package com.xunlei.downloadprovider.plugin.b;

import android.widget.PopupWindow.OnDismissListener;

/* compiled from: PluginLoadingPopupWindow */
final class b implements OnDismissListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void onDismiss() {
        this.a.c = null;
        if (this.a.f != null) {
            this.a.f.onDismiss();
        }
    }
}
