package com.umeng.socialize.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.common.ResContainer;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;

public abstract class BaseDialog extends Dialog {
    public final ResContainer R;
    public Activity mActivity;
    public View mContent;
    public Context mContext;
    public int mFlag = 0;
    public Handler mHandler = new Handler(this) {
        final /* synthetic */ BaseDialog a;

        {
            this.a = r1;
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1 && this.a.mProgressbar != null) {
                this.a.mProgressbar.setVisibility(8);
            }
            message = message.what;
        }
    };
    public SHARE_MEDIA mPlatform;
    public View mProgressbar;
    public Bundle mValues;
    public String mWaitUrl = "error";
    public WebView mWebView;
    public TextView titleMidTv;

    public abstract void setClient(WebView webView);

    public BaseDialog(Activity activity, SHARE_MEDIA share_media) {
        super(activity, ResContainer.get(activity).style("umeng_socialize_popup_dialog"));
        this.mContext = activity.getApplicationContext();
        this.R = ResContainer.get(this.mContext);
        this.mActivity = activity;
        this.mPlatform = share_media;
    }

    public void setWaitUrl(String str) {
        this.mWaitUrl = str;
    }

    public void initViews() {
        setOwnerActivity(this.mActivity);
        LayoutInflater layoutInflater = (LayoutInflater) this.mActivity.getSystemService("layout_inflater");
        int layout = this.R.layout("umeng_socialize_oauth_dialog");
        int id = this.R.id("umeng_socialize_follow");
        String str = null;
        this.mContent = layoutInflater.inflate(layout, null);
        final View findViewById = this.mContent.findViewById(id);
        findViewById.setVisibility(8);
        layout = this.R.id("progress_bar_parent");
        id = this.R.id("umeng_back");
        int id2 = this.R.id("umeng_share_btn");
        int id3 = this.R.id("umeng_title");
        int id4 = this.R.id("umeng_socialize_titlebar");
        this.mProgressbar = this.mContent.findViewById(layout);
        this.mProgressbar.setVisibility(0);
        ((RelativeLayout) this.mContent.findViewById(id)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BaseDialog a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.dismiss();
            }
        });
        this.mContent.findViewById(id2).setVisibility(8);
        this.titleMidTv = (TextView) this.mContent.findViewById(id3);
        if (this.mPlatform.toString().equals("SINA")) {
            str = UmengText.SINA;
        } else if (this.mPlatform.toString().equals("RENREN")) {
            str = UmengText.RENREN;
        } else if (this.mPlatform.toString().equals("DOUBAN")) {
            str = UmengText.DOUBAN;
        } else if (this.mPlatform.toString().equals("TENCENT")) {
            str = UmengText.TENCENT;
        }
        TextView textView = this.titleMidTv;
        StringBuilder stringBuilder = new StringBuilder("授权");
        stringBuilder.append(str);
        textView.setText(stringBuilder.toString());
        setUpWebView();
        final View findViewById2 = this.mContent.findViewById(id4);
        final int dip2Px = SocializeUtils.dip2Px(this.mContext, 200.0f);
        View anonymousClass3 = new FrameLayout(this, this.mContext) {
            final /* synthetic */ BaseDialog d;

            protected void onSizeChanged(int i, int i2, int i3, int i4) {
                super.onSizeChanged(i, i2, i3, i4);
                if (SocializeUtils.isFloatWindowStyle(this.d.mContext) == 0) {
                    a(findViewById, findViewById2, dip2Px, i2);
                }
            }

            private void a(final View view, final View view2, int i, int i2) {
                if (view2.getVisibility() != 0 || i2 >= i) {
                    if (view2.getVisibility() != null && i2 >= i) {
                        this.d.mHandler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass3 b;

                            public void run() {
                                view2.setVisibility(0);
                                this.b.requestLayout();
                            }
                        });
                    }
                    return;
                }
                this.d.mHandler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 c;

                    public void run() {
                        view2.setVisibility(8);
                        if (view.getVisibility() == 0) {
                            view.setVisibility(8);
                        }
                        this.c.requestLayout();
                    }
                });
            }
        };
        anonymousClass3.addView(this.mContent, -1, -1);
        setContentView(anonymousClass3);
        LayoutParams attributes = getWindow().getAttributes();
        if (SocializeUtils.isFloatWindowStyle(this.mContext)) {
            int[] floatWindowSize = SocializeUtils.getFloatWindowSize(this.mContext);
            attributes.width = floatWindowSize[0];
            attributes.height = floatWindowSize[1];
        } else {
            attributes.height = -1;
            attributes.width = -1;
        }
        attributes.gravity = 17;
    }

    public boolean setUpWebView() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = r7.mContent;
        r1 = r7.R;
        r2 = "webView";
        r1 = r1.id(r2);
        r0 = r0.findViewById(r1);
        r0 = (android.webkit.WebView) r0;
        r7.mWebView = r0;
        r0 = r7.mWebView;
        r7.setClient(r0);
        r0 = r7.mWebView;
        r0.requestFocusFromTouch();
        r0 = r7.mWebView;
        r1 = 0;
        r0.setVerticalScrollBarEnabled(r1);
        r0 = r7.mWebView;
        r0.setHorizontalScrollBarEnabled(r1);
        r0 = r7.mWebView;
        r0.setScrollBarStyle(r1);
        r0 = r7.mWebView;
        r0 = r0.getSettings();
        r2 = 2;
        r0.setCacheMode(r2);
        r0 = r7.mWebView;
        r2 = -1;
        r0.setBackgroundColor(r2);
        r0 = android.os.Build.VERSION.SDK_INT;
        r2 = 11;
        if (r0 < r2) goto L_0x0057;
    L_0x0042:
        r0 = r7.mWebView;
        r3 = "searchBoxJavaBridge_";
        r0.removeJavascriptInterface(r3);
        r0 = r7.mWebView;
        r3 = "accessibility";
        r0.removeJavascriptInterface(r3);
        r0 = r7.mWebView;
        r3 = "accessibilityTraversal";
        r0.removeJavascriptInterface(r3);
    L_0x0057:
        r0 = r7.mWebView;
        r0 = r0.getSettings();
        r3 = 1;
        r0.setJavaScriptEnabled(r3);
        r4 = android.os.Build.VERSION.SDK_INT;
        r5 = 8;
        if (r4 < r5) goto L_0x006c;
    L_0x0067:
        r4 = android.webkit.WebSettings.PluginState.ON;
        r0.setPluginState(r4);
    L_0x006c:
        r0.setSupportZoom(r3);
        r0.setBuiltInZoomControls(r3);
        r0.setAllowFileAccess(r3);
        r4 = android.webkit.WebSettings.LayoutAlgorithm.NORMAL;
        r0.setLayoutAlgorithm(r4);
        r0.setUseWideViewPort(r3);
        r4 = android.os.Build.VERSION.SDK_INT;
        if (r4 < r5) goto L_0x0090;
    L_0x0081:
        r0.setLoadWithOverviewMode(r3);
        r0.setDatabaseEnabled(r3);
        r0.setDomStorageEnabled(r3);
        r0.setGeolocationEnabled(r3);
        r0.setAppCacheEnabled(r3);
    L_0x0090:
        r4 = android.os.Build.VERSION.SDK_INT;
        if (r4 < r2) goto L_0x00b9;
    L_0x0094:
        r2 = android.webkit.WebSettings.class;	 Catch:{ Exception -> 0x00b1 }
        r4 = "setDisplayZoomControls";	 Catch:{ Exception -> 0x00b1 }
        r5 = new java.lang.Class[r3];	 Catch:{ Exception -> 0x00b1 }
        r6 = java.lang.Boolean.TYPE;	 Catch:{ Exception -> 0x00b1 }
        r5[r1] = r6;	 Catch:{ Exception -> 0x00b1 }
        r2 = r2.getDeclaredMethod(r4, r5);	 Catch:{ Exception -> 0x00b1 }
        r2.setAccessible(r3);	 Catch:{ Exception -> 0x00b1 }
        r4 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x00b1 }
        r5 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x00b1 }
        r4[r1] = r5;	 Catch:{ Exception -> 0x00b1 }
        r2.invoke(r0, r4);	 Catch:{ Exception -> 0x00b1 }
        goto L_0x00b9;
    L_0x00b1:
        r0 = move-exception;
        r0 = r0.getMessage();
        com.umeng.socialize.utils.Log.um(r0);
    L_0x00b9:
        r0 = r7.mPlatform;	 Catch:{ Exception -> 0x00cb }
        r1 = com.umeng.socialize.bean.SHARE_MEDIA.RENREN;	 Catch:{ Exception -> 0x00cb }
        if (r0 != r1) goto L_0x00cb;	 Catch:{ Exception -> 0x00cb }
    L_0x00bf:
        r0 = r7.mContext;	 Catch:{ Exception -> 0x00cb }
        android.webkit.CookieSyncManager.createInstance(r0);	 Catch:{ Exception -> 0x00cb }
        r0 = android.webkit.CookieManager.getInstance();	 Catch:{ Exception -> 0x00cb }
        r0.removeAllCookie();	 Catch:{ Exception -> 0x00cb }
    L_0x00cb:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.view.BaseDialog.setUpWebView():boolean");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    public void releaseWebView() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.mWebView;	 Catch:{ Exception -> 0x000d }
        r0 = r0.getParent();	 Catch:{ Exception -> 0x000d }
        r0 = (android.view.ViewGroup) r0;	 Catch:{ Exception -> 0x000d }
        r1 = r2.mWebView;	 Catch:{ Exception -> 0x000d }
        r0.removeView(r1);	 Catch:{ Exception -> 0x000d }
    L_0x000d:
        r0 = r2.mWebView;	 Catch:{ Exception -> 0x0012 }
        r0.removeAllViews();	 Catch:{ Exception -> 0x0012 }
    L_0x0012:
        r0 = 0;
        r2.mWebView = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.view.BaseDialog.releaseWebView():void");
    }
}
