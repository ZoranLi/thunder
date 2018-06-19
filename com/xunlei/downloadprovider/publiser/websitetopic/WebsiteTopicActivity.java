package com.xunlei.downloadprovider.publiser.websitetopic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.OnOffsetChangedListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.common.commonview.UnifiedLoadingView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.f.a;
import com.xunlei.downloadprovider.h.j;
import com.xunlei.downloadprovider.publiser.websitetopic.c.b;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;

public class WebsiteTopicActivity extends BaseActivity implements OnOffsetChangedListener {
    private UnifiedLoadingView a;
    private TextView c;
    private ErrorBlankView d;
    private TextView e;
    private ImageView f;
    private ImageView g;
    private WebsiteTopicFragment h;
    private b i;
    private String j;
    private String k;
    private String l;
    private a m = new d(this);

    protected final boolean q_() {
        return false;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_website_topic);
        bundle = getIntent();
        this.j = bundle.getStringExtra("website_topic_id");
        this.k = bundle.getStringExtra("website_topic_title");
        this.l = bundle.getStringExtra("website_topic_from");
        ((AppBarLayout) findViewById(R.id.lyt_appbar)).addOnOffsetChangedListener(this);
        this.g = (ImageView) findViewById(R.id.iv_website_topic_back);
        this.g.setOnClickListener(new b(this));
        this.c = (TextView) findViewById(R.id.tv_website_topic_title);
        this.e = (TextView) findViewById(R.id.tv_topic_title);
        this.f = (ImageView) findViewById(R.id.iv_topic_bg_header);
        this.a = (UnifiedLoadingView) findViewById(R.id.website_topic_loading_view);
        this.d = (ErrorBlankView) findViewById(R.id.website_topic_error_view);
        this.d.setActionButtonListener(new c(this));
        this.h = WebsiteTopicFragment.a(this.j);
        this.h.a = this.m;
        bundle = getSupportFragmentManager().beginTransaction();
        bundle.add(R.id.fl_website, this.h);
        bundle.commit();
        a();
        this.e.setText(this.k);
    }

    private void a() {
        this.a.setType(2);
        this.a.setBackgroundColor(Color.parseColor("#ffffff"));
        this.a.hidePageLoadingViewBack();
        this.a.show();
    }

    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        appBarLayout = appBarLayout.getTotalScrollRange();
        if (appBarLayout != null) {
            i = (Math.abs(i) * 100) / appBarLayout;
            if (i > 43) {
                if (this.i == null || this.i.d.equals(this.c.getText().toString()) != null) {
                    this.c.setText(this.k);
                } else {
                    this.c.setText(this.i.d);
                }
                this.g.setImageResource(R.drawable.commonui_nav_arrow_back_selector);
                if (VERSION.SDK_INT >= 23) {
                    j.a(this);
                    getWindow().setStatusBarColor(getResources().getColor(R.color.status_bar_color));
                }
            } else if (i < 45) {
                this.c.setText("");
                this.g.setImageResource(R.drawable.download_back_selector);
                if (VERSION.SDK_INT >= 23) {
                    j.b(this);
                    getWindow().setStatusBarColor(getResources().getColor(R.color.status_bar_color_dark));
                }
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        g.a();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        a.a();
        a.a((Activity) this, i, i2, intent);
    }

    public static void a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, WebsiteTopicActivity.class);
        intent.putExtra("website_topic_id", str2);
        intent.putExtra("website_topic_title", str3);
        intent.putExtra("website_topic_from", str);
        context.startActivity(intent);
    }

    protected final int e() {
        return getResources().getColor(R.color.status_bar_color_dark);
    }

    static /* synthetic */ void a(WebsiteTopicActivity websiteTopicActivity, int i) {
        websiteTopicActivity.d.setErrorType(i);
        websiteTopicActivity.d.setVisibility(0);
    }

    static /* synthetic */ void b(WebsiteTopicActivity websiteTopicActivity, b bVar) {
        websiteTopicActivity.k = bVar.d;
        websiteTopicActivity.e.setText(bVar.d);
        bVar = bVar.e;
        if (!f.a(websiteTopicActivity)) {
            Glide.with(websiteTopicActivity).load(bVar).diskCacheStrategy(DiskCacheStrategy.ALL).error(R.drawable.bg_website_topic_header_default).fallback(R.drawable.bg_website_topic_header_default).placeholder(R.drawable.bg_website_topic_header_default).into(websiteTopicActivity.f);
        }
    }
}
