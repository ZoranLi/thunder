package com.xunlei.downloadprovider.download.downloadvod;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.download.downloadvod.a.d;
import com.xunlei.downloadprovider.download.engine.task.n;
import java.util.HashMap;
import java.util.Map.Entry;

/* compiled from: DownloadVodImpl */
public final class a {
    private static a a = new a();
    private static d d = new d();
    private final HashMap<Object, a> b = new HashMap();
    private Handler c;

    private a() {
    }

    public static a getInstance() {
        return a;
    }

    public static d getNotifyManager() {
        return d;
    }

    public final void obtainDownloadVodInfo(String str, String str2, String str3, long j, g gVar, @NonNull Object obj, String str4, String str5, boolean z) {
        Object obj2 = obj;
        a bVar = new b(this, str, str2, str3, j, str4, str5, gVar);
        bVar.b = obj2;
        bVar.h = z;
        a(obj2, bVar);
    }

    public final void removeCallback(Object obj) {
        a(obj, true);
    }

    public static void setDownloadVodAllowMobileNetwork(long j) {
        n.a();
        n.h(j);
    }

    public final void cancelAll() {
        synchronized (this.b) {
            for (Entry value : this.b.entrySet()) {
                ((a) value.getValue()).a();
            }
            this.b.clear();
        }
    }

    final void a(@NonNull Object obj, @NonNull a aVar) {
        cancelAll();
        synchronized (this.b) {
            this.b.put(obj, aVar);
        }
        XLThreadPool.execute(new b(this, aVar));
    }

    final void a(Object obj, boolean z) {
        synchronized (this.b) {
            a aVar = (a) this.b.remove(obj);
            if (aVar != null && z) {
                aVar.a();
            }
        }
    }

    final void a(Runnable runnable) {
        a().post(runnable);
    }

    @NonNull
    private synchronized Handler a() {
        if (this.c == null) {
            this.c = new Handler(Looper.getMainLooper());
        }
        return this.c;
    }

    static /* synthetic */ void a(a aVar) {
        if (aVar != null) {
            aVar.b();
        }
    }
}
