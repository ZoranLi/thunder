package com.xunlei.downloadprovider.homepage.choiceness.jointactivity;

/* compiled from: JoinActivityNetwork */
final class c implements Runnable {
    final /* synthetic */ com.xunlei.downloadprovider.personal.message.chat.c a;
    final /* synthetic */ b b;

    c(b bVar, com.xunlei.downloadprovider.personal.message.chat.c cVar) {
        this.b = bVar;
        this.a = cVar;
    }

    public final void run() {
        this.b.a(new a("http://api-shoulei-ssl.xunlei.com/pepper/api/is_newbie", new d(this), new e(this)));
    }
}
