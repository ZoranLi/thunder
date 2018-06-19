package com.alibaba.mtl.log.e;

import android.text.TextUtils;
import com.qq.e.comm.constants.Constants.KEYS;
import org.json.JSONObject;

/* compiled from: ApiResponseParse */
public final class a {

    /* compiled from: ApiResponseParse */
    public static class a {
        public static a c = new a();
        public boolean a = false;
        public String b = null;
    }

    public static a a(String str) {
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("success") != null) {
                str = jSONObject.getString("success");
                if (!(TextUtils.isEmpty(str) || str.equals("success") == null)) {
                    aVar.a = true;
                }
            }
            if (jSONObject.has(KEYS.RET) != null) {
                aVar.b = jSONObject.getString(KEYS.RET);
            }
        } catch (String str2) {
            str2.printStackTrace();
        }
        return aVar;
    }
}
