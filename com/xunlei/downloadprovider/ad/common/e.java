package com.xunlei.downloadprovider.ad.common;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.xunlei.downloadprovider.ad.cache.b;
import com.xunlei.downloadprovider.ad.common.adget.ADConst;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import com.xunlei.downloadprovider.ad.common.adget.k;
import com.xunlei.downloadprovider.ad.common.adget.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: AllianceFilledAdHelper */
public final class e {

    /* compiled from: AllianceFilledAdHelper */
    private static class a {
        public boolean a;
        public int b;

        public a(boolean z, int i) {
            this.a = z;
            this.b = i;
        }
    }

    public static l a(@Nullable com.xunlei.downloadprovider.ad.common.adget.j.a aVar, @NonNull THUNDER_AD_INFO thunder_ad_info) {
        int i;
        int[] iArr = new int[]{2, 4, 1};
        STYLES_INFO defStyle = aVar == null ? thunder_ad_info.getDefStyle() : aVar.h;
        if (aVar == null) {
            i = 2;
        } else {
            i = aVar.a;
        }
        List<a> arrayList = new ArrayList();
        for (int i2 = 0; i2 < 3; i2++) {
            int i3 = iArr[i2];
            if ((defStyle.mLoadStrate & i3) != 0) {
                boolean z = (i3 & i) != 0;
                if (!ADConst.a(i3)) {
                    if (ADConst.c(i3)) {
                        i3 = 2;
                    } else if (ADConst.b(i3)) {
                        i3 = 3;
                    }
                    if (z) {
                        arrayList.add(new a(true, i3));
                    } else {
                        arrayList.add(0, new a(false, i3));
                    }
                }
                i3 = 1;
                if (z) {
                    arrayList.add(new a(true, i3));
                } else {
                    arrayList.add(0, new a(false, i3));
                }
            }
        }
        new StringBuilder("wrappers: ").append(Arrays.toString(arrayList.toArray()));
        l lVar = null;
        for (a aVar2 : arrayList) {
            STYLES_INFO styles_info;
            if (aVar2.a && aVar != null) {
                aVar.c = null;
                aVar.d = null;
            }
            int i4 = aVar2.b;
            if (aVar != null) {
                styles_info = aVar.h;
            } else {
                styles_info = thunder_ad_info.getDefStyle();
            }
            lVar = b.a().a(thunder_ad_info.getPositionId(), i4, styles_info);
            if (lVar != null) {
                if (aVar != null) {
                    lVar.H = aVar.f;
                    lVar.w = k.a(aVar.d);
                    lVar.x = k.a(aVar.c);
                    lVar.v = aVar.h;
                } else {
                    lVar.v = thunder_ad_info.getDefStyle();
                }
                lVar.a(thunder_ad_info.getPositionId());
                continue;
            }
            if (lVar != null) {
                break;
            }
        }
        new StringBuilder("getAllianceAdFillData adInfo: ").append(lVar == null ? "null" : lVar);
        return lVar;
    }
}
