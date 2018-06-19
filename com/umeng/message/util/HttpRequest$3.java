package com.umeng.message.util;

import anet.channel.util.HttpConstant;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

final class HttpRequest$3 implements HostnameVerifier {
    final /* synthetic */ HttpsURLConnection a;

    HttpRequest$3(HttpsURLConnection httpsURLConnection) {
        this.a = httpsURLConnection;
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        str = this.a.getRequestProperty(HttpConstant.HOST);
        if (str == null) {
            str = this.a.getURL().getHost();
        }
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
    }
}
