package com.alibaba.sdk.android.feedback.xblink.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.alibaba.sdk.android.feedback.xblink.e.a;
import com.alibaba.sdk.android.feedback.xblink.i.b;
import com.alibaba.sdk.android.feedback.xblink.i.h;
import com.alibaba.sdk.android.feedback.xblink.webview.XBHybridViewController;
import com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView;
import com.alibaba.sdk.android.feedback.xblink.webview.j;

public abstract class XBBaseHybridActivity extends Activity implements Callback {
    private String TAG = "XBBaseHybridActivity";
    private String appkey;
    private BroadcastReceiver h5PushReceiver = new a(this);
    private String jsCallbackPath = "";
    private boolean jsControlled = false;
    protected Handler mHandler;
    BroadcastReceiver mHomeKeyEventReceiver;
    protected String mUrl;
    protected XBHybridViewController mViewController;
    protected XBHybridWebView mWebView;
    protected byte[] postData = null;
    protected String url = null;

    private void registHomeKeyEventBroadCast() {
        if (this.mHomeKeyEventReceiver == null) {
            this.mHomeKeyEventReceiver = new b(this);
        }
        LocalBroadcastManager.getInstance(this).registerReceiver(this.mHomeKeyEventReceiver, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
    }

    private void unregistHomeKeyEventBroadCast() {
        if (this.mHomeKeyEventReceiver != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mHomeKeyEventReceiver);
            this.mHomeKeyEventReceiver = null;
        }
    }

    public a createFilter() {
        return null;
    }

    protected String getAppkey() {
        return null;
    }

    public boolean handleMessage(Message message) {
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.mWebView != null) {
            this.mWebView.onActivityResult(i, i2, intent);
        }
    }

    public void onBackPressed() {
        if (this.jsControlled) {
            StringBuilder stringBuilder = new StringBuilder("javascript:");
            stringBuilder.append(this.jsCallbackPath);
            this.mWebView.loadUrl(stringBuilder.toString());
            return;
        }
        super.onBackPressed();
    }

    public void onBroadcast(com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView r5, java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r4 = this;
        r0 = "javascript:window.WindVane.fireEvent('%s', '%s');";
        r1 = 2;
        r1 = new java.lang.Object[r1];
        r2 = "WXCommunication.onBroadcast";
        r3 = 0;
        r1[r3] = r2;
        r2 = 1;
        r1[r2] = r6;
        r6 = java.lang.String.format(r0, r1);
        if (r5 == 0) goto L_0x0016;
    L_0x0013:
        r5.loadUrl(r6);	 Catch:{ Exception -> 0x0016 }
    L_0x0016:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.activity.XBBaseHybridActivity.onBroadcast(com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView, java.lang.String):void");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        j jVar = (j) intent.getParcelableExtra("PARAMS");
        this.url = intent.getStringExtra("URL");
        this.mUrl = this.url;
        this.postData = intent.getByteArrayExtra("DATA");
        this.appkey = getAppkey();
        if (TextUtils.isEmpty(this.appkey)) {
            this.appkey = getIntent().getStringExtra("APPKEY");
        }
        if (TextUtils.isEmpty(this.appkey)) {
            this.appkey = b.a(h.b(this.url));
        }
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        this.mViewController = new XBHybridViewController(this);
        this.mViewController.init(jVar);
        this.mViewController.setUrlFilter(createFilter());
        this.mWebView = this.mViewController.getWebview();
        this.mWebView.setAppkey(this.appkey);
        this.mWebView.setCurrentUrl(this.url);
        registHomeKeyEventBroadCast();
    }

    public void onDestroy() {
        this.mViewController.destroy();
        this.mViewController = null;
        unregistHomeKeyEventBroadCast();
        super.onDestroy();
    }

    @SuppressLint({"NewApi"})
    protected void onPause() {
        if (this.mWebView != null) {
            this.mWebView.onPause();
        }
        super.onPause();
    }

    @SuppressLint({"NewApi"})
    protected void onResume() {
        if (this.mWebView != null) {
            this.mWebView.onResume();
        }
        super.onResume();
    }

    public void setJSControlledBackPress(boolean z, String str) {
        this.jsControlled = z;
        this.jsCallbackPath = str;
    }
}
