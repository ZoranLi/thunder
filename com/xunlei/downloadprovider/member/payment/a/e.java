package com.xunlei.downloadprovider.member.payment.a;

import android.os.Handler;
import android.os.Looper;
import com.android.volley.Request;
import com.android.volley.l;
import com.xunlei.common.net.volley.VolleyRequestManager;

/* compiled from: BaseNetworkHelper */
public abstract class e {
    private static Handler a = new Handler(Looper.getMainLooper());
    private l b = VolleyRequestManager.getMainThreadRequestQueue();
    protected l e = VolleyRequestManager.getRequestQueue();

    /* compiled from: BaseNetworkHelper */
    public interface a {
        void a();

        void a(String str);
    }

    /* compiled from: BaseNetworkHelper */
    public interface c<T> {
        void onFail(String str);

        void onSuccess(T t);
    }

    public void a(Request<?> request) {
        this.b.a((Request) request);
    }

    public void a(Object obj) {
        this.b.a(obj);
        this.e.a(obj);
    }

    protected final void b(Request<?> request) {
        this.e.a((Request) request);
    }

    protected static void j(Runnable runnable) {
        a.post(runnable);
    }
}
