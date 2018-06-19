package com.xunlei.common.register.a;

import android.content.Context;
import com.xunlei.common.httpclient.AsyncHttpClient;
import com.xunlei.common.httpclient.BaseHttpClient;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.Header;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* compiled from: XLRegisterRequestHandler */
public class d {
    private static String a = "zhuce.xunlei.com";
    private static int e = 0;
    private static int f = 1;
    private static d j;
    private final String b;
    private final String c;
    private final String d;
    private int g = 1;
    private Context h = null;
    private BaseHttpClient i = new AsyncHttpClient(f.a().e());

    /* compiled from: XLRegisterRequestHandler */
    public static class a extends SSLSocketFactory {
        private SSLContext a = SSLContext.getInstance("TLS");

        public a(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
            super(keyStore);
            keyStore = new X509TrustManager(this) {
                private /* synthetic */ a a;

                public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                }

                public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                }

                public final X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            this.a.init(null, new TrustManager[]{keyStore}, null);
        }

        public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException, UnknownHostException {
            return this.a.getSocketFactory().createSocket(socket, str, i, z);
        }

        public final Socket createSocket() throws IOException {
            return this.a.getSocketFactory().createSocket();
        }
    }

    public static boolean b() {
        return true;
    }

    private d() {
    }

    public static d a() {
        if (j != null) {
            return j;
        }
        synchronized (d.class) {
            if (j == null) {
                j = new d();
            }
        }
        return j;
    }

    public final boolean a(Context context) {
        KeyStore instance;
        Exception e;
        SSLSocketFactory aVar;
        this.h = context;
        try {
            instance = KeyStore.getInstance(KeyStore.getDefaultType());
            try {
                instance.load(null, null);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                aVar = new a(instance);
                aVar.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
                context = this.i;
                if (context instanceof AsyncHttpClient) {
                    ((AsyncHttpClient) context).setSSLSocketFactory(aVar);
                }
                return true;
            }
        } catch (Exception e3) {
            e = e3;
            instance = null;
            e.printStackTrace();
            aVar = new a(instance);
            aVar.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            context = this.i;
            if (context instanceof AsyncHttpClient) {
                ((AsyncHttpClient) context).setSSLSocketFactory(aVar);
            }
            return true;
        }
        try {
            aVar = new a(instance);
            try {
                aVar.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            } catch (KeyManagementException e4) {
                context = e4;
                context.printStackTrace();
                context = this.i;
                if (context instanceof AsyncHttpClient) {
                    ((AsyncHttpClient) context).setSSLSocketFactory(aVar);
                }
                return true;
            } catch (UnrecoverableKeyException e5) {
                context = e5;
                context.printStackTrace();
                context = this.i;
                if (context instanceof AsyncHttpClient) {
                    ((AsyncHttpClient) context).setSSLSocketFactory(aVar);
                }
                return true;
            } catch (NoSuchAlgorithmException e6) {
                context = e6;
                context.printStackTrace();
                context = this.i;
                if (context instanceof AsyncHttpClient) {
                    ((AsyncHttpClient) context).setSSLSocketFactory(aVar);
                }
                return true;
            } catch (KeyStoreException e7) {
                context = e7;
                context.printStackTrace();
                context = this.i;
                if (context instanceof AsyncHttpClient) {
                    ((AsyncHttpClient) context).setSSLSocketFactory(aVar);
                }
                return true;
            }
        } catch (KeyManagementException e8) {
            aVar = null;
            context = e8;
            context.printStackTrace();
            context = this.i;
            if (context instanceof AsyncHttpClient) {
                ((AsyncHttpClient) context).setSSLSocketFactory(aVar);
            }
            return true;
        } catch (UnrecoverableKeyException e9) {
            aVar = null;
            context = e9;
            context.printStackTrace();
            context = this.i;
            if (context instanceof AsyncHttpClient) {
                ((AsyncHttpClient) context).setSSLSocketFactory(aVar);
            }
            return true;
        } catch (NoSuchAlgorithmException e10) {
            aVar = null;
            context = e10;
            context.printStackTrace();
            context = this.i;
            if (context instanceof AsyncHttpClient) {
                ((AsyncHttpClient) context).setSSLSocketFactory(aVar);
            }
            return true;
        } catch (KeyStoreException e11) {
            aVar = null;
            context = e11;
            context.printStackTrace();
            context = this.i;
            if (context instanceof AsyncHttpClient) {
                ((AsyncHttpClient) context).setSSLSocketFactory(aVar);
            }
            return true;
        }
        context = this.i;
        if (context instanceof AsyncHttpClient) {
            ((AsyncHttpClient) context).setSSLSocketFactory(aVar);
        }
        return true;
    }

    private void a(int i) {
        this.g = i;
    }

    private int c() {
        return this.g;
    }

    private void a(BaseHttpClient baseHttpClient) {
        this.i = baseHttpClient;
    }

    private BaseHttpClient d() {
        return this.i;
    }

    public final void a(Header[] headerArr, String str, BaseHttpClientListener baseHttpClientListener) {
        String str2 = "https://zhuce.xunlei.com/regapi";
        if (this.g == 0) {
            str2 = "http://zhuce.xunlei.com/regapi";
        }
        this.i.post(this.h, str2, headerArr, str.getBytes(), baseHttpClientListener);
    }

    public final void b(Header[] headerArr, String str, BaseHttpClientListener baseHttpClientListener) {
        headerArr = "https://zhuce.xunlei.com/regapi";
        if (this.g == 0) {
            headerArr = "http://zhuce.xunlei.com/regapi";
        }
        BaseHttpClient baseHttpClient = this.i;
        Context context = this.h;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(headerArr);
        stringBuilder.append("?");
        stringBuilder.append(str);
        baseHttpClient.get(context, stringBuilder.toString(), null, baseHttpClientListener);
    }

    private void e() {
        KeyStore instance;
        Exception e;
        SSLSocketFactory aVar;
        BaseHttpClient baseHttpClient;
        KeyManagementException e2;
        UnrecoverableKeyException e3;
        NoSuchAlgorithmException e4;
        KeyStoreException e5;
        try {
            instance = KeyStore.getInstance(KeyStore.getDefaultType());
            try {
                instance.load(null, null);
            } catch (Exception e6) {
                e = e6;
                e.printStackTrace();
                aVar = new a(instance);
                aVar.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
                baseHttpClient = this.i;
                if (!(baseHttpClient instanceof AsyncHttpClient)) {
                    ((AsyncHttpClient) baseHttpClient).setSSLSocketFactory(aVar);
                }
            }
        } catch (Exception e7) {
            e = e7;
            instance = null;
            e.printStackTrace();
            aVar = new a(instance);
            aVar.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            baseHttpClient = this.i;
            if (!(baseHttpClient instanceof AsyncHttpClient)) {
                ((AsyncHttpClient) baseHttpClient).setSSLSocketFactory(aVar);
            }
        }
        try {
            aVar = new a(instance);
            try {
                aVar.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            } catch (KeyManagementException e8) {
                e2 = e8;
                e2.printStackTrace();
                baseHttpClient = this.i;
                if (!(baseHttpClient instanceof AsyncHttpClient)) {
                    ((AsyncHttpClient) baseHttpClient).setSSLSocketFactory(aVar);
                }
            } catch (UnrecoverableKeyException e9) {
                e3 = e9;
                e3.printStackTrace();
                baseHttpClient = this.i;
                if (!(baseHttpClient instanceof AsyncHttpClient)) {
                    ((AsyncHttpClient) baseHttpClient).setSSLSocketFactory(aVar);
                }
            } catch (NoSuchAlgorithmException e10) {
                e4 = e10;
                e4.printStackTrace();
                baseHttpClient = this.i;
                if (!(baseHttpClient instanceof AsyncHttpClient)) {
                    ((AsyncHttpClient) baseHttpClient).setSSLSocketFactory(aVar);
                }
            } catch (KeyStoreException e11) {
                e5 = e11;
                e5.printStackTrace();
                baseHttpClient = this.i;
                if (!(baseHttpClient instanceof AsyncHttpClient)) {
                    ((AsyncHttpClient) baseHttpClient).setSSLSocketFactory(aVar);
                }
            }
        } catch (KeyManagementException e12) {
            aVar = null;
            e2 = e12;
            e2.printStackTrace();
            baseHttpClient = this.i;
            if (!(baseHttpClient instanceof AsyncHttpClient)) {
                ((AsyncHttpClient) baseHttpClient).setSSLSocketFactory(aVar);
            }
        } catch (UnrecoverableKeyException e13) {
            aVar = null;
            e3 = e13;
            e3.printStackTrace();
            baseHttpClient = this.i;
            if (!(baseHttpClient instanceof AsyncHttpClient)) {
                ((AsyncHttpClient) baseHttpClient).setSSLSocketFactory(aVar);
            }
        } catch (NoSuchAlgorithmException e14) {
            aVar = null;
            e4 = e14;
            e4.printStackTrace();
            baseHttpClient = this.i;
            if (!(baseHttpClient instanceof AsyncHttpClient)) {
                ((AsyncHttpClient) baseHttpClient).setSSLSocketFactory(aVar);
            }
        } catch (KeyStoreException e15) {
            aVar = null;
            e5 = e15;
            e5.printStackTrace();
            baseHttpClient = this.i;
            if (!(baseHttpClient instanceof AsyncHttpClient)) {
                ((AsyncHttpClient) baseHttpClient).setSSLSocketFactory(aVar);
            }
        }
        baseHttpClient = this.i;
        if (!(baseHttpClient instanceof AsyncHttpClient)) {
            ((AsyncHttpClient) baseHttpClient).setSSLSocketFactory(aVar);
        }
    }
}
