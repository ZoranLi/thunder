package com.xunlei.downloadprovider.personal.lixianspace.c;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.payment.a.j;

/* compiled from: LXSpaceReport */
public final class a {
    public static void a(String str) {
        StatEvent d = d("lx_off_dl_create_task");
        d.add("click_id", str);
        ThunderReport.reportEvent(d);
    }

    public static void b(String str) {
        StatEvent d = d("lx_off_dl_dl_type_click");
        d.add("click_id", str);
        ThunderReport.reportEvent(d);
    }

    public static void c(String str) {
        StatEvent d = d("lx_off_dl_dilatation_pop_click");
        d.add("click_id", str);
        ThunderReport.reportEvent(d);
    }

    public static StatEvent d(String str) {
        str = HubbleEventBuilder.build("android_space_lixian_event", str);
        j.a();
        str.add("is_login", l.b()).add("is_year", j.a().e()).add("is_vip", j.a().c()).add("vip_level", j.a().a.m()).add("vip_type", j.a().d());
        return str;
    }
}
