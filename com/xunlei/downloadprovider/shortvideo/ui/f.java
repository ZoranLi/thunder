package com.xunlei.downloadprovider.shortvideo.ui;

import android.text.TextUtils;
import com.xunlei.downloadprovider.e.a.e;

/* compiled from: PlayerUgcView */
final class f implements e {
    final /* synthetic */ a a;

    f(a aVar) {
        this.a = aVar;
    }

    public final void a(String str, int i) {
        if (this.a.c != null) {
            if (this.a.b != null) {
                if (TextUtils.equals(str, this.a.c.getVideoId()) != null) {
                    this.a.c.setLikeCount(i + 1);
                    this.a.c.setHasLike(true);
                    a.b(this.a.b, this.a.c);
                }
            }
        }
    }
}
