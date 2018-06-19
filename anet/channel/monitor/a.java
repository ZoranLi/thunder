package anet.channel.monitor;

import anet.channel.util.ALog;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class a {
    private static volatile a b;
    private Map<INetworkQualityChangeListener, f> a = new ConcurrentHashMap();
    private f c = new f();

    private a() {
    }

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    public void a(INetworkQualityChangeListener iNetworkQualityChangeListener, f fVar) {
        if (iNetworkQualityChangeListener == null) {
            ALog.e("BandWidthListenerHelp", "listener is null", null, new Object[0]);
        } else if (fVar == null) {
            this.c.b = System.currentTimeMillis();
            this.a.put(iNetworkQualityChangeListener, this.c);
        } else {
            fVar.b = System.currentTimeMillis();
            this.a.put(iNetworkQualityChangeListener, fVar);
        }
    }

    public void a(INetworkQualityChangeListener iNetworkQualityChangeListener) {
        this.a.remove(iNetworkQualityChangeListener);
    }

    public void a(double d) {
        for (Entry entry : this.a.entrySet()) {
            INetworkQualityChangeListener iNetworkQualityChangeListener = (INetworkQualityChangeListener) entry.getKey();
            f fVar = (f) entry.getValue();
            if (!(iNetworkQualityChangeListener == null || fVar == null || fVar.b())) {
                boolean a = fVar.a(d);
                if (fVar.a != a) {
                    fVar.a = a;
                    iNetworkQualityChangeListener.onNetworkQualityChanged(a ? NetworkSpeed.Slow : NetworkSpeed.Fast);
                }
            }
        }
    }
}
