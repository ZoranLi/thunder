package com.xunlei.downloadprovider.homepage.choiceness.jointactivity;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.payment.a.j;

/* compiled from: JoinActivityReporter */
final class f {
    static StatEvent a(String str) {
        str = HubbleEventBuilder.build("android_caomei", str);
        j.a();
        str.add("is_login", l.b()).add("is_year", j.a().e()).add("is_vip", j.a().c()).add("vip_level", j.a().a.m()).add("vip_type", j.a().d());
        return str;
    }
}
