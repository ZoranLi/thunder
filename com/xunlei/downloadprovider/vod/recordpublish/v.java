package com.xunlei.downloadprovider.vod.recordpublish;

import android.view.inputmethod.InputMethodManager;
import com.xunlei.common.encrypt.URLCoder;
import com.xunlei.downloadprovider.vod.recordpublish.topicsearch.a;
import com.xunlei.downloadprovider.vod.recordpublish.z.b;

/* compiled from: VodPlayerTopicSelectActivity */
final class v implements b {
    final /* synthetic */ VodPlayerTopicSelectActivity a;

    v(VodPlayerTopicSelectActivity vodPlayerTopicSelectActivity) {
        this.a = vodPlayerTopicSelectActivity;
    }

    public final void a(a aVar) {
        if (this.a.p) {
            ((InputMethodManager) this.a.getSystemService("input_method")).toggleSoftInput(0, 2);
        }
        String str = aVar.a;
        this.a.a(str, (int) aVar.i);
        com.xunlei.downloadprovider.g.a.b.b("hot", URLCoder.encode(str, null));
    }
}
