package com.alipay.sdk.tid;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.util.a;

public final class b {
    private static b c;
    public String a;
    public String b;

    private b() {
    }

    private String b() {
        return this.a;
    }

    private void a(String str) {
        this.a = str;
    }

    private String c() {
        return this.b;
    }

    private void b(String str) {
        this.b = str;
    }

    private void a(android.content.Context r5) {
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
        r4 = this;
        r0 = new com.alipay.sdk.tid.a;
        r0.<init>(r5);
        r1 = com.alipay.sdk.util.a.a(r5);	 Catch:{ Exception -> 0x0025, all -> 0x0020 }
        r1 = r1.a();	 Catch:{ Exception -> 0x0025, all -> 0x0020 }
        r5 = com.alipay.sdk.util.a.a(r5);	 Catch:{ Exception -> 0x0025, all -> 0x0020 }
        r5 = r5.b();	 Catch:{ Exception -> 0x0025, all -> 0x0020 }
        r2 = r4.a;	 Catch:{ Exception -> 0x0025, all -> 0x0020 }
        r3 = r4.b;	 Catch:{ Exception -> 0x0025, all -> 0x0020 }
        r0.a(r1, r5, r2, r3);	 Catch:{ Exception -> 0x0025, all -> 0x0020 }
        r0.close();
        return;
    L_0x0020:
        r5 = move-exception;
        r0.close();
        throw r5;
    L_0x0025:
        r0.close();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.tid.b.a(android.content.Context):void");
    }

    private boolean d() {
        return TextUtils.isEmpty(this.a);
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (c == null) {
                c = new b();
                Context context = com.alipay.sdk.sys.b.a().a;
                a aVar = new a(context);
                String a = a.a(context).a();
                String b = a.a(context).b();
                c.a = aVar.a(a, b);
                c.b = aVar.b(a, b);
                if (TextUtils.isEmpty(c.b)) {
                    b bVar2 = c;
                    String toHexString = Long.toHexString(System.currentTimeMillis());
                    if (toHexString.length() > 10) {
                        toHexString = toHexString.substring(toHexString.length() - 10);
                    }
                    bVar2.b = toHexString;
                }
                aVar.a(a, b, c.a, c.b);
            }
            bVar = c;
        }
        return bVar;
    }

    private static void e() {
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
        r0 = com.alipay.sdk.sys.b.a();
        r0 = r0.a;
        r1 = com.alipay.sdk.util.a.a(r0);
        r1 = r1.a();
        r2 = com.alipay.sdk.util.a.a(r0);
        r8 = r2.b();
        r9 = new com.alipay.sdk.tid.a;
        r9.<init>(r0);
        r0 = 0;
        r10 = r9.getWritableDatabase();	 Catch:{ Exception -> 0x0051, all -> 0x0042 }
        r6 = "";	 Catch:{ Exception -> 0x0040, all -> 0x003e }
        r7 = "";	 Catch:{ Exception -> 0x0040, all -> 0x003e }
        r2 = r9;	 Catch:{ Exception -> 0x0040, all -> 0x003e }
        r3 = r10;	 Catch:{ Exception -> 0x0040, all -> 0x003e }
        r4 = r1;	 Catch:{ Exception -> 0x0040, all -> 0x003e }
        r5 = r8;	 Catch:{ Exception -> 0x0040, all -> 0x003e }
        r2.a(r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x0040, all -> 0x003e }
        r0 = com.alipay.sdk.tid.a.c(r1, r8);	 Catch:{ Exception -> 0x0040, all -> 0x003e }
        com.alipay.sdk.tid.a.a(r10, r0);	 Catch:{ Exception -> 0x0040, all -> 0x003e }
        if (r10 == 0) goto L_0x005c;
    L_0x0034:
        r0 = r10.isOpen();
        if (r0 == 0) goto L_0x005c;
    L_0x003a:
        r10.close();
        goto L_0x005c;
    L_0x003e:
        r0 = move-exception;
        goto L_0x0045;
    L_0x0040:
        r0 = r10;
        goto L_0x0051;
    L_0x0042:
        r1 = move-exception;
        r10 = r0;
        r0 = r1;
    L_0x0045:
        if (r10 == 0) goto L_0x0050;
    L_0x0047:
        r1 = r10.isOpen();
        if (r1 == 0) goto L_0x0050;
    L_0x004d:
        r10.close();
    L_0x0050:
        throw r0;
    L_0x0051:
        if (r0 == 0) goto L_0x005c;
    L_0x0053:
        r1 = r0.isOpen();
        if (r1 == 0) goto L_0x005c;
    L_0x0059:
        r0.close();
    L_0x005c:
        r9.close();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.tid.b.e():void");
    }

    private static String f() {
        String toHexString = Long.toHexString(System.currentTimeMillis());
        return toHexString.length() > 10 ? toHexString.substring(toHexString.length() - 10) : toHexString;
    }
}
