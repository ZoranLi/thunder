package com.xunlei.downloadprovider.homepage.follow.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;

/* compiled from: NotLoginViewHolder */
final class t implements OnClickListener {
    final /* synthetic */ View a;
    final /* synthetic */ s b;

    t(s sVar, View view) {
        this.b = sVar;
        this.a = view;
    }

    public final void onClick(View view) {
        LoginHelper.a().a(this.a.getContext(), null, LoginFrom.FOLLOW_TAB, null);
    }
}
