package anywheresoftware.b4a.objects;

import android.os.Handler;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.CheckForReinitialize;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.Msgbox;

@BA.ShortName("Timer")
public class Timer
  implements BA.CheckForReinitialize
{
  private BA ba;
  private boolean enabled = false;
  private String eventName;
  private long interval;
  private ParentReference myRef = new ParentReference();
  private int relevantTimer = 0;

  private void startTicking()
  {
    TickTack localTickTack = new TickTack(this.relevantTimer, this.myRef, this.ba);
    BA.handler.postDelayed(localTickTack, this.interval);
  }

  private void stopTicking()
  {
    this.relevantTimer = (1 + this.relevantTimer);
  }

  public void Initialize(BA paramBA, String paramString, long paramLong)
  {
    this.interval = paramLong;
    this.ba = paramBA;
    this.eventName = (paramString.toLowerCase(BA.cul) + "_tick");
  }

  public boolean IsInitialized()
  {
    return this.ba != null;
  }

  public boolean getEnabled()
  {
    return this.enabled;
  }

  public long getInterval()
  {
    return this.interval;
  }

  public void setEnabled(boolean paramBoolean)
  {
    if (paramBoolean == this.enabled)
      return;
    if (paramBoolean)
    {
      this.myRef.timer = this;
      if (this.interval <= 0L)
        throw new IllegalStateException("Interval must be larger than 0.");
      startTicking();
    }
    while (true)
    {
      this.enabled = paramBoolean;
      return;
      this.myRef.timer = null;
      stopTicking();
    }
  }

  public void setInterval(long paramLong)
  {
    if (this.interval == paramLong);
    do
    {
      return;
      this.interval = paramLong;
    }
    while (!this.enabled);
    stopTicking();
    startTicking();
  }

  static class ParentReference
  {
    public Timer timer;
  }

  static class TickTack
    implements Runnable
  {
    private final BA ba;
    private final int currentTimer;
    private final Timer.ParentReference parent;

    public TickTack(int paramInt, Timer.ParentReference paramParentReference, BA paramBA)
    {
      this.currentTimer = paramInt;
      this.parent = paramParentReference;
      this.ba = paramBA;
    }

    public void run()
    {
      Timer localTimer = this.parent.timer;
      if ((localTimer == null) || (this.currentTimer != localTimer.relevantTimer));
      do
      {
        return;
        BA.handler.postDelayed(this, localTimer.interval);
      }
      while ((this.ba.isActivityPaused()) || (Msgbox.msgboxIsVisible()));
      this.ba.raiseEvent2(localTimer, false, localTimer.eventName, true, new Object[0]);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anywheresoftware.b4a.objects.Timer
 * JD-Core Version:    0.6.2
 */