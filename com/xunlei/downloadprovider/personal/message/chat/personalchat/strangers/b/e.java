package com.xunlei.downloadprovider.personal.message.chat.personalchat.strangers.b;

import com.xunlei.downloadprovider.personal.message.chat.b;
import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.g;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.f;

/* compiled from: PersonalChatStrangersPresenter */
final class e implements c<g> {
    final /* synthetic */ a a;

    e(a aVar) {
        this.a = aVar;
    }

    public final /* synthetic */ void a(Object obj) {
        g gVar = (g) obj;
        if (!this.a.c) {
            f.a().b(gVar);
            this.a.b.c();
        }
    }

    public final void a(b bVar) {
        if (this.a.c == null) {
            this.a.b.c();
        }
    }
}
