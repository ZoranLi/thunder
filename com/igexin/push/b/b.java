package com.igexin.push.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class b extends SQLiteOpenHelper {
    private SQLiteDatabase a = null;

    public b(Context context) {
        super(context, "pushsdk.db", null, 3);
    }

    private String a(String[] strArr, String[] strArr2, int i) {
        StringBuilder stringBuilder = new StringBuilder(" ");
        int i2 = 0;
        if (strArr.length == 1) {
            for (int i3 = 0; i3 < i; i3++) {
                stringBuilder.append(strArr[0]);
                stringBuilder.append(" = '");
                stringBuilder.append(strArr2[i3]);
                stringBuilder.append("'");
                if (i3 < i - 1) {
                    stringBuilder.append(" or ");
                }
            }
        } else {
            while (i2 < i) {
                stringBuilder.append(strArr[i2]);
                stringBuilder.append(" = '");
                stringBuilder.append(strArr2[i2]);
                stringBuilder.append("'");
                if (i2 < i - 1) {
                    stringBuilder.append(" and ");
                }
                i2++;
            }
        }
        return stringBuilder.toString();
    }

    private String b(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder("delete from ");
        stringBuilder.append(str);
        stringBuilder.append(" where ");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    public int a(java.lang.String r3, java.lang.String r4) {
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
        r2 = this;
        r0 = r2.getWritableDatabase();
        r2.a = r0;
        r0 = r2.a;
        r0.beginTransaction();
        r0 = r2.a;	 Catch:{ Exception -> 0x001f, all -> 0x0018 }
        r1 = 0;	 Catch:{ Exception -> 0x001f, all -> 0x0018 }
        r3 = r0.delete(r3, r4, r1);	 Catch:{ Exception -> 0x001f, all -> 0x0018 }
        r4 = r2.a;	 Catch:{ Exception -> 0x0020, all -> 0x0018 }
        r4.setTransactionSuccessful();	 Catch:{ Exception -> 0x0020, all -> 0x0018 }
        goto L_0x0020;
    L_0x0018:
        r3 = move-exception;
        r4 = r2.a;
        r4.endTransaction();
        throw r3;
    L_0x001f:
        r3 = 0;
    L_0x0020:
        r4 = r2.a;
        r4.endTransaction();
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.b.b.a(java.lang.String, java.lang.String):int");
    }

    public android.database.Cursor a(java.lang.String r11, java.lang.String[] r12, java.lang.String[] r13, java.lang.String[] r14, java.lang.String r15) {
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
        r10 = this;
        r0 = r10.getReadableDatabase();
        r10.a = r0;
        r0 = r10.a;
        r0.beginTransaction();
        if (r12 != 0) goto L_0x001d;
    L_0x000d:
        r1 = r10.a;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r4 = 0;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r5 = 0;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r6 = 0;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r7 = 0;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r2 = r11;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r3 = r14;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r8 = r15;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r11 = r1.query(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        goto L_0x005f;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
    L_0x001b:
        r11 = move-exception;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        goto L_0x0065;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
    L_0x001d:
        r0 = r12.length;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r1 = 1;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        if (r0 != r1) goto L_0x0057;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
    L_0x0021:
        r0 = r13.length;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        if (r0 != r1) goto L_0x0045;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
    L_0x0024:
        r2 = r10.a;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r0.<init>();	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r1 = 0;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r12 = r12[r1];	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r0.append(r12);	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r12 = "= ?";	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r0.append(r12);	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r5 = r0.toString();	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r7 = 0;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r8 = 0;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r3 = r11;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r4 = r14;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r6 = r13;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r9 = r15;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r11 = r2.query(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        goto L_0x005f;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
    L_0x0045:
        r0 = r10.a;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r1 = r13.length;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r3 = r10.a(r12, r13, r1);	 Catch:{ Exception -> 0x006b, all -> 0x001b }
    L_0x004c:
        r4 = 0;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r5 = 0;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r6 = 0;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r1 = r11;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r2 = r14;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r7 = r15;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r11 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        goto L_0x005f;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
    L_0x0057:
        r0 = r10.a;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r1 = r12.length;	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        r3 = r10.a(r12, r13, r1);	 Catch:{ Exception -> 0x006b, all -> 0x001b }
        goto L_0x004c;
    L_0x005f:
        r12 = r10.a;	 Catch:{ Exception -> 0x006c, all -> 0x001b }
        r12.setTransactionSuccessful();	 Catch:{ Exception -> 0x006c, all -> 0x001b }
        goto L_0x006c;
    L_0x0065:
        r12 = r10.a;
        r12.endTransaction();
        throw r11;
    L_0x006b:
        r11 = 0;
    L_0x006c:
        r12 = r10.a;
        r12.endTransaction();
        return r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.b.b.a(java.lang.String, java.lang.String[], java.lang.String[], java.lang.String[], java.lang.String):android.database.Cursor");
    }

    public void a(java.lang.String r5, android.content.ContentValues r6, java.lang.String[] r7, java.lang.String[] r8) {
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
        r0 = r4.getWritableDatabase();
        r4.a = r0;
        r0 = r4.a;
        r0.beginTransaction();
        r0 = 0;
        if (r7 != 0) goto L_0x0016;
    L_0x000e:
        r7 = r4.a;	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
        r7.update(r5, r6, r0, r0);	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
        goto L_0x0051;	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
    L_0x0014:
        r5 = move-exception;	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
        goto L_0x005c;	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
    L_0x0016:
        r1 = r7.length;	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
        r2 = 1;	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
        if (r1 != r2) goto L_0x0049;	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
    L_0x001a:
        r1 = r8.length;	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
        if (r1 != r2) goto L_0x0041;	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
    L_0x001d:
        r1 = r4.a;	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
        r2.<init>();	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
        r3 = 0;	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
        r7 = r7[r3];	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
        r2.append(r7);	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
        r7 = "='";	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
        r2.append(r7);	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
        r7 = r8[r3];	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
        r2.append(r7);	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
        r7 = "'";	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
        r2.append(r7);	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
        r7 = r2.toString();	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
    L_0x003d:
        r1.update(r5, r6, r7, r0);	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
        goto L_0x0051;	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
    L_0x0041:
        r1 = r4.a;	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
        r2 = r8.length;	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
        r7 = r4.a(r7, r8, r2);	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
        goto L_0x003d;	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
    L_0x0049:
        r1 = r4.a;	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
        r2 = r7.length;	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
        r7 = r4.a(r7, r8, r2);	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
        goto L_0x003d;	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
    L_0x0051:
        r5 = r4.a;	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
        r5.setTransactionSuccessful();	 Catch:{ Exception -> 0x0056, all -> 0x0014 }
    L_0x0056:
        r5 = r4.a;
        r5.endTransaction();
        return;
    L_0x005c:
        r6 = r4.a;
        r6.endTransaction();
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.b.b.a(java.lang.String, android.content.ContentValues, java.lang.String[], java.lang.String[]):void");
    }

    public void a(java.lang.String r4, java.lang.String[] r5, java.lang.String[] r6) {
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
        r3 = this;
        r0 = r3.getWritableDatabase();
        r3.a = r0;
        r0 = r3.a;
        r0.beginTransaction();
        if (r5 != 0) goto L_0x0016;
    L_0x000d:
        r5 = r3.a;	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
        r6 = 0;	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
        r5.delete(r4, r6, r6);	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
        goto L_0x0052;	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
    L_0x0014:
        r4 = move-exception;	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
        goto L_0x005d;	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
    L_0x0016:
        r0 = r5.length;	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
        r1 = 1;	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
        if (r0 != r1) goto L_0x0046;	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
    L_0x001a:
        r0 = r6.length;	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
        if (r0 != r1) goto L_0x0037;	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
    L_0x001d:
        r0 = r3.a;	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
        r1.<init>();	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
        r2 = 0;	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
        r5 = r5[r2];	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
        r1.append(r5);	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
        r5 = " = ?";	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
        r1.append(r5);	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
        r5 = r1.toString();	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
        r0.delete(r4, r5, r6);	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
        goto L_0x0052;	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
    L_0x0037:
        r0 = r3.a;	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
        r1 = r6.length;	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
        r5 = r3.a(r5, r6, r1);	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
        r4 = r3.b(r4, r5);	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
    L_0x0042:
        r0.execSQL(r4);	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
        goto L_0x0052;	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
    L_0x0046:
        r0 = r3.a;	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
        r1 = r5.length;	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
        r5 = r3.a(r5, r6, r1);	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
        r4 = r3.b(r4, r5);	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
        goto L_0x0042;	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
    L_0x0052:
        r4 = r3.a;	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
        r4.setTransactionSuccessful();	 Catch:{ Exception -> 0x0057, all -> 0x0014 }
    L_0x0057:
        r4 = r3.a;
        r4.endTransaction();
        return;
    L_0x005d:
        r5 = r3.a;
        r5.endTransaction();
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.b.b.a(java.lang.String, java.lang.String[], java.lang.String[]):void");
    }

    public boolean a(java.lang.String r3, android.content.ContentValues r4) {
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
        r2 = this;
        r0 = r2.getWritableDatabase();
        r2.a = r0;
        r0 = r2.a;
        r0.beginTransaction();
        r0 = r2.a;	 Catch:{ Exception -> 0x001f, all -> 0x0018 }
        r1 = 0;	 Catch:{ Exception -> 0x001f, all -> 0x0018 }
        r0.insert(r3, r1, r4);	 Catch:{ Exception -> 0x001f, all -> 0x0018 }
        r3 = r2.a;	 Catch:{ Exception -> 0x001f, all -> 0x0018 }
        r3.setTransactionSuccessful();	 Catch:{ Exception -> 0x001f, all -> 0x0018 }
        r3 = 1;
        goto L_0x0020;
    L_0x0018:
        r3 = move-exception;
        r4 = r2.a;
        r4.endTransaction();
        throw r3;
    L_0x001f:
        r3 = 0;
    L_0x0020:
        r4 = r2.a;
        r4.endTransaction();
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.b.b.a(java.lang.String, android.content.ContentValues):boolean");
    }

    public void onCreate(android.database.sqlite.SQLiteDatabase r2) {
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
        r1 = this;
        r2.beginTransaction();
        r0 = "create table if not exists config (id integer primary key,value text)";	 Catch:{ Exception -> 0x0032, all -> 0x002d }
        r2.execSQL(r0);	 Catch:{ Exception -> 0x0032, all -> 0x002d }
        r0 = "create table if not exists runtime (id integer primary key,value text)";	 Catch:{ Exception -> 0x0032, all -> 0x002d }
        r2.execSQL(r0);	 Catch:{ Exception -> 0x0032, all -> 0x002d }
        r0 = "create table if not exists message (id integer primary key autoincrement,messageid text,taskid text,appid text,info text,msgextra blob,key text,status integer,createtime integer)";	 Catch:{ Exception -> 0x0032, all -> 0x002d }
        r2.execSQL(r0);	 Catch:{ Exception -> 0x0032, all -> 0x002d }
        r0 = "create table if not exists ral (id integer primary key,data text,type integer,time integer)";	 Catch:{ Exception -> 0x0032, all -> 0x002d }
        r2.execSQL(r0);	 Catch:{ Exception -> 0x0032, all -> 0x002d }
        r0 = "create table if not exists ca (pkgname text primary key,signature text,permissions text, accesstoken blob, expire integer)";	 Catch:{ Exception -> 0x0032, all -> 0x002d }
        r2.execSQL(r0);	 Catch:{ Exception -> 0x0032, all -> 0x002d }
        r0 = "create table if not exists bi(id integer primary key autoincrement, start_service_count integer, login_count integer, loginerror_nonetwork_count integer, loginerror_timeout_count integer, loginerror_connecterror_count integer, loginerror_other_count integer, online_time long, network_time long, running_time long, create_time text, type integer)";	 Catch:{ Exception -> 0x0032, all -> 0x002d }
        r2.execSQL(r0);	 Catch:{ Exception -> 0x0032, all -> 0x002d }
        r0 = "create table if not exists st(id integer primary key autoincrement,type integer,value blob,time integer)";	 Catch:{ Exception -> 0x0032, all -> 0x002d }
        r2.execSQL(r0);	 Catch:{ Exception -> 0x0032, all -> 0x002d }
        r2.setTransactionSuccessful();	 Catch:{ Exception -> 0x0032, all -> 0x002d }
        r2.endTransaction();
        return;
    L_0x002d:
        r0 = move-exception;
        r2.endTransaction();
        throw r0;
    L_0x0032:
        r2.endTransaction();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.b.b.onCreate(android.database.sqlite.SQLiteDatabase):void");
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i2, i);
    }

    public void onUpgrade(android.database.sqlite.SQLiteDatabase r1, int r2, int r3) {
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
        r0 = this;
        r2 = com.igexin.push.core.b.g.a();
        r2.d(r1);
        r2 = "drop table if exists config";	 Catch:{ Exception -> 0x000c }
        r1.execSQL(r2);	 Catch:{ Exception -> 0x000c }
    L_0x000c:
        r2 = "drop table if exists runtime";	 Catch:{ Exception -> 0x0011 }
        r1.execSQL(r2);	 Catch:{ Exception -> 0x0011 }
    L_0x0011:
        r2 = "drop table if exists message";	 Catch:{ Exception -> 0x0016 }
        r1.execSQL(r2);	 Catch:{ Exception -> 0x0016 }
    L_0x0016:
        r2 = "drop table if exists ral";	 Catch:{ Exception -> 0x001b }
        r1.execSQL(r2);	 Catch:{ Exception -> 0x001b }
    L_0x001b:
        r2 = "drop table if exists ca";	 Catch:{ Exception -> 0x0020 }
        r1.execSQL(r2);	 Catch:{ Exception -> 0x0020 }
    L_0x0020:
        r2 = "drop table if exists bi";	 Catch:{ Exception -> 0x0025 }
        r1.execSQL(r2);	 Catch:{ Exception -> 0x0025 }
    L_0x0025:
        r2 = "drop table if exists st";	 Catch:{ Exception -> 0x002a }
        r1.execSQL(r2);	 Catch:{ Exception -> 0x002a }
    L_0x002a:
        r0.onCreate(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.b.b.onUpgrade(android.database.sqlite.SQLiteDatabase, int, int):void");
    }
}
