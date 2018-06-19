package com.xunlei.downloadprovider.personal.lixianspace.ui.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.personal.lixianspace.c.a;

/* compiled from: LXDownloadEntryFragment */
final class e implements OnClickListener {
    final /* synthetic */ LXDownloadEntryFragment a;

    e(LXDownloadEntryFragment lXDownloadEntryFragment) {
        this.a = lXDownloadEntryFragment;
    }

    public final void onClick(View view) {
        if (this.a.m != null) {
            this.a.m.b();
        }
        ThunderReport.reportEvent(a.d("lx_off_dl_black_pay_botton_click"));
    }
}
