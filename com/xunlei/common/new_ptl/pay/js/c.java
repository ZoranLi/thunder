package com.xunlei.common.new_ptl.pay.js;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.pay.js.export.IXLPayJSHandler;
import com.xunlei.common.new_ptl.pay.js.export.XLPayJSInterface;
import com.xunlei.common.new_ptl.pay.js.export.XLPayJSUserInfo;

/* compiled from: XLPayJSRegister */
public class c {
    private static String e = "XLPayJsInstance";
    private String a = c.class.getSimpleName();
    private WebView b = null;
    private XLPayJSInterface c = null;
    private Activity d = null;
    private a f = null;
    private IXLPayJSHandler g = null;
    private XLPayJSUserInfo h = null;

    public final boolean a(WebView webView, Activity activity, IXLPayJSHandler iXLPayJSHandler) {
        if (!(this.b != null || webView == null || activity == null)) {
            if (iXLPayJSHandler != null) {
                String str = this.a;
                StringBuilder stringBuilder = new StringBuilder("register js interface thread = ");
                stringBuilder.append(Thread.currentThread().getId());
                XLLog.v(str, stringBuilder.toString());
                this.b = webView;
                this.d = activity;
                this.g = iXLPayJSHandler;
                this.h = this.g.handleXLUserInfo();
                this.f = new a(this, Looper.getMainLooper());
                this.b.getSettings().setJavaScriptEnabled(true);
                this.c = new XLPayJSInterface();
                this.c.init(this);
                this.b.addJavascriptInterface(this.c, "XLPayJsInstance");
                return true;
            }
        }
        return false;
    }

    public final boolean a() {
        if (this.b == null) {
            return false;
        }
        XLLog.v(this.a, "unRegister js interface.");
        if (VERSION.SDK_INT >= 11) {
            this.b.removeJavascriptInterface("XLPayJsInstance");
        }
        this.b = null;
        this.d = null;
        this.f = null;
        this.c.unInit();
        this.c = null;
        return true;
    }

    private WebView d() {
        return this.b;
    }

    public final Activity b() {
        return this.d;
    }

    private Handler e() {
        return this.f;
    }

    public final XLPayJSUserInfo c() {
        return this.h;
    }

    public final void a(String str) {
        this.f.post(new 1(this, str));
    }
}
