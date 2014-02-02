package anywheresoftware.b4a.objects;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.keywords.Common;

@BA.ShortName("Notification")
public class NotificationWrapper extends AbsObjectWrapper<Notification>
{
  private static int pendingId = 1;

  private void setFlag(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      Notification localNotification2 = (Notification)getObject();
      localNotification2.flags = (paramInt | localNotification2.flags);
      return;
    }
    Notification localNotification1 = (Notification)getObject();
    localNotification1.flags &= (paramInt ^ 0xFFFFFFFF);
  }

  private void setValue(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      Notification localNotification2 = (Notification)getObject();
      localNotification2.defaults = (paramInt | localNotification2.defaults);
      return;
    }
    Notification localNotification1 = (Notification)getObject();
    localNotification1.defaults &= (paramInt ^ 0xFFFFFFFF);
  }

  public void Cancel(int paramInt)
  {
    ((NotificationManager)BA.applicationContext.getSystemService("notification")).cancel(paramInt);
  }

  public void Initialize()
  {
    setObject(new Notification());
    Notification localNotification = (Notification)getObject();
    localNotification.defaults = (0xFFFFFFFF | localNotification.defaults);
  }

  public void Notify(int paramInt)
  {
    ((NotificationManager)BA.applicationContext.getSystemService("notification")).notify(paramInt, (Notification)getObject());
  }

  public void SetInfo(BA paramBA, String paramString1, String paramString2, Object paramObject)
    throws ClassNotFoundException
  {
    SetInfo2(paramBA, paramString1, paramString2, null, paramObject);
  }

  public void SetInfo2(BA paramBA, String paramString1, String paramString2, String paramString3, Object paramObject)
    throws ClassNotFoundException
  {
    ((Notification)getObject()).when = System.currentTimeMillis();
    Intent localIntent = Common.getComponentIntent(paramBA, paramObject);
    localIntent.addFlags(268435456);
    localIntent.addFlags(131072);
    if (paramString3 != null)
      localIntent.putExtra("Notification_Tag", paramString3);
    Context localContext = paramBA.context;
    int i;
    if (paramString3 == null)
      i = 0;
    while (true)
    {
      PendingIntent localPendingIntent = PendingIntent.getActivity(localContext, i, localIntent, 134217728);
      ((Notification)getObject()).setLatestEventInfo(paramBA.context, paramString1, paramString2, localPendingIntent);
      return;
      i = pendingId;
      pendingId = i + 1;
    }
  }

  public int getNumber()
  {
    return ((Notification)getObject()).number;
  }

  public void setAutoCancel(boolean paramBoolean)
  {
    setFlag(paramBoolean, 16);
  }

  public void setIcon(String paramString)
  {
    ((Notification)getObject()).icon = BA.applicationContext.getResources().getIdentifier(paramString, "drawable", BA.packageName);
  }

  public void setInsistent(boolean paramBoolean)
  {
    setFlag(paramBoolean, 4);
  }

  public void setLight(boolean paramBoolean)
  {
    setValue(paramBoolean, 4);
  }

  public void setNumber(int paramInt)
  {
    ((Notification)getObject()).number = paramInt;
  }

  public void setOnGoingEvent(boolean paramBoolean)
  {
    setFlag(paramBoolean, 2);
  }

  public void setSound(boolean paramBoolean)
  {
    setValue(paramBoolean, 1);
  }

  public void setVibrate(boolean paramBoolean)
  {
    setValue(paramBoolean, 2);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.NotificationWrapper
 * JD-Core Version:    0.6.2
 */