package com.xunlei.downloadprovider.contentpublish.website.a;

import android.text.TextUtils;
import com.qq.e.comm.constants.Constants.KEYS;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONObject;

/* compiled from: WebsiteParseResponse */
public final class l {
    public int a = -1;
    public String b;
    public String c;
    private int d;
    private int e;

    public final boolean a() {
        return this.a == 0 && !TextUtils.isEmpty(this.b);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("WebsiteParseResponse{mRet=");
        stringBuilder.append(this.a);
        stringBuilder.append(", mWidth=");
        stringBuilder.append(this.d);
        stringBuilder.append(", mHeight=");
        stringBuilder.append(this.e);
        stringBuilder.append(", mTitle='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append(", mPoster='");
        stringBuilder.append(this.c);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static l a(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.length() != 0) {
                l lVar = new l();
                try {
                    lVar.a = jSONObject.getInt(KEYS.RET);
                    lVar.d = jSONObject.optInt(SocializeProtocolConstants.WIDTH);
                    lVar.e = jSONObject.optInt(SocializeProtocolConstants.HEIGHT);
                    lVar.b = jSONObject.optString("title");
                    lVar.c = jSONObject.optString("poster");
                    return lVar;
                } catch (JSONObject jSONObject2) {
                    jSONObject2.printStackTrace();
                    return null;
                }
            }
        }
        return null;
    }
}
