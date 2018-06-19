package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.smtt.utils.TbsLog;

class al extends Handler {
    final /* synthetic */ aj a;

    al(aj ajVar, Looper looper) {
        this.a = ajVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        QbSdk.setTBSInstallingStatus(true);
        Object[] objArr;
        switch (message.what) {
            case 1:
                TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE");
                objArr = (Object[]) message.obj;
                this.a.b((Context) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue());
                break;
            case 2:
                TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_COPY_TBS_CORE");
                objArr = (Object[]) message.obj;
                this.a.a((Context) objArr[0], (Context) objArr[1], ((Integer) objArr[2]).intValue());
                break;
            case 3:
                TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE_EX");
                objArr = (Object[]) message.obj;
                this.a.b((Context) objArr[0], (Bundle) objArr[1]);
                break;
            default:
                break;
        }
        QbSdk.setTBSInstallingStatus(false);
        super.handleMessage(message);
    }
}
