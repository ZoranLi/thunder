package com.alibaba.baichuan.android.a.a;

import com.alibaba.baichuan.android.a.b.a;

public class c extends a {
    public final boolean a(java.lang.String r6, java.lang.String r7, com.alibaba.baichuan.android.a.d r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = android.text.TextUtils.isEmpty(r7);
        r1 = 0;
        if (r0 != 0) goto L_0x00e5;
    L_0x0007:
        r6 = android.text.TextUtils.isEmpty(r6);
        if (r6 == 0) goto L_0x000f;
    L_0x000d:
        goto L_0x00e5;
    L_0x000f:
        r6 = com.alibaba.fastjson.a.parseObject(r7);	 Catch:{ Exception -> 0x00e1 }
        r6 = com.alibaba.baichuan.android.trade.utils.b.d(r6);	 Catch:{ Exception -> 0x00e1 }
        r7 = new com.alibaba.baichuan.android.trade.adapter.mtop.NetworkRequest;
        r7.<init>();
        r0 = "api";
        r0 = r6.get(r0);
        r0 = com.alibaba.baichuan.android.trade.utils.b.c(r0);
        r7.apiName = r0;
        r0 = "version";
        r0 = r6.get(r0);
        r0 = com.alibaba.baichuan.android.trade.utils.b.c(r0);
        r7.apiVersion = r0;
        r0 = "needLogin";
        r0 = r6.get(r0);
        r0 = com.alibaba.baichuan.android.trade.utils.b.a(r0);
        r7.needLogin = r0;
        r0 = "needWua";
        r0 = r6.get(r0);
        r0 = com.alibaba.baichuan.android.trade.utils.b.a(r0);
        r7.needWua = r0;
        r0 = "needAuth";
        r0 = r6.get(r0);
        r0 = com.alibaba.baichuan.android.trade.utils.b.a(r0);
        r7.needAuth = r0;
        r0 = "isPost";
        r0 = r6.get(r0);
        r0 = com.alibaba.baichuan.android.trade.utils.b.a(r0);
        r7.isPost = r0;
        r0 = "ext_headers";
        r0 = r6.get(r0);
        r0 = com.alibaba.baichuan.android.trade.utils.b.e(r0);
        r7.extHeaders = r0;
        r0 = "timeout";
        r0 = r6.get(r0);
        r0 = com.alibaba.baichuan.android.trade.utils.b.b(r0);
        r0 = r0.intValue();
        r7.timeOut = r0;
        r0 = r7.hashCode();
        r7.requestType = r0;
        r0 = "params";
        r6 = r6.get(r0);
        r6 = com.alibaba.baichuan.android.trade.utils.b.c(r6);
        r6 = com.alibaba.fastjson.a.parseObject(r6);
        if (r6 == 0) goto L_0x00bf;
    L_0x0096:
        r0 = new java.util.HashMap;
        r0.<init>();
        r2 = r6.keySet();
        r2 = r2.iterator();
    L_0x00a3:
        r3 = r2.hasNext();
        if (r3 == 0) goto L_0x00bd;
    L_0x00a9:
        r3 = r2.next();
        r3 = (java.lang.String) r3;
        r4 = r6.get(r3);
        if (r4 == 0) goto L_0x00a3;
    L_0x00b5:
        r4 = r4.toString();
        r0.put(r3, r4);
        goto L_0x00a3;
    L_0x00bd:
        r7.paramMap = r0;
    L_0x00bf:
        r6 = r7.check();
        if (r6 != 0) goto L_0x00d5;
    L_0x00c5:
        r6 = new com.alibaba.baichuan.android.a.e;
        r7 = "6";
        r6.<init>(r7);
        r7 = "2";
        r6.a(r7);
        r8.b(r6);
        return r1;
    L_0x00d5:
        r6 = com.alibaba.baichuan.android.trade.adapter.mtop.a.a.a;
        r0 = new com.alibaba.baichuan.android.a.a.d;
        r0.<init>(r5, r8);
        r6.a(r0, r7);
        r6 = 1;
        return r6;
    L_0x00e1:
        com.alibaba.baichuan.android.trade.utils.g.a.b();
        return r1;
    L_0x00e5:
        r6 = new com.alibaba.baichuan.android.a.e;
        r7 = "6";
        r6.<init>(r7);
        r7 = "2";
        r6.a(r7);
        r8.b(r6);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.baichuan.android.a.a.c.a(java.lang.String, java.lang.String, com.alibaba.baichuan.android.a.d):boolean");
    }
}
