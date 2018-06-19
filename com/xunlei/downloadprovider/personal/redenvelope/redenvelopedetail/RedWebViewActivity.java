package com.xunlei.downloadprovider.personal.redenvelope.redenvelopedetail;

import android.content.Context;
import android.content.Intent;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.web.base.core.BaseWebViewActivity;
import com.xunlei.downloadprovider.web.base.core.CustomWebView;
import com.xunlei.downloadprovider.web.base.core.ak;
import com.xunlei.xllib.android.XLIntent;

public class RedWebViewActivity extends BaseWebViewActivity {
    protected RedWebTitleBar a;
    private String c;

    protected final void a() {
        super.a();
        setContentView(R.layout.activity_red_web_view);
        this.f = (CustomWebView) findViewById(R.id.webView);
        this.a = (RedWebTitleBar) findViewById(R.id.title_bar);
        this.f.setWebViewClient(new n(this.a));
        Intent intent = getIntent();
        if (intent != null) {
            this.c = intent.getStringExtra("title");
        }
        if (!ak.a(this.c)) {
            this.a.setTitleText(this.c);
        }
    }

    public static void a(Context context, String str, String str2) {
        Intent xLIntent = new XLIntent(context, RedWebViewActivity.class);
        xLIntent.putExtra("from", str);
        xLIntent.putExtra("url", str2);
        xLIntent.putExtra("title", "");
        context.startActivity(xLIntent);
    }
}
