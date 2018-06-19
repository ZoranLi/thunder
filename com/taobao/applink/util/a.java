package com.taobao.applink.util;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.WebView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class a {
    public static String a(Context context, String str) {
        InputStream open;
        Throwable th;
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            open = context.getAssets().open(str);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open));
                StringBuilder stringBuilder = new StringBuilder();
                String readLine;
                do {
                    readLine = bufferedReader.readLine();
                    if (!(readLine == null || readLine.matches("^\\s*\\/\\/.*"))) {
                        stringBuilder.append(readLine);
                        continue;
                    }
                } while (readLine != null);
                bufferedReader.close();
                open.close();
                str = stringBuilder.toString();
                if (open != null) {
                    try {
                        open.close();
                        return str;
                    } catch (IOException e) {
                        e.toString();
                    }
                }
                return str;
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.toString();
                    if (open != null) {
                        try {
                            open.close();
                            return null;
                        } catch (IOException e2) {
                            e2.toString();
                            return null;
                        }
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e22) {
                            e22.toString();
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            open = null;
            if (open != null) {
                open.close();
            }
            throw th;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.replace("tblink://return/", "").split("/");
        return split.length > 0 ? split[0] : null;
    }

    public static void a(WebView webView) {
        if (webView != null && !TextUtils.isEmpty("TBAppLinkJsBridge.js")) {
            String a = a(webView.getContext(), "TBAppLinkJsBridge.js");
            StringBuilder stringBuilder = new StringBuilder("javascript:");
            stringBuilder.append(a);
            webView.loadUrl(stringBuilder.toString());
        }
    }

    public static void a(WebView webView, com.taobao.applink.i.a aVar) {
        if (webView != null && aVar != null) {
            com.taobao.applink.f.a.a a = aVar.a();
            if (a != null) {
                a.a(webView, "TBAppLink", new b(webView));
            }
        }
    }

    public static void a(WebView webView, String str) {
        if (webView != null && !TextUtils.isEmpty(str)) {
            StringBuilder stringBuilder = new StringBuilder("javascript:");
            stringBuilder.append(str);
            webView.loadUrl(stringBuilder.toString());
        }
    }

    public static String b(String str) {
        return TextUtils.isEmpty(str) ? null : str.replace("javascript:TBAppLinkJsBridge.", "").replaceAll("\\(.*\\);", "");
    }

    public static void b(WebView webView) {
        try {
            r1 = new Object[4];
            StringBuilder stringBuilder = new StringBuilder("ANDROID ");
            stringBuilder.append(VERSION.SDK_INT);
            r1[1] = String.valueOf(stringBuilder.toString());
            r1[2] = String.valueOf(Build.MODEL);
            r1[3] = com.taobao.applink.b.a.c(webView.getContext());
            a(webView, String.format("window.applinkInfo ={sdkVersion:\"%s\",system:\"%s\",device:\"%s\",taoVersion:\"%s\"};", r1));
        } catch (Throwable th) {
            th.toString();
        }
    }

    public static String c(String str) {
        if (str.startsWith("tblink://return/_fetchQueue/")) {
            return str.replace("tblink://return/_fetchQueue/", "");
        }
        String[] split = str.replace("tblink://return/", "").split("/");
        if (split.length < 2) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < split.length; i++) {
            stringBuilder.append(split[i]);
        }
        return stringBuilder.toString();
    }
}
