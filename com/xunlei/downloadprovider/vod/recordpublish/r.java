package com.xunlei.downloadprovider.vod.recordpublish;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.vod.recordpublish.a.a;

/* compiled from: VodPlayerTopicSelectActivity */
final class r implements a {
    final /* synthetic */ VodPlayerTopicSelectActivity a;

    r(VodPlayerTopicSelectActivity vodPlayerTopicSelectActivity) {
        this.a = vodPlayerTopicSelectActivity;
    }

    public final void a() {
        XLToast.showToast(this.a, "不可超过12字符", 1);
    }
}
