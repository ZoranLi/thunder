package com.xunlei.downloadprovider.homepage.follow.b;

import com.xunlei.download.Downloads.Impl;
import com.xunlei.downloadprovider.homepage.follow.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RecommendGroup */
public final class g {
    public String a;
    public List<a> b;
    public List<a> c = new ArrayList();
    private String d;
    private int e;
    private boolean f;

    public final int b() {
        return a().size();
    }

    public final List<a> c() {
        if (this.c.size() == 0) {
            Object a = a();
            int size = a.size();
            int i = 0;
            if (size == 0) {
                this.c.addAll(this.b.subList(0, Math.min(this.b.size(), 4)));
            } else if (size <= 4) {
                this.c.addAll(a);
            } else {
                while (i < 4) {
                    this.c.add(a.get(i));
                    i++;
                }
            }
        }
        return this.c;
    }

    public static g a(JSONObject jSONObject) {
        g gVar = new g();
        gVar.d = jSONObject.optString(Impl.COLUMN_GROUP_ID);
        gVar.a = jSONObject.optString("title");
        gVar.e = jSONObject.optInt("count");
        int i = 0;
        gVar.f = false;
        gVar.b = new ArrayList();
        jSONObject = jSONObject.optJSONArray("pub_list");
        if (jSONObject != null) {
            while (i < jSONObject.length()) {
                try {
                    gVar.b.add(a.a(jSONObject.getJSONObject(i)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                i++;
            }
        }
        return gVar;
    }

    public final List<a> a() {
        List<a> list = this.b;
        List<a> arrayList = new ArrayList();
        b a = b.a();
        for (a aVar : list) {
            if (!a.b(aVar.b)) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }
}
