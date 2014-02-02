package anywheresoftware.b4a.phone;

import android.app.Application;
import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.CallLog.Calls;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.objects.collections.List;
import java.util.HashMap;

@BA.ShortName("CallLog")
public class CallLogWrapper
{
  private static final String[] calls_projection = { "date", "type", "duration", "number", "_id", "name" };

  private List getAllCalls(String paramString, String[] paramArrayOfString, int paramInt)
  {
    Cursor localCursor = BA.applicationContext.getContentResolver().query(CallLog.Calls.CONTENT_URI, calls_projection, paramString, paramArrayOfString, "date DESC");
    List localList = new List();
    localList.Initialize();
    HashMap localHashMap = new HashMap();
    int i = 0;
    int j;
    if (i >= localCursor.getColumnCount())
    {
      j = 0;
      label62: if (localCursor.moveToNext())
        break label108;
    }
    while (true)
    {
      localCursor.close();
      return localList;
      localHashMap.put(localCursor.getColumnName(i), Integer.valueOf(i));
      i++;
      break;
      label108: localList.Add(new CallItem(localCursor.getString(((Integer)localHashMap.get("number")).intValue()), localCursor.getInt(((Integer)localHashMap.get("_id")).intValue()), localCursor.getLong(((Integer)localHashMap.get("duration")).intValue()), localCursor.getInt(((Integer)localHashMap.get("type")).intValue()), localCursor.getLong(((Integer)localHashMap.get("date")).intValue()), localCursor.getString(((Integer)localHashMap.get("name")).intValue())));
      if (paramInt <= 0)
        break label62;
      j++;
      if (j < paramInt)
        break label62;
    }
  }

  public List GetAll(int paramInt)
  {
    return getAllCalls(null, null, paramInt);
  }

  public CallItem GetById(int paramInt)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramInt);
    List localList = getAllCalls("_id = ?", arrayOfString, 0);
    if (localList.getSize() == 0)
      return null;
    return (CallItem)localList.Get(0);
  }

  public List GetSince(long paramLong, int paramInt)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = Long.toString(paramLong);
    return getAllCalls("date >= ?", arrayOfString, paramInt);
  }

  @BA.ShortName("CallItem")
  public static class CallItem
  {
    public static final int TYPE_INCOMING = 1;
    public static final int TYPE_MISSED = 3;
    public static final int TYPE_OUTGOING = 2;
    public String CachedName = "";
    public int CallType;
    public long Date;
    public long Duration;
    public int Id = -1;
    public String Number;

    public CallItem()
    {
    }

    CallItem(String paramString1, int paramInt1, long paramLong1, int paramInt2, long paramLong2, String paramString2)
    {
      String str1;
      if (paramString1 == null)
      {
        str1 = "";
        this.Number = str1;
        this.Id = paramInt1;
        this.CallType = paramInt2;
        this.Duration = paramLong1;
        this.Date = paramLong2;
        if (paramString2 != null)
          break label73;
      }
      label73: for (String str2 = ""; ; str2 = paramString2)
      {
        this.CachedName = str2;
        return;
        str1 = paramString1;
        break;
      }
    }

    @BA.Hide
    public String toString()
    {
      return "Id=" + this.Id + ", Number=" + this.Number + ",CachedName=" + this.CachedName + ", Type=" + this.CallType + ", Date=" + this.Date + ", Duration=" + this.Duration;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.phone.CallLogWrapper
 * JD-Core Version:    0.6.2
 */