package com.xunlei.downloadprovider.homepage.cinecism;

import android.text.TextUtils;
import com.xunlei.downloadprovider.e.a.e;

/* compiled from: CinecismDetailActivity */
final class k implements e {
    final /* synthetic */ CinecismDetailActivity a;

    k(CinecismDetailActivity cinecismDetailActivity) {
        this.a = cinecismDetailActivity;
    }

    public final void a(String str, int i) {
        if (!(this.a.g() || TextUtils.equals(str, this.a.f.a) == null)) {
            this.a.f.g = i + 1;
            this.a.f.f = true;
            this.a.d();
        }
    }
}
