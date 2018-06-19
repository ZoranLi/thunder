package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter;

import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.personal.a.a;
import com.xunlei.downloadprovider.personal.message.data.s;

/* compiled from: MessageCenterFakeUnreadCountManager */
public final class f {
    public s a = null;
    public boolean b = false;

    public f() {
        a a = a.a();
        s sVar = new s();
        sVar.a = a.a("key_new_unread_comment_count");
        sVar.b = a.a("key_new_unread_follow_count");
        sVar.c = a.a("key_new_unread_star_count");
        sVar.a(a.a("key_new_unread_chat_count"));
        sVar.d = a.a("key_new_unread_visitor_count");
        this.a = sVar;
        this.b = false;
    }

    public final void a(s sVar) {
        XLThreadPool.execute(new g(this, sVar));
    }
}
