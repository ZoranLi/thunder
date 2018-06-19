package com.xunlei.downloadprovider.download.tasklist.list.banner.d;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.download.tasklist.task.b;
import com.xunlei.downloadprovider.download.tasklist.task.h;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.xllib.b.d;

/* compiled from: DownloadLimitPrivilegeReporter */
public final class f {
    public static void a() {
        b b = h.e().b(1);
        if (b != null) {
            Object<e> c = b.c();
            if (!d.a(c)) {
                int i = 0;
                for (e eVar : c) {
                    if (!(eVar == null || eVar.a == 100 || eVar.b() == null)) {
                        DownloadTaskInfo b2 = eVar.b();
                        if (b2.getTaskStatus() == 2 || b2.getTaskStatus() == 1) {
                            i++;
                        }
                    }
                }
                if (i > 5) {
                    StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_task_limit_exceed");
                    LoginHelper.a();
                    build.add("is_login", l.c());
                    build.add("is_vip", LoginHelper.a().l());
                    build.add("vip_type", LoginHelper.a().g.f());
                    build.add("exceed_num", String.valueOf(i));
                    ThunderReport.reportEvent(build);
                }
            }
        }
    }
}
