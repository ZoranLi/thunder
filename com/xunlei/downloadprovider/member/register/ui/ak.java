package com.xunlei.downloadprovider.member.register.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.downloadprovider.personal.user.account.k;

/* compiled from: RegisterSuccessActivity */
final class ak implements OnClickListener {
    final /* synthetic */ RegisterSuccessActivity a;

    ak(RegisterSuccessActivity registerSuccessActivity) {
        this.a = registerSuccessActivity;
    }

    public final void onClick(View view) {
        if (this.a.c == 1) {
            k.a(HubbleEventBuilder.build("android_personal_account", "register_name_gender_back"));
        } else {
            k.a(HubbleEventBuilder.build("android_personal_account", "register_head_back"));
        }
        this.a.onBackPressed();
    }
}
