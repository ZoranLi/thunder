package com.xunlei.downloadprovider.publiser.common.guide.a;

import android.content.Context;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.download.create.m;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.publiser.common.guide.interesttag.GuideInterestTagActivity;

/* compiled from: GuideInterestTagBusiness */
public final class h extends a {
    public final boolean b() {
        return false;
    }

    public final boolean c() {
        return false;
    }

    public final int f() {
        return 2;
    }

    public final boolean a() {
        StringBuilder stringBuilder = new StringBuilder("shouldExecute. hasUserGuided: ");
        stringBuilder.append(h());
        stringBuilder.append(" \nLoginHelper.getInstance().isLogined: ");
        LoginHelper.a();
        stringBuilder.append(l.c());
        if (super.a()) {
            LoginHelper.a();
            if (l.c() && h()) {
                return true;
            }
        }
        return false;
    }

    public final void a(Context context) {
        GuideInterestTagActivity.a(context);
        m.a().b();
    }

    public final boolean d() {
        return d.a().b.f();
    }

    private static boolean h() {
        LoginHelper.a();
        return l.c() && !com.xunlei.downloadprovider.member.login.c.h.a().b("key_guide_hobby_tag");
    }

    public final void e() {
        LoginHelper.a();
        if (l.c()) {
            com.xunlei.downloadprovider.member.login.c.h.a().a("key_guide_hobby_tag");
        }
    }
}
