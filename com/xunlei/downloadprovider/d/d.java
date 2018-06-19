package com.xunlei.downloadprovider.d;

import android.text.TextUtils;
import com.xunlei.downloadprovider.d.a.i;
import com.xunlei.downloadprovider.d.b.b;
import com.xunlei.downloadprovider.d.b.c;
import com.xunlei.downloadprovider.d.b.e;
import com.xunlei.downloadprovider.d.b.f;
import com.xunlei.downloadprovider.d.b.g;
import com.xunlei.downloadprovider.d.b.h;
import com.xunlei.downloadprovider.d.b.j;
import com.xunlei.downloadprovider.d.b.k;
import com.xunlei.downloadprovider.d.b.l;
import com.xunlei.downloadprovider.d.b.m;
import com.xunlei.downloadprovider.d.b.n;
import com.xunlei.downloadprovider.d.b.p;
import com.xunlei.downloadprovider.d.b.q;
import com.xunlei.downloadprovider.d.b.r;
import com.xunlei.downloadprovider.d.b.s;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONObject;

/* compiled from: GlobalConfigure */
public class d extends i {
    public static d a;
    public g b = new g();
    public b c = new b();
    public c d = new c();
    public com.xunlei.downloadprovider.d.b.d e = new com.xunlei.downloadprovider.d.b.d();
    public f f = new f();
    public h g = new h();
    public com.xunlei.downloadprovider.d.b.i h = new com.xunlei.downloadprovider.d.b.i();
    public k i = new k();
    public l j = new l();
    public n l = new n();
    public p m = new p();
    public q n = new q();
    public r o = new r();
    public com.xunlei.downloadprovider.d.b.a p = new com.xunlei.downloadprovider.d.b.a();
    public j q = new j();
    public s r = new s();
    public m s = new m();
    public e t = new e();
    public a u;

    /* compiled from: GlobalConfigure */
    public interface a {
        void a();
    }

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    private d() {
        super("GlobalConfigure.json", "http://api-shoulei-ssl.xunlei.com/configuration/global/get_cfg");
    }

    public final String b() {
        return this.k == null ? "" : this.k.toString();
    }

    protected final void a(boolean z, JSONObject jSONObject, String str) {
        super.a(z, jSONObject, str);
        if (jSONObject != null) {
            a(jSONObject);
            this.b.a((JSONObject) jSONObject.optJSONObject("homepage"));
            this.c.a((JSONObject) jSONObject.optJSONObject("discovery"));
            this.d.a((JSONObject) jSONObject.optJSONObject("download_task"));
            this.e.a((JSONObject) jSONObject.optJSONObject("forcelogin"));
            this.f.a((JSONObject) jSONObject.optJSONObject("guide"));
            this.h.a((JSONObject) jSONObject.optJSONObject("paycenter"));
            this.i.a((JSONObject) jSONObject.optJSONObject("player"));
            this.j.a((JSONObject) jSONObject.optJSONObject("publish"));
            this.l.a((JSONObject) jSONObject.optJSONObject("red_envelope"));
            this.m.a((JSONObject) jSONObject.optJSONObject("search"));
            this.n.a(jSONObject.optJSONObject("webs"));
            this.o.a((JSONObject) jSONObject.optJSONObject("xllive"));
            this.p.a((JSONObject) jSONObject.optJSONObject("ad"));
            this.r.a((JSONObject) jSONObject.optJSONObject("youliao"));
            this.q.a((JSONObject) jSONObject.optJSONObject("personal_letter"));
            z = jSONObject.optJSONArray("tabs");
            h hVar = this.g;
            new StringBuilder("parseTabs--valueJson=").append(z);
            if (z) {
                if (z.length() != 0) {
                    Collection arrayList = new ArrayList();
                    for (int i = 0; i < z.length(); i++) {
                        JSONObject optJSONObject = z.optJSONObject(i);
                        if (optJSONObject != null) {
                            com.xunlei.downloadprovider.d.b.h.a aVar = new com.xunlei.downloadprovider.d.b.h.a();
                            Object optString = optJSONObject.optString("tabKey");
                            if (!TextUtils.isEmpty(optString)) {
                                aVar.a = optString;
                                aVar.b = optJSONObject.optString("tabTitle");
                                aVar.c = optJSONObject.optString("tabIcon");
                                arrayList.add(aVar);
                            }
                        }
                    }
                    hVar.a.clear();
                    hVar.a.addAll(arrayList);
                    this.s.a((JSONObject) jSONObject.optJSONObject("push"));
                }
            }
            hVar.a.clear();
            this.s.a((JSONObject) jSONObject.optJSONObject("push"));
        }
        this.t.a = str;
        if (this.u) {
            this.u.a();
            this.u = false;
        }
    }
}
