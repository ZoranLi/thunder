package com.xunlei.downloadprovider.ad.taskdetailnew;

import android.os.Handler;
import android.os.Looper;
import com.xunlei.downloadprovider.ad.cache.b;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.adget.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: TaskDetailNewAdModel */
public final class c {
    private static c b;
    Map<THUNDER_AD_INFO, List<l>> a;

    public static c a() {
        if (b == null) {
            b = new c();
        }
        return b;
    }

    private c() {
        this.a = null;
        this.a = new HashMap();
    }

    private static void c(THUNDER_AD_INFO thunder_ad_info) {
        new Handler(Looper.getMainLooper()).postDelayed(new d(thunder_ad_info), 2000);
    }

    public final void b(THUNDER_AD_INFO thunder_ad_info) {
        new r().a(thunder_ad_info, new e(this, thunder_ad_info), true);
    }

    public final l a(THUNDER_AD_INFO thunder_ad_info) {
        List arrayList = new ArrayList(1);
        List list = (List) this.a.get(thunder_ad_info);
        if (list != null) {
            if (!list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    l lVar = (l) it.next();
                    it.remove();
                    arrayList.add(lVar);
                }
            }
        }
        b(thunder_ad_info);
        return arrayList.isEmpty() == null ? (l) arrayList.get(null) : null;
    }

    public static void b() {
        if (b.a()) {
            b.a().a(STYLES_INFO.TASK_DETAIL_NEW_IMG);
        }
        if (b.d()) {
            b.a().a(STYLES_INFO.TASK_DETAIL_NEW_BANNER);
        }
        if (b.a()) {
            c(THUNDER_AD_INFO.TASK_DETAIL_NEW_IMAGE);
        }
        if (b.d()) {
            c(THUNDER_AD_INFO.TASK_DETAIL_NEW_BANNER);
        }
    }
}
