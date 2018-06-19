package anet.channel.heartbeat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: Taobao */
public class HeartbeatManager {
    private static volatile IHeartbeatFactory heartbeatFactory = new b();

    @Deprecated
    /* compiled from: Taobao */
    public static class Receiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
        }
    }

    public static IHeartbeatFactory getHeartbeatFactory() {
        return heartbeatFactory;
    }

    public static void setHeartbeatFactory(IHeartbeatFactory iHeartbeatFactory) {
        heartbeatFactory = iHeartbeatFactory;
    }
}
