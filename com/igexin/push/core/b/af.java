package com.igexin.push.core.b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.igexin.b.a.b.c;
import com.igexin.b.a.c.a;
import com.igexin.push.core.bean.k;
import com.igexin.push.core.f;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xunlei.download.Downloads.Impl.RequestHeaders;
import java.util.ArrayList;
import java.util.Iterator;
import org.android.agoo.common.AgooConstants;

public class af implements a {
    private static final String a = "com.igexin.push.core.b.af";
    private static int b = 200;
    private static int c = 50;
    private static af f;
    private int d;
    private ArrayList<k> e = null;

    private af() {
    }

    public static af a() {
        if (f == null) {
            f = new af();
        }
        return f;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<com.igexin.push.core.bean.k> a(java.lang.String r12) {
        /*
        r11 = this;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = 0;
        r2 = com.igexin.push.core.f.a();	 Catch:{ Throwable -> 0x006b, all -> 0x0068 }
        r3 = r2.k();	 Catch:{ Throwable -> 0x006b, all -> 0x0068 }
        r4 = "st";
        r2 = 1;
        r5 = new java.lang.String[r2];	 Catch:{ Throwable -> 0x006b, all -> 0x0068 }
        r6 = "type";
        r9 = 0;
        r5[r9] = r6;	 Catch:{ Throwable -> 0x006b, all -> 0x0068 }
        r6 = new java.lang.String[r2];	 Catch:{ Throwable -> 0x006b, all -> 0x0068 }
        r6[r9] = r12;	 Catch:{ Throwable -> 0x006b, all -> 0x0068 }
        r7 = 0;
        r8 = 0;
        r12 = r3.a(r4, r5, r6, r7, r8);	 Catch:{ Throwable -> 0x006b, all -> 0x0068 }
        if (r12 == 0) goto L_0x0062;
    L_0x0024:
        r1 = r12.getCount();	 Catch:{ Throwable -> 0x0060 }
        if (r1 <= 0) goto L_0x0062;
    L_0x002a:
        r1 = r12.moveToNext();	 Catch:{ Throwable -> 0x0060 }
        if (r1 == 0) goto L_0x0062;
    L_0x0030:
        r1 = 2;
        r1 = r12.getBlob(r1);	 Catch:{ Throwable -> 0x0060 }
        r1 = com.igexin.b.b.a.c(r1);	 Catch:{ Throwable -> 0x0060 }
        r3 = new com.igexin.push.core.bean.k;	 Catch:{ Throwable -> 0x0060 }
        r3.<init>();	 Catch:{ Throwable -> 0x0060 }
        r4 = r12.getInt(r9);	 Catch:{ Throwable -> 0x0060 }
        r3.a(r4);	 Catch:{ Throwable -> 0x0060 }
        r4 = r12.getInt(r2);	 Catch:{ Throwable -> 0x0060 }
        r3.b(r4);	 Catch:{ Throwable -> 0x0060 }
        r4 = new java.lang.String;	 Catch:{ Throwable -> 0x0060 }
        r4.<init>(r1);	 Catch:{ Throwable -> 0x0060 }
        r3.a(r4);	 Catch:{ Throwable -> 0x0060 }
        r1 = 3;
        r4 = r12.getLong(r1);	 Catch:{ Throwable -> 0x0060 }
        r3.a(r4);	 Catch:{ Throwable -> 0x0060 }
        r0.add(r3);	 Catch:{ Throwable -> 0x0060 }
        goto L_0x002a;
    L_0x0060:
        r1 = move-exception;
        goto L_0x006f;
    L_0x0062:
        if (r12 == 0) goto L_0x008f;
    L_0x0064:
        r12.close();
        return r0;
    L_0x0068:
        r0 = move-exception;
        r12 = r1;
        goto L_0x0091;
    L_0x006b:
        r12 = move-exception;
        r10 = r1;
        r1 = r12;
        r12 = r10;
    L_0x006f:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0090 }
        r2.<init>();	 Catch:{ all -> 0x0090 }
        r3 = a;	 Catch:{ all -> 0x0090 }
        r2.append(r3);	 Catch:{ all -> 0x0090 }
        r3 = "|getThirdGuardData exception:";
        r2.append(r3);	 Catch:{ all -> 0x0090 }
        r1 = r1.toString();	 Catch:{ all -> 0x0090 }
        r2.append(r1);	 Catch:{ all -> 0x0090 }
        r1 = r2.toString();	 Catch:{ all -> 0x0090 }
        com.igexin.b.a.c.a.b(r1);	 Catch:{ all -> 0x0090 }
        if (r12 == 0) goto L_0x008f;
    L_0x008e:
        goto L_0x0064;
    L_0x008f:
        return r0;
    L_0x0090:
        r0 = move-exception;
    L_0x0091:
        if (r12 == 0) goto L_0x0096;
    L_0x0093:
        r12.close();
    L_0x0096:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.af.a(java.lang.String):java.util.ArrayList<com.igexin.push.core.bean.k>");
    }

    public void a(android.database.sqlite.SQLiteDatabase r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r9 = 0;
        r0 = com.igexin.push.core.f.a();	 Catch:{ Throwable -> 0x0030, all -> 0x0029 }
        r1 = r0.k();	 Catch:{ Throwable -> 0x0030, all -> 0x0029 }
        r2 = "st";	 Catch:{ Throwable -> 0x0030, all -> 0x0029 }
        r3 = 0;	 Catch:{ Throwable -> 0x0030, all -> 0x0029 }
        r4 = 0;	 Catch:{ Throwable -> 0x0030, all -> 0x0029 }
        r5 = 0;	 Catch:{ Throwable -> 0x0030, all -> 0x0029 }
        r6 = 0;	 Catch:{ Throwable -> 0x0030, all -> 0x0029 }
        r0 = r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x0030, all -> 0x0029 }
        if (r0 == 0) goto L_0x0023;
    L_0x0015:
        r9 = r0.getCount();	 Catch:{ Throwable -> 0x0021, all -> 0x001c }
        r8.d = r9;	 Catch:{ Throwable -> 0x0021, all -> 0x001c }
        goto L_0x0023;
    L_0x001c:
        r9 = move-exception;
        r7 = r0;
        r0 = r9;
        r9 = r7;
        goto L_0x002a;
    L_0x0021:
        r9 = r0;
        goto L_0x0030;
    L_0x0023:
        if (r0 == 0) goto L_0x0035;
    L_0x0025:
        r0.close();
        return;
    L_0x0029:
        r0 = move-exception;
    L_0x002a:
        if (r9 == 0) goto L_0x002f;
    L_0x002c:
        r9.close();
    L_0x002f:
        throw r0;
    L_0x0030:
        if (r9 == 0) goto L_0x0035;
    L_0x0032:
        r9.close();
    L_0x0035:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.af.a(android.database.sqlite.SQLiteDatabase):void");
    }

    public void a(String str, String str2) {
        if (this.d >= b) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append("|rowCount >= 200 can not insert");
            a.b(stringBuilder.toString());
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", str);
        contentValues.put(RequestHeaders.COLUMN_VALUE, com.igexin.b.b.a.b(str2.getBytes()));
        contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
        c.b().a(new ag(this, contentValues), false, true);
    }

    public void a(String str, ArrayList<k> arrayList) {
        try {
            String[] strArr = new String[arrayList.size()];
            Iterator it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                k kVar = (k) it.next();
                int i2 = i + 1;
                strArr[i] = String.valueOf(kVar.a());
                this.e.remove(kVar);
                i = i2;
            }
            f.a().k().a(SocializeProtocolConstants.PROTOCOL_KEY_ST, new String[]{AgooConstants.MESSAGE_ID}, strArr);
            if (this.e.size() > 0) {
                c(str);
            }
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append("|onReportResult exception:");
            stringBuilder.append(th.toString());
            a.b(stringBuilder.toString());
        }
    }

    public void b(SQLiteDatabase sQLiteDatabase) {
    }

    public void b(String str) {
        this.e = a(str);
        c(str);
    }

    public void c(SQLiteDatabase sQLiteDatabase) {
    }

    public void c(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            StringBuilder stringBuilder = new StringBuilder();
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                k kVar = (k) it.next();
                if (arrayList.size() >= c) {
                    break;
                }
                arrayList.add(kVar);
                stringBuilder.append(kVar.b());
                stringBuilder.append("\n");
            }
            Object stringBuilder2 = stringBuilder.toString();
            if (!TextUtils.isEmpty(stringBuilder2)) {
                c.b().a(new com.igexin.push.f.a.c(new com.igexin.push.core.c.k(stringBuilder2.getBytes(), str, arrayList)), false, true);
            }
        } catch (Throwable th) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(a);
            stringBuilder3.append("|doSTReport exception:");
            stringBuilder3.append(th.toString());
            a.b(stringBuilder3.toString());
        }
    }
}
