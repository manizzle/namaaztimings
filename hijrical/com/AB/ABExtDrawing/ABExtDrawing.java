package com.AB.ABExtDrawing;

import android.graphics.AvoidXfermode;
import android.graphics.AvoidXfermode.Mode;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Canvas.EdgeType;
import android.graphics.Canvas.VertexMode;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.ComposePathEffect;
import android.graphics.ComposeShader;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.EmbossMaskFilter;
import android.graphics.LayerRasterizer;
import android.graphics.LightingColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.PathDashPathEffect;
import android.graphics.PathDashPathEffect.Style;
import android.graphics.PathEffect;
import android.graphics.PixelXorXfermode;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.SumPathEffect;
import android.graphics.SweepGradient;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import anywheresoftware.b4a.objects.drawable.CanvasWrapper;
import java.nio.Buffer;
import java.text.DateFormat;
import java.util.Calendar;

@BA.Author("Alain Bailleul")
@BA.ShortName("ABExtDrawing")
@BA.Version(1.7F)
public class ABExtDrawing
{
  public static final int ALL_SAVE_FLAG = 31;
  public static final String ALPHA_8 = "ALPHA_8";
  public static final String ARGB_4444 = "ARGB_4444";
  public static final String ARGB_8888 = "ARGB_8888";
  public static final int CLIP_SAVE_FLAG = 2;
  public static final int CLIP_TO_LAYER_SAVE_FLAG = 16;
  public static final int EdgeType_AA = 0;
  public static final int EdgeType_BW = 1;
  public static final int FULL_COLOR_LAYER_SAVE_FLAG = 8;
  public static final int HAS_ALPHA_LAYER_SAVE_FLAG = 4;
  public static final int MATRIX_SAVE_FLAG = 1;
  public static final int PorterDuffMode_CLEAR = 1;
  public static final int PorterDuffMode_DARKEN = 2;
  public static final int PorterDuffMode_DST = 3;
  public static final int PorterDuffMode_DST_ATOP = 4;
  public static final int PorterDuffMode_DST_IN = 5;
  public static final int PorterDuffMode_DST_OUT = 6;
  public static final int PorterDuffMode_DST_OVER = 7;
  public static final int PorterDuffMode_LIGHTEN = 8;
  public static final int PorterDuffMode_MULTIPLY = 9;
  public static final int PorterDuffMode_SCREEN = 11;
  public static final int PorterDuffMode_SRC = 12;
  public static final int PorterDuffMode_SRC_ATOP = 13;
  public static final int PorterDuffMode_SRC_IN = 14;
  public static final int PorterDuffMode_SRC_OUT = 15;
  public static final int PorterDuffMode_SRC_OVER = 16;
  public static final int PorterDuffMode_XOR = 17;
  public static final String RGB_565 = "RGB_565";
  public static final int RegionOp_DIFFERENCE = 0;
  public static final int RegionOp_INTERSECT = 1;
  public static final int RegionOp_REPLACE = 2;
  public static final int RegionOp_REVERSE_DIFFERENCE = 3;
  public static final int RegionOp_UNION = 4;
  public static final int RegionOp_XOR = 5;
  public static final int VertexMode_TRIANGLES = 0;
  public static final int VertexMode_TRIANGLE_FAN = 1;
  public static final int VertexMode_TRIANGLE_STRIP = 2;

  private Bitmap InnerBlur(Bitmap paramBitmap, float paramFloat)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    Paint localPaint = new Paint();
    localPaint.setAlpha(127);
    Bitmap localBitmap1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas1 = new Canvas(localBitmap1);
    Bitmap localBitmap2 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas2 = new Canvas(localBitmap2);
    localCanvas2.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
    for (int k = (int)paramFloat; ; k--)
    {
      if (k <= 0)
      {
        localBitmap1.recycle();
        return localBitmap2;
      }
      localCanvas1.drawBitmap(localBitmap2, 0.0F, 0.0F, localPaint);
      localCanvas2.drawBitmap(localBitmap1, -k, -k, null);
      localCanvas1.drawBitmap(localBitmap2, 0.0F, 0.0F, localPaint);
      localCanvas2.drawBitmap(localBitmap1, -k, k, null);
      localCanvas1.drawBitmap(localBitmap2, 0.0F, 0.0F, localPaint);
      localCanvas2.drawBitmap(localBitmap1, k, k, null);
      localCanvas1.drawBitmap(localBitmap2, 0.0F, 0.0F, localPaint);
      localCanvas2.drawBitmap(localBitmap1, k, -k, null);
    }
  }

  protected int AlignToInt(Paint.Align paramAlign)
  {
    if (paramAlign == Paint.Align.CENTER)
      return 0;
    if (paramAlign == Paint.Align.LEFT)
      return 1;
    return 2;
  }

  public Bitmap Blur(Bitmap paramBitmap, float paramFloat, int paramInt)
  {
    int i = (int)(paramFloat - (float)Math.round(0.4D * paramFloat));
    switch (paramInt)
    {
    default:
      return null;
    case 0:
      return InnerBlur(Resize(InnerBlur(Resize(paramBitmap, 50.0F), i), 200.0F), 1.0F);
    case 1:
    }
    return InnerBlur(Resize(InnerBlur(Resize(paramBitmap, 25.0F), i), 400.0F), 1.0F);
  }

  public void GetAlphaLayer(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    paramBitmap1.extractAlpha();
  }

  public final Rect GetClipBounds(CanvasWrapper paramCanvasWrapper)
  {
    return paramCanvasWrapper.canvas.getClipBounds();
  }

  public Bitmap.Config GetConfig(Bitmap paramBitmap)
  {
    return paramBitmap.getConfig();
  }

  public int GetDensity(CanvasWrapper paramCanvasWrapper)
  {
    return paramCanvasWrapper.canvas.getDensity();
  }

  public String GetFullDate(int paramInt1, int paramInt2, int paramInt3)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
    return DateFormat.getDateInstance(0).format(localCalendar.getTime());
  }

  public int GetHeight(CanvasWrapper paramCanvasWrapper)
  {
    return paramCanvasWrapper.canvas.getHeight();
  }

  public final ABMatrix GetMatrix(CanvasWrapper paramCanvasWrapper)
  {
    ABMatrix localABMatrix = new ABMatrix();
    localABMatrix.Set2(paramCanvasWrapper.canvas.getMatrix());
    return localABMatrix;
  }

  public int GetSaveCount(CanvasWrapper paramCanvasWrapper)
  {
    return paramCanvasWrapper.canvas.getSaveCount();
  }

  public int GetWidth(CanvasWrapper paramCanvasWrapper)
  {
    return paramCanvasWrapper.canvas.getWidth();
  }

  protected Paint.Align IntToAlign(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return Paint.Align.RIGHT;
    case 0:
      return Paint.Align.CENTER;
    case 1:
    }
    return Paint.Align.LEFT;
  }

  public Bitmap MakeBitmapHorizontal(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getHeight();
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setFilterBitmap(true);
    localPaint.setDither(true);
    localRect1.set(0, 0, paramInt2, i);
    localRect2.set(0, 0, paramInt2, i);
    localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
    localRect1.set(paramInt2, 0, paramInt2 * 2, i);
    int j = paramInt2;
    while (true)
    {
      if (j >= paramInt1 - paramInt2)
      {
        localRect1.set(paramInt2 * 2, 0, paramInt2 * 3, i);
        localRect2.set(paramInt1 - paramInt2, 0, paramInt1, i);
        localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
        return localBitmap;
      }
      localRect2.set(j, 0, j + paramInt2, i);
      localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
      j += paramInt2;
    }
  }

  public Bitmap MakeBitmapHorizontalVertical(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setFilterBitmap(true);
    localPaint.setDither(true);
    localRect1.set(0, 0, paramInt3, paramInt4);
    localRect2.set(0, 0, paramInt3, paramInt4);
    localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
    localRect1.set(paramInt3, 0, paramInt3 * 2, paramInt4);
    int i = paramInt3;
    int k;
    int i3;
    if (i >= paramInt1 - paramInt3)
    {
      localRect1.set(paramInt3 * 2, 0, paramInt3 * 3, paramInt4);
      localRect2.set(paramInt1 - paramInt3, 0, paramInt1, paramInt4);
      localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
      k = paramInt4;
      if (k < paramInt2 - paramInt4)
        break label346;
      localRect1.set(0, paramInt4 * 2, paramInt3, paramInt4 * 3);
      localRect2.set(0, paramInt2 - paramInt4, paramInt3, paramInt2);
      localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
      localRect1.set(paramInt3, paramInt4 * 2, paramInt3 * 2, paramInt4 * 3);
      i3 = paramInt3;
    }
    while (true)
    {
      if (i3 >= paramInt1 - paramInt3)
      {
        localRect1.set(paramInt3 * 2, paramInt4 * 2, paramInt3 * 3, paramInt4 * 3);
        localRect2.set(paramInt1 - paramInt3, paramInt2 - paramInt4, paramInt1, paramInt2);
        localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
        return localBitmap;
        int j = i + paramInt3;
        localRect2.set(i, 0, j, paramInt4);
        localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
        i += paramInt3;
        break;
        label346: localRect1.set(0, paramInt4, paramInt3, paramInt4 * 2);
        int m = k + paramInt4;
        localRect2.set(0, k, paramInt3, m);
        localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
        localRect1.set(paramInt3, paramInt4, paramInt3 * 2, paramInt4 * 2);
        int n = paramInt3;
        while (true)
        {
          if (n >= paramInt1 - paramInt3)
          {
            localRect1.set(paramInt3 * 2, paramInt4, paramInt3 * 3, paramInt4 * 2);
            int i1 = paramInt1 - paramInt3;
            int i2 = k + paramInt4;
            localRect2.set(i1, k, paramInt1, i2);
            localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
            k += paramInt4;
            break;
          }
          localRect2.set(n, k, n + paramInt3, k + paramInt4);
          localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
          n += paramInt3;
        }
      }
      int i4 = paramInt2 - paramInt4;
      int i5 = i3 + paramInt3;
      localRect2.set(i3, i4, i5, paramInt2);
      localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
      i3 += paramInt3;
    }
  }

  public Bitmap MakeBitmapScale(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    float f1 = paramInt1 / paramBitmap.getWidth();
    float f2 = paramInt2 / paramBitmap.getHeight();
    float f3 = paramInt1 / 2.0F;
    float f4 = paramInt2 / 2.0F;
    Matrix localMatrix = new Matrix();
    localMatrix.setScale(f1, f2, f3, f4);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.setMatrix(localMatrix);
    localCanvas.drawBitmap(paramBitmap, f3 - paramBitmap.getWidth() / 2, f4 - paramBitmap.getHeight() / 2, new Paint(2));
    return localBitmap;
  }

  public Bitmap MakeBitmapScaleFromRect(Bitmap paramBitmap, Rect paramRect, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    Bitmap localBitmap2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    Rect localRect = new Rect(0, 0, paramInt1, paramInt2);
    new Canvas(localBitmap2).drawBitmap(paramBitmap, paramRect, localRect, new Paint(2));
    float f1 = paramInt1 / localBitmap2.getWidth();
    float f2 = paramInt2 / localBitmap2.getHeight();
    float f3 = paramInt1 / 2.0F;
    float f4 = paramInt2 / 2.0F;
    Matrix localMatrix = new Matrix();
    localMatrix.setScale(f1, f2, f3, f4);
    Canvas localCanvas = new Canvas(localBitmap1);
    localCanvas.setMatrix(localMatrix);
    localCanvas.drawBitmap(localBitmap2, f3 - localBitmap2.getWidth() / 2, f4 - localBitmap2.getHeight() / 2, new Paint(2));
    return localBitmap1;
  }

  public Bitmap MakeBitmapVertical(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    Bitmap localBitmap = Bitmap.createBitmap(i, paramInt1, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setFilterBitmap(true);
    localPaint.setDither(true);
    localRect1.set(0, 0, i, paramInt2);
    localRect2.set(0, 0, i, paramInt2);
    localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
    localRect1.set(0, paramInt2, i, paramInt2 * 2);
    int j = paramInt2;
    while (true)
    {
      if (j >= paramInt1 - paramInt2)
      {
        localRect1.set(0, paramInt2 * 2, i, paramInt2 * 3);
        localRect2.set(0, paramInt1 - paramInt2, i, paramInt1);
        localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
        return localBitmap;
      }
      localRect2.set(0, j, i, j + paramInt2);
      localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
      j += paramInt2;
    }
  }

  public void Recycle(Bitmap paramBitmap)
  {
    paramBitmap.recycle();
  }

  public Bitmap Resize(Bitmap paramBitmap, float paramFloat)
  {
    float f = (float)(paramFloat / 100.0D);
    int i = (int)(f * paramBitmap.getWidth());
    int j = (int)(f * paramBitmap.getHeight());
    if (paramFloat > 100.0F)
      return Bitmap.createScaledBitmap(paramBitmap, i, j, true);
    return Bitmap.createScaledBitmap(paramBitmap, i, j, false);
  }

  public Bitmap Saturate(Bitmap paramBitmap, float paramFloat)
  {
    ColorMatrix localColorMatrix = new ColorMatrix();
    ColorMatrixColorFilter localColorMatrixColorFilter = new ColorMatrixColorFilter(localColorMatrix);
    Paint localPaint = new Paint();
    localPaint.setColorFilter(localColorMatrixColorFilter);
    localColorMatrix.setSaturation(paramFloat / 100.0F);
    localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getConfig());
    new Canvas(localBitmap).drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    return localBitmap;
  }

  public void SetBitmap(CanvasWrapper paramCanvasWrapper, Bitmap paramBitmap)
  {
    paramCanvasWrapper.canvas.setBitmap(paramBitmap);
  }

  public void SetDensity(CanvasWrapper paramCanvasWrapper, int paramInt)
  {
    paramCanvasWrapper.canvas.setDensity(paramInt);
  }

  public void SetMatrix(CanvasWrapper paramCanvasWrapper, ABMatrix paramABMatrix)
  {
    paramCanvasWrapper.canvas.setMatrix(paramABMatrix.mMatrix);
  }

  public void SetPaintFlagsDrawFilter(CanvasWrapper paramCanvasWrapper, int paramInt1, int paramInt2)
  {
    paramCanvasWrapper.canvas.setDrawFilter(new PaintFlagsDrawFilter(paramInt1, paramInt2));
  }

  public boolean clipPath(CanvasWrapper paramCanvasWrapper, ABPath paramABPath, int paramInt)
  {
    Region.Op localOp;
    switch (paramInt)
    {
    default:
      localOp = Region.Op.XOR;
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      return paramCanvasWrapper.canvas.clipPath(paramABPath.mPath, localOp);
      localOp = Region.Op.DIFFERENCE;
      continue;
      localOp = Region.Op.INTERSECT;
      continue;
      localOp = Region.Op.REPLACE;
      continue;
      localOp = Region.Op.REVERSE_DIFFERENCE;
      continue;
      localOp = Region.Op.UNION;
    }
  }

  public boolean clipPath2(CanvasWrapper paramCanvasWrapper, ABPath paramABPath)
  {
    return paramCanvasWrapper.canvas.clipPath(paramABPath.mPath);
  }

  public boolean clipRect(CanvasWrapper paramCanvasWrapper, Rect paramRect, int paramInt)
  {
    Region.Op localOp;
    switch (paramInt)
    {
    default:
      localOp = Region.Op.XOR;
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      return paramCanvasWrapper.canvas.clipRect(paramRect, localOp);
      localOp = Region.Op.DIFFERENCE;
      continue;
      localOp = Region.Op.INTERSECT;
      continue;
      localOp = Region.Op.REPLACE;
      continue;
      localOp = Region.Op.REVERSE_DIFFERENCE;
      continue;
      localOp = Region.Op.UNION;
    }
  }

  public boolean clipRect2(CanvasWrapper paramCanvasWrapper, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramCanvasWrapper.canvas.clipRect(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public boolean clipRegion(CanvasWrapper paramCanvasWrapper, ABRegion paramABRegion)
  {
    return paramCanvasWrapper.canvas.clipRegion(paramABRegion.mRegion);
  }

  public void concat(CanvasWrapper paramCanvasWrapper, ABMatrix paramABMatrix)
  {
    paramCanvasWrapper.canvas.concat(paramABMatrix.mMatrix);
  }

  public void copyPixelsFromBuffer(Bitmap paramBitmap, Buffer paramBuffer)
  {
    paramBitmap.copyPixelsFromBuffer(paramBuffer);
  }

  public void copyPixelsToBuffer(Bitmap paramBitmap, Buffer paramBuffer)
  {
    paramBitmap.copyPixelsToBuffer(paramBuffer);
  }

  public void drawARGB(CanvasWrapper paramCanvasWrapper, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramCanvasWrapper.canvas.drawARGB(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void drawArc(CanvasWrapper paramCanvasWrapper, ABRectF paramABRectF, float paramFloat1, float paramFloat2, boolean paramBoolean, ABPaint paramABPaint)
  {
    paramCanvasWrapper.canvas.drawArc(paramABRectF.mRectF, paramFloat1, paramFloat2, paramBoolean, paramABPaint.mPaint);
  }

  public void drawBitmap(CanvasWrapper paramCanvasWrapper, Bitmap paramBitmap, Rect paramRect1, Rect paramRect2, ABPaint paramABPaint)
  {
    paramCanvasWrapper.canvas.drawBitmap(paramBitmap, paramRect1, paramRect2, paramABPaint.mPaint);
  }

  public void drawBitmap2(CanvasWrapper paramCanvasWrapper, Bitmap paramBitmap, float paramFloat1, float paramFloat2, ABPaint paramABPaint)
  {
    paramCanvasWrapper.canvas.drawBitmap(paramBitmap, paramFloat1, paramFloat2, paramABPaint.mPaint);
  }

  public void drawBitmap3(CanvasWrapper paramCanvasWrapper, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, ABPaint paramABPaint)
  {
    paramCanvasWrapper.canvas.drawBitmap(paramArrayOfInt, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramBoolean, paramABPaint.mPaint);
  }

  public void drawBitmap4(CanvasWrapper paramCanvasWrapper, Bitmap paramBitmap, ABMatrix paramABMatrix, ABPaint paramABPaint)
  {
    paramCanvasWrapper.canvas.drawBitmap(paramBitmap, paramABMatrix.mMatrix, paramABPaint.mPaint);
  }

  public void drawBitmapMesh(CanvasWrapper paramCanvasWrapper, Bitmap paramBitmap, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3, int[] paramArrayOfInt, int paramInt4, ABPaint paramABPaint)
  {
    paramCanvasWrapper.canvas.drawBitmapMesh(paramBitmap, paramInt1, paramInt2, paramArrayOfFloat, paramInt3, paramArrayOfInt, paramInt4, paramABPaint.mPaint);
  }

  public void drawCircle(CanvasWrapper paramCanvasWrapper, float paramFloat1, float paramFloat2, float paramFloat3, ABPaint paramABPaint)
  {
    paramCanvasWrapper.canvas.drawCircle(paramFloat1, paramFloat2, paramFloat3, paramABPaint.mPaint);
  }

  public void drawColor(CanvasWrapper paramCanvasWrapper, int paramInt)
  {
    paramCanvasWrapper.canvas.drawColor(paramInt);
  }

  public void drawColor2(CanvasWrapper paramCanvasWrapper, int paramInt1, int paramInt2)
  {
    PorterDuff.Mode localMode;
    switch (paramInt2)
    {
    case 10:
    default:
      localMode = PorterDuff.Mode.XOR;
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 11:
    case 12:
    case 13:
    case 14:
    case 15:
    case 16:
    }
    while (true)
    {
      paramCanvasWrapper.canvas.drawColor(paramInt1, localMode);
      return;
      localMode = PorterDuff.Mode.CLEAR;
      continue;
      localMode = PorterDuff.Mode.DARKEN;
      continue;
      localMode = PorterDuff.Mode.DST;
      continue;
      localMode = PorterDuff.Mode.DST_ATOP;
      continue;
      localMode = PorterDuff.Mode.DST_IN;
      continue;
      localMode = PorterDuff.Mode.DST_OUT;
      continue;
      localMode = PorterDuff.Mode.DST_OVER;
      continue;
      localMode = PorterDuff.Mode.LIGHTEN;
      continue;
      localMode = PorterDuff.Mode.MULTIPLY;
      continue;
      localMode = PorterDuff.Mode.SCREEN;
      continue;
      localMode = PorterDuff.Mode.SRC;
      continue;
      localMode = PorterDuff.Mode.SRC_ATOP;
      continue;
      localMode = PorterDuff.Mode.SRC_IN;
      continue;
      localMode = PorterDuff.Mode.SRC_OUT;
      continue;
      localMode = PorterDuff.Mode.SRC_OVER;
    }
  }

  public void drawLine(CanvasWrapper paramCanvasWrapper, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, ABPaint paramABPaint)
  {
    paramCanvasWrapper.canvas.drawLine(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramABPaint.mPaint);
  }

  public void drawLines(CanvasWrapper paramCanvasWrapper, float[] paramArrayOfFloat, ABPaint paramABPaint)
  {
    paramCanvasWrapper.canvas.drawLines(paramArrayOfFloat, paramABPaint.mPaint);
  }

  public void drawLines2(CanvasWrapper paramCanvasWrapper, float[] paramArrayOfFloat, int paramInt1, int paramInt2, ABPaint paramABPaint)
  {
    paramCanvasWrapper.canvas.drawLines(paramArrayOfFloat, paramInt1, paramInt2, paramABPaint.mPaint);
  }

  public void drawOval(CanvasWrapper paramCanvasWrapper, ABRectF paramABRectF, ABPaint paramABPaint)
  {
    paramCanvasWrapper.canvas.drawOval(paramABRectF.mRectF, paramABPaint.mPaint);
  }

  public void drawPaint(CanvasWrapper paramCanvasWrapper, ABPaint paramABPaint)
  {
    paramCanvasWrapper.canvas.drawPaint(paramABPaint.mPaint);
  }

  public void drawPath(CanvasWrapper paramCanvasWrapper, ABPath paramABPath, ABPaint paramABPaint)
  {
    paramCanvasWrapper.canvas.drawPath(paramABPath.mPath, paramABPaint.mPaint);
  }

  public void drawPoint(CanvasWrapper paramCanvasWrapper, float paramFloat1, float paramFloat2, ABPaint paramABPaint)
  {
    paramCanvasWrapper.canvas.drawPoint(paramFloat1, paramFloat2, paramABPaint.mPaint);
  }

  public void drawPoints(CanvasWrapper paramCanvasWrapper, float[] paramArrayOfFloat, int paramInt1, int paramInt2, ABPaint paramABPaint)
  {
    paramCanvasWrapper.canvas.drawPoints(paramArrayOfFloat, paramInt1, paramInt2, paramABPaint.mPaint);
  }

  public void drawPoints2(CanvasWrapper paramCanvasWrapper, float[] paramArrayOfFloat, ABPaint paramABPaint)
  {
    paramCanvasWrapper.canvas.drawPoints(paramArrayOfFloat, paramABPaint.mPaint);
  }

  public void drawPosText(CanvasWrapper paramCanvasWrapper, String paramString, float[] paramArrayOfFloat, ABPaint paramABPaint)
  {
    paramCanvasWrapper.canvas.drawPosText(paramString, paramArrayOfFloat, paramABPaint.mPaint);
  }

  public void drawRGB(CanvasWrapper paramCanvasWrapper, int paramInt1, int paramInt2, int paramInt3)
  {
    paramCanvasWrapper.canvas.drawRGB(paramInt1, paramInt2, paramInt3);
  }

  public void drawRect(CanvasWrapper paramCanvasWrapper, Rect paramRect, ABPaint paramABPaint)
  {
    paramCanvasWrapper.canvas.drawRect(paramRect, paramABPaint.mPaint);
  }

  public void drawRect2(CanvasWrapper paramCanvasWrapper, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, ABPaint paramABPaint)
  {
    paramCanvasWrapper.canvas.drawRect(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramABPaint.mPaint);
  }

  public void drawRoundRect(CanvasWrapper paramCanvasWrapper, ABRectF paramABRectF, float paramFloat1, float paramFloat2, ABPaint paramABPaint)
  {
    paramCanvasWrapper.canvas.drawRoundRect(paramABRectF.mRectF, paramFloat1, paramFloat2, paramABPaint.mPaint);
  }

  public void drawText(CanvasWrapper paramCanvasWrapper, String paramString, float paramFloat1, float paramFloat2, ABPaint paramABPaint)
  {
    paramCanvasWrapper.canvas.drawText(paramString, paramFloat1, paramFloat2, paramABPaint.mPaint);
  }

  public void drawText2(CanvasWrapper paramCanvasWrapper, String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, ABPaint paramABPaint)
  {
    paramCanvasWrapper.canvas.drawText(paramString, paramInt1, paramInt2, paramFloat1, paramFloat2, paramABPaint.mPaint);
  }

  public void drawTextOnPath(CanvasWrapper paramCanvasWrapper, String paramString, ABPath paramABPath, float paramFloat1, float paramFloat2, ABPaint paramABPaint)
  {
    paramCanvasWrapper.canvas.drawTextOnPath(paramString, paramABPath.mPath, paramFloat1, paramFloat2, paramABPaint.mPaint);
  }

  public void drawVertices(CanvasWrapper paramCanvasWrapper, int paramInt1, int paramInt2, float[] paramArrayOfFloat1, int paramInt3, float[] paramArrayOfFloat2, int paramInt4, int[] paramArrayOfInt, int paramInt5, short[] paramArrayOfShort, int paramInt6, int paramInt7, ABPaint paramABPaint)
  {
    Canvas.VertexMode localVertexMode;
    switch (paramInt1)
    {
    default:
      localVertexMode = Canvas.VertexMode.TRIANGLE_STRIP;
    case 0:
    case 1:
    }
    while (true)
    {
      paramCanvasWrapper.canvas.drawVertices(localVertexMode, paramInt2, paramArrayOfFloat1, paramInt3, paramArrayOfFloat2, paramInt4, paramArrayOfInt, paramInt5, paramArrayOfShort, paramInt6, paramInt7, paramABPaint.mPaint);
      return;
      localVertexMode = Canvas.VertexMode.TRIANGLES;
      continue;
      localVertexMode = Canvas.VertexMode.TRIANGLE_FAN;
    }
  }

  public void drawWrapText(CanvasWrapper paramCanvasWrapper, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ABPaint paramABPaint)
  {
    TextPaint localTextPaint = new TextPaint(paramABPaint.mPaint);
    Layout.Alignment localAlignment = Layout.Alignment.ALIGN_NORMAL;
    paramCanvasWrapper.canvas.save();
    paramCanvasWrapper.canvas.translate(paramInt1, paramInt2);
    if (paramInt4 != -1)
      paramCanvasWrapper.canvas.clipRect(new Rect(0, 0, paramInt3, paramInt4));
    new StaticLayout(paramString, localTextPaint, paramInt3, localAlignment, 1.0F, 0.0F, false).draw(paramCanvasWrapper.canvas);
    paramCanvasWrapper.canvas.restore();
  }

  public void getPixels(Bitmap paramBitmap, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    throws IllegalArgumentException, ArrayIndexOutOfBoundsException
  {
    paramBitmap.getPixels(paramArrayOfInt, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }

  public boolean isHardwareAccelerated(CanvasWrapper paramCanvasWrapper)
  {
    return paramCanvasWrapper.canvas.isHardwareAccelerated();
  }

  public boolean isOpaque(CanvasWrapper paramCanvasWrapper)
  {
    return paramCanvasWrapper.canvas.isOpaque();
  }

  public boolean quickReject(CanvasWrapper paramCanvasWrapper, ABPath paramABPath, int paramInt)
  {
    Canvas.EdgeType localEdgeType = Canvas.EdgeType.AA;
    if (paramInt == 1)
      localEdgeType = Canvas.EdgeType.BW;
    return paramCanvasWrapper.canvas.quickReject(paramABPath.mPath, localEdgeType);
  }

  public boolean quickReject2(CanvasWrapper paramCanvasWrapper, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    Canvas.EdgeType localEdgeType = Canvas.EdgeType.AA;
    if (paramInt == 1)
      localEdgeType = Canvas.EdgeType.BW;
    return paramCanvasWrapper.canvas.quickReject(paramFloat1, paramFloat2, paramFloat3, paramFloat4, localEdgeType);
  }

  public boolean quickReject3(CanvasWrapper paramCanvasWrapper, ABRectF paramABRectF, int paramInt)
  {
    Canvas.EdgeType localEdgeType = Canvas.EdgeType.AA;
    if (paramInt == 1)
      localEdgeType = Canvas.EdgeType.BW;
    return paramCanvasWrapper.canvas.quickReject(paramABRectF.mRectF, localEdgeType);
  }

  public void restore(CanvasWrapper paramCanvasWrapper)
  {
    paramCanvasWrapper.canvas.restore();
  }

  public void restoreToCount(CanvasWrapper paramCanvasWrapper, int paramInt)
  {
    paramCanvasWrapper.canvas.restoreToCount(paramInt);
  }

  public void rotate(CanvasWrapper paramCanvasWrapper, float paramFloat)
  {
    paramCanvasWrapper.canvas.rotate(paramFloat);
  }

  public final void rotate2(CanvasWrapper paramCanvasWrapper, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramCanvasWrapper.canvas.rotate(paramFloat1, paramFloat2, paramFloat3);
  }

  public int save(CanvasWrapper paramCanvasWrapper)
  {
    return paramCanvasWrapper.canvas.save();
  }

  public int save2(CanvasWrapper paramCanvasWrapper, int paramInt)
  {
    return paramCanvasWrapper.canvas.save(paramInt);
  }

  public int saveLayer(CanvasWrapper paramCanvasWrapper, ABRectF paramABRectF, ABPaint paramABPaint, int paramInt)
  {
    return paramCanvasWrapper.canvas.saveLayer(paramABRectF.mRectF, paramABPaint.mPaint, paramInt);
  }

  public int saveLayer2(CanvasWrapper paramCanvasWrapper, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, ABPaint paramABPaint, int paramInt)
  {
    return paramCanvasWrapper.canvas.saveLayer(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramABPaint.mPaint, paramInt);
  }

  public int saveLayerAlpha(CanvasWrapper paramCanvasWrapper, ABRectF paramABRectF, int paramInt1, int paramInt2)
  {
    return paramCanvasWrapper.canvas.saveLayerAlpha(paramABRectF.mRectF, paramInt1, paramInt2);
  }

  public int saveLayerAlpha2(CanvasWrapper paramCanvasWrapper, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2)
  {
    return paramCanvasWrapper.canvas.saveLayerAlpha(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt1, paramInt2);
  }

  public void scale(CanvasWrapper paramCanvasWrapper, float paramFloat1, float paramFloat2)
  {
    paramCanvasWrapper.canvas.scale(paramFloat1, paramFloat2);
  }

  public final void scale2(CanvasWrapper paramCanvasWrapper, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramCanvasWrapper.canvas.scale(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }

  public void setPixels(Bitmap paramBitmap, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    throws IllegalStateException, IllegalArgumentException, ArrayIndexOutOfBoundsException
  {
    paramBitmap.setPixels(paramArrayOfInt, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }

  public void skew(CanvasWrapper paramCanvasWrapper, float paramFloat1, float paramFloat2)
  {
    paramCanvasWrapper.canvas.skew(paramFloat1, paramFloat2);
  }

  public void translate(CanvasWrapper paramCanvasWrapper, float paramFloat1, float paramFloat2)
  {
    paramCanvasWrapper.canvas.translate(paramFloat1, paramFloat2);
  }

  @BA.ShortName("ABCamera")
  public static class ABCamera
  {
    private Camera mCamera = null;

    public void GetMatrix(ABExtDrawing.ABMatrix paramABMatrix)
    {
      this.mCamera.getMatrix(paramABMatrix.mMatrix);
    }

    public void Initialize()
    {
      this.mCamera = new Camera();
    }

    public void SetLocation(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      this.mCamera.setLocation(paramFloat1, paramFloat2, paramFloat3);
    }

    public void applyToCanvas(CanvasWrapper paramCanvasWrapper)
    {
      this.mCamera.applyToCanvas(paramCanvasWrapper.canvas);
    }

    public float dotWithNormal(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      return this.mCamera.dotWithNormal(paramFloat1, paramFloat2, paramFloat3);
    }

    public void restore()
    {
      this.mCamera.restore();
    }

    public void rotate(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      this.mCamera.rotate(paramFloat1, paramFloat2, paramFloat3);
    }

    public void rotateX(float paramFloat)
    {
      this.mCamera.rotateX(paramFloat);
    }

    public void rotateY(float paramFloat)
    {
      this.mCamera.rotateY(paramFloat);
    }

    public void rotateZ(float paramFloat)
    {
      this.mCamera.rotateZ(paramFloat);
    }

    public void save()
    {
      this.mCamera.save();
    }

    public void translate(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      this.mCamera.translate(paramFloat1, paramFloat2, paramFloat3);
    }
  }

  @BA.ShortName("ABColorMatrix")
  public static class ABColorMatrix
  {
    protected ColorMatrix mColorMatrix = new ColorMatrix();

    public void Initialize()
    {
      this.mColorMatrix = new ColorMatrix();
    }

    public void Initialize2(float[] paramArrayOfFloat)
    {
      this.mColorMatrix = new ColorMatrix(paramArrayOfFloat);
    }

    public void Initialize3(ABColorMatrix paramABColorMatrix)
    {
      this.mColorMatrix = new ColorMatrix(paramABColorMatrix.mColorMatrix);
    }

    public void Set(float[] paramArrayOfFloat)
    {
      this.mColorMatrix.set(paramArrayOfFloat);
    }

    public void Set2(ABColorMatrix paramABColorMatrix)
    {
      this.mColorMatrix.set(paramABColorMatrix.mColorMatrix);
    }

    public void SetRGB2YUV()
    {
      this.mColorMatrix.setRGB2YUV();
    }

    public void SetRotate(int paramInt, float paramFloat)
    {
      this.mColorMatrix.setRotate(paramInt, paramFloat);
    }

    public void SetSaturation(float paramFloat)
    {
      this.mColorMatrix.setSaturation(paramFloat);
    }

    public void SetScale(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.mColorMatrix.setScale(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    }

    public void SetYUV2RGB()
    {
      this.mColorMatrix.setYUV2RGB();
    }

    public float[] getArray()
    {
      return this.mColorMatrix.getArray();
    }

    public void postConcat(ABColorMatrix paramABColorMatrix)
    {
      this.mColorMatrix.postConcat(paramABColorMatrix.mColorMatrix);
    }

    public void preConcat(ABColorMatrix paramABColorMatrix)
    {
      this.mColorMatrix.preConcat(paramABColorMatrix.mColorMatrix);
    }

    public void reset()
    {
      this.mColorMatrix.reset();
    }

    public void setConcat(ABColorMatrix paramABColorMatrix1, ABColorMatrix paramABColorMatrix2)
    {
      this.mColorMatrix.setConcat(paramABColorMatrix1.mColorMatrix, paramABColorMatrix2.mColorMatrix);
    }
  }

  @BA.ShortName("ABMatrix")
  public static class ABMatrix
  {
    public static final int MPERSP_0 = 6;
    public static final int MPERSP_1 = 7;
    public static final int MPERSP_2 = 8;
    public static final int MSCALE_X = 0;
    public static final int MSCALE_Y = 4;
    public static final int MSKEW_X = 1;
    public static final int MSKEW_Y = 3;
    public static final int MTRANS_X = 2;
    public static final int MTRANS_Y = 5;
    public static final int MatrixScaleToFit_CENTER = 0;
    public static final int MatrixScaleToFit_END = 1;
    public static final int MatrixScaleToFit_FILL = 2;
    public static final int MatrixScaleToFit_START = 3;
    protected Matrix mMatrix = new Matrix();

    public void Initialize()
    {
      this.mMatrix = new Matrix();
    }

    public void Initialize2(ABMatrix paramABMatrix)
    {
      this.mMatrix = new Matrix(paramABMatrix.mMatrix);
    }

    public void Set(ABMatrix paramABMatrix)
    {
      this.mMatrix.set(paramABMatrix.mMatrix);
    }

    protected void Set2(Matrix paramMatrix)
    {
      this.mMatrix.set(paramMatrix);
    }

    public boolean equals(Object paramObject)
    {
      return this.mMatrix.equals(paramObject);
    }

    public void getValues(float[] paramArrayOfFloat)
    {
      this.mMatrix.getValues(paramArrayOfFloat);
    }

    public boolean invert(ABMatrix paramABMatrix)
    {
      return this.mMatrix.invert(paramABMatrix.mMatrix);
    }

    public boolean isIdentity()
    {
      return this.mMatrix.isIdentity();
    }

    public void mapPoints(float[] paramArrayOfFloat1, int paramInt1, float[] paramArrayOfFloat2, int paramInt2, int paramInt3)
    {
      this.mMatrix.mapPoints(paramArrayOfFloat1, paramInt1, paramArrayOfFloat2, paramInt2, paramInt3);
    }

    public void mapPoints2(float[] paramArrayOfFloat)
    {
      this.mMatrix.mapPoints(paramArrayOfFloat);
    }

    public void mapPoints3(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
    {
      this.mMatrix.mapPoints(paramArrayOfFloat1, paramArrayOfFloat2);
    }

    public float mapRadius(float paramFloat)
    {
      return this.mMatrix.mapRadius(paramFloat);
    }

    public boolean mapRect(ABExtDrawing.ABRectF paramABRectF)
    {
      return this.mMatrix.mapRect(ABExtDrawing.ABRectF.access$0(paramABRectF));
    }

    public boolean mapRect(ABExtDrawing.ABRectF paramABRectF1, ABExtDrawing.ABRectF paramABRectF2)
    {
      return this.mMatrix.mapRect(ABExtDrawing.ABRectF.access$0(paramABRectF1), ABExtDrawing.ABRectF.access$0(paramABRectF2));
    }

    public void mapVectors(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
    {
      this.mMatrix.mapVectors(paramArrayOfFloat1, paramArrayOfFloat2);
    }

    public void mapVectors2(float[] paramArrayOfFloat)
    {
      this.mMatrix.mapPoints(paramArrayOfFloat);
    }

    public void mapVectors3(float[] paramArrayOfFloat1, int paramInt1, float[] paramArrayOfFloat2, int paramInt2, int paramInt3)
    {
      this.mMatrix.mapPoints(paramArrayOfFloat1, paramInt1, paramArrayOfFloat2, paramInt2, paramInt3);
    }

    public boolean postConcat(ABMatrix paramABMatrix)
    {
      return this.mMatrix.postConcat(paramABMatrix.mMatrix);
    }

    public boolean postRotate(float paramFloat)
    {
      return this.mMatrix.postRotate(paramFloat);
    }

    public boolean postRotate(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      return this.mMatrix.postRotate(paramFloat1, paramFloat2, paramFloat3);
    }

    public boolean postScale(float paramFloat1, float paramFloat2)
    {
      return this.mMatrix.postScale(paramFloat1, paramFloat2);
    }

    public boolean postScale(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      return this.mMatrix.postScale(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    }

    public boolean postSkew(float paramFloat1, float paramFloat2)
    {
      return this.mMatrix.postSkew(paramFloat1, paramFloat2);
    }

    public boolean postSkew(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      return this.mMatrix.postSkew(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    }

    public boolean postTranslate(float paramFloat1, float paramFloat2)
    {
      return this.mMatrix.postTranslate(paramFloat1, paramFloat2);
    }

    public boolean preConcat(ABMatrix paramABMatrix)
    {
      return this.mMatrix.preConcat(paramABMatrix.mMatrix);
    }

    public boolean preRotate(float paramFloat)
    {
      return this.mMatrix.preRotate(paramFloat);
    }

    public boolean preRotate(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      return this.mMatrix.preRotate(paramFloat1, paramFloat2, paramFloat3);
    }

    public boolean preScale(float paramFloat1, float paramFloat2)
    {
      return this.mMatrix.preScale(paramFloat1, paramFloat2);
    }

    public boolean preScale(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      return this.mMatrix.preScale(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    }

    public boolean preSkew(float paramFloat1, float paramFloat2)
    {
      return this.mMatrix.preSkew(paramFloat1, paramFloat2);
    }

    public boolean preSkew(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      return this.mMatrix.preSkew(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    }

    public boolean preTranslate(float paramFloat1, float paramFloat2)
    {
      return this.mMatrix.preTranslate(paramFloat1, paramFloat2);
    }

    public boolean rectStaysRect()
    {
      return this.mMatrix.rectStaysRect();
    }

    public void reset()
    {
      this.mMatrix.reset();
    }

    public boolean setConcat(ABMatrix paramABMatrix1, ABMatrix paramABMatrix2)
    {
      return this.mMatrix.setConcat(paramABMatrix1.mMatrix, paramABMatrix2.mMatrix);
    }

    public boolean setPolyToPoly(float[] paramArrayOfFloat1, int paramInt1, float[] paramArrayOfFloat2, int paramInt2, int paramInt3)
    {
      return this.mMatrix.setPolyToPoly(paramArrayOfFloat1, paramInt1, paramArrayOfFloat2, paramInt2, paramInt3);
    }

    public boolean setRectToRect(ABExtDrawing.ABRectF paramABRectF1, ABExtDrawing.ABRectF paramABRectF2, int paramInt)
    {
      Matrix.ScaleToFit localScaleToFit;
      switch (paramInt)
      {
      default:
        localScaleToFit = Matrix.ScaleToFit.START;
      case 0:
      case 1:
      case 2:
      }
      while (true)
      {
        return this.mMatrix.setRectToRect(ABExtDrawing.ABRectF.access$0(paramABRectF1), ABExtDrawing.ABRectF.access$0(paramABRectF2), localScaleToFit);
        localScaleToFit = Matrix.ScaleToFit.CENTER;
        continue;
        localScaleToFit = Matrix.ScaleToFit.END;
        continue;
        localScaleToFit = Matrix.ScaleToFit.FILL;
      }
    }

    public void setRotate(float paramFloat)
    {
      this.mMatrix.setRotate(paramFloat);
    }

    public void setRotate2(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      this.mMatrix.setRotate(paramFloat1, paramFloat2, paramFloat3);
    }

    public void setScale(float paramFloat1, float paramFloat2)
    {
      this.mMatrix.setScale(paramFloat1, paramFloat2);
    }

    public void setScale2(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.mMatrix.setScale(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    }

    public void setSinCos(float paramFloat1, float paramFloat2)
    {
      this.mMatrix.setSinCos(paramFloat1, paramFloat2);
    }

    public void setSinCos2(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.mMatrix.setSinCos(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    }

    public void setSkew(float paramFloat1, float paramFloat2)
    {
      this.mMatrix.setSkew(paramFloat1, paramFloat2);
    }

    public void setSkew2(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.mMatrix.setSkew(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    }

    public void setTranslate(float paramFloat1, float paramFloat2)
    {
      this.mMatrix.setTranslate(paramFloat1, paramFloat2);
    }

    public void setValues(float[] paramArrayOfFloat)
    {
      this.mMatrix.setValues(paramArrayOfFloat);
    }
  }

  @BA.ShortName("ABPaint")
  public static class ABPaint
  {
    public static final int Align_CENTER = 0;
    public static final int Align_LEFT = 1;
    public static final int Align_RIGHT = 2;
    public static final int AvoidXfermodeMode_AVOID = 0;
    public static final int AvoidXfermodeMode_TARGET = 1;
    public static final int Blur_INNER = 0;
    public static final int Blur_NORMAL = 1;
    public static final int Blur_OUTER = 2;
    public static final int Blur_SOLID = 3;
    public static final int Cap_BUTT = 0;
    public static final int Cap_ROUND = 1;
    public static final int Cap_SQUARE = 2;
    public static final int Join_BEVEL = 0;
    public static final int Join_MITER = 1;
    public static final int Join_ROUND = 2;
    public static final int PathDashPathEffectStyle_MORPH = 0;
    public static final int PathDashPathEffectStyle_ROTATE = 1;
    public static final int PathDashPathEffectStyle_TRANSLATE = 2;
    public static final int PorterDuffMode_ADD = 0;
    public static final int PorterDuffMode_CLEAR = 1;
    public static final int PorterDuffMode_DARKEN = 2;
    public static final int PorterDuffMode_DST = 3;
    public static final int PorterDuffMode_DST_ATOP = 4;
    public static final int PorterDuffMode_DST_IN = 5;
    public static final int PorterDuffMode_DST_OUT = 6;
    public static final int PorterDuffMode_DST_OVER = 7;
    public static final int PorterDuffMode_LIGHTEN = 8;
    public static final int PorterDuffMode_MULTIPLY = 9;
    public static final int PorterDuffMode_OVERLAY = 10;
    public static final int PorterDuffMode_SCREEN = 11;
    public static final int PorterDuffMode_SRC = 12;
    public static final int PorterDuffMode_SRC_ATOP = 13;
    public static final int PorterDuffMode_SRC_IN = 14;
    public static final int PorterDuffMode_SRC_OUT = 15;
    public static final int PorterDuffMode_SRC_OVER = 16;
    public static final int PorterDuffMode_XOR = 17;
    public static final int ShaderTileMode_CLAMP = 0;
    public static final int ShaderTileMode_MIRROR = 1;
    public static final int ShaderTileMode_REPEAT = 2;
    public static final int Style_FILL = 0;
    public static final int Style_FILL_AND_STROKE = 1;
    public static final int Style_STROKE = 2;
    public static final int flag_ANTI_ALIAS_FLAG = 1;
    public static final int flag_DEV_KERN_TEXT_FLAG = 256;
    public static final int flag_DITHER_FLAG = 4;
    public static final int flag_FAKE_BOLD_TEXT_FLAG = 32;
    public static final int flag_FILTER_BITMAP_FLAG = 2;
    public static final int flag_HINTING_OFF = 0;
    public static final int flag_HINTING_ON = 1;
    public static final int flag_LINEAR_TEXT_FLAG = 64;
    public static final int flag_STRIKE_THRU_TEXT_FLAG = 16;
    public static final int flag_SUBPIXEL_TEXT_FLAG = 128;
    public static final int flag_UNDERLINE_TEXT_FLAG = 8;
    private Shader ShaderA = null;
    private Shader ShaderB = null;
    private Paint mPaint = null;
    private LayerRasterizer mRasterizer = new LayerRasterizer();
    private PathEffect pathEffect1 = null;
    private PathEffect pathEffect2 = null;

    protected int AlignToInt(Paint.Align paramAlign)
    {
      if (paramAlign == Paint.Align.CENTER)
        return 0;
      if (paramAlign == Paint.Align.LEFT)
        return 1;
      return 2;
    }

    protected int CapToInt(Paint.Cap paramCap)
    {
      if (paramCap == Paint.Cap.BUTT)
        return 0;
      if (paramCap == Paint.Cap.ROUND)
        return 1;
      return 2;
    }

    public void ClearLayerRasterizer()
    {
      this.mRasterizer = new LayerRasterizer();
      this.mPaint.setRasterizer(null);
    }

    public void DoPathEffectCompose()
    {
      ComposePathEffect localComposePathEffect = new ComposePathEffect(this.pathEffect1, this.pathEffect2);
      this.mPaint.setPathEffect(localComposePathEffect);
    }

    public void DoPathEffectSingle(int paramInt)
    {
      if (paramInt == 1)
      {
        this.mPaint.setPathEffect(this.pathEffect1);
        return;
      }
      this.mPaint.setPathEffect(this.pathEffect2);
    }

    public void DoPathEffectSum()
    {
      SumPathEffect localSumPathEffect = new SumPathEffect(this.pathEffect1, this.pathEffect2);
      this.mPaint.setPathEffect(localSumPathEffect);
    }

    public void DoShaderComposeXfermodeAvoid(int paramInt1, int paramInt2, int paramInt3)
    {
      AvoidXfermode.Mode localMode = AvoidXfermode.Mode.AVOID;
      if (paramInt3 == 1)
        localMode = AvoidXfermode.Mode.TARGET;
      AvoidXfermode localAvoidXfermode = new AvoidXfermode(paramInt1, paramInt2, localMode);
      ComposeShader localComposeShader = new ComposeShader(this.ShaderA, this.ShaderB, localAvoidXfermode);
      this.mPaint.setShader(localComposeShader);
    }

    public void DoShaderComposeXfermodePixelXor(int paramInt)
    {
      PixelXorXfermode localPixelXorXfermode = new PixelXorXfermode(paramInt);
      ComposeShader localComposeShader = new ComposeShader(this.ShaderA, this.ShaderB, localPixelXorXfermode);
      this.mPaint.setShader(localComposeShader);
    }

    public void DoShaderComposeXfermodePorterduffMode(int paramInt)
    {
      PorterDuff.Mode localMode;
      switch (paramInt)
      {
      case 10:
      default:
        localMode = PorterDuff.Mode.XOR;
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
      case 16:
      }
      while (true)
      {
        PorterDuffXfermode localPorterDuffXfermode = new PorterDuffXfermode(localMode);
        ComposeShader localComposeShader = new ComposeShader(this.ShaderA, this.ShaderB, localPorterDuffXfermode);
        this.mPaint.setShader(localComposeShader);
        return;
        localMode = PorterDuff.Mode.CLEAR;
        continue;
        localMode = PorterDuff.Mode.DARKEN;
        continue;
        localMode = PorterDuff.Mode.DST;
        continue;
        localMode = PorterDuff.Mode.DST_ATOP;
        continue;
        localMode = PorterDuff.Mode.DST_IN;
        continue;
        localMode = PorterDuff.Mode.DST_OUT;
        continue;
        localMode = PorterDuff.Mode.DST_OVER;
        continue;
        localMode = PorterDuff.Mode.LIGHTEN;
        continue;
        localMode = PorterDuff.Mode.MULTIPLY;
        continue;
        localMode = PorterDuff.Mode.SCREEN;
        continue;
        localMode = PorterDuff.Mode.SRC;
        continue;
        localMode = PorterDuff.Mode.SRC_ATOP;
        continue;
        localMode = PorterDuff.Mode.SRC_IN;
        continue;
        localMode = PorterDuff.Mode.SRC_OUT;
        continue;
        localMode = PorterDuff.Mode.SRC_OVER;
      }
    }

    public void DoShaderSingle(int paramInt)
    {
      if (paramInt == 1)
      {
        this.mPaint.setShader(this.ShaderA);
        return;
      }
      this.mPaint.setShader(this.ShaderB);
    }

    public int GetAlpha()
    {
      return this.mPaint.getAlpha();
    }

    public float GetAscent()
    {
      return this.mPaint.ascent();
    }

    public int GetColor()
    {
      return this.mPaint.getColor();
    }

    public float GetDescent()
    {
      return this.mPaint.descent();
    }

    public boolean GetFillPath(ABExtDrawing.ABPath paramABPath1, ABExtDrawing.ABPath paramABPath2)
    {
      return this.mPaint.getFillPath(paramABPath1.mPath, paramABPath2.mPath);
    }

    public int GetFlags()
    {
      return this.mPaint.getFlags();
    }

    public float GetFontSpacing()
    {
      return this.mPaint.getFontSpacing();
    }

    public int GetStrokeCap()
    {
      return CapToInt(this.mPaint.getStrokeCap());
    }

    public int GetStrokeJoin()
    {
      return JoinToInt(this.mPaint.getStrokeJoin());
    }

    public float GetStrokeMiter()
    {
      return this.mPaint.getStrokeMiter();
    }

    public float GetStrokeWidth()
    {
      return this.mPaint.getStrokeWidth();
    }

    public int GetStyle()
    {
      return StyleToInt(this.mPaint.getStyle());
    }

    public int GetTextAlign()
    {
      return AlignToInt(this.mPaint.getTextAlign());
    }

    public void GetTextBounds(String paramString, int paramInt1, int paramInt2, Rect paramRect)
    {
      this.mPaint.getTextBounds(paramString, paramInt1, paramInt2, paramRect);
    }

    public void GetTextPath(String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, ABExtDrawing.ABPath paramABPath)
    {
      Path localPath = new Path();
      this.mPaint.getTextPath(paramString, paramInt1, paramInt2, paramFloat1, paramFloat2, localPath);
      paramABPath.mPath = localPath;
    }

    public float GetTextScaleX()
    {
      return this.mPaint.getTextScaleX();
    }

    public float GetTextSize()
    {
      return this.mPaint.getTextSize();
    }

    public float GetTextSkewX()
    {
      return this.mPaint.getTextSkewX();
    }

    public int GetTextWidths(String paramString, float[] paramArrayOfFloat)
    {
      return this.mPaint.getTextWidths(paramString, paramArrayOfFloat);
    }

    public Typeface GetTypeface()
    {
      return this.mPaint.getTypeface();
    }

    public void Initialize()
    {
      this.mPaint = new Paint();
    }

    public void Initialize2(int paramInt)
    {
      this.mPaint = new Paint(paramInt);
    }

    public void Initialize3(ABPaint paramABPaint)
    {
      Set2(paramABPaint.mPaint);
    }

    protected Paint.Align IntToAlign(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return Paint.Align.RIGHT;
      case 0:
        return Paint.Align.CENTER;
      case 1:
      }
      return Paint.Align.LEFT;
    }

    protected Paint.Cap IntToCap(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return Paint.Cap.SQUARE;
      case 0:
        return Paint.Cap.BUTT;
      case 1:
      }
      return Paint.Cap.ROUND;
    }

    protected Paint.Join IntToJoin(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return Paint.Join.ROUND;
      case 0:
        return Paint.Join.BEVEL;
      case 1:
      }
      return Paint.Join.MITER;
    }

    protected Paint.Style IntToStyle(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return Paint.Style.STROKE;
      case 0:
        return Paint.Style.FILL;
      case 1:
      }
      return Paint.Style.FILL_AND_STROKE;
    }

    protected int JoinToInt(Paint.Join paramJoin)
    {
      if (paramJoin == Paint.Join.BEVEL)
        return 0;
      if (paramJoin == Paint.Join.MITER)
        return 1;
      return 2;
    }

    public void Set(ABPaint paramABPaint)
    {
      Set2(paramABPaint.mPaint);
    }

    protected void Set2(Paint paramPaint)
    {
      this.mPaint.set(paramPaint);
    }

    public void SetARGB(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.mPaint.setARGB(paramInt1, paramInt2, paramInt3, paramInt4);
    }

    public void SetAlpha(int paramInt)
    {
      this.mPaint.setAlpha(paramInt);
    }

    public void SetAntiAlias(boolean paramBoolean)
    {
      this.mPaint.setAntiAlias(paramBoolean);
    }

    public void SetAvoidXfermode(int paramInt1, int paramInt2, int paramInt3)
    {
      AvoidXfermode.Mode localMode = AvoidXfermode.Mode.AVOID;
      if (paramInt3 == 1)
        localMode = AvoidXfermode.Mode.TARGET;
      this.mPaint.setXfermode(new AvoidXfermode(paramInt1, paramInt2, localMode));
    }

    public void SetBitmapShader(int paramInt1, Bitmap paramBitmap, int paramInt2, int paramInt3)
    {
      Shader.TileMode localTileMode1;
      Shader.TileMode localTileMode2;
      switch (paramInt2)
      {
      default:
        localTileMode1 = Shader.TileMode.REPEAT;
        switch (paramInt3)
        {
        default:
          localTileMode2 = Shader.TileMode.REPEAT;
        case 0:
        case 1:
        }
        break;
      case 0:
      case 1:
      }
      while (true)
      {
        if (paramInt1 != 1)
          break label119;
        this.ShaderA = new BitmapShader(paramBitmap, localTileMode1, localTileMode2);
        return;
        localTileMode1 = Shader.TileMode.CLAMP;
        break;
        localTileMode1 = Shader.TileMode.MIRROR;
        break;
        localTileMode2 = Shader.TileMode.CLAMP;
        continue;
        localTileMode2 = Shader.TileMode.MIRROR;
      }
      label119: this.ShaderB = new BitmapShader(paramBitmap, localTileMode1, localTileMode2);
    }

    public void SetBlurMaskFilter(float paramFloat, int paramInt)
    {
      switch (paramInt)
      {
      default:
      case 0:
      case 1:
      case 2:
      }
      while (true)
      {
        BlurMaskFilter.Blur localBlur = BlurMaskFilter.Blur.SOLID;
        this.mPaint.setMaskFilter(new BlurMaskFilter(paramFloat, localBlur));
        return;
      }
    }

    public void SetColor(int paramInt)
    {
      this.mPaint.setColor(paramInt);
    }

    public void SetColorMatrixColorFilter(float[] paramArrayOfFloat)
    {
      this.mPaint.setColorFilter(new ColorMatrixColorFilter(paramArrayOfFloat));
    }

    public void SetColorMatrixColorFilter2(ABExtDrawing.ABColorMatrix paramABColorMatrix)
    {
      this.mPaint.setColorFilter(new ColorMatrixColorFilter(paramABColorMatrix.mColorMatrix));
    }

    public void SetCornerPathEffect(int paramInt, float paramFloat)
    {
      if (paramInt == 1)
      {
        this.pathEffect1 = new CornerPathEffect(paramFloat);
        return;
      }
      this.pathEffect2 = new CornerPathEffect(paramFloat);
    }

    public void SetDashPathEffect(int paramInt, float[] paramArrayOfFloat, float paramFloat)
    {
      if (paramInt == 1)
      {
        this.pathEffect1 = new DashPathEffect(paramArrayOfFloat, paramFloat);
        return;
      }
      this.pathEffect2 = new DashPathEffect(paramArrayOfFloat, paramFloat);
    }

    public void SetDiscretePathEffect(int paramInt, float paramFloat1, float paramFloat2)
    {
      if (paramInt == 1)
      {
        this.pathEffect1 = new DiscretePathEffect(paramFloat1, paramFloat2);
        return;
      }
      this.pathEffect2 = new DiscretePathEffect(paramFloat1, paramFloat2);
    }

    public void SetDither(boolean paramBoolean)
    {
      this.mPaint.setDither(paramBoolean);
    }

    public void SetEmbossMaskFilter(float[] paramArrayOfFloat, float paramFloat1, float paramFloat2, float paramFloat3)
    {
      this.mPaint.setMaskFilter(new EmbossMaskFilter(paramArrayOfFloat, paramFloat1, paramFloat2, paramFloat3));
    }

    public void SetFakeBoldText(boolean paramBoolean)
    {
      this.mPaint.setFakeBoldText(paramBoolean);
    }

    public void SetFilterBitmap(boolean paramBoolean)
    {
      this.mPaint.setFilterBitmap(paramBoolean);
    }

    public void SetFlags(int paramInt)
    {
      this.mPaint.setFlags(paramInt);
    }

    public void SetLayerRasterizer()
    {
      this.mPaint.setRasterizer(this.mRasterizer);
    }

    public void SetLightingColorFilter(int paramInt1, int paramInt2)
    {
      this.mPaint.setColorFilter(new LightingColorFilter(paramInt1, paramInt2));
    }

    public void SetLinearGradient(int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt2)
    {
      Shader.TileMode localTileMode;
      switch (paramInt2)
      {
      default:
        localTileMode = Shader.TileMode.REPEAT;
      case 0:
      case 1:
      }
      while (paramInt1 == 1)
      {
        this.ShaderA = new LinearGradient(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramArrayOfInt, paramArrayOfFloat, localTileMode);
        return;
        localTileMode = Shader.TileMode.CLAMP;
        continue;
        localTileMode = Shader.TileMode.MIRROR;
      }
      this.ShaderB = new LinearGradient(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramArrayOfInt, paramArrayOfFloat, localTileMode);
    }

    public void SetLinearGradient2(int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt2, int paramInt3, int paramInt4)
    {
      Shader.TileMode localTileMode;
      switch (paramInt4)
      {
      default:
        localTileMode = Shader.TileMode.REPEAT;
      case 0:
      case 1:
      }
      while (paramInt1 == 1)
      {
        this.ShaderA = new LinearGradient(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt2, paramInt3, localTileMode);
        return;
        localTileMode = Shader.TileMode.CLAMP;
        continue;
        localTileMode = Shader.TileMode.MIRROR;
      }
      this.ShaderB = new LinearGradient(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt2, paramInt3, localTileMode);
    }

    public void SetLinearText(boolean paramBoolean)
    {
      this.mPaint.setLinearText(paramBoolean);
    }

    public void SetLocalMatrix(int paramInt, ABExtDrawing.ABMatrix paramABMatrix)
    {
      if (paramInt == 1)
      {
        this.ShaderA.setLocalMatrix(paramABMatrix.mMatrix);
        return;
      }
      this.ShaderA.setLocalMatrix(paramABMatrix.mMatrix);
    }

    public void SetPathDashPathEffect(int paramInt1, Path paramPath, float paramFloat1, float paramFloat2, int paramInt2)
    {
      PathDashPathEffect.Style localStyle;
      switch (paramInt2)
      {
      default:
        localStyle = PathDashPathEffect.Style.TRANSLATE;
      case 0:
      case 1:
      }
      while (paramInt1 == 1)
      {
        this.pathEffect1 = new PathDashPathEffect(paramPath, paramFloat1, paramFloat2, localStyle);
        return;
        localStyle = PathDashPathEffect.Style.MORPH;
        continue;
        localStyle = PathDashPathEffect.Style.ROTATE;
      }
      this.pathEffect2 = new PathDashPathEffect(paramPath, paramFloat1, paramFloat2, localStyle);
    }

    public void SetPixelXorXfermode(int paramInt)
    {
      this.mPaint.setXfermode(new PixelXorXfermode(paramInt));
    }

    public void SetPorterDuffColorFilter(int paramInt1, int paramInt2)
    {
      PorterDuff.Mode localMode;
      switch (paramInt2)
      {
      case 10:
      default:
        localMode = PorterDuff.Mode.XOR;
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
      case 16:
      }
      while (true)
      {
        this.mPaint.setColorFilter(new PorterDuffColorFilter(paramInt1, localMode));
        return;
        localMode = PorterDuff.Mode.CLEAR;
        continue;
        localMode = PorterDuff.Mode.DARKEN;
        continue;
        localMode = PorterDuff.Mode.DST;
        continue;
        localMode = PorterDuff.Mode.DST_ATOP;
        continue;
        localMode = PorterDuff.Mode.DST_IN;
        continue;
        localMode = PorterDuff.Mode.DST_OUT;
        continue;
        localMode = PorterDuff.Mode.DST_OVER;
        continue;
        localMode = PorterDuff.Mode.LIGHTEN;
        continue;
        localMode = PorterDuff.Mode.MULTIPLY;
        continue;
        localMode = PorterDuff.Mode.SCREEN;
        continue;
        localMode = PorterDuff.Mode.SRC;
        continue;
        localMode = PorterDuff.Mode.SRC_ATOP;
        continue;
        localMode = PorterDuff.Mode.SRC_IN;
        continue;
        localMode = PorterDuff.Mode.SRC_OUT;
        continue;
        localMode = PorterDuff.Mode.SRC_OVER;
      }
    }

    public void SetPorterDuffXfermode(int paramInt)
    {
      PorterDuff.Mode localMode;
      switch (paramInt)
      {
      case 10:
      default:
        localMode = PorterDuff.Mode.XOR;
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
      case 16:
      }
      while (true)
      {
        this.mPaint.setXfermode(new PorterDuffXfermode(localMode));
        return;
        localMode = PorterDuff.Mode.CLEAR;
        continue;
        localMode = PorterDuff.Mode.DARKEN;
        continue;
        localMode = PorterDuff.Mode.DST;
        continue;
        localMode = PorterDuff.Mode.DST_ATOP;
        continue;
        localMode = PorterDuff.Mode.DST_IN;
        continue;
        localMode = PorterDuff.Mode.DST_OUT;
        continue;
        localMode = PorterDuff.Mode.DST_OVER;
        continue;
        localMode = PorterDuff.Mode.LIGHTEN;
        continue;
        localMode = PorterDuff.Mode.MULTIPLY;
        continue;
        localMode = PorterDuff.Mode.SCREEN;
        continue;
        localMode = PorterDuff.Mode.SRC;
        continue;
        localMode = PorterDuff.Mode.SRC_ATOP;
        continue;
        localMode = PorterDuff.Mode.SRC_IN;
        continue;
        localMode = PorterDuff.Mode.SRC_OUT;
        continue;
        localMode = PorterDuff.Mode.SRC_OVER;
      }
    }

    public void SetRadialGradient(int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt2)
    {
      Shader.TileMode localTileMode;
      switch (paramInt2)
      {
      default:
        localTileMode = Shader.TileMode.REPEAT;
      case 0:
      case 1:
      }
      while (paramInt1 == 1)
      {
        this.ShaderA = new RadialGradient(paramFloat1, paramFloat2, paramFloat3, paramArrayOfInt, paramArrayOfFloat, localTileMode);
        return;
        localTileMode = Shader.TileMode.CLAMP;
        continue;
        localTileMode = Shader.TileMode.MIRROR;
      }
      this.ShaderB = new RadialGradient(paramFloat1, paramFloat2, paramFloat3, paramArrayOfInt, paramArrayOfFloat, localTileMode);
    }

    public void SetRadialGradient2(int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt2, int paramInt3, int paramInt4)
    {
      Shader.TileMode localTileMode;
      switch (paramInt4)
      {
      default:
        localTileMode = Shader.TileMode.REPEAT;
      case 0:
      case 1:
      }
      while (paramInt1 == 1)
      {
        this.ShaderA = new RadialGradient(paramFloat1, paramFloat2, paramFloat3, paramInt2, paramInt3, localTileMode);
        return;
        localTileMode = Shader.TileMode.CLAMP;
        continue;
        localTileMode = Shader.TileMode.MIRROR;
      }
      this.ShaderB = new RadialGradient(paramFloat1, paramFloat2, paramFloat3, paramInt2, paramInt3, localTileMode);
    }

    public void SetShadowLayer(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
    {
      this.mPaint.setShadowLayer(paramFloat1, paramFloat2, paramFloat3, paramInt);
    }

    public void SetStrikeThruText(boolean paramBoolean)
    {
      this.mPaint.setStrikeThruText(paramBoolean);
    }

    public void SetStrokeCap(int paramInt)
    {
      this.mPaint.setStrokeCap(IntToCap(paramInt));
    }

    public void SetStrokeJoin(int paramInt)
    {
      this.mPaint.setStrokeJoin(IntToJoin(paramInt));
    }

    public void SetStrokeMiter(float paramFloat)
    {
      this.mPaint.setStrokeMiter(paramFloat);
    }

    public void SetStrokeWidth(float paramFloat)
    {
      this.mPaint.setStrokeWidth(paramFloat);
    }

    public void SetStyle(int paramInt)
    {
      this.mPaint.setStyle(IntToStyle(paramInt));
    }

    public void SetSubpixelText(boolean paramBoolean)
    {
      this.mPaint.setSubpixelText(paramBoolean);
    }

    public void SetSweepGradient(int paramInt, float paramFloat1, float paramFloat2, int[] paramArrayOfInt, float[] paramArrayOfFloat)
    {
      if (paramInt == 1)
      {
        this.ShaderA = new SweepGradient(paramFloat1, paramFloat2, paramArrayOfInt, paramArrayOfFloat);
        return;
      }
      this.ShaderB = new SweepGradient(paramFloat1, paramFloat2, paramArrayOfInt, paramArrayOfFloat);
    }

    public void SetSweepGradient2(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3)
    {
      if (paramInt1 == 1)
      {
        this.ShaderA = new SweepGradient(paramFloat1, paramFloat2, paramInt2, paramInt3);
        return;
      }
      this.ShaderB = new SweepGradient(paramFloat1, paramFloat2, paramInt2, paramInt3);
    }

    public void SetTextAlign(int paramInt)
    {
      this.mPaint.setTextAlign(IntToAlign(paramInt));
    }

    public void SetTextScaleX(float paramFloat)
    {
      this.mPaint.setTextScaleX(paramFloat);
    }

    public void SetTextSize(float paramFloat)
    {
      this.mPaint.setTextSize(paramFloat);
    }

    public void SetTextSkewX(float paramFloat)
    {
      this.mPaint.setTextSkewX(paramFloat);
    }

    public void SetUnderlineText(boolean paramBoolean)
    {
      this.mPaint.setUnderlineText(paramBoolean);
    }

    protected int StyleToInt(Paint.Style paramStyle)
    {
      if (paramStyle == Paint.Style.FILL)
        return 0;
      if (paramStyle == Paint.Style.FILL_AND_STROKE)
        return 1;
      return 2;
    }

    public void addRasterizerLayer(ABPaint paramABPaint)
    {
      this.mRasterizer.addLayer(paramABPaint.mPaint);
    }

    public void addRasterizerLayer2(ABPaint paramABPaint, float paramFloat1, float paramFloat2)
    {
      this.mRasterizer.addLayer(paramABPaint.mPaint, paramFloat1, paramFloat2);
    }

    public int breakText(String paramString, boolean paramBoolean, float paramFloat, float[] paramArrayOfFloat)
    {
      return this.mPaint.breakText(paramString, paramBoolean, paramFloat, paramArrayOfFloat);
    }

    public void clearShadowLayer()
    {
      this.mPaint.clearShadowLayer();
    }

    public float getFontMetricsAscent()
    {
      return this.mPaint.getFontMetrics().ascent;
    }

    public float getFontMetricsBottom()
    {
      return this.mPaint.getFontMetrics().bottom;
    }

    public float getFontMetricsDescent()
    {
      return this.mPaint.getFontMetrics().descent;
    }

    public float getFontMetricsLeading()
    {
      return this.mPaint.getFontMetrics().leading;
    }

    public float getFontMetricsTop()
    {
      return this.mPaint.getFontMetrics().top;
    }

    public final boolean isAntiAlias()
    {
      return this.mPaint.isAntiAlias();
    }

    public final boolean isDither()
    {
      return this.mPaint.isDither();
    }

    public final boolean isFakeBoldText()
    {
      return this.mPaint.isFakeBoldText();
    }

    public final boolean isFilterBitmap()
    {
      return this.mPaint.isFilterBitmap();
    }

    public final boolean isLinearText()
    {
      return this.mPaint.isLinearText();
    }

    public final boolean isStrikeThruText()
    {
      return this.mPaint.isStrikeThruText();
    }

    public final boolean isSubpixelText()
    {
      return this.mPaint.isSubpixelText();
    }

    public final boolean isUnderlineText()
    {
      return this.mPaint.isUnderlineText();
    }

    public float measureText(String paramString)
    {
      return this.mPaint.measureText(paramString);
    }

    public void reset()
    {
      this.mPaint.reset();
    }

    public void setFontMetricsAscent(float paramFloat)
    {
      this.mPaint.getFontMetrics().ascent = paramFloat;
    }

    public void setFontMetricsBottom(float paramFloat)
    {
      this.mPaint.getFontMetrics().bottom = paramFloat;
    }

    public void setFontMetricsDescent(float paramFloat)
    {
      this.mPaint.getFontMetrics().descent = paramFloat;
    }

    public void setFontMetricsLeading(float paramFloat)
    {
      this.mPaint.getFontMetrics().leading = paramFloat;
    }

    public void setFontMetricsTop(float paramFloat)
    {
      this.mPaint.getFontMetrics().top = paramFloat;
    }

    public Typeface setTypeface(Typeface paramTypeface)
    {
      return this.mPaint.setTypeface(paramTypeface);
    }
  }

  @BA.ShortName("ABPath")
  public static class ABPath
  {
    public static final int Direction_CCW = 0;
    public static final int Direction_CW = 1;
    public static final int FillType_EVEN_ODD = 0;
    public static final int FillType_INVERSE_EVEN_ODD = 1;
    public static final int FillType_INVERSE_WINDING = 2;
    public static final int FillType_WINDING = 3;
    protected Path.Direction direction = Path.Direction.CW;
    private int mDirection = 1;
    protected Path mPath = new Path();

    public int GetDirection()
    {
      return this.mDirection;
    }

    public int GetFillType()
    {
      Path.FillType localFillType = this.mPath.getFillType();
      if (localFillType == Path.FillType.EVEN_ODD)
        return 0;
      if (localFillType == Path.FillType.INVERSE_EVEN_ODD)
        return 1;
      if (localFillType == Path.FillType.INVERSE_WINDING)
        return 2;
      return 3;
    }

    public void Initialize()
    {
    }

    public void Initialize2(ABPath paramABPath)
    {
      this.mPath = paramABPath.mPath;
    }

    protected void Set(Path paramPath)
    {
      this.mPath = paramPath;
    }

    public void SetDirection(int paramInt)
    {
      this.mDirection = paramInt;
      if (paramInt == 0)
      {
        this.direction = Path.Direction.CCW;
        return;
      }
      this.direction = Path.Direction.CW;
    }

    public void SetFillType(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return;
      case 0:
        this.mPath.setFillType(Path.FillType.EVEN_ODD);
        return;
      case 1:
        this.mPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);
        return;
      case 2:
        this.mPath.setFillType(Path.FillType.INVERSE_WINDING);
        return;
      case 3:
      }
      this.mPath.setFillType(Path.FillType.WINDING);
    }

    public void SetLastPoint(float paramFloat1, float paramFloat2)
    {
      this.mPath.setLastPoint(paramFloat1, paramFloat2);
    }

    public void addArc(ABExtDrawing.ABRectF paramABRectF, float paramFloat1, float paramFloat2)
    {
      this.mPath.addArc(ABExtDrawing.ABRectF.access$0(paramABRectF), paramFloat1, paramFloat2);
    }

    public void addCircle(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
    {
      if (paramInt == 0)
      {
        this.mPath.addCircle(paramFloat1, paramFloat2, paramFloat3, Path.Direction.CCW);
        return;
      }
      this.mPath.addCircle(paramFloat1, paramFloat2, paramFloat3, Path.Direction.CW);
    }

    public void addOval(ABExtDrawing.ABRectF paramABRectF, int paramInt)
    {
      if (paramInt == 0)
      {
        this.mPath.addOval(ABExtDrawing.ABRectF.access$0(paramABRectF), Path.Direction.CCW);
        return;
      }
      this.mPath.addOval(ABExtDrawing.ABRectF.access$0(paramABRectF), Path.Direction.CW);
    }

    public void addPath(ABPath paramABPath)
    {
      this.mPath.addPath(paramABPath.mPath);
    }

    public void addPath2(ABPath paramABPath, ABExtDrawing.ABMatrix paramABMatrix)
    {
      this.mPath.addPath(paramABPath.mPath, paramABMatrix.mMatrix);
    }

    public void addPath3(ABPath paramABPath, float paramFloat1, float paramFloat2)
    {
      this.mPath.addPath(paramABPath.mPath, paramFloat1, paramFloat2);
    }

    public void addRect(ABExtDrawing.ABRectF paramABRectF, int paramInt)
    {
      if (paramInt == 0)
      {
        this.mPath.addRect(ABExtDrawing.ABRectF.access$0(paramABRectF), Path.Direction.CCW);
        return;
      }
      this.mPath.addRect(ABExtDrawing.ABRectF.access$0(paramABRectF), Path.Direction.CW);
    }

    public void addRect2(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
    {
      if (paramInt == 0)
      {
        this.mPath.addRect(paramFloat1, paramFloat2, paramFloat3, paramFloat4, Path.Direction.CCW);
        return;
      }
      this.mPath.addRect(paramFloat1, paramFloat2, paramFloat3, paramFloat4, Path.Direction.CW);
    }

    public void addRoundRect(ABExtDrawing.ABRectF paramABRectF, float paramFloat1, float paramFloat2, int paramInt)
    {
      if (paramInt == 0)
      {
        this.mPath.addRoundRect(ABExtDrawing.ABRectF.access$0(paramABRectF), paramFloat1, paramFloat2, Path.Direction.CCW);
        return;
      }
      this.mPath.addRoundRect(ABExtDrawing.ABRectF.access$0(paramABRectF), paramFloat1, paramFloat2, Path.Direction.CW);
    }

    public void addRoundRect2(ABExtDrawing.ABRectF paramABRectF, float[] paramArrayOfFloat, int paramInt)
    {
      if (paramInt == 0)
      {
        this.mPath.addRoundRect(ABExtDrawing.ABRectF.access$0(paramABRectF), paramArrayOfFloat, Path.Direction.CCW);
        return;
      }
      this.mPath.addRoundRect(ABExtDrawing.ABRectF.access$0(paramABRectF), paramArrayOfFloat, Path.Direction.CW);
    }

    public void arcTo(ABExtDrawing.ABRectF paramABRectF, float paramFloat1, float paramFloat2)
    {
      this.mPath.arcTo(ABExtDrawing.ABRectF.access$0(paramABRectF), paramFloat1, paramFloat2);
    }

    public void arcTo2(ABExtDrawing.ABRectF paramABRectF, float paramFloat1, float paramFloat2, boolean paramBoolean)
    {
      this.mPath.arcTo(ABExtDrawing.ABRectF.access$0(paramABRectF), paramFloat1, paramFloat2, paramBoolean);
    }

    public void close()
    {
      this.mPath.close();
    }

    public void computeBounds(ABExtDrawing.ABRectF paramABRectF, boolean paramBoolean)
    {
      this.mPath.computeBounds(ABExtDrawing.ABRectF.access$0(paramABRectF), paramBoolean);
    }

    public void cubicTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
    {
      this.mPath.cubicTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
    }

    public void incReverse(int paramInt)
    {
      this.mPath.incReserve(paramInt);
    }

    public boolean isEmpty()
    {
      return this.mPath.isEmpty();
    }

    public boolean isInverseFillType()
    {
      return this.mPath.isInverseFillType();
    }

    public boolean isRect(ABExtDrawing.ABRectF paramABRectF)
    {
      return this.mPath.isRect(ABExtDrawing.ABRectF.access$0(paramABRectF));
    }

    public void lineTo(float paramFloat1, float paramFloat2)
    {
      this.mPath.lineTo(paramFloat1, paramFloat2);
    }

    public void moveTo(float paramFloat1, float paramFloat2)
    {
      this.mPath.moveTo(paramFloat1, paramFloat2);
    }

    public void offset(float paramFloat1, float paramFloat2)
    {
      this.mPath.offset(paramFloat1, paramFloat2);
    }

    public void offset2(float paramFloat1, float paramFloat2, ABPath paramABPath)
    {
      this.mPath.offset(paramFloat1, paramFloat2, paramABPath.mPath);
    }

    public void quadTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.mPath.quadTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    }

    public void rCubicTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
    {
      this.mPath.rCubicTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
    }

    public void rLineTo(float paramFloat1, float paramFloat2)
    {
      this.mPath.rLineTo(paramFloat1, paramFloat2);
    }

    public void rMoveTo(float paramFloat1, float paramFloat2)
    {
      this.mPath.rMoveTo(paramFloat1, paramFloat2);
    }

    public void rQuadTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.mPath.rQuadTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    }

    public void reset()
    {
      this.mPath.reset();
    }

    public void rewind()
    {
      this.mPath.rewind();
    }

    public void toggleInverseFillType()
    {
      this.mPath.toggleInverseFillType();
    }

    public void transform(ABExtDrawing.ABMatrix paramABMatrix)
    {
      this.mPath.transform(paramABMatrix.mMatrix);
    }

    public void transform2(ABExtDrawing.ABMatrix paramABMatrix, ABPath paramABPath)
    {
      this.mPath.transform(paramABMatrix.mMatrix, paramABPath.mPath);
    }
  }

  @BA.ShortName("ABRectF")
  public static class ABRectF
  {
    private RectF mRectF = new RectF();
    private boolean misInitialized = false;

    public void Initialize(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.mRectF.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
      this.misInitialized = true;
    }

    public float getBottom()
    {
      return this.mRectF.bottom;
    }

    public float getCenterX()
    {
      return this.mRectF.centerX();
    }

    public float getCenterY()
    {
      return this.mRectF.centerY();
    }

    public float getLeft()
    {
      return this.mRectF.left;
    }

    public float getRight()
    {
      return this.mRectF.right;
    }

    public float getTop()
    {
      return this.mRectF.top;
    }

    public boolean isInitialized()
    {
      return this.misInitialized;
    }

    public void setBottom(float paramFloat)
    {
      this.mRectF.bottom = paramFloat;
    }

    public void setLeft(float paramFloat)
    {
      this.mRectF.left = paramFloat;
    }

    public void setRight(float paramFloat)
    {
      this.mRectF.right = paramFloat;
    }

    public void setTop(float paramFloat)
    {
      this.mRectF.top = paramFloat;
    }
  }

  @BA.ShortName("ABRegion")
  public static class ABRegion
  {
    public static final int RegionOp_DIFFERENCE = 0;
    public static final int RegionOp_INTERSECT = 1;
    public static final int RegionOp_REPLACE = 2;
    public static final int RegionOp_REVERSE_DIFFERENCE = 3;
    public static final int RegionOp_UNION = 4;
    public static final int RegionOp_XOR = 5;
    protected Region mRegion = new Region();

    public ABExtDrawing.ABPath GetBoundaryPath()
    {
      ABExtDrawing.ABPath localABPath = new ABExtDrawing.ABPath();
      localABPath.Set(this.mRegion.getBoundaryPath());
      return localABPath;
    }

    public Rect GetBounds()
    {
      return this.mRegion.getBounds();
    }

    public void Initialize()
    {
      this.mRegion = new Region();
    }

    public void Initialize2(ABRegion paramABRegion)
    {
      this.mRegion = new Region(paramABRegion.mRegion);
    }

    public void Initialize3(Rect paramRect)
    {
      this.mRegion = new Region(paramRect);
    }

    public void Initialize4(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.mRegion = new Region(paramInt1, paramInt2, paramInt3, paramInt4);
    }

    public boolean Set(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      return this.mRegion.set(paramInt1, paramInt2, paramInt3, paramInt4);
    }

    public boolean Set2(Rect paramRect)
    {
      return this.mRegion.set(paramRect);
    }

    public boolean SetBoundaryPath(ABExtDrawing.ABPath paramABPath)
    {
      return this.mRegion.getBoundaryPath(paramABPath.mPath);
    }

    public boolean SetBounds(Rect paramRect)
    {
      return this.mRegion.getBounds(paramRect);
    }

    public boolean contains(int paramInt1, int paramInt2)
    {
      return this.mRegion.contains(paramInt1, paramInt2);
    }

    public boolean equals(Object paramObject)
    {
      return this.mRegion.equals(paramObject);
    }

    public boolean isComplex()
    {
      return this.mRegion.isComplex();
    }

    public boolean isEmpty()
    {
      return this.mRegion.isEmpty();
    }

    public boolean isRect()
    {
      return this.mRegion.isRect();
    }

    public boolean op(Rect paramRect, int paramInt)
    {
      Region.Op localOp;
      switch (paramInt)
      {
      default:
        localOp = Region.Op.XOR;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        return this.mRegion.op(paramRect, localOp);
        localOp = Region.Op.DIFFERENCE;
        continue;
        localOp = Region.Op.INTERSECT;
        continue;
        localOp = Region.Op.REPLACE;
        continue;
        localOp = Region.Op.REVERSE_DIFFERENCE;
        continue;
        localOp = Region.Op.UNION;
      }
    }

    public boolean op2(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      Region.Op localOp;
      switch (paramInt5)
      {
      default:
        localOp = Region.Op.XOR;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        return this.mRegion.op(paramInt1, paramInt2, paramInt3, paramInt4, localOp);
        localOp = Region.Op.DIFFERENCE;
        continue;
        localOp = Region.Op.INTERSECT;
        continue;
        localOp = Region.Op.REPLACE;
        continue;
        localOp = Region.Op.REVERSE_DIFFERENCE;
        continue;
        localOp = Region.Op.UNION;
      }
    }

    public boolean op3(ABRegion paramABRegion, int paramInt)
    {
      Region.Op localOp;
      switch (paramInt)
      {
      default:
        localOp = Region.Op.XOR;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        return this.mRegion.op(paramABRegion.mRegion, localOp);
        localOp = Region.Op.DIFFERENCE;
        continue;
        localOp = Region.Op.INTERSECT;
        continue;
        localOp = Region.Op.REPLACE;
        continue;
        localOp = Region.Op.REVERSE_DIFFERENCE;
        continue;
        localOp = Region.Op.UNION;
      }
    }

    public boolean op4(Rect paramRect, ABRegion paramABRegion, int paramInt)
    {
      Region.Op localOp;
      switch (paramInt)
      {
      default:
        localOp = Region.Op.XOR;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        return this.mRegion.op(paramRect, paramABRegion.mRegion, localOp);
        localOp = Region.Op.DIFFERENCE;
        continue;
        localOp = Region.Op.INTERSECT;
        continue;
        localOp = Region.Op.REPLACE;
        continue;
        localOp = Region.Op.REVERSE_DIFFERENCE;
        continue;
        localOp = Region.Op.UNION;
      }
    }

    public boolean op5(ABRegion paramABRegion1, ABRegion paramABRegion2, int paramInt)
    {
      Region.Op localOp;
      switch (paramInt)
      {
      default:
        localOp = Region.Op.XOR;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        return this.mRegion.op(paramABRegion1.mRegion, paramABRegion2.mRegion, localOp);
        localOp = Region.Op.DIFFERENCE;
        continue;
        localOp = Region.Op.INTERSECT;
        continue;
        localOp = Region.Op.REPLACE;
        continue;
        localOp = Region.Op.REVERSE_DIFFERENCE;
        continue;
        localOp = Region.Op.UNION;
      }
    }

    public boolean quickContains(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      return this.mRegion.quickContains(paramInt1, paramInt2, paramInt3, paramInt4);
    }

    public boolean quickContains2(Rect paramRect)
    {
      return this.mRegion.quickContains(paramRect);
    }

    public boolean quickReject(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      return this.mRegion.quickReject(paramInt1, paramInt2, paramInt3, paramInt4);
    }

    public boolean quickReject(Rect paramRect)
    {
      return this.mRegion.quickReject(paramRect);
    }

    public boolean quickReject(ABRegion paramABRegion)
    {
      return this.mRegion.quickReject(paramABRegion.mRegion);
    }

    public boolean set3(ABRegion paramABRegion)
    {
      return this.mRegion.set(paramABRegion.mRegion);
    }

    public void setEmpty()
    {
      this.mRegion.setEmpty();
    }

    public boolean setPath(ABExtDrawing.ABPath paramABPath, ABRegion paramABRegion)
    {
      return this.mRegion.setPath(paramABPath.mPath, paramABRegion.mRegion);
    }

    public String toString()
    {
      return this.mRegion.toString();
    }

    public void translate(int paramInt1, int paramInt2)
    {
      this.mRegion.translate(paramInt1, paramInt2);
    }

    public void translate2(int paramInt1, int paramInt2, ABRegion paramABRegion)
    {
      this.mRegion.translate(paramInt1, paramInt2, paramABRegion.mRegion);
    }

    public final boolean union(Rect paramRect)
    {
      return this.mRegion.union(paramRect);
    }
  }

  @BA.ShortName("ABRgbFunctions")
  public static class ABRgbFunctions
  {
    public static int getAbsDiff(int paramInt1, int paramInt2)
    {
      return Math.abs(getR(paramInt1) - getR(paramInt2)) + Math.abs(getG(paramInt1) - getG(paramInt2)) + Math.abs(getB(paramInt1) - getB(paramInt2));
    }

    public static byte getB(int paramInt)
    {
      return toSignedByte((byte)(paramInt & 0xFF));
    }

    public static byte getG(int paramInt)
    {
      return toSignedByte((byte)(0xFF & paramInt >> 8));
    }

    public static int getMaxDiff(int paramInt1, int paramInt2)
    {
      int i = getR(paramInt1);
      int j = getG(paramInt1);
      int k = getB(paramInt1);
      int m = getR(paramInt2);
      int n = getG(paramInt2);
      int i1 = getB(paramInt2);
      return Math.max(Math.abs(i - m), Math.max(Math.abs(j - n), Math.abs(k - i1)));
    }

    public static int getProportionateDiff(int paramInt1, int paramInt2)
    {
      int i = getR(paramInt1) + 128;
      int j = getG(paramInt1) + 128;
      int k = getB(paramInt1) + 128;
      int m = getR(paramInt2) + 128;
      int n = getG(paramInt2) + 128;
      int i1 = getB(paramInt2) + 128;
      int i2 = i * m + j * n + k * i1;
      int i3 = i * i + j * j + k * k;
      if (i3 == 0)
        return 381;
      return square(8 * (i2 * (k + (i + j)) - i3 * (i1 + (i + n)))) / square(i3);
    }

    public static byte getR(int paramInt)
    {
      return toSignedByte((byte)(0xFF & paramInt >> 16));
    }

    public static int getSqrDiff(int paramInt1, int paramInt2)
    {
      return square(getR(paramInt1) - getR(paramInt2)) + square(getG(paramInt1) - getG(paramInt2)) + square(getB(paramInt1) - getB(paramInt2));
    }

    public static int getVecDiff(int paramInt1, int paramInt2, int paramInt3)
    {
      int i = getR(paramInt1);
      int j = getG(paramInt1);
      int k = getB(paramInt1);
      int m = getR(paramInt2);
      int n = getG(paramInt2);
      int i1 = getB(paramInt2);
      int i2 = getR(paramInt3);
      int i3 = getG(paramInt3);
      int i4 = getB(paramInt3);
      return i2 * (i - m) + i3 * (j - n) + i4 * (k - i1);
    }

    protected static int square(int paramInt)
    {
      return paramInt * paramInt;
    }

    public static int toRgb(byte paramByte1, byte paramByte2, byte paramByte3)
    {
      return 0xFF000000 | toUnsignedInt(paramByte1) << 16 | toUnsignedInt(paramByte2) << 8 | toUnsignedInt(paramByte3);
    }

    public static byte toSignedByte(byte paramByte)
    {
      return (byte)(paramByte - 128);
    }

    public static String toString(int paramInt)
    {
      return "[" + new Integer(getR(paramInt)).toString() + "," + new Integer(getR(paramInt)).toString() + "," + new Integer(getB(paramInt)).toString() + "]";
    }

    public static int toUnsignedInt(byte paramByte)
    {
      return paramByte + 128;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.AB.ABExtDrawing.ABExtDrawing
 * JD-Core Version:    0.6.2
 */