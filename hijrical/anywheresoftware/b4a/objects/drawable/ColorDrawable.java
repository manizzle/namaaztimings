package anywheresoftware.b4a.objects.drawable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.View;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.objects.ViewWrapper;
import java.util.HashMap;

@BA.ShortName("ColorDrawable")
@BA.ActivityObject
public class ColorDrawable extends AbsObjectWrapper<Drawable>
{
  @BA.Hide
  public static Drawable build(Object paramObject1, HashMap<String, Object> paramHashMap, boolean paramBoolean, Object paramObject2)
  {
    int i = ((Integer)paramHashMap.get("alpha")).intValue();
    int j = ((Integer)paramHashMap.get("color")).intValue();
    if (j == -984833)
      if (paramBoolean)
      {
        if ((Drawable)ViewWrapper.getDefault((View)paramObject1, "background", null) == null)
          return new android.graphics.drawable.ColorDrawable(0);
      }
      else
        return null;
    int k = i << 24 | j << 8 >>> 8;
    Integer localInteger = (Integer)paramHashMap.get("cornerRadius");
    if (localInteger == null)
      localInteger = Integer.valueOf(0);
    ColorDrawable localColorDrawable = new ColorDrawable();
    localColorDrawable.Initialize(k, (int)(BALayout.getDeviceScale() * localInteger.intValue()));
    return (Drawable)localColorDrawable.getObject();
  }

  public void Initialize(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      setObject(new android.graphics.drawable.ColorDrawable(paramInt1));
      return;
    }
    GradientDrawableWithCorners localGradientDrawableWithCorners = new GradientDrawableWithCorners(GradientDrawable.Orientation.BL_TR, new int[] { paramInt1, paramInt1 });
    localGradientDrawableWithCorners.setCornerRadius(paramInt2);
    setObject(localGradientDrawableWithCorners);
  }

  @BA.Hide
  public static class GradientDrawableWithCorners extends GradientDrawable
  {
    public float cornerRadius;

    public GradientDrawableWithCorners(GradientDrawable.Orientation paramOrientation, int[] paramArrayOfInt)
    {
      super(paramArrayOfInt);
    }

    public void setCornerRadius(float paramFloat)
    {
      super.setCornerRadius(paramFloat);
      this.cornerRadius = paramFloat;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.drawable.ColorDrawable
 * JD-Core Version:    0.6.2
 */