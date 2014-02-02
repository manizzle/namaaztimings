package anywheresoftware.b4a.objects;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.IterableList;
import anywheresoftware.b4a.BA.RaisesSynchronousEvents;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.WarningEngine;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.BALayout.LayoutParams;
import anywheresoftware.b4a.DynamicBuilder;
import anywheresoftware.b4a.keywords.LayoutBuilder;
import anywheresoftware.b4a.keywords.LayoutBuilder.LayoutValuesAndMap;
import anywheresoftware.b4a.keywords.LayoutValues;
import java.util.HashMap;

@BA.ShortName("Panel")
@BA.ActivityObject
public class PanelWrapper extends ViewWrapper<ViewGroup>
  implements BA.IterableList
{
  public static final int ACTION_DOWN = 0;
  public static final int ACTION_MOVE = 2;
  public static final int ACTION_UP = 1;

  @BA.Hide
  public static View build(Object paramObject1, HashMap<String, Object> paramHashMap, boolean paramBoolean, Object paramObject2)
    throws Exception
  {
    View localView1 = (View)paramObject1;
    if (localView1 == null)
      localView1 = (View)ViewWrapper.buildNativeView((Context)paramObject2, BALayout.class, paramHashMap, paramBoolean);
    View localView2 = ViewWrapper.build(localView1, paramHashMap, paramBoolean);
    Drawable localDrawable = (Drawable)DynamicBuilder.build(localView2, (HashMap)paramHashMap.get("drawable"), paramBoolean, null);
    if (localDrawable != null)
      localView2.setBackgroundDrawable(localDrawable);
    return localView2;
  }

  public void AddView(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ((ViewGroup)getObject()).addView(paramView, new BALayout.LayoutParams(paramInt1, paramInt2, paramInt3, paramInt4));
  }

  @BA.Hide
  public Object Get(int paramInt)
  {
    return GetView(paramInt).getObject();
  }

  public BA.IterableList GetAllViewsRecursive()
  {
    return new ActivityWrapper.AllViewsIterator((ViewGroup)getObject());
  }

  public ConcreteViewWrapper GetView(int paramInt)
  {
    ConcreteViewWrapper localConcreteViewWrapper = new ConcreteViewWrapper();
    localConcreteViewWrapper.setObject(((ViewGroup)getObject()).getChildAt(paramInt));
    return localConcreteViewWrapper;
  }

  @BA.RaisesSynchronousEvents
  public LayoutValues LoadLayout(String paramString, BA paramBA)
    throws Exception
  {
    ViewGroup.LayoutParams localLayoutParams = ((ViewGroup)getObject()).getLayoutParams();
    int i = 0;
    if (localLayoutParams == null)
      i = 1;
    int j = 0;
    if (i == 0)
    {
      int k = localLayoutParams.width;
      j = 0;
      if (k == -1)
      {
        if ((((ViewGroup)getObject()).getParent() != null) && (((View)((ViewGroup)getObject()).getParent()).getLayoutParams() != null))
          break label123;
        i = 1;
      }
    }
    while (true)
    {
      if (i != 0)
        BA.WarningEngine.warn(1001);
      LayoutValues localLayoutValues = LayoutBuilder.loadLayout(paramString, paramBA, false, (ViewGroup)getObject(), null, false).layoutValues;
      if (j != 0)
        setWidth(-1);
      return localLayoutValues;
      label123: setWidth(((View)((ViewGroup)getObject()).getParent()).getLayoutParams().width);
      j = 1;
    }
  }

  public void RemoveAllViews()
  {
    ((ViewGroup)getObject()).removeAllViews();
  }

  public void RemoveViewAt(int paramInt)
  {
    ((ViewGroup)getObject()).removeViewAt(paramInt);
  }

  public int getNumberOfViews()
  {
    return ((ViewGroup)getObject()).getChildCount();
  }

  @BA.Hide
  public int getSize()
  {
    return getNumberOfViews();
  }

  @BA.Hide
  public void innerInitialize(final BA paramBA, final String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
      setObject(new BALayout(paramBA.context));
    super.innerInitialize(paramBA, paramString, true);
    if (paramBA.subExists(paramString + "_touch"))
      ((ViewGroup)getObject()).setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          BA localBA = paramBA;
          Object localObject = PanelWrapper.this.getObject();
          String str = paramString + "_touch";
          Object[] arrayOfObject = new Object[3];
          arrayOfObject[0] = Integer.valueOf(paramAnonymousMotionEvent.getAction());
          arrayOfObject[1] = Float.valueOf(paramAnonymousMotionEvent.getX());
          arrayOfObject[2] = Float.valueOf(paramAnonymousMotionEvent.getY());
          localBA.raiseEventFromUI(localObject, str, arrayOfObject);
          return true;
        }
      });
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.PanelWrapper
 * JD-Core Version:    0.6.2
 */