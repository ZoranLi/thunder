package com.sina.weibo.sdk.net;

import android.content.Context;
import java.io.IOException;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

class HttpsHelper {
    private static SSLSocketFactory sslSocketFactory;

    public static class KeyStoresTrustManagerEX implements X509TrustManager {
        protected ArrayList<X509TrustManager> x509TrustManagers = new ArrayList();

        protected KeyStoresTrustManagerEX(KeyStore... keyStoreArr) {
            ArrayList arrayList = new ArrayList();
            try {
                TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance.init(null);
                arrayList.add(instance);
                for (KeyStore keyStore : keyStoreArr) {
                    TrustManagerFactory instance2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                    instance2.init(keyStore);
                    arrayList.add(instance2);
                }
                keyStoreArr = arrayList.iterator();
                while (keyStoreArr.hasNext()) {
                    for (TrustManager trustManager : ((TrustManagerFactory) keyStoreArr.next()).getTrustManagers()) {
                        if (trustManager instanceof X509TrustManager) {
                            this.x509TrustManagers.add((X509TrustManager) trustManager);
                        }
                    }
                }
                if (this.x509TrustManagers.size() == null) {
                    throw new RuntimeException("Couldn't find any X509TrustManagers");
                }
            } catch (KeyStore[] keyStoreArr2) {
                throw new RuntimeException(keyStoreArr2);
            }
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            ((X509TrustManager) this.x509TrustManagers.get(0)).checkClientTrusted(x509CertificateArr, str);
        }

        public void checkServerTrusted(java.security.cert.X509Certificate[] r3, java.lang.String r4) throws java.security.cert.CertificateException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r2 = this;
            r0 = r2.x509TrustManagers;
            r0 = r0.iterator();
        L_0x0006:
            r1 = r0.hasNext();
            if (r1 == 0) goto L_0x0016;
        L_0x000c:
            r1 = r0.next();
            r1 = (javax.net.ssl.X509TrustManager) r1;
            r1.checkServerTrusted(r3, r4);	 Catch:{ CertificateException -> 0x0006 }
            return;
        L_0x0016:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.net.HttpsHelper.KeyStoresTrustManagerEX.checkServerTrusted(java.security.cert.X509Certificate[], java.lang.String):void");
        }

        public X509Certificate[] getAcceptedIssuers() {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.x509TrustManagers.iterator();
            while (it.hasNext()) {
                arrayList.addAll(Arrays.asList(((X509TrustManager) it.next()).getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        }
    }

    HttpsHelper() {
    }

    public static javax.net.ssl.SSLSocketFactory getSSL(android.content.Context r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = sslSocketFactory;
        if (r0 == 0) goto L_0x0007;
    L_0x0004:
        r6 = sslSocketFactory;
        return r6;
    L_0x0007:
        r0 = java.security.KeyStore.getDefaultType();	 Catch:{ Exception -> 0x003c }
        r0 = java.security.KeyStore.getInstance(r0);	 Catch:{ Exception -> 0x003c }
        r1 = 0;	 Catch:{ Exception -> 0x003c }
        r0.load(r1, r1);	 Catch:{ Exception -> 0x003c }
        r2 = "geo_global_ca.cer";	 Catch:{ Exception -> 0x003c }
        r6 = getCertificate(r2, r6);	 Catch:{ Exception -> 0x003c }
        r2 = "get_global_ca";	 Catch:{ Exception -> 0x003c }
        r0.setCertificateEntry(r2, r6);	 Catch:{ Exception -> 0x003c }
        r6 = "TLS";	 Catch:{ Exception -> 0x003c }
        r6 = javax.net.ssl.SSLContext.getInstance(r6);	 Catch:{ Exception -> 0x003c }
        r2 = 1;	 Catch:{ Exception -> 0x003c }
        r3 = new javax.net.ssl.TrustManager[r2];	 Catch:{ Exception -> 0x003c }
        r4 = new com.sina.weibo.sdk.net.HttpsHelper$KeyStoresTrustManagerEX;	 Catch:{ Exception -> 0x003c }
        r2 = new java.security.KeyStore[r2];	 Catch:{ Exception -> 0x003c }
        r5 = 0;	 Catch:{ Exception -> 0x003c }
        r2[r5] = r0;	 Catch:{ Exception -> 0x003c }
        r4.<init>(r2);	 Catch:{ Exception -> 0x003c }
        r3[r5] = r4;	 Catch:{ Exception -> 0x003c }
        r6.init(r1, r3, r1);	 Catch:{ Exception -> 0x003c }
        r6 = r6.getSocketFactory();	 Catch:{ Exception -> 0x003c }
        sslSocketFactory = r6;	 Catch:{ Exception -> 0x003c }
    L_0x003c:
        r6 = sslSocketFactory;
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.net.HttpsHelper.getSSL(android.content.Context):javax.net.ssl.SSLSocketFactory");
    }

    private static Certificate getCertificate(String str, Context context) throws CertificateException, IOException {
        CertificateFactory instance = CertificateFactory.getInstance("X.509");
        str = context.getAssets().open(str);
        try {
            context = instance.generateCertificate(str);
            return context;
        } finally {
            if (str != null) {
                str.close();
            }
        }
    }
}
