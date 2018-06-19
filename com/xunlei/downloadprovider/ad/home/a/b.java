package com.xunlei.downloadprovider.ad.home.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.Nullable;
import com.xunlei.downloadprovider.ad.cache.task.a.a;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.d.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* compiled from: HomeAdReloadController */
public final class b implements a {
    public static final int a = ((int) TimeUnit.SECONDS.toSeconds(20));
    private static final boolean c = d.a().p.o();
    private static final long d;
    private static final int e;
    private static b f;
    public Set<String> b;
    private HandlerThread g;
    private Handler h;
    private Set<com.xunlei.downloadprovider.homepage.choiceness.a.a.b> i;
    private List<String> j;
    private Handler k;
    private boolean l;
    private boolean m;

    static {
        int optInt;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        e.a aVar = e.a().e;
        if (aVar.a != null) {
            optInt = aVar.a.optInt("home_ad_reload_tick", a);
        } else {
            optInt = a;
        }
        if (optInt == 0) {
            optInt = a;
        }
        d = timeUnit.toMillis((long) optInt);
        e.a aVar2 = e.a().e;
        int i = 10;
        if (aVar2.a != null) {
            i = aVar2.a.optInt("home_ad_reload_count_max", 10);
        }
        e = i;
    }

    private b() {
        this.g = null;
        this.h = null;
        this.i = null;
        this.b = null;
        this.j = null;
        this.k = null;
        this.l = false;
        this.m = false;
        this.i = new HashSet();
        this.b = new HashSet();
        this.j = new ArrayList();
        if (c) {
            this.k = new Handler(new d(this));
            this.g = new HandlerThread("home ad reload count down task");
            this.g.start();
            this.h = new Handler(this.g.getLooper(), new e(this));
            this.l = true;
        }
        com.xunlei.downloadprovider.ad.cache.task.a.a().a(this);
    }

    public static b c() {
        if (f == null) {
            f = new b();
        }
        return f;
    }

    public static void d() {
        b c = c();
        c.i.clear();
        c.b.clear();
        c.j.clear();
        c.i();
        com.xunlei.downloadprovider.ad.cache.task.a.a().a.remove(c);
        f = null;
    }

    public final void e() {
        this.i.clear();
    }

    public final void a(com.xunlei.downloadprovider.homepage.choiceness.a.a.e eVar) {
        if (eVar instanceof com.xunlei.downloadprovider.homepage.choiceness.a.a.b) {
            a((com.xunlei.downloadprovider.homepage.choiceness.a.a.b) eVar);
        }
    }

    private void a(String str, @Nullable com.xunlei.downloadprovider.homepage.choiceness.a.a.b bVar, String str2) {
        StringBuilder stringBuilder = new StringBuilder("tryReloadFail. resId: ");
        if (bVar == null) {
            str = "null";
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(bVar.b());
            stringBuilder2.append(" stage: ");
            stringBuilder2.append(str);
            stringBuilder2.append(" errorMsg: ");
            stringBuilder2.append(str2);
            str = stringBuilder2.toString();
        }
        stringBuilder.append(str);
        if (bVar != null) {
            b(bVar);
        }
    }

    private void b(@Nullable com.xunlei.downloadprovider.homepage.choiceness.a.a.b bVar) {
        if (bVar != null) {
            this.b.remove(bVar.b());
        }
    }

    private boolean h() {
        return this.j.size() >= e;
    }

    public final void f() {
        if (this.k != null) {
            this.k.removeCallbacksAndMessages(null);
        }
    }

    public final void g() {
        if (this.h != null) {
            this.h.removeCallbacksAndMessages(null);
        }
    }

    public final void a() {
        this.m = false;
        for (com.xunlei.downloadprovider.homepage.choiceness.a.a.b a : this.i) {
            a(a);
        }
        e();
    }

    public final void b() {
        this.m = true;
    }

    private void a(com.xunlei.downloadprovider.homepage.choiceness.a.a.b bVar) {
        if (c && this.l && bVar != null && !f.a((com.xunlei.downloadprovider.homepage.choiceness.a.a.e) bVar) && !this.b.contains(bVar.b()) && !h()) {
            if ((this.b.size() >= 5 ? 1 : null) == null) {
                new StringBuilder("prepareReloadAd. resId: ").append(bVar.b());
                Message obtainMessage = this.h.obtainMessage(1000);
                obtainMessage.obj = bVar;
                this.h.sendMessageDelayed(obtainMessage, d);
                this.b.add(bVar.b());
            }
        }
    }

    private boolean a(String str, com.xunlei.downloadprovider.homepage.choiceness.a.a.b bVar) {
        if (!f.e()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        } else if (!this.l) {
            a(str, bVar, "engine is not working");
            return false;
        } else if (bVar == null) {
            a(str, null, "choicenessAdInfo is null");
            return false;
        } else if (h()) {
            a(str, bVar, "reloadCountFull");
            return false;
        } else if (this.m) {
            a(str, bVar, "isOnBackground");
            this.i.add(bVar);
            return false;
        } else {
            f a = f.a(BrothersApplication.getApplicationInstance());
            boolean z = (a.d == null || a.d.c(bVar) == -1) ? false : true;
            if (z) {
                a = f.a(BrothersApplication.getApplicationInstance());
                z = a.d != null && a.d.b((com.xunlei.downloadprovider.homepage.choiceness.a.a.e) bVar);
                if (!z) {
                    return true;
                }
                a(str, bVar, "currentAdItem is visible");
                a(bVar);
                return false;
            }
            a(str, bVar, "currentAdItem don't exist");
            return false;
        }
    }

    private void i() {
        g();
        this.h = null;
        f();
        this.k = null;
        if (this.g != null) {
            this.g.quit();
        }
        this.g = null;
        this.l = false;
    }

    static /* synthetic */ void a(b bVar, com.xunlei.downloadprovider.homepage.choiceness.a.a.b bVar2) {
        new StringBuilder("tryReloadSuccess. resId: ").append(bVar2.b());
        bVar.j.add(bVar2.b());
        bVar.b(bVar2);
    }

    static /* synthetic */ void b(b bVar, com.xunlei.downloadprovider.homepage.choiceness.a.a.b bVar2) {
        if (bVar.a("tryReloadAd", bVar2)) {
            new StringBuilder("tryReloadAd. resId: ").append(bVar2.b());
            f.a(new c(bVar, bVar2));
        }
    }
}
