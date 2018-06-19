package com.xunlei.downloadprovider.ad.feedvideo;

import android.support.annotation.NonNull;
import android.view.View;
import com.qq.e.ads.nativ.NativeMediaADData;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.j;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.d;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.homepage.recommend.feed.y;
import com.xunlei.xllib.android.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FeedADClient */
public final class a {
    private static a k;
    public Map<String, l> a = new HashMap();
    final Map<String, Boolean> b = new HashMap();
    public WeakReference<FeedGDTVideoItemView> c;
    public final List<String> d = new ArrayList();
    public final List<String> e = new ArrayList();
    public l f;
    public String g;
    public boolean h;
    public WeakReference<View> i;
    public boolean j;

    private a() {
    }

    public final void a(FeedGDTVideoItemView feedGDTVideoItemView) {
        this.c = new WeakReference(feedGDTVideoItemView);
    }

    public final void a() {
        if (this.h) {
            com.xunlei.downloadprovider.ad.home.a.a("adv_shortvideo_pv", null, true);
        } else {
            this.j = true;
        }
    }

    public static a b() {
        if (k == null) {
            k = new a();
        }
        return k;
    }

    public final void a(String str) {
        this.d.add(str);
    }

    public final void b(String str) {
        this.e.add(str);
    }

    public final boolean a(@NonNull l lVar, @NonNull String str, @NonNull View view) {
        if (!this.h) {
            this.f = lVar;
            this.g = str;
            this.i = new WeakReference(view);
        }
        return this.h;
    }

    public static boolean c(@NonNull String str) {
        return b().d.contains(str);
    }

    public static boolean d(@NonNull String str) {
        return b().e.contains(str);
    }

    public final boolean a(y yVar) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(yVar.e);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        l a = d.a(j.a(THUNDER_AD_INFO.FEED_AD, jSONObject), THUNDER_AD_INFO.FEED_AD);
        if (a == null) {
            return null;
        }
        if (!(a == null || !a.F() || b.e(BrothersApplication.getApplicationInstance()))) {
            ((NativeMediaADData) a.G()).preLoadVideo();
        }
        this.a.put(yVar.a.getVideoId(), a);
        return true;
    }
}
