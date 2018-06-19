package com.sina.weibo.sdk.web;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sina.weibo.sdk.utils.ResourceManager;
import com.sina.weibo.sdk.utils.UIUtils;
import com.sina.weibo.sdk.utils.WbUtils;
import com.sina.weibo.sdk.web.client.AuthWebViewClient;
import com.sina.weibo.sdk.web.client.BaseWebViewClient;
import com.sina.weibo.sdk.web.client.DefaultWebViewClient;
import com.sina.weibo.sdk.web.client.ShareWebViewClient;
import com.sina.weibo.sdk.web.param.AuthWebViewRequestParam;
import com.sina.weibo.sdk.web.param.BaseWebViewRequestParam;
import com.sina.weibo.sdk.web.param.BaseWebViewRequestParam.ExtraTaskCallback;
import com.sina.weibo.sdk.web.param.DefaultWebViewRequestParam;
import com.sina.weibo.sdk.web.param.ShareWebViewRequestParam;
import com.sina.weibo.sdk.web.view.LoadingBar;
import com.tencent.tinker.android.dx.instruction.Opcodes;

public class WeiboSdkWebActivity extends Activity implements WebViewRequestCallback {
    public static final String BROWSER_CLOSE_SCHEME = "sinaweibo://browser/close";
    private static final String CANCEL_EN = "Close";
    private static final String CANCEL_ZH_CN = "关闭";
    private static final String CANCEL_ZH_TW = "关闭";
    private static final String CHANNEL_DATA_ERROR_EN = "channel_data_error";
    private static final String CHANNEL_DATA_ERROR_ZH_CN = "重新加载";
    private static final String CHANNEL_DATA_ERROR_ZH_TW = "重新載入";
    private static final String EMPTY_PROMPT_BAD_NETWORK_UI_EN = "A network error occurs, please tap the button to reload";
    private static final String EMPTY_PROMPT_BAD_NETWORK_UI_ZH_CN = "网络出错啦，请点击按钮重新加载";
    private static final String EMPTY_PROMPT_BAD_NETWORK_UI_ZH_TW = "網路出錯啦，請點擊按鈕重新載入";
    private static final String LOADINFO_EN = "Loading....";
    private static final String LOADINFO_ZH_CN = "加载中....";
    private static final String LOADINFO_ZH_TW = "載入中....";
    private static final String WEIBOBROWSER_NO_TITLE_EN = "No Title";
    private static final String WEIBOBROWSER_NO_TITLE_ZH_CN = "无标题";
    private static final String WEIBOBROWSER_NO_TITLE_ZH_TW = "無標題";
    private BaseWebViewRequestParam baseParam;
    private TextView leftBtn;
    private LoadingBar loadingBar;
    private int pageStatus = 0;
    private Button retryBtn;
    private LinearLayout retryLayout;
    private TextView retryTitle;
    private TextView titleText;
    private WebView webView;
    private BaseWebViewClient webViewClient;

    private class MyChromeClient extends WebChromeClient {
        private MyChromeClient() {
        }

        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            WeiboSdkWebActivity.this.loadingBar.drawProgress(i);
            if (i == 100) {
                WeiboSdkWebActivity.this.loadingBar.setVisibility(4);
            } else {
                WeiboSdkWebActivity.this.loadingBar.setVisibility(0);
            }
        }

        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (TextUtils.isEmpty(WeiboSdkWebActivity.this.baseParam.getBaseData().getSpecifyTitle()) != null) {
                WeiboSdkWebActivity.this.titleText.setText(str);
            }
        }
    }

    public void onPageStartedCallBack(WebView webView, String str, Bitmap bitmap) {
    }

    public boolean shouldOverrideUrlLoadingCallBack(WebView webView, String str) {
        return false;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(initView());
        initLoad();
    }

    private void initLoad() {
        Bundle extras = getIntent().getExtras();
        int i = extras.getInt("type", -1);
        if (i == -1) {
            finish();
            return;
        }
        switch (i) {
            case 0:
                this.baseParam = new DefaultWebViewRequestParam();
                this.webViewClient = new DefaultWebViewClient(this, this.baseParam);
                break;
            case 1:
                this.baseParam = new ShareWebViewRequestParam(this);
                this.webViewClient = new ShareWebViewClient(this, this, this.baseParam);
                break;
            case 2:
                this.baseParam = new AuthWebViewRequestParam();
                this.webViewClient = new AuthWebViewClient(this, this, this.baseParam);
                break;
            default:
                break;
        }
        this.webView.setWebViewClient(this.webViewClient);
        this.baseParam.transformBundle(extras);
        initWebView();
        if (this.baseParam.hasExtraTask()) {
            this.baseParam.doExtraTask(new ExtraTaskCallback() {
                public void onException(String str) {
                }

                public void onComplete(String str) {
                    WeiboSdkWebActivity.this.webView.loadUrl(WeiboSdkWebActivity.this.baseParam.getRequestUrl());
                }
            });
            return;
        }
        this.webView.loadUrl(this.baseParam.getRequestUrl());
    }

    private View initView() {
        View relativeLayout = new RelativeLayout(this);
        relativeLayout.setBackgroundColor(-1);
        View relativeLayout2 = new RelativeLayout(this);
        this.leftBtn = new TextView(this);
        this.leftBtn.setTextSize(17.0f);
        this.leftBtn.setTextColor(ResourceManager.createColorStateList(-32256, 1728020992));
        this.leftBtn.setText(ResourceManager.getString(this, CANCEL_EN, "关闭", "关闭"));
        this.leftBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                WeiboSdkWebActivity.this.webViewClient.closeWeb();
                WeiboSdkWebActivity.this.closeActivity();
            }
        });
        this.titleText = new TextView(this);
        this.titleText.setTextSize(18.0f);
        this.titleText.setTextColor(-11382190);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        this.leftBtn.setPadding(UIUtils.dip2px(10, this), 0, UIUtils.dip2px(10, this), 0);
        layoutParams2.addRule(13);
        relativeLayout2.addView(this.leftBtn, layoutParams);
        relativeLayout2.addView(this.titleText, layoutParams2);
        relativeLayout.addView(relativeLayout2, new RelativeLayout.LayoutParams(-1, UIUtils.dip2px(55, this)));
        this.webView = new WebView(this);
        LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams3.topMargin = UIUtils.dip2px(55, this);
        relativeLayout.addView(this.webView, layoutParams3);
        this.loadingBar = new LoadingBar(this);
        layoutParams3 = new RelativeLayout.LayoutParams(-1, UIUtils.dip2px(3, this));
        layoutParams3.topMargin = UIUtils.dip2px(55, this);
        relativeLayout.addView(this.loadingBar, layoutParams3);
        relativeLayout2 = new View(this);
        relativeLayout2.setBackgroundResource(getResources().getIdentifier("weibosdk_common_shadow_top", "drawable", getPackageName()));
        LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, UIUtils.dip2px(3, this));
        layoutParams4.topMargin = UIUtils.dip2px(55, this);
        relativeLayout.addView(relativeLayout2, layoutParams4);
        this.retryLayout = new LinearLayout(this);
        this.retryLayout.setOrientation(1);
        View imageView = new ImageView(this);
        imageView.setImageResource(getResources().getIdentifier("weibosdk_empty_failed", "drawable", getPackageName()));
        this.retryLayout.addView(imageView);
        this.retryTitle = new TextView(this);
        this.retryTitle.setTextSize(14.0f);
        this.retryTitle.setTextColor(-4342339);
        LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.topMargin = UIUtils.dip2px(18, this);
        layoutParams5.bottomMargin = UIUtils.dip2px(20, this);
        this.retryLayout.addView(this.retryTitle, layoutParams5);
        this.retryBtn = new Button(this);
        this.retryBtn.setTextSize(16.0f);
        this.retryBtn.setTextColor(-8882056);
        layoutParams5 = new LinearLayout.LayoutParams(UIUtils.dip2px(Opcodes.INT_TO_CHAR, this), UIUtils.dip2px(46, this));
        layoutParams5.gravity = 17;
        this.retryLayout.addView(this.retryBtn, layoutParams5);
        this.retryBtn.setBackgroundResource(getResources().getIdentifier("retry_btn_selector", "drawable", getPackageName()));
        layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(13);
        relativeLayout.addView(this.retryLayout, layoutParams5);
        this.retryLayout.setVisibility(8);
        this.webView.setWebChromeClient(new MyChromeClient());
        this.retryBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                WeiboSdkWebActivity.this.pageStatus = 0;
                WeiboSdkWebActivity.this.showDefaultPage();
                WeiboSdkWebActivity.this.webView.reload();
            }
        });
        this.retryTitle.setText(ResourceManager.getString(this, EMPTY_PROMPT_BAD_NETWORK_UI_EN, EMPTY_PROMPT_BAD_NETWORK_UI_ZH_CN, EMPTY_PROMPT_BAD_NETWORK_UI_ZH_TW));
        this.retryBtn.setText(ResourceManager.getString(this, CHANNEL_DATA_ERROR_EN, CHANNEL_DATA_ERROR_ZH_CN, CHANNEL_DATA_ERROR_ZH_TW));
        return relativeLayout;
    }

    private void initWebView() {
        if (!TextUtils.isEmpty(this.baseParam.getBaseData().getSpecifyTitle())) {
            this.titleText.setText(this.baseParam.getBaseData().getSpecifyTitle());
        }
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setSavePassword(false);
        this.webView.getSettings().setUserAgentString(WbUtils.generateUA(this, this.baseParam.getBaseData().getAuthInfo().getAppKey()));
        this.webView.requestFocus();
        this.webView.setScrollBarStyle(0);
        if (VERSION.SDK_INT >= 11) {
            this.webView.removeJavascriptInterface("searchBoxJavaBridge_");
        } else {
            removeJavascriptInterface(this.webView);
        }
    }

    private void closeActivity() {
        finish();
    }

    public void removeJavascriptInterface(android.webkit.WebView r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 11;
        if (r0 >= r1) goto L_0x001b;
    L_0x0006:
        r4 = r4.getClass();	 Catch:{ Exception -> 0x001b }
        r0 = "removeJavascriptInterface";	 Catch:{ Exception -> 0x001b }
        r1 = 0;	 Catch:{ Exception -> 0x001b }
        r2 = new java.lang.Class[r1];	 Catch:{ Exception -> 0x001b }
        r4 = r4.getDeclaredMethod(r0, r2);	 Catch:{ Exception -> 0x001b }
        r0 = "searchBoxJavaBridge_";	 Catch:{ Exception -> 0x001b }
        r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x001b }
        r4.invoke(r0, r1);	 Catch:{ Exception -> 0x001b }
        return;
    L_0x001b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.web.WeiboSdkWebActivity.removeJavascriptInterface(android.webkit.WebView):void");
    }

    private void showErrorPage() {
        this.retryLayout.setVisibility(0);
        this.webView.setVisibility(8);
    }

    private void showDefaultPage() {
        this.retryLayout.setVisibility(8);
        this.webView.setVisibility(0);
    }

    public void onPageFinishedCallBack(WebView webView, String str) {
        if (this.pageStatus == -1) {
            showErrorPage();
        } else {
            showDefaultPage();
        }
    }

    public void onReceivedErrorCallBack(android.webkit.WebView r1, int r2, java.lang.String r3, java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = this;
        r1 = r1.getUrl();
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x0038 }
        if (r2 != 0) goto L_0x0037;	 Catch:{ Exception -> 0x0038 }
    L_0x000a:
        r2 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Exception -> 0x0038 }
        if (r2 != 0) goto L_0x0037;	 Catch:{ Exception -> 0x0038 }
    L_0x0010:
        r1 = android.net.Uri.parse(r1);	 Catch:{ Exception -> 0x0038 }
        r2 = android.net.Uri.parse(r4);	 Catch:{ Exception -> 0x0038 }
        r3 = r1.getHost();	 Catch:{ Exception -> 0x0038 }
        r4 = r2.getHost();	 Catch:{ Exception -> 0x0038 }
        r3 = r3.equals(r4);	 Catch:{ Exception -> 0x0038 }
        if (r3 == 0) goto L_0x0037;	 Catch:{ Exception -> 0x0038 }
    L_0x0026:
        r1 = r1.getScheme();	 Catch:{ Exception -> 0x0038 }
        r2 = r2.getScheme();	 Catch:{ Exception -> 0x0038 }
        r1 = r1.equals(r2);	 Catch:{ Exception -> 0x0038 }
        if (r1 == 0) goto L_0x0037;	 Catch:{ Exception -> 0x0038 }
    L_0x0034:
        r1 = -1;	 Catch:{ Exception -> 0x0038 }
        r0.pageStatus = r1;	 Catch:{ Exception -> 0x0038 }
    L_0x0037:
        return;
    L_0x0038:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.web.WeiboSdkWebActivity.onReceivedErrorCallBack(android.webkit.WebView, int, java.lang.String, java.lang.String):void");
    }

    public void onReceivedSslErrorCallBack(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
        webView = new Builder(this);
        webView.setTitle("警告");
        webView.setMessage("你访问的连接可能存在隐患，是否继续访问");
        webView.setPositiveButton("继续", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                sslErrorHandler.proceed();
            }
        });
        webView.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                sslErrorHandler.cancel();
            }
        });
        webView.create().show();
    }

    public void closePage() {
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.webViewClient.onBackKeyDown()) {
                return true;
            }
            if (this.webView.canGoBack()) {
                this.webView.goBack();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }
}
