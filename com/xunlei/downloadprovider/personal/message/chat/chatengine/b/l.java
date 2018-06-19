package com.xunlei.downloadprovider.personal.message.chat.chatengine.b;

import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a.b;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.SingleChatDialog;

/* compiled from: ChatDialogService */
final class l implements c<SingleChatDialog> {
    final /* synthetic */ c a;
    final /* synthetic */ b b;

    l(b bVar, c cVar) {
        this.b = bVar;
        this.a = cVar;
    }

    public final /* synthetic */ void a(Object obj) {
        obj = (SingleChatDialog) obj;
        new StringBuilder("refreshSingleChatDialog onSuccess. singleChatDialog: ").append(obj.toString());
        this.a.a(obj);
        b a = b.a();
        if (obj.lastMessage() != null) {
            q.a().execute(new com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a.c(a, obj.lastMessage()));
        }
    }

    public final void a(com.xunlei.downloadprovider.personal.message.chat.b bVar) {
        new StringBuilder("refreshSingleChatDialog onFail. errorInfo: ").append(bVar);
        this.a.a(bVar);
    }
}
