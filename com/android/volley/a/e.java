package com.android.volley.a;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* compiled from: XVolley */
final class e implements X509TrustManager {
    final /* synthetic */ a a;

    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    e(a aVar) {
        this.a = aVar;
    }

    public final X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
