package com.xunlei.downloadprovider.personal.message.chat.chatengine.b;

import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.pushmessage.b.b;
import java.util.List;

/* compiled from: ChatDialogService */
public final class i implements c<List<IChatDialog>> {
    final /* synthetic */ c a = null;
    final /* synthetic */ b b;

    public i(b bVar) {
        this.b = bVar;
    }

    public final /* synthetic */ void a(Object obj) {
        obj = (List) obj;
        new StringBuilder("loadAllDialogsFromServer onSuccess. dialogSize: ").append(obj.size());
        b a = b.a();
        if (a.a != null) {
            a.a.edit().putBoolean("has_init_chat_data", true).apply();
        }
        n.a().c();
        if (this.a != null) {
            this.a.a(obj);
        }
    }

    public final void a(com.xunlei.downloadprovider.personal.message.chat.b bVar) {
        new StringBuilder("loadAllDialogsFromServer onFail. errorInfo: ").append(bVar);
        n.a().c();
        if (this.a != null) {
            this.a.a(bVar);
        }
    }
}
