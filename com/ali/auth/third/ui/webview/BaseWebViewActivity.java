package com.ali.auth.third.ui.webview;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.ali.auth.third.core.f.b;
import com.ali.auth.third.core.j.e;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

public class BaseWebViewActivity extends Activity {
    private Handler a = new Handler();
    protected TaeWebView d;
    protected TextView e;
    protected View f;
    public boolean g;
    protected View h;
    protected View i;

    class a extends AsyncTask<String, Void, Void> {
        final /* synthetic */ BaseWebViewActivity a;
        private String b;

        a(BaseWebViewActivity baseWebViewActivity) {
            this.a = baseWebViewActivity;
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Void) obj);
            if (com.ali.auth.third.core.j.a.b() == null) {
                com.ali.auth.third.core.j.a.a("com_taobao_tae_sdk_network_not_available_message");
                return;
            }
            this.a.d.resumeTimers();
            if (VERSION.SDK_INT >= 11) {
                this.a.d.onResume();
            }
            this.a.d.loadUrl(this.b);
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            this.b = ((String[]) objArr)[0];
            com.ali.auth.third.core.d.a.a.a();
            return null;
        }
    }

    private void c() {
        setResult(b.h.p, new Intent());
        com.ali.auth.third.a.d.a.a();
        finish();
    }

    public WebViewClient a() {
        return new a();
    }

    public WebChromeClient b() {
        return new f(this);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.ali.auth.third.core.c.a.a(com.ali.auth.third.ui.b.a.class, Collections.singletonMap("requestCodeKey", String.valueOf(i)));
    }

    public void onBackPressed() {
        c();
    }

    protected void onDestroy() {
        if (this.d != null) {
            ViewGroup viewGroup = (ViewGroup) this.d.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.d);
            }
            this.d.removeAllViews();
            this.d.destroy();
        }
        super.onDestroy();
    }

    protected void onResume() {
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
        r2 = this;
        super.onResume();
        r0 = r2.d;
        if (r0 == 0) goto L_0x0017;
    L_0x0007:
        r0 = r2.d;	 Catch:{ Exception -> 0x0017 }
        r0.resumeTimers();	 Catch:{ Exception -> 0x0017 }
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0017 }
        r1 = 11;	 Catch:{ Exception -> 0x0017 }
        if (r0 < r1) goto L_0x0017;	 Catch:{ Exception -> 0x0017 }
    L_0x0012:
        r0 = r2.d;	 Catch:{ Exception -> 0x0017 }
        r0.onResume();	 Catch:{ Exception -> 0x0017 }
    L_0x0017:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.auth.third.ui.webview.BaseWebViewActivity.onResume():void");
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("url", this.d.getUrl());
        bundle.putString("title", this.e.getText().toString());
        bundle.putSerializable("ui_contextParams", this.d.getContextParameters());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CharSequence charSequence = null;
        LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(e.a(this, "layout", "com_taobao_tae_sdk_web_view_activity"), null);
        this.d = new TaeWebView(this);
        this.d.setWebViewClient(a());
        this.d.setWebChromeClient(b());
        linearLayout.addView(this.d, new LayoutParams(-1, -1));
        setContentView(linearLayout);
        this.e = (TextView) findViewById(e.a(this, AgooConstants.MESSAGE_ID, "com_taobao_tae_sdk_web_view_title_bar_title"));
        this.i = findViewById(e.a(this, AgooConstants.MESSAGE_ID, "com_taobao_tae_sdk_web_view_title_bar_back_button"));
        if (this.i != null) {
            this.i.setOnClickListener(new d(this));
        }
        this.h = findViewById(e.a(this, AgooConstants.MESSAGE_ID, "com_taobao_tae_sdk_web_view_title_bar_close_button"));
        if (this.h != null) {
            this.h.setOnClickListener(new e(this));
            this.h.setVisibility(8);
        }
        this.f = findViewById(e.a(this, AgooConstants.MESSAGE_ID, "com_taobao_tae_sdk_web_view_title_bar"));
        Serializable serializableExtra = getIntent() != null ? getIntent().getSerializableExtra("ui_contextParams") : bundle != null ? bundle.getSerializable("ui_contextParams") : null;
        if (serializableExtra instanceof Map) {
            this.d.getContextParameters().putAll((Map) serializableExtra);
        }
        if (bundle != null) {
            charSequence = bundle.getString("title");
            bundle = bundle.getString("url");
        } else {
            bundle = null;
        }
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = getIntent().getStringExtra("title");
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.g = true;
        } else {
            this.g = false;
            this.e.setText(charSequence);
        }
        if (TextUtils.isEmpty(bundle)) {
            bundle = getIntent().getStringExtra("url");
        }
        new a(this).execute(new String[]{bundle});
    }
}
