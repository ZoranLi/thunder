package com.xunlei.downloadprovider.personal.user.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;

/* compiled from: UserAccountCurrentMobileActivity */
final class e implements OnClickListener {
    final /* synthetic */ UserAccountCurrentMobileActivity a;

    e(UserAccountCurrentMobileActivity userAccountCurrentMobileActivity) {
        this.a = userAccountCurrentMobileActivity;
    }

    public final void onClick(View view) {
        ThunderReport.reportEvent(HubbleEventBuilder.build("android_personal_account", "account_phone_conf_click"));
        UserAccountBindMobileActivity.a(this.a, true, "account_phone_change");
    }
}
