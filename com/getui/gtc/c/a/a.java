package com.getui.gtc.c.a;

import com.getui.gtc.c.b;

public final class a extends b {
    public a(byte[] r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r6.<init>();
        r0 = com.getui.gtc.a.a.g;
        r6.e = r0;
        r0 = 1;
        r6.h = r0;
        r1 = new org.json.JSONObject;
        r1.<init>();
        r2 = 0;
        r3 = "action";	 Catch:{ Exception -> 0x005c }
        r4 = "upload_BI";	 Catch:{ Exception -> 0x005c }
        r1.put(r3, r4);	 Catch:{ Exception -> 0x005c }
        r3 = "BIType";	 Catch:{ Exception -> 0x005c }
        r4 = "90";	 Catch:{ Exception -> 0x005c }
        r1.put(r3, r4);	 Catch:{ Exception -> 0x005c }
        r3 = "cid";	 Catch:{ Exception -> 0x005c }
        r4 = com.getui.gtc.a.b.b();	 Catch:{ Exception -> 0x005c }
        r4 = r4.c();	 Catch:{ Exception -> 0x005c }
        r1.put(r3, r4);	 Catch:{ Exception -> 0x005c }
        r3 = "BIData";	 Catch:{ Exception -> 0x005c }
        r4 = new java.lang.String;	 Catch:{ Exception -> 0x005c }
        r7 = com.getui.gtc.e.g.c(r7);	 Catch:{ Exception -> 0x005c }
        r5 = "UTF-8";	 Catch:{ Exception -> 0x005c }
        r4.<init>(r7, r5);	 Catch:{ Exception -> 0x005c }
        r1.put(r3, r4);	 Catch:{ Exception -> 0x005c }
        r7 = new java.lang.String[r0];	 Catch:{ Exception -> 0x005c }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x005c }
        r4 = " DeviceInfoTask init json : ";	 Catch:{ Exception -> 0x005c }
        r3.<init>(r4);	 Catch:{ Exception -> 0x005c }
        r4 = r1.toString();	 Catch:{ Exception -> 0x005c }
        r3.append(r4);	 Catch:{ Exception -> 0x005c }
        r3 = r3.toString();	 Catch:{ Exception -> 0x005c }
        r7[r2] = r3;	 Catch:{ Exception -> 0x005c }
        r7 = r1.toString();	 Catch:{ Exception -> 0x005c }
        r7 = r7.getBytes();	 Catch:{ Exception -> 0x005c }
        r6.f = r7;	 Catch:{ Exception -> 0x005c }
        return;
    L_0x005c:
        r7 = new java.lang.String[r0];
        r0 = " DeviceInfoTask ";
        r7[r2] = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.c.a.a.<init>(byte[]):void");
    }

    public final void a(byte[] bArr) {
        try {
            String str = new String(bArr);
            String[] strArr = new String[1];
            StringBuilder stringBuilder = new StringBuilder(" DeviceInfoTask response : ");
            stringBuilder.append(str);
            strArr[0] = stringBuilder.toString();
        } catch (Throwable th) {
            String[] strArr2 = new String[1];
            StringBuilder stringBuilder2 = new StringBuilder("DeviceInfoTask error : ");
            stringBuilder2.append(th.toString());
            strArr2[0] = stringBuilder2.toString();
        }
    }
}
