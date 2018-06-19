package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.b;

import com.xunlei.downloadprovider.personal.message.chat.b;
import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.f;

/* compiled from: MessageCenterPresenter */
final class g implements c<com.xunlei.downloadprovider.personal.message.chat.chatengine.model.g> {
    final /* synthetic */ b a;

    g(b bVar) {
        this.a = bVar;
    }

    public final /* synthetic */ void a(Object obj) {
        com.xunlei.downloadprovider.personal.message.chat.chatengine.model.g gVar = (com.xunlei.downloadprovider.personal.message.chat.chatengine.model.g) obj;
        if (!this.a.e) {
            f.a().a(gVar);
            this.a.b.b();
            b.e(this.a);
        }
    }

    public final void a(b bVar) {
        if (this.a.e == null) {
            this.a.b.b();
            b.e(this.a);
        }
    }
}
