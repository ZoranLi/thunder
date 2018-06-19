package com.alibaba.baichuan.android.trade.g;

import android.app.Activity;
import android.text.TextUtils;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.b.a;
import com.alibaba.baichuan.android.trade.c.a.a.e;
import com.alibaba.baichuan.android.trade.d.d;
import com.alibaba.baichuan.android.trade.f.c;
import com.alibaba.baichuan.android.trade.model.AlibcTaokeParams;
import com.alibaba.baichuan.android.trade.model.ApplinkOpenType;
import java.util.HashMap;
import java.util.Map;

public class b {
    private static final String b = "b";
    protected String a;

    public void a(AlibcTaokeParams alibcTaokeParams, a aVar, com.alibaba.baichuan.android.trade.callback.b bVar) {
    }

    public boolean a() {
        return true;
    }

    public boolean a(AlibcTaokeParams alibcTaokeParams) {
        return alibcTaokeParams != null;
    }

    public String b() {
        return c.k;
    }

    public String c() {
        return !TextUtils.isEmpty(this.a) ? this.a : null;
    }

    public int d() {
        return 0;
    }

    public String e() {
        return "Other_Page";
    }

    public String f() {
        return "url";
    }

    public boolean g() {
        return false;
    }

    public Map h() {
        return null;
    }

    public boolean a(AlibcTaokeParams alibcTaokeParams, com.alibaba.baichuan.android.trade.model.a aVar, Map map, Activity activity) {
        String str = "alisdk://";
        Object obj = "";
        AlibcTaokeParams alibcTaokeParams2 = alibcTaokeParams != null ? alibcTaokeParams.pid : null;
        if (aVar != null) {
            obj = aVar.c;
        }
        if (aVar != null && TextUtils.isEmpty(aVar.b) == null) {
            str = aVar.b;
        }
        String str2 = str;
        map.put("appType", obj);
        map.put("url", c());
        return d.a(activity, ApplinkOpenType.SHOWURL, c(), null, com.alibaba.baichuan.android.trade.e.a.g().f(), alibcTaokeParams2, str2, map);
    }

    public final String a(String str, Map map, a aVar) {
        StringBuilder stringBuilder = new StringBuilder("首次进入加参，参数： urlParams = ");
        stringBuilder.append(map);
        stringBuilder.append("  url=");
        stringBuilder.append(str);
        AlibcContext.b();
        if (map == null) {
            return c();
        }
        aVar.a("urlHandleTime");
        com.alibaba.baichuan.android.trade.c.a.a.c.a aVar2 = new com.alibaba.baichuan.android.trade.c.a.a.c.a();
        aVar2.e = 1;
        if (str == null) {
            str = c();
        }
        aVar2.d = str;
        aVar2.i = new HashMap();
        aVar2.i.put("ui_contextParams", map);
        str = e.a().a(aVar2);
        aVar.b("urlHandleTime");
        AlibcContext.b();
        if (str == null) {
            str = c();
        }
        return str;
    }

    public final boolean a(com.alibaba.baichuan.android.trade.model.a aVar) {
        if (!com.alibaba.baichuan.android.trade.adapter.b.a.a(aVar.c)) {
            return false;
        }
        if (d() != 0) {
            return 2 == d();
        } else {
            int a = com.alibaba.baichuan.android.trade.e.a.g().a();
            if (a == 1) {
                return true;
            }
            if (a == 2) {
                return false;
            }
            switch (aVar.a) {
                case H5:
                    return false;
                case Native:
                    return true;
                default:
                    aVar = c();
                    if (aVar != null) {
                        for (String matches : AlibcContext.l) {
                            if (aVar.matches(matches) && !"YES".equals(com.alibaba.baichuan.android.trade.e.a.g().a("isForceH5"))) {
                                return true;
                            }
                        }
                    }
                    return false;
            }
        }
    }
}
