package com.huawei.hms.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateFactory;

/* compiled from: PackageManagerHelper */
public class e {
    private final PackageManager a;

    /* compiled from: PackageManagerHelper */
    public enum a {
        ENABLED,
        DISABLED,
        NOT_INSTALLED
    }

    public e(Context context) {
        this.a = context.getPackageManager();
    }

    public com.huawei.hms.c.e.a a(java.lang.String r3) {
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
        r2 = this;
        r0 = r2.a;	 Catch:{ NameNotFoundException -> 0x0011 }
        r1 = 0;	 Catch:{ NameNotFoundException -> 0x0011 }
        r3 = r0.getApplicationInfo(r3, r1);	 Catch:{ NameNotFoundException -> 0x0011 }
        r3 = r3.enabled;	 Catch:{ NameNotFoundException -> 0x0011 }
        if (r3 == 0) goto L_0x000e;	 Catch:{ NameNotFoundException -> 0x0011 }
    L_0x000b:
        r3 = com.huawei.hms.c.e.a.ENABLED;	 Catch:{ NameNotFoundException -> 0x0011 }
        return r3;	 Catch:{ NameNotFoundException -> 0x0011 }
    L_0x000e:
        r3 = com.huawei.hms.c.e.a.DISABLED;	 Catch:{ NameNotFoundException -> 0x0011 }
        return r3;
    L_0x0011:
        r3 = com.huawei.hms.c.e.a.NOT_INSTALLED;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.c.e.a(java.lang.String):com.huawei.hms.c.e$a");
    }

    public int b(java.lang.String r4) {
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
        r3 = this;
        r0 = 0;
        r1 = r3.a;	 Catch:{ NameNotFoundException -> 0x000f }
        r2 = 16;	 Catch:{ NameNotFoundException -> 0x000f }
        r4 = r1.getPackageInfo(r4, r2);	 Catch:{ NameNotFoundException -> 0x000f }
        if (r4 == 0) goto L_0x000e;	 Catch:{ NameNotFoundException -> 0x000f }
    L_0x000b:
        r4 = r4.versionCode;	 Catch:{ NameNotFoundException -> 0x000f }
        return r4;
    L_0x000e:
        return r0;
    L_0x000f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.c.e.b(java.lang.String):int");
    }

    public java.lang.String c(java.lang.String r3) {
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
        r2 = this;
        r0 = r2.a;	 Catch:{ NameNotFoundException -> 0x0014 }
        r1 = 16;	 Catch:{ NameNotFoundException -> 0x0014 }
        r3 = r0.getPackageInfo(r3, r1);	 Catch:{ NameNotFoundException -> 0x0014 }
        if (r3 == 0) goto L_0x0011;	 Catch:{ NameNotFoundException -> 0x0014 }
    L_0x000a:
        r0 = r3.versionName;	 Catch:{ NameNotFoundException -> 0x0014 }
        if (r0 == 0) goto L_0x0011;	 Catch:{ NameNotFoundException -> 0x0014 }
    L_0x000e:
        r3 = r3.versionName;	 Catch:{ NameNotFoundException -> 0x0014 }
        return r3;
    L_0x0011:
        r3 = "";
        return r3;
    L_0x0014:
        r3 = "";
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.c.e.c(java.lang.String):java.lang.String");
    }

    public String d(String str) {
        byte[] e = e(str);
        if (e != null) {
            if (e.length != 0) {
                return b.b(f.a(e), true);
            }
        }
        return null;
    }

    private byte[] e(String str) {
        StringBuilder stringBuilder;
        Throwable th;
        InputStream inputStream = null;
        try {
            str = this.a.getPackageInfo(str, 64);
            if (str != null && str.signatures.length > 0) {
                InputStream a = c.a(str.signatures[0].toByteArray());
                try {
                    byte[] encoded = CertificateFactory.getInstance("X.509").generateCertificate(a).getEncoded();
                    c.a(a);
                    return encoded;
                } catch (NameNotFoundException e) {
                    NameNotFoundException nameNotFoundException = e;
                    inputStream = a;
                    str = nameNotFoundException;
                    try {
                        stringBuilder = new StringBuilder("Failed to get application signature certificate fingerprint.");
                        stringBuilder.append(str.getMessage());
                        com.huawei.hms.support.log.a.d("PackageManagerHelper", stringBuilder.toString());
                        c.a(inputStream);
                        com.huawei.hms.support.log.a.d("PackageManagerHelper", "Failed to get application signature certificate fingerprint.");
                        return new byte[0];
                    } catch (Throwable th2) {
                        th = th2;
                        c.a(inputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = a;
                    c.a(inputStream);
                    throw th;
                }
            }
        } catch (NameNotFoundException e2) {
            str = e2;
            stringBuilder = new StringBuilder("Failed to get application signature certificate fingerprint.");
            stringBuilder.append(str.getMessage());
            com.huawei.hms.support.log.a.d("PackageManagerHelper", stringBuilder.toString());
            c.a(inputStream);
            com.huawei.hms.support.log.a.d("PackageManagerHelper", "Failed to get application signature certificate fingerprint.");
            return new byte[0];
        }
        c.a(inputStream);
        com.huawei.hms.support.log.a.d("PackageManagerHelper", "Failed to get application signature certificate fingerprint.");
        return new byte[0];
    }

    public boolean a(java.lang.String r5, java.lang.String r6) {
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
        r0 = 0;
        r1 = r4.a;	 Catch:{ NameNotFoundException -> 0x0025 }
        r2 = 8;	 Catch:{ NameNotFoundException -> 0x0025 }
        r5 = r1.getPackageInfo(r5, r2);	 Catch:{ NameNotFoundException -> 0x0025 }
        if (r5 == 0) goto L_0x0024;	 Catch:{ NameNotFoundException -> 0x0025 }
    L_0x000b:
        r1 = r5.providers;	 Catch:{ NameNotFoundException -> 0x0025 }
        if (r1 == 0) goto L_0x0024;	 Catch:{ NameNotFoundException -> 0x0025 }
    L_0x000f:
        r5 = r5.providers;	 Catch:{ NameNotFoundException -> 0x0025 }
        r1 = r5.length;	 Catch:{ NameNotFoundException -> 0x0025 }
        r2 = r0;	 Catch:{ NameNotFoundException -> 0x0025 }
    L_0x0013:
        if (r2 >= r1) goto L_0x0024;	 Catch:{ NameNotFoundException -> 0x0025 }
    L_0x0015:
        r3 = r5[r2];	 Catch:{ NameNotFoundException -> 0x0025 }
        r3 = r3.authority;	 Catch:{ NameNotFoundException -> 0x0025 }
        r3 = r6.equals(r3);	 Catch:{ NameNotFoundException -> 0x0025 }
        if (r3 == 0) goto L_0x0021;
    L_0x001f:
        r5 = 1;
        return r5;
    L_0x0021:
        r2 = r2 + 1;
        goto L_0x0013;
    L_0x0024:
        return r0;
    L_0x0025:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.c.e.a(java.lang.String, java.lang.String):boolean");
    }

    public boolean a(String str, String str2, String str3) {
        str = this.a.getPackageArchiveInfo(str, 64);
        if (str == null || str.signatures.length <= 0 || str2.equals(str.packageName) == null) {
            return false;
        }
        InputStream a;
        try {
            a = c.a(str.signatures[0].toByteArray());
        } catch (String str4) {
            str2 = str4;
            a = null;
            try {
                StringBuilder stringBuilder = new StringBuilder("Failed to get application signature certificate fingerprint.");
                stringBuilder.append(str2.getMessage());
                com.huawei.hms.support.log.a.d("PackageManagerHelper", stringBuilder.toString());
                c.a(a);
                return false;
            } catch (Throwable th) {
                str2 = th;
                c.a(a);
                throw str2;
            }
        } catch (String str42) {
            str2 = str42;
            a = null;
            c.a(a);
            throw str2;
        }
        try {
            str2 = str3.equalsIgnoreCase(b.b(f.a(CertificateFactory.getInstance("X.509").generateCertificate(a).getEncoded()), true));
            c.a(a);
            return str2;
        } catch (IOException e) {
            str2 = e;
            StringBuilder stringBuilder2 = new StringBuilder("Failed to get application signature certificate fingerprint.");
            stringBuilder2.append(str2.getMessage());
            com.huawei.hms.support.log.a.d("PackageManagerHelper", stringBuilder2.toString());
            c.a(a);
            return false;
        }
    }
}
