package anywheresoftware.b4a.phone;

import android.app.Application;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.objects.collections.List;
import java.util.HashMap;

@BA.ShortName("SmsMessages")
public class SmsWrapper
{
  public static final int TYPE_DRAFT = 3;
  public static final int TYPE_FAILED = 5;
  public static final int TYPE_INBOX = 1;
  public static final int TYPE_OUTBOX = 4;
  public static final int TYPE_QUEUED = 6;
  public static final int TYPE_SENT = 2;
  public static final int TYPE_UNKNOWN;
  private static final String[] projection = { "_id", "thread_id", "address", "read", "type", "body", "person", "date" };

  private List get(String paramString, String[] paramArrayOfString)
  {
    Cursor localCursor = BA.applicationContext.getContentResolver().query(Uri.parse("content://sms"), projection, paramString, paramArrayOfString, "date DESC");
    HashMap localHashMap = new HashMap();
    List localList;
    for (int i = 0; ; i++)
    {
      if (i >= localCursor.getColumnCount())
      {
        localList = new List();
        localList.Initialize();
        if (localCursor.moveToNext())
          break;
        localCursor.close();
        return localList;
      }
      localHashMap.put(localCursor.getColumnName(i), Integer.valueOf(i));
    }
    String str = localCursor.getString(((Integer)localHashMap.get("person")).intValue());
    int j = localCursor.getInt(((Integer)localHashMap.get("_id")).intValue());
    int k = localCursor.getInt(((Integer)localHashMap.get("thread_id")).intValue());
    int m;
    label173: long l;
    if (str == null)
    {
      m = -1;
      l = localCursor.getLong(((Integer)localHashMap.get("date")).intValue());
      if (localCursor.getInt(((Integer)localHashMap.get("read")).intValue()) <= 0)
        break label311;
    }
    label311: for (boolean bool = true; ; bool = false)
    {
      localList.Add(new Sms(j, k, m, l, bool, localCursor.getInt(((Integer)localHashMap.get("type")).intValue()), localCursor.getString(((Integer)localHashMap.get("body")).intValue()), localCursor.getString(((Integer)localHashMap.get("address")).intValue())));
      break;
      m = Integer.parseInt(str);
      break label173;
    }
  }

  public List GetAll()
  {
    return get(null, null);
  }

  public List GetAllSince(long paramLong)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramLong);
    return get("date >= ?", arrayOfString);
  }

  public List GetBetweenDates(long paramLong1, long paramLong2)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = String.valueOf(paramLong1);
    arrayOfString[1] = String.valueOf(paramLong2);
    return get("date >= ? AND date < ?", arrayOfString);
  }

  public List GetByMessageId(int paramInt)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramInt);
    return get("_id = ?", arrayOfString);
  }

  public List GetByPersonId(int paramInt)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramInt);
    return get("person = ?", arrayOfString);
  }

  public List GetByThreadId(int paramInt)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramInt);
    return get("thread_id = ?", arrayOfString);
  }

  public List GetByType(int paramInt)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramInt);
    return get("type = ?", arrayOfString);
  }

  public List GetUnreadMessages()
  {
    return get("read = 0", null);
  }

  @BA.ShortName("Sms")
  public static class Sms
  {
    public String Address;
    public String Body;
    public long Date;
    public int Id;
    public int PersonId;
    public boolean Read;
    public int ThreadId;
    public int Type;

    public Sms()
    {
    }

    @BA.Hide
    public Sms(int paramInt1, int paramInt2, int paramInt3, long paramLong, boolean paramBoolean, int paramInt4, String paramString1, String paramString2)
    {
      this.Id = paramInt1;
      this.ThreadId = paramInt2;
      this.PersonId = paramInt3;
      this.Date = paramLong;
      this.Read = paramBoolean;
      this.Type = paramInt4;
      this.Body = paramString1;
      this.Address = paramString2;
    }

    @BA.Hide
    public String toString()
    {
      return "Id=" + this.Id + ", ThreadId=" + this.ThreadId + ", PersonId=" + this.PersonId + ", Date=" + this.Date + ", Read=" + this.Read + ", Type=" + this.Type + ", Body=" + this.Body + ", Address=" + this.Address;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.phone.SmsWrapper
 * JD-Core Version:    0.6.2
 */