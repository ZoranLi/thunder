package com.xunlei.downloadprovider.homepage.recommend.feed;

import android.text.TextUtils;
import com.xunlei.downloadprovider.e.b.a;
import com.xunlei.downloadprovider.homepage.choiceness.j;

/* compiled from: FeedVideoItemView */
final class aj implements a {
    final /* synthetic */ z a;

    aj(z zVar) {
        this.a = zVar;
    }

    public final void a(String str) {
        if (TextUtils.equals(str, this.a.a.a.getVideoId()) != null) {
            this.a.s = this.a.s + 1;
            str = this.a.a;
            str.a.setShareCount(this.a.s);
            this.a.n.getShareCountTextView().setText(j.a((long) this.a.s));
        }
    }
}
