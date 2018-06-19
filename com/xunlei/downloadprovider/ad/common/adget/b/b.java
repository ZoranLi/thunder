package com.xunlei.downloadprovider.ad.common.adget.b;

import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import com.xunlei.downloadprovider.ad.common.adget.j.a;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.adget.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: MultiADManager */
public class b {
    public static final String a = "b";
    private Map<THUNDER_AD_INFO, List<l>> b = new HashMap();
    private Map<String, n> c = new HashMap();
    private List<THUNDER_AD_INFO> d = new LinkedList();
    private a e;

    private void a(THUNDER_AD_INFO thunder_ad_info) {
        this.d.remove(thunder_ad_info);
        if (this.d.isEmpty() != null && this.e != null) {
            this.e.a(this.b);
        }
    }

    public final void a(List<THUNDER_AD_INFO> list, a aVar) {
        if (list != null) {
            if (list.size() != 0) {
                this.e = aVar;
                this.d.addAll(list);
                for (THUNDER_AD_INFO thunder_ad_info : list) {
                    if (thunder_ad_info != null) {
                        for (STYLES_INFO styles_info : thunder_ad_info.mStyles) {
                            j jVar = new j(thunder_ad_info, styles_info);
                            Map map = this.c;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(thunder_ad_info.mPositionId);
                            stringBuilder.append(Constants.COLON_SEPARATOR);
                            stringBuilder.append(styles_info.mStyleId);
                            map.put(stringBuilder.toString(), jVar);
                        }
                    }
                }
                new e(list).a(new c(this, list));
            }
        }
    }

    static /* synthetic */ void a(b bVar, THUNDER_AD_INFO thunder_ad_info, a aVar) {
        Map map = bVar.c;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(thunder_ad_info.mPositionId);
        stringBuilder.append(Constants.COLON_SEPARATOR);
        stringBuilder.append(aVar.h.mStyleId);
        n nVar = (n) map.get(stringBuilder.toString());
        if (nVar != null) {
            if ((nVar.a() & aVar.a) != 0) {
                nVar.b();
                nVar.a(aVar, new d(bVar, thunder_ad_info, aVar));
                return;
            }
            bVar.b.put(thunder_ad_info, new ArrayList());
            bVar.a(thunder_ad_info);
        }
    }
}
