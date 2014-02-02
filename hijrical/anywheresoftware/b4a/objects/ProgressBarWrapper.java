package anywheresoftware.b4a.objects;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import java.util.HashMap;

@BA.ShortName("ProgressBar")
@BA.ActivityObject
public class ProgressBarWrapper extends ViewWrapper<ProgressBar>
{
  @BA.Hide
  public static View build(Object paramObject1, HashMap<String, Object> paramHashMap, boolean paramBoolean, Object paramObject2)
    throws Exception
  {
    boolean bool = ((Boolean)paramHashMap.get("indeterminate")).booleanValue();
    if (paramObject1 == null)
    {
      String str = (String)paramHashMap.get("nativeClass");
      if ((str == null) || (str.length() <= 0))
        break label93;
      ViewWrapper.buildNativeView((Context)paramObject2, ProgressBar.class, paramHashMap, paramBoolean);
    }
    while (true)
    {
      ProgressBar localProgressBar1 = (ProgressBar)ViewWrapper.build(paramObject1, paramHashMap, paramBoolean);
      localProgressBar1.setIndeterminate(bool);
      localProgressBar1.setMax(100);
      if (paramBoolean)
        localProgressBar1.setProgress(20);
      return localProgressBar1;
      label93: ProgressBar localProgressBar2 = new ProgressBar((Context)paramObject2, null, 16842872);
      localProgressBar2.setIndeterminateDrawable(new ProgressBar((Context)paramObject2, null, 16842871).getIndeterminateDrawable());
      paramObject1 = localProgressBar2;
    }
  }

  public boolean getIndeterminate()
  {
    return ((ProgressBar)getObject()).isIndeterminate();
  }

  public int getProgress()
  {
    return ((ProgressBar)getObject()).getProgress();
  }

  @BA.Hide
  public void innerInitialize(BA paramBA, String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      ProgressBar localProgressBar = new ProgressBar(paramBA.context, null, 16842872);
      localProgressBar.setIndeterminateDrawable(new ProgressBar(paramBA.context, null, 16842871).getIndeterminateDrawable());
      setObject(localProgressBar);
      ((ProgressBar)getObject()).setMax(100);
      ((ProgressBar)getObject()).setIndeterminate(false);
    }
    super.innerInitialize(paramBA, paramString, true);
  }

  public void setIndeterminate(boolean paramBoolean)
  {
    ((ProgressBar)getObject()).setIndeterminate(paramBoolean);
    ((ProgressBar)getObject()).invalidate();
  }

  public void setProgress(int paramInt)
  {
    ((ProgressBar)getObject()).setProgress(paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.ProgressBarWrapper
 * JD-Core Version:    0.6.2
 */