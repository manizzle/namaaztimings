package anywheresoftware.b4a.keywords.constants;

import android.graphics.Color;

public class Colors
{
  public static final int Black = -16777216;
  public static final int Blue = -16776961;
  public static final int Cyan = -16711681;
  public static final int DarkGray = -12303292;
  public static final int Gray = -7829368;
  public static final int Green = -16711936;
  public static final int LightGray = -3355444;
  public static final int Magenta = -65281;
  public static final int Red = -65536;
  public static final int Transparent = 0;
  public static final int White = -1;
  public static final int Yellow = -256;

  public static int ARGB(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return Color.argb(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public static int RGB(int paramInt1, int paramInt2, int paramInt3)
  {
    return Color.rgb(paramInt1, paramInt2, paramInt3);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.keywords.constants.Colors
 * JD-Core Version:    0.6.2
 */