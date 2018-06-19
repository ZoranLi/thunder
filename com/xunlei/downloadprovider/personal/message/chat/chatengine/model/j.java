package com.xunlei.downloadprovider.personal.message.chat.chatengine.model;

import com.xunlei.downloadprovider.personal.message.chat.b;
import com.xunlei.downloadprovider.personal.message.chat.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SingleChatDialog */
final class j implements c<List<IChatMessage>> {
    final /* synthetic */ IChatMessage a;
    final /* synthetic */ int b;
    final /* synthetic */ c c;
    final /* synthetic */ SingleChatDialog d;

    j(SingleChatDialog singleChatDialog, IChatMessage iChatMessage, int i, c cVar) {
        this.d = singleChatDialog;
        this.a = iChatMessage;
        this.b = i;
        this.c = cVar;
    }

    public final /* synthetic */ void a(Object obj) {
        this.d.mergeServerAndLocalPreviousChatMessages(this.a, this.b, this.d, (List) obj, this.c);
    }

    public final void a(b bVar) {
        this.d.mergeServerAndLocalPreviousChatMessages(this.a, this.b, this.d, new ArrayList(), this.c);
    }
}
