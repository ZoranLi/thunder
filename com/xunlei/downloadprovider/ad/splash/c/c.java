package com.xunlei.downloadprovider.ad.splash.c;

import android.text.TextUtils;
import com.xunlei.common.businessutil.DownloadConfig;
import com.xunlei.common.encrypt.MD5;
import com.xunlei.downloadprovider.ad.splash.downloader.d;
import com.xunlei.downloadprovider.ad.splash.downloader.k;
import com.xunlei.downloadprovider.app.BrothersApplication;
import java.io.File;

/* compiled from: SplashMaterialDownloadLoader */
public class c {
    public static final String a;
    private static final String c = "c";
    public k b;

    /* compiled from: SplashMaterialDownloadLoader */
    public interface a {
        void a();

        void a(String str);
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(DownloadConfig.getAdPath(BrothersApplication.getApplicationInstance()));
        stringBuilder.append(File.separatorChar);
        stringBuilder.append("splash");
        a = stringBuilder.toString();
    }

    public c() {
        this.b = null;
        this.b = new k();
    }

    public final void a() {
        k kVar = this.b;
        if (!kVar.a()) {
            d dVar = kVar.a;
            if (dVar.a != null) {
                synchronized (dVar.a) {
                    dVar.a.clear();
                    dVar.a = null;
                }
            }
            if (dVar.b != null) {
                dVar.b = null;
            }
            if (dVar.c != null) {
                dVar.b();
                for (int i = 0; i < dVar.c.length; i++) {
                    dVar.c[i] = null;
                }
                dVar.c = null;
            }
            kVar.a = null;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append(File.separatorChar);
        stringBuilder.append(MD5.encrypt(str));
        return stringBuilder.toString();
    }
}
