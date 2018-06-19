package com.xunlei.downloadprovider.member.login.a;

import com.android.volley.l;
import com.xunlei.common.net.volley.VolleyRequestManager;
import org.json.JSONObject;

/* compiled from: AuthWechatHelper */
public class a {
    private static final String d = "a";
    private static a e;
    public boolean a = false;
    public l b = VolleyRequestManager.getMainThreadRequestQueue();
    public a c;

    /* compiled from: AuthWechatHelper */
    public interface a {
        void a();

        void a(JSONObject jSONObject);
    }

    private a() {
    }

    public static a a() {
        if (e == null) {
            synchronized (a.class) {
                e = new a();
            }
        }
        return e;
    }
}
