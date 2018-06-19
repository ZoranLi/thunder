package com.xunlei.downloadprovider.personal.message.chat.chatengine.model;

import com.xunlei.downloadprovider.personal.message.chat.b;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.s;

/* compiled from: ChatMessage */
final class c implements com.xunlei.downloadprovider.personal.message.chat.c<IChatMessage> {
    final /* synthetic */ IChatDialog a;
    final /* synthetic */ com.xunlei.downloadprovider.personal.message.chat.c b;
    final /* synthetic */ ChatMessage c;

    c(ChatMessage chatMessage, IChatDialog iChatDialog, com.xunlei.downloadprovider.personal.message.chat.c cVar) {
        this.c = chatMessage;
        this.a = iChatDialog;
        this.b = cVar;
    }

    public final /* synthetic */ void a(Object obj) {
        obj = (IChatMessage) obj;
        this.c.mStatus = 2;
        this.a.setSendBefore(true);
        s.a().b((IChatMessage) obj);
        this.b.a(obj);
    }

    public final void a(b bVar) {
        new StringBuilder("sendTo onFail. errorInfo: ").append(bVar);
        switch (bVar.a) {
            case 1000:
                if (bVar.b != 2) {
                    this.c.mStatus = 5;
                    break;
                } else {
                    this.c.mStatus = 4;
                    break;
                }
            case 1001:
                this.c.mStatus = 5;
                break;
            default:
                this.c.mStatus = 4;
                break;
        }
        s.a().b(this.c);
        this.b.a(bVar);
    }
}
