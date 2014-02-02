package anywheresoftware.b4a;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Application;
import android.app.Service;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Process;
import android.preference.PreferenceManager.OnActivityResultListener;
import android.util.DisplayMetrics;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Future;

public class BA
{
  private static byte[][] _b;
  public static Application applicationContext;
  public static IBridgeLog bridgeLog;
  private static int checkStackTraceEvery50;
  public static final Locale cul;
  public static String debugLine;
  public static int debugLineNum;
  public static boolean debugMode = false;
  public static float density;
  public static final Handler handler;
  public static NumberFormat numberFormat;
  public static String packageName;
  public static boolean shellMode = false;
  private static volatile B4AThreadPool threadPool;
  private static HashMap<String, ArrayList<Runnable>> uninitializedActivitiesMessagesDuringPaused;
  public static WarningEngine warningEngine;
  public final Activity activity;
  public final String className;
  public final Context context;
  public final Object eventsTarget;
  public final HashMap<String, Method> htSubs;
  public final BA processBA;
  public Service service;
  public final SharedProcessBA sharedProcessBA;
  public final BALayout vg;

  static
  {
    density = 1.0F;
    handler = new Handler();
    cul = Locale.US;
    Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
    {
      final Thread.UncaughtExceptionHandler original = Thread.getDefaultUncaughtExceptionHandler();

      public void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
      {
        BA.printException(paramAnonymousThrowable, true);
        if (BA.bridgeLog != null);
        try
        {
          Thread.sleep(100L);
          label18: this.original.uncaughtException(paramAnonymousThread, paramAnonymousThrowable);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          break label18;
        }
      }
    });
  }

  public BA(Context paramContext, BALayout paramBALayout, BA paramBA, String paramString1, String paramString2)
  {
    if (paramContext != null)
      density = paramContext.getResources().getDisplayMetrics().density;
    Activity localActivity;
    boolean bool;
    if ((paramContext != null) && ((paramContext instanceof Activity)))
    {
      localActivity = (Activity)paramContext;
      applicationContext = localActivity.getApplication();
      if ((paramContext == null) || (!(paramContext instanceof Service)))
        break label148;
      bool = true;
      applicationContext = ((Service)paramContext).getApplication();
    }
    while (true)
    {
      if (paramContext != null)
        packageName = paramContext.getPackageName();
      this.eventsTarget = null;
      this.context = paramContext;
      this.activity = localActivity;
      this.htSubs = new HashMap();
      this.className = paramString2;
      this.processBA = paramBA;
      this.vg = paramBALayout;
      if (paramBA != null)
        break label154;
      this.sharedProcessBA = new SharedProcessBA(bool);
      return;
      localActivity = null;
      break;
      label148: bool = false;
    }
    label154: this.sharedProcessBA = null;
  }

  public BA(BA paramBA, Object paramObject, HashMap<String, Method> paramHashMap, String paramString)
  {
    this.vg = paramBA.vg;
    this.eventsTarget = paramObject;
    Object localObject;
    if (paramHashMap == null)
    {
      localObject = new HashMap();
      this.htSubs = ((HashMap)localObject);
      this.processBA = null;
      this.activity = paramBA.activity;
      this.context = paramBA.context;
      this.service = paramBA.service;
      if (paramBA.sharedProcessBA != null)
        break label100;
    }
    label100: for (SharedProcessBA localSharedProcessBA = paramBA.processBA.sharedProcessBA; ; localSharedProcessBA = paramBA.sharedProcessBA)
    {
      this.sharedProcessBA = localSharedProcessBA;
      this.className = paramString;
      return;
      localObject = paramHashMap;
      break;
    }
  }

  public static char CharFromString(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return '\000';
    return paramString.charAt(0);
  }

  public static void Log(String paramString)
  {
    if (paramString == null);
    for (String str = "null"; ; str = paramString)
    {
      Log.i("B4A", str);
      if ((paramString != null) && (paramString.length() > 4000))
        LogInfo("Message longer than Log limit (4000). Message was truncated.");
      if (bridgeLog != null)
        bridgeLog.offer(paramString);
      return;
    }
  }

  public static void LogError(String paramString)
  {
    addLogPrefix("e", paramString);
  }

  public static void LogInfo(String paramString)
  {
    addLogPrefix("i", paramString);
  }

  public static String NumberToString(double paramDouble)
  {
    String str = Double.toString(paramDouble);
    if ((str.length() > 2) && (str.charAt(str.length() - 2) == '.') && (str.charAt(str.length() - 1) == '0'))
      return str.substring(0, str.length() - 2);
    return str;
  }

  public static String NumberToString(float paramFloat)
  {
    return NumberToString(paramFloat);
  }

  public static String NumberToString(int paramInt)
  {
    return String.valueOf(paramInt);
  }

  public static String NumberToString(long paramLong)
  {
    return String.valueOf(paramLong);
  }

  public static String NumberToString(Number paramNumber)
  {
    return String.valueOf(paramNumber);
  }

  public static boolean ObjectToBoolean(Object paramObject)
  {
    if ((paramObject instanceof Boolean))
      return ((Boolean)paramObject).booleanValue();
    return parseBoolean(String.valueOf(paramObject));
  }

  public static char ObjectToChar(Object paramObject)
  {
    if ((paramObject instanceof Character))
      return ((Character)paramObject).charValue();
    return CharFromString(paramObject.toString());
  }

  public static long ObjectToLongNumber(Object paramObject)
  {
    if ((paramObject instanceof Number))
      return ((Number)paramObject).longValue();
    return Long.parseLong(String.valueOf(paramObject));
  }

  public static double ObjectToNumber(Object paramObject)
  {
    if ((paramObject instanceof Number))
      return ((Number)paramObject).doubleValue();
    return Double.parseDouble(String.valueOf(paramObject));
  }

  public static String ObjectToString(Object paramObject)
  {
    return String.valueOf(paramObject);
  }

  public static String TypeToString(Object paramObject, boolean paramBoolean)
  {
    for (int i = 0; ; i++)
      try
      {
        int j = 1 + checkStackTraceEvery50;
        checkStackTraceEvery50 = j;
        if ((j % 50 == 0) || (checkStackTraceEvery50 < 0))
        {
          int k = Thread.currentThread().getStackTrace().length;
          if (checkStackTraceEvery50 < 0);
          for (int m = 20; k >= m; m = 150)
          {
            checkStackTraceEvery50 = -100;
            return "";
          }
          checkStackTraceEvery50 = 0;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        int n = 0;
        Field[] arrayOfField = paramObject.getClass().getDeclaredFields();
        int i1 = arrayOfField.length;
        if (i >= i1)
        {
          if (localStringBuilder.length() >= 2)
            localStringBuilder.setLength(localStringBuilder.length() - 2);
          localStringBuilder.append("]");
          return localStringBuilder.toString();
        }
        Field localField = arrayOfField[i];
        String str = localField.getName();
        if (paramBoolean)
        {
          if (str.startsWith("_"))
          {
            str = str.substring(1);
            if (str.startsWith("_"));
          }
        }
        else
        {
          localField.setAccessible(true);
          localStringBuilder.append(str).append("=").append(String.valueOf(localField.get(paramObject)));
          n++;
          if (n % 3 == 0)
            localStringBuilder.append("\n");
          localStringBuilder.append(", ");
        }
      }
      catch (Exception localException)
      {
        return "N/A";
      }
  }

  public static String __b(byte[] paramArrayOfByte, int paramInt)
    throws UnsupportedEncodingException, PackageManager.NameNotFoundException
  {
    new PreferenceManager.OnActivityResultListener()
    {
      public boolean onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        return false;
      }
    };
    return new String(paramArrayOfByte, "UTF8");
  }

  public static void addLogPrefix(String paramString1, String paramString2)
  {
    String str = "~" + paramString1 + ":";
    StringBuilder localStringBuilder;
    int i;
    int j;
    if (paramString2.length() < 3900)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      i = -1;
      j = 0;
      i = paramString2.indexOf('\n', i + 1);
      if (i != -1)
        break label102;
      if (j >= paramString2.length())
        break label153;
      localStringBuilder.append(paramString2.substring(j));
    }
    while (true)
    {
      paramString2 = localStringBuilder.toString();
      Log(paramString2);
      return;
      label102: if (j == i)
        localStringBuilder.setLength(localStringBuilder.length() - str.length());
      while (true)
      {
        j = i + 1;
        break;
        localStringBuilder.append(paramString2.substring(j, i + 1)).append(str);
      }
      label153: localStringBuilder.setLength(localStringBuilder.length() - str.length());
    }
  }

  public static void addMessageToUninitializeActivity(String paramString1, String paramString2, Object[] paramArrayOfObject)
  {
    if (uninitializedActivitiesMessagesDuringPaused == null)
      uninitializedActivitiesMessagesDuringPaused = new HashMap();
    ArrayList localArrayList = (ArrayList)uninitializedActivitiesMessagesDuringPaused.get(paramString1);
    if (localArrayList == null)
    {
      localArrayList = new ArrayList();
      uninitializedActivitiesMessagesDuringPaused.put(paramString1, localArrayList);
    }
    if (localArrayList.size() < 20)
    {
      RaiseEventWhenFirstCreate localRaiseEventWhenFirstCreate = new RaiseEventWhenFirstCreate(null);
      localRaiseEventWhenFirstCreate.eventName = paramString2;
      localRaiseEventWhenFirstCreate.arguments = paramArrayOfObject;
      Log("sending message to waiting queue of uninitialized activity (" + paramString2 + ")");
      localArrayList.add(localRaiseEventWhenFirstCreate);
    }
  }

  public static boolean fastSubCompare(String paramString1, String paramString2)
  {
    if (paramString1 == paramString2)
      return true;
    if (paramString1.length() != paramString2.length())
      return false;
    for (int i = 0; ; i++)
    {
      if (i >= paramString1.length())
        return true;
      if ((0xDF & paramString1.charAt(i)) != (0xDF & paramString2.charAt(i)))
        return false;
    }
  }

  public static <T extends Enum<T>> T getEnumFromString(Class<T> paramClass, String paramString)
  {
    return Enum.valueOf(paramClass, paramString);
  }

  public static <T> T gm(Map paramMap, Object paramObject, T paramT)
  {
    Object localObject = paramMap.get(paramObject);
    if (localObject == null)
      return paramT;
    return localObject;
  }

  public static boolean isTaskRunning(Object paramObject, int paramInt)
  {
    if (threadPool == null)
      return false;
    return threadPool.isRunning(paramObject, paramInt);
  }

  private static void markTaskAsFinish(Object paramObject, int paramInt)
  {
    if (threadPool == null)
      return;
    threadPool.markTaskAsFinished(paramObject, paramInt);
  }

  public static boolean parseBoolean(String paramString)
  {
    if (paramString.equals("true"))
      return true;
    if (paramString.equals("false"))
      return false;
    throw new RuntimeException("Cannot parse: " + paramString + " as boolean");
  }

  public static String printException(Throwable paramThrowable, boolean paramBoolean)
  {
    String str1 = "";
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    int i = arrayOfStackTraceElement.length;
    int j = 0;
    while (true)
    {
      label23: byte[] arrayOfByte;
      if (j >= i)
        if (paramBoolean)
        {
          if (str1.length() > 0)
            LogError(str1);
          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
          PrintWriter localPrintWriter = new PrintWriter(localByteArrayOutputStream);
          paramThrowable.printStackTrace(localPrintWriter);
          localPrintWriter.close();
          arrayOfByte = localByteArrayOutputStream.toByteArray();
        }
      try
      {
        LogError(new String(arrayOfByte, "UTF8"));
        return str1;
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[j];
        if (localStackTraceElement.getClassName().startsWith(packageName))
        {
          String str2 = localStackTraceElement.getClassName().substring(1 + packageName.length()) + localStackTraceElement.getMethodName();
          if (debugLine != null)
          {
            str1 = str2 + " (B4A line: " + debugLineNum + ")\n" + debugLine;
            break label23;
          }
          str1 = str2 + " (java line: " + localStackTraceElement.getLineNumber() + ")";
          break label23;
        }
        j++;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    return str1;
  }

  public static Future<?> submitRunnable(Runnable paramRunnable, Object paramObject, int paramInt)
  {
    if (threadPool == null);
    try
    {
      if (threadPool == null)
        threadPool = new B4AThreadPool();
      if ((paramObject instanceof ObjectWrapper))
        paramObject = ((ObjectWrapper)paramObject).getObject();
      threadPool.submit(paramRunnable, paramObject, paramInt);
      return null;
    }
    finally
    {
    }
  }

  public static int switchObjectToInt(Object paramObject, Object[] paramArrayOfObject)
  {
    double d;
    int j;
    if ((paramObject instanceof Number))
    {
      d = ((Number)paramObject).doubleValue();
      j = 0;
      if (j < paramArrayOfObject.length);
    }
    while (true)
    {
      return -1;
      if (d == ((Number)paramArrayOfObject[j]).doubleValue())
        return j;
      j++;
      break;
      for (int i = 0; i < paramArrayOfObject.length; i++)
        if (paramObject.equals(paramArrayOfObject[i]))
          return i;
    }
  }

  public void ShowErrorMsgbox(String paramString1, String paramString2)
  {
    this.sharedProcessBA.ignoreEventsFromOtherThreadsDuringMsgboxError = true;
    try
    {
      LogError(paramString1);
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(((BA)this.sharedProcessBA.activityBA.get()).context);
      localBuilder.setTitle("Error occurred");
      String str;
      Msgbox.DialogResponse localDialogResponse;
      AlertDialog localAlertDialog;
      if (paramString2 != null)
      {
        str = "An error has occurred in sub:" + paramString2 + "\n";
        localBuilder.setMessage(str + paramString1 + "\nContinue?");
        localDialogResponse = new Msgbox.DialogResponse(false);
        localBuilder.setPositiveButton("Yes", localDialogResponse);
        localBuilder.setNegativeButton("No", localDialogResponse);
        localAlertDialog = localBuilder.create();
        if (this.sharedProcessBA.numberOfStackedEvents != 1)
          break label203;
      }
      label203: for (boolean bool = true; ; bool = false)
      {
        Msgbox.msgbox(localAlertDialog, bool);
        if (localDialogResponse.res == -2)
        {
          Process.killProcess(Process.myPid());
          System.exit(0);
        }
        return;
        str = "";
        break;
      }
    }
    finally
    {
      this.sharedProcessBA.ignoreEventsFromOtherThreadsDuringMsgboxError = false;
    }
  }

  public void addMessageToPausedMessageQueue(String paramString, Runnable paramRunnable)
  {
    if (this.processBA != null)
    {
      this.processBA.addMessageToPausedMessageQueue(paramString, paramRunnable);
      return;
    }
    Log("sending message to waiting queue (" + paramString + ")");
    if (this.sharedProcessBA.messagesDuringPaused == null)
      this.sharedProcessBA.messagesDuringPaused = new ArrayList();
    if (this.sharedProcessBA.messagesDuringPaused.size() > 20)
    {
      Log("Ignoring event (too many queued events: " + paramString + ")");
      return;
    }
    this.sharedProcessBA.messagesDuringPaused.add(paramRunnable);
  }

  public String getClassNameWithoutPackage()
  {
    return this.className.substring(1 + this.className.lastIndexOf("."));
  }

  public Exception getLastException()
  {
    if (this.processBA != null)
      return this.processBA.getLastException();
    return this.sharedProcessBA.lastException;
  }

  public Object getSender()
  {
    if (this.processBA != null)
      return this.processBA.getSender();
    return this.sharedProcessBA.sender;
  }

  public boolean isActivityPaused()
  {
    if (this.processBA != null)
      return this.processBA.isActivityPaused();
    return this.sharedProcessBA.isActivityPaused;
  }

  public void loadHtSubs(Class<?> paramClass)
  {
    Method[] arrayOfMethod = paramClass.getDeclaredMethods();
    int i = arrayOfMethod.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return;
      Method localMethod = arrayOfMethod[j];
      if (localMethod.getName().startsWith("_"))
        this.htSubs.put(localMethod.getName().substring(1).toLowerCase(cul), localMethod);
    }
  }

  public void onActivityResult(int paramInt1, final int paramInt2, final Intent paramIntent)
  {
    WeakReference localWeakReference;
    if (this.sharedProcessBA.onActivityResultMap != null)
    {
      localWeakReference = (WeakReference)this.sharedProcessBA.onActivityResultMap.get(Integer.valueOf(paramInt1));
      if (localWeakReference == null)
        Log("onActivityResult: wi is null");
    }
    else
    {
      return;
    }
    this.sharedProcessBA.onActivityResultMap.remove(Integer.valueOf(paramInt1));
    final IOnActivityResult localIOnActivityResult = (IOnActivityResult)localWeakReference.get();
    if (localIOnActivityResult == null)
    {
      Log("onActivityResult: IOnActivityResult was released");
      return;
    }
    addMessageToPausedMessageQueue("OnActivityResult", new Runnable()
    {
      public void run()
      {
        try
        {
          localIOnActivityResult.ResultArrived(paramInt2, paramIntent);
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    });
  }

  public Object raiseEvent(Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    return raiseEvent2(paramObject, false, paramString, false, paramArrayOfObject);
  }

  // ERROR //
  public Object raiseEvent2(Object paramObject, boolean paramBoolean1, String paramString, boolean paramBoolean2, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 131	anywheresoftware/b4a/BA:processBA	Lanywheresoftware/b4a/BA;
    //   4: ifnull +18 -> 22
    //   7: aload_0
    //   8: getfield 131	anywheresoftware/b4a/BA:processBA	Lanywheresoftware/b4a/BA;
    //   11: aload_1
    //   12: iload_2
    //   13: aload_3
    //   14: iload 4
    //   16: aload 5
    //   18: invokevirtual 667	anywheresoftware/b4a/BA:raiseEvent2	(Ljava/lang/Object;ZLjava/lang/String;Z[Ljava/lang/Object;)Ljava/lang/Object;
    //   21: areturn
    //   22: aload_0
    //   23: getfield 140	anywheresoftware/b4a/BA:sharedProcessBA	Lanywheresoftware/b4a/BA$SharedProcessBA;
    //   26: getfield 622	anywheresoftware/b4a/BA$SharedProcessBA:isActivityPaused	Z
    //   29: ifeq +32 -> 61
    //   32: iload_2
    //   33: ifne +28 -> 61
    //   36: getstatic 675	java/lang/System:out	Ljava/io/PrintStream;
    //   39: new 279	java/lang/StringBuilder
    //   42: dup
    //   43: ldc_w 677
    //   46: invokespecial 362	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   49: aload_3
    //   50: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokevirtual 682	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   59: aconst_null
    //   60: areturn
    //   61: aload_0
    //   62: getfield 140	anywheresoftware/b4a/BA:sharedProcessBA	Lanywheresoftware/b4a/BA$SharedProcessBA;
    //   65: astore 15
    //   67: aload 15
    //   69: iconst_1
    //   70: aload 15
    //   72: getfield 562	anywheresoftware/b4a/BA$SharedProcessBA:numberOfStackedEvents	I
    //   75: iadd
    //   76: putfield 562	anywheresoftware/b4a/BA$SharedProcessBA:numberOfStackedEvents	I
    //   79: aload_0
    //   80: getfield 140	anywheresoftware/b4a/BA:sharedProcessBA	Lanywheresoftware/b4a/BA$SharedProcessBA;
    //   83: aload_1
    //   84: putfield 617	anywheresoftware/b4a/BA$SharedProcessBA:sender	Ljava/lang/Object;
    //   87: aload_0
    //   88: getfield 127	anywheresoftware/b4a/BA:htSubs	Ljava/util/HashMap;
    //   91: aload_3
    //   92: invokevirtual 375	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   95: checkcast 630	java/lang/reflect/Method
    //   98: astore 16
    //   100: aload 16
    //   102: ifnull +98 -> 200
    //   105: aload 16
    //   107: aload_0
    //   108: getfield 118	anywheresoftware/b4a/BA:eventsTarget	Ljava/lang/Object;
    //   111: aload 5
    //   113: invokevirtual 686	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   116: astore 19
    //   118: aload_0
    //   119: getfield 140	anywheresoftware/b4a/BA:sharedProcessBA	Lanywheresoftware/b4a/BA$SharedProcessBA;
    //   122: astore 20
    //   124: aload 20
    //   126: aload 20
    //   128: getfield 562	anywheresoftware/b4a/BA$SharedProcessBA:numberOfStackedEvents	I
    //   131: iconst_1
    //   132: isub
    //   133: putfield 562	anywheresoftware/b4a/BA$SharedProcessBA:numberOfStackedEvents	I
    //   136: aload 19
    //   138: areturn
    //   139: astore 18
    //   141: new 265	java/lang/Exception
    //   144: dup
    //   145: new 279	java/lang/StringBuilder
    //   148: dup
    //   149: ldc_w 688
    //   152: invokespecial 362	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   155: aload_3
    //   156: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: ldc_w 690
    //   162: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokespecial 691	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   171: athrow
    //   172: astore 14
    //   174: aload 14
    //   176: athrow
    //   177: astore 11
    //   179: aload_0
    //   180: getfield 140	anywheresoftware/b4a/BA:sharedProcessBA	Lanywheresoftware/b4a/BA$SharedProcessBA;
    //   183: astore 12
    //   185: aload 12
    //   187: aload 12
    //   189: getfield 562	anywheresoftware/b4a/BA$SharedProcessBA:numberOfStackedEvents	I
    //   192: iconst_1
    //   193: isub
    //   194: putfield 562	anywheresoftware/b4a/BA$SharedProcessBA:numberOfStackedEvents	I
    //   197: aload 11
    //   199: athrow
    //   200: iload 4
    //   202: ifeq +192 -> 394
    //   205: new 265	java/lang/Exception
    //   208: dup
    //   209: new 279	java/lang/StringBuilder
    //   212: dup
    //   213: ldc_w 688
    //   216: invokespecial 362	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   219: aload_3
    //   220: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: ldc_w 693
    //   226: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokespecial 691	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   235: athrow
    //   236: astore 6
    //   238: aload 6
    //   240: astore 7
    //   242: aload 7
    //   244: instanceof 695
    //   247: ifeq +10 -> 257
    //   250: aload 7
    //   252: invokevirtual 699	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   255: astore 7
    //   257: aload 7
    //   259: instanceof 669
    //   262: ifeq +49 -> 311
    //   265: aload_0
    //   266: getfield 140	anywheresoftware/b4a/BA:sharedProcessBA	Lanywheresoftware/b4a/BA$SharedProcessBA;
    //   269: getfield 562	anywheresoftware/b4a/BA$SharedProcessBA:numberOfStackedEvents	I
    //   272: iconst_1
    //   273: if_icmple +9 -> 282
    //   276: aload 7
    //   278: checkcast 669	anywheresoftware/b4a/B4AUncaughtException
    //   281: athrow
    //   282: getstatic 675	java/lang/System:out	Ljava/io/PrintStream;
    //   285: ldc_w 701
    //   288: invokevirtual 682	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   291: aload_0
    //   292: getfield 140	anywheresoftware/b4a/BA:sharedProcessBA	Lanywheresoftware/b4a/BA$SharedProcessBA;
    //   295: astore 13
    //   297: aload 13
    //   299: aload 13
    //   301: getfield 562	anywheresoftware/b4a/BA$SharedProcessBA:numberOfStackedEvents	I
    //   304: iconst_1
    //   305: isub
    //   306: putfield 562	anywheresoftware/b4a/BA$SharedProcessBA:numberOfStackedEvents	I
    //   309: aconst_null
    //   310: areturn
    //   311: aload 7
    //   313: instanceof 703
    //   316: ifeq +9 -> 325
    //   319: aload 7
    //   321: checkcast 703	java/lang/Error
    //   324: athrow
    //   325: getstatic 55	anywheresoftware/b4a/BA:debugMode	Z
    //   328: ifeq +87 -> 415
    //   331: iconst_0
    //   332: istore 8
    //   334: aload 7
    //   336: iload 8
    //   338: invokestatic 705	anywheresoftware/b4a/BA:printException	(Ljava/lang/Throwable;Z)Ljava/lang/String;
    //   341: astore 9
    //   343: aload_0
    //   344: getfield 140	anywheresoftware/b4a/BA:sharedProcessBA	Lanywheresoftware/b4a/BA$SharedProcessBA;
    //   347: getfield 521	anywheresoftware/b4a/BA$SharedProcessBA:activityBA	Ljava/lang/ref/WeakReference;
    //   350: ifnonnull +13 -> 363
    //   353: new 438	java/lang/RuntimeException
    //   356: dup
    //   357: aload 7
    //   359: invokespecial 708	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   362: athrow
    //   363: aload_0
    //   364: aload 7
    //   366: invokevirtual 709	java/lang/Throwable:toString	()Ljava/lang/String;
    //   369: aload 9
    //   371: invokevirtual 711	anywheresoftware/b4a/BA:ShowErrorMsgbox	(Ljava/lang/String;Ljava/lang/String;)V
    //   374: aload_0
    //   375: getfield 140	anywheresoftware/b4a/BA:sharedProcessBA	Lanywheresoftware/b4a/BA$SharedProcessBA;
    //   378: astore 10
    //   380: aload 10
    //   382: aload 10
    //   384: getfield 562	anywheresoftware/b4a/BA$SharedProcessBA:numberOfStackedEvents	I
    //   387: iconst_1
    //   388: isub
    //   389: putfield 562	anywheresoftware/b4a/BA$SharedProcessBA:numberOfStackedEvents	I
    //   392: aconst_null
    //   393: areturn
    //   394: aload_0
    //   395: getfield 140	anywheresoftware/b4a/BA:sharedProcessBA	Lanywheresoftware/b4a/BA$SharedProcessBA;
    //   398: astore 17
    //   400: aload 17
    //   402: aload 17
    //   404: getfield 562	anywheresoftware/b4a/BA$SharedProcessBA:numberOfStackedEvents	I
    //   407: iconst_1
    //   408: isub
    //   409: putfield 562	anywheresoftware/b4a/BA$SharedProcessBA:numberOfStackedEvents	I
    //   412: goto -20 -> 392
    //   415: iconst_1
    //   416: istore 8
    //   418: goto -84 -> 334
    //
    // Exception table:
    //   from	to	target	type
    //   105	118	139	java/lang/IllegalArgumentException
    //   61	100	172	anywheresoftware/b4a/B4AUncaughtException
    //   105	118	172	anywheresoftware/b4a/B4AUncaughtException
    //   141	172	172	anywheresoftware/b4a/B4AUncaughtException
    //   205	236	172	anywheresoftware/b4a/B4AUncaughtException
    //   61	100	177	finally
    //   105	118	177	finally
    //   141	172	177	finally
    //   174	177	177	finally
    //   205	236	177	finally
    //   242	257	177	finally
    //   257	282	177	finally
    //   282	291	177	finally
    //   311	325	177	finally
    //   325	331	177	finally
    //   334	363	177	finally
    //   363	374	177	finally
    //   61	100	236	java/lang/Throwable
    //   105	118	236	java/lang/Throwable
    //   141	172	236	java/lang/Throwable
    //   205	236	236	java/lang/Throwable
  }

  public Object raiseEventFromDifferentThread(final Object paramObject1, final Object paramObject2, final int paramInt, final String paramString, final boolean paramBoolean, final Object[] paramArrayOfObject)
  {
    if (this.processBA != null)
      return this.processBA.raiseEventFromDifferentThread(paramObject1, paramObject2, paramInt, paramString, paramBoolean, paramArrayOfObject);
    B4ARunnable local3 = new B4ARunnable()
    {
      public void run()
      {
        if (BA.this.sharedProcessBA.ignoreEventsFromOtherThreadsDuringMsgboxError)
        {
          BA.Log("Event: " + paramString + ", was ignored.");
          return;
        }
        if ((!BA.this.sharedProcessBA.isService) && (BA.this.sharedProcessBA.activityBA == null))
        {
          BA.Log("Reposting event: " + paramString);
          BA.handler.post(this);
          return;
        }
        if (BA.this.sharedProcessBA.isActivityPaused)
        {
          if (BA.this.sharedProcessBA.isService)
          {
            BA.Log("Ignoring event as service was destroyed.");
            return;
          }
          BA.this.addMessageToPausedMessageQueue(paramString, this);
          return;
        }
        if (paramObject2 != null)
          BA.markTaskAsFinish(paramObject2, paramInt);
        BA.this.raiseEvent2(paramObject1, false, paramString, paramBoolean, paramArrayOfObject);
      }
    };
    handler.post(local3);
    return null;
  }

  public void raiseEventFromUI(final Object paramObject, final String paramString, final Object[] paramArrayOfObject)
  {
    if (this.processBA != null)
    {
      this.processBA.raiseEventFromUI(paramObject, paramString, paramArrayOfObject);
      return;
    }
    B4ARunnable local2 = new B4ARunnable()
    {
      public void run()
      {
        if (BA.this.sharedProcessBA.ignoreEventsFromOtherThreadsDuringMsgboxError)
        {
          BA.LogInfo("Event: " + paramString + ", was ignored.");
          return;
        }
        if ((!BA.this.sharedProcessBA.isService) && (BA.this.sharedProcessBA.activityBA == null))
        {
          BA.LogInfo("Reposting event: " + paramString);
          BA.handler.post(this);
          return;
        }
        if (BA.this.sharedProcessBA.isActivityPaused)
        {
          BA.LogInfo("Ignoring event: " + paramString);
          return;
        }
        BA.this.raiseEvent2(paramObject, false, paramString, false, paramArrayOfObject);
      }
    };
    handler.post(local2);
  }

  public void setActivityPaused(boolean paramBoolean)
  {
    if (this.processBA != null)
      this.processBA.setActivityPaused(paramBoolean);
    do
    {
      do
      {
        return;
        this.sharedProcessBA.isActivityPaused = paramBoolean;
      }
      while ((paramBoolean) || (this.sharedProcessBA.isService));
      if ((this.sharedProcessBA.messagesDuringPaused == null) && (uninitializedActivitiesMessagesDuringPaused != null))
      {
        String str = this.className;
        this.sharedProcessBA.messagesDuringPaused = ((ArrayList)uninitializedActivitiesMessagesDuringPaused.get(str));
        uninitializedActivitiesMessagesDuringPaused.remove(str);
      }
    }
    while ((this.sharedProcessBA.messagesDuringPaused == null) || (this.sharedProcessBA.messagesDuringPaused.size() <= 0));
    try
    {
      Log("running waiting messages (" + this.sharedProcessBA.messagesDuringPaused.size() + ")");
      Iterator localIterator = this.sharedProcessBA.messagesDuringPaused.iterator();
      while (true)
      {
        boolean bool = localIterator.hasNext();
        if (!bool)
          return;
        Runnable localRunnable = (Runnable)localIterator.next();
        if ((localRunnable instanceof RaiseEventWhenFirstCreate))
          ((RaiseEventWhenFirstCreate)localRunnable).ba = this;
        localRunnable.run();
      }
    }
    finally
    {
      this.sharedProcessBA.messagesDuringPaused.clear();
    }
  }

  public void setLastException(Exception paramException)
  {
    while (true)
    {
      if ((paramException == null) || (paramException.getCause() == null) || (!(paramException instanceof Exception)))
      {
        this.sharedProcessBA.lastException = paramException;
        return;
      }
      paramException = (Exception)paramException.getCause();
    }
  }

  public void startActivityForResult(IOnActivityResult paramIOnActivityResult, Intent paramIntent)
  {
    try
    {
      if (this.processBA != null)
        this.processBA.startActivityForResult(paramIOnActivityResult, paramIntent);
      while (true)
      {
        return;
        if (this.sharedProcessBA.activityBA != null)
        {
          BA localBA = (BA)this.sharedProcessBA.activityBA.get();
          if (localBA != null)
          {
            if (this.sharedProcessBA.onActivityResultMap == null)
              this.sharedProcessBA.onActivityResultMap = new HashMap();
            this.sharedProcessBA.onActivityResultMap.put(Integer.valueOf(this.sharedProcessBA.onActivityResultCode), new WeakReference(paramIOnActivityResult));
            try
            {
              Activity localActivity = localBA.activity;
              SharedProcessBA localSharedProcessBA = this.sharedProcessBA;
              int i = localSharedProcessBA.onActivityResultCode;
              localSharedProcessBA.onActivityResultCode = (i + 1);
              localActivity.startActivityForResult(paramIntent, i);
            }
            catch (ActivityNotFoundException localActivityNotFoundException)
            {
              this.sharedProcessBA.onActivityResultMap.remove(Integer.valueOf(this.sharedProcessBA.onActivityResultCode - 1));
              paramIOnActivityResult.ResultArrived(0, null);
            }
          }
        }
      }
    }
    finally
    {
    }
  }

  public boolean subExists(String paramString)
  {
    if (this.processBA != null)
      return this.processBA.subExists(paramString);
    return this.htSubs.containsKey(paramString);
  }

  public static @interface ActivityObject
  {
  }

  @Retention(RetentionPolicy.RUNTIME)
  public static @interface Author
  {
    public abstract String value();
  }

  public static abstract interface B4ARunnable extends Runnable
  {
  }

  public static abstract interface B4aDebuggable
  {
    public abstract Object[] debug(int paramInt, boolean[] paramArrayOfBoolean);
  }

  public static abstract interface CheckForReinitialize
  {
    public abstract boolean IsInitialized();
  }

  @Retention(RetentionPolicy.SOURCE)
  @Target({java.lang.annotation.ElementType.TYPE})
  public static @interface DependsOn
  {
    public abstract String[] values();
  }

  public static @interface DesignerName
  {
    public abstract String value();
  }

  @Retention(RetentionPolicy.SOURCE)
  @Target({java.lang.annotation.ElementType.TYPE})
  public static @interface DontInheritEvents
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  @Target({java.lang.annotation.ElementType.TYPE})
  public static @interface Events
  {
    public abstract String[] values();
  }

  public static @interface Hide
  {
  }

  public static abstract interface IBridgeLog
  {
    public abstract void offer(String paramString);
  }

  public static abstract interface IterableList
  {
    public abstract Object Get(int paramInt);

    public abstract int getSize();
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface Permissions
  {
    public abstract String[] values();
  }

  public static @interface Pixel
  {
  }

  private static class RaiseEventWhenFirstCreate
    implements Runnable
  {
    Object[] arguments;
    BA ba;
    String eventName;

    public void run()
    {
      this.ba.raiseEvent2(null, true, this.eventName, true, this.arguments);
    }
  }

  @Target({java.lang.annotation.ElementType.METHOD})
  public static @interface RaisesSynchronousEvents
  {
  }

  public static class SharedProcessBA
  {
    public WeakReference<BA> activityBA;
    boolean ignoreEventsFromOtherThreadsDuringMsgboxError = false;
    volatile boolean isActivityPaused = true;
    public final boolean isService;
    Exception lastException = null;
    ArrayList<Runnable> messagesDuringPaused;
    int numberOfStackedEvents = 0;
    int onActivityResultCode = 1;
    HashMap<Integer, WeakReference<IOnActivityResult>> onActivityResultMap;
    public Object sender;

    public SharedProcessBA(boolean paramBoolean)
    {
      this.isService = paramBoolean;
    }
  }

  @Retention(RetentionPolicy.RUNTIME)
  public static @interface ShortName
  {
    public abstract String value();
  }

  public static abstract interface SubDelegator
  {
    public static final Object SubNotFound = new Object();

    public abstract Object callSub(String paramString, Object paramObject, Object[] paramArrayOfObject)
      throws Exception;
  }

  @Retention(RetentionPolicy.RUNTIME)
  public static @interface Version
  {
    public abstract float value();
  }

  public static abstract class WarningEngine
  {
    public static final int FULLSCREEN_MISMATCH = 1004;
    public static final int OBJECT_ALREADY_INITIALIZED = 1003;
    public static final int SAME_OBJECT_ADDED_TO_LIST = 1002;
    public static final int ZERO_SIZE_PANEL = 1001;

    public static void warn(int paramInt)
    {
      if (BA.warningEngine != null)
        BA.warningEngine.warnImpl(paramInt);
    }

    public abstract void checkFullScreenInLayout(boolean paramBoolean1, boolean paramBoolean2);

    protected abstract void warnImpl(int paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.BA
 * JD-Core Version:    0.6.2
 */