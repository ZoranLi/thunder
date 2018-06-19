package com.xunlei.downloadprovider.homepage.youliao.flow;

import android.text.TextUtils;
import com.xunlei.downloadprovider.e.a.e;

/* compiled from: YouliaoVideoCardViewHolder */
final class j implements e {
    final /* synthetic */ g a;

    j(g gVar) {
        this.a = gVar;
    }

    public final void a(String str, int i) {
        if (this.a.c != null && TextUtils.equals(str, this.a.c.getVideoId()) != null) {
            this.a.c.getLikeInfo().setLikeCount(i + 1);
            if (this.a.d != null) {
                this.a.d.a(this.a.c.getLikeInfo().getLikeCount());
            }
        }
    }
}
