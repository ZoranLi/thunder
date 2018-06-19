package com.xunlei.downloadprovider.personal.message.chat.chatengine.b;

/* compiled from: ChatDialogService */
final class g implements Runnable {
    final /* synthetic */ com.xunlei.downloadprovider.personal.message.chat.chatengine.model.g a;
    final /* synthetic */ f b;

    g(f fVar, com.xunlei.downloadprovider.personal.message.chat.chatengine.model.g gVar) {
        this.b = fVar;
        this.a = gVar;
    }

    public final void run() {
        if (this.b.b != null) {
            this.b.b.a(this.a);
        }
    }
}
