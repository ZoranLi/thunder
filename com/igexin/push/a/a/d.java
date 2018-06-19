package com.igexin.push.a.a;

import com.igexin.b.a.b.c;

public class d implements com.igexin.push.f.b.d {
    private static final String a = "com.igexin.push.a.a.d";
    private long b = 0;
    private long c = 0;

    private void c() {
        c.b().a(new e(this), false, true);
    }

    public void a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r24 = this;
        r1 = r24;
        r2 = 1;
        r3 = 0;
        r5 = 0;
        r7 = com.igexin.push.core.g.l;	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
        r8 = 1800000; // 0x1b7740 float:2.522337E-39 double:8.89318E-318;	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
        if (r7 == 0) goto L_0x000f;	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
    L_0x000d:
        r10 = r8;	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
        goto L_0x0010;	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
    L_0x000f:
        r10 = r3;	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
    L_0x0010:
        r7 = com.igexin.push.core.g.h;	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
        if (r7 == 0) goto L_0x0016;	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
    L_0x0014:
        r12 = r8;	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
        goto L_0x0017;	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
    L_0x0016:
        r12 = r3;	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
    L_0x0017:
        r7 = new java.text.SimpleDateFormat;	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
        r14 = "yyyy-MM-dd";	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
        r15 = java.util.Locale.getDefault();	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
        r7.<init>(r14, r15);	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
        r14 = new java.util.Date;	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
        r14.<init>();	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
        r7 = r7.format(r14);	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
        r14 = com.igexin.push.core.f.a();	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
        r15 = r14.k();	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
        r16 = "bi";	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
        r14 = new java.lang.String[r2];	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
        r17 = "type";	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
        r14[r5] = r17;	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
        r6 = new java.lang.String[r2];	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
        r17 = "1";	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
        r6[r5] = r17;	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
        r19 = 0;	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
        r20 = 0;	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
        r17 = r14;	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
        r18 = r6;	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
        r6 = r15.a(r16, r17, r18, r19, r20);	 Catch:{ Exception -> 0x01ae, all -> 0x01a5 }
        if (r6 == 0) goto L_0x01a2;
    L_0x004f:
        r14 = r6.getCount();	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        if (r14 != 0) goto L_0x0098;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
    L_0x0055:
        r14 = new android.content.ContentValues;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r14.<init>();	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r15 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1));	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        if (r15 == 0) goto L_0x0067;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
    L_0x005e:
        r15 = "online_time";	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r10 = java.lang.Long.valueOf(r10);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r14.put(r15, r10);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
    L_0x0067:
        r10 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1));	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        if (r10 == 0) goto L_0x0074;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
    L_0x006b:
        r10 = "network_time";	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r11 = java.lang.Long.valueOf(r12);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r14.put(r10, r11);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
    L_0x0074:
        r10 = "running_time";	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r8 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r14.put(r10, r8);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r8 = "create_time";	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r14.put(r8, r7);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r7 = "type";	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r8 = "1";	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r14.put(r7, r8);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r7 = com.igexin.push.core.f.a();	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r7 = r7.k();	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r8 = "bi";	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r7.a(r8, r14);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        goto L_0x01a2;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
    L_0x0098:
        r14 = r6.moveToNext();	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        if (r14 == 0) goto L_0x01a2;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
    L_0x009e:
        r14 = "create_time";	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r14 = r6.getColumnIndexOrThrow(r14);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r14 = r6.getString(r14);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r15 = "id";	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r15 = r6.getColumnIndexOrThrow(r15);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r15 = r6.getString(r15);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r14 = r7.equals(r14);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        if (r14 == 0) goto L_0x0131;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
    L_0x00b8:
        r14 = new android.content.ContentValues;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r14.<init>();	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r16 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1));	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        if (r16 == 0) goto L_0x00db;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
    L_0x00c1:
        r5 = "online_time";	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r5 = r6.getColumnIndexOrThrow(r5);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r5 = r6.getInt(r5);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r2 = (long) r5;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r4 = r10 + r2;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r2 = "online_time";	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r3 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r14.put(r2, r3);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r10 = r4;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r2 = 0;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        goto L_0x00dc;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
    L_0x00db:
        r2 = r3;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
    L_0x00dc:
        r4 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1));	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        if (r4 == 0) goto L_0x00f7;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
    L_0x00e0:
        r2 = "network_time";	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r2 = r6.getColumnIndexOrThrow(r2);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r2 = r6.getInt(r2);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r2 = (long) r2;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r4 = r12 + r2;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r2 = "network_time";	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r3 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r14.put(r2, r3);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r12 = r4;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
    L_0x00f7:
        r2 = "running_time";	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r2 = r6.getColumnIndexOrThrow(r2);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r2 = r6.getInt(r2);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r2 = (long) r2;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r4 = r8 + r2;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r2 = "running_time";	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r3 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r14.put(r2, r3);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r2 = com.igexin.push.core.f.a();	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r2 = r2.k();	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r3 = "bi";	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r8 = 1;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r9 = new java.lang.String[r8];	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r16 = "id";	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r17 = 0;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r9[r17] = r16;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r21 = r4;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r4 = new java.lang.String[r8];	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r4[r17] = r15;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r2.a(r3, r14, r9, r4);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r8 = r21;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
    L_0x012b:
        r2 = 1;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r3 = 0;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r5 = 0;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        goto L_0x0098;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
    L_0x0131:
        r2 = new android.content.ContentValues;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r2.<init>();	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r3 = "type";	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r4 = "2";	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r3 = com.igexin.push.core.f.a();	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r3 = r3.k();	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r4 = "bi";	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r5 = 1;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r14 = new java.lang.String[r5];	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r16 = "id";	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r17 = 0;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r14[r17] = r16;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r1 = new java.lang.String[r5];	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r1[r17] = r15;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r3.a(r4, r2, r14, r1);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r1 = new android.content.ContentValues;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r1.<init>();	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r2 = 0;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r4 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1));	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        if (r4 == 0) goto L_0x016b;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
    L_0x0162:
        r2 = "online_time";	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r3 = java.lang.Long.valueOf(r10);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r1.put(r2, r3);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
    L_0x016b:
        r2 = 0;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r4 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1));	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        if (r4 == 0) goto L_0x017a;	 Catch:{ Exception -> 0x01af, all -> 0x019f }
    L_0x0171:
        r2 = "network_time";	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r3 = java.lang.Long.valueOf(r12);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r1.put(r2, r3);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
    L_0x017a:
        r2 = "running_time";	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r3 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r1.put(r2, r3);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r2 = "create_time";	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r1.put(r2, r7);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r2 = "type";	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r3 = "1";	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r1.put(r2, r3);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r2 = com.igexin.push.core.f.a();	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r2 = r2.k();	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r3 = "bi";	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r2.a(r3, r1);	 Catch:{ Exception -> 0x01af, all -> 0x019f }
        r1 = r24;
        goto L_0x012b;
    L_0x019f:
        r0 = move-exception;
        r1 = r0;
        goto L_0x01a8;
    L_0x01a2:
        if (r6 == 0) goto L_0x01b4;
    L_0x01a4:
        goto L_0x01b1;
    L_0x01a5:
        r0 = move-exception;
        r1 = r0;
        r6 = 0;
    L_0x01a8:
        if (r6 == 0) goto L_0x01ad;
    L_0x01aa:
        r6.close();
    L_0x01ad:
        throw r1;
    L_0x01ae:
        r6 = 0;
    L_0x01af:
        if (r6 == 0) goto L_0x01b4;
    L_0x01b1:
        r6.close();
    L_0x01b4:
        r1 = java.lang.System.currentTimeMillis();
        r3 = com.igexin.push.core.g.L;
        r5 = r1 - r3;
        r1 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r3 = r5 - r1;
        r1 = 0;
        r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1));
        if (r5 <= 0) goto L_0x01f0;
    L_0x01c7:
        r1 = com.igexin.push.core.a.f.a();
        r2 = 0;
        r1 = r1.a(r2, r2);
        r3 = android.text.TextUtils.isEmpty(r1);
        if (r3 != 0) goto L_0x01f0;
    L_0x01d6:
        r3 = new com.igexin.push.core.c.i;
        r4 = com.igexin.push.config.SDKUrlConfig.getBiUploadServiceUrl();
        r1 = r1.getBytes();
        r5 = 1;
        r3.<init>(r4, r1, r2, r5);
        r1 = com.igexin.b.a.b.c.b();
        r4 = new com.igexin.push.f.a.c;
        r4.<init>(r3);
        r1.a(r4, r2, r5);
    L_0x01f0:
        r1 = com.igexin.push.config.m.x;
        if (r1 == 0) goto L_0x020f;
    L_0x01f4:
        r1 = java.lang.System.currentTimeMillis();
        r3 = r24;
        r4 = r3.c;
        r6 = r1 - r4;
        r1 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        r4 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1));
        if (r4 < 0) goto L_0x0211;
    L_0x0205:
        r24.c();
        r1 = java.lang.System.currentTimeMillis();
        r3.c = r1;
        return;
    L_0x020f:
        r3 = r24;
    L_0x0211:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.a.a.d.a():void");
    }

    public void a(long j) {
        this.b = j;
    }

    public boolean b() {
        return System.currentTimeMillis() - this.b > 1800000;
    }
}
