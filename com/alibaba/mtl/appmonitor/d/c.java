package com.alibaba.mtl.appmonitor.d;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: AccurateSampling */
public final class c extends a<JSONObject> {
    private Map<String, b> b = new HashMap();

    public c(int i) {
        super(i);
    }

    public final void b(JSONObject jSONObject) {
        a(jSONObject);
    }

    public final Boolean a(int i, Map<String, String> map) {
        if (map != null) {
            if (this.b != null) {
                for (String str : this.b.keySet()) {
                    boolean contains;
                    b bVar = (b) this.b.get(str);
                    String str2 = (String) map.get(str2);
                    if (!TextUtils.isEmpty(str2)) {
                        contains = bVar.a.contains(str2);
                        if (bVar.b == a.IN) {
                            continue;
                        } else if (!contains) {
                            contains = true;
                            continue;
                        }
                        if (!contains) {
                            return null;
                        }
                    }
                    contains = false;
                    continue;
                    if (contains) {
                        return null;
                    }
                }
                return Boolean.valueOf(a(i));
            }
        }
        return null;
    }
}
