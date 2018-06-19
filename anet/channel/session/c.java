package anet.channel.session;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* compiled from: Taobao */
final class c implements HostnameVerifier {
    final /* synthetic */ String a;

    c(String str) {
        this.a = str;
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.a, sSLSession);
    }
}
