package com.xunlei.downloadprovider.personal.liked;

import com.android.volley.n.b;
import com.xunlei.downloadprovider.homepage.recommend.a.w;
import java.util.List;

/* compiled from: LikeShortVideoFragment */
final class m implements b<List<w>> {
    final /* synthetic */ String a;
    final /* synthetic */ LikeShortVideoFragment b;

    m(LikeShortVideoFragment likeShortVideoFragment, String str) {
        this.b = likeShortVideoFragment;
        this.a = str;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        List list = (List) obj;
        if (this.b.b != null) {
            if (this.a == null) {
                this.b.b.a.clear();
            }
            if (list == null) {
                this.b.a(1);
                return;
            }
            if (list.size() < 20) {
                this.b.g.post(new n(this, list));
            }
            this.b.g.post(new o(this, LikeShortVideoFragment.a(this.b, list)));
        }
    }
}
