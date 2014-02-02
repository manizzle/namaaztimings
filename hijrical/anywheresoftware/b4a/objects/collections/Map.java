package anywheresoftware.b4a.objects.collections;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.B4aDebuggable;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.IterableList;
import anywheresoftware.b4a.BA.ShortName;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

@BA.ShortName("Map")
public class Map extends AbsObjectWrapper<MyMap>
  implements BA.B4aDebuggable
{
  public void Clear()
  {
    ((MyMap)getObject()).clear();
  }

  public boolean ContainsKey(Object paramObject)
  {
    return ((MyMap)getObject()).containsKey(paramObject);
  }

  public Object Get(Object paramObject)
  {
    return ((MyMap)getObject()).get(paramObject);
  }

  public Object GetDefault(Object paramObject1, Object paramObject2)
  {
    Object localObject = ((MyMap)getObject()).get(paramObject1);
    if (localObject == null)
      return paramObject2;
    return localObject;
  }

  public Object GetKeyAt(int paramInt)
  {
    return ((MyMap)getObject()).getKey(paramInt);
  }

  public Object GetValueAt(int paramInt)
  {
    return ((MyMap)getObject()).getValue(paramInt);
  }

  public void Initialize()
  {
    setObject(new MyMap());
  }

  public BA.IterableList Keys()
  {
    return new BA.IterableList()
    {
      public Object Get(int paramAnonymousInt)
      {
        return Map.this.GetKeyAt(paramAnonymousInt);
      }

      public int getSize()
      {
        return Map.this.getSize();
      }
    };
  }

  public Object Put(Object paramObject1, Object paramObject2)
  {
    return ((MyMap)getObject()).put(paramObject1, paramObject2);
  }

  public Object Remove(Object paramObject)
  {
    return ((MyMap)getObject()).remove(paramObject);
  }

  public BA.IterableList Values()
  {
    return new BA.IterableList()
    {
      public Object Get(int paramAnonymousInt)
      {
        return Map.this.GetValueAt(paramAnonymousInt);
      }

      public int getSize()
      {
        return Map.this.getSize();
      }
    };
  }

  @BA.Hide
  public Object[] debug(int paramInt, boolean[] paramArrayOfBoolean)
  {
    Object[] arrayOfObject = new Object[2 * (1 + Math.min(getSize(), paramInt))];
    arrayOfObject[0] = "Size";
    arrayOfObject[1] = Integer.valueOf(getSize());
    int i = 2;
    Iterator localIterator = ((MyMap)getObject()).entrySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        paramArrayOfBoolean[0] = false;
        return arrayOfObject;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      arrayOfObject[i] = String.valueOf(localEntry.getKey());
      arrayOfObject[(i + 1)] = localEntry.getValue();
      i += 2;
    }
  }

  public int getSize()
  {
    return ((MyMap)getObject()).size();
  }

  @BA.Hide
  public static class MyMap
    implements java.util.Map<Object, Object>
  {
    private Map.Entry<Object, Object> currentEntry;
    private LinkedHashMap<Object, Object> innerMap = new LinkedHashMap();
    private Iterator<Map.Entry<Object, Object>> iterator;
    private int iteratorPosition;

    private Map.Entry<Object, Object> getEntry(int paramInt)
    {
      if ((this.iterator != null) && (this.iteratorPosition != paramInt))
      {
        if (this.iteratorPosition == paramInt - 1)
        {
          this.currentEntry = ((Map.Entry)this.iterator.next());
          this.iteratorPosition = (1 + this.iteratorPosition);
        }
      }
      else if (this.iterator == null)
        this.iterator = this.innerMap.entrySet().iterator();
      for (int i = 0; ; i++)
      {
        if (i > paramInt)
        {
          this.iteratorPosition = paramInt;
          return this.currentEntry;
          this.iterator = null;
          break;
        }
        this.currentEntry = ((Map.Entry)this.iterator.next());
      }
    }

    public void clear()
    {
      this.iterator = null;
      this.innerMap.clear();
    }

    public boolean containsKey(Object paramObject)
    {
      return this.innerMap.containsKey(paramObject);
    }

    public boolean containsValue(Object paramObject)
    {
      return this.innerMap.containsValue(paramObject);
    }

    public Set<Map.Entry<Object, Object>> entrySet()
    {
      return this.innerMap.entrySet();
    }

    public Object get(Object paramObject)
    {
      return this.innerMap.get(paramObject);
    }

    public Object getKey(int paramInt)
    {
      return getEntry(paramInt).getKey();
    }

    public Object getValue(int paramInt)
    {
      return getEntry(paramInt).getValue();
    }

    public boolean isEmpty()
    {
      return this.innerMap.isEmpty();
    }

    public Set<Object> keySet()
    {
      return this.innerMap.keySet();
    }

    public Object put(Object paramObject1, Object paramObject2)
    {
      this.iterator = null;
      return this.innerMap.put(paramObject1, paramObject2);
    }

    public void putAll(java.util.Map<? extends Object, ? extends Object> paramMap)
    {
      this.iterator = null;
      this.innerMap.putAll(paramMap);
    }

    public Object remove(Object paramObject)
    {
      this.iterator = null;
      return this.innerMap.remove(paramObject);
    }

    public int size()
    {
      return this.innerMap.size();
    }

    public String toString()
    {
      return this.innerMap.toString();
    }

    public Collection<Object> values()
    {
      return this.innerMap.values();
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.collections.Map
 * JD-Core Version:    0.6.2
 */