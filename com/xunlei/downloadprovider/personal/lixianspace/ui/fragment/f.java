package com.xunlei.downloadprovider.personal.lixianspace.ui.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.personal.lixianspace.c.a;

/* compiled from: LXDownloadEntryFragment */
final class f implements OnClickListener {
    final /* synthetic */ LXDownloadEntryFragment a;

    f(LXDownloadEntryFragment lXDownloadEntryFragment) {
        this.a = lXDownloadEntryFragment;
    }

    public final void onClick(View view) {
        ThunderReport.reportEvent(a.d("lx_off_dl_dilatation_botton_click"));
        LXDownloadEntryFragment.f(this.a);
    }
}
