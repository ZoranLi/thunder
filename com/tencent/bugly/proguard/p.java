package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.bugly.beta.download.DownloadTask;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BUGLY */
public class p {
    public static p a = new p();

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.content.ContentValues a(java.lang.String r10) {
        /*
        r9 = this;
        monitor-enter(r9);
        r0 = android.text.TextUtils.isEmpty(r10);	 Catch:{ all -> 0x0099 }
        r1 = 0;
        if (r0 == 0) goto L_0x000a;
    L_0x0008:
        monitor-exit(r9);
        return r1;
    L_0x000a:
        r2 = com.tencent.bugly.proguard.ae.a();	 Catch:{ all -> 0x0099 }
        r3 = "dl_1002";
        r4 = 0;
        r5 = "_dUrl=?";
        r0 = 1;
        r6 = new java.lang.String[r0];	 Catch:{ all -> 0x0099 }
        r0 = 0;
        r6[r0] = r10;	 Catch:{ all -> 0x0099 }
        r7 = 0;
        r8 = 1;
        r10 = r2.a(r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x0099 }
        if (r10 == 0) goto L_0x0092;
    L_0x0021:
        r0 = r10.moveToFirst();	 Catch:{ all -> 0x0099 }
        if (r0 == 0) goto L_0x0092;
    L_0x0027:
        r1 = new android.content.ContentValues;	 Catch:{ all -> 0x0099 }
        r1.<init>();	 Catch:{ all -> 0x0099 }
        r0 = "_dUrl";
        r2 = "_dUrl";
        r2 = r10.getColumnIndex(r2);	 Catch:{ all -> 0x0099 }
        r2 = r10.getString(r2);	 Catch:{ all -> 0x0099 }
        r1.put(r0, r2);	 Catch:{ all -> 0x0099 }
        r0 = "_sFile";
        r2 = "_sFile";
        r2 = r10.getColumnIndex(r2);	 Catch:{ all -> 0x0099 }
        r2 = r10.getString(r2);	 Catch:{ all -> 0x0099 }
        r1.put(r0, r2);	 Catch:{ all -> 0x0099 }
        r0 = "_sLen";
        r2 = "_sLen";
        r2 = r10.getColumnIndex(r2);	 Catch:{ all -> 0x0099 }
        r2 = r10.getLong(r2);	 Catch:{ all -> 0x0099 }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x0099 }
        r1.put(r0, r2);	 Catch:{ all -> 0x0099 }
        r0 = "_tLen";
        r2 = "_tLen";
        r2 = r10.getColumnIndex(r2);	 Catch:{ all -> 0x0099 }
        r2 = r10.getLong(r2);	 Catch:{ all -> 0x0099 }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x0099 }
        r1.put(r0, r2);	 Catch:{ all -> 0x0099 }
        r0 = "_MD5";
        r2 = "_MD5";
        r2 = r10.getColumnIndex(r2);	 Catch:{ all -> 0x0099 }
        r2 = r10.getString(r2);	 Catch:{ all -> 0x0099 }
        r1.put(r0, r2);	 Catch:{ all -> 0x0099 }
        r0 = "_DLTIME";
        r2 = "_DLTIME";
        r2 = r10.getColumnIndex(r2);	 Catch:{ all -> 0x0099 }
        r2 = r10.getLong(r2);	 Catch:{ all -> 0x0099 }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x0099 }
        r1.put(r0, r2);	 Catch:{ all -> 0x0099 }
    L_0x0092:
        if (r10 == 0) goto L_0x0097;
    L_0x0094:
        r10.close();	 Catch:{ all -> 0x0099 }
    L_0x0097:
        monitor-exit(r9);
        return r1;
    L_0x0099:
        r10 = move-exception;
        monitor-exit(r9);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.p.a(java.lang.String):android.content.ContentValues");
    }

    public synchronized boolean a(DownloadTask downloadTask) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_dUrl", downloadTask.getDownloadUrl());
        contentValues.put("_sFile", downloadTask.getSaveFile().getAbsolutePath());
        contentValues.put("_sLen", Long.valueOf(downloadTask.getSavedLength()));
        contentValues.put("_tLen", Long.valueOf(downloadTask.getTotalLength()));
        contentValues.put("_MD5", downloadTask.getMD5());
        contentValues.put("_DLTIME", Long.valueOf(downloadTask.getCostTime()));
        return ae.a().a("dl_1002", contentValues, null, true) >= 0 ? true : null;
    }

    public synchronized int b(DownloadTask downloadTask) {
        return ae.a().a("dl_1002", "_dUrl = ?", new String[]{downloadTask.getDownloadUrl()}, null, true);
    }

    public synchronized int b(String str) {
        return ae.a().a("dl_1002", "_sFile = ?", new String[]{str}, null, true);
    }

    public synchronized List<w> a() {
        List<w> arrayList = new ArrayList();
        Cursor a = ae.a().a("ge_1002", null, null, null, null, true);
        while (a != null && a.moveToNext()) {
            w wVar = (w) ah.a(a.getBlob(a.getColumnIndex("_datas")), w.class);
            if (wVar != null) {
                arrayList.add(wVar);
            }
        }
        if (a != null) {
            a.close();
        }
        return arrayList.isEmpty() ? null : arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean a(com.tencent.bugly.proguard.w r8) {
        /*
        r7 = this;
        monitor-enter(r7);
        r0 = 0;
        if (r8 != 0) goto L_0x0006;
    L_0x0004:
        monitor-exit(r7);
        return r0;
    L_0x0006:
        r1 = com.tencent.bugly.proguard.ah.a(r8);	 Catch:{ all -> 0x003d }
        if (r1 == 0) goto L_0x003b;
    L_0x000c:
        r2 = r1.length;	 Catch:{ all -> 0x003d }
        if (r2 > 0) goto L_0x0010;
    L_0x000f:
        goto L_0x003b;
    L_0x0010:
        r2 = new android.content.ContentValues;	 Catch:{ all -> 0x003d }
        r2.<init>();	 Catch:{ all -> 0x003d }
        r3 = "_time";
        r4 = r8.b;	 Catch:{ all -> 0x003d }
        r8 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x003d }
        r2.put(r3, r8);	 Catch:{ all -> 0x003d }
        r8 = "_datas";
        r2.put(r8, r1);	 Catch:{ all -> 0x003d }
        r8 = com.tencent.bugly.proguard.ae.a();	 Catch:{ all -> 0x003d }
        r1 = "ge_1002";
        r3 = 0;
        r4 = 1;
        r1 = r8.a(r1, r2, r3, r4);	 Catch:{ all -> 0x003d }
        r5 = 0;
        r8 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1));
        if (r8 < 0) goto L_0x0039;
    L_0x0037:
        monitor-exit(r7);
        return r4;
    L_0x0039:
        monitor-exit(r7);
        return r0;
    L_0x003b:
        monitor-exit(r7);
        return r0;
    L_0x003d:
        r8 = move-exception;
        monitor-exit(r7);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.p.a(com.tencent.bugly.proguard.w):boolean");
    }

    public synchronized int b() {
        return ae.a().a("ge_1002", null, null, null, true);
    }

    public synchronized boolean a(int i, String str, byte[] bArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(i));
        contentValues.put("_tm", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("_tp", str);
        contentValues.put("_dt", bArr);
        return ae.a().a("st_1002", contentValues, (ad) null, true) >= 0;
    }

    public synchronized boolean c(String str) {
        return ae.a().a("st_1002", "_id = ? and _tp = ? ", new String[]{"1002", str}, null, true) > null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.Map<java.lang.String, byte[]> c() {
        /*
        r9 = this;
        monitor-enter(r9);
        r0 = 0;
        r4 = "_id = 1002";
        r1 = com.tencent.bugly.proguard.ae.a();	 Catch:{ Throwable -> 0x004c, all -> 0x0047 }
        r2 = "st_1002";
        r3 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 1;
        r1 = r1.a(r2, r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x004c, all -> 0x0047 }
        if (r1 != 0) goto L_0x001b;
    L_0x0014:
        if (r1 == 0) goto L_0x0019;
    L_0x0016:
        r1.close();	 Catch:{ all -> 0x0065 }
    L_0x0019:
        monitor-exit(r9);
        return r0;
    L_0x001b:
        r2 = new java.util.HashMap;	 Catch:{ Throwable -> 0x0045 }
        r2.<init>();	 Catch:{ Throwable -> 0x0045 }
    L_0x0020:
        r3 = r1.moveToNext();	 Catch:{ Throwable -> 0x0045 }
        if (r3 == 0) goto L_0x003e;
    L_0x0026:
        r3 = "_tp";
        r3 = r1.getColumnIndex(r3);	 Catch:{ Throwable -> 0x0045 }
        r3 = r1.getString(r3);	 Catch:{ Throwable -> 0x0045 }
        r4 = "_dt";
        r4 = r1.getColumnIndex(r4);	 Catch:{ Throwable -> 0x0045 }
        r4 = r1.getBlob(r4);	 Catch:{ Throwable -> 0x0045 }
        r2.put(r3, r4);	 Catch:{ Throwable -> 0x0045 }
        goto L_0x0020;
    L_0x003e:
        if (r1 == 0) goto L_0x0043;
    L_0x0040:
        r1.close();	 Catch:{ all -> 0x0065 }
    L_0x0043:
        monitor-exit(r9);
        return r2;
    L_0x0045:
        r2 = move-exception;
        goto L_0x004e;
    L_0x0047:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x005f;
    L_0x004c:
        r2 = move-exception;
        r1 = r0;
    L_0x004e:
        r3 = com.tencent.bugly.proguard.an.a(r2);	 Catch:{ all -> 0x005e }
        if (r3 != 0) goto L_0x0057;
    L_0x0054:
        r2.printStackTrace();	 Catch:{ all -> 0x005e }
    L_0x0057:
        if (r1 == 0) goto L_0x005c;
    L_0x0059:
        r1.close();	 Catch:{ all -> 0x0065 }
    L_0x005c:
        monitor-exit(r9);
        return r0;
    L_0x005e:
        r0 = move-exception;
    L_0x005f:
        if (r1 == 0) goto L_0x0067;
    L_0x0061:
        r1.close();	 Catch:{ all -> 0x0065 }
        goto L_0x0067;
    L_0x0065:
        r0 = move-exception;
        goto L_0x0068;
    L_0x0067:
        throw r0;	 Catch:{ all -> 0x0065 }
    L_0x0068:
        monitor-exit(r9);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.p.c():java.util.Map<java.lang.String, byte[]>");
    }
}
