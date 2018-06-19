package com.xunlei.downloadprovider.homepage;

import com.xunlei.downloadprovider.frame.MainTabActivity$b;

/* compiled from: HomeFragment */
final class g implements MainTabActivity$b {
    final /* synthetic */ HomeFragment a;

    g(HomeFragment homeFragment) {
        this.a = homeFragment;
    }

    public final boolean a(android.view.MotionEvent r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = 0;
        r1 = r7.a;	 Catch:{ Exception -> 0x009c }
        r1 = r1.r;	 Catch:{ Exception -> 0x009c }
        r2 = r1.h;	 Catch:{ Exception -> 0x009c }
        if (r2 != 0) goto L_0x000c;	 Catch:{ Exception -> 0x009c }
    L_0x000b:
        return r0;	 Catch:{ Exception -> 0x009c }
    L_0x000c:
        r2 = r1.b;	 Catch:{ Exception -> 0x009c }
        if (r2 != 0) goto L_0x009b;	 Catch:{ Exception -> 0x009c }
    L_0x0010:
        r2 = r1.g;	 Catch:{ Exception -> 0x009c }
        if (r2 == 0) goto L_0x0016;	 Catch:{ Exception -> 0x009c }
    L_0x0014:
        goto L_0x009b;	 Catch:{ Exception -> 0x009c }
    L_0x0016:
        r2 = r8.getAction();	 Catch:{ Exception -> 0x009c }
        r3 = r8.getX();	 Catch:{ Exception -> 0x009c }
        r8 = r8.getY();	 Catch:{ Exception -> 0x009c }
        if (r2 == 0) goto L_0x0096;	 Catch:{ Exception -> 0x009c }
    L_0x0024:
        r4 = 2;	 Catch:{ Exception -> 0x009c }
        if (r2 == r4) goto L_0x0028;	 Catch:{ Exception -> 0x009c }
    L_0x0027:
        return r0;	 Catch:{ Exception -> 0x009c }
    L_0x0028:
        r2 = r1.e;	 Catch:{ Exception -> 0x009c }
        r2 = r8 - r2;	 Catch:{ Exception -> 0x009c }
        r2 = java.lang.Math.abs(r2);	 Catch:{ Exception -> 0x009c }
        r4 = r1.d;	 Catch:{ Exception -> 0x009c }
        r4 = r3 - r4;	 Catch:{ Exception -> 0x009c }
        r4 = java.lang.Math.abs(r4);	 Catch:{ Exception -> 0x009c }
        r5 = r1.e;	 Catch:{ Exception -> 0x009c }
        r5 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1));	 Catch:{ Exception -> 0x009c }
        r6 = 1;	 Catch:{ Exception -> 0x009c }
        if (r5 <= 0) goto L_0x0041;	 Catch:{ Exception -> 0x009c }
    L_0x003f:
        r5 = r6;	 Catch:{ Exception -> 0x009c }
        goto L_0x0042;	 Catch:{ Exception -> 0x009c }
    L_0x0041:
        r5 = r0;	 Catch:{ Exception -> 0x009c }
    L_0x0042:
        r1.e = r8;	 Catch:{ Exception -> 0x009c }
        r1.d = r3;	 Catch:{ Exception -> 0x009c }
        r8 = 1090519040; // 0x41000000 float:8.0 double:5.38787994E-315;	 Catch:{ Exception -> 0x009c }
        r3 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));	 Catch:{ Exception -> 0x009c }
        if (r3 >= 0) goto L_0x0058;	 Catch:{ Exception -> 0x009c }
    L_0x004c:
        r3 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));	 Catch:{ Exception -> 0x009c }
        if (r3 <= 0) goto L_0x0058;	 Catch:{ Exception -> 0x009c }
    L_0x0050:
        r3 = r1.c;	 Catch:{ Exception -> 0x009c }
        if (r3 != 0) goto L_0x0058;	 Catch:{ Exception -> 0x009c }
    L_0x0054:
        if (r5 != 0) goto L_0x0058;	 Catch:{ Exception -> 0x009c }
    L_0x0056:
        r3 = r6;	 Catch:{ Exception -> 0x009c }
        goto L_0x0059;	 Catch:{ Exception -> 0x009c }
    L_0x0058:
        r3 = r0;	 Catch:{ Exception -> 0x009c }
    L_0x0059:
        r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));	 Catch:{ Exception -> 0x009c }
        if (r4 >= 0) goto L_0x0069;	 Catch:{ Exception -> 0x009c }
    L_0x005d:
        r8 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));	 Catch:{ Exception -> 0x009c }
        if (r8 <= 0) goto L_0x0069;	 Catch:{ Exception -> 0x009c }
    L_0x0061:
        r8 = r1.c;	 Catch:{ Exception -> 0x009c }
        if (r8 == 0) goto L_0x0069;	 Catch:{ Exception -> 0x009c }
    L_0x0065:
        if (r5 == 0) goto L_0x0069;	 Catch:{ Exception -> 0x009c }
    L_0x0067:
        r8 = r6;	 Catch:{ Exception -> 0x009c }
        goto L_0x006a;	 Catch:{ Exception -> 0x009c }
    L_0x0069:
        r8 = r0;	 Catch:{ Exception -> 0x009c }
    L_0x006a:
        if (r3 == 0) goto L_0x007d;	 Catch:{ Exception -> 0x009c }
    L_0x006c:
        r8 = new android.content.Intent;	 Catch:{ Exception -> 0x009c }
        r2 = "action_move_up";	 Catch:{ Exception -> 0x009c }
        r8.<init>(r2);	 Catch:{ Exception -> 0x009c }
        r2 = r1.a;	 Catch:{ Exception -> 0x009c }
        r2 = android.support.v4.content.LocalBroadcastManager.getInstance(r2);	 Catch:{ Exception -> 0x009c }
        r2.sendBroadcast(r8);	 Catch:{ Exception -> 0x009c }
        goto L_0x008f;	 Catch:{ Exception -> 0x009c }
    L_0x007d:
        if (r8 == 0) goto L_0x0095;	 Catch:{ Exception -> 0x009c }
    L_0x007f:
        r8 = new android.content.Intent;	 Catch:{ Exception -> 0x009c }
        r2 = "action_move_down";	 Catch:{ Exception -> 0x009c }
        r8.<init>(r2);	 Catch:{ Exception -> 0x009c }
        r2 = r1.a;	 Catch:{ Exception -> 0x009c }
        r2 = android.support.v4.content.LocalBroadcastManager.getInstance(r2);	 Catch:{ Exception -> 0x009c }
        r2.sendBroadcast(r8);	 Catch:{ Exception -> 0x009c }
    L_0x008f:
        r8 = r1.c;	 Catch:{ Exception -> 0x009c }
        r8 = r8 ^ r6;	 Catch:{ Exception -> 0x009c }
        r1.c = r8;	 Catch:{ Exception -> 0x009c }
        return r0;	 Catch:{ Exception -> 0x009c }
    L_0x0095:
        return r0;	 Catch:{ Exception -> 0x009c }
    L_0x0096:
        r1.e = r8;	 Catch:{ Exception -> 0x009c }
        r1.d = r3;	 Catch:{ Exception -> 0x009c }
        return r0;
    L_0x009b:
        return r0;
    L_0x009c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.g.a(android.view.MotionEvent):boolean");
    }
}
