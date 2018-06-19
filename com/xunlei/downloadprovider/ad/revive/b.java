package com.xunlei.downloadprovider.ad.revive;

import com.xunlei.downloadprovider.ad.splash.a.h;

/* compiled from: ReviveAdActivity */
final class b implements h {
    final /* synthetic */ ReviveAdActivity a;

    b(ReviveAdActivity reviveAdActivity) {
        this.a = reviveAdActivity;
    }

    public final void a() {
        String str;
        if (this.a.f.c) {
            str = ReviveAdActivity.a;
        } else {
            str = ReviveAdActivity.a;
        }
    }

    public final void a_(int i, String str) {
        if (this.a.f.c != 0) {
            i = ReviveAdActivity.a;
            return;
        }
        i = ReviveAdActivity.a;
        if (this.a.f.c == 0) {
            this.a.f.d.cancel();
        }
        this.a.finish();
    }

    public final void b() {
        if (this.a.f.c) {
            String str = ReviveAdActivity.a;
            return;
        }
        str = ReviveAdActivity.a;
        if (!this.a.f.c) {
            this.a.f.d.cancel();
        }
        ReviveAdActivity.b(this.a);
    }

    public final void c() {
        if (this.a.f.c) {
            String str = ReviveAdActivity.a;
            return;
        }
        str = ReviveAdActivity.a;
        this.a.finish();
    }

    public final void d() {
        String str = ReviveAdActivity.a;
    }
}
