package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.smtt.sdk.QbSdk.PreInitCallback;
import com.tencent.smtt.utils.TbsLog;

final class f extends Handler {
    final /* synthetic */ PreInitCallback a;
    final /* synthetic */ Context b;

    f(Looper looper, PreInitCallback preInitCallback, Context context) {
        this.a = preInitCallback;
        this.b = context;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                bl d = bk.b().d();
                if (d != null) {
                    d.a(this.b);
                }
                if (this.a != null) {
                    this.a.onViewInitFinished(true);
                }
                TbsLog.writeLogToDisk();
                break;
            case 2:
                if (this.a != null) {
                    this.a.onViewInitFinished(false);
                }
                TbsLog.writeLogToDisk();
                return;
            case 3:
                if (this.a != null) {
                    this.a.onCoreInitFinished();
                    return;
                }
                break;
            default:
                return;
        }
    }
}
