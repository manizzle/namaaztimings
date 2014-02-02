package dawoodibohra.salaat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BroadcastReceiverNotifications extends BroadcastReceiver
{
  public static final String ACTION_NAMAAZ_NOTIFY_ALARM = "dawoodibohra.salaat.ACTION_NAMAAZ_NOTIFY_ALARM";

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext.startService(new Intent(paramContext, ServiceNotifications.class));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     dawoodibohra.salaat.BroadcastReceiverNotifications
 * JD-Core Version:    0.6.2
 */