package com.alibaba.sdk.android.feedback.windvane;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.TextView;
import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;
import com.alibaba.sdk.android.feedback.xblink.webview.HybridWebViewClient;

public class CustomHybirdWebViewClient extends HybridWebViewClient {
    private static final String TAG = "CustomHybirdWebViewClient";
    private static final String[] sDomainWhiteList = new String[]{"chat.etao.com", "amos.alicdn.com", "mobileim.etao.com", "chat.im.daily.taobao.net", "interface.im.daily.taobao.net", "tcms-openim.wangxin.taobao.com", "m.taobao.com", "taobao.com"};
    private boolean isDestroyed;
    private String mUrl;
    private d pageFinishCallback;
    private int reLoginTime = 0;
    private TextView title;

    public CustomHybirdWebViewClient(Context context) {
        super(context);
    }

    private void loadSuccess(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    public void PageFinishCallback(d dVar) {
        this.pageFinishCallback = dVar;
    }

    public void onPageFinished(WebView webView, String str) {
        if (this.pageFinishCallback != null) {
            this.pageFinishCallback.a();
        }
        if (this.title != null && TextUtils.isEmpty(this.title.getText())) {
            TextView textView;
            CharSequence charSequence;
            if (FeedbackAPI.mUICustomInfo.containsKey("pageTitle")) {
                textView = this.title;
                charSequence = (CharSequence) FeedbackAPI.mUICustomInfo.get("pageTitle");
            } else {
                textView = this.title;
                charSequence = webView.getTitle();
            }
            textView.setText(charSequence);
        }
        loadSuccess(webView, str);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    public void setDestroyed(boolean z) {
        this.isDestroyed = z;
    }

    public void setPageFinishCallback(d dVar) {
        this.pageFinishCallback = dVar;
    }

    public void setTitle(TextView textView) {
        this.title = textView;
    }

    public void setmUrl(String str) {
        this.mUrl = str;
    }

    public boolean shouldOverrideUrlLoading(android.webkit.WebView r4, java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r4 = com.alibaba.sdk.android.feedback.xblink.i.g.a();
        if (r4 == 0) goto L_0x0019;
    L_0x0006:
        r4 = TAG;
        r0 = new java.lang.StringBuilder;
        r1 = "shouldOverrideUrlLoading: ";
        r0.<init>(r1);
        r0.append(r5);
        r0 = r0.toString();
        com.alibaba.sdk.android.feedback.xblink.i.g.d(r4, r0);
    L_0x0019:
        r4 = android.text.TextUtils.isEmpty(r5);
        r0 = 1;
        if (r4 != 0) goto L_0x0062;
    L_0x0020:
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x004f }
        r4.<init>();	 Catch:{ Exception -> 0x004f }
        r4.append(r5);	 Catch:{ Exception -> 0x004f }
        r1 = " testing Url";	 Catch:{ Exception -> 0x004f }
        r4.append(r1);	 Catch:{ Exception -> 0x004f }
        r4 = com.alibaba.sdk.android.feedback.util.o.a(r5);	 Catch:{ Exception -> 0x004f }
        if (r4 == 0) goto L_0x0035;	 Catch:{ Exception -> 0x004f }
    L_0x0033:
        r4 = 0;	 Catch:{ Exception -> 0x004f }
        return r4;	 Catch:{ Exception -> 0x004f }
    L_0x0035:
        r4 = new android.content.Intent;	 Catch:{ Exception -> 0x004f }
        r1 = "android.intent.action.VIEW";	 Catch:{ Exception -> 0x004f }
        r2 = android.net.Uri.parse(r5);	 Catch:{ Exception -> 0x004f }
        r4.<init>(r1, r2);	 Catch:{ Exception -> 0x004f }
        r1 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;	 Catch:{ Exception -> 0x004f }
        r4.setFlags(r1);	 Catch:{ Exception -> 0x004f }
        r1 = r3.mContext;	 Catch:{ Exception -> 0x004f }
        if (r1 == 0) goto L_0x004e;	 Catch:{ Exception -> 0x004f }
    L_0x0049:
        r1 = r3.mContext;	 Catch:{ Exception -> 0x004f }
        r1.startActivity(r4);	 Catch:{ Exception -> 0x004f }
    L_0x004e:
        return r0;
    L_0x004f:
        r4 = TAG;
        r1 = new java.lang.StringBuilder;
        r2 = "shouldOverrideUrlLoading: uri parse error, url=";
        r1.<init>(r2);
        r1.append(r5);
        r5 = r1.toString();
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r4, r5);
    L_0x0062:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.windvane.CustomHybirdWebViewClient.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
    }
}
