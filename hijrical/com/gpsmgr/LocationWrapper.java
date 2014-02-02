package com.gpsmgr;

import android.location.Location;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;

@BA.ShortName("Location")
public class LocationWrapper extends AbsObjectWrapper<Location>
{
  public static String ConvertToMinutes(double paramDouble)
  {
    return Location.convert(paramDouble, 1);
  }

  public static String ConvertToSeconds(double paramDouble)
  {
    return Location.convert(paramDouble, 2);
  }

  public float BearingTo(Location paramLocation)
  {
    return ((Location)getObject()).bearingTo(paramLocation);
  }

  public float DistanceTo(Location paramLocation)
  {
    return ((Location)getObject()).distanceTo(paramLocation);
  }

  public void Initialize()
  {
    setObject(new Location("gps"));
  }

  public void Initialize2(String paramString1, String paramString2)
  {
    Initialize();
    ((Location)getObject()).setLatitude(Location.convert(paramString1));
    ((Location)getObject()).setLongitude(Location.convert(paramString2));
  }

  public float getAccuracy()
  {
    return ((Location)getObject()).getAccuracy();
  }

  public boolean getAccuracyValid()
  {
    return ((Location)getObject()).hasAccuracy();
  }

  public double getAltitude()
  {
    return ((Location)getObject()).getAltitude();
  }

  public boolean getAltitudeValid()
  {
    return ((Location)getObject()).hasAltitude();
  }

  public float getBearing()
  {
    return ((Location)getObject()).getBearing();
  }

  public boolean getBearingValid()
  {
    return ((Location)getObject()).hasAccuracy();
  }

  public double getLatitude()
  {
    return ((Location)getObject()).getLatitude();
  }

  public double getLongitude()
  {
    return ((Location)getObject()).getLongitude();
  }

  public float getSpeed()
  {
    return ((Location)getObject()).getSpeed();
  }

  public boolean getSpeedValid()
  {
    return ((Location)getObject()).hasSpeed();
  }

  public long getTime()
  {
    return ((Location)getObject()).getTime();
  }

  public void setAccuracy(float paramFloat)
  {
    ((Location)getObject()).setAccuracy(paramFloat);
  }

  public void setAltitude(double paramDouble)
  {
    ((Location)getObject()).setAltitude(paramDouble);
  }

  public void setBearing(float paramFloat)
  {
    ((Location)getObject()).setBearing(paramFloat);
  }

  public void setLatitude(double paramDouble)
  {
    ((Location)getObject()).setLatitude(paramDouble);
  }

  public void setLongitude(double paramDouble)
  {
    ((Location)getObject()).setLongitude(paramDouble);
  }

  public void setSpeed(float paramFloat)
  {
    ((Location)getObject()).setSpeed(paramFloat);
  }

  public void setTime(long paramLong)
  {
    ((Location)getObject()).setTime(paramLong);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.gpsmgr.LocationWrapper
 * JD-Core Version:    0.6.2
 */