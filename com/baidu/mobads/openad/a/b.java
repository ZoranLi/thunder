package com.baidu.mobads.openad.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.igexin.sdk.PushConsts;

public class b extends BroadcastReceiver {
    private c a;

    public b(c cVar) {
        this.a = cVar;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE) != null) {
            this.a.b();
        }
    }
}
