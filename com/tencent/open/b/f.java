package com.tencent.open.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.tencent.open.utils.d;

/* compiled from: ProGuard */
public class f extends SQLiteOpenHelper {
    protected static final String[] a = new String[]{"key"};
    protected static f b;

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (b == null) {
                b = new f(d.a());
            }
            fVar = b;
        }
        return fVar;
    }

    public f(Context context) {
        super(context, "sdk_report.db", null, 2);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS via_cgi_report( _id INTEGER PRIMARY KEY,key TEXT,type TEXT,blob BLOB);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS via_cgi_report");
        onCreate(sQLiteDatabase);
    }

    public synchronized java.util.List<java.io.Serializable> a(java.lang.String r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r11 = this;
        monitor-enter(r11);
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x00ad }
        r0.<init>();	 Catch:{ all -> 0x00ad }
        r0 = java.util.Collections.synchronizedList(r0);	 Catch:{ all -> 0x00ad }
        r1 = android.text.TextUtils.isEmpty(r12);	 Catch:{ all -> 0x00ad }
        if (r1 == 0) goto L_0x0012;
    L_0x0010:
        monitor-exit(r11);
        return r0;
    L_0x0012:
        r1 = r11.getReadableDatabase();	 Catch:{ all -> 0x00ad }
        if (r1 != 0) goto L_0x001a;
    L_0x0018:
        monitor-exit(r11);
        return r0;
    L_0x001a:
        r10 = 0;
        r3 = "via_cgi_report";	 Catch:{ Exception -> 0x0090 }
        r4 = 0;	 Catch:{ Exception -> 0x0090 }
        r5 = "type = ?";	 Catch:{ Exception -> 0x0090 }
        r2 = 1;	 Catch:{ Exception -> 0x0090 }
        r6 = new java.lang.String[r2];	 Catch:{ Exception -> 0x0090 }
        r2 = 0;	 Catch:{ Exception -> 0x0090 }
        r6[r2] = r12;	 Catch:{ Exception -> 0x0090 }
        r7 = 0;	 Catch:{ Exception -> 0x0090 }
        r8 = 0;	 Catch:{ Exception -> 0x0090 }
        r9 = 0;	 Catch:{ Exception -> 0x0090 }
        r2 = r1;	 Catch:{ Exception -> 0x0090 }
        r12 = r2.query(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0090 }
        if (r12 == 0) goto L_0x0082;
    L_0x0030:
        r2 = r12.getCount();	 Catch:{ Exception -> 0x007f, all -> 0x007d }
        if (r2 <= 0) goto L_0x0082;	 Catch:{ Exception -> 0x007f, all -> 0x007d }
    L_0x0036:
        r12.moveToFirst();	 Catch:{ Exception -> 0x007f, all -> 0x007d }
    L_0x0039:
        r2 = "blob";	 Catch:{ Exception -> 0x007f, all -> 0x007d }
        r2 = r12.getColumnIndex(r2);	 Catch:{ Exception -> 0x007f, all -> 0x007d }
        r2 = r12.getBlob(r2);	 Catch:{ Exception -> 0x007f, all -> 0x007d }
        r3 = new java.io.ByteArrayInputStream;	 Catch:{ Exception -> 0x007f, all -> 0x007d }
        r3.<init>(r2);	 Catch:{ Exception -> 0x007f, all -> 0x007d }
        r2 = new java.io.ObjectInputStream;	 Catch:{ Exception -> 0x0067, all -> 0x005c }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0067, all -> 0x005c }
        r4 = r2.readObject();	 Catch:{ Exception -> 0x0068, all -> 0x005a }
        r4 = (java.io.Serializable) r4;	 Catch:{ Exception -> 0x0068, all -> 0x005a }
        r2.close();	 Catch:{ IOException -> 0x0056 }
    L_0x0056:
        r3.close();	 Catch:{ IOException -> 0x0071 }
        goto L_0x0071;
    L_0x005a:
        r4 = move-exception;
        goto L_0x005e;
    L_0x005c:
        r4 = move-exception;
        r2 = r10;
    L_0x005e:
        if (r2 == 0) goto L_0x0063;
    L_0x0060:
        r2.close();	 Catch:{ IOException -> 0x0063 }
    L_0x0063:
        r3.close();	 Catch:{ IOException -> 0x0066 }
    L_0x0066:
        throw r4;	 Catch:{ Exception -> 0x007f, all -> 0x007d }
    L_0x0067:
        r2 = r10;
    L_0x0068:
        if (r2 == 0) goto L_0x006d;
    L_0x006a:
        r2.close();	 Catch:{ IOException -> 0x006d }
    L_0x006d:
        r3.close();	 Catch:{ IOException -> 0x0070 }
    L_0x0070:
        r4 = r10;
    L_0x0071:
        if (r4 == 0) goto L_0x0076;
    L_0x0073:
        r0.add(r4);	 Catch:{ Exception -> 0x007f, all -> 0x007d }
    L_0x0076:
        r2 = r12.moveToNext();	 Catch:{ Exception -> 0x007f, all -> 0x007d }
        if (r2 != 0) goto L_0x0039;
    L_0x007c:
        goto L_0x0082;
    L_0x007d:
        r0 = move-exception;
        goto L_0x00a2;
    L_0x007f:
        r2 = move-exception;
        r10 = r12;
        goto L_0x0091;
    L_0x0082:
        if (r12 == 0) goto L_0x0087;
    L_0x0084:
        r12.close();	 Catch:{ all -> 0x00ad }
    L_0x0087:
        if (r1 == 0) goto L_0x00a0;	 Catch:{ all -> 0x00ad }
    L_0x0089:
        r1.close();	 Catch:{ all -> 0x00ad }
        goto L_0x00a0;
    L_0x008d:
        r0 = move-exception;
        r12 = r10;
        goto L_0x00a2;
    L_0x0090:
        r2 = move-exception;
    L_0x0091:
        r12 = "openSDK_LOG.ReportDatabaseHelper";	 Catch:{ all -> 0x008d }
        r3 = "getReportItemFromDB has exception.";	 Catch:{ all -> 0x008d }
        com.tencent.open.a.f.b(r12, r3, r2);	 Catch:{ all -> 0x008d }
        if (r10 == 0) goto L_0x009d;
    L_0x009a:
        r10.close();	 Catch:{ all -> 0x00ad }
    L_0x009d:
        if (r1 == 0) goto L_0x00a0;
    L_0x009f:
        goto L_0x0089;
    L_0x00a0:
        monitor-exit(r11);
        return r0;
    L_0x00a2:
        if (r12 == 0) goto L_0x00a7;
    L_0x00a4:
        r12.close();	 Catch:{ all -> 0x00ad }
    L_0x00a7:
        if (r1 == 0) goto L_0x00ac;	 Catch:{ all -> 0x00ad }
    L_0x00a9:
        r1.close();	 Catch:{ all -> 0x00ad }
    L_0x00ac:
        throw r0;	 Catch:{ all -> 0x00ad }
    L_0x00ad:
        r12 = move-exception;
        monitor-exit(r11);
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.f.a(java.lang.String):java.util.List<java.io.Serializable>");
    }

    public synchronized void a(java.lang.String r9, java.util.List<java.io.Serializable> r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        monitor-enter(r8);
        r0 = r10.size();	 Catch:{ all -> 0x00a4 }
        if (r0 != 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r8);
        return;
    L_0x0009:
        r1 = 20;
        if (r0 > r1) goto L_0x000e;
    L_0x000d:
        goto L_0x000f;
    L_0x000e:
        r0 = r1;
    L_0x000f:
        r1 = android.text.TextUtils.isEmpty(r9);	 Catch:{ all -> 0x00a4 }
        if (r1 == 0) goto L_0x0017;
    L_0x0015:
        monitor-exit(r8);
        return;
    L_0x0017:
        r8.b(r9);	 Catch:{ all -> 0x00a4 }
        r1 = r8.getWritableDatabase();	 Catch:{ all -> 0x00a4 }
        if (r1 != 0) goto L_0x0022;
    L_0x0020:
        monitor-exit(r8);
        return;
    L_0x0022:
        r1.beginTransaction();	 Catch:{ all -> 0x00a4 }
        r2 = new android.content.ContentValues;	 Catch:{ Exception -> 0x0088 }
        r2.<init>();	 Catch:{ Exception -> 0x0088 }
        r3 = 0;	 Catch:{ Exception -> 0x0088 }
    L_0x002b:
        if (r3 >= r0) goto L_0x0079;	 Catch:{ Exception -> 0x0088 }
    L_0x002d:
        r4 = r10.get(r3);	 Catch:{ Exception -> 0x0088 }
        r4 = (java.io.Serializable) r4;	 Catch:{ Exception -> 0x0088 }
        if (r4 == 0) goto L_0x0073;	 Catch:{ Exception -> 0x0088 }
    L_0x0035:
        r5 = "type";	 Catch:{ Exception -> 0x0088 }
        r2.put(r5, r9);	 Catch:{ Exception -> 0x0088 }
        r5 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0088 }
        r6 = 512; // 0x200 float:7.175E-43 double:2.53E-321;	 Catch:{ Exception -> 0x0088 }
        r5.<init>(r6);	 Catch:{ Exception -> 0x0088 }
        r6 = 0;
        r7 = new java.io.ObjectOutputStream;	 Catch:{ IOException -> 0x005e, all -> 0x0054 }
        r7.<init>(r5);	 Catch:{ IOException -> 0x005e, all -> 0x0054 }
        r7.writeObject(r4);	 Catch:{ IOException -> 0x005f, all -> 0x0051 }
        r7.close();	 Catch:{ IOException -> 0x004d }
    L_0x004d:
        r5.close();	 Catch:{ IOException -> 0x0065 }
        goto L_0x0065;
    L_0x0051:
        r9 = move-exception;
        r6 = r7;
        goto L_0x0055;
    L_0x0054:
        r9 = move-exception;
    L_0x0055:
        if (r6 == 0) goto L_0x005a;
    L_0x0057:
        r6.close();	 Catch:{ IOException -> 0x005a }
    L_0x005a:
        r5.close();	 Catch:{ IOException -> 0x005d }
    L_0x005d:
        throw r9;	 Catch:{ Exception -> 0x0088 }
    L_0x005e:
        r7 = r6;
    L_0x005f:
        if (r7 == 0) goto L_0x004d;
    L_0x0061:
        r7.close();	 Catch:{ IOException -> 0x004d }
        goto L_0x004d;
    L_0x0065:
        r4 = "blob";	 Catch:{ Exception -> 0x0088 }
        r5 = r5.toByteArray();	 Catch:{ Exception -> 0x0088 }
        r2.put(r4, r5);	 Catch:{ Exception -> 0x0088 }
        r4 = "via_cgi_report";	 Catch:{ Exception -> 0x0088 }
        r1.insert(r4, r6, r2);	 Catch:{ Exception -> 0x0088 }
    L_0x0073:
        r2.clear();	 Catch:{ Exception -> 0x0088 }
        r3 = r3 + 1;	 Catch:{ Exception -> 0x0088 }
        goto L_0x002b;	 Catch:{ Exception -> 0x0088 }
    L_0x0079:
        r1.setTransactionSuccessful();	 Catch:{ Exception -> 0x0088 }
        r1.endTransaction();	 Catch:{ all -> 0x00a4 }
        if (r1 == 0) goto L_0x0099;	 Catch:{ all -> 0x00a4 }
    L_0x0081:
        r1.close();	 Catch:{ all -> 0x00a4 }
        monitor-exit(r8);
        return;
    L_0x0086:
        r9 = move-exception;
        goto L_0x009b;
    L_0x0088:
        r9 = "openSDK_LOG.ReportDatabaseHelper";	 Catch:{ all -> 0x0086 }
        r10 = "saveReportItemToDB has exception.";	 Catch:{ all -> 0x0086 }
        com.tencent.open.a.f.e(r9, r10);	 Catch:{ all -> 0x0086 }
        r1.endTransaction();	 Catch:{ all -> 0x00a4 }
        if (r1 == 0) goto L_0x0099;	 Catch:{ all -> 0x00a4 }
    L_0x0094:
        r1.close();	 Catch:{ all -> 0x00a4 }
        monitor-exit(r8);
        return;
    L_0x0099:
        monitor-exit(r8);
        return;
    L_0x009b:
        r1.endTransaction();	 Catch:{ all -> 0x00a4 }
        if (r1 == 0) goto L_0x00a3;	 Catch:{ all -> 0x00a4 }
    L_0x00a0:
        r1.close();	 Catch:{ all -> 0x00a4 }
    L_0x00a3:
        throw r9;	 Catch:{ all -> 0x00a4 }
    L_0x00a4:
        r9 = move-exception;
        monitor-exit(r8);
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.f.a(java.lang.String, java.util.List):void");
    }

    public synchronized void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null) {
                try {
                    writableDatabase.delete("via_cgi_report", "type = ?", new String[]{str});
                    if (writableDatabase != null) {
                        writableDatabase.close();
                    }
                } catch (String str2) {
                    try {
                        com.tencent.open.a.f.b("openSDK_LOG.ReportDatabaseHelper", "clearReportItem has exception.", str2);
                        if (writableDatabase != null) {
                            writableDatabase.close();
                        }
                    } catch (Throwable th) {
                        if (writableDatabase != null) {
                            writableDatabase.close();
                        }
                    }
                }
            }
        }
    }
}
