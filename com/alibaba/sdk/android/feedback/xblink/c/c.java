package com.alibaba.sdk.android.feedback.xblink.c;

import anet.channel.util.HttpConstant;
import com.alibaba.sdk.android.feedback.xblink.webview.t;
import com.xiaomi.push.service.av;
import java.net.HttpURLConnection;
import java.util.Map;
import java.util.Map.Entry;

public class c {
    private static String a = "HttpConnector";
    private int b = 0;
    private b c = null;

    static {
        System.setProperty("http.keepAlive", av.b);
    }

    private void a(HttpURLConnection httpURLConnection, h hVar) {
        int h = hVar.h() + 1;
        httpURLConnection.setConnectTimeout(hVar.e() * h);
        httpURLConnection.setReadTimeout(hVar.f() * h);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty(HttpConstant.HOST, hVar.a().getHost());
        httpURLConnection.setRequestProperty(HttpConstant.CONNECTION, "close");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String a = t.a(httpURLConnection.getURL().toString());
        if (a != null) {
            httpURLConnection.setRequestProperty(HttpConstant.COOKIE, a);
        }
        Map d = hVar.d();
        if (d != null) {
            for (Entry entry : d.entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        httpURLConnection.setUseCaches(false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.alibaba.sdk.android.feedback.xblink.c.i b(com.alibaba.sdk.android.feedback.xblink.c.h r15) {
        /*
        r14 = this;
        r0 = r15.a();
        r1 = com.alibaba.sdk.android.feedback.xblink.i.g.a();
        if (r1 == 0) goto L_0x0021;
    L_0x000a:
        r1 = a;
        r2 = new java.lang.StringBuilder;
        r3 = "url:";
        r2.<init>(r3);
        r3 = r0.toString();
        r2.append(r3);
        r2 = r2.toString();
        com.alibaba.sdk.android.feedback.xblink.i.g.c(r1, r2);
    L_0x0021:
        r1 = r14.c;
        if (r1 == 0) goto L_0x002a;
    L_0x0025:
        r1 = r14.c;
        r1.a();
    L_0x002a:
        r1 = new com.alibaba.sdk.android.feedback.xblink.c.i;
        r1.<init>();
        r2 = "https";
        r3 = r0.getScheme();
        r2 = r2.equalsIgnoreCase(r3);
        r3 = new java.io.ByteArrayOutputStream;
        r4 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r3.<init>(r4);
        r4 = -1;
        r5 = 0;
        r6 = new java.net.URL;	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        r0 = r0.toString();	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        r6.<init>(r0);	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        r0 = r6.getHost();	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        r7 = 0;
        r8 = 1;
        if (r2 == 0) goto L_0x011b;
    L_0x0053:
        r2 = a;	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        r9 = "proxy or https";
        com.alibaba.sdk.android.feedback.xblink.i.g.c(r2, r9);	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        r2 = com.alibaba.sdk.android.feedback.xblink.g.d.a();	 Catch:{ Exception -> 0x0085, g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, all -> 0x0358 }
        if (r2 == 0) goto L_0x0069;
    L_0x0060:
        r2 = new javax.net.ssl.TrustManager[r8];	 Catch:{ Exception -> 0x0085, g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, all -> 0x0358 }
        r9 = com.alibaba.sdk.android.feedback.xblink.g.d.a();	 Catch:{ Exception -> 0x0085, g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, all -> 0x0358 }
        r2[r7] = r9;	 Catch:{ Exception -> 0x0085, g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, all -> 0x0358 }
        goto L_0x0072;
    L_0x0069:
        r2 = new javax.net.ssl.TrustManager[r8];	 Catch:{ Exception -> 0x0085, g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, all -> 0x0358 }
        r9 = new com.alibaba.sdk.android.feedback.xblink.g.a;	 Catch:{ Exception -> 0x0085, g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, all -> 0x0358 }
        r9.<init>();	 Catch:{ Exception -> 0x0085, g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, all -> 0x0358 }
        r2[r7] = r9;	 Catch:{ Exception -> 0x0085, g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, all -> 0x0358 }
    L_0x0072:
        r9 = "TLS";
        r9 = javax.net.ssl.SSLContext.getInstance(r9);	 Catch:{ Exception -> 0x0085, g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, all -> 0x0358 }
        r10 = new java.security.SecureRandom;	 Catch:{ Exception -> 0x0085, g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, all -> 0x0358 }
        r10.<init>();	 Catch:{ Exception -> 0x0085, g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, all -> 0x0358 }
        r9.init(r5, r2, r10);	 Catch:{ Exception -> 0x0085, g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, all -> 0x0358 }
        r2 = r9.getSocketFactory();	 Catch:{ Exception -> 0x0085, g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, all -> 0x0358 }
        goto L_0x0090;
    L_0x0085:
        r2 = move-exception;
        r9 = a;	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r9, r2);	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        r2 = r5;
    L_0x0090:
        r9 = com.alibaba.sdk.android.feedback.xblink.b.b.d;	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        r9 = com.alibaba.sdk.android.feedback.xblink.i.f.a(r9);	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        if (r9 == 0) goto L_0x00d1;
    L_0x0098:
        r10 = com.alibaba.sdk.android.feedback.xblink.i.g.a();	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        if (r10 == 0) goto L_0x00c1;
    L_0x009e:
        r10 = a;	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        r11 = new java.lang.StringBuilder;	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        r12 = "https:proxy:";
        r11.<init>(r12);	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        r12 = r9.getHostName();	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        r11.append(r12);	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        r12 = ":";
        r11.append(r12);	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        r12 = r9.getPort();	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        r11.append(r12);	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        r11 = r11.toString();	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        com.alibaba.sdk.android.feedback.xblink.i.g.a(r10, r11);	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
    L_0x00c1:
        r10 = new com.alibaba.sdk.android.feedback.xblink.g.b;	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        r11 = r9.getHostName();	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        r9 = r9.getPort();	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        r12 = "taobao_hybrid_4.5.1";
        r10.<init>(r11, r9, r2, r12);	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        goto L_0x00d9;
    L_0x00d1:
        r9 = a;	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        r10 = "https:proxy: none";
        com.alibaba.sdk.android.feedback.xblink.i.g.a(r9, r10);	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        r10 = r5;
    L_0x00d9:
        r6 = r6.openConnection();	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        r6 = (javax.net.ssl.HttpsURLConnection) r6;	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        if (r10 == 0) goto L_0x00e5;
    L_0x00e1:
        r6.setSSLSocketFactory(r10);	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        goto L_0x00e8;
    L_0x00e5:
        r6.setSSLSocketFactory(r2);	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
    L_0x00e8:
        r2 = com.alibaba.sdk.android.feedback.xblink.g.d.a();	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        if (r2 != 0) goto L_0x00f6;
    L_0x00ee:
        r2 = new org.apache.http.conn.ssl.StrictHostnameVerifier;	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        r2.<init>();	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        r6.setHostnameVerifier(r2);	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
    L_0x00f6:
        r2 = "Connection";
        r9 = "Keep-Alive";
        r6.setRequestProperty(r2, r9);	 Catch:{ g -> 0x0115, d -> 0x010f, SSLHandshakeException -> 0x010a, Exception -> 0x0104, all -> 0x00ff }
        r2 = r6;
        goto L_0x0121;
    L_0x00ff:
        r15 = move-exception;
        r0 = r5;
        r2 = r6;
        goto L_0x033d;
    L_0x0104:
        r15 = move-exception;
        r0 = r5;
        r1 = r0;
        r5 = r6;
        goto L_0x0361;
    L_0x010a:
        r15 = move-exception;
        r0 = r5;
        r2 = r6;
        goto L_0x0348;
    L_0x010f:
        r15 = move-exception;
        r0 = r5;
        r1 = r0;
        r5 = r6;
        goto L_0x0400;
    L_0x0115:
        r15 = move-exception;
        r0 = r5;
        r1 = r0;
        r5 = r6;
        goto L_0x0411;
    L_0x011b:
        r2 = r6.openConnection();	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ g -> 0x040e, d -> 0x03fd, SSLHandshakeException -> 0x0390, Exception -> 0x035e, all -> 0x0358 }
    L_0x0121:
        r14.a(r2, r15);	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r6 = r14.c;	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        if (r6 == 0) goto L_0x012d;
    L_0x0128:
        r6 = r14.c;	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r6.a(r7);	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
    L_0x012d:
        r6 = "post";
        r9 = r15.c();	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r6 = r6.equalsIgnoreCase(r9);	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        if (r6 == 0) goto L_0x0181;
    L_0x0139:
        r6 = com.alibaba.sdk.android.feedback.xblink.i.g.a();	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        if (r6 == 0) goto L_0x0161;
    L_0x013f:
        r6 = r15.b();	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        if (r6 == 0) goto L_0x0161;
    L_0x0145:
        r6 = a;	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r9 = new java.lang.StringBuilder;	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r10 = "post data: ";
        r9.<init>(r10);	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r10 = new java.lang.String;	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r11 = r15.b();	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r10.<init>(r11);	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r9.append(r10);	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r9 = r9.toString();	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        com.alibaba.sdk.android.feedback.xblink.i.g.a(r6, r9);	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
    L_0x0161:
        r2.setDoOutput(r8);	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r2.setDoInput(r8);	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r6 = "POST";
        r2.setRequestMethod(r6);	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r2.connect();	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r6 = r2.getOutputStream();	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r9 = r15.b();	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r6.write(r9);	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r6.flush();	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r6.close();	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        goto L_0x0184;
    L_0x0181:
        r2.connect();	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
    L_0x0184:
        r6 = r2.getResponseCode();	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r9 = com.alibaba.sdk.android.feedback.xblink.i.g.a();	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        if (r9 == 0) goto L_0x01a1;
    L_0x018e:
        r9 = a;	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r10 = new java.lang.StringBuilder;	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r11 = "responeCode:";
        r10.<init>(r11);	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r10.append(r6);	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r10 = r10.toString();	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        com.alibaba.sdk.android.feedback.xblink.i.g.c(r9, r10);	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
    L_0x01a1:
        r9 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r6 < r9) goto L_0x0224;
    L_0x01a5:
        r10 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r6 >= r10) goto L_0x0224;
    L_0x01a9:
        r10 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        if (r6 == r10) goto L_0x0224;
    L_0x01ad:
        r10 = r15.g();	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        if (r10 == 0) goto L_0x0224;
    L_0x01b3:
        r10 = r14.b;	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r11 = 5;
        if (r10 <= r11) goto L_0x01c0;
    L_0x01b8:
        r15 = new com.alibaba.sdk.android.feedback.xblink.c.g;	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r0 = "too many redirect";
        r15.<init>(r14, r0);	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        throw r15;	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
    L_0x01c0:
        r10 = r14.b;	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r10 = r10 + r8;
        r14.b = r10;	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r10 = "location";
        r10 = r2.getHeaderField(r10);	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        if (r10 == 0) goto L_0x0224;
    L_0x01cd:
        r1 = r10.toLowerCase();	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r7 = "http";
        r1 = r1.startsWith(r7);	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        if (r1 != 0) goto L_0x01e4;
    L_0x01d9:
        r1 = new java.net.URL;	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r7 = "http";
        r1.<init>(r7, r0, r10);	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r10 = r1.toString();	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
    L_0x01e4:
        r0 = 305; // 0x131 float:4.27E-43 double:1.507E-321;
        if (r6 == r0) goto L_0x0207;
    L_0x01e8:
        r0 = android.net.Uri.parse(r10);	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r15.a(r0);	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r15 = r14.b(r15);	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r3.close();	 Catch:{ Exception -> 0x01f7 }
        goto L_0x0201;
    L_0x01f7:
        r0 = move-exception;
        r1 = a;
        r0 = java.lang.String.valueOf(r0);
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r1, r0);
    L_0x0201:
        if (r2 == 0) goto L_0x0206;
    L_0x0203:
        r2.disconnect();
    L_0x0206:
        return r15;
    L_0x0207:
        r15 = new com.alibaba.sdk.android.feedback.xblink.c.h;	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r15.<init>(r10);	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r15 = r14.b(r15);	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r3.close();	 Catch:{ Exception -> 0x0214 }
        goto L_0x021e;
    L_0x0214:
        r0 = move-exception;
        r1 = a;
        r0 = java.lang.String.valueOf(r0);
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r1, r0);
    L_0x021e:
        if (r2 == 0) goto L_0x0223;
    L_0x0220:
        r2.disconnect();
    L_0x0223:
        return r15;
    L_0x0224:
        r1.a(r6);	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
    L_0x0227:
        r15 = r2.getHeaderFieldKey(r8);	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        if (r15 == 0) goto L_0x023b;
    L_0x022d:
        r8 = r8 + 1;
        r0 = r2.getHeaderField(r15);	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r15 = r15.toLowerCase();	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r1.a(r15, r0);	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        goto L_0x0227;
    L_0x023b:
        r15 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r6 < r15) goto L_0x02f5;
    L_0x023f:
        if (r6 >= r9) goto L_0x02f5;
    L_0x0241:
        r15 = r2.getContentLength();	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r0 = 5242880; // 0x500000 float:7.34684E-39 double:2.590327E-317;
        if (r15 <= r0) goto L_0x025d;
    L_0x0249:
        r0 = new com.alibaba.sdk.android.feedback.xblink.c.d;	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r1 = new java.lang.StringBuilder;	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r6 = "The Content-Length is too large:";
        r1.<init>(r6);	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r1.append(r15);	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r15 = r1.toString();	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r0.<init>(r14, r15);	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        throw r0;	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
    L_0x025d:
        r0 = r2.getInputStream();	 Catch:{ g -> 0x0351, d -> 0x034a, SSLHandshakeException -> 0x0346, Exception -> 0x0340, all -> 0x033b }
        r6 = r2.getContentEncoding();	 Catch:{ g -> 0x02f1, d -> 0x02ed, SSLHandshakeException -> 0x02e9, Exception -> 0x02e6, all -> 0x02e2 }
        if (r6 == 0) goto L_0x028b;
    L_0x0267:
        r8 = "gzip";
        r6 = r8.equals(r6);	 Catch:{ g -> 0x02f1, d -> 0x02ed, SSLHandshakeException -> 0x02e9, Exception -> 0x02e6, all -> 0x02e2 }
        if (r6 == 0) goto L_0x028b;
    L_0x026f:
        r6 = new java.util.zip.GZIPInputStream;	 Catch:{ g -> 0x02f1, d -> 0x02ed, SSLHandshakeException -> 0x02e9, Exception -> 0x02e6, all -> 0x02e2 }
        r6.<init>(r0);	 Catch:{ g -> 0x02f1, d -> 0x02ed, SSLHandshakeException -> 0x02e9, Exception -> 0x02e6, all -> 0x02e2 }
        r8 = new java.io.DataInputStream;	 Catch:{ g -> 0x0287, d -> 0x0283, SSLHandshakeException -> 0x0280, Exception -> 0x027c }
        r8.<init>(r6);	 Catch:{ g -> 0x0287, d -> 0x0283, SSLHandshakeException -> 0x0280, Exception -> 0x027c }
        r5 = r6;
        r6 = r8;
        goto L_0x0290;
    L_0x027c:
        r15 = move-exception;
        r1 = r5;
        goto L_0x0344;
    L_0x0280:
        r15 = move-exception;
        goto L_0x0394;
    L_0x0283:
        r15 = move-exception;
        r1 = r5;
        goto L_0x034e;
    L_0x0287:
        r15 = move-exception;
        r1 = r5;
        goto L_0x0355;
    L_0x028b:
        r6 = new java.io.DataInputStream;	 Catch:{ g -> 0x02f1, d -> 0x02ed, SSLHandshakeException -> 0x02e9, Exception -> 0x02e6, all -> 0x02e2 }
        r6.<init>(r0);	 Catch:{ g -> 0x02f1, d -> 0x02ed, SSLHandshakeException -> 0x02e9, Exception -> 0x02e6, all -> 0x02e2 }
    L_0x0290:
        r8 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r9 = new byte[r8];	 Catch:{ g -> 0x02dd, d -> 0x02d8, SSLHandshakeException -> 0x02d2, Exception -> 0x02cd, all -> 0x02c7 }
        r10 = r15;
        r15 = r7;
    L_0x0296:
        r11 = r6.read(r9, r7, r8);	 Catch:{ g -> 0x02dd, d -> 0x02d8, SSLHandshakeException -> 0x02d2, Exception -> 0x02cd, all -> 0x02c7 }
        if (r11 == r4) goto L_0x02b4;
    L_0x029c:
        r3.write(r9, r7, r11);	 Catch:{ g -> 0x02dd, d -> 0x02d8, SSLHandshakeException -> 0x02d2, Exception -> 0x02cd, all -> 0x02c7 }
        r12 = r14.c;	 Catch:{ g -> 0x02dd, d -> 0x02d8, SSLHandshakeException -> 0x02d2, Exception -> 0x02cd, all -> 0x02c7 }
        if (r12 == 0) goto L_0x0296;
    L_0x02a3:
        r15 = r15 + r11;
        if (r15 <= r10) goto L_0x02a7;
    L_0x02a6:
        r10 = r15;
    L_0x02a7:
        r11 = (float) r15;	 Catch:{ g -> 0x02dd, d -> 0x02d8, SSLHandshakeException -> 0x02d2, Exception -> 0x02cd, all -> 0x02c7 }
        r12 = (float) r10;	 Catch:{ g -> 0x02dd, d -> 0x02d8, SSLHandshakeException -> 0x02d2, Exception -> 0x02cd, all -> 0x02c7 }
        r11 = r11 / r12;
        r12 = 1120403456; // 0x42c80000 float:100.0 double:5.53552857E-315;
        r11 = r11 * r12;
        r11 = (int) r11;	 Catch:{ g -> 0x02dd, d -> 0x02d8, SSLHandshakeException -> 0x02d2, Exception -> 0x02cd, all -> 0x02c7 }
        r12 = r14.c;	 Catch:{ g -> 0x02dd, d -> 0x02d8, SSLHandshakeException -> 0x02d2, Exception -> 0x02cd, all -> 0x02c7 }
        r12.a(r11);	 Catch:{ g -> 0x02dd, d -> 0x02d8, SSLHandshakeException -> 0x02d2, Exception -> 0x02cd, all -> 0x02c7 }
        goto L_0x0296;
    L_0x02b4:
        r15 = r3.toByteArray();	 Catch:{ g -> 0x02dd, d -> 0x02d8, SSLHandshakeException -> 0x02d2, Exception -> 0x02cd, all -> 0x02c7 }
        r1.a(r15);	 Catch:{ g -> 0x02dd, d -> 0x02d8, SSLHandshakeException -> 0x02d2, Exception -> 0x02cd, all -> 0x02c7 }
        r15 = r14.c;	 Catch:{ g -> 0x02dd, d -> 0x02d8, SSLHandshakeException -> 0x02d2, Exception -> 0x02cd, all -> 0x02c7 }
        if (r15 == 0) goto L_0x02c4;
    L_0x02bf:
        r15 = r14.c;	 Catch:{ g -> 0x02dd, d -> 0x02d8, SSLHandshakeException -> 0x02d2, Exception -> 0x02cd, all -> 0x02c7 }
        r15.a(r1, r7);	 Catch:{ g -> 0x02dd, d -> 0x02d8, SSLHandshakeException -> 0x02d2, Exception -> 0x02cd, all -> 0x02c7 }
    L_0x02c4:
        r15 = r5;
        r5 = r6;
        goto L_0x02f7;
    L_0x02c7:
        r15 = move-exception;
        r13 = r6;
        r6 = r5;
        r5 = r13;
        goto L_0x0421;
    L_0x02cd:
        r15 = move-exception;
        r1 = r6;
        r6 = r5;
        goto L_0x0344;
    L_0x02d2:
        r15 = move-exception;
        r13 = r6;
        r6 = r5;
        r5 = r13;
        goto L_0x0394;
    L_0x02d8:
        r15 = move-exception;
        r1 = r6;
        r6 = r5;
        goto L_0x034e;
    L_0x02dd:
        r15 = move-exception;
        r1 = r6;
        r6 = r5;
        goto L_0x0355;
    L_0x02e2:
        r15 = move-exception;
        r6 = r5;
        goto L_0x0421;
    L_0x02e6:
        r15 = move-exception;
        r1 = r5;
        goto L_0x0343;
    L_0x02e9:
        r15 = move-exception;
        r6 = r5;
        goto L_0x0394;
    L_0x02ed:
        r15 = move-exception;
        r1 = r5;
        goto L_0x034d;
    L_0x02f1:
        r15 = move-exception;
        r1 = r5;
        goto L_0x0354;
    L_0x02f5:
        r15 = r5;
        r0 = r15;
    L_0x02f7:
        if (r5 == 0) goto L_0x0307;
    L_0x02f9:
        r5.close();	 Catch:{ Exception -> 0x02fd }
        goto L_0x0307;
    L_0x02fd:
        r4 = move-exception;
        r5 = a;
        r4 = java.lang.String.valueOf(r4);
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r5, r4);
    L_0x0307:
        if (r0 == 0) goto L_0x0317;
    L_0x0309:
        r0.close();	 Catch:{ Exception -> 0x030d }
        goto L_0x0317;
    L_0x030d:
        r0 = move-exception;
        r4 = a;
        r0 = java.lang.String.valueOf(r0);
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r4, r0);
    L_0x0317:
        if (r15 == 0) goto L_0x0327;
    L_0x0319:
        r15.close();	 Catch:{ Exception -> 0x031d }
        goto L_0x0327;
    L_0x031d:
        r15 = move-exception;
        r0 = a;
        r15 = java.lang.String.valueOf(r15);
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r0, r15);
    L_0x0327:
        r3.close();	 Catch:{ Exception -> 0x032b }
        goto L_0x0335;
    L_0x032b:
        r15 = move-exception;
        r0 = a;
        r15 = java.lang.String.valueOf(r15);
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r0, r15);
    L_0x0335:
        if (r2 == 0) goto L_0x033a;
    L_0x0337:
        r2.disconnect();
    L_0x033a:
        return r1;
    L_0x033b:
        r15 = move-exception;
        r0 = r5;
    L_0x033d:
        r6 = r0;
        goto L_0x0421;
    L_0x0340:
        r15 = move-exception;
        r0 = r5;
        r1 = r0;
    L_0x0343:
        r6 = r1;
    L_0x0344:
        r5 = r2;
        goto L_0x0362;
    L_0x0346:
        r15 = move-exception;
        r0 = r5;
    L_0x0348:
        r6 = r0;
        goto L_0x0394;
    L_0x034a:
        r15 = move-exception;
        r0 = r5;
        r1 = r0;
    L_0x034d:
        r6 = r1;
    L_0x034e:
        r5 = r2;
        goto L_0x0401;
    L_0x0351:
        r15 = move-exception;
        r0 = r5;
        r1 = r0;
    L_0x0354:
        r6 = r1;
    L_0x0355:
        r5 = r2;
        goto L_0x0412;
    L_0x0358:
        r15 = move-exception;
        r0 = r5;
        r2 = r0;
        r6 = r2;
        goto L_0x0421;
    L_0x035e:
        r15 = move-exception;
        r0 = r5;
        r1 = r0;
    L_0x0361:
        r6 = r1;
    L_0x0362:
        r2 = r15.getMessage();	 Catch:{ all -> 0x041e }
        r4 = r14.c;	 Catch:{ all -> 0x041e }
        if (r4 == 0) goto L_0x037e;
    L_0x036a:
        r4 = r14.c;	 Catch:{ all -> 0x041e }
        r7 = -4;
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x041e }
        r9 = "network exception: ";
        r8.<init>(r9);	 Catch:{ all -> 0x041e }
        r8.append(r2);	 Catch:{ all -> 0x041e }
        r8 = r8.toString();	 Catch:{ all -> 0x041e }
        r4.a(r7, r8);	 Catch:{ all -> 0x041e }
    L_0x037e:
        r4 = a;	 Catch:{ all -> 0x041e }
        r15 = java.lang.String.valueOf(r15);	 Catch:{ all -> 0x041e }
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r4, r15);	 Catch:{ all -> 0x041e }
        r3.reset();	 Catch:{ all -> 0x041e }
        r15 = new com.alibaba.sdk.android.feedback.xblink.c.f;	 Catch:{ all -> 0x041e }
        r15.<init>(r14, r2);	 Catch:{ all -> 0x041e }
        throw r15;	 Catch:{ all -> 0x041e }
    L_0x0390:
        r15 = move-exception;
        r0 = r5;
        r2 = r0;
        r6 = r2;
    L_0x0394:
        r1 = r14.c;	 Catch:{ all -> 0x03fb }
        if (r1 == 0) goto L_0x03a0;
    L_0x0398:
        r1 = r14.c;	 Catch:{ all -> 0x03fb }
        r4 = -3;
        r7 = "ssl handshake exception";
        r1.a(r4, r7);	 Catch:{ all -> 0x03fb }
    L_0x03a0:
        r15 = r15.getCause();	 Catch:{ all -> 0x03fb }
        if (r15 == 0) goto L_0x03b2;
    L_0x03a6:
        throw r15;	 Catch:{ Throwable -> 0x03a7 }
    L_0x03a7:
        r15 = move-exception;
        r1 = new com.alibaba.sdk.android.feedback.xblink.c.e;	 Catch:{ all -> 0x03fb }
        r15 = r15.getMessage();	 Catch:{ all -> 0x03fb }
        r1.<init>(r14, r15);	 Catch:{ all -> 0x03fb }
        throw r1;	 Catch:{ all -> 0x03fb }
    L_0x03b2:
        if (r5 == 0) goto L_0x03c2;
    L_0x03b4:
        r5.close();	 Catch:{ Exception -> 0x03b8 }
        goto L_0x03c2;
    L_0x03b8:
        r15 = move-exception;
        r1 = a;
        r15 = java.lang.String.valueOf(r15);
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r1, r15);
    L_0x03c2:
        if (r0 == 0) goto L_0x03d2;
    L_0x03c4:
        r0.close();	 Catch:{ Exception -> 0x03c8 }
        goto L_0x03d2;
    L_0x03c8:
        r15 = move-exception;
        r0 = a;
        r15 = java.lang.String.valueOf(r15);
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r0, r15);
    L_0x03d2:
        if (r6 == 0) goto L_0x03e2;
    L_0x03d4:
        r6.close();	 Catch:{ Exception -> 0x03d8 }
        goto L_0x03e2;
    L_0x03d8:
        r15 = move-exception;
        r0 = a;
        r15 = java.lang.String.valueOf(r15);
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r0, r15);
    L_0x03e2:
        r3.close();	 Catch:{ Exception -> 0x03e6 }
        goto L_0x03f0;
    L_0x03e6:
        r15 = move-exception;
        r0 = a;
        r15 = java.lang.String.valueOf(r15);
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r0, r15);
    L_0x03f0:
        if (r2 == 0) goto L_0x03f5;
    L_0x03f2:
        r2.disconnect();
    L_0x03f5:
        r15 = new com.alibaba.sdk.android.feedback.xblink.c.i;
        r15.<init>();
        return r15;
    L_0x03fb:
        r15 = move-exception;
        goto L_0x0421;
    L_0x03fd:
        r15 = move-exception;
        r0 = r5;
        r1 = r0;
    L_0x0400:
        r6 = r1;
    L_0x0401:
        r2 = r14.c;	 Catch:{ all -> 0x041e }
        if (r2 == 0) goto L_0x040d;
    L_0x0405:
        r2 = r14.c;	 Catch:{ all -> 0x041e }
        r4 = -2;
        r7 = "connect file is too large";
        r2.a(r4, r7);	 Catch:{ all -> 0x041e }
    L_0x040d:
        throw r15;	 Catch:{ all -> 0x041e }
    L_0x040e:
        r15 = move-exception;
        r0 = r5;
        r1 = r0;
    L_0x0411:
        r6 = r1;
    L_0x0412:
        r2 = r14.c;	 Catch:{ all -> 0x041e }
        if (r2 == 0) goto L_0x041d;
    L_0x0416:
        r2 = r14.c;	 Catch:{ all -> 0x041e }
        r7 = "too many redirect";
        r2.a(r4, r7);	 Catch:{ all -> 0x041e }
    L_0x041d:
        throw r15;	 Catch:{ all -> 0x041e }
    L_0x041e:
        r15 = move-exception;
        r2 = r5;
        r5 = r1;
    L_0x0421:
        if (r5 == 0) goto L_0x0431;
    L_0x0423:
        r5.close();	 Catch:{ Exception -> 0x0427 }
        goto L_0x0431;
    L_0x0427:
        r1 = move-exception;
        r4 = a;
        r1 = java.lang.String.valueOf(r1);
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r4, r1);
    L_0x0431:
        if (r0 == 0) goto L_0x0441;
    L_0x0433:
        r0.close();	 Catch:{ Exception -> 0x0437 }
        goto L_0x0441;
    L_0x0437:
        r0 = move-exception;
        r1 = a;
        r0 = java.lang.String.valueOf(r0);
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r1, r0);
    L_0x0441:
        if (r6 == 0) goto L_0x0451;
    L_0x0443:
        r6.close();	 Catch:{ Exception -> 0x0447 }
        goto L_0x0451;
    L_0x0447:
        r0 = move-exception;
        r1 = a;
        r0 = java.lang.String.valueOf(r0);
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r1, r0);
    L_0x0451:
        r3.close();	 Catch:{ Exception -> 0x0455 }
        goto L_0x045f;
    L_0x0455:
        r0 = move-exception;
        r1 = a;
        r0 = java.lang.String.valueOf(r0);
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r1, r0);
    L_0x045f:
        if (r2 == 0) goto L_0x0464;
    L_0x0461:
        r2.disconnect();
    L_0x0464:
        throw r15;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.c.c.b(com.alibaba.sdk.android.feedback.xblink.c.h):com.alibaba.sdk.android.feedback.xblink.c.i");
    }

    public i a(h hVar) {
        return a(hVar, null);
    }

    public com.alibaba.sdk.android.feedback.xblink.c.i a(com.alibaba.sdk.android.feedback.xblink.c.h r5, com.alibaba.sdk.android.feedback.xblink.c.b r6) {
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
        if (r5 != 0) goto L_0x000a;
    L_0x0002:
        r5 = new java.lang.NullPointerException;
        r6 = "Http connect error, request is null";
        r5.<init>(r6);
        throw r5;
    L_0x000a:
        r4.c = r6;
        r6 = 0;
        r4.b = r6;
        r0 = r5.h();
    L_0x0013:
        if (r6 >= r0) goto L_0x005b;
    L_0x0015:
        r1 = r4.b(r5);	 Catch:{ f -> 0x0025, d -> 0x001a, d -> 0x001a, d -> 0x001a }
        return r1;
    L_0x001a:
        r5 = move-exception;
        r6 = a;
        r5 = java.lang.String.valueOf(r5);
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r6, r5);
        goto L_0x005b;
    L_0x0025:
        r1 = move-exception;
        r2 = a;
        r1 = java.lang.String.valueOf(r1);
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r2, r1);
        r1 = com.alibaba.sdk.android.feedback.xblink.i.g.a();
        if (r1 == 0) goto L_0x0048;
    L_0x0035:
        r1 = a;
        r2 = new java.lang.StringBuilder;
        r3 = "retryTime: ";
        r2.<init>(r3);
        r2.append(r6);
        r2 = r2.toString();
        com.alibaba.sdk.android.feedback.xblink.i.g.a(r1, r2);
    L_0x0048:
        r6 = r6 + 1;
        r1 = r6 * 2;
        r1 = r1 * 1000;
        r1 = (long) r1;
        java.lang.Thread.sleep(r1);	 Catch:{ InterruptedException -> 0x0053 }
        goto L_0x0013;
    L_0x0053:
        r1 = a;
        r2 = "HttpConnector retry Sleep has been interrupted, go ahead";
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r1, r2);
        goto L_0x0013;
    L_0x005b:
        r5 = new com.alibaba.sdk.android.feedback.xblink.c.i;
        r5.<init>();
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.c.c.a(com.alibaba.sdk.android.feedback.xblink.c.h, com.alibaba.sdk.android.feedback.xblink.c.b):com.alibaba.sdk.android.feedback.xblink.c.i");
    }
}
