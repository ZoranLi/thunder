package com.xunlei.downloadprovider.member.payment.a;

import android.content.Context;
import android.os.Handler;
import com.xunlei.downloadprovider.member.payment.network.BaseJsonRequest;
import com.xunlei.downloadprovider.member.payment.network.BaseJsonRequest.IMethod;

/* compiled from: ActivationBox */
public final class a extends e {
    public boolean a = false;

    public a(Context context, String str, String str2, String str3, String str4, String str5, Handler handler) {
        StringBuilder stringBuilder = new StringBuilder("http://dypay.vip.xunlei.com/gdscore/charge?uid=");
        stringBuilder.append(str);
        stringBuilder.append("&ticket=");
        stringBuilder.append(str2);
        stringBuilder.append("&verifycode=");
        stringBuilder.append(str3);
        stringBuilder.append("&verifykey=");
        stringBuilder.append(str4);
        stringBuilder.append("&act=");
        stringBuilder.append(str5);
        stringBuilder.append("&client=all&callback=callback&resptype=json");
        new BaseJsonRequest(IMethod.GET, stringBuilder.toString()).a(null, new b(this, handler), new c(this, context, handler));
    }
}
