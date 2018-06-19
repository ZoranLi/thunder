package com.xunlei.downloadprovider.personal.user;

import android.view.View;
import android.view.View.OnFocusChangeListener;

/* compiled from: ReportActivity */
final class n implements OnFocusChangeListener {
    final /* synthetic */ ReportActivity a;

    n(ReportActivity reportActivity) {
        this.a = reportActivity;
    }

    public final void onFocusChange(View view, boolean z) {
        if (z) {
            ReportActivity.d(this.a).check(true);
        }
    }
}
