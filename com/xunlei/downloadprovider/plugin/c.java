package com.xunlei.downloadprovider.plugin;

import android.widget.PopupWindow.OnDismissListener;

/* compiled from: XLPluginDownloadManager */
final class c implements OnDismissListener {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final void onDismiss() {
        this.a.b = null;
        a.i(this.a);
    }
}
