package com.xunlei.downloadprovider.homepage.recommend.feed;

import android.text.TextUtils;
import com.xunlei.downloadprovider.e.a.e;
import com.xunlei.downloadprovider.homepage.choiceness.j;

/* compiled from: FeedVideoItemView */
final class aa implements e {
    final /* synthetic */ z a;

    aa(z zVar) {
        this.a = zVar;
    }

    public final void a(String str, int i) {
        if (TextUtils.equals(str, this.a.a.a.getVideoId()) != null) {
            i++;
            if (i > this.a.t) {
                this.a.t = i;
            } else {
                this.a.t = this.a.t + 1;
            }
            this.a.a.a(this.a.t);
            this.a.a.a();
            this.a.n.getLikeTextView().setText(j.a((long) this.a.t));
            this.a.i.add(this.a.a.a.getVideoId());
            this.a.n.getLikeImageView().setEnabled(0);
        }
    }
}
