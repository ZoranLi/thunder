package com.xunlei.downloadprovider.member.login;

import android.content.Context;
import android.content.Intent;
import com.xunlei.downloadprovider.broadcast.b;
import com.xunlei.downloadprovider.member.login.b.l;

/* compiled from: LoginHelper */
final class f extends b {
    final /* synthetic */ LoginHelper a;

    f(LoginHelper loginHelper) {
        this.a = loginHelper;
    }

    public final void b(Context context, Intent intent) {
        if (l.b() != null) {
            this.a.f;
            l.a(true);
        }
    }

    public final void c(Context context, Intent intent) {
        if (l.b() != null) {
            this.a.f;
            l.a((boolean) null);
        }
    }
}
