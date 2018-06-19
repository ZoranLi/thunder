package com.xunlei.downloadprovider.member.a.a;

import com.android.volley.Request;
import com.xunlei.common.net.volley.BaseStringRequest;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.member.a.a;

/* compiled from: HighSpeedConfig */
public final class b implements a {
    a.a a;
    private a b = new a(this);

    public b(a.a aVar) {
        this.a = aVar;
    }

    public final void a() {
        if (c.b()) {
            if (this.b != null) {
                Object obj = this.b;
                if (obj.a != null) {
                    Request baseStringRequest = new BaseStringRequest("http://try.service.cdn.vip.xunlei.com:80/high_speed_channel/scene/config/get", obj, obj);
                    baseStringRequest.setShouldCache(false);
                    VolleyRequestManager.getMainThreadRequestQueue().a(baseStringRequest);
                }
            }
            return;
        }
        b();
    }

    protected final void b() {
        if (this.a != null) {
            this.a.b();
        }
    }

    public static String a(String str) {
        return c.a(str);
    }
}
