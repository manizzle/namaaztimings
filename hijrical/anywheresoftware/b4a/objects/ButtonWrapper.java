package anywheresoftware.b4a.objects;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.DynamicBuilder;
import java.util.HashMap;

@BA.ShortName("Button")
@BA.ActivityObject
public class ButtonWrapper extends TextViewWrapper<Button>
{
  @BA.Hide
  public static View build(Object paramObject1, HashMap<String, Object> paramHashMap, boolean paramBoolean, Object paramObject2)
    throws Exception
  {
    if (paramObject1 == null)
      paramObject1 = ViewWrapper.buildNativeView((Context)paramObject2, Button.class, paramHashMap, paramBoolean);
    TextView localTextView = (TextView)TextViewWrapper.build(paramObject1, paramHashMap, paramBoolean);
    Drawable localDrawable = (Drawable)DynamicBuilder.build(paramObject1, (HashMap)paramHashMap.get("drawable"), paramBoolean, null);
    if (localDrawable != null)
      localTextView.setBackgroundDrawable(localDrawable);
    if (paramBoolean)
      localTextView.setPressed(((Boolean)paramHashMap.get("pressed")).booleanValue());
    return localTextView;
  }

  @BA.Hide
  public void innerInitialize(final BA paramBA, final String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
      setObject(new Button(paramBA.context));
    super.innerInitialize(paramBA, paramString, true);
    if ((paramBA.subExists(paramString + "_down")) || (paramBA.subExists(paramString + "_up")))
      ((Button)getObject()).setOnTouchListener(new View.OnTouchListener()
      {
        private boolean down = false;

        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            this.down = true;
            paramBA.raiseEventFromUI(ButtonWrapper.this.getObject(), paramString + "_down", new Object[0]);
          }
          do
            while (true)
            {
              return false;
              if ((!this.down) || ((paramAnonymousMotionEvent.getAction() != 1) && (paramAnonymousMotionEvent.getAction() != 3)))
                break;
              this.down = false;
              paramBA.raiseEventFromUI(ButtonWrapper.this.getObject(), paramString + "_up", new Object[0]);
            }
          while (paramAnonymousMotionEvent.getAction() != 2);
          int[] arrayOfInt = paramAnonymousView.getDrawableState();
          if (arrayOfInt == null)
            return false;
          for (int i = 0; ; i++)
          {
            if (i >= arrayOfInt.length)
            {
              if (!this.down)
                break;
              paramBA.raiseEventFromUI(ButtonWrapper.this.getObject(), paramString + "_up", new Object[0]);
              this.down = false;
              break;
            }
            if (arrayOfInt[i] == 16842919)
            {
              if (this.down)
                return false;
              paramBA.raiseEventFromUI(ButtonWrapper.this.getObject(), paramString + "_down", new Object[0]);
              this.down = true;
              return false;
            }
          }
        }
      });
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.ButtonWrapper
 * JD-Core Version:    0.6.2
 */