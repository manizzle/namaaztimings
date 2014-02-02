package edsmith.calendar;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.provider.CalendarContract.Attendees;
import android.provider.CalendarContract.Calendars;
import android.provider.CalendarContract.Events;
import android.provider.CalendarContract.Instances;
import android.provider.CalendarContract.Reminders;
import android.util.Log;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import anywheresoftware.b4a.objects.collections.List;
import anywheresoftware.b4a.objects.collections.Map;
import java.util.TimeZone;

@BA.Author("Edward Smith")
@BA.ShortName("MyCalendar")
@BA.Version(1.12F)
public class Calendar
{
  private static final String DEBUG_TAG = "CalendarActivity";
  private static final String Sort_Order = "dtstart ASC";
  private BA es_ba;

  private Cursor getCalendarManagedCursor(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3)
  {
    Uri localUri1 = Uri.parse("content://calendar/" + paramString2);
    ContentResolver localContentResolver = this.es_ba.context.getContentResolver();
    Object localObject;
    try
    {
      Cursor localCursor2 = localContentResolver.query(localUri1, paramArrayOfString, paramString1, null, paramString3);
      localObject = localCursor2;
      if (localObject == null)
        localUri2 = Uri.parse("content://com.android.calendar/" + paramString2);
    }
    catch (IllegalArgumentException localIllegalArgumentException1)
    {
      try
      {
        Cursor localCursor1 = localContentResolver.query(localUri2, paramArrayOfString, paramString1, null, paramString3);
        localObject = localCursor1;
        return localObject;
        localIllegalArgumentException1 = localIllegalArgumentException1;
        Log.i("CalendarActivity", "         ****  Not a pre 2.1 uri");
        Log.w("CalendarActivity", "Failed to get provider at 2.1 [" + localUri1.toString() + "]");
        localObject = null;
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        Uri localUri2;
        Log.i("CalendarActivity", "         ****  Not a post 2.1 uri");
        Log.w("CalendarActivity", "Failed to get provider at 2.2 [" + localUri2.toString() + "]");
      }
    }
    return localObject;
  }

  private String getCalendarUriBase()
  {
    Uri localUri1 = Uri.parse("content://calendar/calendars");
    ContentResolver localContentResolver = this.es_ba.context.getContentResolver();
    while (true)
    {
      Object localObject;
      String str;
      Uri localUri2;
      try
      {
        Cursor localCursor2 = localContentResolver.query(localUri1, null, null, null, null);
        localObject = localCursor2;
        if (localObject != null)
        {
          str = "content://calendar/";
          return str;
        }
      }
      catch (Exception localException1)
      {
        Log.i("CalendarActivity", "         ****  Not a pre 2.1 calendar");
        Log.w("CalendarActivity", "Failed to get provider at 2.1 [" + localUri1.toString() + "]");
        localObject = null;
        continue;
        localUri2 = Uri.parse("content://com.android.calendar/calendars");
      }
      try
      {
        Cursor localCursor1 = localContentResolver.query(localUri2, null, null, null, null);
        localObject = localCursor1;
        str = null;
        if (localObject == null)
          continue;
        return "content://com.android.calendar/";
      }
      catch (Exception localException2)
      {
        while (true)
        {
          Log.i("CalendarActivity", "         ****  Not a pre 2.1 calendar");
          Log.w("CalendarActivity", "Failed to get provider at 2.1 [" + localUri2.toString() + "]");
        }
      }
    }
  }

  public String CreateEvent(int paramInt, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, String paramString4, boolean paramBoolean)
  {
    ContentValues localContentValues1 = new ContentValues();
    String str1 = TimeZone.getDefault().getID();
    TimeZone localTimeZone = TimeZone.getDefault();
    String str2 = localTimeZone.getDisplayName();
    Log.i("CalendarActivity", "TimeZone = *************************        " + str2);
    if (Build.VERSION.SDK_INT < 14)
    {
      new Map().Initialize();
      localContentValues1.put("calendar_id", Integer.valueOf(paramInt));
      localContentValues1.put("title", paramString1);
      localContentValues1.put("description", paramString2);
      localContentValues1.put("eventLocation", paramString3);
      localContentValues1.put("dtstart", Long.valueOf(paramLong1));
      Log.i("CalendarActivity", "RRule =                " + paramString4);
      if (paramString4 != "null")
      {
        localContentValues1.put("rrule", paramString4);
        long l2 = (paramLong2 - paramLong1) / 1000L;
        localContentValues1.put("duration", "P" + l2 + "S");
        Log.i("CalendarActivity", "RRule added ");
        Log.i("CalendarActivity", "duration = *************************        " + l2);
        Log.i("CalendarActivity", " ");
        if (!paramBoolean)
          break label392;
        localContentValues1.put("allDay", Integer.valueOf(1));
        localContentValues1.put("eventTimezone", "UTC");
      }
      while (true)
      {
        Uri localUri = Uri.parse(getCalendarUriBase() + "events");
        String str5 = this.es_ba.context.getContentResolver().insert(localUri, localContentValues1).getLastPathSegment();
        Log.i("CalendarActivity", "                   Event ID = " + str5);
        return str5;
        localContentValues1.put("dtend", Long.valueOf(paramLong2));
        Log.i("CalendarActivity", "       ********* dtstart = " + paramLong1 + "       ********* dtend = " + paramLong2);
        Log.i("CalendarActivity", "                   No RRule ");
        break;
        label392: localContentValues1.put("allDay", Integer.valueOf(0));
        localContentValues1.put("eventTimezone", str1);
      }
    }
    ContentResolver localContentResolver = this.es_ba.context.getContentResolver();
    ContentValues localContentValues2 = new ContentValues();
    String str3;
    if (paramBoolean)
    {
      str3 = "1";
      localContentValues2.put("eventTimezone", "UTC");
      localContentValues2.put("calendar_id", Integer.valueOf(paramInt));
      localContentValues2.put("title", paramString1);
      localContentValues2.put("description", paramString2);
      localContentValues2.put("dtstart", Long.valueOf(paramLong1));
      localContentValues2.put("eventLocation", paramString3);
      localContentValues2.put("allDay", str3);
      Log.i("CalendarActivity", "RRule =                " + paramString4);
      if (paramString4 == "null")
        break label740;
      localContentValues2.put("rrule", paramString4);
      long l1 = (paramLong2 - paramLong1) / 1000L;
      localContentValues2.put("duration", "P" + l1 + "S");
      Log.i("CalendarActivity", "RRule added ");
      Log.i("CalendarActivity", "duration = *************************        " + l1);
      Log.i("CalendarActivity", " ");
    }
    while (true)
    {
      int i = Build.VERSION.SDK_INT;
      Log.i("CalendarActivity", "Timezone = " + str2 + "      **************  Version = " + String.valueOf(i) + "Time zone = " + localTimeZone.toString());
      String str4 = localContentResolver.insert(CalendarContract.Events.CONTENT_URI, localContentValues2).getLastPathSegment();
      Log.i("CalendarActivity", "                   Event ID = " + str4);
      return str4;
      str3 = "0";
      localContentValues2.put("eventTimezone", str1);
      break;
      label740: localContentValues2.put("dtend", Long.valueOf(paramLong2));
      Log.i("CalendarActivity", "       ********* dtstart = " + paramLong1 + "       ********* dtend = " + paramLong2);
      Log.i("CalendarActivity", "                   No RRule ");
    }
  }

  public String CreateEventWithReminder(int paramInt, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3, String paramString4, boolean paramBoolean)
  {
    String str1 = TimeZone.getDefault().getID();
    TimeZone localTimeZone = TimeZone.getDefault();
    String str2 = localTimeZone.getDisplayName();
    Log.i("CalendarActivity", "TimeZone = *************************        " + str2);
    Log.i("CalendarActivity", "TimeZoneUTC = *************************        UTC");
    Log.i("CalendarActivity", "LocalTimeZone = *************************        " + str1);
    if (Build.VERSION.SDK_INT < 14)
    {
      ContentValues localContentValues1 = new ContentValues();
      ContentValues localContentValues2 = new ContentValues();
      new Map().Initialize();
      localContentValues1.put("calendar_id", Integer.valueOf(paramInt));
      localContentValues1.put("title", paramString1);
      localContentValues1.put("description", paramString2);
      localContentValues1.put("eventLocation", paramString3);
      localContentValues1.put("dtstart", Long.valueOf(paramLong1));
      Log.i("CalendarActivity", "RRule =                " + paramString4);
      if (paramString4 != "null")
      {
        localContentValues1.put("rrule", paramString4);
        long l1 = (paramLong2 - paramLong1) / 1000L;
        localContentValues1.put("duration", "P" + l1 + "S");
        Log.i("CalendarActivity", "RRule added ");
        Log.i("CalendarActivity", "duration = *************************        " + l1);
        Log.i("CalendarActivity", " ");
        if (!paramBoolean)
          break label496;
        localContentValues1.put("allDay", Integer.valueOf(1));
        localContentValues1.put("eventTimezone", "UTC");
      }
      while (true)
      {
        localContentValues1.put("hasAlarm", Integer.valueOf(1));
        Uri localUri1 = Uri.parse(getCalendarUriBase() + "events");
        Uri localUri2 = this.es_ba.context.getContentResolver().insert(localUri1, localContentValues1);
        String str3 = localUri2.getLastPathSegment();
        if (localUri2 != null)
        {
          Log.i("CalendarActivity", "Event ID = *************************        " + str3);
          localContentValues2.put("event_id", str3);
          localContentValues2.put("method", Integer.valueOf(1));
          localContentValues2.put("minutes", Long.valueOf(paramLong3));
          Uri localUri3 = Uri.parse(getCalendarUriBase() + "reminders");
          this.es_ba.context.getContentResolver().insert(localUri3, localContentValues2);
        }
        return str3;
        localContentValues1.put("dtend", Long.valueOf(paramLong2));
        Log.i("CalendarActivity", "                   No RRule ");
        break;
        label496: localContentValues1.put("allDay", Integer.valueOf(0));
        localContentValues1.put("eventTimezone", str1);
      }
    }
    ContentResolver localContentResolver1 = this.es_ba.context.getContentResolver();
    ContentValues localContentValues3 = new ContentValues();
    String str4;
    if (paramBoolean)
    {
      str4 = "1";
      localContentValues3.put("eventTimezone", "UTC");
      localContentValues3.put("calendar_id", Integer.valueOf(paramInt));
      localContentValues3.put("title", paramString1);
      localContentValues3.put("description", paramString2);
      localContentValues3.put("dtstart", Long.valueOf(paramLong1));
      localContentValues3.put("eventLocation", paramString3);
      localContentValues3.put("allDay", str4);
      Log.i("CalendarActivity", "RRule =                " + paramString4);
      if (paramString4 == "null")
        break label918;
      localContentValues3.put("rrule", paramString4);
      long l3 = (paramLong2 - paramLong1) / 1000L;
      localContentValues3.put("duration", "P" + l3 + "S");
      Log.i("CalendarActivity", "RRule added ");
      Log.i("CalendarActivity", "duration = *************************        " + l3);
      Log.i("CalendarActivity", " ");
    }
    while (true)
    {
      int i = Build.VERSION.SDK_INT;
      Log.i("CalendarActivity", "Timezone = " + str2 + "      **************  Version = " + String.valueOf(i) + "Time zone = " + localTimeZone.toString());
      String str5 = localContentResolver1.insert(CalendarContract.Events.CONTENT_URI, localContentValues3).getLastPathSegment();
      Log.i("CalendarActivity", "                   Event ID = " + str5);
      long l2 = Long.parseLong(str5);
      ContentResolver localContentResolver2 = this.es_ba.context.getContentResolver();
      ContentValues localContentValues4 = new ContentValues();
      localContentValues4.put("minutes", Long.valueOf(paramLong3));
      localContentValues4.put("event_id", Long.valueOf(l2));
      localContentValues4.put("method", Integer.valueOf(1));
      localContentResolver2.insert(CalendarContract.Reminders.CONTENT_URI, localContentValues4);
      return str5;
      str4 = "0";
      localContentValues3.put("eventTimezone", str1);
      break;
      label918: localContentValues3.put("dtend", Long.valueOf(paramLong2));
      Log.i("CalendarActivity", "       ********* dtstart = " + paramLong1 + "       ********* dtend = " + paramLong2);
      Log.i("CalendarActivity", "                   No RRule ");
    }
  }

  public int DeleteCalendarEntry(int paramInt)
  {
    if (Build.VERSION.SDK_INT < 14)
    {
      Uri localUri2 = ContentUris.withAppendedId(Uri.parse(getCalendarUriBase() + "events"), paramInt);
      Log.i("CalendarActivity", "eventUri = " + localUri2);
      int j = this.es_ba.context.getContentResolver().delete(localUri2, null, null);
      Log.i("CalendarActivity", "Deleted " + j + " calendar entry.");
      return j;
    }
    ContentResolver localContentResolver = this.es_ba.context.getContentResolver();
    Uri localUri1 = ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, paramInt);
    Log.i("CalendarActivity", "eventUri = " + localUri1);
    int i = localContentResolver.delete(localUri1, null, null);
    Log.i("CalendarActivity", "Deleted " + i + " calendar entry.");
    return i;
  }

  public Map GetEventDetails(int paramInt)
  {
    Map localMap = new Map();
    localMap.Initialize();
    if (Build.VERSION.SDK_INT < 14)
    {
      Cursor localCursor2 = getCalendarManagedCursor(null, null, "events/" + paramInt, null);
      if ((localCursor2 != null) && (localCursor2.moveToFirst()))
      {
        int i7 = localCursor2.getColumnIndex("title");
        int i8 = localCursor2.getColumnIndex("description");
        int i9 = localCursor2.getColumnIndex("eventLocation");
        int i10 = localCursor2.getColumnIndex("dtstart");
        int i11 = localCursor2.getColumnIndex("dtend");
        int i12 = localCursor2.getColumnIndex("allDay");
        int i13 = localCursor2.getColumnIndex("duration");
        int i14 = localCursor2.getColumnIndex("hasAlarm");
        int i15 = localCursor2.getColumnIndex("rrule");
        localMap.Put("title", localCursor2.getString(i7));
        localMap.Put("description", localCursor2.getString(i8));
        localMap.Put("eventLocation", localCursor2.getString(i9));
        localMap.Put("dtstart", localCursor2.getString(i10));
        localMap.Put("dtend", localCursor2.getString(i11));
        localMap.Put("allDay", localCursor2.getString(i12));
        localMap.Put("duration", localCursor2.getString(i13));
        localMap.Put("hasAlarm", localCursor2.getString(i14));
        localMap.Put("recurRule", localCursor2.getString(i15));
        return localMap;
      }
      localMap.Clear();
      Log.i("CalendarActivity", "No Calendar Entry");
      return localMap;
    }
    ContentResolver localContentResolver = this.es_ba.context.getContentResolver();
    Uri localUri = CalendarContract.Events.CONTENT_URI;
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramInt);
    Cursor localCursor1 = localContentResolver.query(localUri, null, "(_id = ?) ", arrayOfString, null);
    Log.i("CalendarActivity", "       ********************* START      **************");
    Log.i("CalendarActivity", "(_id = ?) " + arrayOfString);
    if ((localCursor1 != null) && (localCursor1.moveToFirst()))
    {
      Log.i("CalendarActivity", "Listing All Calendar Event Details");
      int i = localCursor1.getColumnIndex("title");
      int j = localCursor1.getColumnIndex("description");
      int k = localCursor1.getColumnIndex("eventLocation");
      int m = localCursor1.getColumnIndex("dtstart");
      int n = localCursor1.getColumnIndex("dtend");
      int i1 = localCursor1.getColumnIndex("allDay");
      int i2 = localCursor1.getColumnIndex("duration");
      int i3 = localCursor1.getColumnIndex("hasAlarm");
      int i4 = localCursor1.getColumnIndex("rrule");
      localMap.Put("title", localCursor1.getString(i));
      localMap.Put("description", localCursor1.getString(j));
      localMap.Put("eventLocation", localCursor1.getString(k));
      localMap.Put("dtstart", localCursor1.getString(m));
      localMap.Put("dtend", localCursor1.getString(n));
      localMap.Put("allDay", localCursor1.getString(i1));
      localMap.Put("duration", localCursor1.getString(i2));
      localMap.Put("hasAlarm", localCursor1.getString(i3));
      localMap.Put("recurRule", localCursor1.getString(i4));
      Log.i("CalendarActivity", "**START All Calendar Event Description**");
      for (int i5 = 0; ; i5++)
      {
        int i6 = localCursor1.getColumnCount();
        if (i5 >= i6)
        {
          Log.i("CalendarActivity", "**END All Calendar Event Description**");
          if (localCursor1.moveToNext())
            break;
          return localMap;
        }
        Log.i("CalendarActivity", localCursor1.getColumnName(i5) + "=" + localCursor1.getString(i5));
      }
    }
    localMap.Clear();
    Log.i("CalendarActivity", "No Calendar Entry");
    return localMap;
  }

  public List GetExtendedListOfAllCalendars(int paramInt)
  {
    List localList = new List();
    localList.Initialize();
    int i = Build.VERSION.SDK_INT;
    Log.i("CalendarActivity", "                  *******************                  ****************");
    Log.i("CalendarActivity", Integer.toString(i));
    if (Build.VERSION.SDK_INT < 14)
    {
      String str8;
      Cursor localCursor2;
      int i7;
      int i8;
      int i9;
      int i10;
      int i11;
      int i12;
      int i13;
      int i14;
      if (paramInt > -1)
      {
        str8 = "access_level=" + paramInt;
        localCursor2 = getCalendarManagedCursor(null, str8, "calendars", null);
        if ((localCursor2 != null) && (localCursor2.moveToFirst()))
        {
          Log.i("CalendarActivity", "Listing Selected Calendars Only");
          i7 = localCursor2.getColumnIndex("_id");
          i8 = localCursor2.getColumnIndex("name");
          i9 = localCursor2.getColumnIndex("displayName");
          i10 = localCursor2.getColumnIndex("color");
          i11 = localCursor2.getColumnIndex("location");
          i12 = localCursor2.getColumnIndex("timezone");
          i13 = localCursor2.getColumnIndex("access_level");
          i14 = localCursor2.getColumnIndex("ownerAccount");
        }
      }
      else
      {
        label200: for (int i15 = 0; ; i15++)
        {
          int i16 = localCursor2.getColumnCount();
          if (i15 >= i16)
          {
            Log.i("CalendarActivity", "Found Calendar '" + null + "' (ID=" + 0L + ")");
            long l2 = localCursor2.getLong(i7);
            String str9 = localCursor2.getString(i8);
            String str10 = localCursor2.getString(i9);
            String str11 = localCursor2.getString(i10);
            String str12 = localCursor2.getString(i11);
            String str13 = localCursor2.getString(i12);
            String str14 = localCursor2.getString(i13);
            String str15 = localCursor2.getString(i14);
            localList.Add(Long.valueOf(l2));
            localList.Add(str9);
            localList.Add(str10);
            localList.Add(str11);
            localList.Add(str12);
            localList.Add(str13);
            localList.Add(str14);
            localList.Add(str15);
            if (localCursor2.moveToNext())
              break label200;
            return localList;
            str8 = "";
            break;
          }
          Log.i("CalendarActivity", localCursor2.getColumnName(i15) + " = " + localCursor2.getString(i15));
        }
      }
      Log.i("CalendarActivity", "No Calendars");
      return localList;
    }
    ContentResolver localContentResolver = this.es_ba.context.getContentResolver();
    Uri localUri = CalendarContract.Calendars.CONTENT_URI;
    Cursor localCursor1;
    label532: label628: long l1;
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    String str7;
    if (paramInt > -1)
    {
      String[] arrayOfString = new String[1];
      arrayOfString[0] = Integer.toString(paramInt);
      localCursor1 = localContentResolver.query(localUri, null, "(calendar_access_level = ?) ", arrayOfString, null);
      int j = localCursor1.getColumnIndex("_id");
      int k = localCursor1.getColumnIndex("name");
      int m = localCursor1.getColumnIndex("calendar_displayName");
      int n = localCursor1.getColumnIndex("calendar_color");
      int i1 = localCursor1.getColumnIndex("calendar_location");
      int i2 = localCursor1.getColumnIndex("calendar_timezone");
      int i3 = localCursor1.getColumnIndex("calendar_access_level");
      int i4 = localCursor1.getColumnIndex("ownerAccount");
      if (localCursor1.moveToNext())
      {
        l1 = localCursor1.getLong(j);
        str1 = localCursor1.getString(k);
        str2 = localCursor1.getString(m);
        str3 = localCursor1.getString(n);
        str4 = localCursor1.getString(i1);
        str5 = localCursor1.getString(i2);
        str6 = localCursor1.getString(i3);
        str7 = localCursor1.getString(i4);
        Log.i("CalendarActivity", "             ***************");
      }
    }
    for (int i5 = 0; ; i5++)
    {
      int i6 = localCursor1.getColumnCount();
      if (i5 >= i6)
      {
        localList.Add(Long.valueOf(l1));
        localList.Add(str1);
        localList.Add(str2);
        localList.Add(str3);
        localList.Add(str4);
        localList.Add(str5);
        localList.Add(str6);
        localList.Add(str7);
        Log.i("CalendarActivity", "Calendar ID = " + l1 + "  Display Name = " + str2 + "  Colour = " + str3);
        break label628;
        break;
        localCursor1 = localContentResolver.query(localUri, null, null, null, null);
        break label532;
      }
      Log.i("CalendarActivity", localCursor1.getColumnName(i5) + " = " + localCursor1.getString(i5));
    }
  }

  public Map GetListOfAllCalendars(boolean paramBoolean)
  {
    Map localMap = new Map();
    localMap.Initialize();
    int i = Build.VERSION.SDK_INT;
    Log.i("CalendarActivity", "                  *******************                  ****************");
    Log.i("CalendarActivity", Integer.toString(i));
    if (Build.VERSION.SDK_INT < 14)
    {
      String[] arrayOfString1 = { "_id", "name" };
      String str1;
      Cursor localCursor1;
      label132: String str2;
      String str3;
      if (paramBoolean)
      {
        str1 = "access_level=700";
        localCursor1 = getCalendarManagedCursor(arrayOfString1, str1, "calendars", null);
        if ((localCursor1 != null) && (localCursor1.moveToFirst()))
        {
          Log.i("CalendarActivity", "Listing Selected Calendars Only");
          int j = localCursor1.getColumnIndex("name");
          int k = localCursor1.getColumnIndex("_id");
          str2 = localCursor1.getString(j);
          str3 = localCursor1.getString(k);
          Log.i("CalendarActivity", "Found Calendar '" + str2 + "' (ID=" + str3 + ")");
        }
      }
      else
      {
        for (int m = 0; ; m++)
        {
          int n = localCursor1.getColumnCount();
          if (m >= n)
          {
            if (str2 != null)
              localMap.Put(Integer.valueOf(Integer.parseInt(str3)), str2);
            if (localCursor1.moveToNext())
              break label132;
            return localMap;
            str1 = "";
            break;
          }
          Log.i("CalendarActivity", localCursor1.getColumnName(m) + " = " + localCursor1.getString(m));
        }
      }
      Log.i("CalendarActivity", "No Calendars");
      return localMap;
    }
    ContentResolver localContentResolver = this.es_ba.context.getContentResolver();
    Uri localUri = CalendarContract.Calendars.CONTENT_URI;
    String[] arrayOfString2 = { "700" };
    Cursor localCursor2;
    label366: long l;
    label402: String str4;
    String str5;
    if (paramBoolean)
    {
      localCursor2 = localContentResolver.query(localUri, null, "(calendar_access_level = ?) ", arrayOfString2, null);
      int i1 = localCursor2.getColumnIndex("_id");
      int i2 = localCursor2.getColumnIndex("calendar_displayName");
      int i3 = localCursor2.getColumnIndex("account_name");
      if (localCursor2.moveToNext())
      {
        l = localCursor2.getLong(i1);
        str4 = localCursor2.getString(i2);
        str5 = localCursor2.getString(i3);
        Log.i("CalendarActivity", "             ***************");
      }
    }
    for (int i4 = 0; ; i4++)
    {
      int i5 = localCursor2.getColumnCount();
      if (i4 >= i5)
      {
        if (str4 != null)
          localMap.Put(Long.valueOf(l), str4);
        Log.i("CalendarActivity", "Calendar ID = " + l + "  Display Name = " + str4 + "   Account Name = " + str5);
        break label402;
        break;
        localCursor2 = localContentResolver.query(localUri, null, null, null, null);
        break label366;
      }
      Log.i("CalendarActivity", localCursor2.getColumnName(i4) + " = " + localCursor2.getString(i4));
    }
  }

  public List GetListofAllEventsforCalendar(int paramInt)
  {
    List localList = new List();
    localList.Initialize();
    if (Build.VERSION.SDK_INT < 14)
    {
      Cursor localCursor2 = getCalendarManagedCursor(null, "calendar_id=" + paramInt, "events", "dtstart ASC");
      Log.i("CalendarActivity", "       ********************* START      **************");
      if ((localCursor2 != null) && (localCursor2.moveToFirst()))
      {
        Log.i("CalendarActivity", "Listing Calendar Event Details");
        int i5 = localCursor2.getColumnIndex("title");
        int i6 = localCursor2.getColumnIndex("description");
        int i7 = localCursor2.getColumnIndex("dtstart");
        int i8 = localCursor2.getColumnIndex("dtend");
        int i9 = localCursor2.getColumnIndex("eventLocation");
        int i10 = localCursor2.getColumnIndex("allDay");
        int i11 = localCursor2.getColumnIndex("_id");
        String str8 = localCursor2.getString(i5);
        String str9 = localCursor2.getString(i6);
        String str10 = localCursor2.getString(i7);
        String str11 = localCursor2.getString(i8);
        String str12 = localCursor2.getString(i9);
        String str13 = localCursor2.getString(i10);
        String str14 = localCursor2.getString(i11);
        Log.i("CalendarActivity", "**START Calendar Event Description**");
        Log.i("CalendarActivity", str8 + "-" + str9 + "-" + str10 + "-" + str11 + "-" + str12 + "-" + str13 + "-" + str14);
        localList.Add(str8);
        localList.Add(str9);
        localList.Add(str10);
        localList.Add(str11);
        localList.Add(str12);
        localList.Add(str13);
        localList.Add(str14);
        for (int i12 = 0; ; i12++)
        {
          int i13 = localCursor2.getColumnCount();
          if (i12 >= i13)
          {
            Log.i("CalendarActivity", "**END Calendar Event Description**");
            Log.i("CalendarActivity", "                ************");
            if (localCursor2.moveToNext())
              break;
            Log.i("CalendarActivity", "       ****************      FINISH      **************");
            return localList;
          }
          Log.i("CalendarActivity", localCursor2.getColumnName(i12) + "=" + localCursor2.getString(i12));
        }
      }
      Log.i("CalendarActivity", "No Calendars");
      return localList;
    }
    String[] arrayOfString1 = { "title", "description", "dtstart", "dtend", "eventLocation", "allDay", "_id" };
    ContentResolver localContentResolver = this.es_ba.context.getContentResolver();
    Uri localUri = CalendarContract.Events.CONTENT_URI;
    String[] arrayOfString2 = new String[1];
    arrayOfString2[0] = String.valueOf(paramInt);
    Cursor localCursor1 = localContentResolver.query(localUri, null, "(calendar_id = ?) ", arrayOfString2, "dtstart ASC");
    Log.i("CalendarActivity", "       ********************* START      **************");
    Log.i("CalendarActivity", arrayOfString1 + "(calendar_id = ?) " + arrayOfString2);
    if ((localCursor1 != null) && (localCursor1.moveToFirst()))
    {
      int i = localCursor1.getColumnIndex("title");
      int j = localCursor1.getColumnIndex("description");
      int k = localCursor1.getColumnIndex("dtstart");
      int m = localCursor1.getColumnIndex("dtend");
      int n = localCursor1.getColumnIndex("eventLocation");
      int i1 = localCursor1.getColumnIndex("allDay");
      int i2 = localCursor1.getColumnIndex("_id");
      String str1 = localCursor1.getString(i);
      String str2 = localCursor1.getString(j);
      String str3 = localCursor1.getString(k);
      String str4 = localCursor1.getString(m);
      String str5 = localCursor1.getString(n);
      String str6 = localCursor1.getString(i1);
      String str7 = localCursor1.getString(i2);
      localList.Add(str1);
      localList.Add(str2);
      localList.Add(str3);
      localList.Add(str4);
      localList.Add(str5);
      localList.Add(str6);
      localList.Add(str7);
      Log.i("CalendarActivity", "**START Calendar Event Description between dates**");
      Log.i("CalendarActivity", str1 + str2 + str3 + str4);
      for (int i3 = 0; ; i3++)
      {
        int i4 = localCursor1.getColumnCount();
        if (i3 >= i4)
        {
          Log.i("CalendarActivity", "**END Calendar Event Description between dates**");
          Log.i("CalendarActivity", "                ************");
          if (localCursor1.moveToNext())
            break;
          Log.i("CalendarActivity", "       ****************      FINISH      **************");
          return localList;
        }
        Log.i("CalendarActivity", localCursor1.getColumnName(i3) + "=" + localCursor1.getString(i3));
      }
    }
    Log.i("CalendarActivity", "************         Error getting events        ***************");
    return localList;
  }

  public List GetListofEventsforCalendarBetweenDates(int paramInt, long paramLong1, long paramLong2)
  {
    List localList = new List();
    localList.Initialize();
    if (Build.VERSION.SDK_INT < 14)
    {
      Cursor localCursor2 = getCalendarManagedCursor(null, "calendar_id = " + paramInt, "instances/when/" + paramLong1 + "/" + paramLong2, "dtstart ASC");
      Log.i("CalendarActivity", "       ********************* START      **************");
      if ((localCursor2 != null) && (localCursor2.moveToFirst()))
      {
        Log.i("CalendarActivity", "Listing Calendar Event Details between dates");
        int i5 = localCursor2.getColumnIndex("title");
        int i6 = localCursor2.getColumnIndex("description");
        int i7 = localCursor2.getColumnIndex("begin");
        int i8 = localCursor2.getColumnIndex("end");
        int i9 = localCursor2.getColumnIndex("eventLocation");
        int i10 = localCursor2.getColumnIndex("allDay");
        int i11 = localCursor2.getColumnIndex("event_id");
        String str8 = localCursor2.getString(i11);
        String str9 = localCursor2.getString(i5);
        String str10 = localCursor2.getString(i6);
        String str11 = localCursor2.getString(i7);
        String str12 = localCursor2.getString(i8);
        String str13 = localCursor2.getString(i9);
        String str14 = localCursor2.getString(i10);
        Log.i("CalendarActivity", "**START Calendar Event Description between dates**");
        Log.i("CalendarActivity", str9 + str10 + str11 + str12 + str13 + str14 + str8);
        localList.Add(str9);
        localList.Add(str10);
        localList.Add(str11);
        localList.Add(str12);
        localList.Add(str13);
        localList.Add(str14);
        localList.Add(str8);
        for (int i12 = 0; ; i12++)
        {
          int i13 = localCursor2.getColumnCount();
          if (i12 >= i13)
          {
            Log.i("CalendarActivity", "**END Calendar Event Description between dates**");
            Log.i("CalendarActivity", "                     *********");
            if (localCursor2.moveToNext())
              break;
            Log.i("CalendarActivity", "       *********************    FINISH      **************");
            return localList;
          }
          Log.i("CalendarActivity", localCursor2.getColumnName(i12) + " = " + localCursor2.getString(i12));
        }
      }
      Log.i("CalendarActivity", "No events");
      return localList;
    }
    String[] arrayOfString1 = { "title", "description", "dtstart", "dtend", "eventLocation", "allDay", "_id" };
    ContentResolver localContentResolver = this.es_ba.context.getContentResolver();
    String[] arrayOfString2 = new String[3];
    arrayOfString2[0] = String.valueOf(paramInt);
    arrayOfString2[1] = String.valueOf(paramLong1);
    arrayOfString2[2] = String.valueOf(paramLong2);
    Uri.Builder localBuilder = CalendarContract.Instances.CONTENT_URI.buildUpon();
    ContentUris.appendId(localBuilder, paramLong1);
    ContentUris.appendId(localBuilder, paramLong2);
    Cursor localCursor1 = localContentResolver.query(localBuilder.build(), null, "((calendar_id = ?) AND (begin >= ?) AND ((end <= ?) OR (dtend is null)) )", arrayOfString2, "dtstart ASC");
    Log.i("CalendarActivity", "       ********************* START      **************");
    Log.i("CalendarActivity", arrayOfString1 + " " + "((calendar_id = ?) AND (begin >= ?) AND ((end <= ?) OR (dtend is null)) )" + " " + arrayOfString2);
    if ((localCursor1 != null) && (localCursor1.moveToFirst()))
    {
      int i = localCursor1.getColumnIndex("title");
      int j = localCursor1.getColumnIndex("description");
      int k = localCursor1.getColumnIndex("begin");
      int m = localCursor1.getColumnIndex("end");
      int n = localCursor1.getColumnIndex("eventLocation");
      int i1 = localCursor1.getColumnIndex("allDay");
      int i2 = localCursor1.getColumnIndex("event_id");
      String str1 = localCursor1.getString(i);
      String str2 = localCursor1.getString(j);
      String str3 = localCursor1.getString(k);
      String str4 = localCursor1.getString(m);
      String str5 = localCursor1.getString(n);
      String str6 = localCursor1.getString(i1);
      String str7 = localCursor1.getString(i2);
      localList.Add(str1);
      localList.Add(str2);
      localList.Add(str3);
      localList.Add(str4);
      localList.Add(str5);
      localList.Add(str6);
      localList.Add(str7);
      Log.i("CalendarActivity", "**START Calendar Event Description between dates**");
      Log.i("CalendarActivity", str1 + str2 + str3 + str4);
      for (int i3 = 0; ; i3++)
      {
        int i4 = localCursor1.getColumnCount();
        if (i3 >= i4)
        {
          Log.i("CalendarActivity", "**END Calendar Event Description between dates**");
          Log.i("CalendarActivity", "                  *********");
          if (localCursor1.moveToNext())
            break;
          Log.i("CalendarActivity", "       ***********       FINISH      **************");
          return localList;
        }
        Log.i("CalendarActivity", localCursor1.getColumnName(i3) + "=" + localCursor1.getString(i3));
      }
    }
    Log.i("CalendarActivity", "************         Error getting events        ***************");
    return localList;
  }

  public void Initialize(BA paramBA)
  {
    this.es_ba = paramBA;
  }

  public Map ListExtendedCalendarEntryDetails(int paramInt)
  {
    Map localMap = new Map();
    localMap.Initialize();
    EventExtendedDetails localEventExtendedDetails = new EventExtendedDetails();
    if (Build.VERSION.SDK_INT < 14)
    {
      Cursor localCursor4 = getCalendarManagedCursor(null, null, "events/" + paramInt, null);
      int i24;
      label247: Cursor localCursor5;
      int i19;
      label390: label425: Cursor localCursor6;
      int i11;
      if ((localCursor4 != null) && (localCursor4.moveToFirst()))
      {
        int i21 = localCursor4.getColumnIndex("hasAlarm");
        int i22 = localCursor4.getColumnIndex("rrule");
        int i23 = localCursor4.getColumnIndex("duration");
        Log.i("CalendarActivity", "Listing All Calendar Event Details");
        do
        {
          localEventExtendedDetails.hasAlarm = localCursor4.getString(i21);
          localEventExtendedDetails.recurRule = localCursor4.getString(i22);
          localEventExtendedDetails.duration = localCursor4.getString(i23);
          localMap.Put("hasAlarm", localCursor4.getString(i21));
          localMap.Put("recurRule", localCursor4.getString(i22));
          localMap.Put("duration", localCursor4.getString(i23));
          Log.i("CalendarActivity", "**START All Calendar Event Description**");
          i24 = 0;
          int i25 = localCursor4.getColumnCount();
          if (i24 < i25)
            break;
          Log.i("CalendarActivity", "**END All Calendar Event Description**");
        }
        while (localCursor4.moveToNext());
        localCursor5 = getCalendarManagedCursor(null, "event_id=" + paramInt, "reminders", null);
        if ((localCursor5 == null) || (!localCursor5.moveToFirst()))
          break label859;
        int i17 = localCursor5.getColumnIndex("minutes");
        int i18 = localCursor5.getColumnIndex("method");
        Log.i("CalendarActivity", "Listing Calendar Reminder Details");
        do
        {
          localEventExtendedDetails.minutes = localCursor5.getString(i17);
          localEventExtendedDetails.method = localCursor5.getString(i18);
          localMap.Put("minutes", localCursor5.getString(i17));
          localMap.Put("method", localCursor5.getString(i18));
          Log.i("CalendarActivity", "**START Calendar Reminder Description**");
          i19 = 0;
          int i20 = localCursor5.getColumnCount();
          if (i19 < i20)
            break;
          Log.i("CalendarActivity", "**END Calendar Reminder Description**");
        }
        while (localCursor5.moveToNext());
        localCursor6 = getCalendarManagedCursor(null, "event_id=" + paramInt, "attendees", null);
        i11 = 0;
        if ((localCursor6 == null) || (!localCursor6.moveToFirst()))
          break label949;
        int i12 = localCursor6.getColumnIndex("attendeeName");
        int i13 = localCursor6.getColumnIndex("attendeeEmail");
        int i14 = localCursor6.getColumnIndex("attendeeStatus");
        Log.i("CalendarActivity", "Listing Calendar Attendees Details");
        label516: localEventExtendedDetails.AttendeeName = localCursor6.getString(i12);
        localEventExtendedDetails.AttendeeEmail = localCursor6.getString(i13);
        localEventExtendedDetails.AttendeeStatus = localCursor6.getString(i14);
        localMap.Put("AttendeeName" + i11, localCursor6.getString(i12));
        localMap.Put("AttendeeEmail" + i11, localCursor6.getString(i13));
        localMap.Put("AttendeeStatus" + i11, localCursor6.getString(i14));
        Log.i("CalendarActivity", "**START Calendar Attendees Description**");
      }
      for (int i15 = 0; ; i15++)
      {
        int i16 = localCursor6.getColumnCount();
        if (i15 >= i16)
        {
          Log.i("CalendarActivity", "**END Calendar Attendees Description**");
          i11++;
          if (localCursor6.moveToNext())
            break label516;
          return localMap;
          Log.i("CalendarActivity", localCursor4.getColumnName(i24) + "=" + localCursor4.getString(i24));
          i24++;
          break;
          localEventExtendedDetails.hasAlarm = null;
          localEventExtendedDetails.recurRule = null;
          localEventExtendedDetails.duration = null;
          localMap.Put("hasAlarm", null);
          localMap.Put("recurRule", null);
          localMap.Put("duration", null);
          Log.i("CalendarActivity", "No Calendar Entry");
          break label247;
          Log.i("CalendarActivity", localCursor5.getColumnName(i19) + "=" + localCursor5.getString(i19));
          i19++;
          break label390;
          label859: localEventExtendedDetails.minutes = null;
          localEventExtendedDetails.method = null;
          localMap.Put("minutes", null);
          localMap.Put("method", null);
          Log.i("CalendarActivity", "No Calendar Reminder");
          break label425;
        }
        Log.i("CalendarActivity", localCursor6.getColumnName(i15) + "=" + localCursor6.getString(i15));
      }
      label949: localEventExtendedDetails.AttendeeName = null;
      localEventExtendedDetails.AttendeeEmail = null;
      localEventExtendedDetails.AttendeeStatus = null;
      localMap.Put("AttendeeName" + 0, null);
      localMap.Put("AttendeeEmail" + 0, null);
      localMap.Put("AttendeeStatus" + 0, null);
      Log.i("CalendarActivity", "No Calendar Attendees");
      return localMap;
    }
    ContentResolver localContentResolver = this.es_ba.context.getContentResolver();
    Uri localUri = CalendarContract.Events.CONTENT_URI;
    String[] arrayOfString1 = new String[1];
    arrayOfString1[0] = String.valueOf(paramInt);
    Cursor localCursor1 = localContentResolver.query(localUri, null, "(_id = ?) ", arrayOfString1, null);
    Log.i("CalendarActivity", "       ********************* START      **************");
    Log.i("CalendarActivity", "(_id = ?) " + arrayOfString1);
    int i9;
    label1280: Cursor localCursor2;
    int i4;
    label1431: label1466: Cursor localCursor3;
    int i;
    if ((localCursor1 != null) && (localCursor1.moveToFirst()))
    {
      Log.i("CalendarActivity", "Listing All Calendar Event Details");
      int i6 = localCursor1.getColumnIndex("hasAlarm");
      int i7 = localCursor1.getColumnIndex("rrule");
      int i8 = localCursor1.getColumnIndex("duration");
      do
      {
        localMap.Put("hasAlarm", localCursor1.getString(i6));
        localMap.Put("recurRule", localCursor1.getString(i7));
        localMap.Put("duration", localCursor1.getString(i8));
        Log.i("CalendarActivity", "**START All Calendar Event Description**");
        i9 = 0;
        int i10 = localCursor1.getColumnCount();
        if (i9 < i10)
          break;
        Log.i("CalendarActivity", "**END All Calendar Event Description**");
      }
      while (localCursor1.moveToNext());
      String[] arrayOfString2 = new String[1];
      arrayOfString2[0] = String.valueOf(paramInt);
      localCursor2 = localContentResolver.query(CalendarContract.Reminders.CONTENT_URI.buildUpon().build(), null, "(event_id = ?) ", arrayOfString2, null);
      Log.i("CalendarActivity", "RemindermanagedCursor = " + localCursor2);
      if ((localCursor2 == null) || (!localCursor2.moveToFirst()))
        break label1855;
      int i2 = localCursor2.getColumnIndex("minutes");
      int i3 = localCursor2.getColumnIndex("method");
      Log.i("CalendarActivity", "Listing Calendar Reminder Details");
      do
      {
        localMap.Put("minutes", localCursor2.getString(i2));
        localMap.Put("method", localCursor2.getString(i3));
        Log.i("CalendarActivity", "**START Calendar Reminder Description**");
        i4 = 0;
        int i5 = localCursor2.getColumnCount();
        if (i4 < i5)
          break;
        Log.i("CalendarActivity", "**END Calendar Reminder Description**");
      }
      while (localCursor2.moveToNext());
      String[] arrayOfString3 = new String[1];
      arrayOfString3[0] = String.valueOf(paramInt);
      localCursor3 = localContentResolver.query(CalendarContract.Attendees.CONTENT_URI.buildUpon().build(), null, "(event_id = ?) ", arrayOfString3, null);
      i = 0;
      if ((localCursor3 == null) || (!localCursor3.moveToFirst()))
        break label1935;
      int j = localCursor3.getColumnIndex("attendeeName");
      int k = localCursor3.getColumnIndex("attendeeEmail");
      int m = localCursor3.getColumnIndex("attendeeStatus");
      Log.i("CalendarActivity", "Listing Calendar Attendees Details");
      label1566: localMap.Put("AttendeeName" + i, localCursor3.getString(j));
      localMap.Put("AttendeeEmail" + i, localCursor3.getString(k));
      localMap.Put("AttendeeStatus" + i, localCursor3.getString(m));
      Log.i("CalendarActivity", "**START Calendar Attendees Description**");
    }
    for (int n = 0; ; n++)
    {
      int i1 = localCursor3.getColumnCount();
      if (n >= i1)
      {
        Log.i("CalendarActivity", "**END Calendar Attendees Description**");
        i++;
        if (localCursor3.moveToNext())
          break label1566;
        return localMap;
        Log.i("CalendarActivity", localCursor1.getColumnName(i9) + "=" + localCursor1.getString(i9));
        i9++;
        break;
        localMap.Put("hasAlarm", null);
        localMap.Put("recurRule", null);
        localMap.Put("duration", null);
        Log.i("CalendarActivity", "No Calendar Entry");
        break label1280;
        Log.i("CalendarActivity", localCursor2.getColumnName(i4) + "=" + localCursor2.getString(i4));
        i4++;
        break label1431;
        label1855: localMap.Put("minutes", null);
        localMap.Put("method", null);
        Log.i("CalendarActivity", "No Calendar Reminder");
        break label1466;
      }
      Log.i("CalendarActivity", localCursor3.getColumnName(n) + "=" + localCursor3.getString(n));
    }
    label1935: localMap.Put("AttendeeName" + 0, null);
    localMap.Put("AttendeeEmail" + 0, null);
    localMap.Put("AttendeeStatus" + 0, null);
    Log.i("CalendarActivity", "No Calendar Attendees");
    return localMap;
  }

  public List ListofEventsWithDescKeywordBetweenDates(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    List localList = new List();
    localList.Initialize();
    if (Build.VERSION.SDK_INT < 14)
    {
      Cursor localCursor2 = getCalendarManagedCursor(null, "calendar_id = " + paramInt, "instances/when/" + paramLong1 + "/" + paramLong2, "dtstart ASC");
      if ((localCursor2 != null) && (localCursor2.moveToFirst()))
      {
        Log.i("CalendarActivity", "Listing Calendar Event Details between dates");
        int i5 = localCursor2.getColumnIndex("title");
        int i6 = localCursor2.getColumnIndex("description");
        int i7 = localCursor2.getColumnIndex("begin");
        int i8 = localCursor2.getColumnIndex("end");
        int i9 = localCursor2.getColumnIndex("eventLocation");
        int i10 = localCursor2.getColumnIndex("allDay");
        int i11 = localCursor2.getColumnIndex("event_id");
        String str9 = localCursor2.getString(i11);
        String str10 = localCursor2.getString(i5);
        String str11 = localCursor2.getString(i6);
        String str12 = localCursor2.getString(i7);
        String str13 = localCursor2.getString(i8);
        String str14 = localCursor2.getString(i9);
        String str15 = localCursor2.getString(i10);
        Log.i("CalendarActivity", "**START Calendar Event Description between dates**");
        Log.i("CalendarActivity", str10 + str11 + str12 + str13 + str14 + str15 + str9);
        if ((str11 != null) && (str11.contains(paramString)))
        {
          localList.Add(str10);
          localList.Add(str11);
          localList.Add(str12);
          localList.Add(str13);
          localList.Add(str14);
          localList.Add(str15);
          localList.Add(str9);
        }
        for (int i12 = 0; ; i12++)
        {
          int i13 = localCursor2.getColumnCount();
          if (i12 >= i13)
          {
            Log.i("CalendarActivity", "**END Calendar Event Description between dates**");
            if (localCursor2.moveToNext())
              break;
            return localList;
          }
          Log.i("CalendarActivity", localCursor2.getColumnName(i12) + "=" + localCursor2.getString(i12));
        }
      }
      Log.i("CalendarActivity", "No events");
      return localList;
    }
    String[] arrayOfString1 = { "title", "description", "dtstart", "dtend", "eventLocation", "allDay", "_id" };
    ContentResolver localContentResolver = this.es_ba.context.getContentResolver();
    String str1 = "((calendar_id = ?)  AND (description LIKE '%" + paramString + "%') AND (" + "begin" + " >= ?) AND ((" + "end" + " <= ?) OR (" + "dtend" + " is null)) )";
    String[] arrayOfString2 = new String[3];
    arrayOfString2[0] = String.valueOf(paramInt);
    arrayOfString2[1] = String.valueOf(paramLong1);
    arrayOfString2[2] = String.valueOf(paramLong2);
    Uri.Builder localBuilder = CalendarContract.Instances.CONTENT_URI.buildUpon();
    ContentUris.appendId(localBuilder, paramLong1);
    ContentUris.appendId(localBuilder, paramLong2);
    Cursor localCursor1 = localContentResolver.query(localBuilder.build(), null, str1, arrayOfString2, "dtstart ASC");
    Log.i("CalendarActivity", "       ********************* START      **************");
    Log.i("CalendarActivity", arrayOfString1 + str1 + arrayOfString2);
    if ((localCursor1 != null) && (localCursor1.moveToFirst()))
    {
      int i = localCursor1.getColumnIndex("title");
      int j = localCursor1.getColumnIndex("description");
      int k = localCursor1.getColumnIndex("begin");
      int m = localCursor1.getColumnIndex("end");
      int n = localCursor1.getColumnIndex("eventLocation");
      int i1 = localCursor1.getColumnIndex("allDay");
      int i2 = localCursor1.getColumnIndex("event_id");
      String str2 = localCursor1.getString(i);
      String str3 = localCursor1.getString(j);
      String str4 = localCursor1.getString(k);
      String str5 = localCursor1.getString(m);
      String str6 = localCursor1.getString(n);
      String str7 = localCursor1.getString(i1);
      String str8 = localCursor1.getString(i2);
      localList.Add(str2);
      localList.Add(str3);
      localList.Add(str4);
      localList.Add(str5);
      localList.Add(str6);
      localList.Add(str7);
      localList.Add(str8);
      Log.i("CalendarActivity", "**START Calendar Event Description between dates**");
      Log.i("CalendarActivity", "                    **********");
      Log.i("CalendarActivity", str2 + str3 + str4 + str5);
      for (int i3 = 0; ; i3++)
      {
        int i4 = localCursor1.getColumnCount();
        if (i3 >= i4)
        {
          Log.i("CalendarActivity", "**END Calendar Event Description between dates**");
          if (localCursor1.moveToNext())
            break;
          Log.i("CalendarActivity", "       *****************     FINISH      **************");
          return localList;
        }
        Log.i("CalendarActivity", localCursor1.getColumnName(i3) + "=" + localCursor1.getString(i3));
      }
    }
    Log.i("CalendarActivity", "************         Error getting events        ***************");
    return localList;
  }

  public List ListofEventsWithTitleKeywordBetweenDates(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    List localList = new List();
    localList.Initialize();
    if (Build.VERSION.SDK_INT < 14)
    {
      Cursor localCursor2 = getCalendarManagedCursor(null, "calendar_id = " + paramInt, "instances/when/" + paramLong1 + "/" + paramLong2, "dtstart ASC");
      if ((localCursor2 != null) && (localCursor2.moveToFirst()))
      {
        Log.i("CalendarActivity", "Listing Calendar Event Details between dates");
        int i5 = localCursor2.getColumnIndex("title");
        int i6 = localCursor2.getColumnIndex("description");
        int i7 = localCursor2.getColumnIndex("begin");
        int i8 = localCursor2.getColumnIndex("end");
        int i9 = localCursor2.getColumnIndex("eventLocation");
        int i10 = localCursor2.getColumnIndex("allDay");
        int i11 = localCursor2.getColumnIndex("event_id");
        String str9 = localCursor2.getString(i11);
        String str10 = localCursor2.getString(i5);
        String str11 = localCursor2.getString(i6);
        String str12 = localCursor2.getString(i7);
        String str13 = localCursor2.getString(i8);
        String str14 = localCursor2.getString(i9);
        String str15 = localCursor2.getString(i10);
        Log.i("CalendarActivity", "**START Calendar Event Description between dates**");
        Log.i("CalendarActivity", str10 + str11 + str12 + str13 + str14 + str15 + str9);
        if ((str10 != null) && (str10.contains(paramString)))
        {
          localList.Add(str10);
          localList.Add(str11);
          localList.Add(str12);
          localList.Add(str13);
          localList.Add(str14);
          localList.Add(str15);
          localList.Add(str9);
        }
        for (int i12 = 0; ; i12++)
        {
          int i13 = localCursor2.getColumnCount();
          if (i12 >= i13)
          {
            Log.i("CalendarActivity", "**END Calendar Event Description between dates**");
            if (localCursor2.moveToNext())
              break;
            return localList;
          }
          Log.i("CalendarActivity", localCursor2.getColumnName(i12) + "=" + localCursor2.getString(i12));
        }
      }
      Log.i("CalendarActivity", "No events");
      return localList;
    }
    String[] arrayOfString1 = { "title", "description", "dtstart", "dtend", "eventLocation", "allDay", "_id" };
    ContentResolver localContentResolver = this.es_ba.context.getContentResolver();
    String str1 = "((calendar_id = ?)  AND (title LIKE '%" + paramString + "%') AND (" + "begin" + " >= ?) AND ((" + "end" + " <= ?) OR (" + "dtend" + " is null)) )";
    String[] arrayOfString2 = new String[3];
    arrayOfString2[0] = String.valueOf(paramInt);
    arrayOfString2[1] = String.valueOf(paramLong1);
    arrayOfString2[2] = String.valueOf(paramLong2);
    Uri.Builder localBuilder = CalendarContract.Instances.CONTENT_URI.buildUpon();
    ContentUris.appendId(localBuilder, paramLong1);
    ContentUris.appendId(localBuilder, paramLong2);
    Cursor localCursor1 = localContentResolver.query(localBuilder.build(), null, str1, arrayOfString2, "dtstart ASC");
    Log.i("CalendarActivity", "       ********************* START      **************");
    Log.i("CalendarActivity", arrayOfString1 + str1 + arrayOfString2);
    if ((localCursor1 != null) && (localCursor1.moveToFirst()))
    {
      int i = localCursor1.getColumnIndex("title");
      int j = localCursor1.getColumnIndex("description");
      int k = localCursor1.getColumnIndex("begin");
      int m = localCursor1.getColumnIndex("end");
      int n = localCursor1.getColumnIndex("eventLocation");
      int i1 = localCursor1.getColumnIndex("allDay");
      int i2 = localCursor1.getColumnIndex("event_id");
      String str2 = localCursor1.getString(i);
      String str3 = localCursor1.getString(j);
      String str4 = localCursor1.getString(k);
      String str5 = localCursor1.getString(m);
      String str6 = localCursor1.getString(n);
      String str7 = localCursor1.getString(i1);
      String str8 = localCursor1.getString(i2);
      localList.Add(str2);
      localList.Add(str3);
      localList.Add(str4);
      localList.Add(str5);
      localList.Add(str6);
      localList.Add(str7);
      localList.Add(str8);
      Log.i("CalendarActivity", "**START Calendar Event Description between dates**");
      Log.i("CalendarActivity", str2 + str3 + str4 + str5);
      for (int i3 = 0; ; i3++)
      {
        int i4 = localCursor1.getColumnCount();
        if (i3 >= i4)
        {
          Log.i("CalendarActivity", "**END Calendar Event Description between dates**");
          Log.i("CalendarActivity", "                  ********");
          if (localCursor1.moveToNext())
            break;
          Log.i("CalendarActivity", "       *****************     FINISH      **************");
          return localList;
        }
        Log.i("CalendarActivity", localCursor1.getColumnName(i3) + "=" + localCursor1.getString(i3));
      }
    }
    Log.i("CalendarActivity", "************         Error getting events        ***************");
    return localList;
  }

  public int UpdateEvent(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    ContentValues localContentValues1 = new ContentValues();
    if (Build.VERSION.SDK_INT < 14)
    {
      if (paramString1 != "")
        localContentValues1.put("title", paramString1);
      if (paramString2 != "")
        localContentValues1.put("description", paramString2);
      if (paramString3 != "")
        localContentValues1.put("eventLocation", paramString3);
      if (paramBoolean)
      {
        localContentValues1.put("dtstart", Long.valueOf(paramLong1));
        localContentValues1.put("dtend", Long.valueOf(paramLong2));
      }
      Uri localUri = ContentUris.withAppendedId(Uri.parse(getCalendarUriBase() + "events"), paramInt);
      return this.es_ba.context.getContentResolver().update(localUri, localContentValues1, null, null);
    }
    ContentResolver localContentResolver = this.es_ba.context.getContentResolver();
    ContentValues localContentValues2 = new ContentValues();
    if (paramString1 != "")
      localContentValues2.put("title", paramString1);
    if (paramString2 != "")
      localContentValues2.put("description", paramString2);
    if (paramString3 != "")
      localContentValues2.put("eventLocation", paramString3);
    if (paramBoolean)
    {
      localContentValues2.put("dtstart", Long.valueOf(paramLong1));
      localContentValues2.put("dtend", Long.valueOf(paramLong2));
    }
    int i = localContentResolver.update(ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, paramInt), localContentValues2, null, null);
    Log.i("CalendarActivity", "Rows updated: " + i);
    return i;
  }

  class EventDetails
  {
    String allday;
    String desc;
    String duration;
    String endtime;
    String eventId;
    String eventTitle;
    String hasAlarm;
    String location;
    String method;
    String minutes;
    String recurrance;
    String starttime;

    EventDetails()
    {
    }
  }

  class EventExtendedDetails
  {
    String AttendeeEmail;
    String AttendeeName;
    String AttendeeStatus;
    String duration;
    String hasAlarm;
    String method;
    String minutes;
    String recurRule;

    EventExtendedDetails()
    {
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     edsmith.calendar.Calendar
 * JD-Core Version:    0.6.2
 */