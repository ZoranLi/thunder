package com.xunlei.downloadprovider.download.create;

import com.xunlei.downloadprovider.app.AppStatusChgObserver.STATUS;
import com.xunlei.downloadprovider.app.AppStatusChgObserver.a;

/* compiled from: ClipboardHandler */
final class n implements a {
    final /* synthetic */ m a;

    n(m mVar) {
        this.a = mVar;
    }

    public final void a(STATUS status) {
        if (STATUS.STATUS_FOREGROUND == status) {
            m.a(this.a).addPrimaryClipChangedListener(this.a);
            if (this.a.b == null) {
                this.a.c();
                return;
            } else {
                this.a.b = false;
                return;
            }
        }
        m.a(this.a).removePrimaryClipChangedListener(this.a);
    }
}
