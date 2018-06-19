package com.xunlei.downloadprovider.download.privatespace.a.b;

import com.xunlei.downloadprovider.download.privatespace.a.a.i;
import com.xunlei.downloadprovider.member.payment.network.BaseJsonRequest.IMethod;

/* compiled from: BindSendSmsRequest */
public final class g extends a {
    public g(Object obj, i iVar) {
        super(obj, IMethod.GET, "https://xluser-ssl.xunlei.com/msg/v1/SendSms");
        a("scene", "040");
        a(iVar);
    }
}
