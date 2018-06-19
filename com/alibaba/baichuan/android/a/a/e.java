package com.alibaba.baichuan.android.a.a;

import android.text.TextUtils;
import com.alibaba.baichuan.android.a.b.a;
import com.alibaba.baichuan.android.a.d;
import com.alibaba.baichuan.android.trade.utils.b;
import com.tencent.connect.common.Constants;

public class e extends a {
    public static String a = "AliBCWebView";

    public final boolean a(String str, String str2, d dVar) {
        if (!TextUtils.isEmpty(str2)) {
            if (!TextUtils.isEmpty(str)) {
                if ("setYbhpss".equals(str) != null) {
                    str = b.e(com.alibaba.fastjson.a.parseObject(str2));
                    if (str != null) {
                        this.c.b.put("ui_contextParams", com.alibaba.baichuan.android.trade.utils.a.a(str));
                    }
                    com.alibaba.baichuan.android.a.e eVar = new com.alibaba.baichuan.android.a.e();
                    eVar.a("0");
                    dVar.a(eVar);
                }
                return true;
            }
        }
        str = new com.alibaba.baichuan.android.a.e(Constants.VIA_SHARE_TYPE_INFO);
        str.a("2");
        dVar.b(str);
        return null;
    }
}
