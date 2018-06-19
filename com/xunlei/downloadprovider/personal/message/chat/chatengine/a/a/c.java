package com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;

/* compiled from: ChatDatabaseCacher */
public final class c implements Runnable {
    final /* synthetic */ IChatMessage a;
    final /* synthetic */ b b;

    public c(b bVar, IChatMessage iChatMessage) {
        this.b = bVar;
        this.a = iChatMessage;
    }

    public final void run() {
        try {
            if (o.b()) {
                m mVar = new m(o.a());
                mVar.a();
                l lVar = new l(o.a());
                lVar.a();
                n nVar = new n(o.a());
                nVar.a();
                p pVar = new p(o.a());
                pVar.a();
                IChatMessage iChatMessage = this.a;
                if (o.b()) {
                    mVar.a(m.a(iChatMessage));
                }
                lVar.a(this.a.chatDialog());
                nVar.a(this.a.chatDialog());
                pVar.a(this.a.chatDialog());
                mVar.b();
                lVar.b();
                nVar.b();
                pVar.b();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
