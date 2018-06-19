package com.xunlei.downloadprovider.search.ui.search;

import com.xunlei.xllib.b.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: MultiLoader */
final class g {
    static boolean a;
    static boolean b;

    /* compiled from: MultiLoader */
    interface a {
        void a();

        void b();
    }

    static List<a> a(JSONObject jSONObject) {
        List<a> arrayList = new ArrayList();
        jSONObject = jSONObject.optJSONObject("pub");
        if (jSONObject != null) {
            jSONObject = jSONObject.optJSONArray("list");
            for (int i = 0; i < jSONObject.length(); i++) {
                JSONObject optJSONObject = jSONObject.optJSONObject(i);
                if (optJSONObject != null) {
                    ai aiVar = new ai();
                    aiVar.a(optJSONObject);
                    arrayList.add(aiVar);
                }
            }
        }
        return arrayList;
    }

    static List<a> b(JSONObject jSONObject) {
        Object arrayList = new ArrayList();
        jSONObject = jSONObject.optJSONArray("pub");
        if (jSONObject != null) {
            for (int i = 0; i < jSONObject.length(); i++) {
                JSONObject optJSONObject = jSONObject.optJSONObject(i);
                if (optJSONObject != null) {
                    ai aiVar = new ai();
                    aiVar.a(optJSONObject);
                    arrayList.add(aiVar);
                }
            }
        }
        if (d.a(arrayList) != null) {
            b = true;
        }
        return arrayList;
    }

    static /* synthetic */ List c(JSONObject jSONObject) {
        List arrayList = new ArrayList();
        jSONObject = jSONObject.optJSONObject("video");
        if (jSONObject != null) {
            jSONObject = jSONObject.optJSONArray("list");
            for (int i = 0; i < jSONObject.length(); i++) {
                JSONObject optJSONObject = jSONObject.optJSONObject(i);
                if (optJSONObject != null) {
                    aj ajVar = new aj();
                    ajVar.a(optJSONObject);
                    arrayList.add(ajVar);
                }
            }
        }
        return arrayList;
    }

    static /* synthetic */ List d(JSONObject jSONObject) {
        Object arrayList = new ArrayList();
        jSONObject = jSONObject.optJSONArray("video");
        if (jSONObject != null) {
            for (int i = 0; i < jSONObject.length(); i++) {
                JSONObject optJSONObject = jSONObject.optJSONObject(i);
                if (optJSONObject != null) {
                    aj ajVar = new aj();
                    ajVar.a(optJSONObject);
                    arrayList.add(ajVar);
                }
            }
        }
        if (d.a(arrayList) != null) {
            b = true;
        }
        return arrayList;
    }
}
