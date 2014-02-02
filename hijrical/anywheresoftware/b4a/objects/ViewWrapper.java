package anywheresoftware.b4a.objects;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.B4aDebuggable;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.Pixel;
import anywheresoftware.b4a.BALayout.LayoutParams;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.objects.drawable.BitmapDrawable;
import anywheresoftware.b4a.objects.drawable.ColorDrawable;
import anywheresoftware.b4a.objects.drawable.ColorDrawable.GradientDrawableWithCorners;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@BA.Hide
public class ViewWrapper<T extends View> extends AbsObjectWrapper<T>
  implements BA.B4aDebuggable
{

  @BA.Hide
  public static final int defaultColor = -984833;

  @BA.Hide
  public static int lastId = 0;
  protected BA ba;

  @BA.Hide
  public static View build(Object paramObject, Map<String, Object> paramMap, boolean paramBoolean)
    throws Exception
  {
    View localView = (View)paramObject;
    if ((localView.getTag() == null) && (paramBoolean))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("background", localView.getBackground());
      localView.setTag(localHashMap);
    }
    BALayout.LayoutParams localLayoutParams = (BALayout.LayoutParams)localView.getLayoutParams();
    if (localLayoutParams == null)
    {
      localLayoutParams = new BALayout.LayoutParams();
      localView.setLayoutParams(localLayoutParams);
    }
    localLayoutParams.setFromUserPlane(((Integer)paramMap.get("left")).intValue(), ((Integer)paramMap.get("top")).intValue(), ((Integer)paramMap.get("width")).intValue(), ((Integer)paramMap.get("height")).intValue());
    localView.setEnabled(((Boolean)paramMap.get("enabled")).booleanValue());
    if (!paramBoolean)
    {
      boolean bool = ((Boolean)paramMap.get("visible")).booleanValue();
      int i = 0;
      if (!bool)
        i = 8;
      localView.setVisibility(i);
      localView.setTag(paramMap.get("tag"));
    }
    return localView;
  }

  @BA.Hide
  public static <T> T buildNativeView(Context paramContext, Class<T> paramClass, HashMap<String, Object> paramHashMap, boolean paramBoolean)
    throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException
  {
    String str = (String)paramHashMap.get("nativeClass");
    if ((str != null) && (str.startsWith(".")))
      str = BA.applicationContext.getPackageName() + str;
    if ((!paramBoolean) && (str != null));
    try
    {
      int j = str.length();
      if (j == 0);
      Class localClass;
      for (localObject = paramClass; ; localObject = localClass)
      {
        return ((Class)localObject).getConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
        localClass = Class.forName(str);
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      while (true)
      {
        int i = str.lastIndexOf(".");
        Object localObject = Class.forName(str.substring(0, i) + "$" + str.substring(i + 1));
      }
    }
  }

  @BA.Hide
  public static Object getDefault(View paramView, String paramString, Object paramObject)
  {
    HashMap localHashMap = (HashMap)paramView.getTag();
    if (localHashMap.containsKey(paramString))
      return localHashMap.get(paramString);
    localHashMap.put(paramString, paramObject);
    return paramObject;
  }

  public void BringToFront()
  {
    if ((((View)getObject()).getParent() instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)((View)getObject()).getParent();
      localViewGroup.removeView((View)getObject());
      localViewGroup.addView((View)getObject());
    }
  }

  public void Initialize(BA paramBA, String paramString)
  {
    innerInitialize(paramBA, paramString.toLowerCase(BA.cul), false);
  }

  public void Invalidate()
  {
    ((View)getObject()).invalidate();
  }

  public void Invalidate2(Rect paramRect)
  {
    ((View)getObject()).invalidate(paramRect);
  }

  public void Invalidate3(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ((View)getObject()).invalidate(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void RemoveView()
  {
    if ((((View)getObject()).getParent() instanceof ViewGroup))
      ((ViewGroup)((View)getObject()).getParent()).removeView((View)getObject());
  }

  public boolean RequestFocus()
  {
    return ((View)getObject()).requestFocus();
  }

  public void SendToBack()
  {
    if ((((View)getObject()).getParent() instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)((View)getObject()).getParent();
      localViewGroup.removeView((View)getObject());
      localViewGroup.addView((View)getObject(), 0);
    }
  }

  public void SetBackgroundImage(Bitmap paramBitmap)
  {
    BitmapDrawable localBitmapDrawable = new BitmapDrawable();
    localBitmapDrawable.Initialize(paramBitmap);
    ((View)getObject()).setBackgroundDrawable((Drawable)localBitmapDrawable.getObject());
  }

  public void SetLayout(@BA.Pixel int paramInt1, @BA.Pixel int paramInt2, @BA.Pixel int paramInt3, @BA.Pixel int paramInt4)
  {
    BALayout.LayoutParams localLayoutParams = (BALayout.LayoutParams)((View)getObject()).getLayoutParams();
    localLayoutParams.left = paramInt1;
    localLayoutParams.top = paramInt2;
    localLayoutParams.width = paramInt3;
    localLayoutParams.height = paramInt4;
    ((View)getObject()).getParent().requestLayout();
  }

  @BA.Hide
  public Object[] debug(int paramInt, boolean[] paramArrayOfBoolean)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "ToString";
    arrayOfObject[1] = toString();
    paramArrayOfBoolean[0] = true;
    return arrayOfObject;
  }

  public Drawable getBackground()
  {
    return ((View)getObject()).getBackground();
  }

  public boolean getEnabled()
  {
    return ((View)getObject()).isEnabled();
  }

  public int getHeight()
  {
    return ((View)getObject()).getLayoutParams().height;
  }

  public int getLeft()
  {
    return ((BALayout.LayoutParams)((View)getObject()).getLayoutParams()).left;
  }

  public Object getTag()
  {
    return ((View)getObject()).getTag();
  }

  public int getTop()
  {
    return ((BALayout.LayoutParams)((View)getObject()).getLayoutParams()).top;
  }

  public boolean getVisible()
  {
    return ((View)getObject()).getVisibility() == 0;
  }

  public int getWidth()
  {
    return ((View)getObject()).getLayoutParams().width;
  }

  @BA.Hide
  public void innerInitialize(final BA paramBA, final String paramString, boolean paramBoolean)
  {
    this.ba = paramBA;
    View localView = (View)getObject();
    int i = 1 + lastId;
    lastId = i;
    localView.setId(i);
    if (paramBA.subExists(paramString + "_click"))
      ((View)getObject()).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramBA.raiseEvent(ViewWrapper.this.getObject(), paramString + "_click", new Object[0]);
        }
      });
    if (paramBA.subExists(paramString + "_longclick"))
      ((View)getObject()).setOnLongClickListener(new View.OnLongClickListener()
      {
        public boolean onLongClick(View paramAnonymousView)
        {
          paramBA.raiseEvent(ViewWrapper.this.getObject(), paramString + "_longclick", new Object[0]);
          return true;
        }
      });
  }

  public void setBackground(Drawable paramDrawable)
  {
    ((View)getObject()).setBackgroundDrawable(paramDrawable);
  }

  public void setColor(int paramInt)
  {
    Drawable localDrawable = ((View)getObject()).getBackground();
    if ((localDrawable != null) && ((localDrawable instanceof GradientDrawable)))
    {
      float f1;
      if ((localDrawable instanceof ColorDrawable.GradientDrawableWithCorners))
        f1 = ((ColorDrawable.GradientDrawableWithCorners)localDrawable).cornerRadius;
      while (true)
      {
        ColorDrawable localColorDrawable = new ColorDrawable();
        localColorDrawable.Initialize(paramInt, (int)f1);
        ((View)getObject()).setBackgroundDrawable((Drawable)localColorDrawable.getObject());
        return;
        GradientDrawable localGradientDrawable = (GradientDrawable)((View)getObject()).getBackground();
        try
        {
          Field localField = localGradientDrawable.getClass().getDeclaredField("mGradientState");
          localField.setAccessible(true);
          Object localObject = localField.get(localGradientDrawable);
          float f2 = ((Float)localObject.getClass().getDeclaredField("mRadius").get(localObject)).floatValue();
          f1 = f2;
        }
        catch (Exception localException)
        {
          Common.Log(localException.toString());
          f1 = 0.0F;
        }
      }
    }
    ((View)getObject()).setBackgroundColor(paramInt);
  }

  public void setEnabled(boolean paramBoolean)
  {
    ((View)getObject()).setEnabled(paramBoolean);
  }

  public void setHeight(@BA.Pixel int paramInt)
  {
    ((View)getObject()).getLayoutParams().height = paramInt;
    ((View)getObject()).getParent().requestLayout();
  }

  public void setLeft(@BA.Pixel int paramInt)
  {
    ((BALayout.LayoutParams)((View)getObject()).getLayoutParams()).left = paramInt;
    ((View)getObject()).getParent().requestLayout();
  }

  public void setTag(Object paramObject)
  {
    ((View)getObject()).setTag(paramObject);
  }

  public void setTop(@BA.Pixel int paramInt)
  {
    ((BALayout.LayoutParams)((View)getObject()).getLayoutParams()).top = paramInt;
    ((View)getObject()).getParent().requestLayout();
  }

  public void setVisible(boolean paramBoolean)
  {
    View localView = (View)getObject();
    if (paramBoolean);
    for (int i = 0; ; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }

  public void setWidth(@BA.Pixel int paramInt)
  {
    ((View)getObject()).getLayoutParams().width = paramInt;
    ((View)getObject()).getParent().requestLayout();
  }

  @BA.Hide
  public String toString()
  {
    String str1 = baseToString();
    String str2;
    if (IsInitialized())
    {
      str2 = str1 + ": ";
      if (!getEnabled())
        str2 = str2 + "Enabled=false, ";
      if (!getVisible())
        str2 = str2 + "Visible=false, ";
      if ((((View)getObject()).getLayoutParams() != null) && ((((View)getObject()).getLayoutParams() instanceof BALayout.LayoutParams)))
        break label179;
    }
    label179: for (str1 = str2 + "Layout not available"; ; str1 = str2 + "Left=" + getLeft() + ", Top=" + getTop() + ", Width=" + getWidth() + ", Height=" + getHeight())
    {
      if (getTag() != null)
        str1 = str1 + ", Tag=" + getTag().toString();
      return str1;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.ViewWrapper
 * JD-Core Version:    0.6.2
 */