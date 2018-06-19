package com.xunlei.downloadprovidershare.redpacket;

import com.android.volley.l;
import com.xunlei.common.net.volley.VolleyRequestManager;

/* compiled from: RedPacketCashRequestManager */
public class b {
    private static b a;
    private final l b = VolleyRequestManager.getMainThreadRequestQueue();

    /* compiled from: RedPacketCashRequestManager */
    public interface a {
        void a();

        void a(a aVar);
    }

    private b() {
    }

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }
}
