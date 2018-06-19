package com.tencent.wxop.stat;

import android.content.Context;

final class ak implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Context b;
    final /* synthetic */ StatSpecifyReportedInfo c;

    ak(String str, Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.a = str;
        this.b = context;
        this.c = statSpecifyReportedInfo;
    }

    public final void run() {
        if (this.a != null) {
            if (this.a.trim().length() != 0) {
                StatConfig.f = this.a;
                StatServiceImpl.b(this.b, new StatAccount(this.a), this.c);
                return;
            }
        }
        StatServiceImpl.q.w("qq num is null or empty.");
    }
}
