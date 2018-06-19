package com.xunlei.downloadprovider.personal.user;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.R;

/* compiled from: ReportActivity */
final class l implements OnClickListener {
    final /* synthetic */ ReportActivity a;

    l(ReportActivity reportActivity) {
        this.a = reportActivity;
    }

    public final void onClick(View view) {
        ReportActivity.d(this.a).check(R.id.rbtn_other);
    }
}
