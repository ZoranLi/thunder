package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import com.alipay.sdk.data.a;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.b;

/* compiled from: Taobao */
class f implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ Context c;
    final /* synthetic */ Intent d;
    final /* synthetic */ d e;

    f(d dVar, String str, String str2, Context context, Intent intent) {
        this.e = dVar;
        this.a = str;
        this.b = str2;
        this.c = context;
        this.d = intent;
    }

    public void run() {
        if (d.d() != null && d.d().contains(this.a)) {
            ALog.e("MsgDistribute", "routing msg time out, try election", new Object[]{Constants.KEY_DATA_ID, this.a, Constants.KEY_SERVICE_ID, this.b});
            d.d().remove(this.a);
            d.a(this.e, this.c);
            String str = a.f;
            StringBuilder stringBuilder = new StringBuilder("pkg:");
            stringBuilder.append(this.d.getPackage());
            b.a("accs", BaseMonitor.ALARM_MSG_ROUTING_RATE, "", str, stringBuilder.toString());
        }
    }
}
