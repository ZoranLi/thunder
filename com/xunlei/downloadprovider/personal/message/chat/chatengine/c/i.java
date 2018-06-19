package com.xunlei.downloadprovider.personal.message.chat.chatengine.c;

import com.xunlei.downloadprovider.personal.message.chat.c;

/* compiled from: ChatDialogNetwork */
public final class i implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ c b;
    final /* synthetic */ d c;

    public i(d dVar, int i, c cVar) {
        this.c = dVar;
        this.a = i;
        this.b = cVar;
    }

    public final void run() {
        this.c.a(this.c.a(1, "http://api-shoulei-ssl.xunlei.com/chitchat/session", d.c(this.a), new j(this)));
    }
}
