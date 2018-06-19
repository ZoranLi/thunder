package com.xunlei.downloadprovider.broadcast;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: XLBroadcastManager */
public final class a {
    private static a b = new a();
    public final a a = new a();

    /* compiled from: XLBroadcastManager */
    private static class a {
        public BroadcastReceiver a;
        public List<b> b = new ArrayList();
        final List<a> c = new ArrayList();
        public IntentFilter d;

        a() {
        }

        final synchronized void a(b bVar) {
            if (bVar != null) {
                synchronized (this.c) {
                    a aVar = new a(bVar);
                    if (this.c.contains(aVar)) {
                        return;
                    }
                    this.c.add(aVar);
                    StringBuilder stringBuilder = new StringBuilder("registerBroadcastObserver(");
                    stringBuilder.append(this.c.size());
                    stringBuilder.append("):");
                    stringBuilder.append(bVar);
                }
            }
        }
    }

    private a() {
    }

    public static a a() {
        return b;
    }

    public final void a(b bVar) {
        this.a.a(bVar);
    }

    public final void b(b bVar) {
        a aVar = this.a;
        if (bVar != null && !aVar.c.isEmpty()) {
            synchronized (aVar.c) {
                Iterator it = aVar.c.iterator();
                while (it.hasNext()) {
                    if (bVar.equals(((a) it.next()).a)) {
                        it.remove();
                        StringBuilder stringBuilder = new StringBuilder("unregisterBroadcastObserver(");
                        stringBuilder.append(aVar.c.size());
                        stringBuilder.append("):");
                        stringBuilder.append(bVar);
                    }
                }
            }
        }
    }
}
