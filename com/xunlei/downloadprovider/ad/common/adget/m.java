package com.xunlei.downloadprovider.ad.common.adget;

import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.d.d;
import java.util.List;

/* compiled from: ContentADRequestHelper */
public final class m {
    public static String a(List<THUNDER_AD_INFO> list, int i) {
        boolean c;
        StringBuilder stringBuilder = new StringBuilder();
        if (i != 4) {
            switch (i) {
                case 1:
                    c = d.a().p.c();
                    break;
                case 2:
                    c = d.a().p.n();
                    break;
                default:
                    c = true;
                    break;
            }
        }
        c = d.a().p.d();
        k.a(stringBuilder, "ads_filter", c ? "0" : "1", false);
        stringBuilder.append(k.a(list, true, i));
        return stringBuilder.toString();
    }
}
