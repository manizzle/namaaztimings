package anywheresoftware.b4a.objects;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.BALayout.LayoutParams;
import anywheresoftware.b4a.DynamicBuilder;
import anywheresoftware.b4a.keywords.Common.DesignerCustomView;
import anywheresoftware.b4a.keywords.LayoutBuilder.DesignerTextSizeMethod;
import anywheresoftware.b4a.objects.collections.Map;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

@BA.Hide
public class CustomViewWrapper extends ViewWrapper<BALayout>
  implements LayoutBuilder.DesignerTextSizeMethod
{
  public Object customObject;
  private String eventName;
  public HashMap<String, Object> props;

  @BA.Hide
  public static View build(Object paramObject1, HashMap<String, Object> paramHashMap, boolean paramBoolean, Object paramObject2)
    throws Exception
  {
    if (paramObject1 == null)
      paramObject1 = ViewWrapper.buildNativeView((Context)paramObject2, BALayout.class, paramHashMap, paramBoolean);
    ViewGroup localViewGroup = (ViewGroup)ViewWrapper.build(paramObject1, paramHashMap, paramBoolean);
    Drawable localDrawable = (Drawable)DynamicBuilder.build(paramObject1, (HashMap)paramHashMap.get("drawable"), paramBoolean, null);
    if (localDrawable != null)
      localViewGroup.setBackgroundDrawable(localDrawable);
    TextView localTextView = (TextView)TextViewWrapper.build(ViewWrapper.buildNativeView((Context)paramObject2, TextView.class, paramHashMap, paramBoolean), paramHashMap, paramBoolean);
    localViewGroup.setTag(localTextView);
    if (paramBoolean)
    {
      localViewGroup.removeAllViews();
      localViewGroup.addView(localTextView, new BALayout.LayoutParams(0, 0, -1, -1));
    }
    return localViewGroup;
  }

  public void AfterDesignerScript()
    throws ClassNotFoundException, IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException
  {
    Class localClass = this.customObject.getClass();
    boolean bool = this.customObject instanceof B4AClass;
    Map localMap = new Map();
    localMap.Initialize();
    localMap.Put("defaultcolor", Integer.valueOf(-984833));
    PanelWrapper localPanelWrapper = new PanelWrapper();
    localPanelWrapper.setObject((ViewGroup)getObject());
    LabelWrapper localLabelWrapper = new LabelWrapper();
    localLabelWrapper.setObject((TextView)getTag());
    localLabelWrapper.setTextSize(((Float)this.props.get("fontsize")).floatValue());
    localPanelWrapper.setTag(this.props.get("tag"));
    if (bool)
      localMap.Put("activity", this.ba.vg);
    if ((BA.shellMode) && (bool))
    {
      BA localBA = this.ba;
      Object[] arrayOfObject2 = new Object[7];
      arrayOfObject2[0] = this.customObject;
      arrayOfObject2[1] = this.ba;
      arrayOfObject2[2] = this.ba.activity.getClass();
      arrayOfObject2[3] = this.eventName;
      arrayOfObject2[4] = localPanelWrapper;
      arrayOfObject2[5] = localLabelWrapper;
      arrayOfObject2[6] = localMap;
      localBA.raiseEvent2(null, true, "CREATE_CUSTOM_VIEW", true, arrayOfObject2);
      return;
    }
    Method localMethod = localClass.getMethod("_initialize", new Class[] { BA.class, Object.class, String.class });
    Object localObject = this.customObject;
    Object[] arrayOfObject1 = new Object[3];
    arrayOfObject1[0] = this.ba;
    arrayOfObject1[1] = this.ba.activity.getClass();
    arrayOfObject1[2] = this.eventName;
    localMethod.invoke(localObject, arrayOfObject1);
    if (bool)
    {
      ((B4AClass)this.customObject).getBA().raiseEvent2(null, true, "designercreateview", true, new Object[] { localPanelWrapper, localLabelWrapper, localMap });
      return;
    }
    ((Common.DesignerCustomView)this.customObject).DesignerCreateView(localPanelWrapper, localLabelWrapper, localMap);
  }

  public float getTextSize()
  {
    return ((Float)this.props.get("fontsize")).floatValue();
  }

  @BA.Hide
  public void innerInitialize(BA paramBA, String paramString, boolean paramBoolean)
  {
    this.ba = paramBA;
    this.eventName = paramString;
  }

  public void setTextSize(float paramFloat)
  {
    this.props.put("fontsize", Float.valueOf(paramFloat));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.CustomViewWrapper
 * JD-Core Version:    0.6.2
 */