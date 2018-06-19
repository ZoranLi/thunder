package com.android.volley.a;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* compiled from: XVolley */
final class d implements HostnameVerifier {
    final /* synthetic */ a a;

    public final boolean verify(String str, SSLSession sSLSession) {
        return true;
    }

    d(a aVar) {
        this.a = aVar;
    }
}
