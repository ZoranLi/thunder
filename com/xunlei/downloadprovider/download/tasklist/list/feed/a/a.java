package com.xunlei.downloadprovider.download.tasklist.list.feed.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.tasklist.list.feed.b;
import com.xunlei.downloadprovider.h.f;
import java.util.concurrent.TimeUnit;

/* compiled from: TouTiaoAuthManager */
public final class a {
    private static a a;
    private a b = null;

    /* compiled from: TouTiaoAuthManager */
    public static class a {
        public String a;
        private long b;

        public a(String str, int i) {
            this.a = str;
            this.b = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis((long) i);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("TokenInfo{mAccessToken='");
            stringBuilder.append(this.a);
            stringBuilder.append('\'');
            stringBuilder.append(", mExpiredTimeInMillis=");
            stringBuilder.append(this.b);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }

        public static boolean a(a aVar) {
            if (aVar != null) {
                if (aVar.b - System.currentTimeMillis() >= TimeUnit.MINUTES.toMillis(5)) {
                    return null;
                }
            }
            return true;
        }
    }

    private a() {
        Object a = f.a(BrothersApplication.getApplicationInstance(), "tou_tiao_token_info");
        if (!TextUtils.isEmpty(a)) {
            this.b = (a) new Gson().fromJson(a, a.class);
            new StringBuilder("initTokenFromLocal. mToken: ").append(this.b.toString());
        }
    }

    public static a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    public final void a(@NonNull com.xunlei.downloadprovider.download.tasklist.list.feed.e.a<a> aVar) {
        if (a.a(this.b)) {
            b(aVar);
        } else {
            aVar.a(this.b);
        }
    }

    public final void b(com.xunlei.downloadprovider.download.tasklist.list.feed.e.a<a> aVar) {
        b.a("token");
        new com.xunlei.downloadprovider.download.tasklist.list.feed.e.a.b().a(new b(this, aVar));
    }

    static /* synthetic */ void a(a aVar, a aVar2) {
        aVar.b = aVar2;
        XLThreadPool.execute(new c(aVar, aVar2));
    }
}
