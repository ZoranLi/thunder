package com.xunlei.downloadprovider.ad.cache.task;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.igexin.sdk.PushConsts;
import com.xunlei.xllib.android.b;
import java.util.HashSet;
import java.util.Set;

public class ADCacheNetworkReceiver extends BroadcastReceiver {
    protected static Set<a> a = new HashSet();

    protected interface a {
        void a(boolean z);
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE) != null) {
            context = b.a(com.xunlei.downloadprovider.ad.a.a());
            for (a a : a) {
                a.a(context);
            }
        }
    }

    protected static void a(a aVar) {
        a.add(aVar);
    }
}
