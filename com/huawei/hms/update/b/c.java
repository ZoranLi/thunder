package com.huawei.hms.update.b;

import javax.net.SocketFactory;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: HttpsUtils */
final class c {
    public static void a(HttpsURLConnection httpsURLConnection) {
        SocketFactory a = e.a();
        if (a instanceof SSLSocketFactory) {
            httpsURLConnection.setSSLSocketFactory((SSLSocketFactory) a);
        }
    }
}
