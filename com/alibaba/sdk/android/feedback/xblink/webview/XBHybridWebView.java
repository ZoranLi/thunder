package com.alibaba.sdk.android.feedback.xblink.webview;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;
import anet.channel.util.HttpConstant;
import com.alibaba.sdk.android.feedback.R;
import com.alibaba.sdk.android.feedback.util.k;
import com.alibaba.sdk.android.feedback.xblink.f.b.b;
import com.alibaba.sdk.android.feedback.xblink.f.j;
import com.alibaba.sdk.android.feedback.xblink.i.g;
import com.alibaba.sdk.android.feedback.xblink.i.h;
import com.alibaba.sdk.android.feedback.xblink.view.a;
import com.taobao.accs.common.Constants;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class XBHybridWebView extends WebView implements Callback {
    public static final int NOTIFY_PAGE_ERROR = 402;
    public static final int NOTIFY_PAGE_FINISH = 401;
    public static final int NOTIFY_PAGE_START = 400;
    public static final int NOTIFY_SAVE_IMAGE_FAIL = 405;
    public static final int NOTIFY_SAVE_IMAGE_SUCCESS = 404;
    public static final int NOTIFY_TIME_OUT = 403;
    public static final int NOTIFY_TOOL_BAR_SETTING = 406;
    private static final String TAG = "HybridWebView";
    private String appkey;
    public Context context;
    private String currentUrl;
    protected j entryManager;
    private b event;
    protected boolean isAlive;
    private long loadTime;
    protected Handler mHandler;
    private String mImageUrl;
    private a mPopupController;
    private String[] mPopupMenuTags;
    private long onErrorTime;
    private OnClickListener popupClickListener;
    protected boolean supportDownload;
    protected WebChromeClient webChromeClient;
    protected WebViewClient webViewClient;
    private boolean wvSupportNativeJs;
    private v wvUIModel;

    public XBHybridWebView(Context context) {
        super(context);
        this.mHandler = null;
        this.wvUIModel = null;
        this.supportDownload = true;
        this.wvSupportNativeJs = true;
        this.currentUrl = "";
        this.appkey = "";
        this.loadTime = System.currentTimeMillis();
        this.onErrorTime = 0;
        this.mPopupMenuTags = new String[]{"保存到相册"};
        this.popupClickListener = new o(this);
        this.context = context;
        init();
    }

    public XBHybridWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.wvUIModel = null;
        this.supportDownload = true;
        this.wvSupportNativeJs = true;
        this.currentUrl = "";
        this.appkey = "";
        this.loadTime = System.currentTimeMillis();
        this.onErrorTime = 0;
        this.mPopupMenuTags = new String[]{"保存到相册"};
        this.popupClickListener = new o(this);
        this.context = context;
        init();
    }

    public XBHybridWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.wvUIModel = null;
        this.supportDownload = true;
        this.wvSupportNativeJs = true;
        this.currentUrl = "";
        this.appkey = "";
        this.loadTime = System.currentTimeMillis();
        this.onErrorTime = 0;
        this.mPopupMenuTags = new String[]{"保存到相册"};
        this.popupClickListener = new o(this);
        this.context = context;
        init();
    }

    private String addTTID(String str) {
        if (str == null) {
            return null;
        }
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        String scheme = parse.getScheme();
        if (host != null && host.endsWith("m.taobao.com") && ((HttpConstant.HTTP.equals(scheme) || "https".equals(scheme)) && parse.getQueryParameter(Constants.KEY_TTID) == null)) {
            Builder buildUpon = parse.buildUpon();
            buildUpon.appendQueryParameter(Constants.KEY_TTID, com.alibaba.sdk.android.feedback.xblink.b.b.a().b());
            str = buildUpon.toString();
        }
        return str;
    }

    @android.annotation.SuppressLint({"NewApi", "SetJavaScriptEnabled"})
    private void init() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r7 = this;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 1;
        r2 = 19;
        if (r0 < r2) goto L_0x000a;
    L_0x0007:
        android.webkit.WebView.setWebContentsDebuggingEnabled(r1);
    L_0x000a:
        r0 = new android.os.Handler;
        r2 = android.os.Looper.getMainLooper();
        r0.<init>(r2, r7);
        r7.mHandler = r0;
        r0 = new com.alibaba.sdk.android.feedback.xblink.webview.HybridWebViewClient;
        r2 = r7.context;
        r0.<init>(r2);
        r7.webViewClient = r0;
        r0 = r7.webViewClient;
        super.setWebViewClient(r0);
        r0 = new com.alibaba.sdk.android.feedback.xblink.webview.HybridWebChromeClient;
        r2 = r7.context;
        r0.<init>(r2);
        r7.webChromeClient = r0;
        r0 = r7.webChromeClient;
        super.setWebChromeClient(r0);
        r0 = 0;
        r7.setVerticalScrollBarEnabled(r0);
        r7.requestFocus();
        r2 = android.webkit.CookieManager.getInstance();
        r2.setAcceptCookie(r1);
        r2 = r7.getSettings();
        r2.setAllowFileAccess(r0);
        r2.setJavaScriptEnabled(r1);	 Catch:{ Throwable -> 0x004a }
        goto L_0x0059;
    L_0x004a:
        r3 = move-exception;
        r4 = new java.lang.StringBuilder;
        r5 = "Failed to enable javascript on device, ";
        r4.<init>(r5);
        r3 = r3.getMessage();
        r4.append(r3);
    L_0x0059:
        r3 = com.alibaba.sdk.android.feedback.xblink.b.b.a();
        r3 = r3.c();
        r4 = com.alibaba.sdk.android.feedback.xblink.b.b.a();
        r4 = r4.d();
        r5 = android.text.TextUtils.isEmpty(r3);
        if (r5 != 0) goto L_0x009d;
    L_0x006f:
        r5 = android.text.TextUtils.isEmpty(r4);
        if (r5 != 0) goto L_0x009d;
    L_0x0075:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = r2.getUserAgentString();
        r5.append(r6);
        r6 = " AliApp(";
        r5.append(r6);
        r5.append(r3);
        r3 = "/";
        r5.append(r3);
        r5.append(r4);
        r3 = ")";
        r5.append(r3);
        r3 = r5.toString();
        r2.setUserAgentString(r3);
    L_0x009d:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = r2.getUserAgentString();
        r3.append(r4);
        r4 = " WindVane/4.5.1";
        r3.append(r4);
        r3 = r3.toString();
        r2.setUserAgentString(r3);
        r3 = -1;
        r2.setCacheMode(r3);
        r3 = android.os.Build.VERSION.SDK_INT;
        r4 = 5;
        if (r3 < r4) goto L_0x00e9;
    L_0x00be:
        r2.setDatabaseEnabled(r1);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = r7.context;
        r4 = r4.getFilesDir();
        r4 = r4.getParentFile();
        r4 = r4.getPath();
        r3.append(r4);
        r4 = "/databases";
        r3.append(r4);
        r3 = r3.toString();
        r2.setDatabasePath(r3);
        r2.setGeolocationEnabled(r1);
        r2.setGeolocationDatabasePath(r3);
    L_0x00e9:
        r3 = android.os.Build.VERSION.SDK_INT;
        r4 = 21;
        if (r3 < r4) goto L_0x00f2;
    L_0x00ef:
        r2.setMixedContentMode(r0);
    L_0x00f2:
        r3 = android.os.Build.VERSION.SDK_INT;
        r4 = 7;
        if (r3 < r4) goto L_0x0116;
    L_0x00f7:
        r2.setDomStorageEnabled(r1);
        r2.setAppCacheEnabled(r1);
        r3 = r7.context;
        if (r3 == 0) goto L_0x0116;
    L_0x0101:
        r3 = r7.context;
        r3 = r3.getCacheDir();
        if (r3 == 0) goto L_0x0116;
    L_0x0109:
        r3 = r7.context;
        r3 = r3.getCacheDir();
        r3 = r3.getAbsolutePath();
        r2.setAppCachePath(r3);
    L_0x0116:
        r3 = android.os.Build.VERSION.SDK_INT;
        r4 = 18;
        if (r3 >= r4) goto L_0x011f;
    L_0x011c:
        r2.setSavePassword(r0);
    L_0x011f:
        r3 = android.os.Build.VERSION.SDK_INT;
        r4 = 16;
        if (r3 < r4) goto L_0x012b;
    L_0x0125:
        r2.setAllowUniversalAccessFromFileURLs(r0);
        r2.setAllowFileAccessFromFileURLs(r0);
    L_0x012b:
        r2 = com.alibaba.sdk.android.feedback.xblink.f.d.a();
        r2.b();
        r2 = new com.alibaba.sdk.android.feedback.xblink.f.j;
        r3 = r7.context;
        r2.<init>(r3, r7);
        r7.entryManager = r2;
        r2 = new com.alibaba.sdk.android.feedback.xblink.f.b.b;
        r2.<init>();
        r7.event = r2;
        r2 = r7.event;
        r3 = r7.context;
        r2.a(r3, r7);
        r2 = "WXAppEvent";
        r3 = r7.event;
        r7.addJsObject(r2, r3);
        r2 = android.os.Build.VERSION.SDK_INT;
        r3 = 15;
        if (r2 <= r3) goto L_0x018f;
    L_0x0156:
        r2 = r7.context;	 Catch:{ Exception -> 0x018f }
        r3 = "clipboard";	 Catch:{ Exception -> 0x018f }
        r2 = r2.getSystemService(r3);	 Catch:{ Exception -> 0x018f }
        r2 = (android.content.ClipboardManager) r2;	 Catch:{ Exception -> 0x018f }
        if (r2 == 0) goto L_0x018f;	 Catch:{ Exception -> 0x018f }
    L_0x0162:
        r3 = r2.getPrimaryClip();	 Catch:{ Exception -> 0x018f }
        if (r3 != 0) goto L_0x0174;	 Catch:{ Exception -> 0x018f }
    L_0x0168:
        r0 = "初始化";	 Catch:{ Exception -> 0x018f }
        r3 = "";	 Catch:{ Exception -> 0x018f }
    L_0x016c:
        r0 = android.content.ClipData.newPlainText(r0, r3);	 Catch:{ Exception -> 0x018f }
        r2.setPrimaryClip(r0);	 Catch:{ Exception -> 0x018f }
        goto L_0x018f;	 Catch:{ Exception -> 0x018f }
    L_0x0174:
        r4 = "intent:#Intent;S.K_1171477665=;end";	 Catch:{ Exception -> 0x018f }
        r0 = r3.getItemAt(r0);	 Catch:{ Exception -> 0x018f }
        r3 = r7.context;	 Catch:{ Exception -> 0x018f }
        r0 = r0.coerceToText(r3);	 Catch:{ Exception -> 0x018f }
        r0 = r0.toString();	 Catch:{ Exception -> 0x018f }
        r0 = r4.equals(r0);	 Catch:{ Exception -> 0x018f }
        if (r0 == 0) goto L_0x018f;	 Catch:{ Exception -> 0x018f }
    L_0x018a:
        r0 = "初始化";	 Catch:{ Exception -> 0x018f }
        r3 = "";	 Catch:{ Exception -> 0x018f }
        goto L_0x016c;
    L_0x018f:
        r0 = new com.alibaba.sdk.android.feedback.xblink.webview.v;
        r2 = r7.context;
        r0.<init>(r2, r7);
        r7.wvUIModel = r0;
        r0 = new com.alibaba.sdk.android.feedback.xblink.webview.n;
        r0.<init>(r7);
        r7.setOnLongClickListener(r0);
        r0 = new com.alibaba.sdk.android.feedback.xblink.webview.s;
        r0.<init>(r7);
        r7.setDownloadListener(r0);
        com.alibaba.sdk.android.feedback.xblink.webview.l.a();
        r7.isAlive = r1;
        r0 = "searchBoxJavaBridge_";
        r7.removeJavascriptInterface(r0);
        r0 = "accessibility";
        r7.removeJavascriptInterface(r0);
        r0 = "accessibilityTraversal";
        r7.removeJavascriptInterface(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView.init():void");
    }

    private void setPageTitle(String str) {
        k.b(this.context, str);
    }

    private void updateReturnButtonBehaviour(boolean r3, java.lang.String r4) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = this;
        r0 = r2.context;
        r0 = (android.app.Activity) r0;
        r1 = com.alibaba.sdk.android.feedback.R.id.title_back;
        r0 = r0.findViewById(r1);
        r1 = r2.context;	 Catch:{ ClassCastException -> 0x0011 }
        r1 = (com.alibaba.sdk.android.feedback.xblink.activity.XBBaseHybridActivity) r1;	 Catch:{ ClassCastException -> 0x0011 }
        r1.setJSControlledBackPress(r3, r4);	 Catch:{ ClassCastException -> 0x0011 }
    L_0x0011:
        if (r3 == 0) goto L_0x001c;
    L_0x0013:
        r3 = new com.alibaba.sdk.android.feedback.xblink.webview.p;
        r3.<init>(r2, r4);
    L_0x0018:
        r0.setOnClickListener(r3);
        return;
    L_0x001c:
        r3 = new com.alibaba.sdk.android.feedback.xblink.webview.q;
        r3.<init>(r2);
        goto L_0x0018;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView.updateReturnButtonBehaviour(boolean, java.lang.String):void");
    }

    private void updateRightNavButton(boolean z, String str, String str2) {
        TextView textView = (TextView) ((Activity) this.context).findViewById(R.id.title_button);
        if (z) {
            k.a(this.context, str);
            textView.setOnClickListener(new r(this, str2));
            return;
        }
        k.a(this.context);
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.wvSupportNativeJs || VERSION.SDK_INT >= 17) {
            if (VERSION.SDK_INT >= 17) {
                super.addJavascriptInterface(obj, str);
            }
            return;
        }
        g.b(TAG, "addJavascriptInterface is disabled before API level 17 for security.");
    }

    public void addJsObject(String str, Object obj) {
        if (this.entryManager != null) {
            this.entryManager.a(str, obj);
        }
    }

    public void destroy() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = this;
        r0 = r2.isAlive;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = 0;
        r2.isAlive = r0;
        r0 = 0;
        super.setWebViewClient(r0);
        super.setWebChromeClient(r0);
        r2.webViewClient = r0;
        r2.webChromeClient = r0;
        r1 = r2.entryManager;
        r1.a();
        r1 = com.alibaba.sdk.android.feedback.xblink.a.b.a();
        r1.b();
        r1 = r2.mHandler;
        r1.removeCallbacksAndMessages(r0);
        r2.removeAllViews();
        super.destroy();	 Catch:{ Exception -> 0x002a }
    L_0x002a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView.destroy():void");
    }

    public void enableTakeDownload(boolean z) {
        if (this.webViewClient instanceof HybridWebViewClient) {
            ((HybridWebViewClient) this.webViewClient).enableTakeDownload(z);
        }
    }

    public String getAppkey() {
        return this.appkey;
    }

    public String getCurrentUrl() {
        return this.currentUrl;
    }

    public Object getJsObject(String str) {
        return this.entryManager == null ? null : this.entryManager.a(str);
    }

    public long getLoadTimestamp() {
        return this.loadTime;
    }

    public com.alibaba.sdk.android.feedback.xblink.e.a getUrlFilter() {
        return this.webViewClient instanceof HybridWebViewClient ? ((HybridWebViewClient) this.webViewClient).getUrlFilter() : null;
    }

    public synchronized com.alibaba.sdk.android.feedback.xblink.f.b getWVCallBackContext() {
        if (this.event == null) {
            return null;
        }
        return this.event.d();
    }

    public Handler getWVHandler() {
        return this.mHandler;
    }

    public v getWvUIModel() {
        return this.wvUIModel;
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 400:
                this.wvUIModel.b();
                return true;
            case 401:
                this.wvUIModel.c();
                if (this.onErrorTime != 0 && System.currentTimeMillis() - this.onErrorTime > 3000) {
                    this.wvUIModel.e();
                }
                return true;
            case 402:
                this.wvUIModel.d();
                this.onErrorTime = System.currentTimeMillis();
                return true;
            case 403:
                this.wvUIModel.c();
                return true;
            case 404:
                Toast.makeText(this.context, "图片保存到相册成功", 1).show();
                return true;
            case 405:
                Toast.makeText(this.context, "图片保存到相册失败", 1).show();
                return true;
            case 406:
                try {
                    String string;
                    JSONObject jSONObject = new JSONObject((String) message.obj);
                    if (jSONObject.has("pageTitle")) {
                        setPageTitle(jSONObject.getString("pageTitle"));
                    }
                    boolean z = jSONObject.getBoolean("canGoBack");
                    String str = null;
                    updateReturnButtonBehaviour(z, z ? jSONObject.getString("backCallback") : null);
                    z = jSONObject.getBoolean("haveRightNavButton");
                    if (z) {
                        str = jSONObject.getString("rightButtonContent");
                        string = jSONObject.getString("rightButtonCallback");
                    } else {
                        string = null;
                    }
                    updateRightNavButton(z, str, string);
                    k.b(this.context);
                    return true;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return true;
                }
            default:
                return false;
        }
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public void loadData(String str, String str2, String str3) {
        if (this.isAlive) {
            super.loadData(str, str2, str3);
            this.loadTime = System.currentTimeMillis();
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (this.isAlive) {
            if (g.a()) {
                String str6 = TAG;
                StringBuilder stringBuilder = new StringBuilder("loadDataWithBaseURL: baseUrl=");
                stringBuilder.append(str);
                g.a(str6, stringBuilder.toString());
            }
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
            this.loadTime = System.currentTimeMillis();
        }
    }

    public void loadUrl(String str) {
        if (this.isAlive && str != null) {
            if (g.a()) {
                String str2 = TAG;
                StringBuilder stringBuilder = new StringBuilder("loadUrl: url=");
                stringBuilder.append(str);
                g.a(str2, stringBuilder.toString());
            }
            super.loadUrl(addTTID(str));
            if (h.a(str)) {
                this.loadTime = System.currentTimeMillis();
            }
        }
    }

    public void loadUrl(String str, Map map) {
        if (this.isAlive && str != null) {
            if (g.a()) {
                String str2 = TAG;
                StringBuilder stringBuilder = new StringBuilder("loadUrl with headers: url=");
                stringBuilder.append(str);
                g.a(str2, stringBuilder.toString());
            }
            super.loadUrl(addTTID(str), map);
            if (h.a(str)) {
                this.loadTime = System.currentTimeMillis();
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.entryManager != null) {
            this.entryManager.a(i, i2, intent);
        }
    }

    public void onMessage(int i, Object obj) {
        if (this.mHandler != null) {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.obj = obj;
            this.mHandler.sendMessage(obtain);
        }
    }

    @TargetApi(11)
    public void onPause() {
        com.alibaba.sdk.android.feedback.xblink.a.b.a().b();
        if (this.entryManager != null) {
            this.entryManager.b();
        }
        if (VERSION.SDK_INT >= 11) {
            super.onPause();
        }
    }

    @TargetApi(11)
    public void onResume() {
        if (this.entryManager != null) {
            this.entryManager.c();
        }
        if (VERSION.SDK_INT >= 11) {
            super.onResume();
        }
    }

    public void postUrl(String str, byte[] bArr) {
        if (this.isAlive && str != null) {
            if (g.a()) {
                String str2 = TAG;
                StringBuilder stringBuilder = new StringBuilder("postUrl: url=");
                stringBuilder.append(str);
                g.a(str2, stringBuilder.toString());
            }
            super.postUrl(str, bArr);
            if (h.a(str)) {
                this.loadTime = System.currentTimeMillis();
            }
        }
    }

    public void reload() {
        super.reload();
        this.loadTime = System.currentTimeMillis();
    }

    public void setAppkey(String str) {
        this.appkey = str;
    }

    public void setCurrentUrl(String str) {
        this.currentUrl = str;
    }

    public void setLoadTimestamp(long j) {
        this.loadTime = j;
    }

    public void setSupportDownload(boolean z) {
        this.supportDownload = z;
    }

    public void setUrlFilter(com.alibaba.sdk.android.feedback.xblink.e.a aVar) {
        if (this.webViewClient instanceof HybridWebViewClient) {
            ((HybridWebViewClient) this.webViewClient).setUrlFilter(aVar);
        }
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        if (webChromeClient instanceof HybridWebChromeClient) {
            this.webChromeClient = webChromeClient;
            super.setWebChromeClient(webChromeClient);
            return;
        }
        throw new u("Your WebChromeClient must be extended from HybridWebChromeClient");
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        if (webViewClient instanceof HybridWebViewClient) {
            this.webViewClient = webViewClient;
            super.setWebViewClient(webViewClient);
            return;
        }
        throw new u("Your WebViewClient must be extended from HybridWebViewClient");
    }

    public void superLoadUrl(String str) {
        if (this.isAlive) {
            super.loadUrl(str);
            if (h.a(str)) {
                this.loadTime = System.currentTimeMillis();
            }
        }
    }

    public void supportJavascriptInterface(boolean z) {
        this.wvSupportNativeJs = z;
    }
}
