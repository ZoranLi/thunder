package com.xunlei.downloadprovider.personal.message.chat.chatengine.c;

import com.xunlei.downloadprovider.personal.message.chat.c;

/* compiled from: ChatUserNetwork */
public final class u implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ c b;
    final /* synthetic */ r c;

    public u(r rVar, long j, c cVar) {
        this.c = rVar;
        this.a = j;
        this.b = cVar;
    }

    public final void run() {
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/chitchat/blacklist?user_id=");
        stringBuilder.append(this.a);
        this.c.a(this.c.a(3, stringBuilder.toString(), new v(this)));
    }
}
