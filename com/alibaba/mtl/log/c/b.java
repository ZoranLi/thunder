package com.alibaba.mtl.log.c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.alibaba.mtl.log.e.i;
import com.xunlei.downloadprovider.pushmessage.e;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: LogSqliteStore */
final class b implements a {
    String a = "SELECT * FROM %s ORDER BY %s ASC LIMIT %s";
    String b = "SELECT count(*) FROM %s";
    String c = "DELETE FROM log where _id in ( select _id from log  ORDER BY _id ASC LIMIT %d )";
    a d;

    /* compiled from: LogSqliteStore */
    class a extends SQLiteOpenHelper {
        final /* synthetic */ b a;
        private AtomicInteger b = new AtomicInteger();
        private SQLiteDatabase c;

        a(b bVar, Context context) {
            this.a = bVar;
            super(context, "ut.db", null, 2);
        }

        public final void onOpen(android.database.sqlite.SQLiteDatabase r3) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r2 = this;
            r0 = 0;
            r1 = "PRAGMA journal_mode=DELETE";	 Catch:{ Throwable -> 0x0010, all -> 0x000b }
            r1 = r3.rawQuery(r1, r0);	 Catch:{ Throwable -> 0x0010, all -> 0x000b }
            com.alibaba.mtl.log.c.b.a(r1);
            goto L_0x0013;
        L_0x000b:
            r3 = move-exception;
            com.alibaba.mtl.log.c.b.a(r0);
            throw r3;
        L_0x0010:
            com.alibaba.mtl.log.c.b.a(r0);
        L_0x0013:
            super.onOpen(r3);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.c.b.a.onOpen(android.database.sqlite.SQLiteDatabase):void");
        }

        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS log (_id INTEGER PRIMARY KEY AUTOINCREMENT, eventId TEXT,priority TEXT, streamId TEXT, time TEXT, content TEXT, _index TEXT )");
        }

        public final void onUpgrade(android.database.sqlite.SQLiteDatabase r2, int r3, int r4) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r1 = this;
            r0 = 1;
            if (r3 != r0) goto L_0x0013;
        L_0x0003:
            r3 = 2;
            if (r4 != r3) goto L_0x0013;
        L_0x0006:
            r3 = "ALTER TABLE log ADD COLUMN _index TEXT ";	 Catch:{ Throwable -> 0x000c }
            r2.execSQL(r3);	 Catch:{ Throwable -> 0x000c }
            return;
        L_0x000c:
            r2 = "UTSqliteLogStore";
            r3 = "DB Upgrade Error";
            com.alibaba.mtl.log.e.i.a(r2, r3);
        L_0x0013:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.c.b.a.onUpgrade(android.database.sqlite.SQLiteDatabase, int, int):void");
        }

        public final synchronized SQLiteDatabase getWritableDatabase() {
            try {
                if (this.b.incrementAndGet() == 1) {
                    this.c = super.getWritableDatabase();
                }
            } catch (Throwable th) {
                i.a("TAG", e.a);
                com.alibaba.mtl.appmonitor.b.b.a(th);
            }
            return this.c;
        }

        public final synchronized void a(android.database.sqlite.SQLiteDatabase r1) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = this;
            monitor-enter(r0);
            if (r1 != 0) goto L_0x0005;
        L_0x0003:
            monitor-exit(r0);
            return;
        L_0x0005:
            r1 = r0.b;	 Catch:{ Throwable -> 0x001e, all -> 0x001b }
            r1 = r1.decrementAndGet();	 Catch:{ Throwable -> 0x001e, all -> 0x001b }
            if (r1 != 0) goto L_0x0019;	 Catch:{ Throwable -> 0x001e, all -> 0x001b }
        L_0x000d:
            r1 = r0.c;	 Catch:{ Throwable -> 0x001e, all -> 0x001b }
            if (r1 == 0) goto L_0x0019;	 Catch:{ Throwable -> 0x001e, all -> 0x001b }
        L_0x0011:
            r1 = r0.c;	 Catch:{ Throwable -> 0x001e, all -> 0x001b }
            r1.close();	 Catch:{ Throwable -> 0x001e, all -> 0x001b }
            r1 = 0;	 Catch:{ Throwable -> 0x001e, all -> 0x001b }
            r0.c = r1;	 Catch:{ Throwable -> 0x001e, all -> 0x001b }
        L_0x0019:
            monitor-exit(r0);
            return;
        L_0x001b:
            r1 = move-exception;
            monitor-exit(r0);
            throw r1;
        L_0x001e:
            monitor-exit(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.c.b.a.a(android.database.sqlite.SQLiteDatabase):void");
        }
    }

    public final /* synthetic */ List a(String str, int i) {
        return b(str, i);
    }

    protected b(Context context) {
        this.d = new a(this, context);
    }

    public final synchronized boolean a(java.util.List<com.alibaba.mtl.log.model.a> r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r10 = this;
        monitor-enter(r10);
        r0 = r11.size();	 Catch:{ all -> 0x00d6 }
        r1 = 1;
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        monitor-exit(r10);
        return r1;
    L_0x000a:
        r0 = 0;
        r2 = 0;
        r3 = r10.d;	 Catch:{ Throwable -> 0x00ae }
        r3 = r3.getWritableDatabase();	 Catch:{ Throwable -> 0x00ae }
        if (r3 == 0) goto L_0x0092;
    L_0x0014:
        r3.beginTransaction();	 Catch:{ Throwable -> 0x008f, all -> 0x008d }
        r0 = r2;
    L_0x0018:
        r4 = r11.size();	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        if (r0 >= r4) goto L_0x0088;	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
    L_0x001e:
        r4 = r11.get(r0);	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r4 = (com.alibaba.mtl.log.model.a) r4;	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        if (r4 == 0) goto L_0x0085;	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
    L_0x0026:
        r5 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r5.<init>();	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r6 = "eventId";	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r7 = r4.b;	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r5.put(r6, r7);	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r6 = "priority";	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r7 = r4.c;	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r5.put(r6, r7);	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r6 = r4.d;	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r7 = "content";	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r5.put(r7, r6);	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r6 = "time";	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r7 = r4.e;	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r5.put(r6, r7);	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r6 = "_index";	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r7 = r4.f;	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r5.put(r6, r7);	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r6 = "log";	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r7 = "";	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r5 = r3.insert(r6, r7, r5);	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r7 = -1;	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        if (r9 != 0) goto L_0x005d;	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
    L_0x005c:
        goto L_0x009d;	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
    L_0x005d:
        r7 = "UTSqliteLogStore";	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r8 = 6;	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r8 = new java.lang.Object[r8];	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r9 = "[insert] ";	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r8[r2] = r9;	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r4 = r4.f;	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r8[r1] = r4;	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r4 = 2;	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r9 = " isSuccess:";	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r8[r4] = r9;	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r4 = 3;	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r9 = java.lang.Boolean.valueOf(r1);	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r8[r4] = r9;	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r4 = 4;	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r9 = "ret";	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r8[r4] = r9;	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r4 = 5;	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r5 = java.lang.Long.valueOf(r5);	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        r8[r4] = r5;	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
        com.alibaba.mtl.log.e.i.a(r7, r8);	 Catch:{ Throwable -> 0x008a, all -> 0x008d }
    L_0x0085:
        r0 = r0 + 1;
        goto L_0x0018;
    L_0x0088:
        r2 = r1;
        goto L_0x009d;
    L_0x008a:
        r11 = move-exception;
        r2 = r1;
        goto L_0x0090;
    L_0x008d:
        r11 = move-exception;
        goto L_0x00c8;
    L_0x008f:
        r11 = move-exception;
    L_0x0090:
        r0 = r3;
        goto L_0x00af;
    L_0x0092:
        r11 = "UTSqliteLogStore";	 Catch:{ Throwable -> 0x008f, all -> 0x008d }
        r0 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x008f, all -> 0x008d }
        r1 = "db is null";	 Catch:{ Throwable -> 0x008f, all -> 0x008d }
        r0[r2] = r1;	 Catch:{ Throwable -> 0x008f, all -> 0x008d }
        com.alibaba.mtl.log.e.i.a(r11, r0);	 Catch:{ Throwable -> 0x008f, all -> 0x008d }
    L_0x009d:
        if (r3 == 0) goto L_0x00a5;
    L_0x009f:
        r3.setTransactionSuccessful();	 Catch:{ Throwable -> 0x00a2 }
    L_0x00a2:
        r3.endTransaction();	 Catch:{ Throwable -> 0x00a5 }
    L_0x00a5:
        r11 = r10.d;	 Catch:{ all -> 0x00d6 }
        r11.a(r3);	 Catch:{ all -> 0x00d6 }
        goto L_0x00c6;
    L_0x00ab:
        r11 = move-exception;
        r3 = r0;
        goto L_0x00c8;
    L_0x00ae:
        r11 = move-exception;
    L_0x00af:
        r1 = "UTSqliteLogStore";	 Catch:{ all -> 0x00ab }
        r3 = "insert error";	 Catch:{ all -> 0x00ab }
        com.alibaba.mtl.log.e.i.a(r1, r3);	 Catch:{ all -> 0x00ab }
        com.alibaba.mtl.appmonitor.b.b.a(r11);	 Catch:{ all -> 0x00ab }
        if (r0 == 0) goto L_0x00c1;
    L_0x00bb:
        r0.setTransactionSuccessful();	 Catch:{ Throwable -> 0x00be }
    L_0x00be:
        r0.endTransaction();	 Catch:{ Throwable -> 0x00c1 }
    L_0x00c1:
        r11 = r10.d;	 Catch:{ all -> 0x00d6 }
        r11.a(r0);	 Catch:{ all -> 0x00d6 }
    L_0x00c6:
        monitor-exit(r10);
        return r2;
    L_0x00c8:
        if (r3 == 0) goto L_0x00d0;
    L_0x00ca:
        r3.setTransactionSuccessful();	 Catch:{ Throwable -> 0x00cd }
    L_0x00cd:
        r3.endTransaction();	 Catch:{ Throwable -> 0x00d0 }
    L_0x00d0:
        r0 = r10.d;	 Catch:{ all -> 0x00d6 }
        r0.a(r3);	 Catch:{ all -> 0x00d6 }
        throw r11;	 Catch:{ all -> 0x00d6 }
    L_0x00d6:
        r11 = move-exception;
        monitor-exit(r10);
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.c.b.a(java.util.List):boolean");
    }

    public final synchronized int b(java.util.List<com.alibaba.mtl.log.model.a> r15) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r14 = this;
        monitor-enter(r14);
        r0 = 0;
        if (r15 == 0) goto L_0x00cf;
    L_0x0004:
        r1 = r15.size();	 Catch:{ all -> 0x00cc }
        if (r1 != 0) goto L_0x000c;	 Catch:{ all -> 0x00cc }
    L_0x000a:
        goto L_0x00cf;	 Catch:{ all -> 0x00cc }
    L_0x000c:
        r1 = r14.d;	 Catch:{ all -> 0x00cc }
        r1 = r1.getWritableDatabase();	 Catch:{ all -> 0x00cc }
        r2 = 3;
        r3 = 2;
        r4 = 4;
        r5 = 1;
        if (r1 == 0) goto L_0x009e;
    L_0x0018:
        r1.beginTransaction();	 Catch:{ all -> 0x0091 }
        r6 = r0;	 Catch:{ all -> 0x0091 }
        r8 = r6;	 Catch:{ all -> 0x0091 }
        r7 = r5;	 Catch:{ all -> 0x0091 }
    L_0x001e:
        r9 = r15.size();	 Catch:{ all -> 0x0091 }
        if (r6 >= r9) goto L_0x0085;	 Catch:{ all -> 0x0091 }
    L_0x0024:
        r9 = "log";	 Catch:{ all -> 0x0091 }
        r10 = "_id=?";	 Catch:{ all -> 0x0091 }
        r11 = new java.lang.String[r5];	 Catch:{ all -> 0x0091 }
        r12 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0091 }
        r12.<init>();	 Catch:{ all -> 0x0091 }
        r13 = r15.get(r6);	 Catch:{ all -> 0x0091 }
        r13 = (com.alibaba.mtl.log.model.a) r13;	 Catch:{ all -> 0x0091 }
        r13 = r13.a;	 Catch:{ all -> 0x0091 }
        r12.append(r13);	 Catch:{ all -> 0x0091 }
        r12 = r12.toString();	 Catch:{ all -> 0x0091 }
        r11[r0] = r12;	 Catch:{ all -> 0x0091 }
        r9 = r1.delete(r9, r10, r11);	 Catch:{ all -> 0x0091 }
        r9 = (long) r9;	 Catch:{ all -> 0x0091 }
        r11 = 0;	 Catch:{ all -> 0x0091 }
        r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1));	 Catch:{ all -> 0x0091 }
        if (r13 > 0) goto L_0x0070;	 Catch:{ all -> 0x0091 }
    L_0x004b:
        r7 = "UTSqliteLogStore";	 Catch:{ all -> 0x0091 }
        r11 = new java.lang.Object[r4];	 Catch:{ all -> 0x0091 }
        r12 = "[delete]  ";	 Catch:{ all -> 0x0091 }
        r11[r0] = r12;	 Catch:{ all -> 0x0091 }
        r12 = r15.get(r6);	 Catch:{ all -> 0x0091 }
        r12 = (com.alibaba.mtl.log.model.a) r12;	 Catch:{ all -> 0x0091 }
        r12 = r12.a;	 Catch:{ all -> 0x0091 }
        r12 = java.lang.Integer.valueOf(r12);	 Catch:{ all -> 0x0091 }
        r11[r5] = r12;	 Catch:{ all -> 0x0091 }
        r12 = " ret:";	 Catch:{ all -> 0x0091 }
        r11[r3] = r12;	 Catch:{ all -> 0x0091 }
        r9 = java.lang.Long.valueOf(r9);	 Catch:{ all -> 0x0091 }
        r11[r2] = r9;	 Catch:{ all -> 0x0091 }
        com.alibaba.mtl.log.e.i.a(r7, r11);	 Catch:{ all -> 0x0091 }
        r7 = r0;	 Catch:{ all -> 0x0091 }
        goto L_0x0082;	 Catch:{ all -> 0x0091 }
    L_0x0070:
        r9 = "6005";	 Catch:{ all -> 0x0091 }
        r10 = r15.get(r6);	 Catch:{ all -> 0x0091 }
        r10 = (com.alibaba.mtl.log.model.a) r10;	 Catch:{ all -> 0x0091 }
        r10 = r10.b;	 Catch:{ all -> 0x0091 }
        r9 = r9.equalsIgnoreCase(r10);	 Catch:{ all -> 0x0091 }
        if (r9 != 0) goto L_0x0082;
    L_0x0080:
        r8 = r8 + 1;
    L_0x0082:
        r6 = r6 + 1;
        goto L_0x001e;
    L_0x0085:
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x0088 }
    L_0x0088:
        r1.endTransaction();	 Catch:{ Throwable -> 0x008b }
    L_0x008b:
        r6 = r14.d;	 Catch:{ all -> 0x00cc }
        r6.a(r1);	 Catch:{ all -> 0x00cc }
        goto L_0x00ab;
    L_0x0091:
        r15 = move-exception;
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x0095 }
    L_0x0095:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0098 }
    L_0x0098:
        r0 = r14.d;	 Catch:{ all -> 0x00cc }
        r0.a(r1);	 Catch:{ all -> 0x00cc }
        throw r15;	 Catch:{ all -> 0x00cc }
    L_0x009e:
        r1 = "UTSqliteLogStore";	 Catch:{ all -> 0x00cc }
        r6 = new java.lang.Object[r5];	 Catch:{ all -> 0x00cc }
        r7 = "db is null";	 Catch:{ all -> 0x00cc }
        r6[r0] = r7;	 Catch:{ all -> 0x00cc }
        com.alibaba.mtl.log.e.i.a(r1, r6);	 Catch:{ all -> 0x00cc }
        r7 = r0;	 Catch:{ all -> 0x00cc }
        r8 = r7;	 Catch:{ all -> 0x00cc }
    L_0x00ab:
        r1 = "UTSqliteLogStore";	 Catch:{ all -> 0x00cc }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00cc }
        r6 = "delete ";	 Catch:{ all -> 0x00cc }
        r4[r0] = r6;	 Catch:{ all -> 0x00cc }
        r15 = r15.size();	 Catch:{ all -> 0x00cc }
        r15 = java.lang.Integer.valueOf(r15);	 Catch:{ all -> 0x00cc }
        r4[r5] = r15;	 Catch:{ all -> 0x00cc }
        r15 = " isSuccess:";	 Catch:{ all -> 0x00cc }
        r4[r3] = r15;	 Catch:{ all -> 0x00cc }
        r15 = java.lang.Boolean.valueOf(r7);	 Catch:{ all -> 0x00cc }
        r4[r2] = r15;	 Catch:{ all -> 0x00cc }
        com.alibaba.mtl.log.e.i.a(r1, r4);	 Catch:{ all -> 0x00cc }
        monitor-exit(r14);
        return r8;
    L_0x00cc:
        r15 = move-exception;
        monitor-exit(r14);
        throw r15;
    L_0x00cf:
        monitor-exit(r14);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.c.b.b(java.util.List):int");
    }

    private synchronized java.util.ArrayList<com.alibaba.mtl.log.model.a> b(java.lang.String r9, int r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        monitor-enter(r8);
        r0 = 0;
        if (r10 > 0) goto L_0x000d;
    L_0x0004:
        r9 = java.util.Collections.EMPTY_LIST;	 Catch:{ Throwable -> 0x0117, all -> 0x000a }
        r9 = (java.util.ArrayList) r9;	 Catch:{ Throwable -> 0x0117, all -> 0x000a }
        monitor-exit(r8);
        return r9;
    L_0x000a:
        r9 = move-exception;
        goto L_0x0115;
    L_0x000d:
        r1 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x0117, all -> 0x000a }
        r1.<init>(r10);	 Catch:{ Throwable -> 0x0117, all -> 0x000a }
        r2 = r8.d;	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        r2 = r2.getWritableDatabase();	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        r3 = 0;	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        r4 = 1;	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        if (r2 == 0) goto L_0x0109;	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
    L_0x001c:
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        r5.<init>();	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        r6 = "SELECT * FROM log";	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        r5.append(r6);	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        r6 = android.text.TextUtils.isEmpty(r9);	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        if (r6 != 0) goto L_0x0034;	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
    L_0x002c:
        r6 = " WHERE ";	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        r5.append(r6);	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        r5.append(r9);	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
    L_0x0034:
        r9 = " ORDER BY time ASC ";	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        r5.append(r9);	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        r9 = " LIMIT ";	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        r5.append(r9);	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        r9 = java.lang.String.valueOf(r10);	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        r5.append(r9);	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        r9 = r5.toString();	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        r10 = "UTSqliteLogStore";	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        r5 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        r7 = "sql:";	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        r6.<init>(r7);	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        r6.append(r9);	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        r5[r3] = r6;	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        com.alibaba.mtl.log.e.i.a(r10, r5);	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        r9 = r2.rawQuery(r9, r0);	 Catch:{ Throwable -> 0x00f3 }
    L_0x0064:
        if (r9 == 0) goto L_0x00e7;
    L_0x0066:
        r10 = r9.moveToNext();	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        if (r10 == 0) goto L_0x00e7;	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
    L_0x006c:
        r10 = new com.alibaba.mtl.log.model.a;	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r10.<init>();	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r0 = "UTSqliteLogStore";	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r5 = 4;	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r5 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r6 = "pos";	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r5[r3] = r6;	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r6 = r9.getPosition();	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r5[r4] = r6;	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r6 = 2;	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r7 = "count";	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r5[r6] = r7;	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r6 = 3;	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r7 = r9.getCount();	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r5[r6] = r7;	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        com.alibaba.mtl.log.e.i.a(r0, r5);	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r0 = "_id";	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r0 = r9.getColumnIndex(r0);	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r0 = r9.getInt(r0);	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r10.a = r0;	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r0 = "eventId";	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r0 = r9.getColumnIndex(r0);	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r0 = r9.getString(r0);	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r10.b = r0;	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r0 = "priority";	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r0 = r9.getColumnIndex(r0);	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r0 = r9.getString(r0);	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r10.c = r0;	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r0 = "content";	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r0 = r9.getColumnIndex(r0);	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r0 = r9.getString(r0);	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r10.d = r0;	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r0 = "time";	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r0 = r9.getColumnIndex(r0);	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r0 = r9.getString(r0);	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r10.e = r0;	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        r0 = "_index";	 Catch:{ Throwable -> 0x00df, all -> 0x00e3 }
        r0 = r9.getColumnIndex(r0);	 Catch:{ Throwable -> 0x00df, all -> 0x00e3 }
        r0 = r9.getString(r0);	 Catch:{ Throwable -> 0x00df, all -> 0x00e3 }
        r10.f = r0;	 Catch:{ Throwable -> 0x00df, all -> 0x00e3 }
    L_0x00df:
        r1.add(r10);	 Catch:{ Throwable -> 0x00e5, all -> 0x00e3 }
        goto L_0x0064;
    L_0x00e3:
        r10 = move-exception;
        goto L_0x0100;
    L_0x00e5:
        r0 = r9;
        goto L_0x00f3;
    L_0x00e7:
        a(r9);	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        r9 = r8.d;	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
    L_0x00ec:
        r9.a(r2);	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        goto L_0x0118;
    L_0x00f0:
        r10 = move-exception;
        r9 = r0;
        goto L_0x0100;
    L_0x00f3:
        r9 = "UTSqliteLogStore";	 Catch:{ all -> 0x00f0 }
        r10 = "[get]";	 Catch:{ all -> 0x00f0 }
        com.alibaba.mtl.log.e.i.a(r9, r10);	 Catch:{ all -> 0x00f0 }
        a(r0);	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        r9 = r8.d;	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        goto L_0x00ec;	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
    L_0x0100:
        a(r9);	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        r9 = r8.d;	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        r9.a(r2);	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        throw r10;	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
    L_0x0109:
        r9 = "UTSqliteLogStore";	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        r10 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        r0 = "db is null";	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        r10[r3] = r0;	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        com.alibaba.mtl.log.e.i.a(r9, r10);	 Catch:{ Throwable -> 0x0118, all -> 0x000a }
        goto L_0x0118;
    L_0x0115:
        monitor-exit(r8);
        throw r9;
    L_0x0117:
        r1 = r0;
    L_0x0118:
        monitor-exit(r8);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.c.b.b(java.lang.String, int):java.util.ArrayList<com.alibaba.mtl.log.model.a>");
    }

    public final synchronized int a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        monitor-enter(r6);
        r0 = r6.d;	 Catch:{ all -> 0x0051 }
        r0 = r0.getWritableDatabase();	 Catch:{ all -> 0x0051 }
        r1 = 1;
        r2 = 0;
        if (r0 == 0) goto L_0x0044;
    L_0x000b:
        r3 = 0;
        r4 = r6.b;	 Catch:{ Throwable -> 0x003d, all -> 0x0033 }
        r1 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x003d, all -> 0x0033 }
        r5 = "log";	 Catch:{ Throwable -> 0x003d, all -> 0x0033 }
        r1[r2] = r5;	 Catch:{ Throwable -> 0x003d, all -> 0x0033 }
        r1 = java.lang.String.format(r4, r1);	 Catch:{ Throwable -> 0x003d, all -> 0x0033 }
        r1 = r0.rawQuery(r1, r3);	 Catch:{ Throwable -> 0x003d, all -> 0x0033 }
        if (r1 == 0) goto L_0x002a;
    L_0x001e:
        r1.moveToFirst();	 Catch:{ Throwable -> 0x003e, all -> 0x0027 }
        r3 = r1.getInt(r2);	 Catch:{ Throwable -> 0x003e, all -> 0x0027 }
        r2 = r3;
        goto L_0x002a;
    L_0x0027:
        r2 = move-exception;
        r3 = r1;
        goto L_0x0034;
    L_0x002a:
        a(r1);	 Catch:{ all -> 0x0051 }
        r1 = r6.d;	 Catch:{ all -> 0x0051 }
    L_0x002f:
        r1.a(r0);	 Catch:{ all -> 0x0051 }
        goto L_0x004f;	 Catch:{ all -> 0x0051 }
    L_0x0033:
        r2 = move-exception;	 Catch:{ all -> 0x0051 }
    L_0x0034:
        a(r3);	 Catch:{ all -> 0x0051 }
        r1 = r6.d;	 Catch:{ all -> 0x0051 }
        r1.a(r0);	 Catch:{ all -> 0x0051 }
        throw r2;	 Catch:{ all -> 0x0051 }
    L_0x003d:
        r1 = r3;	 Catch:{ all -> 0x0051 }
    L_0x003e:
        a(r1);	 Catch:{ all -> 0x0051 }
        r1 = r6.d;	 Catch:{ all -> 0x0051 }
        goto L_0x002f;	 Catch:{ all -> 0x0051 }
    L_0x0044:
        r0 = "UTSqliteLogStore";	 Catch:{ all -> 0x0051 }
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x0051 }
        r3 = "db is null";	 Catch:{ all -> 0x0051 }
        r1[r2] = r3;	 Catch:{ all -> 0x0051 }
        com.alibaba.mtl.log.e.i.a(r0, r1);	 Catch:{ all -> 0x0051 }
    L_0x004f:
        monitor-exit(r6);
        return r2;
    L_0x0051:
        r0 = move-exception;
        monitor-exit(r6);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.c.b.a():int");
    }

    public final synchronized void b() {
        SQLiteDatabase writableDatabase = this.d.getWritableDatabase();
        if (writableDatabase != null) {
            writableDatabase.delete("log", null, null);
            this.d.a(writableDatabase);
        }
    }

    public final synchronized void a(java.lang.String r6, java.lang.String r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.d;	 Catch:{ all -> 0x004b }
        r0 = r0.getWritableDatabase();	 Catch:{ all -> 0x004b }
        r1 = 0;
        r2 = 1;
        if (r0 == 0) goto L_0x003e;
    L_0x000b:
        r3 = "log";	 Catch:{ Throwable -> 0x0037, all -> 0x0030 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0037, all -> 0x0030 }
        r4.<init>();	 Catch:{ Throwable -> 0x0037, all -> 0x0030 }
        r4.append(r6);	 Catch:{ Throwable -> 0x0037, all -> 0x0030 }
        r6 = " < ?";	 Catch:{ Throwable -> 0x0037, all -> 0x0030 }
        r4.append(r6);	 Catch:{ Throwable -> 0x0037, all -> 0x0030 }
        r6 = r4.toString();	 Catch:{ Throwable -> 0x0037, all -> 0x0030 }
        r2 = new java.lang.String[r2];	 Catch:{ Throwable -> 0x0037, all -> 0x0030 }
        r7 = java.lang.String.valueOf(r7);	 Catch:{ Throwable -> 0x0037, all -> 0x0030 }
        r2[r1] = r7;	 Catch:{ Throwable -> 0x0037, all -> 0x0030 }
        r0.delete(r3, r6, r2);	 Catch:{ Throwable -> 0x0037, all -> 0x0030 }
        r6 = r5.d;	 Catch:{ all -> 0x004b }
        r6.a(r0);	 Catch:{ all -> 0x004b }
        monitor-exit(r5);
        return;
    L_0x0030:
        r6 = move-exception;
        r7 = r5.d;	 Catch:{ all -> 0x004b }
        r7.a(r0);	 Catch:{ all -> 0x004b }
        throw r6;	 Catch:{ all -> 0x004b }
    L_0x0037:
        r6 = r5.d;	 Catch:{ all -> 0x004b }
        r6.a(r0);	 Catch:{ all -> 0x004b }
        monitor-exit(r5);
        return;
    L_0x003e:
        r6 = "UTSqliteLogStore";	 Catch:{ all -> 0x004b }
        r7 = new java.lang.Object[r2];	 Catch:{ all -> 0x004b }
        r0 = "db is null";	 Catch:{ all -> 0x004b }
        r7[r1] = r0;	 Catch:{ all -> 0x004b }
        com.alibaba.mtl.log.e.i.a(r6, r7);	 Catch:{ all -> 0x004b }
        monitor-exit(r5);
        return;
    L_0x004b:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.c.b.a(java.lang.String, java.lang.String):void");
    }

    public final void c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = r5.d;
        r0 = r0.getWritableDatabase();
        r1 = 0;
        r2 = 1;
        if (r0 == 0) goto L_0x002a;
    L_0x000a:
        r3 = r5.c;	 Catch:{ Throwable -> 0x001d, all -> 0x0023 }
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x001d, all -> 0x0023 }
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ Throwable -> 0x001d, all -> 0x0023 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x001d, all -> 0x0023 }
        r2[r1] = r4;	 Catch:{ Throwable -> 0x001d, all -> 0x0023 }
        r1 = java.lang.String.format(r3, r2);	 Catch:{ Throwable -> 0x001d, all -> 0x0023 }
        r0.execSQL(r1);	 Catch:{ Throwable -> 0x001d, all -> 0x0023 }
    L_0x001d:
        r1 = r5.d;
        r1.a(r0);
        return;
    L_0x0023:
        r1 = move-exception;
        r2 = r5.d;
        r2.a(r0);
        throw r1;
    L_0x002a:
        r0 = "UTSqliteLogStore";
        r2 = new java.lang.Object[r2];
        r3 = "db is null";
        r2[r1] = r3;
        com.alibaba.mtl.log.e.i.a(r0, r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.c.b.c():void");
    }

    static void a(android.database.Cursor r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 == 0) goto L_0x0006;
    L_0x0002:
        r0.close();	 Catch:{ Throwable -> 0x0006 }
        return;
    L_0x0006:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.c.b.a(android.database.Cursor):void");
    }
}
