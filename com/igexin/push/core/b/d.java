package com.igexin.push.core.b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.igexin.b.a.b.c;
import com.igexin.b.b.a;
import com.igexin.push.core.bean.j;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.android.agoo.common.AgooConstants;

public class d implements a {
    private static d a;
    private List<j> b = new CopyOnWriteArrayList();

    private d() {
    }

    private int a(byte b) {
        int i = 0;
        for (j c : this.b) {
            if (c.c() == b) {
                i++;
            }
        }
        return i;
    }

    public static d a() {
        if (a == null) {
            a = new d();
        }
        return a;
    }

    private static ContentValues b(j jVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(AgooConstants.MESSAGE_ID, Long.valueOf(jVar.a()));
        contentValues.put("data", a.b(jVar.b().getBytes()));
        contentValues.put("type", Byte.valueOf(jVar.c()));
        contentValues.put("time", Long.valueOf(jVar.d()));
        return contentValues;
    }

    private j b(long j) {
        for (j jVar : this.b) {
            if (jVar.a() == j) {
                return jVar;
            }
        }
        return null;
    }

    private void b(byte r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = 0;
        r1 = r4.b;	 Catch:{ Throwable -> 0x0021 }
        r1 = r1.iterator();	 Catch:{ Throwable -> 0x0021 }
    L_0x0007:
        r2 = r1.hasNext();	 Catch:{ Throwable -> 0x0021 }
        if (r2 == 0) goto L_0x001a;	 Catch:{ Throwable -> 0x0021 }
    L_0x000d:
        r2 = r1.next();	 Catch:{ Throwable -> 0x0021 }
        r2 = (com.igexin.push.core.bean.j) r2;	 Catch:{ Throwable -> 0x0021 }
        r3 = r2.c();	 Catch:{ Throwable -> 0x0021 }
        if (r3 != r5) goto L_0x0007;	 Catch:{ Throwable -> 0x0021 }
    L_0x0019:
        r0 = r2;	 Catch:{ Throwable -> 0x0021 }
    L_0x001a:
        r0 = r0.a();	 Catch:{ Throwable -> 0x0021 }
        r4.a(r0);	 Catch:{ Throwable -> 0x0021 }
    L_0x0021:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.d.b(byte):void");
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
    }

    public void a(j jVar) {
        if (jVar != null && (this.b.size() < 108 || jVar.c() == (byte) 2 || jVar.c() == (byte) 7)) {
            switch (jVar.c()) {
                case (byte) 2:
                case (byte) 7:
                    b(jVar.c());
                    break;
                case (byte) 3:
                    if (a((byte) 3) >= 90) {
                        return;
                    }
                    break;
                case (byte) 5:
                    if (a((byte) 5) >= 3) {
                        return;
                    }
                    break;
                case (byte) 6:
                    if (a((byte) 6) >= 10) {
                        return;
                    }
                    break;
                case (byte) 8:
                    if (a((byte) 8) >= 3) {
                        return;
                    }
                    break;
                default:
                    break;
            }
            this.b.add(jVar);
            c.b().a(new e(this, b(jVar)), true, false);
        }
    }

    public boolean a(long j) {
        j b = b(j);
        if (b == null) {
            return false;
        }
        this.b.remove(b);
        c.b().a(new f(this, b(b), j), true, false);
        return true;
    }

    public List<j> b() {
        return this.b;
    }

    public void b(android.database.sqlite.SQLiteDatabase r19) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r18 = this;
        r1 = r18;
        r2 = 0;
        r3 = "select id,data,type,time from ral";	 Catch:{ Exception -> 0x0078, all -> 0x006f }
        r4 = r19;	 Catch:{ Exception -> 0x0078, all -> 0x006f }
        r3 = r4.rawQuery(r3, r2);	 Catch:{ Exception -> 0x0078, all -> 0x006f }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x006d, all -> 0x006a }
        if (r3 == 0) goto L_0x0060;
    L_0x0011:
        r2 = r3.moveToNext();	 Catch:{ Exception -> 0x006d, all -> 0x005c }
        if (r2 == 0) goto L_0x0060;	 Catch:{ Exception -> 0x006d, all -> 0x005c }
    L_0x0017:
        r2 = 0;	 Catch:{ Exception -> 0x006d, all -> 0x005c }
        r13 = r3.getLong(r2);	 Catch:{ Exception -> 0x006d, all -> 0x005c }
        r2 = 2;	 Catch:{ Exception -> 0x006d, all -> 0x005c }
        r2 = r3.getInt(r2);	 Catch:{ Exception -> 0x006d, all -> 0x005c }
        r10 = (byte) r2;	 Catch:{ Exception -> 0x006d, all -> 0x005c }
        r2 = 3;	 Catch:{ Exception -> 0x006d, all -> 0x005c }
        r15 = r3.getLong(r2);	 Catch:{ Exception -> 0x006d, all -> 0x005c }
        r2 = r1.b;	 Catch:{ Exception -> 0x006d, all -> 0x005c }
        r11 = new com.igexin.push.core.bean.j;	 Catch:{ Exception -> 0x006d, all -> 0x005c }
        r9 = new java.lang.String;	 Catch:{ Exception -> 0x006d, all -> 0x005c }
        r6 = 1;	 Catch:{ Exception -> 0x006d, all -> 0x005c }
        r6 = r3.getBlob(r6);	 Catch:{ Exception -> 0x006d, all -> 0x005c }
        r6 = com.igexin.b.b.a.c(r6);	 Catch:{ Exception -> 0x006d, all -> 0x005c }
        r9.<init>(r6);	 Catch:{ Exception -> 0x006d, all -> 0x005c }
        r6 = r11;
        r7 = r13;
        r17 = r3;
        r3 = r11;
        r11 = r15;
        r6.<init>(r7, r9, r10, r11);	 Catch:{ Exception -> 0x0059, all -> 0x0054 }
        r2.add(r3);	 Catch:{ Exception -> 0x0059, all -> 0x0054 }
        r2 = r4 - r15;	 Catch:{ Exception -> 0x0059, all -> 0x0054 }
        r6 = 259200000; // 0xf731400 float:1.1984677E-29 double:1.280618154E-315;	 Catch:{ Exception -> 0x0059, all -> 0x0054 }
        r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));	 Catch:{ Exception -> 0x0059, all -> 0x0054 }
        if (r8 <= 0) goto L_0x0051;	 Catch:{ Exception -> 0x0059, all -> 0x0054 }
    L_0x004e:
        r1.a(r13);	 Catch:{ Exception -> 0x0059, all -> 0x0054 }
    L_0x0051:
        r3 = r17;
        goto L_0x0011;
    L_0x0054:
        r0 = move-exception;
        r2 = r0;
        r3 = r17;
        goto L_0x0072;
    L_0x0059:
        r2 = r17;
        goto L_0x0078;
    L_0x005c:
        r0 = move-exception;
        r17 = r3;
        goto L_0x0071;
    L_0x0060:
        r17 = r3;
        if (r17 == 0) goto L_0x007d;
    L_0x0064:
        r2 = r17;
        r2.close();
        return;
    L_0x006a:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0071;
    L_0x006d:
        r2 = r3;
        goto L_0x0078;
    L_0x006f:
        r0 = move-exception;
        r3 = r2;
    L_0x0071:
        r2 = r0;
    L_0x0072:
        if (r3 == 0) goto L_0x0077;
    L_0x0074:
        r3.close();
    L_0x0077:
        throw r2;
    L_0x0078:
        if (r2 == 0) goto L_0x007d;
    L_0x007a:
        r2.close();
    L_0x007d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.d.b(android.database.sqlite.SQLiteDatabase):void");
    }

    public void c(SQLiteDatabase sQLiteDatabase) {
    }
}
