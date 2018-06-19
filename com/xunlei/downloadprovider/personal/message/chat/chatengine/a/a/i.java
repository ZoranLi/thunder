package com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChatDatabaseCacher */
final class i implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ b b;

    i(b bVar, List list) {
        this.b = bVar;
        this.a = list;
    }

    public final void run() {
        try {
            if (o.b()) {
                List arrayList = new ArrayList(this.a.size());
                for (IChatMessage chatDialog : this.a) {
                    arrayList.add(chatDialog.chatDialog());
                }
                m mVar = new m(o.a());
                mVar.a();
                l lVar = new l(o.a());
                lVar.a();
                n nVar = new n(o.a());
                nVar.a();
                p pVar = new p(o.a());
                pVar.a();
                List list = this.a;
                if (o.b()) {
                    mVar.a(m.a(list));
                }
                lVar.a(arrayList);
                nVar.a(arrayList);
                pVar.a(arrayList);
                mVar.b();
                lVar.b();
                nVar.b();
                pVar.b();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
