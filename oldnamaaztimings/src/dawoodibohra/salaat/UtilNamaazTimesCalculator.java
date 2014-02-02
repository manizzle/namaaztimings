package dawoodibohra.salaat;

import android.text.format.Time;

public class UtilNamaazTimesCalculator
{
  private double day = 1.0D;
  private final double fajrZenith = 99.599999999999994D;
  private double lat = 0.0D;
  private double lng = 0.0D;
  private double month = 1.0D;
  private double pi = 3.14159265D;
  private final double riseZenith = 90.825000000000003D;
  private final double setZenith = 90.950000000000003D;
  private final double sihoriZenith = 101.5D;
  private Time time = new Time();
  private double tz = 0.0D;
  private double year = 2010.0D;

  private double[] calculateNamaazTimes(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    double d1 = (paramDouble1 + paramDouble2) / 2.0D;
    double d2 = (paramDouble2 - paramDouble1) / 12.0D;
    double d3 = 2.0D - d2;
    double d4 = d1 + 2.0D * d2;
    double d5 = d1 + 4.0D * d2;
    double d6 = (12.0D + d1) % 24.0D;
    double d7 = d6 + d3;
    if (paramDouble1 - paramDouble4 < 1.25D)
      paramDouble4 = paramDouble1 - 1.25D;
    return new double[] { paramDouble4, paramDouble3, paramDouble1, d1, d4, d5, paramDouble2, d6, d7 };
  }

  private double calculateRiseSet(Boolean paramBoolean, double paramDouble)
  {
    double d1 = Math.floor(275.0D * this.month / 9.0D) - Math.floor((9.0D + this.month) / 12.0D) * (1.0D + Math.floor((2.0D + (this.year - 4.0D * Math.floor(this.year / 4.0D))) / 3.0D)) + this.day - 30.0D;
    double d2 = this.lng / 15.0D;
    double d3;
    double d7;
    double d10;
    if (paramBoolean.booleanValue())
    {
      d3 = d1 + (18.0D - d2) / 24.0D;
      double d4 = 0.9856D * d3 - 3.289D;
      double d5 = (282.63400000000001D + (d4 + 1.916D * Math.sin(d4 * this.pi / 180.0D) + 0.02D * Math.sin(2.0D * d4 * this.pi / 180.0D))) % 360.0D;
      double d6 = 180.0D * Math.atan(0.91764D * Math.tan(d5 * this.pi / 180.0D)) / this.pi;
      d7 = (d6 + (90.0D * Math.floor(d5 / 90.0D) - 90.0D * Math.floor(d6 / 90.0D))) / 15.0D;
      double d8 = 0.39782D * Math.sin(d5 * this.pi / 180.0D);
      double d9 = Math.cos(Math.asin(d8));
      d10 = (Math.cos(paramDouble * this.pi / 180.0D) - d8 * Math.sin(this.lat * this.pi / 180.0D)) / (d9 * Math.cos(this.lat * this.pi / 180.0D));
      if (!paramBoolean.booleanValue())
        break label405;
    }
    label405: for (double d11 = 180.0D * Math.acos(d10) / this.pi; ; d11 = 360.0D - 180.0D * Math.acos(d10) / this.pi)
    {
      return (24.0D + (d7 + d11 / 15.0D - 0.06571000000000001D * d3 - 6.622D - d2 + this.tz)) % 24.0D;
      d3 = d1 + (6.0D - d2) / 24.0D;
      break;
    }
  }

  private void setDate()
  {
    this.year = this.time.year;
    this.month = (1 + this.time.month);
    this.day = this.time.monthDay;
  }

  public double[] getNamaazTimes()
  {
    return calculateNamaazTimes(calculateRiseSet(Boolean.valueOf(false), 90.825000000000003D), calculateRiseSet(Boolean.valueOf(true), 90.950000000000003D), calculateRiseSet(Boolean.valueOf(false), 99.599999999999994D), calculateRiseSet(Boolean.valueOf(false), 101.5D));
  }

  public double[] getState()
  {
    double d = this.time.hour + this.time.minute / 60.0D + this.time.second / 3600.0D;
    double[] arrayOfDouble1 = getNamaazTimes();
    double[] arrayOfDouble2 = { 0.0D, 0.0D, 0.0D, 0.0D };
    if (((arrayOfDouble1[7] < 12.0D) && (d > arrayOfDouble1[7]) && (d < 0.1667D + arrayOfDouble1[6])) || ((arrayOfDouble1[7] > 12.0D) && ((d < 0.1667D + arrayOfDouble1[6]) || (d > arrayOfDouble1[7]))))
      if (d < arrayOfDouble1[1])
      {
        arrayOfDouble2[0] = 0.0D;
        arrayOfDouble2[1] = (d - arrayOfDouble1[0]);
        arrayOfDouble2[2] = (arrayOfDouble1[1] - d);
      }
    do
    {
      do
      {
        return arrayOfDouble2;
        if (d < arrayOfDouble1[2])
        {
          arrayOfDouble2[0] = 1.0D;
          arrayOfDouble2[1] = (d - arrayOfDouble1[1]);
          arrayOfDouble1[2] -= d;
          return arrayOfDouble2;
        }
        if (d < arrayOfDouble1[3])
        {
          arrayOfDouble2[0] = 2.0D;
          arrayOfDouble2[1] = (d - arrayOfDouble1[2]);
          arrayOfDouble2[2] = (arrayOfDouble1[3] - d);
          return arrayOfDouble2;
        }
        if (d < arrayOfDouble1[4])
        {
          arrayOfDouble2[0] = 3.0D;
          arrayOfDouble2[1] = (d - arrayOfDouble1[3]);
          arrayOfDouble2[2] = (arrayOfDouble1[4] - d);
          return arrayOfDouble2;
        }
        if (d < arrayOfDouble1[5])
        {
          arrayOfDouble2[0] = 4.0D;
          arrayOfDouble2[1] = (d - arrayOfDouble1[4]);
          arrayOfDouble2[2] = (arrayOfDouble1[5] - d);
          arrayOfDouble2[3] = (arrayOfDouble1[6] - d);
          return arrayOfDouble2;
        }
        if (d < arrayOfDouble1[6])
        {
          arrayOfDouble2[0] = 5.0D;
          arrayOfDouble2[1] = (d - arrayOfDouble1[5]);
          arrayOfDouble2[2] = (arrayOfDouble1[6] - d);
          return arrayOfDouble2;
        }
        if (d >= 0.1667D + arrayOfDouble1[6])
          break;
        arrayOfDouble2[0] = 6.0D;
        arrayOfDouble2[1] = (d - arrayOfDouble1[6]);
        arrayOfDouble2[2] = (0.1667D + arrayOfDouble1[6] - d);
        arrayOfDouble2[3] = (arrayOfDouble1[7] - d);
      }
      while (arrayOfDouble2[3] >= 0.0D);
      arrayOfDouble2[3] = (24.0D + arrayOfDouble2[3]);
      return arrayOfDouble2;
      arrayOfDouble2[0] = 0.0D;
      this.time.set(86400000L + this.time.toMillis(false));
      setDate();
      double[] arrayOfDouble3 = getNamaazTimes();
      arrayOfDouble2[1] = (24.0D - d + arrayOfDouble3[1]);
      this.time.set(this.time.toMillis(false) - 86400000L);
      setDate();
      return arrayOfDouble2;
      if ((arrayOfDouble1[7] > 12.0D) && (d < arrayOfDouble1[7]))
      {
        arrayOfDouble2[0] = 7.0D;
        arrayOfDouble2[1] = (d - (0.25D + arrayOfDouble1[6]));
        arrayOfDouble2[2] = (arrayOfDouble1[7] - d);
        return arrayOfDouble2;
      }
      if ((arrayOfDouble1[7] < 12.0D) && (d > 0.25D + arrayOfDouble1[6]))
      {
        arrayOfDouble2[0] = 7.0D;
        arrayOfDouble2[1] = (d - (0.25D + arrayOfDouble1[6]));
        arrayOfDouble2[2] = (24.0D + arrayOfDouble1[7] - d);
        return arrayOfDouble2;
      }
    }
    while ((arrayOfDouble1[7] >= 12.0D) || (d >= arrayOfDouble1[7]));
    arrayOfDouble2[0] = 7.0D;
    arrayOfDouble2[1] = (d + (24.0D - (0.25D + arrayOfDouble1[6])));
    arrayOfDouble2[2] = (arrayOfDouble1[7] - d);
    return arrayOfDouble2;
  }

  public void setLocation(double paramDouble1, double paramDouble2)
  {
    this.lat = paramDouble1;
    this.lng = paramDouble2;
  }

  public void setTime(Time paramTime)
  {
    this.time.set(paramTime);
    setDate();
  }

  public void setTimezone(double paramDouble)
  {
    this.tz = paramDouble;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     dawoodibohra.salaat.UtilNamaazTimesCalculator
 * JD-Core Version:    0.6.2
 */