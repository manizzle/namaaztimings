package anywheresoftware.b4a.objects;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;

@BA.ShortName("Exception")
public class B4AException extends AbsObjectWrapper<Exception>
{
  public String getMessage()
  {
    return ((Exception)getObject()).toString();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.B4AException
 * JD-Core Version:    0.6.2
 */