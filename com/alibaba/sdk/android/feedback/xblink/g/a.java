package com.alibaba.sdk.android.feedback.xblink.g;

import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class a implements X509TrustManager {
    X509TrustManager a;

    public a() {
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance.init(null);
        TrustManager[] trustManagers = instance.getTrustManagers();
        for (int i = 0; i < trustManagers.length; i++) {
            if (trustManagers[i] instanceof X509TrustManager) {
                this.a = (X509TrustManager) trustManagers[i];
                return;
            }
        }
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    public void checkServerTrusted(java.security.cert.X509Certificate[] r5, java.lang.String r6) {
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
        r0 = java.util.Calendar.getInstance();
        r1 = 0;
        r2 = android.text.TextUtils.isEmpty(r1);
        if (r2 != 0) goto L_0x0010;
    L_0x000b:
        r1 = java.lang.Long.parseLong(r1);	 Catch:{ NumberFormatException -> 0x0010 }
        goto L_0x0012;
    L_0x0010:
        r1 = 0;
    L_0x0012:
        r3 = 13;
        r1 = (int) r1;
        r0.add(r3, r1);
        r0 = r0.getTime();
        r1 = 0;
    L_0x001d:
        r2 = r5.length;
        if (r1 >= r2) goto L_0x0028;
    L_0x0020:
        r2 = r5[r1];
        r2.checkValidity(r0);
        r1 = r1 + 1;
        goto L_0x001d;
    L_0x0028:
        r0 = r4.a;	 Catch:{ CertificateException -> 0x002e }
        r0.checkServerTrusted(r5, r6);	 Catch:{ CertificateException -> 0x002e }
        return;
    L_0x002e:
        r5 = move-exception;
        r6 = r5;
    L_0x0030:
        r0 = r6.getCause();
        if (r0 == 0) goto L_0x0043;
    L_0x0036:
        r6 = r6.getCause();
        r0 = r6 instanceof java.security.cert.CertificateExpiredException;
        if (r0 != 0) goto L_0x0042;
    L_0x003e:
        r0 = r6 instanceof java.security.cert.CertificateNotYetValidException;
        if (r0 == 0) goto L_0x0030;
    L_0x0042:
        return;
    L_0x0043:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.g.a.checkServerTrusted(java.security.cert.X509Certificate[], java.lang.String):void");
    }

    public X509Certificate[] getAcceptedIssuers() {
        return this.a.getAcceptedIssuers();
    }
}
