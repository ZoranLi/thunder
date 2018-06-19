package com.xunlei.downloadprovider.ad.home.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.mobad.feeds.NativeResponse;
import com.baidu.mobad.feeds.NativeResponse.MaterialType;
import com.qq.e.ads.nativ.NativeMediaADData;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import com.xunlei.downloadprovider.ad.common.adget.k;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.adget.t;
import com.xunlei.downloadprovider.ad.common.n;
import com.xunlei.downloadprovider.ad.home.ui.ADItemView;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.e;
import com.xunlei.downloadprovider.homepage.choiceness.ui.i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: LoadADClient */
public class f {
    public static final String a = "f";
    public static final THUNDER_AD_INFO b = THUNDER_AD_INFO.HOME_RELOAD;
    private static f g;
    public a c;
    public i d;
    public int e = 1;
    public LinkedList<THUNDER_AD_INFO> f = null;
    private Context h;
    private a i = null;
    private b j = new i(this);

    /* compiled from: LoadADClient */
    public class a {
        public Map<String, l> a = new HashMap();
        Map<String, String> b = new HashMap();
        public Set<String> c = new HashSet();
        public l d;
        public l e;
        final /* synthetic */ f f;

        a(f fVar) {
            this.f = fVar;
        }

        public final l a(String str) {
            return this.a != null ? (l) this.a.get(str) : null;
        }

        public final void a(String str, l lVar) {
            if (this.a != null) {
                this.a.put(str, lVar);
            }
        }

        public final boolean a(@NonNull l lVar) {
            if (this.a == null) {
                return false;
            }
            for (Entry value : this.a.entrySet()) {
                if (lVar.a((l) value.getValue())) {
                    return true;
                }
            }
            return false;
        }

        public final String b(String str) {
            return this.b != null ? (String) this.b.get(str) : "";
        }
    }

    /* compiled from: LoadADClient */
    private interface b {
        l a(String str);
    }

    private f(Context context) {
        this.h = context;
        this.c = new a(this);
        this.i = new a();
        this.f = new LinkedList();
    }

    public final void a() {
        if (d.a().p.c()) {
            new t().a(THUNDER_AD_INFO.HOME_POS0, new g(this));
        }
    }

    public static synchronized f a(Context context) {
        synchronized (f.class) {
            if (g == null) {
                g = new f(context);
            }
            context = g;
        }
        return context;
    }

    protected static boolean a(e eVar) {
        return (eVar.b() == null || eVar.b().startsWith("first_ad_") == null) ? null : true;
    }

    public final int b() {
        if (this.e - 1 <= 0) {
            new StringBuilder("wtf, currentPage is ").append(this.e - 1);
        }
        return this.e - 1;
    }

    public static void a(l lVar) {
        if (lVar.y() == null) {
            lVar.v = STYLES_INFO.HOME_IMG;
        } else if (!lVar.y().equals("baidu")) {
            if (lVar.y().equals(SocializeProtocolConstants.PROTOCOL_KEY_TENCENT)) {
                if (((NativeMediaADData) lVar.G()).isVideoAD()) {
                    lVar.v = STYLES_INFO.HOME_VOD;
                    return;
                }
                lVar.v = STYLES_INFO.HOME_IMG;
            }
        } else if ((lVar.G() instanceof NativeResponse) && ((NativeResponse) lVar.G()).getMaterialType() == MaterialType.VIDEO) {
            lVar.v = STYLES_INFO.HOME_VOD;
        } else {
            lVar.v = STYLES_INFO.HOME_IMG;
        }
    }

    public static void a(l lVar, e eVar) {
        if (lVar.y() == null) {
            eVar.k = 6;
        } else if (!lVar.y().equals(SocializeProtocolConstants.PROTOCOL_KEY_TENCENT)) {
            if (lVar.v != STYLES_INFO.HOME_VOD) {
                if (lVar.v != STYLES_INFO.HOME_VOD_0) {
                    eVar.k = 6;
                    return;
                }
            }
            eVar.k = 16;
        } else if (lVar.v == STYLES_INFO.HOME_VOD) {
            eVar.k = null;
        } else {
            eVar.k = 6;
        }
    }

    public final l a(@NonNull THUNDER_AD_INFO thunder_ad_info, @Nullable com.xunlei.downloadprovider.ad.common.adget.j.a aVar) {
        l lVar = null;
        if (aVar != null && aVar.a == (byte) 0 && aVar.b != null) {
            lVar = aVar.b;
            lVar.H = aVar.f;
            lVar.v = aVar.h;
        } else if (aVar == null) {
            lVar = b(thunder_ad_info, null);
        } else if (aVar.b != null && !aVar.b.i()) {
            lVar = aVar.b;
        } else if ((aVar.a & 1) != 0) {
            l c = c(thunder_ad_info.getPositionId());
            new StringBuilder("getBaiDuFillAd baiduCacheAd: ").append(c == null ? "null" : c.toString());
            if (c == null) {
                if (aVar != null) {
                    aVar.c = null;
                    aVar.d = null;
                    aVar.e = SocializeProtocolConstants.PROTOCOL_KEY_TENCENT;
                }
                thunder_ad_info = b(thunder_ad_info.getPositionId());
                new StringBuilder("getBaiDuFillAd gdtCacheAd: ").append(thunder_ad_info == null ? "null" : thunder_ad_info.toString());
                lVar = thunder_ad_info;
            } else {
                lVar = c;
            }
        } else if ((aVar.a & 6) != 0) {
            lVar = b(thunder_ad_info, aVar);
        }
        if (lVar != null) {
            if (!(aVar == null || aVar.a == null)) {
                lVar.H = aVar.f;
                lVar.x = k.a(aVar.c);
                lVar.w = k.a(aVar.d);
                lVar.z = aVar.e;
            }
            if (lVar.F() == null || com.xunlei.xllib.android.b.e(BrothersApplication.getApplicationInstance()) != null) {
                return lVar;
            }
            ((NativeMediaADData) lVar.G()).preLoadVideo();
            return lVar;
        } else if (aVar == null || aVar.b == null) {
            return lVar;
        } else {
            lVar = aVar.b;
            lVar.H = aVar.f;
            return lVar;
        }
    }

    public static void a(n<JSONObject> nVar) {
        new com.xunlei.downloadprovider.ad.common.adget.e(b).a(nVar);
    }

    public final void a(e eVar, ADItemView aDItemView, i iVar) {
        l lVar;
        this.d = iVar;
        iVar = new StringBuilder("refreshNavAD key: ");
        iVar.append(aDItemView.getViewPositionKey());
        iVar.append(" layout_type: ");
        iVar.append(aDItemView.getADType().name());
        if (a(eVar) != null) {
            lVar = this.c.e;
        } else {
            lVar = this.c.a(eVar.b());
        }
        if (lVar != null) {
            StringBuilder stringBuilder = new StringBuilder("use cache key: ");
            stringBuilder.append(aDItemView.getViewPositionKey());
            stringBuilder.append(" layout: ");
            stringBuilder.append(aDItemView.getADType().name());
            b.c().a(eVar);
            a aVar = this.c;
            String b = eVar.b();
            eVar = ChoicenessReporter.a((com.xunlei.downloadprovider.homepage.choiceness.a.a.a) eVar);
            if (aVar.b != null) {
                aVar.b.put(b, eVar);
            }
            aDItemView.a(lVar);
        }
    }

    private l b(String str) {
        b bVar = this.j;
        l a = bVar.a(str);
        new StringBuilder("getUniqueCacheAd adInfo: ").append(a);
        if (a == null || !this.c.a(a)) {
            return a;
        }
        str = bVar.a(str);
        new StringBuilder("getUniqueCacheAd adInfo2: ").append(str);
        return str != null ? str : a;
    }

    private static l c(String str) {
        return com.xunlei.downloadprovider.ad.cache.b.a().a(str, 3, STYLES_INFO.HOME_IMG);
    }

    private l b(@NonNull THUNDER_AD_INFO thunder_ad_info, @Nullable com.xunlei.downloadprovider.ad.common.adget.j.a aVar) {
        l b = b(thunder_ad_info.getPositionId());
        new StringBuilder("getGDTFillAd gdtCacheAd: ").append(b == null ? "null" : b.toString());
        if (b == null) {
            if (aVar != null) {
                aVar.c = null;
                aVar.d = null;
                aVar.e = "baidu";
            }
            b = c(thunder_ad_info.getPositionId());
            new StringBuilder("getGDTFillAd baiduCacheAd: ").append(b == null ? "null" : b.toString());
        }
        return b;
    }

    public final void a(boolean z) {
        if (z) {
            this.e = true;
        }
    }

    public static void a(boolean z, com.xunlei.downloadprovider.homepage.choiceness.a.a.b bVar, l lVar, THUNDER_AD_INFO thunder_ad_info) {
        lVar.B = z;
        a(lVar);
        a(lVar, (e) bVar);
        lVar.a(thunder_ad_info.mPositionId);
    }
}
