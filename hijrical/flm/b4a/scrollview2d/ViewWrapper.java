package flm.b4a.scrollview2d;

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
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BALayout.LayoutParams;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.objects.drawable.BitmapDrawable;
import anywheresoftware.b4a.objects.drawable.ColorDrawable;
import anywheresoftware.b4a.objects.drawable.ColorDrawable.GradientDrawableWithCorners;
import java.lang.reflect.Field;

@BA.Hide
public class ViewWrapper<T extends View> extends AbsObjectWrapper<T>
{

  @BA.Hide
  public static int lastId;
  protected BA ba;

  public void BringToFront()
  {
    ((View)getObject()).bringToFront();
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

  public void SetLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    BALayout.LayoutParams localLayoutParams = (BALayout.LayoutParams)((View)getObject()).getLayoutParams();
    localLayoutParams.left = paramInt1;
    localLayoutParams.top = paramInt2;
    localLayoutParams.width = paramInt3;
    localLayoutParams.height = paramInt4;
    ((View)getObject()).getParent().requestLayout();
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
        public final void onClick(View paramAnonymousView)
        {
          paramBA.raiseEvent(ViewWrapper.this.getObject(), paramString + "_click", new Object[0]);
        }
      });
    if (paramBA.subExists(paramString + "_longclick"))
      ((View)getObject()).setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
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

  public void setHeight(int paramInt)
  {
    ((View)getObject()).getLayoutParams().height = paramInt;
    ((View)getObject()).getParent().requestLayout();
  }

  public void setLeft(int paramInt)
  {
    ((BALayout.LayoutParams)((View)getObject()).getLayoutParams()).left = paramInt;
    ((View)getObject()).getParent().requestLayout();
  }

  public void setTag(Object paramObject)
  {
    ((View)getObject()).setTag(paramObject);
  }

  public void setTop(int paramInt)
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

  public void setWidth(int paramInt)
  {
    ((View)getObject()).getLayoutParams().width = paramInt;
    ((View)getObject()).getParent().requestLayout();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     flm.b4a.scrollview2d.ViewWrapper
 * JD-Core Version:    0.6.2
 */