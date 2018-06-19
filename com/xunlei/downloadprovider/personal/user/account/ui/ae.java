package com.xunlei.downloadprovider.personal.user.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.xunlei.downloadprovider.personal.user.account.k;

/* compiled from: UserAccountPortraitSettingActivity */
final class ae implements OnClickListener {
    final /* synthetic */ UserAccountPortraitSettingActivity a;

    ae(UserAccountPortraitSettingActivity userAccountPortraitSettingActivity) {
        this.a = userAccountPortraitSettingActivity;
    }

    public final void onClick(View view) {
        UserAccountPortraitSettingActivity.a(this.a).d = Token.WX_TOKEN_PLATFORMID_VALUE;
        k.a("account_center", Token.WX_TOKEN_PLATFORMID_VALUE);
        UserAccountPortraitSettingActivity.a(this.a, UserAccountPortraitSettingActivity.a(UserAccountPortraitSettingActivity.b(this.a)), 21, UserAccountPortraitSettingActivity.c(this.a), UserAccountPortraitSettingActivity.d(this.a));
    }
}
