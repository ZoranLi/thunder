package com.sina.weibo.sdk.web.client;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.sina.weibo.sdk.utils.WbUtils;
import com.sina.weibo.sdk.web.WebViewRequestCallback;
import com.sina.weibo.sdk.web.WeiboCallbackManager;
import com.sina.weibo.sdk.web.WeiboSdkWebActivity;
import com.sina.weibo.sdk.web.param.BaseWebViewRequestParam;

public class ShareWebViewClient extends BaseWebViewClient {
    private static final String RESP_PARAM_CODE = "code";
    private static final String RESP_PARAM_MSG = "msg";
    private static final String RESP_SUCC_CODE = "0";
    private Activity activity;
    private boolean hasCallbacked = null;

    public ShareWebViewClient(Activity activity, WebViewRequestCallback webViewRequestCallback, BaseWebViewRequestParam baseWebViewRequestParam) {
        super(webViewRequestCallback, baseWebViewRequestParam);
        this.activity = activity;
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (this.requestCallback != null) {
            this.requestCallback.onPageStartedCallBack(webView, str, bitmap);
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
        if (!str.startsWith(WeiboSdkWebActivity.BROWSER_CLOSE_SCHEME)) {
            return null;
        }
        str = WbUtils.parseUri(str);
        if (!(this.param.getBaseData() == null || TextUtils.isEmpty(this.param.getBaseData().getCallback()))) {
            String callback = this.param.getBaseData().getCallback();
            WeiboCallbackManager instance = WeiboCallbackManager.getInstance();
            if (!(instance.getWeiboAuthListener(callback) == null || str.isEmpty())) {
                instance.removeWeiboAuthListener(callback);
            }
        }
        CharSequence string = str.getString("code");
        str = str.getString("msg");
        if (TextUtils.isEmpty(string)) {
            sendSdkCancleResponse(this.activity);
        } else if ("0".equals(string)) {
            sendSdkOkResponse(this.activity);
        } else {
            sendSdkErrorResponse(this.activity, str);
        }
        if (this.requestCallback != null) {
            this.requestCallback.closePage();
        }
        return true;
    }

    private void sendSdkResponse(android.app.Activity r5, int r6, java.lang.String r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r5.getIntent();
        r0 = r0.getExtras();
        if (r0 == 0) goto L_0x0043;
    L_0x000a:
        r1 = r4.hasCallbacked;
        if (r1 == 0) goto L_0x000f;
    L_0x000e:
        goto L_0x0043;
    L_0x000f:
        r1 = new android.content.Intent;
        r2 = "com.sina.weibo.sdk.action.ACTION_SDK_REQ_ACTIVITY";
        r1.<init>(r2);
        r2 = "packageName";
        r2 = r0.getString(r2);
        r3 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        r1.setFlags(r3);
        r1.setPackage(r2);
        r1.putExtras(r0);
        r0 = "_weibo_appPackage";
        r2 = r5.getPackageName();
        r1.putExtra(r0, r2);
        r0 = "_weibo_resp_errcode";
        r1.putExtra(r0, r6);
        r6 = "_weibo_resp_errstr";
        r1.putExtra(r6, r7);
        r6 = 765; // 0x2fd float:1.072E-42 double:3.78E-321;
        r5.startActivityForResult(r1, r6);	 Catch:{ ActivityNotFoundException -> 0x003f }
    L_0x003f:
        r5 = 1;
        r4.hasCallbacked = r5;
        return;
    L_0x0043:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.web.client.ShareWebViewClient.sendSdkResponse(android.app.Activity, int, java.lang.String):void");
    }

    public void sendSdkCancleResponse(Activity activity) {
        sendSdkResponse(activity, 1, "send cancel!!!");
    }

    public void sendSdkOkResponse(Activity activity) {
        sendSdkResponse(activity, 0, "send ok!!!");
    }

    public void sendSdkErrorResponse(Activity activity, String str) {
        sendSdkResponse(activity, 2, str);
    }

    public void closeWeb() {
        super.closeWeb();
        sendSdkCancleResponse(this.activity);
    }

    public boolean onBackKeyDown() {
        closeWeb();
        if (this.requestCallback != null) {
            this.requestCallback.closePage();
        }
        return true;
    }
}
