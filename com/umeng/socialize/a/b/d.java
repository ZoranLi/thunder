package com.umeng.socialize.a.b;

/* compiled from: ImageFormat */
public class d {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 6;
    public static final int h = 7;
    public static final int i = 8;
    public static final int j = 9;
    public static final int k = 10;
    public static final int l = 11;
    public static final String[] m = new String[]{"jpeg", "gif", "png", "bmp", "pcx", "iff", "ras", "pbm", "pgm", "ppm", "psd", "swf"};

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(byte[] r10) {
        /*
        r0 = 0;
        r1 = new java.io.ByteArrayInputStream;	 Catch:{ Exception -> 0x020f }
        r1.<init>(r10);	 Catch:{ Exception -> 0x020f }
        r10 = r1.read();	 Catch:{ Exception -> 0x0209, all -> 0x0207 }
        r0 = r1.read();	 Catch:{ Exception -> 0x0209, all -> 0x0207 }
        r2 = 71;
        r3 = 1;
        if (r10 != r2) goto L_0x0039;
    L_0x0013:
        r2 = 73;
        if (r0 != r2) goto L_0x0039;
    L_0x0017:
        r10 = m;	 Catch:{ Exception -> 0x0209, all -> 0x0207 }
        r10 = r10[r3];	 Catch:{ Exception -> 0x0209, all -> 0x0207 }
        r1.close();	 Catch:{ IOException -> 0x001f }
        goto L_0x0038;
    L_0x001f:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = com.umeng.socialize.utils.UmengText.CHECK_FORMAT_ERROR;
        r1.append(r2);
        r0 = r0.getMessage();
        r1.append(r0);
        r0 = r1.toString();
        com.umeng.socialize.utils.Log.um(r0);
    L_0x0038:
        return r10;
    L_0x0039:
        r2 = 137; // 0x89 float:1.92E-43 double:6.77E-322;
        r4 = 80;
        if (r10 != r2) goto L_0x0064;
    L_0x003f:
        if (r0 != r4) goto L_0x0064;
    L_0x0041:
        r10 = m;	 Catch:{ Exception -> 0x0209, all -> 0x0207 }
        r0 = 2;
        r10 = r10[r0];	 Catch:{ Exception -> 0x0209, all -> 0x0207 }
        r1.close();	 Catch:{ IOException -> 0x004a }
        goto L_0x0063;
    L_0x004a:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = com.umeng.socialize.utils.UmengText.CHECK_FORMAT_ERROR;
        r1.append(r2);
        r0 = r0.getMessage();
        r1.append(r0);
        r0 = r1.toString();
        com.umeng.socialize.utils.Log.um(r0);
    L_0x0063:
        return r10;
    L_0x0064:
        r2 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        if (r10 != r2) goto L_0x008f;
    L_0x0068:
        r2 = 216; // 0xd8 float:3.03E-43 double:1.067E-321;
        if (r0 != r2) goto L_0x008f;
    L_0x006c:
        r10 = m;	 Catch:{ Exception -> 0x0209, all -> 0x0207 }
        r0 = 0;
        r10 = r10[r0];	 Catch:{ Exception -> 0x0209, all -> 0x0207 }
        r1.close();	 Catch:{ IOException -> 0x0075 }
        goto L_0x008e;
    L_0x0075:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = com.umeng.socialize.utils.UmengText.CHECK_FORMAT_ERROR;
        r1.append(r2);
        r0 = r0.getMessage();
        r1.append(r0);
        r0 = r1.toString();
        com.umeng.socialize.utils.Log.um(r0);
    L_0x008e:
        return r10;
    L_0x008f:
        r2 = 66;
        r5 = 3;
        if (r10 != r2) goto L_0x00ba;
    L_0x0094:
        r6 = 77;
        if (r0 != r6) goto L_0x00ba;
    L_0x0098:
        r10 = m;	 Catch:{ Exception -> 0x0209, all -> 0x0207 }
        r10 = r10[r5];	 Catch:{ Exception -> 0x0209, all -> 0x0207 }
        r1.close();	 Catch:{ IOException -> 0x00a0 }
        goto L_0x00b9;
    L_0x00a0:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = com.umeng.socialize.utils.UmengText.CHECK_FORMAT_ERROR;
        r1.append(r2);
        r0 = r0.getMessage();
        r1.append(r0);
        r0 = r1.toString();
        com.umeng.socialize.utils.Log.um(r0);
    L_0x00b9:
        return r10;
    L_0x00ba:
        r6 = 10;
        r7 = 6;
        if (r10 != r6) goto L_0x00e4;
    L_0x00bf:
        if (r0 >= r7) goto L_0x00e4;
    L_0x00c1:
        r10 = m;	 Catch:{ Exception -> 0x0209, all -> 0x0207 }
        r0 = 4;
        r10 = r10[r0];	 Catch:{ Exception -> 0x0209, all -> 0x0207 }
        r1.close();	 Catch:{ IOException -> 0x00ca }
        goto L_0x00e3;
    L_0x00ca:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = com.umeng.socialize.utils.UmengText.CHECK_FORMAT_ERROR;
        r1.append(r2);
        r0 = r0.getMessage();
        r1.append(r0);
        r0 = r1.toString();
        com.umeng.socialize.utils.Log.um(r0);
    L_0x00e3:
        return r10;
    L_0x00e4:
        r8 = 70;
        if (r10 != r8) goto L_0x010f;
    L_0x00e8:
        r9 = 79;
        if (r0 != r9) goto L_0x010f;
    L_0x00ec:
        r10 = m;	 Catch:{ Exception -> 0x0209, all -> 0x0207 }
        r0 = 5;
        r10 = r10[r0];	 Catch:{ Exception -> 0x0209, all -> 0x0207 }
        r1.close();	 Catch:{ IOException -> 0x00f5 }
        goto L_0x010e;
    L_0x00f5:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = com.umeng.socialize.utils.UmengText.CHECK_FORMAT_ERROR;
        r1.append(r2);
        r0 = r0.getMessage();
        r1.append(r0);
        r0 = r1.toString();
        com.umeng.socialize.utils.Log.um(r0);
    L_0x010e:
        return r10;
    L_0x010f:
        r9 = 89;
        if (r10 != r9) goto L_0x0139;
    L_0x0113:
        r9 = 166; // 0xa6 float:2.33E-43 double:8.2E-322;
        if (r0 != r9) goto L_0x0139;
    L_0x0117:
        r10 = m;	 Catch:{ Exception -> 0x0209, all -> 0x0207 }
        r10 = r10[r7];	 Catch:{ Exception -> 0x0209, all -> 0x0207 }
        r1.close();	 Catch:{ IOException -> 0x011f }
        goto L_0x0138;
    L_0x011f:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = com.umeng.socialize.utils.UmengText.CHECK_FORMAT_ERROR;
        r1.append(r2);
        r0 = r0.getMessage();
        r1.append(r0);
        r0 = r1.toString();
        com.umeng.socialize.utils.Log.um(r0);
    L_0x0138:
        return r10;
    L_0x0139:
        if (r10 != r4) goto L_0x0195;
    L_0x013b:
        r4 = 49;
        if (r0 < r4) goto L_0x0195;
    L_0x013f:
        r4 = 54;
        if (r0 > r4) goto L_0x0195;
    L_0x0143:
        r0 = r0 + -48;
        if (r0 <= 0) goto L_0x0175;
    L_0x0147:
        if (r0 <= r7) goto L_0x014a;
    L_0x0149:
        goto L_0x0175;
    L_0x014a:
        r10 = new int[r5];	 Catch:{ Exception -> 0x0209, all -> 0x0207 }
        r10 = {7, 8, 9};	 Catch:{ Exception -> 0x0209, all -> 0x0207 }
        r0 = r0 - r3;
        r0 = r0 % r5;
        r10 = r10[r0];	 Catch:{ Exception -> 0x0209, all -> 0x0207 }
        r0 = m;	 Catch:{ Exception -> 0x0209, all -> 0x0207 }
        r10 = r0[r10];	 Catch:{ Exception -> 0x0209, all -> 0x0207 }
        r1.close();	 Catch:{ IOException -> 0x015b }
        goto L_0x0174;
    L_0x015b:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = com.umeng.socialize.utils.UmengText.CHECK_FORMAT_ERROR;
        r1.append(r2);
        r0 = r0.getMessage();
        r1.append(r0);
        r0 = r1.toString();
        com.umeng.socialize.utils.Log.um(r0);
    L_0x0174:
        return r10;
    L_0x0175:
        r10 = "";
        r1.close();	 Catch:{ IOException -> 0x017b }
        goto L_0x0194;
    L_0x017b:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = com.umeng.socialize.utils.UmengText.CHECK_FORMAT_ERROR;
        r1.append(r2);
        r0 = r0.getMessage();
        r1.append(r0);
        r0 = r1.toString();
        com.umeng.socialize.utils.Log.um(r0);
    L_0x0194:
        return r10;
    L_0x0195:
        r3 = 56;
        if (r10 != r3) goto L_0x01bd;
    L_0x0199:
        if (r0 != r2) goto L_0x01bd;
    L_0x019b:
        r10 = m;	 Catch:{ Exception -> 0x0209, all -> 0x0207 }
        r10 = r10[r6];	 Catch:{ Exception -> 0x0209, all -> 0x0207 }
        r1.close();	 Catch:{ IOException -> 0x01a3 }
        goto L_0x01bc;
    L_0x01a3:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = com.umeng.socialize.utils.UmengText.CHECK_FORMAT_ERROR;
        r1.append(r2);
        r0 = r0.getMessage();
        r1.append(r0);
        r0 = r1.toString();
        com.umeng.socialize.utils.Log.um(r0);
    L_0x01bc:
        return r10;
    L_0x01bd:
        if (r10 != r8) goto L_0x01e7;
    L_0x01bf:
        r10 = 87;
        if (r0 != r10) goto L_0x01e7;
    L_0x01c3:
        r10 = m;	 Catch:{ Exception -> 0x0209, all -> 0x0207 }
        r0 = 11;
        r10 = r10[r0];	 Catch:{ Exception -> 0x0209, all -> 0x0207 }
        r1.close();	 Catch:{ IOException -> 0x01cd }
        goto L_0x01e6;
    L_0x01cd:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = com.umeng.socialize.utils.UmengText.CHECK_FORMAT_ERROR;
        r1.append(r2);
        r0 = r0.getMessage();
        r1.append(r0);
        r0 = r1.toString();
        com.umeng.socialize.utils.Log.um(r0);
    L_0x01e6:
        return r10;
    L_0x01e7:
        r10 = "";
        r1.close();	 Catch:{ IOException -> 0x01ed }
        goto L_0x0206;
    L_0x01ed:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = com.umeng.socialize.utils.UmengText.CHECK_FORMAT_ERROR;
        r1.append(r2);
        r0 = r0.getMessage();
        r1.append(r0);
        r0 = r1.toString();
        com.umeng.socialize.utils.Log.um(r0);
    L_0x0206:
        return r10;
    L_0x0207:
        r10 = move-exception;
        goto L_0x024a;
    L_0x0209:
        r10 = move-exception;
        r0 = r1;
        goto L_0x0210;
    L_0x020c:
        r10 = move-exception;
        r1 = r0;
        goto L_0x024a;
    L_0x020f:
        r10 = move-exception;
    L_0x0210:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x020c }
        r1.<init>();	 Catch:{ all -> 0x020c }
        r2 = com.umeng.socialize.utils.UmengText.CHECK_FORMAT_ERROR;	 Catch:{ all -> 0x020c }
        r1.append(r2);	 Catch:{ all -> 0x020c }
        r10 = r10.getMessage();	 Catch:{ all -> 0x020c }
        r1.append(r10);	 Catch:{ all -> 0x020c }
        r10 = r1.toString();	 Catch:{ all -> 0x020c }
        com.umeng.socialize.utils.Log.um(r10);	 Catch:{ all -> 0x020c }
        r10 = "";
        if (r0 == 0) goto L_0x0249;
    L_0x022c:
        r0.close();	 Catch:{ IOException -> 0x0230 }
        goto L_0x0249;
    L_0x0230:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = com.umeng.socialize.utils.UmengText.CHECK_FORMAT_ERROR;
        r1.append(r2);
        r0 = r0.getMessage();
        r1.append(r0);
        r0 = r1.toString();
        com.umeng.socialize.utils.Log.um(r0);
    L_0x0249:
        return r10;
    L_0x024a:
        if (r1 == 0) goto L_0x0269;
    L_0x024c:
        r1.close();	 Catch:{ IOException -> 0x0250 }
        goto L_0x0269;
    L_0x0250:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = com.umeng.socialize.utils.UmengText.CHECK_FORMAT_ERROR;
        r1.append(r2);
        r0 = r0.getMessage();
        r1.append(r0);
        r0 = r1.toString();
        com.umeng.socialize.utils.Log.um(r0);
    L_0x0269:
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.a.b.d.a(byte[]):java.lang.String");
    }
}
