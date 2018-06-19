package com.xunlei.downloadprovider.personal.user.account.ui;

import android.widget.ImageView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.user.account.a.a;

/* compiled from: UserAccountInfoActivity */
final class v implements a {
    final /* synthetic */ UserAccountInfoActivity a;

    v(UserAccountInfoActivity userAccountInfoActivity) {
        this.a = userAccountInfoActivity;
    }

    public final void a(ImageView imageView, ImageView imageView2) {
        if (this.a.t != -1) {
            if (this.a.t == R.string.user_account_sexuality_male) {
                imageView.setVisibility(0);
            }
            if (this.a.t == R.string.user_account_sexuality_female) {
                imageView2.setVisibility(0);
                return;
            }
        }
        imageView.setVisibility(4);
        imageView2.setVisibility(4);
    }
}
