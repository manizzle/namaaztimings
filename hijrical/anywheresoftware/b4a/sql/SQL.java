package anywheresoftware.b4a.sql;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.CheckForReinitialize;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import anywheresoftware.b4a.objects.collections.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

@BA.ShortName("SQL")
@BA.Version(1.2F)
public class SQL
  implements BA.CheckForReinitialize
{
  private SQLiteDatabase db;
  private volatile ArrayList<Object[]> nonQueryStatementsList = new ArrayList();

  public static void LIBRARY_DOC()
  {
  }

  private void checkNull()
  {
    if (this.db == null)
      throw new RuntimeException("Object should first be initialized.");
  }

  public void AddNonQueryToBatch(String paramString, List paramList)
  {
    this.nonQueryStatementsList.add(new Object[] { paramString, paramList });
  }

  public void BeginTransaction()
  {
    checkNull();
    this.db.beginTransaction();
  }

  public void Close()
  {
    if ((this.db != null) && (this.db.isOpen()))
      this.db.close();
  }

  public void EndTransaction()
  {
    this.db.endTransaction();
  }

  public void ExecNonQuery(String paramString)
  {
    checkNull();
    this.db.execSQL(paramString);
  }

  public void ExecNonQuery2(String paramString, List paramList)
  {
    SQLiteStatement localSQLiteStatement = this.db.compileStatement(paramString);
    while (true)
    {
      try
      {
        int i;
        if (!paramList.IsInitialized())
        {
          i = 0;
          break label76;
          if (j >= i)
            localSQLiteStatement.execute();
        }
        else
        {
          i = paramList.getSize();
          break label76;
        }
        DatabaseUtils.bindObjectToProgram(localSQLiteStatement, j + 1, paramList.Get(j));
        j++;
        continue;
      }
      finally
      {
        localSQLiteStatement.close();
      }
      label76: int j = 0;
    }
  }

  public void ExecNonQueryBatch(final BA paramBA, final String paramString)
  {
    final ArrayList localArrayList = this.nonQueryStatementsList;
    this.nonQueryStatementsList = new ArrayList();
    BA.submitRunnable(new Runnable()
    {
      public void run()
      {
        synchronized (SQL.this.db)
        {
          try
          {
            SQL.this.BeginTransaction();
            Iterator localIterator = localArrayList.iterator();
            while (true)
            {
              if (!localIterator.hasNext())
              {
                SQL.this.TransactionSuccessful();
                SQL.this.EndTransaction();
                BA localBA2 = paramBA;
                SQL localSQL3 = SQL.this;
                SQL localSQL4 = SQL.this;
                String str2 = paramString.toLowerCase(BA.cul) + "_nonquerycomplete";
                Object[] arrayOfObject3 = new Object[1];
                arrayOfObject3[0] = Boolean.valueOf(true);
                localBA2.raiseEventFromDifferentThread(localSQL3, localSQL4, 0, str2, true, arrayOfObject3);
                return;
              }
              Object[] arrayOfObject2 = (Object[])localIterator.next();
              SQL.this.ExecNonQuery2((String)arrayOfObject2[0], (List)arrayOfObject2[1]);
            }
          }
          catch (Exception localException)
          {
            while (true)
            {
              SQL.this.EndTransaction();
              localException.printStackTrace();
              paramBA.setLastException(localException);
              BA localBA1 = paramBA;
              SQL localSQL1 = SQL.this;
              SQL localSQL2 = SQL.this;
              String str1 = paramString.toLowerCase(BA.cul) + "_nonquerycomplete";
              Object[] arrayOfObject1 = new Object[1];
              arrayOfObject1[0] = Boolean.valueOf(false);
              localBA1.raiseEventFromDifferentThread(localSQL1, localSQL2, 0, str1, true, arrayOfObject1);
            }
          }
        }
      }
    }
    , this, 1);
  }

  public Cursor ExecQuery(String paramString)
  {
    checkNull();
    return ExecQuery2(paramString, null);
  }

  public Cursor ExecQuery2(String paramString, String[] paramArrayOfString)
  {
    checkNull();
    return this.db.rawQuery(paramString, paramArrayOfString);
  }

  public void ExecQueryAsync(final BA paramBA, final String paramString1, final String paramString2, final String[] paramArrayOfString)
  {
    BA.submitRunnable(new Runnable()
    {
      public void run()
      {
        try
        {
          Cursor localCursor = SQL.this.ExecQuery2(paramString2, paramArrayOfString);
          BA localBA2 = paramBA;
          SQL localSQL3 = SQL.this;
          SQL localSQL4 = SQL.this;
          String str2 = paramString1.toLowerCase(BA.cul) + "_querycomplete";
          Object[] arrayOfObject2 = new Object[2];
          arrayOfObject2[0] = Boolean.valueOf(true);
          arrayOfObject2[1] = AbsObjectWrapper.ConvertToWrapper(new SQL.CursorWrapper(), localCursor);
          localBA2.raiseEventFromDifferentThread(localSQL3, localSQL4, 0, str2, true, arrayOfObject2);
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          paramBA.setLastException(localException);
          BA localBA1 = paramBA;
          SQL localSQL1 = SQL.this;
          SQL localSQL2 = SQL.this;
          String str1 = paramString1.toLowerCase(BA.cul) + "_querycomplete";
          Object[] arrayOfObject1 = new Object[2];
          arrayOfObject1[0] = Boolean.valueOf(false);
          arrayOfObject1[1] = AbsObjectWrapper.ConvertToWrapper(new SQL.CursorWrapper(), null);
          localBA1.raiseEventFromDifferentThread(localSQL1, localSQL2, 0, str1, true, arrayOfObject1);
        }
      }
    }
    , this, 0);
  }

  public String ExecQuerySingleResult(String paramString)
  {
    return ExecQuerySingleResult2(paramString, null);
  }

  public String ExecQuerySingleResult2(String paramString, String[] paramArrayOfString)
  {
    checkNull();
    Cursor localCursor = this.db.rawQuery(paramString, paramArrayOfString);
    try
    {
      boolean bool = localCursor.moveToFirst();
      if (!bool);
      while (localCursor.getColumnCount() == 0)
        return null;
      String str = localCursor.getString(0);
      return str;
    }
    finally
    {
      localCursor.close();
    }
  }

  public void Initialize(String paramString1, String paramString2, boolean paramBoolean)
  {
    String str = new File(paramString1, paramString2).toString();
    if (paramBoolean);
    for (int i = 268435456; ; i = 0)
    {
      this.db = SQLiteDatabase.openDatabase(str, null, i | 0x10);
      return;
    }
  }

  public boolean IsInitialized()
  {
    if (this.db == null)
      return false;
    return this.db.isOpen();
  }

  public void TransactionSuccessful()
  {
    this.db.setTransactionSuccessful();
  }

  @BA.ShortName("Cursor")
  public static class CursorWrapper extends AbsObjectWrapper<Cursor>
  {
    public void Close()
    {
      ((Cursor)getObject()).close();
    }

    public byte[] GetBlob(String paramString)
    {
      return ((Cursor)getObject()).getBlob(((Cursor)getObject()).getColumnIndexOrThrow(paramString));
    }

    public byte[] GetBlob2(int paramInt)
    {
      return ((Cursor)getObject()).getBlob(paramInt);
    }

    public String GetColumnName(int paramInt)
    {
      return ((Cursor)getObject()).getColumnName(paramInt);
    }

    public Double GetDouble(String paramString)
    {
      return Double.valueOf(((Cursor)getObject()).getDouble(((Cursor)getObject()).getColumnIndexOrThrow(paramString)));
    }

    public Double GetDouble2(int paramInt)
    {
      return Double.valueOf(((Cursor)getObject()).getDouble(paramInt));
    }

    public int GetInt(String paramString)
    {
      return ((Cursor)getObject()).getInt(((Cursor)getObject()).getColumnIndexOrThrow(paramString));
    }

    public int GetInt2(int paramInt)
    {
      return ((Cursor)getObject()).getInt(paramInt);
    }

    public Long GetLong(String paramString)
    {
      return Long.valueOf(((Cursor)getObject()).getLong(((Cursor)getObject()).getColumnIndexOrThrow(paramString)));
    }

    public Long GetLong2(int paramInt)
    {
      return Long.valueOf(((Cursor)getObject()).getLong(paramInt));
    }

    public String GetString(String paramString)
    {
      return ((Cursor)getObject()).getString(((Cursor)getObject()).getColumnIndexOrThrow(paramString));
    }

    public String GetString2(int paramInt)
    {
      return ((Cursor)getObject()).getString(paramInt);
    }

    public int getColumnCount()
    {
      return ((Cursor)getObject()).getColumnCount();
    }

    public int getPosition()
    {
      return ((Cursor)getObject()).getPosition();
    }

    public int getRowCount()
    {
      return ((Cursor)getObject()).getCount();
    }

    public void setPosition(int paramInt)
    {
      ((Cursor)getObject()).moveToPosition(paramInt);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.sql.SQL
 * JD-Core Version:    0.6.2
 */