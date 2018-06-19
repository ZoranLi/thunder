package com.tencent.wxop.stat;

import android.content.Context;
import anet.channel.util.HttpConstant;
import com.qq.e.comm.constants.Constants.KEYS;
import com.tencent.a.a.a.a.g;
import com.tencent.a.a.a.a.h;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.common.e;
import com.tencent.wxop.stat.common.f;
import com.tencent.wxop.stat.common.l;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

class i {
    private static StatLogger d = l.b();
    private static i e;
    private static Context f;
    DefaultHttpClient a = null;
    e b = null;
    StringBuilder c = new StringBuilder(4096);
    private long g = 0;

    private i(android.content.Context r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r4.<init>();
        r0 = 0;
        r4.a = r0;
        r4.b = r0;
        r0 = new java.lang.StringBuilder;
        r1 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r0.<init>(r1);
        r4.c = r0;
        r0 = 0;
        r4.g = r0;
        r5 = r5.getApplicationContext();	 Catch:{ Throwable -> 0x008d }
        f = r5;	 Catch:{ Throwable -> 0x008d }
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x008d }
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ Throwable -> 0x008d }
        r0 = r0 / r2;	 Catch:{ Throwable -> 0x008d }
        r4.g = r0;	 Catch:{ Throwable -> 0x008d }
        r5 = new com.tencent.wxop.stat.common.e;	 Catch:{ Throwable -> 0x008d }
        r5.<init>();	 Catch:{ Throwable -> 0x008d }
        r4.b = r5;	 Catch:{ Throwable -> 0x008d }
        r5 = com.tencent.wxop.stat.StatConfig.isDebugEnable();	 Catch:{ Throwable -> 0x008d }
        if (r5 == 0) goto L_0x006a;
    L_0x0031:
        r5 = "org.apache.http.wire";	 Catch:{ Throwable -> 0x006a }
        r5 = java.util.logging.Logger.getLogger(r5);	 Catch:{ Throwable -> 0x006a }
        r0 = java.util.logging.Level.FINER;	 Catch:{ Throwable -> 0x006a }
        r5.setLevel(r0);	 Catch:{ Throwable -> 0x006a }
        r5 = "org.apache.http.headers";	 Catch:{ Throwable -> 0x006a }
        r5 = java.util.logging.Logger.getLogger(r5);	 Catch:{ Throwable -> 0x006a }
        r0 = java.util.logging.Level.FINER;	 Catch:{ Throwable -> 0x006a }
        r5.setLevel(r0);	 Catch:{ Throwable -> 0x006a }
        r5 = "org.apache.commons.logging.Log";	 Catch:{ Throwable -> 0x006a }
        r0 = "org.apache.commons.logging.impl.SimpleLog";	 Catch:{ Throwable -> 0x006a }
        java.lang.System.setProperty(r5, r0);	 Catch:{ Throwable -> 0x006a }
        r5 = "org.apache.commons.logging.simplelog.showdatetime";	 Catch:{ Throwable -> 0x006a }
        r0 = "true";	 Catch:{ Throwable -> 0x006a }
        java.lang.System.setProperty(r5, r0);	 Catch:{ Throwable -> 0x006a }
        r5 = "org.apache.commons.logging.simplelog.log.httpclient.wire";	 Catch:{ Throwable -> 0x006a }
        r0 = "debug";	 Catch:{ Throwable -> 0x006a }
        java.lang.System.setProperty(r5, r0);	 Catch:{ Throwable -> 0x006a }
        r5 = "org.apache.commons.logging.simplelog.log.org.apache.http";	 Catch:{ Throwable -> 0x006a }
        r0 = "debug";	 Catch:{ Throwable -> 0x006a }
        java.lang.System.setProperty(r5, r0);	 Catch:{ Throwable -> 0x006a }
        r5 = "org.apache.commons.logging.simplelog.log.org.apache.http.headers";	 Catch:{ Throwable -> 0x006a }
        r0 = "debug";	 Catch:{ Throwable -> 0x006a }
        java.lang.System.setProperty(r5, r0);	 Catch:{ Throwable -> 0x006a }
    L_0x006a:
        r5 = new org.apache.http.params.BasicHttpParams;	 Catch:{ Throwable -> 0x008d }
        r5.<init>();	 Catch:{ Throwable -> 0x008d }
        r0 = 0;	 Catch:{ Throwable -> 0x008d }
        org.apache.http.params.HttpConnectionParams.setStaleCheckingEnabled(r5, r0);	 Catch:{ Throwable -> 0x008d }
        r0 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;	 Catch:{ Throwable -> 0x008d }
        org.apache.http.params.HttpConnectionParams.setConnectionTimeout(r5, r0);	 Catch:{ Throwable -> 0x008d }
        org.apache.http.params.HttpConnectionParams.setSoTimeout(r5, r0);	 Catch:{ Throwable -> 0x008d }
        r0 = new org.apache.http.impl.client.DefaultHttpClient;	 Catch:{ Throwable -> 0x008d }
        r0.<init>(r5);	 Catch:{ Throwable -> 0x008d }
        r4.a = r0;	 Catch:{ Throwable -> 0x008d }
        r5 = r4.a;	 Catch:{ Throwable -> 0x008d }
        r0 = new com.tencent.wxop.stat.j;	 Catch:{ Throwable -> 0x008d }
        r0.<init>(r4);	 Catch:{ Throwable -> 0x008d }
        r5.setKeepAliveStrategy(r0);	 Catch:{ Throwable -> 0x008d }
        return;
    L_0x008d:
        r5 = move-exception;
        r0 = d;
        r0.e(r5);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.i.<init>(android.content.Context):void");
    }

    static Context a() {
        return f;
    }

    static void a(Context context) {
        f = context.getApplicationContext();
    }

    private void a(JSONObject jSONObject) {
        try {
            StatLogger statLogger;
            StringBuilder stringBuilder;
            String optString = jSONObject.optString("mid");
            if (h.c(optString)) {
                if (StatConfig.isDebugEnable()) {
                    statLogger = d;
                    stringBuilder = new StringBuilder("update mid:");
                    stringBuilder.append(optString);
                    statLogger.i(stringBuilder.toString());
                }
                g.C(f).a(optString);
            }
            if (!jSONObject.isNull("cfg")) {
                StatConfig.a(f, jSONObject.getJSONObject("cfg"));
            }
            if (!jSONObject.isNull("ncts")) {
                int i = jSONObject.getInt("ncts");
                int currentTimeMillis = (int) (((long) i) - (System.currentTimeMillis() / 1000));
                if (StatConfig.isDebugEnable()) {
                    statLogger = d;
                    stringBuilder = new StringBuilder("server time:");
                    stringBuilder.append(i);
                    stringBuilder.append(", diff time:");
                    stringBuilder.append(currentTimeMillis);
                    statLogger.i(stringBuilder.toString());
                }
                l.x(f);
                l.a(f, currentTimeMillis);
            }
        } catch (Throwable th) {
            d.w(th);
        }
    }

    static i b(Context context) {
        if (e == null) {
            synchronized (i.class) {
                if (e == null) {
                    e = new i(context);
                }
            }
        }
        return e;
    }

    void a(com.tencent.wxop.stat.event.e eVar, h hVar) {
        b(Arrays.asList(new String[]{eVar.g()}), hVar);
    }

    void a(List<?> list, h hVar) {
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            list.get(0);
            Throwable th;
            try {
                StatLogger statLogger;
                StringBuilder stringBuilder;
                this.c.delete(0, this.c.length());
                this.c.append("[");
                String str = "rc4";
                for (int i = 0; i < size; i++) {
                    this.c.append(list.get(i).toString());
                    if (i != size - 1) {
                        this.c.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                }
                this.c.append("]");
                String stringBuilder2 = this.c.toString();
                size = stringBuilder2.length();
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(StatConfig.getStatReportUrl());
                stringBuilder3.append("/?index=");
                stringBuilder3.append(this.g);
                String stringBuilder4 = stringBuilder3.toString();
                this.g++;
                if (StatConfig.isDebugEnable()) {
                    statLogger = d;
                    StringBuilder stringBuilder5 = new StringBuilder("[");
                    stringBuilder5.append(stringBuilder4);
                    stringBuilder5.append("]Send request(");
                    stringBuilder5.append(size);
                    stringBuilder5.append("bytes), content:");
                    stringBuilder5.append(stringBuilder2);
                    statLogger.i(stringBuilder5.toString());
                }
                HttpUriRequest httpPost = new HttpPost(stringBuilder4);
                httpPost.addHeader("Accept-Encoding", "gzip");
                httpPost.setHeader(HttpConstant.CONNECTION, "Keep-Alive");
                httpPost.removeHeaders("Cache-Control");
                HttpHost a = a.a(f).a();
                httpPost.addHeader("Content-Encoding", str);
                if (a == null) {
                    this.a.getParams().removeParameter("http.route.default-proxy");
                } else {
                    if (StatConfig.isDebugEnable()) {
                        StatLogger statLogger2 = d;
                        stringBuilder = new StringBuilder("proxy:");
                        stringBuilder.append(a.toHostString());
                        statLogger2.d(stringBuilder.toString());
                    }
                    httpPost.addHeader("X-Content-Encoding", str);
                    this.a.getParams().setParameter("http.route.default-proxy", a);
                    httpPost.addHeader("X-Online-Host", StatConfig.k);
                    httpPost.addHeader("Accept", "*/*");
                    httpPost.addHeader("Content-Type", "json");
                }
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream(size);
                byte[] bytes = stringBuilder2.getBytes("UTF-8");
                int length = bytes.length;
                if ((size > StatConfig.o ? 1 : 0) != 0) {
                    httpPost.removeHeaders("Content-Encoding");
                    StringBuilder stringBuilder6 = new StringBuilder();
                    stringBuilder6.append(str);
                    stringBuilder6.append(",gzip");
                    String stringBuilder7 = stringBuilder6.toString();
                    httpPost.addHeader("Content-Encoding", stringBuilder7);
                    if (a != null) {
                        httpPost.removeHeaders("X-Content-Encoding");
                        httpPost.addHeader("X-Content-Encoding", stringBuilder7);
                    }
                    byteArrayOutputStream.write(new byte[4]);
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    gZIPOutputStream.write(bytes);
                    gZIPOutputStream.close();
                    bytes = byteArrayOutputStream.toByteArray();
                    ByteBuffer.wrap(bytes, 0, 4).putInt(length);
                    if (StatConfig.isDebugEnable()) {
                        StatLogger statLogger3 = d;
                        StringBuilder stringBuilder8 = new StringBuilder("before Gzip:");
                        stringBuilder8.append(length);
                        stringBuilder8.append(" bytes, after Gzip:");
                        stringBuilder8.append(bytes.length);
                        stringBuilder8.append(" bytes");
                        statLogger3.d(stringBuilder8.toString());
                    }
                }
                httpPost.setEntity(new ByteArrayEntity(f.a(bytes)));
                HttpResponse execute = this.a.execute(httpPost);
                HttpEntity entity = execute.getEntity();
                int statusCode = execute.getStatusLine().getStatusCode();
                long contentLength = entity.getContentLength();
                if (StatConfig.isDebugEnable()) {
                    statLogger = d;
                    stringBuilder = new StringBuilder("http recv response status code:");
                    stringBuilder.append(statusCode);
                    stringBuilder.append(", content length:");
                    stringBuilder.append(contentLength);
                    statLogger.i(stringBuilder.toString());
                }
                if (contentLength <= 0) {
                    d.e((Object) "Server response no data.");
                    if (hVar != null) {
                        hVar.b();
                    }
                    EntityUtils.toString(entity);
                    return;
                }
                if (contentLength > 0) {
                    InputStream content = entity.getContent();
                    DataInputStream dataInputStream = new DataInputStream(content);
                    byte[] bArr = new byte[((int) entity.getContentLength())];
                    dataInputStream.readFully(bArr);
                    content.close();
                    dataInputStream.close();
                    Header firstHeader = execute.getFirstHeader("Content-Encoding");
                    if (firstHeader != null) {
                        if (firstHeader.getValue().equalsIgnoreCase("gzip,rc4")) {
                            bArr = f.b(l.a(bArr));
                        } else if (firstHeader.getValue().equalsIgnoreCase("rc4,gzip")) {
                            bArr = l.a(f.b(bArr));
                        } else if (firstHeader.getValue().equalsIgnoreCase("gzip")) {
                            bArr = l.a(bArr);
                        } else if (firstHeader.getValue().equalsIgnoreCase("rc4")) {
                            bArr = f.b(bArr);
                        }
                    }
                    stringBuilder2 = new String(bArr, "UTF-8");
                    if (StatConfig.isDebugEnable()) {
                        StatLogger statLogger4 = d;
                        StringBuilder stringBuilder9 = new StringBuilder("http get response data:");
                        stringBuilder9.append(stringBuilder2);
                        statLogger4.i(stringBuilder9.toString());
                    }
                    JSONObject jSONObject = new JSONObject(stringBuilder2);
                    if (statusCode == 200) {
                        a(jSONObject);
                        if (hVar != null) {
                            if (jSONObject.optInt(KEYS.RET) == 0) {
                                hVar.a();
                            } else {
                                d.error((Object) "response error data.");
                            }
                        }
                        content.close();
                    } else {
                        StatLogger statLogger5 = d;
                        stringBuilder3 = new StringBuilder("Server response error code:");
                        stringBuilder3.append(statusCode);
                        stringBuilder3.append(", error:");
                        stringBuilder3.append(new String(bArr, "UTF-8"));
                        statLogger5.error(stringBuilder3.toString());
                        if (hVar != null) {
                        }
                        content.close();
                    }
                    hVar.b();
                    content.close();
                } else {
                    EntityUtils.toString(entity);
                }
                byteArrayOutputStream.close();
                th = null;
                if (th != null) {
                    d.error(th);
                    if (hVar != null) {
                        try {
                            hVar.b();
                        } catch (Throwable th2) {
                            d.e(th2);
                        }
                    }
                    if (th instanceof OutOfMemoryError) {
                        System.gc();
                        this.c = null;
                        this.c = new StringBuilder(2048);
                    }
                    a.a(f).d();
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    void b(List<?> list, h hVar) {
        if (this.b != null) {
            this.b.a(new k(this, list, hVar));
        }
    }
}
