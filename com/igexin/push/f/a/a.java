package com.igexin.push.f.a;

import android.os.Process;
import com.igexin.b.a.b.c;
import com.igexin.b.a.d.e;
import com.igexin.push.config.m;
import java.net.HttpURLConnection;

public class a extends e {
    public static final String a = "com.igexin.push.f.a.a";
    public b b;
    private HttpURLConnection c;

    public a(b bVar) {
        super(0);
        this.b = bVar;
    }

    private byte[] a(java.lang.String r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = 0;
        r1 = new java.net.URL;	 Catch:{ Exception -> 0x007f, all -> 0x006f }
        r1.<init>(r7);	 Catch:{ Exception -> 0x007f, all -> 0x006f }
        r7 = r1.openConnection();	 Catch:{ Exception -> 0x007f, all -> 0x006f }
        r7 = (java.net.HttpURLConnection) r7;	 Catch:{ Exception -> 0x007f, all -> 0x006f }
        r6.c = r7;	 Catch:{ Exception -> 0x007f, all -> 0x006f }
        r7 = r6.c;	 Catch:{ Exception -> 0x007f, all -> 0x006f }
        r1 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;	 Catch:{ Exception -> 0x007f, all -> 0x006f }
        r7.setConnectTimeout(r1);	 Catch:{ Exception -> 0x007f, all -> 0x006f }
        r7 = r6.c;	 Catch:{ Exception -> 0x007f, all -> 0x006f }
        r7.setReadTimeout(r1);	 Catch:{ Exception -> 0x007f, all -> 0x006f }
        r7 = r6.c;	 Catch:{ Exception -> 0x007f, all -> 0x006f }
        r1 = "GET";	 Catch:{ Exception -> 0x007f, all -> 0x006f }
        r7.setRequestMethod(r1);	 Catch:{ Exception -> 0x007f, all -> 0x006f }
        r7 = r6.c;	 Catch:{ Exception -> 0x007f, all -> 0x006f }
        r1 = 1;	 Catch:{ Exception -> 0x007f, all -> 0x006f }
        r7.setDoInput(r1);	 Catch:{ Exception -> 0x007f, all -> 0x006f }
        r7 = r6.c;	 Catch:{ Exception -> 0x007f, all -> 0x006f }
        r7 = r7.getInputStream();	 Catch:{ Exception -> 0x007f, all -> 0x006f }
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x006d, all -> 0x0067 }
        r1.<init>();	 Catch:{ Exception -> 0x006d, all -> 0x0067 }
        r2 = r6.c;	 Catch:{ Exception -> 0x0081, all -> 0x0062 }
        r2 = r2.getResponseCode();	 Catch:{ Exception -> 0x0081, all -> 0x0062 }
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ Exception -> 0x0081, all -> 0x0062 }
        if (r2 != r3) goto L_0x005c;	 Catch:{ Exception -> 0x0081, all -> 0x0062 }
    L_0x003c:
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;	 Catch:{ Exception -> 0x0081, all -> 0x0062 }
        r2 = new byte[r2];	 Catch:{ Exception -> 0x0081, all -> 0x0062 }
    L_0x0040:
        r3 = r7.read(r2);	 Catch:{ Exception -> 0x0081, all -> 0x0062 }
        r4 = -1;	 Catch:{ Exception -> 0x0081, all -> 0x0062 }
        if (r3 == r4) goto L_0x004c;	 Catch:{ Exception -> 0x0081, all -> 0x0062 }
    L_0x0047:
        r4 = 0;	 Catch:{ Exception -> 0x0081, all -> 0x0062 }
        r1.write(r2, r4, r3);	 Catch:{ Exception -> 0x0081, all -> 0x0062 }
        goto L_0x0040;	 Catch:{ Exception -> 0x0081, all -> 0x0062 }
    L_0x004c:
        r2 = r1.toByteArray();	 Catch:{ Exception -> 0x0081, all -> 0x0062 }
        if (r7 == 0) goto L_0x0055;
    L_0x0052:
        r7.close();	 Catch:{ Exception -> 0x0055 }
    L_0x0055:
        r1.close();	 Catch:{ Exception -> 0x0058 }
    L_0x0058:
        r6.g();
        return r2;
    L_0x005c:
        if (r7 == 0) goto L_0x0088;
    L_0x005e:
        r7.close();	 Catch:{ Exception -> 0x0088 }
        goto L_0x0088;
    L_0x0062:
        r0 = move-exception;
        r5 = r0;
        r0 = r7;
        r7 = r5;
        goto L_0x0071;
    L_0x0067:
        r1 = move-exception;
        r5 = r0;
        r0 = r7;
        r7 = r1;
        r1 = r5;
        goto L_0x0071;
    L_0x006d:
        r1 = r0;
        goto L_0x0081;
    L_0x006f:
        r7 = move-exception;
        r1 = r0;
    L_0x0071:
        if (r0 == 0) goto L_0x0076;
    L_0x0073:
        r0.close();	 Catch:{ Exception -> 0x0076 }
    L_0x0076:
        if (r1 == 0) goto L_0x007b;
    L_0x0078:
        r1.close();	 Catch:{ Exception -> 0x007b }
    L_0x007b:
        r6.g();
        throw r7;
    L_0x007f:
        r7 = r0;
        r1 = r7;
    L_0x0081:
        if (r7 == 0) goto L_0x0086;
    L_0x0083:
        r7.close();	 Catch:{ Exception -> 0x0086 }
    L_0x0086:
        if (r1 == 0) goto L_0x008b;
    L_0x0088:
        r1.close();	 Catch:{ Exception -> 0x008b }
    L_0x008b:
        r6.g();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.f.a.a.a(java.lang.String):byte[]");
    }

    private byte[] a(java.lang.String r8, byte[] r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = 0;
        r1 = new java.net.URL;	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r1.<init>(r8);	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r8 = r1.openConnection();	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r8 = (java.net.HttpURLConnection) r8;	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r7.c = r8;	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r8 = r7.c;	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r1 = 1;	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r8.setDoInput(r1);	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r8 = r7.c;	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r8.setDoOutput(r1);	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r8 = r7.c;	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r2 = "POST";	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r8.setRequestMethod(r2);	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r8 = r7.c;	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r2 = 0;	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r8.setUseCaches(r2);	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r8 = r7.c;	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r8.setInstanceFollowRedirects(r1);	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r8 = r7.c;	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r1 = "Content-Type";	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r3 = "application/octet-stream";	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r8.setRequestProperty(r1, r3);	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r8 = r7.c;	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r1 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r8.setConnectTimeout(r1);	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r8 = r7.c;	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r8.setReadTimeout(r1);	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r8 = r7.c;	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r8.connect();	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r8 = new java.io.DataOutputStream;	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r1 = r7.c;	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r1 = r1.getOutputStream();	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r8.<init>(r1);	 Catch:{ Exception -> 0x00bd, all -> 0x00a7 }
        r1 = r9.length;	 Catch:{ Exception -> 0x00a5, all -> 0x009f }
        r8.write(r9, r2, r1);	 Catch:{ Exception -> 0x00a5, all -> 0x009f }
        r8.flush();	 Catch:{ Exception -> 0x00a5, all -> 0x009f }
        r9 = r7.c;	 Catch:{ Exception -> 0x00a5, all -> 0x009f }
        r9 = r9.getResponseCode();	 Catch:{ Exception -> 0x00a5, all -> 0x009f }
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ Exception -> 0x00a5, all -> 0x009f }
        if (r9 != r1) goto L_0x009b;	 Catch:{ Exception -> 0x00a5, all -> 0x009f }
    L_0x0061:
        r9 = r7.c;	 Catch:{ Exception -> 0x00a5, all -> 0x009f }
        r9 = r9.getInputStream();	 Catch:{ Exception -> 0x00a5, all -> 0x009f }
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0099, all -> 0x0093 }
        r1.<init>();	 Catch:{ Exception -> 0x0099, all -> 0x0093 }
        r3 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r3 = new byte[r3];	 Catch:{ Exception -> 0x00c0, all -> 0x008e }
    L_0x0070:
        r4 = r9.read(r3);	 Catch:{ Exception -> 0x00c0, all -> 0x008e }
        r5 = -1;	 Catch:{ Exception -> 0x00c0, all -> 0x008e }
        if (r4 == r5) goto L_0x007b;	 Catch:{ Exception -> 0x00c0, all -> 0x008e }
    L_0x0077:
        r1.write(r3, r2, r4);	 Catch:{ Exception -> 0x00c0, all -> 0x008e }
        goto L_0x0070;	 Catch:{ Exception -> 0x00c0, all -> 0x008e }
    L_0x007b:
        r2 = r1.toByteArray();	 Catch:{ Exception -> 0x00c0, all -> 0x008e }
        r8.close();	 Catch:{ Exception -> 0x0082 }
    L_0x0082:
        if (r9 == 0) goto L_0x0087;
    L_0x0084:
        r9.close();	 Catch:{ Exception -> 0x0087 }
    L_0x0087:
        r1.close();	 Catch:{ Exception -> 0x008a }
    L_0x008a:
        r7.g();
        return r2;
    L_0x008e:
        r0 = move-exception;
        r6 = r0;
        r0 = r8;
        r8 = r6;
        goto L_0x00aa;
    L_0x0093:
        r1 = move-exception;
        r6 = r0;
        r0 = r8;
        r8 = r1;
        r1 = r6;
        goto L_0x00aa;
    L_0x0099:
        r1 = r0;
        goto L_0x00c0;
    L_0x009b:
        r8.close();	 Catch:{ Exception -> 0x00cf }
        goto L_0x00cf;
    L_0x009f:
        r9 = move-exception;
        r1 = r0;
        r0 = r8;
        r8 = r9;
        r9 = r1;
        goto L_0x00aa;
    L_0x00a5:
        r9 = r0;
        goto L_0x00bf;
    L_0x00a7:
        r8 = move-exception;
        r9 = r0;
        r1 = r9;
    L_0x00aa:
        if (r0 == 0) goto L_0x00af;
    L_0x00ac:
        r0.close();	 Catch:{ Exception -> 0x00af }
    L_0x00af:
        if (r9 == 0) goto L_0x00b4;
    L_0x00b1:
        r9.close();	 Catch:{ Exception -> 0x00b4 }
    L_0x00b4:
        if (r1 == 0) goto L_0x00b9;
    L_0x00b6:
        r1.close();	 Catch:{ Exception -> 0x00b9 }
    L_0x00b9:
        r7.g();
        throw r8;
    L_0x00bd:
        r8 = r0;
        r9 = r8;
    L_0x00bf:
        r1 = r9;
    L_0x00c0:
        if (r8 == 0) goto L_0x00c5;
    L_0x00c2:
        r8.close();	 Catch:{ Exception -> 0x00c5 }
    L_0x00c5:
        if (r9 == 0) goto L_0x00ca;
    L_0x00c7:
        r9.close();	 Catch:{ Exception -> 0x00ca }
    L_0x00ca:
        if (r1 == 0) goto L_0x00cf;
    L_0x00cc:
        r1.close();	 Catch:{ Exception -> 0x00cf }
    L_0x00cf:
        r7.g();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.f.a.a.a(java.lang.String, byte[]):byte[]");
    }

    private void g() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.c;
        if (r0 == 0) goto L_0x000c;
    L_0x0004:
        r0 = r1.c;	 Catch:{ Exception -> 0x000c }
        r0.disconnect();	 Catch:{ Exception -> 0x000c }
        r0 = 0;	 Catch:{ Exception -> 0x000c }
        r1.c = r0;	 Catch:{ Exception -> 0x000c }
    L_0x000c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.f.a.a.g():void");
    }

    public final int b() {
        return -2147483639;
    }

    public final void b_() {
        Exception e;
        super.b_();
        Process.setThreadPriority(10);
        if (!(this.b == null || this.b.b == null)) {
            if (this.b.c == null || this.b.c.length <= m.K * 1024) {
                try {
                    byte[] a = this.b.c == null ? a(this.b.b) : a(this.b.b, this.b.c);
                    if (a != null) {
                        try {
                            this.b.a(a);
                            c.b().a(this.b);
                            c.b().c();
                            return;
                        } catch (Exception e2) {
                            this.b.a(e2);
                            throw e2;
                        }
                    }
                    e2 = new Exception("Http response ＝＝ null");
                    this.b.a(e2);
                    throw e2;
                } catch (Exception e22) {
                    this.b.a(e22);
                    throw e22;
                }
            }
        }
        p();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append("|run return ###");
        com.igexin.b.a.c.a.b(stringBuilder.toString());
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
