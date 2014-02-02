package anywheresoftware.b4a.phone;

import android.app.Application;
import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.objects.collections.List;
import anywheresoftware.b4a.objects.collections.Map;
import anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper;
import java.io.ByteArrayInputStream;
import java.util.HashMap;

@BA.ShortName("Contacts2")
public class Contacts2Wrapper
{
  private static final String[] people_projection = { "times_contacted", "last_time_contacted", "display_name", "has_phone_number", "starred", "_id", "photo_id" };
  private static final String[] phone_projection = { "is_primary", "data1", "contact_id" };

  private List getAllContacts(String paramString, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Cursor localCursor1 = BA.applicationContext.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, people_projection, paramString, paramArrayOfString, null);
    List localList = new List();
    localList.Initialize();
    HashMap localHashMap = new HashMap();
    for (int i = 0; ; i++)
    {
      if (i >= localCursor1.getColumnCount())
      {
        if (localCursor1.moveToNext())
          break;
        localCursor1.close();
        return localList;
      }
      localHashMap.put(localCursor1.getColumnName(i), Integer.valueOf(i));
    }
    String str1 = "";
    int j = localCursor1.getInt(((Integer)localHashMap.get("_id")).intValue());
    Cursor localCursor3;
    label193: label203: Cursor localCursor2;
    String str2;
    if ((paramBoolean1) && (localCursor1.getInt(((Integer)localHashMap.get("has_phone_number")).intValue()) != 0))
    {
      localCursor3 = BA.applicationContext.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, phone_projection, "contact_id = " + j, null, null);
      if (!localCursor3.moveToNext())
        localCursor3.close();
    }
    else
    {
      if (!paramBoolean2)
        break label529;
      localCursor2 = BA.applicationContext.getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[] { "data1" }, "contact_id = " + j + " AND " + "mimetype" + " = ?", new String[] { "vnd.android.cursor.item/note" }, null);
      str2 = "";
      label284: if (localCursor2.moveToNext())
        break label510;
      localCursor2.close();
    }
    while (true)
    {
      String str3 = localCursor1.getString(((Integer)localHashMap.get("display_name")).intValue());
      if (localCursor1.getInt(((Integer)localHashMap.get("starred")).intValue()) > 0);
      for (boolean bool = true; ; bool = false)
      {
        int k = localCursor1.getInt(((Integer)localHashMap.get("times_contacted")).intValue());
        long l = localCursor1.getLong(((Integer)localHashMap.get("last_time_contacted")).intValue());
        String str4 = localCursor1.getString(((Integer)localHashMap.get("display_name")).intValue());
        int m = localCursor1.getInt(((Integer)localHashMap.get("photo_id")).intValue());
        localList.Add(new Contact2(str3, str1, bool, j, str2, k, l, str4, m));
        break;
        str1 = localCursor3.getString(localCursor3.getColumnIndex("data1"));
        if (localCursor3.getInt(localCursor3.getColumnIndex("is_primary")) == 0)
          break label193;
        break label203;
        label510: str2 = localCursor2.getString(0);
        break label284;
      }
      label529: str2 = "";
    }
  }

  public List FindByMail(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ContentResolver localContentResolver = BA.applicationContext.getContentResolver();
    String str1;
    String str2;
    Cursor localCursor;
    StringBuilder localStringBuilder;
    if (!paramBoolean1)
    {
      str1 = " LIKE ?";
      str2 = "%" + paramString + "%";
      localCursor = localContentResolver.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, new String[] { "contact_id" }, "data1" + str1, new String[] { str2 }, null);
      localStringBuilder = new StringBuilder();
    }
    while (true)
    {
      if (!localCursor.moveToNext())
      {
        int j = localCursor.getCount();
        localCursor.close();
        if (j != 0)
          break label192;
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
    label192: localStringBuilder.setLength(localStringBuilder.length() - 1);
    return getAllContacts("_id IN (" + localStringBuilder.toString() + ")", null, paramBoolean2, paramBoolean3);
  }

  public List FindByName(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!paramBoolean1)
    {
      String[] arrayOfString = new String[1];
      arrayOfString[0] = ("%" + paramString + "%");
      return getAllContacts("display_name LIKE ?", arrayOfString, paramBoolean2, paramBoolean3);
    }
    return getAllContacts("display_name = ?", new String[] { paramString }, paramBoolean2, paramBoolean3);
  }

  public List GetAll(boolean paramBoolean1, boolean paramBoolean2)
  {
    return getAllContacts(null, null, paramBoolean1, paramBoolean2);
  }

  public ContactsWrapper.Contact GetById(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramInt);
    List localList = getAllContacts("_id = ?", arrayOfString, paramBoolean1, paramBoolean2);
    if (localList.getSize() == 0)
      return null;
    return (ContactsWrapper.Contact)localList.Get(0);
  }

  public void GetContactsAsync(final BA paramBA, final String paramString1, final String paramString2, final String[] paramArrayOfString, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    BA.submitRunnable(new Runnable()
    {
      public void run()
      {
        List localList = Contacts2Wrapper.this.GetContactsByQuery(paramString2, paramArrayOfString, paramBoolean1, paramBoolean2);
        paramBA.raiseEventFromDifferentThread(this, this, 0, paramString1.toLowerCase(BA.cul) + "_complete", true, new Object[] { localList });
      }
    }
    , this, 0);
  }

  public List GetContactsByQuery(String paramString, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramString.length() == 0);
    for (String str = null; ; str = paramString)
      return getAllContacts(str, paramArrayOfString, paramBoolean1, paramBoolean2);
  }

  protected static class Contact2 extends ContactsWrapper.Contact
  {
    private int photoId;

    Contact2(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, String paramString3, int paramInt2, long paramLong, String paramString4, int paramInt3)
    {
      super(paramString2, paramBoolean, paramInt1, paramString3, paramInt2, paramLong, paramString4);
      this.photoId = paramInt3;
    }

    public Map GetEmails()
    {
      Cursor localCursor = BA.applicationContext.getContentResolver().query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, new String[] { "data1", "data2" }, "contact_id = " + this.Id, null, null);
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
      Cursor localCursor = BA.applicationContext.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[] { "data1", "data2" }, "contact_id = " + this.Id, null, null);
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
      Cursor localCursor = BA.applicationContext.getContentResolver().query(ContactsContract.Data.CONTENT_URI, null, "_id=" + this.photoId, null, null);
      boolean bool = localCursor.moveToNext();
      CanvasWrapper.BitmapWrapper localBitmapWrapper = null;
      if (bool)
      {
        byte[] arrayOfByte = localCursor.getBlob(localCursor.getColumnIndex("data15"));
        localBitmapWrapper = null;
        if (arrayOfByte != null)
        {
          localBitmapWrapper = new CanvasWrapper.BitmapWrapper();
          localBitmapWrapper.Initialize2(new ByteArrayInputStream(arrayOfByte));
        }
      }
      localCursor.close();
      return localBitmapWrapper;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.phone.Contacts2Wrapper
 * JD-Core Version:    0.6.2
 */