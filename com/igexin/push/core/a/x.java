package com.igexin.push.core.a;

import com.igexin.b.a.c.a;
import com.igexin.push.config.l;
import org.json.JSONObject;

public class x extends b {
    private static final String a;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(l.a);
        stringBuilder.append("_SetTagResultAction");
        a = stringBuilder.toString();
    }

    public boolean a(Object obj, JSONObject jSONObject) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append("|set tag result resp data = ");
        stringBuilder.append(jSONObject);
        a.b(stringBuilder.toString());
        if (jSONObject != null) {
            try {
                if (jSONObject.has("action") && jSONObject.getString("action").equals("settag_result")) {
                    f.a().c(jSONObject.getString("sn"), jSONObject.getString("error_code"));
                }
            } catch (Exception e) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(a);
                stringBuilder2.append("|");
                stringBuilder2.append(e.toString());
                a.b(stringBuilder2.toString());
            }
        }
        return true;
    }
}
