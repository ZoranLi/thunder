package com.xunlei.downloadprovider.personal.user.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.user.account.k;

/* compiled from: UserAccountEditActivity */
final class i implements OnClickListener {
    final /* synthetic */ UserAccountEditActivity a;

    i(UserAccountEditActivity userAccountEditActivity) {
        this.a = userAccountEditActivity;
    }

    public final void onClick(View view) {
        k.b("account_center", "cancel");
        this.a.finish();
    }
}
