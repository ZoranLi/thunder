package com.xunlei.downloadprovider.ad.cache.a;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.ad.cache.b.i;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import com.xunlei.downloadprovider.ad.common.adget.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: BaseCacheModel */
public abstract class b {
    protected String a;
    protected final Map<STYLES_INFO, List<l>> b = new HashMap();
    protected final i c = new i();
    public final List<a> d = new ArrayList();
    private Handler e = new Handler(Looper.getMainLooper(), new c(this));

    /* compiled from: BaseCacheModel */
    public interface a {
        void a(STYLES_INFO styles_info);

        void a(STYLES_INFO styles_info, int i);

        void b(STYLES_INFO styles_info, int i);
    }

    public abstract int a();

    public abstract long b();

    public b() {
        StringBuilder stringBuilder = new StringBuilder("Ad.Cache.BaseCacheModel.");
        stringBuilder.append(a());
        this.a = stringBuilder.toString();
    }

    public final int a(@NonNull STYLES_INFO styles_info) {
        int size;
        int size2;
        new StringBuilder("trimCache start, stylesInfo: ").append(styles_info.name());
        synchronized (this.b) {
            List b = b(styles_info);
            size = b.size();
            Iterator it = b.iterator();
            while (it.hasNext()) {
                l lVar = (l) it.next();
                if (lVar.I()) {
                    new StringBuilder("remove expired cacheInfo: ").append(lVar.toString());
                    it.remove();
                }
            }
            size2 = b.size();
        }
        if (size == 0) {
            c(styles_info);
        }
        size -= size2;
        if (size > 0) {
            c(styles_info, size2);
        }
        StringBuilder stringBuilder = new StringBuilder("trimCache end, stylesInfo: ");
        stringBuilder.append(styles_info.name());
        stringBuilder.append(" trimCount: ");
        stringBuilder.append(size);
        return size;
    }

    @NonNull
    private List<l> b(@NonNull STYLES_INFO styles_info) {
        List<l> list = (List) this.b.get(styles_info);
        if (list != null) {
            return list;
        }
        List arrayList = new ArrayList();
        this.b.put(styles_info, arrayList);
        return arrayList;
    }

    @NonNull
    public final List<l> b(@NonNull STYLES_INFO styles_info, int i) {
        int size;
        List<l> arrayList;
        int size2;
        StringBuilder stringBuilder;
        a("popCacheInfos start", styles_info);
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this.b) {
            List b = b(styles_info);
            size = b.size();
            arrayList = new ArrayList(i);
            Iterator it = b.iterator();
            int i2 = 0;
            while (it.hasNext() && i2 < i) {
                l lVar = (l) it.next();
                if (!lVar.I()) {
                    new StringBuilder("pop cacheInfo: ").append(lVar.toString());
                    arrayList.add(lVar);
                    i2++;
                }
                it.remove();
            }
            size2 = b.size();
        }
        if (size == 0) {
            c(styles_info);
        }
        size -= size2;
        if (size > 0) {
            c(styles_info, size2);
        } else if (size < 0) {
            stringBuilder = new StringBuilder("popCache popCount can not be negative, popCount = ");
            stringBuilder.append(size);
            a(stringBuilder.toString(), styles_info);
        }
        stringBuilder = new StringBuilder("popCacheInfos end,  popCount: ");
        stringBuilder.append(size);
        stringBuilder.append(" duration: ");
        stringBuilder.append(SystemClock.uptimeMillis() - uptimeMillis);
        a(stringBuilder.toString(), styles_info);
        if (arrayList.size() < i) {
            String.format(Locale.CHINA, "request %d cache, but only pop %d, stylesInfo is %s", new Object[]{Integer.valueOf(i), Integer.valueOf(arrayList.size()), styles_info.name()});
        } else {
            String.format(Locale.CHINA, "request %d cache,already pop %d, stylesInfo is %s", new Object[]{Integer.valueOf(i), Integer.valueOf(arrayList.size()), styles_info.name()});
        }
        return arrayList;
    }

    private static String a(String str, STYLES_INFO styles_info) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        if (styles_info != null) {
            str = new StringBuilder(" stylesInfo: ");
            str.append(styles_info.name());
            str = str.toString();
        } else {
            str = "";
        }
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    private void c(STYLES_INFO styles_info, int i) {
        StringBuilder stringBuilder = new StringBuilder("onCacheDecreaseCallback. stylesInfo: ");
        stringBuilder.append(styles_info.name());
        stringBuilder.append(" remainderSize: ");
        stringBuilder.append(i);
        for (a b : this.d) {
            b.b(styles_info, i);
        }
    }

    private void c(STYLES_INFO styles_info) {
        StringBuilder stringBuilder = new StringBuilder("onCacheEmptyWhileDecreaseCallback. stylesInfo: ");
        stringBuilder.append(styles_info.name());
        stringBuilder.append(" remainderSize: 0");
        for (a a : this.d) {
            a.a(styles_info);
        }
    }

    public final void a(@NonNull STYLES_INFO styles_info, int i) {
        String positionId = THUNDER_AD_INFO.getPositionId(styles_info);
        StringBuilder stringBuilder = new StringBuilder("requestCache size: ");
        stringBuilder.append(i);
        a(stringBuilder.toString(), styles_info);
        this.c.a(positionId, styles_info, a(), i, 1, this.e);
    }

    static /* synthetic */ void a(b bVar, Map map) {
        for (Entry entry : map.entrySet()) {
            int size;
            int size2;
            STYLES_INFO styles_info = (STYLES_INFO) entry.getKey();
            String.format(Locale.CHINA, "addCache start, stylesInfo: %s, cacheInfos.size: %d", new Object[]{styles_info, Integer.valueOf(((List) entry.getValue()).size())});
            synchronized (bVar.b) {
                List b = bVar.b(styles_info);
                size = b.size();
                b.addAll(r0);
                size2 = b.size();
            }
            int i = size2 - size;
            if (i > 0) {
                StringBuilder stringBuilder = new StringBuilder("onCacheIncreaseCallback. stylesInfo: ");
                stringBuilder.append(styles_info.name());
                stringBuilder.append(" remainderSize: ");
                stringBuilder.append(size2);
                for (a a : bVar.d) {
                    a.a(styles_info, size2);
                }
            } else if (i < 0) {
                StringBuilder stringBuilder2 = new StringBuilder("addCache addCount can not be negative, stylesInfo: ");
                stringBuilder2.append(styles_info.name());
                stringBuilder2.append(" addCount = ");
                stringBuilder2.append(i);
            }
            String.format(Locale.CHINA, "addCache end, stylesInfo: %s,", new Object[]{styles_info});
        }
    }
}
