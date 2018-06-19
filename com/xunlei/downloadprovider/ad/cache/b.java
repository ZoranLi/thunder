package com.xunlei.downloadprovider.ad.cache;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.xunlei.downloadprovider.ad.a;
import com.xunlei.downloadprovider.ad.cache.a.d;
import com.xunlei.downloadprovider.ad.cache.a.e;
import com.xunlei.downloadprovider.ad.cache.task.ADCacheNetworkReceiver;
import com.xunlei.downloadprovider.ad.cache.task.c;
import com.xunlei.downloadprovider.ad.cache.task.f;
import com.xunlei.downloadprovider.ad.common.adget.ADConst;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import com.xunlei.downloadprovider.ad.common.adget.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.android.agoo.message.MessageService;

/* compiled from: ThunderADCacheManager */
public final class b {
    public static final long a = a(a(a.a(), "gdt_ad_expired_time"));
    public static final long b = a(a(a.a(), "baidu_ad_expired_time"));
    private static b d;
    public ADCacheNetworkReceiver c;
    private Integer[] e;
    private Map<Integer, com.xunlei.downloadprovider.ad.cache.a.b> f;
    private Map<Integer, List<com.xunlei.downloadprovider.ad.cache.task.b>> g;

    private static long a(int i) {
        if (i > 0) {
            if (i <= 1440) {
                return ((long) i) * 60000;
            }
        }
        return 1200000;
    }

    public static boolean b() {
        return true;
    }

    public static b a() {
        if (d == null) {
            d = new b();
        }
        return d;
    }

    private b() {
        this.e = null;
        this.f = null;
        this.g = null;
        this.c = null;
        this.e = new Integer[]{Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(2)};
        this.g = new HashMap();
        this.f = new HashMap();
        d();
        e();
    }

    @Nullable
    public final l a(String str, int i, STYLES_INFO styles_info) {
        str = a(str, i, styles_info, 1);
        return str.isEmpty() != 0 ? null : (l) str.get(0);
    }

    public final void a(STYLES_INFO... styles_infoArr) {
        for (STYLES_INFO a : styles_infoArr) {
            a(a);
        }
    }

    public final void b(STYLES_INFO... styles_infoArr) {
        for (STYLES_INFO styles_info : styles_infoArr) {
            if (ADConst.a(styles_info.mLoadStrate)) {
                new StringBuilder("stopGDTCache stylesInfo: ").append(styles_info.name());
                b(styles_info, 1);
            }
            if (ADConst.c(styles_info.mLoadStrate)) {
                new StringBuilder("stopGDTVodCache stylesInfo: ").append(styles_info.name());
                b(styles_info, 2);
            }
            if (ADConst.b(styles_info.mLoadStrate)) {
                new StringBuilder("stopBaiDuCache stylesInfo: ").append(styles_info.name());
                b(styles_info, 3);
            }
        }
    }

    private void d() {
        for (Integer intValue : this.e) {
            int intValue2 = intValue.intValue();
            Object obj = null;
            switch (intValue2) {
                case 1:
                    obj = new d();
                    break;
                case 2:
                    obj = new e();
                    break;
                case 3:
                    obj = new com.xunlei.downloadprovider.ad.cache.a.a();
                    break;
                default:
                    break;
            }
            if (obj != null) {
                this.f.put(Integer.valueOf(intValue2), obj);
            }
        }
    }

    private void e() {
        for (Integer intValue : this.e) {
            int intValue2 = intValue.intValue();
            com.xunlei.downloadprovider.ad.cache.a.b bVar = (com.xunlei.downloadprovider.ad.cache.a.b) this.f.get(Integer.valueOf(intValue2));
            if (bVar != null) {
                com.xunlei.downloadprovider.ad.cache.task.d dVar = new com.xunlei.downloadprovider.ad.cache.task.d(bVar);
                f fVar = new f(bVar);
                c cVar = new c(bVar);
                List arrayList = new ArrayList();
                arrayList.add(dVar);
                arrayList.add(fVar);
                arrayList.add(cVar);
                this.g.put(Integer.valueOf(intValue2), arrayList);
            }
        }
    }

    public final void c() {
        for (Integer intValue : this.e) {
            List<com.xunlei.downloadprovider.ad.cache.task.b> list = (List) this.g.get(Integer.valueOf(intValue.intValue()));
            if (list != null) {
                for (com.xunlei.downloadprovider.ad.cache.task.b c : list) {
                    c.c();
                }
            }
        }
    }

    private void a(STYLES_INFO styles_info, int i) {
        List<com.xunlei.downloadprovider.ad.cache.task.b> list = (List) this.g.get(Integer.valueOf(i));
        if (list != null) {
            for (com.xunlei.downloadprovider.ad.cache.task.b b : list) {
                b.b(styles_info);
            }
        }
    }

    private void b(STYLES_INFO styles_info, int i) {
        List<com.xunlei.downloadprovider.ad.cache.task.b> list = (List) this.g.get(Integer.valueOf(i));
        if (list != null) {
            for (com.xunlei.downloadprovider.ad.cache.task.b c : list) {
                c.c(styles_info);
            }
        }
    }

    private void c(STYLES_INFO styles_info, int i) {
        com.xunlei.downloadprovider.ad.cache.a.b bVar = (com.xunlei.downloadprovider.ad.cache.a.b) this.f.get(Integer.valueOf(i));
        if (bVar != null) {
            bVar.a(styles_info, styles_info.mCacheSize);
        }
    }

    @NonNull
    public final List<l> a(String str, int i, STYLES_INFO styles_info, int i2) {
        com.xunlei.downloadprovider.ad.cache.a.b bVar = (com.xunlei.downloadprovider.ad.cache.a.b) this.f.get(Integer.valueOf(i));
        if (bVar == null) {
            return new ArrayList(null);
        }
        int a = bVar.a();
        if (a.a()) {
            com.xunlei.downloadprovider.ad.common.report.a.a("adv_get_alliance_by_cache", a.a(str, styles_info, a), true);
        }
        List<l> b = bVar.b(styles_info, i2);
        i = bVar.a();
        if (b.isEmpty()) {
            a.a(str, styles_info, i, "101");
            return b;
        } else if (b.size() >= i2) {
            return b;
        } else {
            a.a(str, styles_info, i, MessageService.MSG_DB_COMPLETE);
            return b;
        }
    }

    public final void a(STYLES_INFO styles_info) {
        if (ADConst.a(styles_info.mLoadStrate)) {
            new StringBuilder("startGDTCache stylesInfo: ").append(styles_info.name());
            a(styles_info, 1);
            c(styles_info, 1);
        }
        if (ADConst.c(styles_info.mLoadStrate)) {
            new StringBuilder("startGDTVodCache stylesInfo: ").append(styles_info.name());
            a(styles_info, 2);
            c(styles_info, 2);
        }
        if (ADConst.b(styles_info.mLoadStrate)) {
            new StringBuilder("startBaiDuCache stylesInfo: ").append(styles_info.name());
            a(styles_info, 3);
            c(styles_info, 3);
        }
    }

    private static int a(Context context, String str) {
        return context.getSharedPreferences("init", 0).getInt(str, 0);
    }
}
