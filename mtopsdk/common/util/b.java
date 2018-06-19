package mtopsdk.common.util;

import android.content.ComponentName;
import android.content.ServiceConnection;

final class b implements ServiceConnection {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.a.c) {
            this.a.a = null;
        }
    }

    public final void onServiceConnected(android.content.ComponentName r10, android.os.IBinder r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        r10 = r9.a;
        r10 = r10.c;
        monitor-enter(r10);
        r0 = mtopsdk.common.util.TBSdkLog$LogEnable.DebugEnable;	 Catch:{ all -> 0x0089 }
        r0 = mtopsdk.common.util.j.a(r0);	 Catch:{ all -> 0x0089 }
        if (r0 == 0) goto L_0x0024;	 Catch:{ all -> 0x0089 }
    L_0x000d:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0089 }
        r1 = "[onServiceConnected] Service connected called. interfaceName =";	 Catch:{ all -> 0x0089 }
        r0.<init>(r1);	 Catch:{ all -> 0x0089 }
        r1 = r9.a;	 Catch:{ all -> 0x0089 }
        r1 = r1.c();	 Catch:{ all -> 0x0089 }
        r0.append(r1);	 Catch:{ all -> 0x0089 }
        r0 = r0.toString();	 Catch:{ all -> 0x0089 }
        mtopsdk.common.util.j.a(r0);	 Catch:{ all -> 0x0089 }
    L_0x0024:
        r0 = r9.a;	 Catch:{ Exception -> 0x005d }
        r0 = r0.b;	 Catch:{ Exception -> 0x005d }
        r0 = r0.getDeclaredClasses();	 Catch:{ Exception -> 0x005d }
        r1 = r0.length;	 Catch:{ Exception -> 0x005d }
        r2 = 0;	 Catch:{ Exception -> 0x005d }
        r3 = r2;	 Catch:{ Exception -> 0x005d }
    L_0x002f:
        if (r3 >= r1) goto L_0x007c;	 Catch:{ Exception -> 0x005d }
    L_0x0031:
        r4 = r0[r3];	 Catch:{ Exception -> 0x005d }
        r5 = r4.getSimpleName();	 Catch:{ Exception -> 0x005d }
        r6 = "Stub";	 Catch:{ Exception -> 0x005d }
        r5 = r5.equals(r6);	 Catch:{ Exception -> 0x005d }
        if (r5 == 0) goto L_0x005a;	 Catch:{ Exception -> 0x005d }
    L_0x003f:
        r5 = "asInterface";	 Catch:{ Exception -> 0x005d }
        r6 = 1;	 Catch:{ Exception -> 0x005d }
        r7 = new java.lang.Class[r6];	 Catch:{ Exception -> 0x005d }
        r8 = android.os.IBinder.class;	 Catch:{ Exception -> 0x005d }
        r7[r2] = r8;	 Catch:{ Exception -> 0x005d }
        r5 = r4.getDeclaredMethod(r5, r7);	 Catch:{ Exception -> 0x005d }
        r7 = r9.a;	 Catch:{ Exception -> 0x005d }
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x005d }
        r6[r2] = r11;	 Catch:{ Exception -> 0x005d }
        r4 = r5.invoke(r4, r6);	 Catch:{ Exception -> 0x005d }
        r4 = (android.os.IInterface) r4;	 Catch:{ Exception -> 0x005d }
        r7.a = r4;	 Catch:{ Exception -> 0x005d }
    L_0x005a:
        r3 = r3 + 1;
        goto L_0x002f;
    L_0x005d:
        r11 = mtopsdk.common.util.TBSdkLog$LogEnable.WarnEnable;	 Catch:{ all -> 0x0089 }
        r11 = mtopsdk.common.util.j.a(r11);	 Catch:{ all -> 0x0089 }
        if (r11 == 0) goto L_0x007c;	 Catch:{ all -> 0x0089 }
    L_0x0065:
        r11 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0089 }
        r0 = "[onServiceConnected] Service bind failed. interfaceName=";	 Catch:{ all -> 0x0089 }
        r11.<init>(r0);	 Catch:{ all -> 0x0089 }
        r0 = r9.a;	 Catch:{ all -> 0x0089 }
        r0 = r0.c();	 Catch:{ all -> 0x0089 }
        r11.append(r0);	 Catch:{ all -> 0x0089 }
        r11 = r11.toString();	 Catch:{ all -> 0x0089 }
        mtopsdk.common.util.j.c(r11);	 Catch:{ all -> 0x0089 }
    L_0x007c:
        r11 = r9.a;	 Catch:{ all -> 0x0089 }
        r11 = r11.a;	 Catch:{ all -> 0x0089 }
        if (r11 == 0) goto L_0x0087;	 Catch:{ all -> 0x0089 }
    L_0x0082:
        r11 = r9.a;	 Catch:{ all -> 0x0089 }
        r11.a();	 Catch:{ all -> 0x0089 }
    L_0x0087:
        monitor-exit(r10);	 Catch:{ all -> 0x0089 }
        return;
    L_0x0089:
        r11 = move-exception;
        monitor-exit(r10);
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.common.util.b.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }
}
