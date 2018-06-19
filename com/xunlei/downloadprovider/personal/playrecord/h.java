package com.xunlei.downloadprovider.personal.playrecord;

import com.xunlei.downloadprovider.member.login.b.g;

/* compiled from: PlayRecordActivity */
final class h implements g {
    final /* synthetic */ PlayRecordActivity a;

    h(PlayRecordActivity playRecordActivity) {
        this.a = playRecordActivity;
    }

    public final void onLogout() {
        if (!this.a.B) {
            this.a.g();
            this.a.b();
            PlayRecordActivity.c(this.a);
        }
    }
}
