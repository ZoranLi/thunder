package com.xunlei.downloadprovider.web.website.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.web.website.g.j;

/* compiled from: CollectionAndHistoryFragment */
final class a implements OnClickListener {
    final /* synthetic */ CollectionAndHistoryFragment a;

    a(CollectionAndHistoryFragment collectionAndHistoryFragment) {
        this.a = collectionAndHistoryFragment;
    }

    public final void onClick(View view) {
        j.a().a = true;
        LoginHelper.a().a(this.a.getContext(), this.a.m, LoginFrom.COLLECT_TAB_CLOUD, "CollectionAndHistoryFragment");
    }
}
