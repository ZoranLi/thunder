package com.xunlei.downloadprovider.download.engine.kernel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.igexin.sdk.PushConsts;
import com.xunlei.common.concurrent.XLThreadPool;

public class NetworkReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        new StringBuilder("Get Network Action:").append(intent.getAction());
        if (intent.getAction().equals(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE) != null) {
            new StringBuilder("Target Action:").append(intent.getAction());
            context = g.a();
            if (context.d != null && context.e() == null) {
                XLThreadPool.execute(new h(context));
            }
        }
    }
}
