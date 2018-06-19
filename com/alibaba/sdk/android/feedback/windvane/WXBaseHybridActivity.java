package com.alibaba.sdk.android.feedback.windvane;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.alibaba.sdk.android.feedback.R;
import com.alibaba.sdk.android.feedback.xblink.activity.XBBaseHybridActivity;
import com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView;
import com.alibaba.sdk.android.feedback.xblink.webview.i;

@SuppressLint({"Registered"})
public class WXBaseHybridActivity extends XBBaseHybridActivity implements i {
    public static final String EXTERNAL = "external";
    public static final String FROM = "from";
    public static final String FROM_TAOBAO_ITEM = "fromTaobaoItem";
    public static final String HIDE_TITLE = "hideTitle";
    public static final String NEED_LOGIN = "needLogin";
    public static final String NEED_SHOW_BACK = "need_show_back";
    public static final String NEED_SHOW_NAV = "need_show_nav";
    public static final int REMAI_REQESTCODE = 3;
    private static final String TAG = "WXBaseHybridActivity";
    private String JS_API_NAME = "WXPageAction";
    private boolean isAutoLogin = false;
    private boolean isDestroyed;
    private TextView mBackView;
    private Handler mHandler = new Handler();
    protected l mPageAction;
    protected k mWXPage;
    protected boolean needLogin;
    protected boolean needShowNav;
    private ProgressBar progressbar;
    protected CustomHybirdWebViewClient webViewClient;
    protected XBHybridWebView webview;

    private void controlWebview() {
        this.needLogin = getIntent().getBooleanExtra(NEED_LOGIN, false);
        this.needShowNav = getIntent().getBooleanExtra(NEED_SHOW_NAV, true);
    }

    public static String getSubUserAgent() {
        return "AliApp(WX/1)";
    }

    private void registerJSObject() {
        this.webview.addJsObject(this.JS_API_NAME, this.mPageAction);
        this.webview.addJsObject("WXPage", this.mWXPage);
    }

    private void setErrorView() {
        View inflate = View.inflate(this, R.layout.ali_feedback_error, null);
        this.mViewController.setErrorView(inflate);
        ((Button) inflate.findViewById(R.id.error_view_refresh_btn)).setOnClickListener(new j(this));
    }

    private void setWebview() {
        this.webview = this.mViewController.getWebview();
        if (VERSION.SDK_INT < 18) {
            this.webview.getSettings().setSavePassword(false);
        }
        this.webViewClient = new CustomHybirdWebViewClient(this);
        this.webview.setWebViewClient(this.webViewClient);
        this.progressbar = new ProgressBar(this, null, 16842872);
        this.progressbar.setMax(100);
        this.progressbar.setProgressDrawable(getResources().getDrawable(R.drawable.ali_feedback_progress_bar_states));
        LayoutParams layoutParams = new LayoutParams(-1, 6);
        layoutParams.addRule(10, -1);
        this.webview.setWebChromeClient(new CustomWebChromeClient(this.progressbar));
        this.webview.getWvUIModel().a(this.progressbar, layoutParams);
        String userAgentString = this.mViewController.getWebview().getSettings().getUserAgentString();
        WebSettings settings = this.mViewController.getWebview().getSettings();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(userAgentString);
        stringBuilder.append(" ");
        stringBuilder.append(getSubUserAgent());
        settings.setUserAgentString(stringBuilder.toString());
        this.webViewClient.setmUrl(this.mUrl);
        this.webViewClient.setWebViewErrorListener(this);
        this.webview.setOnTouchListener(new i(this));
    }

    protected void loadUrl() {
        this.mViewController.loadUrl(this.url, this.postData);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        StringBuilder stringBuilder = new StringBuilder("onActivityResult ");
        stringBuilder.append(i);
        stringBuilder.append(" : ");
        stringBuilder.append(i2);
        if (i2 == -1 && i == 3) {
            this.webview.reload();
        }
        if (i == l.a) {
            Object jsObject = this.webview.getJsObject(this.JS_API_NAME);
            if (jsObject != null && (jsObject instanceof l)) {
                ((l) jsObject).a(i, i2, intent);
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mUrl = getIntent().getStringExtra("URL");
        this.webview = this.mViewController.getWebview();
        this.isDestroyed = false;
        this.mPageAction = new l(this, getWindow().getDecorView());
        this.mWXPage = new k(this, getWindow().getDecorView());
        setErrorView();
        registerJSObject();
        setWebview();
        controlWebview();
    }

    protected void onDestroy() {
        this.isDestroyed = true;
        if (this.webViewClient != null) {
            this.webViewClient.setDestroyed(true);
        }
        this.mViewController.removeAllViews();
        super.onDestroy();
    }

    public void onReceivedError() {
        if (this.mBackView == null) {
            this.mBackView = (TextView) findViewById(R.id.webview_icon_back);
        }
        if (this.mBackView != null) {
            this.mBackView.setTextColor(getResources().getColor(R.color.ali_feedback_black));
            this.mBackView.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.ali_feedback_common_back_btn_bg), null, null, null);
        }
        if (this.webview.getWvUIModel() != null) {
            this.webview.getWvUIModel().d();
        }
    }
}
