package com.tencent.wxop.stat.event;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

public class c {
    public String a;
    public JSONArray b;
    public JSONObject c = null;

    public c(String str, String[] strArr, Properties properties) {
        JSONObject jSONObject;
        this.a = str;
        if (properties != null) {
            jSONObject = new JSONObject(properties);
        } else if (strArr != null) {
            this.b = new JSONArray();
            for (Object put : strArr) {
                this.b.put(put);
            }
            return;
        } else {
            jSONObject = new JSONObject();
        }
        this.c = jSONObject;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return toString().equals(((c) obj).toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append(this.a);
        stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (this.b != null) {
            stringBuilder.append(this.b.toString());
        }
        if (this.c != null) {
            stringBuilder.append(this.c.toString());
        }
        return stringBuilder.toString();
    }
}
