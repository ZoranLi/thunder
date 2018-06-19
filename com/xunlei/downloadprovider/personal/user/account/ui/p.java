package com.xunlei.downloadprovider.personal.user.account.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.user.account.k;

/* compiled from: UserAccountInfoActivity */
final class p implements OnLongClickListener {
    final /* synthetic */ UserAccountInfoActivity a;

    p(UserAccountInfoActivity userAccountInfoActivity) {
        this.a = userAccountInfoActivity;
    }

    public final boolean onLongClick(View view) {
        if (view.getId() == R.id.user_account_uid) {
            UserAccountInfoActivity.j(this.a);
            k.a(HubbleEventBuilder.build("android_personal_account", "account_uid_info"));
        }
        return true;
    }
}
