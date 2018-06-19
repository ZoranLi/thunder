package com.baidu.mobads.openad.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.baidu.mobads.openad.c.b;
import com.igexin.sdk.PushConsts;

public class c extends d {
    private int a;
    private b d;
    private IntentFilter e;

    public c(Context context) {
        super(context);
    }

    public void a(BroadcastReceiver broadcastReceiver) {
        this.d = (b) broadcastReceiver;
    }

    public void a() {
        if (this.a == 0) {
            if (this.d == null) {
                a(new b(this));
            }
            this.e = new IntentFilter();
            this.e.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        }
        this.a++;
        this.b.registerReceiver(this.d, this.e);
    }

    public void b() {
        dispatchEvent(new b("network_changed"));
    }
}
