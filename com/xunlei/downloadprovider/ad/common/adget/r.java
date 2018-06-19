package com.xunlei.downloadprovider.ad.common.adget;

import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.d;
import com.xunlei.downloadprovider.ad.common.h.a;
import java.util.Collections;

/* compiled from: TaskDetailADManager */
public final class r {
    public final void a(THUNDER_AD_INFO thunder_ad_info, a aVar, boolean z) {
        if (thunder_ad_info != null) {
            v vVar = new v(-1, aVar, z);
            new e(thunder_ad_info).a(new s(this, vVar, thunder_ad_info), vVar);
        }
    }

    static /* synthetic */ void a(THUNDER_AD_INFO thunder_ad_info, v vVar, j.a aVar) {
        thunder_ad_info = d.a(aVar, thunder_ad_info);
        if (thunder_ad_info != null) {
            vVar.a(Collections.singletonList(thunder_ad_info));
        } else {
            vVar.a(-11, "no data");
        }
    }
}
