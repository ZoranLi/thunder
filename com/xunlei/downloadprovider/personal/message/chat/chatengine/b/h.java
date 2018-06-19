package com.xunlei.downloadprovider.personal.message.chat.chatengine.b;

import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a.b;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.c.a;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.g;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChatDialogService */
final class h implements c<g> {
    final /* synthetic */ c a;
    final /* synthetic */ b b;

    h(b bVar, c cVar) {
        this.b = bVar;
        this.a = cVar;
    }

    public final /* synthetic */ void a(Object obj) {
        obj = (g) obj;
        if (a.a(this.a)) {
            b a = b.a();
            List<IChatDialog> a2 = obj.a();
            List arrayList = new ArrayList(a2.size());
            for (IChatDialog iChatDialog : a2) {
                if (iChatDialog.lastMessage() != null) {
                    arrayList.add(iChatDialog.lastMessage());
                }
            }
            a.a(arrayList);
            this.a.a(obj);
        }
    }

    public final void a(com.xunlei.downloadprovider.personal.message.chat.b bVar) {
        new StringBuilder("queryDialogsFromServer onFail. errorInfo: ").append(bVar);
        if (a.a(this.a)) {
            this.a.a(bVar);
        }
    }
}
