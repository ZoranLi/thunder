package com.xunlei.downloadprovider.personal.message.chat.personalchat.a;

import com.xunlei.downloadprovider.member.login.b.g;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.a;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.ac;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.ag;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.p;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.u;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.b;

/* compiled from: PersonalChatManager */
final class d implements g {
    final /* synthetic */ b a;

    d(b bVar) {
        this.a = bVar;
    }

    public final void onLogout() {
        Object a = this.a.f;
        ((ac) p.a(ac.class)).b(a);
        a.b = false;
        a aVar = (a) p.a(a.class);
        aVar.b = false;
        aVar.a = null;
        ag c = u.a().c();
        c.b.writeLock().lock();
        try {
            ag.a.clear();
            b a2 = b.a();
            a2.g.removeMessages(1000);
            a2.g.removeMessages(1001);
            b.a = null;
            if (b.b().g()) {
                a.a();
            }
        } finally {
            c.b.writeLock().unlock();
        }
    }
}
