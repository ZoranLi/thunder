package com.taobao.accs.a;

import android.content.Context;
import com.taobao.accs.a.a.a;

/* compiled from: Taobao */
final class b implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ a b;

    b(Context context, a aVar) {
        this.a = context;
        this.b = aVar;
    }

    public final void run() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        r0 = 0;
        r1 = 0;
        r2 = com.taobao.accs.a.a.c;	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        if (r2 != 0) goto L_0x000b;	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
    L_0x0008:
        com.taobao.accs.a.a.a();	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
    L_0x000b:
        r2 = com.taobao.accs.a.a.c;	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        if (r2 == 0) goto L_0x0018;	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
    L_0x0011:
        r2 = com.taobao.accs.a.a.c;	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        r2.mkdirs();	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
    L_0x0018:
        r2 = "ElectionServiceUtil";	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        r3 = "saveElectionResult electionFile";	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        r4 = 6;	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        r5 = "path";	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        r4[r0] = r5;	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        r5 = 1;	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        r6 = com.taobao.accs.a.a.d;	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        r6 = r6.getPath();	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        r4[r5] = r6;	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        r5 = 2;	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        r6 = "host";	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        r4[r5] = r6;	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        r5 = 3;	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        r6 = r9.b;	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        r6 = r6.a;	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        r4[r5] = r6;	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        r5 = 4;	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        r6 = "retry";	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        r4[r5] = r6;	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        r5 = 5;	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        r6 = r9.b;	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        r6 = r6.b;	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        r4[r5] = r6;	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        com.taobao.accs.utl.ALog.i(r2, r3, r4);	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        r2 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        r3 = com.taobao.accs.a.a.d;	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        r2.<init>(r3);	 Catch:{ IOException -> 0x0111, Throwable -> 0x00e5, all -> 0x00e2 }
        r1 = new java.util.HashMap;	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r1.<init>();	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r3 = "package";	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r4 = r9.b;	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r4 = r4.a;	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        if (r4 == 0) goto L_0x006a;	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
    L_0x0067:
        r4 = "";	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        goto L_0x006e;	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
    L_0x006a:
        r4 = r9.b;	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r4 = r4.a;	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
    L_0x006e:
        r1.put(r3, r4);	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r3 = "retry";	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r4.<init>();	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r5 = r9.b;	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r5 = r5.b;	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r4.append(r5);	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r4 = r4.toString();	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r1.put(r3, r4);	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r3 = com.taobao.accs.a.a.e;	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r5 = 0;	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        if (r7 <= 0) goto L_0x00b2;	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
    L_0x0090:
        r3 = com.taobao.accs.a.a.e;	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r5 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        if (r7 >= 0) goto L_0x00b2;	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
    L_0x009c:
        r3 = "lastFlushTime";	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r4.<init>();	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r5 = com.taobao.accs.a.a.e;	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r4.append(r5);	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r4 = r4.toString();	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r1.put(r3, r4);	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        goto L_0x00c7;	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
    L_0x00b2:
        r3 = "lastFlushTime";	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r4.<init>();	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r5 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r4.append(r5);	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r4 = r4.toString();	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r1.put(r3, r4);	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
    L_0x00c7:
        r3 = new org.json.JSONObject;	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r3.<init>(r1);	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r1 = r3.toString();	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r3 = "UTF-8";	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r1 = r1.getBytes(r3);	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r2.write(r1);	 Catch:{ IOException -> 0x00e0, Throwable -> 0x00de }
        r2.close();	 Catch:{ Throwable -> 0x00dd }
        return;
    L_0x00dd:
        return;
    L_0x00de:
        r1 = move-exception;
        goto L_0x00e9;
    L_0x00e0:
        r1 = r2;
        goto L_0x0111;
    L_0x00e2:
        r0 = move-exception;
        r2 = r1;
        goto L_0x010b;
    L_0x00e5:
        r2 = move-exception;
        r8 = r2;
        r2 = r1;
        r1 = r8;
    L_0x00e9:
        r3 = "ElectionServiceUtil";	 Catch:{ all -> 0x010a }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010a }
        r5 = "saveElectionResult is error,e=";	 Catch:{ all -> 0x010a }
        r4.<init>(r5);	 Catch:{ all -> 0x010a }
        r1 = r1.toString();	 Catch:{ all -> 0x010a }
        r4.append(r1);	 Catch:{ all -> 0x010a }
        r1 = r4.toString();	 Catch:{ all -> 0x010a }
        r0 = new java.lang.Object[r0];	 Catch:{ all -> 0x010a }
        com.taobao.accs.utl.ALog.e(r3, r1, r0);	 Catch:{ all -> 0x010a }
        if (r2 == 0) goto L_0x0109;
    L_0x0104:
        r2.close();	 Catch:{ Throwable -> 0x0108 }
        goto L_0x0109;
    L_0x0108:
        return;
    L_0x0109:
        return;
    L_0x010a:
        r0 = move-exception;
    L_0x010b:
        if (r2 == 0) goto L_0x0110;
    L_0x010d:
        r2.close();	 Catch:{ Throwable -> 0x0110 }
    L_0x0110:
        throw r0;
    L_0x0111:
        r2 = new java.io.File;	 Catch:{ Throwable -> 0x016d }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x016d }
        r3.<init>();	 Catch:{ Throwable -> 0x016d }
        r4 = r9.a;	 Catch:{ Throwable -> 0x016d }
        r4 = r4.getFilesDir();	 Catch:{ Throwable -> 0x016d }
        r4 = r4.getPath();	 Catch:{ Throwable -> 0x016d }
        r3.append(r4);	 Catch:{ Throwable -> 0x016d }
        r4 = com.taobao.accs.a.a.d();	 Catch:{ Throwable -> 0x016d }
        r3.append(r4);	 Catch:{ Throwable -> 0x016d }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x016d }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x016d }
        com.taobao.accs.a.a.c = r2;	 Catch:{ Throwable -> 0x016d }
        r2 = "ElectionServiceUtil";	 Catch:{ Throwable -> 0x016d }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x016d }
        r4 = "path invailable, new path=";	 Catch:{ Throwable -> 0x016d }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x016d }
        r4 = com.taobao.accs.a.a.c;	 Catch:{ Throwable -> 0x016d }
        r3.append(r4);	 Catch:{ Throwable -> 0x016d }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x016d }
        r0 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x016d }
        com.taobao.accs.utl.ALog.i(r2, r3, r0);	 Catch:{ Throwable -> 0x016d }
        r0 = new java.io.File;	 Catch:{ Throwable -> 0x016d }
        r2 = com.taobao.accs.a.a.c;	 Catch:{ Throwable -> 0x016d }
        r3 = "accs_election";	 Catch:{ Throwable -> 0x016d }
        r0.<init>(r2, r3);	 Catch:{ Throwable -> 0x016d }
        com.taobao.accs.a.a.d = r0;	 Catch:{ Throwable -> 0x016d }
        r0 = com.taobao.accs.a.a.d;	 Catch:{ Throwable -> 0x016d }
        r0 = r0.getPath();	 Catch:{ Throwable -> 0x016d }
        com.taobao.accs.a.a.a = r0;	 Catch:{ Throwable -> 0x016d }
        if (r1 == 0) goto L_0x016c;	 Catch:{ Throwable -> 0x016d }
    L_0x0169:
        r1.close();	 Catch:{ Throwable -> 0x016d }
    L_0x016c:
        return;
    L_0x016d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.a.b.run():void");
    }
}
