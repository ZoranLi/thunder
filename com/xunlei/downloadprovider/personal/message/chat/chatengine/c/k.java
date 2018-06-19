package com.xunlei.downloadprovider.personal.message.chat.chatengine.c;

import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.i;

/* compiled from: ChatDialogNetwork */
public final class k implements Runnable {
    final /* synthetic */ i a;
    final /* synthetic */ c b;
    final /* synthetic */ d c;

    public k(d dVar, i iVar, c cVar) {
        this.c = dVar;
        this.a = iVar;
        this.b = cVar;
    }

    public final void run() {
        this.c.a(this.a, this.b);
    }
}
