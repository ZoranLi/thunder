package com.xunlei.downloadprovider.search.ui.search;

import com.android.volley.n.b;
import com.xunlei.xllib.b.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONObject;

/* compiled from: MultiLoader */
final class l implements b<JSONObject> {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (this.a.d.c != null && this.a.a.equals(this.a.d.f.c)) {
            if (this.a.b.equals(this.a.d.g)) {
                String str = this.a.b;
                boolean z = true;
                int hashCode = str.hashCode();
                if (hashCode != 111357) {
                    if (hashCode != 3530567) {
                        if (hashCode == 112202875) {
                            if (str.equals("video")) {
                                z = true;
                            }
                        }
                    } else if (str.equals("site")) {
                        z = false;
                    }
                } else if (str.equals("pub")) {
                    z = true;
                }
                switch (z) {
                    case false:
                        List list = this.a.d.c;
                        Collection arrayList = new ArrayList();
                        obj = jSONObject.optJSONArray("site");
                        if (obj != null) {
                            for (hashCode = 0; hashCode < obj.length(); hashCode++) {
                                JSONObject optJSONObject = obj.optJSONObject(hashCode);
                                if (optJSONObject != null) {
                                    ak akVar = new ak();
                                    akVar.a(optJSONObject);
                                    arrayList.add(akVar);
                                }
                            }
                        }
                        if (d.a(arrayList) != null) {
                            g.b = true;
                        }
                        list.addAll(arrayList);
                        break;
                    case true:
                        this.a.d.c.addAll(g.b(jSONObject));
                        break;
                    case true:
                        this.a.d.c.addAll(g.d(jSONObject));
                        break;
                    default:
                        break;
                }
                if (this.a.e != null) {
                    this.a.e.a();
                }
                g.a = false;
            }
        }
    }
}
