package com.xunlei.downloadprovider.personal.playrecord;

import com.xunlei.downloadprovider.member.login.b.d;

/* compiled from: PlayRecordActivity */
final class g implements d {
    final /* synthetic */ PlayRecordActivity a;

    g(PlayRecordActivity playRecordActivity) {
        this.a = playRecordActivity;
    }

    public final void onLoginCompleted(boolean z, int i, boolean z2) {
        if (i == 0 && !this.a.B) {
            this.a.b();
        }
    }
}
