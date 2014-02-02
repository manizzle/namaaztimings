package anywheresoftware.b4a.objects;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import java.io.IOException;
import java.util.HashMap;

@BA.ShortName("ImageView")
@BA.ActivityObject
public class ImageViewWrapper extends ViewWrapper<ImageView>
{
  @BA.Hide
  public static View build(Object paramObject1, HashMap<String, Object> paramHashMap, boolean paramBoolean, Object paramObject2)
    throws Exception
  {
    if (paramObject1 == null)
      paramObject1 = ViewWrapper.buildNativeView((Context)paramObject2, ImageView.class, paramHashMap, paramBoolean);
    ImageView localImageView = (ImageView)ViewWrapper.build(paramObject1, paramHashMap, paramBoolean);
    setImage(localImageView, (HashMap)paramHashMap.get("drawable"), paramBoolean);
    return localImageView;
  }

  @BA.Hide
  public static void setImage(View paramView, HashMap<String, Object> paramHashMap, boolean paramBoolean)
  {
    Drawable localDrawable;
    try
    {
      localDrawable = anywheresoftware.b4a.objects.drawable.BitmapDrawable.build(paramView, paramHashMap, paramBoolean, null);
      if (localDrawable == null)
      {
        ColorDrawable localColorDrawable = new ColorDrawable(-1);
        Integer localInteger = (Integer)paramHashMap.get("gravity");
        if (localInteger == null)
          localInteger = Integer.valueOf(0);
        paramView.setBackgroundDrawable(localColorDrawable);
        localColorDrawable.setLevel(localInteger.intValue());
        return;
      }
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
    paramView.setBackgroundDrawable(localDrawable);
  }

  public void SetBackgroundImage(Bitmap paramBitmap)
  {
    setBitmap(paramBitmap);
  }

  public Bitmap getBitmap()
  {
    Drawable localDrawable = ((ImageView)getObject()).getBackground();
    if ((localDrawable == null) || (!(localDrawable instanceof android.graphics.drawable.BitmapDrawable)))
      return null;
    return ((android.graphics.drawable.BitmapDrawable)localDrawable).getBitmap();
  }

  public int getGravity()
  {
    Drawable localDrawable = ((ImageView)getObject()).getBackground();
    if (localDrawable == null)
      return 0;
    if ((localDrawable instanceof android.graphics.drawable.BitmapDrawable))
      return ((android.graphics.drawable.BitmapDrawable)localDrawable).getGravity();
    if ((localDrawable instanceof ColorDrawable))
      return localDrawable.getLevel();
    return 0;
  }

  @BA.Hide
  public void innerInitialize(BA paramBA, String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
      setObject(new ImageView(paramBA.context));
    super.innerInitialize(paramBA, paramString, true);
  }

  public void setBitmap(Bitmap paramBitmap)
  {
    int i = getGravity();
    anywheresoftware.b4a.objects.drawable.BitmapDrawable localBitmapDrawable = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
    localBitmapDrawable.Initialize(paramBitmap);
    localBitmapDrawable.setGravity(i);
    setBackground((Drawable)localBitmapDrawable.getObject());
  }

  public void setGravity(int paramInt)
  {
    Drawable localDrawable = ((ImageView)getObject()).getBackground();
    if ((localDrawable == null) || (!(localDrawable instanceof android.graphics.drawable.BitmapDrawable)))
    {
      anywheresoftware.b4a.objects.drawable.BitmapDrawable localBitmapDrawable = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
      localBitmapDrawable.Initialize(null);
      ((ImageView)getObject()).setBackgroundDrawable((Drawable)localBitmapDrawable.getObject());
      localDrawable = (Drawable)localBitmapDrawable.getObject();
    }
    ((android.graphics.drawable.BitmapDrawable)localDrawable).setGravity(paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.ImageViewWrapper
 * JD-Core Version:    0.6.2
 */