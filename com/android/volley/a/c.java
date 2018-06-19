package com.android.volley.a;

import android.os.Environment;
import com.android.volley.l;
import com.android.volley.toolbox.d;
import com.android.volley.toolbox.i;
import com.android.volley.toolbox.n;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* compiled from: XVolley */
public final class c {
    private static c a;
    private l b;

    /* compiled from: XVolley */
    private class a extends n {
        final /* synthetic */ c a;
        private SSLSocketFactory b;
        private boolean c;

        private a(c cVar) {
            this.a = cVar;
            this.c = null;
        }

        protected final HttpURLConnection a(URL url) throws IOException {
            url = super.a(url);
            if (this.c && (url instanceof HttpsURLConnection)) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url;
                httpsURLConnection.setSSLSocketFactory(a());
                httpsURLConnection.setHostnameVerifier(new d(this));
            }
            return url;
        }

        private SSLSocketFactory a() {
            if (this.b == null) {
                TrustManager[] trustManagerArr = new TrustManager[]{new e(this)};
                try {
                    SSLContext instance = SSLContext.getInstance("SSL");
                    instance.init(null, trustManagerArr, new SecureRandom());
                    this.b = instance.getSocketFactory();
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                }
            }
            return this.b;
        }
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (a == null) {
                a = new c();
            }
            cVar = a;
        }
        return cVar;
    }

    public final l b() {
        if (this.b == null) {
            File file = new File("/sdcard/.volley.cache");
            try {
                file = new File(Environment.getExternalStorageDirectory(), ".volley.cache");
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.b = new l(new i(file, (byte) 0), new d(new a()), 8);
            this.b.a();
        }
        return this.b;
    }
}
