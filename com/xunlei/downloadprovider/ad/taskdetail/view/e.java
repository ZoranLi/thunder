package com.xunlei.downloadprovider.ad.taskdetail.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.ad.common.f;

/* compiled from: TaskDetailBannerAdView */
final class e implements OnClickListener {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public final void onClick(View view) {
        if (this.a.b == null) {
            d.e;
        } else if (f.b(this.a.b) != null) {
            this.a.e();
        } else {
            this.a.c(this.a.b);
        }
    }
}
