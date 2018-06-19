package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter;

import com.sina.weibo.sdk.utils.NetworkHelper;
import com.xunlei.downloadprovider.personal.a.a;
import com.xunlei.downloadprovider.personal.message.data.s;

/* compiled from: UserCenterFakeUnreadCountManager */
final class p implements Runnable {
    final /* synthetic */ s a;
    final /* synthetic */ o b;

    p(o oVar, s sVar) {
        this.b = oVar;
        this.a = sVar;
    }

    public final void run() {
        a a = a.a();
        s sVar = this.a;
        if (NetworkHelper.isNetworkAvailable(a.b())) {
            a.a("key_unread_comment_count", sVar.a);
            a.a("key_unread_follow_count", sVar.b);
            a.a("key_unread_start_count", sVar.c);
            a.a("key_unread_chat_count", sVar.e);
            a.a("key_unread_visitor_count", sVar.d);
        }
    }
}
