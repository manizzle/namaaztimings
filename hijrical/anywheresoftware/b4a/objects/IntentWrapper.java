package anywheresoftware.b4a.objects;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;
import java.io.Serializable;
import java.net.URISyntaxException;

@BA.ShortName("Intent")
public class IntentWrapper extends AbsObjectWrapper<Intent>
{
  public static final String ACTION_APPWIDGET_UPDATE = "android.appwidget.action.APPWIDGET_UPDATE";
  public static final String ACTION_CALL = "android.intent.action.CALL";
  public static final String ACTION_EDIT = "android.intent.action.EDIT";
  public static final String ACTION_MAIN = "android.intent.action.MAIN";
  public static final String ACTION_PICK = "android.intent.action.PICK";
  public static final String ACTION_SEND = "android.intent.action.SEND";
  public static final String ACTION_VIEW = "android.intent.action.VIEW";

  public void AddCategory(String paramString)
  {
    ((Intent)getObject()).addCategory(paramString);
  }

  public String ExtrasToString()
  {
    if (!IsInitialized())
      return "not initialized";
    Bundle localBundle = ((Intent)getObject()).getExtras();
    if (localBundle == null)
      return "no extras";
    localBundle.size();
    return localBundle.toString();
  }

  public String GetData()
  {
    return ((Intent)getObject()).getDataString();
  }

  public Object GetExtra(String paramString)
  {
    return ((Intent)getObject()).getSerializableExtra(paramString);
  }

  public boolean HasExtra(String paramString)
  {
    return ((Intent)getObject()).hasExtra(paramString);
  }

  public void Initialize(String paramString1, String paramString2)
  {
    if (paramString2.length() > 0);
    for (Uri localUri = Uri.parse(paramString2); ; localUri = null)
    {
      setObject(new Intent(paramString1, localUri));
      return;
    }
  }

  public void Initialize2(String paramString, int paramInt)
    throws URISyntaxException
  {
    setObject(Intent.parseUri(paramString, paramInt));
  }

  public void PutExtra(String paramString, Object paramObject)
  {
    Intent localIntent = (Intent)getObject();
    if ((paramObject instanceof Serializable))
      localIntent.putExtra(paramString, (Serializable)paramObject);
    while (!(paramObject instanceof Parcelable))
      return;
    localIntent.putExtra(paramString, (Parcelable)paramObject);
  }

  public void SetComponent(String paramString)
  {
    ((Intent)getObject()).setComponent(ComponentName.unflattenFromString(paramString));
  }

  public void SetType(String paramString)
  {
    ((Intent)getObject()).setDataAndType(((Intent)getObject()).getData(), paramString);
  }

  public void WrapAsIntentChooser(String paramString)
  {
    setObject(Intent.createChooser((Intent)getObject(), paramString));
  }

  public String getAction()
  {
    if (((Intent)getObject()).getAction() == null)
      return "";
    return ((Intent)getObject()).getAction();
  }

  public int getFlags()
  {
    return ((Intent)getObject()).getFlags();
  }

  public void setAction(String paramString)
  {
    ((Intent)getObject()).setAction(paramString);
  }

  public void setFlags(int paramInt)
  {
    ((Intent)getObject()).setFlags(paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.IntentWrapper
 * JD-Core Version:    0.6.2
 */