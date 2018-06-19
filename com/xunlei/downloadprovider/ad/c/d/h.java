package com.xunlei.downloadprovider.ad.c.d;

import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.ad.c.a.b;
import com.xunlei.downloadprovider.ad.c.a.g;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ReportInstalledAppsTask */
public abstract class h extends g implements b {
    private static final String a = "h";

    protected static void a(boolean z, e[] eVarArr) {
        int min = Math.min(eVarArr.length, 500) - 1;
        int i = 0;
        while (i <= min) {
            int min2 = Math.min((min - i) + 1, 30);
            Object obj = new e[min2];
            System.arraycopy(eVarArr, i, obj, 0, min2);
            String b = b(z, obj);
            if (z) {
                d.a("app_pre_install_list", b);
            } else {
                d.a("app_self_install_list", b);
            }
            i += min2;
        }
    }

    private static String b(boolean z, e[] eVarArr) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (e a : eVarArr) {
            jSONArray.put(a(a));
        }
        try {
            jSONObject.put("system", z);
            jSONObject.put("list", jSONArray);
        } catch (boolean z2) {
            z2.printStackTrace();
        }
        return jSONObject.toString();
    }

    @NonNull
    private static JSONObject a(e eVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pkg_nm", eVar.a);
            jSONObject.put("nm", eVar.b);
            jSONObject.put("from", eVar.c);
            jSONObject.put("vc", eVar.f);
            jSONObject.put("v", eVar.g);
            jSONObject.put("install_time", eVar.h);
            jSONObject.put("update_time", eVar.i);
        } catch (e eVar2) {
            eVar2.printStackTrace();
        }
        return jSONObject;
    }
}
