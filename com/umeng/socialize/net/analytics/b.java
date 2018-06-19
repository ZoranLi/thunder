package com.umeng.socialize.net.analytics;

import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.net.base.SocializeReseponse;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: AnalyticsResponse */
public class b extends SocializeReseponse {
    public Map<SHARE_MEDIA, Integer> a;
    public String b;
    public SHARE_MEDIA c;

    public b(Integer num, JSONObject jSONObject) {
        super(jSONObject);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ShareMultiResponse [mInfoMap=");
        stringBuilder.append(this.a);
        stringBuilder.append(", mWeiboId=");
        stringBuilder.append(this.b);
        stringBuilder.append(", mMsg=");
        stringBuilder.append(this.mMsg);
        stringBuilder.append(", mStCode=");
        stringBuilder.append(this.mStCode);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
