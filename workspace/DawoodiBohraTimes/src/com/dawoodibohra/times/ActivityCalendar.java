package com.dawoodibohra.times;

import android.app.Activity;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.format.Time;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

public class ActivityCalendar extends Activity
{
  private static final int DIALOG_GREGPICKER_ID = 0;
  private static final int DIALOG_HIJRIPICKER_ID = 1;
  private View.OnClickListener Cancel = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      ActivityCalendar.this.datePickerDialog.dismiss();
      if (ActivityCalendar.this.dialogType)
      {
        ActivityCalendar.this.removeDialog(0);
        return;
      }
      ActivityCalendar.this.removeDialog(1);
    }
  };
  private Spinner DateSpinner;
  private View.OnClickListener Go = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      int i = Integer.parseInt(ActivityCalendar.this.YearEditText.getText().toString());
      if (ActivityCalendar.this.dialogType)
      {
        ActivityCalendar.this.time.set(1 + ActivityCalendar.this.DateSpinner.getSelectedItemPosition(), ActivityCalendar.this.MonthSpinner.getSelectedItemPosition(), i);
        ActivityCalendar.this.time.normalize(true);
        ActivityCalendar.this.specificDate = true;
        ActivityCalendar.this.datePickerDialog.dismiss();
        if (!ActivityCalendar.this.dialogType)
          break label171;
        ActivityCalendar.this.removeDialog(0);
      }
      while (true)
      {
        ActivityCalendar.this.main();
        return;
        int[] arrayOfInt = new int[3];
        arrayOfInt[0] = (1 + ActivityCalendar.this.DateSpinner.getSelectedItemPosition());
        arrayOfInt[1] = ActivityCalendar.this.MonthSpinner.getSelectedItemPosition();
        arrayOfInt[2] = i;
        ActivityCalendar.this.time.set(UtilCalendar.getGregDate(arrayOfInt));
        break;
        label171: ActivityCalendar.this.removeDialog(1);
      }
    }
  };
  private View.OnClickListener GregDate = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      ActivityCalendar.this.dialogType = true;
      ActivityCalendar.this.showDialog(0);
    }
  };
  private View.OnClickListener HijriDate = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      ActivityCalendar.this.dialogType = false;
      ActivityCalendar.this.showDialog(1);
    }
  };
  private Spinner MonthSpinner;
  private View.OnClickListener Next = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      ActivityCalendar.this.time.set(ActivityCalendar.this.time.toMillis(false) + ActivityCalendar.this.Offset);
      ActivityCalendar.this.time.normalize(true);
      ActivityCalendar.this.specificDate = false;
      ActivityCalendar.this.main();
    }
  };
  private long Offset;
  private View.OnClickListener Prev = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      ActivityCalendar.this.time.set(ActivityCalendar.this.time.toMillis(false) - ActivityCalendar.this.Offset);
      ActivityCalendar.this.time.normalize(true);
      ActivityCalendar.this.specificDate = false;
      ActivityCalendar.this.main();
    }
  };
  private View.OnClickListener Today = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      ActivityCalendar.this.setToToday();
      ActivityCalendar.this.specificDate = true;
      ActivityCalendar.this.main();
    }
  };
  private EditText YearEditText;
  private Context context;
  private Dialog datePickerDialog;
  private boolean dialogType;
  int fontSize;
  Button gregdatebutton;
  Button hijridatebutton;
  private final long monthOffset = 2551440000L;
  Button nextbutton;
  Button prevbutton;
  boolean showAll;
  boolean showDB;
  boolean showGreg;
  private boolean specificDate;
  private Time time = new Time();
  Button todaybutton;
  int typeOfCalendar;
  private final long weekOffset = 604800000L;
  private final long yearOffset = 30617280000L;

  private String formatTextToShow(int[] paramArrayOfInt, String paramString)
  {
    String str = paramArrayOfInt[0] + " " + UtilCalendar.getMisriMonth(paramArrayOfInt[1]) + " " + paramArrayOfInt[2] + "H";
    if (this.showGreg)
      str = str + "\n" + UtilCalendar.getGregDay(this.time.weekDay) + ", " + this.time.monthDay + " " + UtilCalendar.getGregMonth(this.time.month) + " " + this.time.year;
    if ((this.showDB) && (paramString != ""))
      str = str + paramString;
    return str;
  }

  private void main()
  {
    final TextView localTextView1 = (TextView)findViewById(2131361801);
    TextView localTextView2 = (TextView)findViewById(2131361802);
    TextView localTextView3 = (TextView)findViewById(2131361803);
    TextView localTextView4 = (TextView)findViewById(2131361793);
    localTextView4.setTextSize((int)(1.5F * this.fontSize));
    localTextView1.setTextSize(this.fontSize);
    localTextView3.setTextSize(this.fontSize);
    localTextView2.setTextSize(this.fontSize);
    int[] arrayOfInt1 = UtilCalendar.getMisriDate(this.time);
    if (this.typeOfCalendar == 0)
      this.specificDate = true;
    int i;
    long l1;
    int j;
    int k;
    label220: String str1;
    int m;
    label274: int n;
    String str3;
    if (this.specificDate)
    {
      localTextView2.setText(formatTextToShow(arrayOfInt1, UtilCalendar.getMiqaat(arrayOfInt1)));
      localTextView2.setVisibility(0);
      localTextView3.setVisibility(0);
      i = UtilCalendar.getDayOfHijriYear(arrayOfInt1);
      l1 = this.time.toMillis(false);
      if (this.typeOfCalendar != 0)
        break label412;
      localTextView4.setText(arrayOfInt1[0] + " " + UtilCalendar.getMisriMonth(arrayOfInt1[1]) + " " + arrayOfInt1[2] + "H");
      j = 0;
      k = 1;
      str1 = "";
      long l2 = 86400000L * j;
      this.time.set(this.time.toMillis(false) - l2);
      this.time.normalize(true);
      if (!this.specificDate)
        j = k;
      m = 0;
      if (m < j)
        break label589;
      localTextView1.setText(str1);
      if (!this.specificDate)
        break label831;
      n = m + 1;
      this.time.set(86400000L + this.time.toMillis(false));
      this.time.normalize(true);
      str3 = "";
      label332: if (n < k)
        break label698;
      localTextView3.setText(str3);
      final ScrollView localScrollView2 = (ScrollView)findViewById(2131361799);
      Runnable local8 = new Runnable()
      {
        public void run()
        {
          localScrollView2.smoothScrollTo(0, localTextView1.getHeight() - 22);
        }
      };
      localScrollView2.post(local8);
    }
    while (true)
    {
      this.time.set(l1);
      this.time.normalize(true);
      return;
      localTextView2.setVisibility(8);
      localTextView3.setVisibility(8);
      break;
      label412: if (this.typeOfCalendar == 1)
      {
        localTextView4.setText(UtilCalendar.getMisriMonth(arrayOfInt1[1]) + " " + arrayOfInt1[2] + "H");
        j = this.time.weekDay;
        k = 7;
        break label220;
      }
      if (this.typeOfCalendar == 2)
      {
        localTextView4.setText(UtilCalendar.getMisriMonth(arrayOfInt1[1]) + " " + arrayOfInt1[2] + "H");
        j = arrayOfInt1[0] - 1;
        k = UtilCalendar.getMonthSize(arrayOfInt1);
        break label220;
      }
      localTextView4.setText(arrayOfInt1[2] + "H");
      j = i - 1;
      k = UtilCalendar.getYearSize(arrayOfInt1);
      break label220;
      label589: int[] arrayOfInt2 = UtilCalendar.getMisriDate(this.time);
      String str2 = UtilCalendar.getMiqaat(arrayOfInt2);
      if ((str2 != "") || (this.showAll) || (!this.showDB))
        str1 = str1 + "\n" + formatTextToShow(arrayOfInt2, str2) + "\n";
      this.time.set(86400000L + this.time.toMillis(false));
      this.time.normalize(true);
      m++;
      break label274;
      label698: int[] arrayOfInt3 = UtilCalendar.getMisriDate(this.time);
      String str4 = UtilCalendar.getMiqaat(arrayOfInt3);
      if ((str4 != "") || (this.showAll) || (!this.showDB))
      {
        if (n != j)
          str3 = str3 + "\n";
        str3 = str3 + formatTextToShow(arrayOfInt3, str4) + "\n";
      }
      this.time.set(86400000L + this.time.toMillis(false));
      this.time.normalize(true);
      n++;
      break label332;
      label831: final ScrollView localScrollView1 = (ScrollView)findViewById(2131361799);
      Runnable local9 = new Runnable()
      {
        public void run()
        {
          localScrollView1.smoothScrollTo(0, 0);
        }
      };
      localScrollView1.post(local9);
    }
  }

  private void processDialog()
  {
    this.datePickerDialog = new Dialog(this);
    this.datePickerDialog.setContentView(2130903041);
    this.DateSpinner = ((Spinner)this.datePickerDialog.findViewById(2131361805));
    this.MonthSpinner = ((Spinner)this.datePickerDialog.findViewById(2131361806));
    this.YearEditText = ((EditText)this.datePickerDialog.findViewById(2131361807));
    ArrayAdapter localArrayAdapter1;
    label108: ArrayAdapter localArrayAdapter2;
    if (this.dialogType)
    {
      this.datePickerDialog.setTitle("Pick a Gregorian Date");
      if (!this.dialogType)
        break label264;
      localArrayAdapter1 = ArrayAdapter.createFromResource(this, 2131099648, 17367048);
      localArrayAdapter1.setDropDownViewResource(17367049);
      this.DateSpinner.setAdapter(localArrayAdapter1);
      if (!this.dialogType)
        break label278;
      localArrayAdapter2 = ArrayAdapter.createFromResource(this, 2131099650, 17367048);
      label141: localArrayAdapter2.setDropDownViewResource(17367049);
      this.MonthSpinner.setAdapter(localArrayAdapter2);
      if (!this.dialogType)
        break label292;
      this.DateSpinner.setSelection(this.time.monthDay - 1);
      this.MonthSpinner.setSelection(this.time.month);
      this.YearEditText.setText(Integer.toString(this.time.year));
    }
    while (true)
    {
      ((Button)this.datePickerDialog.findViewById(2131361808)).setOnClickListener(this.Go);
      ((Button)this.datePickerDialog.findViewById(2131361809)).setOnClickListener(this.Cancel);
      return;
      this.datePickerDialog.setTitle("Pick a Hijri Date");
      break;
      label264: localArrayAdapter1 = ArrayAdapter.createFromResource(this, 2131099649, 17367048);
      break label108;
      label278: localArrayAdapter2 = ArrayAdapter.createFromResource(this, 2131099651, 17367048);
      break label141;
      label292: int[] arrayOfInt = UtilCalendar.getMisriDate(this.time);
      this.DateSpinner.setSelection(arrayOfInt[0] - 1);
      this.MonthSpinner.setSelection(arrayOfInt[1]);
      this.YearEditText.setText(Integer.toString(arrayOfInt[2]));
    }
  }

  private void setToToday()
  {
    this.time.setToNow();
    this.time.normalize(true);
    UtilNamaazTimesCalculator localUtilNamaazTimesCalculator = new UtilNamaazTimesCalculator();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    if ((!localSharedPreferences.contains("SETTING_LAT")) || (!localSharedPreferences.contains("SETTING_LNG")) || (!localSharedPreferences.contains("SETTING_TZ")))
      startActivity(new Intent(this, ActivityLocationSettings.class));
    localUtilNamaazTimesCalculator.setLocation(localSharedPreferences.getFloat("SETTING_LAT", 0.0F), localSharedPreferences.getFloat("SETTING_LNG", 0.0F));
    localUtilNamaazTimesCalculator.setTimezone(localSharedPreferences.getFloat("SETTING_TZ", 0.0F));
    localUtilNamaazTimesCalculator.setTime(this.time);
    if ((localUtilNamaazTimesCalculator.getState()[0] >= 6.0D) && (this.time.hour >= 12))
    {
      this.time.set(86400000L + this.time.toMillis(false));
      this.time.normalize(true);
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903040);
    this.nextbutton = ((Button)findViewById(2131361796));
    this.nextbutton.setOnClickListener(this.Next);
    this.prevbutton = ((Button)findViewById(2131361795));
    this.prevbutton.setOnClickListener(this.Prev);
    this.todaybutton = ((Button)findViewById(2131361794));
    this.todaybutton.setOnClickListener(this.Today);
    this.gregdatebutton = ((Button)findViewById(2131361797));
    this.gregdatebutton.setOnClickListener(this.GregDate);
    this.hijridatebutton = ((Button)findViewById(2131361798));
    this.hijridatebutton.setOnClickListener(this.HijriDate);
  }

  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default:
      this.datePickerDialog = null;
    case 0:
    case 1:
    }
    while (true)
    {
      return this.datePickerDialog;
      processDialog();
      continue;
      processDialog();
    }
  }

  public void onResume()
  {
    super.onResume();
    ((NotificationManager)getSystemService("notification")).cancel(2);
    this.context = getApplicationContext();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    if (!localSharedPreferences.contains("SETTING_SHOWDB"))
    {
      localEditor.putBoolean("SETTING_SHOWDB", true);
      localEditor.commit();
    }
    if (!localSharedPreferences.contains("SETTING_SHOWGREG"))
    {
      localEditor.putBoolean("SETTING_SHOWGREG", true);
      localEditor.commit();
    }
    if (!localSharedPreferences.contains("SETTING_SHOWALL"))
    {
      localEditor.putBoolean("SETTING_SHOWALL", true);
      localEditor.commit();
    }
    if (!localSharedPreferences.contains("SETTING_CALTYPE"))
    {
      localEditor.putInt("SETTING_CALTYPE", 1);
      localEditor.commit();
    }
    this.showGreg = localSharedPreferences.getBoolean("SETTING_SHOWGREG", true);
    this.showAll = localSharedPreferences.getBoolean("SETTING_SHOWALL", true);
    this.showDB = localSharedPreferences.getBoolean("SETTING_SHOWDB", true);
    this.typeOfCalendar = localSharedPreferences.getInt("SETTING_CALTYPE", 1);
    this.fontSize = localSharedPreferences.getInt("SETTING_ACTUAL_FONT_SIZE", 16);
    this.nextbutton.setTextSize(this.fontSize);
    this.prevbutton.setTextSize(this.fontSize);
    this.todaybutton.setTextSize(this.fontSize);
    this.gregdatebutton.setTextSize(this.fontSize);
    this.hijridatebutton.setTextSize(this.fontSize);
    if (this.typeOfCalendar == 0)
      this.Offset = 86400000L;
    while (true)
    {
      main();
      return;
      if (this.typeOfCalendar == 1)
        this.Offset = 604800000L;
      else if (this.typeOfCalendar == 2)
        this.Offset = 2551440000L;
      else
        this.Offset = 30617280000L;
    }
  }

  public void onStart()
  {
    super.onStart();
    this.specificDate = true;
    setToToday();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     dawoodibohra.salaat.ActivityCalendar
 * JD-Core Version:    0.6.2
 */