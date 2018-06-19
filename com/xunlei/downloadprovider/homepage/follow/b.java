package com.xunlei.downloadprovider.homepage.follow;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.LocalBroadcastManager;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.homepage.follow.b.f;
import com.xunlei.downloadprovider.homepage.follow.b.g;
import com.xunlei.downloadprovider.homepage.follow.c.a;
import com.xunlei.downloadprovider.homepage.follow.c.ao;
import com.xunlei.downloadprovider.homepage.follow.c.t;
import com.xunlei.downloadprovider.homepage.follow.c.z;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.payment.a.e;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import com.xunlei.downloadprovider.member.payment.a.e.d;
import com.xunlei.xllib.android.XLIntent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: FollowManager */
public final class b {
    private static b n;
    Handler a = new Handler(Looper.getMainLooper());
    LocalBroadcastManager b;
    public ac c;
    public a d;
    public com.xunlei.downloadprovider.homepage.follow.a.a e;
    public int f = 0;
    public Set<Long> g = new HashSet();
    public final List<com.xunlei.downloadprovider.homepage.follow.b.a> h = new LinkedList();
    public final Set<Long> i = new HashSet();
    public Map<Long, f> j;
    List<g> k;
    public String l = "";
    public String m = "";

    private b() {
        Context applicationInstance = BrothersApplication.getApplicationInstance();
        this.d = new a();
        this.c = ac.a();
        this.e = new com.xunlei.downloadprovider.homepage.follow.a.a(applicationInstance);
        this.b = LocalBroadcastManager.getInstance(applicationInstance);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.xunlei.downloadprovider.intent.action.FOLLOW_LIST_CHANGE");
        this.b.registerReceiver(new c(this), intentFilter);
        this.g = this.e.a();
        this.j = this.e.b();
        a(null);
    }

    public static b a() {
        if (n == null) {
            n = new b();
        }
        return n;
    }

    public final void a(long j, boolean z, e.a aVar) {
        if (j != LoginHelper.a().g.c()) {
            a(j, false, z, new p(this, aVar));
        }
    }

    public final void a(long j, boolean z, boolean z2, d<com.xunlei.downloadprovider.homepage.follow.b.a, List<com.xunlei.downloadprovider.homepage.follow.b.a>> dVar) {
        if (j != LoginHelper.a().g.c()) {
            XLThreadPool.execute(new com.xunlei.downloadprovider.homepage.follow.c.b(this.d, j, z, new s(this, z2, dVar, j)));
        }
    }

    public final void a(List<com.xunlei.downloadprovider.homepage.follow.b.a> list, e.a aVar) {
        if (!list.isEmpty()) {
            this.d.a(list, new u(this, list, aVar));
        }
    }

    public final void a(long j, e.a aVar) {
        if (j != LoginHelper.a().g.c()) {
            XLThreadPool.execute(new t(this.d, j, new w(this, j, aVar)));
        }
    }

    public final void a(c<Set<Long>> cVar) {
        XLThreadPool.execute(new z(this.d, new x(this, cVar)));
    }

    public final int a(long j) {
        f fVar = (f) this.j.get(Long.valueOf(j));
        return fVar == null ? 0 : fVar.d;
    }

    public final boolean b(long j) {
        LoginHelper.a();
        if (!l.c()) {
            return false;
        }
        if (j == LoginHelper.a().g.c()) {
            return true;
        }
        if (this.g == null || this.g.contains(Long.valueOf(j)) == null) {
            return false;
        }
        return true;
    }

    public final void b(c<List<g>> cVar) {
        if (this.k != null) {
            cVar.onSuccess(this.k);
            return;
        }
        a aVar = this.d;
        c hVar = new h(this, cVar);
        cVar = new StringBuilder("http://api-shoulei-ssl.xunlei.com/follow/recommend_group_list_v2");
        cVar.append("?size=5000");
        XLThreadPool.execute(new ao(aVar, cVar, hVar));
    }

    public final com.xunlei.downloadprovider.homepage.follow.b.a c(long j) {
        if (!(this.g == null || this.h == null)) {
            if (this.g.contains(Long.valueOf(j))) {
                for (com.xunlei.downloadprovider.homepage.follow.b.a aVar : this.h) {
                    if (aVar.b == j) {
                        return aVar;
                    }
                }
                return null;
            }
        }
        return null;
    }

    public final boolean d(long j) {
        if (b(j)) {
            return false;
        }
        SharedPreferences sharedPreferences = this.c.a;
        StringBuilder stringBuilder = new StringBuilder("like_count_");
        stringBuilder.append(j);
        j = sharedPreferences.getInt(stringBuilder.toString(), 0);
        if (j <= null || j % 2 != null) {
            return false;
        }
        return 1;
    }

    public final void e(long j) {
        ac acVar = this.c;
        StringBuilder stringBuilder = new StringBuilder("like_count_");
        stringBuilder.append(j);
        j = stringBuilder.toString();
        acVar.a.edit().putInt(j, acVar.a.getInt(j, 0) + 1).apply();
    }

    public final boolean f(long j) {
        if (!b(j)) {
            SharedPreferences sharedPreferences = this.c.a;
            StringBuilder stringBuilder = new StringBuilder("show_dialog_");
            stringBuilder.append(j);
            if (sharedPreferences.getBoolean(stringBuilder.toString(), true) != null) {
                return true;
            }
        }
        return 0;
    }

    public final void g(long j) {
        Editor edit = this.c.a.edit();
        StringBuilder stringBuilder = new StringBuilder("show_dialog_");
        stringBuilder.append(j);
        edit.putBoolean(stringBuilder.toString(), false).apply();
    }

    public final void b() {
        this.m = "";
        this.l = "";
        this.g.clear();
        this.h.clear();
        this.i.clear();
        this.k = null;
        this.j = null;
        this.e.c();
        this.c.a(0);
        this.c.a("");
    }

    public final void c() {
        this.m = "";
        this.l = "";
        this.e.c();
    }

    public static void a(Runnable runnable) {
        XLThreadPool.getSingleThreadExecutorService().execute(runnable);
    }

    static /* synthetic */ void a(b bVar, com.xunlei.downloadprovider.homepage.follow.b.a aVar) {
        bVar.g.add(Long.valueOf(aVar.b));
        bVar.h.add(0, aVar);
        bVar.i.add(Long.valueOf(aVar.b));
        bVar.f++;
    }

    static /* synthetic */ void a(b bVar, long j) {
        bVar.g.remove(Long.valueOf(j));
        Iterator it = bVar.h.iterator();
        while (it.hasNext()) {
            if (((com.xunlei.downloadprovider.homepage.follow.b.a) it.next()).b == j) {
                it.remove();
                break;
            }
        }
        bVar.f--;
        bVar.b.sendBroadcast(new XLIntent("cancel_follow"));
        bVar = new ArrayList(1);
        bVar.add(String.valueOf(j));
        ab.a().a(true, bVar);
    }
}
