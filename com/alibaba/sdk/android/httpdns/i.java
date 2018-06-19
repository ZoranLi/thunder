package com.alibaba.sdk.android.httpdns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.igexin.sdk.PushConsts;
import java.util.ArrayList;

final class i extends BroadcastReceiver {
    i() {
    }

    public final void onReceive(Context context, Intent intent) {
        if (!isInitialStickyBroadcast() && intent.getAction().equals(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE)) {
            String c = h.b();
            if (!(c == "None_Network" || c.equalsIgnoreCase(h.c))) {
                e.d("[BroadcastReceiver.onReceive] - Network state changed");
                ArrayList a = a.a().a();
                a.a().clear();
                if (h.f6c && HttpDns.instance != null) {
                    e.d("[BroadcastReceiver.onReceive] - refresh host");
                    HttpDns.instance.setPreResolveHosts(a);
                }
            }
            h.c = c;
        }
    }
}
