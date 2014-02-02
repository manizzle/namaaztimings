package anywheresoftware.b4a.objects;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.DynamicBuilder;
import java.util.HashMap;

@BA.ShortName("HorizontalScrollView")
@BA.ActivityObject
public class HorizontalScrollViewWrapper extends ViewWrapper<HorizontalScrollView>
{
  private PanelWrapper pw = new PanelWrapper();

  @BA.Hide
  public static View build(Object paramObject1, HashMap<String, Object> paramHashMap, boolean paramBoolean, Object paramObject2)
    throws Exception
  {
    if (paramObject1 == null)
      paramObject1 = ViewWrapper.buildNativeView((Context)paramObject2, MyHScrollView.class, paramHashMap, paramBoolean);
    HorizontalScrollView localHorizontalScrollView = (HorizontalScrollView)ViewWrapper.build(paramObject1, paramHashMap, paramBoolean);
    if (localHorizontalScrollView.getChildCount() > 0)
      localHorizontalScrollView.removeAllViews();
    Drawable localDrawable = (Drawable)DynamicBuilder.build(paramObject1, (HashMap)paramHashMap.get("drawable"), paramBoolean, null);
    if (paramHashMap.containsKey("innerWidth"))
    {
      localBALayout = new BALayout((Context)paramObject2);
      localHorizontalScrollView.addView(localBALayout, (int)(BALayout.getDeviceScale() * ((Integer)paramHashMap.get("innerWidth")).intValue()), -1);
      if (localDrawable != null)
        localBALayout.setBackgroundDrawable(localDrawable);
    }
    while (localDrawable == null)
    {
      BALayout localBALayout;
      return localHorizontalScrollView;
    }
    localHorizontalScrollView.setBackgroundDrawable(localDrawable);
    return localHorizontalScrollView;
  }

  public void FullScroll(boolean paramBoolean)
  {
    HorizontalScrollView localHorizontalScrollView = (HorizontalScrollView)getObject();
    if (paramBoolean);
    for (int i = 66; ; i = 17)
    {
      localHorizontalScrollView.fullScroll(i);
      return;
    }
  }

  public void Initialize(BA paramBA, int paramInt, String paramString)
  {
    super.Initialize(paramBA, paramString);
    PanelWrapper localPanelWrapper = new PanelWrapper();
    localPanelWrapper.Initialize(paramBA, "");
    ((HorizontalScrollView)getObject()).addView((View)localPanelWrapper.getObject(), paramInt, -1);
  }

  public PanelWrapper getPanel()
  {
    this.pw.setObject((ViewGroup)((HorizontalScrollView)getObject()).getChildAt(0));
    return this.pw;
  }

  public int getScrollPosition()
  {
    return ((HorizontalScrollView)getObject()).getScrollX();
  }

  @BA.Hide
  public void innerInitialize(BA paramBA, String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
      setObject(new MyHScrollView(paramBA.context));
    super.innerInitialize(paramBA, paramString, true);
    if ((paramBA.subExists(paramString + "_scrollchanged")) && ((getObject() instanceof MyHScrollView)))
    {
      MyHScrollView localMyHScrollView = (MyHScrollView)getObject();
      localMyHScrollView.ba = paramBA;
      localMyHScrollView.eventName = paramString;
    }
  }

  public void setScrollPosition(int paramInt)
  {
    ((HorizontalScrollView)getObject()).smoothScrollTo(paramInt, 0);
  }

  @BA.Hide
  public static class MyHScrollView extends HorizontalScrollView
  {
    public BA ba;
    public String eventName;

    public MyHScrollView(Context paramContext)
    {
      super();
    }

    protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      if (this.ba != null)
      {
        BA localBA = this.ba;
        String str = this.eventName + "_scrollchanged";
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(paramInt1);
        localBA.raiseEventFromUI(this, str, arrayOfObject);
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.HorizontalScrollViewWrapper
 * JD-Core Version:    0.6.2
 */