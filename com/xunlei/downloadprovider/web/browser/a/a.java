package com.xunlei.downloadprovider.web.browser.a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.smtt.sdk.WebView;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.app.BrothersApplication;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* compiled from: BrowserInjectHack */
public final class a {
    private static final a a = new a();
    private String b;

    /* compiled from: BrowserInjectHack */
    private static class a {
        static File a() {
            return new File(BrothersApplication.getApplicationInstance().getCacheDir(), "HackPlayIconDown.js");
        }
    }

    public static a a() {
        return a;
    }

    public static boolean a(WebView webView, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (VERSION.SDK_INT >= 19) {
            webView.evaluateJavascript(str, null);
        } else {
            StringBuilder stringBuilder = new StringBuilder("javascript:");
            stringBuilder.append(str);
            webView.loadUrl(stringBuilder.toString());
        }
        return true;
    }

    private static String a(InputStream inputStream) {
        InputStreamReader inputStreamReader;
        Exception e;
        Throwable th;
        if (inputStream == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(1024);
        try {
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            try {
                char[] cArr = new char[4096];
                for (int read = inputStreamReader.read(cArr); read > 0; read = inputStreamReader.read(cArr)) {
                    stringBuilder.append(cArr, 0, read);
                }
                try {
                    inputStream.close();
                } catch (InputStream inputStream2) {
                    inputStream2.printStackTrace();
                }
                try {
                    inputStreamReader.close();
                } catch (InputStream inputStream22) {
                    inputStream22.printStackTrace();
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    try {
                        inputStream22.close();
                    } catch (InputStream inputStream222) {
                        inputStream222.printStackTrace();
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    return stringBuilder.toString();
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        inputStream222.close();
                    } catch (InputStream inputStream2222) {
                        inputStream2222.printStackTrace();
                    }
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (InputStream inputStream22222) {
                            inputStream22222.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            Exception exception = e3;
            inputStreamReader = null;
            e = exception;
            e.printStackTrace();
            inputStream22222.close();
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            return stringBuilder.toString();
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
            inputStream22222.close();
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            throw th;
        }
        return stringBuilder.toString();
    }

    private a() {
        XLThreadPool.execute(new b(this));
    }

    private String b() {
        try {
            File a = a.a();
            if (a.exists() && a.canRead()) {
                this.b = a(new FileInputStream(a));
                return this.b;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        InputStream inputStream = null;
        try {
            inputStream = BrothersApplication.getApplicationInstance().getResources().getAssets().open("shoulei/browser/js/HackPlayIconDown.js");
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.b = a(inputStream);
        return this.b;
    }
}
