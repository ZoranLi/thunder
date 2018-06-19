package com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.b;

import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.f;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.h;

/* compiled from: DialogContentPresenter */
final class b implements c<IChatDialog> {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void a(com.xunlei.downloadprovider.personal.message.chat.b bVar) {
        if (!this.a.c) {
            new StringBuilder("onFail errorInfo: ").append(bVar);
        }
    }

    public final /* synthetic */ void a(Object obj) {
        if (this.a.c == null) {
            obj = this.a;
            obj.a.a(obj.b);
            obj.a.b(obj.b);
            obj.a.a();
            if (h.d() != null) {
                f.a().a(this.a.b);
            }
        }
    }
}
