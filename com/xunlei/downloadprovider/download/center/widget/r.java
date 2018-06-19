package com.xunlei.downloadprovider.download.center.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.report.a;
import com.xunlei.downloadprovider.plugin.q;

/* compiled from: DownloadCreateMoreTaskDialog */
final class r implements OnClickListener {
    final /* synthetic */ p a;

    r(p pVar) {
        this.a = pVar;
    }

    public final void onClick(View view) {
        a.h("qr_code");
        if (this.a.getOwnerActivity() != null) {
            q.a().a(this.a.getOwnerActivity(), "com.xunlei.plugin.qrcode", new u(this.a));
        }
        this.a.dismiss();
    }
}
