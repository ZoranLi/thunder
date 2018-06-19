package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.k;
import java.io.File;

class am extends Thread {
    final /* synthetic */ Context a;
    final /* synthetic */ Context b;
    final /* synthetic */ aj c;

    am(aj ajVar, Context context, Context context2) {
        this.c = ajVar;
        this.a = context;
        this.b = context2;
    }

    public void run() {
        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread start");
        try {
            File file = this.a == null ? new File(TbsShareManager.getHostCorePathAppDefined()) : this.c.m(this.a);
            File m = this.c.m(this.b);
            if (VERSION.SDK_INT < 21) {
                k.a(file, m, new an(this));
            }
            k.a(file, m, new ao(this));
            TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
