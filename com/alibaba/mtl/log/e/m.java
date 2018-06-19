package com.alibaba.mtl.log.e;

import java.util.Random;

/* compiled from: PhoneInfoUtils */
public final class m {
    private static final Random a = new Random();

    private static String a() {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nanoTime = (int) System.nanoTime();
        int nextInt = a.nextInt();
        int nextInt2 = a.nextInt();
        Object a = f.a(currentTimeMillis);
        Object a2 = f.a(nanoTime);
        Object a3 = f.a(nextInt);
        Object a4 = f.a(nextInt2);
        Object obj = new byte[16];
        System.arraycopy(a, 0, obj, 0, 4);
        System.arraycopy(a2, 0, obj, 4, 4);
        System.arraycopy(a3, 0, obj, 8, 4);
        System.arraycopy(a4, 0, obj, 12, 4);
        return c.b(obj);
    }

    public static java.lang.String a(android.content.Context r5) {
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
        r0 = 0;
        r1 = 0;
        if (r5 == 0) goto L_0x003d;
    L_0x0004:
        r2 = "UTCommon";	 Catch:{ Exception -> 0x002e }
        r2 = r5.getSharedPreferences(r2, r0);	 Catch:{ Exception -> 0x002e }
        r3 = "_ie";	 Catch:{ Exception -> 0x002e }
        r4 = "";	 Catch:{ Exception -> 0x002e }
        r2 = r2.getString(r3, r4);	 Catch:{ Exception -> 0x002e }
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Exception -> 0x002e }
        if (r3 != 0) goto L_0x002e;	 Catch:{ Exception -> 0x002e }
    L_0x0018:
        r3 = new java.lang.String;	 Catch:{ Exception -> 0x002e }
        r2 = r2.getBytes();	 Catch:{ Exception -> 0x002e }
        r2 = com.alibaba.mtl.log.e.c.a(r2);	 Catch:{ Exception -> 0x002e }
        r4 = "UTF-8";	 Catch:{ Exception -> 0x002e }
        r3.<init>(r2, r4);	 Catch:{ Exception -> 0x002e }
        r2 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Exception -> 0x002e }
        if (r2 != 0) goto L_0x002e;
    L_0x002d:
        return r3;
    L_0x002e:
        r2 = "phone";	 Catch:{ Exception -> 0x003d }
        r2 = r5.getSystemService(r2);	 Catch:{ Exception -> 0x003d }
        r2 = (android.telephony.TelephonyManager) r2;	 Catch:{ Exception -> 0x003d }
        if (r2 == 0) goto L_0x003d;	 Catch:{ Exception -> 0x003d }
    L_0x0038:
        r2 = r2.getDeviceId();	 Catch:{ Exception -> 0x003d }
        r1 = r2;
    L_0x003d:
        r2 = android.text.TextUtils.isEmpty(r1);
        if (r2 == 0) goto L_0x0047;
    L_0x0043:
        r1 = a();
    L_0x0047:
        if (r5 == 0) goto L_0x006f;
    L_0x0049:
        r2 = "UTCommon";	 Catch:{ UnsupportedEncodingException -> 0x006b }
        r5 = r5.getSharedPreferences(r2, r0);	 Catch:{ UnsupportedEncodingException -> 0x006b }
        r5 = r5.edit();	 Catch:{ UnsupportedEncodingException -> 0x006b }
        r0 = "_ie";	 Catch:{ UnsupportedEncodingException -> 0x006b }
        r2 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x006b }
        r3 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x006b }
        r3 = r1.getBytes(r3);	 Catch:{ UnsupportedEncodingException -> 0x006b }
        r3 = com.alibaba.mtl.log.e.c.c(r3);	 Catch:{ UnsupportedEncodingException -> 0x006b }
        r2.<init>(r3);	 Catch:{ UnsupportedEncodingException -> 0x006b }
        r5.putString(r0, r2);	 Catch:{ UnsupportedEncodingException -> 0x006b }
        r5.commit();	 Catch:{ UnsupportedEncodingException -> 0x006b }
        goto L_0x006f;
    L_0x006b:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x006f:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.e.m.a(android.content.Context):java.lang.String");
    }

    public static java.lang.String b(android.content.Context r5) {
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
        r0 = 0;
        r1 = 0;
        if (r5 == 0) goto L_0x003d;
    L_0x0004:
        r2 = "UTCommon";	 Catch:{ Exception -> 0x002e }
        r2 = r5.getSharedPreferences(r2, r0);	 Catch:{ Exception -> 0x002e }
        r3 = "_is";	 Catch:{ Exception -> 0x002e }
        r4 = "";	 Catch:{ Exception -> 0x002e }
        r2 = r2.getString(r3, r4);	 Catch:{ Exception -> 0x002e }
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Exception -> 0x002e }
        if (r3 != 0) goto L_0x002e;	 Catch:{ Exception -> 0x002e }
    L_0x0018:
        r3 = new java.lang.String;	 Catch:{ Exception -> 0x002e }
        r2 = r2.getBytes();	 Catch:{ Exception -> 0x002e }
        r2 = com.alibaba.mtl.log.e.c.a(r2);	 Catch:{ Exception -> 0x002e }
        r4 = "UTF-8";	 Catch:{ Exception -> 0x002e }
        r3.<init>(r2, r4);	 Catch:{ Exception -> 0x002e }
        r2 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Exception -> 0x002e }
        if (r2 != 0) goto L_0x002e;
    L_0x002d:
        return r3;
    L_0x002e:
        r2 = "phone";	 Catch:{ Exception -> 0x003d }
        r2 = r5.getSystemService(r2);	 Catch:{ Exception -> 0x003d }
        r2 = (android.telephony.TelephonyManager) r2;	 Catch:{ Exception -> 0x003d }
        if (r2 == 0) goto L_0x003d;	 Catch:{ Exception -> 0x003d }
    L_0x0038:
        r2 = r2.getSubscriberId();	 Catch:{ Exception -> 0x003d }
        r1 = r2;
    L_0x003d:
        r2 = android.text.TextUtils.isEmpty(r1);
        if (r2 == 0) goto L_0x0047;
    L_0x0043:
        r1 = a();
    L_0x0047:
        if (r5 == 0) goto L_0x006f;
    L_0x0049:
        r2 = "UTCommon";	 Catch:{ UnsupportedEncodingException -> 0x006b }
        r5 = r5.getSharedPreferences(r2, r0);	 Catch:{ UnsupportedEncodingException -> 0x006b }
        r5 = r5.edit();	 Catch:{ UnsupportedEncodingException -> 0x006b }
        r0 = "_is";	 Catch:{ UnsupportedEncodingException -> 0x006b }
        r2 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x006b }
        r3 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x006b }
        r3 = r1.getBytes(r3);	 Catch:{ UnsupportedEncodingException -> 0x006b }
        r3 = com.alibaba.mtl.log.e.c.c(r3);	 Catch:{ UnsupportedEncodingException -> 0x006b }
        r2.<init>(r3);	 Catch:{ UnsupportedEncodingException -> 0x006b }
        r5.putString(r0, r2);	 Catch:{ UnsupportedEncodingException -> 0x006b }
        r5.commit();	 Catch:{ UnsupportedEncodingException -> 0x006b }
        goto L_0x006f;
    L_0x006b:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x006f:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.e.m.b(android.content.Context):java.lang.String");
    }
}
