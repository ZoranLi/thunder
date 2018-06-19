package com.xunlei.common.new_ptl.member.c;

import android.text.TextUtils;
import com.xunlei.common.base.XLLog;
import org.json.JSONObject;

/* compiled from: XLQQSSOResult */
public final class i {
    public String a = "";
    public String b = "";
    public String c = "";
    private String d = h.class.getSimpleName();

    public i(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.b = jSONObject.getString("access_token");
                this.c = jSONObject.getString("expires_in");
                this.a = jSONObject.getString("openid");
            } catch (JSONObject jSONObject2) {
                jSONObject2.printStackTrace();
                XLLog.v(this.d, "extract json object error");
            }
        }
    }

    public final boolean a() {
        if (!(TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.a))) {
            if (!TextUtils.isEmpty(this.c)) {
                return true;
            }
        }
        return false;
    }
}
