package com.alibaba.sdk.android.feedback.xblink.f;

import android.text.TextUtils;
import android.webkit.WebView;
import com.alibaba.sdk.android.feedback.xblink.i.g;

public class c {
    public static void a(Object obj, String str) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (TextUtils.isEmpty(str)) {
                str = String.format("javascript:window.WindVane.onSuccess(%s,'');", new Object[]{bVar.b()});
            } else {
                str = String.format("javascript:window.WindVane.onSuccess(%s,'%s');", new Object[]{bVar.b(), str});
            }
            if (g.a()) {
                StringBuilder stringBuilder = new StringBuilder("onSuccess:");
                stringBuilder.append(str);
                g.a("WVCallJs", stringBuilder.toString());
            }
            WebView a = bVar.a();
            if (a != null) {
                try {
                    a.loadUrl(str);
                    return;
                } catch (Exception e) {
                    StringBuilder stringBuilder2 = new StringBuilder("callSuccess error.");
                    stringBuilder2.append(e.getMessage());
                    g.b("WVCallJs", stringBuilder2.toString());
                }
            }
            return;
        }
        g.e("WVCallJs", "callSuccess: it seems you didn't pass the correct context which WindVane passed to your WindVaneInterface.");
    }

    public static void a(Object obj, String str, String str2) {
        if (obj instanceof b) {
            if (TextUtils.isEmpty(str2)) {
                str = String.format("javascript:window.WindVane.fireEvent('%s', '');", new Object[]{str});
            } else {
                str = String.format("javascript:window.WindVane.fireEvent('%s','%s');", new Object[]{str, str2});
            }
            if (g.a()) {
                StringBuilder stringBuilder = new StringBuilder("fireEvent: ");
                stringBuilder.append(str);
                g.a("WVCallJs", stringBuilder.toString());
            }
            WebView a = ((b) obj).a();
            if (a != null) {
                try {
                    a.loadUrl(str);
                    return;
                } catch (Exception e) {
                    StringBuilder stringBuilder2 = new StringBuilder("fireEvent error.");
                    stringBuilder2.append(e.getMessage());
                    g.b("WVCallJs", stringBuilder2.toString());
                }
            }
            return;
        }
        g.e("WVCallJs", "fireEvent: it seems you didn't pass the correct context which WindVane passed to your WindVaneInterface.");
    }

    public static void b(Object obj, String str) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (TextUtils.isEmpty(str)) {
                str = String.format("javascript:window.WindVane.onFailure(%s,'');", new Object[]{bVar.b()});
            } else {
                str = String.format("javascript:window.WindVane.onFailure(%s,'%s');", new Object[]{bVar.b(), str});
            }
            if (g.a()) {
                StringBuilder stringBuilder = new StringBuilder("onFailure:");
                stringBuilder.append(str);
                g.a("WVCallJs", stringBuilder.toString());
            }
            WebView a = bVar.a();
            if (a != null) {
                try {
                    a.loadUrl(str);
                    return;
                } catch (Exception e) {
                    StringBuilder stringBuilder2 = new StringBuilder("callFailure error. ");
                    stringBuilder2.append(e.getMessage());
                    g.b("WVCallJs", stringBuilder2.toString());
                }
            }
            return;
        }
        g.e("WVCallJs", "callFailure: it seems you didn't pass the correct context which WindVane passed to your WindVaneInterface.");
    }
}
