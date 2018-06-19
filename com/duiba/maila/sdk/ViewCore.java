package com.duiba.maila.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.duiba.maila.sdk.util.c;

public class ViewCore extends LinearLayout {
    WebView a = null;
    boolean b = false;
    private Context c = null;
    private View d;
    private View e = null;
    private ImageButton f = null;
    private int g = 5;
    private OnClickListener h;
    private Handler i = new Handler();
    private String j = null;
    private String k = null;

    public class a implements LocationListener {
        final /* synthetic */ ViewCore a;
        private Activity b;

        public final void onProviderDisabled(String str) {
        }

        public final void onProviderEnabled(String str) {
        }

        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }

        public a(ViewCore viewCore, Context context) {
            this.a = viewCore;
            this.b = (Activity) context;
        }

        public final void onLocationChanged(Location location) {
            this.a.a.post(new q(this, com.alibaba.fastjson.a.toJSONString(new com.duiba.maila.sdk.util.a(this.b, new c(location)))));
        }
    }

    public class b implements LocationListener {
        Activity a;
        final /* synthetic */ ViewCore b;

        public final void onLocationChanged(Location location) {
        }

        public final void onProviderDisabled(String str) {
        }

        public final void onProviderEnabled(String str) {
        }

        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }

        public b(ViewCore viewCore, Context context) {
            this.b = viewCore;
            this.a = (Activity) context;
        }
    }

    public ViewCore(Context context) {
        super(context);
        a(context);
    }

    public ViewCore(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public void setOnBackClickListener(OnClickListener onClickListener) {
        this.h = onClickListener;
    }

    private void a(Context context) {
        this.c = context;
        setOrientation(1);
        this.e = LayoutInflater.from(context).inflate(R.layout.browser_controller, null);
        this.f = (ImageButton) this.e.findViewById(R.id.browser_controller_back);
        this.f.setOnClickListener(new m(this));
        this.a = new WebView(context);
        addView(this.a, new LayoutParams(-1, 0, 1.0f));
        WebSettings settings = this.a.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setCacheMode(-1);
        settings.setBuiltInZoomControls(false);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(false);
        settings.setDomStorageEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        this.a.setScrollContainer(false);
        this.a.setVerticalScrollBarEnabled(false);
        this.a.setHorizontalScrollBarEnabled(false);
        this.a.setWebChromeClient(new n(this));
        this.a.setWebViewClient(new o(this));
        this.a.addJavascriptInterface(new a(this, getContext()), "Android");
        this.a.addJavascriptInterface(new b(this, getContext()), "MailaSDK");
        try {
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            this.j = context.metaData.getString("MAILA_APPKEY");
            this.k = context.metaData.getString("MAILA_APPID");
        } catch (Context context2) {
            context2.printStackTrace();
        }
        if (TextUtils.isEmpty(this.j) == null) {
            if (TextUtils.isEmpty(this.k) == null) {
                this.d = View.inflate(this.c, R.layout.activity_url_error, null);
                return;
            }
        }
        throw new IllegalStateException("app_key or app_id not set");
    }

    protected final void a() {
        this.a.setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) this.a.getParent();
        while (linearLayout.getChildCount() > 1) {
            linearLayout.removeViewAt(0);
        }
        this.d.setVisibility(0);
        ((RelativeLayout) this.d.findViewById(R.id.online_error_btn_retry)).setOnClickListener(new p(this));
        linearLayout.addView(this.d, 0, new LayoutParams(-1, -1));
    }

    protected String getAppKey() {
        return this.j;
    }

    protected String getAppId() {
        return this.k;
    }

    public final void a(String str) {
        StringBuilder stringBuilder = new StringBuilder("javascript:callbackGPS('");
        stringBuilder.append(str);
        stringBuilder.append("')");
        c(stringBuilder.toString());
    }

    public final void b(String str) {
        StringBuilder stringBuilder = new StringBuilder("javascript:callbackShowUrl('");
        stringBuilder.append(str);
        stringBuilder.append("')");
        c(stringBuilder.toString());
    }

    protected void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a.loadUrl(str);
        }
    }

    protected WebView getWebView() {
        return this.a != null ? this.a : null;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.a.canGoBack()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.a.goBack();
        return true;
    }

    static /* synthetic */ void a(ViewCore viewCore, String str) {
        try {
            viewCore.c.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (ViewCore viewCore2) {
            StringBuilder stringBuilder = new StringBuilder("无法打开该链接");
            stringBuilder.append(str);
            stringBuilder.append("               ");
            stringBuilder.append(viewCore2.getMessage());
        }
    }
}
