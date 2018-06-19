package com.xunlei.downloadprovider.app.a;

import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.QbSdk.PreInitCallback;
import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: LaunchInitialization */
final class l implements PreInitCallback {
    final /* synthetic */ i a;

    l(i iVar) {
        this.a = iVar;
    }

    public final void onViewInitFinished(boolean z) {
        z = i.a;
    }

    public final void onCoreInitFinished() {
        if (QbSdk.getTbsVersion(BrothersApplication.getApplicationInstance()) < 38000) {
            QbSdk.forceSysWebView();
            return;
        }
        QbSdk.unForceSysWebView();
        String str = i.a;
    }
}
