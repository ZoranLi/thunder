package com.xunlei.downloadprovider.download.privatespace.a.b;

import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.member.payment.network.BaseJsonRequest.IMethod;

/* compiled from: BindCheckSmsRequest */
public final class f extends a {
    public f(Object obj, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        super(obj, IMethod.GET, "https://xluser-ssl.xunlei.com/msg/v1/CheckSms");
        a("token", str);
        a("sign", str2);
        a("code", str3);
        a("scene", "040");
    }
}
