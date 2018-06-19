package com.xunlei.downloadprovider.web.browser.transcode;

import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import anet.channel.util.HttpConstant;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.h.e;
import com.xunlei.downloadprovider.plugin.q;
import com.xunlei.downloadprovider.web.browser.a.i;
import com.xunlei.downloadprovider.web.browser.aa;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedOutputStream;
import java.net.HttpURLConnection;
import java.util.Timer;

public class BrowserTranscodeHelper {
    private static BrowserTranscodeHelper b;
    private final String a = BrowserTranscodeHelper.class.getSimpleName();
    private boolean c = false;
    private a d;
    private String[] e;
    private boolean f = false;
    private volatile String g = "";
    private volatile boolean h = true;
    private volatile int i = 0;
    private volatile int j = 0;
    private volatile PipedOutputStream k = null;
    private volatile HttpURLConnection l = null;
    private Handler m = new Handler(Looper.getMainLooper());
    private Timer n = new Timer();

    public static BrowserTranscodeHelper getInstance() {
        if (b == null) {
            synchronized (BrowserTranscodeHelper.class) {
                if (b == null) {
                    b = new BrowserTranscodeHelper();
                }
            }
        }
        return b;
    }

    public void prepare() {
        if (d.a().m.c()) {
            b bVar = new b();
            bVar.b = new f(this);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(BrothersApplication.getApplicationInstance().getExternalCacheDir());
            stringBuilder.append(File.separator);
            bVar.a = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(bVar.a);
            stringBuilder.append(a.a);
            if (e.c(stringBuilder.toString())) {
                q.a().a("com.xunlei.plugin.transcode", new c(bVar));
            } else {
                bVar.a(false);
            }
        }
    }

    public boolean shouldOverrideUrlLoadingForTranscode(i iVar, String str, boolean z) {
        if (d.a().m.c()) {
            if (this.c) {
                if (z) {
                    this.f = false;
                }
                closeOldConnect();
                if (str.contains("filterXL=false")) {
                    iVar.a(str.replace("?filterXL=false", "").replace("&filterXL=false", ""));
                    this.g = "";
                    this.f = true;
                    return true;
                }
                a(str);
                return false;
            }
        }
        return false;
    }

    public void filterUrlForTranscodeGoBack(i iVar) {
        if (d.a().m.c()) {
            if (this.c) {
                iVar.a();
                closeOldConnect();
                iVar = iVar.h();
                if (!(iVar == null || iVar.getSize() == 0)) {
                    int currentIndex = iVar.getCurrentIndex() - 1;
                    if (currentIndex >= 0 && currentIndex < iVar.getSize()) {
                        a(iVar.getItemAtIndex(currentIndex).getUrl());
                    }
                }
            }
        }
    }

    public void filterUrlForTranscodeGoForward(i iVar) {
        if (d.a().m.c()) {
            if (this.c) {
                iVar.a();
                closeOldConnect();
                iVar = iVar.h();
                if (!(iVar == null || iVar.getSize() == 0)) {
                    int currentIndex = iVar.getCurrentIndex() + 1;
                    if (currentIndex >= 0 && currentIndex < iVar.getSize()) {
                        a(iVar.getItemAtIndex(currentIndex).getUrl());
                    }
                }
            }
        }
    }

    private void a(String str) {
        if (VERSION.SDK_INT >= 19 && this.c && !this.f) {
            new StringBuilder("recordUrlForTranscode:").append(System.currentTimeMillis());
            if (this.e == null && this.d != null) {
                this.e = this.d.d.split("\r\n");
            }
            this.g = "";
            Uri parse = Uri.parse(str);
            String trim = parse.getScheme().trim();
            String host = parse.getHost();
            if ((!host.contains("eee") && !host.contains("ttt") && !host.contains("uuu")) || !TextUtils.isEmpty(parse.getPath().replace("/", ""))) {
                if (trim.equalsIgnoreCase(HttpConstant.HTTP) || trim.equalsIgnoreCase("https")) {
                    for (CharSequence contains : this.e) {
                        if (parse.getHost().contains(contains)) {
                            this.i++;
                            this.g = str;
                            return;
                        }
                    }
                }
            }
        }
    }

    public void closeOldConnect() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.l;
        if (r0 == 0) goto L_0x000c;
    L_0x0004:
        r0 = new com.xunlei.downloadprovider.web.browser.transcode.g;
        r0.<init>(r1);
        com.xunlei.common.concurrent.XLThreadPool.execute(r0);
    L_0x000c:
        r0 = r1.k;
        if (r0 == 0) goto L_0x0016;
    L_0x0010:
        r0 = r1.k;	 Catch:{ IOException -> 0x0016 }
        r0.close();	 Catch:{ IOException -> 0x0016 }
        return;
    L_0x0016:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.web.browser.transcode.BrowserTranscodeHelper.closeOldConnect():void");
    }

    public WebResourceResponse shouldInterceptRequest(i iVar, String str, Handler handler) {
        if (d.a().m.c()) {
            if (this.c) {
                if (!a(str, this.g)) {
                    return null;
                }
                int i = this.j + 1;
                this.j = i;
                this.h = false;
                new StringBuilder("shouldInterceptRequest:").append(System.currentTimeMillis());
                return a(iVar, str, handler, i);
            }
        }
        return null;
    }

    private boolean a(String str, String str2) {
        if (this.g.equals("")) {
            return false;
        }
        int abs = Math.abs(str.length() - str2.length());
        if (!str.equals(str2)) {
            if (abs != 1 || str.replace("/", "").equals(str2.replace("/", "")) == null) {
                return false;
            }
        }
        return true;
    }

    private com.tencent.smtt.export.external.interfaces.WebResourceResponse a(com.xunlei.downloadprovider.web.browser.a.i r12, java.lang.String r13, android.os.Handler r14, int r15) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r11 = this;
        r0 = r11.i;
        r1 = 0;
        r2 = new java.net.URL;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r2.<init>(r13);	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r2 = r2.openConnection();	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r11.l = r2;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r2 = r11.l;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r3 = 7000; // 0x1b58 float:9.809E-42 double:3.4585E-320;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r2.setConnectTimeout(r3);	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r2 = r11.l;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r2.setReadTimeout(r3);	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r2 = r11.l;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r2 = r2.getContentType();	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r3 = r11.l;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r3 = r3.getURL();	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r3 = r3.toString();	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r4 = r13.equals(r3);	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        if (r4 != 0) goto L_0x0063;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
    L_0x0032:
        r2 = r11.i;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        if (r0 != r2) goto L_0x0062;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
    L_0x0036:
        r0 = android.net.Uri.parse(r13);	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r0 = r0.getHost();	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r2 = "eee";	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r2 = r0.contains(r2);	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        if (r2 != 0) goto L_0x005d;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
    L_0x0046:
        r2 = "ttt";	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r2 = r0.contains(r2);	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        if (r2 != 0) goto L_0x005d;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
    L_0x004e:
        r2 = "uuu";	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r0 = r0.contains(r2);	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        if (r0 == 0) goto L_0x0057;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
    L_0x0056:
        goto L_0x005d;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
    L_0x0057:
        r11.g = r3;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r11.a(r12, r3);	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        goto L_0x0062;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
    L_0x005d:
        r0 = "";	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r11.g = r0;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        return r1;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
    L_0x0062:
        return r1;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
    L_0x0063:
        r3 = r11.l;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r4 = "location";	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r3 = r3.getHeaderField(r4);	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r4 = android.text.TextUtils.isEmpty(r3);	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        if (r4 != 0) goto L_0x00a2;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
    L_0x0071:
        r2 = r11.i;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        if (r0 != r2) goto L_0x00a1;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
    L_0x0075:
        r0 = android.net.Uri.parse(r13);	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r0 = r0.getHost();	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r2 = "eee";	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r2 = r0.contains(r2);	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        if (r2 != 0) goto L_0x009c;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
    L_0x0085:
        r2 = "ttt";	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r2 = r0.contains(r2);	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        if (r2 != 0) goto L_0x009c;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
    L_0x008d:
        r2 = "uuu";	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r0 = r0.contains(r2);	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        if (r0 == 0) goto L_0x0096;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
    L_0x0095:
        goto L_0x009c;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
    L_0x0096:
        r11.g = r3;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r11.a(r12, r3);	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        goto L_0x00a1;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
    L_0x009c:
        r0 = "";	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r11.g = r0;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        return r1;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
    L_0x00a1:
        return r1;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
    L_0x00a2:
        if (r2 == 0) goto L_0x00d9;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
    L_0x00a4:
        r0 = "html";	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r0 = r2.contains(r0);	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        if (r0 != 0) goto L_0x00ad;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
    L_0x00ac:
        goto L_0x00d9;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
    L_0x00ad:
        r0 = r11.l;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r8 = r0.getInputStream();	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r6 = new java.io.PipedOutputStream;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r6.<init>();	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r11.k = r6;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r0 = new java.io.PipedInputStream;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r0.<init>(r6);	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        if (r8 == 0) goto L_0x00d7;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
    L_0x00c1:
        r10 = new com.tencent.smtt.export.external.interfaces.WebResourceResponse;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r2 = "text/html";	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r10.<init>(r2, r1, r0);	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r0 = new com.xunlei.downloadprovider.web.browser.transcode.h;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r2 = r0;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r3 = r11;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r4 = r12;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r5 = r13;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r7 = r10;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r9 = r15;	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        r2.<init>(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        com.xunlei.common.concurrent.XLThreadPool.execute(r0);	 Catch:{ UnknownHostException -> 0x00fa, SSLHandshakeException -> 0x00f6, FileNotFoundException -> 0x00f2, SocketTimeoutException -> 0x00ee, Exception -> 0x00da }
        goto L_0x00d8;
    L_0x00d7:
        r10 = r1;
    L_0x00d8:
        return r10;
    L_0x00d9:
        return r1;
    L_0x00da:
        r14 = move-exception;
        r0 = "Socket closed";
        r2 = r14.getMessage();
        r0 = r0.equals(r2);
        if (r0 != 0) goto L_0x00ed;
    L_0x00e7:
        r14.printStackTrace();
        r11.a(r12, r13, r1, r15);
    L_0x00ed:
        return r1;
    L_0x00ee:
        r11.a(r12, r13, r14);
        return r1;
    L_0x00f2:
        r11.a(r12, r13, r14);
        return r1;
    L_0x00f6:
        r11.a(r12, r13, r14);
        return r1;
    L_0x00fa:
        r11.a(r12, r13, r14);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.web.browser.transcode.BrowserTranscodeHelper.a(com.xunlei.downloadprovider.web.browser.a.i, java.lang.String, android.os.Handler, int):com.tencent.smtt.export.external.interfaces.WebResourceResponse");
    }

    private void a(i iVar, String str) {
        this.m.post(new i(this, iVar, str));
    }

    private void a(i iVar, String str, Handler handler) {
        Message obtain = Message.obtain(handler, 10002);
        obtain.obj = str;
        obtain.arg1 = 502;
        handler.sendEmptyMessage(10002);
        this.m.post(new j(this, iVar));
    }

    private java.lang.String[] a(com.xunlei.downloadprovider.web.browser.a.i r7, java.lang.String r8, java.io.InputStream r9, java.io.PipedOutputStream r10, int r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "gb2312";
        r2 = 0;
        r3 = a(r9, r0);	 Catch:{ EOFException -> 0x003c, EOFException -> 0x003c, Exception -> 0x0027 }
        r1 = new java.io.InputStreamReader;	 Catch:{ EOFException -> 0x003d, EOFException -> 0x003d, Exception -> 0x0025 }
        r1.<init>(r9, r3);	 Catch:{ EOFException -> 0x003d, EOFException -> 0x003d, Exception -> 0x0025 }
        r9 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;	 Catch:{ EOFException -> 0x003d, EOFException -> 0x003d, Exception -> 0x0025 }
        r9 = new char[r9];	 Catch:{ EOFException -> 0x003d, EOFException -> 0x003d, Exception -> 0x0025 }
    L_0x0015:
        r4 = r1.read(r9);	 Catch:{ EOFException -> 0x003d, EOFException -> 0x003d, Exception -> 0x0025 }
        r5 = -1;	 Catch:{ EOFException -> 0x003d, EOFException -> 0x003d, Exception -> 0x0025 }
        if (r4 == r5) goto L_0x003d;	 Catch:{ EOFException -> 0x003d, EOFException -> 0x003d, Exception -> 0x0025 }
    L_0x001c:
        r5 = new java.lang.String;	 Catch:{ EOFException -> 0x003d, EOFException -> 0x003d, Exception -> 0x0025 }
        r5.<init>(r9, r2, r4);	 Catch:{ EOFException -> 0x003d, EOFException -> 0x003d, Exception -> 0x0025 }
        r0.append(r5);	 Catch:{ EOFException -> 0x003d, EOFException -> 0x003d, Exception -> 0x0025 }
        goto L_0x0015;
    L_0x0025:
        r9 = move-exception;
        goto L_0x0029;
    L_0x0027:
        r9 = move-exception;
        r3 = r1;
    L_0x0029:
        r1 = "Socket closed";
        r4 = r9.getMessage();
        r1 = r1.equals(r4);
        if (r1 != 0) goto L_0x003d;
    L_0x0035:
        r9.printStackTrace();
        r6.a(r7, r8, r10, r11);
        goto L_0x003d;
    L_0x003c:
        r3 = r1;
    L_0x003d:
        r7 = 2;
        r7 = new java.lang.String[r7];
        r8 = r0.toString();
        r9 = "\\";
        r10 = "\\\\";
        r8 = r8.replace(r9, r10);
        r9 = "\"";
        r10 = "\\\"";
        r8 = r8.replace(r9, r10);
        r9 = "[\\n\\r\\t]";
        r10 = " ";
        r8 = r8.replaceAll(r9, r10);
        r7[r2] = r8;
        r8 = 1;
        r7[r8] = r3;
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.web.browser.transcode.BrowserTranscodeHelper.a(com.xunlei.downloadprovider.web.browser.a.i, java.lang.String, java.io.InputStream, java.io.PipedOutputStream, int):java.lang.String[]");
    }

    private static String a(InputStream inputStream, StringBuilder stringBuilder) throws IOException {
        String str = "utf-8";
        String str2 = "";
        byte[] bArr = new byte[3];
        if (-1 != inputStream.read(bArr)) {
            if (bArr[0] == (byte) -17 && bArr[1] == (byte) -69 && bArr[2] == (byte) -65) {
                return str;
            }
            stringBuilder.append(new String(bArr));
            while (true) {
                if (str2.contains("charset=")) {
                    if (str2.substring(str2.indexOf("charset=")).contains(">")) {
                        break;
                    }
                }
                if (-1 == inputStream.read(bArr)) {
                    return str;
                }
                stringBuilder.append(new String(bArr));
                str2 = stringBuilder.toString();
            }
            inputStream = str2.substring(str2.indexOf("charset=") + 8);
            if (!(inputStream.startsWith("\"") == null && inputStream.startsWith("'") == null)) {
                inputStream = inputStream.substring(1);
            }
            if (inputStream.contains("\"") != null) {
                str = inputStream.substring(0, inputStream.indexOf("\""));
            } else if (inputStream.contains("'") == null) {
                return "utf-8";
            } else {
                str = inputStream.substring(0, inputStream.indexOf("'"));
            }
        }
        return str;
    }

    public void injectJsOnPageFinished(WebView webView) {
        String url = webView.getUrl();
        if (d.a().m.c() && this.c && !TextUtils.isEmpty(url)) {
            if (a(url, this.g)) {
                if (VERSION.SDK_INT >= 19) {
                    StringBuilder stringBuilder = new StringBuilder("javascript:");
                    stringBuilder.append(this.d.f);
                    webView.evaluateJavascript(stringBuilder.toString(), null);
                }
            }
        }
    }

    private void a(com.xunlei.downloadprovider.web.browser.a.i r2, java.lang.String r3, java.io.PipedOutputStream r4, int r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.j;
        if (r5 != r0) goto L_0x0047;
    L_0x0004:
        r0 = r1.h;
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        goto L_0x0047;
    L_0x0009:
        if (r4 == 0) goto L_0x000e;
    L_0x000b:
        r4.close();	 Catch:{ IOException -> 0x000e }
    L_0x000e:
        r4 = 1;
        r1.h = r4;
        r4 = "?";
        r4 = r3.contains(r4);
        if (r4 == 0) goto L_0x002b;
    L_0x0019:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r3);
        r3 = "&filterXL=false";
        r4.append(r3);
        r3 = r4.toString();
        goto L_0x003c;
    L_0x002b:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r3);
        r3 = "?filterXL=false";
        r4.append(r3);
        r3 = r4.toString();
    L_0x003c:
        r4 = r1.m;
        r0 = new com.xunlei.downloadprovider.web.browser.transcode.p;
        r0.<init>(r1, r5, r2, r3);
        r4.post(r0);
        return;
    L_0x0047:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.web.browser.transcode.BrowserTranscodeHelper.a(com.xunlei.downloadprovider.web.browser.a.i, java.lang.String, java.io.PipedOutputStream, int):void");
    }

    @JavascriptInterface
    public void returnButtonClick(String str) {
        aa.a(str);
    }

    static /* synthetic */ void a(BrowserTranscodeHelper browserTranscodeHelper, i iVar, String str, PipedOutputStream pipedOutputStream, WebResourceResponse webResourceResponse, InputStream inputStream, int i) {
        if (browserTranscodeHelper.j == i) {
            new StringBuilder("transcodeHtml:").append(System.currentTimeMillis());
            inputStream = browserTranscodeHelper.a(iVar, str, inputStream, pipedOutputStream, i);
            Object obj = inputStream[0];
            String str2 = inputStream[1];
            webResourceResponse.setEncoding(str2);
            if (TextUtils.isEmpty(obj) != null) {
                browserTranscodeHelper.a(iVar, str, pipedOutputStream, i);
            } else if (browserTranscodeHelper.j == i) {
                browserTranscodeHelper.m.post(new k(browserTranscodeHelper, i, iVar, obj, str, pipedOutputStream, str2));
            }
        }
    }

    static /* synthetic */ void a(com.xunlei.downloadprovider.web.browser.transcode.BrowserTranscodeHelper r5, com.xunlei.downloadprovider.web.browser.a.i r6, java.lang.String r7, java.io.PipedOutputStream r8, java.lang.String r9, java.lang.String r10, int r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r5.j;
        if (r0 != r11) goto L_0x00a2;
    L_0x0004:
        r0 = r5.h;
        if (r0 == 0) goto L_0x000a;
    L_0x0008:
        goto L_0x00a2;
    L_0x000a:
        r0 = 1;
        r5.h = r0;
        r1 = new java.lang.StringBuilder;
        r2 = "transcodeHtml-ReceiveValue:";
        r1.<init>(r2);
        r2 = java.lang.System.currentTimeMillis();
        r1.append(r2);
        r1 = 0;
        r2 = android.text.TextUtils.isEmpty(r9);	 Catch:{ Exception -> 0x0086 }
        if (r2 == 0) goto L_0x0026;	 Catch:{ Exception -> 0x0086 }
    L_0x0022:
        r5.a(r6, r7, r1, r11);	 Catch:{ Exception -> 0x0086 }
        goto L_0x007f;	 Catch:{ Exception -> 0x0086 }
    L_0x0026:
        r2 = r9.length();	 Catch:{ Exception -> 0x0086 }
        r2 = r2 - r0;	 Catch:{ Exception -> 0x0086 }
        r9 = r9.substring(r0, r2);	 Catch:{ Exception -> 0x0086 }
        r0 = "\\u003C";	 Catch:{ Exception -> 0x0086 }
        r2 = "<";	 Catch:{ Exception -> 0x0086 }
        r9 = r9.replace(r0, r2);	 Catch:{ Exception -> 0x0086 }
        r0 = "\\\\";	 Catch:{ Exception -> 0x0086 }
        r2 = "\\";	 Catch:{ Exception -> 0x0086 }
        r9 = r9.replace(r0, r2);	 Catch:{ Exception -> 0x0086 }
        r0 = "\\\"";	 Catch:{ Exception -> 0x0086 }
        r2 = "\"";	 Catch:{ Exception -> 0x0086 }
        r9 = r9.replace(r0, r2);	 Catch:{ Exception -> 0x0086 }
        r0 = r5.j;	 Catch:{ Exception -> 0x0086 }
        if (r0 == r11) goto L_0x0050;
    L_0x004b:
        r8.close();	 Catch:{ IOException -> 0x004f }
        return;
    L_0x004f:
        return;
    L_0x0050:
        r0 = r5.n;	 Catch:{ Exception -> 0x0086 }
        r2 = new com.xunlei.downloadprovider.web.browser.transcode.o;	 Catch:{ Exception -> 0x0086 }
        r2.<init>(r5, r8);	 Catch:{ Exception -> 0x0086 }
        r3 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;	 Catch:{ Exception -> 0x0086 }
        r0.schedule(r2, r3);	 Catch:{ Exception -> 0x0086 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0086 }
        r2 = "transcodeHtml-outWriteStart:";	 Catch:{ Exception -> 0x0086 }
        r0.<init>(r2);	 Catch:{ Exception -> 0x0086 }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0086 }
        r0.append(r2);	 Catch:{ Exception -> 0x0086 }
        r9 = r9.getBytes(r10);	 Catch:{ Exception -> 0x0086 }
        r8.write(r9);	 Catch:{ Exception -> 0x0086 }
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0086 }
        r10 = "transcodeHtml-outWriteFinish:";	 Catch:{ Exception -> 0x0086 }
        r9.<init>(r10);	 Catch:{ Exception -> 0x0086 }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0086 }
        r9.append(r2);	 Catch:{ Exception -> 0x0086 }
    L_0x007f:
        r8.close();	 Catch:{ IOException -> 0x0083 }
        return;
    L_0x0083:
        return;
    L_0x0084:
        r5 = move-exception;
        goto L_0x009e;
    L_0x0086:
        r9 = move-exception;
        r10 = "Pipe closed";	 Catch:{ all -> 0x0084 }
        r0 = r9.getMessage();	 Catch:{ all -> 0x0084 }
        r10 = r10.equals(r0);	 Catch:{ all -> 0x0084 }
        if (r10 != 0) goto L_0x0099;	 Catch:{ all -> 0x0084 }
    L_0x0093:
        r9.printStackTrace();	 Catch:{ all -> 0x0084 }
        r5.a(r6, r7, r1, r11);	 Catch:{ all -> 0x0084 }
    L_0x0099:
        r8.close();	 Catch:{ IOException -> 0x009d }
        return;
    L_0x009d:
        return;
    L_0x009e:
        r8.close();	 Catch:{ IOException -> 0x00a1 }
    L_0x00a1:
        throw r5;
    L_0x00a2:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.web.browser.transcode.BrowserTranscodeHelper.a(com.xunlei.downloadprovider.web.browser.transcode.BrowserTranscodeHelper, com.xunlei.downloadprovider.web.browser.a.i, java.lang.String, java.io.PipedOutputStream, java.lang.String, java.lang.String, int):void");
    }
}
