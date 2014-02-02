package com.dawoodibohra.times;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.GeomagneticField;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.format.Time;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import java.util.Locale;

public class ActivityLocationSettings extends Activity
  implements LocationListener
{
  public static final double LatLngAccuracy = 0.1D;
  public static final String SETTING_AUTOLOC = "SETTING_AUTOLOC";
  public static final String SETTING_AUTOTZ = "SETTING_AUTOTZ";
  public static final String SETTING_CITY = "SETTING_CITY";
  public static final String SETTING_LAT = "SETTING_LAT";
  public static final String SETTING_LNG = "SETTING_LNG";
  public static final String SETTING_LOC_METHOD = "SETTING_LOC_METHOD";
  public static final String SETTING_MAGDEC = "SETTING_MAGDEC";
  public static final String SETTING_QIBLA = "SETTING_QIBLA";
  public static final String SETTING_TZ = "SETTING_TZ";
  public static final String SETTING_TZ_METHOD = "SETTING_TZ_METHOD";
  CheckBox AutoLoc;
  CheckBox AutoTZ;
  TextView GPSNoteTextView;
  private Spinner TZSpinner;
  TextView TZTextView;
  private Spinner TZmethodSpinner;
  private String errorMessage;
  double gpsLat = 0.0D;
  double gpsLng = 0.0D;
  int gpsLock = 1;
  EditText latEditText;
  TextView latTextView;
  EditText lngEditText;
  TextView lngTextView;
  EditText locEditText;
  TextView locNoteTextView;
  TextView locTextView;
  private Spinner locmethodSpinner;
  private LocationManager myManager;
  SharedPreferences prefs;

  public static void LocationUpdater(LocationManager paramLocationManager, SharedPreferences paramSharedPreferences, Context paramContext)
  {
    if (paramSharedPreferences.getBoolean("SETTING_AUTOLOC", true))
    {
      double d1 = paramSharedPreferences.getFloat("SETTING_LAT", 0.0F);
      double d2 = paramSharedPreferences.getFloat("SETTING_LNG", 0.0F);
      double d3 = d1;
      double d4 = d2;
      if ((paramSharedPreferences.getInt("SETTING_LOC_METHOD", 0) == 0) && (paramLocationManager.getLastKnownLocation("network") != null))
      {
        d3 = paramLocationManager.getLastKnownLocation("network").getLatitude();
        d4 = paramLocationManager.getLastKnownLocation("network").getLongitude();
      }
      if (((paramSharedPreferences.getInt("SETTING_LOC_METHOD", 0) == 1) || (paramSharedPreferences.getInt("SETTING_LOC_METHOD", 0) == 2)) && (paramLocationManager.getLastKnownLocation("gps") != null))
      {
        d3 = paramLocationManager.getLastKnownLocation("gps").getLatitude();
        d4 = paramLocationManager.getLastKnownLocation("gps").getLongitude();
      }
      if ((Math.abs(d3 - d1) > 0.1D) || (Math.abs(d4 - d2) > 0.1D))
      {
        double d5 = d3;
        double d6 = d4;
        String str = determineCity(new Geocoder(paramContext, Locale.getDefault()), d5, d6);
        Toast.makeText(paramContext, "Namaaz Times\nLocation updated: " + str + "\nLatitude: " + ActivityNamaaz.truncateTo2(d5) + "°, Longitude: " + ActivityNamaaz.truncateTo2(d6) + "\nQibla: " + determineQibla(d5, d6) + "° CW from North", 1).show();
        SharedPreferences.Editor localEditor = paramSharedPreferences.edit();
        localEditor.putString("SETTING_CITY", str);
        localEditor.putFloat("SETTING_LAT", (float)d5);
        localEditor.putFloat("SETTING_LNG", (float)d6);
        localEditor.putInt("SETTING_QIBLA", determineQibla(d5, d6));
        localEditor.putInt("SETTING_MAGDEC", determineMagDec(d5, d6));
        localEditor.commit();
      }
    }
  }

  public static void TimeZoneUpdater(SharedPreferences paramSharedPreferences, Context paramContext)
  {
    if ((paramSharedPreferences.getInt("SETTING_TZ_METHOD", 0) == 0) && (paramSharedPreferences.getBoolean("SETTING_AUTOTZ", true)))
    {
      double d1 = paramSharedPreferences.getFloat("SETTING_TZ", 0.0F);
      Time localTime = new Time();
      localTime.setToNow();
      double d2 = localTime.gmtoff / 3600.0D;
      if (d2 != d1)
      {
        SharedPreferences.Editor localEditor = paramSharedPreferences.edit();
        localEditor.putFloat("SETTING_TZ", (float)d2);
        localEditor.commit();
        Toast.makeText(paramContext, "Namaaz Times\nTime zone updated", 1).show();
      }
    }
  }

  public static String determineCity(Geocoder paramGeocoder, double paramDouble1, double paramDouble2)
  {
    while (true)
    {
      Address localAddress;
      String str;
      try
      {
        List localList = paramGeocoder.getFromLocation(paramDouble1, paramDouble2, 1);
        if ((localList.isEmpty()) || (localList == null))
          break label159;
        localAddress = (Address)localList.get(0);
        if (localAddress.getAddressLine(2) != null)
        {
          str = localAddress.getAddressLine(1) + ", " + localAddress.getAddressLine(2);
          return str;
        }
      }
      catch (Exception localException)
      {
        return "Unknown";
      }
      if (localAddress.getAddressLine(1) != null)
        str = localAddress.getAddressLine(0) + ", " + localAddress.getAddressLine(1);
      else if (localAddress.getAddressLine(0) != null)
        str = localAddress.getAddressLine(0);
      else
        label159: str = "Unknown";
    }
  }

  public static int determineMagDec(double paramDouble1, double paramDouble2)
  {
    Time localTime = new Time();
    localTime.setToNow();
    return (int)new GeomagneticField((float)paramDouble1, (float)paramDouble2, 0.0F, localTime.toMillis(false)).getDeclination();
  }

  public static int determineQibla(double paramDouble1, double paramDouble2)
  {
    double d = 180.0D * Math.atan2(Math.sin(3.1415D * (39.826210000000003D - paramDouble2) / 180.0D), Math.cos(paramDouble1 * 3.1415D / 180.0D) * Math.tan(21.422519999999999D * 3.1415D / 180.0D) - Math.sin(paramDouble1 * 3.1415D / 180.0D) * Math.cos(3.1415D * (39.826210000000003D - paramDouble2) / 180.0D)) / 3.1415D;
    if (d < 0.0D)
      d += 360.0D;
    return (int)Math.round(d);
  }

  public static boolean getDefaultSettings(LocationManager paramLocationManager, SharedPreferences paramSharedPreferences, Context paramContext)
  {
    if (paramLocationManager.getLastKnownLocation("network") != null)
    {
      double d1 = paramLocationManager.getLastKnownLocation("network").getLatitude();
      double d2 = paramLocationManager.getLastKnownLocation("network").getLongitude();
      Time localTime = new Time();
      localTime.setToNow();
      double d3 = localTime.gmtoff / 3600.0D;
      String str = determineCity(new Geocoder(paramContext, Locale.getDefault()), d1, d2);
      Toast.makeText(paramContext, "Location: " + str + "\nLatitude: " + ActivityNamaaz.truncateTo2(d1) + "°, Longitude: " + ActivityNamaaz.truncateTo2(d2) + "°\nTimezone (UTC): " + d3 + "\nQibla: " + determineQibla(d1, d2) + "° CW from North", 1).show();
      SharedPreferences.Editor localEditor = paramSharedPreferences.edit();
      localEditor.putInt("SETTING_LOC_METHOD", 0);
      localEditor.putInt("SETTING_TZ_METHOD", 0);
      localEditor.putString("SETTING_CITY", str);
      localEditor.putFloat("SETTING_LAT", (float)d1);
      localEditor.putFloat("SETTING_LNG", (float)d2);
      localEditor.putFloat("SETTING_TZ", (float)d3);
      localEditor.putInt("SETTING_QIBLA", determineQibla(d1, d2));
      localEditor.putInt("SETTING_MAGDEC", determineMagDec(d1, d2));
      localEditor.commit();
      return true;
    }
    return false;
  }

  private double getTZ(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return 0.0D;
    case 0:
      return -12.0D;
    case 1:
      return -11.0D;
    case 2:
      return -10.5D;
    case 3:
      return -10.0D;
    case 4:
      return -9.5D;
    case 5:
      return -9.0D;
    case 6:
      return -8.5D;
    case 7:
      return -8.0D;
    case 8:
      return -7.0D;
    case 9:
      return -6.0D;
    case 10:
      return -5.0D;
    case 11:
      return -4.5D;
    case 12:
      return -4.0D;
    case 13:
      return -3.5D;
    case 14:
      return -3.0D;
    case 15:
      return -2.5D;
    case 16:
      return -2.0D;
    case 17:
      return -1.0D;
    case 18:
      return 0.0D;
    case 19:
      return 1.0D;
    case 20:
      return 2.0D;
    case 21:
      return 3.0D;
    case 22:
      return 3.5D;
    case 23:
      return 4.0D;
    case 24:
      return 4.5D;
    case 25:
      return 5.0D;
    case 26:
      return 5.5D;
    case 27:
      return 5.75D;
    case 28:
      return 6.0D;
    case 29:
      return 6.5D;
    case 30:
      return 7.0D;
    case 31:
      return 8.0D;
    case 32:
      return 8.75D;
    case 33:
      return 9.0D;
    case 34:
      return 9.5D;
    case 35:
      return 9.75D;
    case 36:
      return 10.0D;
    case 37:
      return 10.5D;
    case 38:
      return 11.0D;
    case 39:
      return 11.5D;
    case 40:
      return 12.0D;
    case 41:
      return 12.75D;
    case 42:
      return 13.0D;
    case 43:
      return 13.75D;
    case 44:
    }
    return 14.0D;
  }

  private static int getTZIndex(double paramDouble)
  {
    if (paramDouble == -12.0D);
    do
    {
      return 0;
      if (paramDouble == -11.0D)
        return 1;
      if (paramDouble == -10.5D)
        return 2;
      if (paramDouble == -10.0D)
        return 3;
      if (paramDouble == -9.5D)
        return 4;
      if (paramDouble == -9.0D)
        return 5;
      if (paramDouble == -8.5D)
        return 6;
      if (paramDouble == -8.0D)
        return 7;
      if (paramDouble == -7.0D)
        return 8;
      if (paramDouble == -6.0D)
        return 9;
      if (paramDouble == -5.0D)
        return 10;
      if (paramDouble == -4.5D)
        return 11;
      if (paramDouble == -4.0D)
        return 12;
      if (paramDouble == -3.5D)
        return 13;
      if (paramDouble == -3.0D)
        return 14;
      if (paramDouble == -2.5D)
        return 15;
      if (paramDouble == -2.0D)
        return 16;
      if (paramDouble == -1.0D)
        return 17;
      if (paramDouble == 0.0D)
        return 18;
      if (paramDouble == 1.0D)
        return 19;
      if (paramDouble == 2.0D)
        return 20;
      if (paramDouble == 3.0D)
        return 21;
      if (paramDouble == 3.5D)
        return 22;
      if (paramDouble == 4.0D)
        return 23;
      if (paramDouble == 4.5D)
        return 24;
      if (paramDouble == 5.0D)
        return 25;
      if (paramDouble == 5.5D)
        return 26;
      if (paramDouble == 5.75D)
        return 27;
      if (paramDouble == 6.0D)
        return 28;
      if (paramDouble == 6.5D)
        return 29;
      if (paramDouble == 7.0D)
        return 30;
      if (paramDouble == 8.0D)
        return 31;
      if (paramDouble == 8.75D)
        return 32;
      if (paramDouble == 9.0D)
        return 33;
      if (paramDouble == 9.5D)
        return 34;
      if (paramDouble == 9.75D)
        return 35;
      if (paramDouble == 10.0D)
        return 36;
      if (paramDouble == 10.5D)
        return 37;
      if (paramDouble == 11.0D)
        return 38;
      if (paramDouble == 11.5D)
        return 39;
      if (paramDouble == 12.0D)
        return 40;
      if (paramDouble == 12.75D)
        return 41;
      if (paramDouble == 13.0D)
        return 42;
      if (paramDouble == 13.75D)
        return 43;
    }
    while (paramDouble != 14.0D);
    return 44;
  }

  private void startListening()
  {
    this.myManager.requestLocationUpdates("gps", 0L, 0.0F, this);
  }

  private void stopListening()
  {
    if (this.myManager != null)
      this.myManager.removeUpdates(this);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903042);
    getWindow().setSoftInputMode(3);
    Context localContext = getApplicationContext();
    this.prefs = PreferenceManager.getDefaultSharedPreferences(localContext);
    double d1 = this.prefs.getFloat("SETTING_LAT", 0.0F);
    double d2 = this.prefs.getFloat("SETTING_LNG", 0.0F);
    double d3 = this.prefs.getFloat("SETTING_TZ", 0.0F);
    int i = this.prefs.getInt("SETTING_MAGDEC", 0);
    ((TextView)findViewById(2131361811));
    String str1 = "Location: " + this.prefs.getString("SETTING_CITY", "");
    ((TextView)findViewById(2131361812)).setText(str1);
    String str2 = "Latitude: " + ActivityNamaaz.truncateTo2(d1) + "°, Longitude: " + ActivityNamaaz.truncateTo2(d2) + "°";
    ((TextView)findViewById(2131361813)).setText(str2);
    String str3 = "Timezone (UTC): " + d3;
    ((TextView)findViewById(2131361814)).setText(str3);
    String str4 = "Magnetic Declination: " + i + "°";
    ((TextView)findViewById(2131361815)).setText(str4);
    this.myManager = ((LocationManager)getSystemService("location"));
    this.locmethodSpinner = ((Spinner)findViewById(2131361817));
    this.TZmethodSpinner = ((Spinner)findViewById(2131361829));
    this.TZSpinner = ((Spinner)findViewById(2131361832));
    this.latEditText = ((EditText)findViewById(2131361821));
    this.lngEditText = ((EditText)findViewById(2131361824));
    this.locEditText = ((EditText)findViewById(2131361826));
    this.latTextView = ((TextView)findViewById(2131361820));
    this.lngTextView = ((TextView)findViewById(2131361823));
    this.locTextView = ((TextView)findViewById(2131361825));
    this.locNoteTextView = ((TextView)findViewById(2131361827));
    this.TZTextView = ((TextView)findViewById(2131361831));
    this.GPSNoteTextView = ((TextView)findViewById(2131361819));
    this.AutoLoc = ((CheckBox)findViewById(2131361818));
    this.AutoTZ = ((CheckBox)findViewById(2131361830));
    populateSpinners();
    this.prefs = PreferenceManager.getDefaultSharedPreferences(localContext);
    updateUIFromPreferences();
    Spinner localSpinner1 = this.locmethodSpinner;
    AdapterView.OnItemSelectedListener local1 = new AdapterView.OnItemSelectedListener()
    {
      public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if ((paramAnonymousInt == 0) || (paramAnonymousInt == 1) || (paramAnonymousInt == 2))
        {
          ActivityLocationSettings.this.AutoLoc.setVisibility(0);
          if (paramAnonymousInt != 2)
            break label171;
          ActivityLocationSettings.this.gpsLock = 0;
          ActivityLocationSettings.this.startListening();
          ActivityLocationSettings.this.GPSNoteTextView.setText("Now obtaining GPS fix... Please wait until GPS status icon becomes stable (i.e. stops blinking) before pressing 'Update'.");
          ActivityLocationSettings.this.GPSNoteTextView.setVisibility(0);
          label68: if (paramAnonymousInt != 3)
            break label193;
          ActivityLocationSettings.this.latEditText.setVisibility(0);
          ActivityLocationSettings.this.latTextView.setVisibility(0);
          ActivityLocationSettings.this.lngEditText.setVisibility(0);
          ActivityLocationSettings.this.lngTextView.setVisibility(0);
        }
        while (true)
        {
          if (paramAnonymousInt != 4)
            break label244;
          ActivityLocationSettings.this.locEditText.setVisibility(0);
          ActivityLocationSettings.this.locTextView.setVisibility(0);
          ActivityLocationSettings.this.locNoteTextView.setVisibility(0);
          return;
          ActivityLocationSettings.this.AutoLoc.setVisibility(8);
          break;
          label171: ActivityLocationSettings.this.stopListening();
          ActivityLocationSettings.this.GPSNoteTextView.setVisibility(8);
          break label68;
          label193: ActivityLocationSettings.this.latEditText.setVisibility(8);
          ActivityLocationSettings.this.latTextView.setVisibility(8);
          ActivityLocationSettings.this.lngEditText.setVisibility(8);
          ActivityLocationSettings.this.lngTextView.setVisibility(8);
        }
        label244: ActivityLocationSettings.this.locEditText.setVisibility(8);
        ActivityLocationSettings.this.locTextView.setVisibility(8);
        ActivityLocationSettings.this.locNoteTextView.setVisibility(8);
      }

      public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView)
      {
        ActivityLocationSettings.this.latEditText.setVisibility(8);
        ActivityLocationSettings.this.latTextView.setVisibility(8);
        ActivityLocationSettings.this.lngEditText.setVisibility(8);
        ActivityLocationSettings.this.lngTextView.setVisibility(8);
        ActivityLocationSettings.this.locEditText.setVisibility(8);
        ActivityLocationSettings.this.locTextView.setVisibility(8);
        ActivityLocationSettings.this.AutoLoc.setVisibility(8);
      }
    };
    localSpinner1.setOnItemSelectedListener(local1);
    Spinner localSpinner2 = this.TZmethodSpinner;
    AdapterView.OnItemSelectedListener local2 = new AdapterView.OnItemSelectedListener()
    {
      public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (paramAnonymousInt == 1)
        {
          ActivityLocationSettings.this.TZSpinner.setVisibility(0);
          ActivityLocationSettings.this.TZTextView.setVisibility(0);
          ActivityLocationSettings.this.AutoTZ.setVisibility(8);
          return;
        }
        ActivityLocationSettings.this.TZSpinner.setVisibility(8);
        ActivityLocationSettings.this.TZTextView.setVisibility(8);
        ActivityLocationSettings.this.AutoTZ.setVisibility(0);
      }

      public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView)
      {
        ActivityLocationSettings.this.TZSpinner.setVisibility(8);
        ActivityLocationSettings.this.TZTextView.setVisibility(8);
        ActivityLocationSettings.this.AutoTZ.setVisibility(8);
      }
    };
    localSpinner2.setOnItemSelectedListener(local2);
    Button localButton = (Button)findViewById(2131361833);
    View.OnClickListener local3 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (ActivityLocationSettings.this.savePreferences())
        {
          ActivityLocationSettings.this.finish();
          return;
        }
        Toast.makeText(ActivityLocationSettings.this.getApplicationContext(), ActivityLocationSettings.this.errorMessage, 1).show();
      }
    };
    localButton.setOnClickListener(local3);
    if ((!this.prefs.contains("SETTING_LAT")) || (!this.prefs.contains("SETTING_LNG")) || (!this.prefs.contains("SETTING_TZ")) || (!this.prefs.contains("SETTING_QIBLA")) || (!this.prefs.contains("SETTING_CITY")))
      Toast.makeText(localContext, "If you are unsure on how to configure your location, simply press 'Update' to continue.", 1).show();
  }

  protected void onDestroy()
  {
    stopListening();
    super.onDestroy();
  }

  public void onLocationChanged(Location paramLocation)
  {
    this.gpsLat = paramLocation.getLatitude();
    this.gpsLng = paramLocation.getLongitude();
    this.gpsLock = 1;
    this.GPSNoteTextView.setText("New GPS fix obtained. You can now press 'Update'.");
  }

  protected void onPause()
  {
    stopListening();
    super.onPause();
  }

  public void onProviderDisabled(String paramString)
  {
  }

  public void onProviderEnabled(String paramString)
  {
  }

  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
  {
  }

  protected void onStop()
  {
    stopListening();
    super.onStop();
  }

  public void populateSpinners()
  {
    ArrayAdapter localArrayAdapter1 = ArrayAdapter.createFromResource(this, 2131099656, 17367048);
    localArrayAdapter1.setDropDownViewResource(17367049);
    this.locmethodSpinner.setAdapter(localArrayAdapter1);
    ArrayAdapter localArrayAdapter2 = ArrayAdapter.createFromResource(this, 2131099658, 17367048);
    localArrayAdapter2.setDropDownViewResource(17367049);
    this.TZSpinner.setAdapter(localArrayAdapter2);
    ArrayAdapter localArrayAdapter3 = ArrayAdapter.createFromResource(this, 2131099657, 17367048);
    localArrayAdapter3.setDropDownViewResource(17367049);
    this.TZmethodSpinner.setAdapter(localArrayAdapter3);
  }

  public boolean savePreferences()
  {
    int i = this.locmethodSpinner.getSelectedItemPosition();
    int j = this.TZmethodSpinner.getSelectedItemPosition();
    int k = this.TZSpinner.getSelectedItemPosition();
    boolean bool1 = this.AutoLoc.isChecked();
    boolean bool2 = this.AutoTZ.isChecked();
    double d1 = 0.0D;
    double d2 = 0.0D;
    double d3 = 0.0D;
    Time localTime = new Time();
    localTime.setToNow();
    switch (i)
    {
    default:
      switch (j)
      {
      default:
      case 0:
      case 1:
      }
      break;
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      while (true)
      {
        Geocoder localGeocoder2 = new Geocoder(this, Locale.getDefault());
        String str1 = determineCity(localGeocoder2, d1, d2);
        String str2 = "Location: " + str1 + "\nLatitude: " + ActivityNamaaz.truncateTo2(d1) + "°, Longitude: " + ActivityNamaaz.truncateTo2(d2) + "°\nTimezone (UTC): " + d3 + "\nQibla: " + determineQibla(d1, d2) + "° CW from North";
        Toast.makeText(getApplicationContext(), str2, 1).show();
        SharedPreferences.Editor localEditor = this.prefs.edit();
        localEditor.putInt("SETTING_LOC_METHOD", i);
        localEditor.putInt("SETTING_TZ_METHOD", j);
        localEditor.putString("SETTING_CITY", str1);
        localEditor.putFloat("SETTING_LAT", (float)d1);
        localEditor.putFloat("SETTING_LNG", (float)d2);
        localEditor.putFloat("SETTING_TZ", (float)d3);
        localEditor.putInt("SETTING_QIBLA", determineQibla(d1, d2));
        localEditor.putInt("SETTING_MAGDEC", determineMagDec(d1, d2));
        localEditor.putBoolean("SETTING_AUTOLOC", bool1);
        localEditor.putBoolean("SETTING_AUTOTZ", bool2);
        localEditor.commit();
        return true;
        if (this.myManager.getLastKnownLocation("network") != null)
        {
          d1 = this.myManager.getLastKnownLocation("network").getLatitude();
          d2 = this.myManager.getLastKnownLocation("network").getLongitude();
          break;
        }
        this.errorMessage = "Could not find last Network fix information. Make sure Network connectivity is present and try again.";
        return false;
        if (this.myManager.getLastKnownLocation("gps") != null)
        {
          d1 = this.myManager.getLastKnownLocation("gps").getLatitude();
          d2 = this.myManager.getLastKnownLocation("gps").getLongitude();
          break;
        }
        this.errorMessage = "Could not find last GPS fix information. Try obtaining new GPS lock.";
        return false;
        if ((this.gpsLock == 1) && (this.myManager.getLastKnownLocation("gps") != null))
        {
          d1 = this.gpsLat;
          d2 = this.gpsLng;
          break;
        }
        this.errorMessage = "Could not obtain GPS fix. Please wait further until a GPS fix is obtained. Also, make sure GPS usage is enabled in the device settings.";
        return false;
        d1 = Double.parseDouble(this.latEditText.getText().toString());
        d2 = Double.parseDouble(this.lngEditText.getText().toString());
        if ((d1 > 90.0D) || (d1 < -90.0D) || (d2 > 180.0D) || (d2 < -180.0D))
        {
          this.errorMessage = "Incorrect latitude/longitude settings.";
          return false;
        }
        bool1 = false;
        break;
        Editable localEditable = this.locEditText.getText();
        Geocoder localGeocoder1 = new Geocoder(this, Locale.getDefault());
        try
        {
          List localList = localGeocoder1.getFromLocationName(localEditable.toString(), 1);
          if ((!localList.isEmpty()) && (localList != null))
          {
            Address localAddress = (Address)localList.get(0);
            d1 = localAddress.getLatitude();
            d2 = localAddress.getLongitude();
            bool1 = false;
          }
        }
        catch (Exception localException)
        {
          this.errorMessage = "Could not find location. Check to see if active Internet connection is present.";
          return false;
        }
      }
      this.errorMessage = "Could not find location";
      return false;
      d3 = localTime.gmtoff / 3600.0D;
      continue;
      d3 = getTZ(k);
      bool2 = false;
    }
  }

  public void updateUIFromPreferences()
  {
    int i = this.prefs.getInt("SETTING_LOC_METHOD", 0);
    this.locmethodSpinner.setSelection(i);
    int j = this.prefs.getInt("SETTING_TZ_METHOD", 0);
    this.TZmethodSpinner.setSelection(j);
    String str1 = Double.toString(ActivityNamaaz.truncateTo2(this.prefs.getFloat("SETTING_LAT", 0.0F)));
    this.latEditText.setText(str1);
    String str2 = Double.toString(ActivityNamaaz.truncateTo2(this.prefs.getFloat("SETTING_LNG", 0.0F)));
    this.lngEditText.setText(str2);
    String str3 = this.prefs.getString("SETTING_CITY", "");
    this.locEditText.setText(str3);
    int k = getTZIndex(this.prefs.getFloat("SETTING_TZ", 0.0F));
    this.TZSpinner.setSelection(k);
    this.AutoLoc.setChecked(this.prefs.getBoolean("SETTING_AUTOLOC", true));
    this.AutoTZ.setChecked(this.prefs.getBoolean("SETTING_AUTOTZ", true));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     dawoodibohra.salaat.ActivityLocationSettings
 * JD-Core Version:    0.6.2
 */