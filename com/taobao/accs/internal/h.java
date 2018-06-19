package com.taobao.accs.internal;

import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.b;

/* compiled from: Taobao */
class h implements Runnable {
    final /* synthetic */ ServiceImpl a;

    h(ServiceImpl serviceImpl) {
        this.a = serviceImpl;
    }

    public void run() {
        ServiceImpl.d();
        this.a.a(this.a.c);
        UTMini.getInstance().commitEvent(66001, "START", UtilityImpl.getProxy(), "PROXY");
        long serviceAliveTime = UtilityImpl.getServiceAliveTime(this.a.c);
        ALog.d("ServiceImpl", "getServiceAliveTime", new Object[]{"aliveTime", Long.valueOf(serviceAliveTime)});
        if (serviceAliveTime > 20000) {
            b.a("accs", BaseMonitor.COUNT_SERVICE_ALIVE, "", (double) (serviceAliveTime / 1000));
        }
        UtilityImpl.setServiceTime(this.a.c, Constants.SP_KEY_SERVICE_START, System.currentTimeMillis());
        UTMini.getInstance().commitEvent(66001, "NOTIFY", UtilityImpl.isNotificationEnabled(this.a.c));
    }
}
