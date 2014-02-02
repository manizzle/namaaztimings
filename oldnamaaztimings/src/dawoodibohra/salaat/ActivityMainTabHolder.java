package dawoodibohra.salaat;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.location.LocationManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class ActivityMainTabHolder extends TabActivity
{
  private TabHost tabHost;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Context localContext = getApplicationContext();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(localContext);
    LocationManager localLocationManager = (LocationManager)getSystemService("location");
    if ((!localSharedPreferences.contains("SETTING_LAT")) || (!localSharedPreferences.contains("SETTING_LNG")) || (!localSharedPreferences.contains("SETTING_TZ")) || (!localSharedPreferences.contains("SETTING_CITY")) || (!localSharedPreferences.contains("SETTING_QIBLA")) || (!localSharedPreferences.contains("SETTING_MAGDEC")))
    {
      if (ActivityLocationSettings.getDefaultSettings(localLocationManager, localSharedPreferences, localContext))
        break label360;
      startActivity(new Intent(this, ActivityLocationSettings.class));
    }
    while (true)
    {
      if (!localSharedPreferences.contains("SETTING_AMPM"))
      {
        SharedPreferences.Editor localEditor = localSharedPreferences.edit();
        localEditor.putBoolean("SETTING_AMPM", true);
        localEditor.commit();
      }
      localSharedPreferences.getInt("SETTING_ACTUAL_FONT_SIZE", 16);
      setContentView(2130903043);
      Resources localResources = getResources();
      this.tabHost = getTabHost();
      Intent localIntent1 = new Intent().setClass(this, ActivityNamaaz.class);
      TabHost.TabSpec localTabSpec1 = this.tabHost.newTabSpec("namaaztimes");
      localTabSpec1.setIndicator("Namaaz", localResources.getDrawable(2130837510));
      localTabSpec1.setContent(localIntent1);
      this.tabHost.addTab(localTabSpec1);
      Intent localIntent2 = new Intent().setClass(this, ActivityQibla.class);
      TabHost.TabSpec localTabSpec2 = this.tabHost.newTabSpec("qibla");
      localTabSpec2.setIndicator("Qibla", localResources.getDrawable(2130837513));
      localTabSpec2.setContent(localIntent2);
      this.tabHost.addTab(localTabSpec2);
      Intent localIntent3 = new Intent().setClass(this, ActivityCalendar.class);
      TabHost.TabSpec localTabSpec3 = this.tabHost.newTabSpec("Calendar");
      localTabSpec3.setIndicator("Calendar", localResources.getDrawable(2130837507));
      localTabSpec3.setContent(localIntent3);
      this.tabHost.addTab(localTabSpec3);
      return;
      label360: ActivityLocationSettings.TimeZoneUpdater(localSharedPreferences, localContext);
      ActivityLocationSettings.LocationUpdater(localLocationManager, localSharedPreferences, localContext);
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    paramMenu.add(0, 0, 0, "Settings").setIcon(2130837506);
    paramMenu.add(0, 1, 0, "Location").setIcon(2130837505);
    paramMenu.add(0, 2, 0, "Quit").setIcon(2130837504);
    return true;
  }

  protected void onDestroy()
  {
    super.onDestroy();
  }

  protected void onNewIntent(Intent paramIntent)
  {
    setIntent(paramIntent);
    super.onNewIntent(paramIntent);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return false;
    case 0:
      startActivity(new Intent(this, ActivitySettings.class));
      return true;
    case 1:
      startActivity(new Intent(this, ActivityLocationSettings.class));
      return true;
    case 2:
    }
    finish();
    return true;
  }

  protected void onResume()
  {
    Context localContext = getApplicationContext();
    localContext.startService(new Intent(localContext, ServiceNotifications.class));
    this.tabHost.setCurrentTab(getIntent().getIntExtra("dawoodibohra.salaat.desc", 0));
    super.onResume();
  }

  protected void onStart()
  {
    super.onStart();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     dawoodibohra.salaat.ActivityMainTabHolder
 * JD-Core Version:    0.6.2
 */