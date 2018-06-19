package com.xunlei.downloadprovider.personal.a.c;

import com.xunlei.downloadprovider.member.login.b.c;

/* compiled from: UserFixedBtnViewHolder */
final class q extends c {
    final /* synthetic */ i a;

    q(i iVar) {
        this.a = iVar;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        if (z && this.a.r && !this.a.r.isFinishing()) {
            this.a.r.runOnUiThread(new r(this));
        }
    }
}
