package com.xunlei.downloadprovider.ad.c.b;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.ad.a;

/* compiled from: LocationModel */
public final class c implements Runnable {
    final /* synthetic */ b a;

    public c(b bVar) {
        this.a = bVar;
    }

    public final void run() {
        String a = b.a(a.a(), "ad_location_info");
        if (!TextUtils.isEmpty(a)) {
            this.a.a = (a) new Gson().fromJson(a, a.class);
            StringBuilder stringBuilder = new StringBuilder("Latitude:");
            stringBuilder.append(this.a.a.a);
            stringBuilder.append(",Longitude:");
            stringBuilder.append(this.a.a.b);
            ThunderReport.setShouleiLocation(stringBuilder.toString());
        }
    }
}
