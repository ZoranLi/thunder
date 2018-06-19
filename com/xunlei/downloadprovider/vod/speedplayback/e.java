package com.xunlei.downloadprovider.vod.speedplayback;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.payment.a.j;

/* compiled from: VodSpeedRateReporter */
public final class e {
    static StatEvent a(String str) {
        str = HubbleEventBuilder.build("android_player", str);
        j.a();
        str.add("is_login", l.b());
        str.add("is_vip", j.a().a.l());
        str.add("product_type", j.a().d());
        str.add("vip_level", j.a().a.m());
        return str;
    }
}
