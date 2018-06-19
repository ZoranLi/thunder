package com.xunlei.downloadprovider.personal.lixianspace.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;

/* compiled from: LXSpaceActivity */
final class f implements OnClickListener {
    final /* synthetic */ LXSpaceActivity a;

    f(LXSpaceActivity lXSpaceActivity) {
        this.a = lXSpaceActivity;
    }

    public final void onClick(View view) {
        LoginHelper.a().a(this.a, new g(this), LoginFrom.SPACE_LI_XIAN, null);
    }
}
