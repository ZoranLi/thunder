package com.xunlei.downloadprovider.personal.redenvelope;

import com.android.volley.l;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.net.volley.VolleyRequestManager;

/* compiled from: GameUsedRequestHelper */
public final class a {
    private static a b;
    l a = VolleyRequestManager.getMainThreadRequestQueue();

    /* compiled from: GameUsedRequestHelper */
    public interface a {
    }

    private a() {
    }

    public static a a() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    public final void a(String str, String str2, a aVar) {
        XLThreadPool.execute(new b(this, str, str2, aVar));
    }
}
