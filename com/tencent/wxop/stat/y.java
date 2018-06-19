package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.c;

final class y implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ c b;
    final /* synthetic */ Context c;

    y(String str, c cVar, Context context) {
        this.a = str;
        this.b = cVar;
        this.c = context;
    }

    public final void run() {
        try {
            if (StatServiceImpl.a(this.a)) {
                StatServiceImpl.q.error((Object) "The event_id of StatService.trackCustomBeginEvent() can not be null or empty.");
                return;
            }
            StatLogger f;
            StringBuilder stringBuilder;
            if (StatConfig.isDebugEnable()) {
                f = StatServiceImpl.q;
                stringBuilder = new StringBuilder("add begin key:");
                stringBuilder.append(this.b);
                f.i(stringBuilder.toString());
            }
            if (StatServiceImpl.e.containsKey(this.b)) {
                f = StatServiceImpl.q;
                stringBuilder = new StringBuilder("Duplicate CustomEvent key: ");
                stringBuilder.append(this.b.toString());
                stringBuilder.append(", trackCustomBeginKVEvent() repeated?");
                f.warn(stringBuilder.toString());
            } else if (StatServiceImpl.e.size() <= StatConfig.getMaxParallelTimmingEvents()) {
                StatServiceImpl.e.put(this.b, Long.valueOf(System.currentTimeMillis()));
            } else {
                f = StatServiceImpl.q;
                stringBuilder = new StringBuilder("The number of timedEvent exceeds the maximum value ");
                stringBuilder.append(Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
                f.error(stringBuilder.toString());
            }
        } catch (Throwable th) {
            StatServiceImpl.q.e(th);
            StatServiceImpl.a(this.c, th);
        }
    }
}
