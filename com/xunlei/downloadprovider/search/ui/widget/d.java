package com.xunlei.downloadprovider.search.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.search.c.a;
import com.xunlei.downloadprovider.search.ui.search.SearchOperateActivity;

/* compiled from: SearchAssociativeView */
final class d implements OnClickListener {
    final /* synthetic */ SearchAssociativeView a;

    d(SearchAssociativeView searchAssociativeView) {
        this.a = searchAssociativeView;
    }

    public final void onClick(View view) {
        ((SearchOperateActivity) this.a.getContext()).a("search_think_zonghe", this.a.c, 2);
        a.b("search_think", this.a.c, "word", "zonghe");
    }
}
