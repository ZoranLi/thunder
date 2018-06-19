package com.xunlei.downloadprovider.personal.a.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;

/* compiled from: UserInfoViewHolder */
final class an implements OnClickListener {
    final /* synthetic */ s a;

    an(s sVar) {
        this.a = sVar;
    }

    public final void onClick(View view) {
        m.a(this.a.X, this.a.W.g.c(), "", this.a.W.g.d(), this.a.W.g.a(1000), From.PERSONAL_ACCOUNT_HEAD);
    }
}
