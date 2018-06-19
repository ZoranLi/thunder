package com.igexin.push.core.c;

import android.content.Context;
import android.content.Intent;
import com.igexin.b.a.c.a;
import com.igexin.push.core.bean.f;
import com.igexin.push.core.g;
import org.android.agoo.common.AgooConstants;

public class h implements Runnable {
    private Context a;
    private f b;
    private boolean c;
    private int d;

    public h(Context context, f fVar, boolean z) {
        this.a = context;
        this.b = fVar;
        this.c = z;
    }

    public boolean a(java.lang.String r12, java.lang.String r13, java.lang.String r14) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r11 = this;
        r0 = android.text.TextUtils.isEmpty(r13);
        r1 = 0;
        if (r0 == 0) goto L_0x0019;
    L_0x0007:
        r12 = new java.lang.StringBuilder;
        r14 = "HttpExtensionDownload|downLoad ext name is invalid name = ";
        r12.<init>(r14);
        r12.append(r13);
        r12 = r12.toString();
    L_0x0015:
        com.igexin.b.a.c.a.b(r12);
        return r1;
    L_0x0019:
        r0 = android.text.TextUtils.isEmpty(r12);
        r2 = 3;
        if (r0 == 0) goto L_0x003a;
    L_0x0020:
        r11.d = r2;
        r13 = com.igexin.push.core.a.f.a();
        r14 = "url is invalid";
        r13.b(r14);
        r13 = new java.lang.StringBuilder;
        r14 = "HttpExtensionDownload|downLoad ext url is invalid, url = ";
        r13.<init>(r14);
    L_0x0032:
        r13.append(r12);
        r12 = r13.toString();
        goto L_0x0015;
    L_0x003a:
        r0 = "http://";
        r0 = r12.startsWith(r0);
        if (r0 != 0) goto L_0x006e;
    L_0x0042:
        r0 = "https://";
        r0 = r12.startsWith(r0);
        if (r0 != 0) goto L_0x006e;
    L_0x004a:
        r11.d = r2;
        r13 = com.igexin.push.core.a.f.a();
        r14 = new java.lang.StringBuilder;
        r0 = "httpUrl : ";
        r14.<init>(r0);
        r14.append(r12);
        r0 = " is invalid ...";
        r14.append(r0);
        r14 = r14.toString();
        r13.b(r14);
        r13 = new java.lang.StringBuilder;
        r14 = "HttpExtensionDownload|downLoad ext url is invalid url = ";
        r13.<init>(r14);
        goto L_0x0032;
    L_0x006e:
        r0 = 10;
        android.os.Process.setThreadPriority(r0);
        r0 = 1;
        r3 = 0;
        r4 = new java.net.URL;	 Catch:{ IllegalArgumentException -> 0x0228, Exception -> 0x01fb, all -> 0x01f6 }
        r4.<init>(r12);	 Catch:{ IllegalArgumentException -> 0x0228, Exception -> 0x01fb, all -> 0x01f6 }
        r12 = r4.openConnection();	 Catch:{ IllegalArgumentException -> 0x0228, Exception -> 0x01fb, all -> 0x01f6 }
        r12 = (java.net.HttpURLConnection) r12;	 Catch:{ IllegalArgumentException -> 0x0228, Exception -> 0x01fb, all -> 0x01f6 }
        r4 = r12.getResponseCode();	 Catch:{ IllegalArgumentException -> 0x01f3, Exception -> 0x01f0, all -> 0x01ed }
        r5 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ IllegalArgumentException -> 0x01f3, Exception -> 0x01f0, all -> 0x01ed }
        if (r4 == r5) goto L_0x0093;	 Catch:{ IllegalArgumentException -> 0x01f3, Exception -> 0x01f0, all -> 0x01ed }
    L_0x0088:
        r13 = r11.d;	 Catch:{ IllegalArgumentException -> 0x01f3, Exception -> 0x01f0, all -> 0x01ed }
        r13 = r13 + r0;	 Catch:{ IllegalArgumentException -> 0x01f3, Exception -> 0x01f0, all -> 0x01ed }
        r11.d = r13;	 Catch:{ IllegalArgumentException -> 0x01f3, Exception -> 0x01f0, all -> 0x01ed }
        if (r12 == 0) goto L_0x0092;
    L_0x008f:
        r12.disconnect();
    L_0x0092:
        return r1;
    L_0x0093:
        r4 = r12.getInputStream();	 Catch:{ IllegalArgumentException -> 0x01f3, Exception -> 0x01f0, all -> 0x01ed }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x01eb, Exception -> 0x01e9 }
        r5.<init>();	 Catch:{ IllegalArgumentException -> 0x01eb, Exception -> 0x01e9 }
        r6 = com.igexin.push.core.g.ac;	 Catch:{ IllegalArgumentException -> 0x01eb, Exception -> 0x01e9 }
        r5.append(r6);	 Catch:{ IllegalArgumentException -> 0x01eb, Exception -> 0x01e9 }
        r6 = "/";	 Catch:{ IllegalArgumentException -> 0x01eb, Exception -> 0x01e9 }
        r5.append(r6);	 Catch:{ IllegalArgumentException -> 0x01eb, Exception -> 0x01e9 }
        r5.append(r13);	 Catch:{ IllegalArgumentException -> 0x01eb, Exception -> 0x01e9 }
        r13 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x01eb, Exception -> 0x01e9 }
        r5 = new java.io.File;	 Catch:{ IllegalArgumentException -> 0x01eb, Exception -> 0x01e9 }
        r5.<init>(r13);	 Catch:{ IllegalArgumentException -> 0x01eb, Exception -> 0x01e9 }
        r6 = new java.io.FileOutputStream;	 Catch:{ IllegalArgumentException -> 0x01eb, Exception -> 0x01e9 }
        r6.<init>(r5);	 Catch:{ IllegalArgumentException -> 0x01eb, Exception -> 0x01e9 }
        r3 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r3 = new byte[r3];	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
    L_0x00bb:
        r7 = r4.read(r3);	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r8 = -1;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        if (r7 == r8) goto L_0x00c6;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
    L_0x00c2:
        r6.write(r3, r1, r7);	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        goto L_0x00bb;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
    L_0x00c6:
        r3 = r11.a;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r13 = com.igexin.b.b.a.a(r3, r13);	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r13 = r13.equals(r14);	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        if (r13 == 0) goto L_0x01af;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
    L_0x00d2:
        r13 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r13.<init>();	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r14 = com.igexin.push.core.g.ac;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r13.append(r14);	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r14 = "/";	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r13.append(r14);	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r14 = r11.b;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r14 = r14.c();	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r13.append(r14);	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r13 = r13.toString();	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r14 = new java.io.File;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r14.<init>(r13);	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r5.renameTo(r14);	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r13 = r11.b;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r13 = r13.g();	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        if (r13 != 0) goto L_0x018c;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
    L_0x00fe:
        r13 = r11.b;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r7 = r13.h();	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r9 = 0;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r13 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        if (r13 != 0) goto L_0x018c;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
    L_0x010a:
        r13 = new java.io.File;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r3 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r3.<init>();	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r5 = com.igexin.push.core.g.ab;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r3.append(r5);	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r5 = "/";	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r3.append(r5);	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r5 = r11.b;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r5 = r5.c();	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r3.append(r5);	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r3 = r3.toString();	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r13.<init>(r3);	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r3 = r13.exists();	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        if (r3 == 0) goto L_0x016b;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
    L_0x0131:
        r3 = com.igexin.push.core.g.f;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r5 = r13.getAbsolutePath();	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r3 = com.igexin.b.b.a.a(r3, r5);	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r5 = r11.b;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r5 = r5.f();	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r3 = r3.equals(r5);	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        if (r3 != 0) goto L_0x01a1;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
    L_0x0147:
        r13.delete();	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r3 = r11.b;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r3 = r3.f();	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        com.igexin.push.util.e.a(r14, r13, r3);	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r13 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r14 = "HttpExtensionDownload|downLoadFile success delete local tmp and copy ext name = ";	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r13.<init>(r14);	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r14 = r11.b;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r14 = r14.c();	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r13.append(r14);	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r13 = r13.toString();	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
    L_0x0167:
        com.igexin.b.a.c.a.b(r13);	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        goto L_0x01a1;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
    L_0x016b:
        r3 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r5 = "HttpExtensionDownload|downLoadFile success cope ext to local tmp name = ";	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r3.<init>(r5);	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r5 = r11.b;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r5 = r5.c();	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r3.append(r5);	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r3 = r3.toString();	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        com.igexin.b.a.c.a.b(r3);	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r3 = r11.b;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r3 = r3.f();	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        com.igexin.push.util.e.a(r14, r13, r3);	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        goto L_0x01a1;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
    L_0x018c:
        r13 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r14 = "HttpExtensionDownload|downLoadFile success do not copy ext to local tmp name = ";	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r13.<init>(r14);	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r14 = r11.b;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r14 = r14.c();	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r13.append(r14);	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r13 = r13.toString();	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        goto L_0x0167;
    L_0x01a1:
        r6.close();	 Catch:{ IOException -> 0x01a4 }
    L_0x01a4:
        if (r4 == 0) goto L_0x01a9;
    L_0x01a6:
        r4.close();	 Catch:{ IOException -> 0x01a9 }
    L_0x01a9:
        if (r12 == 0) goto L_0x01ae;
    L_0x01ab:
        r12.disconnect();
    L_0x01ae:
        return r0;
    L_0x01af:
        r13 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r14 = "HttpExtensionDownload|download ext failed CheckSum error name = ";	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r13.<init>(r14);	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r14 = r11.b;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r14 = r14.c();	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r13.append(r14);	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r13 = r13.toString();	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        com.igexin.b.a.c.a.b(r13);	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r13 = r5.exists();	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        if (r13 == 0) goto L_0x01cf;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
    L_0x01cc:
        r5.delete();	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
    L_0x01cf:
        r13 = 4;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r11.d = r13;	 Catch:{ IllegalArgumentException -> 0x01e6, Exception -> 0x01e3, all -> 0x01e0 }
        r6.close();	 Catch:{ IOException -> 0x01d5 }
    L_0x01d5:
        if (r4 == 0) goto L_0x01da;
    L_0x01d7:
        r4.close();	 Catch:{ IOException -> 0x01da }
    L_0x01da:
        if (r12 == 0) goto L_0x01df;
    L_0x01dc:
        r12.disconnect();
    L_0x01df:
        return r1;
    L_0x01e0:
        r13 = move-exception;
        goto L_0x025d;
    L_0x01e3:
        r13 = move-exception;
        r3 = r6;
        goto L_0x01fe;
    L_0x01e6:
        r13 = move-exception;
        r3 = r6;
        goto L_0x022b;
    L_0x01e9:
        r13 = move-exception;
        goto L_0x01fe;
    L_0x01eb:
        r13 = move-exception;
        goto L_0x022b;
    L_0x01ed:
        r13 = move-exception;
        r4 = r3;
        goto L_0x01f9;
    L_0x01f0:
        r13 = move-exception;
        r4 = r3;
        goto L_0x01fe;
    L_0x01f3:
        r13 = move-exception;
        r4 = r3;
        goto L_0x022b;
    L_0x01f6:
        r13 = move-exception;
        r12 = r3;
        r4 = r12;
    L_0x01f9:
        r6 = r4;
        goto L_0x025d;
    L_0x01fb:
        r13 = move-exception;
        r12 = r3;
        r4 = r12;
    L_0x01fe:
        r14 = r11.d;	 Catch:{ all -> 0x025b }
        r14 = r14 + r0;	 Catch:{ all -> 0x025b }
        r11.d = r14;	 Catch:{ all -> 0x025b }
        r14 = new java.lang.StringBuilder;	 Catch:{ all -> 0x025b }
        r0 = "HttpExtensionDownload|";	 Catch:{ all -> 0x025b }
        r14.<init>(r0);	 Catch:{ all -> 0x025b }
        r13 = r13.toString();	 Catch:{ all -> 0x025b }
        r14.append(r13);	 Catch:{ all -> 0x025b }
        r13 = r14.toString();	 Catch:{ all -> 0x025b }
        com.igexin.b.a.c.a.b(r13);	 Catch:{ all -> 0x025b }
        if (r3 == 0) goto L_0x021d;
    L_0x021a:
        r3.close();	 Catch:{ IOException -> 0x021d }
    L_0x021d:
        if (r4 == 0) goto L_0x0222;
    L_0x021f:
        r4.close();	 Catch:{ IOException -> 0x0222 }
    L_0x0222:
        if (r12 == 0) goto L_0x025a;
    L_0x0224:
        r12.disconnect();
        return r1;
    L_0x0228:
        r13 = move-exception;
        r12 = r3;
        r4 = r12;
    L_0x022b:
        r11.d = r2;	 Catch:{ all -> 0x025b }
        r14 = com.igexin.push.core.a.f.a();	 Catch:{ all -> 0x025b }
        r0 = r13.toString();	 Catch:{ all -> 0x025b }
        r14.b(r0);	 Catch:{ all -> 0x025b }
        r14 = new java.lang.StringBuilder;	 Catch:{ all -> 0x025b }
        r0 = "HttpExtensionDownload|";	 Catch:{ all -> 0x025b }
        r14.<init>(r0);	 Catch:{ all -> 0x025b }
        r13 = r13.toString();	 Catch:{ all -> 0x025b }
        r14.append(r13);	 Catch:{ all -> 0x025b }
        r13 = r14.toString();	 Catch:{ all -> 0x025b }
        com.igexin.b.a.c.a.b(r13);	 Catch:{ all -> 0x025b }
        if (r3 == 0) goto L_0x0252;
    L_0x024f:
        r3.close();	 Catch:{ IOException -> 0x0252 }
    L_0x0252:
        if (r4 == 0) goto L_0x0257;
    L_0x0254:
        r4.close();	 Catch:{ IOException -> 0x0257 }
    L_0x0257:
        if (r12 == 0) goto L_0x025a;
    L_0x0259:
        goto L_0x0224;
    L_0x025a:
        return r1;
    L_0x025b:
        r13 = move-exception;
        r6 = r3;
    L_0x025d:
        if (r6 == 0) goto L_0x0262;
    L_0x025f:
        r6.close();	 Catch:{ IOException -> 0x0262 }
    L_0x0262:
        if (r4 == 0) goto L_0x0267;
    L_0x0264:
        r4.close();	 Catch:{ IOException -> 0x0267 }
    L_0x0267:
        if (r12 == 0) goto L_0x026c;
    L_0x0269:
        r12.disconnect();
    L_0x026c:
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.c.h.a(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    public void run() {
        Intent intent;
        do {
            StringBuilder stringBuilder;
            try {
                StringBuilder stringBuilder2 = new StringBuilder("HttpExtensionDownload|downloading ");
                stringBuilder2.append(this.b.c());
                stringBuilder2.append(".tmp");
                a.b(stringBuilder2.toString());
                String e = this.b.e();
                stringBuilder = new StringBuilder();
                stringBuilder.append(this.b.c());
                stringBuilder.append(".tmp");
                if (a(e, stringBuilder.toString(), this.b.f())) {
                    stringBuilder2 = new StringBuilder("HttpExtensionDownload|download ");
                    stringBuilder2.append(this.b.c());
                    stringBuilder2.append(".tmp, success ########");
                    a.b(stringBuilder2.toString());
                    intent = new Intent(this.a, com.igexin.push.core.a.f.a().a(g.f));
                    intent.putExtra("action", "com.igexin.sdk.action.extdownloadsuccess");
                    intent.putExtra(AgooConstants.MESSAGE_ID, this.b.a());
                    intent.putExtra("result", true);
                    intent.putExtra("isReload", this.c);
                    this.a.startService(intent);
                    return;
                }
                stringBuilder2 = new StringBuilder("HttpExtensionDownload | download ext = ");
                stringBuilder2.append(this.b.c());
                stringBuilder2.append(", downloadFailedTimes = ");
                stringBuilder2.append(this.d);
                a.b(stringBuilder2.toString());
            } catch (Throwable th) {
                stringBuilder = new StringBuilder("HttpExtensionDownload|");
                stringBuilder.append(th.toString());
                a.b(stringBuilder.toString());
                return;
            }
        } while (this.d < 3);
        intent = new Intent(this.a, com.igexin.push.core.a.f.a().a(g.f));
        intent.putExtra("action", "com.igexin.sdk.action.extdownloadsuccess");
        intent.putExtra(AgooConstants.MESSAGE_ID, this.b.a());
        intent.putExtra("result", false);
        this.a.startService(intent);
    }
}
