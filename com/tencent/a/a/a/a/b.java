package com.tencent.a.a.a.a;

import android.content.Context;
import android.os.Environment;
import com.umeng.message.MsgConstant;

final class b extends f {
    b(Context context) {
        super(context);
    }

    protected final void a(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0062 }
        r0.<init>();	 Catch:{ all -> 0x0062 }
        r1 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ all -> 0x0062 }
        r0.append(r1);	 Catch:{ all -> 0x0062 }
        r1 = "/";	 Catch:{ all -> 0x0062 }
        r0.append(r1);	 Catch:{ all -> 0x0062 }
        r1 = "6X8Y4XdM2Vhvn0I=";	 Catch:{ all -> 0x0062 }
        r1 = com.tencent.a.a.a.a.h.f(r1);	 Catch:{ all -> 0x0062 }
        r0.append(r1);	 Catch:{ all -> 0x0062 }
        r0 = r0.toString();	 Catch:{ all -> 0x0062 }
        com.tencent.a.a.a.a.a.d(r0);	 Catch:{ all -> 0x0062 }
        r0 = new java.io.File;	 Catch:{ all -> 0x0062 }
        r1 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ all -> 0x0062 }
        r2 = "6X8Y4XdM2Vhvn0KfzcEatGnWaNU=";	 Catch:{ all -> 0x0062 }
        r2 = com.tencent.a.a.a.a.h.f(r2);	 Catch:{ all -> 0x0062 }
        r0.<init>(r1, r2);	 Catch:{ all -> 0x0062 }
        r1 = new java.io.FileWriter;	 Catch:{ Exception -> 0x0060 }
        r1.<init>(r0);	 Catch:{ Exception -> 0x0060 }
        r0 = new java.io.BufferedWriter;	 Catch:{ Exception -> 0x0060 }
        r0.<init>(r1);	 Catch:{ Exception -> 0x0060 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0060 }
        r1.<init>();	 Catch:{ Exception -> 0x0060 }
        r2 = "4kU71lN96TJUomD1vOU9lgj9Tw==";	 Catch:{ Exception -> 0x0060 }
        r2 = com.tencent.a.a.a.a.h.f(r2);	 Catch:{ Exception -> 0x0060 }
        r1.append(r2);	 Catch:{ Exception -> 0x0060 }
        r2 = ",";	 Catch:{ Exception -> 0x0060 }
        r1.append(r2);	 Catch:{ Exception -> 0x0060 }
        r1.append(r4);	 Catch:{ Exception -> 0x0060 }
        r4 = r1.toString();	 Catch:{ Exception -> 0x0060 }
        r0.write(r4);	 Catch:{ Exception -> 0x0060 }
        r4 = "\n";	 Catch:{ Exception -> 0x0060 }
        r0.write(r4);	 Catch:{ Exception -> 0x0060 }
        r0.close();	 Catch:{ Exception -> 0x0060 }
    L_0x0060:
        monitor-exit(r3);	 Catch:{ all -> 0x0062 }
        return;	 Catch:{ all -> 0x0062 }
    L_0x0062:
        r4 = move-exception;	 Catch:{ all -> 0x0062 }
        monitor-exit(r3);	 Catch:{ all -> 0x0062 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.a.a.a.a.b.a(java.lang.String):void");
    }

    protected final boolean a() {
        return h.a(this.a, MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE) && Environment.getExternalStorageState().equals("mounted");
    }

    protected final java.lang.String b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = new java.io.File;	 Catch:{ all -> 0x0050 }
        r1 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ all -> 0x0050 }
        r2 = "6X8Y4XdM2Vhvn0KfzcEatGnWaNU=";	 Catch:{ all -> 0x0050 }
        r2 = com.tencent.a.a.a.a.h.f(r2);	 Catch:{ all -> 0x0050 }
        r0.<init>(r1, r2);	 Catch:{ all -> 0x0050 }
        r0 = com.tencent.a.a.a.a.a.a(r0);	 Catch:{ IOException -> 0x004d }
        r0 = r0.iterator();	 Catch:{ IOException -> 0x004d }
    L_0x0018:
        r1 = r0.hasNext();	 Catch:{ IOException -> 0x004d }
        if (r1 == 0) goto L_0x004d;	 Catch:{ IOException -> 0x004d }
    L_0x001e:
        r1 = r0.next();	 Catch:{ IOException -> 0x004d }
        r1 = (java.lang.String) r1;	 Catch:{ IOException -> 0x004d }
        r2 = ",";	 Catch:{ IOException -> 0x004d }
        r1 = r1.split(r2);	 Catch:{ IOException -> 0x004d }
        r2 = r1.length;	 Catch:{ IOException -> 0x004d }
        r3 = 2;	 Catch:{ IOException -> 0x004d }
        if (r2 != r3) goto L_0x0018;	 Catch:{ IOException -> 0x004d }
    L_0x002e:
        r2 = 0;	 Catch:{ IOException -> 0x004d }
        r2 = r1[r2];	 Catch:{ IOException -> 0x004d }
        r3 = "4kU71lN96TJUomD1vOU9lgj9Tw==";	 Catch:{ IOException -> 0x004d }
        r3 = com.tencent.a.a.a.a.h.f(r3);	 Catch:{ IOException -> 0x004d }
        r2 = r2.equals(r3);	 Catch:{ IOException -> 0x004d }
        if (r2 == 0) goto L_0x0018;	 Catch:{ IOException -> 0x004d }
    L_0x003d:
        r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x004d }
        r2 = "read mid from InternalStorage:";	 Catch:{ IOException -> 0x004d }
        r0.<init>(r2);	 Catch:{ IOException -> 0x004d }
        r2 = 1;	 Catch:{ IOException -> 0x004d }
        r3 = r1[r2];	 Catch:{ IOException -> 0x004d }
        r0.append(r3);	 Catch:{ IOException -> 0x004d }
        r0 = r1[r2];	 Catch:{ IOException -> 0x004d }
        goto L_0x004e;
    L_0x004d:
        r0 = 0;
    L_0x004e:
        monitor-exit(r4);	 Catch:{ all -> 0x0050 }
        return r0;	 Catch:{ all -> 0x0050 }
    L_0x0050:
        r0 = move-exception;	 Catch:{ all -> 0x0050 }
        monitor-exit(r4);	 Catch:{ all -> 0x0050 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.a.a.a.a.b.b():java.lang.String");
    }
}
