package com.xunlei.downloadprovider.search.ui.search;

import com.xunlei.downloadprovider.R;
import com.xunlei.xllib.b.d;
import java.util.List;

/* compiled from: SearchOperateActivity */
final class bo implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ bn b;

    bo(bn bnVar, List list) {
        this.b = bnVar;
        this.a = list;
    }

    public final void run() {
        int a = SearchOperateActivity.l(this.b.a) != null ? d.a(this.a) ^ 1 : 0;
        if (SearchOperateActivity.m(this.b.a) != null) {
            SearchOperateActivity.m(this.b.a).setBackgroundResource(a != 0 ? R.color.common_content_bkg_color : R.color.white);
        }
    }
}
