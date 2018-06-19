package com.xunlei.downloadprovider.homepage.category;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.text.TextUtils;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.commonview.UnifiedLoadingView;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.homepage.choiceness.ui.RefreshPromptView;
import com.xunlei.downloadprovider.homepage.choiceness.ui.i;
import com.xunlei.downloadprovider.homepage.choiceness.ui.y;
import com.xunlei.downloadprovider.player.a.a;
import com.xunlei.downloadprovider.xlui.recyclerview.XRecyclerView;
import com.xunlei.downloadprovider.xlui.recyclerview.XRecyclerView.b;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;
import java.util.List;

public class ShortVideoCategoryActivity extends BaseActivity {
    private static final String a = "ShortVideoCategoryActivity";
    private String c;
    private RefreshPromptView d;
    private UnifiedLoadingView e;
    private ErrorBlankView f;
    private XRecyclerView g;
    private LinearLayoutManager h;
    private i i;
    private a j;
    private r k = new r();
    private Handler l = new Handler();
    private long m;
    private LocalBroadcastManager n = LocalBroadcastManager.getInstance(BrothersApplication.getApplicationInstance());
    private b o = new g(this);
    private OnScrollListener p = new n(this);
    private com.xunlei.downloadprovider.e.b.a q = new o(this);
    private BroadcastReceiver r = new p(this);
    private y s = new q(this);

    public static void a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent(context, ShortVideoCategoryActivity.class);
            intent.putExtra("from", str2);
            intent.putExtra("tag", str);
            context.startActivity(intent);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_short_video_category);
        String stringExtra = getIntent().getStringExtra("from");
        this.c = getIntent().getStringExtra("tag");
        findViewById(R.id.category_title_bar).bringToFront();
        findViewById(R.id.titlebar_left).setOnClickListener(new b(this));
        ((TextView) findViewById(R.id.titlebar_title)).setText(this.c);
        this.d = (RefreshPromptView) findViewById(R.id.refresh_prompt);
        this.d.setTranslationY((float) (-DipPixelUtil.dip2px(37.0f)));
        this.e = (UnifiedLoadingView) findViewById(R.id.category_loading_view);
        this.e.setPageLoadingViewBgColor(-1);
        this.e.setOnClickListener(null);
        this.e.show();
        this.f = (ErrorBlankView) findViewById(R.id.error_layout);
        this.f.setActionButtonListener(new c(this));
        this.f.setOnTouchListener(new d(this));
        this.g = (XRecyclerView) findViewById(R.id.recyclerView);
        this.h = new LinearLayoutManager(this);
        this.g.setLayoutManager(this.h);
        this.j = new a(this);
        this.j.a = this.g;
        this.i = new i(this, this.g, this.j, this.s);
        this.g.setAdapter(this.i);
        this.g.setOnTouchListener(new e(this));
        this.g.setLoadingListener(this.o);
        this.g.addOnScrollListener(this.p);
        a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("following_id_list_loaded");
        intentFilter.addAction("user_logout");
        this.n.registerReceiver(this.r, intentFilter);
        com.xunlei.downloadprovider.e.b.b.a();
        com.xunlei.downloadprovider.e.b.b.a(this.q);
        v.a(stringExtra, this.c);
    }

    protected void onDestroy() {
        super.onDestroy();
        com.xunlei.downloadprovider.e.b.b.a();
        com.xunlei.downloadprovider.e.b.b.b(this.q);
        this.n.unregisterReceiver(this.r);
    }

    public void onBackPressed() {
        this.s.a();
        this.s.b();
        super.onBackPressed();
    }

    protected void onResume() {
        super.onResume();
        if (this.i != null) {
            this.i.a(false);
        }
        this.m = System.currentTimeMillis();
    }

    protected void onPause() {
        super.onPause();
        if (this.i != null) {
            this.i.b();
            if (this.i.getItemCount() > 0) {
                v.a(this.c, System.currentTimeMillis() - this.m);
            }
        }
    }

    public final void a() {
        this.g.scrollToPosition(0);
        XRecyclerView xRecyclerView = this.g;
        if (!(xRecyclerView.b || !xRecyclerView.e || xRecyclerView.d.a())) {
            if (xRecyclerView.c != null) {
                xRecyclerView.b = true;
                xRecyclerView.a();
                xRecyclerView.f.onChanged();
                xRecyclerView.c();
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        com.xunlei.downloadprovider.f.a.a();
        com.xunlei.downloadprovider.f.a.a((Activity) this, i, i2, intent);
    }

    static /* synthetic */ void a(ShortVideoCategoryActivity shortVideoCategoryActivity, boolean z, List list) {
        boolean a = com.xunlei.xllib.android.b.a(BrothersApplication.getApplicationInstance());
        boolean a2 = com.xunlei.xllib.android.b.a(BrothersApplication.getApplicationInstance());
        if (shortVideoCategoryActivity.i.a()) {
            if (a2) {
                shortVideoCategoryActivity.f.setErrorType(0);
            } else {
                shortVideoCategoryActivity.f.setErrorType(2);
            }
            shortVideoCategoryActivity.f.setVisibility(0);
        } else {
            shortVideoCategoryActivity.f.setVisibility(8);
        }
        if (!shortVideoCategoryActivity.i.a()) {
            if (!a) {
                XLToast.showNoNetworkToast(shortVideoCategoryActivity);
            } else if (list == null) {
                XLToast.showToast(shortVideoCategoryActivity, "网络异常");
            } else {
                int size = list.size();
                if (z) {
                    if (size != null) {
                        shortVideoCategoryActivity.d.a(size);
                        return;
                    }
                }
                shortVideoCategoryActivity.d.a();
            }
        }
    }
}
