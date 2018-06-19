package com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.b;

import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.b;
import java.util.List;

/* compiled from: DialogContentPresenter */
final class d implements c<List<IChatMessage>> {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public final /* synthetic */ void a(Object obj) {
        List list = (List) obj;
        if (!this.a.c) {
            this.a.a.a(list, true);
            this.a.i();
            this.a.a.d();
            b.a().a(list);
        }
    }

    public final void a(com.xunlei.downloadprovider.personal.message.chat.b bVar) {
        if (this.a.c == null) {
            this.a.a.d();
        }
    }
}
