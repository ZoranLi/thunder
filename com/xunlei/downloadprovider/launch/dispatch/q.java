package com.xunlei.downloadprovider.launch.dispatch;

import android.content.Context;
import android.content.Intent;
import com.xunlei.downloadprovider.bho.ThunderTaskBHOActivity;
import com.xunlei.downloadprovider.launch.e.c;

/* compiled from: ThunderTaskBHODISP */
public final class q extends b {
    public static boolean a;
    private Intent b;

    protected final boolean a(Intent intent) {
        this.b = intent;
        if (this.b == null || this.b.getIntExtra("dispatch_from_key", -1) != 1101) {
            return false;
        }
        return true;
    }

    protected final void a(Context context) {
        new StringBuilder("enterConcreateActivity ").append(getClass().getSimpleName());
        if (!a) {
            a = true;
        }
        this.b.setClass(context, ThunderTaskBHOActivity.class);
        this.b.putExtra("dispatch_from_key", 0);
        context.startActivity(this.b);
        c.a("sdk", true);
    }
}
