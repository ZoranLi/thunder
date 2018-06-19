package com.igexin.sdk.a;

import com.igexin.sdk.IPushCore;

public class a {
    private static String a = "PushSdk";
    private static a c;
    private IPushCore b;

    private a() {
    }

    public static a a() {
        if (c == null) {
            c = new a();
        }
        return c;
    }

    public void a(IPushCore iPushCore) {
        this.b = iPushCore;
    }

    public boolean a(android.content.Context r2) {
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
        r1 = this;
        r0 = "com.igexin.push.core.stub.PushCore";
        r2 = r2.getClassLoader();	 Catch:{ Exception -> 0x0017 }
        r2 = r2.loadClass(r0);	 Catch:{ Exception -> 0x0017 }
        r2 = r2.newInstance();	 Catch:{ Exception -> 0x0017 }
        r2 = (com.igexin.sdk.IPushCore) r2;	 Catch:{ Exception -> 0x0017 }
        if (r2 == 0) goto L_0x0017;	 Catch:{ Exception -> 0x0017 }
    L_0x0012:
        r1.a(r2);	 Catch:{ Exception -> 0x0017 }
        r2 = 1;
        return r2;
    L_0x0017:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.sdk.a.a.a(android.content.Context):boolean");
    }

    public IPushCore b() {
        return this.b;
    }
}
