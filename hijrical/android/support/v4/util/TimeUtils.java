package android.support.v4.util;

import java.io.PrintWriter;

public class TimeUtils
{
  public static final int HUNDRED_DAY_FIELD_LEN = 19;
  private static final int SECONDS_PER_DAY = 86400;
  private static final int SECONDS_PER_HOUR = 3600;
  private static final int SECONDS_PER_MINUTE = 60;
  private static char[] sFormatStr = new char[24];
  private static final Object sFormatSync = new Object();

  private static int accumField(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if ((paramInt1 > 99) || ((paramBoolean) && (paramInt3 >= 3)))
      return paramInt2 + 3;
    if ((paramInt1 > 9) || ((paramBoolean) && (paramInt3 >= 2)))
      return paramInt2 + 2;
    if ((paramBoolean) || (paramInt1 > 0))
      return paramInt2 + 1;
    return 0;
  }

  public static void formatDuration(long paramLong1, long paramLong2, PrintWriter paramPrintWriter)
  {
    if (paramLong1 == 0L)
    {
      paramPrintWriter.print("--");
      return;
    }
    formatDuration(paramLong1 - paramLong2, paramPrintWriter, 0);
  }

  public static void formatDuration(long paramLong, PrintWriter paramPrintWriter)
  {
    formatDuration(paramLong, paramPrintWriter, 0);
  }

  public static void formatDuration(long paramLong, PrintWriter paramPrintWriter, int paramInt)
  {
    synchronized (sFormatSync)
    {
      int i = formatDurationLocked(paramLong, paramInt);
      paramPrintWriter.print(new String(sFormatStr, 0, i));
      return;
    }
  }

  public static void formatDuration(long paramLong, StringBuilder paramStringBuilder)
  {
    synchronized (sFormatSync)
    {
      int i = formatDurationLocked(paramLong, 0);
      paramStringBuilder.append(sFormatStr, 0, i);
      return;
    }
  }

  private static int formatDurationLocked(long paramLong, int paramInt)
  {
    if (sFormatStr.length < paramInt)
      sFormatStr = new char[paramInt];
    char[] arrayOfChar = sFormatStr;
    if (paramLong == 0L)
    {
      int i21 = paramInt - 1;
      while (i21 < 0)
        arrayOfChar[0] = ' ';
      arrayOfChar[0] = '0';
      return 0 + 1;
    }
    int i;
    int j;
    int k;
    int m;
    int n;
    int i2;
    int i1;
    if (paramLong > 0L)
    {
      i = 43;
      j = (int)(paramLong % 1000L);
      k = (int)Math.floor(paramLong / 1000L);
      m = 0;
      if (k > 86400)
      {
        m = k / 86400;
        k -= 86400 * m;
      }
      n = 0;
      if (k > 3600)
      {
        n = k / 3600;
        k -= 3600 * n;
      }
      if (k <= 60)
        break label548;
      i2 = k / 60;
      i1 = k - i2 * 60;
    }
    while (true)
    {
      int i3 = 0;
      if (paramInt != 0)
      {
        int i15 = accumField(m, 1, false, 0);
        boolean bool4;
        label187: boolean bool5;
        label209: boolean bool6;
        label231: int i18;
        if (i15 > 0)
        {
          bool4 = true;
          int i16 = i15 + accumField(n, 1, bool4, 2);
          if (i16 <= 0)
            break label306;
          bool5 = true;
          int i17 = i16 + accumField(i2, 1, bool5, 2);
          if (i17 <= 0)
            break label312;
          bool6 = true;
          i18 = i17 + accumField(i1, 1, bool6, 2);
          if (i18 <= 0)
            break label318;
        }
        label306: label312: label318: for (int i19 = 3; ; i19 = 0)
        {
          for (int i20 = i18 + (1 + accumField(j, 2, true, i19)); i20 < paramInt; i20++)
          {
            arrayOfChar[i3] = ' ';
            i3++;
          }
          paramLong = -paramLong;
          i = 45;
          break;
          bool4 = false;
          break label187;
          bool5 = false;
          break label209;
          bool6 = false;
          break label231;
        }
      }
      arrayOfChar[i3] = i;
      int i4 = i3 + 1;
      int i5;
      boolean bool1;
      label367: int i7;
      label375: boolean bool2;
      label401: int i9;
      label409: boolean bool3;
      label435: int i11;
      label443: int i12;
      if (paramInt != 0)
      {
        i5 = 1;
        int i6 = printField(arrayOfChar, m, 'd', i4, false, 0);
        if (i6 == i4)
          break label506;
        bool1 = true;
        if (i5 == 0)
          break label512;
        i7 = 2;
        int i8 = printField(arrayOfChar, n, 'h', i6, bool1, i7);
        if (i8 == i4)
          break label518;
        bool2 = true;
        if (i5 == 0)
          break label524;
        i9 = 2;
        int i10 = printField(arrayOfChar, i2, 'm', i8, bool2, i9);
        if (i10 == i4)
          break label530;
        bool3 = true;
        if (i5 == 0)
          break label536;
        i11 = 2;
        i12 = printField(arrayOfChar, i1, 's', i10, bool3, i11);
        if ((i5 == 0) || (i12 == i4))
          break label542;
      }
      label512: label518: label524: label530: label536: label542: for (int i13 = 3; ; i13 = 0)
      {
        int i14 = printField(arrayOfChar, j, 'm', i12, true, i13);
        arrayOfChar[i14] = 's';
        return i14 + 1;
        i5 = 0;
        break;
        label506: bool1 = false;
        break label367;
        i7 = 0;
        break label375;
        bool2 = false;
        break label401;
        i9 = 0;
        break label409;
        bool3 = false;
        break label435;
        i11 = 0;
        break label443;
      }
      label548: i1 = k;
      i2 = 0;
    }
  }

  private static int printField(char[] paramArrayOfChar, int paramInt1, char paramChar, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if ((paramBoolean) || (paramInt1 > 0))
    {
      int i = paramInt2;
      if (((paramBoolean) && (paramInt3 >= 3)) || (paramInt1 > 99))
      {
        int m = paramInt1 / 100;
        paramArrayOfChar[paramInt2] = ((char)(m + 48));
        paramInt2++;
        paramInt1 -= m * 100;
      }
      if (((paramBoolean) && (paramInt3 >= 2)) || (paramInt1 > 9) || (i != paramInt2))
      {
        int j = paramInt1 / 10;
        paramArrayOfChar[paramInt2] = ((char)(j + 48));
        paramInt2++;
        paramInt1 -= j * 10;
      }
      paramArrayOfChar[paramInt2] = ((char)(paramInt1 + 48));
      int k = paramInt2 + 1;
      paramArrayOfChar[k] = paramChar;
      paramInt2 = k + 1;
    }
    return paramInt2;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     android.support.v4.util.TimeUtils
 * JD-Core Version:    0.6.2
 */