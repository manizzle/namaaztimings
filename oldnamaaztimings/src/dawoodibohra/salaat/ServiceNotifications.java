package dawoodibohra.salaat;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.preference.PreferenceManager;
import android.text.format.Time;

public class ServiceNotifications extends Service
{
  public static final int NOTIFIER_MIQAAT = 2;
  public static final int NOTIFIER_NAMAAZ = 1;
  private PendingIntent alarmIntent;
  private AlarmManager alarms;
  private Context context;
  private final IBinder mBinder = new LocalBinder();
  private NotificationManager mNM;
  private UtilNamaazTimesCalculator namaazTimesCalculator = new UtilNamaazTimesCalculator();
  double[] nextNamaaz;
  private PowerManager pm;
  private SharedPreferences prefs;
  private Time theTime = new Time();

  private void doOnStart()
  {
    this.theTime.setToNow();
    this.namaazTimesCalculator.setTime(this.theTime);
    this.namaazTimesCalculator.setLocation(this.prefs.getFloat("SETTING_LAT", 0.0F), this.prefs.getFloat("SETTING_LNG", 0.0F));
    this.namaazTimesCalculator.setTimezone(this.prefs.getFloat("SETTING_TZ", 0.0F));
    this.nextNamaaz = this.namaazTimesCalculator.getState();
    setAlarm();
    if (this.prefs.getBoolean("SETTING_NAMAAZ_NOTIFY", false))
      processCurrentNamaaz();
    if (this.prefs.getBoolean("SETTING_MIQAAT_NOTIFY", false))
      processTodaysMiqaat();
    stopSelf();
  }

  private void initializeAlarm()
  {
    this.alarms = ((AlarmManager)getSystemService("alarm"));
    this.alarmIntent = PendingIntent.getBroadcast(this, 0, new Intent("dawoodibohra.salaat.ACTION_NAMAAZ_NOTIFY_ALARM"), 0);
  }

  private void processCurrentNamaaz()
  {
    int i = this.prefs.getInt("SETTING_NAMAAZ_NOTIFY_VIBRATE", 0);
    boolean bool = this.prefs.getBoolean("SETTING_NAMAAZ_NOTIFY_SOUND", false);
    this.theTime.setToNow();
    double d = this.nextNamaaz[2] + this.theTime.hour + this.theTime.minute / 60.0D + this.theTime.second / 3600.0D;
    if ((this.nextNamaaz[0] == 1.0D) && (this.nextNamaaz[1] < 0.0028D))
    {
      String str3 = "Ends at " + ActivityNamaaz.convertTimeToString(d, true, false);
      showNamaazNotification(this.mNM, this.pm, this.context, str3, "Fajr Namaaz", i, bool);
    }
    do
    {
      return;
      if ((this.nextNamaaz[0] == 3.0D) && (this.nextNamaaz[1] < 0.0028D))
      {
        String str2 = "Ends at " + ActivityNamaaz.convertTimeToString(d, true, false);
        showNamaazNotification(this.mNM, this.pm, this.context, str2, "Zohr/Asr Namaaz", i, bool);
        return;
      }
    }
    while ((this.nextNamaaz[0] != 6.0D) || (this.nextNamaaz[1] >= 0.0028D));
    String str1 = "Ends at " + ActivityNamaaz.convertTimeToString(d, true, false);
    showNamaazNotification(this.mNM, this.pm, this.context, str1, "Magrib/Isha Namaaz", i, bool);
  }

  private void processTodaysMiqaat()
  {
    Time localTime = new Time();
    localTime.setToNow();
    localTime.set(86400000L + localTime.toMillis(false));
    int[] arrayOfInt = UtilCalendar.getMisriDate(localTime);
    String str1 = UtilCalendar.getMiqaat(arrayOfInt);
    if ((this.nextNamaaz[0] == 6.0D) && (this.nextNamaaz[1] < 0.0028D) && (str1 != ""))
    {
      String str2 = "Miqaats for " + Integer.toString(arrayOfInt[0]) + " " + UtilCalendar.getMisriMonth(arrayOfInt[1]) + " " + Integer.toString(arrayOfInt[2]) + "H";
      showMiqaatNotification(this.mNM, this.context, str1, str2);
    }
  }

  private void setAlarm()
  {
    long l = 5000L + Math.round(60.0D * (60.0D * (1000.0D * this.nextNamaaz[2])));
    this.alarms.cancel(this.alarmIntent);
    this.alarms.set(0, l + System.currentTimeMillis(), this.alarmIntent);
  }

  public static void showMiqaatNotification(NotificationManager paramNotificationManager, Context paramContext, String paramString1, String paramString2)
  {
    Notification localNotification = new Notification();
    localNotification.icon = 2130837517;
    localNotification.when = System.currentTimeMillis();
    Intent localIntent = new Intent(paramContext, ActivityMainTabHolder.class);
    localIntent.putExtra("dawoodibohra.salaat.desc", 2);
    localIntent.setFlags(268435456);
    localNotification.setLatestEventInfo(paramContext, paramString2, paramString1, PendingIntent.getActivity(paramContext, 0, localIntent, 1207959552));
    localNotification.ledARGB = -65536;
    localNotification.ledOffMS = 0;
    localNotification.ledOnMS = 1;
    localNotification.flags = (0x1 | localNotification.flags);
    localNotification.flags = (0x10 | localNotification.flags);
    paramNotificationManager.cancel(2);
    paramNotificationManager.notify(2, localNotification);
  }

  public static void showNamaazNotification(NotificationManager paramNotificationManager, PowerManager paramPowerManager, Context paramContext, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    Notification localNotification = new Notification();
    localNotification.icon = 2130837517;
    localNotification.when = System.currentTimeMillis();
    Intent localIntent = new Intent(paramContext, ActivityMainTabHolder.class);
    localIntent.putExtra("dawoodibohra.salaat.desc", 0);
    localIntent.setFlags(268435456);
    localNotification.setLatestEventInfo(paramContext, paramString2, paramString1, PendingIntent.getActivity(paramContext, 0, localIntent, 1207959552));
    if (paramInt == 1)
      localNotification.vibrate = new long[] { 1000L, 1000L, 1000L };
    while (true)
    {
      if (paramBoolean)
      {
        localNotification.sound = Uri.parse("android.resource://dawoodibohra.salaat/2131034112");
        localNotification.audioStreamType = 5;
      }
      localNotification.ledARGB = -16711936;
      localNotification.ledOffMS = 0;
      localNotification.ledOnMS = 1;
      localNotification.flags = (0x1 | localNotification.flags);
      localNotification.flags = (0x10 | localNotification.flags);
      paramNotificationManager.cancel(1);
      paramNotificationManager.notify(1, localNotification);
      paramPowerManager.newWakeLock(268435466, "My Tag").acquire(5000L);
      return;
      if (paramInt == 2)
        localNotification.vibrate = new long[] { 1000L, 1000L, 1000L, 1000L, 1000L };
      else if (paramInt == 3)
        localNotification.vibrate = new long[] { 1000L, 1000L, 1000L, 1000L, 1000L, 1000L, 1000L, 1000L, 1000L };
    }
  }

  public IBinder onBind(Intent paramIntent)
  {
    return this.mBinder;
  }

  public void onCreate()
  {
    this.mNM = ((NotificationManager)getSystemService("notification"));
    this.pm = ((PowerManager)getSystemService("power"));
    this.context = getApplicationContext();
    LocationManager localLocationManager = (LocationManager)getSystemService("location");
    this.prefs = PreferenceManager.getDefaultSharedPreferences(this.context);
    ActivityLocationSettings.TimeZoneUpdater(this.prefs, this.context);
    ActivityLocationSettings.LocationUpdater(localLocationManager, this.prefs, this.context);
    this.namaazTimesCalculator.setLocation(this.prefs.getFloat("SETTING_LAT", 0.0F), this.prefs.getFloat("SETTING_LNG", 0.0F));
    this.namaazTimesCalculator.setTimezone(this.prefs.getFloat("SETTING_TZ", 0.0F));
    this.theTime.setToNow();
    this.namaazTimesCalculator.setTime(this.theTime);
    initializeAlarm();
  }

  public void onDestroy()
  {
    super.onDestroy();
  }

  public void onStart(Intent paramIntent, int paramInt)
  {
    if ((!this.prefs.getBoolean("SETTING_NAMAAZ_NOTIFY", false)) && (!this.prefs.getBoolean("SETTING_MIQAAT_NOTIFY", false)))
      stopSelf();
    doOnStart();
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if ((!this.prefs.getBoolean("SETTING_NAMAAZ_NOTIFY", false)) && (!this.prefs.getBoolean("SETTING_MIQAAT_NOTIFY", false)))
      stopSelf();
    doOnStart();
    return 2;
  }

  public class LocalBinder extends Binder
  {
    public LocalBinder()
    {
    }

    ServiceNotifications getService()
    {
      return ServiceNotifications.this;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     dawoodibohra.salaat.ServiceNotifications
 * JD-Core Version:    0.6.2
 */