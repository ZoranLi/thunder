package com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;

/* compiled from: ChatDatabaseCacher */
public final class h implements Runnable {
    final /* synthetic */ IChatDialog a;
    final /* synthetic */ b b;

    public h(b bVar, IChatDialog iChatDialog) {
        this.b = bVar;
        this.a = iChatDialog;
    }

    public final void run() {
        try {
            if (o.b()) {
                n nVar = new n(o.a());
                nVar.a();
                nVar.a(this.a);
                nVar.b();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
