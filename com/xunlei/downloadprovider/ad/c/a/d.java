package com.xunlei.downloadprovider.ad.c.a;

import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.h.f;

/* compiled from: SharedPreferenceStorage */
public final class d extends e {
    private String a = null;

    public d(@NonNull String str) {
        this.a = str;
    }

    public final long a() {
        return f.b(BrothersApplication.getApplicationInstance().getApplicationContext(), this.a, 0);
    }

    public final void a(long j) {
        f.a(BrothersApplication.getApplicationInstance().getApplicationContext(), this.a, j);
    }
}
