package com.igexin.assist.action;

import android.text.TextUtils;

class d {
    private byte[] a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;

    d() {
    }

    public void a(com.igexin.assist.MessageBean r6) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r5 = this;
        r0 = r6.getContext();	 Catch:{ Throwable -> 0x00b3 }
        r1 = r6.getStringMessage();	 Catch:{ Throwable -> 0x00b3 }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Throwable -> 0x00b3 }
        if (r2 != 0) goto L_0x00b3;	 Catch:{ Throwable -> 0x00b3 }
    L_0x000e:
        if (r0 != 0) goto L_0x0011;	 Catch:{ Throwable -> 0x00b3 }
    L_0x0010:
        return;	 Catch:{ Throwable -> 0x00b3 }
    L_0x0011:
        r2 = r0.getPackageManager();	 Catch:{ Throwable -> 0x00b3 }
        r3 = r0.getPackageName();	 Catch:{ Throwable -> 0x00b3 }
        r4 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ Throwable -> 0x00b3 }
        r2 = r2.getApplicationInfo(r3, r4);	 Catch:{ Throwable -> 0x00b3 }
        r2 = r2.metaData;	 Catch:{ Throwable -> 0x00b3 }
        r3 = "PUSH_APPID";	 Catch:{ Throwable -> 0x00b3 }
        r2 = r2.getString(r3);	 Catch:{ Throwable -> 0x00b3 }
        r5.d = r2;	 Catch:{ Throwable -> 0x00b3 }
        r2 = r5.d;	 Catch:{ Throwable -> 0x00b3 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x00b3 }
        if (r2 == 0) goto L_0x0032;	 Catch:{ Throwable -> 0x00b3 }
    L_0x0031:
        return;	 Catch:{ Throwable -> 0x00b3 }
    L_0x0032:
        r0 = r0.getPackageName();	 Catch:{ Throwable -> 0x00b3 }
        r5.e = r0;	 Catch:{ Throwable -> 0x00b3 }
        r0 = r6.getMessageSource();	 Catch:{ Throwable -> 0x00b3 }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x00b3 }
        if (r0 == 0) goto L_0x0045;	 Catch:{ Throwable -> 0x00b3 }
    L_0x0042:
        r6 = "";	 Catch:{ Throwable -> 0x00b3 }
        goto L_0x0049;	 Catch:{ Throwable -> 0x00b3 }
    L_0x0045:
        r6 = r6.getMessageSource();	 Catch:{ Throwable -> 0x00b3 }
    L_0x0049:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00b3 }
        r0.<init>();	 Catch:{ Throwable -> 0x00b3 }
        r0.append(r6);	 Catch:{ Throwable -> 0x00b3 }
        r6 = java.util.UUID.randomUUID();	 Catch:{ Throwable -> 0x00b3 }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x00b3 }
        r0.append(r6);	 Catch:{ Throwable -> 0x00b3 }
        r6 = r0.toString();	 Catch:{ Throwable -> 0x00b3 }
        r5.c = r6;	 Catch:{ Throwable -> 0x00b3 }
        r6 = r5.d;	 Catch:{ Throwable -> 0x00b3 }
        r6 = com.igexin.assist.util.a.a(r1, r6);	 Catch:{ Throwable -> 0x00b3 }
        r0 = android.text.TextUtils.isEmpty(r6);	 Catch:{ Throwable -> 0x00b3 }
        if (r0 != 0) goto L_0x00b3;	 Catch:{ Throwable -> 0x00b3 }
    L_0x006e:
        r0 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x00b3 }
        r0.<init>(r6);	 Catch:{ Throwable -> 0x00b3 }
        r6 = "TI";	 Catch:{ Throwable -> 0x00b3 }
        r6 = r0.has(r6);	 Catch:{ Throwable -> 0x00b3 }
        if (r6 == 0) goto L_0x0083;	 Catch:{ Throwable -> 0x00b3 }
    L_0x007b:
        r6 = "TI";	 Catch:{ Throwable -> 0x00b3 }
        r6 = r0.getString(r6);	 Catch:{ Throwable -> 0x00b3 }
        r5.b = r6;	 Catch:{ Throwable -> 0x00b3 }
    L_0x0083:
        r6 = "AC";	 Catch:{ Throwable -> 0x00b3 }
        r6 = r0.has(r6);	 Catch:{ Throwable -> 0x00b3 }
        if (r6 == 0) goto L_0x0093;	 Catch:{ Throwable -> 0x00b3 }
    L_0x008b:
        r6 = "AC";	 Catch:{ Throwable -> 0x00b3 }
        r6 = r0.getString(r6);	 Catch:{ Throwable -> 0x00b3 }
        r5.f = r6;	 Catch:{ Throwable -> 0x00b3 }
    L_0x0093:
        r6 = "CT";	 Catch:{ Throwable -> 0x00b3 }
        r6 = r0.has(r6);	 Catch:{ Throwable -> 0x00b3 }
        if (r6 == 0) goto L_0x00b3;	 Catch:{ Throwable -> 0x00b3 }
    L_0x009b:
        r6 = "CT";	 Catch:{ Throwable -> 0x00b3 }
        r6 = r0.getString(r6);	 Catch:{ Throwable -> 0x00b3 }
        r6 = android.text.TextUtils.isEmpty(r6);	 Catch:{ Throwable -> 0x00b3 }
        if (r6 != 0) goto L_0x00b3;	 Catch:{ Throwable -> 0x00b3 }
    L_0x00a7:
        r6 = "CT";	 Catch:{ Throwable -> 0x00b3 }
        r6 = r0.getString(r6);	 Catch:{ Throwable -> 0x00b3 }
        r6 = r6.getBytes();	 Catch:{ Throwable -> 0x00b3 }
        r5.a = r6;	 Catch:{ Throwable -> 0x00b3 }
    L_0x00b3:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.assist.action.d.a(com.igexin.assist.MessageBean):void");
    }

    public boolean a() {
        if (!(this.a == null || TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.e) || TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.f))) {
            if (!TextUtils.isEmpty(this.c)) {
                return true;
            }
        }
        return false;
    }

    public byte[] b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public String e() {
        return this.d;
    }

    public String f() {
        return this.f;
    }

    public String g() {
        return this.e;
    }
}
