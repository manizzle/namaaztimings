package anywheresoftware.b4a;

public abstract interface ObjectWrapper<T>
{
  @BA.Hide
  public abstract T getObject();

  @BA.Hide
  public abstract T getObjectOrNull();

  @BA.Hide
  public abstract void setObject(T paramT);
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.ObjectWrapper
 * JD-Core Version:    0.6.2
 */