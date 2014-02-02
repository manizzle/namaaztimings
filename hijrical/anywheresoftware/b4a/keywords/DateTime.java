package anywheresoftware.b4a.keywords;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import anywheresoftware.b4a.BA;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class DateTime
{
  public static final long TicksPerDay = 86400000L;
  public static final long TicksPerHour = 3600000L;
  public static final long TicksPerMinute = 60000L;
  public static final long TicksPerSecond = 1000L;
  private static DateTime _instance;
  private static long lastTimeSetEvent;
  private static boolean listenToTimeZone = false;
  private static TimeZone zeroTimeZone = new SimpleTimeZone(0, "13256");
  private Calendar cal = Calendar.getInstance(Locale.US);
  private Date date;
  private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
  private SimpleDateFormat timeFormat;
  private TimeZone timeZone;

  private DateTime()
  {
    this.dateFormat.setLenient(false);
    this.timeFormat = new SimpleDateFormat("HH:mm:ss");
    this.timeFormat.setLenient(false);
    this.date = new Date(0L);
    this.timeZone = TimeZone.getDefault();
  }

  public static long Add(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    Calendar localCalendar = getInst().cal;
    localCalendar.setTimeInMillis(paramLong);
    localCalendar.add(1, paramInt1);
    localCalendar.add(2, paramInt2);
    localCalendar.add(6, paramInt3);
    return localCalendar.getTimeInMillis();
  }

  public static String Date(long paramLong)
  {
    DateTime localDateTime = getInst();
    localDateTime.date.setTime(paramLong);
    return localDateTime.dateFormat.format(localDateTime.date);
  }

  public static long DateParse(String paramString)
    throws ParseException
  {
    return getInst().dateFormat.parse(paramString).getTime();
  }

  public static long DateTimeParse(String paramString1, String paramString2)
    throws ParseException
  {
    SimpleDateFormat localSimpleDateFormat1 = getInst().dateFormat;
    SimpleDateFormat localSimpleDateFormat2 = getInst().timeFormat;
    localSimpleDateFormat1.setTimeZone(zeroTimeZone);
    localSimpleDateFormat2.setTimeZone(zeroTimeZone);
    try
    {
      long l1 = DateParse(paramString1);
      System.out.println("dd: " + new Date(l1).toGMTString());
      long l2 = localSimpleDateFormat2.parse(paramString2).getTime();
      System.out.println("tt: " + new Date(l2).toGMTString());
      long l3 = l1 + l2;
      System.out.println("total: " + new Date(l3).toGMTString());
      int i = (int)(3600000.0D * GetTimeZoneOffsetAt(l3));
      long l4 = l3 - i;
      System.out.println("total after endShift: " + new Date(l4).toGMTString());
      int j = (int)(3600000.0D * GetTimeZoneOffsetAt(l4));
      System.out.println(i - j);
      long l5 = l4 + (i - j);
      return l5;
    }
    finally
    {
      localSimpleDateFormat2.setTimeZone(getInst().timeZone);
      localSimpleDateFormat1.setTimeZone(getInst().timeZone);
    }
  }

  public static int GetDayOfMonth(long paramLong)
  {
    getInst().cal.setTimeInMillis(paramLong);
    return getInst().cal.get(5);
  }

  public static int GetDayOfWeek(long paramLong)
  {
    getInst().cal.setTimeInMillis(paramLong);
    return getInst().cal.get(7);
  }

  public static int GetDayOfYear(long paramLong)
  {
    getInst().cal.setTimeInMillis(paramLong);
    return getInst().cal.get(6);
  }

  public static int GetHour(long paramLong)
  {
    getInst().cal.setTimeInMillis(paramLong);
    return getInst().cal.get(11);
  }

  public static int GetMinute(long paramLong)
  {
    getInst().cal.setTimeInMillis(paramLong);
    return getInst().cal.get(12);
  }

  public static int GetMonth(long paramLong)
  {
    getInst().cal.setTimeInMillis(paramLong);
    return 1 + getInst().cal.get(2);
  }

  public static int GetSecond(long paramLong)
  {
    getInst().cal.setTimeInMillis(paramLong);
    return getInst().cal.get(13);
  }

  public static double GetTimeZoneOffsetAt(long paramLong)
  {
    return getInst().timeZone.getOffset(paramLong) / 3600000.0D;
  }

  public static int GetYear(long paramLong)
  {
    getInst().cal.setTimeInMillis(paramLong);
    return getInst().cal.get(1);
  }

  public static void ListenToExternalTimeChanges(BA paramBA)
  {
    if (listenToTimeZone)
      return;
    listenToTimeZone = true;
    BroadcastReceiver local1 = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        if (paramAnonymousIntent.hasExtra("time-zone"))
          DateTime.setTimeZoneInternal(TimeZone.getTimeZone(paramAnonymousIntent.getStringExtra("time-zone")));
        if (DateTime.getNow() - DateTime.lastTimeSetEvent > 100L)
          DateTime.this.raiseEventFromDifferentThread(null, null, 0, "datetime_timechanged", false, null);
        DateTime.lastTimeSetEvent = DateTime.getNow();
      }
    };
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.TIMEZONE_CHANGED");
    localIntentFilter.addAction("android.intent.action.TIME_SET");
    BA.applicationContext.registerReceiver(local1, localIntentFilter);
  }

  public static void SetTimeZone(int paramInt)
  {
    setTimeZoneInternal(new SimpleTimeZone(1000 * (paramInt * 3600), ""));
  }

  public static String Time(long paramLong)
  {
    DateTime localDateTime = getInst();
    localDateTime.date.setTime(paramLong);
    return localDateTime.timeFormat.format(localDateTime.date);
  }

  public static long TimeParse(String paramString)
    throws ParseException
  {
    SimpleDateFormat localSimpleDateFormat = getInst().timeFormat;
    localSimpleDateFormat.setTimeZone(zeroTimeZone);
    long l1 = localSimpleDateFormat.parse(paramString).getTime();
    localSimpleDateFormat.setTimeZone(getInst().timeZone);
    long l2 = Math.round(60.0D * getTimeZoneOffset());
    long l3 = System.currentTimeMillis() + l2 * 60000L;
    return l3 - l3 % 86400000L - l2 * 60000L + l1 % 86400000L;
  }

  public static String getDateFormat()
  {
    return getInst().dateFormat.toPattern();
  }

  public static String getDeviceDefaultDateFormat()
  {
    return ((SimpleDateFormat)DateFormat.getDateInstance()).toPattern();
  }

  public static String getDeviceDefaultTimeFormat()
  {
    return ((SimpleDateFormat)DateFormat.getTimeInstance()).toPattern();
  }

  private static DateTime getInst()
  {
    if (_instance == null)
      _instance = new DateTime();
    return _instance;
  }

  public static long getNow()
  {
    return System.currentTimeMillis();
  }

  public static String getTimeFormat()
  {
    return getInst().timeFormat.toPattern();
  }

  public static double getTimeZoneOffset()
  {
    return getInst().timeZone.getOffset(System.currentTimeMillis()) / 3600000.0D;
  }

  public static void setDateFormat(String paramString)
  {
    getInst().dateFormat.applyPattern(paramString);
  }

  public static void setTimeFormat(String paramString)
  {
    getInst().timeFormat.applyPattern(paramString);
  }

  private static void setTimeZoneInternal(TimeZone paramTimeZone)
  {
    getInst().timeZone = paramTimeZone;
    getInst().cal.setTimeZone(getInst().timeZone);
    getInst().dateFormat.setTimeZone(getInst().timeZone);
    getInst().timeFormat.setTimeZone(getInst().timeZone);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.keywords.DateTime
 * JD-Core Version:    0.6.2
 */