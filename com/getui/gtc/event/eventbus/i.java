package com.getui.gtc.event.eventbus;

import java.util.ArrayList;
import java.util.List;

final class i {
    private static final List d = new ArrayList();
    Object a;
    n b;
    i c;

    private i(Object obj, n nVar) {
        this.a = obj;
        this.b = nVar;
    }

    static i a(n nVar, Object obj) {
        synchronized (d) {
            int size = d.size();
            if (size > 0) {
                i iVar = (i) d.remove(size - 1);
                iVar.a = obj;
                iVar.b = nVar;
                iVar.c = null;
                return iVar;
            }
            return new i(obj, nVar);
        }
    }

    static void a(i iVar) {
        iVar.a = null;
        iVar.b = null;
        iVar.c = null;
        synchronized (d) {
            if (d.size() < 10000) {
                d.add(iVar);
            }
        }
    }
}
