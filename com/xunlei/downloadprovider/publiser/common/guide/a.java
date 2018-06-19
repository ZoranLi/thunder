package com.xunlei.downloadprovider.publiser.common.guide;

import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.loading.c;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.publiser.common.guide.b.b;
import com.xunlei.downloadprovider.publiser.common.guide.b.e;
import com.xunlei.downloadprovider.publiser.common.guide.b.f;
import com.xunlei.downloadprovider.publiser.common.guide.b.g;

/* compiled from: GuideManager */
public final class a {
    private static a d;
    public g a = null;
    public com.xunlei.downloadprovider.publiser.common.guide.a.a b = null;
    public boolean c = false;

    public static a a() {
        if (d == null) {
            d = new a();
        }
        return d;
    }

    private a() {
    }

    @NonNull
    public static g b() {
        g bVar;
        if (c.c()) {
            LoginHelper.a();
            if (l.c()) {
                bVar = new b();
            } else {
                bVar = new com.xunlei.downloadprovider.publiser.common.guide.b.c();
            }
        } else {
            LoginHelper.a();
            if (l.c()) {
                bVar = new e();
            } else {
                bVar = new f();
            }
        }
        new StringBuilder("createGuideScene scene: ").append(bVar.getClass().getSimpleName());
        return bVar;
    }

    public final boolean c() {
        return this.a != null;
    }

    public final boolean d() {
        return this.b != null;
    }

    public final void e() {
        if (d()) {
            this.b.e();
        }
    }
}
