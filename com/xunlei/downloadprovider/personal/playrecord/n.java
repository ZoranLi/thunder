package com.xunlei.downloadprovider.personal.playrecord;

import android.os.Handler.Callback;

/* compiled from: PlayRecordActivity */
final class n implements Callback {
    final /* synthetic */ l a;

    n(l lVar) {
        this.a = lVar;
    }

    public final boolean handleMessage(android.os.Message r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = r7.what;
        if (r0 != 0) goto L_0x008e;
    L_0x0004:
        r0 = 0;
        r1 = new org.json.JSONArray;	 Catch:{ Exception -> 0x008d }
        r7 = r7.obj;	 Catch:{ Exception -> 0x008d }
        r7 = (java.lang.String) r7;	 Catch:{ Exception -> 0x008d }
        r1.<init>(r7);	 Catch:{ Exception -> 0x008d }
        r7 = new java.util.ArrayList;
        r7.<init>();
        r2 = new java.util.LinkedHashSet;
        r2.<init>();
        r3 = r1.length();
    L_0x001c:
        if (r0 >= r3) goto L_0x0036;
    L_0x001e:
        r4 = r1.optJSONObject(r0);
        if (r4 == 0) goto L_0x0033;
    L_0x0024:
        r5 = new com.xunlei.downloadprovider.personal.playrecord.b;
        r5.<init>(r4);
        r7.add(r5);
        r4 = r5.d();
        r2.add(r4);
    L_0x0033:
        r0 = r0 + 1;
        goto L_0x001c;
    L_0x0036:
        r0 = r6.a;
        r0 = r0.b;
        r0 = r0.a;
        r0 = r0.x;
        r0 = r0.iterator();
    L_0x0044:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x0058;
    L_0x004a:
        r1 = r0.next();
        r1 = (com.xunlei.downloadprovider.personal.playrecord.VideoPlayRecord) r1;
        r2 = r1 instanceof com.xunlei.downloadprovider.personal.playrecord.b;
        if (r2 != 0) goto L_0x0044;
    L_0x0054:
        r7.add(r1);
        goto L_0x0044;
    L_0x0058:
        r0 = r6.a;
        r0 = r0.b;
        r0 = r0.a;
        r0.x = r7;
        r7 = r6.a;
        r7 = r7.b;
        r7 = r7.a;
        r7 = r7.x;
        r7 = com.xunlei.xllib.b.d.a(r7);
        if (r7 != 0) goto L_0x0083;
    L_0x0071:
        r7 = r6.a;
        r7 = r7.b;
        r7 = r7.a;
        r7 = r7.x;
        r0 = new com.xunlei.downloadprovider.personal.playrecord.o;
        r0.<init>(r6);
        java.util.Collections.sort(r7, r0);
    L_0x0083:
        r7 = r6.a;
        r7 = r7.b;
        r7 = r7.a;
        r7.l();
        goto L_0x008e;
    L_0x008d:
        return r0;
    L_0x008e:
        r7 = 1;
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.personal.playrecord.n.handleMessage(android.os.Message):boolean");
    }
}
