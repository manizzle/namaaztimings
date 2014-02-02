package anywheresoftware.b4a.keywords;

import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.ConnectorUtils;
import java.io.DataInputStream;
import java.io.IOException;

@BA.ShortName("LayoutValues")
public class LayoutValues
{
  public int Height;
  public float Scale;
  public int Width;

  @BA.Hide
  public static LayoutValues readFromStream(DataInputStream paramDataInputStream)
    throws IOException
  {
    LayoutValues localLayoutValues = new LayoutValues();
    localLayoutValues.Scale = Float.intBitsToFloat(ConnectorUtils.readInt(paramDataInputStream));
    localLayoutValues.Width = ConnectorUtils.readInt(paramDataInputStream);
    localLayoutValues.Height = ConnectorUtils.readInt(paramDataInputStream);
    return localLayoutValues;
  }

  @BA.Hide
  public float calcDistance(LayoutValues paramLayoutValues)
  {
    float f1 = paramLayoutValues.Scale / this.Scale;
    float f2 = f1 * this.Width;
    float f3 = f1 * this.Height;
    if (f2 > 1.2D * paramLayoutValues.Width)
      return 3.4028235E+38F;
    if (f3 > 1.2D * paramLayoutValues.Height)
      return 3.4028235E+38F;
    if (f2 > paramLayoutValues.Width)
      f2 += 50.0F;
    if (f3 > paramLayoutValues.Height)
      f3 += 50.0F;
    if (Math.signum(f2 - f3) == Math.signum(paramLayoutValues.Width - paramLayoutValues.Height));
    for (int i = 0; ; i = 100)
      return i + (Math.abs(f2 - paramLayoutValues.Width) + Math.abs(f3 - paramLayoutValues.Height) + 100.0F * Math.abs(this.Scale - paramLayoutValues.Scale));
  }

  public double getApproximateScreenSize()
  {
    return Math.sqrt(Math.pow(this.Width / this.Scale, 2.0D) + Math.pow(this.Height / this.Scale, 2.0D)) / 160.0D;
  }

  public String toString()
  {
    return this.Width + " x " + this.Height + ", scale = " + this.Scale + " (" + (int)(160.0F * this.Scale) + " dpi)";
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.keywords.LayoutValues
 * JD-Core Version:    0.6.2
 */