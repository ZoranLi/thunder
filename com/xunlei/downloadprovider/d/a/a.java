package com.xunlei.downloadprovider.d.a;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.android.volley.l;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.net.volley.VolleyRequestManager;

/* compiled from: AbsConfig */
public abstract class a extends com.xunlei.downloadprovider.d.a {
    private static l a = VolleyRequestManager.getRequestQueue();
    private static Handler b = new Handler(Looper.getMainLooper());
    private String c;
    private String d;
    String v;

    protected abstract boolean a(boolean z, String str);

    public a(String str) {
        this.c = str;
    }

    public a(String str, String str2) {
        this.v = str;
        this.c = str2;
    }

    public a(String str, String str2, String str3) {
        this.v = str;
        this.c = str2;
        this.d = str3;
    }

    public final void g() {
        h();
        i();
    }

    public void i() {
        XLThreadPool.execute(new c(this));
    }

    public void a(Runnable runnable) {
        b.post(runnable);
    }

    public String j() {
        return this.v;
    }

    public void f(String str) {
        this.c = str;
    }

    public final void h() {
        Object obj;
        if (TextUtils.isEmpty(this.v)) {
            if (TextUtils.isEmpty(this.d)) {
                obj = null;
                if (obj == null) {
                    XLThreadPool.execute(new b(this));
                }
            }
        }
        obj = 1;
        if (obj == null) {
            XLThreadPool.execute(new b(this));
        }
    }

    static /* synthetic */ void a(a aVar, String str) {
        StringBuilder stringBuilder = new StringBuilder("onCacheLoaded--fileName=");
        stringBuilder.append(aVar.j());
        stringBuilder.append("|cacheIsNull=");
        stringBuilder.append(TextUtils.isEmpty(str));
        aVar.a(true, str);
    }

    static /* synthetic */ void b(a aVar, String str) {
        StringBuilder stringBuilder = new StringBuilder("onServerResponse--fileName=");
        stringBuilder.append(aVar.j());
        stringBuilder.append("|responseIsNull=");
        stringBuilder.append(TextUtils.isEmpty(str));
        aVar.a(false, str);
    }
}
