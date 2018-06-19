package com.xunlei.downloadprovider.publiser.per;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PublisherActivity */
final class bt implements OnClickListener {
    final /* synthetic */ PublisherActivity a;

    bt(PublisherActivity publisherActivity) {
        this.a = publisherActivity;
    }

    public final void onClick(View view) {
        this.a.onBackPressed();
    }
}
