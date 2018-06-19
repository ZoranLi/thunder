package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.d;
import com.tencent.wxop.stat.event.h;

final class q implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ Throwable b;

    q(Context context, Throwable th) {
        this.a = context;
        this.b = th;
    }

    public final void run() {
        try {
            if (StatConfig.isEnableStatService()) {
                new aq(new d(this.a, StatServiceImpl.a(this.a, false, null), 99, this.b, h.a)).a();
            }
        } catch (Throwable th) {
            StatLogger f = StatServiceImpl.q;
            StringBuilder stringBuilder = new StringBuilder("reportSdkSelfException error: ");
            stringBuilder.append(th);
            f.e(stringBuilder.toString());
        }
    }
}
