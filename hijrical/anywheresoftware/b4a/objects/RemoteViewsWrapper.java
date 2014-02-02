package anywheresoftware.b4a.objects;

import android.app.Application;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Parcel;
import android.widget.RemoteViews;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.B4ARunnable;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.ConnectorUtils;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.keywords.LayoutValues;
import java.io.DataInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;

@BA.ShortName("RemoteViews")
public class RemoteViewsWrapper
{
  protected RemoteViews current;
  protected String eventName;
  protected Parcel original;

  @BA.Hide
  public static RemoteViewsWrapper createRemoteViews(BA paramBA, int paramInt, String paramString1, String paramString2)
    throws Exception
  {
    RemoteViews localRemoteViews = new RemoteViews(BA.packageName, paramInt);
    String str = paramString1.toLowerCase(BA.cul);
    if (!str.endsWith(".bal"))
      str = str + ".bal";
    InputStream localInputStream = BA.applicationContext.getAssets().open(str);
    DataInputStream localDataInputStream = new DataInputStream(localInputStream);
    int i = ConnectorUtils.readInt(localDataInputStream);
    int j = ConnectorUtils.readInt(localDataInputStream);
    String[] arrayOfString;
    int n;
    label122: int k;
    if (j <= 0)
    {
      arrayOfString = (String[])null;
      if (i >= 3)
      {
        arrayOfString = new String[ConnectorUtils.readInt(localDataInputStream)];
        n = 0;
        if (n < arrayOfString.length)
          break label226;
      }
      k = ConnectorUtils.readInt(localDataInputStream);
    }
    for (int m = 0; ; m++)
    {
      if (m >= k)
      {
        loadLayoutHelper(paramBA, ConnectorUtils.readMap(localDataInputStream, arrayOfString), localRemoteViews);
        localDataInputStream.close();
        RemoteViewsWrapper localRemoteViewsWrapper = new RemoteViewsWrapper();
        localRemoteViewsWrapper.original = Parcel.obtain();
        localRemoteViews.writeToParcel(localRemoteViewsWrapper.original, 0);
        localRemoteViewsWrapper.eventName = paramString2.toLowerCase(BA.cul);
        return localRemoteViewsWrapper;
        j = (int)(j - localInputStream.skip(j));
        break;
        label226: arrayOfString[n] = ConnectorUtils.readString(localDataInputStream);
        n++;
        break label122;
      }
      LayoutValues.readFromStream(localDataInputStream);
    }
  }

  protected static int getIdForView(BA paramBA, String paramString)
  {
    try
    {
      int i = Class.forName(BA.packageName + ".R$id").getField(paramBA.getClassNameWithoutPackage() + "_" + paramString.toLowerCase(BA.cul)).getInt(null);
      return i;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  private static void loadLayoutHelper(BA paramBA, HashMap<String, Object> paramHashMap, RemoteViews paramRemoteViews)
    throws Exception
  {
    String str1 = ((String)paramHashMap.get("eventName")).toLowerCase(BA.cul);
    String str2 = ((String)paramHashMap.get("name")).toLowerCase(BA.cul);
    HashMap localHashMap = (HashMap)paramHashMap.get(":kids");
    if (localHashMap != null);
    for (int j = 0; ; j++)
    {
      if (j >= localHashMap.size())
      {
        if (paramBA.htSubs.containsKey(str1 + "_click"))
        {
          Intent localIntent = Common.getComponentIntent(paramBA, null);
          localIntent.putExtra("b4a_internal_event", str1 + "_click");
          int i = getIdForView(paramBA, str2);
          paramRemoteViews.setOnClickPendingIntent(i, PendingIntent.getService(paramBA.context, i, localIntent, 134217728));
        }
        return;
      }
      loadLayoutHelper(paramBA, (HashMap)localHashMap.get(String.valueOf(j)), paramRemoteViews);
    }
  }

  private void raiseEventWithDebuggingSupport(final BA paramBA, final String paramString)
  {
    if (BA.debugMode)
    {
      BA.handler.post(new BA.B4ARunnable()
      {
        public void run()
        {
          paramBA.raiseEvent(this, paramString, new Object[0]);
        }
      });
      return;
    }
    paramBA.raiseEvent(this, paramString, new Object[0]);
  }

  public boolean HandleWidgetEvents(BA paramBA, Intent paramIntent)
  {
    if (paramIntent == null)
      return false;
    if (paramIntent.hasExtra("b4a_internal_event"))
    {
      raiseEventWithDebuggingSupport(paramBA, paramIntent.getStringExtra("b4a_internal_event"));
      return true;
    }
    if ("android.appwidget.action.APPWIDGET_UPDATE".equals(paramIntent.getAction()))
    {
      raiseEventWithDebuggingSupport(paramBA, this.eventName + "_requestupdate");
      return true;
    }
    if ("android.appwidget.action.APPWIDGET_DISABLED".equals(paramIntent.getAction()))
    {
      raiseEventWithDebuggingSupport(paramBA, this.eventName + "_disabled");
      return true;
    }
    return false;
  }

  public void SetImage(BA paramBA, String paramString, Bitmap paramBitmap)
  {
    checkNull();
    this.current.setImageViewBitmap(getIdForView(paramBA, paramString), paramBitmap);
  }

  public void SetProgress(BA paramBA, String paramString, int paramInt)
  {
    checkNull();
    this.current.setInt(getIdForView(paramBA, paramString), "setProgress", paramInt);
  }

  public void SetText(BA paramBA, String paramString1, String paramString2)
  {
    checkNull();
    this.current.setTextViewText(getIdForView(paramBA, paramString1), paramString2);
  }

  public void SetTextColor(BA paramBA, String paramString, int paramInt)
  {
    checkNull();
    this.current.setTextColor(getIdForView(paramBA, paramString), paramInt);
  }

  public void SetTextSize(BA paramBA, String paramString, float paramFloat)
  {
    checkNull();
    this.current.setFloat(getIdForView(paramBA, paramString), "setTextSize", paramFloat);
  }

  public void SetVisible(BA paramBA, String paramString, boolean paramBoolean)
  {
    checkNull();
    RemoteViews localRemoteViews = this.current;
    int i = getIdForView(paramBA, paramString);
    if (paramBoolean);
    for (int j = 0; ; j = 4)
    {
      localRemoteViews.setViewVisibility(i, j);
      return;
    }
  }

  public void UpdateWidget(BA paramBA)
    throws ClassNotFoundException
  {
    checkNull();
    ComponentName localComponentName = new ComponentName(paramBA.context, Class.forName(paramBA.className + "$" + paramBA.getClassNameWithoutPackage() + "_BR"));
    AppWidgetManager.getInstance(paramBA.context).updateAppWidget(localComponentName, this.current);
    this.current = null;
  }

  protected void checkNull()
  {
    if (this.original == null)
      throw new RuntimeException("RemoteViews should be set by calling ConfigureHomeWidget.");
    if (this.current == null)
    {
      this.original.setDataPosition(0);
      this.current = new RemoteViews(this.original);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.RemoteViewsWrapper
 * JD-Core Version:    0.6.2
 */