package com.xunlei.downloadprovider.download.privatespace.a.b;

import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.member.payment.network.BaseJsonRequest.IMethod;

/* compiled from: UnBindCheckSmsRequest */
public final class i extends a {
    public i(Object obj, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
        super(obj, IMethod.GET, "https://xluser-ssl.xunlei.com/msg/v1/CheckSmsToMobile");
        a("phone", str);
        a("token", str2);
        a("sign", str3);
        a("code", str4);
        a("scene", "002");
    }
}
