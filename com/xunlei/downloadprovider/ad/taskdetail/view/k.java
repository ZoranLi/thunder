package com.xunlei.downloadprovider.ad.taskdetail.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.ad.common.f;

/* compiled from: TaskDetailStyleDownloadListAdView */
final class k implements OnClickListener {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public final void onClick(View view) {
        if (this.a.b == null) {
            j.k;
        } else if (f.b(this.a.b) != null) {
            this.a.e();
        } else {
            this.a.c(this.a.b);
        }
    }
}
