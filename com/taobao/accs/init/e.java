package com.taobao.accs.init;

import android.app.Application;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import java.util.HashMap;

/* compiled from: Taobao */
class e implements Runnable {
    final /* synthetic */ HashMap a;
    final /* synthetic */ Application b;
    final /* synthetic */ Launcher_Login c;

    e(Launcher_Login launcher_Login, HashMap hashMap, Application application) {
        this.c = launcher_Login;
        this.a = hashMap;
        this.b = application;
    }

    public void run() {
        Throwable th;
        String str = null;
        try {
            int intValue = ((Integer) this.a.get("envIndex")).intValue();
            String str2 = (String) this.a.get("onlineAppKey");
            if (intValue == 1) {
                try {
                    str = (String) this.a.get("preAppKey");
                } catch (Throwable th2) {
                    th = th2;
                    str = str2;
                    try {
                        ALog.e("Launcher_Login", "login get param error", th, new Object[0]);
                        if (TextUtils.isEmpty(str)) {
                            ALog.e("Launcher_Login", "login get appkey null", new Object[0]);
                            str = "21646297";
                        }
                        Launcher_InitAccs.mForceBindUser = true;
                        Launcher_InitAccs.mUserId = (String) this.a.get("userId");
                        Launcher_InitAccs.mSid = (String) this.a.get("sid");
                        ACCSManager.bindApp(this.b.getApplicationContext(), str, (String) this.a.get(Constants.KEY_TTID), Launcher_InitAccs.mAppReceiver);
                    } catch (Throwable th22) {
                        ALog.e("Launcher_Login", "login", th22, new Object[0]);
                        return;
                    }
                }
            }
            str = ((intValue == 2 ? 1 : 0) | (intValue == 3 ? 1 : 0)) != 0 ? (String) this.a.get("dailyAppkey") : str2;
        } catch (Throwable th3) {
            th = th3;
            ALog.e("Launcher_Login", "login get param error", th, new Object[0]);
            if (TextUtils.isEmpty(str)) {
                ALog.e("Launcher_Login", "login get appkey null", new Object[0]);
                str = "21646297";
            }
            Launcher_InitAccs.mForceBindUser = true;
            Launcher_InitAccs.mUserId = (String) this.a.get("userId");
            Launcher_InitAccs.mSid = (String) this.a.get("sid");
            ACCSManager.bindApp(this.b.getApplicationContext(), str, (String) this.a.get(Constants.KEY_TTID), Launcher_InitAccs.mAppReceiver);
        }
        if (TextUtils.isEmpty(str)) {
            ALog.e("Launcher_Login", "login get appkey null", new Object[0]);
            str = "21646297";
        }
        Launcher_InitAccs.mForceBindUser = true;
        Launcher_InitAccs.mUserId = (String) this.a.get("userId");
        Launcher_InitAccs.mSid = (String) this.a.get("sid");
        ACCSManager.bindApp(this.b.getApplicationContext(), str, (String) this.a.get(Constants.KEY_TTID), Launcher_InitAccs.mAppReceiver);
    }
}
