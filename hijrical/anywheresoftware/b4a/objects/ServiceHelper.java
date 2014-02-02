package anywheresoftware.b4a.objects;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Hide;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@BA.ActivityObject
public class ServiceHelper
{
  private static Method mStartForeground;
  private static final Class<?>[] mStartForegroundSignature;
  private static Method mStopForeground;
  private static final Class<?>[] mStopForegroundSignature = arrayOfClass2;
  NotificationManager mNM;
  private Service service;

  static
  {
    Class[] arrayOfClass1 = new Class[2];
    arrayOfClass1[0] = Integer.TYPE;
    arrayOfClass1[1] = Notification.class;
    mStartForegroundSignature = arrayOfClass1;
    Class[] arrayOfClass2 = new Class[1];
    arrayOfClass2[0] = Boolean.TYPE;
  }

  public ServiceHelper(Service paramService)
  {
    this.service = paramService;
    this.mNM = ((NotificationManager)BA.applicationContext.getSystemService("notification"));
  }

  @BA.Hide
  public static void init()
  {
    try
    {
      mStartForeground = Service.class.getMethod("startForeground", mStartForegroundSignature);
      mStopForeground = Service.class.getMethod("stopForeground", mStopForegroundSignature);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      mStopForeground = null;
      mStartForeground = null;
    }
  }

  public void StartForeground(int paramInt, Notification paramNotification)
    throws IllegalArgumentException, IllegalAccessException, InvocationTargetException
  {
    if (mStartForeground != null)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      arrayOfObject[1] = paramNotification;
      mStartForeground.invoke(this.service, arrayOfObject);
      return;
    }
    this.service.setForeground(true);
    this.mNM.notify(paramInt, paramNotification);
  }

  public void StopForeground(int paramInt)
    throws IllegalArgumentException, IllegalAccessException, InvocationTargetException
  {
    if (mStopForeground != null)
    {
      Method localMethod = mStopForeground;
      Service localService = this.service;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Boolean.TRUE;
      localMethod.invoke(localService, arrayOfObject);
      return;
    }
    this.mNM.cancel(paramInt);
    this.service.setForeground(false);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.ServiceHelper
 * JD-Core Version:    0.6.2
 */