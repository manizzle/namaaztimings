package anywheresoftware.b4a.objects;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.DynamicBuilder;
import java.util.HashMap;

@BA.ShortName("Label")
@BA.ActivityObject
public class LabelWrapper extends TextViewWrapper<TextView>
{
  @BA.Hide
  public static View build(Object paramObject1, HashMap<String, Object> paramHashMap, boolean paramBoolean, Object paramObject2)
    throws Exception
  {
    if (paramObject1 == null)
      paramObject1 = ViewWrapper.buildNativeView((Context)paramObject2, TextView.class, paramHashMap, paramBoolean);
    TextView localTextView = (TextView)TextViewWrapper.build(paramObject1, paramHashMap, paramBoolean);
    HashMap localHashMap = (HashMap)paramHashMap.get("drawable");
    if (localHashMap != null)
    {
      Drawable localDrawable = (Drawable)DynamicBuilder.build(paramObject1, localHashMap, paramBoolean, null);
      if (localDrawable != null)
        localTextView.setBackgroundDrawable(localDrawable);
    }
    return localTextView;
  }

  @BA.Hide
  public void innerInitialize(BA paramBA, String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
      setObject(new TextView(paramBA.context));
    super.innerInitialize(paramBA, paramString, true);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.LabelWrapper
 * JD-Core Version:    0.6.2
 */