package com.xunlei.downloadprovider.personal.message.chat.chatengine.b;

import com.xunlei.downloadprovider.personal.message.chat.b;
import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a.k;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;

/* compiled from: ChatDialogService */
final class m implements c<Boolean> {
    final /* synthetic */ c a;
    final /* synthetic */ IChatDialog b;
    final /* synthetic */ b c;

    m(b bVar, c cVar, IChatDialog iChatDialog) {
        this.c = bVar;
        this.a = cVar;
        this.b = iChatDialog;
    }

    public final void a(b bVar) {
        this.a.a(bVar);
    }

    public final /* synthetic */ void a(Object obj) {
        this.a.a(Boolean.valueOf(true));
        obj = u.a().c();
        int dialogId = this.b.dialogId();
        obj.b.writeLock().lock();
        try {
            ag.a.remove(dialogId);
            q.a().execute(new k(com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a.b.a(), this.b));
        } finally {
            obj.b.writeLock().unlock();
        }
    }
}
