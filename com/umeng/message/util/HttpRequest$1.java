package com.umeng.message.util;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

final class HttpRequest$1 implements HostnameVerifier {
    public final boolean verify(String str, SSLSession sSLSession) {
        return true;
    }

    HttpRequest$1() {
    }
}
