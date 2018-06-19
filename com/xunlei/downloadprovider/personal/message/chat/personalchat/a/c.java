package com.xunlei.downloadprovider.personal.message.chat.personalchat.a;

import com.xunlei.downloadprovider.member.login.b.d;

/* compiled from: PersonalChatManager */
final class c implements d {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final void onLoginCompleted(boolean z, int i, boolean z2) {
        if (z) {
            b.a(z2);
        }
        z2 = this.a.f;
        if (z) {
            z2.a();
        }
        if (!z && i != true && b.b().g()) {
            a.a();
        }
    }
}
