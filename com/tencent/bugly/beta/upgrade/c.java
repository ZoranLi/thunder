package com.tencent.bugly.beta.upgrade;

import android.text.TextUtils;
import com.tencent.bugly.beta.download.BetaReceiver;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.download.a;
import com.tencent.bugly.beta.global.d;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.beta.global.f;
import com.tencent.bugly.beta.ui.h;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.bg;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.y;

/* compiled from: BUGLY */
public class c {
    public static c a = new c();
    public BetaGrayStrategy b;
    public DownloadTask c;
    public DownloadListener d;
    public UpgradeListener e;
    public UpgradeStateListener f;
    public boolean g;
    public d h;
    public d i;
    public int j;
    private final Object k = new Object();
    private final Object l = new Object();
    private DownloadListener m = new a(3, this, Integer.valueOf(0));
    private a n = null;
    private d o;
    private boolean p;

    public com.tencent.bugly.beta.upgrade.BetaGrayStrategy a(com.tencent.bugly.proguard.y r23) {
        /* JADX: method processing error */
/*
Error: java.util.ConcurrentModificationException
	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:901)
	at java.util.ArrayList$Itr.next(ArrayList.java:851)
	at jadx.core.dex.visitors.ssa.EliminatePhiNodes.replaceMerge(EliminatePhiNodes.java:114)
	at jadx.core.dex.visitors.ssa.EliminatePhiNodes.replaceMergeInstructions(EliminatePhiNodes.java:68)
	at jadx.core.dex.visitors.ssa.EliminatePhiNodes.visit(EliminatePhiNodes.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r22 = this;
        r1 = r22;
        r2 = r23;
        r3 = r1.k;
        monitor-enter(r3);
        r4 = "st.bch";	 Catch:{ all -> 0x0235 }
        r5 = com.tencent.bugly.beta.upgrade.BetaGrayStrategy.CREATOR;	 Catch:{ all -> 0x0235 }
        r4 = com.tencent.bugly.beta.global.a.a(r4, r5);	 Catch:{ all -> 0x0235 }
        r4 = (com.tencent.bugly.beta.upgrade.BetaGrayStrategy) r4;	 Catch:{ all -> 0x0235 }
        r5 = 0;	 Catch:{ all -> 0x0235 }
        if (r4 == 0) goto L_0x001e;	 Catch:{ all -> 0x0235 }
    L_0x0014:
        r6 = r4.a;	 Catch:{ all -> 0x0235 }
        if (r6 != 0) goto L_0x001e;	 Catch:{ all -> 0x0235 }
    L_0x0018:
        r4 = "st.bch";	 Catch:{ all -> 0x0235 }
        com.tencent.bugly.beta.global.a.a(r4);	 Catch:{ all -> 0x0235 }
        r4 = r5;	 Catch:{ all -> 0x0235 }
    L_0x001e:
        r6 = 1;	 Catch:{ all -> 0x0235 }
        if (r4 == 0) goto L_0x0053;	 Catch:{ all -> 0x0235 }
    L_0x0021:
        r7 = r4.a;	 Catch:{ all -> 0x0235 }
        if (r7 == 0) goto L_0x0053;	 Catch:{ all -> 0x0235 }
    L_0x0025:
        r7 = r4.a;	 Catch:{ all -> 0x0235 }
        r7 = r7.e;	 Catch:{ all -> 0x0235 }
        r7 = r7.c;	 Catch:{ all -> 0x0235 }
        r8 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x0235 }
        r8 = r8.w;	 Catch:{ all -> 0x0235 }
        if (r7 <= r8) goto L_0x004d;	 Catch:{ all -> 0x0235 }
    L_0x0031:
        r7 = r4.a;	 Catch:{ all -> 0x0235 }
        r7 = r7.n;	 Catch:{ all -> 0x0235 }
        if (r7 != r6) goto L_0x004d;	 Catch:{ all -> 0x0235 }
    L_0x0037:
        r7 = r4.a;	 Catch:{ all -> 0x0235 }
        r7 = r7.f;	 Catch:{ all -> 0x0235 }
        if (r7 == 0) goto L_0x0053;	 Catch:{ all -> 0x0235 }
    L_0x003d:
        r7 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x0235 }
        r7 = r7.v;	 Catch:{ all -> 0x0235 }
        r8 = r4.a;	 Catch:{ all -> 0x0235 }
        r8 = r8.f;	 Catch:{ all -> 0x0235 }
        r8 = r8.a;	 Catch:{ all -> 0x0235 }
        r7 = android.text.TextUtils.equals(r7, r8);	 Catch:{ all -> 0x0235 }
        if (r7 == 0) goto L_0x0053;	 Catch:{ all -> 0x0235 }
    L_0x004d:
        r4 = "st.bch";	 Catch:{ all -> 0x0235 }
        com.tencent.bugly.beta.global.a.a(r4);	 Catch:{ all -> 0x0235 }
        r4 = r5;	 Catch:{ all -> 0x0235 }
    L_0x0053:
        r7 = 2;	 Catch:{ all -> 0x0235 }
        r8 = 0;	 Catch:{ all -> 0x0235 }
        if (r2 == 0) goto L_0x007d;	 Catch:{ all -> 0x0235 }
    L_0x0057:
        r9 = r2.e;	 Catch:{ all -> 0x0235 }
        r9 = r9.c;	 Catch:{ all -> 0x0235 }
        r10 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x0235 }
        r10 = r10.w;	 Catch:{ all -> 0x0235 }
        if (r9 >= r10) goto L_0x007d;	 Catch:{ all -> 0x0235 }
    L_0x0061:
        r9 = "versionCode is too small, discard remote strategy: [new: %d] [current: %d]";	 Catch:{ all -> 0x0235 }
        r10 = new java.lang.Object[r7];	 Catch:{ all -> 0x0235 }
        r2 = r2.e;	 Catch:{ all -> 0x0235 }
        r2 = r2.c;	 Catch:{ all -> 0x0235 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0235 }
        r10[r8] = r2;	 Catch:{ all -> 0x0235 }
        r2 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x0235 }
        r2 = r2.w;	 Catch:{ all -> 0x0235 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0235 }
        r10[r6] = r2;	 Catch:{ all -> 0x0235 }
        com.tencent.bugly.proguard.an.a(r9, r10);	 Catch:{ all -> 0x0235 }
        r2 = r5;	 Catch:{ all -> 0x0235 }
    L_0x007d:
        if (r2 == 0) goto L_0x00e1;	 Catch:{ all -> 0x0235 }
    L_0x007f:
        r9 = r2.n;	 Catch:{ all -> 0x0235 }
        if (r9 != r7) goto L_0x00d1;	 Catch:{ all -> 0x0235 }
    L_0x0083:
        if (r4 == 0) goto L_0x00d1;	 Catch:{ all -> 0x0235 }
    L_0x0085:
        r9 = r4.a;	 Catch:{ all -> 0x0235 }
        if (r9 == 0) goto L_0x00d1;	 Catch:{ all -> 0x0235 }
    L_0x0089:
        r9 = r2.m;	 Catch:{ all -> 0x0235 }
        r9 = android.text.TextUtils.isEmpty(r9);	 Catch:{ all -> 0x0235 }
        if (r9 != 0) goto L_0x00d1;	 Catch:{ all -> 0x0235 }
    L_0x0091:
        r9 = r4.a;	 Catch:{ all -> 0x0235 }
        r9 = r9.m;	 Catch:{ all -> 0x0235 }
        r9 = android.text.TextUtils.isEmpty(r9);	 Catch:{ all -> 0x0235 }
        if (r9 != 0) goto L_0x00d1;	 Catch:{ all -> 0x0235 }
    L_0x009b:
        r9 = r2.m;	 Catch:{ all -> 0x0235 }
        r10 = r4.a;	 Catch:{ all -> 0x0235 }
        r10 = r10.m;	 Catch:{ all -> 0x0235 }
        r9 = android.text.TextUtils.equals(r9, r10);	 Catch:{ all -> 0x0235 }
        if (r9 == 0) goto L_0x00d1;	 Catch:{ all -> 0x0235 }
    L_0x00a7:
        r9 = "callback strategy: %s";	 Catch:{ all -> 0x0235 }
        r10 = new java.lang.Object[r6];	 Catch:{ all -> 0x0235 }
        r11 = r2.m;	 Catch:{ all -> 0x0235 }
        r10[r8] = r11;	 Catch:{ all -> 0x0235 }
        com.tencent.bugly.proguard.an.a(r9, r10);	 Catch:{ all -> 0x0235 }
        r9 = "st.bch";	 Catch:{ all -> 0x0235 }
        com.tencent.bugly.beta.global.a.a(r9);	 Catch:{ all -> 0x0235 }
        r9 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x0235 }
        r9 = r9.p;	 Catch:{ all -> 0x0235 }
        r4 = r4.a;	 Catch:{ all -> 0x0235 }
        r4 = r4.f;	 Catch:{ all -> 0x0235 }
        r4 = r4.b;	 Catch:{ all -> 0x0235 }
        r10 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x0235 }
        r10 = r10.t;	 Catch:{ all -> 0x0235 }
        r10 = r10.getAbsolutePath();	 Catch:{ all -> 0x0235 }
        r4 = r9.a(r4, r10, r5, r5);	 Catch:{ all -> 0x0235 }
        r4.delete(r6);	 Catch:{ all -> 0x0235 }
        r4 = r5;	 Catch:{ all -> 0x0235 }
    L_0x00d1:
        r9 = r2.n;	 Catch:{ all -> 0x0235 }
        if (r9 == r6) goto L_0x00e1;	 Catch:{ all -> 0x0235 }
    L_0x00d5:
        r9 = "invalid strategy: %s";	 Catch:{ all -> 0x0235 }
        r10 = new java.lang.Object[r6];	 Catch:{ all -> 0x0235 }
        r2 = r2.m;	 Catch:{ all -> 0x0235 }
        r10[r8] = r2;	 Catch:{ all -> 0x0235 }
        com.tencent.bugly.proguard.an.a(r9, r10);	 Catch:{ all -> 0x0235 }
        r2 = r5;	 Catch:{ all -> 0x0235 }
    L_0x00e1:
        r9 = 3;	 Catch:{ all -> 0x0235 }
        if (r2 == 0) goto L_0x0222;	 Catch:{ all -> 0x0235 }
    L_0x00e4:
        if (r4 == 0) goto L_0x0138;	 Catch:{ all -> 0x0235 }
    L_0x00e6:
        r10 = r4.a;	 Catch:{ all -> 0x0235 }
        if (r10 == 0) goto L_0x0138;	 Catch:{ all -> 0x0235 }
    L_0x00ea:
        r10 = r2.m;	 Catch:{ all -> 0x0235 }
        r10 = android.text.TextUtils.isEmpty(r10);	 Catch:{ all -> 0x0235 }
        if (r10 != 0) goto L_0x0138;	 Catch:{ all -> 0x0235 }
    L_0x00f2:
        r10 = r4.a;	 Catch:{ all -> 0x0235 }
        r10 = r10.m;	 Catch:{ all -> 0x0235 }
        r10 = android.text.TextUtils.isEmpty(r10);	 Catch:{ all -> 0x0235 }
        if (r10 != 0) goto L_0x0138;	 Catch:{ all -> 0x0235 }
    L_0x00fc:
        r10 = r2.m;	 Catch:{ all -> 0x0235 }
        r11 = r4.a;	 Catch:{ all -> 0x0235 }
        r11 = r11.m;	 Catch:{ all -> 0x0235 }
        r10 = android.text.TextUtils.equals(r10, r11);	 Catch:{ all -> 0x0235 }
        if (r10 == 0) goto L_0x0138;	 Catch:{ all -> 0x0235 }
    L_0x0108:
        r10 = new com.tencent.bugly.beta.upgrade.BetaGrayStrategy;	 Catch:{ all -> 0x0235 }
        r11 = com.tencent.bugly.proguard.ap.a(r4);	 Catch:{ all -> 0x0235 }
        r11 = com.tencent.bugly.proguard.ap.d(r11);	 Catch:{ all -> 0x0235 }
        r10.<init>(r11);	 Catch:{ all -> 0x0235 }
        r11 = "same strategyId:[new: %s] [current: %s] keep has popup times: %d, interval: %d";	 Catch:{ all -> 0x0235 }
        r12 = 4;	 Catch:{ all -> 0x0235 }
        r12 = new java.lang.Object[r12];	 Catch:{ all -> 0x0235 }
        r13 = r2.m;	 Catch:{ all -> 0x0235 }
        r12[r8] = r13;	 Catch:{ all -> 0x0235 }
        r13 = r4.a;	 Catch:{ all -> 0x0235 }
        r13 = r13.m;	 Catch:{ all -> 0x0235 }
        r12[r6] = r13;	 Catch:{ all -> 0x0235 }
        r13 = r10.b;	 Catch:{ all -> 0x0235 }
        r13 = java.lang.Integer.valueOf(r13);	 Catch:{ all -> 0x0235 }
        r12[r7] = r13;	 Catch:{ all -> 0x0235 }
        r13 = r2.i;	 Catch:{ all -> 0x0235 }
        r13 = java.lang.Long.valueOf(r13);	 Catch:{ all -> 0x0235 }
        r12[r9] = r13;	 Catch:{ all -> 0x0235 }
        com.tencent.bugly.proguard.an.a(r11, r12);	 Catch:{ all -> 0x0235 }
        goto L_0x013d;	 Catch:{ all -> 0x0235 }
    L_0x0138:
        r10 = new com.tencent.bugly.beta.upgrade.BetaGrayStrategy;	 Catch:{ all -> 0x0235 }
        r10.<init>();	 Catch:{ all -> 0x0235 }
    L_0x013d:
        r10.a = r2;	 Catch:{ all -> 0x0235 }
        r11 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0235 }
        r10.e = r11;	 Catch:{ all -> 0x0235 }
        if (r4 == 0) goto L_0x01e8;	 Catch:{ all -> 0x0235 }
    L_0x0147:
        r11 = r4.a;	 Catch:{ all -> 0x0235 }
        r11 = r11.f;	 Catch:{ all -> 0x0235 }
        r11 = r11.b;	 Catch:{ all -> 0x0235 }
        r12 = r2.f;	 Catch:{ all -> 0x0235 }
        r12 = r12.b;	 Catch:{ all -> 0x0235 }
        r11 = r11.equals(r12);	 Catch:{ all -> 0x0235 }
        if (r11 != 0) goto L_0x01aa;	 Catch:{ all -> 0x0235 }
    L_0x0157:
        r11 = r1.c;	 Catch:{ all -> 0x0235 }
        if (r11 != 0) goto L_0x0198;	 Catch:{ all -> 0x0235 }
    L_0x015b:
        r11 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x0235 }
        r11 = r11.p;	 Catch:{ all -> 0x0235 }
        r12 = r4.a;	 Catch:{ all -> 0x0235 }
        r12 = r12.f;	 Catch:{ all -> 0x0235 }
        r12 = r12.b;	 Catch:{ all -> 0x0235 }
        r13 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x0235 }
        r13 = r13.t;	 Catch:{ all -> 0x0235 }
        r13 = r13.getAbsolutePath();	 Catch:{ all -> 0x0235 }
        r5 = r11.a(r12, r13, r5, r5);	 Catch:{ all -> 0x0235 }
        r5.delete(r6);	 Catch:{ all -> 0x0235 }
        r5 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x0235 }
        r5 = r5.t;	 Catch:{ all -> 0x0235 }
        r5 = r5.listFiles();	 Catch:{ all -> 0x0235 }
        r11 = r5.length;	 Catch:{ all -> 0x0235 }
        r12 = r8;	 Catch:{ all -> 0x0235 }
    L_0x017e:
        if (r12 >= r11) goto L_0x01aa;	 Catch:{ all -> 0x0235 }
    L_0x0180:
        r13 = r5[r12];	 Catch:{ all -> 0x0235 }
        r14 = r13.delete();	 Catch:{ all -> 0x0235 }
        if (r14 != 0) goto L_0x0195;	 Catch:{ all -> 0x0235 }
    L_0x0188:
        r14 = "cannot deleteCache file:%s";	 Catch:{ all -> 0x0235 }
        r15 = new java.lang.Object[r6];	 Catch:{ all -> 0x0235 }
        r13 = r13.getAbsolutePath();	 Catch:{ all -> 0x0235 }
        r15[r8] = r13;	 Catch:{ all -> 0x0235 }
        com.tencent.bugly.proguard.an.e(r14, r15);	 Catch:{ all -> 0x0235 }
    L_0x0195:
        r12 = r12 + 1;	 Catch:{ all -> 0x0235 }
        goto L_0x017e;	 Catch:{ all -> 0x0235 }
    L_0x0198:
        r11 = com.tencent.bugly.beta.download.BetaReceiver.netListeners;	 Catch:{ all -> 0x0235 }
        r12 = r1.c;	 Catch:{ all -> 0x0235 }
        r12 = r12.getDownloadUrl();	 Catch:{ all -> 0x0235 }
        r11.remove(r12);	 Catch:{ all -> 0x0235 }
        r11 = r1.c;	 Catch:{ all -> 0x0235 }
        r11.delete(r6);	 Catch:{ all -> 0x0235 }
        r1.c = r5;	 Catch:{ all -> 0x0235 }
    L_0x01aa:
        r4 = r4.a;	 Catch:{ all -> 0x0235 }
        r4 = r4.p;	 Catch:{ all -> 0x0235 }
        if (r4 != r9) goto L_0x01e8;	 Catch:{ all -> 0x0235 }
    L_0x01b0:
        r4 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x0235 }
        r4 = r4.H;	 Catch:{ all -> 0x0235 }
        if (r4 == 0) goto L_0x01c9;	 Catch:{ all -> 0x0235 }
    L_0x01b6:
        r5 = r4.exists();	 Catch:{ all -> 0x0235 }
        if (r5 == 0) goto L_0x01c9;	 Catch:{ all -> 0x0235 }
    L_0x01bc:
        r4 = r4.delete();	 Catch:{ all -> 0x0235 }
        if (r4 == 0) goto L_0x01c9;	 Catch:{ all -> 0x0235 }
    L_0x01c2:
        r4 = "delete tmpPatchFile";	 Catch:{ all -> 0x0235 }
        r5 = new java.lang.Object[r8];	 Catch:{ all -> 0x0235 }
        com.tencent.bugly.proguard.an.a(r4, r5);	 Catch:{ all -> 0x0235 }
    L_0x01c9:
        r4 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x0235 }
        r4 = r4.G;	 Catch:{ all -> 0x0235 }
        if (r4 == 0) goto L_0x01e8;	 Catch:{ all -> 0x0235 }
    L_0x01cf:
        r5 = r4.exists();	 Catch:{ all -> 0x0235 }
        if (r5 == 0) goto L_0x01e8;	 Catch:{ all -> 0x0235 }
    L_0x01d5:
        r4 = r4.delete();	 Catch:{ all -> 0x0235 }
        if (r4 == 0) goto L_0x01e8;	 Catch:{ all -> 0x0235 }
    L_0x01db:
        r4 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x0235 }
        r5 = "";	 Catch:{ all -> 0x0235 }
        r4.L = r5;	 Catch:{ all -> 0x0235 }
        r4 = "delete patchFile";	 Catch:{ all -> 0x0235 }
        r5 = new java.lang.Object[r8];	 Catch:{ all -> 0x0235 }
        com.tencent.bugly.proguard.an.a(r4, r5);	 Catch:{ all -> 0x0235 }
    L_0x01e8:
        r4 = "st.bch";	 Catch:{ all -> 0x0235 }
        com.tencent.bugly.beta.global.a.a(r4, r10);	 Catch:{ all -> 0x0235 }
        r4 = "onUpgradeReceived: %s [type: %d]";	 Catch:{ all -> 0x0235 }
        r5 = new java.lang.Object[r7];	 Catch:{ all -> 0x0235 }
        r5[r8] = r2;	 Catch:{ all -> 0x0235 }
        r7 = r2.g;	 Catch:{ all -> 0x0235 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x0235 }
        r5[r6] = r7;	 Catch:{ all -> 0x0235 }
        com.tencent.bugly.proguard.an.a(r4, r5);	 Catch:{ all -> 0x0235 }
        r4 = com.tencent.bugly.proguard.p.a;	 Catch:{ all -> 0x0235 }
        r5 = new com.tencent.bugly.proguard.w;	 Catch:{ all -> 0x0235 }
        r12 = "rcv";	 Catch:{ all -> 0x0235 }
        r13 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0235 }
        r15 = 0;	 Catch:{ all -> 0x0235 }
        r16 = 0;	 Catch:{ all -> 0x0235 }
        r6 = r2.e;	 Catch:{ all -> 0x0235 }
        r7 = r2.m;	 Catch:{ all -> 0x0235 }
        r2 = r2.p;	 Catch:{ all -> 0x0235 }
        r21 = 0;	 Catch:{ all -> 0x0235 }
        r11 = r5;	 Catch:{ all -> 0x0235 }
        r18 = r6;	 Catch:{ all -> 0x0235 }
        r19 = r7;	 Catch:{ all -> 0x0235 }
        r20 = r2;	 Catch:{ all -> 0x0235 }
        r11.<init>(r12, r13, r15, r16, r18, r19, r20, r21);	 Catch:{ all -> 0x0235 }
        r4.a(r5);	 Catch:{ all -> 0x0235 }
        r5 = r10;	 Catch:{ all -> 0x0235 }
        goto L_0x0233;	 Catch:{ all -> 0x0235 }
    L_0x0222:
        if (r4 == 0) goto L_0x0233;	 Catch:{ all -> 0x0235 }
    L_0x0224:
        r2 = r4.a;	 Catch:{ all -> 0x0235 }
        if (r2 == 0) goto L_0x0233;	 Catch:{ all -> 0x0235 }
    L_0x0228:
        r2 = r4.a;	 Catch:{ all -> 0x0235 }
        r2 = r2.p;	 Catch:{ all -> 0x0235 }
        if (r2 == r9) goto L_0x0233;	 Catch:{ all -> 0x0235 }
    L_0x022e:
        r2 = "st.bch";	 Catch:{ all -> 0x0235 }
        com.tencent.bugly.beta.global.a.a(r2);	 Catch:{ all -> 0x0235 }
    L_0x0233:
        monitor-exit(r3);	 Catch:{ all -> 0x0235 }
        return r5;	 Catch:{ all -> 0x0235 }
    L_0x0235:
        r0 = move-exception;	 Catch:{ all -> 0x0235 }
        r2 = r0;	 Catch:{ all -> 0x0235 }
        monitor-exit(r3);	 Catch:{ all -> 0x0235 }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.upgrade.c.a(com.tencent.bugly.proguard.y):com.tencent.bugly.beta.upgrade.BetaGrayStrategy");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r10, boolean r11, int r12, com.tencent.bugly.proguard.y r13, java.lang.String r14) {
        /*
        r9 = this;
        r14 = r9.k;
        monitor-enter(r14);
        r13 = r9.a(r13);	 Catch:{ all -> 0x01af }
        r9.b = r13;	 Catch:{ all -> 0x01af }
        r9.g = r10;	 Catch:{ all -> 0x01af }
        r13 = r9.e;	 Catch:{ all -> 0x01af }
        r0 = 5;
        r1 = 2;
        r2 = 3;
        r3 = 1;
        r4 = 0;
        if (r13 == 0) goto L_0x0098;
    L_0x0014:
        r13 = "你已放弃让SDK来处理策略";
        r5 = new java.lang.Object[r4];	 Catch:{ all -> 0x01af }
        com.tencent.bugly.proguard.an.a(r13, r5);	 Catch:{ all -> 0x01af }
        r9.j = r2;	 Catch:{ all -> 0x01af }
        r13 = r9.b;	 Catch:{ all -> 0x01af }
        if (r13 != 0) goto L_0x0028;
    L_0x0021:
        r13 = "betaStrategy is null";
        r5 = new java.lang.Object[r4];	 Catch:{ all -> 0x01af }
        com.tencent.bugly.proguard.an.a(r13, r5);	 Catch:{ all -> 0x01af }
    L_0x0028:
        r13 = r9.b;	 Catch:{ all -> 0x01af }
        r5 = 0;
        if (r13 == 0) goto L_0x0053;
    L_0x002d:
        r13 = r9.c;	 Catch:{ all -> 0x01af }
        if (r13 != 0) goto L_0x0053;
    L_0x0031:
        r13 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x01af }
        r13 = r13.p;	 Catch:{ all -> 0x01af }
        r6 = r9.b;	 Catch:{ all -> 0x01af }
        r6 = r6.a;	 Catch:{ all -> 0x01af }
        r6 = r6.f;	 Catch:{ all -> 0x01af }
        r6 = r6.b;	 Catch:{ all -> 0x01af }
        r7 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x01af }
        r7 = r7.t;	 Catch:{ all -> 0x01af }
        r7 = r7.getAbsolutePath();	 Catch:{ all -> 0x01af }
        r8 = r9.b;	 Catch:{ all -> 0x01af }
        r8 = r8.a;	 Catch:{ all -> 0x01af }
        r8 = r8.f;	 Catch:{ all -> 0x01af }
        r8 = r8.a;	 Catch:{ all -> 0x01af }
        r13 = r13.a(r6, r7, r5, r8);	 Catch:{ all -> 0x01af }
        r9.c = r13;	 Catch:{ all -> 0x01af }
    L_0x0053:
        r13 = r9.c;	 Catch:{ all -> 0x01af }
        if (r13 != 0) goto L_0x006a;
    L_0x0057:
        r13 = "用户自定义activity，创建task失败 [strategy:%s]";
        r6 = new java.lang.Object[r3];	 Catch:{ all -> 0x01af }
        r7 = r9.b;	 Catch:{ all -> 0x01af }
        r6[r4] = r7;	 Catch:{ all -> 0x01af }
        com.tencent.bugly.proguard.an.a(r13, r6);	 Catch:{ all -> 0x01af }
        r9.b = r5;	 Catch:{ all -> 0x01af }
        r13 = "st.bch";
        com.tencent.bugly.beta.global.a.a(r13);	 Catch:{ all -> 0x01af }
        goto L_0x0071;
    L_0x006a:
        r13 = r9.c;	 Catch:{ all -> 0x01af }
        r5 = r9.m;	 Catch:{ all -> 0x01af }
        r13.addListener(r5);	 Catch:{ all -> 0x01af }
    L_0x0071:
        r13 = new com.tencent.bugly.beta.global.d;	 Catch:{ all -> 0x01af }
        r5 = 16;
        r6 = new java.lang.Object[r0];	 Catch:{ all -> 0x01af }
        r7 = r9.e;	 Catch:{ all -> 0x01af }
        r6[r4] = r7;	 Catch:{ all -> 0x01af }
        r7 = java.lang.Integer.valueOf(r12);	 Catch:{ all -> 0x01af }
        r6[r3] = r7;	 Catch:{ all -> 0x01af }
        r7 = r9.b;	 Catch:{ all -> 0x01af }
        r6[r1] = r7;	 Catch:{ all -> 0x01af }
        r7 = java.lang.Boolean.valueOf(r10);	 Catch:{ all -> 0x01af }
        r6[r2] = r7;	 Catch:{ all -> 0x01af }
        r7 = 4;
        r8 = java.lang.Boolean.valueOf(r11);	 Catch:{ all -> 0x01af }
        r6[r7] = r8;	 Catch:{ all -> 0x01af }
        r13.<init>(r5, r6);	 Catch:{ all -> 0x01af }
        com.tencent.bugly.beta.utils.e.a(r13);	 Catch:{ all -> 0x01af }
    L_0x0098:
        r13 = 18;
        if (r12 == 0) goto L_0x00d4;
    L_0x009c:
        if (r10 == 0) goto L_0x00d4;
    L_0x009e:
        if (r11 != 0) goto L_0x00d4;
    L_0x00a0:
        r12 = r9.b;	 Catch:{ all -> 0x01af }
        if (r12 != 0) goto L_0x00d4;
    L_0x00a4:
        r11 = r9.f;	 Catch:{ all -> 0x01af }
        if (r11 == 0) goto L_0x00c4;
    L_0x00a8:
        r11 = new com.tencent.bugly.beta.global.d;	 Catch:{ all -> 0x01af }
        r12 = new java.lang.Object[r2];	 Catch:{ all -> 0x01af }
        r0 = r9.f;	 Catch:{ all -> 0x01af }
        r12[r4] = r0;	 Catch:{ all -> 0x01af }
        r0 = -1;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x01af }
        r12[r3] = r0;	 Catch:{ all -> 0x01af }
        r10 = java.lang.Boolean.valueOf(r10);	 Catch:{ all -> 0x01af }
        r12[r1] = r10;	 Catch:{ all -> 0x01af }
        r11.<init>(r13, r12);	 Catch:{ all -> 0x01af }
        com.tencent.bugly.beta.utils.e.a(r11);	 Catch:{ all -> 0x01af }
        goto L_0x00d2;
    L_0x00c4:
        r10 = new com.tencent.bugly.beta.global.d;	 Catch:{ all -> 0x01af }
        r11 = new java.lang.Object[r3];	 Catch:{ all -> 0x01af }
        r12 = com.tencent.bugly.beta.Beta.strToastCheckUpgradeError;	 Catch:{ all -> 0x01af }
        r11[r4] = r12;	 Catch:{ all -> 0x01af }
        r10.<init>(r0, r11);	 Catch:{ all -> 0x01af }
        com.tencent.bugly.beta.utils.e.a(r10);	 Catch:{ all -> 0x01af }
    L_0x00d2:
        monitor-exit(r14);	 Catch:{ all -> 0x01af }
        return;
    L_0x00d4:
        r12 = r9.b;	 Catch:{ all -> 0x01af }
        if (r12 == 0) goto L_0x017c;
    L_0x00d8:
        r12 = r9.b;	 Catch:{ all -> 0x01af }
        r12 = r12.a;	 Catch:{ all -> 0x01af }
        if (r12 == 0) goto L_0x017c;
    L_0x00de:
        r12 = r9.f;	 Catch:{ all -> 0x01af }
        if (r12 == 0) goto L_0x00fc;
    L_0x00e2:
        r12 = new com.tencent.bugly.beta.global.d;	 Catch:{ all -> 0x01af }
        r0 = new java.lang.Object[r2];	 Catch:{ all -> 0x01af }
        r5 = r9.f;	 Catch:{ all -> 0x01af }
        r0[r4] = r5;	 Catch:{ all -> 0x01af }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ all -> 0x01af }
        r0[r3] = r4;	 Catch:{ all -> 0x01af }
        r4 = java.lang.Boolean.valueOf(r10);	 Catch:{ all -> 0x01af }
        r0[r1] = r4;	 Catch:{ all -> 0x01af }
        r12.<init>(r13, r0);	 Catch:{ all -> 0x01af }
        com.tencent.bugly.beta.utils.e.a(r12);	 Catch:{ all -> 0x01af }
    L_0x00fc:
        r12 = r9.e;	 Catch:{ all -> 0x01af }
        if (r12 == 0) goto L_0x0102;
    L_0x0100:
        monitor-exit(r14);	 Catch:{ all -> 0x01af }
        return;
    L_0x0102:
        if (r10 != 0) goto L_0x015f;
    L_0x0104:
        r12 = r9.b;	 Catch:{ all -> 0x01af }
        r12 = r12.a;	 Catch:{ all -> 0x01af }
        r12 = r12.g;	 Catch:{ all -> 0x01af }
        if (r12 == r1) goto L_0x015f;
    L_0x010c:
        r12 = r9.b;	 Catch:{ all -> 0x01af }
        r12 = r12.d;	 Catch:{ all -> 0x01af }
        if (r12 == 0) goto L_0x0134;
    L_0x0112:
        r12 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x01af }
        r12 = r12.e;	 Catch:{ all -> 0x01af }
        if (r12 == 0) goto L_0x0134;
    L_0x0118:
        r12 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x01af }
        r12 = r12.s;	 Catch:{ all -> 0x01af }
        r12 = com.tencent.bugly.beta.global.a.a(r12);	 Catch:{ all -> 0x01af }
        if (r12 != r3) goto L_0x012d;
    L_0x0122:
        r12 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x01af }
        r12 = r12.S;	 Catch:{ all -> 0x01af }
        if (r12 == 0) goto L_0x012d;
    L_0x0128:
        r9.c();	 Catch:{ all -> 0x01af }
        monitor-exit(r14);	 Catch:{ all -> 0x01af }
        return;
    L_0x012d:
        if (r11 != 0) goto L_0x0132;
    L_0x012f:
        r9.a(r10);	 Catch:{ all -> 0x01af }
    L_0x0132:
        monitor-exit(r14);	 Catch:{ all -> 0x01af }
        return;
    L_0x0134:
        r12 = r9.b;	 Catch:{ all -> 0x01af }
        r12 = r12.c;	 Catch:{ all -> 0x01af }
        r0 = r9.b;	 Catch:{ all -> 0x01af }
        r0 = r0.a;	 Catch:{ all -> 0x01af }
        r0 = r0.i;	 Catch:{ all -> 0x01af }
        r4 = r12 + r0;
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x01af }
        r0 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1));
        if (r0 > 0) goto L_0x015d;
    L_0x0148:
        r12 = r9.b;	 Catch:{ all -> 0x01af }
        r12 = r12.a;	 Catch:{ all -> 0x01af }
        r12 = r12.h;	 Catch:{ all -> 0x01af }
        r13 = r9.b;	 Catch:{ all -> 0x01af }
        r13 = r13.b;	 Catch:{ all -> 0x01af }
        r12 = r12 - r13;
        if (r12 <= 0) goto L_0x015d;
    L_0x0155:
        r12 = r9.b;	 Catch:{ all -> 0x01af }
        r12 = r12.a;	 Catch:{ all -> 0x01af }
        r12 = r12.g;	 Catch:{ all -> 0x01af }
        if (r12 != r2) goto L_0x015f;
    L_0x015d:
        monitor-exit(r14);	 Catch:{ all -> 0x01af }
        return;
    L_0x015f:
        if (r11 != 0) goto L_0x01ad;
    L_0x0161:
        r11 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x01af }
        r11 = r11.s;	 Catch:{ all -> 0x01af }
        r11 = com.tencent.bugly.beta.global.a.a(r11);	 Catch:{ all -> 0x01af }
        if (r11 != r3) goto L_0x0178;
    L_0x016b:
        r11 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x01af }
        r11 = r11.S;	 Catch:{ all -> 0x01af }
        if (r11 == 0) goto L_0x0178;
    L_0x0171:
        if (r10 != 0) goto L_0x0178;
    L_0x0173:
        r9.c();	 Catch:{ all -> 0x01af }
        monitor-exit(r14);	 Catch:{ all -> 0x01af }
        return;
    L_0x0178:
        r9.a(r10);	 Catch:{ all -> 0x01af }
        goto L_0x01ad;
    L_0x017c:
        r12 = r9.f;	 Catch:{ all -> 0x01af }
        if (r12 == 0) goto L_0x019b;
    L_0x0180:
        r11 = new com.tencent.bugly.beta.global.d;	 Catch:{ all -> 0x01af }
        r12 = new java.lang.Object[r2];	 Catch:{ all -> 0x01af }
        r0 = r9.f;	 Catch:{ all -> 0x01af }
        r12[r4] = r0;	 Catch:{ all -> 0x01af }
        r0 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x01af }
        r12[r3] = r0;	 Catch:{ all -> 0x01af }
        r10 = java.lang.Boolean.valueOf(r10);	 Catch:{ all -> 0x01af }
        r12[r1] = r10;	 Catch:{ all -> 0x01af }
        r11.<init>(r13, r12);	 Catch:{ all -> 0x01af }
        com.tencent.bugly.beta.utils.e.a(r11);	 Catch:{ all -> 0x01af }
        goto L_0x01ad;
    L_0x019b:
        if (r10 == 0) goto L_0x01ad;
    L_0x019d:
        if (r11 != 0) goto L_0x01ad;
    L_0x019f:
        r10 = new com.tencent.bugly.beta.global.d;	 Catch:{ all -> 0x01af }
        r11 = new java.lang.Object[r3];	 Catch:{ all -> 0x01af }
        r12 = com.tencent.bugly.beta.Beta.strToastYourAreTheLatestVersion;	 Catch:{ all -> 0x01af }
        r11[r4] = r12;	 Catch:{ all -> 0x01af }
        r10.<init>(r0, r11);	 Catch:{ all -> 0x01af }
        com.tencent.bugly.beta.utils.e.a(r10);	 Catch:{ all -> 0x01af }
    L_0x01ad:
        monitor-exit(r14);	 Catch:{ all -> 0x01af }
        return;
    L_0x01af:
        r10 = move-exception;
        monitor-exit(r14);	 Catch:{ all -> 0x01af }
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.upgrade.c.a(boolean, boolean, int, com.tencent.bugly.proguard.y, java.lang.String):void");
    }

    private y a() {
        return this.b == null ? null : this.b.a;
    }

    private DownloadTask b() {
        y a = a();
        if (a == null) {
            return null;
        }
        if (this.c == null) {
            this.c = e.E.p.a(a.f.b, e.E.t.getAbsolutePath(), null, this.b.a.f.a);
        }
        return this.c;
    }

    private void c() {
        y a = a();
        if (a != null) {
            if (this.c == null) {
                this.c = b();
            }
            if (this.c != null) {
                com.tencent.bugly.beta.global.a.a("st.bch", this.b);
                BetaReceiver.addTask(this.c);
                if (this.c.getStatus() != 1) {
                    this.c.download();
                } else if (this.g && com.tencent.bugly.beta.global.a.a(e.E.s, this.c.getSaveFile(), a.f.a)) {
                    p.a.a(new w("install", System.currentTimeMillis(), (byte) 0, 0, a.e, a.m, a.p, null));
                } else if (e.E.d) {
                    a(this.g);
                }
            }
        }
    }

    private void a(boolean z) {
        y a = a();
        if (a != null) {
            boolean z2 = false;
            if (System.currentTimeMillis() <= a.a() - 86400000) {
                z = new StringBuilder();
                z.append(System.currentTimeMillis());
                z.append("ms");
                an.e(z.toString(), new Object[0]);
                return;
            }
            f.a.a(e.E.p, a.l);
            if (this.c == null) {
                this.c = b();
            }
            if (this.c != null) {
                if (z || this.c.getStatus() != 2) {
                    this.c.addListener(this.m);
                    if (this.d != null) {
                        this.c.addListener(this.d);
                    }
                    h hVar = h.v;
                    hVar.a(a, this.c);
                    hVar.r = new d(3, this.b, this.c);
                    hVar.s = new d(4, this.b, this.c, Boolean.valueOf(z));
                    this.b.c = System.currentTimeMillis();
                    com.tencent.bugly.beta.global.a.a("st.bch", this.b);
                    if (z) {
                        f.a.a(new d(2, hVar, Boolean.valueOf(z)), (int) true);
                        return;
                    }
                    f fVar = f.a;
                    Object[] objArr = new Object[2];
                    objArr[0] = hVar;
                    if (z || a.g) {
                        z2 = true;
                    }
                    objArr[1] = Boolean.valueOf(z2);
                    fVar.a(new d(2, objArr));
                    return;
                }
                an.a("Task is downloading %s %s", a.m, this.c.getDownloadUrl());
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r14, boolean r15, int r16) {
        /*
        r13 = this;
        r1 = r13;
        r8 = r14;
        r9 = r1.l;
        monitor-enter(r9);
        r2 = "st.bch";
        r3 = com.tencent.bugly.beta.upgrade.BetaGrayStrategy.CREATOR;	 Catch:{ all -> 0x00fb }
        r2 = com.tencent.bugly.beta.global.a.a(r2, r3);	 Catch:{ all -> 0x00fb }
        r2 = (com.tencent.bugly.beta.upgrade.BetaGrayStrategy) r2;	 Catch:{ all -> 0x00fb }
        r3 = 3;
        if (r8 == 0) goto L_0x001f;
    L_0x0012:
        if (r2 == 0) goto L_0x001f;
    L_0x0014:
        r4 = r2.a;	 Catch:{ all -> 0x00fb }
        if (r4 == 0) goto L_0x001f;
    L_0x0018:
        r4 = r2.a;	 Catch:{ all -> 0x00fb }
        r4 = r4.p;	 Catch:{ all -> 0x00fb }
        if (r4 != r3) goto L_0x001f;
    L_0x001e:
        r2 = 0;
    L_0x001f:
        r10 = r2;
        r2 = r1.n;	 Catch:{ all -> 0x00fb }
        r11 = 2;
        r4 = 1;
        r5 = 0;
        if (r2 == 0) goto L_0x005a;
    L_0x0027:
        r2 = r1.n;	 Catch:{ all -> 0x00fb }
        r2 = r2.d;	 Catch:{ all -> 0x00fb }
        if (r2 != 0) goto L_0x005a;
    L_0x002d:
        r2 = r1.p;	 Catch:{ all -> 0x00fb }
        if (r2 == r8) goto L_0x0032;
    L_0x0031:
        goto L_0x005a;
    L_0x0032:
        r2 = r1.n;	 Catch:{ all -> 0x00fb }
        monitor-enter(r2);	 Catch:{ all -> 0x00fb }
        r3 = r1.n;	 Catch:{ all -> 0x0056 }
        r3 = r3.c;	 Catch:{ all -> 0x0056 }
        r6 = java.lang.Boolean.valueOf(r8);	 Catch:{ all -> 0x0056 }
        r3[r5] = r6;	 Catch:{ all -> 0x0056 }
        r3 = r1.n;	 Catch:{ all -> 0x0056 }
        r3 = r3.c;	 Catch:{ all -> 0x0056 }
        r6 = java.lang.Boolean.valueOf(r15);	 Catch:{ all -> 0x0056 }
        r3[r4] = r6;	 Catch:{ all -> 0x0056 }
        monitor-exit(r2);	 Catch:{ all -> 0x0056 }
        r2 = r1.o;	 Catch:{ all -> 0x00fb }
        r2 = r2.b;	 Catch:{ all -> 0x00fb }
        r3 = java.lang.Boolean.valueOf(r5);	 Catch:{ all -> 0x00fb }
        r2[r5] = r3;	 Catch:{ all -> 0x00fb }
        goto L_0x00dd;
    L_0x0056:
        r0 = move-exception;
        r3 = r0;
        monitor-exit(r2);	 Catch:{ all -> 0x0056 }
        throw r3;	 Catch:{ all -> 0x00fb }
    L_0x005a:
        r1.p = r8;	 Catch:{ all -> 0x00fb }
        r2 = r1.n;	 Catch:{ all -> 0x00fb }
        if (r2 == 0) goto L_0x0064;
    L_0x0060:
        r2 = r1.n;	 Catch:{ all -> 0x00fb }
        r2.d = r4;	 Catch:{ all -> 0x00fb }
    L_0x0064:
        r2 = new com.tencent.bugly.beta.upgrade.a;	 Catch:{ all -> 0x00fb }
        r6 = 804; // 0x324 float:1.127E-42 double:3.97E-321;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x00fb }
        r7 = java.lang.Boolean.valueOf(r8);	 Catch:{ all -> 0x00fb }
        r3[r5] = r7;	 Catch:{ all -> 0x00fb }
        r7 = java.lang.Boolean.valueOf(r15);	 Catch:{ all -> 0x00fb }
        r3[r4] = r7;	 Catch:{ all -> 0x00fb }
        r3[r11] = r10;	 Catch:{ all -> 0x00fb }
        r2.<init>(r4, r6, r3);	 Catch:{ all -> 0x00fb }
        r1.n = r2;	 Catch:{ all -> 0x00fb }
        r2 = new com.tencent.bugly.beta.global.d;	 Catch:{ all -> 0x00fb }
        r3 = 12;
        r6 = new java.lang.Object[r11];	 Catch:{ all -> 0x00fb }
        r7 = java.lang.Boolean.valueOf(r5);	 Catch:{ all -> 0x00fb }
        r6[r5] = r7;	 Catch:{ all -> 0x00fb }
        r5 = r1.n;	 Catch:{ all -> 0x00fb }
        r6[r4] = r5;	 Catch:{ all -> 0x00fb }
        r2.<init>(r3, r6);	 Catch:{ all -> 0x00fb }
        r1.o = r2;	 Catch:{ all -> 0x00fb }
        r2 = "";
        r3 = 0;
        if (r10 == 0) goto L_0x00a4;
    L_0x0098:
        r5 = r10.a;	 Catch:{ Throwable -> 0x00d2 }
        if (r5 == 0) goto L_0x00a4;
    L_0x009c:
        r2 = r10.a;	 Catch:{ Throwable -> 0x00d2 }
        r2 = r2.m;	 Catch:{ Throwable -> 0x00d2 }
        r3 = r10.a;	 Catch:{ Throwable -> 0x00d2 }
        r3 = r3.o;	 Catch:{ Throwable -> 0x00d2 }
    L_0x00a4:
        r5 = r3;
        r4 = r2;
        r7 = new java.util.HashMap;	 Catch:{ Throwable -> 0x00d2 }
        r7.<init>();	 Catch:{ Throwable -> 0x00d2 }
        r2 = "G16";
        r3 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Throwable -> 0x00d2 }
        r3 = r3.L;	 Catch:{ Throwable -> 0x00d2 }
        r7.put(r2, r3);	 Catch:{ Throwable -> 0x00d2 }
        r12 = new com.tencent.bugly.proguard.z;	 Catch:{ Throwable -> 0x00d2 }
        r2 = r12;
        r3 = r8;
        r2.<init>(r3, r4, r5, r7);	 Catch:{ Throwable -> 0x00d2 }
        r4 = com.tencent.bugly.proguard.ah.a(r12);	 Catch:{ Throwable -> 0x00d2 }
        r2 = com.tencent.bugly.beta.upgrade.b.a;	 Catch:{ Throwable -> 0x00d2 }
        r3 = 804; // 0x324 float:1.127E-42 double:3.97E-321;
        r5 = r1.n;	 Catch:{ Throwable -> 0x00d2 }
        r6 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Throwable -> 0x00d2 }
        r6 = r6.F;	 Catch:{ Throwable -> 0x00d2 }
        r6 = r6.a;	 Catch:{ Throwable -> 0x00d2 }
        r7 = r6.e;	 Catch:{ Throwable -> 0x00d2 }
        r6 = r8;
        r2.a(r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x00d2 }
        goto L_0x00dd;
    L_0x00d2:
        r0 = move-exception;
        r2 = r0;
        r3 = com.tencent.bugly.proguard.an.b(r2);	 Catch:{ all -> 0x00fb }
        if (r3 != 0) goto L_0x00dd;
    L_0x00da:
        r2.printStackTrace();	 Catch:{ all -> 0x00fb }
    L_0x00dd:
        if (r8 == 0) goto L_0x00e1;
    L_0x00df:
        if (r15 == 0) goto L_0x00ed;
    L_0x00e1:
        if (r10 == 0) goto L_0x00f9;
    L_0x00e3:
        r2 = r10.a;	 Catch:{ all -> 0x00fb }
        if (r2 == 0) goto L_0x00f9;
    L_0x00e7:
        r2 = r10.a;	 Catch:{ all -> 0x00fb }
        r2 = r2.p;	 Catch:{ all -> 0x00fb }
        if (r2 != r11) goto L_0x00f9;
    L_0x00ed:
        r2 = r1.o;	 Catch:{ all -> 0x00fb }
        com.tencent.bugly.beta.utils.e.b(r2);	 Catch:{ all -> 0x00fb }
        r2 = r1.o;	 Catch:{ all -> 0x00fb }
        r3 = 6000; // 0x1770 float:8.408E-42 double:2.9644E-320;
        com.tencent.bugly.beta.utils.e.a(r2, r3);	 Catch:{ all -> 0x00fb }
    L_0x00f9:
        monitor-exit(r9);	 Catch:{ all -> 0x00fb }
        return;
    L_0x00fb:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r9);	 Catch:{ all -> 0x00fb }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.upgrade.c.a(boolean, boolean, int):void");
    }

    public void a(bg bgVar) {
        if (e.E.F == null) {
            e.E.F = new BetaUploadStrategy();
        }
        if (bgVar != null) {
            if (e.E.F.b != bgVar.h) {
                e.E.F.b = bgVar.h;
                e.E.F.a.b = bgVar.b;
                e.E.F.a.c = bgVar.c;
                e.E.F.a.h = bgVar.h;
                if (ap.c(bgVar.d)) {
                    e.E.F.a.d = bgVar.d;
                }
                if (ap.c(bgVar.e)) {
                    e.E.F.a.e = bgVar.e;
                }
                if (!(bgVar.f == null || TextUtils.isEmpty(bgVar.f.a))) {
                    e.E.F.a.f.a = bgVar.f.a;
                }
                if (bgVar.g != null && bgVar.g.size() > 0) {
                    e.E.F.a.g = bgVar.g;
                }
                if (ap.c(bgVar.i)) {
                    e.E.F.a.i = bgVar.i;
                }
                if (ap.c(bgVar.j)) {
                    e.E.F.a.j = bgVar.j;
                }
                com.tencent.bugly.beta.global.a.a("us.bch", e.E.F);
            }
        }
    }
}
