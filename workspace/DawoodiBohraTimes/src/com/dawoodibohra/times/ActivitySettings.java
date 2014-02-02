package com.dawoodibohra.times;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.PowerManager;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ActivitySettings extends Activity
{
  public static final float FONTSIZE_LARGE = 18.0F;
  public static final float FONTSIZE_MEDIUM = 16.0F;
  public static final float FONTSIZE_SMALL = 14.0F;
  public static final float FONTSIZE_XLARGE = 20.0F;
  public static final String SETTING_ACTUAL_FONT_SIZE = "SETTING_ACTUAL_FONT_SIZE";
  public static final String SETTING_AMPM = "SETTING_AMPM";
  public static final String SETTING_CALTYPE = "SETTING_CALTYPE";
  public static final String SETTING_FONTSIZE = "SETTING_FONTSIZE";
  public static final String SETTING_LIVEGPS = "SETTING_LIVEGPS";
  public static final String SETTING_MIQAAT_NOTIFY = "SETTING_MIQAAT_NOTIFY";
  public static final String SETTING_NAMAAZ_NOTIFY = "SETTING_NAMAAZ_NOTIFY";
  public static final String SETTING_NAMAAZ_NOTIFY_SOUND = "SETTING_NAMAAZ_NOTIFY_SOUND";
  public static final String SETTING_NAMAAZ_NOTIFY_VIBRATE = "SETTING_NAMAAZ_NOTIFY_VIBRATE";
  public static final String SETTING_SHOWALL = "SETTING_SHOWALL";
  public static final String SETTING_SHOWDB = "SETTING_SHOWDB";
  public static final String SETTING_SHOWGREG = "SETTING_SHOWGREG";
  private Spinner AMPMSpinner;
  private CheckBox CalAllCB;
  private CheckBox CalGregCB;
  private CheckBox CalShowDB;
  private Spinner CalTypeSpinner;
  private Spinner FontSizeSpinner;
  private CheckBox LiveGPSCB;
  private CheckBox MiqaatNotifyCB;
  private CheckBox NamaazNotifyCB;
  private CheckBox NamaazNotifySoundCB;
  private Spinner NamaazNotifyVibrateSpinner;
  private TextView NamaazNotifyVibrateTV;
  private View.OnClickListener TestMiqaat = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      Context localContext = ActivitySettings.this.getApplicationContext();
      ServiceNotifications.showMiqaatNotification((NotificationManager)ActivitySettings.this.getSystemService("notification"), localContext, "\n• Ashara Mubaraka: Ninth Waaz (Ashura)", "Miqaats for 10 Muharram al-Haraam 1431H");
    }
  };
  private View.OnClickListener TestNamaaz = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      Context localContext = ActivitySettings.this.getApplicationContext();
      ServiceNotifications.showNamaazNotification((NotificationManager)ActivitySettings.this.getSystemService("notification"), (PowerManager)ActivitySettings.this.getSystemService("power"), localContext, "Ends at 6:00 AM", "Fajr Namaaz", ActivitySettings.this.NamaazNotifyVibrateSpinner.getSelectedItemPosition(), ActivitySettings.this.NamaazNotifySoundCB.isChecked());
    }
  };
  private Context context;
  private String errorMessage;
  SharedPreferences prefs;
  private Button testMiqaatButton;
  private Button testNamaazButton;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903046);
    this.context = getApplicationContext();
    getWindow().setSoftInputMode(3);
    this.FontSizeSpinner = ((Spinner)findViewById(2131361872));
    this.AMPMSpinner = ((Spinner)findViewById(2131361873));
    this.CalTypeSpinner = ((Spinner)findViewById(2131361874));
    this.CalGregCB = ((CheckBox)findViewById(2131361875));
    this.CalAllCB = ((CheckBox)findViewById(2131361877));
    this.CalShowDB = ((CheckBox)findViewById(2131361876));
    this.NamaazNotifyCB = ((CheckBox)findViewById(2131361878));
    this.NamaazNotifySoundCB = ((CheckBox)findViewById(2131361879));
    this.NamaazNotifyVibrateTV = ((TextView)findViewById(2131361880));
    this.NamaazNotifyVibrateSpinner = ((Spinner)findViewById(2131361881));
    this.MiqaatNotifyCB = ((CheckBox)findViewById(2131361883));
    this.LiveGPSCB = ((CheckBox)findViewById(2131361886));
    this.testNamaazButton = ((Button)findViewById(2131361882));
    this.testNamaazButton.setOnClickListener(this.TestNamaaz);
    this.testMiqaatButton = ((Button)findViewById(2131361885));
    this.testMiqaatButton.setOnClickListener(this.TestMiqaat);
    populateSpinners();
    this.prefs = PreferenceManager.getDefaultSharedPreferences(this.context);
    updateUIFromPreferences();
    this.CalAllCB.setVisibility(8);
    this.NamaazNotifyCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          ActivitySettings.this.NamaazNotifySoundCB.setVisibility(0);
          ActivitySettings.this.NamaazNotifyVibrateTV.setVisibility(0);
          ActivitySettings.this.NamaazNotifyVibrateSpinner.setVisibility(0);
          ActivitySettings.this.testNamaazButton.setVisibility(0);
          return;
        }
        ActivitySettings.this.NamaazNotifySoundCB.setVisibility(8);
        ActivitySettings.this.NamaazNotifyVibrateTV.setVisibility(8);
        ActivitySettings.this.NamaazNotifyVibrateSpinner.setVisibility(8);
        ActivitySettings.this.testNamaazButton.setVisibility(8);
      }
    });
    this.MiqaatNotifyCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          ActivitySettings.this.testMiqaatButton.setVisibility(0);
          return;
        }
        ActivitySettings.this.testMiqaatButton.setVisibility(8);
      }
    });
  }

  public void onPause()
  {
    if (savePreferences())
      finish();
    while (true)
    {
      super.onPause();
      return;
      Toast.makeText(getApplicationContext(), this.errorMessage, 1).show();
    }
  }

  public void populateSpinners()
  {
    ArrayAdapter localArrayAdapter1 = ArrayAdapter.createFromResource(this, 2131099652, 17367048);
    localArrayAdapter1.setDropDownViewResource(17367049);
    this.FontSizeSpinner.setAdapter(localArrayAdapter1);
    ArrayAdapter localArrayAdapter2 = ArrayAdapter.createFromResource(this, 2131099653, 17367048);
    localArrayAdapter2.setDropDownViewResource(17367049);
    this.AMPMSpinner.setAdapter(localArrayAdapter2);
    ArrayAdapter localArrayAdapter3 = ArrayAdapter.createFromResource(this, 2131099655, 17367048);
    localArrayAdapter3.setDropDownViewResource(17367049);
    this.CalTypeSpinner.setAdapter(localArrayAdapter3);
    ArrayAdapter localArrayAdapter4 = ArrayAdapter.createFromResource(this, 2131099654, 17367048);
    localArrayAdapter4.setDropDownViewResource(17367049);
    this.NamaazNotifyVibrateSpinner.setAdapter(localArrayAdapter4);
  }

  public boolean savePreferences()
  {
    int i;
    if (this.FontSizeSpinner.getSelectedItemPosition() == 0)
    {
      i = (int)(14.0F * 1.0F);
      if (this.AMPMSpinner.getSelectedItemPosition() != 0)
        break label344;
    }
    label344: for (boolean bool1 = true; ; bool1 = false)
    {
      int j = this.CalTypeSpinner.getSelectedItemPosition();
      boolean bool2 = this.CalGregCB.isChecked();
      boolean bool3 = this.CalShowDB.isChecked();
      boolean bool4 = this.NamaazNotifyCB.isChecked();
      boolean bool5 = this.NamaazNotifySoundCB.isChecked();
      int k = this.NamaazNotifyVibrateSpinner.getSelectedItemPosition();
      boolean bool6 = this.MiqaatNotifyCB.isChecked();
      boolean bool7 = this.LiveGPSCB.isChecked();
      Toast.makeText(getApplicationContext(), "Settings saved.", 1).show();
      SharedPreferences.Editor localEditor = this.prefs.edit();
      localEditor.putInt("SETTING_FONTSIZE", this.FontSizeSpinner.getSelectedItemPosition());
      localEditor.putInt("SETTING_ACTUAL_FONT_SIZE", i);
      localEditor.putBoolean("SETTING_AMPM", bool1);
      localEditor.putInt("SETTING_CALTYPE", j);
      localEditor.putBoolean("SETTING_SHOWDB", bool3);
      localEditor.putBoolean("SETTING_SHOWGREG", bool2);
      localEditor.putBoolean("SETTING_SHOWALL", true);
      localEditor.putBoolean("SETTING_NAMAAZ_NOTIFY", bool4);
      localEditor.putBoolean("SETTING_NAMAAZ_NOTIFY_SOUND", bool5);
      localEditor.putInt("SETTING_NAMAAZ_NOTIFY_VIBRATE", k);
      localEditor.putBoolean("SETTING_MIQAAT_NOTIFY", bool6);
      localEditor.putBoolean("SETTING_LIVEGPS", bool7);
      localEditor.commit();
      return true;
      if (this.FontSizeSpinner.getSelectedItemPosition() == 1)
      {
        i = (int)(16.0F * 1.0F);
        break;
      }
      if (this.FontSizeSpinner.getSelectedItemPosition() == 2)
      {
        i = (int)(18.0F * 1.0F);
        break;
      }
      i = (int)(20.0F * 1.0F);
      break;
    }
  }

  public void updateUIFromPreferences()
  {
    if (this.prefs.getBoolean("SETTING_AMPM", true))
    {
      this.AMPMSpinner.setSelection(0);
      if (this.prefs.getInt("SETTING_FONTSIZE", 1) >= 4)
        break label320;
      this.FontSizeSpinner.setSelection(this.prefs.getInt("SETTING_FONTSIZE", 1));
      label58: this.CalTypeSpinner.setSelection(this.prefs.getInt("SETTING_CALTYPE", 1));
      this.CalGregCB.setChecked(this.prefs.getBoolean("SETTING_SHOWGREG", true));
      this.CalAllCB.setChecked(this.prefs.getBoolean("SETTING_SHOWALL", true));
      this.CalShowDB.setChecked(this.prefs.getBoolean("SETTING_SHOWDB", true));
      this.NamaazNotifyCB.setChecked(this.prefs.getBoolean("SETTING_NAMAAZ_NOTIFY", false));
      this.NamaazNotifySoundCB.setChecked(this.prefs.getBoolean("SETTING_NAMAAZ_NOTIFY_SOUND", false));
      this.NamaazNotifyVibrateSpinner.setSelection(this.prefs.getInt("SETTING_NAMAAZ_NOTIFY_VIBRATE", 0));
      this.MiqaatNotifyCB.setChecked(this.prefs.getBoolean("SETTING_MIQAAT_NOTIFY", false));
      this.LiveGPSCB.setChecked(this.prefs.getBoolean("SETTING_LIVEGPS", false));
      this.CalAllCB.setVisibility(8);
      if (!this.prefs.getBoolean("SETTING_NAMAAZ_NOTIFY", false))
        break label331;
      this.NamaazNotifySoundCB.setVisibility(0);
      this.NamaazNotifyVibrateTV.setVisibility(0);
      this.NamaazNotifyVibrateSpinner.setVisibility(0);
      this.testNamaazButton.setVisibility(0);
    }
    while (true)
    {
      if (!this.prefs.getBoolean("SETTING_MIQAAT_NOTIFY", false))
        break label370;
      this.testMiqaatButton.setVisibility(0);
      return;
      this.AMPMSpinner.setSelection(1);
      break;
      label320: this.FontSizeSpinner.setSelection(1);
      break label58;
      label331: this.NamaazNotifySoundCB.setVisibility(8);
      this.NamaazNotifyVibrateTV.setVisibility(8);
      this.NamaazNotifyVibrateSpinner.setVisibility(8);
      this.testNamaazButton.setVisibility(8);
    }
    label370: this.testMiqaatButton.setVisibility(8);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     dawoodibohra.salaat.ActivitySettings
 * JD-Core Version:    0.6.2
 */