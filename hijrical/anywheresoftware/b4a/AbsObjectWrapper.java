package anywheresoftware.b4a;

public class AbsObjectWrapper<T>
  implements ObjectWrapper<T>
{

  @BA.Hide
  public static boolean Activity_LoadLayout_Was_Called = false;
  private T object;

  @BA.Hide
  public static ObjectWrapper ConvertToWrapper(ObjectWrapper paramObjectWrapper, Object paramObject)
  {
    paramObjectWrapper.setObject(paramObject);
    return paramObjectWrapper;
  }

  public boolean IsInitialized()
  {
    return this.object != null;
  }

  @BA.Hide
  public String baseToString()
  {
    String str1;
    if (this.object != null)
      str1 = this.object.getClass().getSimpleName();
    while (true)
    {
      int i = str1.lastIndexOf(".");
      if (i > -1)
        str1 = str1.substring(i + 1);
      String str2 = "(" + str1 + ")";
      if (this.object == null)
        str2 = str2 + " Not initialized";
      return str2;
      BA.ShortName localShortName = (BA.ShortName)getClass().getAnnotation(BA.ShortName.class);
      if (localShortName != null)
        str1 = localShortName.value();
      else
        str1 = getClass().getSimpleName();
    }
  }

  @BA.Hide
  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (paramObject == null)
      return this.object == null;
    if ((paramObject instanceof AbsObjectWrapper))
    {
      AbsObjectWrapper localAbsObjectWrapper = (AbsObjectWrapper)paramObject;
      if (this.object == null)
        return localAbsObjectWrapper.object == null;
      return this.object.equals(localAbsObjectWrapper.object);
    }
    if (this.object == null)
      return false;
    return this.object.equals(paramObject);
  }

  @BA.Hide
  public T getObject()
  {
    if (this.object == null)
    {
      BA.ShortName localShortName = (BA.ShortName)getClass().getAnnotation(BA.ShortName.class);
      Object localObject;
      if (localShortName == null)
        localObject = "Object should first be initialized" + ".";
      try
      {
        while (true)
        {
          if ((Class.forName("anywheresoftware.b4a.objects.ViewWrapper").isInstance(this)) && (!Activity_LoadLayout_Was_Called))
          {
            String str = localObject + "\nDid you forget to call Activity.LoadLayout?";
            localObject = str;
          }
          throw new RuntimeException((String)localObject);
          localObject = "Object should first be initialized" + " (" + localShortName.value() + ").";
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        while (true)
          localClassNotFoundException.printStackTrace();
      }
    }
    return this.object;
  }

  @BA.Hide
  public T getObjectOrNull()
  {
    return this.object;
  }

  @BA.Hide
  public int hashCode()
  {
    if (this.object == null)
      return 0;
    return this.object.hashCode();
  }

  @BA.Hide
  public void setObject(T paramT)
  {
    this.object = paramT;
  }

  @BA.Hide
  public String toString()
  {
    String str = baseToString();
    if (this.object == null)
      return str;
    return str + " " + this.object.toString();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.AbsObjectWrapper
 * JD-Core Version:    0.6.2
 */