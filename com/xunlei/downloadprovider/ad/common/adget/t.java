package com.xunlei.downloadprovider.ad.common.adget;

import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import com.xunlei.downloadprovider.ad.common.c.b$a;
import com.xunlei.downloadprovider.ad.common.h.a;
import com.xunlei.downloadprovider.ad.common.report.j;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ThunderADManager */
public final class t {
    private Map<String, p> a;

    public final void a(THUNDER_AD_INFO thunder_ad_info, a aVar) {
        a(thunder_ad_info, aVar, -1, false);
    }

    public final void a(THUNDER_AD_INFO thunder_ad_info, a aVar, int i, boolean z) {
        if (thunder_ad_info != null) {
            if (aVar != null) {
                v vVar = new v(i, aVar, z);
                for (STYLES_INFO styles_info : thunder_ad_info.mStyles) {
                    z = new p(thunder_ad_info, styles_info);
                    if (this.a == null) {
                        this.a = new HashMap();
                    }
                    Map map = this.a;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(thunder_ad_info.mPositionId);
                    stringBuilder.append(Constants.COLON_SEPARATOR);
                    stringBuilder.append(styles_info.mStyleId);
                    map.put(stringBuilder.toString(), z);
                    z.b();
                }
                new e(thunder_ad_info).a(new u(this, vVar, thunder_ad_info), vVar);
            }
        }
    }

    static /* synthetic */ void a(t tVar, THUNDER_AD_INFO thunder_ad_info, v vVar, j.a aVar) {
        tVar = tVar.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(thunder_ad_info.mPositionId);
        stringBuilder.append(Constants.COLON_SEPARATOR);
        stringBuilder.append(aVar.h.mStyleId);
        p pVar = (p) tVar.get(stringBuilder.toString());
        if (pVar != null) {
            if ((pVar.c & aVar.a) != 0) {
                pVar.a(aVar, vVar);
            } else {
                j.a(thunder_ad_info.mPositionId, aVar.h.mStyleId, -10, new b$a());
                vVar.a(-10, "config error");
            }
        }
    }
}
