package com.xunlei.downloadprovider.publiser.common.guide.follow.a;

import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.ad.common.n;
import com.xunlei.downloadprovider.publiser.common.guide.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: GuideFollowModel */
public final class d implements n {
    public final b a() {
        a a = a.a();
        Object g = a.d() ? a.b.g() : null;
        if (g instanceof b) {
            return (b) g;
        }
        return null;
    }

    public final void a(@NonNull List<Long> list, @NonNull n<List<Long>> nVar) {
        new com.xunlei.downloadprovider.homepage.follow.c.a().b(new ArrayList(new HashSet(list)), new e(this, nVar));
    }

    public final void b() {
        a.a().e();
    }

    public final boolean c() {
        a a = a.a();
        return a.c() && a.a.c();
    }
}
