package com.xunlei.downloadprovider.member;

import android.content.Context;
import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.h.f;
import org.json.JSONObject;

/* compiled from: NewUserManager */
final class c implements b<JSONObject> {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject != null) {
            new StringBuilder("requestNewUserFlag. success: ").append(jSONObject.toString());
            if (ITagManager.SUCCESS.contentEquals(jSONObject.optString("result"))) {
                boolean z = false;
                obj = jSONObject.optInt("is_newbie", 0);
                Context applicationInstance = BrothersApplication.getApplicationInstance();
                String str = "key_is_new_user";
                if (obj == 1) {
                    z = true;
                }
                f.a(applicationInstance, str, z);
                if (obj == 1) {
                    f.a(BrothersApplication.getApplicationInstance(), "key_first_enter_thunder", System.currentTimeMillis());
                }
            }
        }
    }
}
