package com.xunlei.downloadprovider.personal.message.chat.chatengine.c;

import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;

/* compiled from: ChatDialogNetwork */
public final class m implements Runnable {
    final /* synthetic */ IChatDialog a;
    final /* synthetic */ c b;
    final /* synthetic */ d c;

    public m(d dVar, IChatDialog iChatDialog, c cVar) {
        this.c = dVar;
        this.a = iChatDialog;
        this.b = cVar;
    }

    public final void run() {
        this.c.a(this.c.a(1, "http://api-shoulei-ssl.xunlei.com/chitchat/unread", d.d(this.a.dialogId()), new n(this)));
    }
}
