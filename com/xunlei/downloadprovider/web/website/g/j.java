package com.xunlei.downloadprovider.web.website.g;

import android.text.TextUtils;
import com.android.volley.Request;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.socialize.common.SocializeConstants;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.web.website.b.c;
import com.xunlei.downloadprovider.web.website.c.a;
import com.xunlei.xllib.b.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: WebsiteSyncServer */
public class j {
    private static final String b = "j";
    private static j d;
    public boolean a;
    private List<Long> c = new ArrayList();
    private a e = new n(this);

    private j() {
    }

    public static j a() {
        if (d == null) {
            synchronized (j.class) {
                if (d == null) {
                    d = new j();
                }
            }
        }
        return d;
    }

    public final void a(a aVar) {
        XLThreadPool.execute(new o(this, aVar));
    }

    private static JSONObject b(c cVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", cVar.b);
            jSONObject.put("title", cVar.c);
            jSONObject.put(SocializeConstants.KEY_PIC, cVar.d);
            jSONObject.put("collect_time", cVar.d() / 1000);
        } catch (c cVar2) {
            cVar2.printStackTrace();
        }
        return jSONObject;
    }

    static /* synthetic */ void a(j jVar, JSONObject jSONObject) {
        long c = LoginHelper.a().g.c();
        try {
            String string = jSONObject.getString("result");
            jSONObject = jSONObject.getBoolean("new_user");
            if (ITagManager.SUCCESS.equals(string) && jSONObject == null) {
                if (jVar.c.contains(Long.valueOf(c)) == null) {
                    jVar.c.add(Long.valueOf(c));
                    jVar.a(jVar.e);
                }
                return;
            }
            if (ITagManager.SUCCESS.equals(string) && jSONObject != null) {
                XLThreadPool.execute(new r(jVar));
            }
        } catch (j jVar2) {
            jVar2.printStackTrace();
        }
    }

    static /* synthetic */ void a(JSONObject jSONObject, a aVar) {
        try {
            if (ITagManager.SUCCESS.equals(jSONObject.getString("result"))) {
                jSONObject = jSONObject.getString("site_list");
                if (TextUtils.isEmpty(jSONObject)) {
                    aVar.b();
                    return;
                }
                try {
                    JSONArray jSONArray = new JSONArray(jSONObject);
                    jSONObject = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        c cVar = new c();
                        String optString = jSONObject2.optString("url");
                        if (a.b(optString) == null) {
                            cVar.b = optString;
                            cVar.c = jSONObject2.optString("title");
                            cVar.d = jSONObject2.optString(SocializeConstants.KEY_PIC);
                            cVar.a(jSONObject2.optLong("collect_time") * 1000);
                            jSONObject.add(0, cVar);
                            b.a().a(optString, true);
                        }
                    }
                    if (jSONObject.size() > 0) {
                        try {
                            com.xunlei.downloadprovider.database.b.a.a().b().getCollectWebsiteInfoDao().insertOrReplaceInTx((Iterable) jSONObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (d.a(jSONObject) != null) {
                        aVar.b();
                        return;
                    } else {
                        aVar.a();
                        return;
                    }
                } catch (JSONObject jSONObject3) {
                    aVar.b();
                    jSONObject3.printStackTrace();
                    return;
                }
            }
            aVar.b();
        } catch (JSONObject jSONObject32) {
            aVar.b();
            jSONObject32.printStackTrace();
        }
    }

    static /* synthetic */ void a(j jVar, boolean z, JSONObject jSONObject) {
        Request sigJsonObjectRequest = new SigJsonObjectRequest(1, z ? "http://api-shoulei-ssl.xunlei.com/fav_site/api/v2/store" : "http://api-shoulei-ssl.xunlei.com/fav_site/api/v2/store/delete", jSONObject, new u(jVar), new v(jVar));
        sigJsonObjectRequest.setShouldCache(null);
        sigJsonObjectRequest.setRetryPolicy(new com.android.volley.d(ReaderCallback.GET_BAR_ANIMATING, 1, 1.0f));
        VolleyRequestManager.getRequestQueue().a(sigJsonObjectRequest);
    }
}
