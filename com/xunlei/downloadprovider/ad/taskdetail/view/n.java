package com.xunlei.downloadprovider.ad.taskdetail.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.ad.common.f;

/* compiled from: TaskDetailThemeAdView */
final class n implements OnClickListener {
    final /* synthetic */ m a;

    n(m mVar) {
        this.a = mVar;
    }

    public final void onClick(View view) {
        if (this.a.b != null) {
            if (f.b(this.a.b) != null) {
                this.a.e();
                return;
            }
            this.a.c(this.a.b);
        }
    }
}
