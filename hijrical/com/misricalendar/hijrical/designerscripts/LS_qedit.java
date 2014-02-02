package com.misricalendar.hijrical.designerscripts;

import anywheresoftware.b4a.keywords.LayoutBuilder;
import anywheresoftware.b4a.objects.ViewWrapper;
import java.util.HashMap;

public class LS_qedit
{
  public static void LS_general(HashMap<String, ViewWrapper<?>> paramHashMap, int paramInt1, int paramInt2, float paramFloat)
  {
    LayoutBuilder.setScaleRate(0.3D);
    LayoutBuilder.scaleAll(paramHashMap);
    ((ViewWrapper)paramHashMap.get("pnlqedit")).setHeight((int)(1.0D * paramInt2 - ((ViewWrapper)paramHashMap.get("pnlqedit")).getTop() - 2.0D * paramFloat));
    ((ViewWrapper)paramHashMap.get("pnltable")).setHeight((int)(1.0D * paramInt2 - ((ViewWrapper)paramHashMap.get("pnltable")).getTop() - 2.0D * paramFloat));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.misricalendar.hijrical.designerscripts.LS_qedit
 * JD-Core Version:    0.6.2
 */