package com.tencent.wxop.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.common.a;
import com.tencent.wxop.stat.common.e;
import com.tencent.wxop.stat.common.l;
import com.tencent.wxop.stat.common.r;
import com.umeng.message.MsgConstant;
import com.umeng.message.proguard.k;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class au {
    private static StatLogger h = l.b();
    private static Context i;
    private static au j;
    volatile int a = 0;
    a b = null;
    private bc c = null;
    private bc d = null;
    private e e = null;
    private String f = "";
    private String g = "";
    private int k = 0;
    private ConcurrentHashMap<com.tencent.wxop.stat.event.e, String> l = null;
    private boolean m = false;
    private HashMap<String, String> n = new HashMap();

    private au(Context context) {
        try {
            this.e = new e();
            i = context.getApplicationContext();
            this.l = new ConcurrentHashMap();
            this.f = l.p(context);
            StringBuilder stringBuilder = new StringBuilder("pri_");
            stringBuilder.append(l.p(context));
            this.g = stringBuilder.toString();
            this.c = new bc(i, this.f);
            this.d = new bc(i, this.g);
            a(true);
            a(false);
            f();
            b(i);
            d();
            j();
        } catch (Throwable th) {
            h.e(th);
        }
    }

    public static au a(Context context) {
        if (j == null) {
            synchronized (au.class) {
                if (j == null) {
                    j = new au(context);
                }
            }
        }
        return j;
    }

    private String a(List<bd> list) {
        StringBuilder stringBuilder = new StringBuilder(3 * list.size());
        stringBuilder.append("event_id in (");
        int size = list.size();
        int i = 0;
        for (bd bdVar : list) {
            stringBuilder.append(bdVar.a);
            if (i != size - 1) {
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            i++;
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(int r4, boolean r5) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.a;	 Catch:{ Throwable -> 0x0076 }
        if (r0 <= 0) goto L_0x0072;
    L_0x0005:
        if (r4 <= 0) goto L_0x0072;
    L_0x0007:
        r0 = com.tencent.wxop.stat.StatServiceImpl.a();	 Catch:{ Throwable -> 0x0076 }
        if (r0 == 0) goto L_0x000e;
    L_0x000d:
        goto L_0x0072;
    L_0x000e:
        r0 = com.tencent.wxop.stat.StatConfig.isDebugEnable();	 Catch:{ Throwable -> 0x0076 }
        if (r0 == 0) goto L_0x002e;
    L_0x0014:
        r0 = h;	 Catch:{ Throwable -> 0x0076 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0076 }
        r2 = "Load ";
        r1.<init>(r2);	 Catch:{ Throwable -> 0x0076 }
        r2 = r3.a;	 Catch:{ Throwable -> 0x0076 }
        r1.append(r2);	 Catch:{ Throwable -> 0x0076 }
        r2 = " unsent events";
        r1.append(r2);	 Catch:{ Throwable -> 0x0076 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x0076 }
        r0.i(r1);	 Catch:{ Throwable -> 0x0076 }
    L_0x002e:
        r0 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x0076 }
        r0.<init>(r4);	 Catch:{ Throwable -> 0x0076 }
        r3.b(r0, r4, r5);	 Catch:{ Throwable -> 0x0076 }
        r4 = r0.size();	 Catch:{ Throwable -> 0x0076 }
        if (r4 <= 0) goto L_0x0070;
    L_0x003c:
        r4 = com.tencent.wxop.stat.StatConfig.isDebugEnable();	 Catch:{ Throwable -> 0x0076 }
        if (r4 == 0) goto L_0x005e;
    L_0x0042:
        r4 = h;	 Catch:{ Throwable -> 0x0076 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0076 }
        r2 = "Peek ";
        r1.<init>(r2);	 Catch:{ Throwable -> 0x0076 }
        r2 = r0.size();	 Catch:{ Throwable -> 0x0076 }
        r1.append(r2);	 Catch:{ Throwable -> 0x0076 }
        r2 = " unsent events.";
        r1.append(r2);	 Catch:{ Throwable -> 0x0076 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x0076 }
        r4.i(r1);	 Catch:{ Throwable -> 0x0076 }
    L_0x005e:
        r4 = 2;
        r3.a(r0, r4, r5);	 Catch:{ Throwable -> 0x0076 }
        r4 = i;	 Catch:{ Throwable -> 0x0076 }
        r4 = com.tencent.wxop.stat.i.b(r4);	 Catch:{ Throwable -> 0x0076 }
        r1 = new com.tencent.wxop.stat.ba;	 Catch:{ Throwable -> 0x0076 }
        r1.<init>(r3, r0, r5);	 Catch:{ Throwable -> 0x0076 }
        r4.b(r0, r1);	 Catch:{ Throwable -> 0x0076 }
    L_0x0070:
        monitor-exit(r3);
        return;
    L_0x0072:
        monitor-exit(r3);
        return;
    L_0x0074:
        r4 = move-exception;
        goto L_0x007e;
    L_0x0076:
        r4 = move-exception;
        r5 = h;	 Catch:{ all -> 0x0074 }
        r5.e(r4);	 Catch:{ all -> 0x0074 }
        monitor-exit(r3);
        return;
    L_0x007e:
        monitor-exit(r3);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.au.a(int, boolean):void");
    }

    private void a(com.tencent.wxop.stat.event.e eVar, h hVar, boolean z) {
        long insert;
        Throwable th;
        StatLogger statLogger;
        StringBuilder stringBuilder;
        StatLogger statLogger2;
        StringBuilder stringBuilder2;
        Throwable th2;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase c = c(z);
            try {
                c.beginTransaction();
                if (!z && this.a > StatConfig.getMaxStoreEventCount()) {
                    h.warn("Too many events stored in db.");
                    this.a -= this.c.getWritableDatabase().delete("events", "event_id in (select event_id from events where timestamp in (select min(timestamp) from events) limit 1)", null);
                }
                ContentValues contentValues = new ContentValues();
                String g = eVar.g();
                if (StatConfig.isDebugEnable()) {
                    StatLogger statLogger3 = h;
                    StringBuilder stringBuilder3 = new StringBuilder("insert 1 event, content:");
                    stringBuilder3.append(g);
                    statLogger3.i(stringBuilder3.toString());
                }
                contentValues.put("content", r.b(g));
                contentValues.put("send_count", "0");
                contentValues.put("status", Integer.toString(1));
                contentValues.put("timestamp", Long.valueOf(eVar.c()));
                insert = c.insert("events", null, contentValues);
                c.setTransactionSuccessful();
                if (c != null) {
                    try {
                        c.endTransaction();
                    } catch (Throwable th3) {
                        h.e(th3);
                    }
                }
            } catch (Throwable th4) {
                th2 = th4;
                if (c != null) {
                    c.endTransaction();
                }
                throw th2;
            }
        } catch (Throwable th5) {
            th3 = th5;
            insert = -1;
            h.e(th3);
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            if (insert > 0) {
                this.a++;
                if (StatConfig.isDebugEnable()) {
                    statLogger2 = h;
                    stringBuilder2 = new StringBuilder("directStoreEvent insert event to db, event:");
                    stringBuilder2.append(eVar.g());
                    statLogger2.d(stringBuilder2.toString());
                }
                if (hVar != null) {
                    hVar.a();
                    return;
                }
            }
            statLogger = h;
            stringBuilder = new StringBuilder("Failed to store event:");
            stringBuilder.append(eVar.g());
            statLogger.error(stringBuilder.toString());
        }
        if (insert > 0) {
            this.a++;
            if (StatConfig.isDebugEnable()) {
                statLogger2 = h;
                stringBuilder2 = new StringBuilder("directStoreEvent insert event to db, event:");
                stringBuilder2.append(eVar.g());
                statLogger2.d(stringBuilder2.toString());
            }
            if (hVar != null) {
                hVar.a();
                return;
            }
        }
        statLogger = h;
        stringBuilder = new StringBuilder("Failed to store event:");
        stringBuilder.append(eVar.g());
        statLogger.error(stringBuilder.toString());
    }

    private synchronized void a(List<bd> list, int i, boolean z) {
        Throwable th;
        if (list.size() != 0) {
            int b = b(z);
            SQLiteDatabase sQLiteDatabase = null;
            try {
                StringBuilder stringBuilder;
                String stringBuilder2;
                StringBuilder stringBuilder3;
                String stringBuilder4;
                SQLiteDatabase c = c(z);
                if (i == 2) {
                    try {
                        stringBuilder = new StringBuilder("update events set status=");
                        stringBuilder.append(i);
                        stringBuilder.append(", send_count=send_count+1  where ");
                        stringBuilder.append(a((List) list));
                        stringBuilder2 = stringBuilder.toString();
                    } catch (Throwable th2) {
                        th = th2;
                        if (c != null) {
                            c.endTransaction();
                        }
                        throw th;
                    }
                }
                StringBuilder stringBuilder5 = new StringBuilder("update events set status=");
                stringBuilder5.append(i);
                stringBuilder5.append(" where ");
                stringBuilder5.append(a((List) list));
                stringBuilder2 = stringBuilder5.toString();
                if (this.k % 3 == 0) {
                    stringBuilder3 = new StringBuilder("delete from events where send_count>");
                    stringBuilder3.append(b);
                    stringBuilder4 = stringBuilder3.toString();
                }
                this.k++;
                if (StatConfig.isDebugEnable()) {
                    StatLogger statLogger = h;
                    stringBuilder = new StringBuilder("update sql:");
                    stringBuilder.append(stringBuilder2);
                    statLogger.i(stringBuilder.toString());
                }
                c.beginTransaction();
                c.execSQL(stringBuilder2);
                if (stringBuilder4 != null) {
                    StatLogger statLogger2 = h;
                    stringBuilder3 = new StringBuilder("update for delete sql:");
                    stringBuilder3.append(stringBuilder4);
                    statLogger2.i(stringBuilder3.toString());
                    c.execSQL(stringBuilder4);
                    f();
                }
                c.setTransactionSuccessful();
                if (c != null) {
                    try {
                        c.endTransaction();
                    } catch (Throwable th3) {
                        h.e(th3);
                    }
                }
            } catch (Throwable th4) {
                th3 = th4;
                h.e(th3);
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
            }
        }
    }

    private synchronized void a(List<bd> list, boolean z) {
        SQLiteDatabase c;
        Throwable th;
        Throwable th2;
        if (list.size() != 0) {
            if (StatConfig.isDebugEnable()) {
                StatLogger statLogger = h;
                StringBuilder stringBuilder = new StringBuilder("Delete ");
                stringBuilder.append(list.size());
                stringBuilder.append(" events, important:");
                stringBuilder.append(z);
                statLogger.i(stringBuilder.toString());
            }
            StringBuilder stringBuilder2 = new StringBuilder(3 * list.size());
            stringBuilder2.append("event_id in (");
            int i = 0;
            int size = list.size();
            for (bd bdVar : list) {
                stringBuilder2.append(bdVar.a);
                if (i != size - 1) {
                    stringBuilder2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                i++;
            }
            stringBuilder2.append(k.t);
            try {
                c = c(z);
                try {
                    c.beginTransaction();
                    int delete = c.delete("events", stringBuilder2.toString(), null);
                    if (StatConfig.isDebugEnable()) {
                        StatLogger statLogger2 = h;
                        StringBuilder stringBuilder3 = new StringBuilder("delete ");
                        stringBuilder3.append(size);
                        stringBuilder3.append(" event ");
                        stringBuilder3.append(stringBuilder2.toString());
                        stringBuilder3.append(", success delete:");
                        stringBuilder3.append(delete);
                        statLogger2.i(stringBuilder3.toString());
                    }
                    this.a -= delete;
                    c.setTransactionSuccessful();
                    f();
                    if (c != null) {
                        try {
                            c.endTransaction();
                        } catch (Throwable th3) {
                            h.e(th3);
                        }
                    }
                } catch (Throwable th4) {
                    th3 = th4;
                    try {
                        h.e(th3);
                        if (c != null) {
                            try {
                                c.endTransaction();
                            } catch (Throwable th32) {
                                h.e(th32);
                            }
                        }
                    } catch (Throwable th5) {
                        th32 = th5;
                        if (c != null) {
                            try {
                                c.endTransaction();
                            } catch (Throwable th6) {
                                h.e(th6);
                            }
                        }
                        throw th32;
                    }
                }
            } catch (Throwable th62) {
                th2 = th62;
                c = null;
                th32 = th2;
                if (c != null) {
                    c.endTransaction();
                }
                throw th32;
            }
        }
    }

    private void a(boolean z) {
        SQLiteDatabase c;
        Throwable th;
        try {
            c = c(z);
            try {
                c.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("status", Integer.valueOf(1));
                int update = c.update("events", contentValues, "status=?", new String[]{Long.toString(2)});
                if (StatConfig.isDebugEnable()) {
                    StatLogger statLogger = h;
                    StringBuilder stringBuilder = new StringBuilder("update ");
                    stringBuilder.append(update);
                    stringBuilder.append(" unsent events.");
                    statLogger.i(stringBuilder.toString());
                }
                c.setTransactionSuccessful();
                if (c != null) {
                    try {
                        c.endTransaction();
                    } catch (Throwable th2) {
                        h.e(th2);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                try {
                    h.e(th);
                    if (c != null) {
                        c.endTransaction();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    if (c != null) {
                        try {
                            c.endTransaction();
                        } catch (Throwable th22) {
                            h.e(th22);
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th222) {
            th = th222;
            c = null;
            if (c != null) {
                c.endTransaction();
            }
            throw th;
        }
    }

    private int b(boolean z) {
        return !z ? StatConfig.getMaxSendRetryCount() : StatConfig.getMaxImportantDataSendRetryCount();
    }

    public static au b() {
        return j;
    }

    private void b(int i, boolean z) {
        if (i == -1) {
            i = !z ? g() : h();
        }
        if (i > 0) {
            int sendPeriodMinutes = (StatConfig.getSendPeriodMinutes() * 60) * StatConfig.getNumEventsCommitPerSec();
            if (i > sendPeriodMinutes && sendPeriodMinutes > 0) {
                i = sendPeriodMinutes;
            }
            int a = StatConfig.a();
            int i2 = i / a;
            int i3 = i % a;
            if (StatConfig.isDebugEnable()) {
                StatLogger statLogger = h;
                StringBuilder stringBuilder = new StringBuilder("sentStoreEventsByDb sendNumbers=");
                stringBuilder.append(i);
                stringBuilder.append(",important=");
                stringBuilder.append(z);
                stringBuilder.append(",maxSendNumPerFor1Period=");
                stringBuilder.append(sendPeriodMinutes);
                stringBuilder.append(",maxCount=");
                stringBuilder.append(i2);
                stringBuilder.append(",restNumbers=");
                stringBuilder.append(i3);
                statLogger.i(stringBuilder.toString());
            }
            for (i = 0; i < i2; i++) {
                a(a, z);
            }
            if (i3 > 0) {
                a(i3, z);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void b(com.tencent.wxop.stat.event.e r2, com.tencent.wxop.stat.h r3, boolean r4, boolean r5) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = com.tencent.wxop.stat.StatConfig.getMaxStoreEventCount();	 Catch:{ all -> 0x008a }
        if (r0 <= 0) goto L_0x0088;
    L_0x0007:
        r0 = com.tencent.wxop.stat.StatConfig.m;	 Catch:{ all -> 0x008a }
        if (r0 <= 0) goto L_0x0083;
    L_0x000b:
        if (r4 != 0) goto L_0x0083;
    L_0x000d:
        if (r5 == 0) goto L_0x0010;
    L_0x000f:
        goto L_0x0083;
    L_0x0010:
        r4 = com.tencent.wxop.stat.StatConfig.m;	 Catch:{ all -> 0x008a }
        if (r4 <= 0) goto L_0x0088;
    L_0x0014:
        r4 = com.tencent.wxop.stat.StatConfig.isDebugEnable();	 Catch:{ all -> 0x008a }
        if (r4 == 0) goto L_0x005e;
    L_0x001a:
        r4 = h;	 Catch:{ all -> 0x008a }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008a }
        r0 = "cacheEventsInMemory.size():";
        r5.<init>(r0);	 Catch:{ all -> 0x008a }
        r0 = r1.l;	 Catch:{ all -> 0x008a }
        r0 = r0.size();	 Catch:{ all -> 0x008a }
        r5.append(r0);	 Catch:{ all -> 0x008a }
        r0 = ",numEventsCachedInMemory:";
        r5.append(r0);	 Catch:{ all -> 0x008a }
        r0 = com.tencent.wxop.stat.StatConfig.m;	 Catch:{ all -> 0x008a }
        r5.append(r0);	 Catch:{ all -> 0x008a }
        r0 = ",numStoredEvents:";
        r5.append(r0);	 Catch:{ all -> 0x008a }
        r0 = r1.a;	 Catch:{ all -> 0x008a }
        r5.append(r0);	 Catch:{ all -> 0x008a }
        r5 = r5.toString();	 Catch:{ all -> 0x008a }
        r4.i(r5);	 Catch:{ all -> 0x008a }
        r4 = h;	 Catch:{ all -> 0x008a }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008a }
        r0 = "cache event:";
        r5.<init>(r0);	 Catch:{ all -> 0x008a }
        r0 = r2.g();	 Catch:{ all -> 0x008a }
        r5.append(r0);	 Catch:{ all -> 0x008a }
        r5 = r5.toString();	 Catch:{ all -> 0x008a }
        r4.i(r5);	 Catch:{ all -> 0x008a }
    L_0x005e:
        r4 = r1.l;	 Catch:{ all -> 0x008a }
        r5 = "";
        r4.put(r2, r5);	 Catch:{ all -> 0x008a }
        r2 = r1.l;	 Catch:{ all -> 0x008a }
        r2 = r2.size();	 Catch:{ all -> 0x008a }
        r4 = com.tencent.wxop.stat.StatConfig.m;	 Catch:{ all -> 0x008a }
        if (r2 < r4) goto L_0x0072;
    L_0x006f:
        r1.i();	 Catch:{ all -> 0x008a }
    L_0x0072:
        if (r3 == 0) goto L_0x0088;
    L_0x0074:
        r2 = r1.l;	 Catch:{ all -> 0x008a }
        r2 = r2.size();	 Catch:{ all -> 0x008a }
        if (r2 <= 0) goto L_0x007f;
    L_0x007c:
        r1.i();	 Catch:{ all -> 0x008a }
    L_0x007f:
        r3.a();	 Catch:{ all -> 0x008a }
        goto L_0x0088;
    L_0x0083:
        r1.a(r2, r3, r4);	 Catch:{ all -> 0x008a }
        monitor-exit(r1);
        return;
    L_0x0088:
        monitor-exit(r1);
        return;
    L_0x008a:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.au.b(com.tencent.wxop.stat.event.e, com.tencent.wxop.stat.h, boolean, boolean):void");
    }

    private synchronized void b(com.tencent.wxop.stat.f r13) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r12 = this;
        monitor-enter(r12);
        r0 = 0;
        r1 = r13.a();	 Catch:{ Throwable -> 0x00dd }
        r2 = com.tencent.wxop.stat.common.l.a(r1);	 Catch:{ Throwable -> 0x00dd }
        r3 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x00dd }
        r3.<init>();	 Catch:{ Throwable -> 0x00dd }
        r4 = "content";	 Catch:{ Throwable -> 0x00dd }
        r5 = r13.b;	 Catch:{ Throwable -> 0x00dd }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x00dd }
        r3.put(r4, r5);	 Catch:{ Throwable -> 0x00dd }
        r4 = "md5sum";	 Catch:{ Throwable -> 0x00dd }
        r3.put(r4, r2);	 Catch:{ Throwable -> 0x00dd }
        r13.c = r2;	 Catch:{ Throwable -> 0x00dd }
        r2 = "version";	 Catch:{ Throwable -> 0x00dd }
        r4 = r13.d;	 Catch:{ Throwable -> 0x00dd }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x00dd }
        r3.put(r2, r4);	 Catch:{ Throwable -> 0x00dd }
        r2 = r12.c;	 Catch:{ Throwable -> 0x00dd }
        r4 = r2.getReadableDatabase();	 Catch:{ Throwable -> 0x00dd }
        r5 = "config";	 Catch:{ Throwable -> 0x00dd }
        r6 = 0;	 Catch:{ Throwable -> 0x00dd }
        r7 = 0;	 Catch:{ Throwable -> 0x00dd }
        r8 = 0;	 Catch:{ Throwable -> 0x00dd }
        r9 = 0;	 Catch:{ Throwable -> 0x00dd }
        r10 = 0;	 Catch:{ Throwable -> 0x00dd }
        r11 = 0;	 Catch:{ Throwable -> 0x00dd }
        r2 = r4.query(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Throwable -> 0x00dd }
    L_0x003e:
        r4 = r2.moveToNext();	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r5 = 1;	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r6 = 0;	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        if (r4 == 0) goto L_0x0050;	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
    L_0x0046:
        r4 = r2.getInt(r6);	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r7 = r13.a;	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        if (r4 != r7) goto L_0x003e;	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
    L_0x004e:
        r4 = r5;	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        goto L_0x0051;	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
    L_0x0050:
        r4 = r6;	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
    L_0x0051:
        r7 = r12.c;	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r7 = r7.getWritableDatabase();	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r7.beginTransaction();	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        if (r5 != r4) goto L_0x0076;	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
    L_0x005c:
        r0 = r12.c;	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r0 = r0.getWritableDatabase();	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r4 = "config";	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r7 = "type=?";	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r5 = new java.lang.String[r5];	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r13 = r13.a;	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r13 = java.lang.Integer.toString(r13);	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r5[r6] = r13;	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r13 = r0.update(r4, r3, r7, r5);	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r3 = (long) r13;	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        goto L_0x008d;	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
    L_0x0076:
        r4 = "type";	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r13 = r13.a;	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r13 = java.lang.Integer.valueOf(r13);	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r3.put(r4, r13);	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r13 = r12.c;	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r13 = r13.getWritableDatabase();	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r4 = "config";	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r3 = r13.insert(r4, r0, r3);	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
    L_0x008d:
        r5 = -1;	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r13 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        if (r13 != 0) goto L_0x00a7;	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
    L_0x0093:
        r13 = h;	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r3 = "Failed to store cfg:";	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r0.<init>(r3);	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r0.append(r1);	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r13.e(r0);	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        goto L_0x00ba;	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
    L_0x00a7:
        r13 = h;	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r3 = "Sucessed to store cfg:";	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r0.<init>(r3);	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r0.append(r1);	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r13.d(r0);	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
    L_0x00ba:
        r13 = r12.c;	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r13 = r13.getWritableDatabase();	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        r13.setTransactionSuccessful();	 Catch:{ Throwable -> 0x00d7, all -> 0x00d5 }
        if (r2 == 0) goto L_0x00c8;
    L_0x00c5:
        r2.close();	 Catch:{ all -> 0x00fb }
    L_0x00c8:
        r13 = r12.c;	 Catch:{ Exception -> 0x00d3 }
        r13 = r13.getWritableDatabase();	 Catch:{ Exception -> 0x00d3 }
        r13.endTransaction();	 Catch:{ Exception -> 0x00d3 }
        monitor-exit(r12);
        return;
    L_0x00d3:
        monitor-exit(r12);
        return;
    L_0x00d5:
        r13 = move-exception;
        goto L_0x00f5;
    L_0x00d7:
        r13 = move-exception;
        r0 = r2;
        goto L_0x00de;
    L_0x00da:
        r13 = move-exception;
        r2 = r0;
        goto L_0x00f5;
    L_0x00dd:
        r13 = move-exception;
    L_0x00de:
        r1 = h;	 Catch:{ all -> 0x00da }
        r1.e(r13);	 Catch:{ all -> 0x00da }
        if (r0 == 0) goto L_0x00e8;
    L_0x00e5:
        r0.close();	 Catch:{ all -> 0x00fb }
    L_0x00e8:
        r13 = r12.c;	 Catch:{ Exception -> 0x00f3 }
        r13 = r13.getWritableDatabase();	 Catch:{ Exception -> 0x00f3 }
        r13.endTransaction();	 Catch:{ Exception -> 0x00f3 }
        monitor-exit(r12);
        return;
    L_0x00f3:
        monitor-exit(r12);
        return;
    L_0x00f5:
        if (r2 == 0) goto L_0x00fd;
    L_0x00f7:
        r2.close();	 Catch:{ all -> 0x00fb }
        goto L_0x00fd;
    L_0x00fb:
        r13 = move-exception;
        goto L_0x0107;
    L_0x00fd:
        r0 = r12.c;	 Catch:{ Exception -> 0x0106 }
        r0 = r0.getWritableDatabase();	 Catch:{ Exception -> 0x0106 }
        r0.endTransaction();	 Catch:{ Exception -> 0x0106 }
    L_0x0106:
        throw r13;	 Catch:{ all -> 0x00fb }
    L_0x0107:
        monitor-exit(r12);
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.au.b(com.tencent.wxop.stat.f):void");
    }

    private void b(List<bd> list, int i, boolean z) {
        Cursor query;
        Throwable th;
        Cursor cursor = null;
        try {
            query = d(z).query("events", null, "status=?", new String[]{Integer.toString(1)}, null, null, null, Integer.toString(i));
            while (query.moveToNext()) {
                try {
                    long j = query.getLong(0);
                    String string = query.getString(1);
                    if (!StatConfig.g) {
                        string = r.a(string);
                    }
                    String str = string;
                    int i2 = query.getInt(2);
                    int i3 = query.getInt(3);
                    bd bdVar = new bd(j, str, i2, i3);
                    if (StatConfig.isDebugEnable()) {
                        StatLogger statLogger = h;
                        StringBuilder stringBuilder = new StringBuilder("peek event, id=");
                        stringBuilder.append(j);
                        stringBuilder.append(",send_count=");
                        stringBuilder.append(i3);
                        stringBuilder.append(",timestamp=");
                        stringBuilder.append(query.getLong(4));
                        statLogger.i(stringBuilder.toString());
                    }
                    list.add(bdVar);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th3) {
            th = th3;
            try {
                h.e(th);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th4) {
                th = th4;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        }
    }

    private SQLiteDatabase c(boolean z) {
        return (!z ? this.c : this.d).getWritableDatabase();
    }

    private SQLiteDatabase d(boolean z) {
        return (!z ? this.c : this.d).getReadableDatabase();
    }

    private void f() {
        this.a = g() + h();
    }

    private int g() {
        return (int) DatabaseUtils.queryNumEntries(this.c.getReadableDatabase(), "events");
    }

    private int h() {
        return (int) DatabaseUtils.queryNumEntries(this.d.getReadableDatabase(), "events");
    }

    private void i() {
        Throwable th;
        if (!this.m) {
            synchronized (this.l) {
                if (this.l.size() == 0) {
                    return;
                }
                StatLogger statLogger;
                StatLogger statLogger2;
                StringBuilder stringBuilder;
                this.m = true;
                if (StatConfig.isDebugEnable()) {
                    statLogger = h;
                    StringBuilder stringBuilder2 = new StringBuilder("insert ");
                    stringBuilder2.append(this.l.size());
                    stringBuilder2.append(" events ,numEventsCachedInMemory:");
                    stringBuilder2.append(StatConfig.m);
                    stringBuilder2.append(",numStoredEvents:");
                    stringBuilder2.append(this.a);
                    statLogger.i(stringBuilder2.toString());
                }
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
                    try {
                        writableDatabase.beginTransaction();
                        Iterator it = this.l.entrySet().iterator();
                        while (it.hasNext()) {
                            com.tencent.wxop.stat.event.e eVar = (com.tencent.wxop.stat.event.e) ((Entry) it.next()).getKey();
                            ContentValues contentValues = new ContentValues();
                            String g = eVar.g();
                            if (StatConfig.isDebugEnable()) {
                                StatLogger statLogger3 = h;
                                StringBuilder stringBuilder3 = new StringBuilder("insert content:");
                                stringBuilder3.append(g);
                                statLogger3.i(stringBuilder3.toString());
                            }
                            contentValues.put("content", r.b(g));
                            contentValues.put("send_count", "0");
                            contentValues.put("status", Integer.toString(1));
                            contentValues.put("timestamp", Long.valueOf(eVar.c()));
                            writableDatabase.insert("events", null, contentValues);
                            it.remove();
                        }
                        writableDatabase.setTransactionSuccessful();
                        if (writableDatabase != null) {
                            try {
                                writableDatabase.endTransaction();
                                f();
                            } catch (Throwable th2) {
                                th = th2;
                                statLogger = h;
                                statLogger.e(th);
                                this.m = false;
                                if (StatConfig.isDebugEnable()) {
                                    statLogger2 = h;
                                    stringBuilder = new StringBuilder("after insert, cacheEventsInMemory.size():");
                                    stringBuilder.append(this.l.size());
                                    stringBuilder.append(",numEventsCachedInMemory:");
                                    stringBuilder.append(StatConfig.m);
                                    stringBuilder.append(",numStoredEvents:");
                                    stringBuilder.append(this.a);
                                    statLogger2.i(stringBuilder.toString());
                                }
                                return;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (writableDatabase != null) {
                            writableDatabase.endTransaction();
                            f();
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    h.e(th);
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                        f();
                    }
                    this.m = false;
                    if (StatConfig.isDebugEnable()) {
                        statLogger2 = h;
                        stringBuilder = new StringBuilder("after insert, cacheEventsInMemory.size():");
                        stringBuilder.append(this.l.size());
                        stringBuilder.append(",numEventsCachedInMemory:");
                        stringBuilder.append(StatConfig.m);
                        stringBuilder.append(",numStoredEvents:");
                        stringBuilder.append(this.a);
                        statLogger2.i(stringBuilder.toString());
                    }
                    return;
                }
                this.m = false;
                if (StatConfig.isDebugEnable()) {
                    statLogger2 = h;
                    stringBuilder = new StringBuilder("after insert, cacheEventsInMemory.size():");
                    stringBuilder.append(this.l.size());
                    stringBuilder.append(",numEventsCachedInMemory:");
                    stringBuilder.append(StatConfig.m);
                    stringBuilder.append(",numStoredEvents:");
                    stringBuilder.append(this.a);
                    statLogger2.i(stringBuilder.toString());
                }
            }
        }
    }

    private void j() {
        Cursor query;
        Throwable th;
        Throwable th2;
        try {
            query = this.c.getReadableDatabase().query("keyvalues", null, null, null, null, null, null);
            while (query.moveToNext()) {
                try {
                    this.n.put(query.getString(0), query.getString(1));
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th4) {
            th2 = th4;
            query = null;
            th = th2;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public int a() {
        return this.a;
    }

    void a(int i) {
        this.e.a(new bb(this, i));
    }

    void a(com.tencent.wxop.stat.event.e eVar, h hVar, boolean z, boolean z2) {
        if (this.e != null) {
            this.e.a(new ay(this, eVar, hVar, z, z2));
        }
    }

    void a(f fVar) {
        if (fVar != null) {
            this.e.a(new az(this, fVar));
        }
    }

    void a(List<bd> list, int i, boolean z, boolean z2) {
        if (this.e != null) {
            this.e.a(new av(this, list, i, z, z2));
        }
    }

    void a(List<bd> list, boolean z, boolean z2) {
        if (this.e != null) {
            this.e.a(new aw(this, list, z, z2));
        }
    }

    public synchronized a b(Context context) {
        a aVar;
        Cursor cursor;
        Throwable th;
        Throwable th2;
        Cursor cursor2;
        StatLogger statLogger;
        Cursor cursor3;
        au auVar = this;
        synchronized (this) {
            Cursor cursor4;
            try {
                if (auVar.b != null) {
                    aVar = auVar.b;
                    return aVar;
                }
                try {
                    auVar.c.getWritableDatabase().beginTransaction();
                    if (StatConfig.isDebugEnable()) {
                        try {
                            cursor = "try to load user info from db.";
                            h.i(cursor);
                        } catch (Throwable th22) {
                            th = th22;
                            cursor2 = null;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            auVar.c.getWritableDatabase().endTransaction();
                            throw th;
                        }
                    }
                    cursor = auVar.c.getReadableDatabase();
                    long j = MessageInfo.USER;
                    int i = 0;
                    int i2 = 0;
                    String str = null;
                    int i3 = 0;
                    int i4 = 0;
                    String str2 = null;
                    cursor4 = cursor.query(j, null, i, i2, str, i3, i4, str2);
                    try {
                        cursor = cursor4.moveToNext();
                        j = 1000;
                        i = 0;
                        i2 = 1;
                        String b;
                        String str3;
                        SQLiteDatabase writableDatabase;
                        if (cursor == true) {
                            int i5;
                            int currentTimeMillis;
                            try {
                                cursor = cursor4.getString(0);
                                str = r.a((String) cursor);
                                i3 = cursor4.getInt(1);
                                i4 = 2;
                                str2 = cursor4.getString(2);
                                i5 = cursor4.getLong(3);
                                currentTimeMillis = System.currentTimeMillis();
                            } catch (Throwable th3) {
                                th22 = th3;
                                cursor3 = cursor4;
                                th = th22;
                                cursor2 = cursor3;
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                auVar.c.getWritableDatabase().endTransaction();
                                throw th;
                            }
                            try {
                                String str4;
                                String c;
                                SQLiteDatabase writableDatabase2;
                                long j2 = currentTimeMillis / j;
                                i5 = (i3 == i2 || l.a(i5 * j).equals(l.a(j2 * j))) ? i3 : i2;
                                if (!str2.equals(l.l(context))) {
                                    i5 |= 2;
                                }
                                str2 = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                if (str2 == null || str2.length <= 0) {
                                    str = l.b(context);
                                    j = i2;
                                    str4 = str;
                                } else {
                                    str4 = str2[i];
                                    if (str4 != null) {
                                        currentTimeMillis = str4.length();
                                        if (currentTimeMillis < 11) {
                                        }
                                        j = i;
                                    }
                                    String a = r.a(context);
                                    if (a != null) {
                                        currentTimeMillis = 10;
                                        if (a.length() > 10) {
                                            str4 = a;
                                            j = i2;
                                        }
                                    }
                                    j = i;
                                }
                                if (str2 == null || str2.length < r11) {
                                    c = l.c(context);
                                    if (c != null && c.length() > 0) {
                                        StringBuilder stringBuilder = new StringBuilder();
                                        stringBuilder.append(str4);
                                        stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                        stringBuilder.append(c);
                                        str = stringBuilder.toString();
                                        j = i2;
                                    }
                                } else {
                                    c = str2[i2];
                                    StringBuilder stringBuilder2 = new StringBuilder();
                                    stringBuilder2.append(str4);
                                    stringBuilder2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                    stringBuilder2.append(c);
                                    str = stringBuilder2.toString();
                                }
                                auVar.b = new a(str4, c, i5);
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("uid", r.b(str));
                                contentValues.put("user_type", Integer.valueOf(i5));
                                i4 = l.l(context);
                                contentValues.put("app_ver", i4);
                                str = MsgConstant.KEY_TS;
                                contentValues.put(str, Long.valueOf(j2));
                                if (j != null) {
                                    writableDatabase2 = auVar.c.getWritableDatabase();
                                    cursor4 = MessageInfo.USER;
                                    j = "uid=?";
                                    str = new String[i2];
                                    str[i] = cursor;
                                    writableDatabase2.update(cursor4, contentValues, j, str);
                                }
                                if (i5 != i3) {
                                    writableDatabase2 = auVar.c.getWritableDatabase();
                                    cursor4 = MessageInfo.USER;
                                    writableDatabase2.replace(cursor4, null, contentValues);
                                }
                                if (i2 == 0) {
                                    b = l.b(context);
                                    cursor4 = l.c(context);
                                    if (cursor4 != null || cursor4.length() <= 0) {
                                        str3 = b;
                                    } else {
                                        StringBuilder stringBuilder3 = new StringBuilder();
                                        stringBuilder3.append(b);
                                        stringBuilder3.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                        stringBuilder3.append(cursor4);
                                        str3 = stringBuilder3.toString();
                                    }
                                    j = System.currentTimeMillis() / 1000;
                                    i2 = l.l(context);
                                    str = new ContentValues();
                                    str.put("uid", r.b(str3));
                                    i3 = Integer.valueOf(i);
                                    str.put("user_type", i3);
                                    str.put("app_ver", i2);
                                    str.put(MsgConstant.KEY_TS, Long.valueOf(j));
                                    writableDatabase = auVar.c.getWritableDatabase();
                                    j = MessageInfo.USER;
                                    writableDatabase.insert(j, null, str);
                                    auVar.b = new a(b, cursor4, i);
                                }
                                try {
                                    th = auVar.c.getWritableDatabase();
                                    th.setTransactionSuccessful();
                                    if (cursor3 != null) {
                                        cursor = cursor3;
                                        cursor.close();
                                    }
                                    auVar.c.getWritableDatabase().endTransaction();
                                } catch (Throwable th4) {
                                    th22 = th4;
                                    cursor = cursor3;
                                    th = th22;
                                    cursor2 = cursor;
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    auVar.c.getWritableDatabase().endTransaction();
                                    throw th;
                                }
                            } catch (Throwable th5) {
                                th22 = th5;
                                th = th22;
                                cursor2 = cursor3;
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                auVar.c.getWritableDatabase().endTransaction();
                                throw th;
                            }
                            aVar = auVar.b;
                            return aVar;
                        }
                        cursor3 = cursor4;
                        i2 = 0;
                        if (i2 == 0) {
                            b = l.b(context);
                            cursor4 = l.c(context);
                            if (cursor4 != null) {
                            }
                            str3 = b;
                            j = System.currentTimeMillis() / 1000;
                            i2 = l.l(context);
                            str = new ContentValues();
                            str.put("uid", r.b(str3));
                            i3 = Integer.valueOf(i);
                            str.put("user_type", i3);
                            str.put("app_ver", i2);
                            str.put(MsgConstant.KEY_TS, Long.valueOf(j));
                            writableDatabase = auVar.c.getWritableDatabase();
                            j = MessageInfo.USER;
                            writableDatabase.insert(j, null, str);
                            auVar.b = new a(b, cursor4, i);
                        }
                        th = auVar.c.getWritableDatabase();
                        th.setTransactionSuccessful();
                        if (cursor3 != null) {
                            cursor = cursor3;
                            cursor.close();
                        }
                        auVar.c.getWritableDatabase().endTransaction();
                        aVar = auVar.b;
                        return aVar;
                    } catch (Throwable th6) {
                        th22 = th6;
                        cursor = cursor4;
                        th = th22;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        auVar.c.getWritableDatabase().endTransaction();
                        throw th;
                    }
                } catch (Throwable th7) {
                    th22 = th7;
                    cursor2 = null;
                    th = th22;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    auVar.c.getWritableDatabase().endTransaction();
                    throw th;
                }
            } catch (Cursor th8) {
                statLogger = h;
                statLogger.e(th);
                aVar = auVar.b;
                return aVar;
            } finally {
                Object obj = 
/*
Method generation error in method: com.tencent.wxop.stat.au.b(android.content.Context):com.tencent.wxop.stat.common.a
jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0244: MERGE  (r2_29 'obj' java.lang.Object) = (r0_10 'th8' android.database.Cursor), (r3_22 'cursor4' android.database.Cursor) in method: com.tencent.wxop.stat.au.b(android.content.Context):com.tencent.wxop.stat.common.a
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:203)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:100)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:50)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:297)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:227)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:328)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:265)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:228)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:83)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:19)
	at jadx.core.ProcessClass.process(ProcessClass.java:43)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:530)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:514)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 27 more

*/

                void c() {
                    if (StatConfig.isEnableStatService()) {
                        try {
                            this.e.a(new ax(this));
                        } catch (Throwable th) {
                            h.e(th);
                        }
                    }
                }

                void d() {
                    Throwable th;
                    Throwable th2;
                    Cursor query;
                    try {
                        query = this.c.getReadableDatabase().query("config", null, null, null, null, null, null);
                        while (query.moveToNext()) {
                            try {
                                int i = query.getInt(0);
                                String string = query.getString(1);
                                String string2 = query.getString(2);
                                int i2 = query.getInt(3);
                                f fVar = new f(i);
                                fVar.a = i;
                                fVar.b = new JSONObject(string);
                                fVar.c = string2;
                                fVar.d = i2;
                                StatConfig.a(i, fVar);
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                        if (query != null) {
                            query.close();
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        query = null;
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            }
