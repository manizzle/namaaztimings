package anywheresoftware.b4a.objects;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.DynamicBuilder;
import java.util.HashMap;

@BA.ShortName("ScrollView")
@BA.ActivityObject
public class ScrollViewWrapper extends ViewWrapper<ScrollView>
{
  private PanelWrapper pw = new PanelWrapper();

  @BA.Hide
  public static View build(Object paramObject1, HashMap<String, Object> paramHashMap, boolean paramBoolean, Object paramObject2)
    throws Exception
  {
    if (paramObject1 == null)
      paramObject1 = ViewWrapper.buildNativeView((Context)paramObject2, MyScrollView.class, paramHashMap, paramBoolean);
    ScrollView localScrollView = (ScrollView)ViewWrapper.build(paramObject1, paramHashMap, paramBoolean);
    if (localScrollView.getChildCount() > 0)
      localScrollView.removeAllViews();
    Drawable localDrawable = (Drawable)DynamicBuilder.build(paramObject1, (HashMap)paramHashMap.get("drawable"), paramBoolean, null);
    if (paramHashMap.containsKey("innerHeight"))
    {
      BALayout localBALayout = new BALayout((Context)paramObject2);
      localScrollView.addView(localBALayout, -1, (int)(BALayout.getDeviceScale() * ((Integer)paramHashMap.get("innerHeight")).intValue()));
      localBALayout.setBackgroundDrawable(localDrawable);
      return localScrollView;
    }
    localScrollView.setBackgroundDrawable(localDrawable);
    return localScrollView;
  }

  public void FullScroll(boolean paramBoolean)
  {
    ScrollView localScrollView = (ScrollView)getObject();
    if (paramBoolean);
    for (int i = 130; ; i = 33)
    {
      localScrollView.fullScroll(i);
      return;
    }
  }

  public void Initialize(BA paramBA, int paramInt)
  {
    Initialize2(paramBA, paramInt, "");
  }

  public void Initialize2(BA paramBA, int paramInt, String paramString)
  {
    super.Initialize(paramBA, paramString);
    PanelWrapper localPanelWrapper = new PanelWrapper();
    localPanelWrapper.Initialize(paramBA, "");
    ((ScrollView)getObject()).addView((View)localPanelWrapper.getObject(), -1, paramInt);
  }

  public PanelWrapper getPanel()
  {
    this.pw.setObject((ViewGroup)((ScrollView)getObject()).getChildAt(0));
    return this.pw;
  }

  public int getScrollPosition()
  {
    return ((ScrollView)getObject()).getScrollY();
  }

  @BA.Hide
  public void innerInitialize(BA paramBA, String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
      setObject(new MyScrollView(paramBA.context));
    super.innerInitialize(paramBA, paramString, true);
    if ((paramBA.subExists(paramString + "_scrollchanged")) && ((getObject() instanceof MyScrollView)))
    {
      MyScrollView localMyScrollView = (MyScrollView)getObject();
      localMyScrollView.ba = paramBA;
      localMyScrollView.eventName = paramString;
    }
  }

  public void setScrollPosition(int paramInt)
  {
    ((ScrollView)getObject()).smoothScrollTo(0, paramInt);
  }

  @BA.Hide
  public static class MyScrollView extends ScrollView
  {
    public BA ba;
    public String eventName;

    public MyScrollView(Context paramContext)
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
        arrayOfObject[0] = Integer.valueOf(paramInt2);
        localBA.raiseEventFromUI(this, str, arrayOfObject);
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.ScrollViewWrapper
 * JD-Core Version:    0.6.2
 */