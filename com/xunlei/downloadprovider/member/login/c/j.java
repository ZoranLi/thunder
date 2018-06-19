package com.xunlei.downloadprovider.member.login.c;

/* compiled from: XLLoginErrorMsg */
public final class j {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(int r3) {
        /*
        r0 = 14;
        if (r3 == r0) goto L_0x008f;
    L_0x0004:
        r0 = 28;
        if (r3 == r0) goto L_0x008b;
    L_0x0008:
        r0 = 16781266; // 0x1000fd2 float:2.3521238E-38 double:8.291047E-317;
        if (r3 == r0) goto L_0x0087;
    L_0x000d:
        r0 = 16781283; // 0x1000fe3 float:2.3521285E-38 double:8.2910554E-317;
        if (r3 == r0) goto L_0x0083;
    L_0x0012:
        r0 = 16781290; // 0x1000fea float:2.3521305E-38 double:8.291059E-317;
        if (r3 == r0) goto L_0x007f;
    L_0x0017:
        switch(r3) {
            case 0: goto L_0x0083;
            case 1: goto L_0x007b;
            case 2: goto L_0x0077;
            case 3: goto L_0x0073;
            case 4: goto L_0x006f;
            case 5: goto L_0x006b;
            case 6: goto L_0x0067;
            case 7: goto L_0x0063;
            case 8: goto L_0x005f;
            case 9: goto L_0x005b;
            case 10: goto L_0x0057;
            case 11: goto L_0x0053;
            case 12: goto L_0x004f;
            default: goto L_0x001a;
        };
    L_0x001a:
        switch(r3) {
            case 16781296: goto L_0x004b;
            case 16781297: goto L_0x0083;
            default: goto L_0x001d;
        };
    L_0x001d:
        switch(r3) {
            case 16781306: goto L_0x0047;
            case 16781307: goto L_0x0083;
            case 16781308: goto L_0x007b;
            default: goto L_0x0020;
        };
    L_0x0020:
        switch(r3) {
            case 16781310: goto L_0x0043;
            case 16781311: goto L_0x0043;
            default: goto L_0x0023;
        };
    L_0x0023:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = com.xunlei.downloadprovider.member.login.LoginHelper.a();
        r1 = r1.e;
        r0.append(r1);
        r1 = "(";
        r0.append(r1);
        r0.append(r3);
        r3 = ")";
        r0.append(r3);
        r3 = r0.toString();
        return r3;
    L_0x0043:
        r0 = 2131363066; // 0x7f0a04fa float:1.834593E38 double:1.0530332697E-314;
        goto L_0x0092;
    L_0x0047:
        r0 = 2131363125; // 0x7f0a0535 float:1.834605E38 double:1.053033299E-314;
        goto L_0x0092;
    L_0x004b:
        r0 = 2131363095; // 0x7f0a0517 float:1.834599E38 double:1.053033284E-314;
        goto L_0x0092;
    L_0x004f:
        r0 = 2131363068; // 0x7f0a04fc float:1.8345934E38 double:1.0530332707E-314;
        goto L_0x0092;
    L_0x0053:
        r0 = 2131363063; // 0x7f0a04f7 float:1.8345924E38 double:1.053033268E-314;
        goto L_0x0092;
    L_0x0057:
        r0 = 2131363122; // 0x7f0a0532 float:1.8346044E38 double:1.0530332974E-314;
        goto L_0x0092;
    L_0x005b:
        r0 = 2131363096; // 0x7f0a0518 float:1.8345991E38 double:1.0530332845E-314;
        goto L_0x0092;
    L_0x005f:
        r0 = 2131363117; // 0x7f0a052d float:1.8346034E38 double:1.053033295E-314;
        goto L_0x0092;
    L_0x0063:
        r0 = 2131363061; // 0x7f0a04f5 float:1.834592E38 double:1.0530332673E-314;
        goto L_0x0092;
    L_0x0067:
        r0 = 2131362456; // 0x7f0a0298 float:1.8344693E38 double:1.0530329683E-314;
        goto L_0x0092;
    L_0x006b:
        r0 = 2131363106; // 0x7f0a0522 float:1.8346011E38 double:1.0530332895E-314;
        goto L_0x0092;
    L_0x006f:
        r0 = 2131363104; // 0x7f0a0520 float:1.8346007E38 double:1.0530332885E-314;
        goto L_0x0092;
    L_0x0073:
        r0 = 2131363090; // 0x7f0a0512 float:1.834598E38 double:1.0530332816E-314;
        goto L_0x0092;
    L_0x0077:
        r0 = 2131363060; // 0x7f0a04f4 float:1.8345918E38 double:1.053033267E-314;
        goto L_0x0092;
    L_0x007b:
        r0 = 2131363105; // 0x7f0a0521 float:1.834601E38 double:1.053033289E-314;
        goto L_0x0092;
    L_0x007f:
        r0 = 2131363116; // 0x7f0a052c float:1.8346032E38 double:1.0530332944E-314;
        goto L_0x0092;
    L_0x0083:
        r0 = 2131363082; // 0x7f0a050a float:1.8345963E38 double:1.0530332776E-314;
        goto L_0x0092;
    L_0x0087:
        r0 = 2131363084; // 0x7f0a050c float:1.8345967E38 double:1.0530332786E-314;
        goto L_0x0092;
    L_0x008b:
        r0 = 2131363123; // 0x7f0a0533 float:1.8346046E38 double:1.053033298E-314;
        goto L_0x0092;
    L_0x008f:
        r0 = 2131363083; // 0x7f0a050b float:1.8345965E38 double:1.053033278E-314;
    L_0x0092:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = com.xunlei.downloadprovider.app.BrothersApplication.getApplicationInstance();
        r0 = r2.getString(r0);
        r1.append(r0);
        r0 = "(";
        r1.append(r0);
        r1.append(r3);
        r3 = ")";
        r1.append(r3);
        r3 = r1.toString();
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.member.login.c.j.a(int):java.lang.String");
    }
}
