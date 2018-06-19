package com.xunlei.downloadprovider.personal.message.chat.chatengine.b;

import com.xunlei.downloadprovider.personal.message.chat.b;
import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.d.a;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChatDialogService */
final class e implements c<List<IChatDialog>> {
    final /* synthetic */ List a;
    final /* synthetic */ List b;
    final /* synthetic */ d c;

    e(d dVar, List list, List list2) {
        this.c = dVar;
        this.a = list;
        this.b = list2;
    }

    public final /* synthetic */ void a(Object obj) {
        List list = (List) obj;
        new StringBuilder("initDialogs. onSuccess. chatDialogs.size: ").append(list.size());
        obj = a.a(list);
        a.a(this.a, obj.b, true, null);
        a.a(this.b, obj.c, true, null);
        obj.b = this.a;
        obj.c = this.b;
        obj.a.clear();
        obj.a.addAll(obj.b);
        obj.a.addAll(obj.c);
        this.c.b.a(obj);
    }

    public final void a(b bVar) {
        new StringBuilder("initDialogs. onFail. errorInfo: ").append(bVar);
        bVar = new com.xunlei.downloadprovider.personal.message.chat.chatengine.model.b();
        List arrayList = new ArrayList();
        arrayList.addAll(this.a);
        arrayList.addAll(this.b);
        bVar.b = this.a;
        bVar.c = this.b;
        bVar.a = arrayList;
        this.c.b.a(bVar);
    }
}
