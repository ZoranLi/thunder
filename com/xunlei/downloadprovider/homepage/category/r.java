package com.xunlei.downloadprovider.homepage.category;

import android.support.annotation.NonNull;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.member.payment.a.e;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import java.util.List;

/* compiled from: ShortVideoCategoryDataHelper */
public final class r extends e {
    public final void a(String str, @NonNull c<List<com.xunlei.downloadprovider.homepage.choiceness.a.a.e>> cVar) {
        XLThreadPool.execute(new s(this, str, cVar));
    }
}
