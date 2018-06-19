package com.xunlei.downloadprovider.download.player.a;

import android.view.View;
import com.xunlei.downloadprovider.download.player.c;
import com.xunlei.downloadprovider.download.player.views.DownloadVodPlayerView$d;
import com.xunlei.downloadprovider.vod.floatwindow.a;

/* compiled from: DownloadVodPlayerController */
final class w implements DownloadVodPlayerView$d {
    final /* synthetic */ m a;

    w(m mVar) {
        this.a = mVar;
    }

    public final void a(View view) {
        if (m.h(this.a) != null) {
            m.h(this.a).onClick(view);
        }
    }

    public final void a() {
        m.O();
        m.i(this.a).b();
        m.j(this.a);
    }

    public final void b() {
        m.O();
        m.i(this.a).b();
        m.j(this.a);
    }

    public final void c() {
        m.O();
        this.a.C();
        m.i(this.a).c();
    }

    public final void d() {
        m.O();
        m.k(this.a).g();
        this.a.c(true);
        this.a.b(false);
    }

    public final void e() {
        m.O();
        if (m.l(this.a) != null) {
            m.l(this.a).a();
        }
        this.a.H();
    }

    public final void a(int i) {
        m.O();
        m.a(this.a, i);
        if (this.a.e != 0 && this.a.e.getPlayerCenterViewGroup() != 0) {
            i = this.a.e.getPlayerCenterViewGroup();
            if (i.a != null) {
                i.a.c();
            }
        }
    }

    public final void a(int i, boolean z) {
        m.O();
        if (z && this.a.e && this.a.e.getPlayerCenterViewGroup()) {
            z = this.a.e.getPlayerCenterViewGroup();
            int m = i - m.m(this.a);
            int e = this.a.e();
            if (z.a != null) {
                z.a.a(m, i, e);
            }
        }
        m.a(this.a, i);
    }

    public final void b(int i) {
        m.O();
        if (m.i(this.a) != null) {
            c i2 = m.i(this.a);
            i2.h++;
        }
        this.a.a(i);
        if (this.a.e != 0 && this.a.e.getPlayerCenterViewGroup() != 0) {
            i = this.a.e.getPlayerCenterViewGroup();
            if (i.a != null) {
                i.a.d();
            }
        }
    }

    public final void f() {
        if (a.a) {
            m.O();
            return;
        }
        if (this.a.E()) {
            m.a(this.a, true);
            this.a.C();
        } else {
            m.a(this.a, false);
        }
        m.b(this.a, m.n(this.a));
    }

    public final void b(View view) {
        if (m.o(this.a) != null) {
            m.o(this.a).onClick(view);
        }
    }
}
