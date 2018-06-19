package com.alibaba.baichuan.android.trade.c.a.b;

import android.text.TextUtils;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.adapter.c.a;
import com.alibaba.baichuan.android.trade.c.a.a.b.c;
import com.alibaba.baichuan.android.trade.c.b.d;
import com.alibaba.baichuan.android.trade.callback.AlibcLoginCallback;
import com.alibaba.baichuan.android.trade.utils.d.b;
import com.alibaba.baichuan.android.trade.utils.l;
import com.taobao.accs.common.Constants;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

class e implements AlibcLoginCallback {
    final /* synthetic */ c a;
    final /* synthetic */ d b;

    e(d dVar, c cVar) {
        this.b = dVar;
        this.a = cVar;
    }

    public void onSuccess() {
        d dVar = this.a.b;
        if (dVar.a != null) {
            dVar.a.reload();
        }
        Map hashMap = new HashMap();
        if (!TextUtils.isEmpty(AlibcContext.c())) {
            hashMap.put("appkey", AlibcContext.c());
            String str = "userId";
            a aVar = a.a;
            aVar.b();
            hashMap.put(str, (aVar.b == null ? null : aVar.b.b()).c);
            hashMap.put("utdid", AlibcContext.a());
            hashMap.put(Constants.KEY_TTID, com.alibaba.baichuan.android.trade.e.a.g().e());
            hashMap.put("ybhpss", (String) b.a("trade", "ybhpss"));
        }
        com.alibaba.baichuan.android.trade.adapter.ut.a.a();
        com.alibaba.baichuan.android.trade.adapter.ut.a.a(com.alibaba.baichuan.android.trade.f.c.a, "", hashMap);
    }

    public void onFailure(int i, String str) {
        if (this.a != 0) {
            i = this.a.b != 0 ? this.a.b.a : 0;
            if (i != 0 && com.alibaba.baichuan.android.trade.utils.b.a(i.getTag(l.a(this.a.d, AgooConstants.MESSAGE_ID, "com_taobao_nb_sdk_webview_click"))) == 0) {
                if (this.a.b.b() != 0) {
                    this.a.b.d();
                } else if (this.a.d != 0) {
                    this.a.d.finish();
                }
            }
        }
    }
}
