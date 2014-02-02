package anywheresoftware.b4a.objects.streams;

import android.app.Application;
import android.content.ContentResolver;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Environment;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class File
{

  @BA.Hide
  public static final String ContentDir = "ContentDir";
  private static final String assetsDir = "AssetsDir";

  public static String Combine(String paramString1, String paramString2)
  {
    return new java.io.File(paramString1, paramString2).toString();
  }

  public static void Copy(String paramString1, String paramString2, String paramString3, String paramString4)
    throws IOException
  {
    Delete(paramString3, paramString4);
    InputStream localInputStream = (InputStream)OpenInput(paramString1, paramString2).getObject();
    OutputStream localOutputStream = (OutputStream)OpenOutput(paramString3, paramString4, false).getObject();
    Copy2(localInputStream, localOutputStream);
    localInputStream.close();
    localOutputStream.close();
  }

  public static void Copy2(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[8192];
    while (true)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i <= 0)
      {
        paramInputStream.close();
        return;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }

  public static boolean Delete(String paramString1, String paramString2)
  {
    return new java.io.File(paramString1, paramString2).delete();
  }

  public static boolean Exists(String paramString1, String paramString2)
    throws IOException
  {
    if (!paramString1.equals("AssetsDir"))
      return new java.io.File(paramString1, paramString2).exists();
    return Arrays.asList(BA.applicationContext.getAssets().list("")).indexOf(paramString2.toLowerCase(BA.cul)) > -1;
  }

  public static String GetText(String paramString1, String paramString2)
    throws IOException
  {
    InputStreamWrapper localInputStreamWrapper = OpenInput(paramString1, paramString2);
    TextReaderWrapper localTextReaderWrapper = new TextReaderWrapper();
    localTextReaderWrapper.Initialize((InputStream)localInputStreamWrapper.getObject());
    return localTextReaderWrapper.ReadAll();
  }

  public static boolean IsDirectory(String paramString1, String paramString2)
  {
    return new java.io.File(paramString1, paramString2).isDirectory();
  }

  public static long LastModified(String paramString1, String paramString2)
  {
    return new java.io.File(paramString1, paramString2).lastModified();
  }

  public static anywheresoftware.b4a.objects.collections.List ListFiles(String paramString)
    throws IOException
  {
    anywheresoftware.b4a.objects.collections.List localList = new anywheresoftware.b4a.objects.collections.List();
    if (!paramString.equals("AssetsDir"))
    {
      java.io.File localFile = new java.io.File(paramString);
      if (!localFile.isDirectory())
        throw new IOException(paramString + " is not a folder.");
      String[] arrayOfString = localFile.list();
      if (arrayOfString != null)
        localList.setObject(Arrays.asList(arrayOfString));
      return localList;
    }
    localList.setObject(Arrays.asList(BA.applicationContext.getAssets().list("")));
    return localList;
  }

  public static void MakeDir(String paramString1, String paramString2)
  {
    new java.io.File(paramString1, paramString2).mkdirs();
  }

  public static InputStreamWrapper OpenInput(String paramString1, String paramString2)
    throws IOException
  {
    InputStreamWrapper localInputStreamWrapper = new InputStreamWrapper();
    if (paramString1.equals("AssetsDir"))
    {
      localInputStreamWrapper.setObject(BA.applicationContext.getAssets().open(paramString2.toLowerCase(BA.cul)));
      return localInputStreamWrapper;
    }
    if (paramString1.equals("ContentDir"))
    {
      localInputStreamWrapper.setObject(BA.applicationContext.getContentResolver().openInputStream(Uri.parse(paramString2)));
      return localInputStreamWrapper;
    }
    localInputStreamWrapper.setObject(new BufferedInputStream(new FileInputStream(new java.io.File(paramString1, paramString2)), 4096));
    return localInputStreamWrapper;
  }

  public static OutputStreamWrapper OpenOutput(String paramString1, String paramString2, boolean paramBoolean)
    throws FileNotFoundException
  {
    OutputStreamWrapper localOutputStreamWrapper = new OutputStreamWrapper();
    localOutputStreamWrapper.setObject(new BufferedOutputStream(new FileOutputStream(new java.io.File(paramString1, paramString2), paramBoolean)));
    return localOutputStreamWrapper;
  }

  public static anywheresoftware.b4a.objects.collections.List ReadList(String paramString1, String paramString2)
    throws IOException
  {
    InputStreamWrapper localInputStreamWrapper = OpenInput(paramString1, paramString2);
    TextReaderWrapper localTextReaderWrapper = new TextReaderWrapper();
    localTextReaderWrapper.Initialize((InputStream)localInputStreamWrapper.getObject());
    return localTextReaderWrapper.ReadList();
  }

  public static anywheresoftware.b4a.objects.collections.Map ReadMap(String paramString1, String paramString2)
    throws IOException
  {
    return ReadMap2(paramString1, paramString2, null);
  }

  public static anywheresoftware.b4a.objects.collections.Map ReadMap2(String paramString1, String paramString2, anywheresoftware.b4a.objects.collections.Map paramMap)
    throws IOException
  {
    InputStreamWrapper localInputStreamWrapper = OpenInput(paramString1, paramString2);
    Properties localProperties = new Properties();
    localProperties.load((InputStream)localInputStreamWrapper.getObject());
    if (paramMap == null)
      paramMap = new anywheresoftware.b4a.objects.collections.Map();
    if (!paramMap.IsInitialized())
      paramMap.Initialize();
    Iterator localIterator = localProperties.entrySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        localInputStreamWrapper.Close();
        return paramMap;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramMap.Put(localEntry.getKey(), localEntry.getValue());
    }
  }

  public static String ReadString(String paramString1, String paramString2)
    throws IOException
  {
    InputStreamWrapper localInputStreamWrapper = OpenInput(paramString1, paramString2);
    TextReaderWrapper localTextReaderWrapper = new TextReaderWrapper();
    localTextReaderWrapper.Initialize((InputStream)localInputStreamWrapper.getObject());
    String str = localTextReaderWrapper.ReadAll();
    localInputStreamWrapper.Close();
    return str;
  }

  public static long Size(String paramString1, String paramString2)
  {
    return new java.io.File(paramString1, paramString2).length();
  }

  public static void WriteList(String paramString1, String paramString2, anywheresoftware.b4a.objects.collections.List paramList)
    throws IOException
  {
    OutputStreamWrapper localOutputStreamWrapper = OpenOutput(paramString1, paramString2, false);
    TextWriterWrapper localTextWriterWrapper = new TextWriterWrapper();
    localTextWriterWrapper.Initialize((OutputStream)localOutputStreamWrapper.getObject());
    localTextWriterWrapper.WriteList(paramList);
    localTextWriterWrapper.Close();
  }

  public static void WriteMap(String paramString1, String paramString2, anywheresoftware.b4a.objects.collections.Map paramMap)
    throws IOException
  {
    OutputStreamWrapper localOutputStreamWrapper = OpenOutput(paramString1, paramString2, false);
    Properties localProperties = new Properties();
    Iterator localIterator = ((java.util.Map)paramMap.getObject()).entrySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        localProperties.store((OutputStream)localOutputStreamWrapper.getObject(), null);
        localOutputStreamWrapper.Close();
        return;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localProperties.setProperty(String.valueOf(localEntry.getKey()), String.valueOf(localEntry.getValue()));
    }
  }

  public static void WriteString(String paramString1, String paramString2, String paramString3)
    throws IOException
  {
    OutputStreamWrapper localOutputStreamWrapper = OpenOutput(paramString1, paramString2, false);
    TextWriterWrapper localTextWriterWrapper = new TextWriterWrapper();
    localTextWriterWrapper.Initialize((OutputStream)localOutputStreamWrapper.getObject());
    localTextWriterWrapper.Write(paramString3);
    localTextWriterWrapper.Close();
  }

  public static String getDirAssets()
  {
    return "AssetsDir";
  }

  public static String getDirDefaultExternal()
  {
    java.io.File localFile = new java.io.File(Environment.getExternalStorageDirectory(), "/Android/data/" + BA.packageName + "/files/");
    localFile.mkdirs();
    return localFile.toString();
  }

  public static String getDirInternal()
  {
    return BA.applicationContext.getFilesDir().toString();
  }

  public static String getDirInternalCache()
  {
    java.io.File localFile = BA.applicationContext.getCacheDir();
    if (localFile == null)
      return getDirInternal();
    return localFile.toString();
  }

  public static String getDirRootExternal()
  {
    return Environment.getExternalStorageDirectory().toString();
  }

  public static boolean getExternalReadable()
  {
    String str = Environment.getExternalStorageState();
    return ("mounted".equals(str)) || ("mounted_ro".equals(str));
  }

  public static boolean getExternalWritable()
  {
    return "mounted".equals(Environment.getExternalStorageState());
  }

  @BA.ShortName("InputStream")
  public static class InputStreamWrapper extends AbsObjectWrapper<InputStream>
  {
    public int BytesAvailable()
      throws IOException
    {
      return ((InputStream)getObject()).available();
    }

    public void Close()
      throws IOException
    {
      ((InputStream)getObject()).close();
    }

    public void InitializeFromBytesArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      setObject(new ByteArrayInputStream(paramArrayOfByte, paramInt1, paramInt2));
    }

    public int ReadBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      return ((InputStream)getObject()).read(paramArrayOfByte, paramInt1, paramInt2);
    }
  }

  @BA.ShortName("OutputStream")
  public static class OutputStreamWrapper extends AbsObjectWrapper<OutputStream>
  {
    public void Close()
      throws IOException
    {
      ((OutputStream)getObject()).close();
    }

    public void Flush()
      throws IOException
    {
      ((OutputStream)getObject()).flush();
    }

    public void InitializeToBytesArray(int paramInt)
    {
      setObject(new ByteArrayOutputStream(paramInt));
    }

    public byte[] ToBytesArray()
    {
      if (!(getObject() instanceof ByteArrayOutputStream))
        throw new RuntimeException("ToBytes can only be called after InitializeToBytesArray.");
      return ((ByteArrayOutputStream)getObject()).toByteArray();
    }

    public void WriteBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      ((OutputStream)getObject()).write(paramArrayOfByte, paramInt1, paramInt2);
    }
  }

  @BA.ShortName("TextReader")
  public static class TextReaderWrapper extends AbsObjectWrapper<BufferedReader>
  {
    public void Close()
      throws IOException
    {
      ((BufferedReader)getObject()).close();
    }

    public void Initialize(InputStream paramInputStream)
    {
      setObject(new BufferedReader(new InputStreamReader(paramInputStream, Charset.forName("UTF8")), 4096));
    }

    public void Initialize2(InputStream paramInputStream, String paramString)
    {
      setObject(new BufferedReader(new InputStreamReader(paramInputStream, Charset.forName(paramString)), 4096));
    }

    public int Read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
      throws IOException
    {
      return ((BufferedReader)getObject()).read(paramArrayOfChar, paramInt1, paramInt2);
    }

    public String ReadAll()
      throws IOException
    {
      char[] arrayOfChar = new char[1024];
      StringBuilder localStringBuilder = new StringBuilder(1024);
      while (true)
      {
        int i = Read(arrayOfChar, 0, arrayOfChar.length);
        if (i == -1)
        {
          Close();
          return localStringBuilder.toString();
        }
        if (i < arrayOfChar.length)
          localStringBuilder.append(new String(arrayOfChar, 0, i));
        else
          localStringBuilder.append(arrayOfChar);
      }
    }

    public String ReadLine()
      throws IOException
    {
      return ((BufferedReader)getObject()).readLine();
    }

    public anywheresoftware.b4a.objects.collections.List ReadList()
      throws IOException
    {
      anywheresoftware.b4a.objects.collections.List localList = new anywheresoftware.b4a.objects.collections.List();
      localList.Initialize();
      while (true)
      {
        String str = ReadLine();
        if (str == null)
        {
          Close();
          return localList;
        }
        localList.Add(str);
      }
    }

    public boolean Ready()
      throws IOException
    {
      return ((BufferedReader)getObject()).ready();
    }

    public int Skip(int paramInt)
      throws IOException
    {
      return (int)((BufferedReader)getObject()).skip(paramInt);
    }
  }

  @BA.ShortName("TextWriter")
  public static class TextWriterWrapper extends AbsObjectWrapper<BufferedWriter>
  {
    public void Close()
      throws IOException
    {
      ((BufferedWriter)getObject()).close();
    }

    public void Flush()
      throws IOException
    {
      ((BufferedWriter)getObject()).flush();
    }

    public void Initialize(OutputStream paramOutputStream)
    {
      setObject(new BufferedWriter(new OutputStreamWriter(paramOutputStream, Charset.forName("UTF8")), 4096));
    }

    public void Initialize2(OutputStream paramOutputStream, String paramString)
    {
      setObject(new BufferedWriter(new OutputStreamWriter(paramOutputStream, Charset.forName(paramString)), 4096));
    }

    public void Write(String paramString)
      throws IOException
    {
      ((BufferedWriter)getObject()).write(paramString);
    }

    public void WriteLine(String paramString)
      throws IOException
    {
      ((BufferedWriter)getObject()).write(paramString + "\n");
    }

    public void WriteList(anywheresoftware.b4a.objects.collections.List paramList)
      throws IOException
    {
      Iterator localIterator = ((java.util.List)paramList.getObject()).iterator();
      while (true)
      {
        if (!localIterator.hasNext())
          return;
        WriteLine(String.valueOf(localIterator.next()));
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.streams.File
 * JD-Core Version:    0.6.2
 */