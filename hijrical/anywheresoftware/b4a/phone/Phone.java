package anywheresoftware.b4a.phone;

import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Vibrator;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.CheckForReinitialize;
import anywheresoftware.b4a.BA.SharedProcessBA;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.IOnActivityResult;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@BA.ShortName("Phone")
@BA.Version(2.2F)
public class Phone
{
  public static final int RINGER_NORMAL = 2;
  public static final int RINGER_SILENT = 0;
  public static final int RINGER_VIBRATE = 1;
  public static final int VOLUME_ALARM = 4;
  public static final int VOLUME_MUSIC = 3;
  public static final int VOLUME_NOTIFICATION = 5;
  public static final int VOLUME_RING = 2;
  public static final int VOLUME_SYSTEM = 1;
  public static final int VOLUME_VOICE_CALL;

  public static String GetDataState()
  {
    switch (((TelephonyManager)BA.applicationContext.getSystemService("phone")).getDataState())
    {
    default:
      return "DISCONNECTED";
    case 2:
      return "CONNECTED";
    case 0:
      return "DISCONNECTED";
    case 3:
      return "SUSPENDED";
    case 1:
    }
    return "CONNECTING";
  }

  public static int GetMaxVolume(int paramInt)
  {
    return getAudioManager().getStreamMaxVolume(paramInt);
  }

  public static String GetNetworkOperatorName()
  {
    String str = ((TelephonyManager)BA.applicationContext.getSystemService("phone")).getNetworkOperatorName();
    if (str == null)
      return "";
    return str;
  }

  public static String GetNetworkType()
  {
    switch (((TelephonyManager)BA.applicationContext.getSystemService("phone")).getNetworkType())
    {
    default:
      return "UNKNOWN";
    case 7:
      return "1xRTT";
    case 4:
      return "CDMA";
    case 14:
      return "EHRPD";
    case 2:
      return "EDGE";
    case 5:
      return "EVDO_0";
    case 6:
      return "EVDO_A";
    case 12:
      return "EVDO_B";
    case 1:
      return "GPRS";
    case 8:
      return "HSDPA";
    case 10:
      return "HSPA";
    case 15:
      return "HSPAP";
    case 9:
      return "HSUPA";
    case 11:
      return "IDEN";
    case 13:
      return "LTE";
    case 3:
    }
    return "UMTS";
  }

  public static String GetPhoneType()
  {
    switch (((TelephonyManager)BA.applicationContext.getSystemService("phone")).getPhoneType())
    {
    default:
      return "NONE";
    case 2:
      return "CDMA";
    case 1:
    }
    return "GSM";
  }

  public static int GetRingerMode()
  {
    return getAudioManager().getRingerMode();
  }

  public static String GetSettings(String paramString)
  {
    String str = Settings.Secure.getString(BA.applicationContext.getContentResolver(), paramString);
    if (str == null)
    {
      str = Settings.System.getString(BA.applicationContext.getContentResolver(), paramString);
      if (str == null)
        str = "";
    }
    return str;
  }

  public static String GetSimOperator()
  {
    String str = ((TelephonyManager)BA.applicationContext.getSystemService("phone")).getSimOperator();
    if (str == null)
      return "";
    return str;
  }

  public static int GetVolume(int paramInt)
  {
    return getAudioManager().getStreamVolume(paramInt);
  }

  public static void HideKeyboard(ActivityWrapper paramActivityWrapper)
  {
    ((InputMethodManager)BA.applicationContext.getSystemService("input_method")).hideSoftInputFromWindow(((BALayout)paramActivityWrapper.getObject()).getWindowToken(), 0);
  }

  public static boolean IsAirplaneModeOn()
  {
    return Settings.System.getInt(BA.applicationContext.getContentResolver(), "airplane_mode_on", 0) != 0;
  }

  public static boolean IsNetworkRoaming()
  {
    return ((TelephonyManager)BA.applicationContext.getSystemService("phone")).isNetworkRoaming();
  }

  public static void LIBRARY_DOC()
  {
  }

  public static void SendBroadcastIntent(Intent paramIntent)
  {
    BA.applicationContext.sendBroadcast(paramIntent);
  }

  public static void SetMute(int paramInt, boolean paramBoolean)
  {
    getAudioManager().setStreamMute(paramInt, paramBoolean);
  }

  public static void SetRingerMode(int paramInt)
  {
    getAudioManager().setRingerMode(paramInt);
  }

  public static void SetScreenBrightness(BA paramBA, float paramFloat)
  {
    WindowManager.LayoutParams localLayoutParams = ((BA)paramBA.sharedProcessBA.activityBA.get()).activity.getWindow().getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    ((BA)paramBA.sharedProcessBA.activityBA.get()).activity.getWindow().setAttributes(localLayoutParams);
  }

  public static void SetScreenOrientation(BA paramBA, int paramInt)
  {
    ((BA)paramBA.sharedProcessBA.activityBA.get()).activity.setRequestedOrientation(paramInt);
  }

  public static void SetVolume(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AudioManager localAudioManager = getAudioManager();
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      localAudioManager.setStreamVolume(paramInt1, paramInt2, i);
      return;
    }
  }

  public static int Shell(String paramString, String[] paramArrayOfString, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
    throws InterruptedException, IOException
  {
    Process localProcess;
    byte[] arrayOfByte;
    label36: int j;
    InputStream localInputStream1;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      localProcess = Runtime.getRuntime().exec(paramString);
      arrayOfByte = new byte[4096];
      if (paramStringBuilder1 != null)
      {
        InputStream localInputStream2 = localProcess.getInputStream();
        j = localInputStream2.read(arrayOfByte);
        if (j != -1)
          break label126;
      }
      if (paramStringBuilder2 != null)
        localInputStream1 = localProcess.getErrorStream();
    }
    while (true)
    {
      int i = localInputStream1.read(arrayOfByte);
      if (i == -1)
      {
        localProcess.waitFor();
        return localProcess.exitValue();
        String[] arrayOfString = new String[1 + paramArrayOfString.length];
        arrayOfString[0] = paramString;
        System.arraycopy(paramArrayOfString, 0, arrayOfString, 1, paramArrayOfString.length);
        localProcess = Runtime.getRuntime().exec(arrayOfString);
        break;
        label126: paramStringBuilder1.append(new String(arrayOfByte, 0, j, "UTF8"));
        break label36;
      }
      paramStringBuilder2.append(new String(arrayOfByte, 0, i, "UTF8"));
    }
  }

  private static AudioManager getAudioManager()
  {
    return (AudioManager)BA.applicationContext.getSystemService("audio");
  }

  public static String getManufacturer()
  {
    return Build.MANUFACTURER;
  }

  public static String getModel()
  {
    return Build.MODEL;
  }

  public static String getProduct()
  {
    return Build.PRODUCT;
  }

  public static int getSdkVersion()
  {
    return Build.VERSION.SDK_INT;
  }

  public Drawable GetResourceDrawable(int paramInt)
  {
    return BA.applicationContext.getResources().getDrawable(paramInt);
  }

  @BA.ShortName("ContentChooser")
  public static class ContentChooser
    implements BA.CheckForReinitialize
  {
    private String eventName;
    private IOnActivityResult ion;

    public void Initialize(String paramString)
    {
      this.eventName = paramString.toLowerCase(BA.cul);
    }

    public boolean IsInitialized()
    {
      return this.eventName != null;
    }

    public void Show(final BA paramBA, String paramString1, String paramString2)
    {
      if (this.eventName == null)
        throw new RuntimeException("ContentChooser not initialized.");
      Intent localIntent1 = new Intent("android.intent.action.GET_CONTENT");
      localIntent1.setType(paramString1);
      localIntent1.addCategory("android.intent.category.OPENABLE");
      Intent localIntent2 = Intent.createChooser(localIntent1, paramString2);
      this.ion = new IOnActivityResult()
      {
        public void ResultArrived(int paramAnonymousInt, Intent paramAnonymousIntent)
        {
          String str1 = null;
          Object localObject = null;
          if (paramAnonymousInt == -1)
          {
            str1 = null;
            localObject = null;
            if (paramAnonymousIntent != null)
            {
              Uri localUri1 = paramAnonymousIntent.getData();
              str1 = null;
              localObject = null;
              if (localUri1 == null);
            }
          }
          try
          {
            Uri localUri2 = paramAnonymousIntent.getData();
            String str4 = localUri2.getScheme();
            if ("file".equals(str4))
            {
              str1 = "";
              String str5 = localUri2.getPath();
              localObject = str5;
            }
            while (true)
            {
              Phone.ContentChooser.this.ion = null;
              if ((str1 == null) || (localObject == null))
                break;
              BA localBA2 = paramBA;
              Phone.ContentChooser localContentChooser2 = Phone.ContentChooser.this;
              String str3 = Phone.ContentChooser.this.eventName + "_result";
              Object[] arrayOfObject2 = new Object[3];
              arrayOfObject2[0] = Boolean.valueOf(true);
              arrayOfObject2[1] = str1;
              arrayOfObject2[2] = localObject;
              localBA2.raiseEvent(localContentChooser2, str3, arrayOfObject2);
              return;
              boolean bool = "content".equals(str4);
              str1 = null;
              localObject = null;
              if (bool)
              {
                str1 = "ContentDir";
                String str6 = localUri2.toString();
                localObject = str6;
              }
            }
          }
          catch (Exception localException)
          {
            throw new RuntimeException(localException);
          }
          BA localBA1 = paramBA;
          Phone.ContentChooser localContentChooser1 = Phone.ContentChooser.this;
          String str2 = Phone.ContentChooser.this.eventName + "_result";
          Object[] arrayOfObject1 = new Object[3];
          arrayOfObject1[0] = Boolean.valueOf(false);
          arrayOfObject1[1] = "";
          arrayOfObject1[2] = "";
          localBA1.raiseEvent(localContentChooser1, str2, arrayOfObject1);
        }
      };
      paramBA.startActivityForResult(this.ion, localIntent2);
    }
  }

  @BA.ShortName("Email")
  public static class Email
  {
    public anywheresoftware.b4a.objects.collections.List Attachments = new anywheresoftware.b4a.objects.collections.List();
    public anywheresoftware.b4a.objects.collections.List BCC = new anywheresoftware.b4a.objects.collections.List();
    public String Body = "";
    public anywheresoftware.b4a.objects.collections.List CC = new anywheresoftware.b4a.objects.collections.List();
    public String Subject = "";
    public anywheresoftware.b4a.objects.collections.List To = new anywheresoftware.b4a.objects.collections.List();

    public Email()
    {
      this.To.Initialize();
      this.CC.Initialize();
      this.BCC.Initialize();
      this.Attachments.Initialize();
    }

    private Intent getIntent(boolean paramBoolean)
    {
      Intent localIntent = new Intent("android.intent.action.SEND_MULTIPLE");
      String str;
      Object localObject;
      label134: ArrayList localArrayList;
      Iterator localIterator;
      if (paramBoolean)
      {
        str = "text/html";
        localIntent.setType(str);
        localIntent.putExtra("android.intent.extra.EMAIL", (String[])((java.util.List)this.To.getObject()).toArray(new String[0]));
        localIntent.putExtra("android.intent.extra.CC", (String[])((java.util.List)this.CC.getObject()).toArray(new String[0]));
        localIntent.putExtra("android.intent.extra.BCC", (String[])((java.util.List)this.BCC.getObject()).toArray(new String[0]));
        localIntent.putExtra("android.intent.extra.SUBJECT", this.Subject);
        if (!paramBoolean)
          break label219;
        localObject = Html.fromHtml(this.Body);
        localIntent.putExtra("android.intent.extra.TEXT", (CharSequence)localObject);
        localArrayList = new ArrayList();
        localIterator = ((java.util.List)this.Attachments.getObject()).iterator();
        label169: if (localIterator.hasNext())
          break label228;
        if (localArrayList.size() != 1)
          break label257;
        localIntent.putExtra("android.intent.extra.STREAM", (Parcelable)localArrayList.get(0));
        localIntent.setAction("android.intent.action.SEND");
      }
      label219: label228: 
      while (localArrayList.size() <= 1)
      {
        return localIntent;
        str = "text/plain";
        break;
        localObject = this.Body;
        break label134;
        localArrayList.add(Uri.fromFile(new File((String)localIterator.next())));
        break label169;
      }
      label257: localIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", localArrayList);
      return localIntent;
    }

    public Intent GetHtmlIntent()
    {
      return getIntent(true);
    }

    public Intent GetIntent()
    {
      return getIntent(false);
    }
  }

  @BA.ShortName("LogCat")
  public static class LogCat
  {
    private static Process lc;
    private static Thread logcatReader;
    private static volatile InputStream logcatStream;
    private static volatile boolean logcatWorking;

    public static void LogCatStart(final BA paramBA, String[] paramArrayOfString, String paramString)
      throws InterruptedException, IOException
    {
      LogCatStop();
      if (logcatReader != null);
      int j;
      for (int i = 10; ; i = j)
      {
        if (logcatReader.isAlive())
        {
          j = i - 1;
          if (i > 0);
        }
        else
        {
          String[] arrayOfString = new String[1 + paramArrayOfString.length];
          arrayOfString[0] = "/system/bin/logcat";
          System.arraycopy(paramArrayOfString, 0, arrayOfString, 1, paramArrayOfString.length);
          logcatReader = new Thread(new Runnable()
          {
            public void run()
            {
              try
              {
                Phone.LogCat.lc = Runtime.getRuntime().exec(Phone.LogCat.this);
                Phone.LogCat.logcatStream = Phone.LogCat.lc.getInputStream();
                localInputStream = Phone.LogCat.logcatStream;
                Phone.LogCat.logcatWorking = true;
                arrayOfByte = new byte[4092];
                if (!Phone.LogCat.logcatWorking);
                while (true)
                {
                  Phone.LogCat.lc.destroy();
                  return;
                  i = localInputStream.read(arrayOfByte);
                  Thread.sleep(100L);
                  if ((i > 0) && (localInputStream.available() > 0) && (i < arrayOfByte.length))
                    break;
                  if (i != -1)
                    break label134;
                  Phone.LogCat.logcatWorking = false;
                }
              }
              catch (Exception localException)
              {
                InputStream localInputStream;
                byte[] arrayOfByte;
                int i;
                while (Phone.LogCat.lc != null)
                {
                  Phone.LogCat.lc.destroy();
                  return;
                  i += localInputStream.read(arrayOfByte, i, arrayOfByte.length - i);
                  Thread.sleep(100L);
                  continue;
                  label134: BA localBA = paramBA;
                  String str = this.val$ev;
                  Object[] arrayOfObject = new Object[2];
                  arrayOfObject[0] = arrayOfByte;
                  arrayOfObject[1] = Integer.valueOf(i);
                  localBA.raiseEvent(null, str, arrayOfObject);
                }
              }
            }
          });
          logcatReader.setDaemon(true);
          logcatReader.start();
          return;
        }
        Thread.sleep(50L);
        logcatReader.interrupt();
      }
    }

    public static void LogCatStop()
      throws IOException
    {
      logcatWorking = false;
      if (logcatStream != null)
        logcatStream.close();
      if (lc != null)
        lc.destroy();
    }
  }

  @BA.ShortName("PhoneAccelerometer")
  public static class PhoneAccelerometer
  {
    private SensorEventListener listener;

    public void StartListening(final BA paramBA, String paramString)
    {
      SensorManager localSensorManager = (SensorManager)paramBA.context.getSystemService("sensor");
      this.listener = new SensorEventListener()
      {
        public void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt)
        {
        }

        public void onSensorChanged(SensorEvent paramAnonymousSensorEvent)
        {
          BA localBA = paramBA;
          String str = this.val$s;
          Object[] arrayOfObject = new Object[3];
          arrayOfObject[0] = Float.valueOf(paramAnonymousSensorEvent.values[0]);
          arrayOfObject[1] = Float.valueOf(paramAnonymousSensorEvent.values[1]);
          arrayOfObject[2] = Float.valueOf(paramAnonymousSensorEvent.values[2]);
          localBA.raiseEvent(this, str, arrayOfObject);
        }
      };
      localSensorManager.registerListener(this.listener, localSensorManager.getDefaultSensor(1), 3);
    }

    public void StopListening(BA paramBA)
    {
      if (this.listener != null)
        ((SensorManager)paramBA.context.getSystemService("sensor")).unregisterListener(this.listener);
    }
  }

  @BA.ShortName("PhoneCalls")
  public static class PhoneCalls
  {
    public static Intent Call(String paramString)
    {
      return new Intent("android.intent.action.CALL", Uri.parse("tel:" + paramString));
    }
  }

  @BA.ShortName("PhoneId")
  public static class PhoneId
  {
    public static String GetDeviceId()
    {
      String str = ((TelephonyManager)BA.applicationContext.getSystemService("phone")).getDeviceId();
      if (str == null)
        return "";
      return str;
    }

    public static String GetLine1Number()
    {
      String str = ((TelephonyManager)BA.applicationContext.getSystemService("phone")).getLine1Number();
      if (str == null)
        return "";
      return str;
    }

    public static String GetSimSerialNumber()
    {
      String str = ((TelephonyManager)BA.applicationContext.getSystemService("phone")).getSimSerialNumber();
      if (str == null)
        return "";
      return str;
    }

    public static String GetSubscriberId()
    {
      String str = ((TelephonyManager)BA.applicationContext.getSystemService("phone")).getSubscriberId();
      if (str == null)
        return "";
      return str;
    }
  }

  @BA.ShortName("PhoneIntents")
  public static class PhoneIntents
  {
    public static Intent OpenBrowser(String paramString)
    {
      return new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    }

    public static Intent PlayAudio(String paramString1, String paramString2)
    {
      if (paramString1.equals("ContentDir"));
      for (Uri localUri = Uri.parse(paramString2); ; localUri = Uri.parse("file://" + new File(paramString1, paramString2).toString()))
      {
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setDataAndType(localUri, "audio/*");
        return localIntent;
      }
    }

    public static Intent PlayVideo(String paramString1, String paramString2)
    {
      if (paramString1.equals("ContentDir"));
      for (Uri localUri = Uri.parse(paramString2); ; localUri = Uri.parse("file://" + new File(paramString1, paramString2).toString()))
      {
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setDataAndType(localUri, "video/*");
        return localIntent;
      }
    }
  }

  @BA.ShortName("PhoneOrientation")
  public static class PhoneOrientation
  {
    private SensorEventListener listener;

    public void StartListening(final BA paramBA, String paramString)
    {
      SensorManager localSensorManager = (SensorManager)paramBA.context.getSystemService("sensor");
      this.listener = new SensorEventListener()
      {
        public void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt)
        {
        }

        public void onSensorChanged(SensorEvent paramAnonymousSensorEvent)
        {
          BA localBA = paramBA;
          String str = this.val$s;
          Object[] arrayOfObject = new Object[3];
          arrayOfObject[0] = Float.valueOf(paramAnonymousSensorEvent.values[0]);
          arrayOfObject[1] = Float.valueOf(paramAnonymousSensorEvent.values[1]);
          arrayOfObject[2] = Float.valueOf(paramAnonymousSensorEvent.values[2]);
          localBA.raiseEvent(this, str, arrayOfObject);
        }
      };
      localSensorManager.registerListener(this.listener, localSensorManager.getDefaultSensor(3), 3);
    }

    public void StopListening(BA paramBA)
    {
      if (this.listener != null)
        ((SensorManager)paramBA.context.getSystemService("sensor")).unregisterListener(this.listener);
    }
  }

  @BA.ShortName("PhoneSensors")
  public static class PhoneSensors
  {
    public static int TYPE_ACCELEROMETER = 1;
    public static int TYPE_GYROSCOPE;
    public static int TYPE_LIGHT = 5;
    public static int TYPE_MAGNETIC_FIELD = 2;
    public static int TYPE_ORIENTATION = 3;
    public static int TYPE_PRESSURE = 6;
    public static int TYPE_PROXIMITY = 8;
    public static int TYPE_TEMPERATURE = 7;
    private int currentType;
    private SensorEventListener listener;
    private int sensorDelay;

    static
    {
      TYPE_GYROSCOPE = 4;
    }

    public void Initialize(int paramInt)
    {
      Initialize2(paramInt, 3);
    }

    public void Initialize2(int paramInt1, int paramInt2)
    {
      this.currentType = paramInt1;
      this.sensorDelay = paramInt2;
    }

    public boolean StartListening(final BA paramBA, String paramString)
    {
      SensorManager localSensorManager = (SensorManager)BA.applicationContext.getSystemService("sensor");
      this.listener = new SensorEventListener()
      {
        public void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt)
        {
        }

        public void onSensorChanged(SensorEvent paramAnonymousSensorEvent)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          if (Thread.currentThread() == BA.handler.getLooper().getThread());
          for (boolean bool = true; ; bool = false)
          {
            Common.Log(bool);
            BA localBA = paramBA;
            Phone.PhoneSensors localPhoneSensors = Phone.PhoneSensors.this;
            String str = this.val$s;
            Object[] arrayOfObject = new Object[1];
            arrayOfObject[0] = paramAnonymousSensorEvent.values;
            localBA.raiseEvent(localPhoneSensors, str, arrayOfObject);
            return;
          }
        }
      };
      return localSensorManager.registerListener(this.listener, localSensorManager.getDefaultSensor(this.currentType), this.sensorDelay);
    }

    public void StopListening(BA paramBA)
    {
      if (this.listener != null)
        ((SensorManager)paramBA.context.getSystemService("sensor")).unregisterListener(this.listener);
    }

    public float getMaxValue()
    {
      java.util.List localList = ((SensorManager)BA.applicationContext.getSystemService("sensor")).getSensorList(this.currentType);
      if ((localList == null) || (localList.size() == 0))
        return -1.0F;
      return ((Sensor)localList.get(0)).getMaximumRange();
    }
  }

  @BA.ShortName("PhoneSms")
  public static class PhoneSms
  {
    public static void Send(String paramString1, String paramString2)
    {
      Send2(paramString1, paramString2, true, true);
    }

    public static void Send2(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
    {
      SmsManager localSmsManager = SmsManager.getDefault();
      Intent localIntent1 = new Intent("b4a.smssent");
      localIntent1.putExtra("phone", paramString1);
      PendingIntent localPendingIntent1;
      Intent localIntent2;
      if (paramBoolean1)
      {
        localPendingIntent1 = PendingIntent.getBroadcast(BA.applicationContext, 0, localIntent1, 134217728);
        localIntent2 = new Intent("b4a.smsdelivered");
        localIntent2.putExtra("phone", paramString1);
        if (!paramBoolean2)
          break label98;
      }
      label98: for (PendingIntent localPendingIntent2 = PendingIntent.getBroadcast(BA.applicationContext, 0, localIntent2, 134217728); ; localPendingIntent2 = null)
      {
        localSmsManager.sendTextMessage(paramString1, null, paramString2, localPendingIntent1, localPendingIntent2);
        return;
        localPendingIntent1 = null;
        break;
      }
    }
  }

  @BA.ShortName("PhoneVibrate")
  public static class PhoneVibrate
  {
    public static void Vibrate(BA paramBA, long paramLong)
    {
      ((Vibrator)paramBA.context.getSystemService("vibrator")).vibrate(paramLong);
    }
  }

  @BA.ShortName("PhoneWakeState")
  public static class PhoneWakeState
  {
    private static PowerManager.WakeLock partialLock;
    private static PowerManager.WakeLock wakeLock;

    public static void KeepAlive(BA paramBA, boolean paramBoolean)
    {
      if ((wakeLock != null) && (wakeLock.isHeld()))
      {
        Common.Log("WakeLock already held.");
        return;
      }
      PowerManager localPowerManager = (PowerManager)paramBA.context.getSystemService("power");
      if (paramBoolean);
      for (int i = 10; ; i = 6)
      {
        wakeLock = localPowerManager.newWakeLock(i | 0x10000000, "B4A");
        wakeLock.acquire();
        return;
      }
    }

    public static void PartialLock(BA paramBA)
    {
      if ((partialLock != null) && (partialLock.isHeld()))
      {
        Common.Log("Partial wakeLock already held.");
        return;
      }
      partialLock = ((PowerManager)paramBA.context.getSystemService("power")).newWakeLock(1, "B4A-Partial");
      partialLock.acquire();
    }

    public static void ReleaseKeepAlive()
    {
      if ((wakeLock == null) || (!wakeLock.isHeld()))
      {
        Common.Log("No wakelock.");
        return;
      }
      wakeLock.release();
    }

    public static void ReleasePartialLock()
    {
      if ((partialLock == null) || (!partialLock.isHeld()))
      {
        Common.Log("No partial wakelock.");
        return;
      }
      partialLock.release();
    }
  }

  @BA.ShortName("VoiceRecognition")
  public static class VoiceRecognition
  {
    private String eventName;
    private IOnActivityResult ion;
    private String language;
    private String prompt;

    public void Initialize(String paramString)
    {
      this.eventName = paramString.toLowerCase(BA.cul);
    }

    public boolean IsSupported()
    {
      return BA.applicationContext.getPackageManager().queryIntentActivities(new Intent("android.speech.action.RECOGNIZE_SPEECH"), 0).size() > 0;
    }

    public void Listen(final BA paramBA)
    {
      if (this.eventName == null)
        throw new RuntimeException("VoiceRecognition was not initialized.");
      Intent localIntent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
      if ((this.prompt != null) && (this.prompt.length() > 0))
        localIntent.putExtra("android.speech.extra.PROMPT", this.prompt);
      if ((this.language != null) && (this.language.length() > 0))
        localIntent.putExtra("android.speech.extra.LANGUAGE", this.language);
      this.ion = new IOnActivityResult()
      {
        public void ResultArrived(int paramAnonymousInt, Intent paramAnonymousIntent)
        {
          anywheresoftware.b4a.objects.collections.List localList = new anywheresoftware.b4a.objects.collections.List();
          if (paramAnonymousInt == -1)
          {
            ArrayList localArrayList = paramAnonymousIntent.getStringArrayListExtra("android.speech.extra.RESULTS");
            if (localArrayList.size() > 0)
              localList.setObject(localArrayList);
          }
          Phone.VoiceRecognition.this.ion = null;
          BA localBA = paramBA;
          Phone.VoiceRecognition localVoiceRecognition = Phone.VoiceRecognition.this;
          String str = Phone.VoiceRecognition.this.eventName + "_result";
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = Boolean.valueOf(localList.IsInitialized());
          arrayOfObject[1] = localList;
          localBA.raiseEvent(localVoiceRecognition, str, arrayOfObject);
        }
      };
      paramBA.startActivityForResult(this.ion, localIntent);
    }

    public void setLanguage(String paramString)
    {
      this.language = paramString;
    }

    public void setPrompt(String paramString)
    {
      this.prompt = paramString;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.phone.Phone
 * JD-Core Version:    0.6.2
 */