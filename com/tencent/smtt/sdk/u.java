package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.k;
import java.io.File;

public class u {
    public static final String a = CookieManager.LOGTAG;
    static File b;

    public static File a(Context context) {
        if (b == null && context != null) {
            b = new File(context.getDir("webview", 0), "Cookies");
        }
        if (b == null) {
            StringBuilder stringBuilder = new StringBuilder("/data/data/");
            stringBuilder.append(context.getPackageName());
            stringBuilder.append(File.separator);
            stringBuilder.append("app_webview");
            stringBuilder.append(File.separator);
            stringBuilder.append("Cookies");
            b = new File(stringBuilder.toString());
        }
        return b;
    }

    private static java.lang.String a(android.database.sqlite.SQLiteDatabase r4, java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.lang.StringBuilder;
        r1 = "select * from ";
        r0.<init>(r1);
        r0.append(r5);
        r5 = r0.toString();
        r0 = 0;
        r4 = r4.rawQuery(r5, r0);
        r5 = r4.getCount();
        r0 = r4.getColumnCount();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = new java.lang.StringBuilder;
        r3 = "raws:";
        r2.<init>(r3);
        r2.append(r5);
        r3 = ",columns:";
        r2.append(r3);
        r2.append(r0);
        r3 = "\n";
        r2.append(r3);
        r2 = r2.toString();
        r1.append(r2);
        if (r5 <= 0) goto L_0x0068;
    L_0x0040:
        r5 = r4.moveToFirst();
        if (r5 == 0) goto L_0x0068;
    L_0x0046:
        r5 = "\n";
        r1.append(r5);
        r5 = 0;
    L_0x004c:
        if (r5 >= r0) goto L_0x005d;
    L_0x004e:
        r2 = r4.getString(r5);	 Catch:{ Exception -> 0x005a }
        r1.append(r2);
        r2 = ",";
        r1.append(r2);
    L_0x005a:
        r5 = r5 + 1;
        goto L_0x004c;
    L_0x005d:
        r5 = "\n";
        r1.append(r5);
        r5 = r4.moveToNext();
        if (r5 != 0) goto L_0x0046;
    L_0x0068:
        r4 = r1.toString();
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.u.a(android.database.sqlite.SQLiteDatabase, java.lang.String):java.lang.String");
    }

    public static java.util.ArrayList<java.lang.String> a(android.database.sqlite.SQLiteDatabase r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r4 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = "select * from sqlite_master where type='table'";
        r2 = r4.rawQuery(r2, r0);	 Catch:{ Throwable -> 0x0050, all -> 0x003c }
        r0 = r2.moveToFirst();	 Catch:{ Throwable -> 0x003a, all -> 0x0038 }
        if (r0 == 0) goto L_0x002a;	 Catch:{ Throwable -> 0x003a, all -> 0x0038 }
    L_0x0015:
        r0 = 1;	 Catch:{ Throwable -> 0x003a, all -> 0x0038 }
        r0 = r2.getString(r0);	 Catch:{ Throwable -> 0x003a, all -> 0x0038 }
        r3 = 4;	 Catch:{ Throwable -> 0x003a, all -> 0x0038 }
        r2.getString(r3);	 Catch:{ Throwable -> 0x003a, all -> 0x0038 }
        r1.add(r0);	 Catch:{ Throwable -> 0x003a, all -> 0x0038 }
        a(r4, r0);	 Catch:{ Throwable -> 0x003a, all -> 0x0038 }
        r0 = r2.moveToNext();	 Catch:{ Throwable -> 0x003a, all -> 0x0038 }
        if (r0 != 0) goto L_0x0015;
    L_0x002a:
        if (r2 == 0) goto L_0x002f;
    L_0x002c:
        r2.close();
    L_0x002f:
        if (r4 == 0) goto L_0x0060;
    L_0x0031:
        r0 = r4.isOpen();
        if (r0 == 0) goto L_0x0060;
    L_0x0037:
        goto L_0x005d;
    L_0x0038:
        r0 = move-exception;
        goto L_0x003f;
    L_0x003a:
        r0 = r2;
        goto L_0x0050;
    L_0x003c:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
    L_0x003f:
        if (r2 == 0) goto L_0x0044;
    L_0x0041:
        r2.close();
    L_0x0044:
        if (r4 == 0) goto L_0x004f;
    L_0x0046:
        r1 = r4.isOpen();
        if (r1 == 0) goto L_0x004f;
    L_0x004c:
        r4.close();
    L_0x004f:
        throw r0;
    L_0x0050:
        if (r0 == 0) goto L_0x0055;
    L_0x0052:
        r0.close();
    L_0x0055:
        if (r4 == 0) goto L_0x0060;
    L_0x0057:
        r0 = r4.isOpen();
        if (r0 == 0) goto L_0x0060;
    L_0x005d:
        r4.close();
    L_0x0060:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.u.a(android.database.sqlite.SQLiteDatabase):java.util.ArrayList<java.lang.String>");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r8, com.tencent.smtt.sdk.CookieManager.a r9, java.lang.String r10, boolean r11, boolean r12) {
        /*
        if (r8 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r12 = com.tencent.smtt.sdk.CookieManager.a.MODE_KEYS;
        if (r9 != r12) goto L_0x000e;
    L_0x0007:
        r12 = android.text.TextUtils.isEmpty(r10);
        if (r12 == 0) goto L_0x000e;
    L_0x000d:
        return;
    L_0x000e:
        r12 = ",";
        r10 = r10.split(r12);
        if (r10 == 0) goto L_0x0158;
    L_0x0016:
        r12 = r10.length;
        if (r12 > 0) goto L_0x001a;
    L_0x0019:
        return;
    L_0x001a:
        r12 = c(r8);
        if (r12 != 0) goto L_0x0021;
    L_0x0020:
        return;
    L_0x0021:
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = 0;
        r2 = 1;
        r3 = "select * from cookies";
        r3 = r12.rawQuery(r3, r1);	 Catch:{ Throwable -> 0x00cc }
        r1 = r3.getCount();	 Catch:{ Throwable -> 0x00c5, all -> 0x00c2 }
        if (r1 <= 0) goto L_0x00b1;
    L_0x0034:
        r1 = r3.moveToFirst();	 Catch:{ Throwable -> 0x00c5, all -> 0x00c2 }
        if (r1 == 0) goto L_0x00b1;
    L_0x003a:
        r1 = "host_key";
        r1 = r3.getColumnIndex(r1);	 Catch:{ Throwable -> 0x00c5, all -> 0x00c2 }
        r1 = r3.getString(r1);	 Catch:{ Throwable -> 0x00c5, all -> 0x00c2 }
        r4 = com.tencent.smtt.sdk.CookieManager.a.MODE_KEYS;	 Catch:{ Throwable -> 0x00c5, all -> 0x00c2 }
        if (r9 != r4) goto L_0x005c;
    L_0x0048:
        r4 = r10.length;	 Catch:{ Throwable -> 0x00c5, all -> 0x00c2 }
        r5 = 0;
        r6 = r5;
    L_0x004b:
        if (r6 >= r4) goto L_0x005a;
    L_0x004d:
        r7 = r10[r6];	 Catch:{ Throwable -> 0x00c5, all -> 0x00c2 }
        r7 = r1.equals(r7);	 Catch:{ Throwable -> 0x00c5, all -> 0x00c2 }
        if (r7 == 0) goto L_0x0057;
    L_0x0055:
        r5 = r2;
        goto L_0x005a;
    L_0x0057:
        r6 = r6 + 1;
        goto L_0x004b;
    L_0x005a:
        if (r5 == 0) goto L_0x00ab;
    L_0x005c:
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00c5, all -> 0x00c2 }
        r4.<init>();	 Catch:{ Throwable -> 0x00c5, all -> 0x00c2 }
        r5 = "value";
        r5 = r3.getColumnIndex(r5);	 Catch:{ Throwable -> 0x00c5, all -> 0x00c2 }
        r5 = r3.getString(r5);	 Catch:{ Throwable -> 0x00c5, all -> 0x00c2 }
        r4.append(r5);	 Catch:{ Throwable -> 0x00c5, all -> 0x00c2 }
        r5 = ";";
        r4.append(r5);	 Catch:{ Throwable -> 0x00c5, all -> 0x00c2 }
        r5 = "name";
        r5 = r3.getColumnIndex(r5);	 Catch:{ Throwable -> 0x00c5, all -> 0x00c2 }
        r5 = r3.getString(r5);	 Catch:{ Throwable -> 0x00c5, all -> 0x00c2 }
        r4.append(r5);	 Catch:{ Throwable -> 0x00c5, all -> 0x00c2 }
        r5 = ";";
        r4.append(r5);	 Catch:{ Throwable -> 0x00c5, all -> 0x00c2 }
        r5 = "expires_utc";
        r5 = r3.getColumnIndex(r5);	 Catch:{ Throwable -> 0x00c5, all -> 0x00c2 }
        r5 = r3.getInt(r5);	 Catch:{ Throwable -> 0x00c5, all -> 0x00c2 }
        r4.append(r5);	 Catch:{ Throwable -> 0x00c5, all -> 0x00c2 }
        r5 = ";";
        r4.append(r5);	 Catch:{ Throwable -> 0x00c5, all -> 0x00c2 }
        r5 = "priority";
        r5 = r3.getColumnIndex(r5);	 Catch:{ Throwable -> 0x00c5, all -> 0x00c2 }
        r5 = r3.getInt(r5);	 Catch:{ Throwable -> 0x00c5, all -> 0x00c2 }
        r4.append(r5);	 Catch:{ Throwable -> 0x00c5, all -> 0x00c2 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x00c5, all -> 0x00c2 }
        r0.put(r1, r4);	 Catch:{ Throwable -> 0x00c5, all -> 0x00c2 }
    L_0x00ab:
        r1 = r3.moveToNext();	 Catch:{ Throwable -> 0x00c5, all -> 0x00c2 }
        if (r1 != 0) goto L_0x003a;
    L_0x00b1:
        if (r3 == 0) goto L_0x00b6;
    L_0x00b3:
        r3.close();
    L_0x00b6:
        if (r12 == 0) goto L_0x00e9;
    L_0x00b8:
        r9 = r12.isOpen();
        if (r9 == 0) goto L_0x00e9;
    L_0x00be:
        r12.close();
        goto L_0x00e9;
    L_0x00c2:
        r8 = move-exception;
        goto L_0x0147;
    L_0x00c5:
        r9 = move-exception;
        r1 = r3;
        goto L_0x00cd;
    L_0x00c8:
        r8 = move-exception;
        r3 = r1;
        goto L_0x0147;
    L_0x00cc:
        r9 = move-exception;
    L_0x00cd:
        r10 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c8 }
        r3 = "getCookieDBVersion exception:";
        r10.<init>(r3);	 Catch:{ all -> 0x00c8 }
        r9 = r9.toString();	 Catch:{ all -> 0x00c8 }
        r10.append(r9);	 Catch:{ all -> 0x00c8 }
        if (r1 == 0) goto L_0x00e0;
    L_0x00dd:
        r1.close();
    L_0x00e0:
        if (r12 == 0) goto L_0x00e9;
    L_0x00e2:
        r9 = r12.isOpen();
        if (r9 == 0) goto L_0x00e9;
    L_0x00e8:
        goto L_0x00be;
    L_0x00e9:
        r9 = r0.isEmpty();
        if (r9 == 0) goto L_0x00f0;
    L_0x00ef:
        return;
    L_0x00f0:
        b(r8);
        r9 = r0.entrySet();
        r9 = r9.iterator();
    L_0x00fb:
        r10 = r9.hasNext();
        if (r10 == 0) goto L_0x011b;
    L_0x0101:
        r10 = r9.next();
        r10 = (java.util.Map.Entry) r10;
        r12 = r10.getKey();
        r12 = (java.lang.String) r12;
        r10 = r10.getValue();
        r10 = (java.lang.String) r10;
        r0 = com.tencent.smtt.sdk.CookieManager.getInstance();
        r0.setCookie(r12, r10, r2);
        goto L_0x00fb;
    L_0x011b:
        r9 = android.os.Build.VERSION.SDK_INT;
        r10 = 21;
        if (r9 < r10) goto L_0x0129;
    L_0x0121:
        r9 = com.tencent.smtt.sdk.CookieManager.getInstance();
        r9.flush();
        goto L_0x0130;
    L_0x0129:
        r9 = com.tencent.smtt.sdk.CookieSyncManager.getInstance();
        r9.sync();
    L_0x0130:
        if (r11 == 0) goto L_0x0146;
    L_0x0132:
        r9 = c(r8);
        a(r9);
        r9 = d(r8);
        r10 = -1;
        if (r9 == r10) goto L_0x0146;
    L_0x0140:
        com.tencent.smtt.sdk.CookieManager.getInstance();
        com.tencent.smtt.sdk.CookieManager.setROMCookieDBVersion(r8, r9);
    L_0x0146:
        return;
    L_0x0147:
        if (r3 == 0) goto L_0x014c;
    L_0x0149:
        r3.close();
    L_0x014c:
        if (r12 == 0) goto L_0x0157;
    L_0x014e:
        r9 = r12.isOpen();
        if (r9 == 0) goto L_0x0157;
    L_0x0154:
        r12.close();
    L_0x0157:
        throw r8;
    L_0x0158:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.u.a(android.content.Context, com.tencent.smtt.sdk.CookieManager$a, java.lang.String, boolean, boolean):void");
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        k.a(a(context), false);
        return true;
    }

    public static android.database.sqlite.SQLiteDatabase c(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r2 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r2 = a(r2);
        if (r2 != 0) goto L_0x000b;
    L_0x000a:
        return r0;
    L_0x000b:
        r2 = r2.getAbsolutePath();	 Catch:{ Exception -> 0x0015 }
        r1 = 0;	 Catch:{ Exception -> 0x0015 }
        r2 = android.database.sqlite.SQLiteDatabase.openDatabase(r2, r0, r1);	 Catch:{ Exception -> 0x0015 }
        goto L_0x0016;
    L_0x0015:
        r2 = r0;
    L_0x0016:
        if (r2 != 0) goto L_0x001f;
    L_0x0018:
        r0 = a;
        r1 = "dbPath is not exist!";
        com.tencent.smtt.utils.TbsLog.i(r0, r1);
    L_0x001f:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.u.c(android.content.Context):android.database.sqlite.SQLiteDatabase");
    }

    public static int d(android.content.Context r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        java.lang.System.currentTimeMillis();
        r0 = 0;
        r1 = 0;
        r4 = c(r4);	 Catch:{ Throwable -> 0x0076, all -> 0x0062 }
        if (r4 != 0) goto L_0x0018;
    L_0x000b:
        if (r4 == 0) goto L_0x0016;
    L_0x000d:
        r0 = r4.isOpen();
        if (r0 == 0) goto L_0x0016;
    L_0x0013:
        r4.close();
    L_0x0016:
        r4 = -1;
        return r4;
    L_0x0018:
        r2 = "select * from meta";	 Catch:{ Throwable -> 0x0077, all -> 0x005f }
        r2 = r4.rawQuery(r2, r1);	 Catch:{ Throwable -> 0x0077, all -> 0x005f }
        r1 = r2.getCount();	 Catch:{ Throwable -> 0x005d, all -> 0x005b }
        r2.getColumnCount();	 Catch:{ Throwable -> 0x005d, all -> 0x005b }
        if (r1 <= 0) goto L_0x004a;	 Catch:{ Throwable -> 0x005d, all -> 0x005b }
    L_0x0027:
        r1 = r2.moveToFirst();	 Catch:{ Throwable -> 0x005d, all -> 0x005b }
        if (r1 == 0) goto L_0x004a;	 Catch:{ Throwable -> 0x005d, all -> 0x005b }
    L_0x002d:
        r1 = r2.getString(r0);	 Catch:{ Throwable -> 0x005d, all -> 0x005b }
        r3 = "version";	 Catch:{ Throwable -> 0x005d, all -> 0x005b }
        r1 = r1.equals(r3);	 Catch:{ Throwable -> 0x005d, all -> 0x005b }
        if (r1 == 0) goto L_0x0044;	 Catch:{ Throwable -> 0x005d, all -> 0x005b }
    L_0x0039:
        r1 = 1;	 Catch:{ Throwable -> 0x005d, all -> 0x005b }
        r1 = r2.getString(r1);	 Catch:{ Throwable -> 0x005d, all -> 0x005b }
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ Throwable -> 0x005d, all -> 0x005b }
        r0 = r1;	 Catch:{ Throwable -> 0x005d, all -> 0x005b }
        goto L_0x004a;	 Catch:{ Throwable -> 0x005d, all -> 0x005b }
    L_0x0044:
        r1 = r2.moveToNext();	 Catch:{ Throwable -> 0x005d, all -> 0x005b }
        if (r1 != 0) goto L_0x002d;
    L_0x004a:
        if (r2 == 0) goto L_0x004f;
    L_0x004c:
        r2.close();
    L_0x004f:
        if (r4 == 0) goto L_0x0085;
    L_0x0051:
        r1 = r4.isOpen();
        if (r1 == 0) goto L_0x0085;
    L_0x0057:
        r4.close();
        return r0;
    L_0x005b:
        r0 = move-exception;
        goto L_0x0065;
    L_0x005d:
        r1 = r2;
        goto L_0x0077;
    L_0x005f:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0065;
    L_0x0062:
        r0 = move-exception;
        r4 = r1;
        r2 = r4;
    L_0x0065:
        if (r2 == 0) goto L_0x006a;
    L_0x0067:
        r2.close();
    L_0x006a:
        if (r4 == 0) goto L_0x0075;
    L_0x006c:
        r1 = r4.isOpen();
        if (r1 == 0) goto L_0x0075;
    L_0x0072:
        r4.close();
    L_0x0075:
        throw r0;
    L_0x0076:
        r4 = r1;
    L_0x0077:
        if (r1 == 0) goto L_0x007c;
    L_0x0079:
        r1.close();
    L_0x007c:
        if (r4 == 0) goto L_0x0085;
    L_0x007e:
        r1 = r4.isOpen();
        if (r1 == 0) goto L_0x0085;
    L_0x0084:
        goto L_0x0057;
    L_0x0085:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.u.d(android.content.Context):int");
    }
}
