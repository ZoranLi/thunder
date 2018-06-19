package com.alibaba.baichuan.android.trade.g;

import android.app.Activity;
import android.text.TextUtils;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.callback.b;
import com.alibaba.baichuan.android.trade.d.d;
import com.alibaba.baichuan.android.trade.f.c;
import com.alibaba.baichuan.android.trade.model.AlibcTaokeParams;
import com.alibaba.baichuan.android.trade.model.ApplinkOpenType;
import com.alibaba.baichuan.android.trade.model.a;
import java.util.HashMap;
import java.util.Map;

public final class g extends b {
    private String b;
    private String c;

    public g(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.b = str;
        }
    }

    public final boolean a() {
        if (this.b != null) {
            if (!TextUtils.isEmpty(this.b)) {
                return true;
            }
        }
        return false;
    }

    public final boolean a(AlibcTaokeParams alibcTaokeParams) {
        return false;
    }

    public final String b() {
        return c.g;
    }

    public final String c() {
        if (this.c != null && !TextUtils.isEmpty(this.c)) {
            return this.c;
        }
        String str = AlibcContext.q;
        int indexOf = str.indexOf(63);
        if (indexOf > 0) {
            str = str.substring(0, indexOf);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("?shop_id=%s");
        this.c = String.format(stringBuilder.toString(), new Object[]{this.b});
        return this.c;
    }

    public final String e() {
        return "Shop_Page";
    }

    public final String f() {
        return "shop";
    }

    public final boolean a(AlibcTaokeParams alibcTaokeParams, a aVar, Map map, Activity activity) {
        AlibcTaokeParams alibcTaokeParams2 = alibcTaokeParams != null ? alibcTaokeParams.pid : null;
        if (aVar == null || TextUtils.isEmpty(aVar.b) != null) {
            alibcTaokeParams = "alisdk://";
        } else {
            alibcTaokeParams = aVar.b;
        }
        AlibcTaokeParams alibcTaokeParams3 = alibcTaokeParams;
        alibcTaokeParams = "";
        if (aVar != null) {
            alibcTaokeParams = aVar.c;
        }
        map.put("appType", alibcTaokeParams);
        return d.a(activity, ApplinkOpenType.SHOWSHOP, null, this.b, com.alibaba.baichuan.android.trade.e.a.g().f(), alibcTaokeParams2, alibcTaokeParams3, map);
    }

    public final void a(AlibcTaokeParams alibcTaokeParams, com.alibaba.baichuan.android.trade.b.a aVar, b bVar) {
        if (this.b != null && !TextUtils.isEmpty(this.b)) {
            HashMap hashMap = new HashMap();
            hashMap.put("shopId", this.b);
            if (aVar.e != null) {
                com.alibaba.baichuan.android.trade.d.b.a.a(hashMap, c(), true, alibcTaokeParams, c.g, aVar, bVar, aVar.e);
            }
        }
    }
}
