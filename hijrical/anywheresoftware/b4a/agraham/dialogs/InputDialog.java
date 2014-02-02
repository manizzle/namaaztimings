package anywheresoftware.b4a.agraham.dialogs;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.text.Editable;
import android.text.method.PasswordTransformationMethod;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TableLayout;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import android.widget.TimePicker;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.Msgbox;
import anywheresoftware.b4a.Msgbox.DialogResponse;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.keywords.DateTime;
import anywheresoftware.b4a.keywords.constants.Colors;
import anywheresoftware.b4a.objects.SimpleListAdapter;
import anywheresoftware.b4a.objects.SimpleListAdapter.SingleLineData;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.NoSuchElementException;

@BA.Author("Andrew Graham")
@BA.ShortName("InputDialog")
@BA.Version(2.92F)
@BA.ActivityObject
public class InputDialog
{
  public static final int INPUT_TYPE_DECIMAL_NUMBERS = 12290;
  public static final int INPUT_TYPE_NONE = 0;
  public static final int INPUT_TYPE_NUMBERS = 2;
  public static final int INPUT_TYPE_PHONE = 3;
  public static final int INPUT_TYPE_TEXT = 1;
  private static final double version = 2.92D;
  private String hint = "";
  private int hintcolor = -12303292;
  private String input = "";
  private int inputtype = 1;
  private boolean password = false;
  private int response;

  public void LIBRARY_DOC()
  {
  }

  public int Show(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, BA paramBA, Bitmap paramBitmap)
  {
    AlertDialog localAlertDialog = new AlertDialog.Builder(paramBA.context).create();
    float f = paramBA.context.getResources().getDisplayMetrics().density;
    int i = (int)(20.0F * f);
    int j = (int)(10.0F * f);
    LinearLayout localLinearLayout = new LinearLayout(paramBA.context);
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -1);
    localLinearLayout.setLayoutParams(localLayoutParams1);
    localLinearLayout.setOrientation(1);
    TextView localTextView = new TextView(paramBA.context);
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams2.setMargins(i, 0, j, 0);
    localTextView.setLayoutParams(localLayoutParams2);
    localTextView.setGravity(3);
    localTextView.setText(paramString1);
    localLinearLayout.addView(localTextView);
    EditText localEditText = new EditText(paramBA.context);
    LinearLayout.LayoutParams localLayoutParams3 = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams3.setMargins(j, 0, j, 0);
    localEditText.setLayoutParams(localLayoutParams3);
    localEditText.setGravity(7);
    localEditText.setHorizontallyScrolling(true);
    localEditText.setText(this.input);
    localEditText.setInputType(this.inputtype);
    if (this.password)
      localEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
    while (true)
    {
      if (this.hint != "")
      {
        localEditText.setHint(this.hint);
        localEditText.setHintTextColor(this.hintcolor);
      }
      localLinearLayout.addView(localEditText);
      localAlertDialog.setView(localLinearLayout);
      Msgbox.DialogResponse localDialogResponse = new Msgbox.DialogResponse(false);
      localAlertDialog.setTitle(paramString2);
      if (paramString3.length() > 0)
        localAlertDialog.setButton(-1, paramString3, localDialogResponse);
      if (paramString5.length() > 0)
        localAlertDialog.setButton(-2, paramString5, localDialogResponse);
      if (paramString4.length() > 0)
        localAlertDialog.setButton(-3, paramString4, localDialogResponse);
      if (paramBitmap != null)
      {
        BitmapDrawable localBitmapDrawable = new BitmapDrawable(paramBitmap);
        localAlertDialog.setIcon(localBitmapDrawable);
      }
      Msgbox.msgbox(localAlertDialog, false);
      this.input = localEditText.getText().toString();
      this.response = localDialogResponse.res;
      Msgbox.sendCloseMyLoopMessage();
      Msgbox.waitForMessage(false, true);
      ((InputMethodManager)BA.applicationContext.getSystemService("input_method")).hideSoftInputFromWindow(paramBA.vg.getWindowToken(), 0);
      return localDialogResponse.res;
      localEditText.setTransformationMethod(null);
    }
  }

  public String getHint()
  {
    return this.hint;
  }

  public int getHintColor()
  {
    return this.hintcolor;
  }

  public String getInput()
  {
    return this.input;
  }

  public int getInputType()
  {
    return this.inputtype;
  }

  public boolean getPasswordMode()
  {
    return this.password;
  }

  public int getResponse()
  {
    return this.response;
  }

  public double getVersion()
  {
    return 2.92D;
  }

  public void setHint(String paramString)
  {
    this.hint = paramString;
  }

  public void setHintColor(int paramInt)
  {
    this.hintcolor = paramInt;
  }

  public void setInput(String paramString)
  {
    this.input = paramString;
  }

  public void setInputType(int paramInt)
  {
    this.inputtype = paramInt;
  }

  public void setPasswordMode(boolean paramBoolean)
  {
    this.password = paramBoolean;
  }

  @BA.ShortName("ColorDialog")
  @BA.ActivityObject
  public static class ColorDialog
  {
    private int blue;
    private int green;
    private int red;
    private int response;

    private GradientDrawable getColor(int paramInt, float paramFloat)
    {
      GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[] { paramInt, paramInt });
      localGradientDrawable.setCornerRadius(paramFloat);
      return localGradientDrawable;
    }

    public int ARGB(int paramInt)
    {
      return Color.argb(paramInt, this.red, this.green, this.blue);
    }

    public int Show(String paramString1, String paramString2, String paramString3, String paramString4, BA paramBA, Bitmap paramBitmap)
    {
      AlertDialog localAlertDialog = new AlertDialog.Builder(paramBA.context).create();
      float f = paramBA.context.getResources().getDisplayMetrics().density;
      int i = (int)(20.0F * f);
      int j = (int)(10.0F * f);
      final int k = (int)(5.0F * f);
      LinearLayout localLinearLayout = new LinearLayout(paramBA.context);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
      localLinearLayout.setLayoutParams(localLayoutParams1);
      localLinearLayout.setOrientation(1);
      final TextView localTextView1 = new TextView(paramBA.context);
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -1);
      localLayoutParams2.setMargins(i, j, i, i);
      localLayoutParams2.height = (i * 2);
      localTextView1.setLayoutParams(localLayoutParams2);
      localTextView1.setBackgroundDrawable(getColor(Color.argb(255, this.red, this.green, this.blue), k));
      localLinearLayout.addView(localTextView1);
      final TextView localTextView2 = new TextView(paramBA.context);
      LinearLayout.LayoutParams localLayoutParams3 = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams3.setMargins(i, 0, i, 0);
      localTextView2.setLayoutParams(localLayoutParams3);
      localTextView2.setGravity(3);
      localTextView2.setText(Integer.toString(this.red));
      localLinearLayout.addView(localTextView2);
      SeekBar localSeekBar1 = new SeekBar(paramBA.context);
      localSeekBar1.setMax(255);
      localSeekBar1.setProgress(this.red);
      localSeekBar1.setBackgroundDrawable(getColor(-65536, k));
      LinearLayout.LayoutParams localLayoutParams4 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams4.setMargins(j, j, j, j);
      localSeekBar1.setLayoutParams(localLayoutParams4);
      localLinearLayout.addView(localSeekBar1);
      SeekBar.OnSeekBarChangeListener local1 = new SeekBar.OnSeekBarChangeListener()
      {
        public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          InputDialog.ColorDialog.this.red = paramAnonymousInt;
          localTextView2.setText(Integer.toString(paramAnonymousInt));
          localTextView1.setBackgroundDrawable(InputDialog.ColorDialog.this.getColor(Color.argb(255, InputDialog.ColorDialog.this.red, InputDialog.ColorDialog.this.green, InputDialog.ColorDialog.this.blue), k));
        }

        public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
        {
        }

        public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
        {
        }
      };
      localSeekBar1.setOnSeekBarChangeListener(local1);
      final TextView localTextView3 = new TextView(paramBA.context);
      localTextView3.setLayoutParams(localLayoutParams3);
      localTextView3.setGravity(3);
      localTextView3.setText(Integer.toString(this.green));
      localLinearLayout.addView(localTextView3);
      SeekBar localSeekBar2 = new SeekBar(paramBA.context);
      localSeekBar2.setMax(255);
      localSeekBar2.setProgress(this.green);
      localSeekBar2.setBackgroundDrawable(getColor(-16711936, k));
      localSeekBar2.setLayoutParams(localLayoutParams4);
      localLinearLayout.addView(localSeekBar2);
      SeekBar.OnSeekBarChangeListener local2 = new SeekBar.OnSeekBarChangeListener()
      {
        public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          InputDialog.ColorDialog.this.green = paramAnonymousInt;
          localTextView3.setText(Integer.toString(paramAnonymousInt));
          localTextView1.setBackgroundDrawable(InputDialog.ColorDialog.this.getColor(Color.argb(255, InputDialog.ColorDialog.this.red, InputDialog.ColorDialog.this.green, InputDialog.ColorDialog.this.blue), k));
        }

        public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
        {
        }

        public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
        {
        }
      };
      localSeekBar2.setOnSeekBarChangeListener(local2);
      final TextView localTextView4 = new TextView(paramBA.context);
      localTextView4.setLayoutParams(localLayoutParams3);
      localTextView4.setGravity(3);
      localTextView4.setText(Integer.toString(this.blue));
      localLinearLayout.addView(localTextView4);
      SeekBar localSeekBar3 = new SeekBar(paramBA.context);
      localSeekBar3.setMax(255);
      localSeekBar3.setProgress(this.blue);
      localSeekBar3.setBackgroundDrawable(getColor(-16776961, k));
      localSeekBar3.setLayoutParams(localLayoutParams4);
      SeekBar.OnSeekBarChangeListener local3 = new SeekBar.OnSeekBarChangeListener()
      {
        public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          InputDialog.ColorDialog.this.blue = paramAnonymousInt;
          localTextView4.setText(Integer.toString(paramAnonymousInt));
          localTextView1.setBackgroundDrawable(InputDialog.ColorDialog.this.getColor(Color.argb(255, InputDialog.ColorDialog.this.red, InputDialog.ColorDialog.this.green, InputDialog.ColorDialog.this.blue), k));
        }

        public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
        {
        }

        public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
        {
        }
      };
      localSeekBar3.setOnSeekBarChangeListener(local3);
      localLinearLayout.addView(localSeekBar3);
      localAlertDialog.setView(localLinearLayout);
      Msgbox.DialogResponse localDialogResponse = new Msgbox.DialogResponse(false);
      localAlertDialog.setTitle(paramString1);
      if (paramString2.length() > 0)
        localAlertDialog.setButton(-1, paramString2, localDialogResponse);
      if (paramString4.length() > 0)
        localAlertDialog.setButton(-2, paramString4, localDialogResponse);
      if (paramString3.length() > 0)
        localAlertDialog.setButton(-3, paramString3, localDialogResponse);
      if (paramBitmap != null)
      {
        BitmapDrawable localBitmapDrawable = new BitmapDrawable(paramBitmap);
        localAlertDialog.setIcon(localBitmapDrawable);
      }
      Msgbox.msgbox(localAlertDialog, false);
      this.red = localSeekBar1.getProgress();
      this.green = localSeekBar2.getProgress();
      this.blue = localSeekBar3.getProgress();
      this.response = localDialogResponse.res;
      return localDialogResponse.res;
    }

    public int getBlue()
    {
      return this.blue;
    }

    public int getGreen()
    {
      return this.green;
    }

    public int getRGB()
    {
      return Color.rgb(this.red, this.green, this.blue);
    }

    public int getRed()
    {
      return this.red;
    }

    public int getResponse()
    {
      return this.response;
    }

    public double getVersion()
    {
      return 2.92D;
    }

    public void setBlue(int paramInt)
    {
      this.blue = paramInt;
    }

    public void setGreen(int paramInt)
    {
      this.green = paramInt;
    }

    public void setRGB(int paramInt)
    {
      this.red = Color.red(paramInt);
      this.green = Color.green(paramInt);
      this.blue = Color.blue(paramInt);
    }

    public void setRed(int paramInt)
    {
      this.red = paramInt;
    }
  }

  @BA.ShortName("ColorDialogHSV")
  @BA.ActivityObject
  public static class ColorDialogHSV
  {
    private float[] hsv = new float[3];
    private int response;

    private GradientDrawable getColor(int paramInt, float paramFloat)
    {
      GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[] { paramInt, paramInt });
      localGradientDrawable.setCornerRadius(paramFloat);
      return localGradientDrawable;
    }

    private GradientDrawable getGradient(int[] paramArrayOfInt, float paramFloat)
    {
      GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, paramArrayOfInt);
      localGradientDrawable.setCornerRadius(paramFloat);
      return localGradientDrawable;
    }

    public int ARGB(int paramInt)
    {
      return Color.HSVToColor(paramInt, this.hsv);
    }

    public int Show(String paramString1, String paramString2, String paramString3, String paramString4, BA paramBA, Bitmap paramBitmap)
    {
      AlertDialog localAlertDialog = new AlertDialog.Builder(paramBA.context).create();
      float f = paramBA.context.getResources().getDisplayMetrics().density;
      int i = (int)(20.0F * f);
      int j = (int)(10.0F * f);
      final int k = (int)(5.0F * f);
      LinearLayout localLinearLayout = new LinearLayout(paramBA.context);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
      localLinearLayout.setLayoutParams(localLayoutParams1);
      localLinearLayout.setOrientation(1);
      final TextView localTextView1 = new TextView(paramBA.context);
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -1);
      localLayoutParams2.setMargins(i, j, i, i);
      localLayoutParams2.height = (i * 2);
      localTextView1.setLayoutParams(localLayoutParams2);
      localTextView1.setBackgroundDrawable(getColor(Color.HSVToColor(this.hsv), k));
      localLinearLayout.addView(localTextView1);
      final TextView localTextView2 = new TextView(paramBA.context);
      LinearLayout.LayoutParams localLayoutParams3 = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams3.setMargins(i, 0, i, 0);
      localTextView2.setLayoutParams(localLayoutParams3);
      localTextView2.setGravity(3);
      localTextView2.setText("Hue = " + Float.toString(this.hsv[0]));
      localLinearLayout.addView(localTextView2);
      SeekBar localSeekBar1 = new SeekBar(paramBA.context);
      localSeekBar1.setMax(3600);
      localSeekBar1.setProgress((int)(10.0F * this.hsv[0]));
      localSeekBar1.setBackgroundDrawable(getGradient(new int[] { -65536, -16711936, -16776961, -65536 }, k));
      LinearLayout.LayoutParams localLayoutParams4 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams4.setMargins(j, j, j, j);
      localSeekBar1.setLayoutParams(localLayoutParams4);
      localLinearLayout.addView(localSeekBar1);
      SeekBar.OnSeekBarChangeListener local1 = new SeekBar.OnSeekBarChangeListener()
      {
        public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          InputDialog.ColorDialogHSV.this.hsv[0] = (paramAnonymousInt / 10.0F);
          localTextView2.setText("Hue = " + Float.toString(InputDialog.ColorDialogHSV.this.hsv[0]));
          localTextView1.setBackgroundDrawable(InputDialog.ColorDialogHSV.this.getColor(Color.HSVToColor(InputDialog.ColorDialogHSV.this.hsv), k));
        }

        public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
        {
        }

        public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
        {
        }
      };
      localSeekBar1.setOnSeekBarChangeListener(local1);
      final TextView localTextView3 = new TextView(paramBA.context);
      localTextView3.setLayoutParams(localLayoutParams3);
      localTextView3.setGravity(3);
      localTextView3.setText("Saturation = " + Float.toString(this.hsv[1]));
      localLinearLayout.addView(localTextView3);
      SeekBar localSeekBar2 = new SeekBar(paramBA.context);
      localSeekBar2.setMax(1000);
      localSeekBar2.setProgress((int)(1000.0F * this.hsv[1]));
      localSeekBar2.setBackgroundDrawable(getGradient(new int[] { -12303292, -1 }, k));
      localSeekBar2.setLayoutParams(localLayoutParams4);
      localLinearLayout.addView(localSeekBar2);
      SeekBar.OnSeekBarChangeListener local2 = new SeekBar.OnSeekBarChangeListener()
      {
        public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          InputDialog.ColorDialogHSV.this.hsv[1] = (paramAnonymousInt / 1000.0F);
          localTextView3.setText("Saturation = " + Float.toString(InputDialog.ColorDialogHSV.this.hsv[1]));
          localTextView1.setBackgroundDrawable(InputDialog.ColorDialogHSV.this.getColor(Color.HSVToColor(InputDialog.ColorDialogHSV.this.hsv), k));
        }

        public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
        {
        }

        public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
        {
        }
      };
      localSeekBar2.setOnSeekBarChangeListener(local2);
      final TextView localTextView4 = new TextView(paramBA.context);
      localTextView4.setLayoutParams(localLayoutParams3);
      localTextView4.setGravity(3);
      localTextView4.setText("Value = " + Float.toString(this.hsv[2]));
      localLinearLayout.addView(localTextView4);
      SeekBar localSeekBar3 = new SeekBar(paramBA.context);
      localSeekBar3.setMax(1000);
      localSeekBar3.setProgress((int)(1000.0F * this.hsv[2]));
      localSeekBar3.setBackgroundDrawable(getGradient(new int[] { -12303292, -1 }, k));
      localSeekBar3.setLayoutParams(localLayoutParams4);
      SeekBar.OnSeekBarChangeListener local3 = new SeekBar.OnSeekBarChangeListener()
      {
        public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          InputDialog.ColorDialogHSV.this.hsv[2] = (paramAnonymousInt / 1000.0F);
          localTextView4.setText("Value = " + Float.toString(InputDialog.ColorDialogHSV.this.hsv[2]));
          localTextView1.setBackgroundDrawable(InputDialog.ColorDialogHSV.this.getColor(Color.HSVToColor(InputDialog.ColorDialogHSV.this.hsv), k));
        }

        public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
        {
        }

        public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
        {
        }
      };
      localSeekBar3.setOnSeekBarChangeListener(local3);
      localLinearLayout.addView(localSeekBar3);
      localAlertDialog.setView(localLinearLayout);
      Msgbox.DialogResponse localDialogResponse = new Msgbox.DialogResponse(false);
      localAlertDialog.setTitle(paramString1);
      if (paramString2.length() > 0)
        localAlertDialog.setButton(-1, paramString2, localDialogResponse);
      if (paramString4.length() > 0)
        localAlertDialog.setButton(-2, paramString4, localDialogResponse);
      if (paramString3.length() > 0)
        localAlertDialog.setButton(-3, paramString3, localDialogResponse);
      if (paramBitmap != null)
      {
        BitmapDrawable localBitmapDrawable = new BitmapDrawable(paramBitmap);
        localAlertDialog.setIcon(localBitmapDrawable);
      }
      Msgbox.msgbox(localAlertDialog, false);
      this.response = localDialogResponse.res;
      return localDialogResponse.res;
    }

    public float getHue()
    {
      return this.hsv[0];
    }

    public int getRGB()
    {
      return Color.HSVToColor(this.hsv);
    }

    public int getResponse()
    {
      return this.response;
    }

    public float getSaturation()
    {
      return this.hsv[1];
    }

    public float getValue()
    {
      return this.hsv[2];
    }

    public double getVersion()
    {
      return 2.92D;
    }

    public void setHue(float paramFloat)
    {
      this.hsv[0] = paramFloat;
    }

    public void setRGB(int paramInt)
    {
      Color.colorToHSV(paramInt, this.hsv);
    }

    public void setSaturation(float paramFloat)
    {
      this.hsv[1] = paramFloat;
    }

    public void setValue(float paramFloat)
    {
      this.hsv[2] = paramFloat;
    }
  }

  @BA.ShortName("ColorPickerDialog")
  @BA.ActivityObject
  public static class ColorPickerDialog
  {
    private int chosen;
    int green = Colors.RGB(0, 128, 0);
    int maroon = Colors.RGB(128, 0, 0);
    int navy = Colors.RGB(0, 0, 128);
    int orange = Colors.RGB(255, 140, 0);
    private int[] palette;
    private int response;
    int royalblue = Colors.RGB(65, 105, 225);
    int springgreen = Colors.RGB(0, 255, 127);
    private int[] stdpalette;

    public ColorPickerDialog()
    {
      int[] arrayOfInt = new int[15];
      arrayOfInt[0] = -65536;
      arrayOfInt[1] = -65281;
      arrayOfInt[2] = this.orange;
      arrayOfInt[3] = this.maroon;
      arrayOfInt[4] = -16777216;
      arrayOfInt[5] = -16711936;
      arrayOfInt[6] = -256;
      arrayOfInt[7] = this.springgreen;
      arrayOfInt[8] = this.green;
      arrayOfInt[9] = -3355444;
      arrayOfInt[10] = -16776961;
      arrayOfInt[11] = -16711681;
      arrayOfInt[12] = this.royalblue;
      arrayOfInt[13] = this.navy;
      arrayOfInt[14] = -1;
      this.stdpalette = arrayOfInt;
      this.palette = new int[this.stdpalette.length];
      ResetPalette();
    }

    private GradientDrawable getColor(int paramInt, float paramFloat)
    {
      GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[] { paramInt, paramInt });
      localGradientDrawable.setCornerRadius(paramFloat);
      return localGradientDrawable;
    }

    public int ARGB(int paramInt)
    {
      return Color.argb(paramInt, 0xFF & this.chosen >> 16, 0xFF & this.chosen >> 8, 0xFF & this.chosen);
    }

    public int GetPaletteAt(int paramInt)
    {
      return this.palette[paramInt];
    }

    public void ResetPalette()
    {
      for (int i = 0; ; i++)
      {
        if (i >= this.stdpalette.length)
          return;
        this.palette[i] = this.stdpalette[i];
      }
    }

    public void SetPaletteAt(int paramInt1, int paramInt2)
    {
      this.palette[paramInt1] = (0xFF000000 | paramInt2);
    }

    public int Show(String paramString1, String paramString2, String paramString3, String paramString4, BA paramBA, Bitmap paramBitmap)
    {
      AlertDialog localAlertDialog = new AlertDialog.Builder(paramBA.context).create();
      float f = paramBA.context.getResources().getDisplayMetrics().density;
      int i = (int)(40.0F * f);
      int j = (int)(20.0F * f);
      int k = (int)(10.0F * f);
      final int m = (int)(5.0F * f);
      LinearLayout localLinearLayout = new LinearLayout(paramBA.context);
      localLinearLayout.setOrientation(1);
      final TextView localTextView1 = new TextView(paramBA.context);
      TableRow.LayoutParams localLayoutParams1 = new TableRow.LayoutParams(-1, -1);
      localLayoutParams1.setMargins(j, k, j, j);
      localLayoutParams1.height = i;
      localLayoutParams1.width = -1;
      localTextView1.setLayoutParams(localLayoutParams1);
      localTextView1.setBackgroundDrawable(getColor(this.chosen, m));
      localLinearLayout.addView(localTextView1);
      TableLayout localTableLayout = new TableLayout(paramBA.context);
      TableLayout.LayoutParams localLayoutParams = new TableLayout.LayoutParams(-1, -2);
      localTableLayout.setLayoutParams(localLayoutParams);
      localTableLayout.setOrientation(1);
      localTableLayout.setStretchAllColumns(true);
      int n = 0;
      if (n >= 3)
      {
        localLinearLayout.addView(localTableLayout);
        localAlertDialog.setView(localLinearLayout);
        Msgbox.DialogResponse localDialogResponse = new Msgbox.DialogResponse(false);
        localAlertDialog.setTitle(paramString1);
        if (paramString2.length() > 0)
          localAlertDialog.setButton(-1, paramString2, localDialogResponse);
        if (paramString4.length() > 0)
          localAlertDialog.setButton(-2, paramString4, localDialogResponse);
        if (paramString3.length() > 0)
          localAlertDialog.setButton(-3, paramString3, localDialogResponse);
        if (paramBitmap != null)
        {
          BitmapDrawable localBitmapDrawable = new BitmapDrawable(paramBitmap);
          localAlertDialog.setIcon(localBitmapDrawable);
        }
        Msgbox.msgbox(localAlertDialog, false);
        this.response = localDialogResponse.res;
        return localDialogResponse.res;
      }
      TableRow localTableRow = new TableRow(paramBA.context);
      for (int i1 = 0; ; i1++)
      {
        if (i1 >= 5)
        {
          localTableLayout.addView(localTableRow);
          n++;
          break;
        }
        TextView localTextView2 = new TextView(paramBA.context);
        TableRow.LayoutParams localLayoutParams2 = new TableRow.LayoutParams(-1, -1);
        localLayoutParams2.setMargins(m, m, m, 5);
        localLayoutParams2.height = i;
        localLayoutParams2.width = -1;
        localTextView2.setLayoutParams(localLayoutParams2);
        localTextView2.setTag(Integer.valueOf(this.palette[(i1 + n * 5)]));
        localTextView2.setBackgroundDrawable(getColor(this.palette[(i1 + n * 5)], m));
        View.OnClickListener local1 = new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            InputDialog.ColorPickerDialog.this.chosen = ((Integer)paramAnonymousView.getTag()).intValue();
            localTextView1.setBackgroundDrawable(InputDialog.ColorPickerDialog.this.getColor(InputDialog.ColorPickerDialog.this.chosen, m));
          }
        };
        localTextView2.setOnClickListener(local1);
        localTableRow.addView(localTextView2);
      }
    }

    public int[] getPalette()
    {
      int[] arrayOfInt = new int[this.palette.length];
      for (int i = 0; ; i++)
      {
        if (i >= this.palette.length)
          return arrayOfInt;
        arrayOfInt[i] = this.palette[i];
      }
    }

    public int getRGB()
    {
      return this.chosen;
    }

    public int getResponse()
    {
      return this.response;
    }

    public double getVersion()
    {
      return 2.92D;
    }

    public void setPalette(int[] paramArrayOfInt)
    {
      int i = Math.min(15, paramArrayOfInt.length);
      for (int j = 0; ; j++)
      {
        if (j >= i)
          return;
        this.palette[j] = paramArrayOfInt[j];
      }
    }

    public void setRGB(int paramInt)
    {
      this.chosen = (0xFF000000 | paramInt);
    }
  }

  @BA.ShortName("CustomDialog")
  @BA.ActivityObject
  public static class CustomDialog
  {
    private View cview;
    private int response;

    public void AddView(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.cview = paramView;
      AbsoluteLayout.LayoutParams localLayoutParams = new AbsoluteLayout.LayoutParams(paramInt3, paramInt4, paramInt1, paramInt2);
      this.cview.setLayoutParams(localLayoutParams);
    }

    public int Show(String paramString1, String paramString2, String paramString3, String paramString4, BA paramBA, Bitmap paramBitmap)
      throws RuntimeException
    {
      AlertDialog localAlertDialog = new AlertDialog.Builder(paramBA.context).create();
      AbsoluteLayout localAbsoluteLayout = new AbsoluteLayout(paramBA.context);
      localAbsoluteLayout.setLayoutParams(new AbsoluteLayout.LayoutParams(0, 0, 0, 0));
      localAbsoluteLayout.addView(this.cview);
      localAlertDialog.setView(localAbsoluteLayout);
      Msgbox.DialogResponse localDialogResponse = new Msgbox.DialogResponse(false);
      localAlertDialog.setTitle(paramString1);
      if (paramString2.length() > 0)
        localAlertDialog.setButton(-1, paramString2, localDialogResponse);
      if (paramString4.length() > 0)
        localAlertDialog.setButton(-2, paramString4, localDialogResponse);
      if (paramString3.length() > 0)
        localAlertDialog.setButton(-3, paramString3, localDialogResponse);
      if (paramBitmap != null)
        localAlertDialog.setIcon(new BitmapDrawable(paramBitmap));
      Msgbox.msgbox(localAlertDialog, false);
      localAbsoluteLayout.removeView(this.cview);
      this.response = localDialogResponse.res;
      Msgbox.sendCloseMyLoopMessage();
      Msgbox.waitForMessage(false, true);
      ((InputMethodManager)BA.applicationContext.getSystemService("input_method")).hideSoftInputFromWindow(paramBA.vg.getWindowToken(), 0);
      return localDialogResponse.res;
    }

    public int getResponse()
    {
      return this.response;
    }

    public double getVersion()
    {
      return 2.92D;
    }
  }

  @BA.ShortName("CustomDialog2")
  @BA.ActivityObject
  public static class CustomDialog2
  {
    private View cview;
    private int response;

    public void AddView(View paramView, int paramInt1, int paramInt2)
    {
      this.cview = paramView;
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt1, paramInt2);
      this.cview.setLayoutParams(localLayoutParams);
    }

    public int Show(String paramString1, String paramString2, String paramString3, String paramString4, BA paramBA, Bitmap paramBitmap)
      throws RuntimeException
    {
      AlertDialog localAlertDialog = new AlertDialog.Builder(paramBA.context).create();
      LinearLayout localLinearLayout = new LinearLayout(paramBA.context);
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
      localLinearLayout.setGravity(17);
      localLinearLayout.setLayoutParams(localLayoutParams);
      localLinearLayout.addView(this.cview);
      localAlertDialog.setView(localLinearLayout);
      Msgbox.DialogResponse localDialogResponse = new Msgbox.DialogResponse(false);
      localAlertDialog.setTitle(paramString1);
      if (paramString2.length() > 0)
        localAlertDialog.setButton(-1, paramString2, localDialogResponse);
      if (paramString4.length() > 0)
        localAlertDialog.setButton(-2, paramString4, localDialogResponse);
      if (paramString3.length() > 0)
        localAlertDialog.setButton(-3, paramString3, localDialogResponse);
      if (paramBitmap != null)
        localAlertDialog.setIcon(new BitmapDrawable(paramBitmap));
      Msgbox.msgbox(localAlertDialog, false);
      localLinearLayout.removeView(this.cview);
      this.response = localDialogResponse.res;
      Msgbox.sendCloseMyLoopMessage();
      Msgbox.waitForMessage(false, true);
      ((InputMethodManager)BA.applicationContext.getSystemService("input_method")).hideSoftInputFromWindow(paramBA.vg.getWindowToken(), 0);
      return localDialogResponse.res;
    }

    public int getResponse()
    {
      return this.response;
    }

    public double getVersion()
    {
      return 2.92D;
    }
  }

  @BA.ShortName("DateDialog")
  @BA.ActivityObject
  public static class DateDialog
  {
    private int day;
    private int month;
    private int response;
    private boolean showcalendar = true;
    private int year;

    public void SetDate(int paramInt1, int paramInt2, int paramInt3)
    {
      this.day = paramInt1;
      this.month = (paramInt2 - 1);
      this.year = paramInt3;
    }

    public int Show(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, BA paramBA, Bitmap paramBitmap)
    {
      AlertDialog localAlertDialog = new AlertDialog.Builder(paramBA.context).create();
      float f = paramBA.context.getResources().getDisplayMetrics().density;
      int i = (int)(20.0F * f);
      int j = (int)(10.0F * f);
      LinearLayout localLinearLayout = new LinearLayout(paramBA.context);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
      localLinearLayout.setLayoutParams(localLayoutParams1);
      localLinearLayout.setOrientation(1);
      TextView localTextView = new TextView(paramBA.context);
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams2.setMargins(i, 0, j, 0);
      localTextView.setLayoutParams(localLayoutParams2);
      localTextView.setGravity(3);
      localTextView.setText(paramString1);
      localLinearLayout.addView(localTextView);
      DatePicker localDatePicker = new DatePicker(paramBA.context);
      localDatePicker.updateDate(this.year, this.month, this.day);
      localLinearLayout.addView(localDatePicker);
      localAlertDialog.setView(localLinearLayout);
      try
      {
        Class localClass = localDatePicker.getClass();
        Class[] arrayOfClass = new Class[1];
        arrayOfClass[0] = Boolean.TYPE;
        Method localMethod = localClass.getMethod("setCalendarViewShown", arrayOfClass);
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Boolean.valueOf(this.showcalendar);
        localMethod.invoke(localDatePicker, arrayOfObject);
        label255: Msgbox.DialogResponse localDialogResponse = new Msgbox.DialogResponse(false);
        localAlertDialog.setTitle(paramString2);
        if (paramString3.length() > 0)
          localAlertDialog.setButton(-1, paramString3, localDialogResponse);
        if (paramString5.length() > 0)
          localAlertDialog.setButton(-2, paramString5, localDialogResponse);
        if (paramString4.length() > 0)
          localAlertDialog.setButton(-3, paramString4, localDialogResponse);
        if (paramBitmap != null)
        {
          BitmapDrawable localBitmapDrawable = new BitmapDrawable(paramBitmap);
          localAlertDialog.setIcon(localBitmapDrawable);
        }
        Msgbox.msgbox(localAlertDialog, false);
        localDatePicker.clearFocus();
        this.year = localDatePicker.getYear();
        this.month = localDatePicker.getMonth();
        this.day = localDatePicker.getDayOfMonth();
        this.response = localDialogResponse.res;
        return localDialogResponse.res;
      }
      catch (Exception localException)
      {
        break label255;
      }
    }

    public long getDateTicks()
    {
      return new GregorianCalendar(this.year, this.month, this.day, 0, 0).getTimeInMillis();
    }

    public int getDayOfMonth()
    {
      return this.day;
    }

    public int getMonth()
    {
      return 1 + this.month;
    }

    public int getResponse()
    {
      return this.response;
    }

    public boolean getShowCalendar()
    {
      return this.showcalendar;
    }

    public double getVersion()
    {
      return 2.92D;
    }

    public int getYear()
    {
      return this.year;
    }

    public void setDateTicks(long paramLong)
    {
      this.day = DateTime.GetDayOfMonth(paramLong);
      this.month = (DateTime.GetMonth(paramLong) - 1);
      this.year = DateTime.GetYear(paramLong);
    }

    public void setDayOfMonth(int paramInt)
    {
      this.day = paramInt;
    }

    public void setMonth(int paramInt)
    {
      this.month = (paramInt - 1);
    }

    public void setShowCalendar(boolean paramBoolean)
    {
      this.showcalendar = paramBoolean;
    }

    public void setYear(int paramInt)
    {
      this.year = paramInt;
    }
  }

  @BA.ShortName("FileDialog")
  @BA.ActivityObject
  public static class FileDialog
  {
    private String chosenname = "";
    private boolean fastscroll = false;
    private String[] fileList;
    private File filepath = new File("//");
    private String fileseparator = "↓ Files ↓";
    private String ftype = "";
    private String[] ftypes = this.ftype.split(",");
    private boolean keyboardpopup = true;
    private boolean onlyfolders = false;
    private int response;
    private int scrollcol = Colors.ARGB(230, 72, 72, 72);

    private void loadFileList(SimpleListAdapter paramSimpleListAdapter)
      throws RuntimeException
    {
      final ArrayList localArrayList1 = new ArrayList();
      final ArrayList localArrayList2 = new ArrayList();
      paramSimpleListAdapter.items.clear();
      String[] arrayOfString1;
      String[] arrayOfString2;
      if (this.filepath.exists())
      {
        FilenameFilter local1 = new FilenameFilter()
        {
          public boolean accept(File paramAnonymousFile, String paramAnonymousString)
          {
            if (new File(paramAnonymousFile, paramAnonymousString).isDirectory())
            {
              localArrayList1.add(paramAnonymousString);
              return true;
            }
            for (int i = 0; ; i++)
            {
              if (i >= InputDialog.FileDialog.this.ftypes.length)
                return false;
              if ((paramAnonymousString.contains(InputDialog.FileDialog.this.ftypes[i])) || (InputDialog.FileDialog.this.ftype == ""))
              {
                localArrayList2.add(paramAnonymousString);
                return true;
              }
            }
          }
        };
        this.fileList = this.filepath.list(local1);
        arrayOfString1 = (String[])localArrayList1.toArray(new String[0]);
        arrayOfString2 = (String[])localArrayList2.toArray(new String[0]);
        Arrays.sort(arrayOfString1, new sorter(null));
        Arrays.sort(arrayOfString2, new sorter(null));
        if (this.onlyfolders)
        {
          this.fileList = new String[1 + arrayOfString1.length];
          this.fileList[0] = "..";
          System.arraycopy(arrayOfString1, 0, this.fileList, 1, arrayOfString1.length);
        }
      }
      for (int i = 0; ; i++)
      {
        if (i >= this.fileList.length)
        {
          paramSimpleListAdapter.notifyDataSetChanged();
          return;
          this.fileList = new String[2 + (arrayOfString1.length + arrayOfString2.length)];
          this.fileList[0] = "..";
          this.fileList[(1 + arrayOfString1.length)] = this.fileseparator;
          System.arraycopy(arrayOfString1, 0, this.fileList, 1, arrayOfString1.length);
          System.arraycopy(arrayOfString2, 0, this.fileList, 2 + arrayOfString1.length, arrayOfString2.length);
          break;
          throw new RuntimeException("Path '" + this.filepath.getPath() + "'does not exist");
        }
        SimpleListAdapter.SingleLineData localSingleLineData = new SimpleListAdapter.SingleLineData();
        localSingleLineData.Text = this.fileList[i];
        localSingleLineData.ReturnValue = null;
        paramSimpleListAdapter.items.add(localSingleLineData);
      }
    }

    public int Show(String paramString1, String paramString2, String paramString3, String paramString4, BA paramBA, Bitmap paramBitmap)
      throws RuntimeException
    {
      AlertDialog localAlertDialog = new AlertDialog.Builder(paramBA.context).create();
      int i = (int)(10.0F * paramBA.context.getResources().getDisplayMetrics().density);
      LinearLayout localLinearLayout = new LinearLayout(paramBA.context);
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
      localLinearLayout.setLayoutParams(localLayoutParams);
      localLinearLayout.setOrientation(1);
      final EditText localEditText = new EditText(paramBA.context);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams1.setMargins(i, 0, i, 0);
      localEditText.setLayoutParams(localLayoutParams1);
      localEditText.setGravity(7);
      localEditText.setHorizontallyScrolling(true);
      localEditText.setImeOptions(6);
      localEditText.setSingleLine();
      localEditText.setText(this.chosenname);
      localLinearLayout.addView(localEditText);
      final ListView localListView = new ListView(paramBA.context);
      localListView.setFastScrollEnabled(this.fastscroll);
      localListView.setCacheColorHint(this.scrollcol);
      final SimpleListAdapter localSimpleListAdapter = new SimpleListAdapter(paramBA.context);
      localListView.setAdapter(localSimpleListAdapter);
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -2);
      localListView.setLayoutParams(localLayoutParams2);
      loadFileList(localSimpleListAdapter);
      if (!this.keyboardpopup)
        localListView.requestFocus();
      AdapterView.OnItemClickListener local2 = new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          String str = (String)localSimpleListAdapter.getItem(paramAnonymousInt);
          str.equals("..");
          File localFile = new File(InputDialog.FileDialog.this.filepath, str);
          if (localFile.isDirectory())
          {
            localEditText.setText("");
            InputDialog.FileDialog.this.filepath = localFile;
          }
          while (str.equals(InputDialog.FileDialog.this.fileseparator))
            try
            {
              InputDialog.FileDialog.this.loadFileList(localSimpleListAdapter);
              localListView.setSelection(0);
              return;
            }
            catch (RuntimeException localRuntimeException)
            {
              if ((localRuntimeException instanceof NoSuchElementException))
                Common.Log(localRuntimeException.toString() + " " + InputDialog.FileDialog.this.filepath + " " + str);
              throw localRuntimeException;
            }
          localEditText.setText(str);
          InputDialog.FileDialog.this.chosenname = str;
        }
      };
      localListView.setOnItemClickListener(local2);
      localLinearLayout.addView(localListView);
      localAlertDialog.setView(localLinearLayout);
      Msgbox.DialogResponse localDialogResponse = new Msgbox.DialogResponse(false);
      localAlertDialog.setTitle(paramString1);
      if (paramString2.length() > 0)
        localAlertDialog.setButton(-1, paramString2, localDialogResponse);
      if (paramString4.length() > 0)
        localAlertDialog.setButton(-2, paramString4, localDialogResponse);
      if (paramString3.length() > 0)
        localAlertDialog.setButton(-3, paramString3, localDialogResponse);
      if (paramBitmap != null)
      {
        BitmapDrawable localBitmapDrawable = new BitmapDrawable(paramBitmap);
        localAlertDialog.setIcon(localBitmapDrawable);
      }
      Msgbox.msgbox(localAlertDialog, false);
      this.chosenname = localEditText.getText().toString();
      this.response = localDialogResponse.res;
      return localDialogResponse.res;
    }

    public String getChosenName()
    {
      return this.chosenname;
    }

    public boolean getFastScroll()
    {
      return this.fastscroll;
    }

    public String getFileFilter()
    {
      return this.ftype;
    }

    public String getFilePath()
      throws Exception
    {
      return this.filepath.getCanonicalPath();
    }

    public boolean getKeyboardPopUp()
    {
      return this.keyboardpopup;
    }

    public int getResponse()
    {
      return this.response;
    }

    public int getScrollingBackgroundColor()
    {
      return this.scrollcol;
    }

    public boolean getShowOnlyFolders()
    {
      return this.onlyfolders;
    }

    public double getVersion()
    {
      return 2.92D;
    }

    public void setChosenName(String paramString)
    {
      this.chosenname = paramString;
    }

    public void setFastScroll(boolean paramBoolean)
    {
      this.fastscroll = paramBoolean;
    }

    public void setFileFilter(String paramString)
    {
      this.ftype = paramString;
      this.ftypes = this.ftype.split(",");
    }

    public void setFilePath(String paramString)
    {
      this.filepath = new File(paramString, "//");
      this.chosenname = "";
    }

    public void setKeyboardPopUp(boolean paramBoolean)
    {
      this.keyboardpopup = paramBoolean;
    }

    public void setScrollingBackgroundColor(int paramInt)
    {
      this.scrollcol = paramInt;
    }

    public void setShowOnlyFolders(boolean paramBoolean)
    {
      this.onlyfolders = paramBoolean;
    }

    private class sorter
      implements Comparator<String>
    {
      private sorter()
      {
      }

      public int compare(String paramString1, String paramString2)
      {
        return paramString1.compareToIgnoreCase(paramString2);
      }
    }
  }

  @BA.ShortName("NumberDialog")
  @BA.ActivityObject
  public static class NumberDialog
  {
    private int decimal = 0;
    private char decimalchar = '.';
    private TextView[] figures = new TextView[9];
    private final int maxdigits = 9;
    private boolean negative = false;
    private int[] numbers = new int[9];
    private int numdigits = 5;
    private int response;
    private boolean showsign = false;

    public int Show(String paramString1, String paramString2, String paramString3, String paramString4, BA paramBA, Bitmap paramBitmap)
    {
      AlertDialog localAlertDialog = new AlertDialog.Builder(paramBA.context).create();
      float f = paramBA.context.getResources().getDisplayMetrics().density;
      int i = (int)(50.0F * f);
      int j = (int)(40.0F * f);
      int k = (int)(5.0F * f);
      TableLayout localTableLayout = new TableLayout(paramBA.context);
      TableLayout.LayoutParams localLayoutParams = new TableLayout.LayoutParams(-1, -2);
      localTableLayout.setLayoutParams(localLayoutParams);
      localTableLayout.setOrientation(1);
      localTableLayout.setStretchAllColumns(true);
      TableRow localTableRow1 = new TableRow(paramBA.context);
      int m = this.numdigits - 1;
      TableRow localTableRow2;
      int n;
      TableRow localTableRow3;
      if (m < 0)
      {
        localTableLayout.addView(localTableRow1);
        localTableRow2 = new TableRow(paramBA.context);
        n = this.numdigits - 1;
        if (n >= 0)
          break label442;
        localTableLayout.addView(localTableRow2);
        localTableRow3 = new TableRow(paramBA.context);
      }
      for (int i2 = this.numdigits - 1; ; i2--)
      {
        if (i2 < 0)
        {
          localTableLayout.addView(localTableRow3);
          localAlertDialog.setView(localTableLayout);
          Msgbox.DialogResponse localDialogResponse = new Msgbox.DialogResponse(false);
          localAlertDialog.setTitle(paramString1);
          if (paramString2.length() > 0)
            localAlertDialog.setButton(-1, paramString2, localDialogResponse);
          if (paramString4.length() > 0)
            localAlertDialog.setButton(-2, paramString4, localDialogResponse);
          if (paramString3.length() > 0)
            localAlertDialog.setButton(-3, paramString3, localDialogResponse);
          if (paramBitmap != null)
          {
            BitmapDrawable localBitmapDrawable = new BitmapDrawable(paramBitmap);
            localAlertDialog.setIcon(localBitmapDrawable);
          }
          Msgbox.msgbox(localAlertDialog, false);
          this.response = localDialogResponse.res;
          return localDialogResponse.res;
          Button localButton1 = new Button(paramBA.context);
          TableRow.LayoutParams localLayoutParams1 = new TableRow.LayoutParams(-1, -1);
          localLayoutParams1.setMargins(0, 0, 0, 0);
          localLayoutParams1.height = i;
          localLayoutParams1.width = -1;
          localButton1.setLayoutParams(localLayoutParams1);
          localButton1.setPadding(0, -k, 0, 0);
          localButton1.setText("+");
          localButton1.setTextSize(32.0F);
          localButton1.setTag(Integer.valueOf(m));
          View.OnClickListener local1 = new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              int i = ((Integer)paramAnonymousView.getTag()).intValue();
              if ((InputDialog.NumberDialog.this.showsign) && (i == InputDialog.NumberDialog.this.numdigits - 1))
                InputDialog.NumberDialog.this.figures[i].setText("+");
              do
              {
                return;
                int[] arrayOfInt = InputDialog.NumberDialog.this.numbers;
                arrayOfInt[i] = (1 + arrayOfInt[i]);
                if (InputDialog.NumberDialog.this.numbers[i] > 9)
                  InputDialog.NumberDialog.this.numbers[i] = 0;
                InputDialog.NumberDialog.this.figures[i].setText(Integer.toString(InputDialog.NumberDialog.this.numbers[i]));
              }
              while ((InputDialog.NumberDialog.this.decimal <= 0) || (InputDialog.NumberDialog.this.decimal != i));
              InputDialog.NumberDialog.this.figures[i].setText(Integer.toString(InputDialog.NumberDialog.this.numbers[i]) + InputDialog.NumberDialog.this.decimalchar);
            }
          };
          localButton1.setOnClickListener(local1);
          localTableRow1.addView(localButton1);
          m--;
          break;
          label442: TextView localTextView1 = new TextView(paramBA.context);
          TableRow.LayoutParams localLayoutParams2 = new TableRow.LayoutParams(-1, -1);
          localLayoutParams2.setMargins(0, 0, 0, 0);
          localLayoutParams2.height = j;
          localLayoutParams2.width = -1;
          localTextView1.setLayoutParams(localLayoutParams2);
          localTextView1.setPadding(0, 0, 0, 0);
          localTextView1.setGravity(17);
          localTextView1.setText(Integer.toString(this.numbers[n]));
          if ((this.decimal > 0) && (this.decimal == n))
            localTextView1.setText(Integer.toString(this.numbers[n]) + this.decimalchar);
          localTextView1.setTextSize(32.0F);
          localTextView1.setTag(Integer.valueOf(n));
          localTableRow2.addView(localTextView1);
          this.figures[n] = localTextView1;
          TextView localTextView2;
          if (this.showsign)
          {
            int i1 = this.numdigits - 1;
            if (n == i1)
            {
              localTextView2 = this.figures[n];
              if (!this.negative)
                break label666;
            }
          }
          label666: for (String str = "-"; ; str = "+")
          {
            localTextView2.setText(str);
            n--;
            break;
          }
        }
        Button localButton2 = new Button(paramBA.context);
        TableRow.LayoutParams localLayoutParams3 = new TableRow.LayoutParams(-1, -1);
        localLayoutParams3.setMargins(0, 0, 0, 0);
        localLayoutParams3.height = i;
        localLayoutParams3.width = -1;
        localButton2.setLayoutParams(localLayoutParams3);
        localButton2.setPadding(0, -k, 0, 0);
        localButton2.setText("-");
        localButton2.setTextSize(32.0F);
        localButton2.setTag(Integer.valueOf(i2));
        View.OnClickListener local2 = new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            if ((InputDialog.NumberDialog.this.showsign) && (i == InputDialog.NumberDialog.this.numdigits - 1))
              InputDialog.NumberDialog.this.figures[i].setText("-");
            do
            {
              return;
              int[] arrayOfInt = InputDialog.NumberDialog.this.numbers;
              arrayOfInt[i] -= 1;
              if (InputDialog.NumberDialog.this.numbers[i] < 0)
                InputDialog.NumberDialog.this.numbers[i] = 9;
              InputDialog.NumberDialog.this.figures[i].setText(Integer.toString(InputDialog.NumberDialog.this.numbers[i]));
            }
            while ((InputDialog.NumberDialog.this.decimal <= 0) || (InputDialog.NumberDialog.this.decimal != i));
            InputDialog.NumberDialog.this.figures[i].setText(Integer.toString(InputDialog.NumberDialog.this.numbers[i]) + InputDialog.NumberDialog.this.decimalchar);
          }
        };
        localButton2.setOnClickListener(local2);
        localTableRow3.addView(localButton2);
      }
    }

    public int getDecimal()
    {
      return this.decimal;
    }

    public char getDecimalChar()
    {
      return this.decimalchar;
    }

    public int getDigits()
    {
      return this.numdigits;
    }

    public int getNumber()
    {
      int i = 0;
      int j = this.numdigits - 1;
      int k;
      if (this.showsign)
        k = 1;
      for (int m = j - k; ; m--)
      {
        if (m < 0)
        {
          if ((!this.showsign) || (this.figures[(this.numdigits - 1)].getText() != "-"))
            break label81;
          return -i;
          k = 0;
          break;
        }
        i = i * 10 + this.numbers[m];
      }
      label81: return i;
    }

    public int getResponse()
    {
      return this.response;
    }

    public boolean getShowSign()
    {
      return this.showsign;
    }

    public double getVersion()
    {
      return 2.92D;
    }

    public void setDecimal(int paramInt)
    {
      this.decimal = Math.min(8, Math.max(paramInt, 0));
    }

    public void setDecimalChar(char paramChar)
    {
      this.decimalchar = paramChar;
    }

    public void setDigits(int paramInt)
    {
      this.numdigits = Math.min(9, Math.max(paramInt, 1));
    }

    public void setNumber(int paramInt)
    {
      boolean bool;
      int i;
      if (paramInt < 0)
      {
        bool = true;
        this.negative = bool;
        i = Math.abs(paramInt);
      }
      for (int j = 0; ; j++)
      {
        if (j >= this.numdigits)
        {
          return;
          bool = false;
          break;
        }
        this.numbers[j] = (i % 10);
        i /= 10;
      }
    }

    public void setShowSign(boolean paramBoolean)
    {
      this.showsign = paramBoolean;
    }
  }

  @BA.ShortName("TimeDialog")
  @BA.ActivityObject
  public static class TimeDialog
  {
    private int hour;
    private boolean hours24;
    private int minute;
    private int response;

    public void SetTime(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.hour = paramInt1;
      this.minute = paramInt2;
      this.hours24 = paramBoolean;
    }

    public int Show(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, BA paramBA, Bitmap paramBitmap)
    {
      AlertDialog localAlertDialog = new AlertDialog.Builder(paramBA.context).create();
      float f = paramBA.context.getResources().getDisplayMetrics().density;
      int i = (int)(20.0F * f);
      int j = (int)(10.0F * f);
      LinearLayout localLinearLayout = new LinearLayout(paramBA.context);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
      localLinearLayout.setLayoutParams(localLayoutParams1);
      localLinearLayout.setOrientation(1);
      TextView localTextView = new TextView(paramBA.context);
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams2.setMargins(i, 0, j, 0);
      localTextView.setLayoutParams(localLayoutParams2);
      localTextView.setGravity(3);
      localTextView.setText(paramString1);
      localLinearLayout.addView(localTextView);
      TimePicker localTimePicker = new TimePicker(paramBA.context);
      localTimePicker.setIs24HourView(Boolean.valueOf(this.hours24));
      localTimePicker.setCurrentHour(Integer.valueOf(this.hour));
      localTimePicker.setCurrentMinute(Integer.valueOf(this.minute));
      localLinearLayout.addView(localTimePicker);
      localAlertDialog.setView(localLinearLayout);
      Msgbox.DialogResponse localDialogResponse = new Msgbox.DialogResponse(false);
      localAlertDialog.setTitle(paramString2);
      if (paramString3.length() > 0)
        localAlertDialog.setButton(-1, paramString3, localDialogResponse);
      if (paramString5.length() > 0)
        localAlertDialog.setButton(-2, paramString5, localDialogResponse);
      if (paramString4.length() > 0)
        localAlertDialog.setButton(-3, paramString4, localDialogResponse);
      if (paramBitmap != null)
      {
        BitmapDrawable localBitmapDrawable = new BitmapDrawable(paramBitmap);
        localAlertDialog.setIcon(localBitmapDrawable);
      }
      Msgbox.msgbox(localAlertDialog, false);
      localTimePicker.clearFocus();
      this.hour = localTimePicker.getCurrentHour().intValue();
      this.minute = localTimePicker.getCurrentMinute().intValue();
      this.response = localDialogResponse.res;
      return localDialogResponse.res;
    }

    public int getHour()
    {
      return this.hour;
    }

    public boolean getIs24Hours()
    {
      return this.hours24;
    }

    public int getMinute()
    {
      return this.minute;
    }

    public int getResponse()
    {
      return this.response;
    }

    public long getTimeTicks()
    {
      return new GregorianCalendar(0, 0, 0, this.hour, this.minute).getTimeInMillis();
    }

    public double getVersion()
    {
      return 2.92D;
    }

    public void setHour(int paramInt)
    {
      this.hour = paramInt;
    }

    public void setIs24Hours(boolean paramBoolean)
    {
      this.hours24 = paramBoolean;
    }

    public void setMinute(int paramInt)
    {
      this.minute = paramInt;
    }

    public void setTimeTicks(long paramLong)
    {
      this.hour = DateTime.GetHour(paramLong);
      this.minute = DateTime.GetMinute(paramLong);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.agraham.dialogs.InputDialog
 * JD-Core Version:    0.6.2
 */