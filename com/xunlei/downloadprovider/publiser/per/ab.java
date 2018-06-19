package com.xunlei.downloadprovider.publiser.per;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.authphone.r;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;

/* compiled from: HistoryDynamicItemFragment */
final class ab implements OnClickListener {
    final /* synthetic */ HistoryDynamicItemFragment a;

    ab(HistoryDynamicItemFragment historyDynamicItemFragment) {
        this.a = historyDynamicItemFragment;
    }

    public final void onClick(View view) {
        view = this.a.i.b;
        long id = view.getId();
        view = view.getSourceId();
        LoginHelper.a();
        boolean c = l.c();
        StatEvent build = HubbleEventBuilder.build("android_personal_account", "personal_space_discuss_submit");
        build.add("movieid", view);
        build.add("discussid", String.valueOf(id));
        build.add("level", id == -1 ? "0" : "1");
        build.add("is_login", c ? "1" : "0");
        ThunderReport.reportEvent(build);
        if (r.a().a(this.a.b, LoginFrom.SHORTVIDEO_USERCENTER_REPLY, this.a.q) == null) {
            this.a.a();
        }
    }
}
