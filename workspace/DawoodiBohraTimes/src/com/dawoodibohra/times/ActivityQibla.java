package com.dawoodibohra.times;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Geocoder;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.format.Time;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class ActivityQibla extends MapActivity
{
  public static final String SETTING_COMPASS_SENSOR = "SETTING_COMPASS_SENSOR";
  public static final String SETTING_MAP_MODE = "SETTING_MAP_MODE";
  public static final String SETTING_VIEW_MODE = "SETTING_VIEW_MODE";
  private View.OnClickListener ChangeMode = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (ActivityQibla.this.mode == 0)
      {
        ActivityQibla.this.mapView.setVisibility(0);
        ActivityQibla.this.satButton.setVisibility(0);
        ActivityQibla.this.updateButton.setVisibility(0);
        ActivityQibla.this.setlocButton.setVisibility(0);
        ActivityQibla.this.compassView.setVisibility(4);
        ActivityQibla.this.currentdirtext.setVisibility(4);
        ActivityQibla.this.compStateButton.setVisibility(4);
        ActivityQibla.this.qiblatext.setPadding(0, (int)(ActivityQibla.this.scale * ActivityQibla.this.padding), 0, 0);
        ActivityQibla.this.editor.putInt("SETTING_VIEW_MODE", 1);
        ActivityQibla.this.editor.commit();
        ActivityQibla.this.mode = 1;
        return;
      }
      ActivityQibla.this.mapView.setVisibility(4);
      ActivityQibla.this.satButton.setVisibility(4);
      ActivityQibla.this.updateButton.setVisibility(4);
      ActivityQibla.this.setlocButton.setVisibility(4);
      ActivityQibla.this.compassView.setVisibility(0);
      ActivityQibla.this.currentdirtext.setVisibility(0);
      ActivityQibla.this.compStateButton.setVisibility(0);
      ActivityQibla.this.qiblatext.setPadding(0, 0, 0, 0);
      ActivityQibla.this.editor.putInt("SETTING_VIEW_MODE", 0);
      ActivityQibla.this.editor.commit();
      ActivityQibla.this.mode = 0;
    }
  };
  private View.OnClickListener ChangeSat = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (ActivityQibla.this.mapViewMode == 0)
      {
        ActivityQibla.this.mapView.setSatellite(true);
        ActivityQibla.this.satButton.setText("View: Satellite");
        ActivityQibla.this.editor.putInt("SETTING_MAP_MODE", 1);
        ActivityQibla.this.editor.commit();
        ActivityQibla.this.mapViewMode = 1;
        return;
      }
      ActivityQibla.this.mapView.setSatellite(false);
      ActivityQibla.this.satButton.setText("View: Map");
      ActivityQibla.this.editor.putInt("SETTING_MAP_MODE", 0);
      ActivityQibla.this.editor.commit();
      ActivityQibla.this.mapViewMode = 0;
    }
  };
  private View.OnClickListener CompState = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (ActivityQibla.this.compState == 0)
      {
        ActivityQibla.this.editor.putInt("SETTING_COMPASS_SENSOR", 1);
        ActivityQibla.this.editor.commit();
        ActivityQibla.this.compStateButton.setText("Sensor: ON");
        ActivityQibla.this.compState = 1;
        ActivityQibla.this.sensorManager.registerListener(ActivityQibla.this.sensorEventListener, ActivityQibla.this.accelerometer, 0);
        ActivityQibla.this.sensorManager.registerListener(ActivityQibla.this.sensorEventListener, ActivityQibla.this.magField, 0);
        return;
      }
      ActivityQibla.this.editor.putInt("SETTING_COMPASS_SENSOR", 0);
      ActivityQibla.this.editor.commit();
      ActivityQibla.this.compStateButton.setText("Sensor: OFF");
      ActivityQibla.this.compState = 0;
      ActivityQibla.this.sensorManager.unregisterListener(ActivityQibla.this.sensorEventListener);
      ActivityQibla.this.compassView.setBearing(0.0F);
      ActivityQibla.this.compassView.invalidate();
      ActivityQibla.this.currentdirtext.setText("Align manually");
    }
  };
  private View.OnClickListener SetLoc = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      ActivityQibla.this.updateMap();
      Geocoder localGeocoder = new Geocoder(ActivityQibla.this.context, Locale.getDefault());
      GeoPoint localGeoPoint = ActivityQibla.this.mapView.getMapCenter();
      double d1 = localGeoPoint.getLatitudeE6() / 1000000.0D;
      double d2 = localGeoPoint.getLongitudeE6() / 1000000.0D;
      String str1 = ActivityLocationSettings.determineCity(localGeocoder, d1, d2);
      String str2 = "Location updated: " + str1 + "\nLatitude: " + ActivityNamaaz.truncateTo2(d1) + "°, Longitude: " + ActivityNamaaz.truncateTo2(d2) + "\nQibla: " + ActivityLocationSettings.determineQibla(d1, d2) + "° CW from North\nAuto Location Tracking Disabled";
      Toast.makeText(ActivityQibla.this.context, str2, 1).show();
      SharedPreferences.Editor localEditor = ActivityQibla.this.prefs.edit();
      localEditor.putInt("SETTING_LOC_METHOD", 3);
      localEditor.putBoolean("SETTING_AUTOLOC", false);
      localEditor.putString("SETTING_CITY", str1);
      localEditor.putFloat("SETTING_LAT", (float)d1);
      localEditor.putFloat("SETTING_LNG", (float)d2);
      localEditor.putInt("SETTING_QIBLA", ActivityLocationSettings.determineQibla(d1, d2));
      localEditor.putInt("SETTING_MAGDEC", ActivityLocationSettings.determineMagDec(d1, d2));
      localEditor.commit();
    }
  };
  private View.OnClickListener UpdatePoint = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      ActivityQibla.this.updateMap();
    }
  };
  float[] aValues = new float[3];
  Sensor accelerometer;
  int compState;
  Button compStateButton;
  ViewCompass compassView;
  Context context;
  int currentdir;
  TextView currentdirtext;
  SharedPreferences.Editor editor;
  int fontSize;
  GeoPoint geoPoint;
  int lat;
  private double latitude;
  int lng;
  private double longitude;
  float[] mValues = new float[3];
  Sensor magField;
  int magdec;
  MapController mapController;
  MapView mapView;
  int mapViewMode;
  int mode;
  Button modeButton;
  private double moonAltitude;
  private double moonAzimuth = 360.0D;
  List<Float> myList = new LinkedList();
  int offset;
  private float padding = 7.0F;
  private double pi = 3.141592653589793D;
  SharedPreferences prefs;
  int qibla;
  TextView qiblatext;
  Button satButton;
  private float scale = 1.0F;
  private final SensorEventListener sensorEventListener = new SensorEventListener()
  {
    public void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt)
    {
    }

    public void onSensorChanged(SensorEvent paramAnonymousSensorEvent)
    {
      if (paramAnonymousSensorEvent.sensor.getType() == 1)
        ActivityQibla.this.aValues = paramAnonymousSensorEvent.values;
      if (paramAnonymousSensorEvent.sensor.getType() == 2)
        ActivityQibla.this.mValues = paramAnonymousSensorEvent.values;
      ActivityQibla.this.updateOrientation(ActivityQibla.access$4(ActivityQibla.this));
    }
  };
  SensorManager sensorManager;
  Button setlocButton;
  private double sunAltitude;
  private double sunAzimuth = 360.0D;
  protected Time time = new Time();
  private double tz;
  Button updateButton;

  private void MoonCalculator()
  {
    int i = this.time.monthDay;
    int j = 1 + this.time.month;
    int k = this.time.year;
    double d1 = this.time.hour + this.time.minute / 60.0D + this.time.second / 3600.0D - this.tz;
    double d2 = i + (k * 367 - 7 * (k + (j + 9) / 12) / 4 + j * 275 / 9) - 730530 + d1 / 24.0D;
    double d3 = 125.1228D - 0.0529538083D * d2;
    double d4 = 318.0634D + 0.1643573223D * d2;
    double d5 = 115.36539999999999D + 13.064992950900001D * d2;
    double d6 = 23.439299999999999D - 3.563E-07D * d2;
    double d7 = d5 + 0.0549D * (180.0D / this.pi) * Math.sin(d5 * this.pi / 180.0D) * (1.0D + 0.0549D * Math.cos(d5 * this.pi / 180.0D));
    double d8 = d7 - (d7 - 0.0549D * (180.0D / this.pi) * Math.sin(d7 * this.pi / 180.0D) - d5) / (1.0D - 0.0549D * Math.cos(d7 * this.pi / 180.0D));
    double d9 = Math.cos(d8 * this.pi / 180.0D) - 0.0549D;
    double d10 = 180.0D * Math.atan2(Math.sqrt(1.0D - 0.0549D * 0.0549D) * Math.sin(d8 * this.pi / 180.0D), d9) / this.pi;
    double d11 = Math.cos(d3 * this.pi / 180.0D) * Math.cos((d10 + d4) * this.pi / 180.0D) - Math.sin(d3 * this.pi / 180.0D) * Math.sin((d10 + d4) * this.pi / 180.0D) * Math.cos(5.1454D * this.pi / 180.0D);
    double d12 = Math.sin(d3 * this.pi / 180.0D) * Math.cos((d10 + d4) * this.pi / 180.0D) + Math.cos(d3 * this.pi / 180.0D) * Math.sin((d10 + d4) * this.pi / 180.0D) * Math.cos(5.1454D * this.pi / 180.0D);
    double d13 = Math.sin((d10 + d4) * this.pi / 180.0D) * Math.sin(5.1454D * this.pi / 180.0D);
    double d14 = d12 * Math.cos(d6 * this.pi / 180.0D) - d13 * Math.sin(d6 * this.pi / 180.0D);
    double d15 = d12 * Math.sin(d6 * this.pi / 180.0D) + d13 * Math.cos(d6 * this.pi / 180.0D);
    double d16 = 180.0D * Math.atan2(d14, d11) / this.pi;
    double d17 = 180.0D * Math.atan2(d15, Math.sqrt(d11 * d11 + d14 * d14)) / this.pi;
    double d18 = 100.45999999999999D + 0.9856470000000001D * d2 + this.longitude + 15.0D * d1 - d16;
    this.moonAltitude = (180.0D * Math.asin(Math.sin(d17 * this.pi / 180.0D) * Math.sin(this.latitude * this.pi / 180.0D) + Math.cos(d17 * this.pi / 180.0D) * Math.cos(this.latitude * this.pi / 180.0D) * Math.cos(d18 * this.pi / 180.0D)) / this.pi);
    this.moonAzimuth = (180.0D * Math.acos((Math.sin(d17 * this.pi / 180.0D) - Math.sin(this.moonAltitude * this.pi / 180.0D) * Math.sin(this.latitude * this.pi / 180.0D)) / (Math.cos(this.moonAltitude * this.pi / 180.0D) * Math.cos(this.latitude * this.pi / 180.0D))) / this.pi);
    if (Math.sin(d18 * this.pi / 180.0D) > 0.0D)
      this.moonAzimuth = (360.0D - this.moonAzimuth);
    this.moonAzimuth %= 360.0D;
  }

  private void SunCalculator()
  {
    int i = this.time.monthDay;
    int j = 1 + this.time.month;
    int k = this.time.year;
    double d1 = this.time.hour + this.time.minute / 60.0D + this.time.second / 3600.0D - this.tz;
    double d2 = k - 1900.0D;
    double d3 = 0.0D;
    double d5;
    double d7;
    double d8;
    double d9;
    switch (j)
    {
    default:
      if ((k % 4 == 0) && ((k % 100 != 0) || (k % 400 == 0)) && ((j == 1) || (j == 2)))
        d3 -= 1.0D;
      double d4 = (d3 + (int)(365.25D * d2) + i + d1 / 24.0D) / 36525.0D;
      d5 = (279.697D + 36000.769D * d4) % 360.0D;
      double d6 = (358.476D + 35999.050000000003D * d4) % 360.0D;
      d7 = 23.452000000000002D - 0.013D * d4;
      d8 = d5 + (1.919D - 0.005D * d4) * Math.sin(d6 * this.pi / 180.0D) + 0.02D * Math.sin(2.0D * d6 * this.pi / 180.0D);
      d9 = 180.0D * Math.atan(Math.tan(d8 * this.pi / 180.0D) * Math.cos(d7 * this.pi / 180.0D)) / this.pi;
      if (d9 < 0.0D)
        d9 += 180.0D;
      if (d9 - d8 > 90.0D)
        d9 -= 180.0D;
      break;
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 10:
    case 11:
    case 12:
    }
    while (true)
    {
      double d10 = 180.0D * Math.asin(Math.sin(d8 * this.pi / 180.0D) * Math.sin(d7 * this.pi / 180.0D)) / this.pi;
      double d11 = 180.0D + (d5 - d9) + 15.0D * d1 + this.longitude;
      this.sunAltitude = (180.0D * Math.asin(Math.sin(this.latitude * this.pi / 180.0D) * Math.sin(d10 * this.pi / 180.0D) + Math.cos(this.latitude * this.pi / 180.0D) * Math.cos(d10 * this.pi / 180.0D) * Math.cos(d11 * this.pi / 180.0D)) / this.pi);
      this.sunAzimuth = (180.0D * Math.atan2(Math.sin(d11 * this.pi / 180.0D), Math.cos(d11 * this.pi / 180.0D) * Math.sin(this.latitude * this.pi / 180.0D) - Math.tan(d10 * this.pi / 180.0D) * Math.cos(this.latitude * this.pi / 180.0D)) / this.pi);
      this.sunAzimuth = (180.0D + this.sunAzimuth);
      this.sunAzimuth %= 360.0D;
      return;
      d3 = -0.5D;
      break;
      d3 = 30.5D;
      break;
      d3 = 58.5D;
      break;
      d3 = 89.5D;
      break;
      d3 = 119.5D;
      break;
      d3 = 150.5D;
      break;
      d3 = 180.5D;
      break;
      d3 = 211.5D;
      break;
      d3 = 242.5D;
      break;
      d3 = 272.5D;
      break;
      d3 = 303.5D;
      break;
      d3 = 333.5D;
      break;
      if (d9 - d8 < -90.0D)
        d9 += 180.0D;
    }
  }

  private float average()
  {
    float f1 = 0.0F;
    int i = 0;
    if (i >= this.myList.size())
      return f1 / this.myList.size();
    float f2 = ((Float)this.myList.get(i)).floatValue();
    float f3;
    if (i > 0)
    {
      f3 = f1 / i;
      if (f2 - f3 <= 180.0F)
        break label84;
      f2 -= 360.0F;
    }
    while (true)
    {
      f1 += f2;
      i++;
      break;
      label84: if (f2 - f3 < -180.0F)
        f2 += 360.0F;
    }
  }

  private float[] calculateOrientation()
  {
    float[] arrayOfFloat1 = new float[3];
    float[] arrayOfFloat2 = new float[9];
    SensorManager.getRotationMatrix(arrayOfFloat2, null, this.aValues, this.mValues);
    SensorManager.getOrientation(arrayOfFloat2, arrayOfFloat1);
    arrayOfFloat1[0] = ((float)Math.toDegrees(arrayOfFloat1[0]));
    arrayOfFloat1[1] = ((float)Math.toDegrees(arrayOfFloat1[1]));
    arrayOfFloat1[2] = ((float)Math.toDegrees(arrayOfFloat1[2]));
    return arrayOfFloat1;
  }

  private void updateMap()
  {
    GeoPoint localGeoPoint = this.mapView.getMapCenter();
    this.qibla = ActivityLocationSettings.determineQibla(localGeoPoint.getLatitudeE6() / 1000000.0D, localGeoPoint.getLongitudeE6() / 1000000.0D);
    this.qiblatext.setText("Qibla Bearing: " + this.qibla + "°");
    List localList = this.mapView.getOverlays();
    while (true)
    {
      if (localList.size() <= 0)
      {
        Bitmap localBitmap1 = BitmapFactory.decodeResource(getResources(), 2130837519);
        int i = localBitmap1.getWidth();
        int j = localBitmap1.getHeight();
        Matrix localMatrix = new Matrix();
        localMatrix.postRotate(this.qibla);
        Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1, 0, 0, i, j, localMatrix, true);
        BitmapDrawable localBitmapDrawable = new BitmapDrawable(localBitmap2);
        CustomItemizedOverlay localCustomItemizedOverlay = new CustomItemizedOverlay(localBitmapDrawable, this.context);
        OverlayItem localOverlayItem = new OverlayItem(localGeoPoint, "Qibla", "Qibla");
        localCustomItemizedOverlay.addOverlay(localOverlayItem);
        localList.add(localCustomItemizedOverlay);
        this.mapView.invalidate();
        return;
      }
      localList.remove(0);
    }
  }

  private void updateOrientation(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat[0] != 0.0F)
      this.myList.add(Float.valueOf(paramArrayOfFloat[0]));
    if (this.myList.size() > 25)
      this.myList.remove(0);
    this.currentdir = ((int)average());
    int i = ((WindowManager)getSystemService("window")).getDefaultDisplay().getOrientation();
    if (i == 0)
      this.offset = 0;
    while (true)
    {
      this.currentdir += this.offset;
      this.currentdir += this.magdec;
      this.currentdir %= 360;
      if (this.currentdir < 0)
        this.currentdir = (360 + this.currentdir);
      if (this.compassView != null)
      {
        this.compassView.setBearing(this.currentdir);
        this.compassView.invalidate();
      }
      if (this.currentdirtext != null)
        this.currentdirtext.setText("Current Bearing: " + this.currentdir + "°");
      if (this.compState == 0)
      {
        this.compassView.setBearing(0.0F);
        this.compassView.invalidate();
        this.currentdirtext.setText("Align manually");
      }
      return;
      if (i == 1)
        this.offset = 90;
      else if (i == 3)
        this.offset = 270;
    }
  }

  protected boolean isRouteDisplayed()
  {
    return false;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903045);
    this.context = getApplicationContext();
    this.scale = this.context.getResources().getDisplayMetrics().density;
    this.prefs = PreferenceManager.getDefaultSharedPreferences(this.context);
    this.editor = this.prefs.edit();
    this.qiblatext = ((TextView)findViewById(2131361861));
    this.currentdirtext = ((TextView)findViewById(2131361862));
    this.compassView = ((ViewCompass)findViewById(2131361860));
    this.modeButton = ((Button)findViewById(2131361863));
    this.modeButton.setOnClickListener(this.ChangeMode);
    this.satButton = ((Button)findViewById(2131361866));
    this.satButton.setOnClickListener(this.ChangeSat);
    this.updateButton = ((Button)findViewById(2131361867));
    this.updateButton.setOnClickListener(this.UpdatePoint);
    this.setlocButton = ((Button)findViewById(2131361868));
    this.setlocButton.setOnClickListener(this.SetLoc);
    this.compStateButton = ((Button)findViewById(2131361864));
    this.compStateButton.setOnClickListener(this.CompState);
    this.mode = this.prefs.getInt("SETTING_VIEW_MODE", 0);
    this.mapViewMode = this.prefs.getInt("SETTING_MAP_MODE", 0);
    this.compState = this.prefs.getInt("SETTING_COMPASS_SENSOR", 1);
    this.mapView = ((MapView)findViewById(2131361865));
    this.mapView.setBuiltInZoomControls(true);
    this.mapView.setClickable(true);
    this.mapController = this.mapView.getController();
  }

  protected void onPause()
  {
    this.sensorManager.unregisterListener(this.sensorEventListener);
    super.onPause();
  }

  public void onResume()
  {
    super.onResume();
    this.qibla = this.prefs.getInt("SETTING_QIBLA", 0);
    this.magdec = this.prefs.getInt("SETTING_MAGDEC", 0);
    this.fontSize = this.prefs.getInt("SETTING_ACTUAL_FONT_SIZE", 16);
    this.latitude = this.prefs.getFloat("SETTING_LAT", 0.0F);
    this.longitude = this.prefs.getFloat("SETTING_LNG", 0.0F);
    this.tz = this.prefs.getFloat("SETTING_TZ", 0.0F);
    this.satButton.setTextSize(this.fontSize);
    this.modeButton.setTextSize(this.fontSize);
    this.updateButton.setTextSize(this.fontSize);
    this.compStateButton.setTextSize(this.fontSize);
    this.setlocButton.setTextSize(this.fontSize);
    this.qiblatext.setTextSize(this.fontSize);
    this.currentdirtext.setTextSize(this.fontSize);
    this.time.setToNow();
    this.compassView.qibla = this.qibla;
    SunCalculator();
    if (this.sunAltitude > -5.0D)
    {
      this.compassView.sun = ((int)this.sunAzimuth);
      this.compassView.sunAltitude = ((int)this.sunAltitude);
      MoonCalculator();
      if (this.moonAltitude <= -5.0D)
        break label577;
      this.compassView.moon = ((int)this.moonAzimuth);
      label278: this.compassView.moonAltitude = ((int)this.moonAltitude);
      this.sensorManager = ((SensorManager)getSystemService("sensor"));
      updateOrientation(new float[] { 0.0F, 0.0F, 0.0F });
      this.accelerometer = this.sensorManager.getDefaultSensor(1);
      this.magField = this.sensorManager.getDefaultSensor(2);
      if (this.mapViewMode != 0)
        break label590;
      this.mapView.setSatellite(false);
      this.satButton.setText("View: Map");
      label372: if (this.compState != 0)
        break label611;
      this.compStateButton.setText("Sensor: OFF");
      this.sensorManager.unregisterListener(this.sensorEventListener);
      this.compassView.setBearing(0.0F);
      this.compassView.invalidate();
      this.currentdirtext.setText("Align manually");
      label425: if (this.mode != 0)
        break label658;
      this.mapView.setVisibility(4);
      this.satButton.setVisibility(4);
      this.satButton.setText("View: Map");
      this.updateButton.setVisibility(4);
      this.setlocButton.setVisibility(4);
      this.compassView.setVisibility(0);
      this.currentdirtext.setVisibility(0);
      this.compStateButton.setVisibility(0);
      this.qiblatext.setPadding(0, 0, 0, 0);
    }
    while (true)
    {
      this.geoPoint = new GeoPoint((int)(1000000.0D * this.latitude), (int)(1000000.0D * this.longitude));
      this.mapController.setCenter(this.geoPoint);
      this.mapController.setZoom(18);
      updateMap();
      return;
      this.compassView.sun = 360;
      break;
      label577: this.compassView.moon = 360;
      break label278;
      label590: this.mapView.setSatellite(true);
      this.satButton.setText("View: Satellite");
      break label372;
      label611: this.compStateButton.setText("Sensor: ON");
      this.sensorManager.registerListener(this.sensorEventListener, this.accelerometer, 0);
      this.sensorManager.registerListener(this.sensorEventListener, this.magField, 0);
      break label425;
      label658: if (this.mode == 1)
      {
        this.mapView.setVisibility(0);
        this.satButton.setVisibility(0);
        this.updateButton.setVisibility(0);
        this.setlocButton.setVisibility(0);
        this.compassView.setVisibility(4);
        this.currentdirtext.setVisibility(4);
        this.compStateButton.setVisibility(4);
        this.qiblatext.setPadding(0, (int)(this.scale * this.padding), 0, 0);
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     dawoodibohra.salaat.ActivityQibla
 * JD-Core Version:    0.6.2
 */