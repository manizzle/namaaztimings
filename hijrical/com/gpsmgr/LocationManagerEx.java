package com.gpsmgr;

import android.app.Application;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;

@BA.Author("IceFairy333")
@BA.ShortName("LocationManagerEx")
@BA.Version(1.1F)
public class LocationManagerEx
{
  protected static final String LOG_TAG = "B4A";
  private LocationListener GPSLocationListener;
  private LocationListener MobileLocationListener;
  private BA ba;
  private String eventName;
  private LocationManager locationManager;

  public void GeoSet(final double paramDouble1, double paramDouble2, final double paramDouble3)
  {
    this.locationManager.addTestProvider("gps", false, false, false, false, true, true, true, 0, 5);
    this.locationManager.setTestProviderEnabled("gps", true);
    this.locationManager.requestLocationUpdates("gps", 0L, 0.0F, new MyLocationListener(null));
    new Thread(new Runnable()
    {
      public void run()
      {
        Location localLocation = new Location("gps");
        localLocation.setLatitude(paramDouble1);
        localLocation.setLongitude(paramDouble3);
        localLocation.setAltitude(this.val$altitude);
        Log.e("B4A", "GeoSet:gps" + localLocation.toString());
        localLocation.setTime(System.currentTimeMillis());
        LocationManagerEx.this.locationManager.setTestProviderLocation("gps", localLocation);
      }
    }).start();
  }

  public void Initialize(BA paramBA, String paramString)
  {
    this.ba = paramBA;
    this.eventName = paramString.toLowerCase(BA.cul);
    Log.i("B4A", "LocationManager has been initialized.");
    this.locationManager = ((LocationManager)BA.applicationContext.getSystemService("location"));
  }

  public void requestGPSLocation()
  {
    this.GPSLocationListener = new MyLocationListener(null);
    this.locationManager.requestLocationUpdates("gps", 0L, 0.0F, this.GPSLocationListener);
  }

  public void requestMobileLocation()
  {
    this.MobileLocationListener = new MyLocationListener(null);
    this.locationManager.requestLocationUpdates("network", 0L, 0.0F, this.MobileLocationListener);
  }

  public void stopGPSListening()
  {
    this.locationManager.removeUpdates(this.GPSLocationListener);
  }

  public void stopMobileListening()
  {
    this.locationManager.removeUpdates(this.MobileLocationListener);
  }

  private class MyLocationListener
    implements LocationListener
  {
    private MyLocationListener()
    {
    }

    public void onLocationChanged(Location paramLocation)
    {
      LocationWrapper localLocationWrapper = new LocationWrapper();
      localLocationWrapper.setObject(paramLocation);
      LocationManagerEx.this.ba.raiseEvent(this, LocationManagerEx.this.eventName + "_locationchanged", new Object[] { localLocationWrapper });
    }

    public void onProviderDisabled(String paramString)
    {
      BA localBA = LocationManagerEx.this.ba;
      String str = LocationManagerEx.this.eventName + "_providerdisabled";
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramString.toString();
      localBA.raiseEvent(this, str, arrayOfObject);
    }

    public void onProviderEnabled(String paramString)
    {
      BA localBA = LocationManagerEx.this.ba;
      String str = LocationManagerEx.this.eventName + "_providerenabled";
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramString.toString();
      localBA.raiseEvent(this, str, arrayOfObject);
    }

    public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
    {
      BA localBA = LocationManagerEx.this.ba;
      String str = LocationManagerEx.this.eventName + "_statuschanged";
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramString.toString();
      arrayOfObject[1] = Integer.valueOf(paramInt);
      localBA.raiseEvent(this, str, arrayOfObject);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.gpsmgr.LocationManagerEx
 * JD-Core Version:    0.6.2
 */