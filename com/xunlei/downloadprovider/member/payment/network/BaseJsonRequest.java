package com.xunlei.downloadprovider.member.payment.network;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.d;
import com.android.volley.n.a;
import com.android.volley.n.b;
import com.android.volley.p;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.app.BrothersApplication;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

public class BaseJsonRequest {
    public Object a;
    Map<String, String> b = new HashMap(8);
    private Map<String, String> c = new HashMap(8);
    private String d;
    private IMethod e;

    public enum IMethod {
        GET(0),
        POST(1),
        PUT(2),
        DELETE(3),
        HEAD(4),
        OPTIONS(5),
        TRACE(6),
        PATCH(7);
        
        private int value;

        private IMethod(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public BaseJsonRequest(IMethod iMethod, @NonNull String str) {
        this.e = iMethod;
        this.d = str;
    }

    public final BaseJsonRequest a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.c.put(str, str2);
        }
        return this;
    }

    public final BaseJsonRequest a(Map<String, String> map) {
        if (!map.isEmpty()) {
            this.c.putAll(map);
        }
        return this;
    }

    public final BaseJsonRequest b(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.b.put(str, str2);
        }
        return this;
    }

    private String b() {
        Builder buildUpon = Uri.parse(this.d).buildUpon();
        if (!this.c.isEmpty()) {
            for (Entry entry : this.c.entrySet()) {
                buildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
            }
        }
        return buildUpon.build().toString();
    }

    public final void a(JSONObject jSONObject, b<JSONObject> bVar, a aVar) {
        boolean z;
        Request aVar2;
        ConnectivityManager connectivityManager = (ConnectivityManager) BrothersApplication.getApplicationInstance().getApplicationContext().getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.isAvailable()) {
                z = true;
                if (z) {
                    aVar.onErrorResponse(new VolleyError("无网络连接"));
                }
                aVar2 = new a(this, this.e.getValue(), b(), jSONObject == null ? jSONObject.toString().replace("\\/", "/") : null, bVar, aVar);
                aVar2.setShouldCache(false);
                if (this.a != null) {
                    aVar2.setTag(this.a);
                }
                aVar2.setRetryPolicy(a());
                VolleyRequestManager.getMainThreadRequestQueue().a(aVar2);
                return;
            }
        }
        z = false;
        if (z) {
            if (jSONObject == null) {
            }
            aVar2 = new a(this, this.e.getValue(), b(), jSONObject == null ? jSONObject.toString().replace("\\/", "/") : null, bVar, aVar);
            aVar2.setShouldCache(false);
            if (this.a != null) {
                aVar2.setTag(this.a);
            }
            aVar2.setRetryPolicy(a());
            VolleyRequestManager.getMainThreadRequestQueue().a(aVar2);
            return;
        }
        aVar.onErrorResponse(new VolleyError("无网络连接"));
    }

    public p a() {
        return new d(15000, 1, 1.0f);
    }
}
