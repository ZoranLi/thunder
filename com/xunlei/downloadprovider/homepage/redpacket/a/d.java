package com.xunlei.downloadprovider.homepage.redpacket.a;

import com.android.volley.l;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.homepage.follow.c.ar;

/* compiled from: RequestRedPacketManager */
public class d {
    private static d c;
    private final String a = "http://api-shoulei-ssl.xunlei.com/ares/web_api/is_new";
    private final String b = "http://api-shoulei-ssl.xunlei.com/ares/api/newbie";
    private final l d = VolleyRequestManager.getMainThreadRequestQueue();

    /* compiled from: RequestRedPacketManager */
    public interface a {
        void a();

        void a(b bVar);
    }

    private d() {
    }

    public static d a() {
        if (c == null) {
            synchronized (d.class) {
                if (c == null) {
                    c = new d();
                }
            }
        }
        return c;
    }

    static /* synthetic */ void a(d dVar, ar arVar) {
        arVar.setShouldCache(false).setRetryPolicy(new com.android.volley.d(2000, 1, 1.0f));
        dVar.d.a(arVar);
    }
}
