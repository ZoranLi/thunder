package com.xunlei.downloadprovider.homepage.cinecism.ui;

import android.text.TextUtils;
import com.xunlei.downloadprovider.e.a.e;
import com.xunlei.downloadprovider.homepage.cinecism.data.CinecismInfo;

/* compiled from: CinecismCardView */
final class g implements e {
    final /* synthetic */ a a;

    g(a aVar) {
        this.a = aVar;
    }

    public final void a(String str, int i) {
        if (this.a.a != null) {
            if (this.a.b != null) {
                CinecismInfo cinecismInfo = this.a.a.a;
                if (TextUtils.equals(str, cinecismInfo.a) != null) {
                    cinecismInfo.g = i + 1;
                    cinecismInfo.f = true;
                    a.b(this.a.b, cinecismInfo);
                }
            }
        }
    }
}
