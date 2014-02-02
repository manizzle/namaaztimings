package com.misricalendar.hijrical;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.keywords.Common;

public class datecon
{
  private static datecon mostCurrent = new datecon();
  public Common __c = null;
  public main _vvvvvvvvvvvvvvv7 = null;
  public suntime _vvvvvvvvvvvvvvvv1 = null;
  public hcalsrvc _vvvvvvvvvvvvvvvv2 = null;
  public gl _vvvvvvvvvvvvvvvv3 = null;
  public settings _vvvvvvvvvvvvvvvv4 = null;
  public qibla _vvvvvvvvvvvvvvvv5 = null;
  public qedit _vvvvvvvvvvvvvvvv6 = null;

  public static short _check_greg_date(BA paramBA, short paramShort1, short paramShort2, short paramShort3)
    throws Exception
  {
    if ((paramShort3 < 622) || (paramShort3 > 10000))
      return 1;
    if ((paramShort2 < 1) || (paramShort2 > 12))
      return 2;
    if ((paramShort1 > 31) || (paramShort1 < 1))
      return 3;
    if (paramShort3 == 622)
    {
      if (paramShort2 < 7)
        return 5;
      if ((paramShort2 == 7) && (paramShort1 < 15))
        return 5;
    }
    if ((paramShort3 == 1582) && (paramShort2 == 10) && (paramShort1 > 4) && (paramShort1 < 15))
      return 6;
    Short localShort = Short.valueOf(paramShort2);
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = Short.valueOf(2);
    arrayOfObject[1] = Short.valueOf(4);
    arrayOfObject[2] = Short.valueOf(6);
    arrayOfObject[3] = Short.valueOf(9);
    arrayOfObject[4] = Short.valueOf(11);
    switch (BA.switchObjectToInt(localShort, arrayOfObject))
    {
    default:
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    do
    {
      return 0;
      if (_v5(paramBA, paramShort3));
      for (short s = 29; paramShort1 > s; s = 28)
        return 4;
    }
    while (paramShort1 <= 30);
    return 3;
  }

  public static short _check_hijri_date(BA paramBA, short paramShort1, short paramShort2, short paramShort3)
    throws Exception
  {
    if ((paramShort3 < 1) || (paramShort3 > 10000))
      return 11;
    if ((paramShort2 < 1) || (paramShort2 > 12))
      return 12;
    if ((paramShort1 > 30) || (paramShort1 < 1))
      return 13;
    Short localShort = Short.valueOf(paramShort2);
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = Short.valueOf(2);
    arrayOfObject[1] = Short.valueOf(4);
    arrayOfObject[2] = Short.valueOf(6);
    arrayOfObject[3] = Short.valueOf(8);
    arrayOfObject[4] = Short.valueOf(10);
    arrayOfObject[5] = Short.valueOf(12);
    switch (BA.switchObjectToInt(localShort, arrayOfObject))
    {
    default:
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      return 0;
      if (paramShort1 > 29)
      {
        return 13;
        if (_v6(paramBA, paramShort3) == BA.ObjectToBoolean(Integer.valueOf(0)));
        for (short s = 29; paramShort1 > s; s = 30)
          return 14;
      }
    }
  }

  public static short _day_of_week(BA paramBA, int paramInt)
    throws Exception
  {
    short s = (short)(4 + paramInt % 7);
    if (s > 7)
      s = (short)(s - 7);
    return s;
  }

  public static short[] _days_to_gdate(BA paramBA, int paramInt)
    throws Exception
  {
    new short[0];
    int i = (short)(_gday_of_year(paramBA, (short)31, (short)12, (short)622) - _gday_of_year(paramBA, (short)14, (short)7, (short)622));
    int j;
    short s1;
    int k;
    if (paramInt > i)
    {
      j = paramInt - i;
      s1 = 623;
      k = 365;
    }
    while (true)
    {
      int m;
      int n;
      if (j >= k)
      {
        m = j - k;
        s1 = (short)(s1 + 1);
        if (_v5(paramBA, s1));
        for (n = 366; ; n = 365)
        {
          if (s1 != 1582)
            break label247;
          j = m;
          k = 355;
          break;
          short[] arrayOfShort1 = _gday_to_date(paramBA, (short)(paramInt + _gday_of_year(paramBA, (short)14, (short)7, (short)622)), (short)622);
          return new short[] { arrayOfShort1[0], arrayOfShort1[1], 622 };
        }
      }
      short s2;
      if (j != 0)
        s2 = (short)j;
      label245: 
      while (true)
      {
        short[] arrayOfShort2 = _gday_to_date(paramBA, s2, s1);
        return new short[] { arrayOfShort2[0], arrayOfShort2[1], s1 };
        s1 = (short)(s1 - 1);
        if (_v5(paramBA, s1));
        for (s2 = 366; ; s2 = 365)
        {
          if (s1 != 1582)
            break label245;
          s2 = 355;
          break;
        }
      }
      label247: int i1 = n;
      j = m;
      k = i1;
    }
  }

  public static short[] _days_to_hdate(BA paramBA, int paramInt)
    throws Exception
  {
    new short[0];
    short s1 = 1;
    int i = 354;
    int j = paramInt;
    while (j >= i)
    {
      int k = j - i;
      s1 = (short)(s1 + 1);
      if (_v6(paramBA, s1))
      {
        j = k;
        i = 355;
      }
      else
      {
        j = k;
        i = 354;
      }
    }
    short s2;
    if (j != 0)
      s2 = (short)j;
    while (true)
    {
      short[] arrayOfShort = _hday_to_date(paramBA, s2, s1);
      return new short[] { arrayOfShort[0], arrayOfShort[1], s1 };
      s1 = (short)(s1 - 1);
      if (_v6(paramBA, s1))
        s2 = 355;
      else
        s2 = 354;
    }
  }

  public static short _gday_of_year(BA paramBA, short paramShort1, short paramShort2, short paramShort3)
    throws Exception
  {
    new short[0];
    short[] arrayOfShort = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30 };
    if (_v5(paramBA, paramShort3))
      arrayOfShort[2] = 29;
    short s1 = 1;
    short s2 = paramShort1;
    while (s1 < paramShort2)
    {
      s2 = (short)(s2 + arrayOfShort[s1]);
      s1 = (short)(s1 + 1);
    }
    if (((paramShort3 == 1582) && (paramShort2 > 10)) || ((paramShort3 == 1582) && (paramShort2 == 10) && (paramShort1 >= 15)))
      return (short)(s2 - 10);
    return s2;
  }

  public static short[] _gday_to_date(BA paramBA, short paramShort1, short paramShort2)
    throws Exception
  {
    new short[0];
    short[] arrayOfShort = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 1 };
    if (_v5(paramBA, paramShort2))
      arrayOfShort[2] = 29;
    if (paramShort2 == 1582)
      arrayOfShort[10] = 21;
    int i = 1;
    int j = paramShort1;
    while (j >= arrayOfShort[i])
    {
      j = (short)(j - arrayOfShort[i]);
      i = (short)(i + 1);
    }
    int m;
    int k;
    if (j == 0)
    {
      int n = (short)(i - 1);
      m = arrayOfShort[n];
      k = n;
    }
    while (true)
    {
      if ((paramShort2 == 1582) && (k == 10) && (m > 4))
        m = (short)(m + 10);
      return new short[] { m, k };
      k = i;
      m = j;
    }
  }

  public static int _gdays_in_month(BA paramBA, int paramInt1, int paramInt2)
    throws Exception
  {
    if (paramInt1 == 2)
    {
      if (_v5(paramBA, (short)paramInt2))
        return 29;
      return 28;
    }
    switch (paramInt1)
    {
    case 5:
    case 7:
    case 8:
    case 10:
    default:
      return 31;
    case 4:
    case 6:
    case 9:
    case 11:
    }
    return 30;
  }

  public static int _gnum_days(BA paramBA, short paramShort1, short paramShort2, short paramShort3)
    throws Exception
  {
    int i;
    if (paramShort3 > 622)
      i = _gday_of_year(paramBA, (short)31, (short)12, (short)622) - _gday_of_year(paramBA, (short)14, (short)7, (short)622);
    do
    {
      int j = i + (365 * (paramShort3 - 623) + _num_leapyr(paramBA, paramShort3) + _gday_of_year(paramBA, paramShort1, paramShort2, paramShort3));
      if (paramShort3 > 1582)
        j -= 10;
      return j;
      i = 0;
    }
    while (paramShort3 != 622);
    return _gday_of_year(paramBA, paramShort1, paramShort2, paramShort3) - _gday_of_year(paramBA, (short)14, (short)7, (short)622);
  }

  public static short _hday_of_year(BA paramBA, short paramShort1, short paramShort2)
    throws Exception
  {
    new short[0];
    short[] arrayOfShort = { 0, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30 };
    short s1 = 1;
    short s2 = paramShort1;
    while (s1 < paramShort2)
    {
      s2 = (short)(s2 + arrayOfShort[s1]);
      s1 = (short)(s1 + 1);
    }
    return s2;
  }

  public static short[] _hday_to_date(BA paramBA, short paramShort1, short paramShort2)
    throws Exception
  {
    new short[0];
    short[] arrayOfShort = { 0, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 1 };
    if (_v6(paramBA, paramShort2))
      arrayOfShort[12] = 30;
    int i = 1;
    int j = paramShort1;
    while (j >= arrayOfShort[i])
    {
      j = (short)(j - arrayOfShort[i]);
      i = (short)(i + 1);
    }
    int m;
    int k;
    if (j == 0)
    {
      int n = (short)(i - 1);
      m = arrayOfShort[n];
      k = n;
    }
    while (true)
    {
      return new short[] { m, k };
      k = i;
      m = j;
    }
  }

  public static int _hdays_in_month(BA paramBA, int paramInt1, int paramInt2)
    throws Exception
  {
    int i = 29;
    if (paramInt1 == 12)
      if (_v6(paramBA, (short)paramInt2))
        i = 30;
    while (true)
    {
      return i;
      for (int j = 1; j <= 11; j = 2 + (j + 0))
        if (paramInt1 == j)
          return 30;
    }
  }

  public static int _hnum_days(BA paramBA, short paramShort1, short paramShort2, short paramShort3)
    throws Exception
  {
    new short[0];
    short[] arrayOfShort = { 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 11 };
    int i = (short)(int)(paramShort3 - 1 - 30.0D * Common.Floor((paramShort3 - 1) / 30.0D));
    return (short)(int)(11.0D * Common.Floor((paramShort3 - 1) / 30.0D) + arrayOfShort[i]) + 354 * (paramShort3 - 1) + _hday_of_year(paramBA, paramShort1, paramShort2);
  }

  public static short _num_leapyr(BA paramBA, short paramShort)
    throws Exception
  {
    short s1 = (short)(int)(Common.Floor((paramShort - 1) / 4.0D) - Common.Floor(155.75D));
    if (s1 < 0)
      s1 = 0;
    int i = (short)(int)Common.Floor((paramShort - 1) / 100.0D);
    short s2 = s1;
    for (int j = i; j > 15; j = (short)(j - 1))
      if (j % 4 > 0)
        s2 = (short)(s2 - 1);
    return s2;
  }

  public static String _process_globals()
    throws Exception
  {
    return "";
  }

  public static boolean _v5(BA paramBA, short paramShort)
    throws Exception
  {
    if (paramShort % 4 == 0)
      return (paramShort % 100 != 0) || (paramShort % 400 <= 0) || (paramShort <= 1500);
    return false;
  }

  public static boolean _v6(BA paramBA, short paramShort)
    throws Exception
  {
    Short localShort = Short.valueOf((short)(int)(paramShort - 30.0D * Common.Floor(paramShort / 30.0D)));
    Object[] arrayOfObject = new Object[11];
    arrayOfObject[0] = Short.valueOf(2);
    arrayOfObject[1] = Short.valueOf(5);
    arrayOfObject[2] = Short.valueOf(8);
    arrayOfObject[3] = Short.valueOf(10);
    arrayOfObject[4] = Short.valueOf(13);
    arrayOfObject[5] = Short.valueOf(16);
    arrayOfObject[6] = Short.valueOf(19);
    arrayOfObject[7] = Short.valueOf(21);
    arrayOfObject[8] = Short.valueOf(24);
    arrayOfObject[9] = Short.valueOf(27);
    arrayOfObject[10] = Short.valueOf(29);
    switch (BA.switchObjectToInt(localShort, arrayOfObject))
    {
    default:
      return false;
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 10:
    }
    return true;
  }

  public static Object getObject()
  {
    throw new RuntimeException("Code module does not support this method.");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.misricalendar.hijrical.datecon
 * JD-Core Version:    0.6.2
 */