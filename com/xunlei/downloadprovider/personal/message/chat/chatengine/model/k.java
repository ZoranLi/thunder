package com.xunlei.downloadprovider.personal.message.chat.chatengine.model;

import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a.b;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.u;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.d.a;
import java.util.Collections;
import java.util.List;

/* compiled from: SingleChatDialog */
final class k implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ IChatMessage b;
    final /* synthetic */ int c;
    final /* synthetic */ IChatDialog d;
    final /* synthetic */ c e;
    final /* synthetic */ SingleChatDialog f;

    k(SingleChatDialog singleChatDialog, List list, IChatMessage iChatMessage, int i, IChatDialog iChatDialog, c cVar) {
        this.f = singleChatDialog;
        this.a = list;
        this.b = iChatMessage;
        this.c = i;
        this.d = iChatDialog;
        this.e = cVar;
    }

    public final void run() {
        IChatMessage iChatMessage = !this.a.isEmpty() ? (IChatMessage) this.a.get(0) : null;
        i iVar = new i();
        iVar.b = iChatMessage != null ? iChatMessage.createdAt() : 0;
        iVar.c = this.b != null ? this.b.createdAt() : 0;
        if (iVar.b == 0) {
            iVar.e = this.c;
        } else {
            iVar.e = -1;
        }
        b.a();
        List a = b.a(this.d, iVar);
        new StringBuilder("mergeServerAndLocalPreviousChatMessages. chatMessagesFromCache: ").append(a.toString());
        a.a(this.a, a, false, null, null);
        Collections.sort(this.a, new l(this));
        new StringBuilder("mergeServerAndLocalPreviousChatMessages. after merge and sort, chatMessages: ").append(this.a.toString());
        u.a().d().a(new m(this));
    }
}
