package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import android.text.TextUtils;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.j;
import com.xunlei.downloadprovider.ad.common.d;
import com.xunlei.downloadprovider.ad.d.f;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RecommendInfo */
public final class e {
    public String a;
    public Object b;

    public static e a(JSONObject jSONObject) throws JSONException {
        CharSequence optString = jSONObject.optString("type");
        Object obj = null;
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        e eVar = new e();
        eVar.a = optString;
        if (TextUtils.equals(optString, "ads")) {
            if (f.b("effect")) {
                if (jSONObject != null) {
                    jSONObject = jSONObject.optJSONObject("ssp_ads_info");
                    THUNDER_AD_INFO thunder_ad_info = THUNDER_AD_INFO.SHORT_MOVIE_DETAIL_EFFECT;
                    obj = d.a(j.a(thunder_ad_info, jSONObject), thunder_ad_info);
                }
            }
            eVar.b = obj;
        } else if (TextUtils.equals(optString, "video")) {
            eVar.b = b.a(jSONObject);
        } else if (TextUtils.equals(optString, "site")) {
            eVar.b = f.a(jSONObject);
        } else {
            eVar.b = null;
        }
        return eVar;
    }
}
