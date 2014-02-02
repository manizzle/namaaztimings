package anywheresoftware.b4a.objects;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.keywords.LayoutBuilder.DesignerTextSizeMethod;
import java.lang.reflect.Field;
import java.util.Map;

@BA.Hide
public class TextViewWrapper<T extends TextView> extends ViewWrapper<T>
  implements LayoutBuilder.DesignerTextSizeMethod
{
  @BA.Hide
  public static View build(Object paramObject, Map<String, Object> paramMap, boolean paramBoolean)
    throws Exception
  {
    TextView localTextView = (TextView)ViewWrapper.build(paramObject, paramMap, paramBoolean);
    localTextView.setText((CharSequence)paramMap.get("text"));
    ColorStateList localColorStateList = null;
    if (paramBoolean)
      localColorStateList = (ColorStateList)ViewWrapper.getDefault(localTextView, "textColor", localTextView.getTextColors());
    Typeface localTypeface = (Typeface)Typeface.class.getField((String)paramMap.get("typeface")).get(null);
    int i = ((Integer)Typeface.class.getField((String)paramMap.get("style")).get(null)).intValue();
    localTextView.setTextSize(((Float)paramMap.get("fontsize")).floatValue());
    localTextView.setTypeface(localTypeface, i);
    localTextView.setGravity(((Integer)Gravity.class.getField((String)paramMap.get("vAlignment")).get(null)).intValue() | ((Integer)Gravity.class.getField((String)paramMap.get("hAlignment")).get(null)).intValue());
    int j = ((Integer)paramMap.get("textColor")).intValue();
    if (j != -984833)
      localTextView.setTextColor(j);
    if ((paramBoolean) && (j == -984833))
      localTextView.setTextColor(localColorStateList);
    if (paramBoolean)
      setHint(localTextView, (String)paramMap.get("name"));
    return localTextView;
  }

  @BA.Hide
  public static void setHint(TextView paramTextView, String paramString)
  {
    if ((paramTextView.getText().length() == 0) && (!(paramTextView instanceof EditText)))
    {
      paramTextView.setText(paramString);
      paramTextView.setTextColor(-7829368);
    }
  }

  public int getGravity()
  {
    return ((TextView)getObject()).getGravity();
  }

  public String getText()
  {
    return ((TextView)getObject()).getText().toString();
  }

  public int getTextColor()
  {
    return ((TextView)getObject()).getTextColors().getDefaultColor();
  }

  public float getTextSize()
  {
    return ((TextView)getObject()).getTextSize() / ((TextView)getObject()).getContext().getResources().getDisplayMetrics().scaledDensity;
  }

  public Typeface getTypeface()
  {
    return ((TextView)getObject()).getTypeface();
  }

  public void setGravity(int paramInt)
  {
    ((TextView)getObject()).setGravity(paramInt);
  }

  public void setText(Object paramObject)
  {
    if ((paramObject instanceof CharSequence));
    for (Object localObject = (CharSequence)paramObject; ; localObject = paramObject.toString())
    {
      ((TextView)getObject()).setText((CharSequence)localObject);
      return;
    }
  }

  public void setTextColor(int paramInt)
  {
    ((TextView)getObject()).setTextColor(paramInt);
  }

  public void setTextSize(float paramFloat)
  {
    ((TextView)getObject()).setTextSize(paramFloat);
  }

  public void setTypeface(Typeface paramTypeface)
  {
    ((TextView)getObject()).setTypeface(paramTypeface);
  }

  @BA.Hide
  public String toString()
  {
    String str = super.toString();
    if (IsInitialized())
      return str + ", Text=" + getText();
    return str;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.TextViewWrapper
 * JD-Core Version:    0.6.2
 */