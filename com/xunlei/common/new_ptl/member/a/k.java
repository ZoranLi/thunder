package com.xunlei.common.new_ptl.member.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import com.igexin.sdk.PushConsts;
import com.xunlei.common.base.XLLog;

/* compiled from: XLNetWorkMonitor */
final class k extends BroadcastReceiver {
    private /* synthetic */ g a;

    k(g gVar) {
        this.a = gVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE) != null) {
            context = ((ConnectivityManager) this.a.b.getSystemService("connectivity")).getActiveNetworkInfo();
            if (context == null || context.isAvailable() == null) {
                XLLog.v("XLNetWorkMonitor", "net work disconnected!");
                g.a(this.a, false, context);
            } else {
                context.getTypeName();
                XLLog.v("XLNetWorkMonitor", "net work connected!");
                g.a(this.a, true, context);
            }
        }
    }
}
