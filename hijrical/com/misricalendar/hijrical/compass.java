package com.misricalendar.hijrical;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import anywheresoftware.b4a.B4AClass.ImplB4AClass;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.SubDelegator;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.objects.PanelWrapper;
import anywheresoftware.b4a.objects.drawable.CanvasWrapper;
import anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper;
import anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper;
import anywheresoftware.b4a.objects.streams.File;
import java.lang.reflect.Method;
import java.util.HashMap;

public class compass extends B4AClass.ImplB4AClass
  implements BA.SubDelegator
{
  private static HashMap<String, Method> htSubs;
  public Common __c = null;
  public CanvasWrapper.BitmapWrapper _vvvvvvvvvvvvvv0 = null;
  public PanelWrapper _vvvvvvvvvvvvvv7 = null;
  public datecon _vvvvvvvvvvvvvvv0 = null;
  public CanvasWrapper.BitmapWrapper _vvvvvvvvvvvvvvv1 = null;
  public int _vvvvvvvvvvvvvvv2 = 0;
  public int _vvvvvvvvvvvvvvv3 = 0;
  public CanvasWrapper.RectWrapper _vvvvvvvvvvvvvvv4 = null;
  public CanvasWrapper.RectWrapper _vvvvvvvvvvvvvvv5 = null;
  public CanvasWrapper _vvvvvvvvvvvvvvv6 = null;
  public main _vvvvvvvvvvvvvvv7 = null;
  public suntime _vvvvvvvvvvvvvvvv1 = null;
  public hcalsrvc _vvvvvvvvvvvvvvvv2 = null;
  public gl _vvvvvvvvvvvvvvvv3 = null;
  public settings _vvvvvvvvvvvvvvvv4 = null;
  public qibla _vvvvvvvvvvvvvvvv5 = null;
  public qedit _vvvvvvvvvvvvvvvv6 = null;

  private void innerInitialize(BA paramBA)
    throws Exception
  {
    if (this.ba == null)
    {
      this.ba = new BA(paramBA, this, htSubs, "com.misricalendar.hijrical.compass");
      if (htSubs == null)
      {
        this.ba.loadHtSubs(getClass());
        htSubs = this.ba.htSubs;
      }
      if (this.ba.getClass().getName().endsWith("ShellBA"))
      {
        BA localBA = this.ba;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = "com.misricalendar.hijrical.compass";
        arrayOfObject[1] = this.ba;
        localBA.raiseEvent2(null, true, "CREATE", true, arrayOfObject);
      }
    }
    this.ba.raiseEvent2(null, true, "class_globals", false, new Object[0]);
  }

  public String _class_globals()
    throws Exception
  {
    this._vvvvvvvvvvvvvv7 = new PanelWrapper();
    this._vvvvvvvvvvvvvv0 = new CanvasWrapper.BitmapWrapper();
    this._vvvvvvvvvvvvvvv1 = new CanvasWrapper.BitmapWrapper();
    this._vvvvvvvvvvvvvvv2 = 0;
    this._vvvvvvvvvvvvvvv3 = 0;
    this._vvvvvvvvvvvvvvv4 = new CanvasWrapper.RectWrapper();
    this._vvvvvvvvvvvvvvv5 = new CanvasWrapper.RectWrapper();
    this._vvvvvvvvvvvvvvv6 = new CanvasWrapper();
    return "";
  }

  public String _initialize(BA paramBA, PanelWrapper paramPanelWrapper, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2)
    throws Exception
  {
    innerInitialize(paramBA);
    CanvasWrapper.BitmapWrapper localBitmapWrapper1 = this._vvvvvvvvvvvvvv0;
    localBitmapWrapper1.Initialize(File.getDirAssets(), paramString1);
    CanvasWrapper.BitmapWrapper localBitmapWrapper2 = this._vvvvvvvvvvvvvvv1;
    localBitmapWrapper2.Initialize(File.getDirAssets(), paramString2);
    this._vvvvvvvvvvvvvv7.Initialize(this.ba, "");
    View localView = (View)this._vvvvvvvvvvvvvv7.getObject();
    int i = Common.DipToCurrent(paramInt3);
    paramPanelWrapper.AddView(localView, paramInt2, paramInt1, i, Common.DipToCurrent(paramInt4));
    this._vvvvvvvvvvvvvvv2 = 0;
    this._vvvvvvvvvvvvvvv3 = 0;
    this._vvvvvvvvvvvvvvv4.Initialize(this._vvvvvvvvvvvvvvv2, this._vvvvvvvvvvvvvvv3, paramInt3 + this._vvvvvvvvvvvvvvv2, paramInt4 + this._vvvvvvvvvvvvvvv3);
    this._vvvvvvvvvvvvvvv5.Initialize(this._vvvvvvvvvvvvvvv2, this._vvvvvvvvvvvvvvv3, paramInt3 + this._vvvvvvvvvvvvvvv2, paramInt4 + this._vvvvvvvvvvvvvvv3);
    this._vvvvvvvvvvvvvvv6.Initialize((View)this._vvvvvvvvvvvvvv7.getObject());
    CanvasWrapper localCanvasWrapper1 = this._vvvvvvvvvvvvvvv6;
    Bitmap localBitmap1 = (Bitmap)this._vvvvvvvvvvvvvvv1.getObject();
    localCanvasWrapper1.DrawBitmap(localBitmap1, (Rect)Common.Null, (Rect)this._vvvvvvvvvvvvvvv4.getObject());
    CanvasWrapper localCanvasWrapper2 = this._vvvvvvvvvvvvvvv6;
    Bitmap localBitmap2 = (Bitmap)this._vvvvvvvvvvvvvv0.getObject();
    localCanvasWrapper2.DrawBitmap(localBitmap2, (Rect)Common.Null, (Rect)this._vvvvvvvvvvvvvvv5.getObject());
    return "";
  }

  public String _vvvvvvvvvvvvvv6(float paramFloat1, float paramFloat2)
    throws Exception
  {
    float f1 = (float)(360.0D - paramFloat1);
    float f2 = f1 + paramFloat2;
    if (f2 > 360.0D);
    for (float f3 = (float)(f2 - 360.0D); ; f3 = f2)
    {
      CanvasWrapper localCanvasWrapper1 = this._vvvvvvvvvvvvvvv6;
      Bitmap localBitmap1 = (Bitmap)this._vvvvvvvvvvvvvvv1.getObject();
      localCanvasWrapper1.DrawBitmapRotated(localBitmap1, (Rect)Common.Null, (Rect)this._vvvvvvvvvvvvvvv4.getObject(), f1);
      CanvasWrapper localCanvasWrapper2 = this._vvvvvvvvvvvvvvv6;
      Bitmap localBitmap2 = (Bitmap)this._vvvvvvvvvvvvvv0.getObject();
      localCanvasWrapper2.DrawBitmapRotated(localBitmap2, (Rect)Common.Null, (Rect)this._vvvvvvvvvvvvvvv5.getObject(), f3);
      this._vvvvvvvvvvvvvv7.Invalidate();
      return "";
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
 * Qualified Name:     com.misricalendar.hijrical.compass
 * JD-Core Version:    0.6.2
 */