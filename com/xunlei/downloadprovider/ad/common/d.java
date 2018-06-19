package com.xunlei.downloadprovider.ad.common;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.j.a;
import com.xunlei.downloadprovider.ad.common.adget.l;

/* compiled from: AdFilledHelper */
public final class d {
    public static l a(@Nullable a aVar, @NonNull THUNDER_AD_INFO thunder_ad_info) {
        if (aVar == null) {
            return e.a(null, thunder_ad_info);
        }
        if (aVar.b == null) {
            return e.a(aVar, thunder_ad_info);
        }
        if (!aVar.b.i()) {
            return aVar.b;
        }
        thunder_ad_info = e.a(aVar, thunder_ad_info);
        if (thunder_ad_info != null) {
            return thunder_ad_info;
        }
        thunder_ad_info = aVar.b;
        if (aVar != null) {
            thunder_ad_info.H = aVar.f;
        }
        return aVar.b;
    }
}
