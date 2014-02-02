package smith.ed.location2;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@BA.Author("Edward Smith")
@BA.ShortName("ESLocation2")
@BA.Version(1.2F)
public class FindLocation
{
  private static final String DEBUG_TAG = "LocationActivity2";

  @BA.Hide
  public static final String PROXIMITY_ALERT_INTENT = "smith.ed.location2.PROXIMITY_ALERT";
  private LocationListener GPSLocationListener;
  private LocationListener NetworkLocationListener;
  private BroadcastReceiver broadcastReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      Log.i("LocationActivity2", "Received intent " + paramAnonymousIntent.toString());
      if (("smith.ed.location2.PROXIMITY_ALERT".equals(paramAnonymousIntent.getAction())) && (paramAnonymousIntent.hasExtra("entering")))
      {
        if (paramAnonymousIntent.getBooleanExtra("entering", true))
          FindLocation.this.es_ba.raiseEvent(this, FindLocation.this.eventName + "_proximityenter", new Object[0]);
      }
      else
        return;
      FindLocation.this.es_ba.raiseEvent(this, FindLocation.this.eventName + "_proximityexit", new Object[0]);
    }
  };
  private BA es_ba;
  private String eventName;
  private LocationManager locationManager;

  public void EndProximityAlert()
  {
    Log.i("LocationActivity2", "Remove ProximityAlert");
    Intent localIntent = new Intent("smith.ed.location2.PROXIMITY_ALERT");
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(this.es_ba.context.getApplicationContext(), 0, localIntent, 0);
    this.locationManager.removeProximityAlert(localPendingIntent);
  }

  public void Initialize(BA paramBA, String paramString)
  {
    this.es_ba = paramBA;
    this.eventName = paramString.toLowerCase(BA.cul);
    this.locationManager = ((LocationManager)this.es_ba.context.getSystemService("location"));
  }

  public void addProximityAlert(int paramInt, double paramDouble1, double paramDouble2, long paramLong)
  {
    Log.i("LocationActivity2", "addProximityAlert()");
    Intent localIntent = new Intent("smith.ed.location2.PROXIMITY_ALERT");
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(this.es_ba.context.getApplicationContext(), 0, localIntent, 0);
    Log.i("LocationActivity2", "Added Proximity alert intent = " + localPendingIntent.toString());
    this.locationManager.addProximityAlert(paramDouble1, paramDouble2, paramInt, paramLong, localPendingIntent);
    IntentFilter localIntentFilter = new IntentFilter("smith.ed.location2.PROXIMITY_ALERT");
    this.es_ba.context.registerReceiver(this.broadcastReceiver, localIntentFilter);
  }

  public List<String> findLastLocation(String paramString)
  {
    Log.i("LocationActivity2", "Entered provider type  " + paramString);
    ArrayList localArrayList = new ArrayList();
    LocationManager localLocationManager = (LocationManager)this.es_ba.context.getSystemService("location");
    if (paramString.equals("network"))
    {
      Location localLocation4 = localLocationManager.getLastKnownLocation(paramString);
      if (localLocation4 != null)
      {
        Log.i("LocationActivity2", paramString);
        Log.i("LocationActivity2", "Lat = " + Double.toString(localLocation4.getLatitude()) + " Long = " + Double.toString(localLocation4.getLongitude()) + " Time = " + Double.toString(localLocation4.getTime()) + " Accuracy = " + Float.valueOf(localLocation4.getAccuracy()));
        localArrayList.add(paramString);
        localArrayList.add(Long.toString(localLocation4.getTime()));
        localArrayList.add(Double.toString(localLocation4.getLatitude()));
        localArrayList.add(Double.toString(localLocation4.getLongitude()));
        localArrayList.add(Double.toString(localLocation4.getAccuracy()));
      }
    }
    while (true)
    {
      return localArrayList;
      if (paramString.equals("passive"))
      {
        Location localLocation3 = localLocationManager.getLastKnownLocation(paramString);
        if (localLocation3 != null)
        {
          Log.i("LocationActivity2", paramString);
          Log.i("LocationActivity2", "Lat = " + Double.toString(localLocation3.getLatitude()) + " Long = " + Double.toString(localLocation3.getLongitude()) + " Time = " + Double.toString(localLocation3.getTime()) + " Accuracy = " + Float.valueOf(localLocation3.getAccuracy()));
          localArrayList.add(paramString);
          localArrayList.add(Long.toString(localLocation3.getTime()));
          localArrayList.add(Double.toString(localLocation3.getLatitude()));
          localArrayList.add(Double.toString(localLocation3.getLongitude()));
          localArrayList.add(Double.toString(localLocation3.getAccuracy()));
          return localArrayList;
        }
      }
      else if (paramString.equals("gps"))
      {
        Location localLocation2 = localLocationManager.getLastKnownLocation(paramString);
        if (localLocation2 != null)
        {
          Log.i("LocationActivity2", paramString);
          Log.i("LocationActivity2", "Lat = " + Double.toString(localLocation2.getLatitude()) + " Long = " + Double.toString(localLocation2.getLongitude()) + " Time = " + Double.toString(localLocation2.getTime()) + " Accuracy = " + Float.valueOf(localLocation2.getAccuracy()));
          localArrayList.add(paramString);
          localArrayList.add(Long.toString(localLocation2.getTime()));
          localArrayList.add(Double.toString(localLocation2.getLatitude()));
          localArrayList.add(Double.toString(localLocation2.getLongitude()));
          localArrayList.add(Double.toString(localLocation2.getAccuracy()));
          return localArrayList;
        }
      }
      else
      {
        Iterator localIterator = localLocationManager.getAllProviders().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Location localLocation1 = localLocationManager.getLastKnownLocation(str);
          Log.i("LocationActivity2", "Going with a null provider");
          if (localLocation1 != null)
          {
            Log.i("LocationActivity2", str);
            Log.i("LocationActivity2", "Lat = " + Double.toString(localLocation1.getLatitude()) + " Long = " + Double.toString(localLocation1.getLongitude()) + " Time = " + Double.toString(localLocation1.getTime()) + " Accuracy = " + Float.valueOf(localLocation1.getAccuracy()));
            localArrayList.add(str);
            localArrayList.add(Long.toString(localLocation1.getTime()));
            localArrayList.add(Double.toString(localLocation1.getLatitude()));
            localArrayList.add(Double.toString(localLocation1.getLongitude()));
            localArrayList.add(Double.toString(localLocation1.getAccuracy()));
          }
        }
      }
    }
  }

  public void requestGPSLocation(long paramLong, float paramFloat)
  {
    this.GPSLocationListener = new LocationListener()
    {
      public void onLocationChanged(Location paramAnonymousLocation)
      {
        BA localBA = FindLocation.this.es_ba;
        String str = FindLocation.this.eventName + "_locationchanged";
        Object[] arrayOfObject = new Object[8];
        arrayOfObject[0] = Double.valueOf(paramAnonymousLocation.getLongitude());
        arrayOfObject[1] = Double.valueOf(paramAnonymousLocation.getLatitude());
        arrayOfObject[2] = Double.valueOf(paramAnonymousLocation.getAltitude());
        arrayOfObject[3] = Float.valueOf(paramAnonymousLocation.getAccuracy());
        arrayOfObject[4] = Float.valueOf(paramAnonymousLocation.getBearing());
        arrayOfObject[5] = paramAnonymousLocation.getProvider();
        arrayOfObject[6] = Float.valueOf(paramAnonymousLocation.getSpeed());
        arrayOfObject[7] = Long.valueOf(paramAnonymousLocation.getTime());
        localBA.raiseEvent(this, str, arrayOfObject);
      }

      public void onProviderDisabled(String paramAnonymousString)
      {
        BA localBA = FindLocation.this.es_ba;
        String str = FindLocation.this.eventName + "_providerdisabled";
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = paramAnonymousString.toString();
        localBA.raiseEvent(this, str, arrayOfObject);
      }

      public void onProviderEnabled(String paramAnonymousString)
      {
        BA localBA = FindLocation.this.es_ba;
        String str = FindLocation.this.eventName + "_providerenabled";
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = paramAnonymousString.toString();
        localBA.raiseEvent(this, str, arrayOfObject);
      }

      public void onStatusChanged(String paramAnonymousString, int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        BA localBA = FindLocation.this.es_ba;
        String str = FindLocation.this.eventName + "_statuschanged";
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = paramAnonymousString.toString();
        arrayOfObject[1] = Integer.valueOf(paramAnonymousInt);
        localBA.raiseEvent(this, str, arrayOfObject);
      }
    };
    this.locationManager.requestLocationUpdates("gps", paramLong, paramFloat, this.GPSLocationListener);
  }

  public void requestNetworkLocation(long paramLong, float paramFloat)
  {
    this.NetworkLocationListener = new LocationListener()
    {
      public void onLocationChanged(Location paramAnonymousLocation)
      {
        BA localBA = FindLocation.this.es_ba;
        String str = FindLocation.this.eventName + "_locationchanged";
        Object[] arrayOfObject = new Object[8];
        arrayOfObject[0] = Double.valueOf(paramAnonymousLocation.getLongitude());
        arrayOfObject[1] = Double.valueOf(paramAnonymousLocation.getLatitude());
        arrayOfObject[2] = Double.valueOf(paramAnonymousLocation.getAltitude());
        arrayOfObject[3] = Float.valueOf(paramAnonymousLocation.getAccuracy());
        arrayOfObject[4] = Float.valueOf(paramAnonymousLocation.getBearing());
        arrayOfObject[5] = paramAnonymousLocation.getProvider();
        arrayOfObject[6] = Float.valueOf(paramAnonymousLocation.getSpeed());
        arrayOfObject[7] = Long.valueOf(paramAnonymousLocation.getTime());
        localBA.raiseEvent(this, str, arrayOfObject);
      }

      public void onProviderDisabled(String paramAnonymousString)
      {
        BA localBA = FindLocation.this.es_ba;
        String str = FindLocation.this.eventName + "_providerdisabled";
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = paramAnonymousString.toString();
        localBA.raiseEvent(this, str, arrayOfObject);
      }

      public void onProviderEnabled(String paramAnonymousString)
      {
        BA localBA = FindLocation.this.es_ba;
        String str = FindLocation.this.eventName + "_providerenabled";
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = paramAnonymousString.toString();
        localBA.raiseEvent(this, str, arrayOfObject);
      }

      public void onStatusChanged(String paramAnonymousString, int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        BA localBA = FindLocation.this.es_ba;
        String str = FindLocation.this.eventName + "_statuschanged";
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = paramAnonymousString.toString();
        arrayOfObject[1] = Integer.valueOf(paramAnonymousInt);
        localBA.raiseEvent(this, str, arrayOfObject);
      }
    };
    this.locationManager.requestLocationUpdates("network", paramLong, paramFloat, this.NetworkLocationListener);
  }

  public void stopGPSListening()
  {
    this.locationManager.removeUpdates(this.GPSLocationListener);
  }

  public void stopNetworkListening()
  {
    this.locationManager.removeUpdates(this.NetworkLocationListener);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     smith.ed.location2.FindLocation
 * JD-Core Version:    0.6.2
 */