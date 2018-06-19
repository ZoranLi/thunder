package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.c;
import com.xunlei.downloadprovider.web.base.core.BaseWebViewActivity;
import com.xunlei.downloadprovider.web.base.core.CustomWebView;
import com.xunlei.xllib.android.XLIntent;

public class LongVideoDetailActivity extends BaseWebViewActivity {
    private View a;
    private ImageView c;
    private TextView d;
    private View e;
    private String i;
    private boolean j;
    private boolean k;
    private int l;
    private c m;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.l = DipPixelUtil.dip2px(187.0f);
        this.m = new c(this);
    }

    protected final void a(Intent intent) {
        super.a(intent);
        this.i = intent.getStringExtra("title");
    }

    protected final void a() {
        super.a();
        setContentView(R.layout.long_video_detail_activity);
        this.a = findViewById(R.id.title_bar_layout);
        this.c = (ImageView) findViewById(R.id.goback_btn);
        this.d = (TextView) findViewById(R.id.title_text);
        if (!TextUtils.isEmpty(this.i)) {
            this.d.setText(this.i);
        }
        this.e = findViewById(R.id.title_line);
        this.f = (CustomWebView) findViewById(R.id.webView);
        this.f.setProgressType(3);
        this.f.setErrorViewVisibilityListener(new l(this));
        this.f.setProgressVisibilityListener(new m(this));
        this.f.setWebChromeClient(new n(this));
        this.f.setOnScrollChangedListener(new o(this));
    }

    public static void a(Context context, String str, String str2, String str3) {
        Intent xLIntent = new XLIntent(context, LongVideoDetailActivity.class);
        xLIntent.putExtra("url", str2);
        xLIntent.putExtra("title", str3);
        xLIntent.putExtra("from", str);
        context.startActivity(xLIntent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.m.a(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    static /* synthetic */ void a(LongVideoDetailActivity longVideoDetailActivity, float f) {
        if (f == 0.0f) {
            longVideoDetailActivity.c.setImageResource(R.drawable.short_list_back_icon_selector);
        } else {
            longVideoDetailActivity.c.setImageResource(R.drawable.commonui_nav_arrow_back_selector);
        }
        f = (int) (255.0f * f);
        longVideoDetailActivity.a.setBackgroundColor(Color.argb(f, 255, 255, 255));
        longVideoDetailActivity.d.setTextColor(Color.argb(f, 51, 51, 51));
        int color = longVideoDetailActivity.getResources().getColor(R.color.search_line_color);
        longVideoDetailActivity.e.setBackgroundColor(Color.argb(f, Color.red(color), Color.green(color), Color.blue(color)));
    }
}
