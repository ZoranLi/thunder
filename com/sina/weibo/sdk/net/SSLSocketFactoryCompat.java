package com.sina.weibo.sdk.net;

import android.os.Build.VERSION;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SSLSocketFactoryCompat extends SSLSocketFactory {
    static String[] cipherSuites;
    static String[] protocols;
    private SSLSocketFactory defaultFactory;

    static {
        try {
            SSLSocket sSLSocket = (SSLSocket) SSLSocketFactory.getDefault().createSocket();
            if (sSLSocket != null) {
                List linkedList = new LinkedList();
                for (String str : sSLSocket.getSupportedProtocols()) {
                    if (!str.toUpperCase().contains("SSL")) {
                        linkedList.add(str);
                    }
                }
                protocols = (String[]) linkedList.toArray(new String[linkedList.size()]);
                if (VERSION.SDK_INT < 21) {
                    Collection asList = Arrays.asList(new String[]{"TLS_RSA_WITH_AES_256_GCM_SHA384", "TLS_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_ECHDE_RSA_WITH_AES_128_GCM_SHA256", "TLS_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA"});
                    Collection asList2 = Arrays.asList(sSLSocket.getSupportedCipherSuites());
                    HashSet hashSet = new HashSet(asList);
                    hashSet.retainAll(asList2);
                    hashSet.addAll(new HashSet(Arrays.asList(sSLSocket.getEnabledCipherSuites())));
                    cipherSuites = (String[]) hashSet.toArray(new String[hashSet.size()]);
                }
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public SSLSocketFactoryCompat(javax.net.ssl.X509TrustManager r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r4.<init>();
        r0 = "TLS";	 Catch:{ GeneralSecurityException -> 0x001e }
        r0 = javax.net.ssl.SSLContext.getInstance(r0);	 Catch:{ GeneralSecurityException -> 0x001e }
        r1 = 0;	 Catch:{ GeneralSecurityException -> 0x001e }
        if (r5 == 0) goto L_0x0013;	 Catch:{ GeneralSecurityException -> 0x001e }
    L_0x000c:
        r2 = 1;	 Catch:{ GeneralSecurityException -> 0x001e }
        r2 = new javax.net.ssl.X509TrustManager[r2];	 Catch:{ GeneralSecurityException -> 0x001e }
        r3 = 0;	 Catch:{ GeneralSecurityException -> 0x001e }
        r2[r3] = r5;	 Catch:{ GeneralSecurityException -> 0x001e }
        goto L_0x0014;	 Catch:{ GeneralSecurityException -> 0x001e }
    L_0x0013:
        r2 = r1;	 Catch:{ GeneralSecurityException -> 0x001e }
    L_0x0014:
        r0.init(r1, r2, r1);	 Catch:{ GeneralSecurityException -> 0x001e }
        r5 = r0.getSocketFactory();	 Catch:{ GeneralSecurityException -> 0x001e }
        r4.defaultFactory = r5;	 Catch:{ GeneralSecurityException -> 0x001e }
        return;
    L_0x001e:
        r5 = new java.lang.AssertionError;
        r5.<init>();
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.net.SSLSocketFactoryCompat.<init>(javax.net.ssl.X509TrustManager):void");
    }

    private void upgradeTLS(SSLSocket sSLSocket) {
        if (protocols != null) {
            sSLSocket.setEnabledProtocols(protocols);
        }
        if (VERSION.SDK_INT < 21 && cipherSuites != null) {
            sSLSocket.setEnabledCipherSuites(cipherSuites);
        }
    }

    public String[] getDefaultCipherSuites() {
        return cipherSuites;
    }

    public String[] getSupportedCipherSuites() {
        return cipherSuites;
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        socket = this.defaultFactory.createSocket(socket, str, i, z);
        if ((socket instanceof SSLSocket) != null) {
            upgradeTLS((SSLSocket) socket);
        }
        return socket;
    }

    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        str = this.defaultFactory.createSocket(str, i);
        if ((str instanceof SSLSocket) != 0) {
            upgradeTLS((SSLSocket) str);
        }
        return str;
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        str = this.defaultFactory.createSocket(str, i, inetAddress, i2);
        if ((str instanceof SSLSocket) != 0) {
            upgradeTLS((SSLSocket) str);
        }
        return str;
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        inetAddress = this.defaultFactory.createSocket(inetAddress, i);
        if ((inetAddress instanceof SSLSocket) != 0) {
            upgradeTLS((SSLSocket) inetAddress);
        }
        return inetAddress;
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        inetAddress = this.defaultFactory.createSocket(inetAddress, i, inetAddress2, i2);
        if ((inetAddress instanceof SSLSocket) != 0) {
            upgradeTLS((SSLSocket) inetAddress);
        }
        return inetAddress;
    }
}
