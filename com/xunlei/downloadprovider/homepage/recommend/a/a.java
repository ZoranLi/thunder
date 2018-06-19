package com.xunlei.downloadprovider.homepage.recommend.a;

import android.content.Context;
import com.android.volley.n.b;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.app.BrothersApplication;
import org.json.JSONObject;

/* compiled from: CounterDataHelper */
public class a {
    private static a c;
    public final Context a;
    public final b b = new b();

    private a(Context context) {
        this.a = context.getApplicationContext();
    }

    public static a a() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a(BrothersApplication.getApplicationInstance());
                }
            }
        }
        return c;
    }

    public final void a(String str, int i, String str2, b<JSONObject> bVar, com.android.volley.n.a aVar) {
        if (com.xunlei.xllib.android.b.a(this.a)) {
            XLThreadPool.execute(new c(this.b, str, i, str2, bVar, aVar));
        }
    }

    public final void a(String str, int i, String str2, String str3) {
        if (com.xunlei.xllib.android.b.a(this.a)) {
            XLThreadPool.execute(new f(this.b, str, i, str2, str3));
        }
    }

    public final void a(String str, int i, String str2, String str3, int i2, String str4, b<JSONObject> bVar, com.android.volley.n.a aVar) {
        if (com.xunlei.xllib.android.b.a(this.a)) {
            XLThreadPool.execute(new l(r0.b, str, i, str2, str3, i2, str4, bVar, aVar));
        }
    }
}
