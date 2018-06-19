package com.qihoo360.mobilesafe.svcmanager;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;

class PluginServiceRecord extends ReentrantLock {
    private static final boolean a;
    private static final String b;
    private static final long serialVersionUID = 1964598149985081920L;
    com.qihoo360.loader2.m.a mPluginBinder;
    final String mPluginName;
    final String mServiceName;
    ArrayList<a> processRecords = new ArrayList(4);

    class a implements DeathRecipient {
        final int a;
        final IBinder b;
        final /* synthetic */ PluginServiceRecord c;
        private int d;

        private a(com.qihoo360.mobilesafe.svcmanager.PluginServiceRecord r1, int r2, android.os.IBinder r3) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = this;
            r0.c = r1;
            r0.<init>();
            r0.a = r2;
            r0.b = r3;
            r1 = 0;
            r3.linkToDeath(r0, r1);	 Catch:{ RemoteException -> 0x000e }
            goto L_0x0017;
        L_0x000e:
            r1 = com.qihoo360.mobilesafe.svcmanager.PluginServiceRecord.a;
            if (r1 == 0) goto L_0x0017;
        L_0x0014:
            com.qihoo360.mobilesafe.svcmanager.PluginServiceRecord.b;
        L_0x0017:
            r1 = 1;
            r0.d = r1;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.mobilesafe.svcmanager.PluginServiceRecord.a.<init>(com.qihoo360.mobilesafe.svcmanager.PluginServiceRecord, int, android.os.IBinder):void");
        }

        public final void binderDied() {
            c.b(this.c.mPluginName, this.c.mServiceName, this.a);
        }

        static /* synthetic */ int a(a aVar) {
            int i = aVar.d - 1;
            aVar.d = i;
            return i;
        }

        static /* synthetic */ int b(a aVar) {
            int i = aVar.d + 1;
            aVar.d = i;
            return i;
        }
    }

    static {
        boolean z = com.qihoo360.mobilesafe.a.a.a;
        a = z;
        b = z ? "PluginServiceRecord" : PluginServiceRecord.class.getSimpleName();
    }

    PluginServiceRecord(String str, String str2) {
        this.mPluginName = str;
        this.mServiceName = str2;
    }

    android.os.IBinder getService(int r4, android.os.IBinder r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r3.lock();
        r0 = 0;
        r1 = r3.mPluginBinder;	 Catch:{ Exception -> 0x004e, all -> 0x0049 }
        if (r1 != 0) goto L_0x0012;	 Catch:{ Exception -> 0x004e, all -> 0x0049 }
    L_0x0008:
        r1 = r3.mPluginName;	 Catch:{ Exception -> 0x004e, all -> 0x0049 }
        r2 = r3.mServiceName;	 Catch:{ Exception -> 0x004e, all -> 0x0049 }
        r1 = com.qihoo360.loader2.m.a(r1, r2);	 Catch:{ Exception -> 0x004e, all -> 0x0049 }
        r3.mPluginBinder = r1;	 Catch:{ Exception -> 0x004e, all -> 0x0049 }
    L_0x0012:
        r1 = r3.mPluginBinder;	 Catch:{ Exception -> 0x004e, all -> 0x0049 }
        if (r1 != 0) goto L_0x001a;
    L_0x0016:
        r3.unlock();
        return r0;
    L_0x001a:
        r1 = r3.a(r4);	 Catch:{ Exception -> 0x004e, all -> 0x0049 }
        if (r1 == 0) goto L_0x0024;	 Catch:{ Exception -> 0x004e, all -> 0x0049 }
    L_0x0020:
        com.qihoo360.mobilesafe.svcmanager.PluginServiceRecord.a.b(r1);	 Catch:{ Exception -> 0x004e, all -> 0x0049 }
        goto L_0x002f;	 Catch:{ Exception -> 0x004e, all -> 0x0049 }
    L_0x0024:
        r1 = new com.qihoo360.mobilesafe.svcmanager.PluginServiceRecord$a;	 Catch:{ Exception -> 0x004e, all -> 0x0049 }
        r2 = 0;	 Catch:{ Exception -> 0x004e, all -> 0x0049 }
        r1.<init>(r4, r5);	 Catch:{ Exception -> 0x004e, all -> 0x0049 }
        r4 = r3.processRecords;	 Catch:{ Exception -> 0x004e, all -> 0x0049 }
        r4.add(r1);	 Catch:{ Exception -> 0x004e, all -> 0x0049 }
    L_0x002f:
        r4 = a;	 Catch:{ Exception -> 0x004e, all -> 0x0049 }
        if (r4 == 0) goto L_0x0041;	 Catch:{ Exception -> 0x004e, all -> 0x0049 }
    L_0x0033:
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x004e, all -> 0x0049 }
        r5 = "[addNewRecordInternal] remaining ref count: ";	 Catch:{ Exception -> 0x004e, all -> 0x0049 }
        r4.<init>(r5);	 Catch:{ Exception -> 0x004e, all -> 0x0049 }
        r5 = r3.a();	 Catch:{ Exception -> 0x004e, all -> 0x0049 }
        r4.append(r5);	 Catch:{ Exception -> 0x004e, all -> 0x0049 }
    L_0x0041:
        r4 = r3.mPluginBinder;	 Catch:{ Exception -> 0x004e, all -> 0x0049 }
        r4 = r4.d;	 Catch:{ Exception -> 0x004e, all -> 0x0049 }
        r3.unlock();
        return r4;
    L_0x0049:
        r4 = move-exception;
        r3.unlock();
        throw r4;
    L_0x004e:
        r3.unlock();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.mobilesafe.svcmanager.PluginServiceRecord.getService(int, android.os.IBinder):android.os.IBinder");
    }

    int decrementProcessRef(int r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r1.lock();
        r2 = r1.a(r2);	 Catch:{ Exception -> 0x0033, all -> 0x002e }
        if (r2 == 0) goto L_0x0014;	 Catch:{ Exception -> 0x0033, all -> 0x002e }
    L_0x0009:
        r0 = com.qihoo360.mobilesafe.svcmanager.PluginServiceRecord.a.a(r2);	 Catch:{ Exception -> 0x0033, all -> 0x002e }
        if (r0 > 0) goto L_0x0014;	 Catch:{ Exception -> 0x0033, all -> 0x002e }
    L_0x000f:
        r0 = r1.processRecords;	 Catch:{ Exception -> 0x0033, all -> 0x002e }
        r0.remove(r2);	 Catch:{ Exception -> 0x0033, all -> 0x002e }
    L_0x0014:
        r2 = a;	 Catch:{ Exception -> 0x0033, all -> 0x002e }
        if (r2 == 0) goto L_0x0026;	 Catch:{ Exception -> 0x0033, all -> 0x002e }
    L_0x0018:
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0033, all -> 0x002e }
        r0 = "[decrementProcessRef] remaining ref count: ";	 Catch:{ Exception -> 0x0033, all -> 0x002e }
        r2.<init>(r0);	 Catch:{ Exception -> 0x0033, all -> 0x002e }
        r0 = r1.a();	 Catch:{ Exception -> 0x0033, all -> 0x002e }
        r2.append(r0);	 Catch:{ Exception -> 0x0033, all -> 0x002e }
    L_0x0026:
        r2 = r1.a();	 Catch:{ Exception -> 0x0033, all -> 0x002e }
        r1.unlock();
        return r2;
    L_0x002e:
        r2 = move-exception;
        r1.unlock();
        throw r2;
    L_0x0033:
        r1.unlock();
        r2 = -1;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.mobilesafe.svcmanager.PluginServiceRecord.decrementProcessRef(int):int");
    }

    int refProcessDied(int r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r1.lock();
        r2 = r1.a(r2);	 Catch:{ Exception -> 0x001b, all -> 0x0016 }
        if (r2 == 0) goto L_0x000e;	 Catch:{ Exception -> 0x001b, all -> 0x0016 }
    L_0x0009:
        r0 = r1.processRecords;	 Catch:{ Exception -> 0x001b, all -> 0x0016 }
        r0.remove(r2);	 Catch:{ Exception -> 0x001b, all -> 0x0016 }
    L_0x000e:
        r2 = r1.a();	 Catch:{ Exception -> 0x001b, all -> 0x0016 }
        r1.unlock();
        return r2;
    L_0x0016:
        r2 = move-exception;
        r1.unlock();
        throw r2;
    L_0x001b:
        r1.unlock();
        r2 = -1;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.mobilesafe.svcmanager.PluginServiceRecord.refProcessDied(int):int");
    }

    boolean isServiceAlive() {
        return this.mPluginBinder != null && this.mPluginBinder.d != null && this.mPluginBinder.d.isBinderAlive() && this.mPluginBinder.d.pingBinder();
    }

    private a a(int i) {
        Iterator it = this.processRecords.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.a == i) {
                return aVar;
            }
        }
        return 0;
    }

    private int a() {
        Iterator it = this.processRecords.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((a) it.next()).d;
        }
        return i;
    }
}
