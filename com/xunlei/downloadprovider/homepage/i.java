package com.xunlei.downloadprovider.homepage;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.search.a;
import com.xunlei.downloadprovider.search.ui.search.bq;

/* compiled from: HomeFragment */
final class i implements OnClickListener {
    final /* synthetic */ HomeFragment a;

    i(HomeFragment homeFragment) {
        this.a = homeFragment;
    }

    public final void onClick(View view) {
        a.a(this.a.getActivity());
        view = bq.a().a;
        if (view.equals("搜索或输入网址")) {
            view = "";
        }
        com.xunlei.downloadprovider.search.c.a.a("home", "search_prepare", "bar", view);
    }
}
