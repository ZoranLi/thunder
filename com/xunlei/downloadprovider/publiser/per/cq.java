package com.xunlei.downloadprovider.publiser.per;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PublisherActivity */
final class cq implements OnClickListener {
    final /* synthetic */ PublisherActivity a;

    cq(PublisherActivity publisherActivity) {
        this.a = publisherActivity;
    }

    public final void onClick(View view) {
        PublisherActivity.b(this.a, "page_bottom");
    }
}
