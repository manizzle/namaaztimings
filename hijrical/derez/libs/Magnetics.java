package derez.libs;

import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import anywheresoftware.b4a.keywords.DateTime;
import anywheresoftware.b4a.objects.streams.File;
import anywheresoftware.b4a.objects.streams.File.TextReaderWrapper;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;

@BA.Author("Derez")
@BA.ShortName("Magnetics")
@BA.Version(1.0F)
public class Magnetics
{
  private double A;
  private double A2;
  private double A4;
  private double B;
  private double B2;
  private double B4;
  private double[][] C;
  private double C2;
  private double C4;
  private double[][] CD;
  private double[] CP;
  private double DGNM;
  private double DHNM;
  private double[][] DP;
  private double DTR;
  private double EPOCH;
  private double FLNMJ;
  private double[] FM;
  private double[] FN;
  private double GNM;
  private double HNM;
  private double[][] K;
  private int MAXORD;
  private double OALT;
  private double OLAT;
  private double OTIME;
  private double[][] P;
  private double[] PP;
  private double RE;
  private double[][] SNORM;
  private double[] SP;
  private double TIME;

  public Magnetics()
  {
    int[] arrayOfInt1 = { 13, 13 };
    this.C = ((double[][])Array.newInstance(Double.TYPE, arrayOfInt1));
    int[] arrayOfInt2 = { 13, 13 };
    this.CD = ((double[][])Array.newInstance(Double.TYPE, arrayOfInt2));
    int[] arrayOfInt3 = { 13, 13 };
    this.P = ((double[][])Array.newInstance(Double.TYPE, arrayOfInt3));
    int[] arrayOfInt4 = { 13, 13 };
    this.DP = ((double[][])Array.newInstance(Double.TYPE, arrayOfInt4));
    int[] arrayOfInt5 = { 13, 13 };
    this.SNORM = ((double[][])Array.newInstance(Double.TYPE, arrayOfInt5));
    this.SP = new double[13];
    this.CP = new double[13];
    this.FN = new double[13];
    this.FM = new double[13];
    this.PP = new double[13];
    int[] arrayOfInt6 = { 13, 13 };
    this.K = ((double[][])Array.newInstance(Double.TYPE, arrayOfInt6));
  }

  private double Sqrt(double paramDouble)
  {
    return Math.pow(paramDouble, 0.5D);
  }

  public void Initialize()
    throws IOException
  {
    new String[13];
    FileInputStream localFileInputStream = new FileInputStream(File.Combine(File.getDirRootExternal() + "/Magnetics", "WMMC.COF"));
    File.TextReaderWrapper localTextReaderWrapper = new File.TextReaderWrapper();
    localTextReaderWrapper.Initialize(localFileInputStream);
    this.EPOCH = Double.valueOf(localTextReaderWrapper.ReadLine().replace(" ", "").split(",")[0]).doubleValue();
    this.MAXORD = 12;
    this.DTR = 0.0174532925199433D;
    this.SP[0] = 0.0D;
    this.CP[0] = 1.0D;
    this.P[0][0] = 1.0D;
    this.PP[0] = 1.0D;
    this.DP[0][0] = 0.0D;
    this.A = 6378.1369999999997D;
    this.B = 6356.7523142D;
    this.RE = 6371.1999999999998D;
    this.A2 = (this.A * this.A);
    this.B2 = (this.B * this.B);
    this.C2 = (this.A2 - this.B2);
    this.A4 = (this.A2 * this.A2);
    this.B4 = (this.B2 * this.B2);
    this.C4 = (this.A4 - this.B4);
    this.C[0][0] = 0.0D;
    this.CD[0][0] = 0.0D;
    String[] arrayOfString = localTextReaderWrapper.ReadLine().replace(" ", "").split(",");
    int m;
    for (int i = Integer.valueOf(arrayOfString[0]).intValue(); ; i = Integer.valueOf(arrayOfString[0]).intValue())
    {
      if (i >= 13)
      {
        this.SNORM[0][0] = 1.0D;
        m = 1;
        if (m <= this.MAXORD)
          break;
        this.K[1][1] = 0.0D;
        this.OTIME = -1000.0D;
        this.OALT = -1000.0D;
        this.OLAT = -1000.0D;
        this.TIME = (DateTime.GetDayOfYear(DateTime.getNow()) / 365.0D + DateTime.GetYear(DateTime.getNow()));
        return;
      }
      int j = i;
      int k = Integer.valueOf(arrayOfString[1]).intValue();
      this.GNM = Double.valueOf(arrayOfString[2]).doubleValue();
      this.HNM = Double.valueOf(arrayOfString[3]).doubleValue();
      this.DGNM = Double.valueOf(arrayOfString[4]).doubleValue();
      this.DHNM = Double.valueOf(arrayOfString[5]).doubleValue();
      if (k <= j)
      {
        this.C[j][k] = this.GNM;
        this.CD[j][k] = this.DGNM;
        if (k != 0)
        {
          this.C[(k - 1)][j] = this.HNM;
          this.CD[(k - 1)][j] = this.DHNM;
        }
      }
      arrayOfString = localTextReaderWrapper.ReadLine().replace(" ", "").split(",");
    }
    this.SNORM[m][0] = (this.SNORM[(m - 1)][0] * (m * 2 - 1) / m);
    int n = 2;
    for (int i1 = 0; ; i1++)
    {
      if (i1 > m)
      {
        this.FN[m] = (m + 1);
        this.FM[m] = m;
        m++;
        break;
      }
      this.K[m][i1] = (((m - 1) * (m - 1) - i1 * i1) / ((m * 2 - 1) * (m * 2 - 3)));
      if (i1 > 0)
      {
        this.FLNMJ = (n * (1 + (m - i1)) / (m + i1));
        this.SNORM[m][i1] = (this.SNORM[m][(i1 - 1)] * Sqrt(this.FLNMJ));
        n = 1;
        this.C[(i1 - 1)][m] = (this.SNORM[m][i1] * this.C[(i1 - 1)][m]);
        this.CD[(i1 - 1)][m] = (this.SNORM[m][i1] * this.CD[(i1 - 1)][m]);
      }
      this.C[m][i1] = (this.SNORM[m][i1] * this.C[m][i1]);
      this.CD[m][i1] = (this.SNORM[m][i1] * this.CD[m][i1]);
    }
  }

  public String[] MagneticData(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    int[] arrayOfInt = { 13, 13 };
    double[][] arrayOfDouble = (double[][])Array.newInstance(Double.TYPE, arrayOfInt);
    String[] arrayOfString = new String[3];
    double d1 = this.TIME - this.EPOCH;
    double d2 = paramDouble2 * this.DTR;
    double d3 = paramDouble1 * this.DTR;
    double d4 = Math.sin(d2);
    double d5 = Math.sin(d3);
    double d6 = Math.cos(d2);
    double d7 = Math.cos(d3);
    double d8 = d5 * d5;
    double d9 = d7 * d7;
    this.SP[1] = d4;
    this.CP[1] = d6;
    double d10 = Sqrt(this.A2 - d8 * this.C2);
    double d11 = paramDouble3 * d10;
    double d12 = d5 / Sqrt(d8 + d9 * ((d11 + this.A2) / (d11 + this.B2) * ((d11 + this.A2) / (d11 + this.B2))));
    double d13 = Sqrt(1.0D - d12 * d12);
    double d14 = Sqrt(paramDouble3 * paramDouble3 + 2.0D * d11 + (this.A4 - d8 * this.C4) / (d10 * d10));
    double d15 = Sqrt(d9 * this.A2 + d8 * this.B2);
    double d16 = (paramDouble3 + d15) / d14;
    double d17 = d5 * (d7 * this.C2) / (d14 * d15);
    int i = 2;
    int j = this.MAXORD;
    double d18;
    double d19;
    double d20;
    double d21;
    double d22;
    double d23;
    int k;
    label336: double d27;
    label360: double d32;
    double d33;
    double d34;
    int i11;
    label461: int i12;
    label470: int i13;
    label493: int i14;
    label502: int i15;
    label528: int i16;
    label537: int i17;
    if (i > j)
    {
      d18 = this.RE / d14;
      d19 = d18 * d18;
      d20 = 0.0D;
      d21 = 0.0D;
      d22 = 0.0D;
      d23 = 0.0D;
      k = 1;
      int m = this.MAXORD;
      if (k <= m)
        break label755;
      if (d13 != 0.0D)
        break label1629;
      d27 = d23;
      double d28 = d16 * -d21 - d20 * d17;
      double d29 = d27;
      double d30 = d21 * d17 - d20 * d16;
      double d31 = Sqrt(d28 * d28 + d29 * d29);
      d32 = Math.atan2(d29, d28) / this.DTR;
      d33 = Math.atan2(d30, d31) / this.DTR;
      d34 = -999.0D;
      if (Math.abs(paramDouble1) > 55.0D)
      {
        if (paramDouble1 <= 0.0D)
          break label1639;
        i11 = 1;
        if (paramDouble2 <= 0.0D)
          break label1645;
        i12 = 1;
        if ((i11 & i12) != 0)
          d34 = d32 - paramDouble2;
        if (paramDouble1 <= 0.0D)
          break label1651;
        i13 = 1;
        if (paramDouble2 >= 0.0D)
          break label1657;
        i14 = 1;
        if ((i13 & i14) != 0)
          d34 = d32 + Math.abs(paramDouble2);
        if (paramDouble1 >= 0.0D)
          break label1663;
        i15 = 1;
        if (paramDouble2 <= 0.0D)
          break label1669;
        i16 = 1;
        if ((i15 & i16) != 0)
          d34 = d32 + paramDouble2;
        if (paramDouble1 >= 0.0D)
          break label1675;
        i17 = 1;
        label560: if (paramDouble2 >= 0.0D)
          break label1681;
      }
    }
    label1033: label1289: label1675: label1681: for (int i18 = 1; ; i18 = 0)
    {
      if ((i17 & i18) != 0)
        d34 = d32 - Math.abs(paramDouble2);
      if (d34 > 180.0D)
        d34 -= 360.0D;
      if (d34 < -180.0D)
        d34 += 360.0D;
      this.OTIME = this.TIME;
      this.OALT = paramDouble3;
      this.OLAT = paramDouble1;
      arrayOfString[0] = String.valueOf(d32);
      arrayOfString[1] = String.valueOf(d33);
      arrayOfString[2] = String.valueOf(d34);
      return arrayOfString;
      this.SP[i] = (this.SP[1] * this.CP[(i - 1)] + this.CP[1] * this.SP[(i - 1)]);
      this.CP[i] = (this.CP[1] * this.CP[(i - 1)] - this.SP[1] * this.SP[(i - 1)]);
      i++;
      break;
      label755: d19 *= d18;
      int n = 0;
      if (n > k)
      {
        k++;
        break label336;
      }
      int i1;
      label791: int i2;
      label803: label890: double d25;
      double d26;
      int i3;
      label1100: int i4;
      if (paramDouble3 != this.OALT)
      {
        i1 = 1;
        if (paramDouble1 == this.OLAT)
          break label1177;
        i2 = 1;
        if ((i1 | i2) != 0)
        {
          if (k != n)
            break label1183;
          this.P[k][n] = (d13 * this.P[(k - 1)][(n - 1)]);
          this.DP[k][n] = (d13 * this.DP[(k - 1)][(n - 1)] + d12 * this.P[(k - 1)][(n - 1)]);
        }
        if (this.TIME != this.OTIME)
        {
          arrayOfDouble[k][n] = (this.C[k][n] + d1 * this.CD[k][n]);
          if (n != 0)
            arrayOfDouble[(n - 1)][k] = (this.C[(n - 1)][k] + d1 * this.CD[(n - 1)][k]);
        }
        double d24 = d19 * this.P[k][n];
        if (n != 0)
          break label1497;
        d25 = arrayOfDouble[k][n] * this.CP[n];
        d26 = arrayOfDouble[k][n] * this.SP[n];
        d21 -= d19 * d25 * this.DP[k][n];
        d22 += d24 * (d26 * this.FM[n]);
        d20 += d24 * (d25 * this.FN[k]);
        if (d13 != 0.0D)
          break label1574;
        i3 = 1;
        if (n != 1)
          break label1580;
        i4 = 1;
        label1109: if ((i3 & i4) != 0)
        {
          if (k != 1)
            break label1586;
          this.PP[k] = this.PP[(k - 1)];
        }
      }
      while (true)
      {
        d23 += d19 * this.PP[k] * (d26 * this.FM[n]);
        n++;
        break;
        i1 = 0;
        break label791;
        label1177: i2 = 0;
        break label803;
        label1183: int i5;
        if (k == 1)
        {
          i5 = 1;
          label1192: if (n != 0)
            break label1283;
        }
        for (int i6 = 1; ; i6 = 0)
        {
          if ((i5 & i6) == 0)
            break label1289;
          this.P[k][n] = (d12 * this.P[(k - 1)][n]);
          this.DP[k][n] = (d12 * this.DP[(k - 1)][n] - d13 * this.P[(k - 1)][n]);
          break;
          i5 = 0;
          break label1192;
        }
        int i7;
        if (k > 1)
        {
          i7 = 1;
          label1298: if (k == n)
            break label1491;
        }
        label1491: for (int i8 = 1; ; i8 = 0)
        {
          if ((i7 & i8) == 0)
            break label1495;
          int i9 = k - 2;
          if (n > i9)
            this.P[(k - 2)][n] = 0.0D;
          int i10 = k - 2;
          if (n > i10)
            this.DP[(k - 2)][n] = 0.0D;
          this.P[k][n] = (d12 * this.P[(k - 1)][n] - this.K[k][n] * this.P[(k - 2)][n]);
          this.DP[k][n] = (d12 * this.DP[(k - 1)][n] - d13 * this.P[(k - 1)][n] - this.K[k][n] * this.DP[(k - 2)][n]);
          break;
          i7 = 0;
          break label1298;
        }
        label1495: break label890;
        label1497: d25 = arrayOfDouble[k][n] * this.CP[n] + arrayOfDouble[(n - 1)][k] * this.SP[n];
        d26 = arrayOfDouble[k][n] * this.SP[n] - arrayOfDouble[(n - 1)][k] * this.CP[n];
        break label1033;
        label1574: i3 = 0;
        break label1100;
        label1580: i4 = 0;
        break label1109;
        label1586: this.PP[k] = (d12 * this.PP[(k - 1)] - this.K[k][n] * this.PP[(k - 2)]);
      }
      label1629: d27 = d22 / d13;
      break label360;
      label1639: i11 = 0;
      break label461;
      label1645: i12 = 0;
      break label470;
      label1651: i13 = 0;
      break label493;
      label1657: i14 = 0;
      break label502;
      label1663: i15 = 0;
      break label528;
      i16 = 0;
      break label537;
      i17 = 0;
      break label560;
    }
  }

  public void SetDate(int paramInt1, int paramInt2, int paramInt3)
  {
    this.TIME = (paramInt1 / 365.0D + paramInt2 / 12.0D + paramInt3);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     derez.libs.Magnetics
 * JD-Core Version:    0.6.2
 */