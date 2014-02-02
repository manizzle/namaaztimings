package anywheresoftware.b4a.phone;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SmsMessage;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.B4ARunnable;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.objects.IntentWrapper;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

@BA.ShortName("PhoneEvents")
public class PhoneEvents
{
  private BA ba;
  private BroadcastReceiver br;
  private String ev;
  private HashMap<String, ActionHandler> map = new HashMap();

  public PhoneEvents()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 20	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: new 22	java/util/HashMap
    //   8: dup
    //   9: invokespecial 23	java/util/HashMap:<init>	()V
    //   12: putfield 25	anywheresoftware/b4a/phone/PhoneEvents:map	Ljava/util/HashMap;
    //   15: aload_0
    //   16: getfield 25	anywheresoftware/b4a/phone/PhoneEvents:map	Ljava/util/HashMap;
    //   19: ldc 27
    //   21: new 29	anywheresoftware/b4a/phone/PhoneEvents$1
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 32	anywheresoftware/b4a/phone/PhoneEvents$1:<init>	(Lanywheresoftware/b4a/phone/PhoneEvents;)V
    //   29: invokevirtual 36	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   32: pop
    //   33: aload_0
    //   34: getfield 25	anywheresoftware/b4a/phone/PhoneEvents:map	Ljava/util/HashMap;
    //   37: ldc 38
    //   39: new 40	anywheresoftware/b4a/phone/PhoneEvents$2
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 41	anywheresoftware/b4a/phone/PhoneEvents$2:<init>	(Lanywheresoftware/b4a/phone/PhoneEvents;)V
    //   47: invokevirtual 36	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   50: pop
    //   51: aload_0
    //   52: getfield 25	anywheresoftware/b4a/phone/PhoneEvents:map	Ljava/util/HashMap;
    //   55: ldc 43
    //   57: new 45	anywheresoftware/b4a/phone/PhoneEvents$3
    //   60: dup
    //   61: aload_0
    //   62: invokespecial 46	anywheresoftware/b4a/phone/PhoneEvents$3:<init>	(Lanywheresoftware/b4a/phone/PhoneEvents;)V
    //   65: invokevirtual 36	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   68: pop
    //   69: aload_0
    //   70: getfield 25	anywheresoftware/b4a/phone/PhoneEvents:map	Ljava/util/HashMap;
    //   73: ldc 48
    //   75: new 50	anywheresoftware/b4a/phone/PhoneEvents$4
    //   78: dup
    //   79: aload_0
    //   80: invokespecial 51	anywheresoftware/b4a/phone/PhoneEvents$4:<init>	(Lanywheresoftware/b4a/phone/PhoneEvents;)V
    //   83: invokevirtual 36	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   86: pop
    //   87: aload_0
    //   88: getfield 25	anywheresoftware/b4a/phone/PhoneEvents:map	Ljava/util/HashMap;
    //   91: ldc 53
    //   93: new 55	anywheresoftware/b4a/phone/PhoneEvents$5
    //   96: dup
    //   97: aload_0
    //   98: invokespecial 56	anywheresoftware/b4a/phone/PhoneEvents$5:<init>	(Lanywheresoftware/b4a/phone/PhoneEvents;)V
    //   101: invokevirtual 36	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   104: pop
    //   105: aload_0
    //   106: getfield 25	anywheresoftware/b4a/phone/PhoneEvents:map	Ljava/util/HashMap;
    //   109: ldc 58
    //   111: new 60	anywheresoftware/b4a/phone/PhoneEvents$6
    //   114: dup
    //   115: aload_0
    //   116: invokespecial 61	anywheresoftware/b4a/phone/PhoneEvents$6:<init>	(Lanywheresoftware/b4a/phone/PhoneEvents;)V
    //   119: invokevirtual 36	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   122: pop
    //   123: aload_0
    //   124: getfield 25	anywheresoftware/b4a/phone/PhoneEvents:map	Ljava/util/HashMap;
    //   127: ldc 63
    //   129: new 65	anywheresoftware/b4a/phone/PhoneEvents$7
    //   132: dup
    //   133: aload_0
    //   134: invokespecial 66	anywheresoftware/b4a/phone/PhoneEvents$7:<init>	(Lanywheresoftware/b4a/phone/PhoneEvents;)V
    //   137: invokevirtual 36	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   140: pop
    //   141: aload_0
    //   142: getfield 25	anywheresoftware/b4a/phone/PhoneEvents:map	Ljava/util/HashMap;
    //   145: ldc 68
    //   147: new 70	anywheresoftware/b4a/phone/PhoneEvents$8
    //   150: dup
    //   151: aload_0
    //   152: invokespecial 71	anywheresoftware/b4a/phone/PhoneEvents$8:<init>	(Lanywheresoftware/b4a/phone/PhoneEvents;)V
    //   155: invokevirtual 36	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   158: pop
    //   159: aload_0
    //   160: getfield 25	anywheresoftware/b4a/phone/PhoneEvents:map	Ljava/util/HashMap;
    //   163: ldc 73
    //   165: new 75	anywheresoftware/b4a/phone/PhoneEvents$9
    //   168: dup
    //   169: aload_0
    //   170: invokespecial 76	anywheresoftware/b4a/phone/PhoneEvents$9:<init>	(Lanywheresoftware/b4a/phone/PhoneEvents;)V
    //   173: invokevirtual 36	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   176: pop
    //   177: aload_0
    //   178: getfield 25	anywheresoftware/b4a/phone/PhoneEvents:map	Ljava/util/HashMap;
    //   181: ldc 78
    //   183: new 80	anywheresoftware/b4a/phone/PhoneEvents$10
    //   186: dup
    //   187: aload_0
    //   188: invokespecial 81	anywheresoftware/b4a/phone/PhoneEvents$10:<init>	(Lanywheresoftware/b4a/phone/PhoneEvents;)V
    //   191: invokevirtual 36	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   194: pop
    //   195: aload_0
    //   196: getfield 25	anywheresoftware/b4a/phone/PhoneEvents:map	Ljava/util/HashMap;
    //   199: ldc 83
    //   201: new 85	anywheresoftware/b4a/phone/PhoneEvents$11
    //   204: dup
    //   205: aload_0
    //   206: invokespecial 86	anywheresoftware/b4a/phone/PhoneEvents$11:<init>	(Lanywheresoftware/b4a/phone/PhoneEvents;)V
    //   209: invokevirtual 36	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   212: pop
    //   213: aload_0
    //   214: getfield 25	anywheresoftware/b4a/phone/PhoneEvents:map	Ljava/util/HashMap;
    //   217: ldc 88
    //   219: new 90	anywheresoftware/b4a/phone/PhoneEvents$12
    //   222: dup
    //   223: aload_0
    //   224: invokespecial 91	anywheresoftware/b4a/phone/PhoneEvents$12:<init>	(Lanywheresoftware/b4a/phone/PhoneEvents;)V
    //   227: invokevirtual 36	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   230: pop
    //   231: aload_0
    //   232: getfield 25	anywheresoftware/b4a/phone/PhoneEvents:map	Ljava/util/HashMap;
    //   235: ldc 93
    //   237: new 95	anywheresoftware/b4a/phone/PhoneEvents$13
    //   240: dup
    //   241: aload_0
    //   242: invokespecial 96	anywheresoftware/b4a/phone/PhoneEvents$13:<init>	(Lanywheresoftware/b4a/phone/PhoneEvents;)V
    //   245: invokevirtual 36	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   248: pop
    //   249: aload_0
    //   250: getfield 25	anywheresoftware/b4a/phone/PhoneEvents:map	Ljava/util/HashMap;
    //   253: ldc 98
    //   255: new 100	anywheresoftware/b4a/phone/PhoneEvents$14
    //   258: dup
    //   259: aload_0
    //   260: invokespecial 101	anywheresoftware/b4a/phone/PhoneEvents$14:<init>	(Lanywheresoftware/b4a/phone/PhoneEvents;)V
    //   263: invokevirtual 36	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   266: pop
    //   267: aload_0
    //   268: getfield 25	anywheresoftware/b4a/phone/PhoneEvents:map	Ljava/util/HashMap;
    //   271: invokevirtual 105	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   274: invokeinterface 111 1 0
    //   279: astore 15
    //   281: aload 15
    //   283: invokeinterface 117 1 0
    //   288: ifne +4 -> 292
    //   291: return
    //   292: aload 15
    //   294: invokeinterface 121 1 0
    //   299: checkcast 123	java/util/Map$Entry
    //   302: astore 16
    //   304: aload 16
    //   306: invokeinterface 126 1 0
    //   311: checkcast 128	anywheresoftware/b4a/phone/PhoneEvents$ActionHandler
    //   314: aload 16
    //   316: invokeinterface 131 1 0
    //   321: checkcast 133	java/lang/String
    //   324: putfield 136	anywheresoftware/b4a/phone/PhoneEvents$ActionHandler:action	Ljava/lang/String;
    //   327: goto -46 -> 281
  }

  public void Initialize(BA paramBA, String paramString)
  {
    this.ba = paramBA;
    this.ev = paramString.toLowerCase(BA.cul);
    StopListening();
    this.br = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        if (paramAnonymousIntent.getAction() == null);
        PhoneEvents.ActionHandler localActionHandler;
        do
        {
          return;
          localActionHandler = (PhoneEvents.ActionHandler)PhoneEvents.this.map.get(paramAnonymousIntent.getAction());
        }
        while (localActionHandler == null);
        localActionHandler.resultCode = getResultCode();
        localActionHandler.handle(paramAnonymousIntent);
      }
    };
    IntentFilter localIntentFilter1 = new IntentFilter();
    IntentFilter localIntentFilter2 = null;
    Iterator localIterator = this.map.values().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        BA.applicationContext.registerReceiver(this.br, localIntentFilter1);
        if (localIntentFilter2 != null)
          BA.applicationContext.registerReceiver(this.br, localIntentFilter2);
        return;
      }
      ActionHandler localActionHandler = (ActionHandler)localIterator.next();
      if (paramBA.subExists(this.ev + localActionHandler.event))
      {
        if ((localActionHandler.action == "android.intent.action.PACKAGE_ADDED") || (localActionHandler.action == "android.intent.action.PACKAGE_REMOVED"))
        {
          if (localIntentFilter2 == null)
          {
            localIntentFilter2 = new IntentFilter();
            localIntentFilter2.addDataScheme("package");
          }
          localIntentFilter2.addAction(localActionHandler.action);
        }
        localIntentFilter1.addAction(localActionHandler.action);
      }
    }
  }

  public void InitializeWithPhoneState(BA paramBA, String paramString, Phone.PhoneId paramPhoneId)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 25	anywheresoftware/b4a/phone/PhoneEvents:map	Ljava/util/HashMap;
    //   4: ldc 222
    //   6: new 224	anywheresoftware/b4a/phone/PhoneEvents$15
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 225	anywheresoftware/b4a/phone/PhoneEvents$15:<init>	(Lanywheresoftware/b4a/phone/PhoneEvents;)V
    //   14: invokevirtual 36	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   17: pop
    //   18: aload_0
    //   19: getfield 25	anywheresoftware/b4a/phone/PhoneEvents:map	Ljava/util/HashMap;
    //   22: ldc 222
    //   24: invokevirtual 229	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 128	anywheresoftware/b4a/phone/PhoneEvents$ActionHandler
    //   30: ldc 222
    //   32: putfield 136	anywheresoftware/b4a/phone/PhoneEvents$ActionHandler:action	Ljava/lang/String;
    //   35: aload_0
    //   36: aload_1
    //   37: aload_2
    //   38: invokevirtual 231	anywheresoftware/b4a/phone/PhoneEvents:Initialize	(Lanywheresoftware/b4a/BA;Ljava/lang/String;)V
    //   41: return
  }

  public void StopListening()
  {
    if (this.br != null)
      BA.applicationContext.unregisterReceiver(this.br);
    this.br = null;
  }

  private abstract class ActionHandler
  {
    public String action;
    public String event;
    public int resultCode;

    private ActionHandler()
    {
    }

    public abstract void handle(Intent paramIntent);

    protected void send(Intent paramIntent, Object[] paramArrayOfObject)
    {
      final Object[] arrayOfObject;
      if (paramArrayOfObject == null)
        arrayOfObject = new Object[1];
      while (true)
      {
        arrayOfObject[(arrayOfObject.length - 1)] = AbsObjectWrapper.ConvertToWrapper(new IntentWrapper(), paramIntent);
        if (!BA.debugMode)
          break;
        BA.handler.post(new BA.B4ARunnable()
        {
          public void run()
          {
            PhoneEvents.this.ba.raiseEvent(this, PhoneEvents.this.ev + PhoneEvents.ActionHandler.this.event, arrayOfObject);
          }
        });
        return;
        arrayOfObject = new Object[1 + paramArrayOfObject.length];
        System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, paramArrayOfObject.length);
      }
      PhoneEvents.this.ba.raiseEvent(this, PhoneEvents.this.ev + this.event, arrayOfObject);
    }
  }

  @BA.ShortName("SmsInterceptor")
  public static class SMSInterceptor
  {
    private BA ba;
    private BroadcastReceiver br;
    private String eventName;

    public void Initialize(String paramString, BA paramBA)
    {
      Initialize2(paramString, paramBA, 0);
    }

    public void Initialize2(String paramString, final BA paramBA, int paramInt)
    {
      this.ba = paramBA;
      this.eventName = paramString.toLowerCase(BA.cul);
      this.br = new BroadcastReceiver()
      {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          if (!paramAnonymousIntent.getAction().equals("android.provider.Telephony.SMS_RECEIVED"));
          while (true)
          {
            return;
            Bundle localBundle = paramAnonymousIntent.getExtras();
            if (localBundle != null)
            {
              Object[] arrayOfObject1 = (Object[])localBundle.get("pdus");
              for (int i = 0; i < arrayOfObject1.length; i++)
              {
                SmsMessage localSmsMessage = SmsMessage.createFromPdu((byte[])arrayOfObject1[i]);
                BA localBA = paramBA;
                PhoneEvents.SMSInterceptor localSMSInterceptor = PhoneEvents.SMSInterceptor.this;
                String str = PhoneEvents.SMSInterceptor.this.eventName + "_messagereceived";
                Object[] arrayOfObject2 = new Object[2];
                arrayOfObject2[0] = localSmsMessage.getOriginatingAddress();
                arrayOfObject2[1] = localSmsMessage.getMessageBody();
                Boolean localBoolean = (Boolean)localBA.raiseEvent(localSMSInterceptor, str, arrayOfObject2);
                if ((localBoolean != null) && (localBoolean.booleanValue()))
                  abortBroadcast();
              }
            }
          }
        }
      };
      IntentFilter localIntentFilter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
      localIntentFilter.setPriority(paramInt);
      BA.applicationContext.registerReceiver(this.br, localIntentFilter);
    }

    public void ListenToOutgoingMessages()
    {
      final Uri localUri = Uri.parse("content://sms");
      ContentObserver local1 = new ContentObserver(new Handler())
      {
        public void onChange(boolean paramAnonymousBoolean)
        {
          super.onChange(paramAnonymousBoolean);
          Cursor localCursor = BA.applicationContext.getContentResolver().query(localUri, null, null, null, null);
          if (localCursor.moveToNext())
          {
            String str1 = localCursor.getString(localCursor.getColumnIndex("protocol"));
            int i = localCursor.getInt(localCursor.getColumnIndex("type"));
            if ((str1 == null) && (i == 2));
          }
          else
          {
            return;
          }
          BA localBA = PhoneEvents.SMSInterceptor.this.ba;
          String str2 = PhoneEvents.SMSInterceptor.this.eventName + "_messagesent";
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Integer.valueOf(localCursor.getInt(localCursor.getColumnIndex("_id")));
          localBA.raiseEvent(null, str2, arrayOfObject);
          localCursor.close();
        }
      };
      BA.applicationContext.getContentResolver().registerContentObserver(localUri, true, local1);
    }

    public void StopListening()
    {
      if (this.br != null)
        BA.applicationContext.unregisterReceiver(this.br);
      this.br = null;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.phone.PhoneEvents
 * JD-Core Version:    0.6.2
 */