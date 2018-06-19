package com.xunlei.downloadprovider.download.privatespace.a.b;

import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.member.payment.network.BaseJsonRequest.IMethod;

/* compiled from: UnBindBindMobileRequest */
public final class h extends a {
    public h(Object obj, @NonNull String str, @NonNull String str2) {
        super(obj, IMethod.GET, "https://xluser-ssl.xunlei.com/msg/v1/BindPhone");
        a("phone", str);
        a("sign", str2);
        a("scene", "002");
    }
}
