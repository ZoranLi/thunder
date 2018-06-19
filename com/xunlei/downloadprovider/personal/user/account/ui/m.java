package com.xunlei.downloadprovider.personal.user.account.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.user.account.k;
import com.xunlei.xllib.android.XLIntent;

/* compiled from: UserAccountInfoActivity */
final class m implements OnClickListener {
    final /* synthetic */ UserAccountInfoActivity a;

    m(UserAccountInfoActivity userAccountInfoActivity) {
        this.a = userAccountInfoActivity;
    }

    public final void onClick(View view) {
        switch (view.getId()) {
            case R.id.user_account_portrait:
                UserAccountInfoActivity.a(this.a);
                k.a(HubbleEventBuilder.build("android_personal_account", "account_head_click"));
                return;
            case R.id.user_account_nickname:
                UserAccountEditActivity.a(this.a, 1);
                k.a(HubbleEventBuilder.build("android_personal_account", "account_nick_conf"));
                return;
            case R.id.user_account_sexuality:
                UserAccountInfoActivity.c(this.a);
                k.a(HubbleEventBuilder.build("android_personal_account", "account_gender_conf"));
                return;
            case R.id.user_account_birthday:
                UserAccountInfoActivity.d(this.a);
                k.a(HubbleEventBuilder.build("android_personal_account", "account_birth_conf"));
                return;
            case R.id.user_account_address:
                UserAccountInfoActivity.e(this.a);
                return;
            case R.id.user_account_signature:
                UserAccountInfoActivity.f(this.a);
                return;
            case R.id.user_account_phone:
                if (TextUtils.isEmpty(this.a.u.i()) != null) {
                    k.b(false);
                    UserAccountBindMobileActivity.a(this.a, false, "account_phone_bind");
                    return;
                }
                k.b(true);
                UserAccountCurrentMobileActivity.a(this.a);
                return;
            case R.id.user_account_safe:
                this.a.startActivity(new XLIntent(this.a, UserAccountSecurityActivity.class));
                k.a(HubbleEventBuilder.build("android_personal_account", "account_third_conf"));
                return;
            case R.id.user_account_password:
                k.a(HubbleEventBuilder.build("android_personal_account", "account_pwd_conf"));
                UserAccountInfoActivity.h(this.a);
                return;
            case R.id.user_account_member_info:
                UserAccountInfoActivity.i(this.a);
                k.a(HubbleEventBuilder.build("android_personal_account", "account_vip_conf"));
                break;
            default:
                break;
        }
    }
}
