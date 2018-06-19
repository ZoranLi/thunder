package com.taobao.accs.init;

import android.app.Application;
import android.text.TextUtils;
import anet.channel.util.AppLifecycle;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: Taobao */
public class Launcher_CrossActivityStopped implements Serializable {
    public void init(Application application, HashMap<String, Object> hashMap) {
        try {
            if (ALog.isPrintLog(Level.I) != null) {
                ALog.i("Launcher_CrossActivityStopped", "onStopped", new Object[0]);
            }
            AppLifecycle.onBackground();
            if (TextUtils.isEmpty(Launcher_InitAccs.mAppkey) == null) {
                if (Launcher_InitAccs.mContext != null) {
                    if (Launcher_InitAccs.mIsInited != null) {
                        ThreadPoolExecutorFactory.execute(new b(this));
                    }
                    return;
                }
            }
            ALog.e("Launcher_CrossActivityStopped", "params null!!!", new Object[]{"appkey", Launcher_InitAccs.mAppkey, "context", Launcher_InitAccs.mContext});
        } catch (HashMap<String, Object> hashMap2) {
            ALog.e("Launcher_CrossActivityStopped", "onStoped", hashMap2, new Object[0]);
            hashMap2.printStackTrace();
        }
    }
}
