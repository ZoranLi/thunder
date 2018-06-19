package com.android.volley.toolbox;

import android.content.Context;
import com.android.volley.l;

/* compiled from: Volley */
public final class ab {
    private static com.android.volley.l b(android.content.Context r5) {
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
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 0;
        r2 = 9;
        if (r0 < r2) goto L_0x0012;
    L_0x0007:
        r0 = new com.android.volley.toolbox.d;
        r2 = new com.android.volley.toolbox.n;
        r2.<init>();
        r0.<init>(r2);
        goto L_0x0046;
    L_0x0012:
        r0 = "volley/0";
        r2 = r5.getPackageName();	 Catch:{ NameNotFoundException -> 0x0037 }
        r3 = r5.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0037 }
        r3 = r3.getPackageInfo(r2, r1);	 Catch:{ NameNotFoundException -> 0x0037 }
        r4 = new java.lang.StringBuilder;	 Catch:{ NameNotFoundException -> 0x0037 }
        r4.<init>();	 Catch:{ NameNotFoundException -> 0x0037 }
        r4.append(r2);	 Catch:{ NameNotFoundException -> 0x0037 }
        r2 = "/";	 Catch:{ NameNotFoundException -> 0x0037 }
        r4.append(r2);	 Catch:{ NameNotFoundException -> 0x0037 }
        r2 = r3.versionCode;	 Catch:{ NameNotFoundException -> 0x0037 }
        r4.append(r2);	 Catch:{ NameNotFoundException -> 0x0037 }
        r2 = r4.toString();	 Catch:{ NameNotFoundException -> 0x0037 }
        r0 = r2;
    L_0x0037:
        r2 = new com.android.volley.toolbox.d;
        r3 = new com.android.volley.toolbox.j;
        r0 = android.net.http.AndroidHttpClient.newInstance(r0);
        r3.<init>(r0);
        r2.<init>(r3);
        r0 = r2;
    L_0x0046:
        r2 = new java.io.File;
        r5 = r5.getCacheDir();
        r3 = "volley";
        r2.<init>(r5, r3);
        r5 = new com.android.volley.l;
        r3 = new com.android.volley.toolbox.i;
        r3.<init>(r2, r1);
        r5.<init>(r3, r0);
        r5.a();
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.ab.b(android.content.Context):com.android.volley.l");
    }

    public static l a(Context context) {
        return b(context);
    }
}
