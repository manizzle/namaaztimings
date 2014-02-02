package com.misricalendar.hijrical;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.B4AMenuItem;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.Msgbox;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.keywords.Regex;
import anywheresoftware.b4a.keywords.StringBuilderWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper;
import anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper;
import anywheresoftware.b4a.objects.LabelWrapper;
import anywheresoftware.b4a.objects.PanelWrapper;
import anywheresoftware.b4a.objects.ScrollViewWrapper;
import anywheresoftware.b4a.objects.collections.Map;
import anywheresoftware.b4a.objects.streams.File;
import anywheresoftware.b4a.sql.SQL;
import barxdroid.NotificationBuilder.NotificationBuilder;
import edsmith.calendar.Calendar;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

public class settings extends Activity
  implements B4AActivity
{
  public static boolean _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = false;
  public static boolean _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = false;
  static boolean afterFirstLayout = false;
  public static final boolean fullScreen = true;
  public static final boolean includeTitle = true;
  static boolean isFirst = true;
  public static settings mostCurrent;
  public static WeakReference<Activity> previousOne;
  public static BA processBA;
  private static boolean processGlobalsRun = false;
  public Common __c = null;
  ActivityWrapper _activity;
  public CompoundButtonWrapper.CheckBoxWrapper _chknotification = null;
  public CompoundButtonWrapper.CheckBoxWrapper _chkshow12hr = null;
  public LabelWrapper _lbldefgmt = null;
  public LabelWrapper _lbldefloc = null;
  public PanelWrapper _pnlsettings = null;
  public CompoundButtonWrapper.RadioButtonWrapper _rbusedefgmt = null;
  public CompoundButtonWrapper.RadioButtonWrapper _rbusedefloc = null;
  public CompoundButtonWrapper.RadioButtonWrapper _rbusedevgmt = null;
  public CompoundButtonWrapper.RadioButtonWrapper _rbusedevloc = null;
  public datecon _vvvvvvvvvvvvvvv0 = null;
  public main _vvvvvvvvvvvvvvv7 = null;
  public suntime _vvvvvvvvvvvvvvvv1 = null;
  public hcalsrvc _vvvvvvvvvvvvvvvv2 = null;
  public gl _vvvvvvvvvvvvvvvv3 = null;
  public qibla _vvvvvvvvvvvvvvvv5 = null;
  public qedit _vvvvvvvvvvvvvvvv6 = null;
  public ScrollViewWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = null;
  BA activityBA;
  BALayout layout;
  ArrayList<B4AMenuItem> menuItems;
  private Boolean onKeySubExist = null;
  private Boolean onKeyUpSubExist = null;

  static
  {
    _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = false;
  }

  public static String _activity_create(boolean paramBoolean)
    throws Exception
  {
    mostCurrent._activity.setTitle("MisriCalendar: Settings");
    mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Initialize(mostCurrent.activityBA, Common.DipToCurrent(1000));
    mostCurrent._activity.AddView((View)mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.getObject(), 0, 0, Common.PerXToCurrent(100.0F, mostCurrent.activityBA), Common.PerYToCurrent(100.0F, mostCurrent.activityBA));
    mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.getPanel().LoadLayout("Settings", mostCurrent.activityBA);
    mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.getPanel().setHeight(mostCurrent._pnlsettings.getHeight());
    _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1();
    return "";
  }

  public static String _activity_pause(boolean paramBoolean)
    throws Exception
  {
    if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2)
    {
      gl._vvvvvvvvvvv7(mostCurrent.activityBA);
      hcalsrvc._vvv5 = true;
    }
    return "";
  }

  public static String _activity_resume()
    throws Exception
  {
    return "";
  }

  public static String _btnrestoredatafile_click()
    throws Exception
  {
    if (gl._vvvvvv1.equals("hijrical.db"))
    {
      int j = Common.Msgbox2("This will restore latest version of 'hijrical.db' data file.\nA copy of your current file will be saved as 'myhijrical.db'\nDo you want to Proceed ?", "", "Yes", "No", "", (Bitmap)Common.Null, mostCurrent.activityBA);
      if (j == -3)
        return "";
      if (gl._vvvvv7.IsInitialized())
        gl._vvvvv7.Close();
      String str2 = gl._vvvvv0;
      String str3 = gl._vvvvvv1;
      File.Copy(str2, str3, gl._vvvvv0, "myhijrical.db");
    }
    while (true)
    {
      gl._vvvvv0 = gl._vvvvvvvvvv0(mostCurrent.activityBA, "", true);
      SQL localSQL = gl._vvvvv7;
      String str1 = gl._vvvvv0;
      localSQL.Initialize(str1, gl._vvvvvv1, false);
      _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = true;
      return "";
      int i = Common.Msgbox2("This will replace your old data file 'hijrical.db' with the latest version.\nDo you want to Proceed ?", "", "Yes", "No", "", (Bitmap)Common.Null, mostCurrent.activityBA);
      if (i == -3)
        return "";
      if (gl._vvvvv7.IsInitialized())
        gl._vvvvv7.Close();
    }
  }

  public static String _btnshowcals_click()
    throws Exception
  {
    _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3();
    return "";
  }

  public static String _chknotification_checkedchange(boolean paramBoolean)
    throws Exception
  {
    if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4)
      return "";
    _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = true;
    if (paramBoolean)
    {
      gl._vvvv7 = "YES";
      hcalsrvc._vvv5 = true;
    }
    while (true)
    {
      return "";
      gl._vvvv7 = "NO";
      NotificationBuilder localNotificationBuilder = hcalsrvc._vvv2;
      localNotificationBuilder.Cancel(hcalsrvc._vvv4);
    }
  }

  public static String _chkshow12hr_checkedchange(boolean paramBoolean)
    throws Exception
  {
    if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4)
      return "";
    _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = true;
    gl._vvvvvvvvv4 = paramBoolean;
    return "";
  }

  public static String _globals()
    throws Exception
  {
    mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = new ScrollViewWrapper();
    mostCurrent._pnlsettings = new PanelWrapper();
    mostCurrent._chknotification = new CompoundButtonWrapper.CheckBoxWrapper();
    mostCurrent._chkshow12hr = new CompoundButtonWrapper.CheckBoxWrapper();
    mostCurrent._lbldefgmt = new LabelWrapper();
    mostCurrent._lbldefloc = new LabelWrapper();
    mostCurrent._rbusedefgmt = new CompoundButtonWrapper.RadioButtonWrapper();
    mostCurrent._rbusedevgmt = new CompoundButtonWrapper.RadioButtonWrapper();
    mostCurrent._rbusedefloc = new CompoundButtonWrapper.RadioButtonWrapper();
    mostCurrent._rbusedevloc = new CompoundButtonWrapper.RadioButtonWrapper();
    _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = false;
    _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = false;
    _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = false;
    return "";
  }

  public static String _process_globals()
    throws Exception
  {
    return "";
  }

  public static String _rbusedefgmt_checkedchange(boolean paramBoolean)
    throws Exception
  {
    if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4)
      return "";
    _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = true;
    gl._vvvvvvvvv1 = paramBoolean;
    if (gl._vvvvvvvv7.length() < 5)
      gl._vvvvvvvvv1 = false;
    return "";
  }

  public static String _rbusedefloc_checkedchange(boolean paramBoolean)
    throws Exception
  {
    if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4)
      return "";
    _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = true;
    gl._vvvvvvvvv2 = Common.Not(paramBoolean);
    return "";
  }

  public static String _rbusedevgmt_checkedchange(boolean paramBoolean)
    throws Exception
  {
    if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4)
      return "";
    _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = true;
    gl._vvvvvvvvv1 = Common.Not(paramBoolean);
    if (gl._vvvvvvvv7.length() < 5)
      gl._vvvvvvvvv1 = false;
    return "";
  }

  public static String _rbusedevloc_checkedchange(boolean paramBoolean)
    throws Exception
  {
    if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4)
      return "";
    _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = true;
    gl._vvvvvvvvv2 = paramBoolean;
    return "";
  }

  public static String _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1()
    throws Exception
  {
    _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = true;
    _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = false;
    if (gl._vvvv7.equals("YES"))
    {
      mostCurrent._chknotification.setChecked(true);
      if (!gl._vvvvvvvvv4)
        break label310;
      mostCurrent._chkshow12hr.setChecked(true);
      label60: LabelWrapper localLabelWrapper1 = mostCurrent._lbldefgmt;
      StringBuilder localStringBuilder = new StringBuilder().append("Def. GMT Offset: ");
      localLabelWrapper1.setText(gl._vvvvvvvv7);
      if (gl._vvvvvvvv7.length() >= 5)
        break label323;
      mostCurrent._rbusedevgmt.setChecked(true);
      mostCurrent._rbusedefgmt.setEnabled(false);
      gl._vvvvvvvvv1 = false;
      mostCurrent._lbldefgmt.setText("Def. GMT Offset: invalid (check location)");
      label162: if (!gl._vvvvvvvvv1)
        break label336;
      mostCurrent._rbusedefgmt.setChecked(true);
      label185: LabelWrapper localLabelWrapper2 = mostCurrent._lbldefloc;
      localLabelWrapper2.setText(gl._vvvvvvvv6);
      if (!gl._vvvvvvvvv2)
        break label349;
      mostCurrent._rbusedevloc.setChecked(true);
    }
    while (true)
    {
      if (Common.Not(gl._vvvvvvvvv3))
      {
        gl._vvvvvvvvv2 = false;
        mostCurrent._rbusedefloc.setChecked(true);
        mostCurrent._rbusedevloc.setText("Network location not valid");
        mostCurrent._rbusedevloc.setEnabled(false);
      }
      _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = false;
      return "";
      mostCurrent._chknotification.setChecked(false);
      break;
      label310: mostCurrent._chkshow12hr.setChecked(false);
      break label60;
      label323: mostCurrent._rbusedefgmt.setEnabled(true);
      break label162;
      label336: mostCurrent._rbusedevgmt.setChecked(true);
      break label185;
      label349: mostCurrent._rbusedefloc.setChecked(true);
    }
  }

  public static String _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3()
    throws Exception
  {
    Map localMap1 = new Map();
    Map localMap2 = new Map();
    StringBuilderWrapper localStringBuilderWrapper = new StringBuilderWrapper();
    int[] arrayOfInt = new int[gl._vvvvvvvvvv6];
    localMap1.Initialize();
    localMap2.Initialize();
    int i4;
    Map localMap3;
    int j;
    int i2;
    if (gl._vvvvvvvvvv6 > 0)
    {
      int i3 = gl._vvvvvvvvvv6 - 1;
      i4 = 0;
      if (i4 <= i3);
    }
    else
    {
      localMap3 = gl._vvvvvvvvvv7.GetListOfAllCalendars(false);
      int i = localMap3.getSize() - 1;
      j = 0;
      if (j <= i)
        break label277;
      Common.InputMap(localMap2, "Select Calendars to Show", mostCurrent.activityBA);
      localStringBuilderWrapper.Initialize();
      int i1 = localMap2.getSize() - 1;
      i2 = 0;
      label146: if (i2 <= i1)
        break label405;
      gl._vvvvvvvvvv4 = localStringBuilderWrapper.ToString();
      if (!gl._vvvvvvvvvv4.contains(","))
        break label453;
      gl._vvvvvvvvvv5 = Regex.Split(",", gl._vvvvvvvvvv4);
    }
    label277: label453: for (gl._vvvvvvvvvv6 = gl._vvvvvvvvvv5.length; ; gl._vvvvvvvvvv6 = 0)
    {
      _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = true;
      return "";
      arrayOfInt[i4] = ((int)Double.parseDouble(gl._vvvvvvvvvv5[i4]));
      i4 = 1 + (i4 + 0);
      break;
      int k = (int)BA.ObjectToNumber(localMap3.GetKeyAt(j));
      int m = gl._vvvvvvvvvv6 - 1;
      boolean bool = false;
      for (int n = 0; ; n = 1 + (n + 0))
      {
        if (n > m)
        {
          localMap2.Put(BA.ObjectToString(localMap3.GetValueAt(j)) + " [" + BA.NumberToString(k) + "]", Boolean.valueOf(bool));
          j = 1 + (j + 0);
          break;
        }
        if (k == arrayOfInt[n])
          bool = true;
      }
      if (localMap2.GetValueAt(i2).equals(Boolean.valueOf(true)))
        localStringBuilderWrapper.Append(BA.ObjectToString(localMap3.GetKeyAt(i2))).Append(",");
      i2 = 1 + (i2 + 0);
      break label146;
    }
  }

  private void afterFirstLayout()
  {
    if (this != mostCurrent);
    do
    {
      do
      {
        return;
        this.activityBA = new BA(this, this.layout, processBA, "com.misricalendar.hijrical", "com.misricalendar.hijrical.settings");
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
          arrayOfObject2[0] = "com.misricalendar.hijrical.settings";
          arrayOfObject2[1] = processBA;
          arrayOfObject2[2] = this.activityBA;
          arrayOfObject2[3] = this._activity;
          arrayOfObject2[4] = Float.valueOf(Common.Density);
          localBA2.raiseEvent2(null, true, "CREATE", true, arrayOfObject2);
          this._activity.reinitializeForShell(this.activityBA, "activity");
        }
        initializeProcessGlobals();
        initializeGlobals();
        BA.LogInfo("** Activity (settings) Create, isFirst = " + isFirst + " **");
        BA localBA1 = processBA;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Boolean.valueOf(isFirst);
        localBA1.raiseEvent2(null, true, "activity_create", false, arrayOfObject1);
        isFirst = false;
      }
      while (this != mostCurrent);
      processBA.setActivityPaused(false);
      BA.LogInfo("** Activity (settings) Resume **");
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
    return settings.class;
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
      processBA = new BA(getApplicationContext(), null, null, "com.misricalendar.hijrical", "com.misricalendar.hijrical.settings");
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
          BA.LogInfo("Killing previous instance (settings).");
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
    BA.LogInfo("** Activity (settings) Pause, UserClosed = " + this.activityBA.activity.isFinishing() + " **");
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
      settings.processBA.raiseEvent(paramMenuItem.getTitle(), this.eventName + "_click", new Object[0]);
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
      BA localBA = settings.processBA;
      ActivityWrapper localActivityWrapper = settings.this._activity;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      Boolean localBoolean = (Boolean)localBA.raiseEvent2(localActivityWrapper, false, "activity_keypress", false, arrayOfObject);
      if ((localBoolean == null) || (localBoolean.booleanValue() == true))
        return true;
      if (paramInt == 4)
      {
        settings.this.finish();
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
      if ((settings.mostCurrent == null) || (settings.mostCurrent != this.activity.get()))
        return;
      settings.processBA.setActivityPaused(false);
      BA.LogInfo("** Activity (settings) Resume **");
      settings.processBA.raiseEvent(settings.mostCurrent._activity, "activity_resume", (Object[])null);
    }
  }

  private static class WaitForLayout
    implements Runnable
  {
    public void run()
    {
      if (settings.afterFirstLayout);
      while (settings.mostCurrent == null)
        return;
      if (settings.mostCurrent.layout.getWidth() == 0)
      {
        BA.handler.postDelayed(this, 5L);
        return;
      }
      settings.mostCurrent.layout.getLayoutParams().height = settings.mostCurrent.layout.getHeight();
      settings.mostCurrent.layout.getLayoutParams().width = settings.mostCurrent.layout.getWidth();
      settings.afterFirstLayout = true;
      settings.mostCurrent.afterFirstLayout();
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.misricalendar.hijrical.settings
 * JD-Core Version:    0.6.2
 */