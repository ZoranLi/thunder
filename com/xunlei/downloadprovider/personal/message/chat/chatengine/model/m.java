package com.xunlei.downloadprovider.personal.message.chat.chatengine.model;

import com.xunlei.downloadprovider.personal.message.chat.b;

/* compiled from: SingleChatDialog */
final class m implements Runnable {
    final /* synthetic */ k a;

    m(k kVar) {
        this.a = kVar;
    }

    public final void run() {
        if (this.a.a.isEmpty()) {
            this.a.e.a(b.a(-1, "no data"));
            return;
        }
        this.a.f.tryUpdateAllLastMessage((IChatMessage) this.a.a.get(0));
        this.a.e.a(this.a.a);
    }
}
