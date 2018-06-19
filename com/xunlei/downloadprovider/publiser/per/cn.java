package com.xunlei.downloadprovider.publiser.per;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PublisherActivity */
final class cn implements OnClickListener {
    final /* synthetic */ PublisherActivity a;

    cn(PublisherActivity publisherActivity) {
        this.a = publisherActivity;
    }

    public final void onClick(View view) {
        PublisherActivity.a(this.a, "shortvideo_usercenter_chat");
    }
}
