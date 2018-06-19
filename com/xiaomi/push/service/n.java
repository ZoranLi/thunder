package com.xiaomi.push.service;

import com.xiaomi.tinyData.c;
import com.xiaomi.xmpush.thrift.f;
import java.util.List;

public class n implements c {
    private final XMPushService a;

    public n(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    private String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    public void a(List<f> list, String str, String str2) {
        this.a.a(new o(this, 4, str, list, str2));
    }
}
