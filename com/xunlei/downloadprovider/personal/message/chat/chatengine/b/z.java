package com.xunlei.downloadprovider.personal.message.chat.chatengine.b;

import com.xunlei.downloadprovider.member.payment.a.e.a;
import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a.b;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a.h;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;

/* compiled from: ChatUserService */
final class z implements a {
    final /* synthetic */ IChatDialog a;
    final /* synthetic */ c b;
    final /* synthetic */ v c;

    z(v vVar, IChatDialog iChatDialog, c cVar) {
        this.c = vVar;
        this.a = iChatDialog;
        this.b = cVar;
    }

    public final void a() {
        this.a.setFollow(true);
        this.b.a(Boolean.valueOf(true));
        q.a().execute(new h(b.a(), this.a));
    }

    public final void a(String str) {
        this.b.a(com.xunlei.downloadprovider.personal.message.chat.b.a(-1, str));
    }
}
