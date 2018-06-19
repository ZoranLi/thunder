package com.igexin.push.config;

public class o {
    public static void a(java.lang.String r2, boolean r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = new java.lang.StringBuilder;
        r1 = "IDCConfigParse parse idc config data : ";
        r0.<init>(r1);
        r0.append(r2);
        r0 = r0.toString();
        com.igexin.b.a.c.a.b(r0);
        r0 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0017 }
        r0.<init>(r2);	 Catch:{ Exception -> 0x0017 }
        goto L_0x0018;
    L_0x0017:
        r0 = 0;
    L_0x0018:
        if (r0 != 0) goto L_0x001b;
    L_0x001a:
        return;
    L_0x001b:
        r2 = "N";
        r2 = r0.has(r2);
        if (r2 == 0) goto L_0x002c;
    L_0x0023:
        r2 = "N";	 Catch:{ JSONException -> 0x002c }
        r2 = r0.getString(r2);	 Catch:{ JSONException -> 0x002c }
        com.igexin.push.config.SDKUrlConfig.setLocation(r2);	 Catch:{ JSONException -> 0x002c }
    L_0x002c:
        r2 = "X1";
        r2 = r0.has(r2);
        if (r2 == 0) goto L_0x0050;
    L_0x0034:
        r2 = "X1";
        r2 = a(r0, r2);
        if (r2 == 0) goto L_0x0050;
    L_0x003c:
        r1 = r2.length;
        if (r1 <= 0) goto L_0x0050;
    L_0x003f:
        com.igexin.push.config.SDKUrlConfig.setXfrAddressIps(r2);
        r2 = "Detect_IDCConfigParse parse idc success, set new xfr address, reset and redetect +++++++++++++++++";
        com.igexin.b.a.c.a.b(r2);
        if (r3 == 0) goto L_0x0050;
    L_0x0049:
        r2 = com.igexin.push.c.i.a();
        r2.h();
    L_0x0050:
        r2 = "X2";
        r2 = r0.has(r2);
        if (r2 == 0) goto L_0x0065;
    L_0x0058:
        r2 = "X2";
        r2 = a(r0, r2);
        if (r2 == 0) goto L_0x0065;
    L_0x0060:
        r3 = r2.length;
        if (r3 <= 0) goto L_0x0065;
    L_0x0063:
        com.igexin.push.config.SDKUrlConfig.XFR_ADDRESS_BAK = r2;
    L_0x0065:
        r2 = "B";
        r2 = r0.has(r2);
        if (r2 == 0) goto L_0x007a;
    L_0x006d:
        r2 = "B";
        r2 = a(r0, r2);
        if (r2 == 0) goto L_0x007a;
    L_0x0075:
        r3 = r2.length;
        if (r3 <= 0) goto L_0x007a;
    L_0x0078:
        com.igexin.push.config.SDKUrlConfig.BI_ADDRESS_IPS = r2;
    L_0x007a:
        r2 = "C";
        r2 = r0.has(r2);
        if (r2 == 0) goto L_0x008f;
    L_0x0082:
        r2 = "C";
        r2 = a(r0, r2);
        if (r2 == 0) goto L_0x008f;
    L_0x008a:
        r3 = r2.length;
        if (r3 <= 0) goto L_0x008f;
    L_0x008d:
        com.igexin.push.config.SDKUrlConfig.CONFIG_ADDRESS_IPS = r2;
    L_0x008f:
        r2 = "S";
        r2 = r0.has(r2);
        if (r2 == 0) goto L_0x00a4;
    L_0x0097:
        r2 = "S";
        r2 = a(r0, r2);
        if (r2 == 0) goto L_0x00a4;
    L_0x009f:
        r3 = r2.length;
        if (r3 <= 0) goto L_0x00a4;
    L_0x00a2:
        com.igexin.push.config.SDKUrlConfig.STATE_ADDRESS_IPS = r2;
    L_0x00a4:
        r2 = "LO";
        r2 = r0.has(r2);
        if (r2 == 0) goto L_0x00b9;
    L_0x00ac:
        r2 = "LO";
        r2 = a(r0, r2);
        if (r2 == 0) goto L_0x00b9;
    L_0x00b4:
        r3 = r2.length;
        if (r3 <= 0) goto L_0x00b9;
    L_0x00b7:
        com.igexin.push.config.SDKUrlConfig.LOG_ADDRESS_IPS = r2;
    L_0x00b9:
        r2 = "A";
        r2 = r0.has(r2);
        if (r2 == 0) goto L_0x00ce;
    L_0x00c1:
        r2 = "A";
        r2 = a(r0, r2);
        if (r2 == 0) goto L_0x00ce;
    L_0x00c9:
        r3 = r2.length;
        if (r3 <= 0) goto L_0x00ce;
    L_0x00cc:
        com.igexin.push.config.SDKUrlConfig.AMP_ADDRESS_IPS = r2;
    L_0x00ce:
        r2 = "LB";
        r2 = r0.has(r2);
        if (r2 == 0) goto L_0x00e3;
    L_0x00d6:
        r2 = "LB";
        r2 = a(r0, r2);
        if (r2 == 0) goto L_0x00e3;
    L_0x00de:
        r3 = r2.length;
        if (r3 <= 0) goto L_0x00e3;
    L_0x00e1:
        com.igexin.push.config.SDKUrlConfig.LBS_ADDRESS_IPS = r2;
    L_0x00e3:
        r2 = "I";
        r2 = r0.has(r2);
        if (r2 == 0) goto L_0x00f8;
    L_0x00eb:
        r2 = "I";
        r2 = a(r0, r2);
        if (r2 == 0) goto L_0x00f8;
    L_0x00f3:
        r3 = r2.length;
        if (r3 <= 0) goto L_0x00f8;
    L_0x00f6:
        com.igexin.push.config.SDKUrlConfig.INC_ADDRESS_IPS = r2;
    L_0x00f8:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.config.o.a(java.lang.String, boolean):void");
    }

    private static java.lang.String[] a(org.json.JSONObject r5, java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r5 = r5.getJSONArray(r6);	 Catch:{ Exception -> 0x004b }
        r0 = r5.length();	 Catch:{ Exception -> 0x004b }
        r1 = new java.lang.String[r0];	 Catch:{ Exception -> 0x004b }
        r2 = 0;	 Catch:{ Exception -> 0x004b }
    L_0x000b:
        if (r2 >= r0) goto L_0x004a;	 Catch:{ Exception -> 0x004b }
    L_0x000d:
        r3 = "X1";	 Catch:{ Exception -> 0x004b }
        r3 = r6.equals(r3);	 Catch:{ Exception -> 0x004b }
        if (r3 != 0) goto L_0x0033;	 Catch:{ Exception -> 0x004b }
    L_0x0015:
        r3 = "X2";	 Catch:{ Exception -> 0x004b }
        r3 = r6.equals(r3);	 Catch:{ Exception -> 0x004b }
        if (r3 == 0) goto L_0x001e;	 Catch:{ Exception -> 0x004b }
    L_0x001d:
        goto L_0x0033;	 Catch:{ Exception -> 0x004b }
    L_0x001e:
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x004b }
        r4 = "http://";	 Catch:{ Exception -> 0x004b }
        r3.<init>(r4);	 Catch:{ Exception -> 0x004b }
        r4 = r5.getString(r2);	 Catch:{ Exception -> 0x004b }
        r3.append(r4);	 Catch:{ Exception -> 0x004b }
        r3 = r3.toString();	 Catch:{ Exception -> 0x004b }
        r1[r2] = r3;	 Catch:{ Exception -> 0x004b }
        goto L_0x0047;	 Catch:{ Exception -> 0x004b }
    L_0x0033:
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x004b }
        r4 = "socket://";	 Catch:{ Exception -> 0x004b }
        r3.<init>(r4);	 Catch:{ Exception -> 0x004b }
        r4 = r5.getString(r2);	 Catch:{ Exception -> 0x004b }
        r3.append(r4);	 Catch:{ Exception -> 0x004b }
        r3 = r3.toString();	 Catch:{ Exception -> 0x004b }
        r1[r2] = r3;	 Catch:{ Exception -> 0x004b }
    L_0x0047:
        r2 = r2 + 1;
        goto L_0x000b;
    L_0x004a:
        return r1;
    L_0x004b:
        r5 = 0;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.config.o.a(org.json.JSONObject, java.lang.String):java.lang.String[]");
    }
}
