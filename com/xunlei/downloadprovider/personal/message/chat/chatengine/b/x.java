package com.xunlei.downloadprovider.personal.message.chat.chatengine.b;

import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a.b;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;

/* compiled from: ChatUserService */
final class x implements c<Boolean> {
    final /* synthetic */ IChatDialog a;
    final /* synthetic */ c b;
    final /* synthetic */ v c;

    x(v vVar, IChatDialog iChatDialog, c cVar) {
        this.c = vVar;
        this.a = iChatDialog;
        this.b = cVar;
    }

    public final /* synthetic */ void a(Object obj) {
        obj = (Boolean) obj;
        if (obj.booleanValue()) {
            this.a.setBlocking(false);
            b.a().a(this.a);
        }
        this.b.a(obj);
    }

    public final void a(com.xunlei.downloadprovider.personal.message.chat.b bVar) {
        this.b.a(bVar);
    }
}
