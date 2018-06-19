package com.qihoo360.replugin.utils.b;

/* compiled from: PackageFilesUtil */
public final class a {
    public static java.io.InputStream a(android.content.Context r5, java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = b(r5, r6);
        r2 = c(r5, r6);
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        r0 = 0;
        if (r4 < 0) goto L_0x0027;
    L_0x000d:
        r1 = r5.openFileInput(r6);	 Catch:{ Exception -> 0x0016 }
        r0 = com.qihoo360.mobilesafe.a.a.a;	 Catch:{ Exception -> 0x0015 }
        r0 = r1;
        goto L_0x0027;
    L_0x0015:
        r0 = r1;
    L_0x0016:
        r1 = com.qihoo360.mobilesafe.a.a.a;
        if (r1 == 0) goto L_0x0027;
    L_0x001a:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1.append(r6);
        r2 = " in files directory not found, skip.";
        r1.append(r2);
    L_0x0027:
        if (r0 != 0) goto L_0x0038;
    L_0x0029:
        r5 = r5.getAssets();	 Catch:{ FileNotFoundException -> 0x0038, IOException -> 0x0036 }
        r5 = r5.open(r6);	 Catch:{ FileNotFoundException -> 0x0038, IOException -> 0x0036 }
        r6 = com.qihoo360.mobilesafe.a.a.a;	 Catch:{ FileNotFoundException -> 0x0033, IOException -> 0x0035 }
    L_0x0033:
        r0 = r5;
        goto L_0x0038;
    L_0x0035:
        r0 = r5;
    L_0x0036:
        r5 = com.qihoo360.mobilesafe.a.a.a;
    L_0x0038:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.replugin.utils.b.a.a(android.content.Context, java.lang.String):java.io.InputStream");
    }

    private static long b(android.content.Context r1, java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0016 }
        r0.<init>();	 Catch:{ Exception -> 0x0016 }
        r0.append(r2);	 Catch:{ Exception -> 0x0016 }
        r2 = ".timestamp";	 Catch:{ Exception -> 0x0016 }
        r0.append(r2);	 Catch:{ Exception -> 0x0016 }
        r2 = r0.toString();	 Catch:{ Exception -> 0x0016 }
        r1 = r1.openFileInput(r2);	 Catch:{ Exception -> 0x0016 }
        goto L_0x0017;
    L_0x0016:
        r1 = 0;
    L_0x0017:
        if (r1 == 0) goto L_0x001e;
    L_0x0019:
        r1 = a(r1);
        return r1;
    L_0x001e:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.replugin.utils.b.a.b(android.content.Context, java.lang.String):long");
    }

    private static long c(android.content.Context r1, java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = r1.getAssets();	 Catch:{ Exception -> 0x001a }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x001a }
        r0.<init>();	 Catch:{ Exception -> 0x001a }
        r0.append(r2);	 Catch:{ Exception -> 0x001a }
        r2 = ".timestamp";	 Catch:{ Exception -> 0x001a }
        r0.append(r2);	 Catch:{ Exception -> 0x001a }
        r2 = r0.toString();	 Catch:{ Exception -> 0x001a }
        r1 = r1.open(r2);	 Catch:{ Exception -> 0x001a }
        goto L_0x001b;
    L_0x001a:
        r1 = 0;
    L_0x001b:
        if (r1 == 0) goto L_0x0022;
    L_0x001d:
        r1 = a(r1);
        return r1;
    L_0x0022:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.replugin.utils.b.a.c(android.content.Context, java.lang.String):long");
    }

    private static long a(java.io.InputStream r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = new java.io.DataInputStream;	 Catch:{ Exception -> 0x002f }
        r1.<init>(r5);	 Catch:{ Exception -> 0x002f }
        r0 = r1.readLine();	 Catch:{ Exception -> 0x0028, all -> 0x0026 }
        r2 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x0028, all -> 0x0026 }
        if (r2 != 0) goto L_0x0020;	 Catch:{ Exception -> 0x0028, all -> 0x0026 }
    L_0x0010:
        r2 = java.lang.Long.parseLong(r0);	 Catch:{ Exception -> 0x0028, all -> 0x0026 }
        r1.close();	 Catch:{ Exception -> 0x001d }
        if (r5 == 0) goto L_0x001f;	 Catch:{ Exception -> 0x001d }
    L_0x0019:
        r5.close();	 Catch:{ Exception -> 0x001d }
        goto L_0x001f;
    L_0x001d:
        r5 = com.qihoo360.mobilesafe.a.a.a;
    L_0x001f:
        return r2;
    L_0x0020:
        r1.close();	 Catch:{ Exception -> 0x003c }
        if (r5 == 0) goto L_0x003e;
    L_0x0025:
        goto L_0x0038;
    L_0x0026:
        r0 = move-exception;
        goto L_0x0041;
    L_0x0028:
        r0 = r1;
        goto L_0x002f;
    L_0x002a:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x0041;
    L_0x002f:
        r1 = com.qihoo360.mobilesafe.a.a.a;	 Catch:{ all -> 0x002a }
        if (r0 == 0) goto L_0x0036;
    L_0x0033:
        r0.close();	 Catch:{ Exception -> 0x003c }
    L_0x0036:
        if (r5 == 0) goto L_0x003e;	 Catch:{ Exception -> 0x003c }
    L_0x0038:
        r5.close();	 Catch:{ Exception -> 0x003c }
        goto L_0x003e;
    L_0x003c:
        r5 = com.qihoo360.mobilesafe.a.a.a;
    L_0x003e:
        r0 = 0;
        return r0;
    L_0x0041:
        if (r1 == 0) goto L_0x0046;
    L_0x0043:
        r1.close();	 Catch:{ Exception -> 0x004c }
    L_0x0046:
        if (r5 == 0) goto L_0x004e;	 Catch:{ Exception -> 0x004c }
    L_0x0048:
        r5.close();	 Catch:{ Exception -> 0x004c }
        goto L_0x004e;
    L_0x004c:
        r5 = com.qihoo360.mobilesafe.a.a.a;
    L_0x004e:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.replugin.utils.b.a.a(java.io.InputStream):long");
    }
}
