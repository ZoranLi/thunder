package com.tencent.connect.auth;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.qq.e.comm.constants.Constants.KEYS;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.f;
import com.tencent.open.b.g;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.i;
import com.tencent.open.web.security.SecureJsInterface;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.umeng.message.proguard.k;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class a extends Dialog {
    private String a;
    private b b;
    private IUiListener c;
    private Handler d;
    private FrameLayout e;
    private LinearLayout f;
    private FrameLayout g;
    private ProgressBar h;
    private String i;
    private com.tencent.open.c.c j;
    private Context k;
    private com.tencent.open.web.security.b l;
    private boolean m = false;
    private int n;
    private String o;
    private String p;
    private long q = 0;
    private long r = StatisticConfig.MIN_UPLOAD_INTERVAL;
    private HashMap<String, Runnable> s;

    /* compiled from: ProGuard */
    private class a extends WebViewClient {
        final /* synthetic */ a a;

        private a(a aVar) {
            this.a = aVar;
        }

        public boolean shouldOverrideUrlLoading(android.webkit.WebView r4, java.lang.String r5) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r4 = "openSDK_LOG.AuthDialog";
            r0 = new java.lang.StringBuilder;
            r1 = "-->Redirect URL: ";
            r0.<init>(r1);
            r0.append(r5);
            r0 = r0.toString();
            com.tencent.open.a.f.a(r4, r0);
            r4 = "auth://browser";
            r4 = r5.startsWith(r4);
            r0 = 1;
            if (r4 == 0) goto L_0x0093;
        L_0x001c:
            r4 = com.tencent.open.utils.i.c(r5);
            r5 = r3.a;
            r1 = r3.a;
            r1 = r1.e();
            r5.m = r1;
            r5 = r3.a;
            r5 = r5.m;
            if (r5 != 0) goto L_0x0092;
        L_0x0033:
            r5 = "fail_cb";
            r1 = 0;
            r5 = r4.optString(r5, r1);
            if (r5 == 0) goto L_0x004a;
        L_0x003c:
            r5 = r3.a;
            r1 = "fail_cb";
            r4 = r4.optString(r1);
            r1 = "";
            r5.a(r4, r1);
            goto L_0x0092;
        L_0x004a:
            r5 = "fall_to_wv";
            r5 = r4.optInt(r5);
            if (r5 != r0) goto L_0x0081;
        L_0x0052:
            r4 = r3.a;
            r5 = r3.a;
            r5 = r5.a;
            r1 = "?";
            r5 = r5.indexOf(r1);
            if (r5 < 0) goto L_0x0065;
        L_0x0062:
            r5 = "&";
            goto L_0x0067;
        L_0x0065:
            r5 = "?";
        L_0x0067:
            com.tencent.connect.auth.a.a(r4, r5);
            r4 = r3.a;
            r5 = "browser_error=1";
            com.tencent.connect.auth.a.a(r4, r5);
            r4 = r3.a;
            r4 = r4.j;
            r5 = r3.a;
            r5 = r5.a;
            r4.loadUrl(r5);
            goto L_0x0092;
        L_0x0081:
            r5 = "redir";
            r4 = r4.optString(r5, r1);
            if (r4 == 0) goto L_0x0092;
        L_0x0089:
            r5 = r3.a;
            r5 = r5.j;
            r5.loadUrl(r4);
        L_0x0092:
            return r0;
        L_0x0093:
            r4 = "auth://tauth.qq.com/";
            r4 = r5.startsWith(r4);
            if (r4 == 0) goto L_0x00ae;
        L_0x009b:
            r4 = r3.a;
            r4 = r4.b;
            r5 = com.tencent.open.utils.i.c(r5);
            r4.onComplete(r5);
            r4 = r3.a;
            r4.dismiss();
            return r0;
        L_0x00ae:
            r4 = "auth://cancel";
            r4 = r5.startsWith(r4);
            if (r4 == 0) goto L_0x00c5;
        L_0x00b6:
            r4 = r3.a;
            r4 = r4.b;
            r4.onCancel();
            r4 = r3.a;
            r4.dismiss();
            return r0;
        L_0x00c5:
            r4 = "auth://close";
            r4 = r5.startsWith(r4);
            if (r4 == 0) goto L_0x00d3;
        L_0x00cd:
            r4 = r3.a;
            r4.dismiss();
            return r0;
        L_0x00d3:
            r4 = "download://";
            r4 = r5.startsWith(r4);
            if (r4 == 0) goto L_0x0108;
        L_0x00db:
            r4 = 11;
            r4 = r5.substring(r4);	 Catch:{ Exception -> 0x00ff }
            r4 = android.net.Uri.decode(r4);	 Catch:{ Exception -> 0x00ff }
            r4 = android.net.Uri.parse(r4);	 Catch:{ Exception -> 0x00ff }
            r5 = new android.content.Intent;	 Catch:{ Exception -> 0x00ff }
            r1 = "android.intent.action.VIEW";	 Catch:{ Exception -> 0x00ff }
            r5.<init>(r1, r4);	 Catch:{ Exception -> 0x00ff }
            r4 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;	 Catch:{ Exception -> 0x00ff }
            r5.addFlags(r4);	 Catch:{ Exception -> 0x00ff }
            r4 = r3.a;	 Catch:{ Exception -> 0x00ff }
            r4 = r4.k;	 Catch:{ Exception -> 0x00ff }
            r4.startActivity(r5);	 Catch:{ Exception -> 0x00ff }
            goto L_0x0107;
        L_0x00ff:
            r4 = move-exception;
            r5 = "openSDK_LOG.AuthDialog";
            r1 = "-->start download activity exception, e: ";
            com.tencent.open.a.f.b(r5, r1, r4);
        L_0x0107:
            return r0;
        L_0x0108:
            r4 = "auth://progress";
            r4 = r5.startsWith(r4);
            r1 = 0;
            if (r4 == 0) goto L_0x0152;
        L_0x0111:
            r4 = android.net.Uri.parse(r5);	 Catch:{ Exception -> 0x0151 }
            r4 = r4.getPathSegments();	 Catch:{ Exception -> 0x0151 }
            r5 = r4.isEmpty();	 Catch:{ Exception -> 0x0151 }
            if (r5 == 0) goto L_0x0120;	 Catch:{ Exception -> 0x0151 }
        L_0x011f:
            return r0;	 Catch:{ Exception -> 0x0151 }
        L_0x0120:
            r4 = r4.get(r1);	 Catch:{ Exception -> 0x0151 }
            r4 = (java.lang.String) r4;	 Catch:{ Exception -> 0x0151 }
            r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0151 }
            r4 = r4.intValue();	 Catch:{ Exception -> 0x0151 }
            if (r4 != 0) goto L_0x0145;	 Catch:{ Exception -> 0x0151 }
        L_0x0130:
            r4 = r3.a;	 Catch:{ Exception -> 0x0151 }
            r4 = r4.g;	 Catch:{ Exception -> 0x0151 }
            r5 = 8;	 Catch:{ Exception -> 0x0151 }
            r4.setVisibility(r5);	 Catch:{ Exception -> 0x0151 }
            r4 = r3.a;	 Catch:{ Exception -> 0x0151 }
            r4 = r4.j;	 Catch:{ Exception -> 0x0151 }
            r4.setVisibility(r1);	 Catch:{ Exception -> 0x0151 }
            goto L_0x0150;	 Catch:{ Exception -> 0x0151 }
        L_0x0145:
            if (r4 != r0) goto L_0x0150;	 Catch:{ Exception -> 0x0151 }
        L_0x0147:
            r4 = r3.a;	 Catch:{ Exception -> 0x0151 }
            r4 = r4.g;	 Catch:{ Exception -> 0x0151 }
            r4.setVisibility(r1);	 Catch:{ Exception -> 0x0151 }
        L_0x0150:
            return r0;
        L_0x0151:
            return r0;
        L_0x0152:
            r4 = "auth://onLoginSubmit";
            r4 = r5.startsWith(r4);
            if (r4 == 0) goto L_0x0174;
        L_0x015a:
            r4 = android.net.Uri.parse(r5);	 Catch:{ Exception -> 0x0173 }
            r4 = r4.getPathSegments();	 Catch:{ Exception -> 0x0173 }
            r5 = r4.isEmpty();	 Catch:{ Exception -> 0x0173 }
            if (r5 != 0) goto L_0x0173;	 Catch:{ Exception -> 0x0173 }
        L_0x0168:
            r5 = r3.a;	 Catch:{ Exception -> 0x0173 }
            r4 = r4.get(r1);	 Catch:{ Exception -> 0x0173 }
            r4 = (java.lang.String) r4;	 Catch:{ Exception -> 0x0173 }
            r5.p = r4;	 Catch:{ Exception -> 0x0173 }
        L_0x0173:
            return r0;
        L_0x0174:
            r4 = r3.a;
            r4 = r4.l;
            r2 = r3.a;
            r2 = r2.j;
            r4 = r4.a(r2, r5);
            if (r4 == 0) goto L_0x0187;
        L_0x0186:
            return r0;
        L_0x0187:
            r4 = "openSDK_LOG.AuthDialog";
            r5 = "-->Redirect URL: return false";
            com.tencent.open.a.f.c(r4, r5);
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.auth.a.a.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            StringBuilder stringBuilder = new StringBuilder("-->onReceivedError, errorCode: ");
            stringBuilder.append(i);
            stringBuilder.append(" | description: ");
            stringBuilder.append(str);
            f.c("openSDK_LOG.AuthDialog", stringBuilder.toString());
            if (i.b(this.a.k) == null) {
                this.a.b.onError(new UiError(9001, "当前网络不可用，请稍后重试！", str2));
                this.a.dismiss();
            } else if (this.a.o.startsWith("http://qzs.qq.com/open/mobile/login/qzsjump.html?") == null) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.a.q;
                if (this.a.n > null || elapsedRealtime >= this.a.r) {
                    this.a.j.loadUrl(this.a.a());
                    return;
                }
                this.a.n = this.a.n + 1;
                this.a.d.postDelayed(new Runnable(this) {
                    final /* synthetic */ a a;

                    {
                        this.a = r1;
                    }

                    public void run() {
                        this.a.a.j.loadUrl(this.a.a.o);
                    }
                }, 500);
            } else {
                this.a.b.onError(new UiError(i, str, str2));
                this.a.dismiss();
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            StringBuilder stringBuilder = new StringBuilder("-->onPageStarted, url: ");
            stringBuilder.append(str);
            f.a("openSDK_LOG.AuthDialog", stringBuilder.toString());
            super.onPageStarted(webView, str, bitmap);
            this.a.g.setVisibility(null);
            this.a.q = SystemClock.elapsedRealtime();
            if (TextUtils.isEmpty(this.a.o) == null) {
                this.a.d.removeCallbacks((Runnable) this.a.s.remove(this.a.o));
            }
            this.a.o = str;
            webView = new d(this.a, this.a.o);
            this.a.s.put(str, webView);
            this.a.d.postDelayed(webView, 120000);
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            StringBuilder stringBuilder = new StringBuilder("-->onPageFinished, url: ");
            stringBuilder.append(str);
            f.a("openSDK_LOG.AuthDialog", stringBuilder.toString());
            this.a.g.setVisibility(8);
            if (this.a.j != null) {
                this.a.j.setVisibility(0);
            }
            if (TextUtils.isEmpty(str) == null) {
                this.a.d.removeCallbacks((Runnable) this.a.s.remove(str));
            }
        }

        @TargetApi(8)
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.cancel();
            this.a.b.onError(new UiError(sslError.getPrimaryError(), "请求不合法，请检查手机安全设置，如系统时间、代理等。", "ssl error"));
            this.a.dismiss();
        }
    }

    /* compiled from: ProGuard */
    private class c extends Handler {
        final /* synthetic */ a a;
        private b b;

        public c(a aVar, b bVar, Looper looper) {
            this.a = aVar;
            super(looper);
            this.b = bVar;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.b.a((String) message.obj);
                    return;
                case 2:
                    this.b.onCancel();
                    return;
                case 3:
                    a.b(this.a.k, (String) message.obj);
                    break;
                default:
                    break;
            }
        }
    }

    /* compiled from: ProGuard */
    class d implements Runnable {
        String a = "";
        final /* synthetic */ a b;

        public d(a aVar, String str) {
            this.b = aVar;
            this.a = str;
        }

        public void run() {
            StringBuilder stringBuilder = new StringBuilder("-->timeoutUrl: ");
            stringBuilder.append(this.a);
            stringBuilder.append(" | mRetryUrl: ");
            stringBuilder.append(this.b.o);
            f.a("openSDK_LOG.AuthDialog", stringBuilder.toString());
            if (this.a.equals(this.b.o)) {
                this.b.b.onError(new UiError(9002, "请求页面超时，请稍后重试！", this.b.o));
                this.b.dismiss();
            }
        }
    }

    /* compiled from: ProGuard */
    private class b implements IUiListener {
        String a;
        String b;
        final /* synthetic */ a c;
        private String d;
        private IUiListener e;

        public b(a aVar, String str, String str2, String str3, IUiListener iUiListener) {
            this.c = aVar;
            this.d = str;
            this.a = str2;
            this.b = str3;
            this.e = iUiListener;
        }

        private void a(String str) {
            try {
                onComplete(i.d(str));
            } catch (JSONException e) {
                e.printStackTrace();
                onError(new UiError(-4, Constants.MSG_JSON_ERROR, str));
            }
        }

        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            g a = g.a();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.d);
            stringBuilder.append("_H5");
            a.a(stringBuilder.toString(), SystemClock.elapsedRealtime(), 0, 0, jSONObject.optInt(KEYS.RET, -6), this.a, false);
            if (this.e != null) {
                this.e.onComplete(jSONObject);
                this.e = null;
            }
        }

        public void onError(UiError uiError) {
            String stringBuilder;
            if (uiError.errorMessage != null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(uiError.errorMessage);
                stringBuilder2.append(this.a);
                stringBuilder = stringBuilder2.toString();
            } else {
                stringBuilder = this.a;
            }
            g a = g.a();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(this.d);
            stringBuilder3.append("_H5");
            a.a(stringBuilder3.toString(), SystemClock.elapsedRealtime(), 0, 0, uiError.errorCode, stringBuilder, false);
            this.c.a(stringBuilder);
            if (this.e != null) {
                this.e.onError(uiError);
                this.e = null;
            }
        }

        public void onCancel() {
            if (this.e != null) {
                this.e.onCancel();
                this.e = null;
            }
        }
    }

    static /* synthetic */ String a(a aVar, Object obj) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(aVar.a);
        stringBuilder.append(obj);
        obj = stringBuilder.toString();
        aVar.a = obj;
        return obj;
    }

    static {
        StringBuilder stringBuilder;
        try {
            Context a = com.tencent.open.utils.d.a();
            StringBuilder stringBuilder2;
            if (a != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(a.getFilesDir().toString());
                stringBuilder.append("/");
                stringBuilder.append(AuthAgent.SECURE_LIB_NAME);
                if (new File(stringBuilder.toString()).exists()) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(a.getFilesDir().toString());
                    stringBuilder2.append("/");
                    stringBuilder2.append(AuthAgent.SECURE_LIB_NAME);
                    System.load(stringBuilder2.toString());
                    stringBuilder2 = new StringBuilder("-->load lib success:");
                    stringBuilder2.append(AuthAgent.SECURE_LIB_NAME);
                    f.c("openSDK_LOG.AuthDialog", stringBuilder2.toString());
                    return;
                }
                stringBuilder2 = new StringBuilder("-->fail, because so is not exists:");
                stringBuilder2.append(AuthAgent.SECURE_LIB_NAME);
                f.c("openSDK_LOG.AuthDialog", stringBuilder2.toString());
                return;
            }
            stringBuilder2 = new StringBuilder("-->load lib fail, because context is null:");
            stringBuilder2.append(AuthAgent.SECURE_LIB_NAME);
            f.c("openSDK_LOG.AuthDialog", stringBuilder2.toString());
        } catch (Throwable e) {
            stringBuilder = new StringBuilder("-->load lib error:");
            stringBuilder.append(AuthAgent.SECURE_LIB_NAME);
            f.b("openSDK_LOG.AuthDialog", stringBuilder.toString(), e);
        }
    }

    public a(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        this.k = context;
        this.a = str2;
        this.b = new b(this, str, str2, qQToken.getAppId(), iUiListener);
        this.d = new c(this, this.b, context.getMainLooper());
        this.c = iUiListener;
        this.i = str;
        this.l = new com.tencent.open.web.security.b();
        getWindow().setSoftInputMode(32);
    }

    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        b();
        d();
        this.s = new HashMap();
    }

    public void onBackPressed() {
        if (!this.m) {
            this.b.onCancel();
        }
        super.onBackPressed();
    }

    protected void onStop() {
        super.onStop();
    }

    private String a(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        if (TextUtils.isEmpty(this.p) == null && this.p.length() >= 4) {
            str = this.p.substring(this.p.length() - 4);
            stringBuilder.append("_u_");
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    private String a() {
        String substring = this.a.substring(this.a.indexOf("?") + 1);
        StringBuilder stringBuilder = new StringBuilder("http://qzs.qq.com/open/mobile/login/qzsjump.html?");
        stringBuilder.append(substring);
        substring = stringBuilder.toString();
        f.c("openSDK_LOG.AuthDialog", "-->generateDownloadUrl, url: http://qzs.qq.com/open/mobile/login/qzsjump.html?");
        return substring;
    }

    private void b() {
        c();
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.j = new com.tencent.open.c.c(this.k);
        if (VERSION.SDK_INT >= 11) {
            this.j.setLayerType(1, null);
        }
        this.j.setLayoutParams(layoutParams);
        this.e = new FrameLayout(this.k);
        layoutParams.gravity = 17;
        this.e.setLayoutParams(layoutParams);
        this.e.addView(this.j);
        this.e.addView(this.g);
        setContentView(this.e);
    }

    private void c() {
        LayoutParams layoutParams;
        View textView;
        this.h = new ProgressBar(this.k);
        this.h.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f = new LinearLayout(this.k);
        if (this.i.equals("action_login")) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            layoutParams.leftMargin = 5;
            textView = new TextView(this.k);
            if (Locale.getDefault().getLanguage().equals("zh")) {
                textView.setText("登录中...");
            } else {
                textView.setText("Logging in...");
            }
            textView.setTextColor(Color.rgb(255, 255, 255));
            textView.setTextSize(18.0f);
            textView.setLayoutParams(layoutParams);
        } else {
            textView = null;
        }
        layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f.setLayoutParams(layoutParams);
        this.f.addView(this.h);
        if (textView != null) {
            this.f.addView(textView);
        }
        this.g = new FrameLayout(this.k);
        layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = 80;
        layoutParams.rightMargin = 80;
        layoutParams.topMargin = 40;
        layoutParams.bottomMargin = 40;
        layoutParams.gravity = 17;
        this.g.setLayoutParams(layoutParams);
        this.g.setBackgroundResource(17301504);
        this.g.addView(this.f);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void d() {
        this.j.setVerticalScrollBarEnabled(false);
        this.j.setHorizontalScrollBarEnabled(false);
        this.j.setWebViewClient(new a());
        this.j.setWebChromeClient(new WebChromeClient());
        this.j.clearFormData();
        this.j.clearSslPreferences();
        this.j.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ a a;

            public boolean onLongClick(View view) {
                return true;
            }

            {
                this.a = r1;
            }
        });
        this.j.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case null:
                    case 1:
                        if (view.hasFocus() == null) {
                            view.requestFocus();
                            break;
                        }
                        break;
                    default:
                        break;
                }
                return null;
            }
        });
        WebSettings settings = this.j.getSettings();
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(RenderPriority.HIGH);
        settings.setJavaScriptEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(this.k.getDir("databases", 0).getPath());
        settings.setDomStorageEnabled(true);
        StringBuilder stringBuilder = new StringBuilder("-->mUrl : ");
        stringBuilder.append(this.a);
        f.a("openSDK_LOG.AuthDialog", stringBuilder.toString());
        this.o = this.a;
        this.j.loadUrl(this.a);
        this.j.setVisibility(4);
        this.j.getSettings().setSavePassword(false);
        this.l.a(new SecureJsInterface(), "SecureJsInterface");
        SecureJsInterface.isPWDEdit = false;
        super.setOnDismissListener(new OnDismissListener(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void onDismiss(android.content.DialogInterface r1) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r0 = this;
                com.tencent.open.web.security.JniInterface.clearAllPWD();	 Catch:{ Exception -> 0x0004 }
                return;
            L_0x0004:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.auth.a.3.onDismiss(android.content.DialogInterface):void");
            }
        });
    }

    private boolean e() {
        b a = b.a();
        String c = a.c();
        com.tencent.connect.auth.b.a aVar = new com.tencent.connect.auth.b.a();
        aVar.a = this.c;
        aVar.b = this;
        aVar.c = c;
        String a2 = a.a(aVar);
        String substring = this.a.substring(0, this.a.indexOf("?"));
        Bundle b = i.b(this.a);
        b.putString("token_key", c);
        b.putString("serial", a2);
        b.putString("browser", "1");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(substring);
        stringBuilder.append("?");
        stringBuilder.append(HttpUtils.encodeUrl(b));
        this.a = stringBuilder.toString();
        return i.a(this.k, this.a);
    }

    private static void b(Context context, String str) {
        try {
            str = i.d(str);
            int i = str.getInt("type");
            Toast.makeText(context.getApplicationContext(), str.getString("msg"), i).show();
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    public void a(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder("javascript:");
        stringBuilder.append(str);
        stringBuilder.append(k.s);
        stringBuilder.append(str2);
        stringBuilder.append(");void(");
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append(");");
        this.j.loadUrl(stringBuilder.toString());
    }

    public void dismiss() {
        this.s.clear();
        this.d.removeCallbacksAndMessages(null);
        if (isShowing()) {
            super.dismiss();
        }
        if (this.j != null) {
            this.j.destroy();
            this.j = null;
        }
    }
}
