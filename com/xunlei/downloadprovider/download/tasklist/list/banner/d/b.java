package com.xunlei.downloadprovider.download.tasklist.list.banner.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.member.payment.paymentfloat.FloatActivity;
import com.xunlei.downloadprovider.personal.settings.TaskSettingActivity;
import com.xunlei.xllib.android.XLIntent;

/* compiled from: DownloadLimitPrivilegeBanner */
final class b implements OnClickListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        if (this.a.a() != null) {
            this.a.a(false, this.a.d);
            this.a.c.startActivity(new XLIntent(this.a.c, TaskSettingActivity.class));
            d.a().c();
            view = HubbleEventBuilder.build("android_dl_center_action", "dl_task_limit_set_click");
            LoginHelper.a();
            view.add("is_login", l.c());
            ThunderReport.reportEvent(view);
            return;
        }
        if (this.a.b() != null) {
            FloatActivity.a(this.a.c, PayFrom.DOWNLOAD_TASK_LIMIT_PRIVILEGE);
            view = HubbleEventBuilder.build("android_dl_center_action", "dl_task_limit_vipkt_click");
            LoginHelper.a();
            view.add("is_login", l.c());
            ThunderReport.reportEvent(view);
        }
    }
}
