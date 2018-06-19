package com.xunlei.common.device.a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.alipay.sdk.app.statistic.c;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.stat.XLStatPack;
import com.xunlei.common.stat.XLStatUtil;
import com.xunlei.common.stat.a.b;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MD5 */
public class a {
    private b a;
    private SQLiteDatabase b;
    private boolean c;

    private static byte[] a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr, 0, bArr.length);
            return instance.digest();
        } catch (byte[] bArr2) {
            bArr2.printStackTrace();
            return null;
        }
    }

    public static String a(String str) {
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        str = a(str.getBytes());
        if (str == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(32);
        for (byte b : str) {
            stringBuilder.append(cArr[(b >> 4) & 15]);
            stringBuilder.append(cArr[b & 15]);
        }
        return stringBuilder.toString();
    }

    private static java.lang.String b(byte[] r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 16;
        r0 = new char[r0];
        r0 = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
        r1 = "MD5";	 Catch:{ Exception -> 0x003b }
        r1 = java.security.MessageDigest.getInstance(r1);	 Catch:{ Exception -> 0x003b }
        r1.update(r9);	 Catch:{ Exception -> 0x003b }
        r9 = r1.digest();	 Catch:{ Exception -> 0x003b }
        r1 = r9.length;	 Catch:{ Exception -> 0x003b }
        r2 = r1 << 1;	 Catch:{ Exception -> 0x003b }
        r2 = new char[r2];	 Catch:{ Exception -> 0x003b }
        r3 = 0;	 Catch:{ Exception -> 0x003b }
        r4 = r3;	 Catch:{ Exception -> 0x003b }
    L_0x001b:
        if (r3 < r1) goto L_0x0023;	 Catch:{ Exception -> 0x003b }
    L_0x001d:
        r9 = new java.lang.String;	 Catch:{ Exception -> 0x003b }
        r9.<init>(r2);	 Catch:{ Exception -> 0x003b }
        return r9;	 Catch:{ Exception -> 0x003b }
    L_0x0023:
        r5 = r9[r3];	 Catch:{ Exception -> 0x003b }
        r6 = r4 + 1;	 Catch:{ Exception -> 0x003b }
        r7 = r5 >>> 4;	 Catch:{ Exception -> 0x003b }
        r8 = 15;	 Catch:{ Exception -> 0x003b }
        r7 = r7 & r8;	 Catch:{ Exception -> 0x003b }
        r7 = r0[r7];	 Catch:{ Exception -> 0x003b }
        r2[r4] = r7;	 Catch:{ Exception -> 0x003b }
        r4 = r6 + 1;	 Catch:{ Exception -> 0x003b }
        r5 = r5 & 15;	 Catch:{ Exception -> 0x003b }
        r5 = r0[r5];	 Catch:{ Exception -> 0x003b }
        r2[r6] = r5;	 Catch:{ Exception -> 0x003b }
        r3 = r3 + 1;
        goto L_0x001b;
    L_0x003b:
        r9 = 0;
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.device.a.a.b(byte[]):java.lang.String");
    }

    private static byte[] c(byte[] r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "MD5";	 Catch:{ Exception -> 0x000e }
        r0 = java.security.MessageDigest.getInstance(r0);	 Catch:{ Exception -> 0x000e }
        r0.update(r1);	 Catch:{ Exception -> 0x000e }
        r1 = r0.digest();	 Catch:{ Exception -> 0x000e }
        return r1;
    L_0x000e:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.device.a.a.c(byte[]):byte[]");
    }

    public a(Context context) {
        this.c = false;
        this.a = new b(context);
        this.b = this.a.getWritableDatabase();
        this.c = true;
    }

    public void a(List<XLStatPack> list) {
        if (this.c) {
            this.b.beginTransaction();
            try {
                for (XLStatPack xLStatPack : list) {
                    this.b.execSQL("INSERT INTO xl_acc_stat_list VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", new Object[]{xLStatPack.mReqUrl, Integer.valueOf(xLStatPack.mErrorCode), Double.valueOf(xLStatPack.mRespTime), Integer.valueOf(xLStatPack.mRetryNum), xLStatPack.mSvrIp, xLStatPack.mSvrDomain, Integer.valueOf(xLStatPack.mCommandID), Integer.valueOf(XLStatUtil.getInstance().getBusinessType()), xLStatPack.mReportDate, Long.valueOf(xLStatPack.mUserId), Long.valueOf(xLStatPack.mFlowId), xLStatPack.mNetType, xLStatPack.mISP, Integer.valueOf(xLStatPack.mFinal), xLStatPack.mErrorMessage});
                }
                this.b.setTransactionSuccessful();
            } catch (List<XLStatPack> list2) {
                StringBuilder stringBuilder = new StringBuilder("save report list to database error = ");
                stringBuilder.append(list2.getMessage());
                XLLog.v("XLStatDBManager", stringBuilder.toString());
            } catch (Throwable th) {
                this.b.endTransaction();
            }
            this.b.endTransaction();
        }
    }

    public void a() {
        if (this.c) {
            String valueOf = String.valueOf(XLStatUtil.getInstance().getBusinessType());
            SQLiteDatabase sQLiteDatabase = this.b;
            StringBuilder stringBuilder = new StringBuilder("DELETE FROM xl_acc_stat_list WHERE bt=");
            stringBuilder.append(valueOf);
            sQLiteDatabase.execSQL(stringBuilder.toString());
        }
    }

    public List<XLStatPack> b() {
        List<XLStatPack> arrayList = new ArrayList();
        if (!this.c) {
            return arrayList;
        }
        String valueOf = String.valueOf(XLStatUtil.getInstance().getBusinessType());
        SQLiteDatabase sQLiteDatabase = this.b;
        StringBuilder stringBuilder = new StringBuilder("SELECT * FROM xl_acc_stat_list WHERE bt=");
        stringBuilder.append(valueOf);
        Cursor rawQuery = sQLiteDatabase.rawQuery(stringBuilder.toString(), null);
        while (rawQuery.moveToNext()) {
            XLStatPack xLStatPack = new XLStatPack();
            xLStatPack.mReqUrl = rawQuery.getString(rawQuery.getColumnIndex("url"));
            xLStatPack.mErrorCode = rawQuery.getInt(rawQuery.getColumnIndex("error"));
            xLStatPack.mRespTime = rawQuery.getDouble(rawQuery.getColumnIndex("respt"));
            xLStatPack.mRetryNum = rawQuery.getInt(rawQuery.getColumnIndex("retry"));
            xLStatPack.mSvrIp = rawQuery.getString(rawQuery.getColumnIndex("ip"));
            xLStatPack.mSvrDomain = rawQuery.getString(rawQuery.getColumnIndex(DispatchConstants.DOMAIN));
            xLStatPack.mCommandID = rawQuery.getInt(rawQuery.getColumnIndex(com.taobao.agoo.a.a.b.JSON_CMD));
            xLStatPack.mReportDate = rawQuery.getString(rawQuery.getColumnIndex("date"));
            xLStatPack.mUserId = (long) rawQuery.getInt(rawQuery.getColumnIndex("uid"));
            xLStatPack.mFlowId = rawQuery.getLong(rawQuery.getColumnIndex("flowid"));
            xLStatPack.mNetType = rawQuery.getString(rawQuery.getColumnIndex(c.a));
            xLStatPack.mISP = rawQuery.getString(rawQuery.getColumnIndex("isp"));
            xLStatPack.mFinal = rawQuery.getInt(rawQuery.getColumnIndex("final"));
            xLStatPack.mErrorMessage = rawQuery.getString(rawQuery.getColumnIndex("message"));
            arrayList.add(xLStatPack);
        }
        rawQuery.close();
        return arrayList;
    }

    public void c() {
        if (this.c) {
            this.b.close();
            this.c = false;
        }
    }

    private Cursor d() {
        String valueOf = String.valueOf(XLStatUtil.getInstance().getBusinessType());
        SQLiteDatabase sQLiteDatabase = this.b;
        StringBuilder stringBuilder = new StringBuilder("SELECT * FROM xl_acc_stat_list WHERE bt=");
        stringBuilder.append(valueOf);
        return sQLiteDatabase.rawQuery(stringBuilder.toString(), null);
    }
}
