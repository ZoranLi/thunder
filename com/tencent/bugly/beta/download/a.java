package com.tencent.bugly.beta.download;

import com.tencent.bugly.beta.ui.h;

/* compiled from: BUGLY */
public class a implements DownloadListener {
    final int a;
    final Object[] b;

    public void onCompleted(com.tencent.bugly.beta.download.DownloadTask r24) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r23 = this;
        r1 = r23;
        r2 = r24;
        r3 = r1.a;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = 0;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r5 = 2;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r6 = 2080; // 0x820 float:2.915E-42 double:1.0277E-320;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r7 = 0;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r8 = 1;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        switch(r3) {
            case 1: goto L_0x0242;
            case 2: goto L_0x0238;
            case 3: goto L_0x011d;
            case 4: goto L_0x0011;
            default: goto L_0x000f;
        };	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x000f:
        goto L_0x02ee;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x0011:
        r3 = r1.b;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3 = r3[r7];	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3 = (com.tencent.bugly.proguard.q) r3;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r9 = r1.b;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r9 = r9[r8];	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r9 = (java.lang.Integer) r9;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r10 = r3.b;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        if (r10 == 0) goto L_0x011c;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x0021:
        r11 = r10.a;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        if (r11 != 0) goto L_0x0027;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x0025:
        goto L_0x011c;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x0027:
        r11 = "patch download success !!!";	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r12 = new java.lang.Object[r7];	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        com.tencent.bugly.proguard.an.a(r11, r12);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r11 = r24.getSaveFile();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r12 = r10.a;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r12 = r12.f;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r12 = r12.a;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r13 = "SHA";	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r12 = com.tencent.bugly.beta.global.a.a(r11, r12, r13);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        if (r12 == 0) goto L_0x00b8;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x0040:
        r2 = r1.b;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2[r8] = r4;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2 = r2.H;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2 = com.tencent.bugly.beta.global.a.a(r11, r2);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        if (r2 == 0) goto L_0x00a7;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x0052:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = "copy ";	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2.<init>(r4);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = r11.getAbsolutePath();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2.append(r4);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = " to ";	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2.append(r4);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = r4.H;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = r4.getAbsolutePath();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2.append(r4);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = " success!";	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2.append(r4);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2 = r2.toString();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = new java.lang.Object[r7];	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        com.tencent.bugly.proguard.an.c(r2, r4);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2 = r3.c;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        if (r2 == 0) goto L_0x008e;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x0082:
        r2 = "delete temp file";	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = new java.lang.Object[r7];	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        com.tencent.bugly.proguard.an.c(r2, r4);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2 = r3.c;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2.delete(r8);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x008e:
        r2 = "UPLOAD_PATCH_RESULT";	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        com.tencent.bugly.beta.global.a.a(r2, r7);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2 = com.tencent.bugly.beta.tinker.TinkerManager.getInstance();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3 = r3.H;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3 = r3.getAbsolutePath();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = r4.U;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2.onDownloadSuccess(r3, r4);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        return;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x00a7:
        r2 = "copy file failed";	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3 = new java.lang.Object[r7];	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        com.tencent.bugly.proguard.an.a(r2, r3);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2 = com.tencent.bugly.beta.tinker.TinkerManager.getInstance();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3 = "copy file failure.";	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2.onDownloadFailure(r3);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        return;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x00b8:
        r11 = r9.intValue();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        if (r11 >= r5) goto L_0x0101;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x00be:
        r5 = r1.b;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r6 = r9.intValue();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r6 = r6 + r8;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r5[r8] = r6;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2.delete(r8);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2 = r2.p;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r5 = r10.a;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r5 = r5.f;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r5 = r5.b;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r6 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r6 = r6.t;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r6 = r6.getAbsolutePath();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r8 = r10.a;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r8 = r8.f;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r8 = r8.b;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2 = r2.a(r5, r6, r4, r8);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3.c = r2;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2 = r3.c;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2.setNeededNotify(r7);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2 = r3.c;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2.addListener(r1);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2 = r3.c;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        com.tencent.bugly.beta.download.BetaReceiver.addTask(r2);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2 = r3.c;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2.download();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        return;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x0101:
        r3 = r1.b;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3[r8] = r4;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3 = "file sha1 verify fail";	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r1.onFailed(r2, r6, r3);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2.delete(r8);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2 = com.tencent.bugly.beta.tinker.TinkerManager.getInstance();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3 = "retry download patch too many times.";	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2.onDownloadFailure(r3);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        goto L_0x02ee;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x011c:
        return;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x011d:
        r3 = r1.b;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3 = r3[r7];	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3 = (com.tencent.bugly.beta.upgrade.c) r3;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r9 = r3.b;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        if (r9 == 0) goto L_0x0237;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x0127:
        r10 = r9.a;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        if (r10 != 0) goto L_0x012d;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x012b:
        goto L_0x0237;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x012d:
        r10 = r3.f;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        if (r10 == 0) goto L_0x0138;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x0131:
        r10 = r3.f;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r11 = r3.g;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r10.onDownloadCompleted(r11);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x0138:
        r10 = "apk download completed";	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r11 = new java.lang.Object[r7];	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        com.tencent.bugly.proguard.an.a(r10, r11);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r10 = com.tencent.bugly.proguard.p.a;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r15 = new com.tencent.bugly.proguard.w;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r12 = "download";	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r13 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r16 = 0;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r17 = r24.getCostTime();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r11 = r9.a;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r11 = r11.e;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = r9.a;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = r4.m;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r6 = r9.a;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r6 = r6.p;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r21 = 0;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r19 = r11;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r11 = r15;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r5 = r15;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r15 = r16;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r16 = r17;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r18 = r19;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r19 = r4;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r20 = r6;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r11.<init>(r12, r13, r15, r16, r18, r19, r20, r21);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r10.a(r5);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = r24.getSaveFile();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r5 = r1.b;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r5 = r5[r8];	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r5 = (java.lang.Integer) r5;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r6 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r6 = r6.s;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r10 = r9.a;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r10 = r10.f;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r10 = r10.a;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = com.tencent.bugly.beta.global.a.a(r6, r4, r10);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        if (r4 == 0) goto L_0x01bc;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x018b:
        r2 = r1.b;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2[r8] = r3;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2 = com.tencent.bugly.proguard.p.a;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3 = new com.tencent.bugly.proguard.w;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r11 = "install";	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r14 = 0;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r15 = 0;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = r9.a;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = r4.e;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r5 = r9.a;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r5 = r5.m;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r6 = r9.a;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r6 = r6.p;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r20 = 0;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r10 = r3;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r17 = r4;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r18 = r5;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r19 = r6;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r10.<init>(r11, r12, r14, r15, r17, r18, r19, r20);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2.a(r3);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        return;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x01bc:
        r4 = r5.intValue();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r6 = 2;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        if (r4 >= r6) goto L_0x0224;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x01c3:
        r4 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r6 = 24;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        if (r4 < r6) goto L_0x01dc;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x01c9:
        r3 = r1.b;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3[r8] = r4;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3 = "安装失败，请检查您的App是否兼容7.0设备";	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = 2080; // 0x820 float:2.915E-42 double:1.0277E-320;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r1.onFailed(r2, r4, r3);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2.delete(r8);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        return;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x01dc:
        r4 = r1.b;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r5 = r5.intValue();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r5 = r5 + r8;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4[r8] = r5;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2.delete(r8);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2 = r2.p;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = r9.a;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = r4.f;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = r4.b;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r5 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r5 = r5.t;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r5 = r5.getAbsolutePath();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r6 = r9.a;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r6 = r6.f;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r6 = r6.b;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r7 = 0;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2 = r2.a(r4, r5, r7, r6);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3.c = r2;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2 = com.tencent.bugly.beta.ui.h.v;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = r9.a;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r5 = r3.c;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2.a(r4, r5);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2 = r3.c;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2.addListener(r1);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2 = r3.c;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        com.tencent.bugly.beta.download.BetaReceiver.addTask(r2);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2 = r3.c;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2.download();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        return;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x0224:
        r3 = r1.b;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3[r8] = r4;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3 = "file md5 verify fail";	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = 2080; // 0x820 float:2.915E-42 double:1.0277E-320;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r1.onFailed(r2, r4, r3);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2.delete(r8);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        return;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x0237:
        return;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x0238:
        r3 = r1.b;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3 = r3[r7];	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3 = (com.tencent.bugly.beta.ui.h) r3;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3.a(r2);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        return;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x0242:
        r2 = r1.b;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r2 = r2[r7];	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        monitor-enter(r2);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3 = r1.b;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3 = r3[r8];	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3 = (java.util.Map) r3;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = r3.size();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        if (r4 != 0) goto L_0x0255;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x0253:
        monitor-exit(r2);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        return;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x0255:
        r4 = r3.values();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = r4.iterator();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r5 = r7;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x025e:
        r6 = r4.hasNext();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        if (r6 == 0) goto L_0x0273;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x0264:
        r6 = r4.next();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r6 = (com.tencent.bugly.beta.download.DownloadTask) r6;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r6 = r6.getStatus();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        if (r6 != r8) goto L_0x025e;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x0270:
        r5 = r5 + 1;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        goto L_0x025e;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x0273:
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4.<init>();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4.append(r5);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r6 = " has completed";	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4.append(r6);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = r4.toString();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r6 = new java.lang.Object[r7];	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        com.tencent.bugly.proguard.an.c(r4, r6);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = r3.size();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        if (r5 >= r4) goto L_0x0291;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x028f:
        monitor-exit(r2);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        return;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x0291:
        r4 = r3.keySet();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = r4.iterator();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x0299:
        r5 = r4.hasNext();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        if (r5 == 0) goto L_0x02d5;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x029f:
        r5 = r4.next();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r5 = (java.lang.String) r5;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r6 = r3.get(r5);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r6 = (com.tencent.bugly.beta.download.DownloadTask) r6;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r6 = r6.getSaveFile();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        if (r6 == 0) goto L_0x0299;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x02b1:
        r6 = r3.get(r5);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r6 = (com.tencent.bugly.beta.download.DownloadTask) r6;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r6 = r6.getSaveFile();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r6 = r6.exists();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        if (r6 == 0) goto L_0x0299;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x02c1:
        r6 = com.tencent.bugly.beta.global.ResBean.a;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r8 = r3.get(r5);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r8 = (com.tencent.bugly.beta.download.DownloadTask) r8;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r8 = r8.getSaveFile();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r8 = r8.getAbsolutePath();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r6.a(r5, r8);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        goto L_0x0299;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x02d5:
        r3 = "rb.bch";	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r4 = com.tencent.bugly.beta.global.ResBean.a;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        com.tencent.bugly.beta.global.a.a(r3, r4);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3 = r1.b;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3 = r3[r7];	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3 = (com.tencent.bugly.beta.global.f) r3;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3.a();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3.b();	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        monitor-exit(r2);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        return;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x02ea:
        r0 = move-exception;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        r3 = r0;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        monitor-exit(r2);	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
        throw r3;	 Catch:{ all -> 0x02ea, Exception -> 0x02ef }
    L_0x02ee:
        return;
    L_0x02ef:
        r0 = move-exception;
        r2 = r0;
        r3 = com.tencent.bugly.proguard.an.b(r2);
        if (r3 != 0) goto L_0x02fa;
    L_0x02f7:
        r2.printStackTrace();
    L_0x02fa:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.download.a.onCompleted(com.tencent.bugly.beta.download.DownloadTask):void");
    }

    public a(int i, Object... objArr) {
        this.a = i;
        this.b = objArr;
    }

    public void onReceive(DownloadTask downloadTask) {
        if (this.a == 2) {
            ((h) this.b[0]).a(downloadTask);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onFailed(com.tencent.bugly.beta.download.DownloadTask r22, int r23, java.lang.String r24) {
        /*
        r21 = this;
        r1 = r21;
        r2 = r22;
        r3 = r24;
        r4 = r1.a;	 Catch:{ Exception -> 0x00d1 }
        r6 = 2;
        r7 = 0;
        switch(r4) {
            case 1: goto L_0x00b8;
            case 2: goto L_0x00ad;
            case 3: goto L_0x0061;
            case 4: goto L_0x000f;
            default: goto L_0x000d;
        };	 Catch:{ Exception -> 0x00d1 }
    L_0x000d:
        goto L_0x00d0;
    L_0x000f:
        r4 = r1.b;	 Catch:{ Exception -> 0x00d1 }
        r4 = r4[r7];	 Catch:{ Exception -> 0x00d1 }
        r4 = (com.tencent.bugly.proguard.q) r4;	 Catch:{ Exception -> 0x00d1 }
        if (r2 == 0) goto L_0x0049;
    L_0x0017:
        r8 = com.tencent.bugly.proguard.p.a;	 Catch:{ Exception -> 0x00d1 }
        r14 = new com.tencent.bugly.proguard.w;	 Catch:{ Exception -> 0x00d1 }
        r10 = "download";
        r11 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00d1 }
        r13 = 1;
        r15 = r22.getCostTime();	 Catch:{ Exception -> 0x00d1 }
        r2 = r4.b;	 Catch:{ Exception -> 0x00d1 }
        r2 = r2.a;	 Catch:{ Exception -> 0x00d1 }
        r2 = r2.e;	 Catch:{ Exception -> 0x00d1 }
        r9 = r4.b;	 Catch:{ Exception -> 0x00d1 }
        r9 = r9.a;	 Catch:{ Exception -> 0x00d1 }
        r9 = r9.m;	 Catch:{ Exception -> 0x00d1 }
        r4 = r4.b;	 Catch:{ Exception -> 0x00d1 }
        r4 = r4.a;	 Catch:{ Exception -> 0x00d1 }
        r4 = r4.p;	 Catch:{ Exception -> 0x00d1 }
        r19 = 0;
        r17 = r9;
        r9 = r14;
        r5 = r14;
        r14 = r15;
        r16 = r2;
        r18 = r4;
        r9.<init>(r10, r11, r13, r14, r16, r17, r18, r19);	 Catch:{ Exception -> 0x00d1 }
        r8.a(r5);	 Catch:{ Exception -> 0x00d1 }
    L_0x0049:
        r2 = "hotfix download failed：(%d)%s";
        r4 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x00d1 }
        r5 = java.lang.Integer.valueOf(r23);	 Catch:{ Exception -> 0x00d1 }
        r4[r7] = r5;	 Catch:{ Exception -> 0x00d1 }
        r5 = 1;
        r4[r5] = r3;	 Catch:{ Exception -> 0x00d1 }
        com.tencent.bugly.proguard.an.e(r2, r4);	 Catch:{ Exception -> 0x00d1 }
        r2 = com.tencent.bugly.beta.tinker.TinkerManager.getInstance();	 Catch:{ Exception -> 0x00d1 }
        r2.onDownloadFailure(r3);	 Catch:{ Exception -> 0x00d1 }
        goto L_0x00d0;
    L_0x0061:
        r4 = r1.b;	 Catch:{ Exception -> 0x00d1 }
        r4 = r4[r7];	 Catch:{ Exception -> 0x00d1 }
        r4 = (com.tencent.bugly.beta.upgrade.c) r4;	 Catch:{ Exception -> 0x00d1 }
        if (r2 == 0) goto L_0x0099;
    L_0x0069:
        r5 = com.tencent.bugly.proguard.p.a;	 Catch:{ Exception -> 0x00d1 }
        r15 = new com.tencent.bugly.proguard.w;	 Catch:{ Exception -> 0x00d1 }
        r9 = "download";
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00d1 }
        r12 = 1;
        r13 = r22.getCostTime();	 Catch:{ Exception -> 0x00d1 }
        r2 = r4.b;	 Catch:{ Exception -> 0x00d1 }
        r2 = r2.a;	 Catch:{ Exception -> 0x00d1 }
        r2 = r2.e;	 Catch:{ Exception -> 0x00d1 }
        r8 = r4.b;	 Catch:{ Exception -> 0x00d1 }
        r8 = r8.a;	 Catch:{ Exception -> 0x00d1 }
        r8 = r8.m;	 Catch:{ Exception -> 0x00d1 }
        r4 = r4.b;	 Catch:{ Exception -> 0x00d1 }
        r4 = r4.a;	 Catch:{ Exception -> 0x00d1 }
        r4 = r4.p;	 Catch:{ Exception -> 0x00d1 }
        r18 = 0;
        r16 = r8;
        r8 = r15;
        r7 = r15;
        r15 = r2;
        r17 = r4;
        r8.<init>(r9, r10, r12, r13, r15, r16, r17, r18);	 Catch:{ Exception -> 0x00d1 }
        r5.a(r7);	 Catch:{ Exception -> 0x00d1 }
    L_0x0099:
        r2 = "upgrade failed：(%d)%s";
        r4 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x00d1 }
        r5 = java.lang.Integer.valueOf(r23);	 Catch:{ Exception -> 0x00d1 }
        r6 = 0;
        r4[r6] = r5;	 Catch:{ Exception -> 0x00d1 }
        r5 = 1;
        r4[r5] = r3;	 Catch:{ Exception -> 0x00d1 }
        com.tencent.bugly.proguard.an.e(r2, r4);	 Catch:{ Exception -> 0x00d1 }
        r2 = com.tencent.bugly.proguard.an.b;	 Catch:{ Exception -> 0x00d1 }
        return;
    L_0x00ad:
        r3 = r1.b;	 Catch:{ Exception -> 0x00d1 }
        r4 = 0;
        r3 = r3[r4];	 Catch:{ Exception -> 0x00d1 }
        r3 = (com.tencent.bugly.beta.ui.h) r3;	 Catch:{ Exception -> 0x00d1 }
        r3.a(r2);	 Catch:{ Exception -> 0x00d1 }
        return;
    L_0x00b8:
        r2 = r1.b;	 Catch:{ Exception -> 0x00d1 }
        r3 = 0;
        r2 = r2[r3];	 Catch:{ Exception -> 0x00d1 }
        monitor-enter(r2);	 Catch:{ Exception -> 0x00d1 }
        r4 = r1.b;	 Catch:{ all -> 0x00cc }
        r3 = r4[r3];	 Catch:{ all -> 0x00cc }
        r3 = (com.tencent.bugly.beta.global.f) r3;	 Catch:{ all -> 0x00cc }
        r3.a();	 Catch:{ all -> 0x00cc }
        r3.b();	 Catch:{ all -> 0x00cc }
        monitor-exit(r2);	 Catch:{ all -> 0x00cc }
        return;
    L_0x00cc:
        r0 = move-exception;
        r3 = r0;
        monitor-exit(r2);	 Catch:{ all -> 0x00cc }
        throw r3;	 Catch:{ Exception -> 0x00d1 }
    L_0x00d0:
        return;
    L_0x00d1:
        r0 = move-exception;
        r2 = r0;
        r3 = com.tencent.bugly.proguard.an.b(r2);
        if (r3 != 0) goto L_0x00dc;
    L_0x00d9:
        r2.printStackTrace();
    L_0x00dc:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.download.a.onFailed(com.tencent.bugly.beta.download.DownloadTask, int, java.lang.String):void");
    }
}
