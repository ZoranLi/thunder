package com.ali.auth.third.a.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a {
    private static AtomicBoolean a = new AtomicBoolean(false);
    private static Context b;
    private static BroadcastReceiver c;

    public static void a() {
        boolean z = com.ali.auth.third.core.config.a.a;
        if (a.compareAndSet(true, false) && b != null && c != null) {
            Intent intent = new Intent("NOTIFY_LOGIN_STATUS_CHANGE");
            intent.putExtra("currentProcess", com.ali.auth.third.core.j.a.d());
            intent.putExtra("isLogining", a.get());
            intent.setPackage(b.getPackageName());
            b.sendBroadcast(intent);
        }
    }
}
