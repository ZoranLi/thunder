package com.xunlei.downloadprovider.web.base.core;

import com.xunlei.downloadprovider.member.login.a.a.a;
import org.json.JSONObject;

/* compiled from: DefaultJsInterface */
final class u implements a {
    final /* synthetic */ String a;
    final /* synthetic */ DefaultJsInterface b;

    u(DefaultJsInterface defaultJsInterface, String str) {
        this.b = defaultJsInterface;
        this.a = str;
    }

    public final void a(JSONObject jSONObject) {
        String str = BaseJsInterface.TAG;
        new StringBuilder("jsonObject = ").append(jSONObject.toString());
        this.b.authWechatCallback(this.a, jSONObject);
    }

    public final void a() {
        String str = BaseJsInterface.TAG;
        this.b.authWechatCallback(this.a, null);
    }
}
