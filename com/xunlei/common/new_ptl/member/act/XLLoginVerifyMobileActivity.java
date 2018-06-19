package com.xunlei.common.new_ptl.member.act;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.task.d.b;
import com.xunlei.common.new_ptl.member.task.helpertask.c;

public class XLLoginVerifyMobileActivity extends Activity implements c {
    private String TAG = XLLoginVerifyMobileActivity.class.getSimpleName();
    private int mTaskId = 0;
    protected WebView mWebView = null;

    final class XLWebChromeClient extends WebChromeClient {
        XLWebChromeClient() {
        }

        public final boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
            new Builder(XLLoginVerifyMobileActivity.this).setTitle("来自网页的提示").setMessage(str2.toString()).setPositiveButton(17039370, new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            }).setCancelable(null).create().show();
            return true;
        }
    }

    public void onUserVerifyMobileCallBack(int i, String str, String str2, long j, String str3, Object obj, int i2) {
        sendVerifyMobileResult(i, str, str2, j, str3);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        XLLog.v(this.TAG, "onCreate");
        this.mTaskId = getIntent().getIntExtra("XL_VERIFY_MOBILE_TASK_ID", 0);
        if (this.mTaskId == null) {
            finish();
            return;
        }
        this.mWebView = new WebView(this);
        setContentView(this.mWebView);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.setWebChromeClient(new XLWebChromeClient());
        this.mWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }

            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                sslErrorHandler.proceed();
            }
        });
        CookieSyncManager.createInstance(getApplicationContext());
        CookieManager.getInstance().removeAllCookie();
        bundle = new com.xunlei.common.new_ptl.member.task.aq.c(p.a());
        bundle.a(this.mWebView);
        bundle.b(getIntent().getStringExtra("XL_VERIFY_MOBILE_TASK_URL"));
        bundle.b(getIntent().getLongExtra("XL_VERIFY_MOBILE_TASK_UID", 0));
        bundle.a((c) this);
        bundle.h();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public void onBackPressed() {
        sendVerifyMobileResult(XLErrorCode.AQ_USER_CANCLE_VERIFY_MOBILE_ERROR, XLErrorCode.getErrorDesc(XLErrorCode.AQ_USER_CANCLE_VERIFY_MOBILE_ERROR), "", 0, null);
        finish();
    }

    public void sendVerifyMobileResult(int i, String str, String str2, long j, String str3) {
        b bVar = (b) p.a().a(this.mTaskId);
        if (bVar != null) {
            bVar.onUserVerifyMobileCallBack(i, str, str2, j, str3, bVar.f(), r0.mTaskId);
        }
        finish();
    }
}
