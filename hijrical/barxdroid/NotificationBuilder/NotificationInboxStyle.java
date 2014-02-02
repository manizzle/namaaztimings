package barxdroid.NotificationBuilder;

import android.support.v4.app.NotificationCompat.InboxStyle;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;

@BA.Author("BarxDroid")
@BA.ShortName("NotificationInboxStyle")
public class NotificationInboxStyle extends AbsObjectWrapper<NotificationCompat.InboxStyle>
{
  String[] Items = new String[5];

  public void Initialize(BA paramBA)
  {
    setObject(new NotificationCompat.InboxStyle());
  }

  public void setAddLine(String paramString)
  {
    ((NotificationCompat.InboxStyle)getObject()).addLine(paramString);
  }

  public void setBigContentTitle(String paramString)
  {
    ((NotificationCompat.InboxStyle)getObject()).setBigContentTitle(paramString);
  }

  public void setSummaryText(String paramString)
  {
    ((NotificationCompat.InboxStyle)getObject()).setSummaryText(paramString);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     barxdroid.NotificationBuilder.NotificationInboxStyle
 * JD-Core Version:    0.6.2
 */