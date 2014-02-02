package anywheresoftware.b4a.objects;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.keywords.Common;
import java.util.HashMap;

@BA.ShortName("AutoCompleteEditText")
public class AutoCompleteEditTextWrapper extends EditTextWrapper
{
  @BA.Hide
  public static View build(Object paramObject1, HashMap<String, Object> paramHashMap, boolean paramBoolean, Object paramObject2)
    throws Exception
  {
    if (paramObject1 == null);
    for (AutoCompleteTextView localAutoCompleteTextView = (AutoCompleteTextView)ViewWrapper.buildNativeView((Context)paramObject2, AutoCompleteTextView.class, paramHashMap, paramBoolean); ; localAutoCompleteTextView = (AutoCompleteTextView)paramObject1)
      return EditTextWrapper.build(localAutoCompleteTextView, paramHashMap, paramBoolean, paramObject2);
  }

  public void DismissDropDown()
  {
    ((AutoCompleteTextView)getObject()).dismissDropDown();
  }

  public void SetItems(BA paramBA, anywheresoftware.b4a.objects.collections.List paramList)
  {
    MyArrayAdapter localMyArrayAdapter = new MyArrayAdapter(paramBA.context, (java.util.List)paramList.getObject(), getTextSize(), getTypeface(), getGravity(), getTextColor());
    ((AutoCompleteTextView)getObject()).setAdapter(localMyArrayAdapter);
  }

  public void SetItems2(BA paramBA, anywheresoftware.b4a.objects.collections.List paramList, Typeface paramTypeface, int paramInt1, float paramFloat, int paramInt2)
  {
    MyArrayAdapter localMyArrayAdapter = new MyArrayAdapter(paramBA.context, (java.util.List)paramList.getObject(), paramFloat, paramTypeface, paramInt1, paramInt2);
    ((AutoCompleteTextView)getObject()).setAdapter(localMyArrayAdapter);
  }

  public void ShowDropDown()
  {
    ((AutoCompleteTextView)getObject()).showDropDown();
  }

  @BA.Hide
  public void innerInitialize(final BA paramBA, final String paramString, boolean paramBoolean)
  {
    this.ba = paramBA;
    if (!paramBoolean)
    {
      setObject(new AutoCompleteTextView(paramBA.context));
      ((EditText)getObject()).setSingleLine(true);
      ((EditText)getObject()).setImeOptions(6);
    }
    super.innerInitialize(paramBA, paramString, true);
    final AutoCompleteTextView localAutoCompleteTextView = (AutoCompleteTextView)getObject();
    if ((0xF & localAutoCompleteTextView.getInputType()) == 1)
      localAutoCompleteTextView.setInputType(0x80000 | localAutoCompleteTextView.getInputType());
    localAutoCompleteTextView.setThreshold(1);
    localAutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        ((InputMethodManager)BA.applicationContext.getSystemService("input_method")).hideSoftInputFromWindow(((EditText)AutoCompleteEditTextWrapper.this.getObject()).getWindowToken(), 0);
        BA localBA = paramBA;
        Object localObject = AutoCompleteEditTextWrapper.this.getObject();
        String str = paramString + "_itemclick";
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = String.valueOf(localAutoCompleteTextView.getAdapter().getItem(paramAnonymousInt));
        localBA.raiseEventFromUI(localObject, str, arrayOfObject);
      }
    });
  }

  @BA.Hide
  public static class MyArrayAdapter extends ArrayAdapter<String>
  {
    int gravity;
    int textColor;
    float textSize;
    private Typeface typeface;

    public MyArrayAdapter(Context paramContext, java.util.List paramList, float paramFloat, Typeface paramTypeface, int paramInt1, int paramInt2)
    {
      super(0, paramList);
      this.typeface = paramTypeface;
      this.textColor = paramInt2;
      this.textSize = paramFloat;
      this.gravity = paramInt1;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      TextView localTextView;
      if (paramView == null)
      {
        localTextView = new TextView(getContext());
        localTextView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        int i = Common.DipToCurrent(10);
        localTextView.setPadding(i, i, i, i);
        localTextView.setTextColor(this.textColor);
        localTextView.setTextSize(this.textSize);
        localTextView.setTypeface(this.typeface);
        localTextView.setGravity(this.gravity);
      }
      while (true)
      {
        localTextView.setText((CharSequence)getItem(paramInt));
        return localTextView;
        localTextView = (TextView)paramView;
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper
 * JD-Core Version:    0.6.2
 */