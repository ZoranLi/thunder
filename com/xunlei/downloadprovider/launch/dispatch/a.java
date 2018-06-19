package com.xunlei.downloadprovider.launch.dispatch;

import android.content.Context;
import android.content.Intent;
import com.xunlei.downloadprovider.personal.a.i;

/* compiled from: AliFeedBackDISP */
public final class a extends b {
    private Intent a;

    protected final boolean a(Intent intent) {
        this.a = intent;
        if (this.a == null || this.a.getIntExtra("dispatch_from_key", -1) != 1109) {
            return false;
        }
        return true;
    }

    protected final void a(Context context) {
        new StringBuilder("enterConcreateActivity ").append(getClass().getSimpleName());
        this.a.putExtra("dispatch_from_key", 0);
        i.a(context, com.xunlei.downloadprovider.personal.a.b.a.b, "FeedbackNoti");
    }
}
