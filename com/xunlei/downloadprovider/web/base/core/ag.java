package com.xunlei.downloadprovider.web.base.core;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JsMessageInterceptor */
public abstract class ag {
    BaseJsInterface b;

    public abstract boolean a(MethodName methodName, JSONObject jSONObject, String str) throws JSONException;

    protected final void a(String str, Map<String, Object> map) {
        if (this.b != null) {
            this.b.callback(str, map);
        }
    }
}
