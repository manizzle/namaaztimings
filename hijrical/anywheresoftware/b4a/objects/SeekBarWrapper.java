package anywheresoftware.b4a.objects;

import android.content.Context;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import java.util.HashMap;

@BA.ShortName("SeekBar")
@BA.ActivityObject
public class SeekBarWrapper extends ViewWrapper<SeekBar>
{
  @BA.Hide
  public static View build(Object paramObject1, HashMap<String, Object> paramHashMap, boolean paramBoolean, Object paramObject2)
    throws Exception
  {
    if (paramObject1 == null)
      paramObject1 = ViewWrapper.buildNativeView((Context)paramObject2, SeekBar.class, paramHashMap, paramBoolean);
    SeekBar localSeekBar = (SeekBar)ViewWrapper.build(paramObject1, paramHashMap, paramBoolean);
    int i = localSeekBar.getMax();
    localSeekBar.setMax(((Integer)paramHashMap.get("max")).intValue());
    if (localSeekBar.getMax() != i)
      localSeekBar.setProgress(-1);
    localSeekBar.setProgress(((Integer)paramHashMap.get("value")).intValue());
    return localSeekBar;
  }

  public int getMax()
  {
    return ((SeekBar)getObject()).getMax();
  }

  public int getValue()
  {
    return ((SeekBar)getObject()).getProgress();
  }

  @BA.Hide
  public void innerInitialize(final BA paramBA, final String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
      setObject(new SeekBar(paramBA.context));
    super.innerInitialize(paramBA, paramString, true);
    if (paramBA.subExists(paramString + "_valuechanged"))
      ((SeekBar)getObject()).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
      {
        public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          BA localBA = paramBA;
          Object localObject = SeekBarWrapper.this.getObject();
          String str = paramString + "_valuechanged";
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = Integer.valueOf(paramAnonymousInt);
          arrayOfObject[1] = Boolean.valueOf(paramAnonymousBoolean);
          localBA.raiseEventFromUI(localObject, str, arrayOfObject);
        }

        public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
        {
        }

        public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
        {
        }
      });
  }

  public void setMax(int paramInt)
  {
    ((SeekBar)getObject()).setMax(paramInt);
  }

  public void setValue(int paramInt)
  {
    ((SeekBar)getObject()).setProgress(paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.SeekBarWrapper
 * JD-Core Version:    0.6.2
 */