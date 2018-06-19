package com.xunlei.common.new_ptl.member.act;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alipay.sdk.util.h;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLUserInfo;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.task.g.b;
import java.net.MalformedURLException;
import java.net.URL;

@SuppressLint({"SetJavaScriptEnabled"})
public class XLQRCodeLoginAuthActivity extends Activity {
    private String TAG = XLQRCodeLoginAuthActivity.class.getSimpleName();
    private boolean mNormalFinish = false;
    private int mTaskId = 0;
    private String mUrl = "";
    protected WebView mWebView = null;

    public final class JsCallBack {
        @JavascriptInterface
        public final void callBack(int i, String str) {
            XLQRCodeLoginAuthActivity.this.mNormalFinish = true;
            XLQRCodeLoginAuthActivity.this.notifyToTask(i, str);
            XLQRCodeLoginAuthActivity.this.finish();
            String access$200 = XLQRCodeLoginAuthActivity.this.TAG;
            StringBuilder stringBuilder = new StringBuilder("call back from js error = ");
            stringBuilder.append(i);
            stringBuilder.append("#errordesc = ");
            stringBuilder.append(str);
            XLLog.v(access$200, stringBuilder.toString());
        }
    }

    class WebViewTask extends AsyncTask<Void, Void, Boolean> {
        CookieManager cookieManager;

        private WebViewTask() {
            this.cookieManager = null;
        }

        protected void onPreExecute() {
            CookieSyncManager.createInstance(XLQRCodeLoginAuthActivity.this);
            this.cookieManager = CookieManager.getInstance();
            this.cookieManager.setAcceptCookie(true);
        }

        protected Boolean doInBackground(Void... voidArr) {
            SystemClock.sleep(100);
            return Boolean.valueOf(null);
        }

        protected void onPostExecute(Boolean bool) {
            XLQRCodeLoginAuthActivity.this.synCookies(this.cookieManager, XLQRCodeLoginAuthActivity.this.mUrl, XLQRCodeLoginAuthActivity.this.getCookies());
            bool = XLQRCodeLoginAuthActivity.this.mWebView.getSettings();
            bool.setJavaScriptEnabled(true);
            bool.setAppCacheEnabled(true);
            XLQRCodeLoginAuthActivity.this.mWebView.clearCache(true);
            XLQRCodeLoginAuthActivity.this.register(XLQRCodeLoginAuthActivity.this.mWebView);
            XLQRCodeLoginAuthActivity.this.mWebView.setWebViewClient(new WebViewClient() {
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    return XLQRCodeLoginAuthActivity.this.webViewPreLoadUrl(webView, str);
                }

                public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                    sslErrorHandler.proceed();
                }

                public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    super.onPageStarted(webView, str, bitmap);
                }
            });
            XLQRCodeLoginAuthActivity.this.mWebView.loadUrl(XLQRCodeLoginAuthActivity.this.mUrl);
            bool = XLQRCodeLoginAuthActivity.this.TAG;
            StringBuilder stringBuilder = new StringBuilder("load remote login url = ");
            stringBuilder.append(XLQRCodeLoginAuthActivity.this.mUrl);
            XLLog.v(bool, stringBuilder.toString());
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = getIntent();
        this.mTaskId = bundle.getIntExtra("xl_task_id", 0);
        if (this.mTaskId != 0) {
            this.mUrl = bundle.getStringExtra("xl_qr_auth_url");
            this.mWebView = new WebView(this);
            setContentView(this.mWebView);
            new WebViewTask().execute(new Void[0]);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (!this.mNormalFinish) {
            notifyToTask(XLErrorCode.QR_LOGIN_CANCLE_ERROR, "");
        }
        CookieManager.getInstance().removeAllCookie();
    }

    protected boolean webViewPreLoadUrl(WebView webView, String str) {
        webView = this.TAG;
        StringBuilder stringBuilder = new StringBuilder("webViewPreLoadUrl url = ");
        stringBuilder.append(str);
        XLLog.v(webView, stringBuilder.toString());
        return true;
    }

    private void synCookies(CookieManager cookieManager, String str, String str2) {
        str2 = str2.split(h.b);
        for (String cookie : str2) {
            cookieManager.setCookie(str, cookie);
        }
        CookieSyncManager.getInstance().sync();
    }

    private String getCookies() {
        StringBuilder stringBuilder = new StringBuilder();
        XLUserInfo i = p.a().i();
        stringBuilder.append("business_type=");
        stringBuilder.append(p.a().d());
        stringBuilder.append(";clientsessionid=");
        stringBuilder.append(i.getStringValue(USERINFOKEY.SessionID));
        stringBuilder.append(";userid=");
        stringBuilder.append(i.getStringValue(USERINFOKEY.UserID));
        stringBuilder.append(";pkgname=");
        stringBuilder.append(p.a().m());
        stringBuilder.append(";appversion=");
        stringBuilder.append(p.a().e());
        stringBuilder.append(";sdkversion=");
        stringBuilder.append(p.a().c());
        stringBuilder.append(";deviceid=");
        p.a();
        stringBuilder.append(p.v());
        try {
            URL url = new URL(this.mUrl);
            String host = url.getHost();
            String path = url.getPath();
            stringBuilder.append(";domain=");
            stringBuilder.append(host);
            stringBuilder.append(";path=");
            stringBuilder.append(path);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        XLLog.v(this.TAG, stringBuilder.toString());
        return stringBuilder.toString();
    }

    private void register(WebView webView) {
        if (webView != null) {
            XLLog.v(this.TAG, "register javascript interface to webview");
            webView.addJavascriptInterface(new JsCallBack(), JsCallBack.class.getSimpleName());
        }
    }

    private void notifyToTask(int i, String str) {
        b bVar = (b) p.a().a(this.mTaskId);
        if (bVar != null) {
            if (!(i == 0 || i == XLErrorCode.QR_LOGIN_CANCLE_ERROR)) {
                i = XLErrorCode.QR_LOGIN_AUTH_ERROR;
            }
            bVar.f(i);
        }
    }
}
