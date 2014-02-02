package com.dawoodibohra.times;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;
import java.util.ArrayList;

public class CustomItemizedOverlay extends ItemizedOverlay
{
  Context mContext;
  private ArrayList<OverlayItem> mOverlays = new ArrayList();

  public CustomItemizedOverlay(Drawable paramDrawable, Context paramContext)
  {
    super(boundCenterBottom(paramDrawable));
    this.mContext = paramContext;
  }

  public void addOverlay(OverlayItem paramOverlayItem)
  {
    this.mOverlays.add(paramOverlayItem);
    populate();
  }

  protected OverlayItem createItem(int paramInt)
  {
    return (OverlayItem)this.mOverlays.get(paramInt);
  }

  protected boolean onTap(int paramInt)
  {
    OverlayItem localOverlayItem = (OverlayItem)this.mOverlays.get(paramInt);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mContext);
    localBuilder.setTitle(localOverlayItem.getTitle());
    localBuilder.setMessage(localOverlayItem.getSnippet());
    localBuilder.show();
    return true;
  }

  public int size()
  {
    return this.mOverlays.size();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     dawoodibohra.salaat.CustomItemizedOverlay
 * JD-Core Version:    0.6.2
 */