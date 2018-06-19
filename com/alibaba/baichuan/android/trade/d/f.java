package com.alibaba.baichuan.android.trade.d;

import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.a.a;
import com.alibaba.baichuan.android.trade.adapter.mtop.NetworkResponse;
import com.alibaba.baichuan.android.trade.adapter.ut.e;
import com.alibaba.baichuan.android.trade.callback.AlibcFailureCallback;
import com.alibaba.baichuan.android.trade.model.AlibcTaokeParams;
import java.util.HashMap;
import java.util.Map;

final class f implements Runnable {
    final /* synthetic */ HashMap a;
    final /* synthetic */ String b;
    final /* synthetic */ AlibcTaokeParams c;
    final /* synthetic */ String d;
    final /* synthetic */ AlibcFailureCallback e;
    final /* synthetic */ b f;

    f(b bVar, HashMap hashMap, String str, AlibcTaokeParams alibcTaokeParams, String str2, AlibcFailureCallback alibcFailureCallback) {
        this.f = bVar;
        this.a = hashMap;
        this.b = str;
        this.c = alibcTaokeParams;
        this.d = str2;
        this.e = alibcFailureCallback;
    }

    public final void run() {
        NetworkResponse networkResponse;
        String str;
        Map map = this.a;
        AlibcTaokeParams alibcTaokeParams = this.c;
        if (alibcTaokeParams == null) {
            networkResponse = null;
        } else {
            a aVar = new a();
            if (alibcTaokeParams.pid == null || !alibcTaokeParams.pid.startsWith(AlibcTaokeParams.PID_PREFIX)) {
                AlibcContext.b();
            }
            networkResponse = aVar.a(new HashMap(map));
            if (!(networkResponse == null || networkResponse.isSuccess())) {
                String str2 = networkResponse.errorMsg;
                StringBuilder stringBuilder = new StringBuilder("1701");
                stringBuilder.append(networkResponse.errorCode);
                b.a("Taoke_Trace_Async", str2, stringBuilder.toString());
            }
            if (AlibcContext.b()) {
                new StringBuilder("tktrace result json: ").append(networkResponse.data);
                AlibcContext.b();
            }
        }
        if (networkResponse != null) {
            if (networkResponse.isSuccess) {
                e.a("Taoke_Trace_Async");
                AlibcContext.b();
                return;
            }
        }
        if (networkResponse == null) {
            str = "null taokeTrace response";
        } else {
            StringBuilder stringBuilder2 = new StringBuilder("code: ");
            stringBuilder2.append(networkResponse.errorCode);
            stringBuilder2.append(" msg: ");
            stringBuilder2.append(networkResponse.errorMsg);
            str = stringBuilder2.toString();
        }
        com.alibaba.baichuan.android.trade.utils.g.a.b();
        if (this.e != null) {
            AlibcFailureCallback alibcFailureCallback = this.e;
            stringBuilder = new StringBuilder("淘客打点失败，错误信息:");
            stringBuilder.append(str);
            com.alibaba.baichuan.android.trade.utils.f.a(alibcFailureCallback, 0, stringBuilder.toString());
            AlibcContext.b();
        }
    }
}
