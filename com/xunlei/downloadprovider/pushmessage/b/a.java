package com.xunlei.downloadprovider.pushmessage.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;

/* compiled from: NewPushMsgDatabase */
public class a extends SQLiteOpenHelper {
    private static final String a = "a";
    private static a b;

    private a(Context context) {
        super(context, "NewPushMsgDB", null, 1);
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (b == null) {
                b = new a(BrothersApplication.getApplicationInstance());
            }
            aVar = b;
        }
        return aVar;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("create table if not exists newpushmsg ( id integer primary key autoincrement, msgid text UNIQUE, content text )");
        } catch (SQLiteDatabase sQLiteDatabase2) {
            sQLiteDatabase2.getMessage();
            sQLiteDatabase2.printStackTrace();
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            sQLiteDatabase.execSQL("drop table if exists newpushmsg");
        } catch (int i3) {
            i3.printStackTrace();
        }
        onCreate(sQLiteDatabase);
    }

    public final synchronized boolean a(java.lang.String r8, java.lang.String r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        monitor-enter(r7);
        r0 = 0;
        r1 = 0;
        r2 = r7.getWritableDatabase();	 Catch:{ Exception -> 0x0030, all -> 0x0028 }
        r0 = r7.a(r8, r2);	 Catch:{ Exception -> 0x0031, all -> 0x0026 }
        r3 = r7.a(r2);	 Catch:{ Exception -> 0x0032, all -> 0x0026 }
        r5 = 100;	 Catch:{ Exception -> 0x0032, all -> 0x0026 }
        r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));	 Catch:{ Exception -> 0x0032, all -> 0x0026 }
        if (r1 <= 0) goto L_0x0018;	 Catch:{ Exception -> 0x0032, all -> 0x0026 }
    L_0x0015:
        r7.b(r2);	 Catch:{ Exception -> 0x0032, all -> 0x0026 }
    L_0x0018:
        if (r0 != 0) goto L_0x0023;	 Catch:{ Exception -> 0x0032, all -> 0x0026 }
    L_0x001a:
        r1 = android.text.TextUtils.isEmpty(r9);	 Catch:{ Exception -> 0x0032, all -> 0x0026 }
        if (r1 != 0) goto L_0x0023;	 Catch:{ Exception -> 0x0032, all -> 0x0026 }
    L_0x0020:
        r7.a(r8, r9, r2);	 Catch:{ Exception -> 0x0032, all -> 0x0026 }
    L_0x0023:
        if (r2 == 0) goto L_0x003b;
    L_0x0025:
        goto L_0x0034;
    L_0x0026:
        r8 = move-exception;
        goto L_0x002a;
    L_0x0028:
        r8 = move-exception;
        r2 = r0;
    L_0x002a:
        if (r2 == 0) goto L_0x002f;
    L_0x002c:
        r2.close();	 Catch:{ all -> 0x0038 }
    L_0x002f:
        throw r8;	 Catch:{ all -> 0x0038 }
    L_0x0030:
        r2 = r0;	 Catch:{ all -> 0x0038 }
    L_0x0031:
        r0 = r1;	 Catch:{ all -> 0x0038 }
    L_0x0032:
        if (r2 == 0) goto L_0x003b;	 Catch:{ all -> 0x0038 }
    L_0x0034:
        r2.close();	 Catch:{ all -> 0x0038 }
        goto L_0x003b;
    L_0x0038:
        r8 = move-exception;
        monitor-exit(r7);
        throw r8;
    L_0x003b:
        monitor-exit(r7);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.pushmessage.b.a.a(java.lang.String, java.lang.String):boolean");
    }

    private synchronized long a(android.database.sqlite.SQLiteDatabase r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = 0;
        r2 = 0;
        r3 = "select count(*)from newpushmsg";	 Catch:{ Exception -> 0x0023, all -> 0x001b }
        r5 = r5.rawQuery(r3, r2);	 Catch:{ Exception -> 0x0023, all -> 0x001b }
        r5.moveToFirst();	 Catch:{ Exception -> 0x0024, all -> 0x0019 }
        r2 = 0;	 Catch:{ Exception -> 0x0024, all -> 0x0019 }
        r2 = r5.getLong(r2);	 Catch:{ Exception -> 0x0024, all -> 0x0019 }
        if (r5 == 0) goto L_0x0017;
    L_0x0014:
        r5.close();	 Catch:{ all -> 0x002a }
    L_0x0017:
        r0 = r2;	 Catch:{ all -> 0x002a }
        goto L_0x002d;	 Catch:{ all -> 0x002a }
    L_0x0019:
        r0 = move-exception;	 Catch:{ all -> 0x002a }
        goto L_0x001d;	 Catch:{ all -> 0x002a }
    L_0x001b:
        r0 = move-exception;	 Catch:{ all -> 0x002a }
        r5 = r2;	 Catch:{ all -> 0x002a }
    L_0x001d:
        if (r5 == 0) goto L_0x0022;	 Catch:{ all -> 0x002a }
    L_0x001f:
        r5.close();	 Catch:{ all -> 0x002a }
    L_0x0022:
        throw r0;	 Catch:{ all -> 0x002a }
    L_0x0023:
        r5 = r2;	 Catch:{ all -> 0x002a }
    L_0x0024:
        if (r5 == 0) goto L_0x002d;	 Catch:{ all -> 0x002a }
    L_0x0026:
        r5.close();	 Catch:{ all -> 0x002a }
        goto L_0x002d;
    L_0x002a:
        r5 = move-exception;
        monitor-exit(r4);
        throw r5;
    L_0x002d:
        monitor-exit(r4);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.pushmessage.b.a.a(android.database.sqlite.SQLiteDatabase):long");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean a(java.lang.String r12, android.database.sqlite.SQLiteDatabase r13) {
        /*
        r11 = this;
        monitor-enter(r11);
        r0 = 0;
        r1 = 0;
        r3 = "newpushmsg";
        r10 = 1;
        r4 = new java.lang.String[r10];	 Catch:{ Exception -> 0x003a }
        r2 = "*";
        r4[r1] = r2;	 Catch:{ Exception -> 0x003a }
        r5 = "msgid=?";
        r6 = new java.lang.String[r10];	 Catch:{ Exception -> 0x003a }
        r6[r1] = r12;	 Catch:{ Exception -> 0x003a }
        r7 = 0;
        r8 = 0;
        r9 = "id desc";
        r2 = r13;
        r12 = r2.query(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x003a }
        if (r12 == 0) goto L_0x0031;
    L_0x001d:
        r13 = r12.getCount();	 Catch:{ Exception -> 0x002e, all -> 0x002b }
        if (r13 > 0) goto L_0x0024;
    L_0x0023:
        goto L_0x0031;
    L_0x0024:
        if (r12 == 0) goto L_0x0029;
    L_0x0026:
        r12.close();	 Catch:{ all -> 0x004b }
    L_0x0029:
        monitor-exit(r11);
        return r10;
    L_0x002b:
        r13 = move-exception;
        r0 = r12;
        goto L_0x0045;
    L_0x002e:
        r13 = move-exception;
        r0 = r12;
        goto L_0x003b;
    L_0x0031:
        if (r12 == 0) goto L_0x0036;
    L_0x0033:
        r12.close();	 Catch:{ all -> 0x004b }
    L_0x0036:
        monitor-exit(r11);
        return r1;
    L_0x0038:
        r13 = move-exception;
        goto L_0x0045;
    L_0x003a:
        r13 = move-exception;
    L_0x003b:
        r13.printStackTrace();	 Catch:{ all -> 0x0038 }
        if (r0 == 0) goto L_0x0043;
    L_0x0040:
        r0.close();	 Catch:{ all -> 0x004b }
    L_0x0043:
        monitor-exit(r11);
        return r1;
    L_0x0045:
        if (r0 == 0) goto L_0x004d;
    L_0x0047:
        r0.close();	 Catch:{ all -> 0x004b }
        goto L_0x004d;
    L_0x004b:
        r12 = move-exception;
        goto L_0x004e;
    L_0x004d:
        throw r13;	 Catch:{ all -> 0x004b }
    L_0x004e:
        monitor-exit(r11);
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.pushmessage.b.a.a(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
    }

    private synchronized void a(String str, String str2, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MessageInfo.MSGID, str);
        contentValues.put("content", str2);
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.insert("newpushmsg", null, contentValues);
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        } catch (String str3) {
            try {
                str3.printStackTrace();
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
            }
        }
    }

    private synchronized void b(android.database.sqlite.SQLiteDatabase r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = "DELETE FROM newpushmsg";	 Catch:{ Exception -> 0x000b, all -> 0x0008 }
        r2.execSQL(r0);	 Catch:{ Exception -> 0x000b, all -> 0x0008 }
        monitor-exit(r1);
        return;
    L_0x0008:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
    L_0x000b:
        monitor-exit(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.pushmessage.b.a.b(android.database.sqlite.SQLiteDatabase):void");
    }

    public void close() {
        super.close();
    }
}
