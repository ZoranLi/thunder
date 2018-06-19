package com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;

/* compiled from: ChatDatabaseCacher */
final class g implements Runnable {
    final /* synthetic */ IChatDialog a;
    final /* synthetic */ b b;

    g(b bVar, IChatDialog iChatDialog) {
        this.b = bVar;
        this.a = iChatDialog;
    }

    public final void run() {
        try {
            if (o.b()) {
                p pVar = new p(o.a());
                pVar.a();
                pVar.a(this.a);
                pVar.b();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
