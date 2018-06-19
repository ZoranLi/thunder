package com.xunlei.downloadprovider.loading;

import com.xunlei.downloadprovider.ad.splash.a.h;

/* compiled from: LoadingActivity */
final class b implements h {
    final /* synthetic */ LoadingActivity a;

    b(LoadingActivity loadingActivity) {
        this.a = loadingActivity;
    }

    public final void a() {
        String str;
        if (this.a.m.c) {
            str = LoadingActivity.a;
        } else {
            str = LoadingActivity.a;
        }
    }

    public final void a_(int i, String str) {
        if (this.a.m.c != 0) {
            i = LoadingActivity.a;
            return;
        }
        i = LoadingActivity.a;
        if (this.a.m.c == 0) {
            this.a.m.d.cancel();
        }
        this.a.b();
    }

    public final void b() {
        if (this.a.m.c) {
            String str = LoadingActivity.a;
            return;
        }
        str = LoadingActivity.a;
        if (!this.a.m.c) {
            this.a.m.d.cancel();
        }
        LoadingActivity.c(this.a);
    }

    public final void c() {
        if (this.a.m.c) {
            String str = LoadingActivity.a;
            return;
        }
        str = LoadingActivity.a;
        this.a.a();
    }

    public final void d() {
        String str = LoadingActivity.a;
    }
}
