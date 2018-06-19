package com.xiaomi.push.service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.misc.m;
import com.xiaomi.push.service.module.a;
import java.util.ArrayList;
import java.util.Iterator;

public class j {
    private static volatile j a;
    private Context b;

    private j(Context context) {
        this.b = context;
    }

    private synchronized Cursor a(SQLiteDatabase sQLiteDatabase) {
        m.a(false);
        try {
        } catch (Exception e) {
            b.d(e.toString());
            return null;
        }
        return sQLiteDatabase.query("geoMessage", null, null, null, null, null, null);
    }

    public static j a(Context context) {
        if (a == null) {
            synchronized (j.class) {
                if (a == null) {
                    a = new j(context);
                }
            }
        }
        return a;
    }

    public synchronized int a(String str) {
        m.a(false);
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            int delete = i.a(this.b).a().delete("geoMessage", "message_id = ?", new String[]{str});
            i.a(this.b).b();
            return delete;
        } catch (Exception e) {
            b.d(e.toString());
            return 0;
        }
    }

    public synchronized ArrayList<a> a() {
        ArrayList<a> arrayList;
        m.a(false);
        try {
            Cursor a = a(i.a(this.b).a());
            arrayList = new ArrayList();
            if (a != null) {
                while (a.moveToNext()) {
                    a aVar = new a();
                    aVar.a(a.getString(a.getColumnIndex("message_id")));
                    aVar.b(a.getString(a.getColumnIndex("geo_id")));
                    aVar.a(a.getBlob(a.getColumnIndex("content")));
                    aVar.a(a.getInt(a.getColumnIndex("action")));
                    aVar.a(a.getLong(a.getColumnIndex("deadline")));
                    arrayList.add(aVar);
                }
                a.close();
            }
            i.a(this.b).b();
        } catch (Exception e) {
            b.d(e.toString());
            return null;
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean a(java.util.ArrayList<android.content.ContentValues> r9) {
        /*
        r8 = this;
        monitor-enter(r8);
        r0 = 0;
        com.xiaomi.channel.commonutils.misc.m.a(r0);	 Catch:{ all -> 0x0059 }
        if (r9 == 0) goto L_0x0057;
    L_0x0007:
        r1 = r9.size();	 Catch:{ all -> 0x0059 }
        if (r1 > 0) goto L_0x000e;
    L_0x000d:
        goto L_0x0057;
    L_0x000e:
        r1 = 1;
        r2 = r8.b;	 Catch:{ Exception -> 0x004d }
        r2 = com.xiaomi.push.service.i.a(r2);	 Catch:{ Exception -> 0x004d }
        r2 = r2.a();	 Catch:{ Exception -> 0x004d }
        r2.beginTransaction();	 Catch:{ Exception -> 0x004d }
        r9 = r9.iterator();	 Catch:{ Exception -> 0x004d }
    L_0x0020:
        r3 = r9.hasNext();	 Catch:{ Exception -> 0x004d }
        if (r3 == 0) goto L_0x003a;
    L_0x0026:
        r3 = r9.next();	 Catch:{ Exception -> 0x004d }
        r3 = (android.content.ContentValues) r3;	 Catch:{ Exception -> 0x004d }
        r4 = "geoMessage";
        r5 = 0;
        r3 = r2.insert(r4, r5, r3);	 Catch:{ Exception -> 0x004d }
        r5 = -1;
        r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r7 != 0) goto L_0x0020;
    L_0x0039:
        r1 = r0;
    L_0x003a:
        if (r1 == 0) goto L_0x003f;
    L_0x003c:
        r2.setTransactionSuccessful();	 Catch:{ Exception -> 0x004d }
    L_0x003f:
        r2.endTransaction();	 Catch:{ Exception -> 0x004d }
        r9 = r8.b;	 Catch:{ Exception -> 0x004d }
        r9 = com.xiaomi.push.service.i.a(r9);	 Catch:{ Exception -> 0x004d }
        r9.b();	 Catch:{ Exception -> 0x004d }
        monitor-exit(r8);
        return r1;
    L_0x004d:
        r9 = move-exception;
        r9 = r9.toString();	 Catch:{ all -> 0x0059 }
        com.xiaomi.channel.commonutils.logger.b.d(r9);	 Catch:{ all -> 0x0059 }
        monitor-exit(r8);
        return r0;
    L_0x0057:
        monitor-exit(r8);
        return r0;
    L_0x0059:
        r9 = move-exception;
        monitor-exit(r8);
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.j.a(java.util.ArrayList):boolean");
    }

    public synchronized int b(String str) {
        m.a(false);
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            int delete = i.a(this.b).a().delete("geoMessage", "geo_id = ?", new String[]{str});
            i.a(this.b).b();
            return delete;
        } catch (Exception e) {
            b.d(e.toString());
            return 0;
        }
    }

    public synchronized ArrayList<a> c(String str) {
        m.a(false);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ArrayList a = a();
            ArrayList<a> arrayList = new ArrayList();
            Iterator it = a.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (TextUtils.equals(aVar.c(), str)) {
                    arrayList.add(aVar);
                }
            }
            return arrayList;
        } catch (Exception e) {
            b.d(e.toString());
            return null;
        }
    }
}
