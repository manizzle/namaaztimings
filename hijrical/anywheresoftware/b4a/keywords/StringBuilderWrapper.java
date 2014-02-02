package anywheresoftware.b4a.keywords;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.B4aDebuggable;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;

@BA.ShortName("StringBuilder")
public class StringBuilderWrapper extends AbsObjectWrapper<StringBuilder>
  implements BA.B4aDebuggable
{
  public StringBuilderWrapper Append(String paramString)
  {
    ((StringBuilder)getObject()).append(paramString);
    return this;
  }

  public void Initialize()
  {
    setObject(new StringBuilder());
  }

  public StringBuilderWrapper Insert(int paramInt, String paramString)
  {
    ((StringBuilder)getObject()).insert(paramInt, paramString);
    return this;
  }

  public StringBuilderWrapper Remove(int paramInt1, int paramInt2)
  {
    ((StringBuilder)getObject()).delete(paramInt1, paramInt2);
    return this;
  }

  public String ToString()
  {
    return ((StringBuilder)getObject()).toString();
  }

  @BA.Hide
  public Object[] debug(int paramInt, boolean[] paramArrayOfBoolean)
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = "Length";
    arrayOfObject[1] = Integer.valueOf(getLength());
    arrayOfObject[2] = "ToString";
    arrayOfObject[3] = toString();
    paramArrayOfBoolean[0] = true;
    return arrayOfObject;
  }

  public int getLength()
  {
    return ((StringBuilder)getObject()).length();
  }

  @BA.Hide
  public String toString()
  {
    if (getObjectOrNull() == null)
      return "null";
    return ((StringBuilder)getObject()).toString();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.keywords.StringBuilderWrapper
 * JD-Core Version:    0.6.2
 */