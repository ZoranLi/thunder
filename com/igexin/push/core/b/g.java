package com.igexin.push.core.b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.igexin.b.a.b.c;
import com.igexin.b.a.c.a;
import com.igexin.push.util.EncryptUtils;
import com.igexin.push.util.e;
import com.xunlei.download.Downloads.Impl.RequestHeaders;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import org.android.agoo.common.AgooConstants;

public class g implements a {
    private static final String a = "com.igexin.push.core.b.g";
    private static g b;
    private Map<String, String> c = new TreeMap();
    private boolean d;

    private g() {
    }

    public static g a() {
        if (b == null) {
            b = new g();
        }
        return b;
    }

    private void a(SQLiteDatabase sQLiteDatabase, int i, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(AgooConstants.MESSAGE_ID, Integer.valueOf(i));
        contentValues.put(RequestHeaders.COLUMN_VALUE, str);
        sQLiteDatabase.replace("runtime", null, contentValues);
    }

    private void a(SQLiteDatabase sQLiteDatabase, int i, byte[] bArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(AgooConstants.MESSAGE_ID, Integer.valueOf(i));
        contentValues.put(RequestHeaders.COLUMN_VALUE, bArr);
        sQLiteDatabase.replace("runtime", null, contentValues);
    }

    private byte[] a(android.database.sqlite.SQLiteDatabase r4, int r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = 0;
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x003e, all -> 0x0036 }
        r2 = "select value from runtime where id=";	 Catch:{ Exception -> 0x003e, all -> 0x0036 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x003e, all -> 0x0036 }
        r1.append(r5);	 Catch:{ Exception -> 0x003e, all -> 0x0036 }
        r5 = r1.toString();	 Catch:{ Exception -> 0x003e, all -> 0x0036 }
        r4 = r4.rawQuery(r5, r0);	 Catch:{ Exception -> 0x003e, all -> 0x0036 }
        if (r4 == 0) goto L_0x0033;
    L_0x0015:
        r5 = r4.moveToFirst();	 Catch:{ Exception -> 0x003f, all -> 0x0031 }
        if (r5 == 0) goto L_0x0033;	 Catch:{ Exception -> 0x003f, all -> 0x0031 }
    L_0x001b:
        r5 = "value";	 Catch:{ Exception -> 0x003f, all -> 0x0031 }
        r5 = r4.getColumnIndex(r5);	 Catch:{ Exception -> 0x003f, all -> 0x0031 }
        r5 = r4.getBlob(r5);	 Catch:{ Exception -> 0x003f, all -> 0x0031 }
        r1 = com.igexin.push.core.g.C;	 Catch:{ Exception -> 0x003f, all -> 0x0031 }
        r5 = com.igexin.b.a.a.a.c(r5, r1);	 Catch:{ Exception -> 0x003f, all -> 0x0031 }
        if (r4 == 0) goto L_0x0030;
    L_0x002d:
        r4.close();
    L_0x0030:
        return r5;
    L_0x0031:
        r5 = move-exception;
        goto L_0x0038;
    L_0x0033:
        if (r4 == 0) goto L_0x0044;
    L_0x0035:
        goto L_0x0041;
    L_0x0036:
        r5 = move-exception;
        r4 = r0;
    L_0x0038:
        if (r4 == 0) goto L_0x003d;
    L_0x003a:
        r4.close();
    L_0x003d:
        throw r5;
    L_0x003e:
        r4 = r0;
    L_0x003f:
        if (r4 == 0) goto L_0x0044;
    L_0x0041:
        r4.close();
    L_0x0044:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.g.a(android.database.sqlite.SQLiteDatabase, int):byte[]");
    }

    private java.lang.String b(android.database.sqlite.SQLiteDatabase r4, int r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = 0;
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0038, all -> 0x0031 }
        r2 = "select value from runtime where id=";	 Catch:{ Exception -> 0x0038, all -> 0x0031 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0038, all -> 0x0031 }
        r1.append(r5);	 Catch:{ Exception -> 0x0038, all -> 0x0031 }
        r5 = r1.toString();	 Catch:{ Exception -> 0x0038, all -> 0x0031 }
        r4 = r4.rawQuery(r5, r0);	 Catch:{ Exception -> 0x0038, all -> 0x0031 }
        if (r4 == 0) goto L_0x002e;
    L_0x0015:
        r5 = r4.moveToFirst();	 Catch:{ Exception -> 0x0039, all -> 0x002b }
        if (r5 == 0) goto L_0x002e;	 Catch:{ Exception -> 0x0039, all -> 0x002b }
    L_0x001b:
        r5 = "value";	 Catch:{ Exception -> 0x0039, all -> 0x002b }
        r5 = r4.getColumnIndex(r5);	 Catch:{ Exception -> 0x0039, all -> 0x002b }
        r5 = r4.getString(r5);	 Catch:{ Exception -> 0x0039, all -> 0x002b }
        if (r4 == 0) goto L_0x002a;
    L_0x0027:
        r4.close();
    L_0x002a:
        return r5;
    L_0x002b:
        r5 = move-exception;
        r0 = r4;
        goto L_0x0032;
    L_0x002e:
        if (r4 == 0) goto L_0x003e;
    L_0x0030:
        goto L_0x003b;
    L_0x0031:
        r5 = move-exception;
    L_0x0032:
        if (r0 == 0) goto L_0x0037;
    L_0x0034:
        r0.close();
    L_0x0037:
        throw r5;
    L_0x0038:
        r4 = r0;
    L_0x0039:
        if (r4 == 0) goto L_0x003e;
    L_0x003b:
        r4.close();
    L_0x003e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.g.b(android.database.sqlite.SQLiteDatabase, int):java.lang.String");
    }

    private void e(android.database.sqlite.SQLiteDatabase r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = 0;
        r1 = "select value from runtime where id=25";	 Catch:{ Exception -> 0x003e, all -> 0x0034 }
        r5 = r5.rawQuery(r1, r0);	 Catch:{ Exception -> 0x003e, all -> 0x0034 }
        if (r5 == 0) goto L_0x0031;
    L_0x0009:
        r0 = r5.moveToFirst();	 Catch:{ Exception -> 0x003f, all -> 0x002f }
        if (r0 == 0) goto L_0x0031;	 Catch:{ Exception -> 0x003f, all -> 0x002f }
    L_0x000f:
        r0 = new java.lang.String;	 Catch:{ Exception -> 0x003f, all -> 0x002f }
        r1 = "value";	 Catch:{ Exception -> 0x003f, all -> 0x002f }
        r1 = r5.getColumnIndex(r1);	 Catch:{ Exception -> 0x003f, all -> 0x002f }
        r1 = r5.getBlob(r1);	 Catch:{ Exception -> 0x003f, all -> 0x002f }
        r2 = com.igexin.push.core.g.f;	 Catch:{ Exception -> 0x003f, all -> 0x002f }
        r2 = r2.getPackageName();	 Catch:{ Exception -> 0x003f, all -> 0x002f }
        r2 = com.igexin.b.b.a.a(r2);	 Catch:{ Exception -> 0x003f, all -> 0x002f }
        r1 = com.igexin.b.a.a.a.c(r1, r2);	 Catch:{ Exception -> 0x003f, all -> 0x002f }
        r0.<init>(r1);	 Catch:{ Exception -> 0x003f, all -> 0x002f }
        com.igexin.push.core.g.C = r0;	 Catch:{ Exception -> 0x003f, all -> 0x002f }
        goto L_0x0031;
    L_0x002f:
        r0 = move-exception;
        goto L_0x0038;
    L_0x0031:
        if (r5 == 0) goto L_0x0044;
    L_0x0033:
        goto L_0x0041;
    L_0x0034:
        r5 = move-exception;
        r3 = r0;
        r0 = r5;
        r5 = r3;
    L_0x0038:
        if (r5 == 0) goto L_0x003d;
    L_0x003a:
        r5.close();
    L_0x003d:
        throw r0;
    L_0x003e:
        r5 = r0;
    L_0x003f:
        if (r5 == 0) goto L_0x0044;
    L_0x0041:
        r5.close();
    L_0x0044:
        r5 = com.igexin.push.core.g.C;
        if (r5 != 0) goto L_0x0057;
    L_0x0048:
        r5 = com.igexin.push.core.g.t;
        if (r5 != 0) goto L_0x004f;
    L_0x004c:
        r5 = "cantgetimei";
        goto L_0x0051;
    L_0x004f:
        r5 = com.igexin.push.core.g.t;
    L_0x0051:
        r5 = com.igexin.b.b.a.a(r5);
        com.igexin.push.core.g.C = r5;
    L_0x0057:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.g.e(android.database.sqlite.SQLiteDatabase):void");
    }

    private boolean e() {
        return c.b().a(new y(this), false, true);
    }

    private void f() {
        e.a();
        String c = e.c();
        if (c == null || c.length() <= 5) {
            e.e();
        }
    }

    private void f(SQLiteDatabase sQLiteDatabase) {
        String b = b(sQLiteDatabase, 2);
        if (!TextUtils.isEmpty(b)) {
            if (b.equals("null")) {
                b = null;
            }
            com.igexin.push.core.g.y = b;
        }
    }

    private String g() {
        String str = "";
        Random random = new Random(Math.abs(new Random().nextLong()));
        for (int i = 0; i < 15; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(random.nextInt(10));
            str = stringBuilder.toString();
        }
        return str;
    }

    private void g(SQLiteDatabase sQLiteDatabase) {
        String b = b(sQLiteDatabase, 46);
        if (!TextUtils.isEmpty(b)) {
            if (b.equals("null")) {
                b = null;
            }
            com.igexin.push.core.g.z = b;
        }
    }

    private byte[] g(String str) {
        return EncryptUtils.getBytesEncrypted(str.getBytes());
    }

    private void h(SQLiteDatabase sQLiteDatabase) {
        String b = b(sQLiteDatabase, 48);
        if (!TextUtils.isEmpty(b)) {
            if (b.equals("null")) {
                b = null;
            }
            com.igexin.push.core.g.A = b;
        }
    }

    private void i(SQLiteDatabase sQLiteDatabase) {
        String b = b(sQLiteDatabase, 3);
        if (!TextUtils.isEmpty(b)) {
            if (b.equals("null")) {
                b = null;
            }
            com.igexin.push.core.g.B = b;
        }
    }

    private void j(android.database.sqlite.SQLiteDatabase r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = 1;
        r3 = r2.a(r3, r0);
        if (r3 == 0) goto L_0x0038;
    L_0x0007:
        r0 = new java.lang.String;	 Catch:{ Exception -> 0x001d }
        r0.<init>(r3);	 Catch:{ Exception -> 0x001d }
        r3 = "null";	 Catch:{ Exception -> 0x001d }
        r3 = r0.equals(r3);	 Catch:{ Exception -> 0x001d }
        if (r3 == 0) goto L_0x0017;	 Catch:{ Exception -> 0x001d }
    L_0x0014:
        r0 = 0;	 Catch:{ Exception -> 0x001d }
        goto L_0x001b;	 Catch:{ Exception -> 0x001d }
    L_0x0017:
        r0 = java.lang.Long.parseLong(r0);	 Catch:{ Exception -> 0x001d }
    L_0x001b:
        com.igexin.push.core.g.q = r0;	 Catch:{ Exception -> 0x001d }
    L_0x001d:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r0 = a;
        r3.append(r0);
        r0 = "|db version changed, save session = ";
        r3.append(r0);
        r0 = com.igexin.push.core.g.q;
        r3.append(r0);
        r3 = r3.toString();
        com.igexin.b.a.c.a.b(r3);
    L_0x0038:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.g.j(android.database.sqlite.SQLiteDatabase):void");
    }

    private void k(SQLiteDatabase sQLiteDatabase) {
        byte[] a = a(sQLiteDatabase, 20);
        if (a != null) {
            String str = new String(a);
            if (str.equals("null")) {
                str = null;
            }
            com.igexin.push.core.g.s = str;
            com.igexin.push.core.g.r = str;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append("|db version changed, save cid = ");
            stringBuilder.append(str);
            a.b(stringBuilder.toString());
        }
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
    }

    public boolean a(int i) {
        com.igexin.push.core.g.T = i;
        return c.b().a(new o(this), false, true);
    }

    public boolean a(long j) {
        if (j == com.igexin.push.core.g.H) {
            return false;
        }
        com.igexin.push.core.g.H = j;
        return c.b().a(new s(this), false, true);
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.igexin.push.core.g.w = str;
        return c.b().a(new z(this), false, true);
    }

    public boolean a(String str, String str2, long j) {
        com.igexin.push.core.g.q = j;
        if (TextUtils.isEmpty(com.igexin.push.core.g.y)) {
            com.igexin.push.core.g.y = str2;
        }
        com.igexin.push.core.g.r = str;
        return e();
    }

    public boolean a(String str, boolean z) {
        if (str == null) {
            return false;
        }
        c b;
        com.igexin.b.a.d.e pVar;
        String str2 = null;
        if (z) {
            if (!str.equals(com.igexin.push.core.g.az)) {
                if (!str.equals("null")) {
                    str2 = str;
                }
                com.igexin.push.core.g.az = str2;
                b = c.b();
                pVar = new p(this, str);
            }
            return false;
        }
        if (!str.equals(com.igexin.push.core.g.aA)) {
            if (!str.equals("null")) {
                str2 = str;
            }
            com.igexin.push.core.g.aA = str2;
            b = c.b();
            pVar = new q(this, str);
        }
        return false;
        return b.a(pVar, false, true);
    }

    public boolean a(boolean z) {
        if (com.igexin.push.core.g.O == z) {
            return false;
        }
        com.igexin.push.core.g.O = z;
        return c.b().a(new l(this), false, true);
    }

    public void b() {
        c.b().a(new h(this), false, true);
    }

    public void b(android.database.sqlite.SQLiteDatabase r14) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r13 = this;
        r13.e(r14);
        r0 = 25;
        r1 = 14;
        r2 = 20;
        r3 = 0;
        r4 = 1;
        r5 = 0;
        r7 = 0;
        r8 = "select id, value from runtime order by id";	 Catch:{ Exception -> 0x02b8, all -> 0x02b0 }
        r8 = r14.rawQuery(r8, r7);	 Catch:{ Exception -> 0x02b8, all -> 0x02b0 }
        if (r8 == 0) goto L_0x02ad;
    L_0x0016:
        r9 = r8.moveToNext();	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        if (r9 == 0) goto L_0x02ad;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x001c:
        r9 = r8.getInt(r3);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        if (r9 == r4) goto L_0x0044;
    L_0x0022:
        if (r9 == r1) goto L_0x0044;
    L_0x0024:
        r10 = 19;
        if (r9 == r10) goto L_0x0044;
    L_0x0028:
        if (r9 == r2) goto L_0x0044;
    L_0x002a:
        r10 = 23;
        if (r9 == r10) goto L_0x0044;
    L_0x002e:
        if (r9 == r0) goto L_0x0044;
    L_0x0030:
        r10 = 22;
        if (r9 == r10) goto L_0x0044;
    L_0x0034:
        r10 = 31;
        if (r9 == r10) goto L_0x0044;
    L_0x0038:
        r10 = 30;
        if (r9 != r10) goto L_0x003d;
    L_0x003c:
        goto L_0x0044;
    L_0x003d:
        r10 = r8.getString(r4);	 Catch:{ Throwable -> 0x028e }
        r11 = r10;	 Catch:{ Throwable -> 0x028e }
        r10 = r7;	 Catch:{ Throwable -> 0x028e }
        goto L_0x0051;	 Catch:{ Throwable -> 0x028e }
    L_0x0044:
        r10 = r8.getBlob(r4);	 Catch:{ Throwable -> 0x028e }
        if (r10 == 0) goto L_0x0050;	 Catch:{ Throwable -> 0x028e }
    L_0x004a:
        r11 = com.igexin.push.core.g.C;	 Catch:{ Throwable -> 0x028e }
        r10 = com.igexin.b.a.a.a.c(r10, r11);	 Catch:{ Throwable -> 0x028e }
    L_0x0050:
        r11 = r7;
    L_0x0051:
        if (r10 != 0) goto L_0x0056;
    L_0x0053:
        if (r11 != 0) goto L_0x0056;
    L_0x0055:
        goto L_0x0016;
    L_0x0056:
        r12 = 6;
        if (r9 == r12) goto L_0x027c;
    L_0x0059:
        r12 = 8;
        if (r9 == r12) goto L_0x026a;
    L_0x005d:
        r12 = 40;
        if (r9 == r12) goto L_0x0250;
    L_0x0061:
        switch(r9) {
            case 1: goto L_0x0235;
            case 2: goto L_0x0228;
            case 3: goto L_0x021b;
            case 4: goto L_0x0205;
            default: goto L_0x0064;
        };
    L_0x0064:
        switch(r9) {
            case 11: goto L_0x01f3;
            case 12: goto L_0x01e1;
            case 13: goto L_0x01d4;
            case 14: goto L_0x01cb;
            case 15: goto L_0x01bb;
            case 16: goto L_0x01a9;
            case 17: goto L_0x019c;
            case 18: goto L_0x018a;
            case 19: goto L_0x0178;
            case 20: goto L_0x0164;
            case 21: goto L_0x0152;
            case 22: goto L_0x0129;
            case 23: goto L_0x0100;
            default: goto L_0x0067;
        };
    L_0x0067:
        switch(r9) {
            case 30: goto L_0x00d7;
            case 31: goto L_0x00aa;
            case 32: goto L_0x0098;
            default: goto L_0x006a;
        };
    L_0x006a:
        switch(r9) {
            case 46: goto L_0x008b;
            case 47: goto L_0x007a;
            case 48: goto L_0x006e;
            default: goto L_0x006d;
        };
    L_0x006d:
        goto L_0x0016;
    L_0x006e:
        r9 = "null";	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9 = r11.equals(r9);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        if (r9 == 0) goto L_0x0077;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0076:
        r11 = r7;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0077:
        com.igexin.push.core.g.A = r11;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x0016;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x007a:
        r9 = "null";	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9 = r11.equals(r9);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        if (r9 == 0) goto L_0x0084;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0082:
        r9 = r3;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x0088;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0084:
        r9 = java.lang.Integer.parseInt(r11);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0088:
        com.igexin.push.core.g.aC = r9;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x0016;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x008b:
        r9 = "null";	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9 = r11.equals(r9);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        if (r9 == 0) goto L_0x0094;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0093:
        r11 = r7;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0094:
        com.igexin.push.core.g.z = r11;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x0016;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0098:
        r9 = "null";	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9 = r11.equals(r9);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        if (r9 == 0) goto L_0x00a2;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x00a0:
        r9 = r5;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x00a6;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x00a2:
        r9 = java.lang.Long.parseLong(r11);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x00a6:
        com.igexin.push.core.g.M = r9;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x0016;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x00aa:
        r9 = new java.lang.String;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9.<init>(r10);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r10 = "null";	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r10 = r9.equals(r10);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        if (r10 == 0) goto L_0x00b8;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x00b7:
        r9 = r7;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x00b8:
        com.igexin.push.core.g.az = r9;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9.<init>();	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r10 = a;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9.append(r10);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r10 = "|read last domainMobileStatus = ";	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9.append(r10);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r10 = com.igexin.push.core.g.az;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9.append(r10);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9 = r9.toString();	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x00d2:
        com.igexin.b.a.c.a.b(r9);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x0016;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x00d7:
        r9 = new java.lang.String;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9.<init>(r10);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r10 = "null";	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r10 = r9.equals(r10);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        if (r10 == 0) goto L_0x00e5;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x00e4:
        r9 = r7;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x00e5:
        com.igexin.push.core.g.aA = r9;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9.<init>();	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r10 = a;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9.append(r10);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r10 = "|read last domainWifiStatus = ";	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9.append(r10);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r10 = com.igexin.push.core.g.aA;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9.append(r10);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9 = r9.toString();	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x00d2;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0100:
        r9 = new java.lang.String;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9.<init>(r10);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r10 = "null";	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r10 = r9.equals(r10);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        if (r10 == 0) goto L_0x010e;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x010d:
        r9 = r7;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x010e:
        com.igexin.push.core.g.ax = r9;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9.<init>();	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r10 = a;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9.append(r10);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r10 = "|read last mobile result = ";	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9.append(r10);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r10 = com.igexin.push.core.g.ax;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9.append(r10);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9 = r9.toString();	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x00d2;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0129:
        r9 = new java.lang.String;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9.<init>(r10);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r10 = "null";	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r10 = r9.equals(r10);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        if (r10 == 0) goto L_0x0137;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0136:
        r9 = r7;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0137:
        com.igexin.push.core.g.ay = r9;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9.<init>();	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r10 = a;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9.append(r10);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r10 = "|read last wifi result = ";	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9.append(r10);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r10 = com.igexin.push.core.g.ay;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9.append(r10);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9 = r9.toString();	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x00d2;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0152:
        r9 = "null";	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9 = r11.equals(r9);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        if (r9 == 0) goto L_0x015c;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x015a:
        r9 = r5;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x0160;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x015c:
        r9 = java.lang.Long.parseLong(r11);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0160:
        com.igexin.push.core.g.aw = r9;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x0016;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0164:
        r9 = new java.lang.String;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9.<init>(r10);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r10 = "null";	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r10 = r9.equals(r10);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        if (r10 == 0) goto L_0x0172;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0171:
        r9 = r7;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0172:
        com.igexin.push.core.g.s = r9;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        com.igexin.push.core.g.r = r9;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x0016;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0178:
        r9 = new java.lang.String;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9.<init>(r10);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r10 = "null";	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r10 = r9.equals(r10);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        if (r10 == 0) goto L_0x0186;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0185:
        r9 = r7;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0186:
        com.igexin.push.core.g.w = r9;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x0016;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x018a:
        r9 = "null";	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9 = r11.equals(r9);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        if (r9 == 0) goto L_0x0194;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0192:
        r9 = r3;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x0198;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0194:
        r9 = java.lang.Integer.parseInt(r11);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0198:
        com.igexin.push.core.g.T = r9;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x0016;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x019c:
        r9 = "null";	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9 = r11.equals(r9);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        if (r9 == 0) goto L_0x01a5;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x01a4:
        r11 = r7;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x01a5:
        com.igexin.push.core.g.R = r11;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x0016;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x01a9:
        r9 = "null";	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9 = r11.equals(r9);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        if (r9 == 0) goto L_0x01b3;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x01b1:
        r9 = r5;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x01b7;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x01b3:
        r9 = java.lang.Long.parseLong(r11);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x01b7:
        com.igexin.push.core.g.P = r9;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x0016;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x01bb:
        r9 = "null";	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9 = r11.equals(r9);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        if (r9 != 0) goto L_0x0016;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x01c3:
        r9 = java.lang.Boolean.parseBoolean(r11);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        com.igexin.push.core.g.O = r9;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x0016;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x01cb:
        r9 = new java.lang.String;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9.<init>(r10);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        com.igexin.push.core.g.au = r9;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x0016;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x01d4:
        r9 = "null";	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9 = r11.equals(r9);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        if (r9 == 0) goto L_0x01dd;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x01dc:
        r11 = r7;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x01dd:
        com.igexin.push.core.g.N = r11;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x0016;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x01e1:
        r9 = "null";	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9 = r11.equals(r9);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        if (r9 == 0) goto L_0x01eb;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x01e9:
        r9 = r5;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x01ef;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x01eb:
        r9 = java.lang.Long.parseLong(r11);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x01ef:
        com.igexin.push.core.g.L = r9;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x0016;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x01f3:
        r9 = "null";	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9 = r11.equals(r9);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        if (r9 == 0) goto L_0x01fd;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x01fb:
        r9 = r5;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x0201;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x01fd:
        r9 = java.lang.Long.parseLong(r11);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0201:
        com.igexin.push.core.g.K = r9;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x0016;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0205:
        r9 = "null";	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9 = r11.equals(r9);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        if (r9 != 0) goto L_0x0216;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x020d:
        r9 = java.lang.Boolean.parseBoolean(r11);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        if (r9 == 0) goto L_0x0214;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0213:
        goto L_0x0216;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0214:
        r9 = r3;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x0217;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0216:
        r9 = r4;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0217:
        com.igexin.push.core.g.k = r9;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x0016;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x021b:
        r9 = "null";	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9 = r11.equals(r9);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        if (r9 == 0) goto L_0x0224;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0223:
        r11 = r7;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0224:
        com.igexin.push.core.g.B = r11;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x0016;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0228:
        r9 = "null";	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9 = r11.equals(r9);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        if (r9 == 0) goto L_0x0231;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0230:
        r11 = r7;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0231:
        com.igexin.push.core.g.y = r11;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x0016;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0235:
        r9 = new java.lang.String;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9.<init>(r10);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r10 = "null";	 Catch:{ Exception -> 0x024c, all -> 0x02ab }
        r10 = r9.equals(r10);	 Catch:{ Exception -> 0x024c, all -> 0x02ab }
        if (r10 == 0) goto L_0x0244;	 Catch:{ Exception -> 0x024c, all -> 0x02ab }
    L_0x0242:
        r9 = r5;	 Catch:{ Exception -> 0x024c, all -> 0x02ab }
        goto L_0x0248;	 Catch:{ Exception -> 0x024c, all -> 0x02ab }
    L_0x0244:
        r9 = java.lang.Long.parseLong(r9);	 Catch:{ Exception -> 0x024c, all -> 0x02ab }
    L_0x0248:
        com.igexin.push.core.g.q = r9;	 Catch:{ Exception -> 0x024c, all -> 0x02ab }
        goto L_0x0016;
    L_0x024c:
        com.igexin.push.core.g.q = r5;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x0016;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0250:
        r9 = "null";	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9 = r11.equals(r9);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        if (r9 != 0) goto L_0x0260;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0258:
        r9 = java.lang.Boolean.parseBoolean(r11);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        if (r9 == 0) goto L_0x0260;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x025e:
        r9 = r4;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x0261;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0260:
        r9 = r3;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0261:
        r10 = com.igexin.push.d.b.a();	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r10.a(r9);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x0016;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x026a:
        r9 = "null";	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9 = r11.equals(r9);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        if (r9 == 0) goto L_0x0274;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0272:
        r9 = r5;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x0278;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0274:
        r9 = java.lang.Long.parseLong(r11);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0278:
        com.igexin.push.core.g.H = r9;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x0016;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x027c:
        r9 = "null";	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9 = r11.equals(r9);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        if (r9 == 0) goto L_0x0286;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0284:
        r9 = r5;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x028a;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x0286:
        r9 = java.lang.Long.parseLong(r11);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x028a:
        com.igexin.push.core.g.G = r9;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x0016;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
    L_0x028e:
        r9 = move-exception;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r10 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r10.<init>();	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r11 = a;	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r10.append(r11);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r11 = "|";	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r10.append(r11);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9 = r9.toString();	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r10.append(r9);	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        r9 = r10.toString();	 Catch:{ Exception -> 0x02b9, all -> 0x02ab }
        goto L_0x00d2;
    L_0x02ab:
        r14 = move-exception;
        goto L_0x02b2;
    L_0x02ad:
        if (r8 == 0) goto L_0x02be;
    L_0x02af:
        goto L_0x02bb;
    L_0x02b0:
        r14 = move-exception;
        r8 = r7;
    L_0x02b2:
        if (r8 == 0) goto L_0x02b7;
    L_0x02b4:
        r8.close();
    L_0x02b7:
        throw r14;
    L_0x02b8:
        r8 = r7;
    L_0x02b9:
        if (r8 == 0) goto L_0x02be;
    L_0x02bb:
        r8.close();
    L_0x02be:
        r8 = com.igexin.push.core.g.q;
        r10 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1));
        if (r10 != 0) goto L_0x02dd;
    L_0x02c4:
        r8 = com.igexin.push.util.e.d();
        r10 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1));
        if (r10 == 0) goto L_0x02dd;
    L_0x02cc:
        com.igexin.push.core.g.q = r8;
        r8 = java.lang.String.valueOf(r8);
        r8 = r8.getBytes();
        r8 = com.igexin.push.util.EncryptUtils.getBytesEncrypted(r8);
        r13.a(r14, r4, r8);
    L_0x02dd:
        r8 = com.igexin.push.core.g.r;
        if (r8 != 0) goto L_0x02f8;
    L_0x02e1:
        r8 = com.igexin.push.util.e.b();
        if (r8 == 0) goto L_0x02f8;
    L_0x02e7:
        com.igexin.push.core.g.s = r8;
        com.igexin.push.core.g.r = r8;
        r8 = com.igexin.push.core.g.r;
        r8 = r8.getBytes();
        r8 = com.igexin.push.util.EncryptUtils.getBytesEncrypted(r8);
        r13.a(r14, r2, r8);
    L_0x02f8:
        r8 = com.igexin.push.core.g.r;
        if (r8 != 0) goto L_0x0320;
    L_0x02fc:
        r8 = com.igexin.push.core.g.q;
        r10 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1));
        if (r10 == 0) goto L_0x0320;
    L_0x0302:
        r8 = com.igexin.push.core.g.q;
        r8 = java.lang.String.valueOf(r8);
        r8 = com.igexin.b.b.a.a(r8);
        com.igexin.push.core.g.s = r8;
        r8 = com.igexin.push.core.g.q;
        com.igexin.push.core.g.a(r8);
        r8 = com.igexin.push.core.g.r;
        r8 = r8.getBytes();
        r8 = com.igexin.push.util.EncryptUtils.getBytesEncrypted(r8);
        r13.a(r14, r2, r8);
    L_0x0320:
        r8 = "cfcd208495d565ef66e7dff9f98764da";
        r9 = com.igexin.push.core.g.r;
        r8 = r8.equals(r9);
        if (r8 != 0) goto L_0x0338;
    L_0x032a:
        r8 = com.igexin.push.core.g.r;
        if (r8 == 0) goto L_0x0357;
    L_0x032e:
        r8 = com.igexin.push.core.g.r;
        r9 = "([a-f]|[0-9]){32}";
        r8 = r8.matches(r9);
        if (r8 != 0) goto L_0x0357;
    L_0x0338:
        r8 = com.igexin.push.core.g.q;
        r10 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1));
        if (r10 == 0) goto L_0x034f;
    L_0x033e:
        r7 = a();
        r8 = com.igexin.push.core.g.q;
        r7.b(r8);
        r7 = com.igexin.push.core.g.r;
        com.igexin.push.core.g.s = r7;
        com.igexin.push.util.e.f();
        goto L_0x0357;
    L_0x034f:
        com.igexin.push.core.g.s = r7;
        r7 = "null";
        com.igexin.push.core.g.r = r7;
        com.igexin.push.core.g.q = r5;
    L_0x0357:
        r7 = com.igexin.push.core.g.au;
        r7 = android.text.TextUtils.isEmpty(r7);
        if (r7 != 0) goto L_0x0369;
    L_0x035f:
        r7 = "null";
        r8 = com.igexin.push.core.g.au;
        r7 = r7.equals(r8);
        if (r7 == 0) goto L_0x037e;
    L_0x0369:
        r7 = 32;
        r7 = com.igexin.b.b.a.a(r7);
        com.igexin.push.core.g.au = r7;
        r7 = com.igexin.push.core.g.au;
        r7 = r7.getBytes();
        r7 = com.igexin.push.util.EncryptUtils.getBytesEncrypted(r7);
        r13.a(r14, r1, r7);
    L_0x037e:
        r1 = com.igexin.push.util.e.c();
        r7 = com.igexin.push.core.g.y;
        r8 = 2;
        r9 = 5;
        if (r7 != 0) goto L_0x0397;
    L_0x0388:
        if (r1 == 0) goto L_0x0397;
    L_0x038a:
        r7 = r1.length();
        if (r7 <= r9) goto L_0x0397;
    L_0x0390:
        com.igexin.push.core.g.y = r1;
        r1 = com.igexin.push.core.g.y;
        r13.a(r14, r8, r1);
    L_0x0397:
        r1 = com.igexin.push.core.g.B;
        r7 = 3;
        if (r1 != 0) goto L_0x03d3;
    L_0x039c:
        r1 = com.igexin.push.core.g.t;
        if (r1 != 0) goto L_0x03b2;
    L_0x03a0:
        r1 = new java.lang.StringBuilder;
        r10 = "V";
        r1.<init>(r10);
        r10 = r13.g();
        r1.append(r10);
        r1 = r1.toString();
    L_0x03b2:
        r10 = new java.lang.StringBuilder;
        r11 = "A-";
        r10.<init>(r11);
        r10.append(r1);
        r1 = "-";
        r10.append(r1);
        r11 = java.lang.System.currentTimeMillis();
        r10.append(r11);
        r1 = r10.toString();
        com.igexin.push.core.g.B = r1;
        r1 = com.igexin.push.core.g.B;
        r13.a(r14, r7, r1);
    L_0x03d3:
        r1 = r13.d;
        if (r1 == 0) goto L_0x0464;
    L_0x03d7:
        r13.d = r3;
        r1 = com.igexin.push.core.g.C;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x03f8;
    L_0x03e1:
        r1 = com.igexin.push.core.g.C;
        r1 = r1.getBytes();
        r3 = com.igexin.push.core.g.f;
        r3 = r3.getPackageName();
        r3 = com.igexin.b.b.a.a(r3);
        r1 = com.igexin.b.a.a.a.d(r1, r3);
        r13.a(r14, r0, r1);
    L_0x03f8:
        r0 = com.igexin.push.core.g.q;
        r3 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1));
        if (r3 == 0) goto L_0x040f;
    L_0x03fe:
        r0 = com.igexin.push.core.g.q;
        r0 = java.lang.String.valueOf(r0);
        r0 = r0.getBytes();
        r0 = com.igexin.push.util.EncryptUtils.getBytesEncrypted(r0);
        r13.a(r14, r4, r0);
    L_0x040f:
        r0 = com.igexin.push.core.g.r;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x0424;
    L_0x0417:
        r0 = com.igexin.push.core.g.r;
        r0 = r0.getBytes();
        r0 = com.igexin.push.util.EncryptUtils.getBytesEncrypted(r0);
        r13.a(r14, r2, r0);
    L_0x0424:
        r0 = com.igexin.push.core.g.y;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x0439;
    L_0x042c:
        r0 = com.igexin.push.core.g.y;
        r0 = r0.length();
        if (r0 <= r9) goto L_0x0439;
    L_0x0434:
        r0 = com.igexin.push.core.g.y;
        r13.a(r14, r8, r0);
    L_0x0439:
        r0 = com.igexin.push.core.g.B;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x0446;
    L_0x0441:
        r0 = com.igexin.push.core.g.B;
        r13.a(r14, r7, r0);
    L_0x0446:
        r0 = com.igexin.push.core.g.z;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x0455;
    L_0x044e:
        r0 = 46;
        r1 = com.igexin.push.core.g.z;
        r13.a(r14, r0, r1);
    L_0x0455:
        r0 = com.igexin.push.core.g.A;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x0464;
    L_0x045d:
        r0 = 48;
        r1 = com.igexin.push.core.g.A;
        r13.a(r14, r0, r1);
    L_0x0464:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.g.b(android.database.sqlite.SQLiteDatabase):void");
    }

    public boolean b(int i) {
        if (com.igexin.push.core.g.aC == i) {
            return false;
        }
        com.igexin.push.core.g.aC = i;
        return c.b().a(new w(this), false, true);
    }

    public boolean b(long j) {
        com.igexin.push.core.g.a(j);
        return c.b().a(new aa(this), false, true);
    }

    public boolean b(String str) {
        com.igexin.push.core.g.y = str;
        return c.b().a(new ab(this), false, true);
    }

    public boolean b(String str, boolean z) {
        if (str == null) {
            return false;
        }
        c b;
        com.igexin.b.a.d.e rVar;
        String str2 = null;
        if (z) {
            if (!str.equals(com.igexin.push.core.g.ax)) {
                if (!str.equals("null")) {
                    str2 = str;
                }
                com.igexin.push.core.g.ax = str2;
                b = c.b();
                rVar = new r(this, str);
            }
            return false;
        }
        if (!str.equals(com.igexin.push.core.g.ay)) {
            if (!str.equals("null")) {
                str2 = str;
            }
            com.igexin.push.core.g.ay = str2;
            b = c.b();
            rVar = new t(this, str);
        }
        return false;
        return b.a(rVar, false, true);
    }

    public boolean b(boolean z) {
        return c.b().a(new x(this, z), false, true);
    }

    public void c(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, 1, com.igexin.b.a.a.a.d(String.valueOf(com.igexin.push.core.g.q).getBytes(), com.igexin.push.core.g.C));
        a(sQLiteDatabase, 4, String.valueOf(com.igexin.push.core.g.k));
        a(sQLiteDatabase, 8, String.valueOf(com.igexin.push.core.g.H));
        a(sQLiteDatabase, 32, String.valueOf(com.igexin.push.core.g.M));
        a(sQLiteDatabase, 3, com.igexin.push.core.g.B);
        a(sQLiteDatabase, 11, String.valueOf(com.igexin.push.core.g.K));
        a(sQLiteDatabase, 12, String.valueOf(com.igexin.push.core.g.L));
        a(sQLiteDatabase, 20, com.igexin.b.a.a.a.d(com.igexin.push.core.g.r.getBytes(), com.igexin.push.core.g.C));
        a(sQLiteDatabase, 2, com.igexin.push.core.g.y);
        a(sQLiteDatabase, 25, com.igexin.b.a.a.a.d(com.igexin.push.core.g.C.getBytes(), com.igexin.b.b.a.a(com.igexin.push.core.g.f.getPackageName())));
    }

    public boolean c() {
        com.igexin.push.core.g.q = 0;
        com.igexin.push.core.g.r = "null";
        return e();
    }

    public boolean c(long j) {
        if (com.igexin.push.core.g.L == j) {
            return false;
        }
        com.igexin.push.core.g.L = j;
        c.b().a(new ae(this), false, true);
        return true;
    }

    public boolean c(String str) {
        com.igexin.push.core.g.z = str;
        return c.b().a(new ac(this), false, true);
    }

    public Map<String, String> d() {
        return this.c;
    }

    public void d(SQLiteDatabase sQLiteDatabase) {
        this.d = true;
        e(sQLiteDatabase);
        j(sQLiteDatabase);
        k(sQLiteDatabase);
        i(sQLiteDatabase);
        f(sQLiteDatabase);
        g(sQLiteDatabase);
        h(sQLiteDatabase);
    }

    public boolean d(long j) {
        com.igexin.push.core.g.aw = j;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append("|save idc config failed time : ");
        stringBuilder.append(j);
        a.b(stringBuilder.toString());
        return c.b().a(new i(this, j), false, true);
    }

    public boolean d(String str) {
        com.igexin.push.core.g.A = str;
        return c.b().a(new ad(this), false, true);
    }

    public boolean e(long j) {
        if (com.igexin.push.core.g.K == j) {
            return false;
        }
        com.igexin.push.core.g.K = j;
        return c.b().a(new j(this), false, true);
    }

    public boolean e(String str) {
        if (str == null || str.equals(com.igexin.push.core.g.N)) {
            return false;
        }
        com.igexin.push.core.g.N = str;
        c.b().a(new k(this), false, true);
        return true;
    }

    public boolean f(long j) {
        if (com.igexin.push.core.g.P == j) {
            return false;
        }
        com.igexin.push.core.g.P = j;
        return c.b().a(new m(this), false, true);
    }

    public boolean f(String str) {
        if (str.equals(com.igexin.push.core.g.R)) {
            return false;
        }
        com.igexin.push.core.g.R = str;
        return c.b().a(new n(this), false, true);
    }

    public boolean g(long j) {
        if (com.igexin.push.core.g.M == j) {
            return false;
        }
        com.igexin.push.core.g.M = j;
        return c.b().a(new u(this), false, true);
    }

    public boolean h(long j) {
        if (com.igexin.push.core.g.G == j) {
            return false;
        }
        com.igexin.push.core.g.G = j;
        return c.b().a(new v(this), false, true);
    }
}
