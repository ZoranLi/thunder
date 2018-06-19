package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.am;
import com.xiaomi.xmpush.thrift.g;

final class b implements Runnable {
    final /* synthetic */ Context a;

    b(Context context) {
        this.a = context;
    }

    public final void run() {
        if (a.d(this.a)) {
            Object a = a.b(am.a(this.a).a(g.AggregationSdkMonitorDepth.a(), 4));
            if (!TextUtils.isEmpty(a)) {
                MiTinyDataClient.upload(this.a, "monitor_upload", "call_stack", 1, a);
                a.e(this.a);
            }
        }
    }
}
