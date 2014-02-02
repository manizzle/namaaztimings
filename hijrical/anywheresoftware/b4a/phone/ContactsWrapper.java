package anywheresoftware.b4a.phone;

import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Contacts.ContactMethods;
import android.provider.Contacts.People;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.objects.collections.List;
import anywheresoftware.b4a.objects.collections.Map;
import anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper;
import anywheresoftware.b4a.objects.streams.File.InputStreamWrapper;
import java.io.InputStream;
import java.util.HashMap;

@BA.ShortName("Contacts")
public class ContactsWrapper
{
  private static final String[] people_projection = { "times_contacted", "number", "last_time_contacted", "display_name", "name", "notes", "starred", "_id" };

  private List getAllContacts(String paramString, String[] paramArrayOfString)
  {
    Cursor localCursor = BA.applicationContext.getContentResolver().query(Contacts.People.CONTENT_URI, people_projection, paramString, paramArrayOfString, null);
    List localList = new List();
    localList.Initialize();
    HashMap localHashMap = new HashMap();
    for (int i = 0; ; i++)
    {
      if (i >= localCursor.getColumnCount())
      {
        if (localCursor.moveToNext())
          break;
        localCursor.close();
        return localList;
      }
      localHashMap.put(localCursor.getColumnName(i), Integer.valueOf(i));
    }
    String str1 = localCursor.getString(((Integer)localHashMap.get("display_name")).intValue());
    String str2 = localCursor.getString(((Integer)localHashMap.get("number")).intValue());
    if (localCursor.getInt(((Integer)localHashMap.get("starred")).intValue()) > 0);
    for (boolean bool = true; ; bool = false)
    {
      localList.Add(new Contact(str1, str2, bool, localCursor.getInt(((Integer)localHashMap.get("_id")).intValue()), localCursor.getString(((Integer)localHashMap.get("notes")).intValue()), localCursor.getInt(((Integer)localHashMap.get("times_contacted")).intValue()), localCursor.getLong(((Integer)localHashMap.get("last_time_contacted")).intValue()), localCursor.getString(((Integer)localHashMap.get("name")).intValue())));
      break;
    }
  }

  public List FindByMail(String paramString, boolean paramBoolean)
  {
    ContentResolver localContentResolver = BA.applicationContext.getContentResolver();
    String str1;
    String str2;
    Cursor localCursor;
    StringBuilder localStringBuilder;
    if (!paramBoolean)
    {
      str1 = " LIKE ?";
      str2 = "%" + paramString + "%";
      localCursor = localContentResolver.query(Contacts.ContactMethods.CONTENT_EMAIL_URI, new String[] { "person", "data" }, "data" + str1, new String[] { str2 }, null);
      localStringBuilder = new StringBuilder();
    }
    while (true)
    {
      if (!localCursor.moveToNext())
      {
        int j = localCursor.getCount();
        localCursor.close();
        if (j != 0)
          break label195;
        List localList = new List();
        localList.Initialize();
        return localList;
        str1 = " = ?";
        str2 = paramString;
        break;
      }
      for (int i = 0; i < localCursor.getColumnCount(); i++)
        localStringBuilder.append(localCursor.getString(0)).append(",");
    }
    label195: localStringBuilder.setLength(localStringBuilder.length() - 1);
    return getAllContacts("_id IN (" + localStringBuilder.toString() + ")", null);
  }

  public List FindByName(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      String[] arrayOfString = new String[1];
      arrayOfString[0] = ("%" + paramString + "%");
      return getAllContacts("name LIKE ?", arrayOfString);
    }
    return getAllContacts("name = ?", new String[] { paramString });
  }

  public List GetAll()
  {
    return getAllContacts(null, null);
  }

  public Contact GetById(int paramInt)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramInt);
    List localList = getAllContacts("_id = ?", arrayOfString);
    if (localList.getSize() == 0)
      return null;
    return (Contact)localList.Get(0);
  }

  @BA.ShortName("Contact")
  public static class Contact
  {
    public static final int EMAIL_CUSTOM = 0;
    public static final int EMAIL_HOME = 1;
    public static final int EMAIL_MOBILE = 4;
    public static final int EMAIL_OTHER = 3;
    public static final int EMAIL_WORK = 2;
    public static final int PHONE_CUSTOM = 0;
    public static final int PHONE_FAX_HOME = 5;
    public static final int PHONE_FAX_WORK = 4;
    public static final int PHONE_HOME = 1;
    public static final int PHONE_MOBILE = 2;
    public static final int PHONE_OTHER = 7;
    public static final int PHONE_PAGER = 6;
    public static final int PHONE_WORK = 3;
    public String DisplayName;
    public int Id = -1;
    public long LastTimeContacted;
    public String Name;
    public String Notes;
    public String PhoneNumber = "";
    public boolean Starred;
    public int TimesContacted;

    public Contact()
    {
    }

    Contact(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, String paramString3, int paramInt2, long paramLong, String paramString4)
    {
      String str1;
      String str2;
      label37: String str3;
      if (paramString1 == null)
      {
        str1 = "";
        this.DisplayName = str1;
        if (paramString2 != null)
          break label103;
        str2 = "";
        this.PhoneNumber = str2;
        this.Starred = paramBoolean;
        this.Id = paramInt1;
        if (paramString3 != null)
          break label109;
        str3 = "";
        label63: this.Notes = str3;
        this.TimesContacted = paramInt2;
        this.LastTimeContacted = paramLong;
        if (paramString4 != null)
          break label116;
      }
      label103: label109: label116: for (String str4 = ""; ; str4 = paramString4)
      {
        this.Name = str4;
        return;
        str1 = paramString1;
        break;
        str2 = paramString2;
        break label37;
        str3 = paramString3;
        break label63;
      }
    }

    public Map GetEmails()
    {
      if (this.Id == -1)
        throw new RuntimeException("Contact object should be set by calling one of the Contacts methods.");
      Uri localUri = Uri.withAppendedPath(ContentUris.withAppendedId(Contacts.People.CONTENT_URI, this.Id), "contact_methods");
      Cursor localCursor = BA.applicationContext.getContentResolver().query(localUri, new String[] { "data", "type", "kind" }, "kind = 1", null, null);
      Map localMap = new Map();
      localMap.Initialize();
      while (true)
      {
        if (!localCursor.moveToNext())
        {
          localCursor.close();
          return localMap;
        }
        localMap.Put(localCursor.getString(0), Integer.valueOf(localCursor.getInt(1)));
      }
    }

    public Map GetPhones()
    {
      if (this.Id == -1)
        throw new RuntimeException("Contact object should be set by calling one of the Contacts methods.");
      Uri localUri = Uri.withAppendedPath(ContentUris.withAppendedId(Contacts.People.CONTENT_URI, this.Id), "phones");
      Cursor localCursor = BA.applicationContext.getContentResolver().query(localUri, new String[] { "number", "type" }, null, null, null);
      Map localMap = new Map();
      localMap.Initialize();
      while (true)
      {
        if (!localCursor.moveToNext())
        {
          localCursor.close();
          return localMap;
        }
        localMap.Put(localCursor.getString(0), Integer.valueOf(localCursor.getInt(1)));
      }
    }

    public CanvasWrapper.BitmapWrapper GetPhoto()
    {
      if (this.Id == -1)
        throw new RuntimeException("Contact object should be set by calling one of the Contacts methods.");
      Uri localUri = Uri.withAppendedPath(ContentUris.withAppendedId(Contacts.People.CONTENT_URI, this.Id), "photo");
      Cursor localCursor = BA.applicationContext.getContentResolver().query(localUri, new String[] { "data" }, null, null, null);
      boolean bool = localCursor.moveToNext();
      CanvasWrapper.BitmapWrapper localBitmapWrapper = null;
      if (bool)
      {
        byte[] arrayOfByte = localCursor.getBlob(0);
        localBitmapWrapper = null;
        if (arrayOfByte != null)
        {
          File.InputStreamWrapper localInputStreamWrapper = new File.InputStreamWrapper();
          localInputStreamWrapper.InitializeFromBytesArray(arrayOfByte, 0, arrayOfByte.length);
          localBitmapWrapper = new CanvasWrapper.BitmapWrapper();
          localBitmapWrapper.Initialize2((InputStream)localInputStreamWrapper.getObject());
        }
      }
      localCursor.close();
      return localBitmapWrapper;
    }

    @BA.Hide
    public String toString()
    {
      return "DisplayName=" + this.DisplayName + ", PhoneNumber=" + this.PhoneNumber + ", Starred=" + this.Starred + ", Id=" + this.Id + ", Notes=" + this.Notes + ", TimesContacted=" + this.TimesContacted + ", LastTimeContacted=" + this.LastTimeContacted + ", Name=" + this.Name;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.phone.ContactsWrapper
 * JD-Core Version:    0.6.2
 */