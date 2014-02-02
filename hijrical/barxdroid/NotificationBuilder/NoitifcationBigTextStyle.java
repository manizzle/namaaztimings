package barxdroid.NotificationBuilder;

import android.support.v4.app.NotificationCompat.BigTextStyle;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;

@BA.Author("BarxDroid")
@BA.ShortName("NotificationBigTextStyle")
public class NoitifcationBigTextStyle extends AbsObjectWrapper<NotificationCompat.BigTextStyle>
{
  public void Initialize(BA paramBA)
  {
    setObject(new NotificationCompat.BigTextStyle());
  }

  public void setBigContentTitle(String paramString)
  {
    ((NotificationCompat.BigTextStyle)getObject()).setBigContentTitle(paramString);
  }

  public void setBigText(String paramString)
  {
    ((NotificationCompat.BigTextStyle)getObject()).bigText(paramString);
  }

  public void setSummaryText(String paramString)
  {
    ((NotificationCompat.BigTextStyle)getObject()).setSummaryText(paramString);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     barxdroid.NotificationBuilder.NoitifcationBigTextStyle
 * JD-Core Version:    0.6.2
 */