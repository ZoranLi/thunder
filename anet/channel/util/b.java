package anet.channel.util;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* compiled from: Taobao */
public class b {
    public static final HostnameVerifier ALLOW_ALL_HOSTNAME_VERIFIER = new a();
    public static final SSLSocketFactory TRUST_ALL_SSL_SOCKET_FACTORY = b.a();
    static SSLSocketFactory a;
    static HostnameVerifier b;

    /* compiled from: Taobao */
    private static class a implements HostnameVerifier {
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }

        private a() {
        }
    }

    /* compiled from: Taobao */
    private static class b {

        /* compiled from: Taobao */
        private static class a implements X509TrustManager {
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            private a() {
            }
        }

        private b() {
        }

        public static SSLSocketFactory a() {
            try {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init(null, new TrustManager[]{new a()}, null);
                return instance.getSocketFactory();
            } catch (Throwable th) {
                StringBuilder stringBuilder = new StringBuilder("getSocketFactory error :");
                stringBuilder.append(th.getMessage());
                ALog.w("awcn.SSLTrustAllSocketFactory", stringBuilder.toString(), null, new Object[0]);
                th.printStackTrace();
                return null;
            }
        }
    }

    public static SSLSocketFactory a() {
        return a;
    }

    public static void a(SSLSocketFactory sSLSocketFactory) {
        a = sSLSocketFactory;
    }

    public static HostnameVerifier b() {
        return b;
    }

    public static void a(HostnameVerifier hostnameVerifier) {
        b = hostnameVerifier;
    }
}
