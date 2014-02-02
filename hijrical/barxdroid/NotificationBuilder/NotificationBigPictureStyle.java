package barxdroid.NotificationBuilder;

import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat.BigPictureStyle;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;

@BA.Author("BarxDroid")
@BA.ShortName("NotificationBigPictureStyle")
public class NotificationBigPictureStyle extends AbsObjectWrapper<NotificationCompat.BigPictureStyle>
{
  public void Initialize(BA paramBA)
  {
    setObject(new NotificationCompat.BigPictureStyle());
  }

  public void setBigContentTitle(String paramString)
  {
    ((NotificationCompat.BigPictureStyle)getObject()).setBigContentTitle(paramString);
  }

  public void setBigPicture(Bitmap paramBitmap)
  {
    ((NotificationCompat.BigPictureStyle)getObject()).bigPicture(paramBitmap);
  }

  public void setSummaryText(String paramString)
  {
    ((NotificationCompat.BigPictureStyle)getObject()).setSummaryText(paramString);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     barxdroid.NotificationBuilder.NotificationBigPictureStyle
 * JD-Core Version:    0.6.2
 */