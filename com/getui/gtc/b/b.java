package com.getui.gtc.b;

import com.getui.gtc.entity.a.a;
import com.getui.gtc.entity.d;
import java.io.File;

final class b extends com.getui.gtc.c.b {
    final /* synthetic */ a a;
    final /* synthetic */ File b;
    final /* synthetic */ d c;
    final /* synthetic */ a d;

    b(a aVar, a aVar2, File file, d dVar) {
        this.d = aVar;
        this.a = aVar2;
        this.b = file;
        this.c = dVar;
    }

    public final void a(int i) {
        super.a(i);
    }

    public final void a(byte[] r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        r0 = 0;
        r1 = 1;
        r2 = 0;
        r3 = new java.io.ByteArrayInputStream;	 Catch:{ IOException -> 0x0066, all -> 0x0045 }
        r3.<init>(r10);	 Catch:{ IOException -> 0x0066, all -> 0x0045 }
        r10 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x0067, all -> 0x0043 }
        r4 = r9.b;	 Catch:{ IOException -> 0x0067, all -> 0x0043 }
        r10.<init>(r4);	 Catch:{ IOException -> 0x0067, all -> 0x0043 }
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = new byte[r0];	 Catch:{ IOException -> 0x0041, all -> 0x003c }
    L_0x0013:
        r4 = r3.read(r0);	 Catch:{ IOException -> 0x0041, all -> 0x003c }
        r5 = -1;	 Catch:{ IOException -> 0x0041, all -> 0x003c }
        if (r4 == r5) goto L_0x001e;	 Catch:{ IOException -> 0x0041, all -> 0x003c }
    L_0x001a:
        r10.write(r0, r2, r4);	 Catch:{ IOException -> 0x0041, all -> 0x003c }
        goto L_0x0013;	 Catch:{ IOException -> 0x0041, all -> 0x003c }
    L_0x001e:
        r10.flush();	 Catch:{ IOException -> 0x0041, all -> 0x003c }
        r3.close();	 Catch:{ IOException -> 0x0025 }
        goto L_0x002e;
    L_0x0025:
        r0 = move-exception;
        r3 = new java.lang.String[r1];
        r0 = r0.toString();
        r3[r2] = r0;
    L_0x002e:
        r10.close();	 Catch:{ IOException -> 0x0032 }
        goto L_0x0085;
    L_0x0032:
        r10 = move-exception;
        r0 = new java.lang.String[r1];
        r10 = r10.toString();
        r0[r2] = r10;
        goto L_0x0085;
    L_0x003c:
        r0 = move-exception;
        r8 = r0;
        r0 = r10;
        r10 = r8;
        goto L_0x0047;
    L_0x0041:
        r0 = r10;
        goto L_0x0067;
    L_0x0043:
        r10 = move-exception;
        goto L_0x0047;
    L_0x0045:
        r10 = move-exception;
        r3 = r0;
    L_0x0047:
        if (r3 == 0) goto L_0x0056;
    L_0x0049:
        r3.close();	 Catch:{ IOException -> 0x004d }
        goto L_0x0056;
    L_0x004d:
        r3 = move-exception;
        r4 = new java.lang.String[r1];
        r3 = r3.toString();
        r4[r2] = r3;
    L_0x0056:
        if (r0 == 0) goto L_0x0065;
    L_0x0058:
        r0.close();	 Catch:{ IOException -> 0x005c }
        goto L_0x0065;
    L_0x005c:
        r0 = move-exception;
        r1 = new java.lang.String[r1];
        r0 = r0.toString();
        r1[r2] = r0;
    L_0x0065:
        throw r10;
    L_0x0066:
        r3 = r0;
    L_0x0067:
        if (r3 == 0) goto L_0x0076;
    L_0x0069:
        r3.close();	 Catch:{ IOException -> 0x006d }
        goto L_0x0076;
    L_0x006d:
        r10 = move-exception;
        r3 = new java.lang.String[r1];
        r10 = r10.toString();
        r3[r2] = r10;
    L_0x0076:
        if (r0 == 0) goto L_0x0085;
    L_0x0078:
        r0.close();	 Catch:{ IOException -> 0x007c }
        goto L_0x0085;
    L_0x007c:
        r10 = move-exception;
        r0 = new java.lang.String[r1];
        r10 = r10.toString();
        r0[r2] = r10;
    L_0x0085:
        r10 = r9.a;	 Catch:{ Exception -> 0x0125 }
        r10 = r10.e;	 Catch:{ Exception -> 0x0125 }
        r0 = r9.b;	 Catch:{ Exception -> 0x0125 }
        r0 = r0.getAbsolutePath();	 Catch:{ Exception -> 0x0125 }
        r0 = com.getui.gtc.e.j.b(r0);	 Catch:{ Exception -> 0x0125 }
        r0 = r0.equals(r10);	 Catch:{ Exception -> 0x0125 }
        if (r0 == 0) goto L_0x0124;	 Catch:{ Exception -> 0x0125 }
    L_0x0099:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0125 }
        r0.<init>();	 Catch:{ Exception -> 0x0125 }
        r3 = r9.d;	 Catch:{ Exception -> 0x0125 }
        r3 = r3.a;	 Catch:{ Exception -> 0x0125 }
        r0.append(r3);	 Catch:{ Exception -> 0x0125 }
        r3 = java.io.File.separator;	 Catch:{ Exception -> 0x0125 }
        r0.append(r3);	 Catch:{ Exception -> 0x0125 }
        r3 = r9.a;	 Catch:{ Exception -> 0x0125 }
        r3 = r3.c;	 Catch:{ Exception -> 0x0125 }
        r0.append(r3);	 Catch:{ Exception -> 0x0125 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0125 }
        r3 = new java.io.File;	 Catch:{ Exception -> 0x0125 }
        r3.<init>(r0);	 Catch:{ Exception -> 0x0125 }
        r0 = r9.b;	 Catch:{ Exception -> 0x0125 }
        r0 = r0.renameTo(r3);	 Catch:{ Exception -> 0x0125 }
        if (r0 == 0) goto L_0x0124;	 Catch:{ Exception -> 0x0125 }
    L_0x00c2:
        r0 = r9.a;	 Catch:{ Exception -> 0x0125 }
        r0 = r0.j;	 Catch:{ Exception -> 0x0125 }
        if (r0 != 0) goto L_0x010d;	 Catch:{ Exception -> 0x0125 }
    L_0x00c8:
        r0 = r9.a;	 Catch:{ Exception -> 0x0125 }
        r4 = r0.h;	 Catch:{ Exception -> 0x0125 }
        r6 = 0;	 Catch:{ Exception -> 0x0125 }
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));	 Catch:{ Exception -> 0x0125 }
        if (r0 != 0) goto L_0x010d;	 Catch:{ Exception -> 0x0125 }
    L_0x00d2:
        r0 = new java.io.File;	 Catch:{ Exception -> 0x0125 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0125 }
        r4.<init>();	 Catch:{ Exception -> 0x0125 }
        r5 = r9.d;	 Catch:{ Exception -> 0x0125 }
        r5 = r5.b;	 Catch:{ Exception -> 0x0125 }
        r4.append(r5);	 Catch:{ Exception -> 0x0125 }
        r5 = java.io.File.separator;	 Catch:{ Exception -> 0x0125 }
        r4.append(r5);	 Catch:{ Exception -> 0x0125 }
        r5 = r9.a;	 Catch:{ Exception -> 0x0125 }
        r5 = r5.c;	 Catch:{ Exception -> 0x0125 }
        r4.append(r5);	 Catch:{ Exception -> 0x0125 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0125 }
        r0.<init>(r4);	 Catch:{ Exception -> 0x0125 }
        r4 = r0.exists();	 Catch:{ Exception -> 0x0125 }
        if (r4 == 0) goto L_0x010a;	 Catch:{ Exception -> 0x0125 }
    L_0x00f9:
        r4 = r0.getAbsolutePath();	 Catch:{ Exception -> 0x0125 }
        r4 = com.getui.gtc.e.j.b(r4);	 Catch:{ Exception -> 0x0125 }
        r4 = r4.equals(r10);	 Catch:{ Exception -> 0x0125 }
        if (r4 != 0) goto L_0x010d;	 Catch:{ Exception -> 0x0125 }
    L_0x0107:
        com.getui.gtc.e.e.a(r0);	 Catch:{ Exception -> 0x0125 }
    L_0x010a:
        com.getui.gtc.e.e.a(r3, r0, r10);	 Catch:{ Exception -> 0x0125 }
    L_0x010d:
        r10 = r9.d;	 Catch:{ Exception -> 0x0125 }
        r10 = r10.c;	 Catch:{ Exception -> 0x0125 }
        if (r10 == 0) goto L_0x0124;	 Catch:{ Exception -> 0x0125 }
    L_0x0113:
        r10 = r9.d;	 Catch:{ Exception -> 0x0125 }
        r10 = r10.c;	 Catch:{ Exception -> 0x0125 }
        r0 = r9.c;	 Catch:{ Exception -> 0x0125 }
        r4 = r9.a;	 Catch:{ Exception -> 0x0125 }
        r4 = r4.a;	 Catch:{ Exception -> 0x0125 }
        r3 = r3.getAbsolutePath();	 Catch:{ Exception -> 0x0125 }
        r10.a(r0, r4, r3);	 Catch:{ Exception -> 0x0125 }
    L_0x0124:
        return;
    L_0x0125:
        r10 = move-exception;
        r0 = new java.lang.String[r1];
        r10 = r10.toString();
        r0[r2] = r10;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.b.b.a(byte[]):void");
    }
}
