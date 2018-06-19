package com.igexin.push.core.a;

import com.igexin.b.a.c.a;
import com.igexin.push.config.l;
import org.json.JSONObject;

public class c extends b {
    private static final String a;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(l.a);
        stringBuilder.append("_BindAliasResultAction");
        a = stringBuilder.toString();
    }

    public boolean a(Object obj, JSONObject jSONObject) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append("|bind alias result resp data = ");
        stringBuilder.append(jSONObject);
        a.b(stringBuilder.toString());
        if (jSONObject != null) {
            try {
                if (jSONObject.has("action") && jSONObject.getString("action").equals("response_bind")) {
                    f.a().d(jSONObject.getString("sn"), jSONObject.getString("result"));
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
