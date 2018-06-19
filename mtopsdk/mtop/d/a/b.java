package mtopsdk.mtop.d.a;

public final class b extends a {
    private static java.util.Map a(java.util.Map r7, java.util.Map r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r8 != 0) goto L_0x0007;
    L_0x0002:
        r8 = new java.util.HashMap;
        r8.<init>();
    L_0x0007:
        r0 = mtopsdk.mtop.domain.MtopHeaderFieldEnum.values();
        r1 = r0.length;
        r2 = 0;
    L_0x000d:
        if (r2 >= r1) goto L_0x0050;
    L_0x000f:
        r3 = r0[r2];
        r4 = r3.getXstateKey();
        r4 = r7.remove(r4);
        r4 = (java.lang.String) r4;
        if (r4 == 0) goto L_0x004d;
    L_0x001d:
        r5 = r3.getHeadField();	 Catch:{ UnsupportedEncodingException -> 0x002b }
        r6 = "utf-8";	 Catch:{ UnsupportedEncodingException -> 0x002b }
        r6 = java.net.URLEncoder.encode(r4, r6);	 Catch:{ UnsupportedEncodingException -> 0x002b }
        r8.put(r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x002b }
        goto L_0x004d;
    L_0x002b:
        r5 = new java.lang.StringBuilder;
        r6 = "[prepareRequestHeaders]urlencode ";
        r5.<init>(r6);
        r3 = r3.getHeadField();
        r5.append(r3);
        r3 = "=";
        r5.append(r3);
        r5.append(r4);
        r3 = "error";
        r5.append(r3);
        r3 = r5.toString();
        mtopsdk.common.util.j.e(r3);
    L_0x004d:
        r2 = r2 + 1;
        goto L_0x000d;
    L_0x0050:
        r0 = "lng";
        r0 = r7.remove(r0);
        r0 = (java.lang.String) r0;
        r1 = "lat";
        r7 = r7.remove(r1);
        r7 = (java.lang.String) r7;
        if (r0 == 0) goto L_0x009e;
    L_0x0062:
        if (r7 == 0) goto L_0x009e;
    L_0x0064:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1.append(r0);
        r0 = ",";
        r1.append(r0);
        r1.append(r7);
        r7 = "x-location";	 Catch:{ UnsupportedEncodingException -> 0x0084 }
        r0 = r1.toString();	 Catch:{ UnsupportedEncodingException -> 0x0084 }
        r2 = "utf-8";	 Catch:{ UnsupportedEncodingException -> 0x0084 }
        r0 = java.net.URLEncoder.encode(r0, r2);	 Catch:{ UnsupportedEncodingException -> 0x0084 }
        r8.put(r7, r0);	 Catch:{ UnsupportedEncodingException -> 0x0084 }
        return r8;
    L_0x0084:
        r7 = new java.lang.StringBuilder;
        r0 = "[prepareRequestHeaders]urlencode x-location=";
        r7.<init>(r0);
        r0 = r1.toString();
        r7.append(r0);
        r0 = "error";
        r7.append(r0);
        r7 = r7.toString();
        mtopsdk.common.util.j.e(r7);
    L_0x009e:
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.mtop.d.a.b.a(java.util.Map, java.util.Map):java.util.Map");
    }

    public final mtopsdk.a.b.b a(mtopsdk.mtop.a r11, java.util.Map r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r10 = this;
        r0 = r11.k;
        if (r0 != 0) goto L_0x000b;
    L_0x0004:
        r0 = new mtopsdk.mtop.util.h;
        r0.<init>();
        r11.k = r0;
    L_0x000b:
        r0 = r11.h;
        r1 = r11.k;
        r1 = r1.q;
        r2 = new mtopsdk.a.b.c;
        r2.<init>();
        r2.e = r1;
        r3 = r0.connTimeout;
        if (r3 <= 0) goto L_0x001e;
    L_0x001c:
        r2.f = r3;
    L_0x001e:
        r3 = r0.socketTimeout;
        if (r3 <= 0) goto L_0x0024;
    L_0x0022:
        r2.g = r3;
    L_0x0024:
        r3 = r0.retryTimes;
        r2.h = r3;
        r3 = r0.method;
        r0 = r0.requestHeaders;
        r0 = a(r12, r0);
        r4 = 0;
        r5 = "api";	 Catch:{ Throwable -> 0x0166 }
        r5 = r12.remove(r5);	 Catch:{ Throwable -> 0x0166 }
        r5 = (java.lang.String) r5;	 Catch:{ Throwable -> 0x0166 }
        r6 = "v";	 Catch:{ Throwable -> 0x0166 }
        r6 = r12.remove(r6);	 Catch:{ Throwable -> 0x0166 }
        r6 = (java.lang.String) r6;	 Catch:{ Throwable -> 0x0166 }
        mtopsdk.mtop.a.g.a();	 Catch:{ Throwable -> 0x0166 }
        r7 = mtopsdk.mtop.a.g.e();	 Catch:{ Throwable -> 0x0166 }
        if (r7 == 0) goto L_0x0095;	 Catch:{ Throwable -> 0x0166 }
    L_0x004a:
        r7 = mtopsdk.common.util.i.b(r5);	 Catch:{ Throwable -> 0x0166 }
        if (r7 != 0) goto L_0x0095;	 Catch:{ Throwable -> 0x0166 }
    L_0x0050:
        r7 = mtopsdk.common.util.i.b(r6);	 Catch:{ Throwable -> 0x0166 }
        if (r7 == 0) goto L_0x0057;	 Catch:{ Throwable -> 0x0166 }
    L_0x0056:
        goto L_0x0095;	 Catch:{ Throwable -> 0x0166 }
    L_0x0057:
        r7 = r11.h;	 Catch:{ Throwable -> 0x0166 }
        r7 = r7.userUnit;	 Catch:{ Throwable -> 0x0166 }
        if (r7 == 0) goto L_0x0095;	 Catch:{ Throwable -> 0x0166 }
    L_0x005d:
        r8 = mtopsdk.mtop.unit.UserUnit.UnitType.UNIT;	 Catch:{ Throwable -> 0x0166 }
        r8 = r8.getUnitType();	 Catch:{ Throwable -> 0x0166 }
        r9 = r7.unitType;	 Catch:{ Throwable -> 0x0166 }
        r9 = r9.getUnitType();	 Catch:{ Throwable -> 0x0166 }
        r8 = r8.equalsIgnoreCase(r9);	 Catch:{ Throwable -> 0x0166 }
        if (r8 == 0) goto L_0x0095;	 Catch:{ Throwable -> 0x0166 }
    L_0x006f:
        r8 = r7.unitPrefix;	 Catch:{ Throwable -> 0x0166 }
        r8 = mtopsdk.common.util.i.a(r8);	 Catch:{ Throwable -> 0x0166 }
        if (r8 == 0) goto L_0x0095;	 Catch:{ Throwable -> 0x0166 }
    L_0x0077:
        mtopsdk.mtop.a.d.a();	 Catch:{ Throwable -> 0x0166 }
        r8 = mtopsdk.mtop.a.d.j();	 Catch:{ Throwable -> 0x0166 }
        if (r8 == 0) goto L_0x0095;	 Catch:{ Throwable -> 0x0166 }
    L_0x0080:
        r9 = r8.apilist;	 Catch:{ Throwable -> 0x0166 }
        if (r9 == 0) goto L_0x0095;	 Catch:{ Throwable -> 0x0166 }
    L_0x0084:
        r8 = r8.apilist;	 Catch:{ Throwable -> 0x0166 }
        r9 = new mtopsdk.mtop.unit.ApiInfo;	 Catch:{ Throwable -> 0x0166 }
        r9.<init>(r5, r6);	 Catch:{ Throwable -> 0x0166 }
        r8 = r8.contains(r9);	 Catch:{ Throwable -> 0x0166 }
        if (r8 != 0) goto L_0x0092;	 Catch:{ Throwable -> 0x0166 }
    L_0x0091:
        goto L_0x0095;	 Catch:{ Throwable -> 0x0166 }
    L_0x0092:
        r7 = r7.unitPrefix;	 Catch:{ Throwable -> 0x0166 }
        goto L_0x0096;	 Catch:{ Throwable -> 0x0166 }
    L_0x0095:
        r7 = r4;	 Catch:{ Throwable -> 0x0166 }
    L_0x0096:
        r8 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0166 }
        r9 = 64;	 Catch:{ Throwable -> 0x0166 }
        r8.<init>(r9);	 Catch:{ Throwable -> 0x0166 }
        r7 = r11.a(r7);	 Catch:{ Throwable -> 0x0166 }
        r8.append(r7);	 Catch:{ Throwable -> 0x0166 }
        r7 = "/";	 Catch:{ Throwable -> 0x0166 }
        r8.append(r7);	 Catch:{ Throwable -> 0x0166 }
        r8.append(r5);	 Catch:{ Throwable -> 0x0166 }
        r5 = "/";	 Catch:{ Throwable -> 0x0166 }
        r8.append(r5);	 Catch:{ Throwable -> 0x0166 }
        r8.append(r6);	 Catch:{ Throwable -> 0x0166 }
        r5 = "/";	 Catch:{ Throwable -> 0x0166 }
        r8.append(r5);	 Catch:{ Throwable -> 0x0166 }
        r5 = mtopsdk.mtop.domain.MethodEnum.POST;	 Catch:{ Throwable -> 0x0166 }
        r5 = r5.getMethod();	 Catch:{ Throwable -> 0x0166 }
        r6 = r3.getMethod();	 Catch:{ Throwable -> 0x0166 }
        r5 = r5.equals(r6);	 Catch:{ Throwable -> 0x0166 }
        r6 = 0;	 Catch:{ Throwable -> 0x0166 }
        r7 = 1;	 Catch:{ Throwable -> 0x0166 }
        if (r5 == 0) goto L_0x012a;	 Catch:{ Throwable -> 0x0166 }
    L_0x00cb:
        r5 = "utf-8";	 Catch:{ Throwable -> 0x0166 }
        r12 = mtopsdk.mtop.d.a.a.a(r12, r5);	 Catch:{ Throwable -> 0x0166 }
        r5 = new mtopsdk.mtop.d.a.c;	 Catch:{ Throwable -> 0x0166 }
        r5.<init>(r10, r12);	 Catch:{ Throwable -> 0x0166 }
        r12 = r3.getMethod();	 Catch:{ Throwable -> 0x0166 }
        if (r12 == 0) goto L_0x0122;	 Catch:{ Throwable -> 0x0166 }
    L_0x00dc:
        r3 = r12.length();	 Catch:{ Throwable -> 0x0166 }
        if (r3 != 0) goto L_0x00e3;	 Catch:{ Throwable -> 0x0166 }
    L_0x00e2:
        goto L_0x0122;	 Catch:{ Throwable -> 0x0166 }
    L_0x00e3:
        r3 = com.taobao.tao.remotebusiness.listener.c.a(r12);	 Catch:{ Throwable -> 0x0166 }
        if (r3 != 0) goto L_0x00f9;	 Catch:{ Throwable -> 0x0166 }
    L_0x00e9:
        r3 = "OPTIONS";	 Catch:{ Throwable -> 0x0166 }
        r3 = r12.equals(r3);	 Catch:{ Throwable -> 0x0166 }
        if (r3 != 0) goto L_0x00f9;	 Catch:{ Throwable -> 0x0166 }
    L_0x00f1:
        r3 = "DELETE";	 Catch:{ Throwable -> 0x0166 }
        r3 = r12.equals(r3);	 Catch:{ Throwable -> 0x0166 }
        if (r3 == 0) goto L_0x00fa;	 Catch:{ Throwable -> 0x0166 }
    L_0x00f9:
        r6 = r7;	 Catch:{ Throwable -> 0x0166 }
    L_0x00fa:
        if (r6 != 0) goto L_0x0115;	 Catch:{ Throwable -> 0x0166 }
    L_0x00fc:
        r11 = new java.lang.IllegalArgumentException;	 Catch:{ Throwable -> 0x0166 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0166 }
        r2 = "method ";	 Catch:{ Throwable -> 0x0166 }
        r0.<init>(r2);	 Catch:{ Throwable -> 0x0166 }
        r0.append(r12);	 Catch:{ Throwable -> 0x0166 }
        r12 = " must not have a request body.";	 Catch:{ Throwable -> 0x0166 }
        r0.append(r12);	 Catch:{ Throwable -> 0x0166 }
        r12 = r0.toString();	 Catch:{ Throwable -> 0x0166 }
        r11.<init>(r12);	 Catch:{ Throwable -> 0x0166 }
        throw r11;	 Catch:{ Throwable -> 0x0166 }
    L_0x0115:
        r2.b = r12;	 Catch:{ Throwable -> 0x0166 }
        r2.d = r5;	 Catch:{ Throwable -> 0x0166 }
        r12 = r8.toString();	 Catch:{ Throwable -> 0x0166 }
        r12 = mtopsdk.mtop.d.a.e.a(r12, r4);	 Catch:{ Throwable -> 0x0166 }
        goto L_0x014c;	 Catch:{ Throwable -> 0x0166 }
    L_0x0122:
        r11 = new java.lang.IllegalArgumentException;	 Catch:{ Throwable -> 0x0166 }
        r12 = "method == null || method.length() == 0";	 Catch:{ Throwable -> 0x0166 }
        r11.<init>(r12);	 Catch:{ Throwable -> 0x0166 }
        throw r11;	 Catch:{ Throwable -> 0x0166 }
    L_0x012a:
        r3 = r11.h;	 Catch:{ Throwable -> 0x0166 }
        r5 = r11.j;	 Catch:{ Throwable -> 0x0166 }
        r5 = r5 instanceof mtopsdk.mtop.common.d;	 Catch:{ Throwable -> 0x0166 }
        if (r5 == 0) goto L_0x0133;	 Catch:{ Throwable -> 0x0166 }
    L_0x0132:
        goto L_0x013b;	 Catch:{ Throwable -> 0x0166 }
    L_0x0133:
        if (r3 == 0) goto L_0x013a;	 Catch:{ Throwable -> 0x0166 }
    L_0x0135:
        r3 = r3.useCache;	 Catch:{ Throwable -> 0x0166 }
        if (r3 == 0) goto L_0x013a;	 Catch:{ Throwable -> 0x0166 }
    L_0x0139:
        goto L_0x013b;	 Catch:{ Throwable -> 0x0166 }
    L_0x013a:
        r7 = r6;	 Catch:{ Throwable -> 0x0166 }
    L_0x013b:
        if (r7 != 0) goto L_0x0144;	 Catch:{ Throwable -> 0x0166 }
    L_0x013d:
        r3 = "cache-control";	 Catch:{ Throwable -> 0x0166 }
        r5 = "no-cache";	 Catch:{ Throwable -> 0x0166 }
        r0.put(r3, r5);	 Catch:{ Throwable -> 0x0166 }
    L_0x0144:
        r3 = r8.toString();	 Catch:{ Throwable -> 0x0166 }
        r12 = mtopsdk.mtop.d.a.e.a(r3, r12);	 Catch:{ Throwable -> 0x0166 }
    L_0x014c:
        if (r12 == 0) goto L_0x0156;	 Catch:{ Throwable -> 0x0166 }
    L_0x014e:
        r11 = r11.k;	 Catch:{ Throwable -> 0x0166 }
        r3 = r12.getHost();	 Catch:{ Throwable -> 0x0166 }
        r11.g = r3;	 Catch:{ Throwable -> 0x0166 }
    L_0x0156:
        r11 = r12.toString();	 Catch:{ Throwable -> 0x0166 }
        r2.a(r11);	 Catch:{ Throwable -> 0x0166 }
        if (r0 == 0) goto L_0x0161;	 Catch:{ Throwable -> 0x0166 }
    L_0x015f:
        r2.c = r0;	 Catch:{ Throwable -> 0x0166 }
    L_0x0161:
        r11 = r2.a();	 Catch:{ Throwable -> 0x0166 }
        goto L_0x016c;
    L_0x0166:
        r11 = "[Api4NetworkConverter] convert Request failed!";
        mtopsdk.common.util.j.f(r1, r11);
        r11 = r4;
    L_0x016c:
        return r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.mtop.d.a.b.a(mtopsdk.mtop.a, java.util.Map):mtopsdk.a.b.b");
    }
}
