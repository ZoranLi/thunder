package com.xunlei.downloadprovider.personal.score;

import com.android.volley.l;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.member.login.LoginHelper;

/* compiled from: UserScoreManager */
public class h {
    private static h a;
    private final l b = VolleyRequestManager.getMainThreadRequestQueue();

    /* compiled from: UserScoreManager */
    public interface a {
        void a();

        void a(o oVar);
    }

    /* compiled from: UserScoreManager */
    public interface b {
        void a();

        void a(String str, String str2);
    }

    private h() {
    }

    public static h a() {
        if (a == null) {
            synchronized (h.class) {
                if (a == null) {
                    a = new h();
                }
            }
        }
        return a;
    }

    static String b() {
        return "http://api-shoulei-ssl.xunlei.com/user_score/web_api/signed_info?uid=%uid".replace("%uid", String.valueOf(LoginHelper.a().g.c()));
    }

    static String c() {
        return "http://api-shoulei-ssl.xunlei.com/user_score/web_api/sign_and_info?uid=%uid".replace("%uid", String.valueOf(LoginHelper.a().g.c()));
    }

    final void a(a aVar, String str) {
        XLThreadPool.execute(new i(this, str, aVar));
    }
}
