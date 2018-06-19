package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;

final class w implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Context b;
    final /* synthetic */ StatSpecifyReportedInfo c;

    w(String str, Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.a = str;
        this.b = context;
        this.c = statSpecifyReportedInfo;
    }

    public final void run() {
        try {
            synchronized (StatServiceImpl.o) {
                StatLogger f;
                StringBuilder stringBuilder;
                if (StatServiceImpl.o.size() >= StatConfig.getMaxParallelTimmingEvents()) {
                    f = StatServiceImpl.q;
                    stringBuilder = new StringBuilder("The number of page events exceeds the maximum value ");
                    stringBuilder.append(Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
                    f.error(stringBuilder.toString());
                    return;
                }
                StatServiceImpl.m = this.a;
                if (StatServiceImpl.o.containsKey(StatServiceImpl.m)) {
                    f = StatServiceImpl.q;
                    stringBuilder = new StringBuilder("Duplicate PageID : ");
                    stringBuilder.append(StatServiceImpl.m);
                    stringBuilder.append(", onResume() repeated?");
                    f.e(stringBuilder.toString());
                    return;
                }
                StatServiceImpl.o.put(StatServiceImpl.m, Long.valueOf(System.currentTimeMillis()));
                StatServiceImpl.a(this.b, true, this.c);
            }
        } catch (Throwable th) {
            StatServiceImpl.q.e(th);
            StatServiceImpl.a(this.b, th);
        }
    }
}
