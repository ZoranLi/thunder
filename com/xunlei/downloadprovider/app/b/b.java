package com.xunlei.downloadprovider.app.b;

import com.tencent.bugly.beta.upgrade.UpgradeStateListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: BuglyAgent */
public final class b implements UpgradeStateListener {
    public final void onDownloadCompleted(boolean z) {
    }

    public final void onUpgradeFailed(boolean z) {
    }

    public final void onUpgradeSuccess(boolean z) {
    }

    public final void onUpgrading(boolean z) {
    }

    public final void onUpgradeNoVersion(boolean z) {
        if (z) {
            XLToast.showToast(BrothersApplication.getApplicationInstance(), "你已经安装了最新版本");
        }
    }
}
