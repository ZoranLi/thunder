package com.xunlei.downloadprovider.download.privatespace;

/* compiled from: PrivateSpaceHelper */
public final class aa implements Runnable {
    final /* synthetic */ v a;

    public aa(v vVar) {
        this.a = vVar;
    }

    public final void run() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = new java.io.File;	 Catch:{ Exception -> 0x00ce }
        r1 = com.xunlei.downloadprovider.download.privatespace.v.e();	 Catch:{ Exception -> 0x00ce }
        r2 = "open.cfg";	 Catch:{ Exception -> 0x00ce }
        r0.<init>(r1, r2);	 Catch:{ Exception -> 0x00ce }
        r1 = r0.exists();	 Catch:{ Exception -> 0x00ce }
        if (r1 == 0) goto L_0x0068;	 Catch:{ Exception -> 0x00ce }
    L_0x0011:
        r0 = r0.getPath();	 Catch:{ Exception -> 0x00ce }
        r1 = "UTF-8";	 Catch:{ Exception -> 0x00ce }
        r0 = com.xunlei.downloadprovider.h.e.a(r0, r1);	 Catch:{ Exception -> 0x00ce }
        if (r0 == 0) goto L_0x0068;	 Catch:{ Exception -> 0x00ce }
    L_0x001d:
        r1 = r0.length();	 Catch:{ Exception -> 0x00ce }
        if (r1 <= 0) goto L_0x0068;	 Catch:{ Exception -> 0x00ce }
    L_0x0023:
        r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x00ce }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00ce }
        r1.<init>(r0);	 Catch:{ Exception -> 0x00ce }
        r0 = r1.length();	 Catch:{ Exception -> 0x00ce }
        if (r0 <= 0) goto L_0x0068;	 Catch:{ Exception -> 0x00ce }
    L_0x0032:
        r0 = r1.keys();	 Catch:{ Exception -> 0x00ce }
    L_0x0036:
        r2 = r0.hasNext();	 Catch:{ Exception -> 0x00ce }
        if (r2 == 0) goto L_0x0068;	 Catch:{ Exception -> 0x00ce }
    L_0x003c:
        r2 = r0.next();	 Catch:{ Exception -> 0x00ce }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x00ce }
        r3 = r1.optBoolean(r2);	 Catch:{ Exception -> 0x00ce }
        if (r3 == 0) goto L_0x0036;	 Catch:{ Exception -> 0x00ce }
    L_0x0048:
        r3 = r6.a;	 Catch:{ Exception -> 0x00ce }
        r3 = r3.b;	 Catch:{ Exception -> 0x00ce }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ce }
        r4.<init>();	 Catch:{ Exception -> 0x00ce }
        r4.append(r2);	 Catch:{ Exception -> 0x00ce }
        r2 = "_open_private_space";	 Catch:{ Exception -> 0x00ce }
        r4.append(r2);	 Catch:{ Exception -> 0x00ce }
        r2 = r4.toString();	 Catch:{ Exception -> 0x00ce }
        r4 = 1;	 Catch:{ Exception -> 0x00ce }
        r2 = r3.putBoolean(r2, r4);	 Catch:{ Exception -> 0x00ce }
        r2.commit();	 Catch:{ Exception -> 0x00ce }
        goto L_0x0036;	 Catch:{ Exception -> 0x00ce }
    L_0x0068:
        r0 = new java.io.File;	 Catch:{ Exception -> 0x00ce }
        r1 = com.xunlei.downloadprovider.download.privatespace.v.e();	 Catch:{ Exception -> 0x00ce }
        r2 = "verify.cfg";	 Catch:{ Exception -> 0x00ce }
        r0.<init>(r1, r2);	 Catch:{ Exception -> 0x00ce }
        r1 = r0.exists();	 Catch:{ Exception -> 0x00ce }
        if (r1 == 0) goto L_0x00cd;	 Catch:{ Exception -> 0x00ce }
    L_0x0079:
        r0 = r0.getPath();	 Catch:{ Exception -> 0x00ce }
        r1 = "UTF-8";	 Catch:{ Exception -> 0x00ce }
        r0 = com.xunlei.downloadprovider.h.e.a(r0, r1);	 Catch:{ Exception -> 0x00ce }
        if (r0 == 0) goto L_0x00cd;	 Catch:{ Exception -> 0x00ce }
    L_0x0085:
        r1 = r0.length();	 Catch:{ Exception -> 0x00ce }
        if (r1 <= 0) goto L_0x00cd;	 Catch:{ Exception -> 0x00ce }
    L_0x008b:
        r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x00ce }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00ce }
        r1.<init>(r0);	 Catch:{ Exception -> 0x00ce }
        r0 = r1.length();	 Catch:{ Exception -> 0x00ce }
        if (r0 <= 0) goto L_0x00cd;	 Catch:{ Exception -> 0x00ce }
    L_0x009a:
        r0 = r1.keys();	 Catch:{ Exception -> 0x00ce }
    L_0x009e:
        r2 = r0.hasNext();	 Catch:{ Exception -> 0x00ce }
        if (r2 == 0) goto L_0x00cd;	 Catch:{ Exception -> 0x00ce }
    L_0x00a4:
        r2 = r0.next();	 Catch:{ Exception -> 0x00ce }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x00ce }
        r3 = r6.a;	 Catch:{ Exception -> 0x00ce }
        r3 = r3.b;	 Catch:{ Exception -> 0x00ce }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ce }
        r4.<init>();	 Catch:{ Exception -> 0x00ce }
        r4.append(r2);	 Catch:{ Exception -> 0x00ce }
        r5 = "_is_need_reverify";	 Catch:{ Exception -> 0x00ce }
        r4.append(r5);	 Catch:{ Exception -> 0x00ce }
        r4 = r4.toString();	 Catch:{ Exception -> 0x00ce }
        r2 = r1.optBoolean(r2);	 Catch:{ Exception -> 0x00ce }
        r2 = r3.putBoolean(r4, r2);	 Catch:{ Exception -> 0x00ce }
        r2.commit();	 Catch:{ Exception -> 0x00ce }
        goto L_0x009e;
    L_0x00cd:
        return;
    L_0x00ce:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.privatespace.aa.run():void");
    }
}
