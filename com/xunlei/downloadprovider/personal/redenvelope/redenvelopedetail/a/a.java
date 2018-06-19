package com.xunlei.downloadprovider.personal.redenvelope.redenvelopedetail.a;

import com.android.volley.VolleyError;
import com.android.volley.l;
import com.xunlei.common.net.volley.VolleyRequestManager;

/* compiled from: RedDetailManager */
public final class a {
    public static a a;
    final l b = VolleyRequestManager.getMainThreadRequestQueue();

    /* compiled from: RedDetailManager */
    public interface a {
        void a(VolleyError volleyError);

        void a(e eVar);
    }
}
