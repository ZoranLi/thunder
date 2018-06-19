package com.xunlei.downloadprovider.publiser.per;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.user.account.ui.UserAccountInfoActivity;

/* compiled from: PublisherActivity */
final class cr implements OnClickListener {
    final /* synthetic */ PublisherActivity a;

    cr(PublisherActivity publisherActivity) {
        this.a = publisherActivity;
    }

    public final void onClick(View view) {
        UserAccountInfoActivity.a(this.a, "personal_space");
    }
}
