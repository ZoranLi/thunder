package com.xunlei.downloadprovider.ad.cache.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xunlei.downloadprovider.ad.cache.CacheException;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import com.xunlei.downloadprovider.ad.common.adget.c.b;
import com.xunlei.downloadprovider.ad.common.adget.k;
import com.xunlei.downloadprovider.ad.common.h.a;

/* compiled from: GDTNetwork */
public final class e extends d {
    public final void a(String str, @NonNull STYLES_INFO styles_info, int i, @NonNull a aVar) {
        StringBuilder stringBuilder = new StringBuilder("performRequest stylesInfo: ");
        stringBuilder.append(styles_info.name());
        stringBuilder.append(" size: ");
        stringBuilder.append(i);
        Object obj = styles_info.mGDTID;
        if (TextUtils.isEmpty(obj)) {
            throw new CacheException("requestId is empty");
        } else if (TextUtils.isEmpty(str)) {
            throw new CacheException("positionId is empty");
        } else {
            new b(com.xunlei.downloadprovider.ad.a.a(), obj, i).a(new f(this, styles_info, aVar, str), str);
            k.b("adv_request", k.a(str, styles_info, SocializeProtocolConstants.PROTOCOL_KEY_TENCENT));
        }
    }
}
