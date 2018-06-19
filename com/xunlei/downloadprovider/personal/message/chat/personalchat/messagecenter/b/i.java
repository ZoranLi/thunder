package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.b;

import com.xunlei.downloadprovider.personal.message.chat.b;
import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.g;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.f;

/* compiled from: MessageCenterPresenter */
final class i implements c<g> {
    final /* synthetic */ b a;

    i(b bVar) {
        this.a = bVar;
    }

    public final /* synthetic */ void a(Object obj) {
        g gVar = (g) obj;
        if (!this.a.e) {
            f.a().a(gVar);
            this.a.b.b();
        }
    }

    public final void a(b bVar) {
        if (this.a.e == null) {
            this.a.b.b();
        }
    }
}
