package com.xunlei.downloadprovider.personal.liked;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: LikeShortVideoFragment */
final class p implements a {
    final /* synthetic */ LikeShortVideoFragment a;

    p(LikeShortVideoFragment likeShortVideoFragment) {
        this.a = likeShortVideoFragment;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.a.a(1);
    }
}
