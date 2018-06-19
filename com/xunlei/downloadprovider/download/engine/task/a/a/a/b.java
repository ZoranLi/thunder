package com.xunlei.downloadprovider.download.engine.task.a.a.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xunlei.download.Downloads.Impl;
import com.xunlei.downloadprovider.app.BrothersApplication;
import org.android.agoo.common.AgooConstants;

/* compiled from: ThunderTaskDatabase */
public final class b extends SQLiteOpenHelper {
    private static b b;
    public final b a = new b();
    private boolean c = null;
    private final a d = new a();

    /* compiled from: ThunderTaskDatabase */
    public static class a extends a {
        static final String[][] c;
        private static String d = "task_consume";
        private static String e = "";

        static {
            String[][] strArr = new String[1][];
            strArr[0] = new String[]{AgooConstants.MESSAGE_TASK_ID, "INTEGER NOT NULL PRIMARY KEY"};
            c = strArr;
        }

        public a() {
            super(4, 4);
        }

        public static void a(SQLiteDatabase sQLiteDatabase) {
            String a;
            if (TextUtils.isEmpty(e)) {
                a = a(d, c);
                e = a;
            } else {
                a = e;
            }
            sQLiteDatabase.execSQL(a);
        }
    }

    /* compiled from: ThunderTaskDatabase */
    public static class b extends a {
        static final String[][] c;
        static String d = "task_extra";
        private static String e = "";

        static {
            r0 = new String[14][];
            r0[0] = new String[]{AgooConstants.MESSAGE_TASK_ID, "INTEGER NOT NULL PRIMARY KEY"};
            r0[1] = new String[]{"url", "TEXT"};
            r0[2] = new String[]{Impl.COLUMN_REFERER, "TEXT"};
            r0[3] = new String[]{"cid", "TEXT"};
            r0[4] = new String[]{"gcid", "TEXT"};
            r0[5] = new String[]{"info_hash", "TEXT"};
            r0[6] = new String[]{"create_origin", "TEXT"};
            r0[7] = new String[]{"task_report_value", "INTEGER DEFAULT 0"};
            r0[8] = new String[]{"seen", "INTEGER DEFAULT 0"};
            r0[9] = new String[]{"max_speed", "INTEGER DEFAULT 0"};
            r0[10] = new String[]{"sniff_key_word", "TEXT"};
            r0[11] = new String[]{"website_name", "TEXT"};
            r0[12] = new String[]{"icon_url", "TEXT"};
            r0[13] = new String[]{SocializeProtocolConstants.DISPLAY_NAME, "TEXT"};
            c = r0;
        }

        public b() {
            super(1, 6);
        }

        public static void a(SQLiteDatabase sQLiteDatabase) {
            String a;
            if (TextUtils.isEmpty(e)) {
                a = a(d, c);
                e = a;
            } else {
                a = e;
            }
            sQLiteDatabase.execSQL(a);
        }
    }

    private b(Context context, String str) {
        super(context, str, null, 6);
    }

    public static b a() {
        if (b == null) {
            b = new b(BrothersApplication.getApplicationInstance().getApplicationContext(), "thunder_tasks.db");
        }
        return b;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.c = true;
        b.a(sQLiteDatabase);
        a.a(sQLiteDatabase);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.xunlei.downloadprovider.download.engine.task.info.TaskExtraInfo a(long r7) {
        /*
        r6 = this;
        monitor-enter(r6);
        r0 = 0;
        r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1));
        r0 = 0;
        if (r2 >= 0) goto L_0x000a;
    L_0x0008:
        monitor-exit(r6);
        return r0;
    L_0x000a:
        monitor-enter(r6);	 Catch:{ all -> 0x010c }
        r1 = r6.getReadableDatabase();	 Catch:{ Exception -> 0x0013 }
        goto L_0x0018;
    L_0x0010:
        r7 = move-exception;
        goto L_0x010a;
    L_0x0013:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ all -> 0x0010 }
        r1 = r0;
    L_0x0018:
        if (r1 == 0) goto L_0x0106;
    L_0x001a:
        r2 = "SELECT url,referer,cid,gcid,info_hash,create_origin,seen,max_speed,sniff_key_word,website_name,icon_url,display_name FROM `task_extra` WHERE task_id=?";
        r3 = 1;
        r3 = new java.lang.String[r3];	 Catch:{ Exception -> 0x00ec }
        r4 = 0;
        r5 = java.lang.String.valueOf(r7);	 Catch:{ Exception -> 0x00ec }
        r3[r4] = r5;	 Catch:{ Exception -> 0x00ec }
        r1 = r1.rawQuery(r2, r3);	 Catch:{ Exception -> 0x00ec }
        r2 = r1.moveToNext();	 Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
        if (r2 == 0) goto L_0x00c9;
    L_0x0030:
        r2 = new com.xunlei.downloadprovider.download.engine.task.info.TaskExtraInfo;	 Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
        r2.<init>();	 Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
        r2.mTaskId = r7;	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r7 = "url";
        r7 = r1.getColumnIndex(r7);	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r7 = r1.getString(r7);	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r2.mUrl = r7;	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r7 = "cid";
        r7 = r1.getColumnIndex(r7);	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r7 = r1.getString(r7);	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r2.mCID = r7;	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r7 = "gcid";
        r7 = r1.getColumnIndex(r7);	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r7 = r1.getString(r7);	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r2.mGCID = r7;	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r7 = "info_hash";
        r7 = r1.getColumnIndex(r7);	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r7 = r1.getString(r7);	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r2.mInfoHash = r7;	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r7 = "referer";
        r7 = r1.getColumnIndex(r7);	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r7 = r1.getString(r7);	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r2.mRefUrl = r7;	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r7 = "create_origin";
        r7 = r1.getColumnIndex(r7);	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r7 = r1.getString(r7);	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r2.mCreateOrigin = r7;	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r7 = "seen";
        r7 = r1.getColumnIndex(r7);	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r7 = r1.getInt(r7);	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r2.mSeen = r7;	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r7 = "max_speed";
        r7 = r1.getColumnIndex(r7);	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r7 = r1.getInt(r7);	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r7 = (long) r7;	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r2.mMaxDownloadSpeed = r7;	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r7 = "sniff_key_word";
        r7 = r1.getColumnIndex(r7);	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r7 = r1.getString(r7);	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r2.mSniffKeyword = r7;	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r7 = "website_name";
        r7 = r1.getColumnIndex(r7);	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r7 = r1.getString(r7);	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r2.mWebsiteName = r7;	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r7 = "icon_url";
        r7 = r1.getColumnIndex(r7);	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r7 = r1.getString(r7);	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r2.mIconUrl = r7;	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r7 = "display_name";
        r7 = r1.getColumnIndex(r7);	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r7 = r1.getString(r7);	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        r2.mDisplayName = r7;	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        goto L_0x00ca;
    L_0x00c9:
        r2 = r0;
    L_0x00ca:
        r7 = r1.isClosed();	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        if (r7 != 0) goto L_0x00d4;
    L_0x00d0:
        r1.close();	 Catch:{ Exception -> 0x00e1, all -> 0x00e3 }
        goto L_0x00d5;
    L_0x00d4:
        r0 = r1;
    L_0x00d5:
        if (r0 == 0) goto L_0x0107;
    L_0x00d7:
        r7 = r0.isClosed();	 Catch:{ all -> 0x0010 }
        if (r7 != 0) goto L_0x0107;
    L_0x00dd:
        r0.close();	 Catch:{ all -> 0x0010 }
        goto L_0x0107;
    L_0x00e1:
        r7 = move-exception;
        goto L_0x00e7;
    L_0x00e3:
        r7 = move-exception;
        goto L_0x00fa;
    L_0x00e5:
        r7 = move-exception;
        r2 = r0;
    L_0x00e7:
        r0 = r1;
        goto L_0x00ee;
    L_0x00e9:
        r7 = move-exception;
        r1 = r0;
        goto L_0x00fa;
    L_0x00ec:
        r7 = move-exception;
        r2 = r0;
    L_0x00ee:
        r7.printStackTrace();	 Catch:{ all -> 0x00e9 }
        if (r0 == 0) goto L_0x0107;
    L_0x00f3:
        r7 = r0.isClosed();	 Catch:{ all -> 0x0010 }
        if (r7 != 0) goto L_0x0107;
    L_0x00f9:
        goto L_0x00dd;
    L_0x00fa:
        if (r1 == 0) goto L_0x0105;
    L_0x00fc:
        r8 = r1.isClosed();	 Catch:{ all -> 0x0010 }
        if (r8 != 0) goto L_0x0105;
    L_0x0102:
        r1.close();	 Catch:{ all -> 0x0010 }
    L_0x0105:
        throw r7;	 Catch:{ all -> 0x0010 }
    L_0x0106:
        r2 = r0;
    L_0x0107:
        monitor-exit(r6);	 Catch:{ all -> 0x0010 }
        monitor-exit(r6);
        return r2;
    L_0x010a:
        monitor-exit(r6);	 Catch:{ all -> 0x0010 }
        throw r7;	 Catch:{ all -> 0x010c }
    L_0x010c:
        r7 = move-exception;
        monitor-exit(r6);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.engine.task.a.a.a.b.a(long):com.xunlei.downloadprovider.download.engine.task.info.TaskExtraInfo");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized long a(com.xunlei.downloadprovider.download.engine.task.info.TaskExtraInfo r9) {
        /*
        r8 = this;
        monitor-enter(r8);
        r0 = -1;
        if (r9 == 0) goto L_0x0095;
    L_0x0005:
        r2 = r9.mTaskId;	 Catch:{ all -> 0x0092 }
        r4 = 0;
        r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r6 >= 0) goto L_0x000f;
    L_0x000d:
        goto L_0x0095;
    L_0x000f:
        r2 = new android.content.ContentValues;	 Catch:{ all -> 0x0092 }
        r2.<init>();	 Catch:{ all -> 0x0092 }
        r3 = "url";
        r4 = r9.mUrl;	 Catch:{ all -> 0x0092 }
        r2.put(r3, r4);	 Catch:{ all -> 0x0092 }
        r3 = "referer";
        r4 = r9.mRefUrl;	 Catch:{ all -> 0x0092 }
        r2.put(r3, r4);	 Catch:{ all -> 0x0092 }
        r3 = "cid";
        r4 = r9.mCID;	 Catch:{ all -> 0x0092 }
        r2.put(r3, r4);	 Catch:{ all -> 0x0092 }
        r3 = "gcid";
        r4 = r9.mGCID;	 Catch:{ all -> 0x0092 }
        r2.put(r3, r4);	 Catch:{ all -> 0x0092 }
        r3 = "info_hash";
        r4 = r9.mInfoHash;	 Catch:{ all -> 0x0092 }
        r2.put(r3, r4);	 Catch:{ all -> 0x0092 }
        r3 = "create_origin";
        r4 = r9.mCreateOrigin;	 Catch:{ all -> 0x0092 }
        r2.put(r3, r4);	 Catch:{ all -> 0x0092 }
        r3 = "seen";
        r4 = r9.mSeen;	 Catch:{ all -> 0x0092 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ all -> 0x0092 }
        r2.put(r3, r4);	 Catch:{ all -> 0x0092 }
        r3 = "sniff_key_word";
        r4 = r9.mSniffKeyword;	 Catch:{ all -> 0x0092 }
        r2.put(r3, r4);	 Catch:{ all -> 0x0092 }
        r3 = "website_name";
        r4 = r9.mWebsiteName;	 Catch:{ all -> 0x0092 }
        r2.put(r3, r4);	 Catch:{ all -> 0x0092 }
        r3 = "icon_url";
        r4 = r9.mIconUrl;	 Catch:{ all -> 0x0092 }
        r2.put(r3, r4);	 Catch:{ all -> 0x0092 }
        r3 = "display_name";
        r4 = r9.mDisplayName;	 Catch:{ all -> 0x0092 }
        r2.put(r3, r4);	 Catch:{ all -> 0x0092 }
        monitor-enter(r8);	 Catch:{ all -> 0x0092 }
        r3 = 0;
        r4 = r8.getWritableDatabase();	 Catch:{ Exception -> 0x006e }
        goto L_0x0073;
    L_0x006c:
        r9 = move-exception;
        goto L_0x0090;
    L_0x006e:
        r4 = move-exception;
        r4.printStackTrace();	 Catch:{ all -> 0x006c }
        r4 = r3;
    L_0x0073:
        if (r4 == 0) goto L_0x008d;
    L_0x0075:
        r5 = "task_id";
        r6 = r9.mTaskId;	 Catch:{ Exception -> 0x0089 }
        r9 = java.lang.Long.valueOf(r6);	 Catch:{ Exception -> 0x0089 }
        r2.put(r5, r9);	 Catch:{ Exception -> 0x0089 }
        r9 = "task_extra";
        r2 = r4.replace(r9, r3, r2);	 Catch:{ Exception -> 0x0089 }
        r9 = (int) r2;
        r0 = (long) r9;
        goto L_0x008d;
    L_0x0089:
        r9 = move-exception;
        r9.printStackTrace();	 Catch:{ all -> 0x006c }
    L_0x008d:
        monitor-exit(r8);	 Catch:{ all -> 0x006c }
        monitor-exit(r8);
        return r0;
    L_0x0090:
        monitor-exit(r8);	 Catch:{ all -> 0x006c }
        throw r9;	 Catch:{ all -> 0x0092 }
    L_0x0092:
        r9 = move-exception;
        monitor-exit(r8);
        throw r9;
    L_0x0095:
        monitor-exit(r8);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.engine.task.a.a.a.b.a(com.xunlei.downloadprovider.download.engine.task.info.TaskExtraInfo):long");
    }

    public final synchronized long a(long j, long j2, boolean z) {
        Exception e;
        long j3 = -1;
        if (j < 0) {
            return -1;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("max_speed", Long.valueOf(j2));
        synchronized (this) {
            SQLiteDatabase writableDatabase;
            try {
                writableDatabase = getWritableDatabase();
                try {
                    Cursor rawQuery = writableDatabase.rawQuery("SELECT url FROM `task_extra` WHERE task_id=?", new String[]{String.valueOf(j)});
                    if (rawQuery.moveToFirst()) {
                        z = false;
                    }
                    rawQuery.close();
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (writableDatabase != null) {
                        if (z) {
                            try {
                                contentValues.put(AgooConstants.MESSAGE_TASK_ID, Long.valueOf(j));
                                j3 = (long) ((int) writableDatabase.replace("task_extra", null, contentValues));
                            } catch (long j4) {
                                j4.printStackTrace();
                            }
                        } else {
                            j3 = (long) writableDatabase.update("task_extra", contentValues, " task_id=? ", new String[]{String.valueOf(j4)});
                        }
                    }
                    return j3;
                }
            } catch (Exception e3) {
                e = e3;
                writableDatabase = null;
                e.printStackTrace();
                if (writableDatabase != null) {
                    if (z) {
                        j3 = (long) writableDatabase.update("task_extra", contentValues, " task_id=? ", new String[]{String.valueOf(j4)});
                    } else {
                        contentValues.put(AgooConstants.MESSAGE_TASK_ID, Long.valueOf(j4));
                        j3 = (long) ((int) writableDatabase.replace("task_extra", null, contentValues));
                    }
                }
                return j3;
            }
            if (writableDatabase != null) {
                if (z) {
                    contentValues.put(AgooConstants.MESSAGE_TASK_ID, Long.valueOf(j4));
                    j3 = (long) ((int) writableDatabase.replace("task_extra", null, contentValues));
                } else {
                    j3 = (long) writableDatabase.update("task_extra", contentValues, " task_id=? ", new String[]{String.valueOf(j4)});
                }
            }
        }
        return j3;
    }

    public final synchronized int a(long... jArr) {
        int i;
        synchronized (this) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = getWritableDatabase();
            } catch (Exception e) {
                e.printStackTrace();
            }
            i = 0;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.beginTransaction();
                int i2 = 0;
                int i3 = i2;
                while (i2 <= 0) {
                    if (jArr[i2] > 0) {
                        try {
                            if (sQLiteDatabase.delete("task_extra", "task_id=?", new String[]{String.valueOf(jArr[i2])}) > 0) {
                                i3++;
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    i2++;
                }
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                i = i3;
            }
        }
        return i;
    }

    public final synchronized long b(long j) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        long j2 = -1;
        ContentValues contentValues = new ContentValues();
        try {
            writableDatabase.beginTransaction();
            contentValues.put(AgooConstants.MESSAGE_TASK_ID, Long.valueOf(j));
            if (c(j)) {
                writableDatabase.delete("task_consume", " task_id=? ", new String[]{String.valueOf(j)});
            }
            j = writableDatabase.insert("task_consume", null, contentValues);
            try {
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                if (writableDatabase != null && writableDatabase.isOpen()) {
                    writableDatabase.close();
                }
            } catch (SQLiteException e) {
                long j3 = j;
                j = e;
                j2 = j3;
                try {
                    j.printStackTrace();
                    j = j2;
                    return j;
                } finally {
                    writableDatabase.endTransaction();
                    if (writableDatabase != null && writableDatabase.isOpen()) {
                        writableDatabase.close();
                    }
                }
            }
        } catch (SQLiteException e2) {
            j = e2;
            j.printStackTrace();
            j = j2;
            return j;
        }
        return j;
    }

    public final synchronized boolean c(long j) {
        boolean z;
        Exception e;
        Throwable th;
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor cursor = null;
        z = false;
        try {
            StringBuilder stringBuilder = new StringBuilder(" task_id=");
            stringBuilder.append(j);
            j = readableDatabase.query("task_consume", null, stringBuilder.toString(), null, null, null, null);
            if (j != null) {
                try {
                    if (j.moveToFirst()) {
                        z = true;
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = j;
                    try {
                        e.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor = j;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (j != null) {
                j.close();
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            if (cursor != null) {
                cursor.close();
            }
            return z;
        }
        return z;
    }

    public final synchronized int b(long... jArr) {
        int i;
        synchronized (this) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = getWritableDatabase();
            } catch (Exception e) {
                e.printStackTrace();
            }
            i = 0;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.beginTransaction();
                int i2 = 0;
                int i3 = i2;
                while (i2 <= 0) {
                    if (jArr[i2] > 0) {
                        try {
                            if (sQLiteDatabase.delete("task_consume", "task_id=?", new String[]{String.valueOf(jArr[i2])}) > 0) {
                                i3++;
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    i2++;
                }
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                i = i3;
            }
        }
        return i;
    }

    public final void onUpgrade(android.database.sqlite.SQLiteDatabase r4, int r5, int r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r6 = 4;
        if (r5 > 0) goto L_0x0007;
    L_0x0003:
        com.xunlei.downloadprovider.download.engine.task.a.a.a.b.b.a(r4);
        goto L_0x004e;
    L_0x0007:
        r0 = 6;
        if (r5 < r0) goto L_0x000e;
    L_0x000a:
        com.xunlei.downloadprovider.download.engine.task.a.a.a.b.b.a(r4);
        goto L_0x004e;
    L_0x000e:
        r1 = 2;
        if (r5 >= r1) goto L_0x0029;
    L_0x0011:
        r1 = new java.lang.StringBuilder;
        r2 = "ALTER TABLE `";
        r1.<init>(r2);
        r2 = com.xunlei.downloadprovider.download.engine.task.a.a.a.b.b.d;
        r1.append(r2);
        r2 = "` ADD COLUMN `max_speed` INTEGER default 0";
        r1.append(r2);
        r1 = r1.toString();
        r4.execSQL(r1);	 Catch:{ SQLException -> 0x0029 }
    L_0x0029:
        if (r5 >= r6) goto L_0x0035;
    L_0x002b:
        r1 = "ALTER TABLE `task_extra` ADD COLUMN `sniff_key_word` TEXT , ` website_name` + TEXT ";
        r4.execSQL(r1);	 Catch:{ SQLException -> 0x0031 }
        goto L_0x0035;
    L_0x0031:
        r1 = move-exception;
        r1.printStackTrace();
    L_0x0035:
        r1 = 5;
        if (r5 >= r1) goto L_0x0042;
    L_0x0038:
        r1 = "ALTER TABLE `task_extra` ADD COLUMN `icon_url` TEXT ";
        r4.execSQL(r1);	 Catch:{ SQLException -> 0x003e }
        goto L_0x0042;
    L_0x003e:
        r1 = move-exception;
        r1.printStackTrace();
    L_0x0042:
        if (r5 >= r0) goto L_0x004e;
    L_0x0044:
        r0 = "ALTER TABLE `task_extra` ADD COLUMN `display_name` TEXT ";
        r4.execSQL(r0);	 Catch:{ SQLException -> 0x004a }
        goto L_0x004e;
    L_0x004a:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x004e:
        if (r5 >= r6) goto L_0x0054;
    L_0x0050:
        com.xunlei.downloadprovider.download.engine.task.a.a.a.b.a.a(r4);
        return;
    L_0x0054:
        if (r5 < r6) goto L_0x0059;
    L_0x0056:
        com.xunlei.downloadprovider.download.engine.task.a.a.a.b.a.a(r4);
    L_0x0059:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.engine.task.a.a.a.b.onUpgrade(android.database.sqlite.SQLiteDatabase, int, int):void");
    }
}
