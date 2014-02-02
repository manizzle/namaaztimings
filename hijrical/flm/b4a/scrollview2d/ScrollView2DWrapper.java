package flm.b4a.scrollview2d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import anywheresoftware.b4a.objects.PanelWrapper;

@BA.Author("Frédéric Leneuf-Magaud")
@BA.ShortName("ScrollView2D")
@BA.Version(1.1F)
@BA.ActivityObject
public class ScrollView2DWrapper extends ViewWrapper<TwoDScrollView>
{
  public static final byte FS_DIR_HORZ = 0;
  public static final byte FS_DIR_HORZ_AND_VERT = 2;
  public static final byte FS_DIR_VERT = 1;
  public static final boolean FS_ToTheEND = true;
  private PanelWrapper a = new PanelWrapper();

  public static void LIBRARY_DOC()
  {
  }

  public void DisableTouchEventInterception(boolean paramBoolean)
  {
    TwoDScrollView localTwoDScrollView = (TwoDScrollView)getObject();
    if (paramBoolean);
    for (boolean bool = false; ; bool = true)
    {
      localTwoDScrollView.DisallowInterceptTouchEvent = bool;
      return;
    }
  }

  public void FadingEdges(boolean paramBoolean)
  {
    ((TwoDScrollView)getObject()).setHorizontalFadingEdgeEnabled(paramBoolean);
    ((TwoDScrollView)getObject()).setVerticalFadingEdgeEnabled(paramBoolean);
  }

  public void FullScroll(byte paramByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = getHorizontalScrollPosition();
    int j = getVerticalScrollPosition();
    int m;
    int n;
    if (paramBoolean1)
    {
      if (paramByte > 0)
        j = getPanel().getHeight();
      if (paramByte == 1)
        break label105;
      int i1 = getPanel().getWidth();
      int i2 = j;
      m = i1;
      n = i2;
    }
    while (true)
      if (paramBoolean2)
      {
        SmoothScrollTo(m, n);
        return;
        if (paramByte > 0)
          j = 0;
        if (paramByte != 1)
        {
          n = j;
          m = 0;
        }
      }
      else
      {
        ((TwoDScrollView)getObject()).scrollTo(m, n);
        return;
        label105: int k = j;
        m = i;
        n = k;
      }
  }

  public void GiveFocusToFirstVisible()
  {
    ((TwoDScrollView)getObject()).FindNewFocusedView(1, 1);
  }

  public void Initialize(BA paramBA, int paramInt1, int paramInt2, String paramString)
  {
    super.Initialize(paramBA, paramString);
    PanelWrapper localPanelWrapper = new PanelWrapper();
    localPanelWrapper.Initialize(paramBA, "");
    ((TwoDScrollView)getObject()).addView((View)localPanelWrapper.getObject(), paramInt1, paramInt2);
  }

  public void ScrollbarsVisibility(boolean paramBoolean1, boolean paramBoolean2)
  {
    ((TwoDScrollView)getObject()).setHorizontalScrollBarEnabled(paramBoolean1);
    ((TwoDScrollView)getObject()).setVerticalScrollBarEnabled(paramBoolean2);
  }

  public boolean ScrollingIsFinished()
  {
    return ((TwoDScrollView)getObject()).ScrollingIsFinished();
  }

  public void SmoothScrollTo(int paramInt1, int paramInt2)
  {
    ((TwoDScrollView)getObject()).smoothScrollTo(paramInt1, paramInt2);
  }

  public int getHorizontalScrollPosition()
  {
    return ((TwoDScrollView)getObject()).getScrollX();
  }

  public PanelWrapper getPanel()
  {
    this.a.setObject((ViewGroup)((TwoDScrollView)getObject()).getChildAt(0));
    return this.a;
  }

  public int getVerticalScrollPosition()
  {
    return ((TwoDScrollView)getObject()).getScrollY();
  }

  @BA.Hide
  public void innerInitialize(BA paramBA, String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
      setObject(new MyScrollView(paramBA.context));
    super.innerInitialize(paramBA, paramString, true);
    if (((getObject() instanceof MyScrollView)) && (paramBA.subExists(paramString + "_scrollchanged")))
    {
      MyScrollView localMyScrollView = (MyScrollView)getObject();
      localMyScrollView.ba = paramBA;
      localMyScrollView.eventName = paramString;
    }
  }

  public void setHorizontalScrollPosition(int paramInt)
  {
    ((TwoDScrollView)getObject()).scrollTo(paramInt, getVerticalScrollPosition());
  }

  public void setVerticalScrollPosition(int paramInt)
  {
    ((TwoDScrollView)getObject()).scrollTo(getHorizontalScrollPosition(), paramInt);
  }

  @BA.Hide
  public static class MyScrollView extends TwoDScrollView
  {
    protected BA ba;
    protected String eventName;

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
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Integer.valueOf(paramInt1);
        arrayOfObject[1] = Integer.valueOf(paramInt2);
        localBA.raiseEvent2(this, false, str, true, arrayOfObject);
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     flm.b4a.scrollview2d.ScrollView2DWrapper
 * JD-Core Version:    0.6.2
 */