package anywheresoftware.b4a;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.util.Log;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@BA.Hide
public class Msgbox
{
  private static Object closeMyLoop;
  private static Field flagsF;
  public static boolean isDismissing;
  private static Method nextM;
  public static WeakReference<ProgressDialog> pd;
  private static boolean stopCodeAfterDismiss;
  private static boolean visible = false;
  private static WeakReference<AlertDialog> visibleAD;
  private static Field whenF;

  // ERROR //
  static
  {
    // Byte code:
    //   0: iconst_0
    //   1: putstatic 27	anywheresoftware/b4a/Msgbox:visible	Z
    //   4: new 4	java/lang/Object
    //   7: dup
    //   8: invokespecial 30	java/lang/Object:<init>	()V
    //   11: putstatic 32	anywheresoftware/b4a/Msgbox:closeMyLoop	Ljava/lang/Object;
    //   14: iconst_0
    //   15: putstatic 34	anywheresoftware/b4a/Msgbox:stopCodeAfterDismiss	Z
    //   18: iconst_0
    //   19: putstatic 36	anywheresoftware/b4a/Msgbox:isDismissing	Z
    //   22: ldc 38
    //   24: ldc 40
    //   26: aconst_null
    //   27: invokevirtual 46	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   30: putstatic 48	anywheresoftware/b4a/Msgbox:nextM	Ljava/lang/reflect/Method;
    //   33: getstatic 48	anywheresoftware/b4a/Msgbox:nextM	Ljava/lang/reflect/Method;
    //   36: iconst_1
    //   37: invokevirtual 54	java/lang/reflect/Method:setAccessible	(Z)V
    //   40: ldc 56
    //   42: ldc 58
    //   44: invokevirtual 62	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   47: putstatic 64	anywheresoftware/b4a/Msgbox:whenF	Ljava/lang/reflect/Field;
    //   50: getstatic 64	anywheresoftware/b4a/Msgbox:whenF	Ljava/lang/reflect/Field;
    //   53: iconst_1
    //   54: invokevirtual 67	java/lang/reflect/Field:setAccessible	(Z)V
    //   57: aconst_null
    //   58: putstatic 69	anywheresoftware/b4a/Msgbox:flagsF	Ljava/lang/reflect/Field;
    //   61: ldc 56
    //   63: ldc 71
    //   65: invokevirtual 62	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   68: putstatic 69	anywheresoftware/b4a/Msgbox:flagsF	Ljava/lang/reflect/Field;
    //   71: getstatic 69	anywheresoftware/b4a/Msgbox:flagsF	Ljava/lang/reflect/Field;
    //   74: iconst_1
    //   75: invokevirtual 67	java/lang/reflect/Field:setAccessible	(Z)V
    //   78: return
    //   79: astore_0
    //   80: aload_0
    //   81: invokevirtual 74	java/lang/Exception:printStackTrace	()V
    //   84: return
    //   85: astore_1
    //   86: return
    //
    // Exception table:
    //   from	to	target	type
    //   22	61	79	java/lang/Exception
    //   61	78	85	java/lang/Exception
  }

  public static void debugWait(Dialog paramDialog)
  {
    if (visible)
    {
      System.out.println("already visible");
      return;
    }
    try
    {
      boolean bool = isDismissing;
      if (bool)
        return;
      stopCodeAfterDismiss = false;
      visible = true;
      waitForMessage(true);
      if (stopCodeAfterDismiss)
      {
        Log.w("", "throwing b4a uncaught exception");
        throw new B4AUncaughtException();
      }
    }
    finally
    {
      visible = false;
    }
    visible = false;
  }

  public static void dismiss(boolean paramBoolean)
  {
    dismissProgressDialog();
    if (BA.debugMode);
    try
    {
      Class.forName("anywheresoftware.b4a.debug.Debug").getMethod("hideProgressDialogToAvoidLeak", null).invoke(null, null);
      isDismissing = true;
      if (visible)
      {
        if (visibleAD != null)
        {
          AlertDialog localAlertDialog = (AlertDialog)visibleAD.get();
          if (localAlertDialog != null)
            localAlertDialog.dismiss();
          stopCodeAfterDismiss = paramBoolean;
        }
      }
      else
        return;
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        continue;
        sendCloseMyLoopMessage();
      }
    }
  }

  public static void dismissProgressDialog()
  {
    if (pd != null)
    {
      ProgressDialog localProgressDialog = (ProgressDialog)pd.get();
      if (localProgressDialog != null)
        localProgressDialog.dismiss();
    }
  }

  public static boolean isItReallyAMsgboxAndNotDebug()
  {
    return visibleAD != null;
  }

  public static void msgbox(AlertDialog paramAlertDialog, boolean paramBoolean)
  {
    if (visible)
      return;
    try
    {
      boolean bool = isDismissing;
      if (bool)
        return;
      stopCodeAfterDismiss = false;
      Message localMessage = Message.obtain();
      localMessage.setTarget(BA.handler);
      localMessage.obj = closeMyLoop;
      paramAlertDialog.setDismissMessage(localMessage);
      visible = true;
      visibleAD = new WeakReference(paramAlertDialog);
      paramAlertDialog.show();
      waitForMessage(false);
      if ((stopCodeAfterDismiss) && (!paramBoolean))
        throw new B4AUncaughtException();
    }
    finally
    {
      visible = false;
      visibleAD = null;
    }
    visible = false;
    visibleAD = null;
  }

  public static boolean msgboxIsVisible()
  {
    return visible;
  }

  public static void sendCloseMyLoopMessage()
  {
    Message localMessage = Message.obtain();
    localMessage.setTarget(BA.handler);
    localMessage.obj = closeMyLoop;
    localMessage.sendToTarget();
  }

  private static void skipMessage(Message paramMessage)
    throws IllegalArgumentException, IllegalAccessException
  {
    whenF.set(paramMessage, Integer.valueOf(0));
    if (flagsF != null)
    {
      int i = flagsF.getInt(paramMessage);
      flagsF.setInt(paramMessage, i & 0xFFFFFFFE);
    }
    paramMessage.getTarget().sendMessage(paramMessage);
  }

  private static void waitForMessage(boolean paramBoolean)
  {
    while (true)
    {
      Message localMessage;
      try
      {
        MessageQueue localMessageQueue = Looper.myQueue();
        localMessage = (Message)nextM.invoke(localMessageQueue, null);
        if (localMessage == null)
          continue;
        if (localMessage.obj == closeMyLoop)
        {
          localMessage.recycle();
          return;
        }
        if ((localMessage.getCallback() != null) && ((localMessage.getCallback() instanceof BA.B4ARunnable)))
        {
          skipMessage(localMessage);
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      if ((paramBoolean) && ((localMessage.obj == null) || (!(localMessage.obj instanceof Drawable))) && (localMessage.what >= 100) && (localMessage.what <= 150))
      {
        skipMessage(localMessage);
      }
      else
      {
        localMessage.getTarget().dispatchMessage(localMessage);
        localMessage.recycle();
      }
    }
  }

  public static void waitForMessage(boolean paramBoolean1, boolean paramBoolean2)
  {
    waitForMessage(paramBoolean2);
  }

  public static class DialogResponse
    implements DialogInterface.OnClickListener
  {
    private boolean dismiss;
    public int res = -3;

    public DialogResponse(boolean paramBoolean)
    {
      this.dismiss = paramBoolean;
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      this.res = paramInt;
      if (this.dismiss)
        ((AlertDialog)Msgbox.visibleAD.get()).dismiss();
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.Msgbox
 * JD-Core Version:    0.6.2
 */