package com.alibaba.sdk.android.feedback.xblink.c;

import com.alibaba.sdk.android.feedback.xblink.i.g;
import com.alibaba.sdk.android.feedback.xblink.webview.HybridPlusWebView;
import com.alipay.sdk.packet.d;
import java.util.HashMap;
import java.util.Map;

public class a implements Runnable {
    private j a;
    private Map b;
    private int c;
    private String d;
    private byte[] e;

    public a(String str, j jVar, Map map, String str2, int i, boolean z) {
        this.c = i;
        this.a = jVar;
        if (map != null) {
            this.b = new HashMap(map);
        }
        this.d = str2;
    }

    public void a() {
    }

    public synchronized void a(j jVar) {
        this.a = jVar;
    }

    public void b() {
        if (this.b != null) {
            this.b.clear();
        }
    }

    public void run() {
        h hVar = new h(this.d);
        hVar.a(this.b);
        hVar.a(false);
        i a = new c().a(hVar);
        this.e = a.c();
        synchronized (this) {
            if (this.a != null) {
                StringBuilder stringBuilder;
                Map b = a.b();
                b.put("url", this.d);
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(a.a());
                b.put("response-code", stringBuilder2.toString());
                b.put(HybridPlusWebView.HTTPSVERIFYERROR, hVar.i());
                String str = (String) b.get(d.d);
                if (g.a()) {
                    stringBuilder = new StringBuilder("http charset:");
                    stringBuilder.append(str);
                    g.a("HtmlDownloader", stringBuilder.toString());
                }
                Object a2 = com.alibaba.sdk.android.feedback.xblink.i.a.a(str);
                if (a2 == null) {
                    a2 = "utf-8";
                    if (g.a()) {
                        stringBuilder = new StringBuilder("default charset:");
                        stringBuilder.append(a2);
                        g.a("HtmlDownloader", stringBuilder.toString());
                    }
                }
                b.put("charset", a2);
                this.a.callback(this.e, b, this.c);
                this.b = null;
                this.a = null;
            }
        }
    }
}
