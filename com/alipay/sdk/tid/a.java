package com.alipay.sdk.tid;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.alipay.sdk.encrypt.b;
import java.lang.ref.WeakReference;

public final class a extends SQLiteOpenHelper {
    private static final String a = "msp.db";
    private static final int b = 1;
    private WeakReference<Context> c;

    public a(Context context) {
        super(context, a, null, 1);
        this.c = new WeakReference(context);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists tb_tid (name text primary key, tid text, key_tid text, dt datetime);");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("drop table if exists tb_tid");
        onCreate(sQLiteDatabase);
    }

    public final void a(java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r8 = this;
        r0 = 0;
        r7 = r8.getWritableDatabase();	 Catch:{ Exception -> 0x009d, all -> 0x008f }
        r1 = a(r7, r9, r10);	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        if (r1 == 0) goto L_0x0015;	 Catch:{ Exception -> 0x008d, all -> 0x008b }
    L_0x000b:
        r1 = r8;	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r2 = r7;	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r3 = r9;	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r4 = r10;	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r5 = r11;	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r6 = r12;	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        goto L_0x007f;	 Catch:{ Exception -> 0x008d, all -> 0x008b }
    L_0x0015:
        r1 = "insert into tb_tid (name, tid, key_tid, dt) values (?, ?, ?, datetime('now', 'localtime'))";	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r2 = r8.c;	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r2 = r2.get();	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r2 = (android.content.Context) r2;	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r2 = com.alipay.sdk.util.a.c(r2);	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r3 = 1;	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r11 = com.alipay.sdk.encrypt.b.a(r3, r11, r2);	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r2 = 3;	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r9 = c(r9, r10);	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r10 = 0;	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r2[r10] = r9;	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r2[r3] = r11;	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r9 = 2;	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r2[r9] = r12;	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r7.execSQL(r1, r2);	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r9 = "select name from tb_tid where tid!='' order by dt asc";	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r9 = r7.rawQuery(r9, r0);	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r11 = r9.getCount();	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r12 = 14;	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        if (r11 > r12) goto L_0x004c;	 Catch:{ Exception -> 0x008d, all -> 0x008b }
    L_0x0048:
        r9.close();	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        goto L_0x007f;	 Catch:{ Exception -> 0x008d, all -> 0x008b }
    L_0x004c:
        r11 = r9.getCount();	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r11 = r11 - r12;	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r12 = new java.lang.String[r11];	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r0 = r9.moveToFirst();	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        if (r0 == 0) goto L_0x006a;	 Catch:{ Exception -> 0x008d, all -> 0x008b }
    L_0x0059:
        r0 = r10;	 Catch:{ Exception -> 0x008d, all -> 0x008b }
    L_0x005a:
        r1 = r9.getString(r10);	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r12[r0] = r1;	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r0 = r0 + 1;	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r1 = r9.moveToNext();	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        if (r1 == 0) goto L_0x006a;	 Catch:{ Exception -> 0x008d, all -> 0x008b }
    L_0x0068:
        if (r11 > r0) goto L_0x005a;	 Catch:{ Exception -> 0x008d, all -> 0x008b }
    L_0x006a:
        r9.close();	 Catch:{ Exception -> 0x008d, all -> 0x008b }
    L_0x006d:
        if (r10 >= r11) goto L_0x007f;	 Catch:{ Exception -> 0x008d, all -> 0x008b }
    L_0x006f:
        r9 = r12[r10];	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        r9 = android.text.TextUtils.isEmpty(r9);	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        if (r9 != 0) goto L_0x007c;	 Catch:{ Exception -> 0x008d, all -> 0x008b }
    L_0x0077:
        r9 = r12[r10];	 Catch:{ Exception -> 0x008d, all -> 0x008b }
        a(r7, r9);	 Catch:{ Exception -> 0x008d, all -> 0x008b }
    L_0x007c:
        r10 = r10 + 1;
        goto L_0x006d;
    L_0x007f:
        if (r7 == 0) goto L_0x00a9;
    L_0x0081:
        r9 = r7.isOpen();
        if (r9 == 0) goto L_0x00a9;
    L_0x0087:
        r7.close();
        return;
    L_0x008b:
        r9 = move-exception;
        goto L_0x0091;
    L_0x008d:
        r0 = r7;
        goto L_0x009d;
    L_0x008f:
        r9 = move-exception;
        r7 = r0;
    L_0x0091:
        if (r7 == 0) goto L_0x009c;
    L_0x0093:
        r10 = r7.isOpen();
        if (r10 == 0) goto L_0x009c;
    L_0x0099:
        r7.close();
    L_0x009c:
        throw r9;
    L_0x009d:
        if (r0 == 0) goto L_0x00a9;
    L_0x009f:
        r9 = r0.isOpen();
        if (r9 == 0) goto L_0x00a9;
    L_0x00a5:
        r0.close();
        return;
    L_0x00a9:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.tid.a.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    private void d(java.lang.String r9, java.lang.String r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r8 = this;
        r0 = 0;
        r7 = r8.getWritableDatabase();	 Catch:{ Exception -> 0x0035, all -> 0x0027 }
        r5 = "";	 Catch:{ Exception -> 0x0025, all -> 0x0023 }
        r6 = "";	 Catch:{ Exception -> 0x0025, all -> 0x0023 }
        r1 = r8;	 Catch:{ Exception -> 0x0025, all -> 0x0023 }
        r2 = r7;	 Catch:{ Exception -> 0x0025, all -> 0x0023 }
        r3 = r9;	 Catch:{ Exception -> 0x0025, all -> 0x0023 }
        r4 = r10;	 Catch:{ Exception -> 0x0025, all -> 0x0023 }
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x0025, all -> 0x0023 }
        r9 = c(r9, r10);	 Catch:{ Exception -> 0x0025, all -> 0x0023 }
        a(r7, r9);	 Catch:{ Exception -> 0x0025, all -> 0x0023 }
        if (r7 == 0) goto L_0x0041;
    L_0x0019:
        r9 = r7.isOpen();
        if (r9 == 0) goto L_0x0041;
    L_0x001f:
        r7.close();
        return;
    L_0x0023:
        r9 = move-exception;
        goto L_0x0029;
    L_0x0025:
        r0 = r7;
        goto L_0x0035;
    L_0x0027:
        r9 = move-exception;
        r7 = r0;
    L_0x0029:
        if (r7 == 0) goto L_0x0034;
    L_0x002b:
        r10 = r7.isOpen();
        if (r10 == 0) goto L_0x0034;
    L_0x0031:
        r7.close();
    L_0x0034:
        throw r9;
    L_0x0035:
        if (r0 == 0) goto L_0x0041;
    L_0x0037:
        r9 = r0.isOpen();
        if (r9 == 0) goto L_0x0041;
    L_0x003d:
        r0.close();
        return;
    L_0x0041:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.tid.a.d(java.lang.String, java.lang.String):void");
    }

    public final java.lang.String a(java.lang.String r5, java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r4 = this;
        r0 = "select tid from tb_tid where name=?";
        r1 = 0;
        r2 = r4.getReadableDatabase();	 Catch:{ Exception -> 0x004b, all -> 0x0038 }
        r3 = 1;
        r3 = new java.lang.String[r3];	 Catch:{ Exception -> 0x0036, all -> 0x0034 }
        r5 = c(r5, r6);	 Catch:{ Exception -> 0x0036, all -> 0x0034 }
        r6 = 0;	 Catch:{ Exception -> 0x0036, all -> 0x0034 }
        r3[r6] = r5;	 Catch:{ Exception -> 0x0036, all -> 0x0034 }
        r5 = r2.rawQuery(r0, r3);	 Catch:{ Exception -> 0x0036, all -> 0x0034 }
        r0 = r5.moveToFirst();	 Catch:{ Exception -> 0x004d, all -> 0x0031 }
        if (r0 == 0) goto L_0x0020;	 Catch:{ Exception -> 0x004d, all -> 0x0031 }
    L_0x001b:
        r6 = r5.getString(r6);	 Catch:{ Exception -> 0x004d, all -> 0x0031 }
        r1 = r6;
    L_0x0020:
        if (r5 == 0) goto L_0x0025;
    L_0x0022:
        r5.close();
    L_0x0025:
        if (r2 == 0) goto L_0x005b;
    L_0x0027:
        r5 = r2.isOpen();
        if (r5 == 0) goto L_0x005b;
    L_0x002d:
        r2.close();
        goto L_0x005b;
    L_0x0031:
        r6 = move-exception;
        r1 = r5;
        goto L_0x003a;
    L_0x0034:
        r6 = move-exception;
        goto L_0x003a;
    L_0x0036:
        r5 = r1;
        goto L_0x004d;
    L_0x0038:
        r6 = move-exception;
        r2 = r1;
    L_0x003a:
        if (r1 == 0) goto L_0x003f;
    L_0x003c:
        r1.close();
    L_0x003f:
        if (r2 == 0) goto L_0x004a;
    L_0x0041:
        r5 = r2.isOpen();
        if (r5 == 0) goto L_0x004a;
    L_0x0047:
        r2.close();
    L_0x004a:
        throw r6;
    L_0x004b:
        r5 = r1;
        r2 = r5;
    L_0x004d:
        if (r5 == 0) goto L_0x0052;
    L_0x004f:
        r5.close();
    L_0x0052:
        if (r2 == 0) goto L_0x005b;
    L_0x0054:
        r5 = r2.isOpen();
        if (r5 == 0) goto L_0x005b;
    L_0x005a:
        goto L_0x002d;
    L_0x005b:
        r5 = android.text.TextUtils.isEmpty(r1);
        if (r5 != 0) goto L_0x0072;
    L_0x0061:
        r5 = r4.c;
        r5 = r5.get();
        r5 = (android.content.Context) r5;
        r5 = com.alipay.sdk.util.a.c(r5);
        r6 = 2;
        r1 = com.alipay.sdk.encrypt.b.a(r6, r1, r5);
    L_0x0072:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.tid.a.a(java.lang.String, java.lang.String):java.lang.String");
    }

    private long e(java.lang.String r7, java.lang.String r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r6 = this;
        r0 = "select dt from tb_tid where name=?";
        r1 = 0;
        r2 = 0;
        r4 = r6.getReadableDatabase();	 Catch:{ Exception -> 0x0061, all -> 0x004d }
        r5 = 1;
        r5 = new java.lang.String[r5];	 Catch:{ Exception -> 0x0062, all -> 0x004a }
        r7 = c(r7, r8);	 Catch:{ Exception -> 0x0062, all -> 0x004a }
        r8 = 0;	 Catch:{ Exception -> 0x0062, all -> 0x004a }
        r5[r8] = r7;	 Catch:{ Exception -> 0x0062, all -> 0x004a }
        r7 = r4.rawQuery(r0, r5);	 Catch:{ Exception -> 0x0062, all -> 0x004a }
        r0 = r7.moveToFirst();	 Catch:{ Exception -> 0x0048, all -> 0x0046 }
        if (r0 == 0) goto L_0x0035;	 Catch:{ Exception -> 0x0048, all -> 0x0046 }
    L_0x001d:
        r0 = new java.text.SimpleDateFormat;	 Catch:{ Exception -> 0x0048, all -> 0x0046 }
        r1 = "yyyy-MM-dd HH:mm:ss";	 Catch:{ Exception -> 0x0048, all -> 0x0046 }
        r5 = java.util.Locale.getDefault();	 Catch:{ Exception -> 0x0048, all -> 0x0046 }
        r0.<init>(r1, r5);	 Catch:{ Exception -> 0x0048, all -> 0x0046 }
        r8 = r7.getString(r8);	 Catch:{ Exception -> 0x0048, all -> 0x0046 }
        r8 = r0.parse(r8);	 Catch:{ Exception -> 0x0048, all -> 0x0046 }
        r0 = r8.getTime();	 Catch:{ Exception -> 0x0048, all -> 0x0046 }
        r2 = r0;
    L_0x0035:
        if (r7 == 0) goto L_0x003a;
    L_0x0037:
        r7.close();
    L_0x003a:
        if (r4 == 0) goto L_0x0070;
    L_0x003c:
        r7 = r4.isOpen();
        if (r7 == 0) goto L_0x0070;
    L_0x0042:
        r4.close();
        goto L_0x0070;
    L_0x0046:
        r8 = move-exception;
        goto L_0x0050;
    L_0x0048:
        r1 = r7;
        goto L_0x0062;
    L_0x004a:
        r8 = move-exception;
        r7 = r1;
        goto L_0x0050;
    L_0x004d:
        r8 = move-exception;
        r7 = r1;
        r4 = r7;
    L_0x0050:
        if (r7 == 0) goto L_0x0055;
    L_0x0052:
        r7.close();
    L_0x0055:
        if (r4 == 0) goto L_0x0060;
    L_0x0057:
        r7 = r4.isOpen();
        if (r7 == 0) goto L_0x0060;
    L_0x005d:
        r4.close();
    L_0x0060:
        throw r8;
    L_0x0061:
        r4 = r1;
    L_0x0062:
        if (r1 == 0) goto L_0x0067;
    L_0x0064:
        r1.close();
    L_0x0067:
        if (r4 == 0) goto L_0x0070;
    L_0x0069:
        r7 = r4.isOpen();
        if (r7 == 0) goto L_0x0070;
    L_0x006f:
        goto L_0x0042;
    L_0x0070:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.tid.a.e(java.lang.String, java.lang.String):long");
    }

    private java.util.List<java.lang.String> a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r6 = this;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = 0;
        r2 = r6.getReadableDatabase();	 Catch:{ Exception -> 0x005f, all -> 0x004b }
        r3 = "select tid from tb_tid";	 Catch:{ Exception -> 0x0060, all -> 0x0048 }
        r3 = r2.rawQuery(r3, r1);	 Catch:{ Exception -> 0x0060, all -> 0x0048 }
    L_0x0010:
        r1 = r3.moveToNext();	 Catch:{ Exception -> 0x0046, all -> 0x0044 }
        if (r1 == 0) goto L_0x0036;	 Catch:{ Exception -> 0x0046, all -> 0x0044 }
    L_0x0016:
        r1 = 0;	 Catch:{ Exception -> 0x0046, all -> 0x0044 }
        r1 = r3.getString(r1);	 Catch:{ Exception -> 0x0046, all -> 0x0044 }
        r4 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x0046, all -> 0x0044 }
        if (r4 != 0) goto L_0x0010;	 Catch:{ Exception -> 0x0046, all -> 0x0044 }
    L_0x0021:
        r4 = r6.c;	 Catch:{ Exception -> 0x0046, all -> 0x0044 }
        r4 = r4.get();	 Catch:{ Exception -> 0x0046, all -> 0x0044 }
        r4 = (android.content.Context) r4;	 Catch:{ Exception -> 0x0046, all -> 0x0044 }
        r4 = com.alipay.sdk.util.a.c(r4);	 Catch:{ Exception -> 0x0046, all -> 0x0044 }
        r5 = 2;	 Catch:{ Exception -> 0x0046, all -> 0x0044 }
        r1 = com.alipay.sdk.encrypt.b.a(r5, r1, r4);	 Catch:{ Exception -> 0x0046, all -> 0x0044 }
        r0.add(r1);	 Catch:{ Exception -> 0x0046, all -> 0x0044 }
        goto L_0x0010;
    L_0x0036:
        if (r3 == 0) goto L_0x003b;
    L_0x0038:
        r3.close();
    L_0x003b:
        if (r2 == 0) goto L_0x0070;
    L_0x003d:
        r1 = r2.isOpen();
        if (r1 == 0) goto L_0x0070;
    L_0x0043:
        goto L_0x006d;
    L_0x0044:
        r0 = move-exception;
        goto L_0x004e;
    L_0x0046:
        r1 = r3;
        goto L_0x0060;
    L_0x0048:
        r0 = move-exception;
        r3 = r1;
        goto L_0x004e;
    L_0x004b:
        r0 = move-exception;
        r2 = r1;
        r3 = r2;
    L_0x004e:
        if (r3 == 0) goto L_0x0053;
    L_0x0050:
        r3.close();
    L_0x0053:
        if (r2 == 0) goto L_0x005e;
    L_0x0055:
        r1 = r2.isOpen();
        if (r1 == 0) goto L_0x005e;
    L_0x005b:
        r2.close();
    L_0x005e:
        throw r0;
    L_0x005f:
        r2 = r1;
    L_0x0060:
        if (r1 == 0) goto L_0x0065;
    L_0x0062:
        r1.close();
    L_0x0065:
        if (r2 == 0) goto L_0x0070;
    L_0x0067:
        r1 = r2.isOpen();
        if (r1 == 0) goto L_0x0070;
    L_0x006d:
        r2.close();
    L_0x0070:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.tid.a.a():java.util.List<java.lang.String>");
    }

    public final java.lang.String b(java.lang.String r5, java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r4 = this;
        r0 = "select key_tid from tb_tid where name=?";
        r1 = 0;
        r2 = r4.getReadableDatabase();	 Catch:{ Exception -> 0x004b, all -> 0x0038 }
        r3 = 1;
        r3 = new java.lang.String[r3];	 Catch:{ Exception -> 0x0036, all -> 0x0034 }
        r5 = c(r5, r6);	 Catch:{ Exception -> 0x0036, all -> 0x0034 }
        r6 = 0;	 Catch:{ Exception -> 0x0036, all -> 0x0034 }
        r3[r6] = r5;	 Catch:{ Exception -> 0x0036, all -> 0x0034 }
        r5 = r2.rawQuery(r0, r3);	 Catch:{ Exception -> 0x0036, all -> 0x0034 }
        r0 = r5.moveToFirst();	 Catch:{ Exception -> 0x004d, all -> 0x0031 }
        if (r0 == 0) goto L_0x0020;	 Catch:{ Exception -> 0x004d, all -> 0x0031 }
    L_0x001b:
        r6 = r5.getString(r6);	 Catch:{ Exception -> 0x004d, all -> 0x0031 }
        r1 = r6;
    L_0x0020:
        if (r5 == 0) goto L_0x0025;
    L_0x0022:
        r5.close();
    L_0x0025:
        if (r2 == 0) goto L_0x005b;
    L_0x0027:
        r5 = r2.isOpen();
        if (r5 == 0) goto L_0x005b;
    L_0x002d:
        r2.close();
        goto L_0x005b;
    L_0x0031:
        r6 = move-exception;
        r1 = r5;
        goto L_0x003a;
    L_0x0034:
        r6 = move-exception;
        goto L_0x003a;
    L_0x0036:
        r5 = r1;
        goto L_0x004d;
    L_0x0038:
        r6 = move-exception;
        r2 = r1;
    L_0x003a:
        if (r1 == 0) goto L_0x003f;
    L_0x003c:
        r1.close();
    L_0x003f:
        if (r2 == 0) goto L_0x004a;
    L_0x0041:
        r5 = r2.isOpen();
        if (r5 == 0) goto L_0x004a;
    L_0x0047:
        r2.close();
    L_0x004a:
        throw r6;
    L_0x004b:
        r5 = r1;
        r2 = r5;
    L_0x004d:
        if (r5 == 0) goto L_0x0052;
    L_0x004f:
        r5.close();
    L_0x0052:
        if (r2 == 0) goto L_0x005b;
    L_0x0054:
        r5 = r2.isOpen();
        if (r5 == 0) goto L_0x005b;
    L_0x005a:
        goto L_0x002d;
    L_0x005b:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.tid.a.b(java.lang.String, java.lang.String):java.lang.String");
    }

    private static boolean a(android.database.sqlite.SQLiteDatabase r5, java.lang.String r6, java.lang.String r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = "select count(*) from tb_tid where name=?";
        r1 = 1;
        r2 = 0;
        r3 = 0;
        r4 = new java.lang.String[r1];	 Catch:{ Exception -> 0x002d, all -> 0x0026 }
        r6 = c(r6, r7);	 Catch:{ Exception -> 0x002d, all -> 0x0026 }
        r4[r2] = r6;	 Catch:{ Exception -> 0x002d, all -> 0x0026 }
        r5 = r5.rawQuery(r0, r4);	 Catch:{ Exception -> 0x002d, all -> 0x0026 }
        r6 = r5.moveToFirst();	 Catch:{ Exception -> 0x002e, all -> 0x0023 }
        if (r6 == 0) goto L_0x001c;	 Catch:{ Exception -> 0x002e, all -> 0x0023 }
    L_0x0017:
        r6 = r5.getInt(r2);	 Catch:{ Exception -> 0x002e, all -> 0x0023 }
        goto L_0x001d;
    L_0x001c:
        r6 = r2;
    L_0x001d:
        if (r5 == 0) goto L_0x0034;
    L_0x001f:
        r5.close();
        goto L_0x0034;
    L_0x0023:
        r6 = move-exception;
        r3 = r5;
        goto L_0x0027;
    L_0x0026:
        r6 = move-exception;
    L_0x0027:
        if (r3 == 0) goto L_0x002c;
    L_0x0029:
        r3.close();
    L_0x002c:
        throw r6;
    L_0x002d:
        r5 = r3;
    L_0x002e:
        if (r5 == 0) goto L_0x0033;
    L_0x0030:
        r5.close();
    L_0x0033:
        r6 = r2;
    L_0x0034:
        if (r6 <= 0) goto L_0x0037;
    L_0x0036:
        return r1;
    L_0x0037:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.tid.a.a(android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String):boolean");
    }

    static String c(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    private void b(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String str4) {
        str3 = b.a(1, str3, com.alipay.sdk.util.a.c((Context) this.c.get()));
        r1 = new Object[3];
        str = c(str, str2);
        str2 = null;
        r1[0] = str;
        r1[1] = str3;
        r1[2] = str4;
        sQLiteDatabase.execSQL("insert into tb_tid (name, tid, key_tid, dt) values (?, ?, ?, datetime('now', 'localtime'))", r1);
        str = sQLiteDatabase.rawQuery("select name from tb_tid where tid!='' order by dt asc", null);
        if (str.getCount() <= 14) {
            str.close();
            return;
        }
        str3 = str.getCount() - 14;
        str4 = new String[str3];
        if (str.moveToFirst()) {
            int i = 0;
            do {
                str4[i] = str.getString(0);
                i++;
                if (!str.moveToNext()) {
                    break;
                }
            } while (str3 > i);
        }
        str.close();
        while (str2 < str3) {
            if (TextUtils.isEmpty(str4[str2]) == null) {
                a(sQLiteDatabase, str4[str2]);
            }
            str2++;
        }
    }

    final void a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String str4) {
        str3 = b.a(1, str3, com.alipay.sdk.util.a.c((Context) this.c.get()));
        sQLiteDatabase.execSQL("update tb_tid set tid=?, key_tid=?, dt=datetime('now', 'localtime') where name=?", new Object[]{str3, str4, c(str, str2)});
    }

    static void a(android.database.sqlite.SQLiteDatabase r4, java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = "tb_tid";	 Catch:{ Exception -> 0x000e }
        r1 = "name=?";	 Catch:{ Exception -> 0x000e }
        r2 = 1;	 Catch:{ Exception -> 0x000e }
        r2 = new java.lang.String[r2];	 Catch:{ Exception -> 0x000e }
        r3 = 0;	 Catch:{ Exception -> 0x000e }
        r2[r3] = r5;	 Catch:{ Exception -> 0x000e }
        r4.delete(r0, r1, r2);	 Catch:{ Exception -> 0x000e }
        return;
    L_0x000e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.tid.a.a(android.database.sqlite.SQLiteDatabase, java.lang.String):void");
    }

    private static void a(SQLiteDatabase sQLiteDatabase) {
        Cursor rawQuery = sQLiteDatabase.rawQuery("select name from tb_tid where tid!='' order by dt asc", null);
        if (rawQuery.getCount() <= 14) {
            rawQuery.close();
            return;
        }
        int count = rawQuery.getCount() - 14;
        String[] strArr = new String[count];
        int i = 0;
        if (rawQuery.moveToFirst()) {
            int i2 = 0;
            do {
                strArr[i2] = rawQuery.getString(0);
                i2++;
                if (!rawQuery.moveToNext()) {
                    break;
                }
            } while (count > i2);
        }
        rawQuery.close();
        while (i < count) {
            if (!TextUtils.isEmpty(strArr[i])) {
                a(sQLiteDatabase, strArr[i]);
            }
            i++;
        }
    }
}
