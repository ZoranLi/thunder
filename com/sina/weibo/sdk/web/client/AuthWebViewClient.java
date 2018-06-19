package com.sina.weibo.sdk.web.client;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.auth.WbConnectErrorMessage;
import com.sina.weibo.sdk.utils.Utility;
import com.sina.weibo.sdk.web.WebViewRequestCallback;
import com.sina.weibo.sdk.web.WeiboCallbackManager;
import com.sina.weibo.sdk.web.WeiboSdkWebActivity;
import com.sina.weibo.sdk.web.param.BaseWebViewRequestParam;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;

public class AuthWebViewClient extends BaseWebViewClient {
    private boolean authed = null;
    private Context context;

    public AuthWebViewClient(WebViewRequestCallback webViewRequestCallback, Context context, BaseWebViewRequestParam baseWebViewRequestParam) {
        super(webViewRequestCallback, baseWebViewRequestParam);
        this.context = context;
    }

    @TargetApi(24)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return needOverLoad(webResourceRequest.getUrl().toString());
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (this.requestCallback != null) {
            this.requestCallback.shouldOverrideUrlLoadingCallBack(webView, str);
        }
        return needOverLoad(str);
    }

    private boolean needOverLoad(String str) {
        if (str.startsWith("sms:")) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.putExtra("address", str.replace("sms:", ""));
            intent.setType("vnd.android-dir/mms-sms");
            this.context.startActivity(intent);
            return true;
        } else if (str.startsWith(WeiboSdkWebActivity.BROWSER_CLOSE_SCHEME) == null) {
            return null;
        } else {
            if (this.param.getBaseData() != null && TextUtils.isEmpty(this.param.getBaseData().getCallback()) == null) {
                str = this.param.getBaseData().getCallback();
                WeiboCallbackManager instance = WeiboCallbackManager.getInstance();
                if (instance.getWeiboAuthListener(str) != null) {
                    instance.getWeiboAuthListener(str).cancel();
                }
                instance.removeWeiboAuthListener(str);
            }
            return true;
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.requestCallback != null) {
            this.requestCallback.onPageStartedCallBack(webView, str, bitmap);
        }
        if (!str.startsWith(this.param.getBaseData().getAuthInfo().getRedirectUrl()) || this.authed) {
            super.onPageStarted(webView, str, bitmap);
            return;
        }
        this.authed = true;
        handleRedirectUrl(str);
        webView.stopLoading();
        if (this.requestCallback != null) {
            this.requestCallback.closePage();
        }
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (this.requestCallback != null) {
            this.requestCallback.onPageFinishedCallBack(webView, str);
        }
    }

    @RequiresApi(api = 23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (this.requestCallback != null) {
            this.requestCallback.onReceivedErrorCallBack(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        if (this.requestCallback != null) {
            this.requestCallback.onReceivedErrorCallBack(webView, i, str, str2);
        }
    }

    private void handleRedirectUrl(String str) {
        WbAuthListener wbAuthListener;
        Bundle parseUrl = Utility.parseUrl(str);
        String string = parseUrl.getString("error");
        String string2 = parseUrl.getString("error_code");
        String string3 = parseUrl.getString(XiaomiOAuthConstants.EXTRA_ERROR_DESCRIPTION_2);
        if (this.param.getBaseData() == null || TextUtils.isEmpty(this.param.getBaseData().getCallback())) {
            wbAuthListener = null;
        } else {
            String callback = this.param.getBaseData().getCallback();
            WeiboCallbackManager instance = WeiboCallbackManager.getInstance();
            wbAuthListener = instance.getWeiboAuthListener(callback);
            instance.removeWeiboAuthListener(callback);
        }
        if (string == null && string2 == null) {
            if (wbAuthListener != null) {
                str = Oauth2AccessToken.parseAccessToken(parseUrl);
                AccessTokenKeeper.writeAccessToken(this.context, str);
                wbAuthListener.onSuccess(str);
            }
        } else if (wbAuthListener != null) {
            wbAuthListener.onFailure(new WbConnectErrorMessage(string2, string3));
        }
    }

    public void closeWeb() {
        super.closeWeb();
        if (this.param.getBaseData() != null && !TextUtils.isEmpty(this.param.getBaseData().getCallback())) {
            String callback = this.param.getBaseData().getCallback();
            WeiboCallbackManager instance = WeiboCallbackManager.getInstance();
            if (instance.getWeiboAuthListener(callback) != null) {
                instance.getWeiboAuthListener(callback).cancel();
            }
            instance.removeWeiboAuthListener(callback);
        }
    }

    public boolean onBackKeyDown() {
        closeWeb();
        if (this.requestCallback != null) {
            this.requestCallback.closePage();
        }
        return true;
    }
}
