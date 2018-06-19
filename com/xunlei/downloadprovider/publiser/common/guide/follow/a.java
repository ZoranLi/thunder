package com.xunlei.downloadprovider.publiser.common.guide.follow;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.ad.common.i;
import com.xunlei.downloadprovider.publiser.common.guide.follow.a.n;
import com.xunlei.downloadprovider.publiser.common.guide.follow.d.b;
import java.util.List;

/* compiled from: GuideFollowPresenter */
public class a implements com.xunlei.downloadprovider.ad.common.i.a, com.xunlei.downloadprovider.publiser.common.guide.follow.d.a {
    private static final String a = "a";
    private final n b;
    private final b c;
    private i d;

    public a(n nVar, b bVar) {
        this.b = nVar;
        this.c = bVar;
    }

    public final void b() {
        com.xunlei.downloadprovider.publiser.common.guide.follow.a.b a = this.b.a();
        if (a != null) {
            this.c.a(a);
        }
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        if (a != null) {
            List<com.xunlei.downloadprovider.publiser.common.guide.follow.a.a> list = a.a;
            if (list != null) {
                for (com.xunlei.downloadprovider.publiser.common.guide.follow.a.a aVar : list) {
                    if (aVar != null) {
                        stringBuilder2.append(aVar.b);
                        stringBuilder2.append("_");
                        if (aVar.a()) {
                            stringBuilder.append(aVar.b);
                            stringBuilder.append("_");
                        }
                    }
                }
            }
        }
        a(stringBuilder2);
        a(stringBuilder);
        boolean c = this.b.c();
        String stringBuilder3 = stringBuilder.toString();
        String stringBuilder4 = stringBuilder2.toString();
        StatEvent build = HubbleEventBuilder.build("android_login_follow_rec", "login_follow_rec_show");
        build.addString("if_guid", c ? "1" : "0");
        build.addString("def_recid", stringBuilder3);
        build.addString("all_recid", stringBuilder4);
        ThunderReport.reportEvent(build);
        this.c.b(false);
        this.c.a("完成");
        this.c.a(true);
    }

    public final void c() {
        this.c.a(false);
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer append : this.c.b()) {
            stringBuilder.append(append);
            stringBuilder.append("_");
        }
        a(stringBuilder);
        boolean c = this.b.c();
        String stringBuilder2 = stringBuilder.toString();
        StatEvent build = HubbleEventBuilder.build("android_login_follow_rec", "login_follow_rec_complete");
        build.addString("if_guid", c ? "1" : "0");
        build.addString("sure_recid", stringBuilder2);
        ThunderReport.reportEvent(build);
        List a = this.c.a();
        if (a.isEmpty()) {
            this.b.b();
            this.c.c();
            return;
        }
        this.c.b(true);
        this.c.a("正在关注");
        this.d = new i(10);
        this.d.a(this);
        if (this.d != null) {
            this.d.a();
        }
        this.b.a(a, new b(this, a));
    }

    private static void a(StringBuilder stringBuilder) {
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public final void g_() {
        this.d.b(this);
        e();
        this.c.c();
    }

    private void e() {
        this.c.b(false);
        this.c.a("关注失败");
    }

    static /* synthetic */ void b(a aVar) {
        if (aVar.d != null) {
            aVar.d.d.cancel();
        }
    }

    static /* synthetic */ void c(a aVar) {
        aVar.c.b(false);
        aVar.c.a("关注成功");
    }

    static /* synthetic */ void a(boolean z, List list) {
        StringBuilder stringBuilder = new StringBuilder();
        if (list != null) {
            for (Long append : list) {
                stringBuilder.append(append);
                stringBuilder.append("_");
            }
        }
        a(stringBuilder);
        list = stringBuilder.toString();
        StatEvent build = HubbleEventBuilder.build("android_login_follow_rec", "login_follow_rec_followAll_result");
        build.addString("id_list", list);
        build.addString("result", z ? "success" : "fail");
        ThunderReport.reportEvent(build);
    }
}
