package anywheresoftware.b4a;

import java.lang.ref.WeakReference;

public abstract interface B4AClass
{
  public abstract boolean IsInitialized();

  public abstract BA getActivityBA();

  public abstract BA getBA();

  public static abstract class ImplB4AClass
    implements B4AClass
  {
    public BA ba;
    protected ImplB4AClass mostCurrent;

    public boolean IsInitialized()
    {
      return this.ba != null;
    }

    public BA getActivityBA()
    {
      WeakReference localWeakReference = this.ba.sharedProcessBA.activityBA;
      BA localBA = null;
      if (localWeakReference != null)
        localBA = (BA)this.ba.sharedProcessBA.activityBA.get();
      if (localBA == null)
        localBA = this.ba;
      return localBA;
    }

    public BA getBA()
    {
      return this.ba;
    }

    public String toString()
    {
      return BA.TypeToString(this, true);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.B4AClass
 * JD-Core Version:    0.6.2
 */