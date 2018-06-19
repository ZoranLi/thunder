package com.xunlei.downloadprovider.personal.lixianspace.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.commonview.TitleBar;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.new_ptl.member.XLUserInfo;
import com.xunlei.common.new_ptl.member.XLUserUtil;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.download.create.m;
import com.xunlei.downloadprovider.frame.view.CustomViewPager;
import com.xunlei.downloadprovider.member.payment.a.j;
import com.xunlei.downloadprovider.member.payment.i;
import com.xunlei.downloadprovider.personal.lixianspace.b.c;
import com.xunlei.downloadprovider.personal.lixianspace.b.l;
import com.xunlei.downloadprovider.personal.lixianspace.expansion.a.b;
import com.xunlei.downloadprovider.personal.lixianspace.ui.c.n;
import com.xunlei.downloadprovider.personal.lixianspace.ui.fragment.LXDownloadEntryFragment;
import com.xunlei.downloadprovider.personal.lixianspace.ui.fragment.LXDownloadFavorityFragment;
import com.xunlei.downloadprovider.personal.lixianspace.ui.fragment.LXDownloadRecordFragment;
import com.xunlei.downloadprovider.xlui.widget.PagerSlidingTabStrip;
import com.xunlei.downloadprovider.xlui.widget.PagerSlidingTabStrip.Mode;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;
import com.xunlei.xllib.android.XLIntent;

public final class LXSpaceActivity extends BaseActivity {
    private static final String[] a = new String[]{"离线下载", "下载记录", "喜欢的资源"};
    private PagerSlidingTabStrip c;
    private LayoutInflater d;
    private CustomViewPager e;
    private z f;
    private View g;
    private ErrorBlankView h;
    private a i = new a();
    private OnPageChangeListener j = new b(this);
    private View k;
    private ImageView l;
    private com.xunlei.downloadprovider.personal.lixianspace.ui.fragment.LXDownloadEntryFragment.a m = new e(this);
    private com.xunlei.downloadprovider.personal.lixianspace.ui.c.a n;
    private n o;
    private com.xunlei.downloadprovider.personal.lixianspace.b.a p = new h(this);

    private class a extends com.xunlei.downloadprovider.personal.lixianspace.ui.a.a {
        final /* synthetic */ LXSpaceActivity a;

        private a(LXSpaceActivity lXSpaceActivity) {
            this.a = lXSpaceActivity;
        }

        public final boolean onUserLogout(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
            this.a.c();
            return false;
        }

        public final boolean onUserInfoCatched(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
            if (i == 0) {
                l.a((Object) "lx-space-get-used-count");
            }
            return false;
        }
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.lx_space_activity);
        XLUserUtil.getInstance().attachListener(this.i);
        a.a.a(this.p);
        this.d = LayoutInflater.from(getApplicationContext());
        bundle = new TitleBar((Activity) this);
        findViewById(R.id.titlebar_left).setOnClickListener(new c(this));
        ((TextView) findViewById(R.id.titlebar_title)).setText("离线空间");
        this.l = bundle.mRight1Iv;
        this.l.setOnClickListener(new d(this));
        this.h = (ErrorBlankView) findViewById(R.id.lx_space_error_layout);
        this.g = findViewById(R.id.lx_space_login_layout);
        j.a();
        if (com.xunlei.downloadprovider.member.login.b.l.b() == null) {
            c();
        } else {
            d();
        }
        new b(this, null).a((Object) "pre-load-download-config");
        ThunderReport.reportEvent(com.xunlei.downloadprovider.personal.lixianspace.c.a.d("lx_off_dl_page_show"));
        bundle = com.xunlei.downloadprovider.personal.lixianspace.business.c.a.a();
        if (bundle.a != null && bundle.c == 1800000) {
            bundle.a.removeMessages(1);
            bundle.a.sendEmptyMessageDelayed(1, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
        bundle.c = StatisticConfig.MIN_UPLOAD_INTERVAL;
    }

    protected final void onResume() {
        super.onResume();
        m.a().b = true;
        l.a((Object) "lx-space-get-used-count");
    }

    private void a(int i) {
        if (this.k != null) {
            this.k.setSelected(false);
        }
        this.k = this.c.a(i).findViewById(R.id.tab_title);
        this.k.setSelected(true);
        a();
    }

    private void a() {
        j.a();
        if (com.xunlei.downloadprovider.member.login.b.l.b()) {
            int i;
            ImageView imageView;
            boolean l = j.a().a.l();
            int i2 = 0;
            if (this.c.getCurrentTabIndext() == 0) {
                j.a();
                if (com.xunlei.downloadprovider.member.login.b.l.b()) {
                    i = 1;
                    imageView = this.l;
                    if (i != 0) {
                        i2 = 8;
                    }
                    imageView.setVisibility(i2);
                    this.l.setEnabled(l);
                    this.l.setImageResource(l ? R.drawable.lx_space_add_enable_ic : R.drawable.lx_space_add_disable_ic);
                }
            }
            i = 0;
            imageView = this.l;
            if (i != 0) {
                i2 = 8;
            }
            imageView.setVisibility(i2);
            this.l.setEnabled(l);
            if (l) {
            }
            this.l.setImageResource(l ? R.drawable.lx_space_add_enable_ic : R.drawable.lx_space_add_disable_ic);
        }
    }

    public static void a(Context context) {
        Intent xLIntent = new XLIntent(context, LXSpaceActivity.class);
        if (!(context instanceof Activity)) {
            xLIntent.addFlags(268435456);
        }
        context.startActivity(xLIntent);
    }

    private void b() {
        if (this.o == null) {
            this.o = new n(this);
        }
        this.o.show();
        ThunderReport.reportEvent(com.xunlei.downloadprovider.personal.lixianspace.c.a.d("lx_off_dl_create_task_pay_show"));
    }

    private void c() {
        this.g.setVisibility(8);
        this.h.setVisibility(0);
        this.h.a(ResourcesCompat.getDrawable(getResources(), R.drawable.commonui_bg_not_login, null), getResources().getString(R.string.tips_not_login), "");
        this.h.a("登录", new f(this));
    }

    private void d() {
        this.h.setVisibility(8);
        this.g.setVisibility(0);
        if (this.c == null) {
            this.c = (PagerSlidingTabStrip) findViewById(R.id.pager_sliding_tab);
            this.c.setCurrentMode(Mode.SLOID_TABS);
            this.c.setIndicatorWidth(DipPixelUtil.dip2px(80.0f));
            int length = a.length;
            for (int i = 0; i < length; i++) {
                View inflate = this.d.inflate(R.layout.lx_space_tab_spec, null);
                ((TextView) inflate.findViewById(R.id.tab_title)).setText(a[i]);
                inflate.setTag(Integer.valueOf(i));
                this.c.a(inflate);
            }
            a(0);
            if (!a.a.b()) {
                this.l.setVisibility(8);
            }
        }
        if (this.e == null) {
            this.f = new z(getSupportFragmentManager());
            this.f.a(LXDownloadEntryFragment.a(this.m));
            this.f.a(LXDownloadRecordFragment.b());
            this.f.a(LXDownloadFavorityFragment.b());
            this.e = (CustomViewPager) findViewById(R.id.viewPager);
            this.e.setAdapter(this.f);
            this.c.setViewPager(this.e);
            this.c.setOnPageChangeListener(this.j);
            this.e.setCurrentItem(0);
        }
    }

    protected final void onDestroy() {
        if (this.n != null) {
            this.n.dismiss();
        }
        if (this.o != null) {
            this.o.dismiss();
        }
        a.a.b(this.p);
        XLUserUtil.getInstance().detachListener(this.i);
        com.xunlei.downloadprovider.personal.lixianspace.business.c.a.a().c = 1800000;
        super.onDestroy();
    }

    static /* synthetic */ void c(LXSpaceActivity lXSpaceActivity) {
        if (j.a().a.l()) {
            c a = a.a;
            if ((a.c >= a.d ? 1 : null) == null) {
                if (lXSpaceActivity.n == null) {
                    lXSpaceActivity.n = new com.xunlei.downloadprovider.personal.lixianspace.ui.c.a(lXSpaceActivity);
                }
                lXSpaceActivity.n.show();
                ThunderReport.reportEvent(com.xunlei.downloadprovider.personal.lixianspace.c.a.d("lx_off_dl_dl_type_show"));
            } else if (!i.b(j.a().d())) {
                lXSpaceActivity.b();
            } else if (j.a().e()) {
                XLToast.showToast(lXSpaceActivity, lXSpaceActivity.getString(R.string.lx_space_task_count_used_out));
            } else {
                lXSpaceActivity.b();
            }
        }
    }
}
