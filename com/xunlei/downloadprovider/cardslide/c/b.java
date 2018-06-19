package com.xunlei.downloadprovider.cardslide.c;

import com.android.volley.l;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.d.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: CardSlideRequestManager */
public class b {
    public static List<a> a = new ArrayList();
    public static List<String> b = new ArrayList();
    public static boolean c = false;
    public static boolean d = true;
    private static final String e = "b";
    private static b g;
    private l f = VolleyRequestManager.getMainThreadRequestQueue();

    /* compiled from: CardSlideRequestManager */
    public interface a {
        void a();

        void a(List<a> list);
    }

    public static b a() {
        if (g == null) {
            synchronized (b.class) {
                if (g == null) {
                    g = new b();
                }
            }
        }
        return g;
    }

    public final void a(a aVar) {
        if (d) {
            d = false;
            XLThreadPool.execute(new c(this, aVar));
        }
    }

    static /* synthetic */ String b() {
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/cataract/api/v2/social_timelines?page=0&size=");
        stringBuilder.append(d.a().r.h());
        return stringBuilder.toString();
    }

    static /* synthetic */ List a(JSONObject jSONObject) {
        List arrayList = new ArrayList();
        if (jSONObject != null) {
            jSONObject = jSONObject.optJSONArray("card_list");
            for (int i = 0; i < jSONObject.length(); i++) {
                arrayList.add(a.a(jSONObject.optJSONObject(i)));
            }
        }
        return arrayList;
    }
}
