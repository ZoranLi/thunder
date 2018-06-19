package com.ali.auth.third.core.c;

import android.content.Context;
import com.ali.auth.third.core.b;
import com.ali.auth.third.core.config.Environment;
import com.ali.auth.third.core.h.d;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public final class a {
    public static boolean a = true;
    public static String b = "a_1.0.0-mini";
    public static volatile Context c;
    public static d d;
    public static com.ali.auth.third.core.h.a e;
    public static b f;
    public static final ReentrantLock g = new ReentrantLock();
    public static volatile com.ali.auth.third.core.g.b h = new com.ali.auth.third.core.g.a.a();
    public static com.ali.auth.third.core.h.b i = new com.ali.auth.third.core.h.a.b();

    public static <T> T a(Class<T> cls) {
        return h.a((Class) cls, null);
    }

    public static <T> T a(Class<T> cls, Map<String, String> map) {
        return h.a((Class) cls, (Map) map);
    }

    public static String a() {
        return d.a();
    }

    public static java.lang.String c() {
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
        r0 = c;	 Catch:{ Exception -> 0x0035 }
        r0 = r0.getPackageManager();	 Catch:{ Exception -> 0x0035 }
        r1 = c;	 Catch:{ Exception -> 0x0035 }
        r1 = r1.getPackageName();	 Catch:{ Exception -> 0x0035 }
        r2 = 64;	 Catch:{ Exception -> 0x0035 }
        r0 = r0.getPackageInfo(r1, r2);	 Catch:{ Exception -> 0x0035 }
        r1 = "X.509";	 Catch:{ Exception -> 0x0035 }
        r1 = java.security.cert.CertificateFactory.getInstance(r1);	 Catch:{ Exception -> 0x0035 }
        r2 = new java.io.ByteArrayInputStream;	 Catch:{ Exception -> 0x0035 }
        r0 = r0.signatures;	 Catch:{ Exception -> 0x0035 }
        r3 = 0;	 Catch:{ Exception -> 0x0035 }
        r0 = r0[r3];	 Catch:{ Exception -> 0x0035 }
        r0 = r0.toByteArray();	 Catch:{ Exception -> 0x0035 }
        r2.<init>(r0);	 Catch:{ Exception -> 0x0035 }
        r0 = r1.generateCertificate(r2);	 Catch:{ Exception -> 0x0035 }
        r0 = (java.security.cert.X509Certificate) r0;	 Catch:{ Exception -> 0x0035 }
        r0 = r0.getSerialNumber();	 Catch:{ Exception -> 0x0035 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0035 }
        return r0;
    L_0x0035:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.auth.third.core.c.a.c():java.lang.String");
    }

    public static String d() {
        try {
            X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(c.getPackageManager().getPackageInfo(c.getPackageName(), 64).signatures[0].toByteArray()));
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            instance.update(x509Certificate.getPublicKey().toString().getBytes());
            return com.ali.auth.third.core.j.a.a(instance.digest());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static Environment b() {
        return com.ali.auth.third.core.config.a.a().d;
    }
}
