package com.xunlei.downloadprovider.cardslide.likelist.c;

import android.text.TextUtils;
import com.android.volley.l;
import com.xunlei.common.net.volley.VolleyRequestManager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: CardLikeNetHelper */
public class c {
    private static c b;
    private l a = VolleyRequestManager.getMainThreadRequestQueue();

    /* compiled from: CardLikeNetHelper */
    public interface a {
        void a();

        void a(List<a> list);
    }

    private c() {
    }

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    static /* synthetic */ String a(String str) {
        return TextUtils.isEmpty(str) == null ? "http://www.cardlikelistnext.com" : "http://www.cardlikelist.com";
    }

    static /* synthetic */ List a(JSONObject jSONObject) {
        List arrayList = new ArrayList();
        if (jSONObject != null) {
            jSONObject = jSONObject.optJSONArray("card_list");
            for (int i = 0; i < jSONObject.length(); i++) {
                arrayList.add(b.a(jSONObject.optJSONObject(i)));
            }
        }
        return arrayList;
    }
}
