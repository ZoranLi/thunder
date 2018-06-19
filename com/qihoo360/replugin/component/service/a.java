package com.qihoo360.replugin.component.service;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import com.umeng.message.proguard.k;

/* compiled from: PluginServiceDispatcherManager */
public final class a {
    private static final byte[] c = new byte[0];
    private com.qihoo360.replugin.utils.a.a<Context, com.qihoo360.replugin.utils.a.a<ServiceConnection, c>> a = new com.qihoo360.replugin.utils.a.a();
    private com.qihoo360.replugin.utils.a.a<Context, com.qihoo360.replugin.utils.a.a<ServiceConnection, c>> b = new com.qihoo360.replugin.utils.a.a();

    public final c a(ServiceConnection serviceConnection, Context context, Handler handler, int i, int i2) {
        c cVar;
        synchronized (c) {
            cVar = null;
            com.qihoo360.replugin.utils.a.a aVar = (com.qihoo360.replugin.utils.a.a) this.a.get(context);
            if (aVar != null) {
                cVar = (c) aVar.get(serviceConnection);
            }
            if (cVar == null) {
                c cVar2 = new c(serviceConnection, context, handler, i, i2);
                if (aVar == null) {
                    aVar = new com.qihoo360.replugin.utils.a.a();
                    this.a.put(context, aVar);
                }
                aVar.put(serviceConnection, cVar2);
            } else if (cVar.c != context) {
                handler = new StringBuilder("ServiceConnection ");
                handler.append(cVar.b);
                handler.append(" registered with differing Context (was ");
                handler.append(cVar.c);
                handler.append(" now ");
                handler.append(context);
                handler.append(k.t);
                throw new RuntimeException(handler.toString());
            } else if (cVar.d != handler) {
                context = new StringBuilder("ServiceConnection ");
                context.append(cVar.b);
                context.append(" registered with differing handler (was ");
                context.append(cVar.d);
                context.append(" now ");
                context.append(handler);
                context.append(k.t);
                throw new RuntimeException(context.toString());
            }
        }
        return cVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.qihoo360.replugin.component.service.c a(android.content.Context r8, android.content.ServiceConnection r9) {
        /*
        r7 = this;
        r0 = c;
        monitor-enter(r0);
        r1 = r7.a;	 Catch:{ all -> 0x00dd }
        r1 = r1.get(r8);	 Catch:{ all -> 0x00dd }
        r1 = (com.qihoo360.replugin.utils.a.a) r1;	 Catch:{ all -> 0x00dd }
        if (r1 == 0) goto L_0x0077;
    L_0x000d:
        r2 = r1.get(r9);	 Catch:{ all -> 0x00dd }
        r2 = (com.qihoo360.replugin.component.service.c) r2;	 Catch:{ all -> 0x00dd }
        if (r2 == 0) goto L_0x0077;
    L_0x0015:
        r1.remove(r9);	 Catch:{ all -> 0x00dd }
        monitor-enter(r2);	 Catch:{ all -> 0x00dd }
        r3 = 0;
        r4 = r3;
    L_0x001b:
        r5 = r2.i;	 Catch:{ all -> 0x0074 }
        r5 = r5.size();	 Catch:{ all -> 0x0074 }
        if (r4 >= r5) goto L_0x0035;
    L_0x0023:
        r5 = r2.i;	 Catch:{ all -> 0x0074 }
        r5 = r5.b(r4);	 Catch:{ all -> 0x0074 }
        r5 = (com.qihoo360.replugin.component.service.c.a) r5;	 Catch:{ all -> 0x0074 }
        r6 = r5.a;	 Catch:{ all -> 0x0074 }
        r5 = r5.b;	 Catch:{ all -> 0x0074 }
        r6.unlinkToDeath(r5, r3);	 Catch:{ all -> 0x0074 }
        r4 = r4 + 1;
        goto L_0x001b;
    L_0x0035:
        r3 = r2.i;	 Catch:{ all -> 0x0074 }
        r3.clear();	 Catch:{ all -> 0x0074 }
        r3 = 1;
        r2.h = r3;	 Catch:{ all -> 0x0074 }
        monitor-exit(r2);	 Catch:{ all -> 0x0074 }
        r1 = r1.size();	 Catch:{ all -> 0x00dd }
        if (r1 != 0) goto L_0x0049;
    L_0x0044:
        r1 = r7.a;	 Catch:{ all -> 0x00dd }
        r1.remove(r8);	 Catch:{ all -> 0x00dd }
    L_0x0049:
        r1 = r2.e;	 Catch:{ all -> 0x00dd }
        r1 = r1 & 2;
        if (r1 == 0) goto L_0x0072;
    L_0x004f:
        r1 = r7.b;	 Catch:{ all -> 0x00dd }
        r1 = r1.get(r8);	 Catch:{ all -> 0x00dd }
        r1 = (com.qihoo360.replugin.utils.a.a) r1;	 Catch:{ all -> 0x00dd }
        if (r1 != 0) goto L_0x0063;
    L_0x0059:
        r1 = new com.qihoo360.replugin.utils.a.a;	 Catch:{ all -> 0x00dd }
        r1.<init>();	 Catch:{ all -> 0x00dd }
        r3 = r7.b;	 Catch:{ all -> 0x00dd }
        r3.put(r8, r1);	 Catch:{ all -> 0x00dd }
    L_0x0063:
        r8 = new java.lang.IllegalArgumentException;	 Catch:{ all -> 0x00dd }
        r3 = "Originally unbound here:";
        r8.<init>(r3);	 Catch:{ all -> 0x00dd }
        r8.fillInStackTrace();	 Catch:{ all -> 0x00dd }
        r2.g = r8;	 Catch:{ all -> 0x00dd }
        r1.put(r9, r2);	 Catch:{ all -> 0x00dd }
    L_0x0072:
        monitor-exit(r0);	 Catch:{ all -> 0x00dd }
        return r2;
    L_0x0074:
        r8 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0074 }
        throw r8;	 Catch:{ all -> 0x00dd }
    L_0x0077:
        r1 = r7.b;	 Catch:{ all -> 0x00dd }
        r1 = r1.get(r8);	 Catch:{ all -> 0x00dd }
        r1 = (com.qihoo360.replugin.utils.a.a) r1;	 Catch:{ all -> 0x00dd }
        r2 = 0;
        if (r1 == 0) goto L_0x00a8;
    L_0x0082:
        r1 = r1.get(r9);	 Catch:{ all -> 0x00dd }
        r1 = (com.qihoo360.replugin.component.service.c) r1;	 Catch:{ all -> 0x00dd }
        if (r1 == 0) goto L_0x00a8;
    L_0x008a:
        r8 = r1.g;	 Catch:{ all -> 0x00dd }
        r1 = new java.lang.IllegalArgumentException;	 Catch:{ all -> 0x00dd }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00dd }
        r4 = "Unbinding Service ";
        r3.<init>(r4);	 Catch:{ all -> 0x00dd }
        r3.append(r9);	 Catch:{ all -> 0x00dd }
        r9 = " that was already unbound";
        r3.append(r9);	 Catch:{ all -> 0x00dd }
        r9 = r3.toString();	 Catch:{ all -> 0x00dd }
        r1.<init>(r9, r8);	 Catch:{ all -> 0x00dd }
        r8 = com.qihoo360.replugin.b.c.a;	 Catch:{ all -> 0x00dd }
        monitor-exit(r0);	 Catch:{ all -> 0x00dd }
        return r2;
    L_0x00a8:
        if (r8 != 0) goto L_0x00c6;
    L_0x00aa:
        r8 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x00dd }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00dd }
        r3 = "Unbinding Service ";
        r1.<init>(r3);	 Catch:{ all -> 0x00dd }
        r1.append(r9);	 Catch:{ all -> 0x00dd }
        r9 = " from Context that is no longer in use";
        r1.append(r9);	 Catch:{ all -> 0x00dd }
        r9 = r1.toString();	 Catch:{ all -> 0x00dd }
        r8.<init>(r9);	 Catch:{ all -> 0x00dd }
        r8 = com.qihoo360.replugin.b.c.a;	 Catch:{ all -> 0x00dd }
        monitor-exit(r0);	 Catch:{ all -> 0x00dd }
        return r2;
    L_0x00c6:
        r8 = new java.lang.IllegalArgumentException;	 Catch:{ all -> 0x00dd }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00dd }
        r3 = "Service not registered: ";
        r1.<init>(r3);	 Catch:{ all -> 0x00dd }
        r1.append(r9);	 Catch:{ all -> 0x00dd }
        r9 = r1.toString();	 Catch:{ all -> 0x00dd }
        r8.<init>(r9);	 Catch:{ all -> 0x00dd }
        r8 = com.qihoo360.replugin.b.c.a;	 Catch:{ all -> 0x00dd }
        monitor-exit(r0);	 Catch:{ all -> 0x00dd }
        return r2;
    L_0x00dd:
        r8 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00dd }
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.replugin.component.service.a.a(android.content.Context, android.content.ServiceConnection):com.qihoo360.replugin.component.service.c");
    }
}
