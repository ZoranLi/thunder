package com.xunlei.downloadprovider.download.tasklist.list.banner.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: DownloadLimitPrivilegeBanner */
final class c implements OnClickListener {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        this.a.a(false, this.a.d);
        if (this.a.a() != null) {
            d.a().c();
            view = HubbleEventBuilder.build("android_dl_center_action", "dl_task_limit_set_close");
            LoginHelper.a();
            view.add("is_login", l.c());
            ThunderReport.reportEvent(view);
            return;
        }
        if (this.a.b() != null) {
            view = d.a();
            view.b.putString(d.g(), new SimpleDateFormat("yyyy-MM-dd").format(new Date())).commit();
            view = HubbleEventBuilder.build("android_dl_center_action", "dl_task_limit_vipkt_close");
            LoginHelper.a();
            view.add("is_login", l.c());
            ThunderReport.reportEvent(view);
        }
    }
}
