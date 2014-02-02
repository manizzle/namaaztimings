package dawoodibohra.salaat;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.format.Time;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Iterator;

public class ActivityNamaaz extends Activity
  implements LocationListener
{
  private View.OnClickListener LiveGPS = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (!ActivityNamaaz.this.livegps)
      {
        ActivityNamaaz.this.livegps = true;
        ActivityNamaaz.this.livegpsButton.setText("Live GPS Tracking: ON");
        ActivityNamaaz.this.startListening();
        return;
      }
      ActivityNamaaz.this.livegps = false;
      ActivityNamaaz.this.livegpsButton.setText("Live GPS Tracking: OFF");
      ActivityNamaaz.this.stopListening();
    }
  };
  TextView LiveGPSLocTV;
  TextView LiveGPSSatTV;
  private View.OnClickListener Next10Day = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      ActivityNamaaz.this.time.set(864000000L + ActivityNamaaz.this.time.toMillis(false));
      ActivityNamaaz.this.processHomeScreen();
    }
  };
  private View.OnClickListener NextDay = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      ActivityNamaaz.this.time.set(86400000L + ActivityNamaaz.this.time.toMillis(false));
      ActivityNamaaz.this.main();
    }
  };
  private View.OnClickListener Prev10Day = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      ActivityNamaaz.this.time.set(ActivityNamaaz.this.time.toMillis(false) - 864000000L);
      ActivityNamaaz.this.processHomeScreen();
    }
  };
  private View.OnClickListener PrevDay = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      ActivityNamaaz.this.time.set(ActivityNamaaz.this.time.toMillis(false) - 86400000L);
      ActivityNamaaz.this.processHomeScreen();
    }
  };
  private View.OnClickListener Today = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      ActivityNamaaz.this.time.setToNow();
      ActivityNamaaz.this.processHomeScreen();
    }
  };
  private boolean ampm;
  ViewCompass compassView;
  Context context;
  private double latitude;
  private GpsStatus.Listener listener = new GpsStatus.Listener()
  {
    public void onGpsStatusChanged(int paramAnonymousInt)
    {
      int i;
      String str;
      Iterator localIterator;
      if (paramAnonymousInt == 4)
      {
        Iterable localIterable = ActivityNamaaz.this.myManager.getGpsStatus(null).getSatellites();
        i = 0;
        str = "";
        localIterator = localIterable.iterator();
      }
      while (true)
      {
        if (!localIterator.hasNext())
        {
          ActivityNamaaz.this.LiveGPSSatTV.setText(str);
          return;
        }
        GpsSatellite localGpsSatellite = (GpsSatellite)localIterator.next();
        i++;
        if (i != 1)
          str = str + "\n";
        str = str + "Satellite " + i + ": PRN = " + localGpsSatellite.getPrn() + ", SNR = " + localGpsSatellite.getSnr();
        if (localGpsSatellite.usedInFix())
          str = str + " - ACTIVE";
      }
    }
  };
  private boolean livegps = false;
  Button livegpsButton;
  private double longitude;
  private LocationManager myManager;
  SharedPreferences prefs;
  private TextView text;
  protected Time time = new Time();
  protected Time timeNow = new Time();
  private double tz;

  public static String convertTimeToString(double paramDouble, boolean paramBoolean1, boolean paramBoolean2)
  {
    double d1 = Math.floor(paramDouble);
    double d2 = Math.floor(60.0D * (paramDouble % 1.0D));
    double d3 = Math.floor(60.0D * (60.0D * (paramDouble % 1.0D) % 1.0D));
    double d4;
    double d5;
    if ((d3 > 30.0D) && (!paramBoolean2))
    {
      d4 = 1.0D + d2;
      if (d4 != 60.0D)
        break label458;
      d5 = 1.0D + d1;
    }
    for (double d6 = 0.0D; ; d6 = d4)
    {
      if (d5 == 24.0D)
        d2 = d6;
      for (d1 = 0.0D; ; d1 = d5)
      {
        String str8;
        String str9;
        if (paramBoolean1)
        {
          str8 = Integer.toString((int)d1 % 12);
          str9 = Integer.toString((int)d2);
          Integer.toString((int)d3);
          if ((d1 != 0.0D) && (d1 != 12.0D))
            break label440;
        }
        label440: for (String str10 = "12"; ; str10 = str8)
        {
          if (d2 < 10.0D)
            str9 = "0" + str9;
          if (d1 < 12.0D)
            return str10 + ":" + str9 + " AM";
          return str10 + ":" + str9 + " PM";
          String str1 = Integer.toString((int)d1);
          String str2 = Integer.toString((int)d2);
          String str3 = Integer.toString((int)d3);
          if (d1 < 10.0D);
          for (String str4 = "0" + str1; ; str4 = str1)
          {
            if (d2 < 10.0D)
              str2 = "0" + str2;
            if (d3 < 10.0D);
            for (String str5 = "0" + str3; ; str5 = str3)
            {
              if (paramBoolean2)
              {
                String str7 = str4 + ":" + str2 + ":" + str5;
                return str7;
              }
              String str6 = str4 + ":" + str2;
              return str6;
            }
          }
        }
        d2 = d6;
      }
      label458: d5 = d1;
    }
  }

  public static String nextNamaazString(double[] paramArrayOfDouble)
  {
    String str = "";
    if (paramArrayOfDouble[0] == 0.0D)
      str = "Fajr starts in: " + convertTimeToString(paramArrayOfDouble[2], false, false);
    do
    {
      return str;
      if (paramArrayOfDouble[0] == 1.0D)
        return "Fajr ends in: " + convertTimeToString(paramArrayOfDouble[2], false, false);
      if (paramArrayOfDouble[0] == 2.0D)
        return "Zohr/Asr starts in: " + convertTimeToString(paramArrayOfDouble[2], false, false);
      if (paramArrayOfDouble[0] == 3.0D)
        return "Zohr ends in: " + convertTimeToString(paramArrayOfDouble[2], false, false);
      if (paramArrayOfDouble[0] == 4.0D)
        return "Asr ends in: " + convertTimeToString(paramArrayOfDouble[2], false, false) + " - Magrib starts in: " + convertTimeToString(paramArrayOfDouble[3], false, false);
      if (paramArrayOfDouble[0] == 5.0D)
        return str + "Magrib/Isha starts in: " + convertTimeToString(paramArrayOfDouble[2], false, false);
      if (paramArrayOfDouble[0] == 6.0D)
        return str + "Magrib ends in: " + convertTimeToString(paramArrayOfDouble[2], false, false);
    }
    while (paramArrayOfDouble[0] != 7.0D);
    return str + "Isha ends in: " + convertTimeToString(paramArrayOfDouble[2], false, false);
  }

  private void startListening()
  {
    this.myManager.requestLocationUpdates("gps", 0L, 0.0F, this);
    this.myManager.addGpsStatusListener(this.listener);
    this.LiveGPSLocTV.setText("Location: Obtaining GPS Fix");
    this.LiveGPSSatTV.setText("Satellites: Obtaining GPS Fix");
    this.compassView.setBearing(0.0F);
    this.compassView.invalidate();
    this.LiveGPSLocTV.setVisibility(0);
    this.LiveGPSSatTV.setVisibility(0);
  }

  private void stopListening()
  {
    if (this.myManager != null)
    {
      this.myManager.removeUpdates(this);
      this.myManager.removeGpsStatusListener(this.listener);
    }
    this.LiveGPSLocTV.setText("Location: Live GPS Tracking Disabled");
    this.LiveGPSSatTV.setText("Satellites: Live GPS Tracking Disabled");
    this.compassView.setBearing(0.0F);
    this.compassView.qibla = 0;
    this.compassView.invalidate();
    this.LiveGPSLocTV.setVisibility(8);
    this.LiveGPSSatTV.setVisibility(8);
    this.compassView.setVisibility(8);
  }

  public static double truncateTo2(double paramDouble)
  {
    if (paramDouble > 0.0D)
      return Math.floor(paramDouble * 100.0D) / 100.0D;
    return Math.ceil(paramDouble * 100.0D) / 100.0D;
  }

  public void main()
  {
    setContentView(2130903044);
    this.context = getApplicationContext();
    this.prefs = PreferenceManager.getDefaultSharedPreferences(this.context);
    this.myManager = ((LocationManager)getSystemService("location"));
    this.livegpsButton = ((Button)findViewById(2131361857));
    this.livegpsButton.setOnClickListener(this.LiveGPS);
    RelativeLayout localRelativeLayout;
    if (this.livegps)
    {
      this.livegpsButton.setText("Live GPS Tracking: ON");
      localRelativeLayout = (RelativeLayout)findViewById(2131361792);
      if (!this.prefs.getBoolean("SETTING_LIVEGPS", false))
        break label193;
      localRelativeLayout.setVisibility(0);
      this.livegpsButton.setVisibility(0);
    }
    while (true)
    {
      this.LiveGPSLocTV = ((TextView)findViewById(2131361858));
      this.LiveGPSSatTV = ((TextView)findViewById(2131361859));
      this.compassView = ((ViewCompass)findViewById(2131361860));
      if (!this.livegps)
        stopListening();
      processHomeScreen();
      return;
      this.livegpsButton.setText("Live GPS Tracking: OFF");
      break;
      label193: localRelativeLayout.setVisibility(8);
      this.livegpsButton.setVisibility(8);
    }
  }

  public void onLocationChanged(Location paramLocation)
  {
    SharedPreferences.Editor localEditor = this.prefs.edit();
    localEditor.putFloat("SETTING_LAT", (float)paramLocation.getLatitude());
    localEditor.putFloat("SETTING_LNG", (float)paramLocation.getLongitude());
    localEditor.putInt("SETTING_QIBLA", ActivityLocationSettings.determineQibla(paramLocation.getLatitude(), paramLocation.getLongitude()));
    localEditor.putInt("SETTING_MAGDEC", ActivityLocationSettings.determineMagDec(paramLocation.getLatitude(), paramLocation.getLongitude()));
    localEditor.putBoolean("SETTING_AUTOLOC", false);
    localEditor.putInt("SETTING_LOC_METHOD", 1);
    localEditor.putString("SETTING_CITY", "Location: Unknown");
    localEditor.commit();
    String str = "Latitude: " + paramLocation.getLatitude() + "\nLongitude: " + paramLocation.getLongitude() + "\nAltitude: " + paramLocation.getAltitude() + "\nSpeed: " + paramLocation.getSpeed() + "\nGPS Bearing: " + paramLocation.getBearing() + "\nQibla Bearing: " + ActivityLocationSettings.determineQibla(paramLocation.getLatitude(), paramLocation.getLongitude());
    this.LiveGPSLocTV.setText(str);
    this.compassView.setVisibility(0);
    this.compassView.setBearing(paramLocation.getBearing());
    this.compassView.qibla = ActivityLocationSettings.determineQibla(paramLocation.getLatitude(), paramLocation.getLongitude());
    this.compassView.invalidate();
    this.timeNow.setToNow();
    this.time.setToNow();
    processHomeScreen();
  }

  public void onProviderDisabled(String paramString)
  {
  }

  public void onProviderEnabled(String paramString)
  {
  }

  public void onResume()
  {
    this.timeNow.setToNow();
    ((NotificationManager)getSystemService("notification")).cancel(1);
    main();
    super.onResume();
  }

  public void onStart()
  {
    this.time.setToNow();
    super.onStart();
  }

  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
  {
  }

  public void processHomeScreen()
  {
    int[] arrayOfInt = UtilCalendar.getMisriDate(this.time);
    this.latitude = this.prefs.getFloat("SETTING_LAT", 0.0F);
    this.longitude = this.prefs.getFloat("SETTING_LNG", 0.0F);
    this.tz = this.prefs.getFloat("SETTING_TZ", 0.0F);
    this.ampm = this.prefs.getBoolean("SETTING_AMPM", true);
    int i = this.prefs.getInt("SETTING_ACTUAL_FONT_SIZE", 16);
    Button localButton1 = (Button)findViewById(2131361796);
    localButton1.setOnClickListener(this.NextDay);
    localButton1.setTextSize(i);
    Button localButton2 = (Button)findViewById(2131361835);
    localButton2.setOnClickListener(this.Next10Day);
    localButton2.setTextSize(i);
    Button localButton3 = (Button)findViewById(2131361795);
    localButton3.setOnClickListener(this.PrevDay);
    localButton3.setTextSize(i);
    Button localButton4 = (Button)findViewById(2131361836);
    localButton4.setOnClickListener(this.Prev10Day);
    localButton4.setTextSize(i);
    Button localButton5 = (Button)findViewById(2131361794);
    localButton5.setOnClickListener(this.Today);
    localButton5.setTextSize(i);
    UtilNamaazTimesCalculator localUtilNamaazTimesCalculator1 = new UtilNamaazTimesCalculator();
    localUtilNamaazTimesCalculator1.setLocation(this.latitude, this.longitude);
    localUtilNamaazTimesCalculator1.setTime(this.timeNow);
    localUtilNamaazTimesCalculator1.setTimezone(this.tz);
    this.text = ((TextView)findViewById(2131361834));
    this.text.setText(nextNamaazString(localUtilNamaazTimesCalculator1.getState()));
    this.text.setTextSize(i);
    UtilNamaazTimesCalculator localUtilNamaazTimesCalculator2 = new UtilNamaazTimesCalculator();
    localUtilNamaazTimesCalculator2.setLocation(this.latitude, this.longitude);
    localUtilNamaazTimesCalculator2.setTime(this.time);
    localUtilNamaazTimesCalculator2.setTimezone(this.tz);
    double[] arrayOfDouble = localUtilNamaazTimesCalculator2.getNamaazTimes();
    this.text = ((TextView)findViewById(2131361839));
    this.text.setTextSize(i);
    this.text = ((TextView)findViewById(2131361841));
    this.text.setTextSize(i);
    this.text = ((TextView)findViewById(2131361843));
    this.text.setTextSize(i);
    this.text = ((TextView)findViewById(2131361845));
    this.text.setTextSize(i);
    this.text = ((TextView)findViewById(2131361847));
    this.text.setTextSize(i);
    this.text = ((TextView)findViewById(2131361849));
    this.text.setTextSize(i);
    this.text = ((TextView)findViewById(2131361851));
    this.text.setTextSize(i);
    this.text = ((TextView)findViewById(2131361853));
    this.text.setTextSize(i);
    this.text = ((TextView)findViewById(2131361855));
    this.text.setTextSize(i);
    String str1 = UtilCalendar.getGregDay(this.time.weekDay) + ", " + Integer.toString(this.time.monthDay) + " " + UtilCalendar.getGregMonth(this.time.month) + " " + Integer.toString(this.time.year);
    this.text = ((TextView)findViewById(2131361838));
    this.text.setText(str1);
    this.text.setTextSize(i);
    String str2 = Integer.toString(arrayOfInt[0]) + " " + UtilCalendar.getMisriMonth(arrayOfInt[1]) + " " + Integer.toString(arrayOfInt[2]) + "H";
    this.text = ((TextView)findViewById(2131361837));
    this.text.setText(str2);
    this.text.setTextSize(i);
    this.text = ((TextView)findViewById(2131361840));
    this.text.setText(convertTimeToString(arrayOfDouble[0], this.ampm, false));
    this.text.setTextSize(i);
    this.text = ((TextView)findViewById(2131361842));
    this.text.setText(convertTimeToString(arrayOfDouble[1], this.ampm, false));
    this.text.setTextSize(i);
    this.text = ((TextView)findViewById(2131361844));
    this.text.setText(convertTimeToString(arrayOfDouble[2], this.ampm, false));
    this.text.setTextSize(i);
    this.text = ((TextView)findViewById(2131361846));
    this.text.setText(convertTimeToString(arrayOfDouble[3], this.ampm, false));
    this.text.setTextSize(i);
    this.text = ((TextView)findViewById(2131361848));
    this.text.setText(convertTimeToString(arrayOfDouble[4], this.ampm, false));
    this.text.setTextSize(i);
    this.text = ((TextView)findViewById(2131361850));
    this.text.setText(convertTimeToString(arrayOfDouble[5], this.ampm, false));
    this.text.setTextSize(i);
    this.text = ((TextView)findViewById(2131361852));
    this.text.setText(convertTimeToString(arrayOfDouble[6], this.ampm, false));
    this.text.setTextSize(i);
    this.text = ((TextView)findViewById(2131361854));
    this.text.setText(convertTimeToString(arrayOfDouble[7], this.ampm, false));
    this.text.setTextSize(i);
    this.text = ((TextView)findViewById(2131361856));
    this.text.setText(convertTimeToString(arrayOfDouble[8], this.ampm, false));
    this.text.setTextSize(i);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     dawoodibohra.salaat.ActivityNamaaz
 * JD-Core Version:    0.6.2
 */