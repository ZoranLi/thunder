package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.b;

import com.xunlei.downloadprovider.personal.message.chat.b;
import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.f;

/* compiled from: MessageCenterPresenter */
final class h implements c<Boolean> {
    final /* synthetic */ IChatDialog a;
    final /* synthetic */ b b;

    h(b bVar, IChatDialog iChatDialog) {
        this.b = bVar;
        this.a = iChatDialog;
    }

    public final void a(b bVar) {
        if (this.b.e == null) {
            this.b.b.p_();
        }
    }

    public final /* synthetic */ void a(Object obj) {
        if (this.b.e == null) {
            f.a().a(3, this.a, true);
        }
    }
}
