package com.huawei.hms.update.a;

import android.content.Context;
import com.huawei.hms.update.a.a.a;
import com.huawei.hms.update.a.a.c;
import com.huawei.hms.update.b.b;
import com.huawei.hms.update.b.d;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/* compiled from: OtaUpdateCheck */
public class e implements a {
    private final Context a;
    private final d b = new b();
    private com.huawei.hms.update.a.a.b c;
    private String d;
    private c e;

    public e(Context context) {
        this.a = context.getApplicationContext();
    }

    private synchronized void b(com.huawei.hms.update.a.a.b bVar) {
        this.c = bVar;
    }

    private synchronized void a(int i) {
        if (this.c != null) {
            this.c.a(i, this.e);
        }
    }

    public Context a() {
        return this.a;
    }

    public void b() {
        com.huawei.hms.support.log.a.b("OtaUpdateCheck", "Enter cancel.");
        b(null);
        this.b.b();
    }

    public void a(com.huawei.hms.update.a.a.b r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = "callback must not be null.";
        com.huawei.hms.c.a.a(r3, r0);
        r0 = "OtaUpdateCheck";
        r1 = "Enter checkUpdate.";
        com.huawei.hms.support.log.a.b(r0, r1);
        r2.b(r3);
        r3 = new com.huawei.hms.update.a.a.c;
        r3.<init>();
        r2.e = r3;
        r3 = r2.e;
        r0 = r2.a;
        r3.a(r0);
        r3 = r2.e;
        r3 = r3.a();
        if (r3 == 0) goto L_0x0034;
    L_0x0025:
        r3 = r2.e;
        r3 = r3.a;
        r0 = 20502300; // 0x138d71c float:3.3949796E-38 double:1.0129482E-316;
        if (r3 < r0) goto L_0x0034;
    L_0x002e:
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2.a(r3);
        return;
    L_0x0034:
        r2.c();	 Catch:{ a -> 0x0038 }
        return;
    L_0x0038:
        r3 = "OtaUpdateCheck";
        r0 = "In checkUpdate, Canceled to download the update file.";
        com.huawei.hms.support.log.a.c(r3, r0);
        r3 = 1101; // 0x44d float:1.543E-42 double:5.44E-321;
        r2.a(r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.update.a.e.a(com.huawei.hms.update.a.a.b):void");
    }

    public void a(com.huawei.hms.update.a.a.b bVar, c cVar) {
        throw new IllegalStateException("Not supported.");
    }

    private void c() throws com.huawei.hms.update.b.a {
        com.huawei.hms.support.log.a.b("OtaUpdateCheck", "Enter checkUpdate.");
        StringBuilder stringBuilder;
        try {
            int d = d();
            if (d != 200) {
                stringBuilder = new StringBuilder("In CheckUpdateHelper.checkUpdate, Check whether has a new version, HTTP code: ");
                stringBuilder.append(d);
                com.huawei.hms.support.log.a.d("OtaUpdateCheck", stringBuilder.toString());
                a(1201);
            } else if (this.d == null) {
                a(1202);
            } else {
                d = e();
                if (d != 200) {
                    stringBuilder = new StringBuilder("In CheckUpdateHelper.checkUpdate, Request the update-info of the new version, HTTP code: ");
                    stringBuilder.append(d);
                    com.huawei.hms.support.log.a.d("OtaUpdateCheck", stringBuilder.toString());
                    a(1201);
                    return;
                }
                if (this.e != null) {
                    if (this.e.a >= 20502300) {
                        this.e.b(this.a);
                        a(1000);
                        return;
                    }
                }
                a(1203);
            }
        } catch (IOException e) {
            stringBuilder = new StringBuilder("In CheckUpdateHelper.checkUpdate, Failed to check update.");
            stringBuilder.append(e.getMessage());
            com.huawei.hms.support.log.a.d("OtaUpdateCheck", stringBuilder.toString());
            a(1201);
        }
    }

    private int d() throws IOException, com.huawei.hms.update.b.a {
        InputStream byteArrayInputStream;
        Throwable th;
        a aVar = new a(this.a);
        if (com.huawei.hms.support.log.a.a()) {
            StringBuilder stringBuilder = new StringBuilder("In doCheckUpdate, Check update params: ");
            stringBuilder.append(aVar.toString());
            com.huawei.hms.support.log.a.a("OtaUpdateCheck", stringBuilder.toString());
        }
        OutputStream byteArrayOutputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(aVar.a().toString().getBytes(Charset.defaultCharset()));
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    int a = this.b.a("https://query.hicloud.com/hwid/v2/CheckEx.action", byteArrayInputStream, byteArrayOutputStream);
                    if (a == 200) {
                        String str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                        if (com.huawei.hms.support.log.a.a()) {
                            StringBuilder stringBuilder2 = new StringBuilder("In CheckUpdateHelper.doCheckUpdate, Check update response: ");
                            stringBuilder2.append(str);
                            com.huawei.hms.support.log.a.a("OtaUpdateCheck", stringBuilder2.toString());
                        }
                        this.d = b.a(str).a();
                    }
                    com.huawei.hms.c.c.a(byteArrayOutputStream);
                    com.huawei.hms.c.c.a(byteArrayInputStream);
                    this.b.a();
                    return a;
                } catch (Throwable th2) {
                    th = th2;
                    com.huawei.hms.c.c.a(byteArrayOutputStream);
                    com.huawei.hms.c.c.a(byteArrayInputStream);
                    this.b.a();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
                com.huawei.hms.c.c.a(byteArrayOutputStream);
                com.huawei.hms.c.c.a(byteArrayInputStream);
                this.b.a();
                throw th;
            }
        } catch (Throwable th32) {
            byteArrayInputStream = null;
            th = th32;
            byteArrayOutputStream = byteArrayInputStream;
            com.huawei.hms.c.c.a(byteArrayOutputStream);
            com.huawei.hms.c.c.a(byteArrayInputStream);
            this.b.a();
            throw th;
        }
    }

    private int e() throws IOException, com.huawei.hms.update.b.a {
        OutputStream byteArrayOutputStream;
        Throwable th;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                d dVar = this.b;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.d);
                stringBuilder.append("full/filelist.xml");
                int a = dVar.a(stringBuilder.toString(), byteArrayOutputStream);
                if (a == 200) {
                    String str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    if (com.huawei.hms.support.log.a.a()) {
                        StringBuilder stringBuilder2 = new StringBuilder("In doGetFilelist, Check update response: ");
                        stringBuilder2.append(str);
                        com.huawei.hms.support.log.a.a("OtaUpdateCheck", stringBuilder2.toString());
                    }
                    d a2 = d.a(str);
                    int d = a2.d();
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(this.d);
                    stringBuilder3.append("full/");
                    stringBuilder3.append(a2.a());
                    this.e = new c(d, stringBuilder3.toString(), a2.b(), a2.c());
                }
                com.huawei.hms.c.c.a(byteArrayOutputStream);
                this.b.a();
                return a;
            } catch (Throwable th2) {
                th = th2;
                com.huawei.hms.c.c.a(byteArrayOutputStream);
                this.b.a();
                throw th;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            byteArrayOutputStream = null;
            th = th4;
            com.huawei.hms.c.c.a(byteArrayOutputStream);
            this.b.a();
            throw th;
        }
    }
}
