package anywheresoftware.b4a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.HashMap;

public class BALayout extends ViewGroup
{
  private static float deviceScale = 0.0F;
  private static float scale = 0.0F;

  public BALayout(Context paramContext)
  {
    super(paramContext);
  }

  public static float getDeviceScale()
  {
    return deviceScale;
  }

  public static void setDeviceScale(float paramFloat)
  {
    deviceScale = paramFloat;
  }

  public static void setUserScale(float paramFloat)
  {
    if (Float.compare(deviceScale, paramFloat) == 0)
    {
      scale = 1.0F;
      return;
    }
    scale = deviceScale / paramFloat;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getChildCount();
    int j = 0;
    if (j >= i)
      return;
    View localView = getChildAt(j);
    if (localView.getVisibility() != 8)
    {
      if (!(localView.getLayoutParams() instanceof LayoutParams))
        break label99;
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      localView.layout(localLayoutParams.left, localLayoutParams.top, localLayoutParams.left + localView.getMeasuredWidth(), localLayoutParams.top + localView.getMeasuredHeight());
    }
    while (true)
    {
      j++;
      break;
      label99: localView.layout(0, 0, getLayoutParams().width, getLayoutParams().height);
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    measureChildren(paramInt1, paramInt2);
    setMeasuredDimension(resolveSize(getLayoutParams().width, paramInt1), resolveSize(getLayoutParams().height, paramInt2));
  }

  public static class LayoutParams extends ViewGroup.LayoutParams
  {
    public int left;
    public int top;

    public LayoutParams()
    {
      super(0);
    }

    public LayoutParams(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super(paramInt4);
      this.left = paramInt1;
      this.top = paramInt2;
    }

    public void setFromUserPlane(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.left = ((int)(paramInt1 * BALayout.scale));
      this.top = ((int)(paramInt2 * BALayout.scale));
      int i;
      if (paramInt3 > 0)
      {
        i = (int)(paramInt3 * BALayout.scale);
        this.width = i;
        if (paramInt4 <= 0)
          break label69;
      }
      label69: for (int j = (int)(paramInt4 * BALayout.scale); ; j = paramInt4)
      {
        this.height = j;
        return;
        i = paramInt3;
        break;
      }
    }

    public HashMap<String, Object> toDesignerMap()
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("left", Integer.valueOf((int)(this.left / BALayout.scale)));
      localHashMap.put("top", Integer.valueOf((int)(this.top / BALayout.scale)));
      localHashMap.put("width", Integer.valueOf((int)(this.width / BALayout.scale)));
      localHashMap.put("height", Integer.valueOf((int)(this.height / BALayout.scale)));
      return localHashMap;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.BALayout
 * JD-Core Version:    0.6.2
 */