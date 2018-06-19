package com.xunlei.downloadprovider.web.base.core;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebSettings.TextSize;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.xunlei.common.commonview.UnifiedLoadingView;
import com.xunlei.common.encrypt.CharsetConvert;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class CustomWebView extends FrameLayout {
    private ErrorBlankView a;
    @Nullable
    private ObservableWebView b;
    private WebView c;
    private String d = "";
    private List<b> e = null;
    private DefaultJsInterface f;
    private String g;
    private boolean h = true;
    private c i;
    private c j;
    private Handler k = new c(this);
    private UnifiedLoadingView l;
    private boolean m;
    private b n = new b();
    private h o = new f(this);
    private DownloadListener p = new g(this);
    private a q = null;

    public interface a {
        void a(String str);

        void a(String str, int i);
    }

    public interface b {
        void a();

        void a(WebView webView);
    }

    public interface c {
        void a(boolean z);
    }

    public CustomWebView(Context context) {
        super(context);
        a(context);
    }

    public CustomWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public CustomWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    protected void onDetachedFromWindow() {
        k();
        super.onDetachedFromWindow();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void k() {
        /*
        r3 = this;
        r0 = r3.c;
        if (r0 == 0) goto L_0x0034;
    L_0x0004:
        r0 = 0;
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x002a }
        r2 = "Destroy WebView; ";
        r1.<init>(r2);	 Catch:{ Throwable -> 0x002a }
        r2 = r3.c;	 Catch:{ Throwable -> 0x002a }
        r1.append(r2);	 Catch:{ Throwable -> 0x002a }
        r1 = r3.c;	 Catch:{ Throwable -> 0x002a }
        r1.destroy();	 Catch:{ Throwable -> 0x002a }
        r1 = r3.c;	 Catch:{ Throwable -> 0x002a }
        r1 = r1.getParent();	 Catch:{ Throwable -> 0x002a }
        if (r1 == 0) goto L_0x0025;
    L_0x001e:
        r1 = (android.view.ViewGroup) r1;	 Catch:{ Throwable -> 0x002a }
        r2 = r3.c;	 Catch:{ Throwable -> 0x002a }
        r1.removeView(r2);	 Catch:{ Throwable -> 0x002a }
    L_0x0025:
        r3.c = r0;
        return;
    L_0x0028:
        r1 = move-exception;
        goto L_0x0031;
    L_0x002a:
        r1 = move-exception;
        com.tencent.bugly.crashreport.CrashReport.postCatchedException(r1);	 Catch:{ all -> 0x0028 }
        r3.c = r0;
        return;
    L_0x0031:
        r3.c = r0;
        throw r1;
    L_0x0034:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.web.base.core.CustomWebView.k():void");
    }

    private void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.custom_webview_layout, this, true);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.custom_webview_layout);
        this.l = (UnifiedLoadingView) inflate.findViewById(R.id.progress_load_root);
        this.a = (ErrorBlankView) inflate.findViewById(R.id.error_layout);
        this.a.setActionButtonListener(new d(this));
        this.l.setType(1);
        this.b = new ObservableWebView(context.getApplicationContext());
        this.b.setScrollBarStyle(0);
        frameLayout.addView(this.b, 0, new LayoutParams(-1, -1));
        context = this.b;
        if (VERSION.SDK_INT >= 19 && (getContext().getApplicationInfo().flags & 2) != 0) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        if (!isInEditMode()) {
            if (VERSION.SDK_INT >= 21) {
                CookieManager.getInstance().setAcceptThirdPartyCookies(context, true);
            }
            CookieManager.getInstance().setAcceptCookie(true);
            WebSettings settings = context.getSettings();
            StringBuilder stringBuilder = new StringBuilder(settings.getUserAgentString());
            stringBuilder.append(" iThunder");
            settings.setUserAgentString(stringBuilder.toString());
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(getContext().getApplicationContext().getDir("database", 0).getPath());
            settings.setLoadWithOverviewMode(true);
            settings.setRenderPriority(RenderPriority.HIGH);
            settings.setBlockNetworkImage(false);
            settings.setAppCacheEnabled(true);
            settings.setAppCachePath(getContext().getApplicationContext().getCacheDir().getPath());
            settings.setDefaultTextEncodingName(CharsetConvert.GBK);
            settings.setSupportZoom(false);
            settings.setBuiltInZoomControls(false);
            settings.setDisplayZoomControls(false);
            settings.setTextSize(TextSize.NORMAL);
            if (VERSION.SDK_INT >= 17) {
                settings.setMediaPlaybackRequiresUserGesture(false);
            }
            context.setScrollBarStyle(33554432);
            context.getSettings().setUseWideViewPort(true);
            context.setWebChromeClient(this.n);
            context.setWebViewClient(this.o);
            this.f = new DefaultJsInterface(getContext(), this);
            context.addJavascriptInterface(this.f, BaseJsInterface.NAME);
            context.setDownloadListener(this.p);
            new StringBuilder("Create WebView; ").append(context);
        }
    }

    public void setProgressType(int i) {
        switch (i) {
            case 1:
                this.l.setType(1);
                return;
            case 2:
                this.l.setType(2);
                break;
            case 3:
                break;
            default:
                break;
        }
        this.l.setType(2);
    }

    public final void a() {
        if (this.h) {
            if (this.k.hasMessages(1)) {
                this.k.removeMessages(1);
            }
            if (!(this.l == null || this.l.getVisibility() == 0)) {
                this.l.show();
                if (this.j != null) {
                    this.j.a(true);
                }
            }
        }
    }

    public final void b() {
        if (this.k.hasMessages(2)) {
            this.k.removeMessages(2);
        }
        if (!com.xunlei.xllib.android.b.a(getContext())) {
            this.a.setErrorType(2);
        }
        if (this.a.getVisibility() != 0) {
            this.a.setVisibility(0);
            if (this.i != null) {
                this.i.a(true);
            }
        }
    }

    public final void c() {
        if (this.k.hasMessages(2)) {
            this.k.removeMessages(2);
        }
        this.k.sendEmptyMessageDelayed(2, 500);
    }

    public final void a(boolean z) {
        this.m = true;
        if (z) {
            if (this.k.hasMessages(1)) {
                this.k.removeMessages(1);
            }
            this.k.sendEmptyMessageDelayed(1, 500);
            return;
        }
        this.k.sendEmptyMessage(1);
    }

    public final void d() {
        if (this.f != null) {
            this.f.clearInterceptors();
            this.f.destroy();
            this.f = null;
        }
        com.xunlei.downloadprovider.h.c.a(BrothersApplication.getApplicationInstance(), "action_finish_login_dialog", null);
        if (this.b != null) {
            this.b.stopLoading();
            this.l.hide();
            this.c = this.b;
            this.b.removeJavascriptInterface(BaseJsInterface.NAME);
            this.b.setDownloadListener(null);
            this.b = null;
            postDelayed(new e(this), 500);
        }
    }

    public final void e() {
        if (this.b != null) {
            this.b.onResume();
        }
    }

    public final void f() {
        if (this.b != null) {
            this.b.onPause();
        }
    }

    public String getUrl() {
        return this.b != null ? this.b.getUrl() : "";
    }

    public final void g() {
        if (this.b != null) {
            this.b.stopLoading();
        }
    }

    public WebSettings getSettings() {
        return this.b != null ? this.b.getSettings() : null;
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str) && this.b != null) {
            if (!str.startsWith("javascript:")) {
                c();
                this.b.loadUrl(str);
                a();
                this.g = str;
            } else if (VERSION.SDK_INT >= 19) {
                str = str.substring(11);
                if (!TextUtils.isEmpty(str)) {
                    this.b.evaluateJavascript(str, null);
                }
            } else {
                this.b.loadUrl(str);
            }
        }
    }

    public void setErrorViewVisibilityListener(c cVar) {
        this.i = cVar;
    }

    public void setProgressVisibilityListener(c cVar) {
        this.j = cVar;
    }

    public String getFrom() {
        return this.d;
    }

    public void setFrom(String str) {
        this.d = str;
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.n.a = webChromeClient;
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        this.o.b = webViewClient;
    }

    public final void a(ag agVar) {
        if (agVar != null) {
            agVar.b = this.f;
            this.f.addInterceptor(agVar);
        }
    }

    public void setOnScrollChangedListener(com.xunlei.downloadprovider.web.base.core.ObservableWebView.a aVar) {
        this.b.setOnScrollChangedListener(aVar);
    }

    public final boolean h() {
        return this.b != null ? this.b.canGoBack() : false;
    }

    public final void i() {
        if (this.b != null) {
            this.b.goBack();
        }
    }

    public final void a(b bVar) {
        if (this.e == null) {
            this.e = new ArrayList();
        }
        this.e.add(bVar);
    }

    public final void j() {
        if (this.b != null) {
            this.b.loadUrl("javascript:document.body.innerHTML=\"\";");
        }
    }

    public void setShowLoading(boolean z) {
        this.h = z;
    }

    public ObservableWebView getWebView() {
        return this.b;
    }

    public int getContentHeight() {
        return this.b != null ? this.b.getContentHeight() : 0;
    }

    public int getWebViewScrollY() {
        return this.b != null ? this.b.getScrollY() : 0;
    }

    public int getWebViewHeight() {
        return this.b != null ? this.b.getHeight() : 0;
    }

    public float getScale() {
        return this.b != null ? this.b.getScale() : 0.0f;
    }

    public ae getJsInterfaceClientSettings() {
        return this.f != null ? this.f.getJsInterfaceClientSettings() : null;
    }

    public void setOnDeepLinkCallListener(a aVar) {
        this.q = aVar;
    }

    static /* synthetic */ void a(CustomWebView customWebView) {
        if (customWebView.l != null && customWebView.l.getVisibility() == 0) {
            customWebView.l.hide();
            if (customWebView.j != null) {
                customWebView.j.a(false);
            }
        }
    }

    static /* synthetic */ void b(CustomWebView customWebView) {
        if (customWebView.a.getVisibility() == 0) {
            customWebView.a.setVisibility(8);
            if (customWebView.i != null) {
                customWebView.i.a(false);
            }
        }
    }

    static /* synthetic */ void a(CustomWebView customWebView, String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", str);
            str = com.alipay.sdk.cons.c.e;
            if (str2 == null) {
                str2 = "";
            }
            jSONObject.put(str, str2);
            str = "refurl";
            if (str3 == null) {
                str3 = "";
            }
            jSONObject.put(str, str3);
            jSONObject.put("createOrigin", str4 == null ? "" : str4);
            if (customWebView.f != null) {
                customWebView.f.xlAddTask(jSONObject, str4);
            }
        } catch (CustomWebView customWebView2) {
            customWebView2.printStackTrace();
        }
    }
}
