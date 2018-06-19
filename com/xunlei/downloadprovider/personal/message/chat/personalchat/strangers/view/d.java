package com.xunlei.downloadprovider.personal.message.chat.personalchat.strangers.view;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.c;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view.c.a;

/* compiled from: PersonalChatStrangersActivity */
final class d implements a {
    final /* synthetic */ IChatDialog a;
    final /* synthetic */ PersonalChatStrangersActivity b;

    d(PersonalChatStrangersActivity personalChatStrangersActivity, IChatDialog iChatDialog) {
        this.b = personalChatStrangersActivity;
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
