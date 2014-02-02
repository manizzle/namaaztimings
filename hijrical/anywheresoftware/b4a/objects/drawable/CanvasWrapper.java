package anywheresoftware.b4a.objects.drawable;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.Pixel;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.objects.streams.File;
import anywheresoftware.b4a.objects.streams.File.InputStreamWrapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@BA.ShortName("Canvas")
@BA.ActivityObject
public class CanvasWrapper
{
  private BitmapWrapper bw;

  @BA.Hide
  public Canvas canvas;
  private PorterDuffXfermode eraseMode;
  private Paint paint;
  private RectF rectF;

  private void checkAndSetTransparent(int paramInt)
  {
    if (paramInt != 0)
    {
      this.paint.setXfermode(null);
      return;
    }
    if (this.eraseMode == null)
      this.eraseMode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    this.paint.setXfermode(this.eraseMode);
  }

  public void ClipPath(Path paramPath)
  {
    this.canvas.clipPath(paramPath);
  }

  public void DrawBitmap(Bitmap paramBitmap, Rect paramRect1, Rect paramRect2)
  {
    this.canvas.drawBitmap(paramBitmap, paramRect1, paramRect2, null);
  }

  public void DrawBitmapFlipped(Bitmap paramBitmap, Rect paramRect1, Rect paramRect2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = -1;
    this.canvas.save();
    while (true)
    {
      int j;
      try
      {
        Canvas localCanvas = this.canvas;
        if (paramBoolean2)
        {
          j = i;
          break label88;
          Object localObject2;
          localCanvas.scale(localObject2, i, paramRect2.centerX(), paramRect2.centerY());
          DrawBitmap(paramBitmap, paramRect1, paramRect2);
        }
        else
        {
          j = 1;
          break label88;
          i = 1;
          continue;
        }
      }
      finally
      {
        this.canvas.restore();
      }
      label88: float f = j;
      if (!paramBoolean1);
    }
  }

  public void DrawBitmapRotated(Bitmap paramBitmap, Rect paramRect1, Rect paramRect2, float paramFloat)
  {
    this.canvas.save();
    try
    {
      this.canvas.rotate(paramFloat, paramRect2.centerX(), paramRect2.centerY());
      DrawBitmap(paramBitmap, paramRect1, paramRect2);
      return;
    }
    finally
    {
      this.canvas.restore();
    }
  }

  public void DrawCircle(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, boolean paramBoolean, float paramFloat4)
  {
    checkAndSetTransparent(paramInt);
    this.paint.setColor(paramInt);
    Paint localPaint = this.paint;
    if (paramBoolean);
    for (Paint.Style localStyle = Paint.Style.FILL; ; localStyle = Paint.Style.STROKE)
    {
      localPaint.setStyle(localStyle);
      this.paint.setStrokeWidth(paramFloat4);
      this.canvas.drawCircle(paramFloat1, paramFloat2, paramFloat3, this.paint);
      return;
    }
  }

  public void DrawColor(int paramInt)
  {
    if (paramInt == 0)
    {
      this.canvas.drawColor(paramInt, PorterDuff.Mode.CLEAR);
      return;
    }
    this.canvas.drawColor(paramInt);
  }

  public void DrawDrawable(Drawable paramDrawable, Rect paramRect)
  {
    paramDrawable.setBounds(paramRect);
    paramDrawable.draw(this.canvas);
  }

  public void DrawDrawableRotate(Drawable paramDrawable, Rect paramRect, float paramFloat)
  {
    this.canvas.save();
    try
    {
      this.canvas.rotate(paramFloat, paramRect.centerX(), paramRect.centerY());
      DrawDrawable(paramDrawable, paramRect);
      return;
    }
    finally
    {
      this.canvas.restore();
    }
  }

  public void DrawLine(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, float paramFloat5)
  {
    checkAndSetTransparent(paramInt);
    this.paint.setColor(paramInt);
    this.paint.setStrokeWidth(paramFloat5);
    this.canvas.drawLine(paramFloat1, paramFloat2, paramFloat3, paramFloat4, this.paint);
  }

  public void DrawOval(Rect paramRect, int paramInt, boolean paramBoolean, float paramFloat)
  {
    checkAndSetTransparent(paramInt);
    this.paint.setColor(paramInt);
    Paint localPaint = this.paint;
    if (paramBoolean);
    for (Paint.Style localStyle = Paint.Style.FILL; ; localStyle = Paint.Style.STROKE)
    {
      localPaint.setStyle(localStyle);
      this.paint.setStrokeWidth(paramFloat);
      if (this.rectF == null)
        this.rectF = new RectF();
      this.rectF.set(paramRect);
      this.canvas.drawOval(this.rectF, this.paint);
      return;
    }
  }

  public void DrawOvalRotated(Rect paramRect, int paramInt, boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.canvas.save();
    try
    {
      this.canvas.rotate(paramFloat2, paramRect.centerX(), paramRect.centerY());
      DrawOval(paramRect, paramInt, paramBoolean, paramFloat1);
      return;
    }
    finally
    {
      this.canvas.restore();
    }
  }

  public void DrawPath(Path paramPath, int paramInt, boolean paramBoolean, float paramFloat)
  {
    checkAndSetTransparent(paramInt);
    this.paint.setColor(paramInt);
    Paint localPaint = this.paint;
    if (paramBoolean);
    for (Paint.Style localStyle = Paint.Style.FILL; ; localStyle = Paint.Style.STROKE)
    {
      localPaint.setStyle(localStyle);
      this.paint.setStrokeWidth(paramFloat);
      this.canvas.drawPath(paramPath, this.paint);
      return;
    }
  }

  public void DrawPoint(float paramFloat1, float paramFloat2, int paramInt)
  {
    checkAndSetTransparent(paramInt);
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setStrokeWidth(0.0F);
    this.paint.setColor(paramInt);
    this.canvas.drawPoint(paramFloat1, paramFloat2, this.paint);
  }

  public void DrawRect(Rect paramRect, int paramInt, boolean paramBoolean, float paramFloat)
  {
    checkAndSetTransparent(paramInt);
    this.paint.setColor(paramInt);
    Paint localPaint = this.paint;
    if (paramBoolean);
    for (Paint.Style localStyle = Paint.Style.FILL; ; localStyle = Paint.Style.STROKE)
    {
      localPaint.setStyle(localStyle);
      this.paint.setStrokeWidth(paramFloat);
      this.canvas.drawRect(paramRect, this.paint);
      return;
    }
  }

  public void DrawRectRotated(Rect paramRect, int paramInt, boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.canvas.save();
    try
    {
      this.canvas.rotate(paramFloat2, paramRect.centerX(), paramRect.centerY());
      DrawRect(paramRect, paramInt, paramBoolean, paramFloat1);
      return;
    }
    finally
    {
      this.canvas.restore();
    }
  }

  public void DrawText(BA paramBA, String paramString, float paramFloat1, float paramFloat2, Typeface paramTypeface, float paramFloat3, int paramInt, Paint.Align paramAlign)
  {
    checkAndSetTransparent(paramInt);
    this.paint.setTextAlign(paramAlign);
    this.paint.setTextSize(paramFloat3 * paramBA.context.getResources().getDisplayMetrics().scaledDensity);
    this.paint.setTypeface(paramTypeface);
    this.paint.setColor(paramInt);
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(0.0F);
    this.paint.setStyle(Paint.Style.STROKE);
    this.canvas.drawText(paramString, paramFloat1, paramFloat2, this.paint);
    this.paint.setAntiAlias(false);
  }

  public void DrawTextRotated(BA paramBA, String paramString, float paramFloat1, float paramFloat2, Typeface paramTypeface, float paramFloat3, int paramInt, Paint.Align paramAlign, float paramFloat4)
  {
    this.canvas.save();
    try
    {
      this.canvas.rotate(paramFloat4, paramFloat1, paramFloat2);
      DrawText(paramBA, paramString, paramFloat1, paramFloat2, paramTypeface, paramFloat3, paramInt, paramAlign);
      return;
    }
    finally
    {
      this.canvas.restore();
    }
  }

  public void Initialize(View paramView)
  {
    this.paint = new Paint();
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    Bitmap localBitmap = Bitmap.createBitmap(localLayoutParams.width, localLayoutParams.height, Bitmap.Config.ARGB_8888);
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(localBitmap);
    this.canvas = new Canvas(localBitmap);
    if (paramView.getBackground() != null)
    {
      paramView.getBackground().setBounds(0, 0, localLayoutParams.width, localLayoutParams.height);
      paramView.getBackground().draw(this.canvas);
    }
    paramView.setBackgroundDrawable(localBitmapDrawable);
    this.bw = new BitmapWrapper();
    this.bw.setObject(localBitmap);
  }

  public void Initialize2(Bitmap paramBitmap)
  {
    this.paint = new Paint();
    if (!paramBitmap.isMutable())
      throw new RuntimeException("Bitmap is not mutable.");
    this.canvas = new Canvas(paramBitmap);
    this.bw = new BitmapWrapper();
    this.bw.setObject(paramBitmap);
  }

  public float MeasureStringHeight(String paramString, Typeface paramTypeface, float paramFloat)
  {
    this.paint.setTextSize(paramFloat * BA.applicationContext.getResources().getDisplayMetrics().scaledDensity);
    this.paint.setTypeface(paramTypeface);
    this.paint.setStrokeWidth(0.0F);
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setTextAlign(Paint.Align.LEFT);
    Rect localRect = new Rect();
    this.paint.getTextBounds(paramString, 0, paramString.length(), localRect);
    return localRect.height();
  }

  public float MeasureStringWidth(String paramString, Typeface paramTypeface, float paramFloat)
  {
    this.paint.setTextSize(paramFloat * BA.applicationContext.getResources().getDisplayMetrics().scaledDensity);
    this.paint.setTypeface(paramTypeface);
    this.paint.setStrokeWidth(0.0F);
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setTextAlign(Paint.Align.LEFT);
    return this.paint.measureText(paramString);
  }

  public void RemoveClip()
  {
    Rect localRect = new Rect(0, 0, this.bw.getWidth(), this.bw.getHeight());
    this.canvas.clipRect(localRect, Region.Op.UNION);
  }

  public BitmapWrapper getBitmap()
  {
    return this.bw;
  }

  @BA.ShortName("Bitmap")
  public static class BitmapWrapper extends AbsObjectWrapper<Bitmap>
  {
    public int GetPixel(int paramInt1, int paramInt2)
    {
      return ((Bitmap)getObject()).getPixel(paramInt1, paramInt2);
    }

    public void Initialize(String paramString1, String paramString2)
      throws IOException
    {
      File.InputStreamWrapper localInputStreamWrapper = null;
      int i = 0;
      try
      {
        localInputStreamWrapper = File.OpenInput(paramString1, paramString2);
        Initialize2((InputStream)localInputStreamWrapper.getObject());
        localInputStreamWrapper.Close();
        if (i != 0)
        {
          BA.Log("Downsampling image due to lack of memory.");
          Display localDisplay = ((WindowManager)BA.applicationContext.getSystemService("window")).getDefaultDisplay();
          InitializeSample(paramString1, paramString2, localDisplay.getWidth() / 2, localDisplay.getHeight() / 2);
        }
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        while (true)
        {
          System.gc();
          localInputStreamWrapper.Close();
          i = 1;
        }
      }
    }

    public void Initialize2(InputStream paramInputStream)
    {
      Bitmap localBitmap = BitmapFactory.decodeStream(paramInputStream);
      if (localBitmap == null)
        throw new RuntimeException("Error loading bitmap.");
      localBitmap.setDensity(160);
      setObject(localBitmap);
    }

    public void Initialize3(Bitmap paramBitmap)
    {
      setObject(Bitmap.createBitmap(paramBitmap));
    }

    public void InitializeMutable(@BA.Pixel int paramInt1, @BA.Pixel int paramInt2)
    {
      setObject(Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888));
    }

    public void InitializeSample(String paramString1, String paramString2, int paramInt1, int paramInt2)
      throws IOException
    {
      File.InputStreamWrapper localInputStreamWrapper = File.OpenInput(paramString1, paramString2);
      BitmapFactory.Options localOptions1 = new BitmapFactory.Options();
      localOptions1.inJustDecodeBounds = true;
      BitmapFactory.decodeStream((InputStream)localInputStreamWrapper.getObject(), null, localOptions1);
      localInputStreamWrapper.Close();
      float f = Math.max(localOptions1.outWidth / paramInt1, localOptions1.outHeight / paramInt2);
      boolean bool = f < 1.0F;
      BitmapFactory.Options localOptions2 = null;
      if (bool)
      {
        localOptions2 = new BitmapFactory.Options();
        localOptions2.inSampleSize = ((int)f);
      }
      Bitmap localBitmap = null;
      int i = 0;
      int j = 5;
      while (true)
      {
        if (j <= 0);
        while (true)
        {
          if (localBitmap != null)
            break label257;
          if (i == 0)
            break label247;
          throw new RuntimeException("Error loading bitmap (OutOfMemoryError)");
          try
          {
            localInputStreamWrapper = File.OpenInput(paramString1, paramString2);
            localBitmap = BitmapFactory.decodeStream((InputStream)localInputStreamWrapper.getObject(), null, localOptions2);
            localInputStreamWrapper.Close();
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            if (localInputStreamWrapper != null)
              localInputStreamWrapper.Close();
            System.gc();
            if (localOptions2 == null)
            {
              localOptions2 = new BitmapFactory.Options();
              localOptions2.inSampleSize = 1;
            }
            localOptions2.inSampleSize = (2 * localOptions2.inSampleSize);
            BA.Log("Downsampling image due to lack of memory: " + localOptions2.inSampleSize);
            i = 1;
            j--;
          }
        }
      }
      label247: throw new RuntimeException("Error loading bitmap.");
      label257: localBitmap.setDensity(160);
      setObject(localBitmap);
    }

    public void WriteToStream(OutputStream paramOutputStream, int paramInt, Bitmap.CompressFormat paramCompressFormat)
    {
      ((Bitmap)getObject()).compress(paramCompressFormat, paramInt, paramOutputStream);
    }

    public int getHeight()
    {
      return ((Bitmap)getObject()).getHeight();
    }

    public int getWidth()
    {
      return ((Bitmap)getObject()).getWidth();
    }

    @BA.Hide
    public String toString()
    {
      String str = baseToString();
      if (IsInitialized())
        str = str + ": " + ((Bitmap)getObject()).getWidth() + " x " + ((Bitmap)getObject()).getHeight();
      return str;
    }
  }

  @BA.ShortName("Path")
  public static class PathWrapper extends AbsObjectWrapper<Path>
  {
    public void Initialize(float paramFloat1, float paramFloat2)
    {
      Path localPath = new Path();
      localPath.moveTo(paramFloat1, paramFloat2);
      setObject(localPath);
    }

    public void LineTo(float paramFloat1, float paramFloat2)
    {
      ((Path)getObject()).lineTo(paramFloat1, paramFloat2);
    }
  }

  @BA.ShortName("Rect")
  public static class RectWrapper extends AbsObjectWrapper<Rect>
  {
    public void Initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      setObject(new Rect(paramInt1, paramInt2, paramInt3, paramInt4));
    }

    public int getBottom()
    {
      return ((Rect)getObject()).bottom;
    }

    public int getCenterX()
    {
      return ((Rect)getObject()).centerX();
    }

    public int getCenterY()
    {
      return ((Rect)getObject()).centerY();
    }

    public int getLeft()
    {
      return ((Rect)getObject()).left;
    }

    public int getRight()
    {
      return ((Rect)getObject()).right;
    }

    public int getTop()
    {
      return ((Rect)getObject()).top;
    }

    public void setBottom(int paramInt)
    {
      ((Rect)getObject()).bottom = paramInt;
    }

    public void setLeft(int paramInt)
    {
      ((Rect)getObject()).left = paramInt;
    }

    public void setRight(int paramInt)
    {
      ((Rect)getObject()).right = paramInt;
    }

    public void setTop(int paramInt)
    {
      ((Rect)getObject()).top = paramInt;
    }

    @BA.Hide
    public String toString()
    {
      String str = baseToString();
      if (IsInitialized())
        str = str + "(" + getLeft() + ", " + getTop() + ", " + getRight() + ", " + getBottom() + ")";
      return str;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.drawable.CanvasWrapper
 * JD-Core Version:    0.6.2
 */