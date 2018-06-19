package com.bumptech.glide.manager;

import android.content.Context;
import com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener;
import com.umeng.message.MsgConstant;

public class ConnectivityMonitorFactory {
    public ConnectivityMonitor build(Context context, ConnectivityListener connectivityListener) {
        if ((context.checkCallingOrSelfPermission(MsgConstant.PERMISSION_ACCESS_NETWORK_STATE) == 0 ? 1 : null) != null) {
            return new DefaultConnectivityMonitor(context, connectivityListener);
        }
        return new NullConnectivityMonitor();
    }
}
