package com.xunlei.downloadprovider.personal.a.e;

import com.android.volley.l;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.member.login.LoginHelper;

/* compiled from: UserScoreManager */
public class b {
    private static b a;
    private final l b = VolleyRequestManager.getMainThreadRequestQueue();

    /* compiled from: UserScoreManager */
    public interface a {
        void a();

        void a(i iVar);
    }

    /* compiled from: UserScoreManager */
    public interface b {
        void a();

        void a(a aVar);
    }

    private b() {
    }

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    public final void a(b bVar) {
        XLThreadPool.execute(new f(this, bVar));
    }

    private static org.json.JSONObject c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = "uid";	 Catch:{ JSONException -> 0x0018 }
        r2 = com.xunlei.downloadprovider.member.login.LoginHelper.a();	 Catch:{ JSONException -> 0x0018 }
        r2 = r2.g;	 Catch:{ JSONException -> 0x0018 }
        r2 = r2.c();	 Catch:{ JSONException -> 0x0018 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ JSONException -> 0x0018 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0018 }
    L_0x0018:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.personal.a.e.b.c():org.json.JSONObject");
    }

    public final void a(a aVar) {
        XLThreadPool.execute(new c(this, "http://api-shoulei-ssl.xunlei.com/user_score/web_api/signed_info?uid=%uid".replace("%uid", String.valueOf(LoginHelper.a().g.c())), aVar));
    }
}
