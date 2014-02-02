package anywheresoftware.b4a.objects;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.keywords.LayoutBuilder.DesignerTextSizeMethod;
import anywheresoftware.b4a.objects.collections.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@BA.ShortName("Spinner")
@BA.ActivityObject
public class SpinnerWrapper extends ViewWrapper<B4ASpinner>
  implements LayoutBuilder.DesignerTextSizeMethod
{
  @BA.Hide
  public static View build(Object paramObject1, HashMap<String, Object> paramHashMap, boolean paramBoolean, Object paramObject2)
    throws Exception
  {
    if (paramObject1 == null)
      paramObject1 = ViewWrapper.buildNativeView((Context)paramObject2, B4ASpinner.class, paramHashMap, paramBoolean);
    B4ASpinner localB4ASpinner = (B4ASpinner)ViewWrapper.build(paramObject1, paramHashMap, paramBoolean);
    Float localFloat = (Float)paramHashMap.get("fontsize");
    if (localFloat != null)
    {
      localB4ASpinner.adapter.textSize = localFloat.floatValue();
      localB4ASpinner.adapter.textColor = ((Integer)paramHashMap.get("textColor")).intValue();
      if ((Color.alpha(localB4ASpinner.adapter.textColor) == 0) || (localB4ASpinner.adapter.textColor == -984833))
        localB4ASpinner.adapter.textColor = 0;
    }
    if (paramBoolean)
    {
      localB4ASpinner.adapter.items.clear();
      localB4ASpinner.adapter.items.add(paramHashMap.get("name"));
      localB4ASpinner.adapter.notifyDataSetChanged();
    }
    String str = (String)paramHashMap.get("prompt");
    if ((str != null) && (str.length() > 0))
      localB4ASpinner.setPrompt(str);
    return localB4ASpinner;
  }

  public void Add(String paramString)
  {
    ((B4ASpinner)getObject()).disallowItemClick = true;
    try
    {
      ((B4ASpinner)getObject()).adapter.items.add(paramString);
      ((B4ASpinner)getObject()).adapter.notifyDataSetChanged();
      if (((B4ASpinner)getObject()).selectedItem == -1)
        ((B4ASpinner)getObject()).selectedItem = 0;
      return;
    }
    finally
    {
      ((B4ASpinner)getObject()).disallowItemClick = false;
    }
  }

  public void AddAll(List paramList)
  {
    ((B4ASpinner)getObject()).disallowItemClick = true;
    try
    {
      ((B4ASpinner)getObject()).adapter.items.addAll((Collection)paramList.getObject());
      ((B4ASpinner)getObject()).adapter.notifyDataSetChanged();
      if (((B4ASpinner)getObject()).selectedItem == -1)
        ((B4ASpinner)getObject()).selectedItem = 0;
      return;
    }
    finally
    {
      ((B4ASpinner)getObject()).disallowItemClick = false;
    }
  }

  public void Clear()
  {
    ((B4ASpinner)getObject()).disallowItemClick = true;
    try
    {
      ((B4ASpinner)getObject()).adapter.items.clear();
      ((B4ASpinner)getObject()).adapter.notifyDataSetChanged();
      ((B4ASpinner)getObject()).selectedItem = -1;
      return;
    }
    finally
    {
      ((B4ASpinner)getObject()).disallowItemClick = false;
    }
  }

  public String GetItem(int paramInt)
  {
    return String.valueOf(((B4ASpinner)getObject()).adapter.getItem(paramInt));
  }

  public int IndexOf(String paramString)
  {
    return ((B4ASpinner)getObject()).adapter.items.indexOf(paramString);
  }

  public void RemoveAt(int paramInt)
  {
    ((B4ASpinner)getObject()).disallowItemClick = true;
    try
    {
      ((B4ASpinner)getObject()).adapter.items.remove(paramInt);
      ((B4ASpinner)getObject()).adapter.notifyDataSetChanged();
      if (((B4ASpinner)getObject()).selectedItem == ((B4ASpinner)getObject()).adapter.getCount())
      {
        B4ASpinner localB4ASpinner = (B4ASpinner)getObject();
        localB4ASpinner.selectedItem -= 1;
      }
      return;
    }
    finally
    {
      ((B4ASpinner)getObject()).disallowItemClick = false;
    }
  }

  public int getDropdownTextColor()
  {
    return ((B4ASpinner)getObject()).adapter.dropdownTextColor;
  }

  public String getPrompt()
  {
    return (String)((B4ASpinner)getObject()).getPrompt();
  }

  public int getSelectedIndex()
  {
    return ((B4ASpinner)getObject()).selectedItem;
  }

  public String getSelectedItem()
  {
    Object localObject1 = ((B4ASpinner)getObject()).getItemAtPosition(((B4ASpinner)getObject()).selectedItem);
    if (localObject1 == null);
    for (Object localObject2 = ""; ; localObject2 = localObject1)
      return String.valueOf(localObject2);
  }

  public int getSize()
  {
    return ((B4ASpinner)getObject()).adapter.getCount();
  }

  public int getTextColor()
  {
    return ((B4ASpinner)getObject()).adapter.textColor;
  }

  public float getTextSize()
  {
    return ((B4ASpinner)getObject()).adapter.textSize;
  }

  @BA.Hide
  public void innerInitialize(BA paramBA, String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
      setObject(new B4ASpinner(paramBA.context));
    super.innerInitialize(paramBA, paramString, true);
    ((B4ASpinner)getObject()).ba = paramBA;
    ((B4ASpinner)getObject()).eventName = paramString;
    ((B4ASpinner)getObject()).disallowItemClick = false;
  }

  public void setDropdownTextColor(int paramInt)
  {
    ((B4ASpinner)getObject()).adapter.dropdownTextColor = paramInt;
  }

  public void setPrompt(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      paramString = null;
    ((B4ASpinner)getObject()).setPrompt(paramString);
  }

  public void setSelectedIndex(int paramInt)
  {
    ((B4ASpinner)getObject()).disallowItemClick = true;
    try
    {
      ((B4ASpinner)getObject()).setSelection(paramInt);
      ((B4ASpinner)getObject()).selectedItem = paramInt;
      return;
    }
    finally
    {
      ((B4ASpinner)getObject()).disallowItemClick = false;
    }
  }

  public void setTextColor(int paramInt)
  {
    ((B4ASpinner)getObject()).adapter.textColor = paramInt;
  }

  public void setTextSize(float paramFloat)
  {
    ((B4ASpinner)getObject()).adapter.textSize = paramFloat;
  }

  @BA.Hide
  public static class B4ASpinner extends Spinner
  {
    public SpinnerWrapper.B4ASpinnerAdapter adapter;
    public BA ba;
    public boolean disallowItemClick = true;
    public String eventName;
    int selectedItem = -1;

    public B4ASpinner(Context paramContext)
    {
      super();
      this.adapter = new SpinnerWrapper.B4ASpinnerAdapter(paramContext);
      setAdapter(this.adapter);
    }

    public void setSelection(int paramInt)
    {
      super.setSelection(paramInt);
      this.selectedItem = paramInt;
      if ((this.ba != null) && (!this.disallowItemClick))
      {
        BA localBA = this.ba;
        String str = this.eventName + "_itemclick";
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Integer.valueOf(this.selectedItem);
        arrayOfObject[1] = this.adapter.getItem(this.selectedItem);
        localBA.raiseEventFromUI(this, str, arrayOfObject);
      }
    }
  }

  @BA.Hide
  public static class B4ASpinnerAdapter extends BaseAdapter
    implements SpinnerAdapter
  {
    public int dropdownTextColor = 0;
    private LayoutInflater inflater;
    ArrayList<Object> items = new ArrayList();
    public int textColor = 0;
    public float textSize = 16.0F;

    public B4ASpinnerAdapter(Context paramContext)
    {
      this.inflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    }

    public int getCount()
    {
      return this.items.size();
    }

    public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = this.inflater.inflate(17367049, paramViewGroup, false);
        ((TextView)paramView).setTextSize(this.textSize);
        if ((this.textColor == 0) || (this.dropdownTextColor != 0))
          break label88;
        ((TextView)paramView).setTextColor(this.textColor);
      }
      TextView localTextView;
      Object localObject;
      while (true)
      {
        localTextView = (TextView)paramView;
        localObject = this.items.get(paramInt);
        if (!(localObject instanceof CharSequence))
          break;
        localTextView.setText((CharSequence)localObject);
        return paramView;
        label88: if (this.dropdownTextColor != 0)
          ((TextView)paramView).setTextColor(this.dropdownTextColor);
      }
      localTextView.setText(String.valueOf(localObject));
      return paramView;
    }

    public Object getItem(int paramInt)
    {
      return this.items.get(paramInt);
    }

    public long getItemId(int paramInt)
    {
      return 0L;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = this.inflater.inflate(17367048, paramViewGroup, false);
        ((TextView)paramView).setTextSize(this.textSize);
        if (this.textColor != 0)
          ((TextView)paramView).setTextColor(this.textColor);
      }
      TextView localTextView = (TextView)paramView;
      Object localObject = this.items.get(paramInt);
      if ((localObject instanceof CharSequence))
      {
        localTextView.setText((CharSequence)localObject);
        return paramView;
      }
      localTextView.setText(String.valueOf(localObject));
      return paramView;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.SpinnerWrapper
 * JD-Core Version:    0.6.2
 */