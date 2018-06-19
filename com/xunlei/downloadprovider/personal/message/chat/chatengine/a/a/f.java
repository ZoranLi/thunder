package com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a;

/* compiled from: ChatDatabaseCacher */
final class f implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ e b;

    f(e eVar, int i) {
        this.b = eVar;
        this.a = i;
    }

    public final void run() {
        if (this.b.b != null) {
            this.b.b.a(Integer.valueOf(this.a));
        }
    }
}
