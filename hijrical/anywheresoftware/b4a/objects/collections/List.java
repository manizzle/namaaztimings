package anywheresoftware.b4a.objects.collections;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.IterableList;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.WarningEngine;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

@BA.ShortName("List")
public class List extends AbsObjectWrapper<java.util.List<Object>>
  implements BA.IterableList
{
  private void sortList(String paramString, final boolean paramBoolean1, final boolean paramBoolean2)
    throws SecurityException, NoSuchFieldException
  {
    if (getSize() == 0)
      return;
    final Field localField = Get(0).getClass().getDeclaredField(paramString);
    localField.setAccessible(true);
    Comparator local2 = new Comparator()
    {
      public int compare(Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        int j;
        int k;
        try
        {
          if (paramBoolean2);
          int i;
          for (j = String.valueOf(paramAnonymousObject1).compareToIgnoreCase(String.valueOf(paramAnonymousObject2)); paramBoolean1; j = i)
          {
            k = 1;
            break label82;
            i = ((Comparable)localField.get(paramAnonymousObject1)).compareTo(localField.get(paramAnonymousObject2));
          }
          k = -1;
        }
        catch (Exception localException)
        {
          throw new RuntimeException(localException);
        }
        label82: return k * j;
      }
    };
    Collections.sort((java.util.List)getObject(), local2);
  }

  public void Add(Object paramObject)
  {
    if ((BA.debugMode) && (((java.util.List)getObject()).size() > 0))
    {
      Object localObject = Get(getSize() - 1);
      if ((localObject != null) && (localObject == paramObject) && (!(localObject instanceof String)) && (!(localObject instanceof Number)) && (!(localObject instanceof Boolean)))
        BA.WarningEngine.warn(1002);
    }
    ((java.util.List)getObject()).add(paramObject);
  }

  public void AddAll(List paramList)
  {
    ((java.util.List)getObject()).addAll((Collection)paramList.getObject());
  }

  public void AddAllAt(int paramInt, List paramList)
  {
    ((java.util.List)getObject()).addAll(paramInt, (Collection)paramList.getObject());
  }

  public void Clear()
  {
    ((java.util.List)getObject()).clear();
  }

  public Object Get(int paramInt)
  {
    return ((java.util.List)getObject()).get(paramInt);
  }

  public int IndexOf(Object paramObject)
  {
    return ((java.util.List)getObject()).indexOf(paramObject);
  }

  public void Initialize()
  {
    setObject(new ArrayList());
  }

  public void Initialize2(List paramList)
  {
    setObject((java.util.List)paramList.getObject());
  }

  public void InsertAt(int paramInt, Object paramObject)
  {
    ((java.util.List)getObject()).add(paramInt, paramObject);
  }

  public void RemoveAt(int paramInt)
  {
    ((java.util.List)getObject()).remove(paramInt);
  }

  public void Set(int paramInt, Object paramObject)
  {
    ((java.util.List)getObject()).set(paramInt, paramObject);
  }

  public void Sort(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Collections.sort((java.util.List)getObject());
      return;
    }
    Collections.sort((java.util.List)getObject(), new Comparator()
    {
      public int compare(Comparable paramAnonymousComparable1, Comparable paramAnonymousComparable2)
      {
        return paramAnonymousComparable2.compareTo(paramAnonymousComparable1);
      }
    });
  }

  public void SortCaseInsensitive(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Collections.sort((java.util.List)getObject(), new Comparator()
      {
        public int compare(Comparable paramAnonymousComparable1, Comparable paramAnonymousComparable2)
        {
          return paramAnonymousComparable1.toString().compareToIgnoreCase(paramAnonymousComparable2.toString());
        }
      });
      return;
    }
    Collections.sort((java.util.List)getObject(), new Comparator()
    {
      public int compare(Comparable paramAnonymousComparable1, Comparable paramAnonymousComparable2)
      {
        return paramAnonymousComparable2.toString().compareToIgnoreCase(paramAnonymousComparable1.toString());
      }
    });
  }

  public void SortType(String paramString, boolean paramBoolean)
    throws SecurityException, NoSuchFieldException
  {
    sortList(paramString, paramBoolean, false);
  }

  public void SortTypeCaseInsensitive(String paramString, boolean paramBoolean)
    throws SecurityException, NoSuchFieldException
  {
    sortList(paramString, paramBoolean, true);
  }

  public int getSize()
  {
    return ((java.util.List)getObject()).size();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.collections.List
 * JD-Core Version:    0.6.2
 */