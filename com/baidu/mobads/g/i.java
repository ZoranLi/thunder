package com.baidu.mobads.g;

import android.os.Handler;
import android.os.Looper;

class i extends Handler {
    final /* synthetic */ g a;

    i(g gVar, Looper looper) {
        this.a = gVar;
        super(looper);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleMessage(android.os.Message r8) {
        /*
        r7 = this;
        r0 = r8.getData();
        r1 = "CODE";
        r0 = r0.getString(r1);
        r8 = r8.getData();
        r1 = "APK_INFO";
        r8 = r8.getParcelable(r1);
        r8 = (com.baidu.mobads.g.e) r8;
        r1 = "OK";
        r1 = r1.equals(r0);
        r2 = 2;
        r3 = 1;
        r4 = 0;
        if (r1 == 0) goto L_0x00b6;
    L_0x0021:
        r0 = new com.baidu.mobads.g.b;
        r1 = r8.e();
        r5 = r7.a;
        r5 = r5.l;
        r0.<init>(r1, r5, r8);
        r1 = r7.a;	 Catch:{ a -> 0x0085 }
        r1 = r1.g;	 Catch:{ a -> 0x0085 }
        r5 = com.baidu.mobads.g.g.f;	 Catch:{ a -> 0x0085 }
        if (r1 != r5) goto L_0x006e;
    L_0x0038:
        r0.a();	 Catch:{ a -> 0x0085 }
        r1 = com.baidu.mobads.g.g.f();	 Catch:{ a -> 0x0085 }
        r0.a(r1);	 Catch:{ a -> 0x0085 }
        r1 = com.baidu.mobads.g.g.b;	 Catch:{ a -> 0x0085 }
        if (r1 == 0) goto L_0x004e;
    L_0x0046:
        r1 = com.baidu.mobads.g.g.b;	 Catch:{ a -> 0x0085 }
        r5 = r8.b();	 Catch:{ a -> 0x0085 }
        r1.a = r5;	 Catch:{ a -> 0x0085 }
    L_0x004e:
        r8 = r7.a;	 Catch:{ a -> 0x0085 }
        r8.k();	 Catch:{ a -> 0x0085 }
        r8 = r7.a;	 Catch:{ a -> 0x0085 }
        r8 = r8.n;	 Catch:{ a -> 0x0085 }
        if (r8 == 0) goto L_0x007f;
    L_0x005b:
        r8 = r7.a;	 Catch:{ a -> 0x0085 }
        r8.n = r4;	 Catch:{ a -> 0x0085 }
        r8 = r7.a;	 Catch:{ a -> 0x0085 }
        r1 = r7.a;	 Catch:{ a -> 0x0085 }
        r1 = r1.p();	 Catch:{ a -> 0x0085 }
        r5 = "load remote file just downloaded";
        r8.a(r1, r5);	 Catch:{ a -> 0x0085 }
        goto L_0x007f;
    L_0x006e:
        r8 = r7.a;	 Catch:{ a -> 0x0085 }
        r8.a(r0);	 Catch:{ a -> 0x0085 }
        r8 = com.baidu.mobads.g.g.f();	 Catch:{ a -> 0x0085 }
        r0.a(r8);	 Catch:{ a -> 0x0085 }
        r8 = r7.a;	 Catch:{ a -> 0x0085 }
        r8.a(r3);	 Catch:{ a -> 0x0085 }
    L_0x007f:
        r0.delete();
        return;
    L_0x0083:
        r8 = move-exception;
        goto L_0x00b2;
    L_0x0085:
        r8 = move-exception;
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0083 }
        r5 = "download apk file failed: ";
        r1.<init>(r5);	 Catch:{ all -> 0x0083 }
        r8 = r8.toString();	 Catch:{ all -> 0x0083 }
        r1.append(r8);	 Catch:{ all -> 0x0083 }
        r8 = r1.toString();	 Catch:{ all -> 0x0083 }
        r1 = r7.a;	 Catch:{ all -> 0x0083 }
        r1.a(r4);	 Catch:{ all -> 0x0083 }
        r1 = r7.a;	 Catch:{ all -> 0x0083 }
        r1 = r1.m;	 Catch:{ all -> 0x0083 }
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0083 }
        r5 = "XAdApkLoader";
        r2[r4] = r5;	 Catch:{ all -> 0x0083 }
        r2[r3] = r8;	 Catch:{ all -> 0x0083 }
        r1.e(r2);	 Catch:{ all -> 0x0083 }
        r0.delete();
        return;
    L_0x00b2:
        r0.delete();
        throw r8;
    L_0x00b6:
        r8 = r7.a;
        r8 = r8.m;
        r1 = new java.lang.Object[r2];
        r2 = "XAdApkLoader";
        r1[r4] = r2;
        r2 = new java.lang.StringBuilder;
        r5 = "mOnApkDownloadCompleted: download failed, code: ";
        r2.<init>(r5);
        r2.append(r0);
        r0 = r2.toString();
        r1[r3] = r0;
        r8.e(r1);
        r8 = r7.a;
        r8.a(r4);
        r8 = r7.a;
        r8 = r8.n;
        if (r8 == 0) goto L_0x00ee;
    L_0x00e2:
        r8 = r7.a;
        r8.n = r4;
        r8 = r7.a;
        r0 = "Refused to download remote for version...";
        r8.a(r4, r0);
    L_0x00ee:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.g.i.handleMessage(android.os.Message):void");
    }
}
