package com.xunlei.downloadprovider.vod.recordpublish;

import android.view.View;
import android.view.View.OnFocusChangeListener;

/* compiled from: VodPlayerTopicSelectActivity */
final class q implements OnFocusChangeListener {
    final /* synthetic */ VodPlayerTopicSelectActivity a;

    q(VodPlayerTopicSelectActivity vodPlayerTopicSelectActivity) {
        this.a = vodPlayerTopicSelectActivity;
    }

    public final void onFocusChange(View view, boolean z) {
        if (z) {
            this.a.p = true;
        } else {
            this.a.p = false;
        }
    }
}
