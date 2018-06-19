package com.qihoo360.replugin.component.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import java.lang.ref.WeakReference;

/* compiled from: ServiceDispatcher */
final class c {
    final c a = new c(this);
    final ServiceConnection b;
    final Context c;
    final Handler d;
    final int e;
    final int f;
    RuntimeException g;
    boolean h;
    final com.qihoo360.replugin.utils.a.a<ComponentName, a> i = new com.qihoo360.replugin.utils.a.a();
    private final ServiceConnectionLeaked j;

    /* compiled from: ServiceDispatcher */
    private static class a {
        IBinder a;
        DeathRecipient b;

        private a() {
        }
    }

    /* compiled from: ServiceDispatcher */
    private final class b implements DeathRecipient {
        final ComponentName a;
        final IBinder b;
        final /* synthetic */ c c;

        b(c cVar, ComponentName componentName, IBinder iBinder) {
            this.c = cVar;
            this.a = componentName;
            this.b = iBinder;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void binderDied() {
            /*
            r6 = this;
            r0 = r6.c;
            r1 = r6.a;
            r2 = r6.b;
            monitor-enter(r0);
            r3 = r0.i;	 Catch:{ all -> 0x0035 }
            r3 = r3.remove(r1);	 Catch:{ all -> 0x0035 }
            r3 = (com.qihoo360.replugin.component.service.c.a) r3;	 Catch:{ all -> 0x0035 }
            if (r3 == 0) goto L_0x0033;
        L_0x0011:
            r4 = r3.a;	 Catch:{ all -> 0x0035 }
            if (r4 == r2) goto L_0x0016;
        L_0x0015:
            goto L_0x0033;
        L_0x0016:
            r4 = r3.a;	 Catch:{ all -> 0x0035 }
            r3 = r3.b;	 Catch:{ all -> 0x0035 }
            r5 = 0;
            r4.unlinkToDeath(r3, r5);	 Catch:{ all -> 0x0035 }
            monitor-exit(r0);	 Catch:{ all -> 0x0035 }
            r3 = r0.d;
            if (r3 == 0) goto L_0x002f;
        L_0x0023:
            r3 = r0.d;
            r4 = new com.qihoo360.replugin.component.service.c$d;
            r5 = 1;
            r4.<init>(r0, r1, r2, r5);
            r3.post(r4);
            return;
        L_0x002f:
            r0.a(r1);
            return;
        L_0x0033:
            monitor-exit(r0);	 Catch:{ all -> 0x0035 }
            return;
        L_0x0035:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0035 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.replugin.component.service.c.b.binderDied():void");
        }
    }

    /* compiled from: ServiceDispatcher */
    private final class d implements Runnable {
        final ComponentName a;
        final IBinder b;
        final int c;
        final /* synthetic */ c d;

        d(c cVar, ComponentName componentName, IBinder iBinder, int i) {
            this.d = cVar;
            this.a = componentName;
            this.b = iBinder;
            this.c = i;
        }

        public final void run() {
            if (this.c == 0) {
                this.d.a(this.a, this.b);
                return;
            }
            if (this.c == 1) {
                this.d.a(this.a);
            }
        }
    }

    /* compiled from: ServiceDispatcher */
    private static class c extends com.qihoo360.loader2.mgr.a.a {
        final WeakReference<c> a;

        c(c cVar) {
            this.a = new WeakReference(cVar);
        }

        public final void a(ComponentName componentName, IBinder iBinder) throws RemoteException {
            c cVar = (c) this.a.get();
            if (cVar != null) {
                if (cVar.d != null) {
                    cVar.d.post(new d(cVar, componentName, iBinder, 0));
                    return;
                }
                cVar.a(componentName, iBinder);
            }
        }
    }

    c(ServiceConnection serviceConnection, Context context, Handler handler, int i, int i2) {
        this.b = serviceConnection;
        this.c = context;
        this.d = handler;
        this.j = new ServiceConnectionLeaked(null);
        this.j.fillInStackTrace();
        this.e = i;
        this.f = i2;
    }

    public final void a(android.content.ComponentName r5, android.os.IBinder r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r4.h;	 Catch:{ all -> 0x0058 }
        if (r0 == 0) goto L_0x0007;	 Catch:{ all -> 0x0058 }
    L_0x0005:
        monitor-exit(r4);	 Catch:{ all -> 0x0058 }
        return;	 Catch:{ all -> 0x0058 }
    L_0x0007:
        r0 = r4.i;	 Catch:{ all -> 0x0058 }
        r0 = r0.get(r5);	 Catch:{ all -> 0x0058 }
        r0 = (com.qihoo360.replugin.component.service.c.a) r0;	 Catch:{ all -> 0x0058 }
        if (r0 == 0) goto L_0x0017;	 Catch:{ all -> 0x0058 }
    L_0x0011:
        r1 = r0.a;	 Catch:{ all -> 0x0058 }
        if (r1 != r6) goto L_0x0017;	 Catch:{ all -> 0x0058 }
    L_0x0015:
        monitor-exit(r4);	 Catch:{ all -> 0x0058 }
        return;	 Catch:{ all -> 0x0058 }
    L_0x0017:
        r1 = 0;	 Catch:{ all -> 0x0058 }
        if (r6 == 0) goto L_0x003a;	 Catch:{ all -> 0x0058 }
    L_0x001a:
        r2 = new com.qihoo360.replugin.component.service.c$a;	 Catch:{ all -> 0x0058 }
        r2.<init>();	 Catch:{ all -> 0x0058 }
        r2.a = r6;	 Catch:{ all -> 0x0058 }
        r3 = new com.qihoo360.replugin.component.service.c$b;	 Catch:{ all -> 0x0058 }
        r3.<init>(r4, r5, r6);	 Catch:{ all -> 0x0058 }
        r2.b = r3;	 Catch:{ all -> 0x0058 }
        r3 = r2.b;	 Catch:{ RemoteException -> 0x0033 }
        r6.linkToDeath(r3, r1);	 Catch:{ RemoteException -> 0x0033 }
        r3 = r4.i;	 Catch:{ RemoteException -> 0x0033 }
        r3.put(r5, r2);	 Catch:{ RemoteException -> 0x0033 }
        goto L_0x003f;
    L_0x0033:
        r6 = r4.i;	 Catch:{ all -> 0x0058 }
        r6.remove(r5);	 Catch:{ all -> 0x0058 }
        monitor-exit(r4);	 Catch:{ all -> 0x0058 }
        return;	 Catch:{ all -> 0x0058 }
    L_0x003a:
        r2 = r4.i;	 Catch:{ all -> 0x0058 }
        r2.remove(r5);	 Catch:{ all -> 0x0058 }
    L_0x003f:
        if (r0 == 0) goto L_0x0048;	 Catch:{ all -> 0x0058 }
    L_0x0041:
        r2 = r0.a;	 Catch:{ all -> 0x0058 }
        r3 = r0.b;	 Catch:{ all -> 0x0058 }
        r2.unlinkToDeath(r3, r1);	 Catch:{ all -> 0x0058 }
    L_0x0048:
        monitor-exit(r4);	 Catch:{ all -> 0x0058 }
        if (r0 == 0) goto L_0x0050;
    L_0x004b:
        r0 = r4.b;
        r0.onServiceDisconnected(r5);
    L_0x0050:
        if (r6 == 0) goto L_0x0057;
    L_0x0052:
        r0 = r4.b;
        r0.onServiceConnected(r5, r6);
    L_0x0057:
        return;
    L_0x0058:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0058 }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.replugin.component.service.c.a(android.content.ComponentName, android.os.IBinder):void");
    }

    public final void a(ComponentName componentName) {
        this.b.onServiceDisconnected(componentName);
    }
}
