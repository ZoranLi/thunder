package com.alibaba.sdk.android.feedback.xblink.f;

import android.text.TextUtils;
import com.alibaba.sdk.android.feedback.xblink.i.g;
import com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView;

public class b {
    private XBHybridWebView a;
    private String b;

    public b(XBHybridWebView xBHybridWebView, String str) {
        this.a = xBHybridWebView;
        this.b = str;
    }

    private void c(String str) {
        if (g.a()) {
            StringBuilder stringBuilder = new StringBuilder("callback: ");
            stringBuilder.append(str);
            g.a("WVCallBackContext", stringBuilder.toString());
        }
        if (this.a != null) {
            try {
                this.a.loadUrl(str);
            } catch (Exception e) {
                stringBuilder = new StringBuilder("callback error. ");
                stringBuilder.append(e.getMessage());
                g.b("WVCallBackContext", stringBuilder.toString());
            }
        }
    }

    public XBHybridWebView a() {
        return this.a;
    }

    public void a(m mVar) {
        if (mVar != null) {
            mVar.a();
            a(mVar.b());
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = String.format("javascript:window.WindVane.onSuccess(%s,'');", new Object[]{this.b});
        } else {
            str = String.format("javascript:window.WindVane.onSuccess(%s,'%s');", new Object[]{this.b, str});
        }
        g.a("WVCallBackContext", "call success ");
        c(str);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str = String.format("javascript:window.WindVane.fireEvent('%s', '');", new Object[]{str});
        } else {
            str = String.format("javascript:window.WindVane.fireEvent('%s','%s');", new Object[]{str, str2});
        }
        g.a("WVCallBackContext", "call fireEvent ");
        c(str);
    }

    public String b() {
        return this.b;
    }

    public void b(m mVar) {
        if (mVar != null) {
            b(mVar.b());
        }
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            str = String.format("javascript:window.WindVane.onFailure(%s,'');", new Object[]{this.b});
        } else {
            str = String.format("javascript:window.WindVane.onFailure(%s,'%s');", new Object[]{this.b, str});
        }
        g.a("WVCallBackContext", "call error ");
        c(str);
    }
}
