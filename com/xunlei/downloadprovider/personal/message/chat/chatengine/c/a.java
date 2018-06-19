package com.xunlei.downloadprovider.personal.message.chat.chatengine.c;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.d;
import com.android.volley.toolbox.k;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.downloadprovider.homepage.follow.c.ar;
import com.xunlei.downloadprovider.personal.message.chat.b;
import com.xunlei.downloadprovider.personal.message.chat.c;
import org.json.JSONObject;

/* compiled from: ChatBaseNetwork */
public class a extends com.xunlei.downloadprovider.personal.message.data.a {

    /* compiled from: ChatBaseNetwork */
    public static class a {

        /* compiled from: ChatBaseNetwork */
        public static class a<DATA> {
            public DATA a;
            public int b;
            public String c;
            public int d;
        }

        public static boolean a(a aVar, @Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                aVar.b = -1001;
                aVar.c = "jsonObject is null";
            } else {
                aVar.b = jSONObject.optInt("code");
                aVar.c = jSONObject.optString("result");
                aVar.d = jSONObject.optInt("type");
            }
            return a(aVar);
        }

        public static boolean a(a aVar) {
            return ITagManager.SUCCESS.equalsIgnoreCase(aVar.c);
        }
    }

    protected final ar a(int i, String str, c<JSONObject> cVar) {
        return a(i, str, null, cVar);
    }

    protected final ar a(int i, String str, JSONObject jSONObject, c<JSONObject> cVar) {
        return new ar(i, str, jSONObject, new b(this, cVar), new c(this, cVar));
    }

    public static boolean a(c cVar) {
        if (com.xunlei.downloadprovider.personal.message.chat.chatengine.b.a.a().b) {
            return true;
        }
        if (cVar != null) {
            cVar.a(b.a(-1003, "已经退出登录！"));
        }
        return null;
    }

    protected static void b(VolleyError volleyError, c cVar) {
        if (cVar != null) {
            JSONObject a = a(volleyError);
            if (a == null) {
                cVar.a(b.a(b(volleyError), ""));
                return;
            }
            volleyError = new a();
            a.a(volleyError, a);
            cVar.a(b.a(volleyError));
        }
    }

    protected static int b(VolleyError volleyError) {
        return volleyError.networkResponse == null ? -1 : volleyError.networkResponse.a;
    }

    private static JSONObject a(VolleyError volleyError) {
        volleyError = volleyError.networkResponse;
        if (volleyError != null) {
            try {
                Object str = new String(volleyError.b, k.a(volleyError.c, "utf-8"));
                if (TextUtils.isEmpty(str) == null) {
                    try {
                        return new JSONObject(str);
                    } catch (VolleyError volleyError2) {
                        volleyError2.printStackTrace();
                    }
                }
            } catch (VolleyError volleyError22) {
                volleyError22.printStackTrace();
            }
        }
        return null;
    }

    protected final void a(Request<?> request) {
        request.setShouldCache(false);
        request.setRetryPolicy(new d(10000, 1, 1.0f));
        d(request);
    }

    protected final void b(Request<?> request) {
        request.setShouldCache(false);
        request.setRetryPolicy(new d(20000, 0, 1.0f));
        d(request);
    }
}
