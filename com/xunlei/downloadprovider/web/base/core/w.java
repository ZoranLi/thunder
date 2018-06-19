package com.xunlei.downloadprovider.web.base.core;

import com.android.volley.Request;
import com.android.volley.l;
import com.xunlei.common.net.volley.VolleyRequestManager;
import java.util.HashMap;

/* compiled from: JsHttpClient */
final class w {
    static l a = VolleyRequestManager.getMainThreadRequestQueue();

    /* compiled from: JsHttpClient */
    static abstract class b {
        String a;
        String b;
        HashMap<String, String> c = new HashMap();
        String d;
        String e;
        c f;
        int g = com.tencent.bugly.BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;

        public abstract Request a();

        b() {
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("RequestBuilder{mUrl='");
            stringBuilder.append(this.a);
            stringBuilder.append('\'');
            stringBuilder.append(", mMethod='");
            stringBuilder.append(this.b);
            stringBuilder.append('\'');
            stringBuilder.append(", mHeaders=");
            stringBuilder.append(this.c);
            stringBuilder.append(", mContentEncoding='");
            stringBuilder.append(this.e);
            stringBuilder.append('\'');
            stringBuilder.append(", mTimeout=");
            stringBuilder.append(this.g);
            stringBuilder.append(", mBodyContent='");
            stringBuilder.append(this.d);
            stringBuilder.append('\'');
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    /* compiled from: JsHttpClient */
    public interface c {
        void a(int i, int i2, String str);
    }

    /* compiled from: JsHttpClient */
    static class a extends b {
        a(String str) {
            this.a = str;
        }

        public final Request a() {
            int i;
            int i2 = this.g > 0 ? this.g : 2500;
            String str = this.b;
            if ("POST".equalsIgnoreCase(str)) {
                i = 1;
            } else if (!"GET".equalsIgnoreCase(str) && "HEAD".equalsIgnoreCase(str)) {
                i = 4;
            } else {
                i = 0;
            }
            Request aaVar = new aa(this, i, this.a, new y(this), new z(this));
            aaVar.setShouldCache(false);
            aaVar.setRetryPolicy(new com.android.volley.d(i2, 1, 1.0f));
            return aaVar;
        }
    }

    /* compiled from: JsHttpClient */
    static class d extends b {
        d(String str) {
            this.a = str;
        }

        public final Request a() {
            int i;
            int i2 = this.g > 0 ? this.g : 2500;
            String str = this.b;
            if ("POST".equalsIgnoreCase(str)) {
                i = 1;
            } else {
                boolean equalsIgnoreCase = "GET".equalsIgnoreCase(str);
                i = 0;
            }
            Request adVar = new ad(this, i, this.a, this.d, new ab(this), new ac(this));
            adVar.setShouldCache(false);
            adVar.setRetryPolicy(new com.android.volley.d(i2, 1, 1.0f));
            return adVar;
        }
    }

    w() {
    }

    static void a(Request request) {
        a.a(request);
    }
}
