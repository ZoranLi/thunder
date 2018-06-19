package com.xunlei.downloadprovider.ad.common.adget;

import android.text.TextUtils;
import com.android.volley.Request;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.ad.common.adget.e.c;
import java.util.List;

/* compiled from: ADGetModel */
public class b$a {
    private static b$a a;

    private b$a() {
    }

    public static b$a a() {
        if (a == null) {
            a = new b$a();
        }
        return a;
    }

    public final void a(List<String> list) {
        int i = 0;
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                if (i < 15) {
                    Request cVar = new c(str, new c(this), new d(this));
                    cVar.setShouldCache(false);
                    VolleyRequestManager.getMainThreadRequestQueue().a(cVar);
                    i++;
                } else {
                    return;
                }
            }
        }
    }
}
