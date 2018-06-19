package com.xunlei.downloadprovider.ad.common.adget;

import android.os.Looper;
import android.text.TextUtils;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.umeng.message.util.HttpRequest;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.net.thunderserver.request.BasicRequest;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.c.b$a;
import com.xunlei.downloadprovider.ad.common.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: AgGet */
public class e {
    String a = "xunlei";
    protected List<THUNDER_AD_INFO> b = new ArrayList();

    /* compiled from: AgGet */
    interface b {
        void a();

        void a(com.xunlei.downloadprovider.ad.common.adget.j.a aVar);

        void a(List<l> list);
    }

    /* compiled from: AgGet */
    protected class a extends BasicRequest {
        final /* synthetic */ e a;

        public final int compareTo(Object obj) {
            return 0;
        }

        public a(e eVar, String str, com.android.volley.n.b bVar, com.android.volley.n.a aVar) {
            this.a = eVar;
            super(null, str, bVar, aVar);
        }

        protected final com.android.volley.n parseNetworkResponse(com.android.volley.j r4) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r0 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x000e }
            r1 = r4.b;	 Catch:{ UnsupportedEncodingException -> 0x000e }
            r2 = r4.c;	 Catch:{ UnsupportedEncodingException -> 0x000e }
            r2 = com.android.volley.toolbox.k.a(r2);	 Catch:{ UnsupportedEncodingException -> 0x000e }
            r0.<init>(r1, r2);	 Catch:{ UnsupportedEncodingException -> 0x000e }
            goto L_0x0015;
        L_0x000e:
            r0 = new java.lang.String;
            r1 = r4.b;
            r0.<init>(r1);
        L_0x0015:
            r4 = com.android.volley.toolbox.k.a(r4);
            r4 = com.android.volley.n.a(r0, r4);
            return r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.ad.common.adget.e.a.parseNetworkResponse(com.android.volley.j):com.android.volley.n");
        }

        public final Map<String, String> getHeaders() throws AuthFailureError {
            Map<String, String> headers = super.getHeaders();
            if (headers == null) {
                headers = new HashMap();
            }
            headers.put(HttpRequest.HEADER_USER_AGENT, AndroidConfig.getUserAgent());
            return headers;
        }
    }

    public e(THUNDER_AD_INFO thunder_ad_info) {
        this.b.add(thunder_ad_info);
    }

    protected final String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://adsp.xunlei.com/api/adp/agget");
        stringBuilder.append("?");
        stringBuilder.append(k.a(this.b, false, 3));
        Object a = k.a(stringBuilder.toString());
        if (!TextUtils.isEmpty(a)) {
            stringBuilder.append(a);
        }
        return stringBuilder.toString();
    }

    final void a(b bVar, v vVar) {
        b$a com_xunlei_downloadprovider_ad_common_c_b_a = new b$a();
        com_xunlei_downloadprovider_ad_common_c_b_a.a = System.currentTimeMillis();
        a(new f(this, com_xunlei_downloadprovider_ad_common_c_b_a, bVar, vVar));
    }

    public final void a(n<JSONObject> nVar) {
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            XLThreadPool.execute(new g(this, nVar));
        } else {
            b(nVar);
        }
    }

    private void b(n<JSONObject> nVar) {
        if (nVar != null) {
            k.b("adv_request", k.a((THUNDER_AD_INFO) this.b.get(0), null, "xunlei"));
            b$a com_xunlei_downloadprovider_ad_common_c_b_a = new b$a();
            com_xunlei_downloadprovider_ad_common_c_b_a.a = System.currentTimeMillis();
            Request aVar = new a(this, a(), new h(this, nVar, com_xunlei_downloadprovider_ad_common_c_b_a), new i(this, com_xunlei_downloadprovider_ad_common_c_b_a, nVar));
            aVar.setShouldCache(false);
            VolleyRequestManager.getMainThreadRequestQueue().a(aVar);
        }
    }
}
