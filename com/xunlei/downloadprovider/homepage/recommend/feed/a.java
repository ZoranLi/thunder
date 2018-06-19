package com.xunlei.downloadprovider.homepage.recommend.feed;

import android.content.Context;
import android.content.SharedPreferences;
import com.android.volley.l;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.k;
import com.xunlei.downloadprovider.ad.common.adget.m;
import com.xunlei.downloadprovider.app.BrothersApplication;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FeedDataManager */
public final class a {
    private static a f;
    l a;
    public SharedPreferences b;
    a c;
    public List<y> d = new ArrayList();
    boolean e = true;
    private Context g;

    /* compiled from: FeedDataManager */
    public interface a {
        void a(boolean z, String str);
    }

    private a() {
        Context applicationInstance = BrothersApplication.getApplicationInstance();
        this.g = applicationInstance;
        this.a = VolleyRequestManager.getMainThreadRequestQueue();
        this.b = applicationInstance.getSharedPreferences("feed_movie", 0);
    }

    public static a a() {
        if (f == null) {
            f = new a();
        }
        return f;
    }

    static /* synthetic */ String a(boolean z, boolean z2) {
        z = z ? "firstLoad" : z2 ? "refresh" : "loadMore";
        z2 = new StringBuilder("http://api-shoulei-ssl.xunlei.com/ivideo_v5/feed_list");
        z2.append("?size=6&type=");
        z2.append(z);
        z2.append(m.a(k.a(THUNDER_AD_INFO.FEED_AD), 2));
        return z2.toString();
    }
}
