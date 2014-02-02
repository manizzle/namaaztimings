package anywheresoftware.b4a.objects;

import android.view.View;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;

@BA.ShortName("View")
@BA.ActivityObject
public class ConcreteViewWrapper extends ViewWrapper<View>
{
  @BA.Hide
  public void Initialize(BA paramBA, String paramString)
  {
    throw new RuntimeException("Cannot initialize object.");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.ConcreteViewWrapper
 * JD-Core Version:    0.6.2
 */