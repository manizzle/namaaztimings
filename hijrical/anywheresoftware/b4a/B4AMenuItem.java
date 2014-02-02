package anywheresoftware.b4a;

import android.graphics.drawable.Drawable;

public class B4AMenuItem
{
  public final boolean addToBar;
  public final Drawable drawable;
  public final String eventName;
  public final String title;

  public B4AMenuItem(String paramString1, Drawable paramDrawable, String paramString2, boolean paramBoolean)
  {
    this.title = paramString1;
    this.drawable = paramDrawable;
    this.eventName = paramString2;
    this.addToBar = paramBoolean;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.B4AMenuItem
 * JD-Core Version:    0.6.2
 */