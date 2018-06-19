package com.xunlei.downloadprovider.homepage.choiceness.a;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.android.volley.VolleyError;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.m;
import com.xunlei.downloadprovider.ad.home.a.f;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter$RefreshType;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.k;
import com.xunlei.downloadprovider.member.payment.a.e;
import com.xunlei.downloadprovider.search.b.b;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: ChoicenessNetworkHelper */
public final class j extends e {
    int a = 1;
    String b;

    private static void b(VolleyError volleyError, @NonNull b<k> bVar) {
        k kVar = new k();
        kVar.g = true;
        kVar.f = volleyError;
        bVar.a(kVar);
    }

    static /* synthetic */ String a(j jVar, ChoicenessReporter$RefreshType choicenessReporter$RefreshType, String str, long j) {
        choicenessReporter$RefreshType = ChoicenessReporter.a(choicenessReporter$RefreshType);
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.append("&length=8");
        stringBuilder.append("&ts=");
        stringBuilder.append(j);
        stringBuilder.append("&page=");
        stringBuilder.append(jVar.a);
        stringBuilder.append("&mobile_type=android");
        if (choicenessReporter$RefreshType != null) {
            stringBuilder.append("&is_autorefresh=1");
        } else {
            stringBuilder.append("&is_autorefresh=0");
        }
        stringBuilder.append("&cursor=");
        stringBuilder.append(TextUtils.isEmpty(jVar.b) != null ? "" : Uri.encode(jVar.b));
        stringBuilder.append("&ads_cursor=");
        stringBuilder.append(String.valueOf(f.a(BrothersApplication.getApplicationInstance()).e));
        jVar = f.a(BrothersApplication.getApplicationInstance());
        str = new ArrayList(2);
        str.add(THUNDER_AD_INFO.HOME_POS1);
        str.add(THUNDER_AD_INFO.HOME_POS_EXTRA);
        j = new StringBuilder("getNextAdPositions isAutoPull: ");
        j.append(choicenessReporter$RefreshType);
        j.append(" result: ");
        j.append(Arrays.toString(str.toArray()));
        jVar.f.clear();
        jVar.f.addAll(str);
        stringBuilder.append(m.a(jVar.f, 1));
        return stringBuilder.toString();
    }

    static /* synthetic */ void a(com.xunlei.downloadprovider.homepage.choiceness.a.j r1, org.json.JSONObject r2, com.xunlei.downloadprovider.search.b.b r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r2 = com.xunlei.downloadprovider.homepage.choiceness.a.a.k.a(r0, r2);	 Catch:{ JSONException -> 0x000d }
        r0 = r2.e;	 Catch:{ JSONException -> 0x000d }
        r1.b = r0;	 Catch:{ JSONException -> 0x000d }
        r3.a(r2);	 Catch:{ JSONException -> 0x000d }
        return;
    L_0x000d:
        r1 = 0;
        b(r1, r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.choiceness.a.j.a(com.xunlei.downloadprovider.homepage.choiceness.a.j, org.json.JSONObject, com.xunlei.downloadprovider.search.b.b):void");
    }
}
