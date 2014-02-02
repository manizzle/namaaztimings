package com.misricalendar.hijrical;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.Window;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.B4AMenuItem;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.Msgbox;
import anywheresoftware.b4a.keywords.Bit;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.objects.ActivityWrapper;
import anywheresoftware.b4a.objects.B4AException;
import anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper;
import anywheresoftware.b4a.objects.EditTextWrapper;
import anywheresoftware.b4a.objects.PanelWrapper;
import anywheresoftware.b4a.objects.collections.List;
import anywheresoftware.b4a.sql.SQL;
import anywheresoftware.b4a.sql.SQL.CursorWrapper;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class qedit extends Activity
  implements B4AActivity
{
  public static int _vvvvvvvvvvvv1 = 0;
  public static int _vvvvvvvvvvvv2 = 0;
  public static int _vvvvvvvvvvvv3 = 0;
  static boolean afterFirstLayout = false;
  public static final boolean fullScreen = true;
  public static final boolean includeTitle = true;
  static boolean isFirst = true;
  public static qedit mostCurrent;
  public static WeakReference<Activity> previousOne;
  public static BA processBA;
  private static boolean processGlobalsRun = false;
  public Common __c = null;
  ActivityWrapper _activity;
  public CompoundButtonWrapper.RadioButtonWrapper _optn = null;
  public CompoundButtonWrapper.RadioButtonWrapper _opto = null;
  public CompoundButtonWrapper.RadioButtonWrapper _optr = null;
  public PanelWrapper _pnltable = null;
  public EditTextWrapper _txtday = null;
  public EditTextWrapper _txtdesc = null;
  public EditTextWrapper _txtmonth = null;
  public EditTextWrapper _txtyear = null;
  public datecon _vvvvvvvvvvvvvvv0 = null;
  public main _vvvvvvvvvvvvvvv7 = null;
  public suntime _vvvvvvvvvvvvvvvv1 = null;
  public hcalsrvc _vvvvvvvvvvvvvvvv2 = null;
  public gl _vvvvvvvvvvvvvvvv3 = null;
  public settings _vvvvvvvvvvvvvvvv4 = null;
  public qibla _vvvvvvvvvvvvvvvv5 = null;
  public table _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = null;
  BA activityBA;
  BALayout layout;
  ArrayList<B4AMenuItem> menuItems;
  private Boolean onKeySubExist = null;
  private Boolean onKeyUpSubExist = null;

  public static String _activity_create(boolean paramBoolean)
    throws Exception
  {
    mostCurrent._activity.LoadLayout("Qedit", mostCurrent.activityBA);
    table localtable1 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6;
    BA localBA = mostCurrent.activityBA;
    Class localClass = getObject();
    localtable1._initialize(localBA, localClass, "Table1", 6, 1, true);
    table localtable2 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6;
    localtable2._setvvvvvvvvvvvvvvvvvvvvvvvvvvv1(Bit.Or(3, 16));
    table localtable3 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6;
    localtable3._setvvvvvvvvvvvvvvvvvvvvvvvvvvv2(-16776961);
    table localtable4 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6;
    localtable4._setvvvvvvvvvvvvvvvvvvvvvvvvvvv4(-3355444);
    table localtable5 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6;
    localtable5._setvvvvvvvvvvvvvvvvvvvvvvvvvvvv4(-12303292);
    table localtable6 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6;
    localtable6._setvvvvvvvvvvvvvvvvvvvvvvvvvvvv3(-3355444);
    mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6._setvvvvvvvvvvvvvvvvvvvvvvvvvvv0(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6._getvvvvvvvvvvvvvvvvvvvvvvvvvvvv1());
    mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6._vvvvvvvvvvvvvvvvvvv7((ActivityWrapper)AbsObjectWrapper.ConvertToWrapper(new ActivityWrapper(), (BALayout)mostCurrent._pnltable.getObject()), 0, 0, mostCurrent._pnltable.getWidth(), mostCurrent._pnltable.getHeight());
    mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6._setvvvvvvvvvvvvvvvvvvvvvvvvvvv5(false);
    return "";
  }

  public static String _activity_pause(boolean paramBoolean)
    throws Exception
  {
    return "";
  }

  public static String _activity_resume()
    throws Exception
  {
    _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7();
    return "";
  }

  public static String _btndelete_click()
    throws Exception
  {
    if (_vvvvvvvvvvvv1 <= 0)
      return "";
    String str = "Delete from Events where id = " + BA.NumberToString(_vvvvvvvvvvvv1);
    try
    {
      gl._vvvvv7.ExecNonQuery(str);
      mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6._vvvvvvvvvvvvvvvvvvvvvvv7(_vvvvvvvvvvvv2);
      _vvvvvvvvvvvv2 = -1;
      _vvvvvvvvvvvv1 = -1;
      return "";
    }
    catch (Exception localException)
    {
      processBA.setLastException(localException);
      Common.ToastMessageShow("DeleteRecord Error" + Common.LastException(mostCurrent.activityBA).getMessage(), true);
    }
    return "";
  }

  public static String _btnreload_click()
    throws Exception
  {
    _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7();
    _vvvvvvvvvvvv1 = -1;
    _vvvvvvvvvvvv2 = -1;
    return "";
  }

  public static String _btnsavenew_click()
    throws Exception
  {
    _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1(true);
    mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6._vvvvvvvvvvvvvvvvvvvv2();
    return "";
  }

  public static String _btnupdate_click()
    throws Exception
  {
    if (_vvvvvvvvvvvv2 < 0)
      return "";
    _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1(false);
    return "";
  }

  public static String _globals()
    throws Exception
  {
    mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = new table();
    mostCurrent._pnltable = new PanelWrapper();
    mostCurrent._txtday = new EditTextWrapper();
    mostCurrent._txtmonth = new EditTextWrapper();
    mostCurrent._txtyear = new EditTextWrapper();
    mostCurrent._txtdesc = new EditTextWrapper();
    mostCurrent._optr = new CompoundButtonWrapper.RadioButtonWrapper();
    mostCurrent._optn = new CompoundButtonWrapper.RadioButtonWrapper();
    mostCurrent._opto = new CompoundButtonWrapper.RadioButtonWrapper();
    return "";
  }

  public static String _process_globals()
    throws Exception
  {
    _vvvvvvvvvvvv1 = -1;
    _vvvvvvvvvvvv2 = 0;
    _vvvvvvvvvvvv3 = 0;
    return "";
  }

  public static String _table1_cellclick(int paramInt1, int paramInt2)
    throws Exception
  {
    _vvvvvvvvvvvv2 = paramInt2;
    Common.Log(BA.NumberToString(_vvvvvvvvvvvv2));
    Common.Log(BA.ObjectToString(Boolean.valueOf(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6._getvvvvvvvvvvvvvvvvvvvvvvvvvvv5())));
    Common.Log(BA.NumberToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6._vvvvvvvvvvvvvvvvvvvvvvvvvvvv2.getSize()));
    _vvvvvvvvvvvv1 = (int)Double.parseDouble(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6._vvvvvvvvvvvvvvvvvvvvvv3(5, _vvvvvvvvvvvv2));
    if (_vvvvvvvvvvvv2 > -1)
    {
      mostCurrent._txtmonth.setText(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6._vvvvvvvvvvvvvvvvvvvvvv3(0, _vvvvvvvvvvvv2));
      mostCurrent._txtday.setText(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6._vvvvvvvvvvvvvvvvvvvvvv3(1, _vvvvvvvvvvvv2));
      mostCurrent._txtdesc.setText(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6._vvvvvvvvvvvvvvvvvvvvvv3(2, _vvvvvvvvvvvv2));
      mostCurrent._txtyear.setText(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6._vvvvvvvvvvvvvvvvvvvvvv3(3, _vvvvvvvvvvvv2));
      switch ((int)Double.parseDouble(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6._vvvvvvvvvvvvvvvvvvvvvv3(4, _vvvvvvvvvvvv2)))
      {
      default:
        mostCurrent._opto.setChecked(true);
      case 1:
      case 2:
      }
    }
    while (true)
    {
      return "";
      mostCurrent._optr.setChecked(true);
      continue;
      mostCurrent._optn.setChecked(true);
    }
  }

  public static String _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1(boolean paramBoolean)
    throws Exception
  {
    SQL.CursorWrapper localCursorWrapper = new SQL.CursorWrapper();
    String[] arrayOfString = new String[6];
    Arrays.fill(arrayOfString, "");
    if (paramBoolean);
    for (int i = 0; (i == 0) && (!paramBoolean); i = _vvvvvvvvvvvv1)
      return "";
    int j;
    int k;
    if (Common.IsNumber(mostCurrent._txtday.getText()))
    {
      j = (int)Double.parseDouble(mostCurrent._txtday.getText());
      if (!Common.IsNumber(mostCurrent._txtmonth.getText()))
        break label182;
      k = (int)Double.parseDouble(mostCurrent._txtmonth.getText());
      label104: if (!Common.IsNumber(mostCurrent._txtyear.getText()))
        break label188;
    }
    label182: label188: for (int m = (int)Double.parseDouble(mostCurrent._txtyear.getText()); ; m = 0)
    {
      if ((j > 0) && (j <= 31) && (k > 0) && (k <= 12))
        break label194;
      Common.Msgbox("invalid day/month entry", "Hijrical", mostCurrent.activityBA);
      return "";
      j = 1;
      break;
      k = 1;
      break label104;
    }
    label194: int n;
    String str1;
    int i2;
    int i3;
    label269: String str4;
    if (mostCurrent._optr.getChecked() == true)
    {
      n = 1;
      str1 = mostCurrent._txtdesc.getText().replace("'", "`");
      if (paramBoolean != true)
        break label555;
      localCursorWrapper.setObject(gl._vvvvv7.ExecQuery("select max(id) from events"));
      int i1 = localCursorWrapper.getRowCount() - 1;
      i2 = i;
      i3 = 0;
      if (i3 <= i1)
        break label531;
      localCursorWrapper.Close();
      int i4 = i2 + 1;
      String str5 = "insert into events(id,day,month,year,cal_type,event_type,description) values(" + BA.NumberToString(i4) + "," + BA.NumberToString(j) + "," + BA.NumberToString(k) + "," + BA.NumberToString(m) + "," + BA.NumberToString(_vvvvvvvvvvvv3) + "," + BA.NumberToString(n) + ", '" + str1 + "')";
      i = i4;
      str4 = str5;
    }
    while (true)
    {
      try
      {
        gl._vvvvv7.ExecNonQuery(str4);
        arrayOfString[0] = BA.NumberToString(k);
        arrayOfString[1] = BA.NumberToString(j);
        arrayOfString[2] = str1;
        arrayOfString[3] = BA.NumberToString(m);
        arrayOfString[4] = BA.NumberToString(n);
        arrayOfString[5] = BA.NumberToString(i);
        if (paramBoolean)
        {
          mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6._vvvvvvvvvvvvvvvvvvv6(arrayOfString);
          Common.DoEvents();
          mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6._vvvvvvvvvvvvvvvvvvvvvvv1(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6._vvvvvvvvvvvvvvvvvvvvv4());
          return "";
          if (mostCurrent._optn.getChecked() == true)
          {
            n = 2;
            break;
          }
          n = 0;
          break;
          label531: localCursorWrapper.setPosition(i3);
          i2 = localCursorWrapper.GetInt2(0);
          i3 = 1 + (i3 + 0);
          break label269;
          label555: String str2 = "update events set day =" + BA.NumberToString(j) + ", month =" + BA.NumberToString(k) + ", year=" + BA.NumberToString(m);
          String str3 = str2 + ", cal_type=" + BA.NumberToString(_vvvvvvvvvvvv3) + ", event_type=" + BA.NumberToString(n) + ", description = '" + str1 + "'";
          str4 = str3 + " where id = " + BA.NumberToString(i);
          continue;
        }
      }
      catch (Exception localException)
      {
        processBA.setLastException(localException);
        Common.ToastMessageShow("SaveRecord Error" + Common.LastException(mostCurrent.activityBA).getMessage(), true);
        return "";
      }
      mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6._vvvvvvvvvvvvvvvvvvvvvvvvvv0(_vvvvvvvvvvvv2, arrayOfString);
    }
  }

  public static String _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7()
    throws Exception
  {
    mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6._vvvvvvvvvvvvvvvvvvvv1();
    String str = "SELECT month as mo,day,description,year,event_type as evt,id FROM events where cal_type = " + BA.NumberToString(_vvvvvvvvvvvv3) + " order by month,day,description";
    table localtable = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6;
    localtable._vvvvvvvvvvvvvvvvvvvvvvv2(gl._vvvvv7, str, true);
    mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6._vvvvvvvvvvvvvvvvvvvvvv5(5);
    return "";
  }

  private void afterFirstLayout()
  {
    if (this != mostCurrent);
    do
    {
      do
      {
        return;
        this.activityBA = new BA(this, this.layout, processBA, "com.misricalendar.hijrical", "com.misricalendar.hijrical.qedit");
        processBA.sharedProcessBA.activityBA = new WeakReference(this.activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        this._activity = new ActivityWrapper(this.activityBA, "activity");
        Msgbox.isDismissing = false;
        if (BA.shellMode)
        {
          if (isFirst)
            processBA.raiseEvent2(null, true, "SHELL", false, new Object[0]);
          BA localBA2 = processBA;
          Object[] arrayOfObject2 = new Object[5];
          arrayOfObject2[0] = "com.misricalendar.hijrical.qedit";
          arrayOfObject2[1] = processBA;
          arrayOfObject2[2] = this.activityBA;
          arrayOfObject2[3] = this._activity;
          arrayOfObject2[4] = Float.valueOf(Common.Density);
          localBA2.raiseEvent2(null, true, "CREATE", true, arrayOfObject2);
          this._activity.reinitializeForShell(this.activityBA, "activity");
        }
        initializeProcessGlobals();
        initializeGlobals();
        BA.LogInfo("** Activity (qedit) Create, isFirst = " + isFirst + " **");
        BA localBA1 = processBA;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Boolean.valueOf(isFirst);
        localBA1.raiseEvent2(null, true, "activity_create", false, arrayOfObject1);
        isFirst = false;
      }
      while (this != mostCurrent);
      processBA.setActivityPaused(false);
      BA.LogInfo("** Activity (qedit) Resume **");
      processBA.raiseEvent(null, "activity_resume", new Object[0]);
    }
    while (Build.VERSION.SDK_INT < 11);
    try
    {
      Activity.class.getMethod("invalidateOptionsMenu", new Class[0]).invoke(this, (Object[])null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public static Class<?> getObject()
  {
    return qedit.class;
  }

  private static void initializeGlobals()
  {
    processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
  }

  public static void initializeProcessGlobals()
  {
    try
    {
      Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals", new Class[0]).invoke(null, null);
      return;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  public void addMenuItem(B4AMenuItem paramB4AMenuItem)
  {
    if (this.menuItems == null)
      this.menuItems = new ArrayList();
    this.menuItems.add(paramB4AMenuItem);
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    processBA.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (isFirst)
    {
      processBA = new BA(getApplicationContext(), null, null, "com.misricalendar.hijrical", "com.misricalendar.hijrical.qedit");
      processBA.loadHtSubs(getClass());
      BALayout.setDeviceScale(getApplicationContext().getResources().getDisplayMetrics().density);
    }
    while (true)
    {
      getWindow().setFlags(1024, 1024);
      mostCurrent = this;
      processBA.sharedProcessBA.activityBA = null;
      this.layout = new BALayout(this);
      setContentView(this.layout);
      afterFirstLayout = false;
      BA.handler.postDelayed(new WaitForLayout(null), 5L);
      return;
      if (previousOne != null)
      {
        Activity localActivity = (Activity)previousOne.get();
        if ((localActivity != null) && (localActivity != this))
        {
          BA.LogInfo("Killing previous instance (qedit).");
          localActivity.finish();
        }
      }
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    super.onCreateOptionsMenu(paramMenu);
    if (this.menuItems == null)
      return false;
    Iterator localIterator = this.menuItems.iterator();
    while (true)
      if (localIterator.hasNext())
      {
        B4AMenuItem localB4AMenuItem = (B4AMenuItem)localIterator.next();
        MenuItem localMenuItem = paramMenu.add(localB4AMenuItem.title);
        if (localB4AMenuItem.drawable != null)
          localMenuItem.setIcon(localB4AMenuItem.drawable);
        if (Build.VERSION.SDK_INT >= 11);
        try
        {
          if (localB4AMenuItem.addToBar)
          {
            Class[] arrayOfClass = new Class[1];
            arrayOfClass[0] = Integer.TYPE;
            Method localMethod = MenuItem.class.getMethod("setShowAsAction", arrayOfClass);
            Object[] arrayOfObject = new Object[1];
            arrayOfObject[0] = Integer.valueOf(1);
            localMethod.invoke(localMenuItem, arrayOfObject);
          }
          localMenuItem.setOnMenuItemClickListener(new B4AMenuItemsClickListener(localB4AMenuItem.eventName.toLowerCase(BA.cul)));
        }
        catch (Exception localException)
        {
          while (true)
            localException.printStackTrace();
        }
      }
    return true;
  }

  public void onDestroy()
  {
    super.onDestroy();
    previousOne = null;
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.onKeySubExist == null)
      this.onKeySubExist = Boolean.valueOf(processBA.subExists("activity_keypress"));
    if (this.onKeySubExist.booleanValue())
    {
      if ((paramInt == 4) && (Build.VERSION.SDK_INT >= 18))
      {
        HandleKeyDelayed localHandleKeyDelayed = new HandleKeyDelayed(null);
        localHandleKeyDelayed.kc = paramInt;
        BA.handler.post(localHandleKeyDelayed);
        return true;
      }
      if (new HandleKeyDelayed(null).runDirectly(paramInt))
        return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.onKeyUpSubExist == null)
      this.onKeyUpSubExist = Boolean.valueOf(processBA.subExists("activity_keyup"));
    if (this.onKeyUpSubExist.booleanValue())
    {
      BA localBA = processBA;
      ActivityWrapper localActivityWrapper = this._activity;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      Boolean localBoolean = (Boolean)localBA.raiseEvent2(localActivityWrapper, false, "activity_keyup", false, arrayOfObject);
      if ((localBoolean == null) || (localBoolean.booleanValue() == true))
        return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }

  public void onNewIntent(Intent paramIntent)
  {
    setIntent(paramIntent);
  }

  public void onPause()
  {
    super.onPause();
    if (this._activity == null)
      return;
    Msgbox.dismiss(true);
    BA.LogInfo("** Activity (qedit) Pause, UserClosed = " + this.activityBA.activity.isFinishing() + " **");
    BA localBA = processBA;
    ActivityWrapper localActivityWrapper = this._activity;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Boolean.valueOf(this.activityBA.activity.isFinishing());
    localBA.raiseEvent2(localActivityWrapper, true, "activity_pause", false, arrayOfObject);
    processBA.setActivityPaused(true);
    mostCurrent = null;
    if (!this.activityBA.activity.isFinishing())
      previousOne = new WeakReference(this);
    Msgbox.isDismissing = false;
  }

  public void onResume()
  {
    super.onResume();
    mostCurrent = this;
    Msgbox.isDismissing = false;
    if (this.activityBA != null)
    {
      ResumeMessage localResumeMessage = new ResumeMessage(mostCurrent);
      BA.handler.post(localResumeMessage);
    }
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (processBA.subExists("activity_windowfocuschanged"))
    {
      BA localBA = processBA;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Boolean.valueOf(paramBoolean);
      localBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, arrayOfObject);
    }
  }

  private class B4AMenuItemsClickListener
    implements MenuItem.OnMenuItemClickListener
  {
    private final String eventName;

    public B4AMenuItemsClickListener(String arg2)
    {
      Object localObject;
      this.eventName = localObject;
    }

    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      qedit.processBA.raiseEvent(paramMenuItem.getTitle(), this.eventName + "_click", new Object[0]);
      return true;
    }
  }

  private class HandleKeyDelayed
    implements Runnable
  {
    int kc;

    private HandleKeyDelayed()
    {
    }

    public void run()
    {
      runDirectly(this.kc);
    }

    public boolean runDirectly(int paramInt)
    {
      BA localBA = qedit.processBA;
      ActivityWrapper localActivityWrapper = qedit.this._activity;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      Boolean localBoolean = (Boolean)localBA.raiseEvent2(localActivityWrapper, false, "activity_keypress", false, arrayOfObject);
      if ((localBoolean == null) || (localBoolean.booleanValue() == true))
        return true;
      if (paramInt == 4)
      {
        qedit.this.finish();
        return true;
      }
      return false;
    }
  }

  private static class ResumeMessage
    implements Runnable
  {
    private final WeakReference<Activity> activity;

    public ResumeMessage(Activity paramActivity)
    {
      this.activity = new WeakReference(paramActivity);
    }

    public void run()
    {
      if ((qedit.mostCurrent == null) || (qedit.mostCurrent != this.activity.get()))
        return;
      qedit.processBA.setActivityPaused(false);
      BA.LogInfo("** Activity (qedit) Resume **");
      qedit.processBA.raiseEvent(qedit.mostCurrent._activity, "activity_resume", (Object[])null);
    }
  }

  private static class WaitForLayout
    implements Runnable
  {
    public void run()
    {
      if (qedit.afterFirstLayout);
      while (qedit.mostCurrent == null)
        return;
      if (qedit.mostCurrent.layout.getWidth() == 0)
      {
        BA.handler.postDelayed(this, 5L);
        return;
      }
      qedit.mostCurrent.layout.getLayoutParams().height = qedit.mostCurrent.layout.getHeight();
      qedit.mostCurrent.layout.getLayoutParams().width = qedit.mostCurrent.layout.getWidth();
      qedit.afterFirstLayout = true;
      qedit.mostCurrent.afterFirstLayout();
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.misricalendar.hijrical.qedit
 * JD-Core Version:    0.6.2
 */