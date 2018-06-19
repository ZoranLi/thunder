package com.xunlei.downloadprovider.personal.liked;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.widget.TextView;
import com.xunlei.common.commonview.UnifiedLoadingView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.frame.view.CustomViewPager;
import com.xunlei.downloadprovider.personal.message.data.q;
import com.xunlei.downloadprovider.xlui.widget.PagerSlidingTabStrip;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;

public class LikeContentActivity extends BaseActivity implements t {
    private static final String a = "LikeContentActivity";
    private int c = 0;
    private int d = 0;
    private CustomViewPager e;
    private PagerSlidingTabStrip f;
    private TextView g;
    private TextView h;
    private View i;
    private UnifiedLoadingView j;
    private ErrorBlankView k;
    private LikeShortVideoFragment l;
    private LikeCinecismFragment m;

    private class a extends FragmentPagerAdapter {
        final /* synthetic */ LikeContentActivity a;

        public final int getCount() {
            return 2;
        }

        private a(LikeContentActivity likeContentActivity, FragmentManager fragmentManager) {
            this.a = likeContentActivity;
            super(fragmentManager);
        }

        public final Fragment getItem(int i) {
            switch (i) {
                case 0:
                    if (this.a.l == 0) {
                        this.a.l = new LikeShortVideoFragment();
                    }
                    return this.a.l;
                case 1:
                    if (this.a.m == 0) {
                        this.a.m = new LikeCinecismFragment();
                    }
                    return this.a.m;
                default:
                    return 0;
            }
        }
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, LikeContentActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        if (bundle != null) {
            bundle.remove("android:support:fragments");
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_like_content);
        this.l = new LikeShortVideoFragment();
        this.m = new LikeCinecismFragment();
        ((TextView) findViewById(R.id.titlebar_title)).setText("我赞过的");
        findViewById(R.id.titlebar_left).setOnClickListener(new g(this));
        this.i = findViewById(R.id.line);
        this.g = new TextView(this);
        this.g.setText("视频");
        this.g.setGravity(17);
        this.h = new TextView(this);
        this.h.setText("影评");
        this.h.setGravity(17);
        if (VERSION.SDK_INT >= 23) {
            this.g.setTextAppearance(R.style.TabTextStyle);
            this.h.setTextAppearance(R.style.TabTextStyle);
        } else {
            this.g.setTextAppearance(this, R.style.TabTextStyle);
            this.h.setTextAppearance(this, R.style.TabTextStyle);
        }
        this.f = (PagerSlidingTabStrip) findViewById(R.id.tb_fragment);
        this.f.a(this.g);
        this.f.a(this.h);
        this.e = (CustomViewPager) findViewById(R.id.vp_fragment);
        this.e.setAdapter(new a(getSupportFragmentManager()));
        this.f.setViewPager(this.e);
        this.e.addOnPageChangeListener(new i(this));
        this.j = (UnifiedLoadingView) findViewById(R.id.lv_loading);
        this.j.setType(2);
        this.j.show();
        this.k = (ErrorBlankView) findViewById(R.id.ev_error);
        this.k.setErrorType(2);
        this.k.a("刷新", new h(this));
        this.k.setVisibility(4);
    }

    protected void onDestroy() {
        super.onDestroy();
        q.c();
    }

    private void b() {
        if (this.k != null) {
            if (this.j != null) {
                runOnUiThread(new j(this));
            }
        }
    }

    public final void a(int i) {
        this.c = i;
        b();
    }

    public final void b(int i) {
        this.d = i;
        b();
    }
}
