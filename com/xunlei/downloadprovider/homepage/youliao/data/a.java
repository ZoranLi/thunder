package com.xunlei.downloadprovider.homepage.youliao.data;

import com.xunlei.downloadprovider.app.BrothersApplication;
import java.io.File;

/* compiled from: DataCache */
final class a {
    a() {
    }

    static File a() {
        return new File(BrothersApplication.getApplicationInstance().getCacheDir(), "cache_youliaotab.json");
    }

    @android.support.annotation.Nullable
    static org.json.JSONObject b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = a();
        r0 = com.xunlei.downloadprovider.d.a.f.a(r0);
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 != 0) goto L_0x0014;
    L_0x000e:
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0014 }
        r1.<init>(r0);	 Catch:{ JSONException -> 0x0014 }
        return r1;
    L_0x0014:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.youliao.data.a.b():org.json.JSONObject");
    }
}
