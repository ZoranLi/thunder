package com.xunlei.downloadprovider.download.privatespace;

import com.xunlei.downloadprovider.app.AppStatusChgObserver.STATUS;
import com.xunlei.downloadprovider.app.AppStatusChgObserver.a;

/* compiled from: PrivateSpaceMgr */
final class ak implements a {
    final /* synthetic */ PrivateSpaceMgr a;

    ak(PrivateSpaceMgr privateSpaceMgr) {
        this.a = privateSpaceMgr;
    }

    public final void a(STATUS status) {
        if (STATUS.STATUS_BACKGROUND == status) {
            PrivateSpaceMgr.a().e();
        }
    }
}
