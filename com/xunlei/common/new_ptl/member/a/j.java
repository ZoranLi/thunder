package com.xunlei.common.new_ptl.member.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import com.igexin.sdk.PushConsts;

/* compiled from: XLNetWorkMonitor */
public final class j {
    private i a;
    private Context b;
    private boolean c;
    private boolean d;
    private int e;
    private BroadcastReceiver f;

    public j(i iVar, Context context) {
        this.a = null;
        this.b = null;
        this.c = false;
        this.d = true;
        this.e = 0;
        this.f = new k(this);
        this.a = iVar;
        this.b = context;
    }

    public final void a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        this.b.registerReceiver(this.f, intentFilter);
    }

    public final void b() {
        if (this.f != null) {
            this.b.unregisterReceiver(this.f);
        }
    }

    private void a(boolean z, NetworkInfo networkInfo) {
        if (this.d) {
            this.a.a(z);
            this.d = null;
        } else {
            int i = -1;
            if (networkInfo != null) {
                i = networkInfo.getType();
            }
            if (!(this.c == z && this.e == i)) {
                this.a.a(z);
                this.e = i;
            }
        }
        this.c = z;
    }
}
