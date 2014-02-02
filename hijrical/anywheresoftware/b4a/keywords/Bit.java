package anywheresoftware.b4a.keywords;

public class Bit
{
  public static int And(int paramInt1, int paramInt2)
  {
    return paramInt1 & paramInt2;
  }

  public static int Not(int paramInt)
  {
    return paramInt ^ 0xFFFFFFFF;
  }

  public static int Or(int paramInt1, int paramInt2)
  {
    return paramInt1 | paramInt2;
  }

  public static int ParseInt(String paramString, int paramInt)
  {
    return Integer.parseInt(paramString, paramInt);
  }

  public static int ShiftLeft(int paramInt1, int paramInt2)
  {
    return paramInt1 << paramInt2;
  }

  public static int ShiftRight(int paramInt1, int paramInt2)
  {
    return paramInt1 >> paramInt2;
  }

  public static String ToBinaryString(int paramInt)
  {
    return Integer.toBinaryString(paramInt);
  }

  public static String ToHexString(int paramInt)
  {
    return Integer.toHexString(paramInt);
  }

  public static String ToOctalString(int paramInt)
  {
    return Integer.toOctalString(paramInt);
  }

  public static int UnsignedShiftRight(int paramInt1, int paramInt2)
  {
    return paramInt1 >>> paramInt2;
  }

  public static int Xor(int paramInt1, int paramInt2)
  {
    return paramInt1 ^ paramInt2;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.keywords.Bit
 * JD-Core Version:    0.6.2
 */