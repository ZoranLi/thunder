package com.xunlei.common.new_ptl.member.act;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.xunlei.common.new_ptl.member.XLErrorCode;

public class XLXmBindActivity extends Activity {
    protected WebView mWebView = null;

    final class XLWebChromeClient extends WebChromeClient {
        XLWebChromeClient() {
        }

        public final boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
            new Builder(XLXmBindActivity.this).setTitle("来自网页的提示").setMessage(str2.toString()).setPositiveButton(17039370, new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            }).setCancelable(null).create().show();
            return true;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mWebView = new WebView(this);
        setContentView(this.mWebView);
        bundle = this.mWebView.getSettings();
        bundle.setJavaScriptEnabled(true);
        bundle.setSupportZoom(true);
        bundle.setBuiltInZoomControls(true);
        this.mWebView.setWebChromeClient(new XLWebChromeClient());
        this.mWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                XLXmBindActivity.this.webViewPreLoadUrl(str);
                return true;
            }

            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                sslErrorHandler.proceed();
            }
        });
        bundle = getIntent().getStringExtra("xl_bind_url");
        clearWebViewCache();
        this.mWebView.loadUrl(bundle);
    }

    private void clearWebViewCache() {
        CookieSyncManager.createInstance(getApplicationContext());
        CookieManager.getInstance().removeAllCookie();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    private void reply(int i, String str, String str2, String str3) {
        Intent intent = new Intent();
        if (i == 0) {
            intent.putExtra("xl_bind_tid", str);
            intent.putExtra("xl_bind_ttoken", str2);
            intent.putExtra("xl_bind_tsign", str3);
        }
        setResult(i, intent);
    }

    protected boolean webViewPreLoadUrl(String str) {
        if (str.indexOf("result=") == -1) {
            return false;
        }
        extractXiaoMiToken(str);
        return false;
    }

    public String extractSingle(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return null;
        }
        indexOf += str2.length();
        str2 = str.indexOf("&", indexOf);
        if (str2 == -1) {
            str2 = str.length();
        }
        return str.substring(indexOf, str2);
    }

    public void extractXiaoMiToken(String str) {
        String extractSingle = extractSingle(str, "third_id=");
        if (extractSingle != null) {
            String extractSingle2 = extractSingle(str, "sign=");
            if (extractSingle2 != null) {
                str = extractSingle(str, "mi_token=");
                if (str != null) {
                    reply(0, extractSingle, str, extractSingle2);
                    finish();
                    return;
                }
            }
        }
        reply(XLErrorCode.AUTH_USER_ERROR, null, null, null);
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.mWebView.canGoBack()) {
            this.mWebView.goBack();
            return true;
        }
        reply(XLErrorCode.AUTH_USER_CANCLE, null, null, null);
        return super.onKeyDown(i, keyEvent);
    }
}
