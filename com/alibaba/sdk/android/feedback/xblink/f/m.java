package com.alibaba.sdk.android.feedback.xblink.f;

import com.alibaba.sdk.android.feedback.xblink.i.g;
import com.qq.e.comm.constants.Constants.KEYS;
import org.json.JSONException;
import org.json.JSONObject;

public class m {
    private static final String a = "m";
    private int b = 0;
    private JSONObject c = new JSONObject();

    public void a() {
        this.b = 1;
    }

    public void a(String str) {
        try {
            this.c.put(KEYS.RET, str);
            this.b = -1;
        } catch (JSONException e) {
            g.b(a, String.valueOf(e));
        }
    }

    public void a(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                this.c.put(str, str2);
            } catch (JSONException e) {
                g.b(a, String.valueOf(e));
            }
        }
    }

    public void a(String str, JSONObject jSONObject) {
        if (str != null && jSONObject != null) {
            try {
                this.c.put(str, jSONObject);
            } catch (JSONException e) {
                g.b(a, String.valueOf(e));
            }
        }
    }

    public String b() {
        try {
            JSONObject jSONObject;
            String str;
            Object obj;
            if (this.b == 1) {
                jSONObject = this.c;
                str = KEYS.RET;
                obj = "HY_SUCCESS";
            } else {
                if (this.b == 0) {
                    jSONObject = this.c;
                    str = KEYS.RET;
                    obj = "HY_FAILED";
                }
                return this.c.toString().replace("\\", "\\\\").replace("\"", "\\\"").replace("\r", "\\r").replace("\n", "\\n").replaceAll("\t", "\\t").replace("'", "");
            }
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            g.b(a, String.valueOf(e));
        }
        return this.c.toString().replace("\\", "\\\\").replace("\"", "\\\"").replace("\r", "\\r").replace("\n", "\\n").replaceAll("\t", "\\t").replace("'", "");
    }
}
