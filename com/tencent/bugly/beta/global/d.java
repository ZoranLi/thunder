package com.tencent.bugly.beta.global;

/* compiled from: BUGLY */
public class d implements Runnable {
    int a;
    public final Object[] b;

    public d(int i, Object... objArr) {
        this.a = i;
        this.b = objArr;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r22 = this;
        r1 = r22;
        r2 = r1.a;	 Catch:{ Exception -> 0x0621 }
        r3 = 0;	 Catch:{ Exception -> 0x0621 }
        r4 = 3;	 Catch:{ Exception -> 0x0621 }
        r5 = 2;	 Catch:{ Exception -> 0x0621 }
        r6 = 1;	 Catch:{ Exception -> 0x0621 }
        r7 = 0;	 Catch:{ Exception -> 0x0621 }
        switch(r2) {
            case 1: goto L_0x04c1;
            case 2: goto L_0x04ad;
            case 3: goto L_0x0440;
            case 4: goto L_0x03e8;
            case 5: goto L_0x03da;
            case 6: goto L_0x03b6;
            case 7: goto L_0x03ac;
            case 8: goto L_0x0387;
            case 9: goto L_0x0341;
            case 10: goto L_0x030c;
            case 11: goto L_0x02c9;
            case 12: goto L_0x027f;
            case 13: goto L_0x01b0;
            case 14: goto L_0x014b;
            case 15: goto L_0x0100;
            case 16: goto L_0x00c7;
            case 17: goto L_0x005a;
            case 18: goto L_0x0027;
            case 19: goto L_0x000e;
            default: goto L_0x000c;
        };	 Catch:{ Exception -> 0x0621 }
    L_0x000c:
        goto L_0x0620;	 Catch:{ Exception -> 0x0621 }
    L_0x000e:
        r2 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r2 = r2[r7];	 Catch:{ Exception -> 0x0621 }
        r2 = (java.lang.Boolean) r2;	 Catch:{ Exception -> 0x0621 }
        r2 = r2.booleanValue();	 Catch:{ Exception -> 0x0621 }
        r3 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r3 = r3[r6];	 Catch:{ Exception -> 0x0621 }
        r3 = (java.lang.Boolean) r3;	 Catch:{ Exception -> 0x0621 }
        r3 = r3.booleanValue();	 Catch:{ Exception -> 0x0621 }
        com.tencent.bugly.beta.Beta.checkUpgrade(r2, r3);	 Catch:{ Exception -> 0x0621 }
        goto L_0x0620;	 Catch:{ Exception -> 0x0621 }
    L_0x0027:
        r2 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r2 = r2[r7];	 Catch:{ Exception -> 0x0621 }
        r2 = (com.tencent.bugly.beta.upgrade.UpgradeStateListener) r2;	 Catch:{ Exception -> 0x0621 }
        r3 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r3 = r3[r6];	 Catch:{ Exception -> 0x0621 }
        r3 = (java.lang.Integer) r3;	 Catch:{ Exception -> 0x0621 }
        r3 = r3.intValue();	 Catch:{ Exception -> 0x0621 }
        r4 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r4 = r4[r5];	 Catch:{ Exception -> 0x0621 }
        r4 = (java.lang.Boolean) r4;	 Catch:{ Exception -> 0x0621 }
        r4 = r4.booleanValue();	 Catch:{ Exception -> 0x0621 }
        switch(r3) {
            case -1: goto L_0x0055;
            case 0: goto L_0x0051;
            case 1: goto L_0x004d;
            case 2: goto L_0x0049;
            case 3: goto L_0x0045;
            default: goto L_0x0044;
        };	 Catch:{ Exception -> 0x0621 }
    L_0x0044:
        goto L_0x0059;	 Catch:{ Exception -> 0x0621 }
    L_0x0045:
        r2.onDownloadCompleted(r4);	 Catch:{ Exception -> 0x0621 }
        goto L_0x0059;	 Catch:{ Exception -> 0x0621 }
    L_0x0049:
        r2.onUpgrading(r4);	 Catch:{ Exception -> 0x0621 }
        return;	 Catch:{ Exception -> 0x0621 }
    L_0x004d:
        r2.onUpgradeNoVersion(r4);	 Catch:{ Exception -> 0x0621 }
        return;	 Catch:{ Exception -> 0x0621 }
    L_0x0051:
        r2.onUpgradeSuccess(r4);	 Catch:{ Exception -> 0x0621 }
        return;	 Catch:{ Exception -> 0x0621 }
    L_0x0055:
        r2.onUpgradeFailed(r4);	 Catch:{ Exception -> 0x0621 }
        return;
    L_0x0059:
        return;
    L_0x005a:
        r2 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Exception -> 0x00b4 }
        r2 = r2.s;	 Catch:{ Exception -> 0x00b4 }
        r2 = r2.getPackageManager();	 Catch:{ Exception -> 0x00b4 }
        if (r2 == 0) goto L_0x007c;	 Catch:{ Exception -> 0x00b4 }
    L_0x0064:
        r3 = new android.content.ComponentName;	 Catch:{ Exception -> 0x00b4 }
        r4 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Exception -> 0x00b4 }
        r4 = r4.s;	 Catch:{ Exception -> 0x00b4 }
        r8 = com.tencent.bugly.beta.ui.BetaActivity.class;	 Catch:{ Exception -> 0x00b4 }
        r8 = r8.getName();	 Catch:{ Exception -> 0x00b4 }
        r3.<init>(r4, r8);	 Catch:{ Exception -> 0x00b4 }
        r4 = r2.getComponentEnabledSetting(r3);	 Catch:{ Exception -> 0x00b4 }
        if (r4 != r5) goto L_0x007c;	 Catch:{ Exception -> 0x00b4 }
    L_0x0079:
        r2.setComponentEnabledSetting(r3, r6, r6);	 Catch:{ Exception -> 0x00b4 }
    L_0x007c:
        r2 = r1.b;	 Catch:{ Exception -> 0x00b4 }
        r2 = r2[r7];	 Catch:{ Exception -> 0x00b4 }
        r2 = (java.util.Map) r2;	 Catch:{ Exception -> 0x00b4 }
        r3 = r1.b;	 Catch:{ Exception -> 0x00b4 }
        r3 = r3[r6];	 Catch:{ Exception -> 0x00b4 }
        r3 = (java.lang.Integer) r3;	 Catch:{ Exception -> 0x00b4 }
        r4 = r1.b;	 Catch:{ Exception -> 0x00b4 }
        r4 = r4[r5];	 Catch:{ Exception -> 0x00b4 }
        r4 = (com.tencent.bugly.beta.ui.b) r4;	 Catch:{ Exception -> 0x00b4 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x00b4 }
        r2 = new android.content.Intent;	 Catch:{ Exception -> 0x00b4 }
        r3 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Exception -> 0x00b4 }
        r3 = r3.s;	 Catch:{ Exception -> 0x00b4 }
        r4 = com.tencent.bugly.beta.ui.BetaActivity.class;	 Catch:{ Exception -> 0x00b4 }
        r2.<init>(r3, r4);	 Catch:{ Exception -> 0x00b4 }
        r3 = "frag";	 Catch:{ Exception -> 0x00b4 }
        r4 = r1.b;	 Catch:{ Exception -> 0x00b4 }
        r4 = r4[r6];	 Catch:{ Exception -> 0x00b4 }
        r4 = (java.lang.Integer) r4;	 Catch:{ Exception -> 0x00b4 }
        r2.putExtra(r3, r4);	 Catch:{ Exception -> 0x00b4 }
        r3 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;	 Catch:{ Exception -> 0x00b4 }
        r2.setFlags(r3);	 Catch:{ Exception -> 0x00b4 }
        r3 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Exception -> 0x00b4 }
        r3 = r3.s;	 Catch:{ Exception -> 0x00b4 }
        r3.startActivity(r2);	 Catch:{ Exception -> 0x00b4 }
        return;
    L_0x00b4:
        r0 = move-exception;
        r2 = r0;
        r3 = "无法正常弹窗，请在AndroidManifest.xml中添加BetaActivity声明：\n<activity\n    android:name=\"com.tencent.bugly.beta.ui.BetaActivity\"\n    android:theme=\"@android:style/Theme.Translucent\" />";	 Catch:{ Exception -> 0x0621 }
        r4 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x0621 }
        com.tencent.bugly.proguard.an.e(r3, r4);	 Catch:{ Exception -> 0x0621 }
        r3 = com.tencent.bugly.proguard.an.b(r2);	 Catch:{ Exception -> 0x0621 }
        if (r3 != 0) goto L_0x00c6;	 Catch:{ Exception -> 0x0621 }
    L_0x00c3:
        r2.printStackTrace();	 Catch:{ Exception -> 0x0621 }
    L_0x00c6:
        return;	 Catch:{ Exception -> 0x0621 }
    L_0x00c7:
        r2 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r2 = r2[r7];	 Catch:{ Exception -> 0x0621 }
        r2 = (com.tencent.bugly.beta.upgrade.UpgradeListener) r2;	 Catch:{ Exception -> 0x0621 }
        r7 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r6 = r7[r6];	 Catch:{ Exception -> 0x0621 }
        r6 = (java.lang.Integer) r6;	 Catch:{ Exception -> 0x0621 }
        r6 = r6.intValue();	 Catch:{ Exception -> 0x0621 }
        r7 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r5 = r7[r5];	 Catch:{ Exception -> 0x0621 }
        r5 = (com.tencent.bugly.beta.upgrade.BetaGrayStrategy) r5;	 Catch:{ Exception -> 0x0621 }
        r7 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r4 = r7[r4];	 Catch:{ Exception -> 0x0621 }
        r4 = (java.lang.Boolean) r4;	 Catch:{ Exception -> 0x0621 }
        r4 = r4.booleanValue();	 Catch:{ Exception -> 0x0621 }
        r7 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r8 = 4;	 Catch:{ Exception -> 0x0621 }
        r7 = r7[r8];	 Catch:{ Exception -> 0x0621 }
        r7 = (java.lang.Boolean) r7;	 Catch:{ Exception -> 0x0621 }
        r7 = r7.booleanValue();	 Catch:{ Exception -> 0x0621 }
        if (r5 != 0) goto L_0x00f5;	 Catch:{ Exception -> 0x0621 }
    L_0x00f4:
        goto L_0x00fc;	 Catch:{ Exception -> 0x0621 }
    L_0x00f5:
        r3 = new com.tencent.bugly.beta.UpgradeInfo;	 Catch:{ Exception -> 0x0621 }
        r5 = r5.a;	 Catch:{ Exception -> 0x0621 }
        r3.<init>(r5);	 Catch:{ Exception -> 0x0621 }
    L_0x00fc:
        r2.onUpgrade(r6, r3, r4, r7);	 Catch:{ Exception -> 0x0621 }
        return;	 Catch:{ Exception -> 0x0621 }
    L_0x0100:
        r2 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r2 = r2[r7];	 Catch:{ Exception -> 0x0621 }
        r2 = (com.tencent.bugly.beta.ui.b) r2;	 Catch:{ Exception -> 0x0621 }
        r2 = r2.b();	 Catch:{ Exception -> 0x0621 }
        if (r2 != 0) goto L_0x0145;	 Catch:{ Exception -> 0x0621 }
    L_0x010c:
        r2 = com.tencent.bugly.beta.ui.g.a();	 Catch:{ Exception -> 0x0621 }
        r3 = com.tencent.bugly.beta.ui.BetaActivity.class;	 Catch:{ Exception -> 0x0621 }
        r3 = r3.getCanonicalName();	 Catch:{ Exception -> 0x0621 }
        r2 = android.text.TextUtils.equals(r2, r3);	 Catch:{ Exception -> 0x0621 }
        if (r2 == 0) goto L_0x011d;	 Catch:{ Exception -> 0x0621 }
    L_0x011c:
        goto L_0x0145;	 Catch:{ Exception -> 0x0621 }
    L_0x011d:
        r2 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r2 = r2[r7];	 Catch:{ Exception -> 0x0621 }
        r2 = (com.tencent.bugly.beta.ui.b) r2;	 Catch:{ Exception -> 0x0621 }
        r3 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r3 = r3[r6];	 Catch:{ Exception -> 0x0621 }
        r3 = (java.lang.Boolean) r3;	 Catch:{ Exception -> 0x0621 }
        r3 = r3.booleanValue();	 Catch:{ Exception -> 0x0621 }
        r6 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r5 = r6[r5];	 Catch:{ Exception -> 0x0621 }
        r5 = (java.lang.Boolean) r5;	 Catch:{ Exception -> 0x0621 }
        r5 = r5.booleanValue();	 Catch:{ Exception -> 0x0621 }
        r6 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r4 = r6[r4];	 Catch:{ Exception -> 0x0621 }
        r4 = (java.lang.Long) r4;	 Catch:{ Exception -> 0x0621 }
        r6 = r4.longValue();	 Catch:{ Exception -> 0x0621 }
        com.tencent.bugly.beta.ui.g.a(r2, r3, r5, r6);	 Catch:{ Exception -> 0x0621 }
        return;	 Catch:{ Exception -> 0x0621 }
    L_0x0145:
        r2 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;	 Catch:{ Exception -> 0x0621 }
        com.tencent.bugly.beta.utils.e.a(r1, r2);	 Catch:{ Exception -> 0x0621 }
        return;	 Catch:{ Exception -> 0x0621 }
    L_0x014b:
        r2 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r2 = r2[r7];	 Catch:{ Exception -> 0x0621 }
        r2 = (com.tencent.bugly.beta.download.DownloadTask) r2;	 Catch:{ Exception -> 0x0621 }
        r3 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r3 = r3[r6];	 Catch:{ Exception -> 0x0621 }
        r3 = (com.tencent.bugly.beta.upgrade.BetaGrayStrategy) r3;	 Catch:{ Exception -> 0x0621 }
        r4 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r4 = r4[r5];	 Catch:{ Exception -> 0x0621 }
        r4 = (java.lang.Boolean) r4;	 Catch:{ Exception -> 0x0621 }
        r4 = r4.booleanValue();	 Catch:{ Exception -> 0x0621 }
        if (r2 == 0) goto L_0x01a8;	 Catch:{ Exception -> 0x0621 }
    L_0x0163:
        if (r3 != 0) goto L_0x0166;	 Catch:{ Exception -> 0x0621 }
    L_0x0165:
        goto L_0x01a8;	 Catch:{ Exception -> 0x0621 }
    L_0x0166:
        r2 = r2.getStatus();	 Catch:{ Exception -> 0x0621 }
        if (r2 == r5) goto L_0x01a7;	 Catch:{ Exception -> 0x0621 }
    L_0x016c:
        r3.d = r7;	 Catch:{ Exception -> 0x0621 }
        r7 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0621 }
        r3.c = r7;	 Catch:{ Exception -> 0x0621 }
        if (r4 != 0) goto L_0x0181;	 Catch:{ Exception -> 0x0621 }
    L_0x0176:
        r2 = r3.a;	 Catch:{ Exception -> 0x0621 }
        r2 = r2.g;	 Catch:{ Exception -> 0x0621 }
        if (r2 == r5) goto L_0x0181;	 Catch:{ Exception -> 0x0621 }
    L_0x017c:
        r2 = r3.b;	 Catch:{ Exception -> 0x0621 }
        r2 = r2 + r6;	 Catch:{ Exception -> 0x0621 }
        r3.b = r2;	 Catch:{ Exception -> 0x0621 }
    L_0x0181:
        r2 = "st.bch";	 Catch:{ Exception -> 0x0621 }
        com.tencent.bugly.beta.global.a.a(r2, r3);	 Catch:{ Exception -> 0x0621 }
        r2 = com.tencent.bugly.proguard.p.a;	 Catch:{ Exception -> 0x0621 }
        r15 = new com.tencent.bugly.proguard.w;	 Catch:{ Exception -> 0x0621 }
        r5 = "pop";	 Catch:{ Exception -> 0x0621 }
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0621 }
        r8 = 2;	 Catch:{ Exception -> 0x0621 }
        r9 = 0;	 Catch:{ Exception -> 0x0621 }
        r4 = r3.a;	 Catch:{ Exception -> 0x0621 }
        r11 = r4.e;	 Catch:{ Exception -> 0x0621 }
        r4 = r3.a;	 Catch:{ Exception -> 0x0621 }
        r12 = r4.m;	 Catch:{ Exception -> 0x0621 }
        r3 = r3.a;	 Catch:{ Exception -> 0x0621 }
        r13 = r3.p;	 Catch:{ Exception -> 0x0621 }
        r14 = 0;	 Catch:{ Exception -> 0x0621 }
        r4 = r15;	 Catch:{ Exception -> 0x0621 }
        r4.<init>(r5, r6, r8, r9, r11, r12, r13, r14);	 Catch:{ Exception -> 0x0621 }
        r2.a(r15);	 Catch:{ Exception -> 0x0621 }
    L_0x01a7:
        return;	 Catch:{ Exception -> 0x0621 }
    L_0x01a8:
        r2 = "strategyTask or betaStrategy is null";	 Catch:{ Exception -> 0x0621 }
        r3 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x0621 }
        com.tencent.bugly.proguard.an.a(r2, r3);	 Catch:{ Exception -> 0x0621 }
        return;	 Catch:{ Exception -> 0x0621 }
    L_0x01b0:
        r2 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r2 = r2[r7];	 Catch:{ Exception -> 0x0621 }
        r2 = (com.tencent.bugly.beta.download.DownloadTask) r2;	 Catch:{ Exception -> 0x0621 }
        r3 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r3 = r3[r6];	 Catch:{ Exception -> 0x0621 }
        r3 = (com.tencent.bugly.beta.upgrade.BetaGrayStrategy) r3;	 Catch:{ Exception -> 0x0621 }
        if (r2 == 0) goto L_0x0277;	 Catch:{ Exception -> 0x0621 }
    L_0x01be:
        if (r3 != 0) goto L_0x01c2;	 Catch:{ Exception -> 0x0621 }
    L_0x01c0:
        goto L_0x0277;	 Catch:{ Exception -> 0x0621 }
    L_0x01c2:
        r4 = r2.getStatus();	 Catch:{ Exception -> 0x0621 }
        switch(r4) {
            case 0: goto L_0x01d0;
            case 1: goto L_0x01d0;
            case 2: goto L_0x01cb;
            case 3: goto L_0x01d0;
            case 4: goto L_0x01d0;
            case 5: goto L_0x01d0;
            default: goto L_0x01c9;
        };	 Catch:{ Exception -> 0x0621 }
    L_0x01c9:
        goto L_0x0276;	 Catch:{ Exception -> 0x0621 }
    L_0x01cb:
        r2.stop();	 Catch:{ Exception -> 0x0621 }
        goto L_0x0276;	 Catch:{ Exception -> 0x0621 }
    L_0x01d0:
        r4 = r3.d;	 Catch:{ Exception -> 0x0621 }
        if (r4 != 0) goto L_0x01e1;	 Catch:{ Exception -> 0x0621 }
    L_0x01d4:
        r3.d = r6;	 Catch:{ Exception -> 0x0621 }
        r7 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0621 }
        r3.c = r7;	 Catch:{ Exception -> 0x0621 }
        r4 = "st.bch";	 Catch:{ Exception -> 0x0621 }
        com.tencent.bugly.beta.global.a.a(r4, r3);	 Catch:{ Exception -> 0x0621 }
    L_0x01e1:
        r4 = r2.getStatus();	 Catch:{ Exception -> 0x0621 }
        if (r4 == r5) goto L_0x0236;	 Catch:{ Exception -> 0x0621 }
    L_0x01e7:
        r4 = r2.getStatus();	 Catch:{ Exception -> 0x0621 }
        if (r4 != r6) goto L_0x0212;	 Catch:{ Exception -> 0x0621 }
    L_0x01ed:
        r4 = com.tencent.bugly.proguard.p.a;	 Catch:{ Exception -> 0x0621 }
        r5 = new com.tencent.bugly.proguard.w;	 Catch:{ Exception -> 0x0621 }
        r8 = "pop";	 Catch:{ Exception -> 0x0621 }
        r9 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0621 }
        r11 = 4;	 Catch:{ Exception -> 0x0621 }
        r12 = 0;	 Catch:{ Exception -> 0x0621 }
        r7 = r3.a;	 Catch:{ Exception -> 0x0621 }
        r14 = r7.e;	 Catch:{ Exception -> 0x0621 }
        r7 = r3.a;	 Catch:{ Exception -> 0x0621 }
        r15 = r7.m;	 Catch:{ Exception -> 0x0621 }
        r7 = r3.a;	 Catch:{ Exception -> 0x0621 }
        r7 = r7.p;	 Catch:{ Exception -> 0x0621 }
        r17 = 0;	 Catch:{ Exception -> 0x0621 }
        r16 = r7;	 Catch:{ Exception -> 0x0621 }
        r7 = r5;	 Catch:{ Exception -> 0x0621 }
        r7.<init>(r8, r9, r11, r12, r14, r15, r16, r17);	 Catch:{ Exception -> 0x0621 }
        r4.a(r5);	 Catch:{ Exception -> 0x0621 }
        goto L_0x0236;	 Catch:{ Exception -> 0x0621 }
    L_0x0212:
        r4 = com.tencent.bugly.proguard.p.a;	 Catch:{ Exception -> 0x0621 }
        r5 = new com.tencent.bugly.proguard.w;	 Catch:{ Exception -> 0x0621 }
        r8 = "pop";	 Catch:{ Exception -> 0x0621 }
        r9 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0621 }
        r11 = 3;	 Catch:{ Exception -> 0x0621 }
        r12 = 0;	 Catch:{ Exception -> 0x0621 }
        r7 = r3.a;	 Catch:{ Exception -> 0x0621 }
        r14 = r7.e;	 Catch:{ Exception -> 0x0621 }
        r7 = r3.a;	 Catch:{ Exception -> 0x0621 }
        r15 = r7.m;	 Catch:{ Exception -> 0x0621 }
        r7 = r3.a;	 Catch:{ Exception -> 0x0621 }
        r7 = r7.p;	 Catch:{ Exception -> 0x0621 }
        r17 = 0;	 Catch:{ Exception -> 0x0621 }
        r16 = r7;	 Catch:{ Exception -> 0x0621 }
        r7 = r5;	 Catch:{ Exception -> 0x0621 }
        r7.<init>(r8, r9, r11, r12, r14, r15, r16, r17);	 Catch:{ Exception -> 0x0621 }
        r4.a(r5);	 Catch:{ Exception -> 0x0621 }
    L_0x0236:
        r4 = r2.getStatus();	 Catch:{ Exception -> 0x0621 }
        if (r4 != r6) goto L_0x0272;	 Catch:{ Exception -> 0x0621 }
    L_0x023c:
        r4 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Exception -> 0x0621 }
        r4 = r4.s;	 Catch:{ Exception -> 0x0621 }
        r5 = r2.getSaveFile();	 Catch:{ Exception -> 0x0621 }
        r6 = r3.a;	 Catch:{ Exception -> 0x0621 }
        r6 = r6.f;	 Catch:{ Exception -> 0x0621 }
        r6 = r6.a;	 Catch:{ Exception -> 0x0621 }
        r4 = com.tencent.bugly.beta.global.a.a(r4, r5, r6);	 Catch:{ Exception -> 0x0621 }
        if (r4 == 0) goto L_0x0272;	 Catch:{ Exception -> 0x0621 }
    L_0x0250:
        r2 = com.tencent.bugly.proguard.p.a;	 Catch:{ Exception -> 0x0621 }
        r15 = new com.tencent.bugly.proguard.w;	 Catch:{ Exception -> 0x0621 }
        r5 = "install";	 Catch:{ Exception -> 0x0621 }
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0621 }
        r8 = 0;	 Catch:{ Exception -> 0x0621 }
        r9 = 0;	 Catch:{ Exception -> 0x0621 }
        r4 = r3.a;	 Catch:{ Exception -> 0x0621 }
        r11 = r4.e;	 Catch:{ Exception -> 0x0621 }
        r4 = r3.a;	 Catch:{ Exception -> 0x0621 }
        r12 = r4.m;	 Catch:{ Exception -> 0x0621 }
        r3 = r3.a;	 Catch:{ Exception -> 0x0621 }
        r13 = r3.p;	 Catch:{ Exception -> 0x0621 }
        r14 = 0;	 Catch:{ Exception -> 0x0621 }
        r4 = r15;	 Catch:{ Exception -> 0x0621 }
        r4.<init>(r5, r6, r8, r9, r11, r12, r13, r14);	 Catch:{ Exception -> 0x0621 }
        r2.a(r15);	 Catch:{ Exception -> 0x0621 }
        return;	 Catch:{ Exception -> 0x0621 }
    L_0x0272:
        r2.download();	 Catch:{ Exception -> 0x0621 }
        return;	 Catch:{ Exception -> 0x0621 }
    L_0x0276:
        return;	 Catch:{ Exception -> 0x0621 }
    L_0x0277:
        r2 = "strategyTask or betaStrategy is null";	 Catch:{ Exception -> 0x0621 }
        r3 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x0621 }
        com.tencent.bugly.proguard.an.a(r2, r3);	 Catch:{ Exception -> 0x0621 }
        return;	 Catch:{ Exception -> 0x0621 }
    L_0x027f:
        r2 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r2 = r2[r7];	 Catch:{ Exception -> 0x0621 }
        r2 = (java.lang.Boolean) r2;	 Catch:{ Exception -> 0x0621 }
        r2 = r2.booleanValue();	 Catch:{ Exception -> 0x0621 }
        r3 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r3 = r3[r6];	 Catch:{ Exception -> 0x0621 }
        r3 = (com.tencent.bugly.beta.upgrade.a) r3;	 Catch:{ Exception -> 0x0621 }
        r4 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r4 = r4[r6];	 Catch:{ Exception -> 0x0621 }
        monitor-enter(r4);	 Catch:{ Exception -> 0x0621 }
        if (r2 != 0) goto L_0x02c5;
    L_0x0296:
        r2 = r3.d;	 Catch:{ all -> 0x02c2 }
        if (r2 != 0) goto L_0x02c5;	 Catch:{ all -> 0x02c2 }
    L_0x029a:
        r2 = r1.b;	 Catch:{ all -> 0x02c2 }
        r5 = java.lang.Boolean.valueOf(r6);	 Catch:{ all -> 0x02c2 }
        r2[r7] = r5;	 Catch:{ all -> 0x02c2 }
        r9 = r3.b;	 Catch:{ all -> 0x02c2 }
        r10 = 0;	 Catch:{ all -> 0x02c2 }
        r11 = 0;	 Catch:{ all -> 0x02c2 }
        r13 = 0;	 Catch:{ all -> 0x02c2 }
        r15 = 0;	 Catch:{ all -> 0x02c2 }
        r16 = "request is not finished";	 Catch:{ all -> 0x02c2 }
        r8 = r3;	 Catch:{ all -> 0x02c2 }
        r8.a(r9, r10, r11, r13, r15, r16);	 Catch:{ all -> 0x02c2 }
        r2 = r3.c;	 Catch:{ all -> 0x02c2 }
        r5 = java.lang.Boolean.valueOf(r6);	 Catch:{ all -> 0x02c2 }
        r2[r6] = r5;	 Catch:{ all -> 0x02c2 }
        r3.d = r7;	 Catch:{ all -> 0x02c2 }
        r2 = "request is not finished";	 Catch:{ all -> 0x02c2 }
        r3 = new java.lang.Object[r7];	 Catch:{ all -> 0x02c2 }
        com.tencent.bugly.proguard.an.a(r2, r3);	 Catch:{ all -> 0x02c2 }
        goto L_0x02c5;	 Catch:{ all -> 0x02c2 }
    L_0x02c2:
        r0 = move-exception;	 Catch:{ all -> 0x02c2 }
        r2 = r0;	 Catch:{ all -> 0x02c2 }
        goto L_0x02c7;	 Catch:{ all -> 0x02c2 }
    L_0x02c5:
        monitor-exit(r4);	 Catch:{ all -> 0x02c2 }
        return;	 Catch:{ all -> 0x02c2 }
    L_0x02c7:
        monitor-exit(r4);	 Catch:{ all -> 0x02c2 }
        throw r2;	 Catch:{ Exception -> 0x0621 }
    L_0x02c9:
        r2 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r2 = r2[r7];	 Catch:{ Exception -> 0x0621 }
        r2 = (com.tencent.bugly.beta.ui.b) r2;	 Catch:{ Exception -> 0x0621 }
        r3 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r3 = r3[r6];	 Catch:{ Exception -> 0x0621 }
        r3 = (java.lang.Boolean) r3;	 Catch:{ Exception -> 0x0621 }
        r3 = r3.booleanValue();	 Catch:{ Exception -> 0x0621 }
        r6 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r5 = r6[r5];	 Catch:{ Exception -> 0x0621 }
        r5 = (java.lang.Boolean) r5;	 Catch:{ Exception -> 0x0621 }
        r5 = r5.booleanValue();	 Catch:{ Exception -> 0x0621 }
        r6 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r4 = r6[r4];	 Catch:{ Exception -> 0x0621 }
        r4 = (java.lang.Long) r4;	 Catch:{ Exception -> 0x0621 }
        r8 = r4.longValue();	 Catch:{ Exception -> 0x0621 }
        com.tencent.bugly.beta.ui.g.a(r2, r3, r5, r8);	 Catch:{ Exception -> 0x0621 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0621 }
        r3 = "BetaAct TYPE_actCanShow checking : ";	 Catch:{ Exception -> 0x0621 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0621 }
        r3 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r3 = r3[r7];	 Catch:{ Exception -> 0x0621 }
        r3 = r3.hashCode();	 Catch:{ Exception -> 0x0621 }
        r2.append(r3);	 Catch:{ Exception -> 0x0621 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0621 }
        r3 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x0621 }
        com.tencent.bugly.proguard.an.a(r2, r3);	 Catch:{ Exception -> 0x0621 }
        return;	 Catch:{ Exception -> 0x0621 }
    L_0x030c:
        r2 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r2 = r2[r7];	 Catch:{ Exception -> 0x0621 }
        r2 = (java.util.List) r2;	 Catch:{ Exception -> 0x0621 }
        if (r2 == 0) goto L_0x0340;	 Catch:{ Exception -> 0x0621 }
    L_0x0314:
        r2 = r2.iterator();	 Catch:{ Exception -> 0x0621 }
    L_0x0318:
        r3 = r2.hasNext();	 Catch:{ Exception -> 0x0621 }
        if (r3 == 0) goto L_0x0340;	 Catch:{ Exception -> 0x0621 }
    L_0x031e:
        r3 = r2.next();	 Catch:{ Exception -> 0x0621 }
        r3 = (com.tencent.bugly.beta.download.DownloadListener) r3;	 Catch:{ Exception -> 0x0621 }
        if (r3 == 0) goto L_0x0318;	 Catch:{ Exception -> 0x0621 }
    L_0x0326:
        r7 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r7 = r7[r6];	 Catch:{ Exception -> 0x0621 }
        r7 = (com.tencent.bugly.beta.download.DownloadTask) r7;	 Catch:{ Exception -> 0x0621 }
        r8 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r8 = r8[r5];	 Catch:{ Exception -> 0x0621 }
        r8 = (java.lang.Integer) r8;	 Catch:{ Exception -> 0x0621 }
        r8 = r8.intValue();	 Catch:{ Exception -> 0x0621 }
        r9 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r9 = r9[r4];	 Catch:{ Exception -> 0x0621 }
        r9 = (java.lang.String) r9;	 Catch:{ Exception -> 0x0621 }
        r3.onFailed(r7, r8, r9);	 Catch:{ Exception -> 0x0621 }
        goto L_0x0318;	 Catch:{ Exception -> 0x0621 }
    L_0x0340:
        return;	 Catch:{ Exception -> 0x0621 }
    L_0x0341:
        r2 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r2 = r2[r7];	 Catch:{ Exception -> 0x0621 }
        r2 = (java.util.List) r2;	 Catch:{ Exception -> 0x0621 }
        if (r2 == 0) goto L_0x0365;	 Catch:{ Exception -> 0x0621 }
    L_0x0349:
        r2 = r2.iterator();	 Catch:{ Exception -> 0x0621 }
    L_0x034d:
        r3 = r2.hasNext();	 Catch:{ Exception -> 0x0621 }
        if (r3 == 0) goto L_0x0365;	 Catch:{ Exception -> 0x0621 }
    L_0x0353:
        r3 = r2.next();	 Catch:{ Exception -> 0x0621 }
        r3 = (com.tencent.bugly.beta.download.DownloadListener) r3;	 Catch:{ Exception -> 0x0621 }
        if (r3 == 0) goto L_0x034d;	 Catch:{ Exception -> 0x0621 }
    L_0x035b:
        r5 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r5 = r5[r6];	 Catch:{ Exception -> 0x0621 }
        r5 = (com.tencent.bugly.beta.download.DownloadTask) r5;	 Catch:{ Exception -> 0x0621 }
        r3.onReceive(r5);	 Catch:{ Exception -> 0x0621 }
        goto L_0x034d;	 Catch:{ Exception -> 0x0621 }
    L_0x0365:
        r2 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Exception -> 0x0621 }
        r2 = r2.V;	 Catch:{ Exception -> 0x0621 }
        if (r2 == 0) goto L_0x0386;	 Catch:{ Exception -> 0x0621 }
    L_0x036b:
        r2 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Exception -> 0x0621 }
        r2 = r2.ac;	 Catch:{ Exception -> 0x0621 }
        if (r2 != r4) goto L_0x0386;	 Catch:{ Exception -> 0x0621 }
    L_0x0371:
        r2 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r2 = r2[r6];	 Catch:{ Exception -> 0x0621 }
        r2 = (com.tencent.bugly.beta.download.DownloadTask) r2;	 Catch:{ Exception -> 0x0621 }
        r3 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Exception -> 0x0621 }
        r3 = r3.V;	 Catch:{ Exception -> 0x0621 }
        r4 = r2.getSavedLength();	 Catch:{ Exception -> 0x0621 }
        r6 = r2.getTotalLength();	 Catch:{ Exception -> 0x0621 }
        r3.onDownloadReceived(r4, r6);	 Catch:{ Exception -> 0x0621 }
    L_0x0386:
        return;	 Catch:{ Exception -> 0x0621 }
    L_0x0387:
        r2 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r2 = r2[r7];	 Catch:{ Exception -> 0x0621 }
        r2 = (java.util.List) r2;	 Catch:{ Exception -> 0x0621 }
        if (r2 == 0) goto L_0x03ab;	 Catch:{ Exception -> 0x0621 }
    L_0x038f:
        r2 = r2.iterator();	 Catch:{ Exception -> 0x0621 }
    L_0x0393:
        r3 = r2.hasNext();	 Catch:{ Exception -> 0x0621 }
        if (r3 == 0) goto L_0x03ab;	 Catch:{ Exception -> 0x0621 }
    L_0x0399:
        r3 = r2.next();	 Catch:{ Exception -> 0x0621 }
        r3 = (com.tencent.bugly.beta.download.DownloadListener) r3;	 Catch:{ Exception -> 0x0621 }
        if (r3 == 0) goto L_0x0393;	 Catch:{ Exception -> 0x0621 }
    L_0x03a1:
        r4 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r4 = r4[r6];	 Catch:{ Exception -> 0x0621 }
        r4 = (com.tencent.bugly.beta.download.DownloadTask) r4;	 Catch:{ Exception -> 0x0621 }
        r3.onCompleted(r4);	 Catch:{ Exception -> 0x0621 }
        goto L_0x0393;	 Catch:{ Exception -> 0x0621 }
    L_0x03ab:
        return;	 Catch:{ Exception -> 0x0621 }
    L_0x03ac:
        r2 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r2 = r2[r7];	 Catch:{ Exception -> 0x0621 }
        r2 = (com.tencent.bugly.beta.ui.h) r2;	 Catch:{ Exception -> 0x0621 }
        r2.c();	 Catch:{ Exception -> 0x0621 }
        return;	 Catch:{ Exception -> 0x0621 }
    L_0x03b6:
        monitor-enter(r22);	 Catch:{ Exception -> 0x0621 }
        r2 = r1.b;	 Catch:{ all -> 0x03d6 }
        r2 = r2[r7];	 Catch:{ all -> 0x03d6 }
        r2 = (java.lang.Boolean) r2;	 Catch:{ all -> 0x03d6 }
        r2 = r2.booleanValue();	 Catch:{ all -> 0x03d6 }
        if (r2 != 0) goto L_0x03d4;	 Catch:{ all -> 0x03d6 }
    L_0x03c3:
        r2 = r1.b;	 Catch:{ all -> 0x03d6 }
        r3 = java.lang.Boolean.valueOf(r6);	 Catch:{ all -> 0x03d6 }
        r2[r7] = r3;	 Catch:{ all -> 0x03d6 }
        r2 = r1.b;	 Catch:{ all -> 0x03d6 }
        r2 = r2[r6];	 Catch:{ all -> 0x03d6 }
        r2 = (java.lang.Runnable) r2;	 Catch:{ all -> 0x03d6 }
        r2.run();	 Catch:{ all -> 0x03d6 }
    L_0x03d4:
        monitor-exit(r22);	 Catch:{ all -> 0x03d6 }
        return;	 Catch:{ all -> 0x03d6 }
    L_0x03d6:
        r0 = move-exception;	 Catch:{ all -> 0x03d6 }
        r2 = r0;	 Catch:{ all -> 0x03d6 }
        monitor-exit(r22);	 Catch:{ all -> 0x03d6 }
        throw r2;	 Catch:{ Exception -> 0x0621 }
    L_0x03da:
        r2 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Exception -> 0x0621 }
        r2 = r2.s;	 Catch:{ Exception -> 0x0621 }
        r3 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r3 = r3[r7];	 Catch:{ Exception -> 0x0621 }
        r3 = (java.lang.String) r3;	 Catch:{ Exception -> 0x0621 }
        com.tencent.bugly.beta.utils.f.a(r2, r3);	 Catch:{ Exception -> 0x0621 }
        return;	 Catch:{ Exception -> 0x0621 }
    L_0x03e8:
        r2 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r2 = r2[r7];	 Catch:{ Exception -> 0x0621 }
        r2 = (com.tencent.bugly.beta.upgrade.BetaGrayStrategy) r2;	 Catch:{ Exception -> 0x0621 }
        r3 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r3 = r3[r6];	 Catch:{ Exception -> 0x0621 }
        r3 = (com.tencent.bugly.beta.download.DownloadTask) r3;	 Catch:{ Exception -> 0x0621 }
        r4 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r4 = r4[r5];	 Catch:{ Exception -> 0x0621 }
        r4 = (java.lang.Boolean) r4;	 Catch:{ Exception -> 0x0621 }
        r4 = r4.booleanValue();	 Catch:{ Exception -> 0x0621 }
        r3 = r3.getStatus();	 Catch:{ Exception -> 0x0621 }
        if (r3 == r5) goto L_0x043f;	 Catch:{ Exception -> 0x0621 }
    L_0x0404:
        r2.d = r7;	 Catch:{ Exception -> 0x0621 }
        r7 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0621 }
        r2.c = r7;	 Catch:{ Exception -> 0x0621 }
        if (r4 != 0) goto L_0x0419;	 Catch:{ Exception -> 0x0621 }
    L_0x040e:
        r3 = r2.a;	 Catch:{ Exception -> 0x0621 }
        r3 = r3.g;	 Catch:{ Exception -> 0x0621 }
        if (r3 == r5) goto L_0x0419;	 Catch:{ Exception -> 0x0621 }
    L_0x0414:
        r3 = r2.b;	 Catch:{ Exception -> 0x0621 }
        r3 = r3 + r6;	 Catch:{ Exception -> 0x0621 }
        r2.b = r3;	 Catch:{ Exception -> 0x0621 }
    L_0x0419:
        r3 = "st.bch";	 Catch:{ Exception -> 0x0621 }
        com.tencent.bugly.beta.global.a.a(r3, r2);	 Catch:{ Exception -> 0x0621 }
        r3 = com.tencent.bugly.proguard.p.a;	 Catch:{ Exception -> 0x0621 }
        r15 = new com.tencent.bugly.proguard.w;	 Catch:{ Exception -> 0x0621 }
        r5 = "pop";	 Catch:{ Exception -> 0x0621 }
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0621 }
        r8 = 2;	 Catch:{ Exception -> 0x0621 }
        r9 = 0;	 Catch:{ Exception -> 0x0621 }
        r4 = r2.a;	 Catch:{ Exception -> 0x0621 }
        r11 = r4.e;	 Catch:{ Exception -> 0x0621 }
        r4 = r2.a;	 Catch:{ Exception -> 0x0621 }
        r12 = r4.m;	 Catch:{ Exception -> 0x0621 }
        r2 = r2.a;	 Catch:{ Exception -> 0x0621 }
        r13 = r2.p;	 Catch:{ Exception -> 0x0621 }
        r14 = 0;	 Catch:{ Exception -> 0x0621 }
        r4 = r15;	 Catch:{ Exception -> 0x0621 }
        r4.<init>(r5, r6, r8, r9, r11, r12, r13, r14);	 Catch:{ Exception -> 0x0621 }
        r3.a(r15);	 Catch:{ Exception -> 0x0621 }
    L_0x043f:
        return;	 Catch:{ Exception -> 0x0621 }
    L_0x0440:
        r2 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r2 = r2[r7];	 Catch:{ Exception -> 0x0621 }
        r2 = (com.tencent.bugly.beta.upgrade.BetaGrayStrategy) r2;	 Catch:{ Exception -> 0x0621 }
        r3 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r3 = r3[r6];	 Catch:{ Exception -> 0x0621 }
        r3 = (com.tencent.bugly.beta.download.DownloadTask) r3;	 Catch:{ Exception -> 0x0621 }
        r4 = r2.d;	 Catch:{ Exception -> 0x0621 }
        if (r4 != 0) goto L_0x045d;	 Catch:{ Exception -> 0x0621 }
    L_0x0450:
        r2.d = r6;	 Catch:{ Exception -> 0x0621 }
        r7 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0621 }
        r2.c = r7;	 Catch:{ Exception -> 0x0621 }
        r4 = "st.bch";	 Catch:{ Exception -> 0x0621 }
        com.tencent.bugly.beta.global.a.a(r4, r2);	 Catch:{ Exception -> 0x0621 }
    L_0x045d:
        r4 = r3.getStatus();	 Catch:{ Exception -> 0x0621 }
        if (r4 == r5) goto L_0x04ac;	 Catch:{ Exception -> 0x0621 }
    L_0x0463:
        r3 = r3.getStatus();	 Catch:{ Exception -> 0x0621 }
        if (r3 != r6) goto L_0x048b;	 Catch:{ Exception -> 0x0621 }
    L_0x0469:
        r3 = com.tencent.bugly.proguard.p.a;	 Catch:{ Exception -> 0x0621 }
        r15 = new com.tencent.bugly.proguard.w;	 Catch:{ Exception -> 0x0621 }
        r5 = "pop";	 Catch:{ Exception -> 0x0621 }
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0621 }
        r8 = 4;	 Catch:{ Exception -> 0x0621 }
        r9 = 0;	 Catch:{ Exception -> 0x0621 }
        r4 = r2.a;	 Catch:{ Exception -> 0x0621 }
        r11 = r4.e;	 Catch:{ Exception -> 0x0621 }
        r4 = r2.a;	 Catch:{ Exception -> 0x0621 }
        r12 = r4.m;	 Catch:{ Exception -> 0x0621 }
        r2 = r2.a;	 Catch:{ Exception -> 0x0621 }
        r13 = r2.p;	 Catch:{ Exception -> 0x0621 }
        r14 = 0;	 Catch:{ Exception -> 0x0621 }
        r4 = r15;	 Catch:{ Exception -> 0x0621 }
        r4.<init>(r5, r6, r8, r9, r11, r12, r13, r14);	 Catch:{ Exception -> 0x0621 }
        r3.a(r15);	 Catch:{ Exception -> 0x0621 }
        return;	 Catch:{ Exception -> 0x0621 }
    L_0x048b:
        r3 = com.tencent.bugly.proguard.p.a;	 Catch:{ Exception -> 0x0621 }
        r15 = new com.tencent.bugly.proguard.w;	 Catch:{ Exception -> 0x0621 }
        r5 = "pop";	 Catch:{ Exception -> 0x0621 }
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0621 }
        r8 = 3;	 Catch:{ Exception -> 0x0621 }
        r9 = 0;	 Catch:{ Exception -> 0x0621 }
        r4 = r2.a;	 Catch:{ Exception -> 0x0621 }
        r11 = r4.e;	 Catch:{ Exception -> 0x0621 }
        r4 = r2.a;	 Catch:{ Exception -> 0x0621 }
        r12 = r4.m;	 Catch:{ Exception -> 0x0621 }
        r2 = r2.a;	 Catch:{ Exception -> 0x0621 }
        r13 = r2.p;	 Catch:{ Exception -> 0x0621 }
        r14 = 0;	 Catch:{ Exception -> 0x0621 }
        r4 = r15;	 Catch:{ Exception -> 0x0621 }
        r4.<init>(r5, r6, r8, r9, r11, r12, r13, r14);	 Catch:{ Exception -> 0x0621 }
        r3.a(r15);	 Catch:{ Exception -> 0x0621 }
    L_0x04ac:
        return;	 Catch:{ Exception -> 0x0621 }
    L_0x04ad:
        r2 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r2 = r2[r7];	 Catch:{ Exception -> 0x0621 }
        r2 = (com.tencent.bugly.beta.ui.b) r2;	 Catch:{ Exception -> 0x0621 }
        r3 = r1.b;	 Catch:{ Exception -> 0x0621 }
        r3 = r3[r6];	 Catch:{ Exception -> 0x0621 }
        r3 = (java.lang.Boolean) r3;	 Catch:{ Exception -> 0x0621 }
        r3 = r3.booleanValue();	 Catch:{ Exception -> 0x0621 }
        com.tencent.bugly.beta.ui.g.a(r2, r3);	 Catch:{ Exception -> 0x0621 }
        return;
    L_0x04c1:
        r2 = "Beta async init start...";	 Catch:{ Exception -> 0x0614 }
        r4 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x0614 }
        com.tencent.bugly.proguard.an.a(r2, r4);	 Catch:{ Exception -> 0x0614 }
        r2 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Exception -> 0x0614 }
        r4 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Exception -> 0x0614 }
        monitor-enter(r4);	 Catch:{ Exception -> 0x0614 }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x04e5 }
        r9 = r2.z;	 Catch:{ Exception -> 0x04e5 }
        r9 = r9.applicationInfo;	 Catch:{ Exception -> 0x04e5 }
        r9 = r9.publicSourceDir;	 Catch:{ Exception -> 0x04e5 }
        r8.<init>(r9);	 Catch:{ Exception -> 0x04e5 }
        r9 = "MD5";	 Catch:{ Exception -> 0x04e5 }
        r8 = com.tencent.bugly.proguard.ap.a(r8, r9);	 Catch:{ Exception -> 0x04e5 }
        r2.v = r8;	 Catch:{ Exception -> 0x04e5 }
        goto L_0x04e7;
    L_0x04e1:
        r0 = move-exception;
        r2 = r0;
        goto L_0x0612;
    L_0x04e5:
        r2.v = r3;	 Catch:{ all -> 0x04e1 }
    L_0x04e7:
        r8 = r2.v;	 Catch:{ all -> 0x04e1 }
        r8 = android.text.TextUtils.isEmpty(r8);	 Catch:{ all -> 0x04e1 }
        if (r8 == 0) goto L_0x04fa;	 Catch:{ all -> 0x04e1 }
    L_0x04ef:
        r8 = "null";	 Catch:{ all -> 0x04e1 }
        r2.v = r8;	 Catch:{ all -> 0x04e1 }
        r8 = "无法获取md5值";	 Catch:{ all -> 0x04e1 }
        r9 = new java.lang.Object[r7];	 Catch:{ all -> 0x04e1 }
        com.tencent.bugly.proguard.an.e(r8, r9);	 Catch:{ all -> 0x04e1 }
    L_0x04fa:
        r8 = r2.C;	 Catch:{ all -> 0x04e1 }
        if (r8 == 0) goto L_0x0503;	 Catch:{ all -> 0x04e1 }
    L_0x04fe:
        r8 = r2.t;	 Catch:{ all -> 0x04e1 }
        com.tencent.bugly.beta.global.a.a(r8);	 Catch:{ all -> 0x04e1 }
    L_0x0503:
        r8 = "st.bch";	 Catch:{ all -> 0x04e1 }
        r9 = com.tencent.bugly.beta.upgrade.BetaGrayStrategy.CREATOR;	 Catch:{ all -> 0x04e1 }
        r8 = com.tencent.bugly.beta.global.a.a(r8, r9);	 Catch:{ all -> 0x04e1 }
        r8 = (com.tencent.bugly.beta.upgrade.BetaGrayStrategy) r8;	 Catch:{ all -> 0x04e1 }
        if (r8 == 0) goto L_0x05c7;	 Catch:{ all -> 0x04e1 }
    L_0x050f:
        r9 = r8.a;	 Catch:{ all -> 0x04e1 }
        if (r9 == 0) goto L_0x05c7;	 Catch:{ all -> 0x04e1 }
    L_0x0513:
        r9 = r8.a;	 Catch:{ all -> 0x04e1 }
        r9 = r9.e;	 Catch:{ all -> 0x04e1 }
        r9 = r9.i;	 Catch:{ all -> 0x04e1 }
        r9 = r9.toUpperCase();	 Catch:{ all -> 0x04e1 }
        r10 = r2.v;	 Catch:{ all -> 0x04e1 }
        r9 = android.text.TextUtils.equals(r9, r10);	 Catch:{ all -> 0x04e1 }
        if (r9 == 0) goto L_0x05b2;	 Catch:{ all -> 0x04e1 }
    L_0x0525:
        r9 = "st.bch";	 Catch:{ all -> 0x04e1 }
        r9 = com.tencent.bugly.beta.global.a.a(r9);	 Catch:{ all -> 0x04e1 }
        if (r9 == 0) goto L_0x05ab;	 Catch:{ all -> 0x04e1 }
    L_0x052d:
        r9 = "installApkMd5";	 Catch:{ all -> 0x04e1 }
        r9 = com.tencent.bugly.beta.global.a.b(r9, r3);	 Catch:{ all -> 0x04e1 }
        r10 = android.text.TextUtils.isEmpty(r9);	 Catch:{ all -> 0x04e1 }
        if (r10 != 0) goto L_0x056d;	 Catch:{ all -> 0x04e1 }
    L_0x0539:
        r10 = r2.v;	 Catch:{ all -> 0x04e1 }
        r9 = android.text.TextUtils.equals(r9, r10);	 Catch:{ all -> 0x04e1 }
        if (r9 == 0) goto L_0x056d;	 Catch:{ all -> 0x04e1 }
    L_0x0541:
        r9 = com.tencent.bugly.proguard.p.a;	 Catch:{ all -> 0x04e1 }
        r15 = new com.tencent.bugly.proguard.w;	 Catch:{ all -> 0x04e1 }
        r11 = "active";	 Catch:{ all -> 0x04e1 }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x04e1 }
        r14 = 0;	 Catch:{ all -> 0x04e1 }
        r16 = 0;	 Catch:{ all -> 0x04e1 }
        r18 = 0;	 Catch:{ all -> 0x04e1 }
        r10 = r8.a;	 Catch:{ all -> 0x04e1 }
        r10 = r10.m;	 Catch:{ all -> 0x04e1 }
        r5 = r8.a;	 Catch:{ all -> 0x04e1 }
        r5 = r5.p;	 Catch:{ all -> 0x04e1 }
        r20 = 0;	 Catch:{ all -> 0x04e1 }
        r19 = r10;	 Catch:{ all -> 0x04e1 }
        r10 = r15;	 Catch:{ all -> 0x04e1 }
        r6 = r15;	 Catch:{ all -> 0x04e1 }
        r15 = r16;	 Catch:{ all -> 0x04e1 }
        r17 = r18;	 Catch:{ all -> 0x04e1 }
        r18 = r19;	 Catch:{ all -> 0x04e1 }
        r19 = r5;	 Catch:{ all -> 0x04e1 }
        r10.<init>(r11, r12, r14, r15, r17, r18, r19, r20);	 Catch:{ all -> 0x04e1 }
        r9.a(r6);	 Catch:{ all -> 0x04e1 }
        goto L_0x0574;	 Catch:{ all -> 0x04e1 }
    L_0x056d:
        r5 = "activated from the other way";	 Catch:{ all -> 0x04e1 }
        r6 = new java.lang.Object[r7];	 Catch:{ all -> 0x04e1 }
        com.tencent.bugly.proguard.an.a(r5, r6);	 Catch:{ all -> 0x04e1 }
    L_0x0574:
        r5 = r2.A;	 Catch:{ all -> 0x04e1 }
        r5 = r5.edit();	 Catch:{ all -> 0x04e1 }
        r6 = "installApkMd5";	 Catch:{ all -> 0x04e1 }
        r5 = r5.remove(r6);	 Catch:{ all -> 0x04e1 }
        r5.apply();	 Catch:{ all -> 0x04e1 }
        r5 = r2.p;	 Catch:{ all -> 0x04e1 }
        r6 = r8.a;	 Catch:{ all -> 0x04e1 }
        r6 = r6.f;	 Catch:{ all -> 0x04e1 }
        r6 = r6.b;	 Catch:{ all -> 0x04e1 }
        r9 = r2.t;	 Catch:{ all -> 0x04e1 }
        r9 = r9.getAbsolutePath();	 Catch:{ all -> 0x04e1 }
        r3 = r5.a(r6, r9, r3, r3);	 Catch:{ all -> 0x04e1 }
        r5 = 1;	 Catch:{ all -> 0x04e1 }
        r3.delete(r5);	 Catch:{ all -> 0x04e1 }
        r3 = r2.t;	 Catch:{ all -> 0x04e1 }
        com.tencent.bugly.beta.global.a.a(r3);	 Catch:{ all -> 0x04e1 }
        r3 = com.tencent.bugly.beta.global.f.a;	 Catch:{ all -> 0x04e1 }
        r3.a();	 Catch:{ all -> 0x04e1 }
        r3 = "upgrade success";	 Catch:{ all -> 0x04e1 }
        r5 = new java.lang.Object[r7];	 Catch:{ all -> 0x04e1 }
        com.tencent.bugly.proguard.an.a(r3, r5);	 Catch:{ all -> 0x04e1 }
        goto L_0x05b2;	 Catch:{ all -> 0x04e1 }
    L_0x05ab:
        r3 = "delete strategy failed";	 Catch:{ all -> 0x04e1 }
        r5 = new java.lang.Object[r7];	 Catch:{ all -> 0x04e1 }
        com.tencent.bugly.proguard.an.d(r3, r5);	 Catch:{ all -> 0x04e1 }
    L_0x05b2:
        r3 = "[this md5:%s] [strategy md5:%s]";	 Catch:{ all -> 0x04e1 }
        r5 = 2;	 Catch:{ all -> 0x04e1 }
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x04e1 }
        r6 = r2.v;	 Catch:{ all -> 0x04e1 }
        r5[r7] = r6;	 Catch:{ all -> 0x04e1 }
        r6 = r8.a;	 Catch:{ all -> 0x04e1 }
        r6 = r6.e;	 Catch:{ all -> 0x04e1 }
        r6 = r6.i;	 Catch:{ all -> 0x04e1 }
        r8 = 1;	 Catch:{ all -> 0x04e1 }
        r5[r8] = r6;	 Catch:{ all -> 0x04e1 }
        com.tencent.bugly.proguard.an.a(r3, r5);	 Catch:{ all -> 0x04e1 }
    L_0x05c7:
        r3 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x04e1 }
        r3.notifyAll();	 Catch:{ all -> 0x04e1 }
        monitor-exit(r4);	 Catch:{ all -> 0x04e1 }
        r3 = r2.s;	 Catch:{ Exception -> 0x0614 }
        r4 = new com.tencent.bugly.beta.download.BetaReceiver;	 Catch:{ Exception -> 0x0614 }
        r4.<init>();	 Catch:{ Exception -> 0x0614 }
        r5 = new android.content.IntentFilter;	 Catch:{ Exception -> 0x0614 }
        r6 = "android.net.conn.CONNECTIVITY_CHANGE";	 Catch:{ Exception -> 0x0614 }
        r5.<init>(r6);	 Catch:{ Exception -> 0x0614 }
        r3.registerReceiver(r4, r5);	 Catch:{ Exception -> 0x0614 }
        r2 = r2.d;	 Catch:{ Exception -> 0x0614 }
        if (r2 == 0) goto L_0x05e5;	 Catch:{ Exception -> 0x0614 }
    L_0x05e2:
        com.tencent.bugly.beta.Beta.checkUpgrade(r7, r7);	 Catch:{ Exception -> 0x0614 }
    L_0x05e5:
        r2 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Exception -> 0x0614 }
        r2 = r2.F;	 Catch:{ Exception -> 0x0614 }
        r2 = r2.a;	 Catch:{ Exception -> 0x0614 }
        r2 = r2.b;	 Catch:{ Exception -> 0x0614 }
        if (r2 == 0) goto L_0x060a;	 Catch:{ Exception -> 0x0614 }
    L_0x05ef:
        r2 = com.tencent.bugly.proguard.p.a;	 Catch:{ Exception -> 0x0614 }
        r2 = r2.a();	 Catch:{ Exception -> 0x0614 }
        r2 = (java.util.ArrayList) r2;	 Catch:{ Exception -> 0x0614 }
        if (r2 == 0) goto L_0x060a;	 Catch:{ Exception -> 0x0614 }
    L_0x05f9:
        r3 = r2.isEmpty();	 Catch:{ Exception -> 0x0614 }
        if (r3 != 0) goto L_0x060a;	 Catch:{ Exception -> 0x0614 }
    L_0x05ff:
        r3 = com.tencent.bugly.beta.upgrade.b.a;	 Catch:{ Exception -> 0x0614 }
        r4 = new com.tencent.bugly.proguard.x;	 Catch:{ Exception -> 0x0614 }
        r4.<init>(r2);	 Catch:{ Exception -> 0x0614 }
        r2 = 1;	 Catch:{ Exception -> 0x0614 }
        r3.a(r4, r2);	 Catch:{ Exception -> 0x0614 }
    L_0x060a:
        r2 = "Beta async init end...";	 Catch:{ Exception -> 0x0614 }
        r3 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x0614 }
        com.tencent.bugly.proguard.an.a(r2, r3);	 Catch:{ Exception -> 0x0614 }
        return;
    L_0x0612:
        monitor-exit(r4);	 Catch:{ all -> 0x04e1 }
        throw r2;	 Catch:{ Exception -> 0x0614 }
    L_0x0614:
        r0 = move-exception;
        r2 = r0;
        r3 = com.tencent.bugly.proguard.an.b(r2);	 Catch:{ Exception -> 0x0621 }
        if (r3 != 0) goto L_0x061f;	 Catch:{ Exception -> 0x0621 }
    L_0x061c:
        r2.printStackTrace();	 Catch:{ Exception -> 0x0621 }
    L_0x061f:
        return;
    L_0x0620:
        return;
    L_0x0621:
        r0 = move-exception;
        r2 = r0;
        r3 = com.tencent.bugly.proguard.an.b(r2);
        if (r3 != 0) goto L_0x062c;
    L_0x0629:
        r2.printStackTrace();
    L_0x062c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.global.d.run():void");
    }
}
