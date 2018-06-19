package com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a;

import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.u;

/* compiled from: ChatDatabaseCacher */
public final class e implements Runnable {
    final /* synthetic */ int a = 2;
    final /* synthetic */ c b;
    final /* synthetic */ b c;

    public e(b bVar, c cVar) {
        this.c = bVar;
        this.b = cVar;
    }

    public final void run() {
        try {
            if (o.b()) {
                l lVar = new l(o.a());
                lVar.a();
                int a = lVar.a(this.a);
                lVar.b();
                u.a().d().a(new f(this, a));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
