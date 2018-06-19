package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter;

import com.xunlei.downloadprovider.member.login.b.d;

/* compiled from: MessageCenterUnreadCountManager */
final class l implements d {
    final /* synthetic */ j a;

    l(j jVar) {
        this.a = jVar;
    }

    public final void onLoginCompleted(boolean z, int i, boolean z2) {
        if (z) {
            this.a.f();
        }
    }
}
