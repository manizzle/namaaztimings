package com.misricalendar.hijrical;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.B4AClass.ImplB4AClass;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.SubDelegator;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.agraham.reflection.Reflection;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.keywords.constants.TypefaceWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import anywheresoftware.b4a.objects.ConcreteViewWrapper;
import anywheresoftware.b4a.objects.LabelWrapper;
import anywheresoftware.b4a.objects.PanelWrapper;
import anywheresoftware.b4a.objects.StringUtils;
import anywheresoftware.b4a.objects.collections.List;
import anywheresoftware.b4a.objects.collections.Map;
import anywheresoftware.b4a.objects.drawable.CanvasWrapper;
import anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper;
import anywheresoftware.b4a.objects.drawable.ColorDrawable;
import anywheresoftware.b4a.objects.streams.File;
import anywheresoftware.b4a.sql.SQL;
import anywheresoftware.b4a.sql.SQL.CursorWrapper;
import flm.b4a.scrollview2d.ScrollView2DWrapper;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

public class table extends B4AClass.ImplB4AClass
  implements BA.SubDelegator
{
  private static HashMap<String, Method> htSubs;
  public Common __c = null;
  public long _debug_counter = 0L;
  public PanelWrapper _pnltable = null;
  public datecon _vvvvvvvvvvvvvvv0 = null;
  public main _vvvvvvvvvvvvvvv7 = null;
  public suntime _vvvvvvvvvvvvvvvv1 = null;
  public hcalsrvc _vvvvvvvvvvvvvvvv2 = null;
  public gl _vvvvvvvvvvvvvvvv3 = null;
  public settings _vvvvvvvvvvvvvvvv4 = null;
  public qibla _vvvvvvvvvvvvvvvv5 = null;
  public qedit _vvvvvvvvvvvvvvvv6 = null;
  public StringUtils _vvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = null;
  public List _vvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = null;
  public LabelWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = null;
  public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = 0;
  public ScrollView2DWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = null;
  public PanelWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = null;
  public Object _vvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = null;
  public String _vvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = "";
  public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = 0;
  public List _vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = null;
  public List _vvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = null;
  public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = 0;
  public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = 0;
  public boolean _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = false;
  public Map _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = null;
  public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = 0;
  public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = 0;
  public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = 0;
  public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = 0;
  public Object _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = null;
  public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = 0;
  public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = 0;
  public float _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = 0.0F;
  public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = 0;
  public Object[] _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = null;
  public Object[] _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = null;
  public Object[] _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = null;
  public boolean _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = false;
  public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = 0;
  public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = 0;
  public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = 0;
  public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = 0;
  public CanvasWrapper.BitmapWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = null;
  public CanvasWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = null;
  public boolean _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = false;
  public int[] _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = null;
  public boolean _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = false;
  public PanelWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = null;
  public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = 0;
  public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = 0;
  public PanelWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = null;
  public boolean _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = false;

  private void innerInitialize(BA paramBA)
    throws Exception
  {
    if (this.ba == null)
    {
      this.ba = new BA(paramBA, this, htSubs, "com.misricalendar.hijrical.table");
      if (htSubs == null)
      {
        this.ba.loadHtSubs(getClass());
        htSubs = this.ba.htSubs;
      }
      if (this.ba.getClass().getName().endsWith("ShellBA"))
      {
        BA localBA = this.ba;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = "com.misricalendar.hijrical.table";
        arrayOfObject[1] = this.ba;
        localBA.raiseEvent2(null, true, "CREATE", true, arrayOfObject);
      }
    }
    this.ba.raiseEvent2(null, true, "class_globals", false, new Object[0]);
  }

  public String _cell_click()
    throws Exception
  {
    new _rowcol();
    LabelWrapper localLabelWrapper = new LabelWrapper();
    localLabelWrapper.setObject((TextView)Common.Sender(this.ba));
    _rowcol local_rowcol = (_rowcol)localLabelWrapper.getTag();
    _vvvvvvvvvvvvvvvvvvvvvvvv2(local_rowcol);
    if (Common.SubExists(this.ba, this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv3, this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 + "_CellClick"))
      Common.CallSubNew3(this.ba, this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv3, this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 + "_CellClick", Integer.valueOf(local_rowcol.Col), Integer.valueOf(local_rowcol.Row));
    return "";
  }

  public String _cell_longclick()
    throws Exception
  {
    new _rowcol();
    LabelWrapper localLabelWrapper = new LabelWrapper();
    localLabelWrapper.setObject((TextView)Common.Sender(this.ba));
    _rowcol local_rowcol = (_rowcol)localLabelWrapper.getTag();
    if (Common.SubExists(this.ba, this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv3, this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 + "_CellLongClick"))
      Common.CallSubNew3(this.ba, this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv3, this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 + "_CellLongClick", Integer.valueOf(local_rowcol.Col), Integer.valueOf(local_rowcol.Row));
    return "";
  }

  public String _class_globals()
    throws Exception
  {
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = new StringUtils();
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = new ScrollView2DWrapper();
    this._pnltable = new PanelWrapper();
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = new PanelWrapper();
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = new LabelWrapper();
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = new Object();
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = "";
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = new List();
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = 0;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = new List();
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = new List();
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = 0;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = 0;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = false;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = new Map();
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = 0;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = 0;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = 0;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = 0;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = 0;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = 0;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = 0;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = 0.0F;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = 0;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = new Object[0];
    int i = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.length;
    for (int j = 0; j < i; j++)
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5[j] = new Object();
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = new Object[0];
    int k = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.length;
    for (int m = 0; m < k; m++)
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6[m] = new Object();
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = new Object[0];
    int n = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.length;
    for (int i1 = 0; i1 < n; i1++)
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7[i1] = new Object();
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = new Object();
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = 0;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = 0;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = 0;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = 0;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = new CanvasWrapper.BitmapWrapper();
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = new CanvasWrapper();
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = -7829368;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = -3355444;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = -16777216;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = -1;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = 14.0F;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = 17;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = -1;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = -6752769;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = -16744449;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = -225620;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = Common.DipToCurrent(30);
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = true;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = false;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = new int[0];
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = true;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = new PanelWrapper();
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = 0;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = -1;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = new PanelWrapper();
    this._debug_counter = 0L;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = false;
    return "";
  }

  public int _getvvvvvvvvvvvvvvvvvvvvvvvvvvv0()
    throws Exception
  {
    return this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4;
  }

  public int _getvvvvvvvvvvvvvvvvvvvvvvvvvvv1()
    throws Exception
  {
    return this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4;
  }

  public int _getvvvvvvvvvvvvvvvvvvvvvvvvvvv2()
    throws Exception
  {
    return this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7;
  }

  public PanelWrapper _getvvvvvvvvvvvvvvvvvvvvvvvvvvv3()
    throws Exception
  {
    return this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv2;
  }

  public int _getvvvvvvvvvvvvvvvvvvvvvvvvvvv4()
    throws Exception
  {
    return this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2;
  }

  public boolean _getvvvvvvvvvvvvvvvvvvvvvvvvvvv5()
    throws Exception
  {
    return this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0;
  }

  public int _getvvvvvvvvvvvvvvvvvvvvvvvvvvv6()
    throws Exception
  {
    return this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1;
  }

  public int _getvvvvvvvvvvvvvvvvvvvvvvvvvvv7()
    throws Exception
  {
    return this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2;
  }

  public int _getvvvvvvvvvvvvvvvvvvvvvvvvvvvv1()
    throws Exception
  {
    return this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3;
  }

  public List _getvvvvvvvvvvvvvvvvvvvvvvvvvvvv2()
    throws Exception
  {
    List localList = new List();
    localList.Initialize();
    localList.AddAll(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv2);
    return localList;
  }

  public int _getvvvvvvvvvvvvvvvvvvvvvvvvvvvv3()
    throws Exception
  {
    return this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0;
  }

  public int _getvvvvvvvvvvvvvvvvvvvvvvvvvvvv4()
    throws Exception
  {
    return this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1;
  }

  public float _getvvvvvvvvvvvvvvvvvvvvvvvvvvvv5()
    throws Exception
  {
    return this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3;
  }

  public String _header_click()
    throws Exception
  {
    LabelWrapper localLabelWrapper = new LabelWrapper();
    localLabelWrapper.setObject((TextView)Common.Sender(this.ba));
    int i = (int)BA.ObjectToNumber(localLabelWrapper.getTag());
    int j;
    if (this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 == i)
    {
      Integer localInteger = Integer.valueOf(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4);
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Integer.valueOf(0);
      arrayOfObject[1] = Integer.valueOf(1);
      arrayOfObject[2] = Integer.valueOf(-1);
      switch (BA.switchObjectToInt(localInteger, arrayOfObject))
      {
      default:
        j = 0;
        this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = i;
        this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = j;
        if (j > 0)
          break;
      case 0:
      case 1:
      case 2:
      }
    }
    for (boolean bool = true; ; bool = false)
    {
      _vvvvvvvvvvvvvvvvvvvvvvvvvv5(i, bool);
      _vvvvvvvvvvvvvvvvvvvvvvvvvv2(i, j);
      return "";
      j = -1;
      break;
      j = -1;
      break;
      j = 1;
      break;
      j = -1;
      break;
    }
  }

  public String _header_longclick()
    throws Exception
  {
    LabelWrapper localLabelWrapper = new LabelWrapper();
    localLabelWrapper.setObject((TextView)Common.Sender(this.ba));
    int i = (int)BA.ObjectToNumber(localLabelWrapper.getTag());
    if (Common.SubExists(this.ba, this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv3, this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 + "_HeaderLongClick"))
      Common.CallSubNew2(this.ba, this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv3, this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 + "_HeaderLongClick", Integer.valueOf(i));
    return "";
  }

  public String _initialize(BA paramBA, Object paramObject, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
    throws Exception
  {
    innerInitialize(paramBA);
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.Initialize(this.ba, 0, 0, "SV");
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.Initialize(this.ba, "IP");
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = paramBoolean;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv2.Initialize();
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = paramInt2;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = paramObject;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = paramString;
    _vvvvvvvvvvvvvvvvvvvvvv7(paramInt1);
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Initialize(this.ba, "");
    CanvasWrapper.BitmapWrapper localBitmapWrapper = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5;
    int i = Common.DipToCurrent(1);
    localBitmapWrapper.InitializeMutable(i, Common.DipToCurrent(1));
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Initialize2((Bitmap)this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.getObject());
    return "";
  }

  public String _ip_click()
    throws Exception
  {
    Common.Log("panel clicked!");
    if (Common.SubExists(this.ba, this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv3, this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 + "_HeaderClick"))
      Common.CallSubNew2(this.ba, this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv3, this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 + "_HeaderClick", Integer.valueOf(-1));
    return "";
  }

  public String _setvvvvvvvvvvvvvvvvvvvvvvvvvvv0(int paramInt)
    throws Exception
  {
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = paramInt;
    return "";
  }

  public String _setvvvvvvvvvvvvvvvvvvvvvvvvvvv1(int paramInt)
    throws Exception
  {
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = paramInt;
    return "";
  }

  public String _setvvvvvvvvvvvvvvvvvvvvvvvvvvv2(int paramInt)
    throws Exception
  {
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = paramInt;
    return "";
  }

  public String _setvvvvvvvvvvvvvvvvvvvvvvvvvvv4(int paramInt)
    throws Exception
  {
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = paramInt;
    return "";
  }

  public String _setvvvvvvvvvvvvvvvvvvvvvvvvvvv5(boolean paramBoolean)
    throws Exception
  {
    _vvvvvvvvvvvvvvvvvvvv2();
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = paramBoolean;
    return "";
  }

  public String _setvvvvvvvvvvvvvvvvvvvvvvvvvvv6(int paramInt)
    throws Exception
  {
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = paramInt;
    return "";
  }

  public String _setvvvvvvvvvvvvvvvvvvvvvvvvvvv7(int paramInt)
    throws Exception
  {
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = paramInt;
    return "";
  }

  public String _setvvvvvvvvvvvvvvvvvvvvvvvvvvvv1(int paramInt)
    throws Exception
  {
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = paramInt;
    return "";
  }

  public String _setvvvvvvvvvvvvvvvvvvvvvvvvvvvv3(int paramInt)
    throws Exception
  {
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = paramInt;
    return "";
  }

  public String _setvvvvvvvvvvvvvvvvvvvvvvvvvvvv4(int paramInt)
    throws Exception
  {
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = paramInt;
    return "";
  }

  public String _setvvvvvvvvvvvvvvvvvvvvvvvvvvvv5(float paramFloat)
    throws Exception
  {
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = ((float)_vvvvvvvvvvvvvvvvvvvvvvvvvv4());
    return "";
  }

  public String _setvvvvvvvvvvvvvvvvvvvvvvvvvvvv6(String paramString)
    throws Exception
  {
    if (this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv6.IsInitialized())
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv6.setText(paramString);
    return "";
  }

  public String _setvvvvvvvvvvvvvvvvvvvvvvvvvvvv7(boolean paramBoolean)
    throws Exception
  {
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = true;
    if (paramBoolean == true)
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = false;
    return "";
  }

  public String _sv_scrollchanged(int paramInt1, int paramInt2)
    throws Exception
  {
    int i = (int)Common.Max(0.0D, paramInt2 / this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 - 30.0D);
    int j = (int)Common.Min(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getSize() - 1, 30.0D + (paramInt2 + this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getHeight()) / this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6);
    if (this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 > -1)
    {
      int i5;
      if (this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 < i)
      {
        int i4 = (int)Common.Min(i - 1, this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1);
        i5 = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0;
        if (i5 <= i4);
      }
      while (true)
      {
        if (this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 <= j)
          break label248;
        int i2 = (int)Common.Max(j + 1, this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0);
        for (int i3 = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1; i3 >= i2; i3 = -1 + (i3 + 0))
          _vvvvvvvvvvvvvvvvvvvvvv6(i3);
        _vvvvvvvvvvvvvvvvvvvvvv6(i5);
        i5 = 1 + (i5 + 0);
        break;
        if (this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 > i)
        {
          int k = (int)Common.Min(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 - 1, j);
          for (int m = i; m <= k; m = 1 + (m + 0))
            _vvvvvvvvvvvvvvvvvvvvvvvvvv3(m);
        }
      }
      label248: if (this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 < j)
      {
        int n = (int)Common.Max(1 + this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1, i);
        for (int i1 = j; i1 >= n; i1 = -1 + (i1 + 0))
          _vvvvvvvvvvvvvvvvvvvvvvvvvv3(i1);
      }
    }
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = i;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = j;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.setLeft(-paramInt1);
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv6.setLeft(-paramInt1);
    return "";
  }

  public String _vvvvvvvvvvvvvvvvv3(int paramInt1, int paramInt2, String paramString)
    throws Exception
  {
    int i = 0;
    Arrays.fill(new String[0], "");
    ((String[])this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get(paramInt2))[paramInt1] = paramString;
    if (this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.ContainsKey(Integer.valueOf(paramInt2)))
    {
      LabelWrapper[] arrayOfLabelWrapper = new LabelWrapper[0];
      int j = arrayOfLabelWrapper.length;
      while (i < j)
      {
        arrayOfLabelWrapper[i] = new LabelWrapper();
        i++;
      }
      ((LabelWrapper[])(LabelWrapper[])this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.Get(Integer.valueOf(paramInt2)))[paramInt1].setText(paramString);
    }
    return "";
  }

  public String _vvvvvvvvvvvvvvvvvvv0(ConcreteViewWrapper paramConcreteViewWrapper, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws Exception
  {
    _vvvvvvvvvvvvvvvvvvv7((ActivityWrapper)AbsObjectWrapper.ConvertToWrapper(new ActivityWrapper(), (BALayout)paramConcreteViewWrapper.getObject()), paramInt1, paramInt2, paramInt3, paramInt4);
    return "";
  }

  public String _vvvvvvvvvvvvvvvvvvv6(String[] paramArrayOfString)
    throws Exception
  {
    if (paramArrayOfString.length != this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4)
    {
      Common.Log("Wrong number of values =" + BA.NumberToString(paramArrayOfString.length) + " col=" + BA.NumberToString(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4));
      return "";
    }
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Add(paramArrayOfString);
    int i = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getSize() - 1;
    if (i < 1.0D + (this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getVerticalScrollPosition() + this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getHeight()) / this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6)
      _vvvvvvvvvvvvvvvvvvvvvvvvvv3(i);
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getPanel().setHeight(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getSize() * this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6);
    _vvvvvvvvvvvvvvvvvvvvvvvvvv7();
    if (this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv6.IsInitialized())
    {
      boolean bool = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7;
      if (!bool)
        _setvvvvvvvvvvvvvvvvvvvvvvvvvvvv6(BA.NumberToString(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getSize()) + " rows");
    }
    return "";
  }

  public String _vvvvvvvvvvvvvvvvvvv7(ActivityWrapper paramActivityWrapper, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws Exception
  {
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getPanel().setColor(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0);
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = true;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.Initialize(this.ba, "");
    this._pnltable.Initialize(this.ba, "");
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.setColor(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0);
    paramActivityWrapper.AddView((View)this._pnltable.getObject(), paramInt1, paramInt2, paramInt3, paramInt4);
    this._pnltable.AddView((View)this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.getObject(), 0, 0, paramInt3, this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6);
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Initialize(this.ba, "");
    LabelWrapper localLabelWrapper = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv6;
    localLabelWrapper.setColor(0);
    PanelWrapper localPanelWrapper = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3;
    localPanelWrapper.setColor(0);
    boolean bool1 = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2;
    if (bool1 == true)
    {
      this._pnltable.AddView((View)this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getObject(), 0, 0 + this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6, paramInt3, paramInt4 - 2 * this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6);
      this._pnltable.AddView((View)this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getObject(), 0, this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getTop() + this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getHeight(), paramInt3, this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6);
    }
    while (true)
    {
      this._pnltable.AddView((View)this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.getObject(), 0, 0, paramInt3, 0);
      _vvvvvvvvvvvvvvvvvvvvvvvvvv7();
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = ((int)(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getWidth() / this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4));
      _sv_scrollchanged(0, 0);
      if (this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv6.IsInitialized())
      {
        boolean bool2 = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7;
        if (!bool2)
          _setvvvvvvvvvvvvvvvvvvvvvvvvvvvv6(BA.NumberToString(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getSize()) + " rows");
      }
      return "";
      this._pnltable.AddView((View)this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getObject(), 0, this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6, paramInt3, paramInt4 - this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6);
      this._pnltable.AddView((View)this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getObject(), 0, this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getTop() + this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getHeight(), 0, 0);
    }
  }

  public LabelWrapper[] _vvvvvvvvvvvvvvvvvvvv0(int paramInt)
    throws Exception
  {
    LabelWrapper[] arrayOfLabelWrapper1 = new LabelWrapper[0];
    int i = arrayOfLabelWrapper1.length;
    for (int j = 0; j < i; j++)
      arrayOfLabelWrapper1[j] = new LabelWrapper();
    LabelWrapper[] arrayOfLabelWrapper2;
    int k;
    if (this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.getSize() > 0)
    {
      arrayOfLabelWrapper2 = (LabelWrapper[])this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.Get(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.getSize() - 1);
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.RemoveAt(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.getSize() - 1);
      k = arrayOfLabelWrapper2.length - 1;
    }
    for (int m = 0; ; m = 1 + (m + 0))
    {
      if (m > k)
      {
        return arrayOfLabelWrapper2;
        arrayOfLabelWrapper2 = _vvvvvvvvvvvvvvvvvvvv3();
        break;
      }
      new _rowcol();
      ((_rowcol)arrayOfLabelWrapper2[m].getTag()).Row = paramInt;
    }
  }

  public String _vvvvvvvvvvvvvvvvvvvv1()
    throws Exception
  {
    _vvvvvvvvvvvvvvvvvvvvvv7(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4);
    _vvvvvvvvvvvvvvvvvvvvvvvvvv7();
    return "";
  }

  public String _vvvvvvvvvvvvvvvvvvvv2()
    throws Exception
  {
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv2.Clear();
    _vvvvvvvvvvvvvvvvvvvvvvv6();
    return "";
  }

  public LabelWrapper[] _vvvvvvvvvvvvvvvvvvvv3()
    throws Exception
  {
    LabelWrapper[] arrayOfLabelWrapper = new LabelWrapper[this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4];
    int i = arrayOfLabelWrapper.length;
    for (int j = 0; j < i; j++)
      arrayOfLabelWrapper[j] = new LabelWrapper();
    int k = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 - 1;
    for (int m = 0; ; m = 1 + (m + 0))
    {
      if (m > k)
        return arrayOfLabelWrapper;
      _rowcol local_rowcol = new _rowcol();
      local_rowcol.Col = m;
      LabelWrapper localLabelWrapper = new LabelWrapper();
      localLabelWrapper.Initialize(this.ba, "cell");
      localLabelWrapper.setGravity(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4);
      localLabelWrapper.setTextSize(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3);
      localLabelWrapper.setTextColor(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1);
      if (this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7)
      {
        Reflection localReflection = new Reflection();
        localReflection.Target = localLabelWrapper.getObject();
        localReflection.RunMethod2("setSingleLine", BA.ObjectToString(Boolean.valueOf(true)), "java.lang.boolean");
      }
      localLabelWrapper.setTag(local_rowcol);
      arrayOfLabelWrapper[m] = localLabelWrapper;
    }
  }

  public int _vvvvvvvvvvvvvvvvvvvvv4()
    throws Exception
  {
    return this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getSize();
  }

  public boolean _vvvvvvvvvvvvvvvvvvvvvv0(int paramInt, String[] paramArrayOfString)
    throws Exception
  {
    if (paramInt < 0);
    for (int i = 0; ; i = paramInt)
    {
      if (i > this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getSize())
      {
        _vvvvvvvvvvvvvvvvvvv6(paramArrayOfString);
        return true;
      }
      _sv_scrollchanged(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getHorizontalScrollPosition(), this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getVerticalScrollPosition());
      List localList = new List();
      localList.Initialize();
      localList.Add(paramArrayOfString);
      int j = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv2.getSize() - 1;
      int k = 0;
      int i1;
      label102: int i2;
      if (k > j)
      {
        int n = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1;
        i1 = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0;
        if (i1 <= n)
          break label341;
        this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.AddAllAt(i, localList);
        _sv_scrollchanged(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getHorizontalScrollPosition(), this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getVerticalScrollPosition());
        i2 = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1;
      }
      for (int i3 = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0; ; i3 = 1 + (i3 + 0))
      {
        if (i3 > i2)
        {
          this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getPanel().setHeight(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getSize() * this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6);
          _vvvvvvvvvvvvvvvvvvvvvvvvvv7();
          int i4 = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getHorizontalScrollPosition();
          _sv_scrollchanged(i4, (int)Common.Min(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getVerticalScrollPosition(), this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getPanel().getHeight()));
          if (this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv6.IsInitialized())
          {
            boolean bool = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7;
            if (!bool)
              _setvvvvvvvvvvvvvvvvvvvvvvvvvvvv6(BA.NumberToString(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getSize()) + " rows");
          }
          return false;
          int m = (int)BA.ObjectToNumber(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv2.Get(k));
          if (m >= i)
            this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv2.Set(k, Integer.valueOf(m + 1));
          k = 1 + (k + 0);
          break;
          label341: _vvvvvvvvvvvvvvvvvvvvvv6(i1);
          i1 = 1 + (i1 + 0);
          break label102;
        }
        _vvvvvvvvvvvvvvvvvvvvvvvvvv3(i3);
      }
    }
  }

  public String _vvvvvvvvvvvvvvvvvvvvvv3(int paramInt1, int paramInt2)
    throws Exception
  {
    Arrays.fill(new String[0], "");
    return ((String[])(String[])this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get(paramInt2))[paramInt1];
  }

  public String[] _vvvvvvvvvvvvvvvvvvvvvv4(int paramInt)
    throws Exception
  {
    String[] arrayOfString1 = (String[])this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get(paramInt);
    String[] arrayOfString2 = new String[this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4];
    Arrays.fill(arrayOfString2, "");
    int i = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 - 1;
    for (int j = 0; ; j = 1 + (j + 0))
    {
      if (j > i)
        return arrayOfString2;
      arrayOfString2[j] = arrayOfString1[j];
    }
  }

  public String _vvvvvvvvvvvvvvvvvvvvvv5(int paramInt)
    throws Exception
  {
    int[] arrayOfInt = new int[this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.length];
    int i = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.length - 1;
    for (int j = 0; ; j = 1 + (j + 0))
    {
      if (j > i)
      {
        arrayOfInt[paramInt] = 1;
        _vvvvvvvvvvvvvvvvvvvvvvvv4(arrayOfInt);
        return "";
      }
      arrayOfInt[j] = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1[j];
    }
  }

  public String _vvvvvvvvvvvvvvvvvvvvvv6(int paramInt)
    throws Exception
  {
    LabelWrapper[] arrayOfLabelWrapper1 = new LabelWrapper[0];
    int i = arrayOfLabelWrapper1.length;
    for (int j = 0; j < i; j++)
      arrayOfLabelWrapper1[j] = new LabelWrapper();
    LabelWrapper[] arrayOfLabelWrapper2 = (LabelWrapper[])this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.Get(Integer.valueOf(paramInt));
    if (arrayOfLabelWrapper2 == null)
    {
      Common.Log("HideRow: (null) " + BA.NumberToString(paramInt));
      return "";
    }
    int k = arrayOfLabelWrapper2.length - 1;
    for (int m = 0; ; m = 1 + (m + 0))
    {
      if (m > k)
      {
        this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.Remove(Integer.valueOf(paramInt));
        this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.Add(arrayOfLabelWrapper2);
        return "";
      }
      arrayOfLabelWrapper2[m].RemoveView();
    }
  }

  public String _vvvvvvvvvvvvvvvvvvvvvv7(int paramInt)
    throws Exception
  {
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv2.Initialize();
    for (int i = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getPanel().getNumberOfViews() - 1; i >= 0; i = -1 + (i + 0))
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getPanel().RemoveViewAt(i);
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = paramInt;
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = new Object[this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4];
    int j = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.length;
    for (int k = 0; k < j; k++)
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6[k] = new Object();
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = new Object[this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4];
    int m = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.length;
    for (int n = 0; n < m; n++)
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7[n] = new Object();
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = new Object[this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4];
    int i1 = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.length;
    for (int i2 = 0; i2 < i1; i2++)
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5[i2] = new Object();
    int i3 = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 - 1;
    int i4 = 0;
    if (i4 > i3)
    {
      ColorDrawable localColorDrawable1 = new ColorDrawable();
      localColorDrawable1.Initialize(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4, 0);
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = localColorDrawable1.getObject();
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getPanel().setHeight(0);
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = -1;
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = -1;
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = 0;
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Initialize();
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.Initialize();
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.Initialize();
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.setVerticalScrollPosition(0);
      Common.DoEvents();
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.setVerticalScrollPosition(0);
    }
    for (int i5 = 1; ; i5 = 1 + (i5 + 0))
    {
      if (i5 > 80)
      {
        if (this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2)
          _sv_scrollchanged(0, 0);
        if (this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv6.IsInitialized())
        {
          boolean bool = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7;
          if (!bool)
            _setvvvvvvvvvvvvvvvvvvvvvvvvvvvv6(BA.NumberToString(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getSize()) + " rows");
        }
        return "";
        ColorDrawable localColorDrawable2 = new ColorDrawable();
        ColorDrawable localColorDrawable3 = new ColorDrawable();
        ColorDrawable localColorDrawable4 = new ColorDrawable();
        localColorDrawable2.Initialize(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1, 0);
        localColorDrawable3.Initialize(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2, 0);
        localColorDrawable4.Initialize(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3, 0);
        this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6[i4] = localColorDrawable2.getObject();
        this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7[i4] = localColorDrawable3.getObject();
        this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5[i4] = localColorDrawable4.getObject();
        i4 = 1 + (i4 + 0);
        break;
      }
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.Add(_vvvvvvvvvvvvvvvvvvvv3());
    }
  }

  public String _vvvvvvvvvvvvvvvvvvvvvvv0(String paramString1, String paramString2)
    throws Exception
  {
    String[] arrayOfString = new String[this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4];
    Arrays.fill(arrayOfString, "");
    int i = arrayOfString.length - 1;
    for (int j = 0; ; j = 1 + (j + 0))
    {
      if (j > i)
      {
        StringUtils.SaveCSV2(paramString1, paramString2, BA.ObjectToChar(","), this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6, Common.ArrayToList(arrayOfString));
        return "";
      }
      LabelWrapper localLabelWrapper = new LabelWrapper();
      localLabelWrapper.setObject((TextView)this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.GetView(j).getObject());
      arrayOfString[j] = localLabelWrapper.getText();
    }
  }

  public String _vvvvvvvvvvvvvvvvvvvvvvv1(int paramInt)
    throws Exception
  {
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.setVerticalScrollPosition(paramInt * this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6);
    return "";
  }

  public String _vvvvvvvvvvvvvvvvvvvvvvv2(SQL paramSQL, String paramString, boolean paramBoolean)
    throws Exception
  {
    SQL.CursorWrapper localCursorWrapper = new SQL.CursorWrapper();
    localCursorWrapper.setObject(paramSQL.ExecQuery(paramString));
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = localCursorWrapper.getColumnCount();
    _vvvvvvvvvvvvvvvvvvvvvv7(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4);
    String[] arrayOfString1 = new String[this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4];
    Arrays.fill(arrayOfString1, "");
    int[] arrayOfInt = new int[this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4];
    int i = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 - 1;
    int j = 0;
    int i1;
    if (j > i)
    {
      _vvvvvvvvvvvvvvvvvvvvvvvv5(arrayOfString1);
      _vvvvvvvvvvvvvvvvvvvvvvvv4(arrayOfInt);
      i1 = localCursorWrapper.getRowCount() - 1;
    }
    String[] arrayOfString2;
    int i4;
    for (int i2 = 0; ; i2 = 1 + (i2 + 0))
    {
      if (i2 > i1)
      {
        localCursorWrapper.Close();
        return "";
        arrayOfString1[j] = localCursorWrapper.GetColumnName(j);
        if (!paramBoolean)
        {
          arrayOfInt[j] = Common.DipToCurrent(130);
          j = 1 + (j + 0);
          break;
        }
        CanvasWrapper localCanvasWrapper1 = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6;
        String str1 = arrayOfString1[j];
        int k = (int)localCanvasWrapper1.MeasureStringWidth(str1, TypefaceWrapper.DEFAULT, this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3);
        int m = localCursorWrapper.getRowCount() - 1;
        for (int n = 0; ; n = 1 + (n + 0))
        {
          if (n > m)
          {
            arrayOfInt[j] = (k + Common.DipToCurrent(8));
            break;
          }
          localCursorWrapper.setPosition(n);
          String str2 = localCursorWrapper.GetString2(j);
          if (str2 != null)
          {
            double d = k;
            CanvasWrapper localCanvasWrapper2 = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6;
            k = (int)Common.Max(d, localCanvasWrapper2.MeasureStringWidth(str2, TypefaceWrapper.DEFAULT, this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3));
          }
        }
      }
      arrayOfString2 = new String[this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4];
      Arrays.fill(arrayOfString2, "");
      int i3 = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 - 1;
      i4 = 0;
      if (i4 <= i3)
        break label379;
      _vvvvvvvvvvvvvvvvvvv6(arrayOfString2);
    }
    label379: localCursorWrapper.setPosition(i2);
    String str3 = localCursorWrapper.GetString2(i4);
    if (str3 != null)
      arrayOfString2[i4] = str3;
    while (true)
    {
      i4 = 1 + (i4 + 0);
      break;
      arrayOfString2[i4] = "";
    }
  }

  public String _vvvvvvvvvvvvvvvvvvvvvvv3(String paramString1, String paramString2, boolean paramBoolean)
    throws Exception
  {
    new List();
    Arrays.fill(new String[0], "");
    List localList1;
    List localList2;
    String[] arrayOfString1;
    int j;
    Object localObject;
    int k;
    if (paramBoolean)
    {
      localList1 = new List();
      localList2 = StringUtils.LoadCSV2(paramString1, paramString2, BA.ObjectToChar(","), localList1);
      arrayOfString1 = new String[localList1.getSize()];
      Arrays.fill(arrayOfString1, "");
      int i = localList1.getSize() - 1;
      j = 0;
      if (j > i)
      {
        localObject = arrayOfString1;
        _vvvvvvvvvvvvvvvvvvvvvv7(localObject.length);
        this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = ((int)(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getWidth() / this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4));
        _vvvvvvvvvvvvvvvvvvvvvvvv5((String[])localObject);
        k = localList2.getSize() - 1;
      }
    }
    for (int m = 0; ; m = 1 + (m + 0))
    {
      if (m > k)
      {
        return "";
        arrayOfString1[j] = BA.ObjectToString(localList1.Get(j));
        j = 1 + (j + 0);
        break;
        localList2 = StringUtils.LoadCSV(paramString1, paramString2, BA.ObjectToChar(","));
        Arrays.fill(new String[0], "");
        String[] arrayOfString2 = (String[])localList2.Get(0);
        String[] arrayOfString3 = new String[arrayOfString2.length];
        Arrays.fill(arrayOfString3, "");
        int n = arrayOfString2.length - 1;
        for (int i1 = 0; ; i1 = 1 + (i1 + 0))
        {
          if (i1 > n)
          {
            localObject = arrayOfString3;
            break;
          }
          arrayOfString3[i1] = ("Col" + BA.NumberToString(i1 + 1));
        }
      }
      Arrays.fill(new String[0], "");
      _vvvvvvvvvvvvvvvvvvv6((String[])localList2.Get(m));
    }
  }

  public int _vvvvvvvvvvvvvvvvvvvvvvv4(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    throws Exception
  {
    Arrays.fill(new String[0], "");
    String str1 = ((String[])(String[])this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get(paramInt3))[paramInt4];
    _vvvvvvvvvvvvvvvvvvvvvvvvvv6(paramInt3, paramInt2);
    int i = paramInt2 - 1;
    int j = paramInt1;
    int k = paramInt1;
    if (j > i)
    {
      _vvvvvvvvvvvvvvvvvvvvvvvvvv6(k, paramInt2);
      return k;
    }
    String str2 = ((String[])(String[])this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get(j))[paramInt4];
    int m;
    if (paramBoolean)
    {
      if (str2.compareTo(str1) >= 0)
        break label157;
      _vvvvvvvvvvvvvvvvvvvvvvvvvv6(j, k);
      m = k + 1;
    }
    while (true)
    {
      j = 1 + (j + 0);
      k = m;
      break;
      if (str2.compareTo(str1) > 0)
      {
        _vvvvvvvvvvvvvvvvvvvvvvvvvv6(j, k);
        m = k + 1;
      }
      else
      {
        label157: m = k;
      }
    }
  }

  public String _vvvvvvvvvvvvvvvvvvvvvvv5(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    throws Exception
  {
    this._debug_counter = (1L + this._debug_counter);
    Common.Log("counter=" + BA.NumberToString(this._debug_counter));
    if (paramInt2 > paramInt1)
    {
      int i = _vvvvvvvvvvvvvvvvvvvvvvv4(paramInt1, paramInt2, Common.Rnd(paramInt1, paramInt2 + 1), paramInt3, paramBoolean);
      _vvvvvvvvvvvvvvvvvvvvvvv5(paramInt1, i - 1, paramInt3, paramBoolean);
      _vvvvvvvvvvvvvvvvvvvvvvv5(i + 1, paramInt2, paramInt3, paramBoolean);
    }
    return "";
  }

  public String _vvvvvvvvvvvvvvvvvvvvvvv6()
    throws Exception
  {
    _sv_scrollchanged(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getHorizontalScrollPosition(), this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getVerticalScrollPosition());
    int i = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1;
    for (int j = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0; ; j = 1 + (j + 0))
    {
      if (j > i)
        return "";
      _vvvvvvvvvvvvvvvvvvvvvv6(j);
      _vvvvvvvvvvvvvvvvvvvvvvvvvv3(j);
    }
  }

  public String _vvvvvvvvvvvvvvvvvvvvvvv7(int paramInt)
    throws Exception
  {
    if ((paramInt < 0) || (paramInt > this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getSize() - 1))
      return "";
    _sv_scrollchanged(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getHorizontalScrollPosition(), this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getVerticalScrollPosition());
    int i = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv2.IndexOf(Integer.valueOf(paramInt));
    int j = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv2.getSize() - 1;
    int k = 0;
    int i1;
    label105: int i2;
    if (k > j)
    {
      if (i != -1)
        this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv2.RemoveAt(i);
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.RemoveAt(paramInt);
      int n = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1;
      i1 = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0;
      if (i1 <= n)
        break label363;
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = ((int)Common.Min(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1, this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getSize() - 1));
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = ((int)Common.Min(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0, this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getSize() - 1));
      i2 = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1;
    }
    for (int i3 = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0; ; i3 = 1 + (i3 + 0))
    {
      if (i3 > i2)
      {
        this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getPanel().setHeight(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getSize() * this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6);
        _vvvvvvvvvvvvvvvvvvvvvvvvvv7();
        int i4 = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getHorizontalScrollPosition();
        _sv_scrollchanged(i4, (int)Common.Min(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getVerticalScrollPosition(), this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getPanel().getHeight()));
        if (this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv6.IsInitialized())
        {
          boolean bool = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7;
          if (!bool)
            _setvvvvvvvvvvvvvvvvvvvvvvvvvvvv6(BA.NumberToString(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getSize()) + " rows");
        }
        return "";
        int m = (int)BA.ObjectToNumber(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv2.Get(k));
        if (m > paramInt)
          this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv2.Set(k, Integer.valueOf(m - 1));
        k = 1 + (k + 0);
        break;
        label363: _vvvvvvvvvvvvvvvvvvvvvv6(i1);
        i1 = 1 + (i1 + 0);
        break label105;
      }
      _vvvvvvvvvvvvvvvvvvvvvvvvvv3(i3);
    }
  }

  public String _vvvvvvvvvvvvvvvvvvvvvvvv1(int paramInt, boolean paramBoolean)
    throws Exception
  {
    int i = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getSize() - 1;
    int m;
    int n;
    for (int j = 0; ; j = 1 + (j + 0))
    {
      if (j > i)
        return "";
      int k = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getSize() - 1;
      m = j + 1;
      n = j;
      if (m <= k)
        break;
      _vvvvvvvvvvvvvvvvvvvvvvvvvv6(j, n);
    }
    String str1 = ((String[])(String[])this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get(m))[paramInt];
    String str2 = ((String[])(String[])this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get(n))[paramInt];
    int i1;
    if (paramBoolean)
    {
      if (str1.compareTo(str2) >= 0)
        break label158;
      i1 = m;
    }
    while (true)
    {
      m = 1 + (m + 0);
      n = i1;
      break;
      if (str1.compareTo(str2) > 0)
        i1 = m;
      else
        label158: i1 = n;
    }
  }

  public String _vvvvvvvvvvvvvvvvvvvvvvvv2(_rowcol param_rowcol)
    throws Exception
  {
    int i = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv2.IndexOf(Integer.valueOf(param_rowcol.Row));
    if (i != -1)
    {
      boolean bool = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0;
      if (!bool)
      {
        this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = param_rowcol.Col;
        if (this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.ContainsKey(Integer.valueOf(param_rowcol.Row)))
        {
          _vvvvvvvvvvvvvvvvvvvvvv6(param_rowcol.Row);
          _vvvvvvvvvvvvvvvvvvvvvvvvvv3(param_rowcol.Row);
        }
        return "";
      }
    }
    int k;
    if (i == -1)
      if (this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0)
      {
        this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv2.Add(Integer.valueOf(param_rowcol.Row));
        k = -1;
      }
    while (true)
    {
      if ((k > -1) && (this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.ContainsKey(Integer.valueOf(param_rowcol.Row))))
      {
        _vvvvvvvvvvvvvvvvvvvvvv6(k);
        _vvvvvvvvvvvvvvvvvvvvvvvvvv3(k);
      }
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = param_rowcol.Col;
      if (this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.ContainsKey(Integer.valueOf(param_rowcol.Row)))
      {
        _vvvvvvvvvvvvvvvvvvvvvv6(param_rowcol.Row);
        _vvvvvvvvvvvvvvvvvvvvvvvvvv3(param_rowcol.Row);
      }
      return "";
      if (this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv2.getSize() != 0)
      {
        k = (int)BA.ObjectToNumber(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv2.Get(0));
        this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv2.Set(0, Integer.valueOf(param_rowcol.Row));
      }
      else
      {
        this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv2.Add(Integer.valueOf(param_rowcol.Row));
        k = -1;
        continue;
        int j = (int)BA.ObjectToNumber(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv2.Get(i));
        this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv2.RemoveAt(i);
        k = j;
      }
    }
  }

  public String _vvvvvvvvvvvvvvvvvvvvvvvv4(int[] paramArrayOfInt)
    throws Exception
  {
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = new int[paramArrayOfInt.length];
    int i = paramArrayOfInt.length - 1;
    int j = 0;
    int k;
    if (j > i)
    {
      new ConcreteViewWrapper();
      k = paramArrayOfInt.length - 1;
    }
    for (int m = 0; ; m = 1 + (m + 0))
    {
      if (m > k)
      {
        this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.setWidth(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.GetView(paramArrayOfInt.length - 1).getLeft() + paramArrayOfInt[(paramArrayOfInt.length - 1)]);
        this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getPanel().setWidth(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.getWidth());
        LabelWrapper[] arrayOfLabelWrapper1 = new LabelWrapper[0];
        int i2 = arrayOfLabelWrapper1.length;
        for (int i3 = 0; i3 < i2; i3++)
          arrayOfLabelWrapper1[i3] = new LabelWrapper();
        this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1[j] = paramArrayOfInt[j];
        j = 1 + (j + 0);
        break;
      }
      ConcreteViewWrapper localConcreteViewWrapper = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.GetView(m);
      int n = paramArrayOfInt[m];
      localConcreteViewWrapper.setWidth(n - Common.DipToCurrent(1));
      if (m > 0)
      {
        int i1 = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.GetView(m - 1).getLeft() + paramArrayOfInt[(m - 1)];
        localConcreteViewWrapper.setLeft(i1 + Common.DipToCurrent(1));
      }
    }
    int i4 = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.getSize() - 1;
    int i5 = 0;
    if (i5 > i4)
    {
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv6.setWidth(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.getWidth());
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.setWidth(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.getWidth());
      return "";
    }
    LabelWrapper[] arrayOfLabelWrapper2 = (LabelWrapper[])this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.GetValueAt(i5);
    int i6 = arrayOfLabelWrapper2.length - 1;
    for (int i7 = 0; ; i7 = 1 + (i7 + 0))
    {
      if (i7 > i6)
      {
        i5 = 1 + (i5 + 0);
        break;
      }
      arrayOfLabelWrapper2[i7].SetLayout(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.GetView(i7).getLeft(), arrayOfLabelWrapper2[i7].getTop(), this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.GetView(i7).getWidth(), this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6);
    }
  }

  public String _vvvvvvvvvvvvvvvvvvvvvvvv5(String[] paramArrayOfString)
    throws Exception
  {
    for (int i = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.getNumberOfViews() - 1; i >= 0; i = -1 + (i + 0))
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.RemoveViewAt(i);
    int j = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 - 1;
    for (int k = 0; ; k = 1 + (k + 0))
    {
      if (k > j)
        return "";
      LabelWrapper localLabelWrapper = new LabelWrapper();
      localLabelWrapper.Initialize(this.ba, "header");
      localLabelWrapper.setGravity(17);
      localLabelWrapper.setTextSize(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3);
      localLabelWrapper.setColor(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7);
      localLabelWrapper.setTextColor(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2);
      localLabelWrapper.setText(paramArrayOfString[k]);
      localLabelWrapper.setTag(Integer.valueOf(k));
      PanelWrapper localPanelWrapper = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv2;
      View localView = (View)localLabelWrapper.getObject();
      int m = k * this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5;
      int n = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5;
      localPanelWrapper.AddView(localView, m, 0, n - Common.DipToCurrent(1), this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6);
    }
  }

  public boolean _vvvvvvvvvvvvvvvvvvvvvvvvvv0(int paramInt, String[] paramArrayOfString)
    throws Exception
  {
    if ((paramArrayOfString.length != this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4) || (paramInt < 0) || (paramInt > this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getSize() - 1))
      return false;
    int i = paramArrayOfString.length - 1;
    for (int j = 0; ; j = 1 + (j + 0))
    {
      if (j > i)
        return true;
      _vvvvvvvvvvvvvvvvv3(j, paramInt, paramArrayOfString[j]);
    }
  }

  public String _vvvvvvvvvvvvvvvvvvvvvvvvvv2(int paramInt1, int paramInt2)
    throws Exception
  {
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.RemoveView();
    if (paramInt2 == 0)
      return "";
    if (paramInt2 == -1)
    {
      PanelWrapper localPanelWrapper2 = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6;
      localPanelWrapper2.SetBackgroundImage((Bitmap)Common.LoadBitmapSample(File.getDirAssets(), "sort_asc.png", 40, 40).getObject());
    }
    while (true)
    {
      new ConcreteViewWrapper();
      ConcreteViewWrapper localConcreteViewWrapper = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.GetView(paramInt1);
      int i = 6 + (localConcreteViewWrapper.getLeft() + localConcreteViewWrapper.getWidth() - 40);
      int j = 6 + (localConcreteViewWrapper.getTop() + localConcreteViewWrapper.getHeight() - 40);
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.AddView((View)this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getObject(), i, j, 40, 40);
      return "";
      PanelWrapper localPanelWrapper1 = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6;
      localPanelWrapper1.SetBackgroundImage((Bitmap)Common.LoadBitmapSample(File.getDirAssets(), "sort_desc.png", 40, 40).getObject());
    }
  }

  public String _vvvvvvvvvvvvvvvvvvvvvvvvvv3(int paramInt)
    throws Exception
  {
    if (this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.ContainsKey(Integer.valueOf(paramInt)))
      return "";
    LabelWrapper[] arrayOfLabelWrapper1 = new LabelWrapper[0];
    int i = arrayOfLabelWrapper1.length;
    for (int j = 0; j < i; j++)
      arrayOfLabelWrapper1[j] = new LabelWrapper();
    Arrays.fill(new String[0], "");
    LabelWrapper[] arrayOfLabelWrapper2 = _vvvvvvvvvvvvvvvvvvvv0(paramInt);
    String[] arrayOfString = (String[])this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get(paramInt);
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.Put(Integer.valueOf(paramInt), arrayOfLabelWrapper2);
    Object[] arrayOfObject1 = new Object[0];
    int k = arrayOfObject1.length;
    for (int m = 0; m < k; m++)
      arrayOfObject1[m] = new Object();
    Object[] arrayOfObject2;
    if (this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv2.IndexOf(Integer.valueOf(paramInt)) != -1)
      arrayOfObject2 = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5;
    int i1;
    while (true)
    {
      int n = arrayOfLabelWrapper2.length - 1;
      i1 = 0;
      if (i1 <= n)
        break;
      return "";
      if (paramInt % 2 == 0)
        arrayOfObject2 = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6;
      else
        arrayOfObject2 = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7;
    }
    if (this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.GetView(i1).getWidth() > 1)
    {
      PanelWrapper localPanelWrapper = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getPanel();
      View localView = (View)arrayOfLabelWrapper2[i1].getObject();
      int i2 = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.GetView(i1).getLeft();
      int i3 = paramInt * this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6;
      int i4 = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.GetView(i1).getWidth();
      int i5 = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6;
      localPanelWrapper.AddView(localView, i2, i3, i4, i5 - Common.DipToCurrent(1));
      arrayOfLabelWrapper2[i1].setText(arrayOfString[i1]);
      if ((i1 != this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv5) || (this._vvvvvvvvvvvvvvvvvvvvvvvvvvvv2.IndexOf(Integer.valueOf(paramInt)) == -1))
        break label372;
      arrayOfLabelWrapper2[i1].setBackground((Drawable)this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0);
    }
    while (true)
    {
      i1 = 1 + (i1 + 0);
      break;
      label372: arrayOfLabelWrapper2[i1].setBackground((Drawable)arrayOfObject2[i1]);
    }
  }

  public long _vvvvvvvvvvvvvvvvvvvvvvvvvv4()
    throws Exception
  {
    return this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getSize();
  }

  public String _vvvvvvvvvvvvvvvvvvvvvvvvvv5(int paramInt, boolean paramBoolean)
    throws Exception
  {
    Common.Log("sorting table for col:" + BA.NumberToString(paramInt));
    _vvvvvvvvvvvvvvvvvvvv2();
    this._debug_counter = 0L;
    _vvvvvvvvvvvvvvvvvvvvvvvv1(paramInt, paramBoolean);
    _vvvvvvvvvvvvvvvvvvvvvvv6();
    return "";
  }

  public String _vvvvvvvvvvvvvvvvvvvvvvvvvv6(int paramInt1, int paramInt2)
    throws Exception
  {
    new Object();
    Object localObject = this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get(paramInt1);
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Set(paramInt1, this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get(paramInt2));
    this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Set(paramInt2, localObject);
    return "";
  }

  public String _vvvvvvvvvvvvvvvvvvvvvvvvvv7()
    throws Exception
  {
    if (this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getHeight() > this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getSize() * this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6)
    {
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.setTop(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getSize() * this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 + this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6);
      this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.setHeight(this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getHeight() - (this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getSize() * this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 + this._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6));
    }
    return "";
  }

  public Object callSub(String paramString, Object paramObject, Object[] paramArrayOfObject)
    throws Exception
  {
    this.ba.sharedProcessBA.sender = paramObject;
    return BA.SubDelegator.SubNotFound;
  }

  public static class _rowcol
  {
    public int Col;
    public boolean IsInitialized;
    public int Row;

    public void Initialize()
    {
      this.IsInitialized = true;
      this.Row = 0;
      this.Col = 0;
    }

    public String toString()
    {
      return BA.TypeToString(this, false);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.misricalendar.hijrical.table
 * JD-Core Version:    0.6.2
 */