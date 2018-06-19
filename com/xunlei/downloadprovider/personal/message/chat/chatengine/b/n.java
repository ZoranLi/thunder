package com.xunlei.downloadprovider.personal.message.chat.chatengine.b;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.ab.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChatDialogSyncService */
public final class n implements ab {
    private static n b;
    public boolean a;
    private List<a> c;

    private n() {
        this.a = false;
        this.c = null;
        this.c = new ArrayList();
    }

    public static n a() {
        if (b == null) {
            b = new n();
        }
        return b;
    }

    public final void a(a aVar) {
        if (aVar != null) {
            if (this.c.contains(aVar)) {
                StringBuilder stringBuilder = new StringBuilder("已经存在该Listener. l: ");
                stringBuilder.append(aVar);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            this.c.add(aVar);
        }
    }

    public final void b(a aVar) {
        this.c.remove(aVar);
    }

    public final boolean b() {
        return this.a;
    }

    protected final void c() {
        this.a = false;
        u.a().d().a(new o(this));
    }

    static /* synthetic */ void a(n nVar) {
        for (a a : nVar.c) {
            a.a();
        }
    }
}
