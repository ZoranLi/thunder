package com.xunlei.downloadprovider.ad.cache.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.xunlei.downloadprovider.ad.cache.CacheException;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import com.xunlei.downloadprovider.ad.common.adget.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: BaiDuNetwork */
public final class a extends d {
    public final void a(String str, @NonNull STYLES_INFO styles_info, int i, @NonNull com.xunlei.downloadprovider.ad.common.h.a aVar) throws CacheException {
        StringBuilder stringBuilder = new StringBuilder("performRequest stylesInfo: ");
        stringBuilder.append(styles_info.name());
        stringBuilder.append(" size: ");
        stringBuilder.append(i);
        Object obj = styles_info.mBaiduID;
        if (TextUtils.isEmpty(obj)) {
            throw new CacheException("requestId is empty");
        } else if (TextUtils.isEmpty(str)) {
            throw new CacheException("positionId is empty");
        } else {
            LinkedList linkedList = new LinkedList();
            com.xunlei.downloadprovider.ad.common.h.a bVar = new b(this, new ArrayList(), linkedList, i, aVar);
            aVar = new com.xunlei.downloadprovider.ad.common.adget.a.a(com.xunlei.downloadprovider.ad.a.a(), obj);
            i = i % 3 > 0 ? (i / 3) + 1 : i / 3;
            for (int i2 = 0; i2 < i; i2++) {
                linkedList.add(Integer.valueOf(i2));
                aVar.a(new c(this, styles_info, bVar, str), str);
                k.b("adv_request", k.a(str, styles_info, "baidu"));
            }
        }
    }

    static /* synthetic */ void a(LinkedList linkedList, int i, List list, com.xunlei.downloadprovider.ad.common.h.a aVar) {
        if (!linkedList.isEmpty()) {
            linkedList.pop();
            if (list.size() >= i || linkedList.isEmpty() != 0) {
                linkedList.clear();
                if (list.isEmpty() == null) {
                    aVar.a(list);
                    return;
                }
                aVar.a(-1, "no data");
            }
        }
    }
}
