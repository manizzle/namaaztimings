package uk.co.martinpearman.b4a.tabhostextras;

import android.app.Application;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper;

@BA.Author("Martin Pearman")
@BA.ShortName("TabHostExtras")
@BA.Version(2.0F)
public class TabHostExtras
{
  public static CanvasWrapper.RectWrapper getTabContentViewPadding(TabHost paramTabHost)
  {
    CanvasWrapper.RectWrapper localRectWrapper = new CanvasWrapper.RectWrapper();
    FrameLayout localFrameLayout = paramTabHost.getTabContentView();
    localRectWrapper.Initialize(localFrameLayout.getPaddingLeft(), localFrameLayout.getPaddingTop(), localFrameLayout.getPaddingRight(), localFrameLayout.getPaddingBottom());
    return localRectWrapper;
  }

  public static boolean getTabEnabled(TabHost paramTabHost, int paramInt)
  {
    return paramTabHost.getTabWidget().getChildAt(paramInt).isEnabled();
  }

  public static int getTabHeight(TabHost paramTabHost)
  {
    return paramTabHost.getTabWidget().getChildAt(0).getLayoutParams().height;
  }

  public static CanvasWrapper.RectWrapper getTabHostPadding(TabHost paramTabHost)
  {
    CanvasWrapper.RectWrapper localRectWrapper = new CanvasWrapper.RectWrapper();
    View localView = paramTabHost.getChildAt(0);
    localRectWrapper.Initialize(localView.getPaddingLeft(), localView.getPaddingTop(), localView.getPaddingRight(), localView.getPaddingBottom());
    return localRectWrapper;
  }

  public static boolean getTabVisibility(TabHost paramTabHost, int paramInt)
  {
    return paramTabHost.getTabWidget().getChildAt(paramInt).getVisibility() == 0;
  }

  public static void setTabContentViewPadding(TabHost paramTabHost, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramTabHost.getTabContentView().setPadding(Common.DipToCurrent(paramInt1), Common.DipToCurrent(paramInt2), Common.DipToCurrent(paramInt3), Common.DipToCurrent(paramInt4));
  }

  public static void setTabEnabled(TabHost paramTabHost, boolean paramBoolean)
  {
    TabWidget localTabWidget = paramTabHost.getTabWidget();
    int j;
    for (int i = localTabWidget.getChildCount(); ; i = j)
    {
      j = i - 1;
      if (i <= 0)
        return;
      localTabWidget.getChildAt(j).setEnabled(paramBoolean);
    }
  }

  public static void setTabEnabled2(TabHost paramTabHost, boolean paramBoolean, int paramInt)
  {
    paramTabHost.getTabWidget().getChildAt(paramInt).setEnabled(paramBoolean);
  }

  public static void setTabGradientDrawable(TabHost paramTabHost, String paramString, int paramInt1, int paramInt2, float paramFloat)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.valueOf(paramString), new int[] { paramInt1, paramInt2 });
    localGradientDrawable.setCornerRadius(paramFloat);
    TabWidget localTabWidget = paramTabHost.getTabWidget();
    int j;
    for (int i = localTabWidget.getChildCount(); ; i = j)
    {
      j = i - 1;
      if (i <= 0)
        return;
      localTabWidget.getChildAt(j).setBackgroundDrawable(localGradientDrawable);
    }
  }

  public static void setTabGradientDrawable2(TabHost paramTabHost, String paramString, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.valueOf(paramString), new int[] { paramInt1, paramInt2 });
    TabWidget localTabWidget;
    switch (paramArrayOfFloat.length)
    {
    case 3:
    default:
      localTabWidget = paramTabHost.getTabWidget();
    case 1:
    case 2:
    case 4:
    }
    int j;
    for (int i = localTabWidget.getChildCount(); ; i = j)
    {
      j = i - 1;
      if (i <= 0)
      {
        return;
        localGradientDrawable.setCornerRadius(paramArrayOfFloat[0]);
        break;
        float[] arrayOfFloat2 = new float[8];
        arrayOfFloat2[0] = paramArrayOfFloat[0];
        arrayOfFloat2[1] = paramArrayOfFloat[0];
        arrayOfFloat2[2] = paramArrayOfFloat[0];
        arrayOfFloat2[3] = paramArrayOfFloat[0];
        arrayOfFloat2[4] = paramArrayOfFloat[1];
        arrayOfFloat2[5] = paramArrayOfFloat[1];
        arrayOfFloat2[6] = paramArrayOfFloat[1];
        arrayOfFloat2[7] = paramArrayOfFloat[1];
        localGradientDrawable.setCornerRadii(arrayOfFloat2);
        break;
        float[] arrayOfFloat1 = new float[8];
        arrayOfFloat1[0] = paramArrayOfFloat[0];
        arrayOfFloat1[1] = paramArrayOfFloat[0];
        arrayOfFloat1[2] = paramArrayOfFloat[1];
        arrayOfFloat1[3] = paramArrayOfFloat[1];
        arrayOfFloat1[4] = paramArrayOfFloat[2];
        arrayOfFloat1[5] = paramArrayOfFloat[2];
        arrayOfFloat1[6] = paramArrayOfFloat[3];
        arrayOfFloat1[7] = paramArrayOfFloat[3];
        localGradientDrawable.setCornerRadii(arrayOfFloat1);
        break;
      }
      localTabWidget.getChildAt(j).setBackgroundDrawable(localGradientDrawable);
    }
  }

  public static void setTabHeight(TabHost paramTabHost, int paramInt)
  {
    TabWidget localTabWidget = paramTabHost.getTabWidget();
    int j;
    for (int i = localTabWidget.getChildCount(); ; i = j)
    {
      j = i - 1;
      if (i <= 0)
        return;
      localTabWidget.getChildAt(j).getLayoutParams().height = paramInt;
    }
  }

  public static void setTabHostPadding(TabHost paramTabHost, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramTabHost.getChildAt(0).setPadding(Common.DipToCurrent(paramInt1), Common.DipToCurrent(paramInt2), Common.DipToCurrent(paramInt3), Common.DipToCurrent(paramInt4));
  }

  public static void setTabVisibility(TabHost paramTabHost, boolean paramBoolean)
  {
    TabWidget localTabWidget = paramTabHost.getTabWidget();
    int i = localTabWidget.getChildCount();
    while (true)
    {
      int j = i - 1;
      if (i <= 0)
        return;
      if (paramBoolean)
      {
        localTabWidget.getChildAt(j).setVisibility(0);
        i = j;
      }
      else
      {
        localTabWidget.getChildAt(j).setVisibility(8);
        i = j;
      }
    }
  }

  public static void setTabVisibility2(TabHost paramTabHost, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      paramTabHost.getTabWidget().getChildAt(paramInt).setVisibility(0);
      return;
    }
    paramTabHost.getTabWidget().getChildAt(paramInt).setVisibility(8);
  }

  public float getTabTextSize(TabHost paramTabHost)
  {
    return ((TextView)((ViewGroup)paramTabHost.getTabWidget().getChildAt(0)).getChildAt(1)).getTextSize();
  }

  public void setTabTextColor(TabHost paramTabHost, int paramInt)
  {
    TabWidget localTabWidget = paramTabHost.getTabWidget();
    int j;
    for (int i = localTabWidget.getChildCount(); ; i = j)
    {
      j = i - 1;
      if (i <= 0)
        return;
      ((TextView)((ViewGroup)localTabWidget.getChildAt(j)).getChildAt(1)).setTextColor(paramInt);
    }
  }

  public void setTabTextColorStateList(TabHost paramTabHost, String paramString)
  {
    int i = BA.applicationContext.getResources().getIdentifier(paramString, "drawable", BA.packageName);
    ColorStateList localColorStateList = BA.applicationContext.getResources().getColorStateList(i);
    TabWidget localTabWidget = paramTabHost.getTabWidget();
    int k;
    for (int j = localTabWidget.getChildCount(); ; j = k)
    {
      k = j - 1;
      if (j <= 0)
        return;
      ((TextView)((ViewGroup)localTabWidget.getChildAt(k)).getChildAt(1)).setTextColor(localColorStateList);
    }
  }

  public void setTabTextSize(TabHost paramTabHost, float paramFloat)
  {
    TabWidget localTabWidget = paramTabHost.getTabWidget();
    int j;
    for (int i = localTabWidget.getChildCount(); ; i = j)
    {
      j = i - 1;
      if (i <= 0)
        return;
      ((TextView)((ViewGroup)localTabWidget.getChildAt(j)).getChildAt(1)).setTextSize(paramFloat);
    }
  }

  public void setTabTitle(TabHost paramTabHost, String paramString, int paramInt)
  {
    ((TextView)((ViewGroup)paramTabHost.getTabWidget().getChildAt(paramInt)).getChildAt(1)).setText(paramString);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     uk.co.martinpearman.b4a.tabhostextras.TabHostExtras
 * JD-Core Version:    0.6.2
 */