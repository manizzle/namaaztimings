package anywheresoftware.b4a.objects;

import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;

@BA.ShortName("Accessiblity")
@BA.Version(1.0F)
public class Accessibility
{
  public static float GetUserFontScale()
  {
    return BA.applicationContext.getResources().getConfiguration().fontScale;
  }

  public static void SetContentDescription(View paramView, CharSequence paramCharSequence)
  {
    paramView.setContentDescription(paramCharSequence);
  }

  public static void SetNextFocusDown(View paramView1, View paramView2)
  {
    paramView1.setNextFocusDownId(paramView2.getId());
  }

  public static void SetNextFocusLeft(View paramView1, View paramView2)
  {
    paramView1.setNextFocusLeftId(paramView2.getId());
  }

  public static void SetNextFocusRight(View paramView1, View paramView2)
  {
    paramView1.setNextFocusRightId(paramView2.getId());
  }

  public static void SetNextFocusUp(View paramView1, View paramView2)
  {
    paramView1.setNextFocusUpId(paramView2.getId());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.Accessibility
 * JD-Core Version:    0.6.2
 */