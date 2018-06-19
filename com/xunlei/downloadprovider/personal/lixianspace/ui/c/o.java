package com.xunlei.downloadprovider.personal.lixianspace.ui.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.personal.lixianspace.c.a;

/* compiled from: LXSpaceUpgradeTaskCountDlg */
final class o implements OnClickListener {
    final /* synthetic */ n a;

    o(n nVar) {
        this.a = nVar;
    }

    public final void onClick(View view) {
        ThunderReport.reportEvent(a.d("lx_off_dl_create_task_pay_click"));
        com.xunlei.downloadprovider.personal.lixianspace.a.a(this.a.getContext(), "intercepte", this.a.a);
        this.a.dismiss();
    }
}
