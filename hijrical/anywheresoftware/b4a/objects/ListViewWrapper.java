package anywheresoftware.b4a.objects;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.DynamicBuilder;
import java.util.ArrayList;
import java.util.HashMap;

@BA.ShortName("ListView")
@BA.ActivityObject
public class ListViewWrapper extends ViewWrapper<SimpleListView>
{
  @BA.Hide
  public static View build(Object paramObject1, HashMap<String, Object> paramHashMap, boolean paramBoolean, Object paramObject2)
    throws Exception
  {
    if (paramObject1 == null)
      paramObject1 = ViewWrapper.buildNativeView((Context)paramObject2, SimpleListView.class, paramHashMap, paramBoolean);
    ListView localListView = (ListView)ViewWrapper.build(paramObject1, paramHashMap, paramBoolean);
    Drawable localDrawable = (Drawable)DynamicBuilder.build(localListView, (HashMap)paramHashMap.get("drawable"), paramBoolean, null);
    if (localDrawable != null)
      localListView.setBackgroundDrawable(localDrawable);
    localListView.setFastScrollEnabled(((Boolean)paramHashMap.get("fastScrollEnabled")).booleanValue());
    SimpleListView localSimpleListView;
    if (paramBoolean)
    {
      localSimpleListView = (SimpleListView)localListView;
      if (localSimpleListView.adapter.items.size() != 0);
    }
    for (int i = 1; ; i++)
    {
      if (i > 10)
      {
        localSimpleListView.adapter.notifyDataSetChanged();
        return localListView;
      }
      SimpleListAdapter.SingleLineData localSingleLineData = new SimpleListAdapter.SingleLineData();
      localSingleLineData.Text = ("Item #" + i);
      localSimpleListView.adapter.items.add(localSingleLineData);
    }
  }

  public void AddSingleLine(String paramString)
  {
    AddSingleLine2(paramString, null);
  }

  public void AddSingleLine2(String paramString, Object paramObject)
  {
    SimpleListAdapter.SingleLineData localSingleLineData = new SimpleListAdapter.SingleLineData();
    localSingleLineData.Text = paramString;
    localSingleLineData.ReturnValue = paramObject;
    add(localSingleLineData);
  }

  public void AddTwoLines(String paramString1, String paramString2)
  {
    AddTwoLines2(paramString1, paramString2, null);
  }

  public void AddTwoLines2(String paramString1, String paramString2, Object paramObject)
  {
    SimpleListAdapter.TwoLinesData localTwoLinesData = new SimpleListAdapter.TwoLinesData();
    localTwoLinesData.Text = paramString1;
    localTwoLinesData.ReturnValue = paramObject;
    localTwoLinesData.SecondLineText = paramString2;
    add(localTwoLinesData);
  }

  public void AddTwoLinesAndBitmap(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    AddTwoLinesAndBitmap2(paramString1, paramString2, paramBitmap, null);
  }

  public void AddTwoLinesAndBitmap2(String paramString1, String paramString2, Bitmap paramBitmap, Object paramObject)
  {
    SimpleListAdapter.TwoLinesAndBitmapData localTwoLinesAndBitmapData = new SimpleListAdapter.TwoLinesAndBitmapData();
    localTwoLinesAndBitmapData.Text = paramString1;
    localTwoLinesAndBitmapData.ReturnValue = paramObject;
    localTwoLinesAndBitmapData.SecondLineText = paramString2;
    localTwoLinesAndBitmapData.Bitmap = paramBitmap;
    add(localTwoLinesAndBitmapData);
  }

  public void Clear()
  {
    ((SimpleListView)getObject()).adapter.items.clear();
    ((SimpleListView)getObject()).adapter.notifyDataSetChanged();
  }

  public Object GetItem(int paramInt)
  {
    return ((SimpleListView)getObject()).adapter.getItem(paramInt);
  }

  public void RemoveAt(int paramInt)
  {
    ((SimpleListView)getObject()).adapter.items.remove(paramInt);
    ((SimpleListView)getObject()).adapter.notifyDataSetChanged();
  }

  public void SetSelection(int paramInt)
  {
    ((SimpleListView)getObject()).setSelection(paramInt);
  }

  @BA.Hide
  public void add(SimpleListAdapter.SimpleItem paramSimpleItem)
  {
    ((SimpleListView)getObject()).adapter.items.add(paramSimpleItem);
    ((SimpleListView)getObject()).adapter.notifyDataSetChanged();
  }

  public boolean getFastScrollEnabled()
  {
    return ((SimpleListView)getObject()).isFastScrollEnabled();
  }

  public SimpleListAdapter.SingleLineLayout getSingleLineLayout()
  {
    return ((SimpleListView)getObject()).adapter.SingleLine;
  }

  public int getSize()
  {
    return ((SimpleListView)getObject()).adapter.getCount();
  }

  public SimpleListAdapter.TwoLinesAndBitmapLayout getTwoLinesAndBitmap()
  {
    return ((SimpleListView)getObject()).adapter.TwoLinesAndBitmap;
  }

  public SimpleListAdapter.TwoLinesLayout getTwoLinesLayout()
  {
    return ((SimpleListView)getObject()).adapter.TwoLines;
  }

  @BA.Hide
  public void innerInitialize(final BA paramBA, final String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
      setObject(new SimpleListView(paramBA.context));
    super.innerInitialize(paramBA, paramString, true);
    if (paramBA.subExists(paramString + "_itemclick"))
      ((SimpleListView)getObject()).setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          BA localBA = paramBA;
          Object localObject = ListViewWrapper.this.getObject();
          String str = paramString + "_itemclick";
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = Integer.valueOf(paramAnonymousInt);
          arrayOfObject[1] = ((ListViewWrapper.SimpleListView)ListViewWrapper.this.getObject()).adapter.getItem(paramAnonymousInt);
          localBA.raiseEventFromUI(localObject, str, arrayOfObject);
        }
      });
    if (paramBA.subExists(paramString + "_itemlongclick"))
      ((SimpleListView)getObject()).setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          BA localBA = paramBA;
          Object localObject = ListViewWrapper.this.getObject();
          String str = paramString + "_itemlongclick";
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = Integer.valueOf(paramAnonymousInt);
          arrayOfObject[1] = ((ListViewWrapper.SimpleListView)ListViewWrapper.this.getObject()).adapter.getItem(paramAnonymousInt);
          localBA.raiseEventFromUI(localObject, str, arrayOfObject);
          return true;
        }
      });
  }

  public void setFastScrollEnabled(boolean paramBoolean)
  {
    ((SimpleListView)getObject()).setFastScrollEnabled(paramBoolean);
  }

  public void setScrollingBackgroundColor(int paramInt)
  {
    ((SimpleListView)getObject()).setCacheColorHint(paramInt);
  }

  @BA.Hide
  public static class SimpleListView extends ListView
  {
    public SimpleListAdapter adapter;

    public SimpleListView(Context paramContext)
    {
      super();
      this.adapter = new SimpleListAdapter(paramContext);
      setAdapter(this.adapter);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.ListViewWrapper
 * JD-Core Version:    0.6.2
 */