package anywheresoftware.b4a.objects;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.RaisesSynchronousEvents;
import anywheresoftware.b4a.BA.ShortName;
import java.lang.reflect.Field;
import java.util.HashMap;

@BA.ShortName("EditText")
@BA.ActivityObject
public class EditTextWrapper extends TextViewWrapper<EditText>
{
  public static final int INPUT_TYPE_DECIMAL_NUMBERS = 12290;
  public static final int INPUT_TYPE_NONE = 0;
  public static final int INPUT_TYPE_NUMBERS = 2;
  public static final int INPUT_TYPE_PHONE = 3;
  public static final int INPUT_TYPE_TEXT = 1;

  @BA.Hide
  public static View build(Object paramObject1, HashMap<String, Object> paramHashMap, boolean paramBoolean, Object paramObject2)
    throws Exception
  {
    EditText localEditText;
    ColorStateList localColorStateList;
    if (paramObject1 == null)
    {
      localEditText = (EditText)ViewWrapper.buildNativeView((Context)paramObject2, EditText.class, paramHashMap, paramBoolean);
      TextViewWrapper.build(localEditText, paramHashMap, paramBoolean);
      localColorStateList = null;
      if (paramBoolean)
        localColorStateList = (ColorStateList)ViewWrapper.getDefault(localEditText, "hintColor", localEditText.getHintTextColors());
      int i = ((Integer)BA.gm(paramHashMap, "hintColor", Integer.valueOf(-984833))).intValue();
      if (i == -984833)
        break label308;
      localEditText.setHintTextColor(i);
      label85: String str1 = (String)BA.gm(paramHashMap, "hint", "");
      if ((paramBoolean) && (str1.length() == 0))
        str1 = (String)paramHashMap.get("name");
      localEditText.setHint(str1);
      String str2 = (String)paramHashMap.get("inputType");
      if (str2 != null)
        localEditText.setInputType(((Integer)EditTextWrapper.class.getField("INPUT_TYPE_" + str2).get(null)).intValue());
      boolean bool1 = ((Boolean)paramHashMap.get("singleLine")).booleanValue();
      localEditText.setSingleLine(bool1);
      if ((paramBoolean) && (bool1))
        localEditText.setInputType(524288);
      if (!((Boolean)paramHashMap.get("password")).booleanValue())
        break label322;
      localEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
      label241: if (!((Boolean)BA.gm(paramHashMap, "wrap", Boolean.valueOf(true))).booleanValue())
        break label331;
    }
    label308: label322: label331: for (boolean bool2 = false; ; bool2 = true)
    {
      localEditText.setHorizontallyScrolling(bool2);
      if (!((Boolean)BA.gm(paramHashMap, "forceDone", Boolean.valueOf(false))).booleanValue())
        break label337;
      localEditText.setImeOptions(6);
      return localEditText;
      localEditText = (EditText)paramObject1;
      break;
      if (!paramBoolean)
        break label85;
      localEditText.setHintTextColor(localColorStateList);
      break label85;
      localEditText.setTransformationMethod(null);
      break label241;
    }
    label337: localEditText.setImeOptions(0);
    return localEditText;
  }

  public void SelectAll()
  {
    Selection.selectAll(((EditText)getObject()).getText());
  }

  public String getHint()
  {
    CharSequence localCharSequence = ((EditText)getObject()).getHint();
    if (localCharSequence == null)
      return "";
    return String.valueOf(localCharSequence);
  }

  public int getHintColor()
  {
    return ((EditText)getObject()).getCurrentHintTextColor();
  }

  public int getInputType()
  {
    return ((EditText)getObject()).getInputType();
  }

  public int getSelectionStart()
  {
    return Selection.getSelectionStart(((EditText)getObject()).getText());
  }

  @BA.Hide
  public void innerInitialize(final BA paramBA, final String paramString, boolean paramBoolean)
  {
    this.ba = paramBA;
    if (!paramBoolean)
      setObject(new EditText(paramBA.context));
    super.innerInitialize(paramBA, paramString, true);
    if (paramBA.subExists(paramString + "_textchanged"))
    {
      TextWatcher local1 = new TextWatcher()
      {
        private CharSequence old;

        public void afterTextChanged(Editable paramAnonymousEditable)
        {
          BA localBA = paramBA;
          Object localObject = EditTextWrapper.this.getObject();
          String str = paramString + "_textchanged";
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = this.old;
          arrayOfObject[1] = ((EditText)EditTextWrapper.this.getObject()).getText().toString();
          localBA.raiseEvent2(localObject, false, str, true, arrayOfObject);
        }

        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          this.old = paramAnonymousCharSequence.toString();
        }

        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
        }
      };
      ((EditText)getObject()).addTextChangedListener(local1);
    }
    if (paramBA.subExists(paramString + "_enterpressed"))
    {
      TextView.OnEditorActionListener local2 = new TextView.OnEditorActionListener()
      {
        public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          paramBA.raiseEvent(EditTextWrapper.this.getObject(), paramString + "_enterpressed", new Object[0]);
          return false;
        }
      };
      ((EditText)getObject()).setOnEditorActionListener(local2);
    }
    if (paramBA.subExists(paramString + "_focuschanged"))
      ((EditText)getObject()).setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          BA localBA = paramBA;
          Object localObject = EditTextWrapper.this.getObject();
          String str = paramString + "_focuschanged";
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Boolean.valueOf(paramAnonymousBoolean);
          localBA.raiseEventFromUI(localObject, str, arrayOfObject);
        }
      });
  }

  public void setForceDoneButton(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((EditText)getObject()).setImeOptions(6);
      return;
    }
    ((EditText)getObject()).setImeOptions(0);
  }

  public void setHint(String paramString)
  {
    ((EditText)getObject()).setHint(paramString);
  }

  public void setHintColor(int paramInt)
  {
    ((EditText)getObject()).setHintTextColor(paramInt);
  }

  public void setInputType(int paramInt)
  {
    ((EditText)getObject()).setInputType(paramInt);
  }

  public void setPasswordMode(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((EditText)getObject()).setTransformationMethod(PasswordTransformationMethod.getInstance());
      return;
    }
    ((EditText)getObject()).setTransformationMethod(null);
  }

  public void setSelectionStart(int paramInt)
  {
    ((EditText)getObject()).setSelection(paramInt);
  }

  public void setSingleLine(boolean paramBoolean)
  {
    ((EditText)getObject()).setSingleLine(paramBoolean);
  }

  @BA.RaisesSynchronousEvents
  public void setText(Object paramObject)
  {
    super.setText(paramObject);
  }

  public void setWrap(boolean paramBoolean)
  {
    EditText localEditText = (EditText)getObject();
    if (paramBoolean);
    for (boolean bool = false; ; bool = true)
    {
      localEditText.setHorizontallyScrolling(bool);
      return;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.EditTextWrapper
 * JD-Core Version:    0.6.2
 */