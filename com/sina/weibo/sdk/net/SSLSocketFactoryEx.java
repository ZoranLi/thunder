package com.sina.weibo.sdk.net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class SSLSocketFactoryEx extends SSLSocketFactory {
    private static final String TAG = "com.sina.weibo.sdk.net.SSLSocketFactoryEx";
    SSLContext sslContext = SSLContext.getInstance("TLS");

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
            r3 = new java.security.cert.CertificateException;
            r3.<init>();
            throw r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.net.SSLSocketFactoryEx.KeyStoresTrustManagerEX.checkServerTrusted(java.security.cert.X509Certificate[], java.lang.String):void");
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

    public SSLSocketFactoryEx(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
        SSLContext sSLContext = this.sslContext;
        TrustManager[] trustManagerArr = new TrustManager[1];
        trustManagerArr[0] = new KeyStoresTrustManagerEX(keyStore);
        sSLContext.init(null, trustManagerArr, null);
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException, UnknownHostException {
        return this.sslContext.getSocketFactory().createSocket(socket, str, i, z);
    }

    public Socket createSocket() throws IOException {
        return this.sslContext.getSocketFactory().createSocket();
    }
}
