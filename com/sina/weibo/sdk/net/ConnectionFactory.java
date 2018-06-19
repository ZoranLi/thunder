package com.sina.weibo.sdk.net;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class ConnectionFactory {

    private static class MyHostnameVerifier implements HostnameVerifier {
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }

        private MyHostnameVerifier() {
        }
    }

    public static java.net.HttpURLConnection createConnect(java.lang.String r7, android.content.Context r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.text.TextUtils.isEmpty(r7);
        if (r0 != 0) goto L_0x00a5;
    L_0x0006:
        r0 = "http://";
        r0 = r7.startsWith(r0);
        if (r0 != 0) goto L_0x0018;
    L_0x000e:
        r0 = "https://";
        r0 = r7.startsWith(r0);
        if (r0 != 0) goto L_0x0018;
    L_0x0016:
        goto L_0x00a5;
    L_0x0018:
        r0 = 0;
        r1 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
        r1.<init>(r7);	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
        r2 = com.sina.weibo.sdk.net.NetStateManager.getAPN();	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
        if (r2 == 0) goto L_0x003d;	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
    L_0x0024:
        r3 = new java.net.Proxy;	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
        r4 = java.net.Proxy.Type.HTTP;	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
        r5 = new java.net.InetSocketAddress;	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
        r6 = r2.first;	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
        r6 = (java.lang.String) r6;	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
        r2 = r2.second;	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
        r2 = (java.lang.Integer) r2;	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
        r2 = r2.intValue();	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
        r5.<init>(r6, r2);	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
        r3.<init>(r4, r5);	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
        goto L_0x003e;	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
    L_0x003d:
        r3 = r0;	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
    L_0x003e:
        r2 = "http://";	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
        r7 = r7.startsWith(r2);	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
        if (r7 == 0) goto L_0x0056;	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
    L_0x0046:
        if (r3 != 0) goto L_0x004f;	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
    L_0x0048:
        r7 = r1.openConnection();	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
        r7 = (java.net.HttpURLConnection) r7;	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
        goto L_0x007c;	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
    L_0x004f:
        r7 = r1.openConnection(r3);	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
        r7 = (java.net.HttpURLConnection) r7;	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
        goto L_0x007c;	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
    L_0x0056:
        if (r3 != 0) goto L_0x005f;	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
    L_0x0058:
        r7 = r1.openConnection();	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
        r7 = (javax.net.ssl.HttpsURLConnection) r7;	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
        goto L_0x0065;	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
    L_0x005f:
        r7 = r1.openConnection(r3);	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
        r7 = (javax.net.ssl.HttpsURLConnection) r7;	 Catch:{ MalformedURLException -> 0x007b, MalformedURLException -> 0x007b }
    L_0x0065:
        r1 = r7;	 Catch:{ MalformedURLException -> 0x007c, MalformedURLException -> 0x007c }
        r1 = (javax.net.ssl.HttpsURLConnection) r1;	 Catch:{ MalformedURLException -> 0x007c, MalformedURLException -> 0x007c }
        r2 = new com.sina.weibo.sdk.net.ConnectionFactory$MyHostnameVerifier;	 Catch:{ MalformedURLException -> 0x007c, MalformedURLException -> 0x007c }
        r2.<init>();	 Catch:{ MalformedURLException -> 0x007c, MalformedURLException -> 0x007c }
        r1.setHostnameVerifier(r2);	 Catch:{ MalformedURLException -> 0x007c, MalformedURLException -> 0x007c }
        r0 = r7;	 Catch:{ MalformedURLException -> 0x007c, MalformedURLException -> 0x007c }
        r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ MalformedURLException -> 0x007c, MalformedURLException -> 0x007c }
        r8 = com.sina.weibo.sdk.net.HttpsHelper.getSSL(r8);	 Catch:{ MalformedURLException -> 0x007c, MalformedURLException -> 0x007c }
        r0.setSSLSocketFactory(r8);	 Catch:{ MalformedURLException -> 0x007c, MalformedURLException -> 0x007c }
        goto L_0x007c;
    L_0x007b:
        r7 = r0;
    L_0x007c:
        r8 = 0;
        r7.setUseCaches(r8);
        r8 = "POST";	 Catch:{ ProtocolException -> 0x0085 }
        r7.setRequestMethod(r8);	 Catch:{ ProtocolException -> 0x0085 }
    L_0x0085:
        r8 = "Content-Type";
        r0 = "application/x-www-form-urlencoded";
        r7.setRequestProperty(r8, r0);
        r8 = "Connection";
        r0 = "Keep-Alive";
        r7.setRequestProperty(r8, r0);
        r8 = "Charset";
        r0 = "UTF-8";
        r7.setRequestProperty(r8, r0);
        r8 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r7.setReadTimeout(r8);
        r8 = 25000; // 0x61a8 float:3.5032E-41 double:1.23516E-319;
        r7.setConnectTimeout(r8);
        return r7;
    L_0x00a5:
        r7 = new java.lang.RuntimeException;
        r8 = "非法url请求";
        r7.<init>(r8);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.net.ConnectionFactory.createConnect(java.lang.String, android.content.Context):java.net.HttpURLConnection");
    }
}
