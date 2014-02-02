package anywheresoftware.b4a.phone;

import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.provider.MediaStore.Audio.Media;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.IOnActivityResult;
import java.io.File;

@BA.ShortName("RingtoneManager")
public class RingtoneManagerWrapper
{
  public static final int TYPE_ALARM = 4;
  public static final int TYPE_NOTIFICATION = 2;
  public static final int TYPE_RINGTONE = 1;
  private IOnActivityResult ion;

  public String AddToMediaStore(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    File localFile = new File(paramString1, paramString2);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("_data", localFile.getAbsolutePath());
    localContentValues.put("title", paramString3);
    localContentValues.put("mime_type", "audio/*");
    localContentValues.put("is_ringtone", Boolean.valueOf(paramBoolean3));
    localContentValues.put("is_notification", Boolean.valueOf(paramBoolean2));
    localContentValues.put("is_alarm", Boolean.valueOf(paramBoolean1));
    localContentValues.put("is_music", Boolean.valueOf(paramBoolean4));
    return BA.applicationContext.getContentResolver().insert(MediaStore.Audio.Media.getContentUriForPath(localFile.getAbsolutePath()), localContentValues).toString();
  }

  public void DeleteRingtone(String paramString)
  {
    BA.applicationContext.getContentResolver().delete(Uri.parse(paramString), null, null);
  }

  public String GetContentDir()
  {
    return "ContentDir";
  }

  public String GetDefault(int paramInt)
  {
    Uri localUri = RingtoneManager.getDefaultUri(paramInt);
    if (localUri == null)
      return "";
    return localUri.toString();
  }

  public void SetDefault(int paramInt, String paramString)
  {
    RingtoneManager.setActualDefaultRingtoneUri(BA.applicationContext, paramInt, Uri.parse(paramString));
  }

  public void ShowRingtonePicker(final BA paramBA, String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    final String str = paramString1.toLowerCase(BA.cul);
    Intent localIntent = new Intent("android.intent.action.RINGTONE_PICKER");
    localIntent.putExtra("android.intent.extra.ringtone.TYPE", paramInt);
    localIntent.putExtra("android.intent.extra.ringtone.SHOW_SILENT", paramBoolean);
    if (paramString2.length() > 0)
      localIntent.putExtra("android.intent.extra.ringtone.EXISTING_URI", Uri.parse(paramString2));
    this.ion = new IOnActivityResult()
    {
      public void ResultArrived(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        String str1 = null;
        Uri localUri;
        if (paramAnonymousInt == -1)
        {
          str1 = null;
          if (paramAnonymousIntent != null)
          {
            localUri = (Uri)paramAnonymousIntent.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI");
            if (localUri != null)
              break label112;
          }
        }
        label112: for (str1 = ""; ; str1 = localUri.toString())
        {
          RingtoneManagerWrapper.this.ion = null;
          if (str1 == null)
            break;
          BA localBA2 = paramBA;
          RingtoneManagerWrapper localRingtoneManagerWrapper2 = RingtoneManagerWrapper.this;
          String str3 = str + "_pickerresult";
          Object[] arrayOfObject2 = new Object[2];
          arrayOfObject2[0] = Boolean.valueOf(true);
          arrayOfObject2[1] = str1;
          localBA2.raiseEvent(localRingtoneManagerWrapper2, str3, arrayOfObject2);
          return;
        }
        BA localBA1 = paramBA;
        RingtoneManagerWrapper localRingtoneManagerWrapper1 = RingtoneManagerWrapper.this;
        String str2 = str + "_pickerresult";
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = Boolean.valueOf(false);
        arrayOfObject1[1] = "";
        localBA1.raiseEvent(localRingtoneManagerWrapper1, str2, arrayOfObject1);
      }
    };
    paramBA.startActivityForResult(this.ion, localIntent);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.phone.RingtoneManagerWrapper
 * JD-Core Version:    0.6.2
 */