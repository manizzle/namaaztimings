package com.misricalendar.hijrical;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.B4AClass.ImplB4AClass;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.SubDelegator;
import anywheresoftware.b4a.keywords.Bit;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.keywords.constants.Colors;
import anywheresoftware.b4a.keywords.constants.TypefaceWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import anywheresoftware.b4a.objects.LabelWrapper;
import anywheresoftware.b4a.objects.PanelWrapper;
import anywheresoftware.b4a.objects.drawable.CanvasWrapper;
import anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper;
import anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper;
import com.AB.ABExtDrawing.ABExtDrawing;
import com.AB.ABExtDrawing.ABExtDrawing.ABPaint;
import java.lang.reflect.Method;
import java.util.HashMap;

public class mbhbargauge extends B4AClass.ImplB4AClass
  implements BA.SubDelegator
{
  private static HashMap<String, Method> htSubs;
  public Common __c = null;
  public CanvasWrapper _cvs_disabled = null;
  public CanvasWrapper _cvs_normal = null;
  public CanvasWrapper _cvs_pressed = null;
  public datecon _vvvvvvvvvvvvvvv0 = null;
  public main _vvvvvvvvvvvvvvv7 = null;
  public suntime _vvvvvvvvvvvvvvvv1 = null;
  public hcalsrvc _vvvvvvvvvvvvvvvv2 = null;
  public gl _vvvvvvvvvvvvvvvv3 = null;
  public settings _vvvvvvvvvvvvvvvv4 = null;
  public qibla _vvvvvvvvvvvvvvvv5 = null;
  public qedit _vvvvvvvvvvvvvvvv6 = null;
  public boolean _vvvvvvvvvvvvvvvvv0 = false;
  public PanelWrapper _vvvvvvvvvvvvvvvvv4 = null;
  public PanelWrapper _vvvvvvvvvvvvvvvvv5 = null;
  public ActivityWrapper _vvvvvvvvvvvvvvvvv6 = null;
  public LabelWrapper _vvvvvvvvvvvvvvvvv7 = null;
  public int _vvvvvvvvvvvvvvvvvv0 = 0;
  public ABExtDrawing.ABPaint _vvvvvvvvvvvvvvvvvv1 = null;
  public ABExtDrawing _vvvvvvvvvvvvvvvvvv2 = null;
  public int _vvvvvvvvvvvvvvvvvv3 = 0;
  public int _vvvvvvvvvvvvvvvvvv4 = 0;
  public double _vvvvvvvvvvvvvvvvvv5 = 0.0D;
  public CanvasWrapper _vvvvvvvvvvvvvvvvvv6 = null;
  public CanvasWrapper.RectWrapper _vvvvvvvvvvvvvvvvvv7 = null;
  public int _vvvvvvvvvvvvvvvvvvv1 = 0;
  public int _vvvvvvvvvvvvvvvvvvv2 = 0;
  public int _vvvvvvvvvvvvvvvvvvv3 = 0;

  private void innerInitialize(BA paramBA)
    throws Exception
  {
    if (this.ba == null)
    {
      this.ba = new BA(paramBA, this, htSubs, "com.misricalendar.hijrical.mbhbargauge");
      if (htSubs == null)
      {
        this.ba.loadHtSubs(getClass());
        htSubs = this.ba.htSubs;
      }
      if (this.ba.getClass().getName().endsWith("ShellBA"))
      {
        BA localBA = this.ba;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = "com.misricalendar.hijrical.mbhbargauge";
        arrayOfObject[1] = this.ba;
        localBA.raiseEvent2(null, true, "CREATE", true, arrayOfObject);
      }
    }
    this.ba.raiseEvent2(null, true, "class_globals", false, new Object[0]);
  }

  public String _class_globals()
    throws Exception
  {
    this._vvvvvvvvvvvvvvvvv4 = new PanelWrapper();
    this._vvvvvvvvvvvvvvvvv5 = new PanelWrapper();
    this._vvvvvvvvvvvvvvvvv6 = new ActivityWrapper();
    this._vvvvvvvvvvvvvvvvv7 = new LabelWrapper();
    this._vvvvvvvvvvvvvvvvv0 = false;
    this._vvvvvvvvvvvvvvvvvv1 = new ABExtDrawing.ABPaint();
    this._vvvvvvvvvvvvvvvvvv2 = new ABExtDrawing();
    this._cvs_disabled = new CanvasWrapper();
    this._cvs_normal = new CanvasWrapper();
    this._cvs_pressed = new CanvasWrapper();
    this._vvvvvvvvvvvvvvvvvv3 = 0;
    this._vvvvvvvvvvvvvvvvvv4 = 0;
    this._vvvvvvvvvvvvvvvvvv5 = 0.0D;
    this._vvvvvvvvvvvvvvvvvv6 = new CanvasWrapper();
    this._vvvvvvvvvvvvvvvvvv7 = new CanvasWrapper.RectWrapper();
    this._vvvvvvvvvvvvvvvvvv0 = 0;
    this._vvvvvvvvvvvvvvvvvvv1 = 0;
    this._vvvvvvvvvvvvvvvvvvv2 = 0;
    this._vvvvvvvvvvvvvvvvvvv3 = 1;
    return "";
  }

  public String _initialize(BA paramBA, ActivityWrapper paramActivityWrapper, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, int paramInt5, int paramInt6, boolean paramBoolean, int paramInt7, int paramInt8, int paramInt9)
    throws Exception
  {
    innerInitialize(paramBA);
    this._vvvvvvvvvvvvvvvvv6 = paramActivityWrapper;
    this._vvvvvvvvvvvvvvvvv0 = paramBoolean;
    this._vvvvvvvvvvvvvvvvvvv1 = paramInt9;
    this._vvvvvvvvvvvvvvvvvv0 = paramInt8;
    this._vvvvvvvvvvvvvvvvvvv2 = (this._vvvvvvvvvvvvvvvvvvv1 - this._vvvvvvvvvvvvvvvvvv0);
    this._vvvvvvvvvvvvvvvvvv3 = paramInt5;
    this._vvvvvvvvvvvvvvvvvv4 = paramInt6;
    this._vvvvvvvvvvvvvvvvvv5 = (paramInt4 / 2.0D);
    this._vvvvvvvvvvvvvvvvv4.Initialize(this.ba, "mbBackground");
    PanelWrapper localPanelWrapper1 = this._vvvvvvvvvvvvvvvvv4;
    localPanelWrapper1.setColor(0);
    this._vvvvvvvvvvvvvvvvv4.setTag("mbhs");
    this._vvvvvvvvvvvvvvvvv6.AddView((View)this._vvvvvvvvvvvvvvvvv4.getObject(), paramInt1, paramInt2, paramInt3, paramInt4);
    this._vvvvvvvvvvvvvvvvvv7.Initialize(0, 0, this._vvvvvvvvvvvvvvvvv4.getWidth(), this._vvvvvvvvvvvvvvvvv4.getHeight());
    this._vvvvvvvvvvvvvvvvvv6.Initialize((View)this._vvvvvvvvvvvvvvvvv4.getObject());
    this._vvvvvvvvvvvvvvvvvv1.Initialize();
    ABExtDrawing.ABPaint localABPaint1 = this._vvvvvvvvvvvvvvvvvv1;
    localABPaint1.SetAntiAlias(true);
    ABExtDrawing.ABPaint localABPaint2 = this._vvvvvvvvvvvvvvvvvv1;
    localABPaint2.SetStyle(2);
    this._vvvvvvvvvvvvvvvvvv1.SetStrokeWidth((float)paramDouble);
    this._vvvvvvvvvvvvvvvvvv1.SetAlpha(145);
    this._vvvvvvvvvvvvvvvvvv1.SetColor(this._vvvvvvvvvvvvvvvvvv3);
    this._vvvvvvvvvvvvvvvvvv2.drawLine(this._vvvvvvvvvvvvvvvvvv6, (float)this._vvvvvvvvvvvvvvvvvv5, (float)this._vvvvvvvvvvvvvvvvvv5, (float)(this._vvvvvvvvvvvvvvvvv4.getWidth() - this._vvvvvvvvvvvvvvvvvv5), (float)this._vvvvvvvvvvvvvvvvvv5, this._vvvvvvvvvvvvvvvvvv1);
    this._vvvvvvvvvvvvvvvvv5.Initialize(this.ba, "mbBtn");
    PanelWrapper localPanelWrapper2 = this._vvvvvvvvvvvvvvvvv5;
    localPanelWrapper2.setColor(0);
    this._vvvvvvvvvvvvvvvvv4.AddView((View)this._vvvvvvvvvvvvvvvvv5.getObject(), 0, 0, paramInt4, paramInt4);
    ABExtDrawing localABExtDrawing = new ABExtDrawing();
    ABExtDrawing.ABPaint localABPaint3 = new ABExtDrawing.ABPaint();
    localABPaint3.Initialize();
    localABPaint3.SetAntiAlias(true);
    CanvasWrapper.BitmapWrapper localBitmapWrapper1 = new CanvasWrapper.BitmapWrapper();
    localBitmapWrapper1.InitializeMutable(paramInt4, paramInt4);
    this._cvs_disabled.Initialize2((Bitmap)localBitmapWrapper1.getObject());
    localABPaint3.SetStyle(0);
    localABPaint3.SetColor(Colors.RGB(136, 136, 136));
    localABPaint3.SetAlpha(77);
    localABExtDrawing.drawCircle(this._cvs_disabled, (float)this._vvvvvvvvvvvvvvvvvv5, (float)this._vvvvvvvvvvvvvvvvvv5, (float)this._vvvvvvvvvvvvvvvvvv5, localABPaint3);
    if (!paramBoolean)
    {
      localABPaint3.SetColor(paramInt6);
      localABPaint3.SetAlpha(255);
      localABExtDrawing.drawCircle(this._cvs_disabled, (float)this._vvvvvvvvvvvvvvvvvv5, (float)this._vvvvvvvvvvvvvvvvvv5, (float)(paramInt4 / 9.0D), localABPaint3);
    }
    CanvasWrapper.BitmapWrapper localBitmapWrapper2 = new CanvasWrapper.BitmapWrapper();
    localBitmapWrapper2.InitializeMutable(paramInt4, paramInt4);
    this._cvs_pressed.Initialize2((Bitmap)localBitmapWrapper2.getObject());
    localABPaint3.SetStyle(0);
    localABPaint3.SetColor(paramInt6);
    localABPaint3.SetAlpha(154);
    localABExtDrawing.drawCircle(this._cvs_pressed, (float)this._vvvvvvvvvvvvvvvvvv5, (float)this._vvvvvvvvvvvvvvvvvv5, (float)this._vvvvvvvvvvvvvvvvvv5, localABPaint3);
    localABPaint3.SetStyle(2);
    localABPaint3.SetStrokeWidth(Common.DipToCurrent(2));
    CanvasWrapper localCanvasWrapper = this._cvs_pressed;
    float f1 = (float)this._vvvvvvvvvvvvvvvvvv5;
    float f2 = (float)this._vvvvvvvvvvvvvvvvvv5;
    double d = this._vvvvvvvvvvvvvvvvvv5;
    localABExtDrawing.drawCircle(localCanvasWrapper, f1, f2, (float)(d - Common.DipToCurrent(2)), localABPaint3);
    if (!paramBoolean)
    {
      localABPaint3.SetAlpha(255);
      localABPaint3.SetStyle(0);
      localABExtDrawing.drawCircle(this._cvs_pressed, (float)this._vvvvvvvvvvvvvvvvvv5, (float)this._vvvvvvvvvvvvvvvvvv5, (float)(paramInt4 / 6.0D), localABPaint3);
    }
    this._cvs_normal.Initialize((View)this._vvvvvvvvvvvvvvvvv5.getObject());
    localABPaint3.SetStyle(0);
    localABPaint3.SetColor(paramInt6);
    localABPaint3.SetAlpha(154);
    localABExtDrawing.drawCircle(this._cvs_normal, (float)this._vvvvvvvvvvvvvvvvvv5, (float)this._vvvvvvvvvvvvvvvvvv5, (float)this._vvvvvvvvvvvvvvvvvv5, localABPaint3);
    if (!paramBoolean)
    {
      localABPaint3.SetAlpha(255);
      localABExtDrawing.drawCircle(this._cvs_normal, (float)this._vvvvvvvvvvvvvvvvvv5, (float)this._vvvvvvvvvvvvvvvvvv5, (float)(paramInt4 / 6.0D), localABPaint3);
    }
    this._vvvvvvvvvvvvvvvvv6.Invalidate();
    boolean bool = this._vvvvvvvvvvvvvvvvv0;
    if (bool == true)
    {
      this._vvvvvvvvvvvvvvvvv7.Initialize(this.ba, "");
      this._vvvvvvvvvvvvvvvvv5.AddView((View)this._vvvvvvvvvvvvvvvvv7.getObject(), 0, 0, this._vvvvvvvvvvvvvvvvv5.getWidth(), this._vvvvvvvvvvvvvvvvv5.getHeight());
      LabelWrapper localLabelWrapper = this._vvvvvvvvvvvvvvvvv7;
      localLabelWrapper.setGravity(Bit.Or(1, 16));
      TypefaceWrapper localTypefaceWrapper = new TypefaceWrapper();
      _vvvvvvvvvvvvvvvv7(-1, 14, (TypefaceWrapper)AbsObjectWrapper.ConvertToWrapper(localTypefaceWrapper, TypefaceWrapper.DEFAULT));
      this._vvvvvvvvvvvvvvvvv7.setText(Integer.valueOf(_vvvvvvvvvvvvvvvvv2()));
    }
    _vvvvvvvvvvvvvvvvv3(paramInt7, false);
    _vvvvvvvvvvvvvvvv0();
    return "";
  }

  public String _redraw_background(boolean paramBoolean)
    throws Exception
  {
    CanvasWrapper localCanvasWrapper = this._vvvvvvvvvvvvvvvvvv6;
    Rect localRect = (Rect)this._vvvvvvvvvvvvvvvvvv7.getObject();
    localCanvasWrapper.DrawRect(localRect, 0, true, 0.0F);
    this._vvvvvvvvvvvvvvvvv4.Invalidate();
    this._vvvvvvvvvvvvvvvvvv1.SetColor(this._vvvvvvvvvvvvvvvvvv3);
    this._vvvvvvvvvvvvvvvvvv1.SetAlpha(145);
    this._vvvvvvvvvvvvvvvvvv2.drawLine(this._vvvvvvvvvvvvvvvvvv6, (float)this._vvvvvvvvvvvvvvvvvv5, (float)this._vvvvvvvvvvvvvvvvvv5, (float)(this._vvvvvvvvvvvvvvvvv4.getWidth() - this._vvvvvvvvvvvvvvvvvv5), (float)this._vvvvvvvvvvvvvvvvvv5, this._vvvvvvvvvvvvvvvvvv1);
    if (paramBoolean == true)
    {
      this._vvvvvvvvvvvvvvvvvv1.SetColor(this._vvvvvvvvvvvvvvvvvv4);
      this._vvvvvvvvvvvvvvvvvv1.SetAlpha(255);
      boolean bool = this._vvvvvvvvvvvvvvvvv0;
      if (bool != true)
        break label215;
      if (this._vvvvvvvvvvvvvvvvv5.getLeft() > this._vvvvvvvvvvvvvvvvvv5)
        this._vvvvvvvvvvvvvvvvvv2.drawLine(this._vvvvvvvvvvvvvvvvvv6, (float)this._vvvvvvvvvvvvvvvvvv5, (float)this._vvvvvvvvvvvvvvvvvv5, this._vvvvvvvvvvvvvvvvv5.getLeft(), (float)this._vvvvvvvvvvvvvvvvvv5, this._vvvvvvvvvvvvvvvvvv1);
    }
    while (true)
    {
      return "";
      label215: this._vvvvvvvvvvvvvvvvvv2.drawLine(this._vvvvvvvvvvvvvvvvvv6, (float)this._vvvvvvvvvvvvvvvvvv5, (float)this._vvvvvvvvvvvvvvvvvv5, (float)(this._vvvvvvvvvvvvvvvvv5.getLeft() + this._vvvvvvvvvvvvvvvvvv5), (float)this._vvvvvvvvvvvvvvvvvv5, this._vvvvvvvvvvvvvvvvvv1);
    }
  }

  public String _vvvvvvvvvvvvvvvv0()
    throws Exception
  {
    this._vvvvvvvvvvvvvvvvv5.SetBackgroundImage((Bitmap)this._cvs_disabled.getBitmap().getObject());
    _redraw_background(false);
    PanelWrapper localPanelWrapper = this._vvvvvvvvvvvvvvvvv4;
    localPanelWrapper.setEnabled(false);
    return "";
  }

  public String _vvvvvvvvvvvvvvvv7(int paramInt1, int paramInt2, TypefaceWrapper paramTypefaceWrapper)
    throws Exception
  {
    boolean bool = this._vvvvvvvvvvvvvvvvv0;
    if (bool == true)
    {
      this._vvvvvvvvvvvvvvvvv7.setTypeface((Typeface)paramTypefaceWrapper.getObject());
      this._vvvvvvvvvvvvvvvvv7.setTextColor(paramInt1);
      this._vvvvvvvvvvvvvvvvv7.setTextSize(paramInt2);
    }
    return "";
  }

  public String _vvvvvvvvvvvvvvvvv1()
    throws Exception
  {
    this._vvvvvvvvvvvvvvvvv5.SetBackgroundImage((Bitmap)this._cvs_normal.getBitmap().getObject());
    _redraw_background(true);
    PanelWrapper localPanelWrapper = this._vvvvvvvvvvvvvvvvv4;
    localPanelWrapper.setEnabled(true);
    boolean bool = this._vvvvvvvvvvvvvvvvv0;
    if (bool == true)
    {
      LabelWrapper localLabelWrapper = this._vvvvvvvvvvvvvvvvv7;
      localLabelWrapper.setVisible(true);
    }
    return "";
  }

  public int _vvvvvvvvvvvvvvvvv2()
    throws Exception
  {
    long l = this._vvvvvvvvvvvvvvvvvv0;
    return (int)(l + Common.Round(this._vvvvvvvvvvvvvvvvv5.getLeft() / ((this._vvvvvvvvvvvvvvvvv4.getWidth() - this._vvvvvvvvvvvvvvvvv5.getWidth()) / this._vvvvvvvvvvvvvvvvvvv2)));
  }

  public String _vvvvvvvvvvvvvvvvv3(int paramInt, boolean paramBoolean)
    throws Exception
  {
    PanelWrapper localPanelWrapper = this._vvvvvvvvvvvvvvvvv5;
    localPanelWrapper.setLeft((int)Common.Round((paramInt - this._vvvvvvvvvvvvvvvvvv0) * ((this._vvvvvvvvvvvvvvvvv4.getWidth() - this._vvvvvvvvvvvvvvvvv5.getWidth()) / this._vvvvvvvvvvvvvvvvvvv2)));
    if (paramBoolean)
      this._vvvvvvvvvvvvvvvvv5.SetBackgroundImage((Bitmap)this._cvs_normal.getBitmap().getObject());
    while (true)
    {
      _redraw_background(this._vvvvvvvvvvvvvvvvv4.getEnabled());
      boolean bool = this._vvvvvvvvvvvvvvvvv0;
      if (bool == true)
        this._vvvvvvvvvvvvvvvvv7.setText(Integer.valueOf(paramInt));
      return "";
      this._vvvvvvvvvvvvvvvvv5.SetBackgroundImage((Bitmap)this._cvs_disabled.getBitmap().getObject());
    }
  }

  public Object callSub(String paramString, Object paramObject, Object[] paramArrayOfObject)
    throws Exception
  {
    this.ba.sharedProcessBA.sender = paramObject;
    return BA.SubDelegator.SubNotFound;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.misricalendar.hijrical.mbhbargauge
 * JD-Core Version:    0.6.2
 */