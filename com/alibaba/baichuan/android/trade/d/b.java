package com.alibaba.baichuan.android.trade.d;

import android.text.TextUtils;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.adapter.ut.e;
import com.alibaba.baichuan.android.trade.b.a;
import com.alibaba.baichuan.android.trade.callback.AlibcFailureCallback;
import com.alibaba.baichuan.android.trade.model.AlibcTaokeParams;
import com.igexin.sdk.PushConsts;
import java.util.HashMap;

public final class b {
    public static final b a = new b();

    private b() {
    }

    static void a(String str, String str2, String str3) {
        e.b(str, str2, str3);
    }

    public final void a(HashMap hashMap, String str, boolean z, AlibcTaokeParams alibcTaokeParams, String str2, a aVar, com.alibaba.baichuan.android.trade.callback.b bVar, AlibcFailureCallback alibcFailureCallback) {
        HashMap hashMap2 = hashMap;
        AlibcTaokeParams alibcTaokeParams2 = alibcTaokeParams;
        com.alibaba.baichuan.android.trade.callback.b bVar2 = bVar;
        if (!com.alibaba.baichuan.android.trade.utils.b.a.a(AlibcContext.a)) {
            com.alibaba.baichuan.android.trade.utils.g.a.b();
            bVar2.a(null);
        } else if (alibcTaokeParams2 == null) {
            com.alibaba.baichuan.android.trade.utils.g.a.b();
        } else {
            AlibcContext.b();
            hashMap2.put("url", str == null ? "" : str);
            hashMap2.put("appKey", AlibcContext.c());
            hashMap2.put("utdid", AlibcContext.a());
            if (TextUtils.isEmpty(alibcTaokeParams2.subPid)) {
                hashMap2.put("subPid", null);
            } else {
                hashMap2.put("subPid", alibcTaokeParams2.subPid);
            }
            if (TextUtils.isEmpty(alibcTaokeParams2.unionId)) {
                hashMap2.put("unionId", null);
            } else {
                hashMap2.put("unionId", alibcTaokeParams2.unionId);
            }
            hashMap2.put(PushConsts.KEY_SERVICE_PIT, alibcTaokeParams2.pid);
            new StringBuilder("淘客参数:").append(hashMap2.toString());
            AlibcContext.b();
            a aVar2 = aVar;
            aVar2.d("async");
            if (z) {
                AlibcContext.b.a(new e(this, aVar2, hashMap2, bVar2, str, alibcTaokeParams2, str2, alibcFailureCallback));
                return;
            }
            a(hashMap2, str, alibcTaokeParams2, str2, alibcFailureCallback);
            bVar2.a(null);
        }
    }

    public final void a(HashMap hashMap, String str, AlibcTaokeParams alibcTaokeParams, String str2, AlibcFailureCallback alibcFailureCallback) {
        StringBuilder stringBuilder = new StringBuilder("taoke异步打点开始，参数为：");
        stringBuilder.append(hashMap != null ? hashMap.toString() : null);
        stringBuilder.append("url=");
        stringBuilder.append(str);
        stringBuilder.append("rpcReferer=");
        stringBuilder.append(str2);
        AlibcContext.b();
        AlibcContext.b.a(new f(this, hashMap, str, alibcTaokeParams, str2, alibcFailureCallback));
    }
}
