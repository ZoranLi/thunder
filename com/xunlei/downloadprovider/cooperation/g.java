package com.xunlei.downloadprovider.cooperation;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.d;
import com.android.volley.n.a;
import com.android.volley.n.b;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.app.e;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: CooperationLoader */
public abstract class g {
    private int a = 0;
    protected volatile JSONObject b;
    String c;
    public boolean d = true;
    HashMap<String, String> e;
    private b<JSONObject> f = new h(this);
    private a g = new i(this);

    protected abstract void a();

    g() {
    }

    public final void b() {
        this.a++;
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/configuration/global/get_cfg?config_type=exchange&versionName=5.60.2.5510&rd=");
        stringBuilder.append(System.currentTimeMillis() / 1000);
        Request jVar = new j(this, stringBuilder.toString(), this.f, this.g);
        jVar.setRetryPolicy(new d(ReaderCallback.GET_BAR_ANIMATING, 1, 1.0f));
        jVar.setShouldCache(false);
        VolleyRequestManager.getRequestQueue().a(jVar);
    }

    final void c() {
        JSONObject a = com.xunlei.downloadprovider.h.d.a(new File(this.c));
        if (a != null && a.optString("result").equals(ITagManager.SUCCESS)) {
            this.b = a.optJSONObject("values");
        }
    }

    static /* synthetic */ void a(g gVar, JSONObject jSONObject) {
        StringBuilder stringBuilder = new StringBuilder("load cooperation data success in ");
        stringBuilder.append(gVar.a);
        stringBuilder.append(" times");
        if (jSONObject != null) {
            if (jSONObject.optString("result").equals(ITagManager.SUCCESS)) {
                gVar.b = jSONObject.optJSONObject("values");
                new StringBuilder("length:").append(jSONObject.toString().length());
                gVar.a();
            }
            new StringBuilder("store json is:").append(jSONObject.toString());
            File file = new File(gVar.c);
            e.a("You should not write file on main thread");
            new StringBuilder("store json:").append(jSONObject.toString());
            try {
                gVar = new FileOutputStream(file);
                gVar.write(jSONObject.toString().getBytes());
                gVar.close();
            } catch (g gVar2) {
                jSONObject = new StringBuilder("exception when store json:");
                jSONObject.append(file.getName());
                jSONObject.append(" ");
                jSONObject.append(gVar2.getMessage());
                gVar2.printStackTrace();
            }
        }
    }

    static /* synthetic */ void a(g gVar, VolleyError volleyError) {
        new StringBuilder("load cooperation data fail in times ").append(gVar.a);
        if (gVar.a < 2) {
            gVar.b();
            return;
        }
        new StringBuilder("request json failed:").append(volleyError.toString());
        gVar.a();
    }
}
