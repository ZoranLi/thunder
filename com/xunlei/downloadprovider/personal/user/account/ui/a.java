package com.xunlei.downloadprovider.personal.user.account.ui;

import android.webkit.WebView;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.web.base.core.CustomWebView.b;

/* compiled from: UserAccountBindMobileActivity */
final class a implements b {
    final /* synthetic */ UserAccountBindMobileActivity a;

    public final void a(WebView webView) {
    }

    a(UserAccountBindMobileActivity userAccountBindMobileActivity) {
        this.a = userAccountBindMobileActivity;
    }

    public final void a() {
        if (!this.a.l) {
            String b;
            StatEvent build;
            if ("account_phone_change".equals(this.a.j)) {
                b = this.a.j;
                build = HubbleEventBuilder.build("android_personal_account", "account_safety_phone_change");
                build.add("from", b);
                ThunderReport.reportEvent(build);
            } else {
                b = this.a.j;
                build = HubbleEventBuilder.build("android_personal_account", "account_safety_phone_show");
                build.add("from", b);
                ThunderReport.reportEvent(build);
            }
        }
        this.a.l = true;
    }
}
