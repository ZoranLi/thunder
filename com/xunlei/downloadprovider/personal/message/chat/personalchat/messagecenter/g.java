package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter;

import com.sina.weibo.sdk.utils.NetworkHelper;
import com.xunlei.downloadprovider.personal.a.a;
import com.xunlei.downloadprovider.personal.message.data.s;

/* compiled from: MessageCenterFakeUnreadCountManager */
final class g implements Runnable {
    final /* synthetic */ s a;
    final /* synthetic */ f b;

    g(f fVar, s sVar) {
        this.b = fVar;
        this.a = sVar;
    }

    public final void run() {
        a a = a.a();
        s sVar = this.a;
        if (NetworkHelper.isNetworkAvailable(a.b())) {
            a.a("key_new_unread_comment_count", sVar.a);
            a.a("key_new_unread_follow_count", sVar.b);
            a.a("key_new_unread_star_count", sVar.c);
            a.a("key_new_unread_chat_count", sVar.e);
            a.a("key_new_unread_visitor_count", sVar.d);
        }
    }
}
