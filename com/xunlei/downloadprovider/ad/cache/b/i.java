package com.xunlei.downloadprovider.ad.cache.b;

import android.os.Handler;
import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.ad.cache.CacheException;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import com.xunlei.downloadprovider.ad.common.h.a;

/* compiled from: RequestHandler */
public final class i {
    public final void a(String str, @NonNull STYLES_INFO styles_info, int i, int i2, int i3, @NonNull Handler handler) {
        d eVar;
        int i4 = i;
        int i5 = i2;
        StringBuilder stringBuilder = new StringBuilder("startCache stylesInfo: ");
        stringBuilder.append(styles_info.name());
        stringBuilder.append(" adType: ");
        stringBuilder.append(i4);
        stringBuilder.append(" size: ");
        stringBuilder.append(i5);
        stringBuilder.append(" retryTimes: ");
        int i6 = i3;
        stringBuilder.append(i6);
        a jVar = new j(this, i6, styles_info, handler, str, i4, i5);
        switch (i4) {
            case 1:
                eVar = new e();
                break;
            case 2:
                eVar = new g();
                break;
            case 3:
                eVar = new a();
                break;
            default:
                eVar = null;
                break;
        }
        if (eVar != null) {
            try {
                eVar.a(str, styles_info, i5, jVar);
            } catch (CacheException e) {
                e.getLocalizedMessage();
            }
        }
    }
}
