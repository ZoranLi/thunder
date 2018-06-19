package com.alibaba.baichuan.android.trade.g;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.callback.b;
import com.alibaba.baichuan.android.trade.f.c;
import com.alibaba.baichuan.android.trade.model.AlibcTaokeParams;
import com.alibaba.wireless.security.open.opensdk.IOpenSDKComponent;
import java.util.HashMap;

public final class a extends b {
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
        return c.e;
    }

    public final String c() {
        if (this.a != null && !TextUtils.isEmpty(this.a)) {
            return this.a;
        }
        String str = AlibcContext.p;
        int indexOf = str.indexOf(63);
        if (indexOf > 0) {
            str = str.substring(0, indexOf);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("?id=%s");
        this.a = Uri.parse(String.format(stringBuilder.toString(), new Object[]{String.valueOf(this.b)})).buildUpon().appendQueryParameter("action_tae", "cart").appendQueryParameter("from_tae", "true").fragment("sku").build().toString();
        return this.a;
    }

    public final int d() {
        return 1;
    }

    public final String e() {
        return "Cart_Page";
    }

    public final String f() {
        return "addCart";
    }

    public a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.matches("^\\d+$")) {
                this.b = str;
            } else {
                com.alibaba.baichuan.android.trade.adapter.d.a.a();
                this.b = String.valueOf(com.alibaba.baichuan.android.trade.adapter.d.a.a(str, IOpenSDKComponent.OPEN_BIZ_IID));
            }
        }
    }

    public final void a(AlibcTaokeParams alibcTaokeParams, com.alibaba.baichuan.android.trade.b.a aVar, b bVar) {
        if (this.b != null && !TextUtils.isEmpty(this.b)) {
            HashMap hashMap = new HashMap();
            hashMap.put("itemId", this.b);
            if (aVar.e != null) {
                com.alibaba.baichuan.android.trade.d.b.a.a(hashMap, c(), false, alibcTaokeParams, c.e, aVar, bVar, aVar.e);
            }
        }
    }
}
