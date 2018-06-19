package com.xunlei.downloadprovider.search.ui.search;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.search.c.a;
import java.util.List;

/* compiled from: SearchContentFragment */
final class at implements OnClickListener {
    final /* synthetic */ List a;
    final /* synthetic */ int b;
    final /* synthetic */ SearchContentFragment c;

    at(SearchContentFragment searchContentFragment, List list, int i) {
        this.c = searchContentFragment;
        this.a = list;
        this.b = i;
    }

    public final void onClick(View view) {
        SearchContentFragment.a(this.c, (String) this.a.get(this.b));
        a.b("search_page_hot", (String) this.a.get(this.b), "word", "quangwang");
        a.a("hotword", "word", (String) this.a.get(this.b), "quangwang", "", "");
    }
}
