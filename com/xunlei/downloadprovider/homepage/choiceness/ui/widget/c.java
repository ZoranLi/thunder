package com.xunlei.downloadprovider.homepage.choiceness.ui.widget;

import android.text.TextUtils;
import com.xunlei.downloadprovider.homepage.follow.b;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;

/* compiled from: FollowBtnView */
final class c extends com.xunlei.downloadprovider.member.login.b.c {
    final /* synthetic */ String a;
    final /* synthetic */ VideoUserInfo b;
    final /* synthetic */ FollowBtnView c;

    c(FollowBtnView followBtnView, String str, VideoUserInfo videoUserInfo) {
        this.c = followBtnView;
        this.a = str;
        this.b = videoUserInfo;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        if (i != 0 || TextUtils.isEmpty(this.a)) {
            this.c.setEnabled(1);
        } else if (b.a().b(Long.valueOf(this.a).longValue())) {
            this.c.setEnabled(0);
        } else {
            FollowBtnView.a(this.c, this.b);
        }
    }
}
