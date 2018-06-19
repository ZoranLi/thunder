package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.event.g;

final class aa implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ StatSpecifyReportedInfo b;
    final /* synthetic */ StatAppMonitor c;

    aa(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo, StatAppMonitor statAppMonitor) {
        this.a = context;
        this.b = statSpecifyReportedInfo;
        this.c = statAppMonitor;
    }

    public final void run() {
        try {
            new aq(new g(this.a, StatServiceImpl.a(this.a, false, this.b), this.c, this.b)).a();
        } catch (Throwable th) {
            StatServiceImpl.q.e(th);
            StatServiceImpl.a(this.a, th);
        }
    }
}
