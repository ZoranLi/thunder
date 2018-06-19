package com.xunlei.downloadprovider.vod.recordpublish;

import android.view.View;
import android.view.View.OnFocusChangeListener;

/* compiled from: VodTopicSearchBar */
final class y implements OnFocusChangeListener {
    final /* synthetic */ VodTopicSearchBar a;

    y(VodTopicSearchBar vodTopicSearchBar) {
        this.a = vodTopicSearchBar;
    }

    public final void onFocusChange(View view, boolean z) {
        this.a.a(z);
        if (this.a.i != null) {
            this.a.i.onFocusChange(view, z);
        }
    }
}
