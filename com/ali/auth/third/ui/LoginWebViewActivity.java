package com.ali.auth.third.ui;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import com.ali.auth.third.a.a.a;
import com.ali.auth.third.a.b;
import com.ali.auth.third.ui.webview.BaseWebViewActivity;

public class LoginWebViewActivity extends BaseWebViewActivity {
    public static String a;
    public static String b;
    public static Activity c;
    private b j;

    public static boolean a(String str) {
        Uri parse = Uri.parse(str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(parse.getAuthority());
        stringBuilder.append(parse.getPath());
        return "https://www.alipay.com/webviewbridge".contains(stringBuilder.toString());
    }

    protected final WebViewClient a() {
        return new b(this);
    }

    protected final WebChromeClient b() {
        return new c(this);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d.a("accountBridge", new a());
        this.d.a("loginBridge", new a());
        this.j = (b) com.ali.auth.third.core.a.a(b.class);
    }

    static /* synthetic */ boolean a(LoginWebViewActivity loginWebViewActivity, Uri uri) {
        Bundle bundle;
        String query = uri.getQuery();
        if (query == null || query.length() <= 0) {
            bundle = null;
        } else {
            String[] split = query.split("&");
            bundle = new Bundle();
            for (String str : split) {
                int indexOf = str.indexOf("=");
                if (indexOf > 0 && indexOf < str.length() - 1) {
                    bundle.putString(str.substring(0, indexOf), str.substring(indexOf + 1));
                }
            }
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.getString("havana_mobile_reg_otherWebView");
        CharSequence string = bundle.getString("action");
        bundle.getString("loginId");
        if (!TextUtils.isEmpty(string)) {
            if (!"quit".equals(string)) {
                if ("relogin".equals(string)) {
                    loginWebViewActivity.finish();
                    return true;
                } else if ("mobile_confirm_login".equals(string) || "trustLogin".equals(string)) {
                    return true;
                } else {
                    if (!"continueLogin".equals(string)) {
                        return false;
                    }
                    bundle.putString("aliusersdk_h5querystring", uri.getQuery());
                    bundle.putString("token", a);
                    bundle.putString("scene", b);
                    loginWebViewActivity.setResult(com.ali.auth.third.core.f.b.c.p, loginWebViewActivity.getIntent().putExtras(bundle));
                    loginWebViewActivity.finish();
                    return true;
                }
            }
        }
        loginWebViewActivity.setResult(com.ali.auth.third.core.f.b.a.p, loginWebViewActivity.getIntent().putExtra("iv_token", bundle.getString("havana_iv_token")));
        loginWebViewActivity.finish();
        return true;
    }
}
