package anywheresoftware.b4a.phone;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.objects.IntentWrapper;
import java.util.Iterator;

@BA.ShortName("PackageManager")
public class PackageManagerWrapper
{
  private PackageManager pm = BA.applicationContext.getPackageManager();

  public Drawable GetApplicationIcon(String paramString)
    throws PackageManager.NameNotFoundException
  {
    return this.pm.getApplicationIcon(paramString);
  }

  public IntentWrapper GetApplicationIntent(String paramString)
  {
    IntentWrapper localIntentWrapper = new IntentWrapper();
    localIntentWrapper.setObject(this.pm.getLaunchIntentForPackage(paramString));
    return localIntentWrapper;
  }

  public String GetApplicationLabel(String paramString)
    throws PackageManager.NameNotFoundException
  {
    CharSequence localCharSequence = this.pm.getApplicationLabel(this.pm.getApplicationInfo(paramString, 0));
    if (localCharSequence == null)
      return "";
    return localCharSequence.toString();
  }

  public anywheresoftware.b4a.objects.collections.List GetInstalledPackages()
  {
    anywheresoftware.b4a.objects.collections.List localList = new anywheresoftware.b4a.objects.collections.List();
    java.util.List localList1 = this.pm.getInstalledPackages(0);
    localList.Initialize();
    Iterator localIterator = localList1.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return localList;
      localList.Add(((PackageInfo)localIterator.next()).packageName);
    }
  }

  public int GetVersionCode(String paramString)
    throws PackageManager.NameNotFoundException
  {
    return this.pm.getPackageInfo(paramString, 0).versionCode;
  }

  public String GetVersionName(String paramString)
    throws PackageManager.NameNotFoundException
  {
    return this.pm.getPackageInfo(paramString, 0).versionName;
  }

  public anywheresoftware.b4a.objects.collections.List QueryIntentActivities(Intent paramIntent)
  {
    java.util.List localList = this.pm.queryIntentActivities(paramIntent, 0);
    anywheresoftware.b4a.objects.collections.List localList1 = new anywheresoftware.b4a.objects.collections.List();
    localList1.Initialize();
    Iterator localIterator = localList.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return localList1;
      ResolveInfo localResolveInfo = (ResolveInfo)localIterator.next();
      localList1.Add(new ComponentName(localResolveInfo.activityInfo.packageName, localResolveInfo.activityInfo.name).flattenToShortString());
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.phone.PackageManagerWrapper
 * JD-Core Version:    0.6.2
 */