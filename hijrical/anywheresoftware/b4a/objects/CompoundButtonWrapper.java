package anywheresoftware.b4a.objects;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.ToggleButton;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.RaisesSynchronousEvents;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.DynamicBuilder;
import java.util.HashMap;

@BA.Hide
public class CompoundButtonWrapper<T extends CompoundButton> extends TextViewWrapper<T>
{
  @BA.Hide
  public static View build(Object paramObject, HashMap<String, Object> paramHashMap, boolean paramBoolean)
    throws Exception
  {
    CompoundButton localCompoundButton = (CompoundButton)TextViewWrapper.build(paramObject, paramHashMap, paramBoolean);
    localCompoundButton.setChecked(((Boolean)paramHashMap.get("isChecked")).booleanValue());
    HashMap localHashMap = (HashMap)paramHashMap.get("drawable");
    if (localHashMap != null)
    {
      Drawable localDrawable = (Drawable)DynamicBuilder.build(paramObject, localHashMap, paramBoolean, null);
      if (localDrawable != null)
        localCompoundButton.setBackgroundDrawable(localDrawable);
    }
    return localCompoundButton;
  }

  public boolean getChecked()
  {
    return ((CompoundButton)getObject()).isChecked();
  }

  @BA.Hide
  public void innerInitialize(BA paramBA, String paramString, boolean paramBoolean)
  {
    innerInitialize(paramBA, paramString, paramBoolean, true);
  }

  protected void innerInitialize(final BA paramBA, final String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.innerInitialize(paramBA, paramString, true);
    if (paramBA.subExists(paramString + "_checkedchange"))
      ((CompoundButton)getObject()).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          BA localBA = paramBA;
          Object localObject = CompoundButtonWrapper.this.getObject();
          String str = paramString + "_checkedchange";
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Boolean.valueOf(paramAnonymousBoolean);
          localBA.raiseEvent2(localObject, false, str, false, arrayOfObject);
        }
      });
  }

  @BA.RaisesSynchronousEvents
  public void setChecked(boolean paramBoolean)
  {
    ((CompoundButton)getObject()).setChecked(paramBoolean);
  }

  @BA.Hide
  public String toString()
  {
    String str = super.toString();
    if (IsInitialized())
      return str + ", Checked=" + getChecked();
    return str;
  }

  @BA.ShortName("CheckBox")
  @BA.ActivityObject
  public static class CheckBoxWrapper extends CompoundButtonWrapper<CheckBox>
  {
    @BA.Hide
    public static View build(Object paramObject1, HashMap<String, Object> paramHashMap, boolean paramBoolean, Object paramObject2)
      throws Exception
    {
      if (paramObject1 == null)
        paramObject1 = ViewWrapper.buildNativeView((Context)paramObject2, CheckBox.class, paramHashMap, paramBoolean);
      return (CheckBox)CompoundButtonWrapper.build(paramObject1, paramHashMap, paramBoolean);
    }

    @BA.Hide
    public void innerInitialize(BA paramBA, String paramString, boolean paramBoolean)
    {
      if (!paramBoolean)
        setObject(new CheckBox(paramBA.context));
      super.innerInitialize(paramBA, paramString, true);
    }
  }

  @BA.ShortName("RadioButton")
  @BA.ActivityObject
  public static class RadioButtonWrapper extends CompoundButtonWrapper<RadioButton>
  {
    @BA.Hide
    public static View build(Object paramObject1, HashMap<String, Object> paramHashMap, boolean paramBoolean, Object paramObject2)
      throws Exception
    {
      if (paramObject1 == null)
        paramObject1 = ViewWrapper.buildNativeView((Context)paramObject2, RadioButton.class, paramHashMap, paramBoolean);
      return (RadioButton)CompoundButtonWrapper.build(paramObject1, paramHashMap, paramBoolean);
    }

    @BA.Hide
    public void innerInitialize(BA paramBA, String paramString, boolean paramBoolean)
    {
      if (!paramBoolean)
        setObject(new RadioButton(paramBA.context));
      super.innerInitialize(paramBA, paramString, true, false);
      ((RadioButton)getObject()).setOnCheckedChangeListener(new RadioButtonListener(paramString, paramBA, (RadioButton)getObject()));
    }

    private static class RadioButtonListener
      implements CompoundButton.OnCheckedChangeListener
    {
      private BA ba;
      private RadioButton current;
      private String eventName;

      public RadioButtonListener(String paramString, BA paramBA, RadioButton paramRadioButton)
      {
        this.eventName = paramString;
        this.ba = paramBA;
        this.current = paramRadioButton;
      }

      public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
      {
        if (!paramBoolean)
          return;
        ViewParent localViewParent = this.current.getParent();
        ViewGroup localViewGroup;
        if ((localViewParent instanceof ViewGroup))
          localViewGroup = (ViewGroup)localViewParent;
        for (int i = 0; ; i++)
        {
          if (i >= localViewGroup.getChildCount())
          {
            if (this.eventName.length() <= 0)
              break;
            BA localBA = this.ba;
            RadioButton localRadioButton1 = this.current;
            String str = this.eventName + "_checkedchange";
            Object[] arrayOfObject = new Object[1];
            arrayOfObject[0] = Boolean.valueOf(paramBoolean);
            localBA.raiseEvent2(localRadioButton1, false, str, false, arrayOfObject);
            return;
          }
          View localView = localViewGroup.getChildAt(i);
          if (((localView instanceof RadioButton)) && (localView != this.current))
          {
            RadioButton localRadioButton2 = (RadioButton)localView;
            if (localRadioButton2.isChecked())
              localRadioButton2.setChecked(false);
          }
        }
      }
    }
  }

  @BA.ShortName("ToggleButton")
  @BA.ActivityObject
  public static class ToggleButtonWrapper extends CompoundButtonWrapper<ToggleButton>
  {
    @BA.Hide
    public static View build(Object paramObject1, HashMap<String, Object> paramHashMap, boolean paramBoolean, Object paramObject2)
      throws Exception
    {
      if (paramObject1 == null)
        paramObject1 = ViewWrapper.buildNativeView((Context)paramObject2, ToggleButton.class, paramHashMap, paramBoolean);
      ToggleButton localToggleButton1 = (ToggleButton)paramObject1;
      localToggleButton1.setTextOn((String)paramHashMap.get("textOn"));
      localToggleButton1.setTextOff((String)paramHashMap.get("textOff"));
      ToggleButton localToggleButton2 = (ToggleButton)CompoundButtonWrapper.build(paramObject1, paramHashMap, paramBoolean);
      localToggleButton2.setTextColor(((Integer)paramHashMap.get("textColor")).intValue());
      return localToggleButton2;
    }

    @BA.Hide
    public String getText()
    {
      return "";
    }

    public String getTextOff()
    {
      return (String)((ToggleButton)getObject()).getTextOff();
    }

    public String getTextOn()
    {
      return (String)((ToggleButton)getObject()).getTextOn();
    }

    @BA.Hide
    public void innerInitialize(BA paramBA, String paramString, boolean paramBoolean)
    {
      if (!paramBoolean)
      {
        setObject(new ToggleButton(paramBA.context));
        ((ToggleButton)getObject()).setText("");
      }
      super.innerInitialize(paramBA, paramString, true);
    }

    @BA.Hide
    public void setText(Object paramObject)
    {
    }

    public void setTextOff(String paramString)
    {
      ((ToggleButton)getObject()).setTextOff(paramString);
      setChecked(getChecked());
    }

    public void setTextOn(String paramString)
    {
      ((ToggleButton)getObject()).setTextOn(paramString);
      setChecked(getChecked());
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.CompoundButtonWrapper
 * JD-Core Version:    0.6.2
 */