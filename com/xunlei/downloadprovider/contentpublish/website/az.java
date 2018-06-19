package com.xunlei.downloadprovider.contentpublish.website;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.android.volley.Request;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.contentpublish.website.a.b;
import com.xunlei.downloadprovider.contentpublish.website.a.l;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import java.util.HashMap;

/* compiled from: WebsitePublishHelper */
public class az {
    private static az c;
    public au a;
    HashMap<String, Request> b = new HashMap();
    private b d = new b();
    private HashMap<String, Request> e = new HashMap();
    private Handler f = new Handler(Looper.getMainLooper());

    private az() {
    }

    public static az a() {
        if (c == null) {
            synchronized (az.class) {
                if (c == null) {
                    c = new az();
                }
            }
        }
        return c;
    }

    public final void a(String str, c<l> cVar) {
        if (TextUtils.isEmpty(str)) {
            cVar.onFail(null);
            return;
        }
        if (this.e.containsKey(str)) {
            a(str);
        }
        XLThreadPool.execute(new ba(this, str, cVar));
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            Request request = (Request) this.e.get(str);
            if (request != null) {
                request.cancel();
                this.e.remove(str);
            }
        }
    }

    public static boolean b(String str) {
        return BrothersApplication.getApplicationInstance().getSharedPreferences("website_save_url_from_clipboard", 0).getString("website_last_copy_text", "").equals(str);
    }

    public static void c(String str) {
        BrothersApplication.getApplicationInstance().getSharedPreferences("website_save_url_from_clipboard", 0).edit().putString("website_last_copy_text", str).apply();
    }

    public final void a(au auVar, c<String> cVar) {
        Object obj;
        if (!(auVar == null || TextUtils.isEmpty(auVar.a))) {
            if (!TextUtils.isEmpty(auVar.c)) {
                obj = 1;
                if (obj == null) {
                    XLThreadPool.execute(new bc(this, auVar, cVar));
                }
            }
        }
        obj = null;
        if (obj == null) {
            XLThreadPool.execute(new bc(this, auVar, cVar));
        }
    }
}
