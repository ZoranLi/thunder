package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.alipay.sdk.util.h;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.FindListener;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.sdk.a.b;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.e;
import com.tencent.smtt.utils.k;
import com.tencent.smtt.utils.v;
import com.tencent.smtt.utils.y;
import com.xunlei.analytics.c.d;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.channels.FileLock;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.android.agoo.common.AgooConstants;

public class WebView extends FrameLayout implements OnLongClickListener {
    public static final int GETPVERROR = -1;
    public static int NIGHT_MODE_ALPHA = 153;
    public static final int NIGHT_MODE_COLOR = -16777216;
    public static final int NORMAL_MODE_ALPHA = 255;
    public static final String SCHEME_GEO = "geo:0,0?q=";
    public static final String SCHEME_MAILTO = "mailto:";
    public static final String SCHEME_TEL = "tel:";
    private static final Lock c = new ReentrantLock();
    private static OutputStream d = null;
    private static Context j = null;
    private static y l = null;
    private static Method m = null;
    public static boolean mSysWebviewCreated = false;
    private static String p = null;
    private static Paint v = null;
    private static boolean w = true;
    int a;
    private final String b;
    private boolean e;
    private IX5WebViewBase f;
    private a g;
    private WebSettings h;
    private Context i;
    private boolean k;
    public WebViewCallbackClient mWebViewCallbackClient;
    private WebViewClient n;
    private WebChromeClient o;
    private final int q;
    private final int r;
    private final int s;
    private final String t;
    private final String u;
    private Object x;
    private OnLongClickListener y;

    public static class HitTestResult {
        @Deprecated
        public static final int ANCHOR_TYPE = 1;
        public static final int EDIT_TEXT_TYPE = 9;
        public static final int EMAIL_TYPE = 4;
        public static final int GEO_TYPE = 3;
        @Deprecated
        public static final int IMAGE_ANCHOR_TYPE = 6;
        public static final int IMAGE_TYPE = 5;
        public static final int PHONE_TYPE = 2;
        public static final int SRC_ANCHOR_TYPE = 7;
        public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
        public static final int UNKNOWN_TYPE = 0;
        private com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult a;
        private android.webkit.WebView.HitTestResult b;

        public HitTestResult() {
            this.b = null;
            this.a = null;
            this.b = null;
        }

        public HitTestResult(android.webkit.WebView.HitTestResult hitTestResult) {
            this.b = null;
            this.a = null;
            this.b = hitTestResult;
        }

        public HitTestResult(com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult hitTestResult) {
            this.b = null;
            this.a = hitTestResult;
            this.b = null;
        }

        public String getExtra() {
            String str = "";
            if (this.a != null) {
                return this.a.getExtra();
            }
            if (this.b != null) {
                str = this.b.getExtra();
            }
            return str;
        }

        public int getType() {
            return this.a != null ? this.a.getType() : this.b != null ? this.b.getType() : 0;
        }
    }

    public interface PictureListener {
        void onNewPicture(WebView webView, Picture picture);
    }

    public class WebViewTransport {
        final /* synthetic */ WebView a;
        private WebView b;

        public WebViewTransport(WebView webView) {
            this.a = webView;
        }

        public synchronized WebView getWebView() {
            return this.b;
        }

        public synchronized void setWebView(WebView webView) {
            this.b = webView;
        }
    }

    private class a extends android.webkit.WebView {
        final /* synthetic */ WebView a;

        public a(WebView webView, Context context) {
            this(webView, context, null);
        }

        public a(com.tencent.smtt.sdk.WebView r2, android.content.Context r3, android.util.AttributeSet r4) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r1 = this;
            r1.a = r2;
            r1.<init>(r3, r4);
            r4 = com.tencent.smtt.sdk.QbSdk.getIsSysWebViewForcedByOuter();
            if (r4 == 0) goto L_0x0011;
        L_0x000b:
            r3 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r3);
            if (r3 != 0) goto L_0x004a;
        L_0x0011:
            r2 = r2.i;
            r2 = com.tencent.smtt.sdk.CookieSyncManager.createInstance(r2);
            r2.startSync();
            r2 = "android.webkit.WebViewWorker";	 Catch:{ Exception -> 0x004a }
            r2 = java.lang.Class.forName(r2);	 Catch:{ Exception -> 0x004a }
            r3 = "getHandler";	 Catch:{ Exception -> 0x004a }
            r4 = 0;	 Catch:{ Exception -> 0x004a }
            r0 = new java.lang.Class[r4];	 Catch:{ Exception -> 0x004a }
            r2 = r2.getDeclaredMethod(r3, r0);	 Catch:{ Exception -> 0x004a }
            r3 = 1;	 Catch:{ Exception -> 0x004a }
            r2.setAccessible(r3);	 Catch:{ Exception -> 0x004a }
            r0 = 0;	 Catch:{ Exception -> 0x004a }
            r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x004a }
            r2 = r2.invoke(r0, r4);	 Catch:{ Exception -> 0x004a }
            r2 = (android.os.Handler) r2;	 Catch:{ Exception -> 0x004a }
            r2 = r2.getLooper();	 Catch:{ Exception -> 0x004a }
            r2 = r2.getThread();	 Catch:{ Exception -> 0x004a }
            r4 = new com.tencent.smtt.sdk.m;	 Catch:{ Exception -> 0x004a }
            r4.<init>();	 Catch:{ Exception -> 0x004a }
            r2.setUncaughtExceptionHandler(r4);	 Catch:{ Exception -> 0x004a }
            com.tencent.smtt.sdk.WebView.mSysWebviewCreated = r3;	 Catch:{ Exception -> 0x004a }
        L_0x004a:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebView.a.<init>(com.tencent.smtt.sdk.WebView, android.content.Context, android.util.AttributeSet):void");
        }

        public void a() {
            super.computeScroll();
        }

        public void a(int i, int i2, int i3, int i4) {
            super.onScrollChanged(i, i2, i3, i4);
        }

        @TargetApi(9)
        public void a(int i, int i2, boolean z, boolean z2) {
            if (VERSION.SDK_INT >= 9) {
                super.onOverScrolled(i, i2, z, z2);
            }
        }

        @TargetApi(9)
        public boolean a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            return VERSION.SDK_INT >= 9 ? super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z) : false;
        }

        public boolean a(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public boolean b(MotionEvent motionEvent) {
            return super.dispatchTouchEvent(motionEvent);
        }

        public boolean c(MotionEvent motionEvent) {
            return super.onInterceptTouchEvent(motionEvent);
        }

        public void computeScroll() {
            if (this.a.mWebViewCallbackClient != null) {
                this.a.mWebViewCallbackClient.computeScroll(this);
            } else {
                super.computeScroll();
            }
        }

        protected void dispatchDraw(Canvas canvas) {
            try {
                super.dispatchDraw(canvas);
                if (!(WebView.w || WebView.v == null)) {
                    canvas.save();
                    canvas.drawPaint(WebView.v);
                    canvas.restore();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return this.a.mWebViewCallbackClient != null ? this.a.mWebViewCallbackClient.dispatchTouchEvent(motionEvent, this) : super.dispatchTouchEvent(motionEvent);
        }

        public WebSettings getSettings() {
            try {
                return super.getSettings();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public void invalidate() {
            super.invalidate();
            if (this.a.mWebViewCallbackClient != null) {
                this.a.mWebViewCallbackClient.invalidate();
            }
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return this.a.mWebViewCallbackClient != null ? this.a.mWebViewCallbackClient.onInterceptTouchEvent(motionEvent, this) : super.onInterceptTouchEvent(motionEvent);
        }

        @TargetApi(9)
        public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
            if (this.a.mWebViewCallbackClient != null) {
                this.a.mWebViewCallbackClient.onOverScrolled(i, i2, z, z2, this);
                return;
            }
            if (VERSION.SDK_INT >= 9) {
                super.onOverScrolled(i, i2, z, z2);
            }
        }

        protected void onScrollChanged(int i, int i2, int i3, int i4) {
            if (this.a.mWebViewCallbackClient != null) {
                this.a.mWebViewCallbackClient.onScrollChanged(i, i2, i3, i4, this);
                return;
            }
            super.onScrollChanged(i, i2, i3, i4);
            this.a.onScrollChanged(i, i2, i3, i4);
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!hasFocus()) {
                requestFocus();
            }
            if (this.a.mWebViewCallbackClient != null) {
                return this.a.mWebViewCallbackClient.onTouchEvent(motionEvent, this);
            }
            try {
                return super.onTouchEvent(motionEvent);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        @TargetApi(9)
        public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            return this.a.mWebViewCallbackClient != null ? r11.a.mWebViewCallbackClient.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z, r11) : VERSION.SDK_INT >= 9 ? super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z) : false;
        }

        public void setOverScrollMode(int r1) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = this;
            super.setOverScrollMode(r1);	 Catch:{ Exception -> 0x0003 }
        L_0x0003:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebView.a.setOverScrollMode(int):void");
        }
    }

    public WebView(Context context) {
        this(context, null);
    }

    public WebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, false);
    }

    @android.annotation.TargetApi(11)
    public WebView(android.content.Context r5, android.util.AttributeSet r6, int r7, java.util.Map<java.lang.String, java.lang.Object> r8, boolean r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r4.<init>(r5, r6, r7);
        r7 = "WebView";
        r4.b = r7;
        r7 = 0;
        r4.e = r7;
        r8 = 0;
        r4.h = r8;
        r4.i = r8;
        r4.a = r7;
        r4.k = r7;
        r4.n = r8;
        r4.o = r8;
        r9 = 1;
        r4.q = r9;
        r0 = 2;
        r4.r = r0;
        r0 = 3;
        r4.s = r0;
        r0 = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
        r4.t = r0;
        r0 = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
        r4.u = r0;
        r4.x = r8;
        r4.y = r8;
        r0 = com.tencent.smtt.sdk.QbSdk.getIsSysWebViewForcedByOuter();
        r1 = -1;
        if (r0 == 0) goto L_0x00b9;
    L_0x0033:
        r0 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r5);
        if (r0 == 0) goto L_0x00b9;
    L_0x0039:
        r4.i = r5;
        r4.f = r8;
        r4.e = r7;
        r0 = "failed to createTBSWebview!";
        com.tencent.smtt.sdk.QbSdk.a(r5, r0);
        r0 = new com.tencent.smtt.sdk.WebView$a;
        r0.<init>(r4, r5, r6);
        r4.g = r0;
        r6 = com.tencent.smtt.sdk.CookieManager.getInstance();
        r6.a(r5, r9, r7);
        r6 = r4.i;
        r6 = com.tencent.smtt.sdk.CookieSyncManager.createInstance(r6);
        r6.startSync();
        r6 = "android.webkit.WebViewWorker";	 Catch:{ Exception -> 0x0086 }
        r6 = java.lang.Class.forName(r6);	 Catch:{ Exception -> 0x0086 }
        r0 = "getHandler";	 Catch:{ Exception -> 0x0086 }
        r2 = new java.lang.Class[r7];	 Catch:{ Exception -> 0x0086 }
        r6 = r6.getDeclaredMethod(r0, r2);	 Catch:{ Exception -> 0x0086 }
        r6.setAccessible(r9);	 Catch:{ Exception -> 0x0086 }
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x0086 }
        r6 = r6.invoke(r8, r7);	 Catch:{ Exception -> 0x0086 }
        r6 = (android.os.Handler) r6;	 Catch:{ Exception -> 0x0086 }
        r6 = r6.getLooper();	 Catch:{ Exception -> 0x0086 }
        r6 = r6.getThread();	 Catch:{ Exception -> 0x0086 }
        r7 = new com.tencent.smtt.sdk.m;	 Catch:{ Exception -> 0x0086 }
        r7.<init>();	 Catch:{ Exception -> 0x0086 }
        r6.setUncaughtExceptionHandler(r7);	 Catch:{ Exception -> 0x0086 }
        mSysWebviewCreated = r9;	 Catch:{ Exception -> 0x0086 }
    L_0x0086:
        r6 = com.tencent.smtt.sdk.CookieManager.getInstance();
        r6.a();
        r6 = r4.g;
        r6.setFocusableInTouchMode(r9);
        r6 = r4.g;
        r7 = new android.widget.FrameLayout$LayoutParams;
        r7.<init>(r1, r1);
        r4.addView(r6, r7);
        r6 = "WebView";
        r7 = "SystemWebView Created Success! #3";
        com.tencent.smtt.utils.TbsLog.i(r6, r7);
        r6 = "WebView";
        r7 = "sys WebView: IsSysWebViewForcedByOuter = true";
        com.tencent.smtt.utils.TbsLog.e(r6, r7, r9);
        r6 = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance();
        r7 = 402; // 0x192 float:5.63E-43 double:1.986E-321;
        r8 = new java.lang.Throwable;
        r8.<init>();
        r6.a(r5, r7, r8);
        return;
    L_0x00b9:
        r0 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r5);
        if (r0 == 0) goto L_0x00c3;
    L_0x00bf:
        com.tencent.smtt.utils.TbsLog.setWriteLogJIT(r9);
        goto L_0x00c6;
    L_0x00c3:
        com.tencent.smtt.utils.TbsLog.setWriteLogJIT(r7);
    L_0x00c6:
        com.tencent.smtt.utils.TbsLog.initIfNeed(r5);
        if (r5 != 0) goto L_0x00d3;
    L_0x00cb:
        r5 = new java.lang.IllegalArgumentException;
        r6 = "Invalid context argument";
        r5.<init>(r6);
        throw r5;
    L_0x00d3:
        r0 = l;
        if (r0 != 0) goto L_0x00dd;
    L_0x00d7:
        r0 = com.tencent.smtt.utils.y.a(r5);
        l = r0;
    L_0x00dd:
        r0 = l;
        r0 = r0.a;
        if (r0 == 0) goto L_0x00ef;
    L_0x00e3:
        r0 = "WebView";
        r2 = "sys WebView: debug.conf force syswebview";
        com.tencent.smtt.utils.TbsLog.e(r0, r2, r9);
        r0 = "debug.conf force syswebview!";
        com.tencent.smtt.sdk.QbSdk.a(r5, r0);
    L_0x00ef:
        r4.c(r5);
        r4.i = r5;
        if (r5 == 0) goto L_0x00fc;
    L_0x00f6:
        r0 = r5.getApplicationContext();
        j = r0;
    L_0x00fc:
        r0 = r4.e;
        r2 = 11;
        if (r0 == 0) goto L_0x01d7;
    L_0x0102:
        r0 = com.tencent.smtt.sdk.QbSdk.a;
        if (r0 != 0) goto L_0x01d7;
    L_0x0106:
        r0 = com.tencent.smtt.sdk.bk.b();
        r0 = r0.a(r9);
        r0 = r0.a(r5);
        r4.f = r0;
        r0 = r4.f;
        if (r0 == 0) goto L_0x016a;
    L_0x0118:
        r0 = r4.f;
        r0 = r0.getView();
        if (r0 != 0) goto L_0x0121;
    L_0x0120:
        goto L_0x016a;
    L_0x0121:
        r0 = "WebView";
        r3 = "X5 WebView Created Success!!";
        com.tencent.smtt.utils.TbsLog.i(r0, r3);
        r0 = r4.f;
        r0 = r0.getView();
        r0.setFocusableInTouchMode(r9);
        r4.a(r6);
        r6 = r4.f;
        r6 = r6.getView();
        r0 = new android.widget.FrameLayout$LayoutParams;
        r0.<init>(r1, r1);
        r4.addView(r6, r0);
        r6 = r4.f;
        r0 = new com.tencent.smtt.sdk.b;
        r1 = r4.e;
        r0.<init>(r4, r8, r1);
        r6.setDownloadListener(r0);
        r6 = r4.f;
        r6 = r6.getX5WebViewExtension();
        r0 = new com.tencent.smtt.sdk.be;
        r1 = com.tencent.smtt.sdk.bk.b();
        r1 = r1.a(r9);
        r1 = r1.k();
        r0.<init>(r4, r1);
        r6.setWebViewClientExtension(r0);
        goto L_0x021d;
    L_0x016a:
        r0 = "WebView";
        r3 = "sys WebView: failed to createTBSWebview";
        com.tencent.smtt.utils.TbsLog.e(r0, r3, r9);
        r4.f = r8;
        r4.e = r7;
        r8 = "failed to createTBSWebview!";
        com.tencent.smtt.sdk.QbSdk.a(r5, r8);
        r4.c(r5);
        r8 = r4.i;
        r8 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r8);
        if (r8 == 0) goto L_0x018d;
    L_0x0185:
        r8 = new com.tencent.smtt.sdk.WebView$a;
        r8.<init>(r4, r5, r6);
        r4.g = r8;
        goto L_0x0194;
    L_0x018d:
        r6 = new com.tencent.smtt.sdk.WebView$a;
        r6.<init>(r4, r5);
        r4.g = r6;
    L_0x0194:
        r6 = "WebView";
        r8 = "SystemWebView Created Success! #1";
        com.tencent.smtt.utils.TbsLog.i(r6, r8);
        r6 = com.tencent.smtt.sdk.CookieManager.getInstance();
        r6.a(r5, r9, r7);
        r6 = com.tencent.smtt.sdk.CookieManager.getInstance();
        r6.a();
        r6 = r4.g;
        r6.setFocusableInTouchMode(r9);
        r6 = r4.g;
        r7 = new android.widget.FrameLayout$LayoutParams;
        r7.<init>(r1, r1);
        r4.addView(r6, r7);
        r6 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x01cc }
        if (r6 < r2) goto L_0x01d0;	 Catch:{ Throwable -> 0x01cc }
    L_0x01bc:
        r6 = "searchBoxJavaBridge_";	 Catch:{ Throwable -> 0x01cc }
        r4.removeJavascriptInterface(r6);	 Catch:{ Throwable -> 0x01cc }
        r6 = "accessibility";	 Catch:{ Throwable -> 0x01cc }
        r4.removeJavascriptInterface(r6);	 Catch:{ Throwable -> 0x01cc }
        r6 = "accessibilityTraversal";	 Catch:{ Throwable -> 0x01cc }
        r4.removeJavascriptInterface(r6);	 Catch:{ Throwable -> 0x01cc }
        goto L_0x01d0;
    L_0x01cc:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x01d0:
        com.tencent.smtt.utils.TbsLog.writeLogToDisk();
        com.tencent.smtt.sdk.aj.a(r5);
        return;
    L_0x01d7:
        r4.f = r8;
        r0 = r4.i;
        r0 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r0);
        if (r0 == 0) goto L_0x01e9;
    L_0x01e1:
        r0 = new com.tencent.smtt.sdk.WebView$a;
        r0.<init>(r4, r5, r6);
        r4.g = r0;
        goto L_0x01f0;
    L_0x01e9:
        r6 = new com.tencent.smtt.sdk.WebView$a;
        r6.<init>(r4, r5);
        r4.g = r6;
    L_0x01f0:
        r6 = "WebView";
        r0 = "SystemWebView Created Success! #2";
        com.tencent.smtt.utils.TbsLog.i(r6, r0);
        r6 = com.tencent.smtt.sdk.CookieManager.getInstance();
        r6.a(r5, r9, r7);
        r6 = com.tencent.smtt.sdk.CookieManager.getInstance();
        r6.a();
        r6 = r4.g;
        r6.setFocusableInTouchMode(r9);
        r6 = r4.g;
        r0 = new android.widget.FrameLayout$LayoutParams;
        r0.<init>(r1, r1);
        r4.addView(r6, r0);
        r4.setDownloadListener(r8);
        com.tencent.smtt.utils.TbsLog.writeLogToDisk();
        com.tencent.smtt.sdk.aj.a(r5);
    L_0x021d:
        r6 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x0231 }
        if (r6 < r2) goto L_0x0235;	 Catch:{ Throwable -> 0x0231 }
    L_0x0221:
        r6 = "searchBoxJavaBridge_";	 Catch:{ Throwable -> 0x0231 }
        r4.removeJavascriptInterface(r6);	 Catch:{ Throwable -> 0x0231 }
        r6 = "accessibility";	 Catch:{ Throwable -> 0x0231 }
        r4.removeJavascriptInterface(r6);	 Catch:{ Throwable -> 0x0231 }
        r6 = "accessibilityTraversal";	 Catch:{ Throwable -> 0x0231 }
        r4.removeJavascriptInterface(r6);	 Catch:{ Throwable -> 0x0231 }
        goto L_0x0235;
    L_0x0231:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x0235:
        r6 = "com.tencent.mobileqq";
        r0 = r4.i;
        r0 = r0.getApplicationInfo();
        r0 = r0.packageName;
        r6 = r6.equals(r0);
        if (r6 != 0) goto L_0x0255;
    L_0x0245:
        r6 = "com.tencent.mm";
        r0 = r4.i;
        r0 = r0.getApplicationInfo();
        r0 = r0.packageName;
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0266;
    L_0x0255:
        r6 = com.tencent.smtt.sdk.l.a(r9);
        r6 = r6.h();
        if (r6 == 0) goto L_0x0266;
    L_0x025f:
        r6 = android.os.Build.VERSION.SDK_INT;
        if (r6 < r2) goto L_0x0266;
    L_0x0263:
        r4.setLayerType(r9, r8);
    L_0x0266:
        r6 = r4.f;
        if (r6 == 0) goto L_0x02d0;
    L_0x026a:
        com.tencent.smtt.utils.TbsLog.writeLogToDisk();
        r6 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r5);
        if (r6 != 0) goto L_0x02d0;
    L_0x0273:
        r6 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r5);
        r6 = r6.mPreferences;
        r8 = "tbs_decouplecoreversion";
        r6 = r6.getInt(r8, r7);
        if (r6 <= 0) goto L_0x029d;
    L_0x0281:
        r7 = com.tencent.smtt.sdk.aj.a();
        r7 = r7.f(r5);
        if (r6 == r7) goto L_0x029d;
    L_0x028b:
        r7 = com.tencent.smtt.sdk.aj.a();
        r7 = r7.g(r5);
        if (r6 != r7) goto L_0x029d;
    L_0x0295:
        r6 = com.tencent.smtt.sdk.aj.a();
        r6.j(r5);
        return;
    L_0x029d:
        r7 = "WebView";
        r8 = new java.lang.StringBuilder;
        r9 = "webview construction #1 deCoupleCoreVersion is ";
        r8.<init>(r9);
        r8.append(r6);
        r6 = " getTbsCoreShareDecoupleCoreVersion is ";
        r8.append(r6);
        r6 = com.tencent.smtt.sdk.aj.a();
        r6 = r6.f(r5);
        r8.append(r6);
        r6 = " getTbsCoreInstalledVerInNolock is ";
        r8.append(r6);
        r6 = com.tencent.smtt.sdk.aj.a();
        r5 = r6.g(r5);
        r8.append(r5);
        r5 = r8.toString();
        com.tencent.smtt.utils.TbsLog.i(r7, r5);
    L_0x02d0:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebView.<init>(android.content.Context, android.util.AttributeSet, int, java.util.Map, boolean):void");
    }

    public WebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        this(context, attributeSet, i, null, z);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            try {
                int attributeCount = attributeSet.getAttributeCount();
                for (int i = 0; i < attributeCount; i++) {
                    if (attributeSet.getAttributeName(i).equalsIgnoreCase("scrollbars")) {
                        View view;
                        int[] intArray = getResources().getIntArray(16842974);
                        int attributeIntValue = attributeSet.getAttributeIntValue(i, -1);
                        if (attributeIntValue == intArray[1]) {
                            this.f.getView().setVerticalScrollBarEnabled(false);
                            view = this.f.getView();
                        } else if (attributeIntValue == intArray[2]) {
                            this.f.getView().setVerticalScrollBarEnabled(false);
                        } else if (attributeIntValue == intArray[3]) {
                            view = this.f.getView();
                        }
                        view.setHorizontalScrollBarEnabled(false);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean a(View view) {
        if (this.i != null && getTbsCoreVersion(this.i) > 36200) {
            return false;
        }
        Object a = v.a(this.x, "onLongClick", new Class[]{View.class}, view);
        return a != null ? ((Boolean) a).booleanValue() : false;
    }

    private boolean b(Context context) {
        try {
            if (context.getPackageName().indexOf("com.tencent.mobileqq") >= 0) {
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    static void c() {
        new bj().start();
    }

    private void c(Context context) {
        if (QbSdk.i && TbsShareManager.isThirdPartyApp(context)) {
            TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(context);
        }
        bk b = bk.b();
        b.a(context);
        this.e = b.c();
    }

    private int d(Context context) {
        IOException e;
        String str;
        StringBuilder stringBuilder;
        Exception e2;
        Throwable th;
        FileOutputStream b = k.b(context, true, "tbslock.txt");
        if (b != null) {
            FileLock a = k.a(context, b);
            if (a == null) {
                return -1;
            }
            if (c.tryLock()) {
                FileInputStream fileInputStream = null;
                StringBuilder stringBuilder2;
                try {
                    File dir = context.getDir("tbs", 0);
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(dir);
                    stringBuilder2.append(File.separator);
                    stringBuilder2.append("core_private");
                    File file = new File(stringBuilder2.toString(), "pv.db");
                    if (file.exists()) {
                        Properties properties = new Properties();
                        InputStream fileInputStream2 = new FileInputStream(file);
                        try {
                            properties.load(fileInputStream2);
                            fileInputStream2.close();
                            String property = properties.getProperty("PV");
                            if (property == null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e3) {
                                    e = e3;
                                    str = "getTbsCorePV";
                                    stringBuilder = new StringBuilder("TbsInstaller--getTbsCorePV IOException=");
                                    stringBuilder.append(e.toString());
                                    TbsLog.e(str, stringBuilder.toString());
                                    c.unlock();
                                    k.a(a, b);
                                    return -1;
                                }
                            }
                            int parseInt = Integer.parseInt(property);
                            try {
                                fileInputStream2.close();
                            } catch (IOException e4) {
                                stringBuilder = new StringBuilder("TbsInstaller--getTbsCorePV IOException=");
                                stringBuilder.append(e4.toString());
                                TbsLog.e("getTbsCorePV", stringBuilder.toString());
                            }
                            c.unlock();
                            k.a(a, b);
                            return parseInt;
                        } catch (Exception e5) {
                            e2 = e5;
                            fileInputStream = fileInputStream2;
                            try {
                                stringBuilder2 = new StringBuilder("TbsInstaller--getTbsCorePV Exception=");
                                stringBuilder2.append(e2.toString());
                                TbsLog.e("getTbsCorePV", stringBuilder2.toString());
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e6) {
                                        e = e6;
                                        str = "getTbsCorePV";
                                        stringBuilder = new StringBuilder("TbsInstaller--getTbsCorePV IOException=");
                                        stringBuilder.append(e.toString());
                                        TbsLog.e(str, stringBuilder.toString());
                                        c.unlock();
                                        k.a(a, b);
                                        return -1;
                                    }
                                }
                                c.unlock();
                                k.a(a, b);
                                return -1;
                            } catch (Throwable th2) {
                                th = th2;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e42) {
                                        stringBuilder = new StringBuilder("TbsInstaller--getTbsCorePV IOException=");
                                        stringBuilder.append(e42.toString());
                                        TbsLog.e("getTbsCorePV", stringBuilder.toString());
                                    }
                                }
                                c.unlock();
                                k.a(a, b);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            c.unlock();
                            k.a(a, b);
                            throw th;
                        }
                    }
                } catch (Exception e7) {
                    e2 = e7;
                    stringBuilder2 = new StringBuilder("TbsInstaller--getTbsCorePV Exception=");
                    stringBuilder2.append(e2.toString());
                    TbsLog.e("getTbsCorePV", stringBuilder2.toString());
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    c.unlock();
                    k.a(a, b);
                    return -1;
                }
                c.unlock();
                k.a(a, b);
                return -1;
            }
            k.a(a, b);
        }
        return -1;
    }

    @Deprecated
    public static void disablePlatformNotifications() {
        if (!bk.b().c()) {
            v.a("android.webkit.WebView", "disablePlatformNotifications");
        }
    }

    private void e(Context context) {
        StringBuilder stringBuilder;
        try {
            File dir = context.getDir("tbs", 0);
            stringBuilder = new StringBuilder();
            stringBuilder.append(dir);
            stringBuilder.append(File.separator);
            stringBuilder.append("core_private");
            File file = new File(stringBuilder.toString(), "pv.db");
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            stringBuilder = new StringBuilder("TbsInstaller--getTbsCorePV Exception=");
            stringBuilder.append(e.toString());
            TbsLog.i("getTbsCorePV", stringBuilder.toString());
        }
    }

    @Deprecated
    public static void enablePlatformNotifications() {
        if (!bk.b().c()) {
            v.a("android.webkit.WebView", "enablePlatformNotifications");
        }
    }

    public static String findAddress(String str) {
        return !bk.b().c() ? android.webkit.WebView.findAddress(str) : null;
    }

    private long g() {
        long j;
        synchronized (QbSdk.h) {
            if (QbSdk.e) {
                QbSdk.g += System.currentTimeMillis() - QbSdk.f;
                StringBuilder stringBuilder = new StringBuilder("pv report, WebView.getWifiConnectedTime QbSdk.sWifiConnectedTime=");
                stringBuilder.append(QbSdk.g);
                TbsLog.d("sdkreport", stringBuilder.toString());
            }
            j = QbSdk.g / 1000;
            QbSdk.g = 0;
            QbSdk.f = System.currentTimeMillis();
        }
        return j;
    }

    public static String getCrashExtraMessage(Context context) {
        if (context == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder("tbs_core_version:");
        stringBuilder.append(QbSdk.getTbsVersion(context));
        stringBuilder.append(";tbs_sdk_version:43500;");
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(l.a(true).e());
        stringBuilder3.append("\n");
        stringBuilder3.append(stringBuilder2);
        if (!TbsShareManager.isThirdPartyApp(context) && QbSdk.l != null && QbSdk.l.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) && QbSdk.l.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY)) {
            StringBuilder stringBuilder4 = new StringBuilder("weapp_id:");
            stringBuilder4.append(QbSdk.l.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY));
            stringBuilder4.append(";weapp_name:");
            stringBuilder4.append(QbSdk.l.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY));
            stringBuilder4.append(h.b);
            String stringBuilder5 = stringBuilder4.toString();
            stringBuilder3.append("\n");
            stringBuilder3.append(stringBuilder5);
        }
        return stringBuilder3.length() > 8192 ? stringBuilder3.substring(stringBuilder3.length() - 8192) : stringBuilder3.toString();
    }

    public static PackageInfo getCurrentWebViewPackage() {
        if (bk.b().c() || VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            return (PackageInfo) v.a("android.webkit.WebView", "getCurrentWebViewPackage");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Deprecated
    public static synchronized Object getPluginList() {
        synchronized (WebView.class) {
            if (bk.b().c()) {
                return null;
            }
            Object a = v.a("android.webkit.WebView", "getPluginList");
            return a;
        }
    }

    public static int getTbsCoreVersion(Context context) {
        return QbSdk.getTbsVersion(context);
    }

    public static boolean getTbsNeedReboot() {
        c();
        return l.a(true).f();
    }

    public static int getTbsSDKVersion(Context context) {
        return 43500;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void setSysDayOrNight(boolean r3) {
        /*
        r0 = com.tencent.smtt.sdk.WebView.class;
        monitor-enter(r0);
        r1 = w;	 Catch:{ all -> 0x0041 }
        if (r3 != r1) goto L_0x0009;
    L_0x0007:
        monitor-exit(r0);
        return;
    L_0x0009:
        w = r3;	 Catch:{ all -> 0x0041 }
        r1 = v;	 Catch:{ all -> 0x0041 }
        if (r1 != 0) goto L_0x001b;
    L_0x000f:
        r1 = new android.graphics.Paint;	 Catch:{ all -> 0x0041 }
        r1.<init>();	 Catch:{ all -> 0x0041 }
        v = r1;	 Catch:{ all -> 0x0041 }
        r2 = -16777216; // 0xffffffffff000000 float:-1.7014118E38 double:NaN;
        r1.setColor(r2);	 Catch:{ all -> 0x0041 }
    L_0x001b:
        if (r3 != 0) goto L_0x0030;
    L_0x001d:
        r3 = v;	 Catch:{ all -> 0x0041 }
        r3 = r3.getAlpha();	 Catch:{ all -> 0x0041 }
        r1 = NIGHT_MODE_ALPHA;	 Catch:{ all -> 0x0041 }
        if (r3 == r1) goto L_0x003f;
    L_0x0027:
        r3 = v;	 Catch:{ all -> 0x0041 }
        r1 = NIGHT_MODE_ALPHA;	 Catch:{ all -> 0x0041 }
        r3.setAlpha(r1);	 Catch:{ all -> 0x0041 }
        monitor-exit(r0);
        return;
    L_0x0030:
        r3 = v;	 Catch:{ all -> 0x0041 }
        r3 = r3.getAlpha();	 Catch:{ all -> 0x0041 }
        r1 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        if (r3 == r1) goto L_0x003f;
    L_0x003a:
        r3 = v;	 Catch:{ all -> 0x0041 }
        r3.setAlpha(r1);	 Catch:{ all -> 0x0041 }
    L_0x003f:
        monitor-exit(r0);
        return;
    L_0x0041:
        r3 = move-exception;
        monitor-exit(r0);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebView.setSysDayOrNight(boolean):void");
    }

    public static void setWebContentsDebuggingEnabled(boolean z) {
        if (VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("setWebContentsDebuggingEnabled", new Class[]{Boolean.TYPE});
                m = declaredMethod;
                if (declaredMethod != null) {
                    m.setAccessible(true);
                    m.invoke(null, new Object[]{Boolean.valueOf(z)});
                }
            } catch (Exception e) {
                StringBuilder stringBuilder = new StringBuilder("Exception:");
                stringBuilder.append(e.getStackTrace());
                TbsLog.e("QbSdk", stringBuilder.toString());
                e.printStackTrace();
            }
        }
    }

    android.webkit.WebView a() {
        return !this.e ? this.g : null;
    }

    void a(android.content.Context r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.d(r5);
        r1 = -1;
        if (r0 == r1) goto L_0x001c;
    L_0x0007:
        r0 = r0 + 1;
        r1 = new java.lang.StringBuilder;
        r2 = "PV=";
        r1.<init>(r2);
        r0 = java.lang.String.valueOf(r0);
        r1.append(r0);
        r0 = r1.toString();
        goto L_0x001e;
    L_0x001c:
        r0 = "PV=1";
    L_0x001e:
        r1 = "tbs";
        r2 = 0;
        r5 = r5.getDir(r1, r2);
        r1 = new java.io.File;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r3.append(r5);
        r5 = java.io.File.separator;
        r3.append(r5);
        r5 = "core_private";
        r3.append(r5);
        r5 = r3.toString();
        r3 = "pv.db";
        r1.<init>(r5, r3);
        r5 = r1.getParentFile();	 Catch:{ all -> 0x0070 }
        r5.mkdirs();	 Catch:{ all -> 0x0070 }
        r5 = r1.isFile();	 Catch:{ all -> 0x0070 }
        if (r5 == 0) goto L_0x0055;	 Catch:{ all -> 0x0070 }
    L_0x004f:
        r5 = r1.exists();	 Catch:{ all -> 0x0070 }
        if (r5 != 0) goto L_0x0058;	 Catch:{ all -> 0x0070 }
    L_0x0055:
        r1.createNewFile();	 Catch:{ all -> 0x0070 }
    L_0x0058:
        r5 = new java.io.FileOutputStream;	 Catch:{ all -> 0x0070 }
        r5.<init>(r1, r2);	 Catch:{ all -> 0x0070 }
        d = r5;	 Catch:{ all -> 0x0070 }
        r0 = r0.getBytes();	 Catch:{ all -> 0x0070 }
        r5.write(r0);	 Catch:{ all -> 0x0070 }
        r5 = d;	 Catch:{ Throwable -> 0x007b }
        if (r5 == 0) goto L_0x006f;	 Catch:{ Throwable -> 0x007b }
    L_0x006a:
        r5 = d;	 Catch:{ Throwable -> 0x007b }
        r5.flush();	 Catch:{ Throwable -> 0x007b }
    L_0x006f:
        return;	 Catch:{ Throwable -> 0x007b }
    L_0x0070:
        r5 = move-exception;	 Catch:{ Throwable -> 0x007b }
        r0 = d;	 Catch:{ Throwable -> 0x007b }
        if (r0 == 0) goto L_0x007a;	 Catch:{ Throwable -> 0x007b }
    L_0x0075:
        r0 = d;	 Catch:{ Throwable -> 0x007b }
        r0.flush();	 Catch:{ Throwable -> 0x007b }
    L_0x007a:
        throw r5;	 Catch:{ Throwable -> 0x007b }
    L_0x007b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebView.a(android.content.Context):void");
    }

    void a(android.webkit.WebView webView) {
    }

    void a(IX5WebViewBase iX5WebViewBase) {
        this.f = iX5WebViewBase;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.e) {
            this.f.addJavascriptInterface(obj, str);
        } else {
            this.g.addJavascriptInterface(obj, str);
        }
    }

    public void addView(android.view.View r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = r6.e;
        if (r0 != 0) goto L_0x000a;
    L_0x0004:
        r0 = r6.g;
        r0.addView(r7);
        return;
    L_0x000a:
        r0 = r6.f;
        r0 = r0.getView();
        r1 = "addView";	 Catch:{ Throwable -> 0x0028 }
        r2 = 1;	 Catch:{ Throwable -> 0x0028 }
        r3 = new java.lang.Class[r2];	 Catch:{ Throwable -> 0x0028 }
        r4 = android.view.View.class;	 Catch:{ Throwable -> 0x0028 }
        r5 = 0;	 Catch:{ Throwable -> 0x0028 }
        r3[r5] = r4;	 Catch:{ Throwable -> 0x0028 }
        r1 = com.tencent.smtt.utils.v.a(r0, r1, r3);	 Catch:{ Throwable -> 0x0028 }
        r1.setAccessible(r2);	 Catch:{ Throwable -> 0x0028 }
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0028 }
        r2[r5] = r7;	 Catch:{ Throwable -> 0x0028 }
        r1.invoke(r0, r2);	 Catch:{ Throwable -> 0x0028 }
    L_0x0028:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebView.addView(android.view.View):void");
    }

    IX5WebViewBase b() {
        return this.f;
    }

    public boolean canGoBack() {
        return !this.e ? this.g.canGoBack() : this.f.canGoBack();
    }

    public boolean canGoBackOrForward(int i) {
        return !this.e ? this.g.canGoBackOrForward(i) : this.f.canGoBackOrForward(i);
    }

    public boolean canGoForward() {
        return !this.e ? this.g.canGoForward() : this.f.canGoForward();
    }

    @Deprecated
    public boolean canZoomIn() {
        if (this.e) {
            return this.f.canZoomIn();
        }
        if (VERSION.SDK_INT < 11) {
            return false;
        }
        Object a = v.a(this.g, "canZoomIn");
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    @Deprecated
    public boolean canZoomOut() {
        if (this.e) {
            return this.f.canZoomOut();
        }
        if (VERSION.SDK_INT < 11) {
            return false;
        }
        Object a = v.a(this.g, "canZoomOut");
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    @Deprecated
    public Picture capturePicture() {
        if (this.e) {
            return this.f.capturePicture();
        }
        Object a = v.a(this.g, "capturePicture");
        return a == null ? null : (Picture) a;
    }

    public void clearCache(boolean z) {
        if (this.e) {
            this.f.clearCache(z);
        } else {
            this.g.clearCache(z);
        }
    }

    public void clearFormData() {
        if (this.e) {
            this.f.clearFormData();
        } else {
            this.g.clearFormData();
        }
    }

    public void clearHistory() {
        if (this.e) {
            this.f.clearHistory();
        } else {
            this.g.clearHistory();
        }
    }

    @TargetApi(3)
    public void clearMatches() {
        if (this.e) {
            this.f.clearMatches();
        } else {
            this.g.clearMatches();
        }
    }

    public void clearSslPreferences() {
        if (this.e) {
            this.f.clearSslPreferences();
        } else {
            this.g.clearSslPreferences();
        }
    }

    @Deprecated
    public void clearView() {
        if (this.e) {
            this.f.clearView();
        } else {
            v.a(this.g, "clearView");
        }
    }

    public int computeHorizontalScrollExtent() {
        try {
            Method a;
            if (this.e) {
                a = v.a(this.f.getView(), "computeHorizontalScrollExtent", new Class[0]);
                a.setAccessible(true);
                return ((Integer) a.invoke(this.f.getView(), null)).intValue();
            }
            a = v.a(this.g, "computeHorizontalScrollExtent", new Class[0]);
            a.setAccessible(true);
            return ((Integer) a.invoke(this.g, null)).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int computeHorizontalScrollOffset() {
        try {
            Method a;
            if (this.e) {
                a = v.a(this.f.getView(), "computeHorizontalScrollOffset", new Class[0]);
                a.setAccessible(true);
                return ((Integer) a.invoke(this.f.getView(), null)).intValue();
            }
            a = v.a(this.g, "computeHorizontalScrollOffset", new Class[0]);
            a.setAccessible(true);
            return ((Integer) a.invoke(this.g, null)).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int computeHorizontalScrollRange() {
        try {
            if (this.e) {
                return ((Integer) v.a(this.f.getView(), "computeHorizontalScrollRange", new Class[0], new Object[0])).intValue();
            }
            Method a = v.a(this.g, "computeHorizontalScrollRange", new Class[0]);
            a.setAccessible(true);
            return ((Integer) a.invoke(this.g, null)).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void computeScroll() {
        if (this.e) {
            this.f.computeScroll();
        } else {
            this.g.computeScroll();
        }
    }

    public int computeVerticalScrollRange() {
        try {
            if (this.e) {
                return ((Integer) v.a(this.f.getView(), "computeVerticalScrollRange", new Class[0], new Object[0])).intValue();
            }
            Method a = v.a(this.g, "computeVerticalScrollRange", new Class[0]);
            a.setAccessible(true);
            return ((Integer) a.invoke(this.g, null)).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public WebBackForwardList copyBackForwardList() {
        return this.e ? WebBackForwardList.a(this.f.copyBackForwardList()) : WebBackForwardList.a(this.g.copyBackForwardList());
    }

    public Object createPrintDocumentAdapter(String str) {
        if (this.e) {
            try {
                return this.f.createPrintDocumentAdapter(str);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        } else if (VERSION.SDK_INT < 21) {
            return null;
        } else {
            return v.a(this.g, "createPrintDocumentAdapter", new Class[]{String.class}, str);
        }
    }

    public void customDiskCachePathEnabled(boolean z, String str) {
        if (this.e && getX5WebViewExtension() != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("enabled", z);
            bundle.putString("path", str);
            getX5WebViewExtension().invokeMiscMethod("customDiskCachePathEnabled", bundle);
        }
    }

    public void destroy() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r13 = this;
        r0 = r13.k;
        r1 = 0;
        r2 = 1;
        if (r0 != 0) goto L_0x006a;
    L_0x0006:
        r0 = r13.a;
        if (r0 == 0) goto L_0x006a;
    L_0x000a:
        r13.k = r2;
        r0 = "";
        r3 = "";
        r4 = "";
        r5 = r13.e;
        if (r5 == 0) goto L_0x0034;
    L_0x0016:
        r5 = r13.f;
        r5 = r5.getX5WebViewExtension();
        r5 = r5.getSdkQBStatisticsInfo();
        if (r5 == 0) goto L_0x0034;
    L_0x0022:
        r0 = "guid";
        r0 = r5.getString(r0);
        r3 = "qua2";
        r3 = r5.getString(r3);
        r4 = "lc";
        r4 = r5.getString(r4);
    L_0x0034:
        r6 = r0;
        r7 = r3;
        r8 = r4;
        r0 = "com.qzone";
        r3 = r13.i;
        r3 = r3.getApplicationInfo();
        r3 = r3.packageName;
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x0059;
    L_0x0047:
        r0 = r13.i;
        r0 = r13.d(r0);
        r3 = -1;
        if (r0 != r3) goto L_0x0052;
    L_0x0050:
        r0 = r13.a;
    L_0x0052:
        r13.a = r0;
        r0 = r13.i;
        r13.e(r0);
    L_0x0059:
        r5 = r13.i;
        r9 = r13.a;
        r10 = r13.e;
        r11 = r13.g();
        com.tencent.smtt.sdk.a.b.a(r5, r6, r7, r8, r9, r10, r11);
        r13.a = r1;
        r13.k = r1;
    L_0x006a:
        r0 = r13.e;
        if (r0 != 0) goto L_0x010e;
    L_0x006e:
        r0 = 0;
        r3 = "android.webkit.WebViewClassic";	 Catch:{ Exception -> 0x00cf }
        r3 = java.lang.Class.forName(r3);	 Catch:{ Exception -> 0x00cf }
        r4 = "fromWebView";	 Catch:{ Exception -> 0x00cf }
        r5 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x00cf }
        r6 = android.webkit.WebView.class;	 Catch:{ Exception -> 0x00cf }
        r5[r1] = r6;	 Catch:{ Exception -> 0x00cf }
        r4 = r3.getMethod(r4, r5);	 Catch:{ Exception -> 0x00cf }
        r4.setAccessible(r2);	 Catch:{ Exception -> 0x00cf }
        r5 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x00cf }
        r6 = r13.g;	 Catch:{ Exception -> 0x00cf }
        r5[r1] = r6;	 Catch:{ Exception -> 0x00cf }
        r1 = r4.invoke(r0, r5);	 Catch:{ Exception -> 0x00cf }
        if (r1 == 0) goto L_0x00cf;	 Catch:{ Exception -> 0x00cf }
    L_0x0090:
        r4 = "mListBoxDialog";	 Catch:{ Exception -> 0x00cf }
        r3 = r3.getDeclaredField(r4);	 Catch:{ Exception -> 0x00cf }
        r3.setAccessible(r2);	 Catch:{ Exception -> 0x00cf }
        r1 = r3.get(r1);	 Catch:{ Exception -> 0x00cf }
        if (r1 == 0) goto L_0x00cf;	 Catch:{ Exception -> 0x00cf }
    L_0x009f:
        r1 = (android.app.Dialog) r1;	 Catch:{ Exception -> 0x00cf }
        r1.setOnCancelListener(r0);	 Catch:{ Exception -> 0x00cf }
        r3 = "android.app.Dialog";	 Catch:{ Exception -> 0x00cf }
        r3 = java.lang.Class.forName(r3);	 Catch:{ Exception -> 0x00cf }
        r4 = "CANCEL";	 Catch:{ Exception -> 0x00cf }
        r4 = r3.getDeclaredField(r4);	 Catch:{ Exception -> 0x00cf }
        r4.setAccessible(r2);	 Catch:{ Exception -> 0x00cf }
        r4 = r4.get(r1);	 Catch:{ Exception -> 0x00cf }
        r4 = (java.lang.Integer) r4;	 Catch:{ Exception -> 0x00cf }
        r4 = r4.intValue();	 Catch:{ Exception -> 0x00cf }
        r5 = "mListenersHandler";	 Catch:{ Exception -> 0x00cf }
        r3 = r3.getDeclaredField(r5);	 Catch:{ Exception -> 0x00cf }
        r3.setAccessible(r2);	 Catch:{ Exception -> 0x00cf }
        r1 = r3.get(r1);	 Catch:{ Exception -> 0x00cf }
        r1 = (android.os.Handler) r1;	 Catch:{ Exception -> 0x00cf }
        r1.removeMessages(r4);	 Catch:{ Exception -> 0x00cf }
    L_0x00cf:
        r1 = r13.g;
        r1.destroy();
        r1 = "android.webkit.BrowserFrame";	 Catch:{ Exception -> 0x0113 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ Exception -> 0x0113 }
        r3 = "sConfigCallback";	 Catch:{ Exception -> 0x0113 }
        r1 = r1.getDeclaredField(r3);	 Catch:{ Exception -> 0x0113 }
        r1.setAccessible(r2);	 Catch:{ Exception -> 0x0113 }
        r3 = r1.get(r0);	 Catch:{ Exception -> 0x0113 }
        r3 = (android.content.ComponentCallbacks) r3;	 Catch:{ Exception -> 0x0113 }
        if (r3 == 0) goto L_0x0113;	 Catch:{ Exception -> 0x0113 }
    L_0x00eb:
        r1.set(r0, r0);	 Catch:{ Exception -> 0x0113 }
        r1 = "android.view.ViewRoot";	 Catch:{ Exception -> 0x0113 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ Exception -> 0x0113 }
        r4 = "sConfigCallbacks";	 Catch:{ Exception -> 0x0113 }
        r1 = r1.getDeclaredField(r4);	 Catch:{ Exception -> 0x0113 }
        r1.setAccessible(r2);	 Catch:{ Exception -> 0x0113 }
        r0 = r1.get(r0);	 Catch:{ Exception -> 0x0113 }
        if (r0 == 0) goto L_0x0113;	 Catch:{ Exception -> 0x0113 }
    L_0x0103:
        r0 = (java.util.List) r0;	 Catch:{ Exception -> 0x0113 }
        monitor-enter(r0);	 Catch:{ Exception -> 0x0113 }
        r0.remove(r3);	 Catch:{ all -> 0x010b }
        monitor-exit(r0);	 Catch:{ all -> 0x010b }
        goto L_0x0113;	 Catch:{ all -> 0x010b }
    L_0x010b:
        r1 = move-exception;	 Catch:{ all -> 0x010b }
        monitor-exit(r0);	 Catch:{ all -> 0x010b }
        throw r1;	 Catch:{ Exception -> 0x0113 }
    L_0x010e:
        r0 = r13.f;
        r0.destroy();
    L_0x0113:
        r0 = "WebView";
        r1 = new java.lang.StringBuilder;
        r2 = "X5 GUID = ";
        r1.<init>(r2);
        r2 = com.tencent.smtt.sdk.QbSdk.b();
        r1.append(r2);
        r1 = r1.toString();
        com.tencent.smtt.utils.TbsLog.i(r0, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebView.destroy():void");
    }

    public void documentHasImages(Message message) {
        if (this.e) {
            this.f.documentHasImages(message);
        } else {
            this.g.documentHasImages(message);
        }
    }

    public void dumpViewHierarchyWithProperties(BufferedWriter bufferedWriter, int i) {
        if (this.e) {
            this.f.dumpViewHierarchyWithProperties(bufferedWriter, i);
            return;
        }
        v.a(this.g, "dumpViewHierarchyWithProperties", new Class[]{BufferedWriter.class, Integer.TYPE}, bufferedWriter, Integer.valueOf(i));
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.e) {
            try {
                Method a = v.a(this.f.getView(), "evaluateJavascript", String.class, ValueCallback.class);
                a.setAccessible(true);
                a.invoke(this.f.getView(), new Object[]{str, valueCallback});
                return;
            } catch (Exception e) {
                e.printStackTrace();
                loadUrl(str);
                return;
            }
        }
        if (VERSION.SDK_INT >= 19) {
            try {
                a = Class.forName("android.webkit.WebView").getDeclaredMethod("evaluateJavascript", new Class[]{String.class, ValueCallback.class});
                a.setAccessible(true);
                a.invoke(this.g, new Object[]{str, valueCallback});
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Deprecated
    public int findAll(String str) {
        if (this.e) {
            return this.f.findAll(str);
        }
        Object a = v.a(this.g, "findAll", new Class[]{String.class}, str);
        return a == null ? 0 : ((Integer) a).intValue();
    }

    @TargetApi(16)
    public void findAllAsync(String str) {
        if (this.e) {
            this.f.findAllAsync(str);
        } else if (VERSION.SDK_INT >= 16) {
            v.a(this.g, "findAllAsync", new Class[]{String.class}, str);
        }
    }

    public View findHierarchyView(String str, int i) {
        if (this.e) {
            return this.f.findHierarchyView(str, i);
        }
        return (View) v.a(this.g, "findHierarchyView", new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i));
    }

    @TargetApi(3)
    public void findNext(boolean z) {
        if (this.e) {
            this.f.findNext(z);
        } else {
            this.g.findNext(z);
        }
    }

    public void flingScroll(int i, int i2) {
        if (this.e) {
            this.f.flingScroll(i, i2);
        } else {
            this.g.flingScroll(i, i2);
        }
    }

    @Deprecated
    public void freeMemory() {
        if (this.e) {
            this.f.freeMemory();
        } else {
            v.a(this.g, "freeMemory");
        }
    }

    public SslCertificate getCertificate() {
        return !this.e ? this.g.getCertificate() : this.f.getCertificate();
    }

    public int getContentHeight() {
        return !this.e ? this.g.getContentHeight() : this.f.getContentHeight();
    }

    public int getContentWidth() {
        if (this.e) {
            return this.f.getContentWidth();
        }
        Object a = v.a(this.g, "getContentWidth");
        return a == null ? 0 : ((Integer) a).intValue();
    }

    public Bitmap getFavicon() {
        return !this.e ? this.g.getFavicon() : this.f.getFavicon();
    }

    public HitTestResult getHitTestResult() {
        return !this.e ? new HitTestResult(this.g.getHitTestResult()) : new HitTestResult(this.f.getHitTestResult());
    }

    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        return !this.e ? this.g.getHttpAuthUsernamePassword(str, str2) : this.f.getHttpAuthUsernamePassword(str, str2);
    }

    @TargetApi(3)
    public String getOriginalUrl() {
        return !this.e ? this.g.getOriginalUrl() : this.f.getOriginalUrl();
    }

    public int getProgress() {
        return !this.e ? this.g.getProgress() : this.f.getProgress();
    }

    public boolean getRendererPriorityWaivedWhenNotVisible() {
        try {
            if (this.e || VERSION.SDK_INT < 26) {
                return false;
            }
            Object a = v.a(this.g, "getRendererPriorityWaivedWhenNotVisible");
            return a == null ? false : ((Boolean) a).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getRendererRequestedPriority() {
        try {
            if (this.e || VERSION.SDK_INT < 26) {
                return 0;
            }
            Object a = v.a(this.g, "getRendererRequestedPriority");
            return a == null ? 0 : ((Integer) a).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Deprecated
    public float getScale() {
        if (this.e) {
            return this.f.getScale();
        }
        Object a = v.a(this.g, "getScale");
        return a == null ? 0.0f : ((Float) a).floatValue();
    }

    public int getScrollBarDefaultDelayBeforeFade() {
        return getView() == null ? 0 : getView().getScrollBarDefaultDelayBeforeFade();
    }

    public int getScrollBarFadeDuration() {
        return getView() == null ? 0 : getView().getScrollBarFadeDuration();
    }

    public int getScrollBarSize() {
        return getView() == null ? 0 : getView().getScrollBarSize();
    }

    public int getScrollBarStyle() {
        return getView() == null ? 0 : getView().getScrollBarStyle();
    }

    public WebSettings getSettings() {
        if (this.h != null) {
            return this.h;
        }
        WebSettings webSettings = this.e ? new WebSettings(this.f.getSettings()) : new WebSettings(this.g.getSettings());
        this.h = webSettings;
        return webSettings;
    }

    public IX5WebSettingsExtension getSettingsExtension() {
        return !this.e ? null : this.f.getX5WebViewExtension().getSettingsExtension();
    }

    public int getSysNightModeAlpha() {
        return NIGHT_MODE_ALPHA;
    }

    public String getTitle() {
        return !this.e ? this.g.getTitle() : this.f.getTitle();
    }

    public String getUrl() {
        return !this.e ? this.g.getUrl() : this.f.getUrl();
    }

    public View getView() {
        return !this.e ? this.g : this.f.getView();
    }

    public int getVisibleTitleHeight() {
        if (this.e) {
            return this.f.getVisibleTitleHeight();
        }
        Object a = v.a(this.g, "getVisibleTitleHeight");
        return a == null ? 0 : ((Integer) a).intValue();
    }

    public WebChromeClient getWebChromeClient() {
        return this.o;
    }

    public IX5WebChromeClientExtension getWebChromeClientExtension() {
        return !this.e ? null : this.f.getX5WebViewExtension().getWebChromeClientExtension();
    }

    public int getWebScrollX() {
        return this.e ? this.f.getView().getScrollX() : this.g.getScrollX();
    }

    public int getWebScrollY() {
        return this.e ? this.f.getView().getScrollY() : this.g.getScrollY();
    }

    public WebViewClient getWebViewClient() {
        return this.n;
    }

    public IX5WebViewClientExtension getWebViewClientExtension() {
        return !this.e ? null : this.f.getX5WebViewExtension().getWebViewClientExtension();
    }

    public IX5WebViewExtension getX5WebViewExtension() {
        return !this.e ? null : this.f.getX5WebViewExtension();
    }

    @Deprecated
    public View getZoomControls() {
        return !this.e ? (View) v.a(this.g, "getZoomControls") : this.f.getZoomControls();
    }

    public void goBack() {
        if (this.e) {
            this.f.goBack();
        } else {
            this.g.goBack();
        }
    }

    public void goBackOrForward(int i) {
        if (this.e) {
            this.f.goBackOrForward(i);
        } else {
            this.g.goBackOrForward(i);
        }
    }

    public void goForward() {
        if (this.e) {
            this.f.goForward();
        } else {
            this.g.goForward();
        }
    }

    public void invokeZoomPicker() {
        if (this.e) {
            this.f.invokeZoomPicker();
        } else {
            this.g.invokeZoomPicker();
        }
    }

    public boolean isDayMode() {
        return w;
    }

    public boolean isPrivateBrowsingEnabled() {
        if (this.e) {
            return this.f.isPrivateBrowsingEnable();
        }
        if (VERSION.SDK_INT < 11) {
            return false;
        }
        Object a = v.a(this.g, "isPrivateBrowsingEnabled");
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    public void loadData(String str, String str2, String str3) {
        if (this.e) {
            this.f.loadData(str, str2, str3);
        } else {
            this.g.loadData(str, str2, str3);
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (this.e) {
            this.f.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            this.g.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    public void loadUrl(String str) {
        if (str != null && !showDebugView(str)) {
            if (this.e) {
                this.f.loadUrl(str);
            } else {
                this.g.loadUrl(str);
            }
        }
    }

    @TargetApi(8)
    public void loadUrl(String str, Map<String, String> map) {
        if (str != null && !showDebugView(str)) {
            if (this.e) {
                this.f.loadUrl(str, map);
            } else if (VERSION.SDK_INT >= 8) {
                this.g.loadUrl(str, map);
            }
        }
    }

    protected void onDetachedFromWindow() {
        if (!(this.k || this.a == 0)) {
            this.k = true;
            String str = "";
            String str2 = "";
            String str3 = "";
            if (this.e) {
                Bundle sdkQBStatisticsInfo = this.f.getX5WebViewExtension().getSdkQBStatisticsInfo();
                if (sdkQBStatisticsInfo != null) {
                    str = sdkQBStatisticsInfo.getString(d.a);
                    str2 = sdkQBStatisticsInfo.getString("qua2");
                    str3 = sdkQBStatisticsInfo.getString("lc");
                }
            }
            String str4 = str;
            String str5 = str2;
            String str6 = str3;
            if ("com.qzone".equals(this.i.getApplicationInfo().packageName)) {
                int d = d(this.i);
                if (d == -1) {
                    d = this.a;
                }
                this.a = d;
                e(this.i);
            }
            b.a(this.i, str4, str5, str6, this.a, this.e, g());
            this.a = 0;
            this.k = false;
        }
        super.onDetachedFromWindow();
    }

    public boolean onLongClick(View view) {
        return this.y != null ? !this.y.onLongClick(view) ? a(view) : true : a(view);
    }

    public void onPause() {
        if (this.e) {
            this.f.onPause();
        } else {
            v.a(this.g, "onPause");
        }
    }

    public void onResume() {
        if (this.e) {
            this.f.onResume();
        } else {
            v.a(this.g, "onResume");
        }
    }

    @TargetApi(11)
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (VERSION.SDK_INT >= 21 && b(this.i) && isHardwareAccelerated() && i > 0 && i2 > 0) {
            getLayerType();
        }
    }

    protected void onVisibilityChanged(View view, int i) {
        if (this.i == null) {
            super.onVisibilityChanged(view, i);
            return;
        }
        if (p == null) {
            p = this.i.getApplicationInfo().packageName;
        }
        if (p == null || !(p.equals("com.tencent.mm") || p.equals("com.tencent.mobileqq"))) {
            if (!(i == 0 || this.k || this.a == 0)) {
                this.k = true;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (this.e) {
                    Bundle sdkQBStatisticsInfo = this.f.getX5WebViewExtension().getSdkQBStatisticsInfo();
                    if (sdkQBStatisticsInfo != null) {
                        str = sdkQBStatisticsInfo.getString(d.a);
                        str2 = sdkQBStatisticsInfo.getString("qua2");
                        str3 = sdkQBStatisticsInfo.getString("lc");
                    }
                }
                String str4 = str;
                String str5 = str2;
                String str6 = str3;
                if ("com.qzone".equals(this.i.getApplicationInfo().packageName)) {
                    int d = d(this.i);
                    if (d == -1) {
                        d = this.a;
                    }
                    this.a = d;
                    e(this.i);
                }
                b.a(this.i, str4, str5, str6, this.a, this.e, g());
                this.a = 0;
                this.k = false;
            }
            super.onVisibilityChanged(view, i);
            return;
        }
        super.onVisibilityChanged(view, i);
    }

    public boolean overlayHorizontalScrollbar() {
        return !this.e ? this.g.overlayHorizontalScrollbar() : this.f.overlayHorizontalScrollbar();
    }

    public boolean overlayVerticalScrollbar() {
        return this.e ? this.f.overlayVerticalScrollbar() : this.g.overlayVerticalScrollbar();
    }

    public boolean pageDown(boolean z) {
        return !this.e ? this.g.pageDown(z) : this.f.pageDown(z, -1);
    }

    public boolean pageUp(boolean z) {
        return !this.e ? this.g.pageUp(z) : this.f.pageUp(z, -1);
    }

    public void pauseTimers() {
        if (this.e) {
            this.f.pauseTimers();
        } else {
            this.g.pauseTimers();
        }
    }

    @TargetApi(5)
    public void postUrl(String str, byte[] bArr) {
        if (this.e) {
            this.f.postUrl(str, bArr);
        } else {
            this.g.postUrl(str, bArr);
        }
    }

    @Deprecated
    public void refreshPlugins(boolean z) {
        if (this.e) {
            this.f.refreshPlugins(z);
            return;
        }
        v.a(this.g, "refreshPlugins", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
    }

    public void reload() {
        if (this.e) {
            this.f.reload();
        } else {
            this.g.reload();
        }
    }

    @TargetApi(11)
    public void removeJavascriptInterface(String str) {
        if (!this.e) {
            if (VERSION.SDK_INT >= 11) {
                v.a(this.g, "removeJavascriptInterface", new Class[]{String.class}, str);
                return;
            }
            this.f.removeJavascriptInterface(str);
        }
    }

    public void removeView(android.view.View r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = r6.e;
        if (r0 != 0) goto L_0x000a;
    L_0x0004:
        r0 = r6.g;
        r0.removeView(r7);
        return;
    L_0x000a:
        r0 = r6.f;
        r0 = r0.getView();
        r1 = "removeView";	 Catch:{ Throwable -> 0x0028 }
        r2 = 1;	 Catch:{ Throwable -> 0x0028 }
        r3 = new java.lang.Class[r2];	 Catch:{ Throwable -> 0x0028 }
        r4 = android.view.View.class;	 Catch:{ Throwable -> 0x0028 }
        r5 = 0;	 Catch:{ Throwable -> 0x0028 }
        r3[r5] = r4;	 Catch:{ Throwable -> 0x0028 }
        r1 = com.tencent.smtt.utils.v.a(r0, r1, r3);	 Catch:{ Throwable -> 0x0028 }
        r1.setAccessible(r2);	 Catch:{ Throwable -> 0x0028 }
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0028 }
        r2[r5] = r7;	 Catch:{ Throwable -> 0x0028 }
        r1.invoke(r0, r2);	 Catch:{ Throwable -> 0x0028 }
    L_0x0028:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebView.removeView(android.view.View):void");
    }

    public void reportInitPerformance(long j) {
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        if (this.e) {
            View view2 = this.f.getView();
            if (!(view2 instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) view2;
            if (view == this) {
                view = view2;
            }
            return viewGroup.requestChildRectangleOnScreen(view, rect, z);
        }
        android.webkit.WebView webView = this.g;
        if (view == this) {
            view = this.g;
        }
        return webView.requestChildRectangleOnScreen(view, rect, z);
    }

    public void requestFocusNodeHref(Message message) {
        if (this.e) {
            this.f.requestFocusNodeHref(message);
        } else {
            this.g.requestFocusNodeHref(message);
        }
    }

    public void requestImageRef(Message message) {
        if (this.e) {
            this.f.requestImageRef(message);
        } else {
            this.g.requestImageRef(message);
        }
    }

    @Deprecated
    public boolean restorePicture(Bundle bundle, File file) {
        if (this.e) {
            return this.f.restorePicture(bundle, file);
        }
        Object a = v.a(this.g, "restorePicture", new Class[]{Bundle.class, File.class}, bundle, file);
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    public WebBackForwardList restoreState(Bundle bundle) {
        return !this.e ? WebBackForwardList.a(this.g.restoreState(bundle)) : WebBackForwardList.a(this.f.restoreState(bundle));
    }

    public void resumeTimers() {
        if (this.e) {
            this.f.resumeTimers();
        } else {
            this.g.resumeTimers();
        }
    }

    @Deprecated
    public void savePassword(String str, String str2, String str3) {
        if (this.e) {
            this.f.savePassword(str, str2, str3);
            return;
        }
        v.a(this.g, "savePassword", new Class[]{String.class, String.class, String.class}, str, str2, str3);
    }

    @Deprecated
    public boolean savePicture(Bundle bundle, File file) {
        if (this.e) {
            return this.f.savePicture(bundle, file);
        }
        Object a = v.a(this.g, "savePicture", new Class[]{Bundle.class, File.class}, bundle, file);
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    public WebBackForwardList saveState(Bundle bundle) {
        return !this.e ? WebBackForwardList.a(this.g.saveState(bundle)) : WebBackForwardList.a(this.f.saveState(bundle));
    }

    @TargetApi(11)
    public void saveWebArchive(String str) {
        if (this.e) {
            this.f.saveWebArchive(str);
        } else if (VERSION.SDK_INT >= 11) {
            v.a(this.g, "saveWebArchive", new Class[]{String.class}, str);
        }
    }

    @TargetApi(11)
    public void saveWebArchive(String str, boolean z, ValueCallback<String> valueCallback) {
        if (this.e) {
            this.f.saveWebArchive(str, z, valueCallback);
        } else if (VERSION.SDK_INT >= 11) {
            v.a(this.g, "saveWebArchive", new Class[]{String.class, Boolean.TYPE, ValueCallback.class}, str, Boolean.valueOf(z), valueCallback);
        }
    }

    public void setARModeEnable(boolean z) {
        try {
            if (this.e) {
                getSettingsExtension().setARModeEnable(z);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setBackgroundColor(int i) {
        if (this.e) {
            this.f.setBackgroundColor(i);
        } else {
            this.g.setBackgroundColor(i);
        }
        super.setBackgroundColor(i);
    }

    @Deprecated
    public void setCertificate(SslCertificate sslCertificate) {
        if (this.e) {
            this.f.setCertificate(sslCertificate);
        } else {
            this.g.setCertificate(sslCertificate);
        }
    }

    public void setDayOrNight(boolean z) {
        try {
            if (this.e) {
                getSettingsExtension().setDayOrNight(z);
            }
            setSysDayOrNight(z);
            getView().postInvalidate();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        if (this.e) {
            this.f.setDownloadListener(new b(this, downloadListener, this.e));
        } else {
            this.g.setDownloadListener(new bg(this, downloadListener));
        }
    }

    @TargetApi(16)
    public void setFindListener(FindListener findListener) {
        if (this.e) {
            this.f.setFindListener(findListener);
        } else if (VERSION.SDK_INT >= 16) {
            this.g.setFindListener(new bf(this, findListener));
        }
    }

    public void setHorizontalScrollbarOverlay(boolean z) {
        if (this.e) {
            this.f.setHorizontalScrollbarOverlay(z);
        } else {
            this.g.setHorizontalScrollbarOverlay(z);
        }
    }

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        if (this.e) {
            this.f.setHttpAuthUsernamePassword(str, str2, str3, str4);
        } else {
            this.g.setHttpAuthUsernamePassword(str, str2, str3, str4);
        }
    }

    public void setInitialScale(int i) {
        if (this.e) {
            this.f.setInitialScale(i);
        } else {
            this.g.setInitialScale(i);
        }
    }

    @Deprecated
    public void setMapTrackballToArrowKeys(boolean z) {
        if (this.e) {
            this.f.setMapTrackballToArrowKeys(z);
            return;
        }
        v.a(this.g, "setMapTrackballToArrowKeys", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
    }

    public void setNetworkAvailable(boolean z) {
        if (this.e) {
            this.f.setNetworkAvailable(z);
        } else if (VERSION.SDK_INT >= 3) {
            this.g.setNetworkAvailable(z);
        }
    }

    public void setOnLongClickListener(android.view.View.OnLongClickListener r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.e;
        if (r0 != 0) goto L_0x000a;
    L_0x0004:
        r0 = r4.g;
        r0.setOnLongClickListener(r5);
        return;
    L_0x000a:
        r0 = r4.f;
        r0 = r0.getView();
        r1 = r4.x;	 Catch:{ Throwable -> 0x0042 }
        if (r1 != 0) goto L_0x0039;	 Catch:{ Throwable -> 0x0042 }
    L_0x0014:
        r1 = "getListenerInfo";	 Catch:{ Throwable -> 0x0042 }
        r2 = 0;	 Catch:{ Throwable -> 0x0042 }
        r2 = new java.lang.Class[r2];	 Catch:{ Throwable -> 0x0042 }
        r1 = com.tencent.smtt.utils.v.a(r0, r1, r2);	 Catch:{ Throwable -> 0x0042 }
        r2 = 1;	 Catch:{ Throwable -> 0x0042 }
        r1.setAccessible(r2);	 Catch:{ Throwable -> 0x0042 }
        r3 = 0;	 Catch:{ Throwable -> 0x0042 }
        r0 = r1.invoke(r0, r3);	 Catch:{ Throwable -> 0x0042 }
        r1 = r0.getClass();	 Catch:{ Throwable -> 0x0042 }
        r3 = "mOnLongClickListener";	 Catch:{ Throwable -> 0x0042 }
        r1 = r1.getDeclaredField(r3);	 Catch:{ Throwable -> 0x0042 }
        r1.setAccessible(r2);	 Catch:{ Throwable -> 0x0042 }
        r0 = r1.get(r0);	 Catch:{ Throwable -> 0x0042 }
        r4.x = r0;	 Catch:{ Throwable -> 0x0042 }
    L_0x0039:
        r4.y = r5;
        r5 = r4.getView();
        r5.setOnLongClickListener(r4);
    L_0x0042:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebView.setOnLongClickListener(android.view.View$OnLongClickListener):void");
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        getView().setOnTouchListener(onTouchListener);
    }

    public void setPictureListener(PictureListener pictureListener) {
        if (this.e) {
            if (pictureListener == null) {
                this.f.setPictureListener(null);
            } else {
                this.f.setPictureListener(new bi(this, pictureListener));
            }
        } else if (pictureListener == null) {
            this.g.setPictureListener(null);
        } else {
            this.g.setPictureListener(new bh(this, pictureListener));
        }
    }

    public void setRendererPriorityPolicy(int i, boolean z) {
        try {
            if (!this.e && VERSION.SDK_INT >= 26) {
                v.a(this.g, "setRendererPriorityPolicy", new Class[]{Integer.TYPE, Boolean.TYPE}, Integer.valueOf(i), Boolean.valueOf(z));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setScrollBarStyle(int i) {
        if (this.e) {
            this.f.getView().setScrollBarStyle(i);
        } else {
            this.g.setScrollBarStyle(i);
        }
    }

    public void setSysNightModeAlpha(int i) {
        NIGHT_MODE_ALPHA = i;
    }

    public void setVerticalScrollbarOverlay(boolean z) {
        if (this.e) {
            this.f.setVerticalScrollbarOverlay(z);
        } else {
            this.g.setVerticalScrollbarOverlay(z);
        }
    }

    public boolean setVideoFullScreen(Context context, boolean z) {
        if (!context.getApplicationInfo().processName.contains("com.tencent.android.qqdownloader") || this.f == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putInt("DefaultVideoScreen", 2);
        } else {
            bundle.putInt("DefaultVideoScreen", 1);
        }
        this.f.getX5WebViewExtension().invokeMiscMethod("setVideoParams", bundle);
        return true;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (getView() != null) {
            getView().setVisibility(i);
        }
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        WebChromeClient webChromeClient2 = null;
        if (this.e) {
            IX5WebChromeClient nVar;
            IX5WebViewBase iX5WebViewBase = this.f;
            if (webChromeClient != null) {
                nVar = new n(bk.b().a(true).i(), this, webChromeClient);
            }
            iX5WebViewBase.setWebChromeClient(nVar);
        } else {
            android.webkit.WebView webView = this.g;
            if (webChromeClient != null) {
                webChromeClient2 = new SystemWebChromeClient(this, webChromeClient);
            }
            webView.setWebChromeClient(webChromeClient2);
        }
        this.o = webChromeClient;
    }

    public void setWebChromeClientExtension(IX5WebChromeClientExtension iX5WebChromeClientExtension) {
        if (this.e) {
            this.f.getX5WebViewExtension().setWebChromeClientExtension(iX5WebChromeClientExtension);
        }
    }

    public void setWebViewCallbackClient(WebViewCallbackClient webViewCallbackClient) {
        this.mWebViewCallbackClient = webViewCallbackClient;
        if (this.e && getX5WebViewExtension() != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(AgooConstants.MESSAGE_FLAG, true);
            getX5WebViewExtension().invokeMiscMethod("setWebViewCallbackClientFlag", bundle);
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        WebViewClient webViewClient2 = null;
        if (this.e) {
            IX5WebViewClient sVar;
            IX5WebViewBase iX5WebViewBase = this.f;
            if (webViewClient != null) {
                sVar = new s(bk.b().a(true).j(), this, webViewClient);
            }
            iX5WebViewBase.setWebViewClient(sVar);
        } else {
            android.webkit.WebView webView = this.g;
            if (webViewClient != null) {
                webViewClient2 = new aa(this, webViewClient);
            }
            webView.setWebViewClient(webViewClient2);
        }
        this.n = webViewClient;
    }

    public void setWebViewClientExtension(IX5WebViewClientExtension iX5WebViewClientExtension) {
        if (this.e) {
            this.f.getX5WebViewExtension().setWebViewClientExtension(iX5WebViewClientExtension);
        }
    }

    @SuppressLint({"NewApi"})
    public boolean showDebugView(String str) {
        str = str.toLowerCase();
        if (str.startsWith("http://debugtbs.qq.com")) {
            getView().setVisibility(4);
            e.a(this.i).a(str, this, this.i, ai.a().getLooper());
            return true;
        } else if (!str.startsWith("http://debugx5.qq.com") || this.e) {
            return false;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<!DOCTYPE html><html><body>");
            stringBuilder.append("<head>");
            stringBuilder.append("<title>无法打开debugx5</title>");
            stringBuilder.append("<meta name=\"viewport\" content=\"width=device-width, user-scalable=no\" />");
            stringBuilder.append("</head>");
            stringBuilder.append("<br/><br /><h2>debugx5页面仅在使用了X5内核时有效，由于当前没有使用X5内核，无法打开debugx5！</h2><br />");
            stringBuilder.append("尝试<a href=\"http://debugtbs.qq.com?10000\">进入DebugTbs安装或打开X5内核</a>");
            stringBuilder.append("</body></html>");
            loadDataWithBaseURL(null, stringBuilder.toString(), "text/html", "utf-8", null);
            return true;
        }
    }

    public boolean showFindDialog(String str, boolean z) {
        return false;
    }

    public void stopLoading() {
        if (this.e) {
            this.f.stopLoading();
        } else {
            this.g.stopLoading();
        }
    }

    public void super_computeScroll() {
        if (this.e) {
            try {
                v.a(this.f.getView(), "super_computeScroll");
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        this.g.a();
    }

    public boolean super_dispatchTouchEvent(android.view.MotionEvent r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = r6.e;
        if (r0 != 0) goto L_0x000b;
    L_0x0004:
        r0 = r6.g;
        r7 = r0.b(r7);
        return r7;
    L_0x000b:
        r0 = r6.f;
        r0 = r0.getView();
        r1 = 0;
        r2 = "super_dispatchTouchEvent";	 Catch:{ Throwable -> 0x002d }
        r3 = 1;	 Catch:{ Throwable -> 0x002d }
        r4 = new java.lang.Class[r3];	 Catch:{ Throwable -> 0x002d }
        r5 = android.view.MotionEvent.class;	 Catch:{ Throwable -> 0x002d }
        r4[r1] = r5;	 Catch:{ Throwable -> 0x002d }
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x002d }
        r3[r1] = r7;	 Catch:{ Throwable -> 0x002d }
        r7 = com.tencent.smtt.utils.v.a(r0, r2, r4, r3);	 Catch:{ Throwable -> 0x002d }
        if (r7 != 0) goto L_0x0026;	 Catch:{ Throwable -> 0x002d }
    L_0x0025:
        return r1;	 Catch:{ Throwable -> 0x002d }
    L_0x0026:
        r7 = (java.lang.Boolean) r7;	 Catch:{ Throwable -> 0x002d }
        r7 = r7.booleanValue();	 Catch:{ Throwable -> 0x002d }
        return r7;
    L_0x002d:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebView.super_dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean super_onInterceptTouchEvent(android.view.MotionEvent r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = r6.e;
        if (r0 != 0) goto L_0x000b;
    L_0x0004:
        r0 = r6.g;
        r7 = r0.c(r7);
        return r7;
    L_0x000b:
        r0 = r6.f;
        r0 = r0.getView();
        r1 = 0;
        r2 = "super_onInterceptTouchEvent";	 Catch:{ Throwable -> 0x002d }
        r3 = 1;	 Catch:{ Throwable -> 0x002d }
        r4 = new java.lang.Class[r3];	 Catch:{ Throwable -> 0x002d }
        r5 = android.view.MotionEvent.class;	 Catch:{ Throwable -> 0x002d }
        r4[r1] = r5;	 Catch:{ Throwable -> 0x002d }
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x002d }
        r3[r1] = r7;	 Catch:{ Throwable -> 0x002d }
        r7 = com.tencent.smtt.utils.v.a(r0, r2, r4, r3);	 Catch:{ Throwable -> 0x002d }
        if (r7 != 0) goto L_0x0026;	 Catch:{ Throwable -> 0x002d }
    L_0x0025:
        return r1;	 Catch:{ Throwable -> 0x002d }
    L_0x0026:
        r7 = (java.lang.Boolean) r7;	 Catch:{ Throwable -> 0x002d }
        r7 = r7.booleanValue();	 Catch:{ Throwable -> 0x002d }
        return r7;
    L_0x002d:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebView.super_onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public void super_onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (this.e) {
            try {
                v.a(this.f.getView(), "super_onOverScrolled", new Class[]{Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE}, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2));
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        this.g.a(i, i2, z, z2);
    }

    public void super_onScrollChanged(int i, int i2, int i3, int i4) {
        if (this.e) {
            try {
                v.a(this.f.getView(), "super_onScrollChanged", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        this.g.a(i, i2, i3, i4);
    }

    public boolean super_onTouchEvent(android.view.MotionEvent r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = r6.e;
        if (r0 != 0) goto L_0x000b;
    L_0x0004:
        r0 = r6.g;
        r7 = r0.a(r7);
        return r7;
    L_0x000b:
        r0 = r6.f;
        r0 = r0.getView();
        r1 = 0;
        r2 = "super_onTouchEvent";	 Catch:{ Throwable -> 0x002d }
        r3 = 1;	 Catch:{ Throwable -> 0x002d }
        r4 = new java.lang.Class[r3];	 Catch:{ Throwable -> 0x002d }
        r5 = android.view.MotionEvent.class;	 Catch:{ Throwable -> 0x002d }
        r4[r1] = r5;	 Catch:{ Throwable -> 0x002d }
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x002d }
        r3[r1] = r7;	 Catch:{ Throwable -> 0x002d }
        r7 = com.tencent.smtt.utils.v.a(r0, r2, r4, r3);	 Catch:{ Throwable -> 0x002d }
        if (r7 != 0) goto L_0x0026;	 Catch:{ Throwable -> 0x002d }
    L_0x0025:
        return r1;	 Catch:{ Throwable -> 0x002d }
    L_0x0026:
        r7 = (java.lang.Boolean) r7;	 Catch:{ Throwable -> 0x002d }
        r7 = r7.booleanValue();	 Catch:{ Throwable -> 0x002d }
        return r7;
    L_0x002d:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebView.super_onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean super_overScrollBy(int r16, int r17, int r18, int r19, int r20, int r21, int r22, int r23, boolean r24) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r15 = this;
        r0 = r15;
        r1 = r0.e;
        if (r1 != 0) goto L_0x001e;
    L_0x0005:
        r2 = r0.g;
        r3 = r16;
        r4 = r17;
        r5 = r18;
        r6 = r19;
        r7 = r20;
        r8 = r21;
        r9 = r22;
        r10 = r23;
        r11 = r24;
        r1 = r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11);
        return r1;
    L_0x001e:
        r1 = r0.f;
        r1 = r1.getView();
        r2 = 0;
        r3 = "super_overScrollBy";	 Catch:{ Throwable -> 0x009e }
        r4 = 9;	 Catch:{ Throwable -> 0x009e }
        r5 = new java.lang.Class[r4];	 Catch:{ Throwable -> 0x009e }
        r6 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x009e }
        r5[r2] = r6;	 Catch:{ Throwable -> 0x009e }
        r6 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x009e }
        r7 = 1;	 Catch:{ Throwable -> 0x009e }
        r5[r7] = r6;	 Catch:{ Throwable -> 0x009e }
        r6 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x009e }
        r8 = 2;	 Catch:{ Throwable -> 0x009e }
        r5[r8] = r6;	 Catch:{ Throwable -> 0x009e }
        r6 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x009e }
        r9 = 3;	 Catch:{ Throwable -> 0x009e }
        r5[r9] = r6;	 Catch:{ Throwable -> 0x009e }
        r6 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x009e }
        r10 = 4;	 Catch:{ Throwable -> 0x009e }
        r5[r10] = r6;	 Catch:{ Throwable -> 0x009e }
        r6 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x009e }
        r11 = 5;	 Catch:{ Throwable -> 0x009e }
        r5[r11] = r6;	 Catch:{ Throwable -> 0x009e }
        r6 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x009e }
        r12 = 6;	 Catch:{ Throwable -> 0x009e }
        r5[r12] = r6;	 Catch:{ Throwable -> 0x009e }
        r6 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x009e }
        r13 = 7;	 Catch:{ Throwable -> 0x009e }
        r5[r13] = r6;	 Catch:{ Throwable -> 0x009e }
        r6 = java.lang.Boolean.TYPE;	 Catch:{ Throwable -> 0x009e }
        r14 = 8;	 Catch:{ Throwable -> 0x009e }
        r5[r14] = r6;	 Catch:{ Throwable -> 0x009e }
        r4 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x009e }
        r6 = java.lang.Integer.valueOf(r16);	 Catch:{ Throwable -> 0x009e }
        r4[r2] = r6;	 Catch:{ Throwable -> 0x009e }
        r6 = java.lang.Integer.valueOf(r17);	 Catch:{ Throwable -> 0x009e }
        r4[r7] = r6;	 Catch:{ Throwable -> 0x009e }
        r6 = java.lang.Integer.valueOf(r18);	 Catch:{ Throwable -> 0x009e }
        r4[r8] = r6;	 Catch:{ Throwable -> 0x009e }
        r6 = java.lang.Integer.valueOf(r19);	 Catch:{ Throwable -> 0x009e }
        r4[r9] = r6;	 Catch:{ Throwable -> 0x009e }
        r6 = java.lang.Integer.valueOf(r20);	 Catch:{ Throwable -> 0x009e }
        r4[r10] = r6;	 Catch:{ Throwable -> 0x009e }
        r6 = java.lang.Integer.valueOf(r21);	 Catch:{ Throwable -> 0x009e }
        r4[r11] = r6;	 Catch:{ Throwable -> 0x009e }
        r6 = java.lang.Integer.valueOf(r22);	 Catch:{ Throwable -> 0x009e }
        r4[r12] = r6;	 Catch:{ Throwable -> 0x009e }
        r6 = java.lang.Integer.valueOf(r23);	 Catch:{ Throwable -> 0x009e }
        r4[r13] = r6;	 Catch:{ Throwable -> 0x009e }
        r6 = java.lang.Boolean.valueOf(r24);	 Catch:{ Throwable -> 0x009e }
        r4[r14] = r6;	 Catch:{ Throwable -> 0x009e }
        r1 = com.tencent.smtt.utils.v.a(r1, r3, r5, r4);	 Catch:{ Throwable -> 0x009e }
        if (r1 != 0) goto L_0x0097;	 Catch:{ Throwable -> 0x009e }
    L_0x0096:
        return r2;	 Catch:{ Throwable -> 0x009e }
    L_0x0097:
        r1 = (java.lang.Boolean) r1;	 Catch:{ Throwable -> 0x009e }
        r1 = r1.booleanValue();	 Catch:{ Throwable -> 0x009e }
        return r1;
    L_0x009e:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebView.super_overScrollBy(int, int, int, int, int, int, int, int, boolean):boolean");
    }

    public void switchNightMode(boolean z) {
        if (z != w) {
            String str;
            w = z;
            if (z) {
                TbsLog.e("QB_SDK", "deleteNightMode");
                str = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
            } else {
                TbsLog.e("QB_SDK", "nightMode");
                str = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
            }
            loadUrl(str);
        }
    }

    public void switchToNightMode() {
        TbsLog.e("QB_SDK", "switchToNightMode 01");
        if (!w) {
            TbsLog.e("QB_SDK", "switchToNightMode");
            loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
        }
    }

    public boolean zoomIn() {
        return !this.e ? this.g.zoomIn() : this.f.zoomIn();
    }

    public boolean zoomOut() {
        return !this.e ? this.g.zoomOut() : this.f.zoomOut();
    }
}
