package com.alibaba.baichuan.android.trade.g;

import android.app.Activity;
import android.text.TextUtils;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.adapter.d.a;
import com.alibaba.baichuan.android.trade.callback.b;
import com.alibaba.baichuan.android.trade.d.d;
import com.alibaba.baichuan.android.trade.model.AlibcTaokeParams;
import com.alibaba.baichuan.android.trade.model.ApplinkOpenType;
import com.alibaba.wireless.security.open.opensdk.IOpenSDKComponent;
import java.util.HashMap;
import java.util.Map;

public final class c extends b {
    private String b;

    public final boolean a() {
        if (this.b != null) {
            if (!TextUtils.isEmpty(this.b)) {
                return true;
            }
        }
        return false;
    }

    public final boolean a(AlibcTaokeParams alibcTaokeParams) {
        return alibcTaokeParams != null;
    }

    public final String b() {
        return com.alibaba.baichuan.android.trade.f.c.h;
    }

    public final String e() {
        return "Detail_Page";
    }

    public final String f() {
        return "detail";
    }

    public c(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.matches("^\\d+$")) {
                this.b = str;
            } else {
                a.a();
                this.b = String.valueOf(a.a(str, IOpenSDKComponent.OPEN_BIZ_IID));
            }
        }
    }

    public final String c() {
        if (this.a != null && !TextUtils.isEmpty(this.a)) {
            return this.a;
        }
        String str = AlibcContext.r;
        int indexOf = str.indexOf(63);
        if (indexOf > 0) {
            str = str.substring(0, indexOf);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("?id=%s");
        this.a = String.format(stringBuilder.toString(), new Object[]{this.b});
        return this.a;
    }

    public final void a(AlibcTaokeParams alibcTaokeParams, com.alibaba.baichuan.android.trade.b.a aVar, b bVar) {
        if (this.b != null && !TextUtils.isEmpty(this.b)) {
            HashMap hashMap = new HashMap();
            hashMap.put("itemId", this.b);
            if (aVar.e != null) {
                com.alibaba.baichuan.android.trade.d.b.a.a(hashMap, c(), true, alibcTaokeParams, com.alibaba.baichuan.android.trade.f.c.h, aVar, bVar, aVar.e);
            }
        }
    }

    public final boolean a(AlibcTaokeParams alibcTaokeParams, com.alibaba.baichuan.android.trade.model.a aVar, Map map, Activity activity) {
        AlibcTaokeParams alibcTaokeParams2 = alibcTaokeParams != null ? alibcTaokeParams.pid : null;
        alibcTaokeParams = "";
        if (aVar != null) {
            alibcTaokeParams = aVar.c;
        }
        map.put("appType", alibcTaokeParams);
        alibcTaokeParams = (aVar == null || TextUtils.isEmpty(aVar.b) != null) ? "alisdk://" : aVar.b;
        return d.a(activity, ApplinkOpenType.SHOWITEM, null, this.b, com.alibaba.baichuan.android.trade.e.a.g().f(), alibcTaokeParams2, alibcTaokeParams, map);
    }
}
