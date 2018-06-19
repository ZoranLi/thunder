package com.xunlei.downloadprovider.personal.message.chat.chatengine.model;

import com.xunlei.downloadprovider.personal.message.chat.b;
import com.xunlei.downloadprovider.personal.message.chat.c;
import java.util.List;

/* compiled from: SingleChatDialog */
final class n implements c<List<IChatMessage>> {
    final /* synthetic */ c a;
    final /* synthetic */ SingleChatDialog b;

    n(SingleChatDialog singleChatDialog, c cVar) {
        this.b = singleChatDialog;
        this.a = cVar;
    }

    public final /* synthetic */ void a(Object obj) {
        obj = (List) obj;
        if (!obj.isEmpty()) {
            this.b.tryUpdateAllLastMessage((IChatMessage) obj.get(0));
        }
        this.a.a(obj);
    }

    public final void a(b bVar) {
        this.a.a(bVar);
    }
}
