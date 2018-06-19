package com.taobao.accs.init;

import com.taobao.accs.ACCSManager;

/* compiled from: Taobao */
class a implements Runnable {
    final /* synthetic */ Launcher_CrossActivityStarted a;

    a(Launcher_CrossActivityStarted launcher_CrossActivityStarted) {
        this.a = launcher_CrossActivityStarted;
    }

    public void run() {
        ACCSManager.bindApp(Launcher_InitAccs.mContext, Launcher_InitAccs.mAppkey, Launcher_InitAccs.mTtid, Launcher_InitAccs.mAppReceiver);
    }
}
