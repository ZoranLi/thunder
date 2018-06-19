package com.xunlei.downloadprovider.broadcast;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

/* compiled from: XLBroadcastManager */
class a$a$b {
    public BroadcastReceiver a;
    IntentFilter b;

    public a$a$b(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        this.a = broadcastReceiver;
        this.b = intentFilter;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                return this.a.equals(((a$a$b) obj).a);
            }
        }
        return null;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
