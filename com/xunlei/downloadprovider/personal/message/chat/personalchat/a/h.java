package com.xunlei.downloadprovider.personal.message.chat.personalchat.a;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.ac;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.p;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.r;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.d.e;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.f;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PersonalChatUnreadCountManager */
public final class h implements r {
    List<a> a;
    boolean b;

    /* compiled from: PersonalChatUnreadCountManager */
    public interface a {
        void a(f fVar);
    }

    public final void b(List<IChatMessage> list) {
    }

    public h() {
        this.a = null;
        this.b = false;
        this.a = new ArrayList();
    }

    public final void a(a aVar) {
        this.a.remove(aVar);
    }

    public final void a(List<IChatMessage> list) {
        f fVar = new f();
        int i = 0;
        int i2 = 0;
        for (IChatMessage iChatMessage : list) {
            if (!e.a(iChatMessage)) {
                if (com.xunlei.downloadprovider.personal.message.chat.chatengine.d.a.a(iChatMessage.chatDialog())) {
                    i++;
                } else if (com.xunlei.downloadprovider.personal.message.chat.chatengine.d.a.b(iChatMessage.chatDialog())) {
                    i2++;
                }
            }
        }
        fVar.a(3, i);
        fVar.a(2, i2);
        if (fVar.a() != null) {
            list = this.a.iterator();
            while (list.hasNext()) {
                ((a) list.next()).a(fVar);
            }
        }
    }

    final void a() {
        if (!this.b) {
            ((ac) p.a(ac.class)).a((r) this);
            this.b = true;
        }
    }
}
