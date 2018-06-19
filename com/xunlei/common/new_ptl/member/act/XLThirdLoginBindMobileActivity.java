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
import com.xunlei.common.new_ptl.member.task.helpertask.a;
import com.xunlei.common.new_ptl.member.task.helpertask.b;

public class XLThirdLoginBindMobileActivity extends Activity implements a {
    private String TAG = XLThirdLoginBindMobileActivity.class.getSimpleName();
    private b mBindMobileTask;
    private int mTaskId = 0;
    protected WebView mWebView = null;

    interface XLBindMobileJsTraceStatCommand {
        public static final String BM_USER_CANCEL = "user_cancel_bind_mobile";
        public static final String BM_USER_CLICK_CANCEL = "bind_mobile_cancel_btn";
    }

    final class XLWebChromeClient extends WebChromeClient {
        XLWebChromeClient() {
        }

        public final boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
            new Builder(XLThirdLoginBindMobileActivity.this).setTitle("迅雷安全中心").setMessage(str2.toString()).setCancelable(null).setPositiveButton(17039370, new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            }).create().show();
            return true;
        }
    }

    public String getThirdAppId() {
        a aVar = (a) p.a().a(this.mTaskId);
        return aVar != null ? aVar.getThirdAppId() : "";
    }

    public void onThirdLoginBindMobile(int i, String str, String str2, String str3, int i2) {
        sendVerifyMobileResult(i, str, str2, str3);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        XLLog.v(this.TAG, "onCreate");
        this.mTaskId = getIntent().getIntExtra("XL_BIND_MOBILE_TASK_ID", 0);
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
        this.mBindMobileTask = new b(p.a());
        this.mBindMobileTask.a(this.mWebView);
        this.mBindMobileTask.b(getIntent().getStringExtra("XL_BIND_MOBILE_TASK_URL"));
        this.mBindMobileTask.a((a) this);
        this.mBindMobileTask.h();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public void onBackPressed() {
        sendVerifyMobileResult(XLErrorCode.TUSER_CANCLE_BIND_MOBILE_ERROR, XLErrorCode.getErrorDesc(XLErrorCode.TUSER_CANCLE_BIND_MOBILE_ERROR), "", "");
        if (this.mBindMobileTask != null) {
            this.mBindMobileTask.d(XLBindMobileJsTraceStatCommand.BM_USER_CANCEL);
        }
        finish();
    }

    public void sendVerifyMobileResult(int i, String str, String str2, String str3) {
        a aVar = (a) p.a().a(this.mTaskId);
        if (aVar != null) {
            aVar.onThirdLoginBindMobile(i, str, str2, str3, this.mTaskId);
        }
        finish();
    }
}
