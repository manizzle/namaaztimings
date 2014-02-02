package com.misricalendar.hijrical;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.keywords.Common;

public class suntime
{
  public static double _v7 = 0.0D;
  private static suntime mostCurrent = new suntime();
  public Common __c = null;
  public datecon _vvvvvvvvvvvvvvv0 = null;
  public main _vvvvvvvvvvvvvvv7 = null;
  public hcalsrvc _vvvvvvvvvvvvvvvv2 = null;
  public gl _vvvvvvvvvvvvvvvv3 = null;
  public settings _vvvvvvvvvvvvvvvv4 = null;
  public qibla _vvvvvvvvvvvvvvvv5 = null;
  public qedit _vvvvvvvvvvvvvvvv6 = null;

  public static String _process_globals()
    throws Exception
  {
    _v7 = 0.0D;
    _v7 = 0.0174532925199433D;
    return "";
  }

  public static _suntimetype _v0(BA paramBA, double paramDouble1, double paramDouble2, double paramDouble3, short paramShort1, short paramShort2)
    throws Exception
  {
    _suntimetype local_suntimetype = new _suntimetype();
    local_suntimetype.Initialize();
    double d1 = paramDouble1 * -1.0D;
    double d2 = paramDouble3 * -1.0D;
    if ((d1 > 180.0D) || (d1 < -180.0D))
      return local_suntimetype;
    if ((paramDouble2 > 90.0D) || (paramDouble2 < -90.0D))
      return local_suntimetype;
    if ((d2 > 12.0D) || (d2 < -12.0D))
      return local_suntimetype;
    if (paramShort1 < 0)
      paramShort1 = 0;
    if (paramShort1 > 365)
      paramShort1 = (short)(paramShort1 - 365);
    double d3 = 2433282.5D - 2451545.0D + paramShort1;
    for (double d4 = 280.45999999999998D + 0.9856474D * d3; d4 <= 0.0D; d4 += 360.0D);
    for (double d5 = 357.52800000000002D + 0.9856003D * d3; d5 <= 0.0D; d5 += 360.0D);
    double d6 = d4 + 1.915D * Common.Sin(d5 * _v7) + 0.02D * Common.Sin(2.0D * d5 * _v7);
    double d7 = 23.439D - d3 * 4.0E-07D;
    double d8 = Common.Power(Common.Tan(d7 / 2.0D * _v7), 2.0D);
    double d9 = d6 - d8 * Common.Sin(2.0D * d6 * _v7) / _v7 + Common.Power(d8, 2.0D) * Common.Sin(4.0D * d6 * _v7) / (2.0D * _v7);
    double d10 = Common.ASin(Common.Sin(d7 * _v7) * Common.Sin(d6 * _v7)) / _v7;
    double d11 = 0.5332D / (1.00014D - 0.01671D * Common.Cos(d5 * _v7) - 0.00014D * Common.Cos(d5 * 2.0D * _v7));
    double d12 = 4.0D * (d4 - d9);
    double d13 = 4.0D * (2.0D * (90.0D + Common.ASin(Common.Tan(paramDouble2 * _v7) * Common.Tan(d10 * _v7)) / _v7)) + 4.0D * (d11 + 1.133333333333333D) / Common.Cos(Common.Abs(paramDouble2 - d10) * _v7);
    double d14 = 4.0D * (d1 - d2 * 15.0D) + (720.0D - d12);
    if (paramShort2 != 0)
      d14 += 60.0D;
    double d15 = d14 - d13 / 2.0D;
    double d16 = d14 + d13 / 2.0D;
    double d17 = d14 + (d16 - d15) / 6.0D;
    local_suntimetype.Sunrise = _vv1(paramBA, Common.Round(d15 + 0.5D));
    local_suntimetype.Noon = _vv1(paramBA, Common.Round(d14 + 0.5D));
    local_suntimetype.Sunset = _vv1(paramBA, Common.Round(0.5D + d16));
    local_suntimetype.ZuhrEnd = _vv1(paramBA, Common.Round(0.5D + d17));
    return local_suntimetype;
  }

  public static _clocktimetype _vv1(BA paramBA, double paramDouble)
    throws Exception
  {
    _clocktimetype local_clocktimetype = new _clocktimetype();
    local_clocktimetype.Initialize();
    double d = paramDouble - Common.Floor(paramDouble);
    local_clocktimetype.hour = ((byte)(int)Common.Floor(paramDouble / 60.0D));
    local_clocktimetype.minute = ((byte)(int)Common.Floor(paramDouble - 60.0D * local_clocktimetype.hour));
    local_clocktimetype.sec = ((byte)(int)Common.Floor(d * 60.0D));
    if ((gl._vvvvvvvvv4) && (local_clocktimetype.hour > 12))
      local_clocktimetype.hour = ((byte)(local_clocktimetype.hour - 12));
    return local_clocktimetype;
  }

  public static Object getObject()
  {
    throw new RuntimeException("Code module does not support this method.");
  }

  public static class _clocktimetype
  {
    public boolean IsInitialized;
    public byte hour;
    public byte minute;
    public byte sec;

    public void Initialize()
    {
      this.IsInitialized = true;
      this.hour = 0;
      this.minute = 0;
      this.sec = 0;
    }

    public String toString()
    {
      return BA.TypeToString(this, false);
    }
  }

  public static class _suntimetype
  {
    public boolean IsInitialized;
    public suntime._clocktimetype Noon;
    public suntime._clocktimetype Sunrise;
    public suntime._clocktimetype Sunset;
    public suntime._clocktimetype ZuhrEnd;

    public void Initialize()
    {
      this.IsInitialized = true;
      this.Sunrise = new suntime._clocktimetype();
      this.Noon = new suntime._clocktimetype();
      this.Sunset = new suntime._clocktimetype();
      this.ZuhrEnd = new suntime._clocktimetype();
    }

    public String toString()
    {
      return BA.TypeToString(this, false);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.misricalendar.hijrical.suntime
 * JD-Core Version:    0.6.2
 */