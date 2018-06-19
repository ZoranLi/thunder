package com.xunlei.downloadprovider.homepage.recommend.b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.message.proguard.k;
import com.xunlei.downloadprovider.app.BrothersApplication;
import java.util.ArrayList;
import java.util.List;

/* compiled from: LikeDatabase */
public final class a extends SQLiteOpenHelper {
    static String a = "clickNiceRecord_table";
    static String b = "id";
    static String c = "name";
    static String d = "play_url";
    static String e = "movie_id";
    static String f = "gc_id";
    private static a h;
    private final String g = "LikeDatabase";

    public static a a() {
        if (h == null) {
            h = new a(BrothersApplication.getApplicationInstance());
        }
        return h;
    }

    private a(Context context) {
        super(context, "clickNiceRecord_db", null, 111);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder("onUpgrade oldVersion=");
        stringBuilder.append(i);
        stringBuilder.append(",newVersion=");
        stringBuilder.append(i2);
        i = new StringBuilder("drop table if exists ");
        i.append(a);
        sQLiteDatabase.execSQL(i.toString());
        a(sQLiteDatabase);
    }

    private static void a(SQLiteDatabase sQLiteDatabase) {
        StringBuilder stringBuilder = new StringBuilder("create table if not exists ");
        stringBuilder.append(a);
        stringBuilder.append(k.s);
        stringBuilder.append(b);
        stringBuilder.append(" integer primary key autoincrement,");
        stringBuilder.append(c);
        stringBuilder.append(" text,");
        stringBuilder.append(e);
        stringBuilder.append(" long,");
        stringBuilder.append(d);
        stringBuilder.append(" text,");
        stringBuilder.append(f);
        stringBuilder.append(" text)");
        sQLiteDatabase.execSQL(stringBuilder.toString());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.xunlei.downloadprovider.homepage.recommend.b.b a(java.lang.String r12) {
        /*
        r11 = this;
        r9 = r11.getWritableDatabase();
        r10 = 0;
        r1 = a;	 Catch:{ Exception -> 0x004e, all -> 0x004c }
        r2 = 0;
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x004e, all -> 0x004c }
        r0.<init>();	 Catch:{ Exception -> 0x004e, all -> 0x004c }
        r3 = e;	 Catch:{ Exception -> 0x004e, all -> 0x004c }
        r0.append(r3);	 Catch:{ Exception -> 0x004e, all -> 0x004c }
        r3 = "=";
        r0.append(r3);	 Catch:{ Exception -> 0x004e, all -> 0x004c }
        r0.append(r12);	 Catch:{ Exception -> 0x004e, all -> 0x004c }
        r3 = r0.toString();	 Catch:{ Exception -> 0x004e, all -> 0x004c }
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r0 = r9;
        r12 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ Exception -> 0x004e, all -> 0x004c }
        if (r12 == 0) goto L_0x0041;
    L_0x002a:
        r0 = a(r12);	 Catch:{ Exception -> 0x003f }
        if (r0 == 0) goto L_0x0041;
    L_0x0030:
        r1 = r0.size();	 Catch:{ Exception -> 0x003f }
        if (r1 <= 0) goto L_0x0041;
    L_0x0036:
        r1 = 0;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x003f }
        r0 = (com.xunlei.downloadprovider.homepage.recommend.b.b) r0;	 Catch:{ Exception -> 0x003f }
        r10 = r0;
        goto L_0x0041;
    L_0x003f:
        r0 = move-exception;
        goto L_0x0050;
    L_0x0041:
        if (r12 == 0) goto L_0x0046;
    L_0x0043:
        r12.close();
    L_0x0046:
        if (r9 == 0) goto L_0x005b;
    L_0x0048:
        r9.close();
        goto L_0x005b;
    L_0x004c:
        r0 = move-exception;
        goto L_0x005e;
    L_0x004e:
        r0 = move-exception;
        r12 = r10;
    L_0x0050:
        r0.printStackTrace();	 Catch:{ all -> 0x005c }
        if (r12 == 0) goto L_0x0058;
    L_0x0055:
        r12.close();
    L_0x0058:
        if (r9 == 0) goto L_0x005b;
    L_0x005a:
        goto L_0x0048;
    L_0x005b:
        return r10;
    L_0x005c:
        r0 = move-exception;
        r10 = r12;
    L_0x005e:
        if (r10 == 0) goto L_0x0063;
    L_0x0060:
        r10.close();
    L_0x0063:
        if (r9 == 0) goto L_0x0068;
    L_0x0065:
        r9.close();
    L_0x0068:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.recommend.b.a.a(java.lang.String):com.xunlei.downloadprovider.homepage.recommend.b.b");
    }

    static List<b> a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        List<b> arrayList = new ArrayList();
        try {
            int columnIndex = cursor.getColumnIndex(b);
            int columnIndex2 = cursor.getColumnIndex(c);
            int columnIndex3 = cursor.getColumnIndex(e);
            int columnIndex4 = cursor.getColumnIndex(d);
            int columnIndex5 = cursor.getColumnIndex(f);
            if (cursor.moveToFirst()) {
                while (!cursor.isAfterLast()) {
                    b bVar = new b();
                    if (columnIndex >= 0) {
                        bVar.a = cursor.getInt(columnIndex);
                    }
                    if (columnIndex2 >= 0) {
                        bVar.b = cursor.getString(columnIndex2);
                    }
                    if (columnIndex3 >= 0) {
                        bVar.d = cursor.getString(columnIndex3);
                    }
                    if (columnIndex4 >= 0) {
                        try {
                            bVar.c = com.xunlei.downloadprovider.h.k.a.c(cursor.getString(columnIndex4));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (columnIndex5 > 0) {
                        bVar.e = cursor.getString(columnIndex5);
                    }
                    arrayList.add(bVar);
                    cursor.moveToNext();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            cursor.close();
        }
        cursor.close();
        return arrayList;
    }
}
