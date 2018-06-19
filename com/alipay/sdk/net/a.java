package com.alipay.sdk.net;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.net.URL;
import org.apache.http.HttpHost;

public final class a {
    public static final String a = "application/octet-stream;binary/octet-stream";
    public String b;
    private Context c;

    private a(Context context) {
        this(context, null);
    }

    public a(Context context, String str) {
        this.c = context;
        this.b = str;
    }

    private void a(String str) {
        this.b = str;
    }

    private String a() {
        return this.b;
    }

    private java.net.URL b() {
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
        r2 = this;
        r0 = new java.net.URL;	 Catch:{ Exception -> 0x0008 }
        r1 = r2.b;	 Catch:{ Exception -> 0x0008 }
        r0.<init>(r1);	 Catch:{ Exception -> 0x0008 }
        goto L_0x0009;
    L_0x0008:
        r0 = 0;
    L_0x0009:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.net.a.b():java.net.URL");
    }

    public final org.apache.http.HttpResponse a(byte[] r7, java.util.List<org.apache.http.Header> r8) throws java.lang.Throwable {
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
        r6 = this;
        r0 = new java.lang.StringBuilder;
        r1 = "requestUrl : ";
        r0.<init>(r1);
        r1 = r6.b;
        r0.append(r1);
        r0 = com.alipay.sdk.net.b.a();
        r1 = 0;
        if (r0 != 0) goto L_0x0014;
    L_0x0013:
        return r1;
    L_0x0014:
        r2 = r0.c;	 Catch:{ Throwable -> 0x010d }
        r2 = r2.getParams();	 Catch:{ Throwable -> 0x010d }
        r3 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x010d }
        r4 = 11;	 Catch:{ Throwable -> 0x010d }
        if (r3 < r4) goto L_0x005b;	 Catch:{ Throwable -> 0x010d }
    L_0x0020:
        r3 = r6.g();	 Catch:{ Throwable -> 0x010d }
        if (r3 == 0) goto L_0x0030;	 Catch:{ Throwable -> 0x010d }
    L_0x0026:
        r4 = "wap";	 Catch:{ Throwable -> 0x010d }
        r3 = r3.contains(r4);	 Catch:{ Throwable -> 0x010d }
        if (r3 != 0) goto L_0x0030;	 Catch:{ Throwable -> 0x010d }
    L_0x002e:
        r5 = r1;	 Catch:{ Throwable -> 0x010d }
        goto L_0x007c;	 Catch:{ Throwable -> 0x010d }
    L_0x0030:
        r3 = r6.b();	 Catch:{ Throwable -> 0x010d }
        if (r3 == 0) goto L_0x002e;	 Catch:{ Throwable -> 0x010d }
    L_0x0036:
        r3 = r3.getProtocol();	 Catch:{ Throwable -> 0x010d }
        r4 = "https";	 Catch:{ Throwable -> 0x010d }
        r4.equalsIgnoreCase(r3);	 Catch:{ Throwable -> 0x010d }
        r3 = "https.proxyHost";	 Catch:{ Throwable -> 0x010d }
        r3 = java.lang.System.getProperty(r3);	 Catch:{ Throwable -> 0x010d }
        r4 = "https.proxyPort";	 Catch:{ Throwable -> 0x010d }
        r4 = java.lang.System.getProperty(r4);	 Catch:{ Throwable -> 0x010d }
        r5 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Throwable -> 0x010d }
        if (r5 != 0) goto L_0x002e;	 Catch:{ Throwable -> 0x010d }
    L_0x0051:
        r5 = new org.apache.http.HttpHost;	 Catch:{ Throwable -> 0x010d }
        r4 = java.lang.Integer.parseInt(r4);	 Catch:{ Throwable -> 0x010d }
        r5.<init>(r3, r4);	 Catch:{ Throwable -> 0x010d }
        goto L_0x007c;	 Catch:{ Throwable -> 0x010d }
    L_0x005b:
        r3 = r6.f();	 Catch:{ Throwable -> 0x010d }
        if (r3 == 0) goto L_0x002e;	 Catch:{ Throwable -> 0x010d }
    L_0x0061:
        r4 = r3.isAvailable();	 Catch:{ Throwable -> 0x010d }
        if (r4 == 0) goto L_0x002e;	 Catch:{ Throwable -> 0x010d }
    L_0x0067:
        r3 = r3.getType();	 Catch:{ Throwable -> 0x010d }
        if (r3 != 0) goto L_0x002e;	 Catch:{ Throwable -> 0x010d }
    L_0x006d:
        r3 = android.net.Proxy.getDefaultHost();	 Catch:{ Throwable -> 0x010d }
        r4 = android.net.Proxy.getDefaultPort();	 Catch:{ Throwable -> 0x010d }
        if (r3 == 0) goto L_0x002e;	 Catch:{ Throwable -> 0x010d }
    L_0x0077:
        r5 = new org.apache.http.HttpHost;	 Catch:{ Throwable -> 0x010d }
        r5.<init>(r3, r4);	 Catch:{ Throwable -> 0x010d }
    L_0x007c:
        if (r5 == 0) goto L_0x0083;	 Catch:{ Throwable -> 0x010d }
    L_0x007e:
        r3 = "http.route.default-proxy";	 Catch:{ Throwable -> 0x010d }
        r2.setParameter(r3, r5);	 Catch:{ Throwable -> 0x010d }
    L_0x0083:
        if (r7 == 0) goto L_0x00b6;	 Catch:{ Throwable -> 0x010d }
    L_0x0085:
        r2 = r7.length;	 Catch:{ Throwable -> 0x010d }
        if (r2 != 0) goto L_0x0089;	 Catch:{ Throwable -> 0x010d }
    L_0x0088:
        goto L_0x00b6;	 Catch:{ Throwable -> 0x010d }
    L_0x0089:
        r2 = new org.apache.http.client.methods.HttpPost;	 Catch:{ Throwable -> 0x010d }
        r3 = r6.b;	 Catch:{ Throwable -> 0x010d }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x010d }
        r3 = new org.apache.http.entity.ByteArrayEntity;	 Catch:{ Throwable -> 0x010d }
        r3.<init>(r7);	 Catch:{ Throwable -> 0x010d }
        r7 = "application/octet-stream;binary/octet-stream";	 Catch:{ Throwable -> 0x010d }
        r3.setContentType(r7);	 Catch:{ Throwable -> 0x010d }
        r7 = r2;	 Catch:{ Throwable -> 0x010d }
        r7 = (org.apache.http.client.methods.HttpPost) r7;	 Catch:{ Throwable -> 0x010d }
        r7.setEntity(r3);	 Catch:{ Throwable -> 0x010d }
        r7 = "Accept-Charset";	 Catch:{ Throwable -> 0x010d }
        r3 = "UTF-8";	 Catch:{ Throwable -> 0x010d }
        r2.addHeader(r7, r3);	 Catch:{ Throwable -> 0x010d }
        r7 = "Connection";	 Catch:{ Throwable -> 0x010d }
        r3 = "Keep-Alive";	 Catch:{ Throwable -> 0x010d }
        r2.addHeader(r7, r3);	 Catch:{ Throwable -> 0x010d }
        r7 = "Keep-Alive";	 Catch:{ Throwable -> 0x010d }
        r3 = "timeout=180, max=100";	 Catch:{ Throwable -> 0x010d }
        r2.addHeader(r7, r3);	 Catch:{ Throwable -> 0x010d }
        goto L_0x00bd;	 Catch:{ Throwable -> 0x010d }
    L_0x00b6:
        r2 = new org.apache.http.client.methods.HttpGet;	 Catch:{ Throwable -> 0x010d }
        r7 = r6.b;	 Catch:{ Throwable -> 0x010d }
        r2.<init>(r7);	 Catch:{ Throwable -> 0x010d }
    L_0x00bd:
        if (r8 == 0) goto L_0x00d3;	 Catch:{ Throwable -> 0x010d }
    L_0x00bf:
        r7 = r8.iterator();	 Catch:{ Throwable -> 0x010d }
    L_0x00c3:
        r8 = r7.hasNext();	 Catch:{ Throwable -> 0x010d }
        if (r8 == 0) goto L_0x00d3;	 Catch:{ Throwable -> 0x010d }
    L_0x00c9:
        r8 = r7.next();	 Catch:{ Throwable -> 0x010d }
        r8 = (org.apache.http.Header) r8;	 Catch:{ Throwable -> 0x010d }
        r2.addHeader(r8);	 Catch:{ Throwable -> 0x010d }
        goto L_0x00c3;	 Catch:{ Throwable -> 0x010d }
    L_0x00d3:
        r7 = r0.a(r2);	 Catch:{ Throwable -> 0x010d }
        r8 = "X-Hostname";	 Catch:{ Throwable -> 0x010d }
        r8 = r7.getHeaders(r8);	 Catch:{ Throwable -> 0x010d }
        r2 = 0;	 Catch:{ Throwable -> 0x010d }
        if (r8 == 0) goto L_0x00f2;	 Catch:{ Throwable -> 0x010d }
    L_0x00e0:
        r3 = r8.length;	 Catch:{ Throwable -> 0x010d }
        if (r3 <= 0) goto L_0x00f2;	 Catch:{ Throwable -> 0x010d }
    L_0x00e3:
        r8 = r8[r2];	 Catch:{ Throwable -> 0x010d }
        if (r8 == 0) goto L_0x00f2;	 Catch:{ Throwable -> 0x010d }
    L_0x00e7:
        r8 = "X-Hostname";	 Catch:{ Throwable -> 0x010d }
        r8 = r7.getHeaders(r8);	 Catch:{ Throwable -> 0x010d }
        r8 = r8[r2];	 Catch:{ Throwable -> 0x010d }
        r8.toString();	 Catch:{ Throwable -> 0x010d }
    L_0x00f2:
        r8 = "X-ExecuteTime";	 Catch:{ Throwable -> 0x010d }
        r8 = r7.getHeaders(r8);	 Catch:{ Throwable -> 0x010d }
        if (r8 == 0) goto L_0x010c;	 Catch:{ Throwable -> 0x010d }
    L_0x00fa:
        r3 = r8.length;	 Catch:{ Throwable -> 0x010d }
        if (r3 <= 0) goto L_0x010c;	 Catch:{ Throwable -> 0x010d }
    L_0x00fd:
        r8 = r8[r2];	 Catch:{ Throwable -> 0x010d }
        if (r8 == 0) goto L_0x010c;	 Catch:{ Throwable -> 0x010d }
    L_0x0101:
        r8 = "X-ExecuteTime";	 Catch:{ Throwable -> 0x010d }
        r8 = r7.getHeaders(r8);	 Catch:{ Throwable -> 0x010d }
        r8 = r8[r2];	 Catch:{ Throwable -> 0x010d }
        r8.toString();	 Catch:{ Throwable -> 0x010d }
    L_0x010c:
        return r7;
    L_0x010d:
        r7 = move-exception;
        if (r0 == 0) goto L_0x011d;
    L_0x0110:
        r8 = r0.c;	 Catch:{ Throwable -> 0x011d }
        r8 = r8.getConnectionManager();	 Catch:{ Throwable -> 0x011d }
        if (r8 == 0) goto L_0x011d;	 Catch:{ Throwable -> 0x011d }
    L_0x0118:
        r8.shutdown();	 Catch:{ Throwable -> 0x011d }
        com.alipay.sdk.net.b.b = r1;	 Catch:{ Throwable -> 0x011d }
    L_0x011d:
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.net.a.a(byte[], java.util.List):org.apache.http.HttpResponse");
    }

    private HttpHost c() {
        HttpHost httpHost = null;
        String g;
        if (VERSION.SDK_INT >= 11) {
            g = g();
            if (g != null && !g.contains("wap")) {
                return null;
            }
            URL b = b();
            if (b != null) {
                "https".equalsIgnoreCase(b.getProtocol());
                Object property = System.getProperty("https.proxyHost");
                String property2 = System.getProperty("https.proxyPort");
                if (!TextUtils.isEmpty(property)) {
                    httpHost = new HttpHost(property, Integer.parseInt(property2));
                }
            }
            return httpHost;
        }
        NetworkInfo f = f();
        if (f != null && f.isAvailable() && f.getType() == 0) {
            g = Proxy.getDefaultHost();
            int defaultPort = Proxy.getDefaultPort();
            if (g != null) {
                httpHost = new HttpHost(g, defaultPort);
            }
        }
        return httpHost;
    }

    private HttpHost d() {
        NetworkInfo f = f();
        if (f != null && f.isAvailable() && f.getType() == 0) {
            String defaultHost = Proxy.getDefaultHost();
            int defaultPort = Proxy.getDefaultPort();
            if (defaultHost != null) {
                return new HttpHost(defaultHost, defaultPort);
            }
        }
        return null;
    }

    private HttpHost e() {
        String g = g();
        HttpHost httpHost = null;
        if (g != null && !g.contains("wap")) {
            return null;
        }
        URL b = b();
        if (b != null) {
            "https".equalsIgnoreCase(b.getProtocol());
            Object property = System.getProperty("https.proxyHost");
            String property2 = System.getProperty("https.proxyPort");
            if (!TextUtils.isEmpty(property)) {
                httpHost = new HttpHost(property, Integer.parseInt(property2));
            }
        }
        return httpHost;
    }

    private android.net.NetworkInfo f() {
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
        r2 = this;
        r0 = r2.c;	 Catch:{ Exception -> 0x000f }
        r1 = "connectivity";	 Catch:{ Exception -> 0x000f }
        r0 = r0.getSystemService(r1);	 Catch:{ Exception -> 0x000f }
        r0 = (android.net.ConnectivityManager) r0;	 Catch:{ Exception -> 0x000f }
        r0 = r0.getActiveNetworkInfo();	 Catch:{ Exception -> 0x000f }
        goto L_0x0010;
    L_0x000f:
        r0 = 0;
    L_0x0010:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.net.a.f():android.net.NetworkInfo");
    }

    private java.lang.String g() {
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
        r3 = this;
        r0 = r3.f();	 Catch:{ Exception -> 0x0022 }
        if (r0 == 0) goto L_0x001f;	 Catch:{ Exception -> 0x0022 }
    L_0x0006:
        r1 = r0.isAvailable();	 Catch:{ Exception -> 0x0022 }
        if (r1 == 0) goto L_0x001f;	 Catch:{ Exception -> 0x0022 }
    L_0x000c:
        r1 = r0.getType();	 Catch:{ Exception -> 0x0022 }
        r2 = 1;	 Catch:{ Exception -> 0x0022 }
        if (r1 != r2) goto L_0x0016;	 Catch:{ Exception -> 0x0022 }
    L_0x0013:
        r0 = "wifi";	 Catch:{ Exception -> 0x0022 }
        return r0;	 Catch:{ Exception -> 0x0022 }
    L_0x0016:
        r0 = r0.getExtraInfo();	 Catch:{ Exception -> 0x0022 }
        r0 = r0.toLowerCase();	 Catch:{ Exception -> 0x0022 }
        return r0;
    L_0x001f:
        r0 = "none";
        return r0;
    L_0x0022:
        r0 = "none";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.net.a.g():java.lang.String");
    }
}
