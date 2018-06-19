package com.xunlei.downloadprovider.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.web.base.CustomWebViewActivity;

/* compiled from: ActivityDlg */
final class e implements OnClickListener {
    final /* synthetic */ b a;

    e(b bVar) {
        this.a = bVar;
    }

    public final void onClick(View view) {
        LoginHelper.a();
        view = l.c();
        StatEvent build = HubbleEventBuilder.build("android_home_activity", "home_activity_alert_click");
        build.add("if_login", view);
        h.a(build);
        if ("http://h5.m.xunlei.com/sj/activity/share-redpacket/index.html".equals(this.a.a.e) != null) {
            CustomWebViewActivity.a(this.a.i, "", this.a.a.e, "抢钱啦", CustomWebViewActivity.class);
        } else {
            CustomWebViewActivity.a(this.a.i, "", this.a.a.e, this.a.a.b, CustomWebViewActivity.class);
        }
        this.a.cancel();
    }
}
