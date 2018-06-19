package com.xunlei.downloadprovider.personal.message.chat.chatengine.c;

import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.i;

/* compiled from: ChatMessageNetwork */
public final class p implements Runnable {
    final /* synthetic */ IChatDialog a;
    final /* synthetic */ i b;
    final /* synthetic */ c c;
    final /* synthetic */ o d;

    public p(o oVar, IChatDialog iChatDialog, i iVar, c cVar) {
        this.d = oVar;
        this.a = iChatDialog;
        this.b = iVar;
        this.c = cVar;
    }

    public final void run() {
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/chitchat/one-to-one/records?user_id=");
        stringBuilder.append(this.a.targetUser().userId());
        stringBuilder.append(this.b.a(false));
        this.d.a(this.d.a(0, stringBuilder.toString(), new q(this)));
    }
}
