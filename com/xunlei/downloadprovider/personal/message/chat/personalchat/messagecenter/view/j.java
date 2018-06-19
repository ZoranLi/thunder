package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.c;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view.c.a;

/* compiled from: MessageCenterActivity */
final class j implements a {
    final /* synthetic */ IChatDialog a;
    final /* synthetic */ MessageCenterActivity b;

    j(MessageCenterActivity messageCenterActivity, IChatDialog iChatDialog) {
        this.b = messageCenterActivity;
        this.a = iChatDialog;
    }

    public final void a() {
        c.a("delete");
        this.b.a.a(this.a);
        this.b.d();
    }

    public final void b() {
        this.b.d();
    }
}
