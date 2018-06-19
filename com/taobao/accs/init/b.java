package com.taobao.accs.init;

import com.taobao.accs.ACCSManager;

/* compiled from: Taobao */
class b implements Runnable {
    final /* synthetic */ Launcher_CrossActivityStopped a;

    b(Launcher_CrossActivityStopped launcher_CrossActivityStopped) {
        this.a = launcher_CrossActivityStopped;
    }

    public void run() {
        ACCSManager.bindApp(Launcher_InitAccs.mContext, Launcher_InitAccs.mAppkey, Launcher_InitAccs.mTtid, Launcher_InitAccs.mAppReceiver);
    }
}
