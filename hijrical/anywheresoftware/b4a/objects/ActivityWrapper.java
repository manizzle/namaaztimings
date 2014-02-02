package anywheresoftware.b4a.objects;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.B4AMenuItem;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.IterableList;
import anywheresoftware.b4a.BA.Pixel;
import anywheresoftware.b4a.BA.RaisesSynchronousEvents;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.WarningEngine;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.BALayout.LayoutParams;
import anywheresoftware.b4a.DynamicBuilder;
import anywheresoftware.b4a.keywords.LayoutBuilder;
import anywheresoftware.b4a.keywords.LayoutBuilder.LayoutHashMap;
import anywheresoftware.b4a.keywords.LayoutBuilder.LayoutValuesAndMap;
import anywheresoftware.b4a.keywords.LayoutValues;
import anywheresoftware.b4a.objects.drawable.BitmapDrawable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

@BA.ShortName("Activity")
@BA.ActivityObject
public class ActivityWrapper extends ViewWrapper<BALayout>
  implements BA.IterableList
{
  public static final int ACTION_DOWN = 0;
  public static final int ACTION_MOVE = 2;
  public static final int ACTION_UP = 1;

  public ActivityWrapper()
  {
  }

  public ActivityWrapper(BA paramBA, String paramString)
  {
    if (BA.shellMode)
      return;
    reinitializeForShell(paramBA, paramString);
  }

  @BA.Hide
  public static View build(Object paramObject1, HashMap<String, Object> paramHashMap, boolean paramBoolean, Object paramObject2)
    throws Exception
  {
    Drawable localDrawable = (Drawable)DynamicBuilder.build(paramObject1, (HashMap)paramHashMap.get("drawable"), paramBoolean, null);
    View localView = (View)paramObject1;
    int i = 0;
    if (paramBoolean)
      i = ((Integer)ViewWrapper.getDefault(localView, "titleColor", Integer.valueOf(((Activity)localView.getContext()).getTitleColor()))).intValue();
    if (localDrawable != null)
      localView.setBackgroundDrawable(localDrawable);
    ((Activity)localView.getContext()).setTitle((String)paramHashMap.get("title"));
    int j = ((Integer)paramHashMap.get("titleColor")).intValue();
    if (j != -984833)
      ((Activity)localView.getContext()).setTitleColor(j);
    while (true)
    {
      if (BA.debugMode)
        BA.warningEngine.checkFullScreenInLayout(((Boolean)paramHashMap.get("fullScreen")).booleanValue(), ((Boolean)paramHashMap.get("includeTitle")).booleanValue());
      if (paramBoolean)
      {
        boolean bool1 = ((Boolean)paramHashMap.get("fullScreen")).booleanValue();
        boolean bool2 = ((Boolean)paramHashMap.get("includeTitle")).booleanValue();
        Class localClass = Class.forName("anywheresoftware.b4a.designer.Designer");
        boolean bool3 = localClass.getField("fullScreen").getBoolean(localView.getContext());
        boolean bool4 = localClass.getField("includeTitle").getBoolean(localView.getContext());
        if ((bool3 != bool1) || (bool2 != bool4))
        {
          Intent localIntent = new Intent(localView.getContext().getApplicationContext(), localClass);
          localIntent.putExtra("anywheresoftware.b4a.designer.includeTitle", bool2);
          localIntent.putExtra("anywheresoftware.b4a.designer.fullScreen", bool1);
          localClass.getMethod("restartActivity", new Class[] { Intent.class }).invoke(localView.getContext(), new Object[] { localIntent });
        }
      }
      return (View)paramObject1;
      if (paramBoolean)
        ((Activity)localView.getContext()).setTitleColor(i);
    }
  }

  public void AddMenuItem(String paramString1, String paramString2)
  {
    AddMenuItem3(paramString1, paramString2, null, false);
  }

  public void AddMenuItem2(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    AddMenuItem3(paramString1, paramString2, paramBitmap, false);
  }

  public void AddMenuItem3(String paramString1, String paramString2, Bitmap paramBitmap, boolean paramBoolean)
  {
    Drawable localDrawable = null;
    if (paramBitmap != null)
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable();
      localBitmapDrawable.Initialize(paramBitmap);
      localDrawable = (Drawable)localBitmapDrawable.getObject();
    }
    B4AMenuItem localB4AMenuItem = new B4AMenuItem(paramString1, localDrawable, paramString2, paramBoolean);
    ((B4AActivity)this.ba.activity).addMenuItem(localB4AMenuItem);
  }

  public void AddView(View paramView, @BA.Pixel int paramInt1, @BA.Pixel int paramInt2, @BA.Pixel int paramInt3, @BA.Pixel int paramInt4)
  {
    ((BALayout)getObject()).addView(paramView, new BALayout.LayoutParams(paramInt1, paramInt2, paramInt3, paramInt4));
  }

  @BA.Hide
  public void BringToFront()
  {
  }

  public void CloseMenu()
  {
    this.ba.activity.closeOptionsMenu();
  }

  public void Finish()
  {
    this.ba.activity.finish();
  }

  @BA.Hide
  public Object Get(int paramInt)
  {
    return GetView(paramInt).getObject();
  }

  public BA.IterableList GetAllViewsRecursive()
  {
    return new AllViewsIterator((ViewGroup)getObject());
  }

  public IntentWrapper GetStartingIntent()
  {
    IntentWrapper localIntentWrapper = new IntentWrapper();
    localIntentWrapper.setObject(this.ba.activity.getIntent());
    return localIntentWrapper;
  }

  public ConcreteViewWrapper GetView(int paramInt)
  {
    ConcreteViewWrapper localConcreteViewWrapper = new ConcreteViewWrapper();
    localConcreteViewWrapper.setObject(((BALayout)getObject()).getChildAt(paramInt));
    return localConcreteViewWrapper;
  }

  @BA.RaisesSynchronousEvents
  public LayoutValues LoadLayout(String paramString, BA paramBA)
    throws Exception
  {
    anywheresoftware.b4a.AbsObjectWrapper.Activity_LoadLayout_Was_Called = true;
    return LayoutBuilder.loadLayout(paramString, paramBA, true, paramBA.vg, null, false).layoutValues;
  }

  public void OpenMenu()
  {
    this.ba.activity.openOptionsMenu();
  }

  public void RemoveAllViews()
  {
    ((BALayout)getObject()).removeAllViews();
  }

  @BA.Hide
  public void RemoveView()
  {
  }

  public void RemoveViewAt(int paramInt)
  {
    ((BALayout)getObject()).removeViewAt(paramInt);
  }

  public void RerunDesignerScript(String paramString, BA paramBA, int paramInt1, int paramInt2)
    throws Exception
  {
    BALayout localBALayout = new BALayout(paramBA.context);
    localBALayout.setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
    LayoutBuilder.LayoutHashMap localLayoutHashMap = new LayoutBuilder.LayoutHashMap();
    Field[] arrayOfField = paramBA.activity.getClass().getFields();
    int i = arrayOfField.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
      {
        LayoutBuilder.loadLayout(paramString, paramBA, false, localBALayout, localLayoutHashMap, false);
        return;
      }
      Field localField = arrayOfField[j];
      if ((localField.getName().startsWith("_")) && (ViewWrapper.class.isAssignableFrom(localField.getType())))
        localLayoutHashMap.put(localField.getName().substring(1), (ViewWrapper)localField.get(paramBA.activity));
    }
  }

  @BA.Hide
  public void SendToBack()
  {
  }

  public void SetActivityResult(int paramInt, IntentWrapper paramIntentWrapper)
  {
    this.ba.activity.setResult(paramInt, (Intent)paramIntentWrapper.getObject());
  }

  @BA.Hide
  public boolean getEnabled()
  {
    return true;
  }

  public int getHeight()
  {
    return ((BALayout)getObject()).getHeight();
  }

  public int getLeft()
  {
    return 0;
  }

  public int getNumberOfViews()
  {
    return ((BALayout)getObject()).getChildCount();
  }

  @BA.Hide
  public int getSize()
  {
    return getNumberOfViews();
  }

  public CharSequence getTitle()
  {
    return this.ba.activity.getTitle();
  }

  public int getTitleColor()
  {
    return this.ba.activity.getTitleColor();
  }

  public int getTop()
  {
    return 0;
  }

  @BA.Hide
  public boolean getVisible()
  {
    return true;
  }

  public int getWidth()
  {
    return ((BALayout)getObject()).getWidth();
  }

  @BA.Hide
  public void reinitializeForShell(final BA paramBA, String paramString)
  {
    if (IsInitialized());
    do
    {
      return;
      setObject(paramBA.vg);
      innerInitialize(paramBA, paramString, true);
    }
    while (!paramBA.subExists("activity_touch"));
    ((BALayout)getObject()).setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        BA localBA = paramBA;
        ActivityWrapper localActivityWrapper = ActivityWrapper.this;
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = Integer.valueOf(paramAnonymousMotionEvent.getAction());
        arrayOfObject[1] = Float.valueOf(paramAnonymousMotionEvent.getX());
        arrayOfObject[2] = Float.valueOf(paramAnonymousMotionEvent.getY());
        localBA.raiseEventFromUI(localActivityWrapper, "activity_touch", arrayOfObject);
        return true;
      }
    });
  }

  @BA.Hide
  public void setEnabled(boolean paramBoolean)
  {
  }

  public void setTitle(Object paramObject)
  {
    if ((paramObject instanceof CharSequence));
    for (Object localObject = (CharSequence)paramObject; ; localObject = paramObject.toString())
    {
      this.ba.activity.setTitle((CharSequence)localObject);
      return;
    }
  }

  public void setTitleColor(int paramInt)
  {
    this.ba.activity.setTitleColor(paramInt);
  }

  @BA.Hide
  public void setVisible(boolean paramBoolean)
  {
  }

  @BA.Hide
  public static class AllViewsIterator
    implements BA.IterableList
  {
    private ArrayList<View> views = new ArrayList();

    public AllViewsIterator(ViewGroup paramViewGroup)
    {
      addViews(paramViewGroup);
    }

    private void addViews(ViewGroup paramViewGroup)
    {
      for (int i = 0; ; i++)
      {
        if (i >= paramViewGroup.getChildCount())
          return;
        View localView = paramViewGroup.getChildAt(i);
        this.views.add(localView);
        if ((localView instanceof ViewGroup))
          addViews((ViewGroup)localView);
      }
    }

    public Object Get(int paramInt)
    {
      return this.views.get(paramInt);
    }

    public int getSize()
    {
      return this.views.size();
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.ActivityWrapper
 * JD-Core Version:    0.6.2
 */