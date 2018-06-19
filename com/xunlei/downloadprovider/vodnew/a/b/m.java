package com.xunlei.downloadprovider.vodnew.a.b;

import android.text.TextUtils;
import com.xunlei.downloadprovider.vod.subtitle.g.a;
import com.xunlei.downloadprovider.vodnew.a.d.b;

/* compiled from: PlayerSubtitleDecorator */
final class m implements a {
    final /* synthetic */ j a;

    m(j jVar) {
        this.a = jVar;
    }

    public final void a(String str) {
        j.a;
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            if (this.a.g != null) {
                this.a.g.a(false);
            }
            return;
        }
        str = this.a.a(str, 0);
        if (this.a.g != null) {
            b.a c = this.a.g;
            if (str == null) {
                z = true;
            }
            c.a(z);
        }
    }
}
