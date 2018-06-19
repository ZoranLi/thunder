package com.xunlei.downloadprovider.personal.message.chat.personalchat.a;

import com.xunlei.downloadprovider.member.login.b.h;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.a;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.p;

/* compiled from: PersonalChatManager */
final class e implements h {
    final /* synthetic */ b a;

    e(b bVar) {
        this.a = bVar;
    }

    public final void onRefreshUserInfoCompleted(boolean z, int i) {
        if (z) {
            a aVar = (a) p.a(a.class);
            i = b.i();
            if (aVar.b) {
                a.a(i, aVar.a);
            }
        }
    }
}
