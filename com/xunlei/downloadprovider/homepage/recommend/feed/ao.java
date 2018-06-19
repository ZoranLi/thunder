package com.xunlei.downloadprovider.homepage.recommend.feed;

import android.text.TextUtils;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.homepage.recommend.b.c;
import com.xunlei.downloadprovider.homepage.recommend.b.e;
import com.xunlei.downloadprovider.homepage.recommend.feed.a.a;

/* compiled from: FeedVideoItemView */
final class ao implements a {
    final /* synthetic */ z a;

    ao(z zVar) {
        this.a = zVar;
    }

    public final void a(boolean z, String str) {
        if (z && !TextUtils.isEmpty(str)) {
            XLThreadPool.execute(new e(c.a(), str));
            z = new StringBuilder("点赞之后删除数据 movieId, Long.parseLong(movieId) = ");
            z.append(str);
            z.append(", ");
            z.append(Long.parseLong(str));
        }
    }
}
