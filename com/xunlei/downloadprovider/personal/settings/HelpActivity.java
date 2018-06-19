package com.xunlei.downloadprovider.personal.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.common.commonview.TitleBar;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.xllib.android.XLIntent;
import com.xunlei.xllib.android.b;

public class HelpActivity extends BaseActivity implements OnClickListener {
    private View a;
    private TextView c;
    private ImageView d;
    private WebView e;
    private ImageView f;
    private ImageView g;
    private String h = null;
    private String i = null;
    private View j;
    private TextView k;
    private Button l;

    public static void a(Context context, String str, String str2) {
        Intent xLIntent = new XLIntent(context, HelpActivity.class);
        xLIntent.putExtra("url_idx", str);
        xLIntent.putExtra("title", str2);
        if ((context instanceof Activity) != null) {
            context.startActivity(xLIntent);
            return;
        }
        xLIntent.addFlags(268435456);
        context.startActivity(xLIntent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.h = getIntent().getStringExtra("url_idx");
        this.i = getIntent().getStringExtra("title");
        setContentView(R.layout.setting_help_layout);
        b();
    }

    public void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return true;
        }
        a();
        return false;
    }

    private void a() {
        if (c()) {
            a(this.e);
        } else {
            finish();
        }
    }

    private void b() {
        new TitleBar((Activity) this).mRight.setVisibility(4);
        this.a = findViewById(R.id.titlebar_left);
        this.a.setOnClickListener(this);
        this.c = (TextView) findViewById(R.id.titlebar_title);
        this.e = (WebView) findViewById(R.id.setting_help_webview);
        boolean z = this.h != null && this.h.startsWith("file:");
        if (!z) {
            if (!b.a(this)) {
                this.c.setText(this.i);
                this.j = findViewById(R.id.channel_error_view);
                this.j.setVisibility(0);
                this.k = (TextView) findViewById(R.id.empty_tip);
                this.k.setVisibility(0);
                this.l = (Button) findViewById(R.id.empty_refresh_btn);
                this.l.setOnClickListener(new n(this));
                return;
            }
        }
        this.d = (ImageView) findViewById(R.id.setting_help_back);
        this.f = (ImageView) findViewById(R.id.setting_help_go);
        this.g = (ImageView) findViewById(R.id.setting_help_refresh);
        findViewById(R.id.setting_help_bottom_bar).setVisibility(8);
        if (TextUtils.isEmpty(this.i)) {
            this.c.setText("常见问题");
        } else {
            this.c.setText(this.i);
        }
        this.e.setWebViewClient(new o(this));
        this.e.setWebChromeClient(new p(this));
        WebSettings settings = this.e.getSettings();
        settings.setJavaScriptEnabled(true);
        this.e.setScrollBarStyle(33554432);
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        settings.setUseWideViewPort(false);
        settings.setLoadWithOverviewMode(true);
        settings.setLayoutAlgorithm(LayoutAlgorithm.NORMAL);
        this.e.setScrollBarStyle(33554432);
        this.e.setBackgroundColor(0);
        this.e.setBackgroundColor(0);
        String str = this.h;
        if (str != null) {
            try {
                this.e.loadUrl(str);
            } catch (Exception e) {
                new StringBuilder("loadWeb error msg=").append(e.getMessage());
            }
        }
        this.j = findViewById(R.id.channel_error_view);
        this.j.setVisibility(8);
    }

    public void onClick(View view) {
        view = view.getId();
        if (view != R.id.titlebar_left) {
            switch (view) {
                case R.id.setting_help_back:
                    c();
                    return;
                case R.id.setting_help_go:
                    if (this.e.canGoForward() != null) {
                        this.e.goForward();
                    }
                    return;
                case R.id.setting_help_refresh:
                    try {
                        this.e.reload();
                        return;
                    } catch (View view2) {
                        new StringBuilder("refresh error msg=").append(view2.getMessage());
                        break;
                    }
                default:
                    break;
            }
            return;
        }
        a();
    }

    private boolean c() {
        if (!this.e.canGoBack()) {
            return false;
        }
        this.e.goBack();
        return true;
    }

    private void a(WebView webView) {
        if (webView.canGoBack()) {
            this.d.setEnabled(true);
        } else {
            this.d.setEnabled(false);
        }
        if (webView.canGoForward() != null) {
            this.f.setEnabled(true);
        } else {
            this.f.setEnabled(false);
        }
    }
}
