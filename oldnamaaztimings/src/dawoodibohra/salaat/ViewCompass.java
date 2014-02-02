package dawoodibohra.salaat;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

public class ViewCompass extends View
{
  private float bearing;
  private Paint circlePaint;
  private String eastString;
  private Paint markerPaint;
  public int moon = 360;
  public int moonAltitude = 0;
  private String northString;
  public int qibla = 0;
  private Paint qiblaPaint;
  private String southString;
  public int sun = 360;
  public int sunAltitude = 0;
  private Paint textPaint;
  private String westString;

  public ViewCompass(Context paramContext)
  {
    super(paramContext);
    initCompassView();
  }

  public ViewCompass(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initCompassView();
  }

  public ViewCompass(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initCompassView();
  }

  public float getBearing()
  {
    return this.bearing;
  }

  protected void initCompassView()
  {
    setFocusable(true);
    Resources localResources = getResources();
    this.circlePaint = new Paint(1);
    this.circlePaint.setColor(localResources.getColor(2131165184));
    this.circlePaint.setStrokeWidth(1.0F);
    this.circlePaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.northString = localResources.getString(2131230724);
    this.eastString = localResources.getString(2131230725);
    this.southString = localResources.getString(2131230726);
    this.westString = localResources.getString(2131230727);
    this.textPaint = new Paint(1);
    this.textPaint.setColor(localResources.getColor(2131165187));
    this.textPaint.setTextSize(25.0F);
    this.markerPaint = new Paint(1);
    this.markerPaint.setColor(localResources.getColor(2131165186));
    this.qiblaPaint = new Paint(1);
    this.qiblaPaint.setColor(localResources.getColor(2131165188));
    this.qiblaPaint.setStrokeWidth(2.0F);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    int i = getMeasuredWidth() / 2;
    int j = getMeasuredHeight() / 2;
    int k = Math.min(i, j);
    Bitmap localBitmap1 = BitmapFactory.decodeResource(getResources(), 2130837516);
    int m = localBitmap1.getWidth();
    int n = localBitmap1.getHeight();
    int i1 = k / 4;
    int i2 = k / 4;
    float f1 = i1 / m;
    float f2 = i2 / n;
    Matrix localMatrix1 = new Matrix();
    localMatrix1.postScale(f1, f2);
    Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1, 0, 0, m, n, localMatrix1, true);
    Bitmap localBitmap3 = BitmapFactory.decodeResource(getResources(), 2130837520);
    int i3 = localBitmap3.getWidth();
    int i4 = localBitmap3.getHeight();
    int i5 = k / 3;
    int i6 = k / 3;
    float f3 = i5 / i3;
    float f4 = i6 / i4;
    Matrix localMatrix2 = new Matrix();
    localMatrix2.postScale(f3, f4);
    Bitmap localBitmap4 = Bitmap.createBitmap(localBitmap3, 0, 0, i3, i4, localMatrix2, true);
    Bitmap localBitmap5 = BitmapFactory.decodeResource(getResources(), 2130837518);
    int i7 = localBitmap5.getWidth();
    int i8 = localBitmap5.getHeight();
    int i9 = k / 3;
    int i10 = k / 3;
    float f5 = i9 / i7;
    float f6 = i10 / i8;
    Matrix localMatrix3 = new Matrix();
    localMatrix3.postScale(f5, f6);
    Bitmap localBitmap6 = Bitmap.createBitmap(localBitmap5, 0, 0, i7, i8, localMatrix3, true);
    paramCanvas.drawCircle(i, j, k, this.circlePaint);
    paramCanvas.save();
    paramCanvas.rotate(-this.bearing, i, j);
    this.textPaint.setTextSize(k / 5);
    int i11 = 0;
    int i13;
    if (i11 >= 24)
    {
      if (this.sunAltitude < 90 * (i6 / 2) / k)
        this.sunAltitude = (90 * (i6 / 2) / k);
      if (this.moonAltitude < 90 * (i10 / 2) / k)
        this.moonAltitude = (90 * (i10 / 2) / k);
      i13 = 0;
      label411: if (i13 < 360)
        break label776;
    }
    for (int i16 = 0; ; i16++)
    {
      if (i16 >= 360)
      {
        paramCanvas.drawCircle(i, j, k / 35, this.markerPaint);
        paramCanvas.save();
        return;
        if (i11 % 2 == 0)
          paramCanvas.drawLine(i, j - k, i, j - k + k / 12, this.markerPaint);
        paramCanvas.save();
        paramCanvas.translate(0.0F, k / 5);
        String str2;
        if (i11 % 6 == 0)
        {
          str2 = "";
          switch (i11)
          {
          default:
            label560: this.textPaint.setTextSize(k / 6);
            int i12 = (int)this.textPaint.measureText(str2);
            float f8 = i - (int)this.textPaint.measureText(str2) / 2;
            float f9 = j - k + i12 / 2;
            Paint localPaint = this.textPaint;
            paramCanvas.drawText(str2, f8, f9, localPaint);
          case 0:
          case 6:
          case 12:
          case 18:
          }
        }
        while (true)
        {
          paramCanvas.restore();
          paramCanvas.rotate(15.0F, i, j);
          i11++;
          break;
          str2 = this.northString;
          break label560;
          str2 = this.eastString;
          break label560;
          str2 = this.southString;
          break label560;
          str2 = this.westString;
          break label560;
          if (i11 % 2 == 0)
          {
            String str1 = String.valueOf(i11 * 15);
            this.textPaint.setTextSize(k / 10);
            ((int)this.textPaint.measureText(str1));
            ((int)this.textPaint.measureText(str1));
            float f7 = this.textPaint.measureText(str1);
            paramCanvas.drawText(str1, i - f7 / 2.0F, j - k, this.textPaint);
          }
        }
        label776: int i14 = this.sun;
        if (i13 == i14)
          paramCanvas.drawBitmap(localBitmap4, i - i5 / 2, j - k + k * this.sunAltitude / 90 - i6 / 2, this.qiblaPaint);
        int i15 = this.moon;
        if (i13 == i15)
          paramCanvas.drawBitmap(localBitmap6, i - i9 / 2, j - k + k * this.moonAltitude / 90 - i10 / 2, this.qiblaPaint);
        paramCanvas.rotate(1.0F, i, j);
        i13++;
        break label411;
      }
      int i17 = this.qibla;
      if (i16 == i17)
      {
        paramCanvas.drawLine(i + k / 15, j, i - k / 15, j, this.qiblaPaint);
        paramCanvas.drawLine(i, j - k, i + k / 15, j, this.qiblaPaint);
        paramCanvas.drawLine(i, j - k, i - k / 15, j, this.qiblaPaint);
        paramCanvas.drawBitmap(localBitmap2, i - i1 / 2, j * 55 / 100, this.qiblaPaint);
      }
      paramCanvas.rotate(1.0F, i, j);
    }
  }

  public void setBearing(float paramFloat)
  {
    this.bearing = paramFloat;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     dawoodibohra.salaat.ViewCompass
 * JD-Core Version:    0.6.2
 */