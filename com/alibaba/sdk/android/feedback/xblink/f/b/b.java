package com.alibaba.sdk.android.feedback.xblink.f.b;

import com.alibaba.sdk.android.feedback.xblink.f.a;

public class b extends a {
    private com.alibaba.sdk.android.feedback.xblink.f.b d = null;

    public boolean a(String str, String str2, com.alibaba.sdk.android.feedback.xblink.f.b bVar) {
        return true;
    }

    public void b() {
        d().a("WXPage.onPaused", "{}");
        super.b();
    }

    public void c() {
        super.c();
        d().a("WXPage.onResumed", "{}");
    }

    public synchronized com.alibaba.sdk.android.feedback.xblink.f.b d() {
        if (this.d == null) {
            this.d = new com.alibaba.sdk.android.feedback.xblink.f.b(this.b, "");
        }
        return this.d;
    }
}
