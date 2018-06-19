package com.xunlei.downloadprovider.personal.a.c;

import com.xunlei.downloadprovider.member.login.b.c;

/* compiled from: UserInfoViewHolder */
final class aa extends c {
    final /* synthetic */ String a;
    final /* synthetic */ s b;

    aa(s sVar, String str) {
        this.b = sVar;
        this.a = str;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        if (z && this.b.X) {
            this.b.X.runOnUiThread(new ab(this));
        }
    }
}
