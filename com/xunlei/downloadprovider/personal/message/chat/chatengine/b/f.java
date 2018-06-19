package com.xunlei.downloadprovider.personal.message.chat.chatengine.b;

import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a.b;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.i;

/* compiled from: ChatDialogService */
final class f implements Runnable {
    final /* synthetic */ i a;
    final /* synthetic */ c b;
    final /* synthetic */ b c;

    f(b bVar, i iVar, c cVar) {
        this.c = bVar;
        this.a = iVar;
        this.b = cVar;
    }

    public final void run() {
        b.a();
        u.a().d().a(new g(this, b.a(this.a)));
    }
}
