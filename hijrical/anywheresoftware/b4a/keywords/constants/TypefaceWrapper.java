package anywheresoftware.b4a.keywords.constants;

import android.app.Application;
import android.graphics.Typeface;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ShortName;

@BA.ShortName("Typeface")
public class TypefaceWrapper extends AbsObjectWrapper<Typeface>
{
  public static final Typeface DEFAULT = Typeface.DEFAULT;
  public static final Typeface DEFAULT_BOLD = Typeface.DEFAULT_BOLD;
  public static final Typeface MONOSPACE = Typeface.MONOSPACE;
  public static final Typeface SANS_SERIF = Typeface.SANS_SERIF;
  public static final Typeface SERIF = Typeface.SERIF;
  public static final int STYLE_BOLD = 1;
  public static final int STYLE_BOLD_ITALIC = 3;
  public static final int STYLE_ITALIC = 2;
  public static final int STYLE_NORMAL;

  public static Typeface CreateNew(Typeface paramTypeface, int paramInt)
  {
    return Typeface.create(paramTypeface, paramInt);
  }

  public static Typeface LoadFromAssets(String paramString)
  {
    return Typeface.createFromAsset(BA.applicationContext.getAssets(), paramString.toLowerCase(BA.cul));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.keywords.constants.TypefaceWrapper
 * JD-Core Version:    0.6.2
 */