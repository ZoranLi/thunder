package com.xunlei.downloadprovider.download.privatespace.a.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.android.volley.VolleyError;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.privatespace.a.a.f;
import com.xunlei.downloadprovider.download.privatespace.a.a.i;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.payment.network.BaseJsonRequest;
import com.xunlei.downloadprovider.member.payment.network.BaseJsonRequest.IMethod;
import com.xunlei.downloadprovider.member.payment.network.d;
import java.util.HashMap;

/* compiled from: BaseVerifyRequest */
public class a extends BaseJsonRequest {
    a(Object obj, IMethod iMethod, @NonNull String str) {
        super(iMethod, str);
        this.a = obj;
        obj = String.valueOf("5.60.2.5510");
        iMethod = new HashMap();
        iMethod.put("appid", "40");
        iMethod.put(DispatchConstants.PLATFORM_VERSION, "10");
        iMethod.put("appName", BrothersApplication.getApplicationInstance().getPackageName());
        iMethod.put("clientVersion", obj);
        iMethod.put("userid", String.valueOf(LoginHelper.a().g.c()));
        iMethod.put("sessionid", LoginHelper.a().c());
        iMethod.put("deviceid", LoginHelper.q());
        a(iMethod);
    }

    public final void a(d dVar) {
        a(null, new b(this, dVar), new c(this, dVar));
    }

    static int a(VolleyError volleyError) {
        return (volleyError == null || volleyError.networkResponse == null) ? -1000 : volleyError.networkResponse.a;
    }

    final void a(i iVar) {
        if (iVar != null) {
            a("VERIFY_CODE", iVar.c);
            a("VERIFY_KEY", iVar.a);
            a("VERIFY_TYPE", iVar.b);
        }
    }

    static /* synthetic */ String b(VolleyError volleyError) {
        if (volleyError == null || TextUtils.isEmpty(volleyError.getMessage())) {
            return f.a(a(volleyError));
        }
        return volleyError.getMessage();
    }
}
