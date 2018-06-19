package com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.b;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.b;
import java.util.List;

/* compiled from: DialogContentPresenter */
final class c implements com.xunlei.downloadprovider.personal.message.chat.c<List<IChatMessage>> {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final /* synthetic */ void a(Object obj) {
        List list = (List) obj;
        if (!this.a.c) {
            this.a.a.a(true);
            this.a.a.a(list, false);
            this.a.i();
            this.a.a.b();
            b.a().a(list);
        }
    }

    public final void a(com.xunlei.downloadprovider.personal.message.chat.b bVar) {
        if (this.a.c == null) {
            this.a.a.a(true);
        }
    }
}
