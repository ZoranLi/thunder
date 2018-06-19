package com.huawei.hms.support.log.a;

import android.content.Context;
import com.huawei.hms.support.log.a.a.a;

/* compiled from: FileLogNode */
class b implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ a c;

    b(a aVar, Context context, String str) {
        this.c = aVar;
        this.a = context;
        this.b = str;
    }

    public void run() {
        this.c.a.a(this.a, this.b);
    }
}
