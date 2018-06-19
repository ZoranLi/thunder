package com.xunlei.downloadprovider.personal.message.chat.chatengine.b;

import com.xunlei.downloadprovider.personal.message.chat.b;
import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.SingleChatDialog;

/* compiled from: ChatDialogService */
final class k implements c<SingleChatDialog> {
    final /* synthetic */ c a;
    final /* synthetic */ b b;

    k(b bVar, c cVar) {
        this.b = bVar;
        this.a = cVar;
    }

    public final /* synthetic */ void a(Object obj) {
        obj = (SingleChatDialog) obj;
        new StringBuilder("createSingleChatDialog onSuccess. singleChatDialog: ").append(obj.toString());
        this.a.a(obj);
    }

    public final void a(b bVar) {
        StringBuilder stringBuilder = new StringBuilder("createSingleChatDialog onFail. errorCode: ");
        stringBuilder.append(bVar.a);
        stringBuilder.append(" errorInfo: ");
        stringBuilder.append(bVar.c);
        this.a.a(bVar);
    }
}
