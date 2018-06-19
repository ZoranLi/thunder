package com.xunlei.common.stat.a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.taobao.agoo.a.a.b;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.stat.XLStatPack;
import com.xunlei.common.stat.XLStatUtil;
import java.util.ArrayList;
import java.util.List;

/* compiled from: XLStatDBManager */
public final class c {
    private b a;
    private SQLiteDatabase b;
    private boolean c;

    public c(Context context) {
        this.c = false;
        this.a = new b(context);
        this.b = this.a.getWritableDatabase();
        this.c = true;
    }

    public final void a(List<XLStatPack> list) {
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

    public final void a() {
        if (this.c) {
            String valueOf = String.valueOf(XLStatUtil.getInstance().getBusinessType());
            SQLiteDatabase sQLiteDatabase = this.b;
            StringBuilder stringBuilder = new StringBuilder("DELETE FROM xl_acc_stat_list WHERE bt=");
            stringBuilder.append(valueOf);
            sQLiteDatabase.execSQL(stringBuilder.toString());
        }
    }

    public final List<XLStatPack> b() {
        List<XLStatPack> arrayList = new ArrayList();
        if (!this.c) {
            return arrayList;
        }
        Cursor d = super.d();
        while (d.moveToNext()) {
            XLStatPack xLStatPack = new XLStatPack();
            xLStatPack.mReqUrl = d.getString(d.getColumnIndex("url"));
            xLStatPack.mErrorCode = d.getInt(d.getColumnIndex("error"));
            xLStatPack.mRespTime = d.getDouble(d.getColumnIndex("respt"));
            xLStatPack.mRetryNum = d.getInt(d.getColumnIndex("retry"));
            xLStatPack.mSvrIp = d.getString(d.getColumnIndex("ip"));
            xLStatPack.mSvrDomain = d.getString(d.getColumnIndex(DispatchConstants.DOMAIN));
            xLStatPack.mCommandID = d.getInt(d.getColumnIndex(b.JSON_CMD));
            xLStatPack.mReportDate = d.getString(d.getColumnIndex("date"));
            xLStatPack.mUserId = (long) d.getInt(d.getColumnIndex("uid"));
            xLStatPack.mFlowId = d.getLong(d.getColumnIndex("flowid"));
            xLStatPack.mNetType = d.getString(d.getColumnIndex(com.alipay.sdk.app.statistic.c.a));
            xLStatPack.mISP = d.getString(d.getColumnIndex("isp"));
            xLStatPack.mFinal = d.getInt(d.getColumnIndex("final"));
            xLStatPack.mErrorMessage = d.getString(d.getColumnIndex("message"));
            arrayList.add(xLStatPack);
        }
        d.close();
        return arrayList;
    }

    public final void c() {
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
