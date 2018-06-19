package com.xunlei.downloadprovider.personal.lixianspace.b;

import android.text.TextUtils;
import com.xunlei.downloadprovider.member.payment.network.c;
import com.xunlei.downloadprovider.personal.lixianspace.d.p;

/* compiled from: LXSpaceRequestMgr */
public final class s implements c {
    public final void a(org.json.JSONArray r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = -20000; // 0xffffffffffffb1e0 float:NaN double:NaN;
        if (r7 == 0) goto L_0x0035;
    L_0x0004:
        r1 = r7.length();	 Catch:{ Exception -> 0x003d }
        if (r1 <= 0) goto L_0x0035;	 Catch:{ Exception -> 0x003d }
    L_0x000a:
        r1 = new java.util.ArrayList;	 Catch:{ Exception -> 0x003d }
        r2 = r7.length();	 Catch:{ Exception -> 0x003d }
        r1.<init>(r2);	 Catch:{ Exception -> 0x003d }
        r2 = r7.length();	 Catch:{ Exception -> 0x003d }
        r3 = 0;	 Catch:{ Exception -> 0x003d }
        r4 = r3;	 Catch:{ Exception -> 0x003d }
    L_0x0019:
        if (r4 >= r2) goto L_0x002b;	 Catch:{ Exception -> 0x003d }
    L_0x001b:
        r5 = r7.getJSONObject(r4);	 Catch:{ Exception -> 0x003d }
        r5 = com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo.a(r5);	 Catch:{ Exception -> 0x003d }
        if (r5 == 0) goto L_0x0028;	 Catch:{ Exception -> 0x003d }
    L_0x0025:
        r1.add(r5);	 Catch:{ Exception -> 0x003d }
    L_0x0028:
        r4 = r4 + 1;	 Catch:{ Exception -> 0x003d }
        goto L_0x0019;	 Catch:{ Exception -> 0x003d }
    L_0x002b:
        r7 = com.xunlei.downloadprovider.personal.lixianspace.b.c.a.a;	 Catch:{ Exception -> 0x003d }
        r2 = "";	 Catch:{ Exception -> 0x003d }
        r7.a(r3, r2, r1);	 Catch:{ Exception -> 0x003d }
        return;	 Catch:{ Exception -> 0x003d }
    L_0x0035:
        r7 = com.xunlei.downloadprovider.personal.lixianspace.d.p.a(r0);	 Catch:{ Exception -> 0x003d }
        r6.a(r0, r7);	 Catch:{ Exception -> 0x003d }
        return;
    L_0x003d:
        r7 = com.xunlei.downloadprovider.personal.lixianspace.d.p.a(r0);
        r6.a(r0, r7);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.personal.lixianspace.b.s.a(org.json.JSONArray):void");
    }

    public final void a(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            str = p.a(i);
        }
        a.a.a(i, str, null);
    }
}
