package com.tencent.wxop.stat;

import com.tencent.wxop.stat.common.l;
import java.util.TimerTask;

class e extends TimerTask {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public void run() {
        if (StatConfig.isDebugEnable()) {
            l.b().i("TimerTask run");
        }
        StatServiceImpl.e(this.a.c);
        cancel();
        this.a.a();
    }
}
