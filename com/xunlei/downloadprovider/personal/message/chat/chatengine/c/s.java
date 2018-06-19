package com.xunlei.downloadprovider.personal.message.chat.chatengine.c;

import com.xunlei.downloadprovider.personal.message.chat.c;

/* compiled from: ChatUserNetwork */
final class s implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ int b;
    final /* synthetic */ c c;
    final /* synthetic */ r d;

    s(r rVar, long j, int i, c cVar) {
        this.d = rVar;
        this.a = j;
        this.b = i;
        this.c = cVar;
    }

    public final void run() {
        this.d.a(this.d.a(1, "http://api-shoulei-ssl.xunlei.com/chitchat/blacklist", r.a(this.a, this.b), new t(this)));
    }
}
