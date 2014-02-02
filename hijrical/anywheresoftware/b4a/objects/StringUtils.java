package anywheresoftware.b4a.objects;

import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.objects.streams.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@BA.ShortName("StringUtils")
public class StringUtils
{
  public static anywheresoftware.b4a.objects.collections.List LoadCSV(String paramString1, String paramString2, char paramChar)
    throws IOException
  {
    return LoadCSV2(paramString1, paramString2, paramChar, null);
  }

  public static anywheresoftware.b4a.objects.collections.List LoadCSV2(String paramString1, String paramString2, char paramChar, anywheresoftware.b4a.objects.collections.List paramList)
    throws IOException
  {
    int i = 0;
    String str1 = File.ReadString(paramString1, paramString2);
    anywheresoftware.b4a.objects.collections.List localList = new anywheresoftware.b4a.objects.collections.List();
    localList.Initialize();
    ArrayList localArrayList = new ArrayList();
    int j = 1;
    label46: int i4;
    label50: String str2;
    label90: String str3;
    label102: int i5;
    Iterator localIterator;
    label131: int[] arrayOfInt;
    int k;
    int m;
    int n;
    if (i >= str1.length())
    {
      i4 = i;
      if (str1.charAt(str1.length() - 1) == '\n')
        break label686;
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1));
      if (j != 0)
      {
        str2 = "\n";
        str3 = str2;
        i5 = localArrayList.size();
        if (paramList == null)
          break label543;
        if (!paramList.IsInitialized())
          paramList.Initialize();
        localIterator = localArrayList.iterator();
        if (localIterator.hasNext())
          break label526;
        arrayOfInt = new int[] { i4 };
        if (arrayOfInt[0] < str3.length() - 1)
          break label592;
        return localList;
      }
    }
    else
    {
      if (str1.charAt(i) == '"')
      {
        int i8 = str1.indexOf("\"", i + 1);
        int i9 = 0;
        while (true)
        {
          if ((i8 >= str1.length()) || (i8 <= -1));
          while ((i8 == str1.length() - 1) || (str1.charAt(i8 + 1) != '"'))
          {
            String str4 = str1.substring(i + 1, i8);
            if (i9 != 0)
              str4 = str4.replace("\"\"", "\"");
            localArrayList.add(str4);
            i = i8 + 2;
            if ((str1.charAt(i8 + 1) != '\r') && (str1.charAt(i8 + 1) != '\n'))
              break;
            if (str1.charAt(i8 + 1) != '\r')
              break label46;
            i4 = i + 1;
            j = 0;
            break label50;
          }
          i9 = 1;
          i8 = str1.indexOf("\"", i8 + 2);
        }
      }
      k = str1.indexOf(paramChar, i);
      m = str1.indexOf('\n', i);
      if (m == -1)
      {
        str1 = str1 + "\n";
        m = str1.length() - 1;
      }
      if ((m < k) || (k == -1))
      {
        if (str1.charAt(m - 1) != '\r')
          break label693;
        n = m - 1;
      }
    }
    for (int i1 = 0; ; i1 = j)
    {
      localArrayList.add(str1.substring(i, n));
      if (i1 != 0);
      for (int i2 = 1; ; i2 = 2)
      {
        int i3 = i2 + n;
        j = i1;
        i4 = i3;
        break;
      }
      localArrayList.add(str1.substring(i, k));
      i = k + 1;
      break;
      str2 = "\r\n";
      break label90;
      label526: paramList.Add((String)localIterator.next());
      break label131;
      label543: String[] arrayOfString1 = new String[i5];
      for (int i6 = 0; ; i6++)
      {
        if (i6 >= arrayOfString1.length)
        {
          localList.Add(arrayOfString1);
          break;
        }
        arrayOfString1[i6] = ((String)localArrayList.get(i6));
      }
      label592: String[] arrayOfString2 = new String[i5];
      int i7 = 0;
      label602: if (i7 >= i5 - 1)
      {
        if (j != 0)
          break label669;
        arrayOfString2[i7] = ReadWord(str3, arrayOfInt, '\r');
        arrayOfInt[0] = (1 + arrayOfInt[0]);
      }
      while (true)
      {
        localList.Add(arrayOfString2);
        break;
        arrayOfString2[i7] = ReadWord(str3, arrayOfInt, paramChar);
        i7++;
        break label602;
        label669: arrayOfString2[i7] = ReadWord(str3, arrayOfInt, '\n');
      }
      label686: str3 = str1;
      break label102;
      label693: n = m;
    }
  }

  private static String ReadWord(String paramString, int[] paramArrayOfInt, char paramChar)
  {
    if (paramString.charAt(paramArrayOfInt[0]) == '"')
    {
      int j = paramString.indexOf("\"", 1 + paramArrayOfInt[0]);
      int k = 0;
      while (true)
      {
        if ((j >= paramString.length()) || (j <= -1));
        while ((j == paramString.length() - 1) || (paramString.charAt(j + 1) != '"'))
        {
          String str2 = paramString.substring(1 + paramArrayOfInt[0], j);
          if (k != 0)
            str2 = str2.replace("\"\"", "\"");
          paramArrayOfInt[0] = (j + 2);
          return str2;
        }
        k = 1;
        j = paramString.indexOf("\"", j + 2);
      }
    }
    int i = paramString.indexOf(paramChar, paramArrayOfInt[0]);
    String str1 = paramString.substring(paramArrayOfInt[0], i);
    paramArrayOfInt[0] = (i + 1);
    return str1;
  }

  public static void SaveCSV(String paramString1, String paramString2, char paramChar, anywheresoftware.b4a.objects.collections.List paramList)
    throws IOException
  {
    SaveCSV2(paramString1, paramString2, paramChar, paramList, null);
  }

  public static void SaveCSV2(String paramString1, String paramString2, char paramChar, anywheresoftware.b4a.objects.collections.List paramList1, anywheresoftware.b4a.objects.collections.List paramList2)
    throws IOException
  {
    int i = ((String[])paramList1.Get(0)).length;
    StringBuilder localStringBuilder = new StringBuilder();
    Pattern localPattern = Pattern.compile("[\"\\r\\n" + paramChar + "]");
    Iterator localIterator;
    if (paramList2 != null)
      localIterator = ((java.util.List)paramList2.getObject()).iterator();
    int j;
    while (true)
    {
      if (!localIterator.hasNext())
      {
        localStringBuilder.setCharAt(localStringBuilder.length() - 1, '\n');
        j = 0;
        if (j < paramList1.getSize())
          break;
        File.WriteString(paramString1, paramString2, localStringBuilder.toString());
        return;
      }
      localStringBuilder.append(Word((String)localIterator.next(), localPattern, paramChar));
    }
    String[] arrayOfString = (String[])paramList1.Get(j);
    for (int k = 0; ; k++)
    {
      if (k >= i)
      {
        localStringBuilder.setCharAt(localStringBuilder.length() - 1, '\n');
        j++;
        break;
      }
      localStringBuilder.append(Word(arrayOfString[k], localPattern, paramChar));
    }
  }

  private static String Word(String paramString, Pattern paramPattern, char paramChar)
  {
    if (paramPattern.matcher(paramString).find())
      paramString = "\"" + paramString + "\"";
    for (int i = paramString.indexOf('"', 1); ; i = paramString.indexOf("\"", i + 2))
    {
      if ((i <= -1) || (i >= paramString.length() - 1))
        return paramString + paramChar;
      paramString = paramString.substring(0, i) + "\"" + paramString.substring(i);
    }
  }

  public byte[] DecodeBase64(String paramString)
    throws IOException
  {
    return Base64.decode(paramString);
  }

  public String DecodeUrl(String paramString1, String paramString2)
    throws UnsupportedEncodingException
  {
    return URLDecoder.decode(paramString1, paramString2);
  }

  public String EncodeBase64(byte[] paramArrayOfByte)
  {
    return Base64.encodeBytes(paramArrayOfByte);
  }

  public String EncodeUrl(String paramString1, String paramString2)
    throws UnsupportedEncodingException
  {
    return URLEncoder.encode(paramString1, paramString2);
  }

  public int MeasureMultilineTextHeight(TextView paramTextView, String paramString)
  {
    StaticLayout localStaticLayout = new StaticLayout(paramString, paramTextView.getPaint(), paramTextView.getLayoutParams().width - paramTextView.getPaddingLeft() - paramTextView.getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
    return localStaticLayout.getLineTop(localStaticLayout.getLineCount());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.StringUtils
 * JD-Core Version:    0.6.2
 */