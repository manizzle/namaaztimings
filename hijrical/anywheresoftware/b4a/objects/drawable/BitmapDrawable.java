package anywheresoftware.b4a.objects.drawable;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.objects.streams.File;
import java.io.IOException;
import java.util.HashMap;

@BA.ShortName("BitmapDrawable")
@BA.ActivityObject
public class BitmapDrawable extends AbsObjectWrapper<android.graphics.drawable.BitmapDrawable>
{
  @BA.Hide
  public static Drawable build(Object paramObject1, HashMap<String, Object> paramHashMap, boolean paramBoolean, Object paramObject2)
    throws IOException
  {
    String str1 = ((String)paramHashMap.get("file")).toLowerCase(BA.cul);
    if (str1.length() == 0)
      return null;
    if (paramBoolean);
    for (String str2 = File.getDirInternal(); ; str2 = File.getDirAssets())
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable();
      CanvasWrapper.BitmapWrapper localBitmapWrapper = new CanvasWrapper.BitmapWrapper();
      localBitmapWrapper.Initialize(str2, str1);
      localBitmapDrawable.Initialize((Bitmap)localBitmapWrapper.getObject());
      Integer localInteger = (Integer)paramHashMap.get("gravity");
      if (localInteger != null)
        ((android.graphics.drawable.BitmapDrawable)localBitmapDrawable.getObject()).setGravity(localInteger.intValue());
      return (Drawable)localBitmapDrawable.getObject();
    }
  }

  public void Initialize(Bitmap paramBitmap)
  {
    setObject(new android.graphics.drawable.BitmapDrawable(BA.applicationContext.getResources(), paramBitmap));
  }

  public Bitmap getBitmap()
  {
    return ((android.graphics.drawable.BitmapDrawable)getObject()).getBitmap();
  }

  public int getGravity()
  {
    return ((android.graphics.drawable.BitmapDrawable)getObject()).getGravity();
  }

  public void setGravity(int paramInt)
  {
    ((android.graphics.drawable.BitmapDrawable)getObject()).setGravity(paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.drawable.BitmapDrawable
 * JD-Core Version:    0.6.2
 */