package anywheresoftware.b4a.objects.drawable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BALayout;
import java.util.HashMap;

@BA.ShortName("GradientDrawable")
@BA.ActivityObject
public class GradientDrawable extends AbsObjectWrapper<android.graphics.drawable.GradientDrawable>
{
  @BA.Hide
  public static Drawable build(Object paramObject1, HashMap<String, Object> paramHashMap, boolean paramBoolean, Object paramObject2)
  {
    GradientDrawable.Orientation localOrientation = (GradientDrawable.Orientation)Enum.valueOf(GradientDrawable.Orientation.class, (String)paramHashMap.get("orientation"));
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = ((Integer)paramHashMap.get("firstColor")).intValue();
    arrayOfInt[1] = ((Integer)paramHashMap.get("secondColor")).intValue();
    android.graphics.drawable.GradientDrawable localGradientDrawable = new android.graphics.drawable.GradientDrawable(localOrientation, arrayOfInt);
    localGradientDrawable.setCornerRadius((int)(BALayout.getDeviceScale() * ((Integer)paramHashMap.get("cornerRadius")).intValue()));
    return localGradientDrawable;
  }

  public void Initialize(GradientDrawable.Orientation paramOrientation, int[] paramArrayOfInt)
  {
    setObject(new android.graphics.drawable.GradientDrawable(paramOrientation, paramArrayOfInt));
  }

  public void setCornerRadius(float paramFloat)
  {
    ((android.graphics.drawable.GradientDrawable)getObject()).setCornerRadius(paramFloat);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.drawable.GradientDrawable
 * JD-Core Version:    0.6.2
 */