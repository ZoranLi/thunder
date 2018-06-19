package com.xunlei.downloadprovider.ad.cache.b;

import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import com.xunlei.downloadprovider.ad.common.adget.k;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.h.a;
import com.xunlei.downloadprovider.ad.common.report.e;
import java.util.List;

/* compiled from: BaiDuNetwork */
final class c implements a {
    final /* synthetic */ STYLES_INFO a;
    final /* synthetic */ a b;
    final /* synthetic */ String c;
    final /* synthetic */ a d;

    c(a aVar, STYLES_INFO styles_info, a aVar2, String str) {
        this.d = aVar;
        this.a = styles_info;
        this.b = aVar2;
        this.c = str;
    }

    public final void a(List<l> list) {
        StringBuilder stringBuilder = new StringBuilder("performRequest onLoadComplete stylesInfo: ");
        stringBuilder.append(this.a.name());
        stringBuilder.append(" result.size: ");
        stringBuilder.append(list.size());
        this.b.a(list);
    }

    public final void a(int i, String str) {
        StringBuilder stringBuilder = new StringBuilder("performRequest onLoadFail stylesInfo: ");
        stringBuilder.append(this.a.name());
        stringBuilder.append(" errorCode: ");
        stringBuilder.append(i);
        stringBuilder.append(" errorInfo: ");
        stringBuilder.append(str);
        this.b.a(i, str);
        k.b("adv_request_fail", k.a(this.c, this.a, "baidu", e.a(i, str)));
    }
}
