package anet.channel.a;

import anet.channel.monitor.INetworkQualityChangeListener;
import anet.channel.monitor.NetworkSpeed;
import anet.channel.monitor.b;
import anet.channel.util.ALog;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: Taobao */
final class e implements INetworkQualityChangeListener {
    e() {
    }

    public final void onNetworkQualityChanged(NetworkSpeed networkSpeed) {
        r2 = new Object[4];
        int i = 2;
        r2[2] = "Speed";
        r2[3] = Integer.valueOf(((int) b.a().c()) * 1024);
        ALog.i("awcn.ThreadPoolExecutorFactory", "", null, r2);
        ThreadPoolExecutor a = d.a();
        if (networkSpeed == NetworkSpeed.Slow) {
            i = 3;
        }
        a.setCorePoolSize(i);
    }
}
