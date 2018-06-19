package com.huawei.hms.update.a;

import android.content.Context;
import com.huawei.hms.update.a.a.a;
import com.huawei.hms.update.a.a.c;
import com.huawei.hms.update.b.b;
import com.huawei.hms.update.b.d;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: OtaUpdateDownload */
public class f implements a {
    private final Context a;
    private final d b = new b();
    private com.huawei.hms.update.a.a.b c;
    private File d;
    private final c e = new c();

    public f(Context context) {
        this.a = context.getApplicationContext();
    }

    private synchronized void b(com.huawei.hms.update.a.a.b bVar) {
        this.c = bVar;
    }

    private synchronized void a(int i, int i2, int i3) {
        if (this.c != null) {
            this.c.a(i, i2, i3, this.d);
        }
    }

    public Context a() {
        return this.a;
    }

    public void b() {
        com.huawei.hms.support.log.a.b("OtaUpdateDownload", "Enter cancel.");
        b(null);
        this.b.b();
    }

    public void a(com.huawei.hms.update.a.a.b bVar) {
        throw new IllegalStateException("Not supported.");
    }

    public void a(com.huawei.hms.update.a.a.b r6, com.huawei.hms.update.a.a.c r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = "callback must not be null.";
        com.huawei.hms.c.a.a(r6, r0);
        r0 = "OtaUpdateDownload";
        r1 = "Enter downloadPackage.";
        com.huawei.hms.support.log.a.b(r0, r1);
        r5.b(r6);
        r6 = 2201; // 0x899 float:3.084E-42 double:1.0874E-320;
        r0 = 0;
        if (r7 == 0) goto L_0x0099;
    L_0x0014:
        r1 = r7.a();
        if (r1 != 0) goto L_0x001c;
    L_0x001a:
        goto L_0x0099;
    L_0x001c:
        r1 = android.os.Environment.getExternalStorageState();
        r2 = "mounted";
        r1 = r2.equals(r1);
        r2 = 2204; // 0x89c float:3.088E-42 double:1.089E-320;
        if (r1 != 0) goto L_0x0035;
    L_0x002a:
        r6 = "OtaUpdateDownload";
        r7 = "In downloadPackage, Invalid external storage for downloading file.";
        com.huawei.hms.support.log.a.d(r6, r7);
        r5.a(r2, r0, r0);
        return;
    L_0x0035:
        r1 = r5.a;
        r3 = "hms/HwMobileService.apk";
        r1 = com.huawei.hms.update.provider.UpdateProvider.getLocalFile(r1, r3);
        r5.d = r1;
        r1 = r5.d;
        if (r1 != 0) goto L_0x004e;
    L_0x0043:
        r6 = "OtaUpdateDownload";
        r7 = "In downloadPackage, Failed to get local file for downloading.";
        com.huawei.hms.support.log.a.d(r6, r7);
        r5.a(r2, r0, r0);
        return;
    L_0x004e:
        r1 = r5.d;
        r1 = r1.getParentFile();
        if (r1 == 0) goto L_0x008e;
    L_0x0056:
        r2 = r1.mkdirs();
        if (r2 != 0) goto L_0x0063;
    L_0x005c:
        r2 = r1.isDirectory();
        if (r2 != 0) goto L_0x0063;
    L_0x0062:
        goto L_0x008e;
    L_0x0063:
        r1 = r1.getUsableSpace();
        r6 = 3;
        r3 = r7.c;
        r6 = r6 * r3;
        r3 = (long) r6;
        r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r6 >= 0) goto L_0x007d;
    L_0x0070:
        r6 = "OtaUpdateDownload";
        r7 = "In downloadPackage, No space for downloading file.";
        com.huawei.hms.support.log.a.d(r6, r7);
        r6 = 2203; // 0x89b float:3.087E-42 double:1.0884E-320;
        r5.a(r6, r0, r0);
        return;
    L_0x007d:
        r5.a(r7);	 Catch:{ a -> 0x0081 }
        return;
    L_0x0081:
        r6 = "OtaUpdateDownload";
        r7 = "In downloadPackage, Canceled to download the update file.";
        com.huawei.hms.support.log.a.c(r6, r7);
        r6 = 2101; // 0x835 float:2.944E-42 double:1.038E-320;
        r5.a(r6, r0, r0);
        return;
    L_0x008e:
        r7 = "OtaUpdateDownload";
        r1 = "In downloadPackage, Failed to create directory for downloading file.";
        com.huawei.hms.support.log.a.d(r7, r1);
        r5.a(r6, r0, r0);
        return;
    L_0x0099:
        r7 = "OtaUpdateDownload";
        r1 = "In downloadPackage, Invalid update info.";
        com.huawei.hms.support.log.a.d(r7, r1);
        r5.a(r6, r0, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.update.a.f.a(com.huawei.hms.update.a.a.b, com.huawei.hms.update.a.a.c):void");
    }

    private static boolean a(String str, File file) {
        file = com.huawei.hms.c.f.a(file);
        return file != null ? com.huawei.hms.c.b.b(file, true).equalsIgnoreCase(str) : null;
    }

    void a(c cVar) throws com.huawei.hms.update.b.a {
        StringBuilder stringBuilder;
        com.huawei.hms.support.log.a.b("OtaUpdateDownload", "Enter downloadPackage.");
        OutputStream outputStream = null;
        try {
            this.e.a(a());
            OutputStream a;
            int a2;
            if (this.e.b(cVar.b, cVar.c, cVar.d)) {
                if (this.e.b() != this.e.a()) {
                    a = a(this.d, cVar.c);
                    try {
                        a.a((long) this.e.b());
                    } catch (IOException e) {
                        cVar = e;
                        outputStream = a;
                        try {
                            stringBuilder = new StringBuilder("In DownloadHelper.downloadPackage, Failed to download.");
                            stringBuilder.append(cVar.getMessage());
                            com.huawei.hms.support.log.a.d("OtaUpdateDownload", stringBuilder.toString());
                            a(2201, 0, 0);
                            this.b.a();
                            com.huawei.hms.c.c.a(outputStream);
                        } catch (Throwable th) {
                            cVar = th;
                            this.b.a();
                            com.huawei.hms.c.c.a(outputStream);
                            throw cVar;
                        }
                    } catch (Throwable th2) {
                        cVar = th2;
                        outputStream = a;
                        this.b.a();
                        com.huawei.hms.c.c.a(outputStream);
                        throw cVar;
                    }
                } else if (a(cVar.d, this.d)) {
                    a(2000, 0, 0);
                } else {
                    this.e.a(cVar.b, cVar.c, cVar.d);
                    a = a(this.d, cVar.c);
                }
                outputStream = a;
                a2 = this.b.a(cVar.b, outputStream, this.e.b(), this.e.a());
                if (a2 == 200 && a2 != 206) {
                    stringBuilder = new StringBuilder("In DownloadHelper.downloadPackage, Download the package, HTTP code: ");
                    stringBuilder.append(a2);
                    com.huawei.hms.support.log.a.d("OtaUpdateDownload", stringBuilder.toString());
                    a(2201, 0, 0);
                } else if (a(cVar.d, this.d) != null) {
                    a(2202, 0, 0);
                } else {
                    a(2000, 0, 0);
                    this.b.a();
                    com.huawei.hms.c.c.a(outputStream);
                }
            }
            this.e.a(cVar.b, cVar.c, cVar.d);
            a = a(this.d, cVar.c);
            outputStream = a;
            a2 = this.b.a(cVar.b, outputStream, this.e.b(), this.e.a());
            if (a2 == 200) {
            }
            if (a(cVar.d, this.d) != null) {
                a(2000, 0, 0);
                this.b.a();
                com.huawei.hms.c.c.a(outputStream);
            }
            a(2202, 0, 0);
            this.b.a();
            com.huawei.hms.c.c.a(outputStream);
        } catch (IOException e2) {
            cVar = e2;
            stringBuilder = new StringBuilder("In DownloadHelper.downloadPackage, Failed to download.");
            stringBuilder.append(cVar.getMessage());
            com.huawei.hms.support.log.a.d("OtaUpdateDownload", stringBuilder.toString());
            a(2201, 0, 0);
            this.b.a();
            com.huawei.hms.c.c.a(outputStream);
        }
    }

    private h a(File file, int i) throws IOException {
        return new g(this, file, i, i);
    }
}
