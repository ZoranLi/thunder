package com.xunlei.downloadprovider.personal.lixianspace.d;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.android.volley.VolleyError;
import com.android.volley.p;
import com.umeng.message.MsgConstant;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.common.encrypt.Base64;
import com.xunlei.common.encrypt.MD5;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.payment.network.BaseJsonRequest;
import com.xunlei.downloadprovider.member.payment.network.BaseJsonRequest.IMethod;
import com.xunlei.downloadprovider.member.payment.network.d;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: BaseLixianRequest */
public class a extends BaseJsonRequest {
    private static Random c = new Random();

    a(Object obj, IMethod iMethod, @NonNull String str) {
        super(iMethod, str);
        this.a = obj;
        obj = String.valueOf("5.60.2.5510");
        str = String.valueOf(System.currentTimeMillis() / 1000);
        String valueOf = String.valueOf(c.nextInt(Integer.MAX_VALUE));
        Map hashMap = new HashMap();
        hashMap.put("client_name", "xl_android");
        hashMap.put("client_version", obj);
        hashMap.put(MsgConstant.KEY_TS, str);
        hashMap.put("r", valueOf);
        hashMap.put("uid", String.valueOf(LoginHelper.a().g.c()));
        StringBuilder stringBuilder = new StringBuilder("+%?#]^@clien`(^");
        stringBuilder.append(IMethod.POST == iMethod ? "POST" : "GET");
        stringBuilder.append("xl_android");
        stringBuilder.append(obj);
        stringBuilder.append(str);
        stringBuilder.append(valueOf);
        hashMap.put("key", MD5.encrypt(stringBuilder.toString()));
        str = new StringBuilder();
        str.append(String.valueOf(LoginHelper.a().g.c()));
        str.append(Constants.COLON_SEPARATOR);
        str.append(LoginHelper.a().c());
        str.append(":client:40");
        str = Base64.encode(str.toString().getBytes(Charset.forName("ISO-8859-1")));
        StringBuilder stringBuilder2 = new StringBuilder("Basic ");
        stringBuilder2.append(str);
        a(hashMap).b("Accept", "application/json; version=1.0").b("Authorization", stringBuilder2.toString());
    }

    protected final void a(JSONObject jSONObject, d dVar) {
        a(jSONObject, new b(this, dVar), new c(this, dVar));
    }

    protected final p a() {
        return new com.android.volley.d(20000, 1, 1.0f);
    }

    private static int c(VolleyError volleyError) {
        return (volleyError == null || volleyError.networkResponse == null) ? -1000 : volleyError.networkResponse.a;
    }

    static /* synthetic */ String b(VolleyError volleyError) {
        if (volleyError == null || TextUtils.isEmpty(volleyError.getMessage())) {
            return p.a(c(volleyError));
        }
        return volleyError.getMessage();
    }
}
