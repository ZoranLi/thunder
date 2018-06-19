package com.xunlei.downloadprovider.download.privatespace.a.b;

import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.download.privatespace.a.a.i;
import com.xunlei.downloadprovider.member.payment.network.BaseJsonRequest.IMethod;

/* compiled from: UnBindSendSmsRequest */
public final class j extends a {
    public j(Object obj, @NonNull String str, i iVar) {
        super(obj, IMethod.GET, "https://xluser-ssl.xunlei.com/msg/v1/SendSmsToMobile");
        a("phone", str);
        a("scene", "002");
        a(iVar);
    }
}
