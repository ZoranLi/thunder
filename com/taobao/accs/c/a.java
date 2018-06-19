package com.taobao.accs.c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: Taobao */
public class a extends SQLiteOpenHelper {
    private static volatile a c;
    private static final Lock e = new ReentrantLock();
    public int a = null;
    LinkedList<a> b = new LinkedList();
    private Context d;

    /* compiled from: Taobao */
    private class a {
        String a;
        Object[] b;
        final /* synthetic */ a c;

        private a(a aVar, String str, Object[] objArr) {
            this.c = aVar;
            this.a = str;
            this.b = objArr;
        }
    }

    public SQLiteDatabase getWritableDatabase() {
        if (com.taobao.accs.utl.a.a(super.getWritableDatabase().getPath(), ShareConstants.MD5_FILE_BUF_LENGTH)) {
            return super.getWritableDatabase();
        }
        return null;
    }

    public static a a(Context context) {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a(context, Constants.DB_NAME, null, 3);
                }
            }
        }
        return c;
    }

    private a(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
        this.d = context;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            if (e.tryLock()) {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS traffic(_id INTEGER PRIMARY KEY AUTOINCREMENT, date TEXT, host TEXT,serviceid TEXT, bid TEXT, isbackground TEXT, size TEXT)");
            }
            e.unlock();
        } catch (Throwable th) {
            e.unlock();
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < i2) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS service");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS network");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ping");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS msg");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ack");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS election");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS bindApp");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS bindUser");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS traffic");
            onCreate(sQLiteDatabase);
        }
    }

    public void a(String str, String str2, String str3, boolean z, long j, String str4) {
        if (a(str, str3, z, str4)) {
            a("UPDATE traffic SET size=? WHERE date=? AND host=? AND bid=? AND isbackground=?", new Object[]{Long.valueOf(j), str4, str, str3, String.valueOf(z)}, true);
            return;
        }
        a("INSERT INTO traffic VALUES(null,?,?,?,?,?,?)", new Object[]{str4, str, str2, str3, String.valueOf(z), Long.valueOf(j)}, true);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean a(java.lang.String r15, java.lang.String r16, boolean r17, java.lang.String r18) {
        /*
        r14 = this;
        monitor-enter(r14);
        r1 = 0;
        r2 = 0;
        r3 = r14.getWritableDatabase();	 Catch:{ Exception -> 0x006a, all -> 0x0066 }
        if (r3 != 0) goto L_0x000b;
    L_0x0009:
        monitor-exit(r14);
        return r2;
    L_0x000b:
        r4 = "traffic";
        r5 = 7;
        r5 = new java.lang.String[r5];	 Catch:{ Exception -> 0x006a, all -> 0x0066 }
        r6 = "_id";
        r5[r2] = r6;	 Catch:{ Exception -> 0x006a, all -> 0x0066 }
        r6 = "date";
        r12 = 1;
        r5[r12] = r6;	 Catch:{ Exception -> 0x006a, all -> 0x0066 }
        r6 = "host";
        r7 = 2;
        r5[r7] = r6;	 Catch:{ Exception -> 0x006a, all -> 0x0066 }
        r6 = "serviceid";
        r8 = 3;
        r5[r8] = r6;	 Catch:{ Exception -> 0x006a, all -> 0x0066 }
        r6 = "bid";
        r9 = 4;
        r5[r9] = r6;	 Catch:{ Exception -> 0x006a, all -> 0x0066 }
        r6 = 5;
        r10 = "isbackground";
        r5[r6] = r10;	 Catch:{ Exception -> 0x006a, all -> 0x0066 }
        r6 = 6;
        r10 = "size";
        r5[r6] = r10;	 Catch:{ Exception -> 0x006a, all -> 0x0066 }
        r6 = "date=? AND host=? AND bid=? AND isbackground=?";
        r9 = new java.lang.String[r9];	 Catch:{ Exception -> 0x006a, all -> 0x0066 }
        r9[r2] = r18;	 Catch:{ Exception -> 0x006a, all -> 0x0066 }
        r9[r12] = r15;	 Catch:{ Exception -> 0x006a, all -> 0x0066 }
        r9[r7] = r16;	 Catch:{ Exception -> 0x006a, all -> 0x0066 }
        r7 = java.lang.String.valueOf(r17);	 Catch:{ Exception -> 0x006a, all -> 0x0066 }
        r9[r8] = r7;	 Catch:{ Exception -> 0x006a, all -> 0x0066 }
        r8 = 0;
        r10 = 0;
        r11 = 0;
        r13 = "100";
        r7 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r13;
        r3 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x006a, all -> 0x0066 }
        if (r3 == 0) goto L_0x0060;
    L_0x0051:
        r1 = r3.getCount();	 Catch:{ Exception -> 0x005e }
        if (r1 <= 0) goto L_0x0060;
    L_0x0057:
        if (r3 == 0) goto L_0x005c;
    L_0x0059:
        r3.close();	 Catch:{ all -> 0x0085 }
    L_0x005c:
        monitor-exit(r14);
        return r12;
    L_0x005e:
        r0 = move-exception;
        goto L_0x006c;
    L_0x0060:
        if (r3 == 0) goto L_0x007b;
    L_0x0062:
        r3.close();	 Catch:{ all -> 0x0085 }
        goto L_0x007b;
    L_0x0066:
        r0 = move-exception;
        r3 = r1;
    L_0x0068:
        r1 = r0;
        goto L_0x007f;
    L_0x006a:
        r0 = move-exception;
        r3 = r1;
    L_0x006c:
        r1 = r0;
        r4 = "DBHelper";
        r1 = r1.toString();	 Catch:{ all -> 0x007d }
        r5 = new java.lang.Object[r2];	 Catch:{ all -> 0x007d }
        com.taobao.accs.utl.ALog.w(r4, r1, r5);	 Catch:{ all -> 0x007d }
        if (r3 == 0) goto L_0x007b;
    L_0x007a:
        goto L_0x0062;
    L_0x007b:
        monitor-exit(r14);
        return r2;
    L_0x007d:
        r0 = move-exception;
        goto L_0x0068;
    L_0x007f:
        if (r3 == 0) goto L_0x0088;
    L_0x0081:
        r3.close();	 Catch:{ all -> 0x0085 }
        goto L_0x0088;
    L_0x0085:
        r0 = move-exception;
        r1 = r0;
        goto L_0x0089;
    L_0x0088:
        throw r1;	 Catch:{ all -> 0x0085 }
    L_0x0089:
        monitor-exit(r14);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.c.a.a(java.lang.String, java.lang.String, boolean, java.lang.String):boolean");
    }

    public void a() {
        a("DELETE FROM traffic", null, true);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.taobao.accs.ut.monitor.TrafficsMonitor.a> a(boolean r30) {
        /*
        r29 = this;
        monitor-enter(r29);
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x0158 }
        r1.<init>();	 Catch:{ all -> 0x0158 }
        r2 = 0;
        r3 = 0;
        r4 = r29.getWritableDatabase();	 Catch:{ Exception -> 0x013c, all -> 0x0138 }
        if (r4 != 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r29);	 Catch:{ all -> 0x0158 }
        return r2;
    L_0x0010:
        r5 = 7;
        r13 = 6;
        r14 = 5;
        r12 = 4;
        r11 = 3;
        r10 = 2;
        r9 = 1;
        if (r30 == 0) goto L_0x006b;
    L_0x0019:
        r6 = "traffic";
        r7 = new java.lang.String[r5];	 Catch:{ Exception -> 0x0066, all -> 0x0061 }
        r5 = "_id";
        r7[r3] = r5;	 Catch:{ Exception -> 0x0066, all -> 0x0061 }
        r5 = "date";
        r7[r9] = r5;	 Catch:{ Exception -> 0x0066, all -> 0x0061 }
        r5 = "host";
        r7[r10] = r5;	 Catch:{ Exception -> 0x0066, all -> 0x0061 }
        r5 = "serviceid";
        r7[r11] = r5;	 Catch:{ Exception -> 0x0066, all -> 0x0061 }
        r5 = "bid";
        r7[r12] = r5;	 Catch:{ Exception -> 0x0066, all -> 0x0061 }
        r5 = "isbackground";
        r7[r14] = r5;	 Catch:{ Exception -> 0x0066, all -> 0x0061 }
        r5 = "size";
        r7[r13] = r5;	 Catch:{ Exception -> 0x0066, all -> 0x0061 }
        r8 = "date=?";
        r5 = new java.lang.String[r9];	 Catch:{ Exception -> 0x0066, all -> 0x0061 }
        r9 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0066, all -> 0x0061 }
        r9 = com.taobao.accs.utl.UtilityImpl.formatDay(r9);	 Catch:{ Exception -> 0x0066, all -> 0x0061 }
        r5[r3] = r9;	 Catch:{ Exception -> 0x0066, all -> 0x0061 }
        r9 = 0;
        r10 = 0;
        r17 = 0;
        r18 = "100";
        r19 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r19;
        r2 = 1;
        r13 = 2;
        r14 = r11;
        r11 = r17;
        r12 = r18;
        r4 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12);	 Catch:{ Exception -> 0x0066, all -> 0x0061 }
        r3 = 4;
        goto L_0x00a6;
    L_0x0061:
        r0 = move-exception;
        r1 = r0;
        r4 = 0;
        goto L_0x0152;
    L_0x0066:
        r0 = move-exception;
        r2 = r0;
        r4 = 0;
        goto L_0x013f;
    L_0x006b:
        r2 = r9;
        r13 = r10;
        r14 = r11;
        r6 = "traffic";
        r7 = new java.lang.String[r5];	 Catch:{ Exception -> 0x0135, all -> 0x0132 }
        r5 = "_id";
        r7[r3] = r5;	 Catch:{ Exception -> 0x0135, all -> 0x0132 }
        r5 = "date";
        r7[r2] = r5;	 Catch:{ Exception -> 0x0135, all -> 0x0132 }
        r5 = "host";
        r7[r13] = r5;	 Catch:{ Exception -> 0x0135, all -> 0x0132 }
        r5 = "serviceid";
        r7[r14] = r5;	 Catch:{ Exception -> 0x0135, all -> 0x0132 }
        r5 = "bid";
        r12 = 4;
        r7[r12] = r5;	 Catch:{ Exception -> 0x0135, all -> 0x0132 }
        r5 = "isbackground";
        r8 = 5;
        r7[r8] = r5;	 Catch:{ Exception -> 0x0135, all -> 0x0132 }
        r5 = "size";
        r8 = 6;
        r7[r8] = r5;	 Catch:{ Exception -> 0x0135, all -> 0x0132 }
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r11 = 0;
        r15 = 0;
        r16 = "100";
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r15;
        r3 = r12;
        r12 = r16;
        r4 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12);	 Catch:{ Exception -> 0x0135, all -> 0x0132 }
    L_0x00a6:
        if (r4 != 0) goto L_0x00b0;
    L_0x00a8:
        if (r4 == 0) goto L_0x00ad;
    L_0x00aa:
        r4.close();	 Catch:{ all -> 0x0158 }
    L_0x00ad:
        monitor-exit(r29);	 Catch:{ all -> 0x0158 }
        r4 = 0;
        return r4;
    L_0x00b0:
        r5 = r4.moveToFirst();	 Catch:{ Exception -> 0x0130 }
        if (r5 == 0) goto L_0x012a;
    L_0x00b6:
        r21 = r4.getString(r2);	 Catch:{ Exception -> 0x0130 }
        r5 = r4.getString(r13);	 Catch:{ Exception -> 0x0130 }
        r6 = r4.getString(r14);	 Catch:{ Exception -> 0x0130 }
        r7 = r4.getString(r3);	 Catch:{ Exception -> 0x0130 }
        r8 = 5;
        r9 = r4.getString(r8);	 Catch:{ Exception -> 0x0130 }
        r9 = java.lang.Boolean.valueOf(r9);	 Catch:{ Exception -> 0x0130 }
        r24 = r9.booleanValue();	 Catch:{ Exception -> 0x0130 }
        r9 = 6;
        r10 = r4.getLong(r9);	 Catch:{ Exception -> 0x0130 }
        if (r7 == 0) goto L_0x0120;
    L_0x00da:
        r15 = 0;
        r12 = (r10 > r15 ? 1 : (r10 == r15 ? 0 : -1));
        if (r12 <= 0) goto L_0x0120;
    L_0x00e0:
        r12 = new com.taobao.accs.ut.monitor.TrafficsMonitor$a;	 Catch:{ Exception -> 0x0130 }
        r20 = r12;
        r22 = r7;
        r23 = r6;
        r25 = r5;
        r26 = r10;
        r20.<init>(r21, r22, r23, r24, r25, r26);	 Catch:{ Exception -> 0x0130 }
        r1.add(r12);	 Catch:{ Exception -> 0x0130 }
        r12 = "DBHelper";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0130 }
        r3 = "resotre traffics from db bid:";
        r2.<init>(r3);	 Catch:{ Exception -> 0x0130 }
        r2.append(r7);	 Catch:{ Exception -> 0x0130 }
        r3 = " serviceid:";
        r2.append(r3);	 Catch:{ Exception -> 0x0130 }
        r2.append(r6);	 Catch:{ Exception -> 0x0130 }
        r3 = " host:";
        r2.append(r3);	 Catch:{ Exception -> 0x0130 }
        r2.append(r5);	 Catch:{ Exception -> 0x0130 }
        r3 = " size:";
        r2.append(r3);	 Catch:{ Exception -> 0x0130 }
        r2.append(r10);	 Catch:{ Exception -> 0x0130 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0130 }
        r3 = 0;
        r5 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0130 }
        com.taobao.accs.utl.ALog.d(r12, r2, r5);	 Catch:{ Exception -> 0x0130 }
    L_0x0120:
        r2 = r4.moveToNext();	 Catch:{ Exception -> 0x0130 }
        if (r2 != 0) goto L_0x0127;
    L_0x0126:
        goto L_0x012a;
    L_0x0127:
        r2 = 1;
        r3 = 4;
        goto L_0x00b6;
    L_0x012a:
        if (r4 == 0) goto L_0x014e;
    L_0x012c:
        r4.close();	 Catch:{ all -> 0x0158 }
        goto L_0x014e;
    L_0x0130:
        r0 = move-exception;
        goto L_0x013e;
    L_0x0132:
        r0 = move-exception;
        r4 = 0;
        goto L_0x013a;
    L_0x0135:
        r0 = move-exception;
        r4 = 0;
        goto L_0x013e;
    L_0x0138:
        r0 = move-exception;
        r4 = r2;
    L_0x013a:
        r1 = r0;
        goto L_0x0152;
    L_0x013c:
        r0 = move-exception;
        r4 = r2;
    L_0x013e:
        r2 = r0;
    L_0x013f:
        r3 = "DBHelper";
        r2 = r2.toString();	 Catch:{ all -> 0x0150 }
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0150 }
        com.taobao.accs.utl.ALog.w(r3, r2, r5);	 Catch:{ all -> 0x0150 }
        if (r4 == 0) goto L_0x014e;
    L_0x014d:
        goto L_0x012c;
    L_0x014e:
        monitor-exit(r29);	 Catch:{ all -> 0x0158 }
        return r1;
    L_0x0150:
        r0 = move-exception;
        goto L_0x013a;
    L_0x0152:
        if (r4 == 0) goto L_0x0157;
    L_0x0154:
        r4.close();	 Catch:{ all -> 0x0158 }
    L_0x0157:
        throw r1;	 Catch:{ all -> 0x0158 }
    L_0x0158:
        r0 = move-exception;
        r1 = r0;
        monitor-exit(r29);	 Catch:{ all -> 0x0158 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.c.a.a(boolean):java.util.List<com.taobao.accs.ut.monitor.TrafficsMonitor$a>");
    }

    private synchronized void a(String str, Object[] objArr, boolean z) {
        this.b.add(new a(str, objArr));
        if (this.b.size() <= 5) {
            if (!z) {
                return;
            }
        }
        try {
            str = getWritableDatabase();
            if (str != null) {
                while (this.b.size() > null) {
                    a aVar = (a) this.b.removeFirst();
                    if (aVar.b) {
                        str.execSQL(aVar.a, aVar.b);
                    } else {
                        str.execSQL(aVar.a);
                    }
                    if (aVar.a.contains("INSERT") != null) {
                        this.a += 1;
                        if (this.a > 4000) {
                            ALog.d("DBHelper", "db is full!", new Object[0]);
                            onUpgrade(str, 0, 1);
                            this.a = 0;
                            break;
                        }
                    }
                }
                str.close();
            }
        } catch (String str2) {
            ALog.d("DBHelper", str2.toString(), new Object[0]);
        } catch (Throwable th) {
            str2.close();
        }
    }
}
