package anywheresoftware.b4a.objects.drawable;

import android.graphics.drawable.Drawable;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.DynamicBuilder;
import java.util.HashMap;

@BA.ShortName("StateListDrawable")
@BA.ActivityObject
public class StateListDrawable extends AbsObjectWrapper<android.graphics.drawable.StateListDrawable>
{
  public static final int State_Checked = 16842912;
  public static final int State_Disabled = -16842910;
  public static final int State_Enabled = 16842910;
  public static final int State_Focused = 16842908;
  public static final int State_Pressed = 16842919;
  public static final int State_Selected = 16842913;
  public static final int State_Unchecked = -16842912;

  @BA.Hide
  public static Drawable build(Object paramObject1, HashMap<String, Object> paramHashMap, boolean paramBoolean, Object paramObject2)
  {
    android.graphics.drawable.StateListDrawable localStateListDrawable = new android.graphics.drawable.StateListDrawable();
    Drawable localDrawable1 = (Drawable)DynamicBuilder.build(paramObject1, (HashMap)paramHashMap.get("disabledDrawable"), paramBoolean, paramObject2);
    Drawable localDrawable2 = (Drawable)DynamicBuilder.build(paramObject1, (HashMap)paramHashMap.get("enabledDrawable"), paramBoolean, paramObject2);
    Drawable localDrawable3 = (Drawable)DynamicBuilder.build(paramObject1, (HashMap)paramHashMap.get("pressedDrawable"), paramBoolean, paramObject2);
    localStateListDrawable.addState(new int[] { -16842910 }, localDrawable1);
    localStateListDrawable.addState(new int[] { 16842919 }, localDrawable3);
    localStateListDrawable.addState(new int[0], localDrawable2);
    return localStateListDrawable;
  }

  public void AddCatchAllState(Drawable paramDrawable)
  {
    ((android.graphics.drawable.StateListDrawable)getObject()).addState(new int[0], paramDrawable);
  }

  public void AddState(int paramInt, Drawable paramDrawable)
  {
    ((android.graphics.drawable.StateListDrawable)getObject()).addState(new int[] { paramInt }, paramDrawable);
  }

  public void AddState2(int[] paramArrayOfInt, Drawable paramDrawable)
  {
    ((android.graphics.drawable.StateListDrawable)getObject()).addState(paramArrayOfInt, paramDrawable);
  }

  public void Initialize()
  {
    setObject(new android.graphics.drawable.StateListDrawable());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.drawable.StateListDrawable
 * JD-Core Version:    0.6.2
 */