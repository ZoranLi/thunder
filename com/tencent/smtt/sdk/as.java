package com.tencent.smtt.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo;

class as extends Handler {
    final /* synthetic */ TbsLogReport a;

    as(TbsLogReport tbsLogReport, Looper looper) {
        this.a = tbsLogReport;
        super(looper);
    }

    public void handleMessage(Message message) {
        if (message.what == 600) {
            if (message.obj instanceof TbsLogInfo) {
                TbsLogInfo tbsLogInfo = (TbsLogInfo) message.obj;
                this.a.a(message.arg1, tbsLogInfo);
            }
            return;
        }
        if (message.what == 601) {
            this.a.g();
        }
    }
}
