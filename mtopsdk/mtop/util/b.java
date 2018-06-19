package mtopsdk.mtop.util;

public final class b {
    public static mtopsdk.mtop.domain.a a(byte[] r2, java.lang.Class r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r3 == 0) goto L_0x002a;
    L_0x0003:
        if (r2 == 0) goto L_0x002a;
    L_0x0005:
        r1 = r2.length;
        if (r1 != 0) goto L_0x0009;
    L_0x0008:
        goto L_0x002a;
    L_0x0009:
        r1 = 0;
        r1 = new com.alibaba.fastjson.parser.Feature[r1];	 Catch:{ Throwable -> 0x0013 }
        r2 = com.alibaba.fastjson.a.parseObject(r2, r3, r1);	 Catch:{ Throwable -> 0x0013 }
        r2 = (mtopsdk.mtop.domain.a) r2;	 Catch:{ Throwable -> 0x0013 }
        return r2;
    L_0x0013:
        r2 = new java.lang.StringBuilder;
        r1 = "[jsonToOutputDO]invoke JSON.parseObject error ---Class=";
        r2.<init>(r1);
        r3 = r3.getName();
        r2.append(r3);
        r2 = r2.toString();
        mtopsdk.common.util.j.f(r2);
        r2 = r0;
        return r2;
    L_0x002a:
        r2 = "[jsonToOutputDO]outClass is null or jsondata is blank";
        mtopsdk.common.util.j.e(r2);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.mtop.util.b.a(byte[], java.lang.Class):mtopsdk.mtop.domain.a");
    }
}
