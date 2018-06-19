package com.igexin.push.config;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.igexin.b.a.b.c;
import com.xunlei.download.Downloads.Impl.RequestHeaders;
import org.android.agoo.common.AgooConstants;

public class a implements com.igexin.push.core.b.a {
    public static final String a = "com.igexin.push.config.a";
    private static a b;

    public static a a() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    private void a(SQLiteDatabase sQLiteDatabase, int i) {
        sQLiteDatabase.delete("config", "id = ?", new String[]{String.valueOf(i)});
    }

    private void a(SQLiteDatabase sQLiteDatabase, int i, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(AgooConstants.MESSAGE_ID, Integer.valueOf(i));
        contentValues.put(RequestHeaders.COLUMN_VALUE, str);
        sQLiteDatabase.replace("config", null, contentValues);
    }

    private void a(SQLiteDatabase sQLiteDatabase, int i, byte[] bArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(AgooConstants.MESSAGE_ID, Integer.valueOf(i));
        contentValues.put(RequestHeaders.COLUMN_VALUE, bArr);
        sQLiteDatabase.replace("config", null, contentValues);
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
    }

    public void a(String str) {
        c.b().a(new i(this, str), true, false);
    }

    public void b() {
        c.b().a(new c(this), false, true);
    }

    public void b(android.database.sqlite.SQLiteDatabase r6) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r5 = this;
        r0 = 0;
        r1 = 0;
        r2 = "select id, value from config order by id";	 Catch:{ Throwable -> 0x0353, all -> 0x034b }
        r6 = r6.rawQuery(r2, r1);	 Catch:{ Throwable -> 0x0353, all -> 0x034b }
        if (r6 == 0) goto L_0x0348;
    L_0x000a:
        r2 = r6.moveToNext();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        if (r2 == 0) goto L_0x0348;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x0010:
        r2 = r6.getInt(r0);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r3 = 20;
        r4 = 1;
        if (r2 == r3) goto L_0x0035;
    L_0x0019:
        r3 = 21;
        if (r2 == r3) goto L_0x0035;
    L_0x001d:
        r3 = 22;
        if (r2 == r3) goto L_0x0035;
    L_0x0021:
        r3 = 24;
        if (r2 == r3) goto L_0x0035;
    L_0x0025:
        r3 = 26;
        if (r2 == r3) goto L_0x0035;
    L_0x0029:
        r3 = 45;
        if (r2 != r3) goto L_0x002e;
    L_0x002d:
        goto L_0x0035;
    L_0x002e:
        r3 = r6.getString(r4);	 Catch:{ Throwable -> 0x0329, all -> 0x0346 }
        r4 = r3;	 Catch:{ Throwable -> 0x0329, all -> 0x0346 }
        r3 = r1;	 Catch:{ Throwable -> 0x0329, all -> 0x0346 }
        goto L_0x0042;	 Catch:{ Throwable -> 0x0329, all -> 0x0346 }
    L_0x0035:
        r3 = r6.getBlob(r4);	 Catch:{ Throwable -> 0x0329, all -> 0x0346 }
        if (r3 == 0) goto L_0x0041;	 Catch:{ Throwable -> 0x0329, all -> 0x0346 }
    L_0x003b:
        r4 = com.igexin.push.core.g.C;	 Catch:{ Throwable -> 0x0329, all -> 0x0346 }
        r3 = com.igexin.b.a.a.a.c(r3, r4);	 Catch:{ Throwable -> 0x0329, all -> 0x0346 }
    L_0x0041:
        r4 = r1;
    L_0x0042:
        if (r3 != 0) goto L_0x0047;
    L_0x0044:
        if (r4 != 0) goto L_0x0047;
    L_0x0046:
        goto L_0x000a;
    L_0x0047:
        switch(r2) {
            case 1: goto L_0x0315;
            case 2: goto L_0x0301;
            case 3: goto L_0x02ed;
            case 4: goto L_0x02d9;
            case 5: goto L_0x02c5;
            case 6: goto L_0x02b1;
            case 7: goto L_0x029d;
            case 8: goto L_0x0289;
            case 9: goto L_0x0275;
            default: goto L_0x004a;
        };
    L_0x004a:
        switch(r2) {
            case 11: goto L_0x0261;
            case 12: goto L_0x024d;
            case 13: goto L_0x0239;
            case 14: goto L_0x0225;
            case 15: goto L_0x0211;
            case 16: goto L_0x01fd;
            case 17: goto L_0x01e9;
            case 18: goto L_0x01d5;
            case 19: goto L_0x01c1;
            case 20: goto L_0x018e;
            case 21: goto L_0x0185;
            case 22: goto L_0x017c;
            case 23: goto L_0x0168;
            case 24: goto L_0x015e;
            case 25: goto L_0x014a;
            case 26: goto L_0x0137;
            case 27: goto L_0x0123;
            case 28: goto L_0x0117;
            case 29: goto L_0x0103;
            default: goto L_0x004d;
        };
    L_0x004d:
        switch(r2) {
            case 40: goto L_0x00ef;
            case 41: goto L_0x00da;
            case 42: goto L_0x00c6;
            case 43: goto L_0x00b2;
            default: goto L_0x0050;
        };
    L_0x0050:
        switch(r2) {
            case 45: goto L_0x008e;
            case 46: goto L_0x007a;
            case 47: goto L_0x0067;
            case 48: goto L_0x0054;
            default: goto L_0x0053;
        };
    L_0x0053:
        goto L_0x000a;
    L_0x0054:
        r2 = "null";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r4.equals(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        if (r2 != 0) goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x005c:
        r2 = java.lang.Boolean.valueOf(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.booleanValue();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.O = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x0067:
        r2 = "null";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r4.equals(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        if (r2 != 0) goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x006f:
        r2 = java.lang.Boolean.valueOf(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.booleanValue();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.N = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x007a:
        r2 = "null";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r4.equals(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        if (r2 != 0) goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x0082:
        r2 = java.lang.Boolean.valueOf(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.booleanValue();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.M = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x008e:
        r2 = new java.lang.String;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.L = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2.<init>();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r3 = a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r3 = "|read from db hideRightIconBlackList = ";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r3 = com.igexin.push.config.m.L;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x00ad:
        com.igexin.b.a.c.a.b(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x00b2:
        r2 = "null";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r4.equals(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        if (r2 != 0) goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x00ba:
        r2 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.intValue();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.K = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x00c6:
        r2 = "null";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r4.equals(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        if (r2 != 0) goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x00ce:
        r2 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.intValue();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.J = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x00da:
        r2 = "null";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r4.equals(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        if (r2 != 0) goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x00e2:
        r2 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.intValue();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = (long) r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.I = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x00ef:
        r2 = "null";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r4.equals(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        if (r2 != 0) goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x00f7:
        r2 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.intValue();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.H = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x0103:
        r2 = "null";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r4.equals(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        if (r2 != 0) goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x010b:
        r2 = java.lang.Boolean.valueOf(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.booleanValue();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.G = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x0117:
        r2 = "null";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r4.equals(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        if (r2 != 0) goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x011f:
        com.igexin.push.config.m.F = r4;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x0123:
        r2 = "null";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r4.equals(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        if (r2 != 0) goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x012b:
        r2 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.intValue();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.E = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;
    L_0x0137:
        r2 = new java.lang.String;	 Catch:{ Exception -> 0x000a }
        r2.<init>(r3);	 Catch:{ Exception -> 0x000a }
        r3 = new org.json.JSONArray;	 Catch:{ Exception -> 0x000a }
        r3.<init>(r2);	 Catch:{ Exception -> 0x000a }
        r2 = com.igexin.push.core.a.t.a(r3);	 Catch:{ Exception -> 0x000a }
        com.igexin.push.config.SDKUrlConfig.setIdcConfigUrl(r2);	 Catch:{ Exception -> 0x000a }
        goto L_0x000a;
    L_0x014a:
        r2 = "null";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r4.equals(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        if (r2 != 0) goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x0152:
        r2 = java.lang.Boolean.valueOf(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.booleanValue();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.x = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;
    L_0x015e:
        r2 = new java.lang.String;	 Catch:{ Exception -> 0x000a }
        r2.<init>(r3);	 Catch:{ Exception -> 0x000a }
        com.igexin.push.config.o.a(r2, r0);	 Catch:{ Exception -> 0x000a }
        goto L_0x000a;
    L_0x0168:
        r2 = "null";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r4.equals(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        if (r2 != 0) goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x0170:
        r2 = java.lang.Boolean.valueOf(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.booleanValue();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.v = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x017c:
        r2 = new java.lang.String;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.u = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x0185:
        r2 = new java.lang.String;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.t = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;
    L_0x018e:
        r2 = new java.lang.String;	 Catch:{ Exception -> 0x01a4 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x01a4 }
        r3 = com.igexin.push.core.a.f.a();	 Catch:{ Exception -> 0x01a4 }
        r4 = new org.json.JSONObject;	 Catch:{ Exception -> 0x01a4 }
        r4.<init>(r2);	 Catch:{ Exception -> 0x01a4 }
        r2 = r3.a(r4);	 Catch:{ Exception -> 0x01a4 }
        com.igexin.push.config.m.s = r2;	 Catch:{ Exception -> 0x01a4 }
        goto L_0x000a;
    L_0x01a4:
        r2 = move-exception;
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r3.<init>();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r4 = a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r3.append(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r4 = "|";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r3.append(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r3.append(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r3.toString();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x00ad;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x01c1:
        r2 = "null";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r4.equals(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        if (r2 != 0) goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x01c9:
        r2 = java.lang.Boolean.valueOf(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.booleanValue();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.r = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x01d5:
        r2 = "null";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r4.equals(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        if (r2 != 0) goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x01dd:
        r2 = java.lang.Boolean.valueOf(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.booleanValue();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.q = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x01e9:
        r2 = "null";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r4.equals(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        if (r2 != 0) goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x01f1:
        r2 = java.lang.Boolean.valueOf(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.booleanValue();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.p = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x01fd:
        r2 = "null";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r4.equals(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        if (r2 != 0) goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x0205:
        r2 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.intValue();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.e = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x0211:
        r2 = "null";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r4.equals(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        if (r2 != 0) goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x0219:
        r2 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.intValue();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.d = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x0225:
        r2 = "null";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r4.equals(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        if (r2 != 0) goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x022d:
        r2 = java.lang.Boolean.valueOf(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.booleanValue();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.m = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x0239:
        r2 = "null";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r4.equals(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        if (r2 != 0) goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x0241:
        r2 = java.lang.Boolean.valueOf(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.booleanValue();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.l = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x024d:
        r2 = "null";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r4.equals(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        if (r2 != 0) goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x0255:
        r2 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.longValue();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.o = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x0261:
        r2 = "null";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r4.equals(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        if (r2 != 0) goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x0269:
        r2 = java.lang.Boolean.valueOf(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.booleanValue();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.n = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x0275:
        r2 = "null";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r4.equals(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        if (r2 != 0) goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x027d:
        r2 = java.lang.Boolean.valueOf(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.booleanValue();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.k = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x0289:
        r2 = "null";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r4.equals(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        if (r2 != 0) goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x0291:
        r2 = java.lang.Boolean.valueOf(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.booleanValue();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.j = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x029d:
        r2 = "null";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r4.equals(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        if (r2 != 0) goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x02a5:
        r2 = java.lang.Boolean.valueOf(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.booleanValue();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.i = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x02b1:
        r2 = "null";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r4.equals(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        if (r2 != 0) goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x02b9:
        r2 = java.lang.Boolean.valueOf(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.booleanValue();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.h = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x02c5:
        r2 = "null";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r4.equals(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        if (r2 != 0) goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x02cd:
        r2 = java.lang.Boolean.valueOf(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.booleanValue();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.g = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x02d9:
        r2 = "null";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r4.equals(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        if (r2 != 0) goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x02e1:
        r2 = java.lang.Boolean.valueOf(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.booleanValue();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.f = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x02ed:
        r2 = "null";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r4.equals(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        if (r2 != 0) goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x02f5:
        r2 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.longValue();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.c = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x0301:
        r2 = "null";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r4.equals(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        if (r2 != 0) goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x0309:
        r2 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.intValue();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.b = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x0315:
        r2 = "null";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r4.equals(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        if (r2 != 0) goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x031d:
        r2 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.intValue();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        com.igexin.push.config.m.a = r2;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x000a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
    L_0x0329:
        r2 = move-exception;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r3.<init>();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r4 = a;	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r3.append(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r4 = "|";	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r3.append(r4);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r3.append(r2);	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        r2 = r3.toString();	 Catch:{ Throwable -> 0x0354, all -> 0x0346 }
        goto L_0x00ad;
    L_0x0346:
        r0 = move-exception;
        goto L_0x034d;
    L_0x0348:
        if (r6 == 0) goto L_0x0359;
    L_0x034a:
        goto L_0x0356;
    L_0x034b:
        r0 = move-exception;
        r6 = r1;
    L_0x034d:
        if (r6 == 0) goto L_0x0352;
    L_0x034f:
        r6.close();
    L_0x0352:
        throw r0;
    L_0x0353:
        r6 = r1;
    L_0x0354:
        if (r6 == 0) goto L_0x0359;
    L_0x0356:
        r6.close();
    L_0x0359:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r2 = a;
        r6.append(r2);
        r2 = "|current ver = 2.11.1.0, last ver = ";
        r6.append(r2);
        r2 = com.igexin.push.core.g.N;
        r6.append(r2);
        r6 = r6.toString();
        com.igexin.b.a.c.a.b(r6);
        r6 = "2.11.1.0";
        r2 = com.igexin.push.core.g.N;
        r6 = r6.equals(r2);
        if (r6 != 0) goto L_0x040c;
    L_0x037e:
        r6 = com.igexin.push.config.m.s;
        if (r6 == 0) goto L_0x03d8;
    L_0x0382:
        r6 = com.igexin.push.config.m.s;
        r6 = r6.b();
        r6 = r6.isEmpty();
        if (r6 != 0) goto L_0x03d2;
    L_0x038e:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r0 = a;
        r6.append(r0);
        r0 = "|extMap is empty  = false";
        r6.append(r0);
        r6 = r6.toString();
        com.igexin.b.a.c.a.b(r6);
        r6 = com.igexin.push.config.m.s;
        r6 = r6.b();
        r6 = r6.keySet();
        r6 = r6.iterator();
    L_0x03b2:
        r0 = r6.hasNext();
        if (r0 == 0) goto L_0x03d2;
    L_0x03b8:
        r0 = com.igexin.push.config.m.s;
        r0 = r0.b();
        r2 = r6.next();
        r0 = r0.get(r2);
        r0 = (com.igexin.push.core.bean.f) r0;
        if (r0 == 0) goto L_0x03b2;
    L_0x03ca:
        r0 = r0.c();
        com.igexin.push.util.e.b(r0);
        goto L_0x03b2;
    L_0x03d2:
        com.igexin.push.config.m.s = r1;
        r5.h();
        goto L_0x03fa;
    L_0x03d8:
        r6 = new java.io.File;	 Catch:{ Exception -> 0x03fa }
        r1 = com.igexin.push.core.g.ac;	 Catch:{ Exception -> 0x03fa }
        r6.<init>(r1);	 Catch:{ Exception -> 0x03fa }
        r6 = r6.listFiles();	 Catch:{ Exception -> 0x03fa }
        r1 = r6.length;	 Catch:{ Exception -> 0x03fa }
    L_0x03e4:
        if (r0 >= r1) goto L_0x03fa;	 Catch:{ Exception -> 0x03fa }
    L_0x03e6:
        r2 = r6[r0];	 Catch:{ Exception -> 0x03fa }
        r3 = r2.getName();	 Catch:{ Exception -> 0x03fa }
        r4 = "tdata_";	 Catch:{ Exception -> 0x03fa }
        r3 = r3.startsWith(r4);	 Catch:{ Exception -> 0x03fa }
        if (r3 == 0) goto L_0x03f7;	 Catch:{ Exception -> 0x03fa }
    L_0x03f4:
        r2.delete();	 Catch:{ Exception -> 0x03fa }
    L_0x03f7:
        r0 = r0 + 1;
        goto L_0x03e4;
    L_0x03fa:
        r6 = com.igexin.push.core.b.g.a();
        r0 = "2.11.1.0";
        r6.e(r0);
        r6 = com.igexin.push.core.b.g.a();
        r0 = 0;
        r6.e(r0);
    L_0x040c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.config.a.b(android.database.sqlite.SQLiteDatabase):void");
    }

    public void b(String str) {
        c.b().a(new j(this, str), true, false);
    }

    public void c() {
        c.b().a(new d(this), false, true);
    }

    public void c(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, 1, String.valueOf(m.a));
        a(sQLiteDatabase, 2, String.valueOf(m.b));
        a(sQLiteDatabase, 3, String.valueOf(m.c));
        a(sQLiteDatabase, 4, String.valueOf(m.f));
        a(sQLiteDatabase, 5, String.valueOf(m.g));
        a(sQLiteDatabase, 6, String.valueOf(m.h));
        a(sQLiteDatabase, 7, String.valueOf(m.i));
        a(sQLiteDatabase, 8, String.valueOf(m.j));
        a(sQLiteDatabase, 9, String.valueOf(m.k));
        a(sQLiteDatabase, 11, String.valueOf(m.n));
        a(sQLiteDatabase, 12, String.valueOf(m.o));
        a(sQLiteDatabase, 13, String.valueOf(m.l));
        a(sQLiteDatabase, 14, String.valueOf(m.m));
        a(sQLiteDatabase, 15, String.valueOf(m.d));
        a(sQLiteDatabase, 3, String.valueOf(m.c));
        a(sQLiteDatabase, 17, String.valueOf(m.p));
        a(sQLiteDatabase, 18, String.valueOf(m.q));
        a(sQLiteDatabase, 19, String.valueOf(m.r));
        a(sQLiteDatabase, 25, String.valueOf(m.x));
    }

    public void d() {
        c.b().a(new e(this), false, true);
    }

    public void e() {
        c.b().a(new f(this), false, true);
    }

    public void f() {
        c.b().a(new g(this), false, true);
    }

    public void g() {
        c.b().a(new h(this), true, false);
    }

    public void h() {
        c.b().a(new b(this), true, false);
    }
}
