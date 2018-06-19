package com.xunlei.analytics.dbstore;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.xunlei.analytics.c.e;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class a {
    private static volatile a d;
    private static AtomicBoolean e = new AtomicBoolean(false);
    SQLiteDatabase a;
    private a b;
    private int c;

    private a() {
        this.a = null;
        this.b = new a(this, com.xunlei.analytics.config.a.d());
        this.a = this.b.getReadableDatabase();
    }

    public static a a() {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a();
                }
            }
        }
        return d;
    }

    private void a(java.lang.Exception r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = new java.lang.StringBuilder;
        r1 = "Exception: ";
        r0.<init>(r1);
        r1 = android.util.Log.getStackTraceString(r5);
        r0.append(r1);
        r0 = r0.toString();
        com.xunlei.analytics.c.e.a(r0);
        r0 = e;
        r1 = 1;
        r2 = 0;
        r0 = r0.compareAndSet(r2, r1);
        if (r0 == 0) goto L_0x0071;
    L_0x001f:
        r0 = r4.c;	 Catch:{ Exception -> 0x0062 }
        r3 = 5;	 Catch:{ Exception -> 0x0062 }
        if (r0 <= r3) goto L_0x002b;	 Catch:{ Exception -> 0x0062 }
    L_0x0024:
        r0 = android.os.Process.myPid();	 Catch:{ Exception -> 0x0062 }
        android.os.Process.killProcess(r0);	 Catch:{ Exception -> 0x0062 }
    L_0x002b:
        r0 = r4.a;	 Catch:{ Exception -> 0x0062 }
        if (r0 == 0) goto L_0x0039;
    L_0x002f:
        r0 = r4.a;	 Catch:{ Exception -> 0x0035 }
        r0.close();	 Catch:{ Exception -> 0x0035 }
        goto L_0x0039;
    L_0x0035:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ Exception -> 0x0062 }
    L_0x0039:
        r0 = r4.b;	 Catch:{ Exception -> 0x0062 }
        if (r0 == 0) goto L_0x0047;
    L_0x003d:
        r0 = r4.b;	 Catch:{ Exception -> 0x0043 }
        r0.close();	 Catch:{ Exception -> 0x0043 }
        goto L_0x0047;
    L_0x0043:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ Exception -> 0x0062 }
    L_0x0047:
        r0 = new com.xunlei.analytics.dbstore.a$a;	 Catch:{ Exception -> 0x0062 }
        r3 = com.xunlei.analytics.config.a.d();	 Catch:{ Exception -> 0x0062 }
        r0.<init>(r4, r3);	 Catch:{ Exception -> 0x0062 }
        r4.b = r0;	 Catch:{ Exception -> 0x0062 }
        r0 = r4.b;	 Catch:{ Exception -> 0x0062 }
        r0 = r0.getReadableDatabase();	 Catch:{ Exception -> 0x0062 }
        r4.a = r0;	 Catch:{ Exception -> 0x0062 }
    L_0x005a:
        r5 = e;
        r5.set(r2);
        return;
    L_0x0060:
        r5 = move-exception;
        goto L_0x006b;
    L_0x0062:
        r5.printStackTrace();	 Catch:{ all -> 0x0060 }
        r5 = r4.c;	 Catch:{ all -> 0x0060 }
        r5 = r5 + r1;	 Catch:{ all -> 0x0060 }
        r4.c = r5;	 Catch:{ all -> 0x0060 }
        goto L_0x005a;
    L_0x006b:
        r0 = e;
        r0.set(r2);
        throw r5;
    L_0x0071:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.analytics.dbstore.a.a(java.lang.Exception):void");
    }

    private void b(String str, String str2, String str3) {
        if (e.a()) {
            StringBuilder stringBuilder = new StringBuilder("insert event Appid=");
            stringBuilder.append(str);
            stringBuilder.append(",InterId=");
            stringBuilder.append(str2);
            stringBuilder.append(",mEventData=");
            stringBuilder.append(str3);
            e.a(stringBuilder.toString());
        }
    }

    public int a(long j) {
        try {
            return this.a.delete(AnalyticsConstant.STORAGE_DB_TABLE_NAME, "_eventTime< ?", new String[]{String.valueOf(j)});
        } catch (Exception e) {
            a(e);
            return 0;
        }
    }

    public List<b> a(int i) {
        Cursor cursor;
        Exception exception;
        Throwable th;
        Throwable th2;
        try {
            SQLiteDatabase sQLiteDatabase = this.a;
            String str = AnalyticsConstant.STORAGE_DB_TABLE_NAME;
            String[] strArr = new String[]{com.xunlei.analytics.dbstore.AnalyticsConstant.a.a, com.xunlei.analytics.dbstore.AnalyticsConstant.a.b, com.xunlei.analytics.dbstore.AnalyticsConstant.a.c, com.xunlei.analytics.dbstore.AnalyticsConstant.a.d, "_id"};
            StringBuilder stringBuilder = new StringBuilder("0,");
            stringBuilder.append(i);
            Cursor query = sQLiteDatabase.query(str, strArr, null, null, null, null, "_id desc ", stringBuilder.toString());
            if (query != null) {
                try {
                    List arrayList = new ArrayList();
                    while (query.moveToNext()) {
                        b bVar = new b(query.getString(0), query.getString(1), query.getString(2));
                        bVar.d = query.getInt(4);
                        arrayList.add(bVar);
                    }
                    arrayList.trimToSize();
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                } catch (Exception e) {
                    cursor = query;
                    exception = e;
                    try {
                        a(exception);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                        th2 = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th2;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    cursor = query;
                    th2 = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th2;
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Exception e2) {
            exception = e2;
            cursor = null;
            a(exception);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th5) {
            th2 = th5;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public boolean a(b bVar) {
        try {
            this.a.execSQL("insert into analytics(_appId,_interId,_eventData,_eventTime)values(?,?,?,?)", new Object[]{bVar.a, bVar.b, bVar.c, Long.valueOf(System.currentTimeMillis())});
            com.xunlei.analytics.a.a.a().a(false);
            return true;
        } catch (Exception e) {
            a(e);
            return false;
        }
    }

    public boolean a(String str, String str2, String str3) {
        try {
            this.a.execSQL("insert into analytics(_appId,_interId,_eventData,_eventTime)values(?,?,?,?)", new Object[]{str, str2, str3, Long.valueOf(System.currentTimeMillis())});
            b(str, str2, str3);
            com.xunlei.analytics.a.a.a().a(false);
            return true;
        } catch (Exception e) {
            a(e);
            return false;
        }
    }

    public boolean a(List<b> list) {
        try {
            this.a.beginTransaction();
            for (b bVar : list) {
                this.a.execSQL("insert into analytics(_appId,_interId,_eventData,_eventTime)values(?,?,?,?)", new Object[]{bVar.a, bVar.b, bVar.c, Long.valueOf(System.currentTimeMillis())});
                com.xunlei.analytics.a.a.a().a(false);
            }
            this.a.setTransactionSuccessful();
            this.a.endTransaction();
            return true;
        } catch (Exception e) {
            a(e);
            return false;
        }
    }

    public boolean a(Integer... numArr) {
        try {
            if (numArr.length > 0) {
                this.a.beginTransaction();
                for (Integer intValue : numArr) {
                    int intValue2 = intValue.intValue();
                    this.a.execSQL("delete from analytics where _id= ?", new Object[]{Integer.valueOf(intValue2)});
                }
                this.a.setTransactionSuccessful();
                this.a.endTransaction();
                return true;
            }
        } catch (Exception e) {
            a(e);
        }
        return false;
    }

    public int b() {
        Exception exception;
        Throwable th;
        Cursor cursor = null;
        int i = 0;
        try {
            Cursor rawQuery = this.a.rawQuery("select count(*) from analytics", null);
            if (rawQuery != null) {
                try {
                    if (rawQuery.moveToFirst()) {
                        i = rawQuery.getInt(0);
                    }
                } catch (Exception e) {
                    Cursor cursor2 = rawQuery;
                    exception = e;
                    cursor = cursor2;
                    try {
                        a(exception);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return i;
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor = rawQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
                return i;
            }
        } catch (Exception e2) {
            exception = e2;
            a(exception);
            if (cursor != null) {
                cursor.close();
            }
            return i;
        }
        return i;
    }

    public boolean b(List<b> list) {
        try {
            if (list.size() > 0) {
                this.a.beginTransaction();
                for (b bVar : list) {
                    this.a.execSQL("delete from analytics where _id= ?", new Object[]{Integer.valueOf(bVar.d)});
                    StringBuilder stringBuilder = new StringBuilder("delete event ");
                    stringBuilder.append(bVar.toString());
                    e.a(stringBuilder.toString());
                }
                this.a.setTransactionSuccessful();
                this.a.endTransaction();
                return true;
            }
        } catch (Exception e) {
            a(e);
        }
        return false;
    }
}
