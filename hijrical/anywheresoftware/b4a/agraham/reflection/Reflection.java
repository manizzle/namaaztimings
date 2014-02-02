package anywheresoftware.b4a.agraham.reflection;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.SharedProcessBA;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

@BA.Author("Andrew Graham")
@BA.ShortName("Reflector")
@BA.Version(2.4F)
public class Reflection
{
  private static HashMap<String, Class<?>> primitives = new HashMap()
  {
    private static final long serialVersionUID = 1L;
  };
  private static final double version = 2.4D;
  public Object Target;

  private static Class<?> classforname(String paramString)
  {
    if (primitives.containsKey(paramString))
      return (Class)primitives.get(paramString);
    try
    {
      Class localClass = Class.forName(paramString);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new RuntimeException(localClassNotFoundException);
    }
  }

  private Object runmethod(String paramString, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass)
    throws Exception
  {
    Class localClass1 = Class.forName("java.lang.Object");
    Class localClass2 = this.Target.getClass();
    Boolean localBoolean = Boolean.valueOf(true);
    while (true)
    {
      if (localClass2 == localClass1);
      try
      {
        localBoolean = Boolean.valueOf(false);
        Method localMethod = localClass2.getDeclaredMethod(paramString, paramArrayOfClass);
        localMethod.setAccessible(true);
        Object localObject = localMethod.invoke(this.Target, paramArrayOfObject);
        return localObject;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        localClass2 = localClass2.getSuperclass();
        if (localBoolean.booleanValue())
          continue;
        throw localNoSuchMethodException;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw ((Exception)localInvocationTargetException.getCause());
      }
    }
  }

  private static Object sethelper(String paramString, Class paramClass)
  {
    if (paramClass.isEnum())
      return Enum.valueOf(paramClass, paramString);
    if (paramClass.isPrimitive())
    {
      if (paramClass == Boolean.TYPE)
        return Boolean.valueOf(Boolean.parseBoolean(paramString));
      if (paramClass == Byte.TYPE)
        return Byte.valueOf(Byte.parseByte(paramString));
      if (paramClass == Character.TYPE)
        return Character.valueOf(paramString.charAt(0));
      if (paramClass == Short.TYPE)
        return Short.valueOf(Short.parseShort(paramString));
      if (paramClass == Integer.TYPE)
        return Integer.valueOf(Integer.parseInt(paramString));
      if (paramClass == Long.TYPE)
        return Long.valueOf(Long.parseLong(paramString));
      if (paramClass == Float.TYPE)
        return Float.valueOf(Float.parseFloat(paramString));
      if (paramClass == Double.TYPE)
        return Double.valueOf(Double.parseDouble(paramString));
    }
    return paramString;
  }

  public Object CreateObject(String paramString)
  {
    try
    {
      Object localObject = classforname(paramString).newInstance();
      return localObject;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  public Object CreateObject2(String paramString, Object[] paramArrayOfObject, String[] paramArrayOfString)
  {
    Class[] arrayOfClass = new Class[paramArrayOfObject.length];
    try
    {
      Class localClass = classforname(paramString);
      for (int i = 0; ; i++)
      {
        if (i >= paramArrayOfObject.length)
          return localClass.getConstructor(arrayOfClass).newInstance(paramArrayOfObject);
        arrayOfClass[i] = classforname(paramArrayOfString[i]);
      }
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  public Activity GetActivity(BA paramBA)
  {
    return ((BA)paramBA.sharedProcessBA.activityBA.get()).activity;
  }

  public BA GetActivityBA(BA paramBA)
  {
    return (BA)paramBA.sharedProcessBA.activityBA.get();
  }

  public Object GetArray(int[] paramArrayOfInt)
  {
    Object localObject = this.Target;
    for (int i = 0; ; i++)
    {
      if (i >= paramArrayOfInt.length - 1)
        return Array.get(localObject, paramArrayOfInt[(paramArrayOfInt.length - 1)]);
      localObject = Array.get(localObject, paramArrayOfInt[i]);
    }
  }

  public Class<?> GetB4AClass(String paramString)
  {
    try
    {
      Class localClass = Class.forName(BA.packageName + "." + paramString.toLowerCase(BA.cul));
      return localClass;
    }
    catch (Exception localException)
    {
    }
    throw new RuntimeException("Class " + paramString + " not found.");
  }

  public Context GetContext(BA paramBA)
  {
    return paramBA.context;
  }

  public Object GetField(String paramString)
    throws Exception
  {
    Class localClass1 = Class.forName("java.lang.Object");
    Class localClass2 = this.Target.getClass();
    do
      try
      {
        Field localField = localClass2.getDeclaredField(paramString);
        localField.setAccessible(true);
        Object localObject = localField.get(this.Target);
        return localObject;
      }
      catch (Exception localException)
      {
        localClass2 = localClass2.getSuperclass();
      }
    while (localClass2 != localClass1);
    throw localException;
  }

  public Object GetField2(Field paramField)
    throws Exception
  {
    return paramField.get(this.Target);
  }

  public Field GetFieldInfo(String paramString)
    throws Exception
  {
    Class localClass1 = Class.forName("java.lang.Object");
    Class localClass2 = this.Target.getClass();
    do
      try
      {
        Field localField = localClass2.getDeclaredField(paramString);
        localField.setAccessible(true);
        return localField;
      }
      catch (Exception localException)
      {
        localClass2 = localClass2.getSuperclass();
      }
    while (localClass2 != localClass1);
    throw localException;
  }

  public Method GetMethod(String paramString, String[] paramArrayOfString)
    throws Exception
  {
    Class localClass1 = Class.forName("java.lang.Object");
    Class localClass2 = this.Target.getClass();
    if (paramArrayOfString == null)
      paramArrayOfString = new String[0];
    Class[] arrayOfClass = new Class[paramArrayOfString.length];
    int i = 0;
    if (i >= paramArrayOfString.length);
    do
      try
      {
        Method localMethod = localClass2.getDeclaredMethod(paramString, arrayOfClass);
        localMethod.setAccessible(true);
        return localMethod;
        arrayOfClass[i] = classforname(paramArrayOfString[i]);
        i++;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        localClass2 = localClass2.getSuperclass();
      }
    while (localClass2 != localClass1);
    throw localNoSuchMethodException;
  }

  public Object GetMostCurrent(String paramString)
  {
    try
    {
      Field localField = Class.forName(BA.packageName + "." + paramString.toLowerCase(BA.cul)).getDeclaredField("mostCurrent");
      localField.setAccessible(true);
      Object localObject = localField.get(null);
      return localObject;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  public BA GetProcessBA(String paramString)
  {
    try
    {
      Field localField = Class.forName(BA.packageName + "." + paramString.toLowerCase(BA.cul)).getDeclaredField("processBA");
      localField.setAccessible(true);
      BA localBA = (BA)localField.get(null);
      return localBA;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  public Proxy GetProxy(BA paramBA, String[] paramArrayOfString, String paramString)
    throws ClassNotFoundException
  {
    Class[] arrayOfClass = new Class[paramArrayOfString.length];
    for (int i = 0; ; i++)
    {
      if (i >= paramArrayOfString.length)
        return (Proxy)Proxy.newProxyInstance(arrayOfClass[0].getClassLoader(), arrayOfClass, new MyInvocationHandler(paramBA, paramString));
      arrayOfClass[i] = Class.forName(paramArrayOfString[i]);
    }
  }

  public Object GetPublicField(String paramString)
  {
    try
    {
      Object localObject = this.Target.getClass().getField(paramString).get(this.Target);
      return localObject;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  public Object GetStaticField(String paramString1, String paramString2)
    throws Exception
  {
    Class localClass1 = Class.forName("java.lang.Object");
    Class localClass2 = Class.forName(paramString1);
    do
      try
      {
        Field localField = localClass2.getDeclaredField(paramString2);
        localField.setAccessible(true);
        Object localObject = localField.get(null);
        return localObject;
      }
      catch (Exception localException)
      {
        localClass2 = localClass2.getSuperclass();
      }
    while (localClass2 != localClass1);
    throw localException;
  }

  public Object InvokeMethod(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    throws Exception
  {
    try
    {
      Object localObject = paramMethod.invoke(paramObject, paramArrayOfObject);
      return localObject;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw ((Exception)localInvocationTargetException.getCause());
    }
  }

  public void LIBRARY_DOC()
  {
  }

  public Object RunMethod(String paramString)
    throws Exception
  {
    return runmethod(paramString, new Object[0], new Class[0]);
  }

  public Object RunMethod2(String paramString1, String paramString2, String paramString3)
    throws Exception
  {
    Object[] arrayOfObject = new Object[1];
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = classforname(paramString3);
    arrayOfObject[0] = sethelper(paramString2, arrayOfClass[0]);
    return runmethod(paramString1, arrayOfObject, arrayOfClass);
  }

  public Object RunMethod3(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws Exception
  {
    Object[] arrayOfObject = new Object[2];
    Class[] arrayOfClass = new Class[2];
    arrayOfClass[0] = classforname(paramString3);
    arrayOfClass[1] = classforname(paramString5);
    arrayOfObject[0] = sethelper(paramString2, arrayOfClass[0]);
    arrayOfObject[1] = sethelper(paramString4, arrayOfClass[1]);
    return runmethod(paramString1, arrayOfObject, arrayOfClass);
  }

  public Object RunMethod4(String paramString, Object[] paramArrayOfObject, String[] paramArrayOfString)
    throws Exception
  {
    if (paramArrayOfString == null)
      paramArrayOfString = new String[0];
    Class[] arrayOfClass = new Class[paramArrayOfString.length];
    for (int i = 0; ; i++)
    {
      if (i >= paramArrayOfString.length)
        return runmethod(paramString, paramArrayOfObject, arrayOfClass);
      arrayOfClass[i] = classforname(paramArrayOfString[i]);
    }
  }

  public Object RunPublicmethod(String paramString, Object[] paramArrayOfObject, String[] paramArrayOfString)
  {
    if (paramArrayOfString == null)
      paramArrayOfString = new String[0];
    Class[] arrayOfClass = new Class[paramArrayOfString.length];
    int i = 0;
    while (true)
    {
      if (i >= paramArrayOfString.length);
      try
      {
        Object localObject = this.Target.getClass().getMethod(paramString, arrayOfClass).invoke(this.Target, paramArrayOfObject);
        return localObject;
        arrayOfClass[i] = classforname(paramArrayOfString[i]);
        i++;
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
    }
  }

  public Object RunStaticMethod(String paramString1, String paramString2, Object[] paramArrayOfObject, String[] paramArrayOfString)
    throws Exception
  {
    if (paramArrayOfString == null)
      paramArrayOfString = new String[0];
    Class localClass1 = Class.forName("java.lang.Object");
    Class localClass2 = Class.forName(paramString1);
    Class[] arrayOfClass = new Class[paramArrayOfString.length];
    int i = 0;
    while (true)
    {
      if (i >= paramArrayOfString.length);
      try
      {
        Method localMethod = localClass2.getDeclaredMethod(paramString2, arrayOfClass);
        localMethod.setAccessible(true);
        Object localObject = localMethod.invoke(null, paramArrayOfObject);
        return localObject;
        arrayOfClass[i] = classforname(paramArrayOfString[i]);
        i++;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        do
          localClass2 = localClass2.getSuperclass();
        while (localClass2 != localClass1);
        throw localNoSuchMethodException;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw ((Exception)localInvocationTargetException.getCause());
      }
    }
  }

  public void SetArray(int[] paramArrayOfInt, String paramString1, String paramString2)
  {
    Object localObject1 = this.Target;
    for (int i = 0; ; i++)
    {
      if (i >= paramArrayOfInt.length - 1)
      {
        Object localObject2 = sethelper(paramString1, classforname(paramString2));
        Array.set(localObject1, paramArrayOfInt[(paramArrayOfInt.length - 1)], localObject2);
        return;
      }
      localObject1 = Array.get(localObject1, paramArrayOfInt[i]);
    }
  }

  public void SetArray2(int[] paramArrayOfInt, Object paramObject)
  {
    Object localObject = this.Target;
    for (int i = 0; ; i++)
    {
      if (i >= paramArrayOfInt.length - 1)
      {
        Array.set(localObject, paramArrayOfInt[(paramArrayOfInt.length - 1)], paramObject);
        return;
      }
      localObject = Array.get(localObject, paramArrayOfInt[i]);
    }
  }

  public void SetField(String paramString1, String paramString2, String paramString3)
    throws Exception
  {
    Class localClass1 = Class.forName("java.lang.Object");
    Class localClass2 = this.Target.getClass();
    do
      try
      {
        Field localField = localClass2.getDeclaredField(paramString1);
        localField.setAccessible(true);
        Object localObject = sethelper(paramString2, classforname(paramString3));
        localField.set(this.Target, localObject);
        return;
      }
      catch (Exception localException)
      {
        localClass2 = localClass2.getSuperclass();
      }
    while (localClass2 != localClass1);
    throw localException;
  }

  public void SetField2(String paramString, Object paramObject)
    throws Exception
  {
    Class localClass1 = Class.forName("java.lang.Object");
    Class localClass2 = this.Target.getClass();
    do
      try
      {
        Field localField = localClass2.getDeclaredField(paramString);
        localField.setAccessible(true);
        localField.set(this.Target, paramObject);
        return;
      }
      catch (Exception localException)
      {
        localClass2 = localClass2.getSuperclass();
      }
    while (localClass2 != localClass1);
    throw localException;
  }

  public void SetField3(Field paramField, String paramString1, String paramString2)
    throws Exception
  {
    Object localObject = sethelper(paramString1, classforname(paramString2));
    paramField.set(this.Target, localObject);
  }

  public void SetField4(Field paramField, Object paramObject)
    throws Exception
  {
    paramField.set(this.Target, paramObject);
  }

  public void SetOnClickListener(final BA paramBA, String paramString)
  {
    final String str = paramString.toLowerCase();
    ((View)this.Target).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        BA localBA = paramBA;
        String str = str;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = paramAnonymousView.getTag();
        localBA.raiseEvent(paramAnonymousView, str, arrayOfObject);
      }
    });
  }

  public void SetOnCreateContextMenuListener(final BA paramBA, String paramString)
  {
    final String str = paramString.toLowerCase();
    ((View)this.Target).setOnCreateContextMenuListener(new View.OnCreateContextMenuListener()
    {
      public void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        BA localBA = paramBA;
        String str = str;
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = paramAnonymousView.getTag();
        arrayOfObject[1] = paramAnonymousContextMenu;
        arrayOfObject[2] = paramAnonymousContextMenuInfo;
        localBA.raiseEvent(paramAnonymousView, str, arrayOfObject);
      }
    });
  }

  public void SetOnFocusListener(final BA paramBA, String paramString)
  {
    final String str = paramString.toLowerCase();
    ((View)this.Target).setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        BA localBA = paramBA;
        String str = str;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = paramAnonymousView.getTag();
        arrayOfObject[1] = Boolean.valueOf(paramAnonymousBoolean);
        localBA.raiseEvent(paramAnonymousView, str, arrayOfObject);
      }
    });
  }

  public void SetOnKeyListener(final BA paramBA, String paramString)
  {
    final String str = paramString.toLowerCase();
    ((View)this.Target).setOnKeyListener(new View.OnKeyListener()
    {
      public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        BA localBA = paramBA;
        String str = str;
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = paramAnonymousView.getTag();
        arrayOfObject[1] = Integer.valueOf(paramAnonymousInt);
        arrayOfObject[2] = paramAnonymousKeyEvent;
        Object localObject = localBA.raiseEvent(paramAnonymousView, str, arrayOfObject);
        if (localObject != null)
          return ((Boolean)localObject).booleanValue();
        Log.w("B4A", str + " raiseEvent returned null");
        return false;
      }
    });
  }

  public void SetOnLongClickListener(final BA paramBA, String paramString)
  {
    final String str = paramString.toLowerCase();
    ((View)this.Target).setOnLongClickListener(new View.OnLongClickListener()
    {
      public boolean onLongClick(View paramAnonymousView)
      {
        BA localBA = paramBA;
        String str = str;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = paramAnonymousView.getTag();
        Object localObject = localBA.raiseEvent(paramAnonymousView, str, arrayOfObject);
        if (localObject != null)
          return ((Boolean)localObject).booleanValue();
        Log.w("B4A", str + " raiseEvent returned null");
        return false;
      }
    });
  }

  public void SetOnTouchListener(final BA paramBA, String paramString)
  {
    final String str = paramString.toLowerCase();
    ((View)this.Target).setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        BA localBA = paramBA;
        String str = str;
        Object[] arrayOfObject = new Object[5];
        arrayOfObject[0] = paramAnonymousView.getTag();
        arrayOfObject[1] = Integer.valueOf(paramAnonymousMotionEvent.getAction());
        arrayOfObject[2] = Float.valueOf(paramAnonymousMotionEvent.getX());
        arrayOfObject[3] = Float.valueOf(paramAnonymousMotionEvent.getY());
        arrayOfObject[4] = paramAnonymousMotionEvent;
        Object localObject = localBA.raiseEvent(paramAnonymousView, str, arrayOfObject);
        if (localObject != null)
          return ((Boolean)localObject).booleanValue();
        Log.w("B4A", "raiseEvent for " + str + " returned null");
        return true;
      }
    });
  }

  public void SetPublicField(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      Field localField = this.Target.getClass().getField(paramString1);
      Object localObject = sethelper(paramString2, classforname(paramString3));
      localField.set(this.Target, localObject);
      return;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  public void SetPublicField2(String paramString, Object paramObject)
  {
    try
    {
      this.Target.getClass().getField(paramString).set(this.Target, paramObject);
      return;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  public void SetStaticField(String paramString1, String paramString2, String paramString3, String paramString4)
    throws Exception
  {
    Class localClass1 = Class.forName("java.lang.Object");
    Class localClass2 = Class.forName(paramString1);
    do
      try
      {
        Field localField = localClass2.getDeclaredField(paramString2);
        localField.setAccessible(true);
        localField.set(null, sethelper(paramString3, classforname(paramString4)));
        return;
      }
      catch (Exception localException)
      {
        localClass2 = localClass2.getSuperclass();
      }
    while (localClass2 != localClass1);
    throw localException;
  }

  public void SetStaticField2(String paramString1, String paramString2, Object paramObject)
    throws Exception
  {
    Class localClass1 = Class.forName("java.lang.Object");
    Class localClass2 = Class.forName(paramString1);
    do
      try
      {
        Field localField = localClass2.getDeclaredField(paramString2);
        localField.setAccessible(true);
        localField.set(null, paramObject);
        return;
      }
      catch (Exception localException)
      {
        localClass2 = localClass2.getSuperclass();
      }
    while (localClass2 != localClass1);
    throw localException;
  }

  public int[] TargetRank()
  {
    Class localClass = this.Target.getClass();
    if (!localClass.isArray())
      return new int[0];
    int i = 1 + localClass.getName().lastIndexOf('[');
    int[] arrayOfInt = new int[i];
    Object localObject = this.Target;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return arrayOfInt;
      int k = Array.getLength(localObject);
      arrayOfInt[j] = k;
      if (k > 0)
        localObject = Array.get(localObject, 0);
    }
  }

  public String ToString()
  {
    return this.Target.toString();
  }

  public boolean getIsNull()
  {
    return this.Target == null;
  }

  public String getTypeName()
  {
    return this.Target.getClass().getName();
  }

  public double getVersion()
  {
    return 2.4D;
  }

  private class MyInvocationHandler
    implements InvocationHandler
  {
    BA ba;
    String event;

    public MyInvocationHandler(BA paramString, String arg3)
    {
      Object localObject;
      this.event = localObject.toLowerCase();
      this.ba = paramString;
    }

    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      if (paramArrayOfObject == null)
        paramArrayOfObject = new Object[0];
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramMethod.getName();
      arrayOfObject[1] = paramArrayOfObject;
      return this.ba.raiseEvent(paramObject, this.event, arrayOfObject);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.agraham.reflection.Reflection
 * JD-Core Version:    0.6.2
 */