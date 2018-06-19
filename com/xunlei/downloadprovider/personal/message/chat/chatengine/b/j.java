package com.xunlei.downloadprovider.personal.message.chat.chatengine.b;

import com.xunlei.downloadprovider.personal.message.chat.b;
import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.g;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.i;
import java.util.List;

/* compiled from: ChatDialogService */
final class j implements c<g> {
    final /* synthetic */ List a;
    final /* synthetic */ i b;
    final /* synthetic */ c c;
    final /* synthetic */ b d;

    j(b bVar, List list, i iVar, c cVar) {
        this.d = bVar;
        this.a = list;
        this.b = iVar;
        this.c = cVar;
    }

    public final /* synthetic */ void a(Object obj) {
        g gVar = (g) obj;
        int size = gVar.a().size();
        this.a.addAll(gVar.a());
        if (size < this.b.e) {
            this.c.a(this.a);
            return;
        }
        obj = this.b;
        obj.d += size;
        this.d.a(true, this.b, this.a, this.c);
    }

    public final void a(b bVar) {
        new StringBuilder("loadRemainDialogsFromServer onFail. errorInfo: ").append(bVar);
        this.c.a(this.a);
    }
}
