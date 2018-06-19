package com.xunlei.downloadprovider.ad.cache.task;

import com.xunlei.downloadprovider.ad.cache.a.b;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;

/* compiled from: FillTask */
public final class f extends b {
    public f(b bVar) {
        super(bVar);
    }

    protected final void d(STYLES_INFO styles_info, int i) {
        super.d(styles_info, i);
        e(styles_info, i);
    }

    protected final void d(STYLES_INFO styles_info) {
        super.d(styles_info);
        e(styles_info, 0);
    }

    private void e(STYLES_INFO styles_info, int i) {
        boolean z = i < styles_info.mRequiredSize;
        int i2 = styles_info.mCacheSize - i;
        StringBuilder stringBuilder = new StringBuilder("start fill task stylesInfo: ");
        stringBuilder.append(styles_info.name());
        stringBuilder.append(" shouldRequestCache: ");
        stringBuilder.append(z);
        stringBuilder.append(" remainderSize: ");
        stringBuilder.append(i);
        stringBuilder.append(" requestSize: ");
        stringBuilder.append(i2);
        if (z && i2 > 0) {
            this.b.a(styles_info, i2);
        }
    }
}
