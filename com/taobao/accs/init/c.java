package com.taobao.accs.init;

import com.taobao.accs.ACCSManager;

/* compiled from: Taobao */
class c implements Runnable {
    final /* synthetic */ Launcher_InitAccs a;

    c(Launcher_InitAccs launcher_InitAccs) {
        this.a = launcher_InitAccs;
    }

    public void run() {
        ACCSManager.bindApp(Launcher_InitAccs.mContext, Launcher_InitAccs.mAppkey, Launcher_InitAccs.mTtid, Launcher_InitAccs.mAppReceiver);
        Launcher_InitAccs.mIsInited = true;
    }
}
