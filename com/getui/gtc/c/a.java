package com.getui.gtc.c;

import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.getui.gtc.e.j;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

public final class a implements Runnable {
    public b a;
    private HttpURLConnection b;

    public a(b bVar) {
        this.a = bVar;
    }

    private void a() {
        if (this.b != null) {
            try {
                this.b.disconnect();
                this.b = null;
            } catch (Throwable th) {
                new String[1][0] = th.toString();
            }
        }
    }

    private byte[] a(java.util.Map r10) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:45:0x0102 in {5, 8, 11, 19, 28, 35, 36, 38, 44, 47, 49, 51, 53, 55, 58, 62, 65, 71, 73, 75, 77, 79, 81, 86, 92, 95, 98, 100, 102, 103, 104, 107, 113, 116, 119, 121, 123} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r9 = this;
        r0 = 1;
        r1 = 0;
        r2 = 0;
        r3 = new java.net.URL;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r4 = r9.a;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r4 = r4.e;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r3 = r3.openConnection();	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r3 = (java.net.HttpURLConnection) r3;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r9.b = r3;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r3 = r9.b;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r4 = r9.a;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r4 = r4.j;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r3.setConnectTimeout(r4);	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r3 = r9.b;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r4 = r9.a;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r4 = r4.k;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r3.setReadTimeout(r4);	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r3 = r9.b;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r4 = r9.a;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r4 = r4.m;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r3.setDoInput(r4);	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r3 = r9.b;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r4 = r9.a;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r4 = r4.l;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r3.setDoOutput(r4);	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r3 = r9.b;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r4 = "POST";	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r3.setRequestMethod(r4);	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r3 = r9.b;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r4 = r9.a;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r4 = r4.n;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r3.setUseCaches(r4);	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r3 = r9.b;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r4 = r9.a;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r4 = r4.o;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r3.setInstanceFollowRedirects(r4);	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r3 = r9.a;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r3 = r3.p;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r3 = r3.keySet();	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r3 = r3.iterator();	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
    L_0x005d:
        r4 = r3.hasNext();	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        if (r4 == 0) goto L_0x0079;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
    L_0x0063:
        r4 = r3.next();	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r4 = (java.lang.String) r4;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r5 = r9.b;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r6 = r9.a;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r6 = r6.p;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r6 = r6.get(r4);	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r6 = (java.lang.String) r6;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r5.setRequestProperty(r4, r6);	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        goto L_0x005d;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
    L_0x0079:
        r3 = r9.a;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r3 = r3.f;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r4 = r9.a;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r4 = r4.h;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        if (r4 == 0) goto L_0x0087;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
    L_0x0083:
        r3 = com.getui.gtc.e.j.a(r3);	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
    L_0x0087:
        if (r3 != 0) goto L_0x008d;
    L_0x0089:
        r9.a();
        return r1;
    L_0x008d:
        r4 = r9.b;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r4.connect();	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r4 = new java.io.DataOutputStream;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r5 = r9.b;	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r5 = r5.getOutputStream();	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r4.<init>(r5);	 Catch:{ Throwable -> 0x0159, all -> 0x0155 }
        r5 = r3.length;	 Catch:{ Throwable -> 0x0151, all -> 0x014d }
        r4.write(r3, r2, r5);	 Catch:{ Throwable -> 0x0151, all -> 0x014d }
        r4.flush();	 Catch:{ Throwable -> 0x0151, all -> 0x014d }
        r3 = r9.b;	 Catch:{ Throwable -> 0x0151, all -> 0x014d }
        r3 = r3.getResponseCode();	 Catch:{ Throwable -> 0x0151, all -> 0x014d }
        r5 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ Throwable -> 0x0151, all -> 0x014d }
        if (r3 != r5) goto L_0x0122;	 Catch:{ Throwable -> 0x0151, all -> 0x014d }
    L_0x00ae:
        r3 = r9.b;	 Catch:{ Throwable -> 0x0151, all -> 0x014d }
        r3 = r3.getHeaderFields();	 Catch:{ Throwable -> 0x0151, all -> 0x014d }
        if (r3 == 0) goto L_0x00bf;	 Catch:{ Throwable -> 0x0151, all -> 0x014d }
    L_0x00b6:
        r3 = r9.b;	 Catch:{ Throwable -> 0x0151, all -> 0x014d }
        r3 = r3.getHeaderFields();	 Catch:{ Throwable -> 0x0151, all -> 0x014d }
        r10.putAll(r3);	 Catch:{ Throwable -> 0x0151, all -> 0x014d }
    L_0x00bf:
        r10 = r9.b;	 Catch:{ Throwable -> 0x0151, all -> 0x014d }
        r10 = r10.getInputStream();	 Catch:{ Throwable -> 0x0151, all -> 0x014d }
        r3 = new java.io.ByteArrayOutputStream;	 Catch:{ Throwable -> 0x011c, all -> 0x0114 }
        r3.<init>();	 Catch:{ Throwable -> 0x011c, all -> 0x0114 }
        r5 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r5 = new byte[r5];	 Catch:{ Throwable -> 0x010d, all -> 0x0107 }
    L_0x00ce:
        r6 = r10.read(r5);	 Catch:{ Throwable -> 0x010d, all -> 0x0107 }
        r7 = -1;	 Catch:{ Throwable -> 0x010d, all -> 0x0107 }
        if (r6 == r7) goto L_0x00d9;	 Catch:{ Throwable -> 0x010d, all -> 0x0107 }
    L_0x00d5:
        r3.write(r5, r2, r6);	 Catch:{ Throwable -> 0x010d, all -> 0x0107 }
        goto L_0x00ce;	 Catch:{ Throwable -> 0x010d, all -> 0x0107 }
    L_0x00d9:
        r5 = r3.toByteArray();	 Catch:{ Throwable -> 0x010d, all -> 0x0107 }
        if (r5 == 0) goto L_0x012f;	 Catch:{ Throwable -> 0x010d, all -> 0x0107 }
    L_0x00df:
        r5 = r3.toByteArray();	 Catch:{ Throwable -> 0x010d, all -> 0x0107 }
        r5 = r9.a(r5);	 Catch:{ Throwable -> 0x010d, all -> 0x0107 }
        r4.close();	 Catch:{ Throwable -> 0x00f8 }
        if (r10 == 0) goto L_0x00ef;	 Catch:{ Throwable -> 0x00f8 }
    L_0x00ec:
        r10.close();	 Catch:{ Throwable -> 0x00f8 }
    L_0x00ef:
        r3.close();	 Catch:{ Throwable -> 0x00f8 }
    L_0x00f2:
        r9.a();
        return r5;
    L_0x00f6:
        r10 = move-exception;
        goto L_0x0103;
    L_0x00f8:
        r10 = move-exception;
        r0 = new java.lang.String[r0];	 Catch:{ all -> 0x00f6 }
        r10 = r10.toString();	 Catch:{ all -> 0x00f6 }
        r0[r2] = r10;	 Catch:{ all -> 0x00f6 }
        goto L_0x00f2;
        return r5;
    L_0x0103:
        r9.a();
        throw r10;
    L_0x0107:
        r1 = move-exception;
        r5 = r3;
        r3 = r10;
        r10 = r1;
        goto L_0x0191;
    L_0x010d:
        r5 = move-exception;
        r8 = r3;
        r3 = r10;
        r10 = r5;
        r5 = r8;
        goto L_0x015d;
    L_0x0114:
        r3 = move-exception;
        r5 = r1;
        r1 = r4;
        r8 = r3;
        r3 = r10;
        r10 = r8;
        goto L_0x0192;
    L_0x011c:
        r3 = move-exception;
        r5 = r1;
        r8 = r3;
        r3 = r10;
        r10 = r8;
        goto L_0x015d;
    L_0x0122:
        r10 = r9.a;	 Catch:{ Throwable -> 0x0151, all -> 0x014d }
        r3 = r9.b;	 Catch:{ Throwable -> 0x0151, all -> 0x014d }
        r3 = r3.getResponseCode();	 Catch:{ Throwable -> 0x0151, all -> 0x014d }
        r10.a(r3);	 Catch:{ Throwable -> 0x0151, all -> 0x014d }
        r10 = r1;
        r3 = r10;
    L_0x012f:
        r4.close();	 Catch:{ Throwable -> 0x013f }
        if (r10 == 0) goto L_0x0137;	 Catch:{ Throwable -> 0x013f }
    L_0x0134:
        r10.close();	 Catch:{ Throwable -> 0x013f }
    L_0x0137:
        if (r3 == 0) goto L_0x018c;	 Catch:{ Throwable -> 0x013f }
    L_0x0139:
        r3.close();	 Catch:{ Throwable -> 0x013f }
        goto L_0x018c;
    L_0x013d:
        r10 = move-exception;
        goto L_0x0149;
    L_0x013f:
        r10 = move-exception;
        r0 = new java.lang.String[r0];	 Catch:{ all -> 0x013d }
        r10 = r10.toString();	 Catch:{ all -> 0x013d }
        r0[r2] = r10;	 Catch:{ all -> 0x013d }
        goto L_0x018c;
    L_0x0149:
        r9.a();
        throw r10;
    L_0x014d:
        r10 = move-exception;
        r3 = r1;
        r5 = r3;
        goto L_0x0191;
    L_0x0151:
        r10 = move-exception;
        r3 = r1;
        r5 = r3;
        goto L_0x015d;
    L_0x0155:
        r10 = move-exception;
        r3 = r1;
        r5 = r3;
        goto L_0x0192;
    L_0x0159:
        r10 = move-exception;
        r3 = r1;
        r4 = r3;
        r5 = r4;
    L_0x015d:
        r6 = r9.a;	 Catch:{ all -> 0x0190 }
        r6.a(r10);	 Catch:{ all -> 0x0190 }
        r6 = new java.lang.String[r0];	 Catch:{ all -> 0x0190 }
        r10 = r10.toString();	 Catch:{ all -> 0x0190 }
        r6[r2] = r10;	 Catch:{ all -> 0x0190 }
        if (r4 == 0) goto L_0x0174;
    L_0x016c:
        r4.close();	 Catch:{ Throwable -> 0x0172 }
        goto L_0x0174;	 Catch:{ Throwable -> 0x0172 }
    L_0x0170:
        r10 = move-exception;	 Catch:{ Throwable -> 0x0172 }
        goto L_0x0188;	 Catch:{ Throwable -> 0x0172 }
    L_0x0172:
        r10 = move-exception;	 Catch:{ Throwable -> 0x0172 }
        goto L_0x017f;	 Catch:{ Throwable -> 0x0172 }
    L_0x0174:
        if (r3 == 0) goto L_0x0179;	 Catch:{ Throwable -> 0x0172 }
    L_0x0176:
        r3.close();	 Catch:{ Throwable -> 0x0172 }
    L_0x0179:
        if (r5 == 0) goto L_0x018c;	 Catch:{ Throwable -> 0x0172 }
    L_0x017b:
        r5.close();	 Catch:{ Throwable -> 0x0172 }
        goto L_0x018c;
    L_0x017f:
        r0 = new java.lang.String[r0];	 Catch:{ all -> 0x0170 }
        r10 = r10.toString();	 Catch:{ all -> 0x0170 }
        r0[r2] = r10;	 Catch:{ all -> 0x0170 }
        goto L_0x018c;
    L_0x0188:
        r9.a();
        throw r10;
    L_0x018c:
        r9.a();
        return r1;
    L_0x0190:
        r10 = move-exception;
    L_0x0191:
        r1 = r4;
    L_0x0192:
        if (r1 == 0) goto L_0x019c;
    L_0x0194:
        r1.close();	 Catch:{ Throwable -> 0x019a }
        goto L_0x019c;	 Catch:{ Throwable -> 0x019a }
    L_0x0198:
        r10 = move-exception;	 Catch:{ Throwable -> 0x019a }
        goto L_0x01b0;	 Catch:{ Throwable -> 0x019a }
    L_0x019a:
        r1 = move-exception;	 Catch:{ Throwable -> 0x019a }
        goto L_0x01a7;	 Catch:{ Throwable -> 0x019a }
    L_0x019c:
        if (r3 == 0) goto L_0x01a1;	 Catch:{ Throwable -> 0x019a }
    L_0x019e:
        r3.close();	 Catch:{ Throwable -> 0x019a }
    L_0x01a1:
        if (r5 == 0) goto L_0x01b4;	 Catch:{ Throwable -> 0x019a }
    L_0x01a3:
        r5.close();	 Catch:{ Throwable -> 0x019a }
        goto L_0x01b4;
    L_0x01a7:
        r0 = new java.lang.String[r0];	 Catch:{ all -> 0x0198 }
        r1 = r1.toString();	 Catch:{ all -> 0x0198 }
        r0[r2] = r1;	 Catch:{ all -> 0x0198 }
        goto L_0x01b4;
    L_0x01b0:
        r9.a();
        throw r10;
    L_0x01b4:
        r9.a();
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.c.a.a(java.util.Map):byte[]");
    }

    private byte[] a(byte[] bArr) {
        try {
            if (!this.a.g) {
                if (this.a.i) {
                    bArr = j.b(Base64.decode(bArr, 0));
                }
                return bArr;
            }
        } catch (Throwable th) {
            String[] strArr = new String[1];
            StringBuilder stringBuilder = new StringBuilder("Gin_AsyncHttpTask|error : ");
            stringBuilder.append(th.toString());
            strArr[0] = stringBuilder.toString();
        }
        return null;
    }

    private byte[] b(java.util.Map r8) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:35:0x00cd in {5, 14, 18, 24, 29, 31, 34, 37, 39, 42, 48, 51, 53, 55, 57, 59, 61, 63, 68, 75, 78, 80, 82, 83, 84, 87, 94, 97, 99, 101} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r7 = this;
        r0 = 0;
        r1 = 1;
        r2 = 0;
        r3 = new java.net.URL;	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r4 = r7.a;	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r4 = r4.e;	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r3 = r3.openConnection();	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r3 = (java.net.HttpURLConnection) r3;	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r7.b = r3;	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r3 = r7.b;	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r4 = r7.a;	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r4 = r4.j;	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r3.setConnectTimeout(r4);	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r3 = r7.b;	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r4 = r7.a;	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r4 = r4.k;	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r3.setReadTimeout(r4);	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r3 = r7.b;	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r4 = r7.a;	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r4 = r4.m;	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r3.setDoInput(r4);	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r3 = r7.b;	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r4 = "GET";	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r3.setRequestMethod(r4);	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r3 = r7.b;	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r4 = r7.a;	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r4 = r4.n;	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r3.setUseCaches(r4);	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r3 = r7.b;	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r4 = r7.a;	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r4 = r4.o;	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r3.setInstanceFollowRedirects(r4);	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r3 = r7.a;	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r3 = r3.p;	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r3 = r3.keySet();	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r3 = r3.iterator();	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
    L_0x0054:
        r4 = r3.hasNext();	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        if (r4 == 0) goto L_0x0070;	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
    L_0x005a:
        r4 = r3.next();	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r4 = (java.lang.String) r4;	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r5 = r7.b;	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r6 = r7.a;	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r6 = r6.p;	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r6 = r6.get(r4);	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r6 = (java.lang.String) r6;	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r5.setRequestProperty(r4, r6);	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        goto L_0x0054;	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
    L_0x0070:
        r3 = r7.b;	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r3 = r3.getInputStream();	 Catch:{ Throwable -> 0x0103, all -> 0x0100 }
        r4 = new java.io.ByteArrayOutputStream;	 Catch:{ Throwable -> 0x00fd, all -> 0x00fa }
        r4.<init>();	 Catch:{ Throwable -> 0x00fd, all -> 0x00fa }
        r5 = r7.b;	 Catch:{ Throwable -> 0x00f8 }
        r5 = r5.getResponseCode();	 Catch:{ Throwable -> 0x00f8 }
        r6 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ Throwable -> 0x00f8 }
        if (r5 != r6) goto L_0x00d2;	 Catch:{ Throwable -> 0x00f8 }
    L_0x0085:
        r5 = r7.b;	 Catch:{ Throwable -> 0x00f8 }
        r5 = r5.getHeaderFields();	 Catch:{ Throwable -> 0x00f8 }
        if (r5 == 0) goto L_0x0096;	 Catch:{ Throwable -> 0x00f8 }
    L_0x008d:
        r5 = r7.b;	 Catch:{ Throwable -> 0x00f8 }
        r5 = r5.getHeaderFields();	 Catch:{ Throwable -> 0x00f8 }
        r8.putAll(r5);	 Catch:{ Throwable -> 0x00f8 }
    L_0x0096:
        r8 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;	 Catch:{ Throwable -> 0x00f8 }
        r8 = new byte[r8];	 Catch:{ Throwable -> 0x00f8 }
    L_0x009a:
        r5 = r3.read(r8);	 Catch:{ Throwable -> 0x00f8 }
        r6 = -1;	 Catch:{ Throwable -> 0x00f8 }
        if (r5 == r6) goto L_0x00a5;	 Catch:{ Throwable -> 0x00f8 }
    L_0x00a1:
        r4.write(r8, r2, r5);	 Catch:{ Throwable -> 0x00f8 }
        goto L_0x009a;	 Catch:{ Throwable -> 0x00f8 }
    L_0x00a5:
        r8 = r4.toByteArray();	 Catch:{ Throwable -> 0x00f8 }
        if (r8 == 0) goto L_0x00dd;	 Catch:{ Throwable -> 0x00f8 }
    L_0x00ab:
        r8 = r4.toByteArray();	 Catch:{ Throwable -> 0x00f8 }
        r8 = r7.a(r8);	 Catch:{ Throwable -> 0x00f8 }
        if (r3 == 0) goto L_0x00bd;
    L_0x00b5:
        r3.close();	 Catch:{ Throwable -> 0x00bb }
        goto L_0x00bd;	 Catch:{ Throwable -> 0x00bb }
    L_0x00b9:
        r8 = move-exception;	 Catch:{ Throwable -> 0x00bb }
        goto L_0x00ce;	 Catch:{ Throwable -> 0x00bb }
    L_0x00bb:
        r0 = move-exception;	 Catch:{ Throwable -> 0x00bb }
        goto L_0x00c4;	 Catch:{ Throwable -> 0x00bb }
    L_0x00bd:
        r4.close();	 Catch:{ Throwable -> 0x00bb }
    L_0x00c0:
        r7.a();
        return r8;
    L_0x00c4:
        r1 = new java.lang.String[r1];	 Catch:{ all -> 0x00b9 }
        r0 = r0.toString();	 Catch:{ all -> 0x00b9 }
        r1[r2] = r0;	 Catch:{ all -> 0x00b9 }
        goto L_0x00c0;
        return r8;
    L_0x00ce:
        r7.a();
        throw r8;
    L_0x00d2:
        r8 = r7.a;	 Catch:{ Throwable -> 0x00f8 }
        r5 = r7.b;	 Catch:{ Throwable -> 0x00f8 }
        r5 = r5.getResponseCode();	 Catch:{ Throwable -> 0x00f8 }
        r8.a(r5);	 Catch:{ Throwable -> 0x00f8 }
    L_0x00dd:
        if (r3 == 0) goto L_0x00e7;
    L_0x00df:
        r3.close();	 Catch:{ Throwable -> 0x00e5 }
        goto L_0x00e7;	 Catch:{ Throwable -> 0x00e5 }
    L_0x00e3:
        r8 = move-exception;	 Catch:{ Throwable -> 0x00e5 }
        goto L_0x00f4;	 Catch:{ Throwable -> 0x00e5 }
    L_0x00e5:
        r8 = move-exception;	 Catch:{ Throwable -> 0x00e5 }
        goto L_0x00eb;	 Catch:{ Throwable -> 0x00e5 }
    L_0x00e7:
        r4.close();	 Catch:{ Throwable -> 0x00e5 }
        goto L_0x0130;
    L_0x00eb:
        r1 = new java.lang.String[r1];	 Catch:{ all -> 0x00e3 }
        r8 = r8.toString();	 Catch:{ all -> 0x00e3 }
        r1[r2] = r8;	 Catch:{ all -> 0x00e3 }
        goto L_0x0130;
    L_0x00f4:
        r7.a();
        throw r8;
    L_0x00f8:
        r8 = move-exception;
        goto L_0x0106;
    L_0x00fa:
        r8 = move-exception;
        r4 = r0;
        goto L_0x0135;
    L_0x00fd:
        r8 = move-exception;
        r4 = r0;
        goto L_0x0106;
    L_0x0100:
        r8 = move-exception;
        r4 = r0;
        goto L_0x0136;
    L_0x0103:
        r8 = move-exception;
        r3 = r0;
        r4 = r3;
    L_0x0106:
        r5 = r7.a;	 Catch:{ all -> 0x0134 }
        r5.a(r8);	 Catch:{ all -> 0x0134 }
        r5 = new java.lang.String[r1];	 Catch:{ all -> 0x0134 }
        r8 = r8.toString();	 Catch:{ all -> 0x0134 }
        r5[r2] = r8;	 Catch:{ all -> 0x0134 }
        if (r3 == 0) goto L_0x011d;
    L_0x0115:
        r3.close();	 Catch:{ Throwable -> 0x011b }
        goto L_0x011d;	 Catch:{ Throwable -> 0x011b }
    L_0x0119:
        r8 = move-exception;	 Catch:{ Throwable -> 0x011b }
        goto L_0x012c;	 Catch:{ Throwable -> 0x011b }
    L_0x011b:
        r8 = move-exception;	 Catch:{ Throwable -> 0x011b }
        goto L_0x0123;	 Catch:{ Throwable -> 0x011b }
    L_0x011d:
        if (r4 == 0) goto L_0x0130;	 Catch:{ Throwable -> 0x011b }
    L_0x011f:
        r4.close();	 Catch:{ Throwable -> 0x011b }
        goto L_0x0130;
    L_0x0123:
        r1 = new java.lang.String[r1];	 Catch:{ all -> 0x0119 }
        r8 = r8.toString();	 Catch:{ all -> 0x0119 }
        r1[r2] = r8;	 Catch:{ all -> 0x0119 }
        goto L_0x0130;
    L_0x012c:
        r7.a();
        throw r8;
    L_0x0130:
        r7.a();
        return r0;
    L_0x0134:
        r8 = move-exception;
    L_0x0135:
        r0 = r3;
    L_0x0136:
        if (r0 == 0) goto L_0x0140;
    L_0x0138:
        r0.close();	 Catch:{ Throwable -> 0x013e }
        goto L_0x0140;	 Catch:{ Throwable -> 0x013e }
    L_0x013c:
        r8 = move-exception;	 Catch:{ Throwable -> 0x013e }
        goto L_0x014f;	 Catch:{ Throwable -> 0x013e }
    L_0x013e:
        r0 = move-exception;	 Catch:{ Throwable -> 0x013e }
        goto L_0x0146;	 Catch:{ Throwable -> 0x013e }
    L_0x0140:
        if (r4 == 0) goto L_0x0153;	 Catch:{ Throwable -> 0x013e }
    L_0x0142:
        r4.close();	 Catch:{ Throwable -> 0x013e }
        goto L_0x0153;
    L_0x0146:
        r1 = new java.lang.String[r1];	 Catch:{ all -> 0x013c }
        r0 = r0.toString();	 Catch:{ all -> 0x013c }
        r1[r2] = r0;	 Catch:{ all -> 0x013c }
        goto L_0x0153;
    L_0x014f:
        r7.a();
        throw r8;
    L_0x0153:
        r7.a();
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.c.a.b(java.util.Map):byte[]");
    }

    public final void run() {
        try {
            Process.setThreadPriority(10);
            if (this.a != null && !TextUtils.isEmpty(this.a.e)) {
                String[] strArr = new String[1];
                StringBuilder stringBuilder = new StringBuilder("Gin_AsyncHttpTask|-----------");
                stringBuilder.append(this.a.e);
                stringBuilder.append("-----------");
                strArr[0] = stringBuilder.toString();
                Map hashMap = new HashMap();
                byte[] b = this.a.f == null ? b(hashMap) : a(hashMap);
                if (b != null) {
                    this.a.a(b);
                }
            }
        } catch (Throwable th) {
            new String[1][0] = th.toString();
        }
    }
}
