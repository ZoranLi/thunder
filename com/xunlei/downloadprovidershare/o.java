package com.xunlei.downloadprovidershare;

import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

/* compiled from: ShareProxy */
final class o implements UMShareListener {
    final /* synthetic */ n a;

    public final void onStart(SHARE_MEDIA share_media) {
    }

    o(n nVar) {
        this.a = nVar;
    }

    public final void onResult(SHARE_MEDIA share_media) {
        if (this.a.a != null) {
            this.a.a.a(0);
            this.a.a = null;
        }
    }

    public final void onError(SHARE_MEDIA share_media, Throwable th) {
        if (this.a.a != null) {
            this.a.a.a(1);
            this.a.a = null;
        }
    }

    public final void onCancel(SHARE_MEDIA share_media) {
        if (this.a.a != null) {
            this.a.a.a(2);
            this.a.a = null;
        }
    }
}
