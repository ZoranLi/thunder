package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter;

import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.personal.a.a;
import com.xunlei.downloadprovider.personal.message.data.s;

/* compiled from: UserCenterFakeUnreadCountManager */
public final class o {
    public s a = null;

    public o() {
        a a = a.a();
        s sVar = new s();
        sVar.a = a.a("key_unread_comment_count");
        sVar.b = a.a("key_unread_follow_count");
        sVar.c = a.a("key_unread_start_count");
        sVar.a(a.a("key_unread_chat_count"));
        sVar.d = a.a("key_unread_visitor_count");
        this.a = sVar;
    }

    public final void a(s sVar) {
        XLThreadPool.execute(new p(this, sVar));
    }
}
