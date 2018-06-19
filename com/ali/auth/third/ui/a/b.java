package com.ali.auth.third.ui.a;

import android.webkit.WebView;
import com.ali.auth.third.core.c.a;
import org.json.JSONObject;

public class b {
    public WebView a;
    public int b;

    public final void a(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i);
            jSONObject.put("message", str);
            a.i.a(new c(this, jSONObject.toString()));
        } catch (int i2) {
            throw new RuntimeException(i2);
        }
    }

    static /* synthetic */ void a(b bVar, String str) {
        if (bVar.a != null) {
            bVar.a.loadUrl(str);
        }
    }
}
