package com.xunlei.downloadprovider.d.b;

import com.xunlei.downloadprovider.d.a;

/* compiled from: ForceLoginConfig */
public final class d extends a {
    public final boolean a() {
        return c("is_force_login");
    }

    public final int b() {
        return a("is_mobile_verify_login", 1);
    }

    public final int c() {
        return a("is_mobile_verify_comment", 0);
    }

    public final int d() {
        return a("is_mobile_verify_publish_video", 0);
    }

    public final int e() {
        return a("is_mobile_verify_website", 0);
    }

    public final int f() {
        return a("is_mobile_verify_chat", 0);
    }

    public final boolean g() {
        return a("like_should_show_score_dlg", false);
    }

    public final long h() {
        return (long) ((((a("new_user_keep_days", -1) * 24) * 60) * 60) * 1000);
    }
}
