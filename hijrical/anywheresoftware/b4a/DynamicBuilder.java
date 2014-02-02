package anywheresoftware.b4a;

import android.util.Log;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class DynamicBuilder
{
  public static <T> T build(Object paramObject1, HashMap<String, Object> paramHashMap, boolean paramBoolean, Object paramObject2)
  {
    String str1 = (String)paramHashMap.get("type");
    try
    {
      if (str1.startsWith("."))
        str1 = "anywheresoftware.b4a.objects" + str1;
      Class localClass = Class.forName(str1);
      Class[] arrayOfClass = new Class[4];
      arrayOfClass[0] = Object.class;
      arrayOfClass[1] = HashMap.class;
      arrayOfClass[2] = Boolean.TYPE;
      arrayOfClass[3] = Object.class;
      Method localMethod = localClass.getMethod("build", arrayOfClass);
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = paramObject1;
      arrayOfObject[1] = paramHashMap;
      arrayOfObject[2] = Boolean.valueOf(paramBoolean);
      arrayOfObject[3] = paramObject2;
      Object localObject = localMethod.invoke(null, arrayOfObject);
      return localObject;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      String str2 = "B4A";
      if ((localInvocationTargetException.getCause() instanceof FileNotFoundException))
        str2 = "";
      Log.e(str2, "", localInvocationTargetException);
      return null;
    }
    catch (Exception localException)
    {
      while (true)
        Log.e("B4A", "", localException);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.DynamicBuilder
 * JD-Core Version:    0.6.2
 */