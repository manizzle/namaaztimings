package anywheresoftware.b4a.objects;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.BALayout.LayoutParams;
import anywheresoftware.b4a.keywords.Common;
import java.util.ArrayList;

@BA.Hide
public class SimpleListAdapter extends BaseAdapter
  implements ListAdapter
{
  private static final int SINGLE_LINE_ITEM = 0;
  private static final int TWO_LINES_AND_BITMAP_ITEM = 2;
  private static final int TWO_LINES_ITEM = 1;
  public SingleLineLayout SingleLine;
  public TwoLinesLayout TwoLines;
  public TwoLinesAndBitmapLayout TwoLinesAndBitmap;
  public BALayout dummyParent;
  public ArrayList<SimpleItem> items = new ArrayList();
  private ItemLayout[] layouts;

  public SimpleListAdapter(Context paramContext)
  {
    this.dummyParent = new BALayout(paramContext);
    this.SingleLine = new SingleLineLayout(this.dummyParent, false, null, null);
    this.TwoLines = new TwoLinesLayout(this.dummyParent, false, null, null);
    this.TwoLinesAndBitmap = new TwoLinesAndBitmapLayout(this.dummyParent, null);
    this.layouts = new ItemLayout[3];
    this.layouts[0] = this.SingleLine;
    this.layouts[1] = this.TwoLines;
    this.layouts[2] = this.TwoLinesAndBitmap;
  }

  public int getCount()
  {
    return this.items.size();
  }

  public Object getItem(int paramInt)
  {
    return ((SimpleItem)this.items.get(paramInt)).getReturnValue();
  }

  public long getItemId(int paramInt)
  {
    return 0L;
  }

  public int getItemViewType(int paramInt)
  {
    return ((SimpleItem)this.items.get(paramInt)).getType();
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    SimpleItem localSimpleItem = (SimpleItem)this.items.get(paramInt);
    if (paramView == null)
    {
      BALayout localBALayout = new BALayout(paramViewGroup.getContext());
      localBALayout.setLayoutParams(new AbsListView.LayoutParams(-1, this.layouts[localSimpleItem.getType()].getItemHeight()));
      localSimpleItem.addNewToLayout(localBALayout, this);
      paramView = localBALayout;
    }
    localSimpleItem.updateExisting((ViewGroup)paramView, this);
    return paramView;
  }

  public int getViewTypeCount()
  {
    return 3;
  }

  public static abstract interface ItemLayout
  {
    public abstract int getItemHeight();
  }

  public static abstract interface SimpleItem
  {
    public abstract void addNewToLayout(ViewGroup paramViewGroup, SimpleListAdapter paramSimpleListAdapter);

    public abstract Object getReturnValue();

    public abstract int getType();

    public abstract void updateExisting(ViewGroup paramViewGroup, SimpleListAdapter paramSimpleListAdapter);
  }

  @BA.Hide
  public static class SingleLineData
    implements SimpleListAdapter.SimpleItem
  {
    public Object ReturnValue;
    public String Text;

    @BA.Hide
    public void addNewToLayout(ViewGroup paramViewGroup, SimpleListAdapter paramSimpleListAdapter)
    {
      paramViewGroup.setBackgroundDrawable(paramSimpleListAdapter.SingleLine.Background);
      addNewToLayoutImpl(paramViewGroup, (TextView)paramSimpleListAdapter.SingleLine.Label.getObject());
    }

    protected void addNewToLayoutImpl(ViewGroup paramViewGroup, TextView paramTextView)
    {
      TextView localTextView = new TextView(paramViewGroup.getContext());
      paramViewGroup.addView(localTextView, paramTextView.getLayoutParams());
      localTextView.setBackgroundDrawable(paramTextView.getBackground());
      localTextView.setTextSize(paramTextView.getTextSize() / paramViewGroup.getContext().getResources().getDisplayMetrics().scaledDensity);
      localTextView.setTextColor(paramTextView.getTextColors());
      localTextView.setGravity(paramTextView.getGravity());
      localTextView.setVisibility(paramTextView.getVisibility());
      localTextView.setTypeface(paramTextView.getTypeface());
    }

    @BA.Hide
    public Object getReturnValue()
    {
      if (this.ReturnValue == null)
        return this.Text;
      return this.ReturnValue;
    }

    @BA.Hide
    public int getType()
    {
      return 0;
    }

    @BA.Hide
    public void updateExisting(ViewGroup paramViewGroup, SimpleListAdapter paramSimpleListAdapter)
    {
      ((TextView)paramViewGroup.getChildAt(0)).setText(this.Text);
    }
  }

  public static class SingleLineLayout
    implements SimpleListAdapter.ItemLayout
  {
    public Drawable Background;
    public LabelWrapper Label;
    protected int itemHeight;

    private SingleLineLayout(ViewGroup paramViewGroup, boolean paramBoolean)
    {
      TextView localTextView = new TextView(paramViewGroup.getContext());
      this.Label = new LabelWrapper();
      this.Label.setObject(localTextView);
      if (!paramBoolean)
      {
        localTextView.setTextSize(22.5F);
        localTextView.setTextColor(-1);
        this.itemHeight = Common.DipToCurrent(50);
        localTextView.setGravity(16);
        paramViewGroup.addView(localTextView, new BALayout.LayoutParams(Common.DipToCurrent(5), 0, -1, -1));
      }
    }

    public int getItemHeight()
    {
      return this.itemHeight;
    }

    public void setItemHeight(int paramInt)
    {
      this.itemHeight = paramInt;
    }
  }

  @BA.Hide
  public static class TwoLinesAndBitmapData extends SimpleListAdapter.TwoLinesData
  {
    public Bitmap Bitmap;

    @BA.Hide
    public void addNewToLayout(ViewGroup paramViewGroup, SimpleListAdapter paramSimpleListAdapter)
    {
      paramViewGroup.setBackgroundDrawable(paramSimpleListAdapter.TwoLinesAndBitmap.Background);
      super.addNewToLayoutImpl(paramViewGroup, (TextView)paramSimpleListAdapter.TwoLinesAndBitmap.Label.getObject());
      super.addNewToLayoutImpl(paramViewGroup, (TextView)paramSimpleListAdapter.TwoLinesAndBitmap.SecondLabel.getObject());
      ImageView localImageView1 = new ImageView(paramViewGroup.getContext());
      ImageView localImageView2 = (ImageView)paramSimpleListAdapter.TwoLinesAndBitmap.ImageView.getObject();
      paramViewGroup.addView(localImageView1, localImageView2.getLayoutParams());
      localImageView1.setVisibility(localImageView2.getVisibility());
    }

    @BA.Hide
    public int getType()
    {
      return 2;
    }

    @BA.Hide
    public void updateExisting(ViewGroup paramViewGroup, SimpleListAdapter paramSimpleListAdapter)
    {
      super.updateExisting(paramViewGroup, paramSimpleListAdapter);
      ImageView localImageView = (ImageView)paramViewGroup.getChildAt(2);
      if (this.Bitmap != null);
      for (int i = 0; ; i = 8)
      {
        localImageView.setVisibility(i);
        if (this.Bitmap != null)
          localImageView.setBackgroundDrawable(new BitmapDrawable(this.Bitmap));
        return;
      }
    }
  }

  public static class TwoLinesAndBitmapLayout extends SimpleListAdapter.TwoLinesLayout
  {
    public ImageViewWrapper ImageView;

    private TwoLinesAndBitmapLayout(ViewGroup paramViewGroup)
    {
      super(true, null);
      TextView localTextView1 = (TextView)this.Label.getObject();
      TextView localTextView2 = (TextView)this.SecondLabel.getObject();
      localTextView1.setTextSize(19.5F);
      localTextView2.setTextSize(16.5F);
      this.itemHeight = Common.DipToCurrent(60);
      localTextView1.setGravity(80);
      localTextView2.setGravity(48);
      localTextView1.setTextColor(-1);
      localTextView2.setTextColor(-7829368);
      paramViewGroup.addView(localTextView1, new BALayout.LayoutParams(Common.DipToCurrent(60), 0, -1, Common.DipToCurrent(30)));
      paramViewGroup.addView(localTextView2, new BALayout.LayoutParams(Common.DipToCurrent(60), Common.DipToCurrent(32), -1, Common.DipToCurrent(28)));
      ImageView localImageView = new ImageView(paramViewGroup.getContext());
      this.ImageView = new ImageViewWrapper();
      this.ImageView.setObject(localImageView);
      paramViewGroup.addView(localImageView, new BALayout.LayoutParams(Common.DipToCurrent(5), Common.DipToCurrent(5), Common.DipToCurrent(50), Common.DipToCurrent(50)));
    }
  }

  @BA.Hide
  public static class TwoLinesData extends SimpleListAdapter.SingleLineData
  {
    public String SecondLineText;

    @BA.Hide
    public void addNewToLayout(ViewGroup paramViewGroup, SimpleListAdapter paramSimpleListAdapter)
    {
      paramViewGroup.setBackgroundDrawable(paramSimpleListAdapter.TwoLines.Background);
      super.addNewToLayoutImpl(paramViewGroup, (TextView)paramSimpleListAdapter.TwoLines.Label.getObject());
      super.addNewToLayoutImpl(paramViewGroup, (TextView)paramSimpleListAdapter.TwoLines.SecondLabel.getObject());
    }

    @BA.Hide
    public int getType()
    {
      return 1;
    }

    @BA.Hide
    public void updateExisting(ViewGroup paramViewGroup, SimpleListAdapter paramSimpleListAdapter)
    {
      super.updateExisting(paramViewGroup, paramSimpleListAdapter);
      ((TextView)paramViewGroup.getChildAt(1)).setText(this.SecondLineText);
    }
  }

  public static class TwoLinesLayout extends SimpleListAdapter.SingleLineLayout
  {
    public LabelWrapper SecondLabel;

    private TwoLinesLayout(ViewGroup paramViewGroup, boolean paramBoolean)
    {
      super(true, null);
      TextView localTextView1 = new TextView(paramViewGroup.getContext());
      this.SecondLabel = new LabelWrapper();
      this.SecondLabel.setObject(localTextView1);
      if (!paramBoolean)
      {
        TextView localTextView2 = (TextView)this.Label.getObject();
        localTextView2.setTextSize(19.5F);
        localTextView1.setTextSize(16.5F);
        this.itemHeight = Common.DipToCurrent(60);
        localTextView2.setGravity(80);
        localTextView1.setGravity(48);
        localTextView2.setTextColor(-1);
        localTextView1.setTextColor(-7829368);
        paramViewGroup.addView(localTextView2, new BALayout.LayoutParams(Common.DipToCurrent(5), 0, -1, Common.DipToCurrent(30)));
        paramViewGroup.addView(localTextView1, new BALayout.LayoutParams(Common.DipToCurrent(5), Common.DipToCurrent(32), -1, Common.DipToCurrent(28)));
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.SimpleListAdapter
 * JD-Core Version:    0.6.2
 */