package barxdroid.NotificationBuilder;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.NotificationCompat.Style;
import android.support.v4.app.TaskStackBuilder;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import anywheresoftware.b4a.keywords.Common;

@BA.Author("BarxDroid")
@BA.ShortName("NotificationBuilder")
@BA.Version(2.01F)
public class NotificationBuilder extends AbsObjectWrapper<NotificationCompat.Builder>
{
  private static int actionId = 1;
  private static Object nActivity;
  private static int nDefaults;
  private static int nNumber;
  private static String nTag;
  private static long nWhen;
  private static Object pActivity;
  private static int pendingId = 1;
  private static boolean setWhen;

  private void setValue(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      nDefaults = paramInt | nDefaults;
      return;
    }
    nDefaults &= (paramInt ^ 0xFFFFFFFF);
  }

  public void AddAction(BA paramBA, String paramString1, String paramString2, String paramString3, Object paramObject)
    throws ClassNotFoundException
  {
    int i = BA.applicationContext.getResources().getIdentifier(paramString1, "drawable", BA.packageName);
    Intent localIntent = Common.getComponentIntent(paramBA, paramObject);
    if (paramString3.length() > 0)
    {
      localIntent.putExtra("Notification_Action_Tag", paramString3);
      BA.Log("Action Tag set to " + paramString3);
    }
    while (true)
    {
      Context localContext = paramBA.context;
      int j = actionId;
      actionId = j + 1;
      PendingIntent localPendingIntent = PendingIntent.getActivity(localContext, j, localIntent, 0);
      ((NotificationCompat.Builder)getObject()).addAction(i, paramString2, localPendingIntent);
      return;
      localIntent.putExtra("Notification_Action_Tag", paramString2);
      BA.Log("Action Tag set to " + paramString2);
    }
  }

  public void AddAction2(BA paramBA, String paramString1, String paramString2, String paramString3, Object paramObject)
    throws ClassNotFoundException
  {
    int i = BA.applicationContext.getResources().getIdentifier(paramString1, "drawable", BA.packageName);
    Intent localIntent = Common.getComponentIntent(paramBA, paramObject);
    if (paramString3.length() > 0)
    {
      localIntent.putExtra("Notification_Action_Tag", paramString3);
      BA.Log("Action2 Tag set to " + paramString3);
    }
    while (true)
    {
      Context localContext = paramBA.context;
      int j = actionId;
      actionId = j + 1;
      PendingIntent localPendingIntent = PendingIntent.getService(localContext, j, localIntent, 0);
      ((NotificationCompat.Builder)getObject()).addAction(i, paramString2, localPendingIntent);
      return;
      localIntent.putExtra("Notification_Action_Tag", paramString2);
      BA.Log("Action2 Tag set to " + paramString2);
    }
  }

  public void Cancel(int paramInt)
  {
    ((NotificationManager)BA.applicationContext.getSystemService("notification")).cancel(paramInt);
  }

  public void Initialize(BA paramBA)
  {
    setObject(new NotificationCompat.Builder(paramBA.context));
    nWhen = System.currentTimeMillis();
    setWhen = true;
    nActivity = null;
    pActivity = null;
    nDefaults = -1;
  }

  public void Notify(BA paramBA, int paramInt)
    throws ClassNotFoundException
  {
    TaskStackBuilder localTaskStackBuilder;
    int i;
    if (setWhen)
    {
      ((NotificationCompat.Builder)getObject()).setWhen(nWhen);
      ((NotificationCompat.Builder)getObject()).setDefaults(nDefaults);
      Intent localIntent1 = Common.getComponentIntent(paramBA, nActivity);
      localTaskStackBuilder = TaskStackBuilder.create(paramBA.context);
      if (nTag != null)
        localIntent1.putExtra("Notification_Tag", nTag);
      if (pActivity != null)
      {
        Intent localIntent2 = Common.getComponentIntent(paramBA, pActivity);
        if (nTag != null)
          localIntent2.putExtra("Notification_Tag", nTag);
        localTaskStackBuilder.addNextIntent(localIntent2);
      }
      localTaskStackBuilder.addNextIntent(localIntent1);
      if (nTag != null)
        break label207;
      i = 0;
    }
    while (true)
    {
      PendingIntent localPendingIntent = localTaskStackBuilder.getPendingIntent(i, 134217728);
      ((NotificationCompat.Builder)getObject()).setContentIntent(localPendingIntent);
      NotificationManager localNotificationManager = (NotificationManager)BA.applicationContext.getSystemService("notification");
      Notification localNotification = ((NotificationCompat.Builder)getObject()).build();
      localNotification.number = nNumber;
      localNotificationManager.notify(paramInt, localNotification);
      return;
      ((NotificationCompat.Builder)getObject()).setWhen(0L);
      break;
      label207: i = pendingId;
      pendingId = i + 1;
    }
  }

  public void SetStyle(NotificationCompat.Style paramStyle)
  {
    ((NotificationCompat.Builder)getObject()).setStyle(paramStyle);
  }

  public int getNumber()
  {
    return ((NotificationCompat.Builder)getObject()).build().number;
  }

  public void setActivity(BA paramBA, Object paramObject)
  {
    nActivity = paramObject;
  }

  public void setAutoCancel(boolean paramBoolean)
  {
    ((NotificationCompat.Builder)getObject()).setAutoCancel(paramBoolean);
  }

  public void setContentInfo(String paramString)
  {
    ((NotificationCompat.Builder)getObject()).setContentInfo(paramString);
  }

  public void setContentText(String paramString)
  {
    ((NotificationCompat.Builder)getObject()).setContentText(paramString);
  }

  public void setContentTitle(String paramString)
  {
    ((NotificationCompat.Builder)getObject()).setContentTitle(paramString);
  }

  public void setCustomLight(int paramInt1, int paramInt2, int paramInt3)
  {
    setValue(false, 4);
    ((NotificationCompat.Builder)getObject()).setLights(paramInt1, paramInt2, paramInt3);
  }

  public void setCustomSound(String paramString)
  {
    setValue(false, 1);
    ((NotificationCompat.Builder)getObject()).setSound(Uri.parse(paramString));
  }

  public void setCustomVibrate(long[] paramArrayOfLong)
  {
    setValue(false, 2);
    ((NotificationCompat.Builder)getObject()).setVibrate(paramArrayOfLong);
  }

  public void setDefaultLight(boolean paramBoolean)
  {
    setValue(paramBoolean, 4);
  }

  public void setDefaultSound(boolean paramBoolean)
  {
    setValue(paramBoolean, 1);
  }

  public void setDefaultVibrate(boolean paramBoolean)
  {
    setValue(paramBoolean, 2);
  }

  public void setDeleteActivity(BA paramBA, Object paramObject)
    throws ClassNotFoundException
  {
    Intent localIntent = Common.getComponentIntent(paramBA, paramObject);
    PendingIntent localPendingIntent = PendingIntent.getActivity(paramBA.context, 0, localIntent, 134217728);
    ((NotificationCompat.Builder)getObject()).setDeleteIntent(localPendingIntent);
  }

  public void setLargeIcon(Bitmap paramBitmap)
  {
    ((NotificationCompat.Builder)getObject()).setLargeIcon(paramBitmap);
  }

  public void setNumber(int paramInt)
  {
    ((NotificationCompat.Builder)getObject()).setNumber(paramInt);
    nNumber = paramInt;
  }

  public void setOnGoingEvent(boolean paramBoolean)
  {
    ((NotificationCompat.Builder)getObject()).setOngoing(paramBoolean);
  }

  public void setOnlyAlertOnce(boolean paramBoolean)
  {
    ((NotificationCompat.Builder)getObject()).setOnlyAlertOnce(paramBoolean);
  }

  public void setParentActivity(BA paramBA, Object paramObject)
  {
    pActivity = paramObject;
  }

  public void setPriority(int paramInt)
  {
    ((NotificationCompat.Builder)getObject()).setPriority(paramInt);
  }

  public void setProgress(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ((NotificationCompat.Builder)getObject()).setProgress(paramInt1, paramInt2, paramBoolean);
  }

  public void setShowTime(boolean paramBoolean)
  {
    setWhen = paramBoolean;
  }

  public void setSmallIcon(String paramString)
  {
    ((NotificationCompat.Builder)getObject()).setSmallIcon(BA.applicationContext.getResources().getIdentifier(paramString, "drawable", BA.packageName));
  }

  public void setSmallIcon2(String paramString, int paramInt)
  {
    ((NotificationCompat.Builder)getObject()).setSmallIcon(BA.applicationContext.getResources().getIdentifier(paramString, "drawable", BA.packageName), paramInt);
  }

  public void setSubText(String paramString)
  {
    ((NotificationCompat.Builder)getObject()).setSubText(paramString);
  }

  public void setTag(String paramString)
  {
    nTag = paramString;
  }

  public void setTicker(String paramString)
  {
    ((NotificationCompat.Builder)getObject()).setTicker(paramString);
  }

  public void setUsesChrono(boolean paramBoolean)
  {
    ((NotificationCompat.Builder)getObject()).setUsesChronometer(paramBoolean);
  }

  public void setWhen(Long paramLong)
  {
    if (paramLong.longValue() == 0L);
    for (long l = System.currentTimeMillis(); ; l = paramLong.longValue())
    {
      nWhen = l;
      return;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     barxdroid.NotificationBuilder.NotificationBuilder
 * JD-Core Version:    0.6.2
 */