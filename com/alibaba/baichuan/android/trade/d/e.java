package com.alibaba.baichuan.android.trade.d;

import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.adapter.mtop.NetworkResponse;
import com.alibaba.baichuan.android.trade.b.a;
import com.alibaba.baichuan.android.trade.callback.AlibcFailureCallback;
import com.alibaba.baichuan.android.trade.callback.b;
import com.alibaba.baichuan.android.trade.model.AlibcTaokeParams;
import java.util.HashMap;

final class e implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ HashMap b;
    final /* synthetic */ b c;
    final /* synthetic */ String d;
    final /* synthetic */ AlibcTaokeParams e;
    final /* synthetic */ String f;
    final /* synthetic */ AlibcFailureCallback g;
    final /* synthetic */ b h;

    e(b bVar, a aVar, HashMap hashMap, b bVar2, String str, AlibcTaokeParams alibcTaokeParams, String str2, AlibcFailureCallback alibcFailureCallback) {
        this.h = bVar;
        this.a = aVar;
        this.b = hashMap;
        this.c = bVar2;
        this.d = str;
        this.e = alibcTaokeParams;
        this.f = str2;
        this.g = alibcFailureCallback;
    }

    public final void run() {
        this.a.d("sync");
        if ("YES".equals(com.alibaba.baichuan.android.trade.e.a.g().a("isSyncForTaoke"))) {
            Object obj;
            String str;
            StringBuilder stringBuilder;
            AlibcContext.b();
            this.a.a("taokeTime");
            NetworkResponse a = new com.alibaba.baichuan.android.trade.a.b().a(new HashMap(this.b));
            if (a.data != null && a.isSuccess) {
                if (a.errorCode.equals(HttpConstant.SUCCESS)) {
                    obj = a.data.get("data").toString();
                    this.a.b("taokeTime");
                    if (TextUtils.isEmpty(obj)) {
                        new StringBuilder("taoke同步打点成,sclickUrl：").append(a.data);
                        AlibcContext.b();
                        com.alibaba.baichuan.android.trade.adapter.ut.e.a("Taoke_Trace_Sync");
                        this.c.a(obj);
                        return;
                    }
                    if (a != null) {
                        str = a.errorMsg;
                        stringBuilder = new StringBuilder("1702");
                        stringBuilder.append(a.errorCode);
                        com.alibaba.baichuan.android.trade.adapter.ut.e.b("Taoke_Trace_Sync", str, stringBuilder.toString());
                    }
                    com.alibaba.baichuan.android.trade.utils.g.a.b();
                }
            }
            obj = null;
            this.a.b("taokeTime");
            if (TextUtils.isEmpty(obj)) {
                if (a != null) {
                    str = a.errorMsg;
                    stringBuilder = new StringBuilder("1702");
                    stringBuilder.append(a.errorCode);
                    com.alibaba.baichuan.android.trade.adapter.ut.e.b("Taoke_Trace_Sync", str, stringBuilder.toString());
                }
                com.alibaba.baichuan.android.trade.utils.g.a.b();
            } else {
                new StringBuilder("taoke同步打点成,sclickUrl：").append(a.data);
                AlibcContext.b();
                com.alibaba.baichuan.android.trade.adapter.ut.e.a("Taoke_Trace_Sync");
                this.c.a(obj);
                return;
            }
        }
        this.h.a(this.b, this.d, this.e, this.f, this.g);
        this.c.a(null);
    }
}
