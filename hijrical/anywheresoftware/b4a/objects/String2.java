package anywheresoftware.b4a.objects;

import anywheresoftware.b4a.BA.DesignerName;

public abstract class String2
{
  @BA.DesignerName("CharAt")
  public abstract char charAt(int paramInt);

  @BA.DesignerName("CompareTo")
  public abstract int compareTo(String paramString);

  @BA.DesignerName("Contains")
  public abstract boolean contains(String paramString);

  @BA.DesignerName("EndsWith")
  public abstract boolean endsWith(String paramString);

  @BA.DesignerName("EqualsIgnoreCase")
  public abstract boolean equalsIgnoreCase(String paramString);

  @BA.DesignerName("GetBytes")
  public abstract byte[] getBytes(String paramString);

  @BA.DesignerName("IndexOf")
  public abstract int indexOf(String paramString);

  @BA.DesignerName("IndexOf2")
  public abstract int indexOf(String paramString, int paramInt);

  @BA.DesignerName("LastIndexOf")
  public abstract int lastIndexOf(String paramString);

  @BA.DesignerName("LastIndexOf2")
  public abstract int lastIndexOf(String paramString, int paramInt);

  @BA.DesignerName("Length")
  public abstract int length();

  @BA.DesignerName("Replace")
  public abstract String replace(String paramString1, String paramString2);

  @BA.DesignerName("StartsWith")
  public abstract boolean startsWith(String paramString);

  @BA.DesignerName("SubString")
  public abstract String substring(int paramInt);

  @BA.DesignerName("SubString2")
  public abstract String substring(int paramInt1, int paramInt2);

  @BA.DesignerName("ToLowerCase")
  public abstract String toLowerCase();

  @BA.DesignerName("ToUpperCase")
  public abstract String toUpperCase();

  @BA.DesignerName("Trim")
  public abstract String trim();
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.String2
 * JD-Core Version:    0.6.2
 */