package com.xunlei.downloadprovider.publiser.per;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.homepage.recommend.a;
import com.xunlei.downloadprovider.publiser.common.o;

/* compiled from: PublisherActivity */
final class cf implements OnClickListener {
    final /* synthetic */ PublisherActivity a;

    cf(PublisherActivity publisherActivity) {
        this.a = publisherActivity;
    }

    public final void onClick(View view) {
        a.b("avatar", o.a(this.a.l));
        PublisherActivity.b(this.a);
    }
}
