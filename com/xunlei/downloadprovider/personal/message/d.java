package com.xunlei.downloadprovider.personal.message;

import com.xunlei.downloadprovider.pushmessage.c;
import com.xunlei.downloadprovider.pushmessage.o;

/* compiled from: MessageCenterSubject */
public class d extends o {
    private static d b;

    /* compiled from: MessageCenterSubject */
    public interface a extends c {
        void a();
    }

    private d() {
    }

    public static d a() {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d();
                }
            }
        }
        return b;
    }

    public final void a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public final void b(a aVar) {
        if (aVar != null) {
            b(aVar);
        }
    }

    public final void b() {
        for (c a : this.a) {
            a.a(null);
        }
    }

    public final void c() {
        for (c cVar : this.a) {
            ((a) cVar).a();
        }
    }
}
