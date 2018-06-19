package com.igexin.push.f.a;

import android.os.Process;
import com.igexin.b.a.b.f;
import com.igexin.b.a.c.a;
import com.igexin.b.a.d.e;
import com.igexin.push.config.m;
import com.igexin.push.util.EncryptUtils;
import java.net.HttpURLConnection;
import java.net.URL;

public class c extends e {
    public b a;
    private HttpURLConnection b;

    public c(b bVar) {
        super(0);
        this.a = bVar;
    }

    private com.igexin.push.f.a.d a(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r3 = r2.b(r3);	 Catch:{ Throwable -> 0x001d, all -> 0x0018 }
        r2.b = r3;	 Catch:{ Throwable -> 0x001d, all -> 0x0018 }
        r3 = r2.b;	 Catch:{ Throwable -> 0x001d, all -> 0x0018 }
        r3 = r2.a(r3);	 Catch:{ Throwable -> 0x001d, all -> 0x0018 }
        if (r3 == 0) goto L_0x001d;	 Catch:{ Throwable -> 0x001d, all -> 0x0018 }
    L_0x000e:
        r0 = r2.b;	 Catch:{ Throwable -> 0x001d, all -> 0x0018 }
        r3 = r2.b(r0, r3);	 Catch:{ Throwable -> 0x001d, all -> 0x0018 }
        r2.g();
        return r3;
    L_0x0018:
        r3 = move-exception;
        r2.g();
        throw r3;
    L_0x001d:
        r2.g();
        r3 = new com.igexin.push.f.a.d;
        r0 = 0;
        r1 = 0;
        r3.<init>(r2, r0, r1);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.f.a.c.a(java.lang.String):com.igexin.push.f.a.d");
    }

    private com.igexin.push.f.a.d a(java.lang.String r4, byte[] r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = 0;
        r1 = 0;
        r4 = r3.b(r4, r5);	 Catch:{ Throwable -> 0x0053, all -> 0x0049 }
        r3.b = r4;	 Catch:{ Throwable -> 0x0053, all -> 0x0049 }
        r4 = r3.b;	 Catch:{ Throwable -> 0x0053, all -> 0x0049 }
        r4 = r3.a(r5, r4);	 Catch:{ Throwable -> 0x0053, all -> 0x0049 }
        if (r4 != 0) goto L_0x001a;	 Catch:{ Throwable -> 0x0053, all -> 0x0049 }
    L_0x0010:
        r4 = new com.igexin.push.f.a.d;	 Catch:{ Throwable -> 0x0053, all -> 0x0049 }
        r5 = 1;	 Catch:{ Throwable -> 0x0053, all -> 0x0049 }
        r4.<init>(r3, r5, r1);	 Catch:{ Throwable -> 0x0053, all -> 0x0049 }
        r3.g();
        return r4;
    L_0x001a:
        r5 = r3.b;	 Catch:{ Throwable -> 0x0053, all -> 0x0049 }
        r5.connect();	 Catch:{ Throwable -> 0x0053, all -> 0x0049 }
        r5 = new java.io.DataOutputStream;	 Catch:{ Throwable -> 0x0053, all -> 0x0049 }
        r2 = r3.b;	 Catch:{ Throwable -> 0x0053, all -> 0x0049 }
        r2 = r2.getOutputStream();	 Catch:{ Throwable -> 0x0053, all -> 0x0049 }
        r5.<init>(r2);	 Catch:{ Throwable -> 0x0053, all -> 0x0049 }
        r2 = r4.length;	 Catch:{ Throwable -> 0x0054, all -> 0x0046 }
        r5.write(r4, r0, r2);	 Catch:{ Throwable -> 0x0054, all -> 0x0046 }
        r5.flush();	 Catch:{ Throwable -> 0x0054, all -> 0x0046 }
        r4 = r3.b;	 Catch:{ Throwable -> 0x0054, all -> 0x0046 }
        r4 = r3.a(r4);	 Catch:{ Throwable -> 0x0054, all -> 0x0046 }
        if (r4 == 0) goto L_0x0056;	 Catch:{ Throwable -> 0x0054, all -> 0x0046 }
    L_0x0039:
        r2 = r3.b;	 Catch:{ Throwable -> 0x0054, all -> 0x0046 }
        r4 = r3.b(r2, r4);	 Catch:{ Throwable -> 0x0054, all -> 0x0046 }
        r5.close();	 Catch:{ Exception -> 0x0042 }
    L_0x0042:
        r3.g();
        return r4;
    L_0x0046:
        r4 = move-exception;
        r1 = r5;
        goto L_0x004a;
    L_0x0049:
        r4 = move-exception;
    L_0x004a:
        if (r1 == 0) goto L_0x004f;
    L_0x004c:
        r1.close();	 Catch:{ Exception -> 0x004f }
    L_0x004f:
        r3.g();
        throw r4;
    L_0x0053:
        r5 = r1;
    L_0x0054:
        if (r5 == 0) goto L_0x0059;
    L_0x0056:
        r5.close();	 Catch:{ Exception -> 0x0059 }
    L_0x0059:
        r3.g();
        r4 = new com.igexin.push.f.a.d;
        r4.<init>(r3, r0, r1);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.f.a.c.a(java.lang.String, byte[]):com.igexin.push.f.a.d");
    }

    private void a(HttpURLConnection httpURLConnection, byte[] bArr) {
        if (httpURLConnection != null) {
            byte[] bArr2 = new byte[0];
            if (bArr == null) {
                bArr = bArr2;
            }
            httpURLConnection.addRequestProperty("GT_C_T", "1");
            httpURLConnection.addRequestProperty("GT_C_K", new String(EncryptUtils.getRSAKeyId()));
            httpURLConnection.addRequestProperty("GT_C_V", EncryptUtils.getHttpGTCV());
            String valueOf = String.valueOf(System.currentTimeMillis());
            String httpSignature = EncryptUtils.getHttpSignature(valueOf, bArr);
            httpURLConnection.addRequestProperty("GT_T", valueOf);
            httpURLConnection.addRequestProperty("GT_C_S", httpSignature);
        }
    }

    private void a(byte[] bArr) {
        this.a.a(bArr);
        com.igexin.b.a.b.c.b().a(this.a);
        com.igexin.b.a.b.c.b().c();
    }

    private byte[] a(java.net.HttpURLConnection r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = 0;
        r1 = r5.getInputStream();	 Catch:{ Exception -> 0x003a }
        r2 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0034, all -> 0x0032 }
        r2.<init>();	 Catch:{ Exception -> 0x0034, all -> 0x0032 }
        r5 = r5.getResponseCode();	 Catch:{ Exception -> 0x0034, all -> 0x0032 }
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ Exception -> 0x0034, all -> 0x0032 }
        if (r5 != r3) goto L_0x002c;	 Catch:{ Exception -> 0x0034, all -> 0x0032 }
    L_0x0012:
        r5 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;	 Catch:{ Exception -> 0x0034, all -> 0x0032 }
        r5 = new byte[r5];	 Catch:{ Exception -> 0x0034, all -> 0x0032 }
    L_0x0016:
        r0 = r1.read(r5);	 Catch:{ Exception -> 0x0034, all -> 0x0032 }
        r3 = -1;	 Catch:{ Exception -> 0x0034, all -> 0x0032 }
        if (r0 == r3) goto L_0x0022;	 Catch:{ Exception -> 0x0034, all -> 0x0032 }
    L_0x001d:
        r3 = 0;	 Catch:{ Exception -> 0x0034, all -> 0x0032 }
        r2.write(r5, r3, r0);	 Catch:{ Exception -> 0x0034, all -> 0x0032 }
        goto L_0x0016;	 Catch:{ Exception -> 0x0034, all -> 0x0032 }
    L_0x0022:
        r5 = r2.toByteArray();	 Catch:{ Exception -> 0x0034, all -> 0x0032 }
        if (r1 == 0) goto L_0x002b;
    L_0x0028:
        r1.close();	 Catch:{ Exception -> 0x002b }
    L_0x002b:
        return r5;
    L_0x002c:
        if (r1 == 0) goto L_0x0031;
    L_0x002e:
        r1.close();	 Catch:{ Exception -> 0x0031 }
    L_0x0031:
        return r0;
    L_0x0032:
        r5 = move-exception;
        goto L_0x003c;
    L_0x0034:
        r5 = move-exception;
        r0 = r1;
        goto L_0x003b;
    L_0x0037:
        r5 = move-exception;
        r1 = r0;
        goto L_0x003c;
    L_0x003a:
        r5 = move-exception;
    L_0x003b:
        throw r5;	 Catch:{ all -> 0x0037 }
    L_0x003c:
        if (r1 == 0) goto L_0x0041;
    L_0x003e:
        r1.close();	 Catch:{ Exception -> 0x0041 }
    L_0x0041:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.f.a.c.a(java.net.HttpURLConnection):byte[]");
    }

    private byte[] a(byte[] bArr, HttpURLConnection httpURLConnection) {
        try {
            if (httpURLConnection.getRequestProperties().containsKey("GT_C_S")) {
                String requestProperty = httpURLConnection.getRequestProperty("GT_C_S");
                if (requestProperty != null) {
                    return EncryptUtils.aesEncHttp(bArr, EncryptUtils.md5(requestProperty.getBytes()));
                }
            }
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("_HttpTask|");
            stringBuilder.append(th.toString());
            a.b(stringBuilder.toString());
        }
        return null;
    }

    private d b(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            String headerField = httpURLConnection.getHeaderField("GT_ERR");
            StringBuilder stringBuilder = new StringBuilder("_HttpTask|GT_ERR = ");
            stringBuilder.append(headerField);
            a.b(stringBuilder.toString());
            if (headerField != null) {
                if (headerField.equals("0")) {
                    headerField = httpURLConnection.getHeaderField("GT_T");
                    if (headerField == null) {
                        a.b("_HttpTask|GT_T = null");
                        return new d(this, true, null);
                    }
                    String headerField2 = httpURLConnection.getHeaderField("GT_C_S");
                    if (headerField2 == null) {
                        a.b("_HttpTask|GT_C_S = null");
                        return new d(this, true, null);
                    }
                    bArr = EncryptUtils.aesDecHttp(bArr, EncryptUtils.md5(headerField.getBytes()));
                    headerField = EncryptUtils.getHttpSignature(headerField, bArr);
                    if (headerField != null) {
                        if (headerField.equals(headerField2)) {
                            return new d(this, false, bArr);
                        }
                    }
                    a.b("_HttpTask|signature = null or error");
                    return new d(this, true, null);
                }
            }
            return new d(this, true, null);
        } catch (Throwable th) {
            StringBuilder stringBuilder2 = new StringBuilder("_HttpTask|");
            stringBuilder2.append(th.toString());
            a.b(stringBuilder2.toString());
            return new d(this, true, null);
        }
    }

    private HttpURLConnection b(String str) {
        this.b = (HttpURLConnection) new URL(str).openConnection();
        this.b.setConnectTimeout(20000);
        this.b.setReadTimeout(20000);
        this.b.setRequestMethod("GET");
        this.b.setDoInput(true);
        a(this.b, null);
        return this.b;
    }

    private HttpURLConnection b(String str, byte[] bArr) {
        this.b = (HttpURLConnection) new URL(str).openConnection();
        this.b.setDoInput(true);
        this.b.setDoOutput(true);
        this.b.setRequestMethod("POST");
        this.b.setUseCaches(false);
        this.b.setInstanceFollowRedirects(true);
        this.b.setRequestProperty("Content-Type", "application/octet-stream");
        this.b.setConnectTimeout(20000);
        this.b.setReadTimeout(20000);
        a(this.b, bArr);
        return this.b;
    }

    private void g() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.b;
        if (r0 == 0) goto L_0x000c;
    L_0x0004:
        r0 = r1.b;	 Catch:{ Exception -> 0x000c }
        r0.disconnect();	 Catch:{ Exception -> 0x000c }
        r0 = 0;	 Catch:{ Exception -> 0x000c }
        r1.b = r0;	 Catch:{ Exception -> 0x000c }
    L_0x000c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.f.a.c.g():void");
    }

    public final int b() {
        return -2147483638;
    }

    public final void b_() {
        super.b_();
        Process.setThreadPriority(10);
        if (!(this.a == null || this.a.b == null)) {
            if (this.a.c == null || this.a.c.length <= m.K * 1024) {
                if (this.a.c != null && this.a.c.length > 0) {
                    this.a.c = f.c(this.a.c);
                }
                int i = 0;
                while (i < 3) {
                    d a = this.a.c == null ? a(this.a.b) : a(this.a.b, this.a.c);
                    if (a.a) {
                        throw new Exception("http server resp decode header error");
                    } else if (a.b != null) {
                        a(a.b);
                        return;
                    } else if (i == 2) {
                        this.a.a(new Exception("try up to limit"));
                        StringBuilder stringBuilder = new StringBuilder("http request exception, try times = ");
                        stringBuilder.append(i + 1);
                        throw new Exception(stringBuilder.toString());
                    } else {
                        i++;
                    }
                }
                return;
            }
        }
        p();
        a.b("_HttpTask|run return ###");
    }

    public void d() {
        this.n = true;
    }

    protected void e() {
    }

    public void f() {
        super.f();
        g();
    }
}
