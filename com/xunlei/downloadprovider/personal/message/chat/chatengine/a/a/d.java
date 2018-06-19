package com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;

/* compiled from: ChatDatabaseCacher */
public final class d implements Runnable {
    final /* synthetic */ IChatDialog a;
    final /* synthetic */ b b;

    public d(b bVar, IChatDialog iChatDialog) {
        this.b = bVar;
        this.a = iChatDialog;
    }

    public final void run() {
        try {
            if (o.b()) {
                l lVar = new l(o.a());
                lVar.a();
                lVar.a(this.a);
                lVar.b();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
