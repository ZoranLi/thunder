package com.xunlei.downloadprovider.personal.lixianspace.ui.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.lixianspace.c.a;
import com.xunlei.downloadprovider.web.base.CustomWebViewActivity;

/* compiled from: LXSpaceExpansionDlg */
final class e implements OnClickListener {
    final /* synthetic */ c a;

    e(c cVar) {
        this.a = cVar;
    }

    public final void onClick(View view) {
        CustomWebViewActivity.a(this.a.getContext(), "lx-space-ex-dlg", "http://act.vip.xunlei.com/m/vip/2017/tqxq/#2", "迅雷会员离线下载特权配置", CustomWebViewActivity.class);
        a.c("view_details");
    }
}
