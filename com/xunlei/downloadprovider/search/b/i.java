package com.xunlei.downloadprovider.search.b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.search.a.b;
import com.xunlei.downloadprovider.search.ui.search.SearchContentFragment;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SearchRecordDbHelper */
public class i extends SQLiteOpenHelper {
    private static i a;

    private i(Context context) {
        super(context, "xlsearch.db", null, 2);
    }

    public static i a() {
        if (a == null) {
            synchronized (i.class) {
                if (a == null) {
                    a = new i(BrothersApplication.getApplicationInstance());
                }
            }
        }
        return a;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists Search_Record_Tab (_id integer primary key autoincrement,searchContent text,searchSuffix text,searchTimestamp long ,searchKeywordTab int );");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS Search_Record_Tab");
        onCreate(sQLiteDatabase);
    }

    public final synchronized List<b> b() {
        List<b> arrayList;
        Exception e;
        Throwable th;
        arrayList = new ArrayList();
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = readableDatabase;
            Cursor query = sQLiteDatabase.query("Search_Record_Tab", new String[]{"searchContent", "searchTimestamp", "searchKeywordTab", "searchSuffix"}, null, null, null, null, "searchTimestamp DESC ");
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int columnIndex = query.getColumnIndex("searchContent");
                        int columnIndex2 = query.getColumnIndex("searchTimestamp");
                        int columnIndex3 = query.getColumnIndex("searchKeywordTab");
                        int columnIndex4 = query.getColumnIndex("searchSuffix");
                        do {
                            b bVar = new b();
                            String string = query.getString(columnIndex);
                            bVar.b = query.getLong(columnIndex2);
                            bVar.c = query.getInt(columnIndex3);
                            bVar.d = query.getString(columnIndex4);
                            bVar.a = string;
                            SearchContentFragment.class.getSimpleName();
                            StringBuilder stringBuilder = new StringBuilder("读取数据库  mType: ");
                            stringBuilder.append(bVar.c);
                            stringBuilder.append(" content :");
                            stringBuilder.append(string);
                            stringBuilder.append(" suffix:");
                            stringBuilder.append(bVar.d);
                            arrayList.add(bVar);
                        } while (query.moveToNext());
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = query;
                    try {
                        e.printStackTrace();
                        a(readableDatabase, cursor);
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                        query = cursor;
                        a(readableDatabase, query);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    a(readableDatabase, query);
                    throw th;
                }
            }
            a(readableDatabase, query);
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            a(readableDatabase, cursor);
            return arrayList;
        }
        return arrayList;
    }

    private static void a(SQLiteDatabase sQLiteDatabase, Cursor cursor) {
        a(sQLiteDatabase);
        if (cursor != null) {
            try {
                cursor.close();
            } catch (SQLiteDatabase sQLiteDatabase2) {
                sQLiteDatabase2.printStackTrace();
            }
        }
    }

    private static void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            try {
                sQLiteDatabase.close();
            } catch (SQLiteDatabase sQLiteDatabase2) {
                sQLiteDatabase2.printStackTrace();
            }
        }
    }

    public final synchronized void a(String str) {
        b bVar = new b();
        bVar.a = str;
        bVar.b = System.currentTimeMillis();
        bVar.c = null;
        a(bVar);
    }

    public final synchronized void a(String str, int i) {
        b bVar = new b();
        bVar.a = str;
        bVar.b = System.currentTimeMillis();
        bVar.c = i;
        a(bVar);
    }

    public final synchronized void a(String str, String str2) {
        b bVar = new b();
        bVar.a = str;
        bVar.d = str2;
        bVar.b = System.currentTimeMillis();
        bVar.c = null;
        a(bVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(com.xunlei.downloadprovider.search.a.b r20) {
        /*
        r19 = this;
        r1 = r20;
        monitor-enter(r19);
        r12 = r19.getReadableDatabase();	 Catch:{ all -> 0x0150 }
        r13 = 1;
        r14 = 0;
        r11 = 0;
        r5 = "Search_Record_Tab";
        r4 = 4;
        r6 = new java.lang.String[r4];	 Catch:{ Exception -> 0x00d9, all -> 0x00d4 }
        r4 = "searchContent";
        r6[r14] = r4;	 Catch:{ Exception -> 0x00d9, all -> 0x00d4 }
        r4 = "searchTimestamp";
        r6[r13] = r4;	 Catch:{ Exception -> 0x00d9, all -> 0x00d4 }
        r4 = 2;
        r7 = "searchKeywordTab";
        r6[r4] = r7;	 Catch:{ Exception -> 0x00d9, all -> 0x00d4 }
        r4 = 3;
        r7 = "searchSuffix";
        r6[r4] = r7;	 Catch:{ Exception -> 0x00d9, all -> 0x00d4 }
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r15 = "searchTimestamp DESC ";
        r4 = r12;
        r2 = r11;
        r11 = r15;
        r11 = r4.query(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x00d9, all -> 0x00d4 }
        if (r11 == 0) goto L_0x00d1;
    L_0x0030:
        r3 = r11.moveToFirst();	 Catch:{ Exception -> 0x00ce }
        if (r3 == 0) goto L_0x00d1;
    L_0x0036:
        r3 = "searchContent";
        r3 = r11.getColumnIndex(r3);	 Catch:{ Exception -> 0x00ce }
        r4 = "searchTimestamp";
        r4 = r11.getColumnIndex(r4);	 Catch:{ Exception -> 0x00ce }
        r5 = "searchKeywordTab";
        r5 = r11.getColumnIndex(r5);	 Catch:{ Exception -> 0x00ce }
        r6 = "searchSuffix";
        r6 = r11.getColumnIndex(r6);	 Catch:{ Exception -> 0x00ce }
        r16 = -1;
    L_0x0050:
        r7 = r11.getString(r3);	 Catch:{ Exception -> 0x00cb }
        r8 = r11.getLong(r4);	 Catch:{ Exception -> 0x00cb }
        r10 = r11.getInt(r5);	 Catch:{ Exception -> 0x00cb }
        r2 = r11.getString(r6);	 Catch:{ Exception -> 0x00cb }
        r14 = r1.c;	 Catch:{ Exception -> 0x00cb }
        if (r10 != r14) goto L_0x00c0;
    L_0x0064:
        r10 = r1.a;	 Catch:{ Exception -> 0x00cb }
        r10 = r7.equals(r10);	 Catch:{ Exception -> 0x00cb }
        if (r10 == 0) goto L_0x0075;
    L_0x006c:
        r10 = r1.d;	 Catch:{ Exception -> 0x00cb }
        r10 = r2.equals(r10);	 Catch:{ Exception -> 0x00cb }
        if (r10 == 0) goto L_0x0075;
    L_0x0074:
        goto L_0x00be;
    L_0x0075:
        r10 = r1.d;	 Catch:{ Exception -> 0x00cb }
        r10 = android.text.TextUtils.isEmpty(r10);	 Catch:{ Exception -> 0x00cb }
        if (r10 == 0) goto L_0x009a;
    L_0x007d:
        r10 = r1.a;	 Catch:{ Exception -> 0x00cb }
        r14 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00cb }
        r14.<init>();	 Catch:{ Exception -> 0x00cb }
        r14.append(r7);	 Catch:{ Exception -> 0x00cb }
        r13 = " ";
        r14.append(r13);	 Catch:{ Exception -> 0x00cb }
        r14.append(r2);	 Catch:{ Exception -> 0x00cb }
        r13 = r14.toString();	 Catch:{ Exception -> 0x00cb }
        r10 = r10.equals(r13);	 Catch:{ Exception -> 0x00cb }
        if (r10 == 0) goto L_0x009a;
    L_0x0099:
        goto L_0x00be;
    L_0x009a:
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Exception -> 0x00cb }
        if (r2 == 0) goto L_0x00c0;
    L_0x00a0:
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00cb }
        r2.<init>();	 Catch:{ Exception -> 0x00cb }
        r10 = r1.a;	 Catch:{ Exception -> 0x00cb }
        r2.append(r10);	 Catch:{ Exception -> 0x00cb }
        r10 = " ";
        r2.append(r10);	 Catch:{ Exception -> 0x00cb }
        r10 = r1.d;	 Catch:{ Exception -> 0x00cb }
        r2.append(r10);	 Catch:{ Exception -> 0x00cb }
        r2 = r2.toString();	 Catch:{ Exception -> 0x00cb }
        r2 = r7.equals(r2);	 Catch:{ Exception -> 0x00cb }
        if (r2 == 0) goto L_0x00c0;
    L_0x00be:
        r16 = r8;
    L_0x00c0:
        r2 = r11.moveToNext();	 Catch:{ Exception -> 0x00cb }
        if (r2 != 0) goto L_0x00c7;
    L_0x00c6:
        goto L_0x00e1;
    L_0x00c7:
        r2 = 0;
        r13 = 1;
        r14 = 0;
        goto L_0x0050;
    L_0x00cb:
        r0 = move-exception;
        r2 = r0;
        goto L_0x00de;
    L_0x00ce:
        r0 = move-exception;
        r2 = r0;
        goto L_0x00dc;
    L_0x00d1:
        r16 = -1;
        goto L_0x00e1;
    L_0x00d4:
        r0 = move-exception;
        r1 = r0;
        r11 = 0;
        goto L_0x014c;
    L_0x00d9:
        r0 = move-exception;
        r2 = r0;
        r11 = 0;
    L_0x00dc:
        r16 = -1;
    L_0x00de:
        r2.printStackTrace();	 Catch:{ all -> 0x014a }
    L_0x00e1:
        a(r12, r11);	 Catch:{ all -> 0x0150 }
        r2 = r16;
        r11 = r19.getWritableDatabase();	 Catch:{ Exception -> 0x013a, all -> 0x0135 }
        r4 = "Search_Record_Tab";
        r5 = "searchTimestamp=?";
        r6 = 1;
        r6 = new java.lang.String[r6];	 Catch:{ Exception -> 0x0132 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ Exception -> 0x0132 }
        r3 = 0;
        r6[r3] = r2;	 Catch:{ Exception -> 0x0132 }
        r11.delete(r4, r5, r6);	 Catch:{ Exception -> 0x0132 }
        r2 = new android.content.ContentValues;	 Catch:{ Exception -> 0x0132 }
        r2.<init>();	 Catch:{ Exception -> 0x0132 }
        r3 = "searchContent";
        r4 = r1.a;	 Catch:{ Exception -> 0x0132 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x0132 }
        r3 = "searchTimestamp";
        r4 = r1.b;	 Catch:{ Exception -> 0x0132 }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x0132 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x0132 }
        r3 = "searchSuffix";
        r4 = r1.d;	 Catch:{ Exception -> 0x0132 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x0132 }
        r3 = "searchKeywordTab";
        r1 = r1.c;	 Catch:{ Exception -> 0x0132 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Exception -> 0x0132 }
        r2.put(r3, r1);	 Catch:{ Exception -> 0x0132 }
        r1 = "Search_Record_Tab";
        r3 = 0;
        r11.insert(r1, r3, r2);	 Catch:{ Exception -> 0x0132 }
        a(r11);	 Catch:{ all -> 0x0150 }
        monitor-exit(r19);
        return;
    L_0x012f:
        r0 = move-exception;
        r1 = r0;
        goto L_0x0146;
    L_0x0132:
        r0 = move-exception;
        r1 = r0;
        goto L_0x013e;
    L_0x0135:
        r0 = move-exception;
        r3 = 0;
        r1 = r0;
        r11 = r3;
        goto L_0x0146;
    L_0x013a:
        r0 = move-exception;
        r3 = 0;
        r1 = r0;
        r11 = r3;
    L_0x013e:
        r1.printStackTrace();	 Catch:{ all -> 0x012f }
        a(r11);	 Catch:{ all -> 0x0150 }
        monitor-exit(r19);
        return;
    L_0x0146:
        a(r11);	 Catch:{ all -> 0x0150 }
        throw r1;	 Catch:{ all -> 0x0150 }
    L_0x014a:
        r0 = move-exception;
        r1 = r0;
    L_0x014c:
        a(r12, r11);	 Catch:{ all -> 0x0150 }
        throw r1;	 Catch:{ all -> 0x0150 }
    L_0x0150:
        r0 = move-exception;
        r1 = r0;
        monitor-exit(r19);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.search.b.i.a(com.xunlei.downloadprovider.search.a.b):void");
    }

    public final synchronized void c() {
        SQLiteDatabase writableDatabase;
        Exception e;
        Throwable th;
        try {
            writableDatabase = getWritableDatabase();
            try {
                writableDatabase.delete("Search_Record_Tab", null, null);
                a(writableDatabase);
            } catch (Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    a(writableDatabase);
                } catch (Throwable th2) {
                    th = th2;
                    a(writableDatabase);
                    throw th;
                }
            }
        } catch (Exception e3) {
            Exception exception = e3;
            writableDatabase = null;
            e = exception;
            e.printStackTrace();
            a(writableDatabase);
        } catch (Throwable th3) {
            Throwable th4 = th3;
            writableDatabase = null;
            th = th4;
            a(writableDatabase);
            throw th;
        }
    }
}
