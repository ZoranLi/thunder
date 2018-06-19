package com.xunlei.downloadprovider.search.ui.search;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.xunlei.downloadprovider.search.ui.widget.SearchTitleBar;

/* compiled from: SearchOperateActivity */
final class bj implements OnClickListener {
    final /* synthetic */ SearchOperateActivity a;

    bj(SearchOperateActivity searchOperateActivity) {
        this.a = searchOperateActivity;
    }

    public final void onClick(View view) {
        SearchTitleBar a = SearchOperateActivity.a(this.a);
        a.b.getEditableText().insert(a.b.getSelectionStart(), ((TextView) view).getText().toString());
    }
}
