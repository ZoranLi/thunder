package com.xunlei.downloadprovider.vod.recordpublish;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: VodTopicSearchBar */
final class x implements OnClickListener {
    final /* synthetic */ VodTopicSearchBar a;

    x(VodTopicSearchBar vodTopicSearchBar) {
        this.a = vodTopicSearchBar;
    }

    public final void onClick(View view) {
        this.a.a.setText("");
    }
}
