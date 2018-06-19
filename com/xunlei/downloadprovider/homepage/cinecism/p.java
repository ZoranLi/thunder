package com.xunlei.downloadprovider.homepage.cinecism;

import android.text.TextUtils;
import com.umeng.message.proguard.k;
import com.xunlei.downloadprovider.homepage.follow.b;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.c;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;

/* compiled from: CinecismDetailActivity */
final class p extends c {
    final /* synthetic */ String a;
    final /* synthetic */ VideoUserInfo b;
    final /* synthetic */ CinecismDetailActivity c;

    p(CinecismDetailActivity cinecismDetailActivity, String str, VideoUserInfo videoUserInfo) {
        this.c = cinecismDetailActivity;
        this.a = str;
        this.b = videoUserInfo;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        if (i != 0 || TextUtils.isEmpty(this.a)) {
            this.c.a((boolean) 0);
            return;
        }
        if (this.c.p) {
            z = this.c.p;
            i = new StringBuilder("javascript:window.get_userid(");
            i.append(LoginHelper.a().g.c());
            i.append(k.t);
            z.a(i.toString());
        }
        if (b.a().b(Long.valueOf(this.a).longValue())) {
            this.c.a((boolean) 1);
        } else {
            CinecismDetailActivity.b(this.c, this.b);
        }
    }
}
