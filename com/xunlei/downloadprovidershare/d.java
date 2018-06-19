package com.xunlei.downloadprovidershare;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovidershare.b.d.b;

/* compiled from: InternalShareHelper */
final class d implements b {
    final /* synthetic */ b a;

    d(b bVar) {
        this.a = bVar;
    }

    public final void a(ShareOperationType shareOperationType) {
        StringBuilder stringBuilder = new StringBuilder("onItemClick--operationType=");
        stringBuilder.append(shareOperationType);
        stringBuilder.append("|shareInfo=");
        stringBuilder.append(this.a.c);
        stringBuilder.append("|size=");
        stringBuilder.append(this.a.g.a.size());
        this.a.b = shareOperationType;
        if (!shareOperationType.isShouldProcessShareUrl()) {
            if (this.a.d != null) {
                this.a.d.onShareTargetClicked(shareOperationType, this.a.c);
            }
            b.a(this.a, shareOperationType, this.a.c);
        } else if (com.xunlei.xllib.android.b.a(this.a.a)) {
            if (this.a.c.a(this.a.a, shareOperationType, new e(this, shareOperationType)) != null) {
                this.a.a(this.a.a);
            }
        } else {
            XLToast.showToast(this.a.a, "网络不给力");
            this.a.c();
        }
    }

    public final void a(boolean z) {
        StringBuilder stringBuilder = new StringBuilder("onDismiss--mShouldReleaseSharing=");
        stringBuilder.append(z);
        stringBuilder.append("|shareInfo=");
        stringBuilder.append(this.a.c);
        stringBuilder.append("|size=");
        stringBuilder.append(this.a.g.a.size());
        if (this.a.b == null || z) {
            this.a.c();
        }
    }
}
