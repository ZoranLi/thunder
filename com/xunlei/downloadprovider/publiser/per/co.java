package com.xunlei.downloadprovider.publiser.per;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PublisherActivity */
final class co implements OnClickListener {
    final /* synthetic */ PublisherActivity a;

    co(PublisherActivity publisherActivity) {
        this.a = publisherActivity;
    }

    public final void onClick(View view) {
        PublisherActivity.b(this.a, "icon_below");
    }
}
