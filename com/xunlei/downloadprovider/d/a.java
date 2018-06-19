package com.xunlei.downloadprovider.d;

import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: BaseConfig */
public class a {
    private static final String a = "a";
    private HashMap<String, Object> b;
    protected JSONObject k;

    public void a(JSONObject jSONObject) {
        this.k = jSONObject;
    }

    public String toString() {
        return this.k == null ? null : this.k.toString();
    }

    protected final boolean a(String str, boolean z) {
        return this.k == null ? z : this.k.optBoolean(str, z);
    }

    protected final int a(String str, int i) {
        return this.k == null ? i : this.k.optInt(str, i);
    }

    protected final double a(String str) {
        return this.k == null ? 1.0d : this.k.optDouble(str, 1.0d);
    }

    protected final String a(String str, String str2) {
        return this.k == null ? str2 : this.k.optString(str, str2);
    }

    protected final JSONArray b(String str) {
        return this.k == null ? null : this.k.optJSONArray(str);
    }

    protected final boolean c(String str) {
        Object d = d(str);
        if (d != null) {
            return ((Boolean) d).booleanValue();
        }
        boolean a = a(str, false);
        a(str, Boolean.valueOf(a));
        return a;
    }

    protected final int b(String str, int i) {
        Object d = d(str);
        if (d != null) {
            return ((Integer) d).intValue();
        }
        i = a(str, i);
        a(str, Integer.valueOf(i));
        return i;
    }

    private Object d(String str) {
        if (this.b == null) {
            this.b = new HashMap();
        }
        return this.b.get(str);
    }

    private void a(String str, Object obj) {
        if (this.b == null) {
            this.b = new HashMap();
        }
        this.b.put(str, obj);
    }
}
