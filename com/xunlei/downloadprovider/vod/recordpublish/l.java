package com.xunlei.downloadprovider.vod.recordpublish;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.vod.recordpublish.a.a;

/* compiled from: VodPlayerPublishActivity */
final class l implements a {
    final /* synthetic */ VodPlayerPublishActivity a;

    l(VodPlayerPublishActivity vodPlayerPublishActivity) {
        this.a = vodPlayerPublishActivity;
    }

    public final void a() {
        XLToast.showToastWithDuration(this.a, "不可超过30字符", 1);
    }
}
