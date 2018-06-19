package com.xunlei.downloadprovider.personal.user;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.igexin.sdk.PushConsts;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.homepage.recommend.b.c;
import com.xunlei.downloadprovider.homepage.recommend.b.f;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.xllib.android.b;

public class NetWorkChangedReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE) != null && b.a(context) != null) {
            LoginHelper.a();
            if (l.b() == null) {
                LoginHelper.a().a(null);
                new StringBuilder("---LoginHelper.getInstance().userLoginWithStoredInfo()---").append(Thread.currentThread().getId());
            }
            XLThreadPool.execute(new f(c.a()));
        }
    }
}
