package com.xunlei.downloadprovider.publiser.per;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.publiser.common.view.a;

/* compiled from: PublisherActivity */
final class cl implements OnClickListener {
    final /* synthetic */ PublisherActivity a;

    cl(PublisherActivity publisherActivity) {
        this.a = publisherActivity;
    }

    public final void onClick(View view) {
        boolean isAuthPub = this.a.d.a().isAuthPub();
        String kind = this.a.d.a().getKind();
        if (isAuthPub || "rad".equals(kind) || "yl_daren".equals(kind) || "yl_nanshen".equals(kind) || "yl_nvshen".equals(kind)) {
            new a(view.getContext(), isAuthPub, kind).show();
        }
    }
}
