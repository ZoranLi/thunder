package com.xunlei.downloadprovider.personal.user;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.settings.HelpActivity;

/* compiled from: ReportActivity */
final class p implements OnClickListener {
    final /* synthetic */ ReportActivity a;

    p(ReportActivity reportActivity) {
        this.a = reportActivity;
    }

    public final void onClick(View view) {
        HelpActivity.a(this.a, "file:///android_asset/reg_protocol/copyright.html", this.a.getString(R.string.report_copyright_protocol_webpage_title));
    }
}
