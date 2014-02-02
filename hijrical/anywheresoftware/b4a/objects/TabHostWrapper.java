package anywheresoftware.b4a.objects;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import android.widget.TextView;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.RaisesSynchronousEvents;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.keywords.LayoutValues;
import anywheresoftware.b4a.objects.drawable.BitmapDrawable;
import java.util.HashMap;

@BA.ShortName("TabHost")
@BA.ActivityObject
public class TabHostWrapper extends ViewWrapper<TabHost>
{
  @BA.Hide
  public static View build(Object paramObject1, HashMap<String, Object> paramHashMap, boolean paramBoolean, Object paramObject2)
    throws Exception
  {
    int i = 0;
    if (paramObject1 == null)
    {
      i = 1;
      paramObject1 = ViewWrapper.buildNativeView((Context)paramObject2, MyTabHost.class, paramHashMap, paramBoolean);
    }
    TabHost localTabHost = (TabHost)ViewWrapper.build(paramObject1, paramHashMap, paramBoolean);
    TextView localTextView;
    if ((paramBoolean) && (i != 0))
    {
      initializeTabWidget((Context)paramObject2, localTabHost);
      localTextView = new TextView((Context)paramObject2);
      localTextView.setText("This is an example page.\nTab pages should be added programmatically.");
    }
    for (int j = 1; ; j++)
    {
      if (j > 3)
        return localTabHost;
      MyContentFactory localMyContentFactory = new MyContentFactory(localTextView);
      TabHost.TabSpec localTabSpec = localTabHost.newTabSpec("");
      localTabSpec.setContent(localMyContentFactory);
      localTabSpec.setIndicator("Page " + j);
      localTabHost.addTab(localTabSpec);
    }
  }

  private View createPanelForLayoutFile(BA paramBA, String paramString)
    throws Exception
  {
    PanelWrapper localPanelWrapper = new PanelWrapper();
    localPanelWrapper.Initialize(paramBA, "");
    int i = 84;
    if ((BA.applicationContext.getApplicationInfo().targetSdkVersion >= 11) && (Build.VERSION.SDK_INT >= 11) && (Common.GetDeviceLayoutValues(paramBA).getApproximateScreenSize() < 5.0D))
      i = 68;
    ((ViewGroup)localPanelWrapper.getObject()).setLayoutParams(new ViewGroup.LayoutParams(getWidth() - Common.DipToCurrent(20), getHeight() - Common.DipToCurrent(i)));
    localPanelWrapper.LoadLayout(paramString, paramBA);
    return (View)localPanelWrapper.getObject();
  }

  private static void initializeTabWidget(Context paramContext, TabHost paramTabHost)
  {
    TabWidget localTabWidget = new TabWidget(paramContext);
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    int i = Common.DipToCurrent(5);
    localLinearLayout.setPadding(i, i, i, i);
    localLinearLayout.setOrientation(1);
    localTabWidget.setId(16908307);
    localLinearLayout.addView(localTabWidget, new ViewGroup.LayoutParams(-1, -2));
    FrameLayout localFrameLayout = new FrameLayout(paramContext);
    localFrameLayout.setId(16908305);
    localFrameLayout.setPadding(i, i, i, i);
    localLinearLayout.addView(localFrameLayout, new ViewGroup.LayoutParams(-1, -1));
    paramTabHost.addView(localLinearLayout, new ViewGroup.LayoutParams(-1, -1));
    paramTabHost.setup();
  }

  @BA.RaisesSynchronousEvents
  public void AddTab(BA paramBA, String paramString1, String paramString2)
    throws Exception
  {
    AddTab2(paramString1, createPanelForLayoutFile(paramBA, paramString2));
  }

  public void AddTab2(String paramString, View paramView)
  {
    if (((TabHost)getObject()).getCurrentTabTag().equals("~temp"))
      ((TabHost)getObject()).clearAllTabs();
    MyContentFactory localMyContentFactory = new MyContentFactory(paramView);
    TabHost.TabSpec localTabSpec = ((TabHost)getObject()).newTabSpec("");
    localTabSpec.setContent(localMyContentFactory);
    localTabSpec.setIndicator(paramString);
    ((TabHost)getObject()).addTab(localTabSpec);
  }

  @BA.RaisesSynchronousEvents
  public void AddTabWithIcon(BA paramBA, String paramString1, Bitmap paramBitmap1, Bitmap paramBitmap2, String paramString2)
    throws Exception
  {
    AddTabWithIcon2(paramString1, paramBitmap1, paramBitmap2, createPanelForLayoutFile(paramBA, paramString2));
  }

  public void AddTabWithIcon2(String paramString, Bitmap paramBitmap1, Bitmap paramBitmap2, View paramView)
  {
    if (((TabHost)getObject()).getCurrentTabTag().equals("~temp"))
      ((TabHost)getObject()).clearAllTabs();
    MyContentFactory localMyContentFactory = new MyContentFactory(paramView);
    TabHost.TabSpec localTabSpec = ((TabHost)getObject()).newTabSpec("");
    localTabSpec.setContent(localMyContentFactory);
    BitmapDrawable localBitmapDrawable1 = new BitmapDrawable();
    localBitmapDrawable1.Initialize(paramBitmap1);
    BitmapDrawable localBitmapDrawable2 = new BitmapDrawable();
    localBitmapDrawable2.Initialize(paramBitmap2);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842913 }, (Drawable)localBitmapDrawable2.getObject());
    localStateListDrawable.addState(new int[0], (Drawable)localBitmapDrawable1.getObject());
    localTabSpec.setIndicator(paramString, localStateListDrawable);
    ((TabHost)getObject()).addTab(localTabSpec);
  }

  public int getCurrentTab()
  {
    return ((TabHost)getObject()).getCurrentTab();
  }

  public int getTabCount()
  {
    return ((TabHost)getObject()).getTabWidget().getTabCount();
  }

  @BA.Hide
  public void innerInitialize(final BA paramBA, final String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
      setObject(new TabHost(paramBA.context, null));
    super.innerInitialize(paramBA, paramString, true);
    initializeTabWidget(paramBA.context, (TabHost)getObject());
    if (paramBA.subExists(paramString + "_tabchanged"))
      ((TabHost)getObject()).setOnTabChangedListener(new TabHost.OnTabChangeListener()
      {
        public void onTabChanged(String paramAnonymousString)
        {
          paramBA.raiseEvent2(TabHostWrapper.this.getObject(), false, paramString + "_tabchanged", false, new Object[0]);
        }
      });
    MyContentFactory localMyContentFactory = new MyContentFactory(new View(paramBA.context));
    TabHost.TabSpec localTabSpec = ((TabHost)getObject()).newTabSpec("~temp");
    localTabSpec.setContent(localMyContentFactory);
    localTabSpec.setIndicator("");
    ((TabHost)getObject()).addTab(localTabSpec);
  }

  @BA.RaisesSynchronousEvents
  public void setCurrentTab(int paramInt)
  {
    ((TabHost)getObject()).setCurrentTab(paramInt);
  }

  private static class MyContentFactory
    implements TabHost.TabContentFactory
  {
    private View view;

    public MyContentFactory(View paramView)
    {
      this.view = paramView;
    }

    public View createTabContent(String paramString)
    {
      return this.view;
    }
  }

  @BA.Hide
  public static class MyTabHost extends TabHost
  {
    public MyTabHost(Context paramContext)
    {
      super(null);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.TabHostWrapper
 * JD-Core Version:    0.6.2
 */