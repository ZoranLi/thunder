package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.f;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.a.h.a;
import com.xunlei.downloadprovider.personal.message.data.s;

/* compiled from: MessageCenterUnreadCountManager */
final class k implements a {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public final void a(f fVar) {
        s c = this.a.c();
        c.a(c.e + fVar.a());
        this.a.a(c);
    }
}
