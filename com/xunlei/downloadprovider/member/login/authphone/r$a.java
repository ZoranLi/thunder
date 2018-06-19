package com.xunlei.downloadprovider.member.login.authphone;

import org.json.JSONObject;

/* compiled from: PhoneAuthHelper */
public class r$a {
    public String a;
    public String b;
    private String c;

    public static r$a a(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.length() != 0) {
                r$a com_xunlei_downloadprovider_member_login_authphone_r_a = new r$a();
                com_xunlei_downloadprovider_member_login_authphone_r_a.a = jSONObject.optString("result");
                com_xunlei_downloadprovider_member_login_authphone_r_a.c = jSONObject.optString("data");
                com_xunlei_downloadprovider_member_login_authphone_r_a.b = jSONObject.optString("key");
                return com_xunlei_downloadprovider_member_login_authphone_r_a;
            }
        }
        return null;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("PhoneAuthResponse{result='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append(", data='");
        stringBuilder.append(this.c);
        stringBuilder.append('\'');
        stringBuilder.append(", key='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
