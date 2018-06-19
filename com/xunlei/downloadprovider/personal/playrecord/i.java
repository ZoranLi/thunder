package com.xunlei.downloadprovider.personal.playrecord;

import com.xunlei.downloadprovider.member.login.b.h;

/* compiled from: PlayRecordActivity */
final class i implements h {
    final /* synthetic */ PlayRecordActivity a;

    i(PlayRecordActivity playRecordActivity) {
        this.a = playRecordActivity;
    }

    public final void onRefreshUserInfoCompleted(boolean z, int i) {
        if (!this.a.B) {
            this.a.runOnUiThread(new j(this));
            this.a.z.b(this.a.J);
        }
    }
}
