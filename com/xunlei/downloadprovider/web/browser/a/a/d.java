package com.xunlei.downloadprovider.web.browser.a.a;

import com.android.volley.n.b;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONObject;

/* compiled from: AdBlockConfig */
final class d implements b<JSONObject> {
    d() {
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        try {
            File a = b.a();
            obj = jSONObject.toString();
            FileOutputStream fileOutputStream = new FileOutputStream(a);
            fileOutputStream.write(obj.getBytes());
            fileOutputStream.close();
        } catch (Object obj2) {
            obj2.printStackTrace();
        }
    }
}
