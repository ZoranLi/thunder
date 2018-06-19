package com.xunlei.downloadprovider.frame;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.d.i;
import com.xunlei.downloadprovider.d.i.a;
import com.xunlei.downloadprovider.frame.view.CustomViewPager;
import com.xunlei.downloadprovider.homepage.o;
import com.xunlei.downloadprovider.xlui.widget.PagerSlidingTabStrip;
import com.xunlei.downloadprovider.xlui.widget.PagerSlidingTabStrip.Mode;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseViewPagerFragment extends BaseCacheViewFragment implements a {
    protected PagerSlidingTabStrip a;
    protected CustomViewPager b;
    public boolean c;
    protected int d = 0;
    protected f e;
    private Handler f = new Handler();
    private e g;
    private TextView h;
    private List<TextView> i = new ArrayList(2);
    private OnPageChangeListener j = new c(this);
    private Runnable k = new d(this);

    public void a(int i, View view) {
    }

    public void a(i iVar) {
    }

    public void c() {
    }

    public abstract String[] f();

    public abstract Class<?>[] g();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.g = new e(getChildFragmentManager(), g(), (byte) 0);
        i.a().a(this);
    }

    public Mode a() {
        return Mode.SLOID_TABS;
    }

    public int b() {
        return DipPixelUtil.dip2px(100.0f);
    }

    public final void a(int i) {
        if (this.b == null) {
            this.d = i;
        } else {
            this.b.setCurrentItem(i);
        }
    }

    public final void a(boolean z) {
        BasePageFragment e = e();
        if (e != null) {
            e.onMainTabClick(z);
        }
    }

    public final void a(int i, int i2, Intent intent) {
        BasePageFragment e = e();
        if (e != null) {
            e.onCustomActivityResult(i, i2, intent);
        }
    }

    public boolean onBackPressed() {
        BasePageFragment e = e();
        if (e == null) {
            return super.onBackPressed();
        }
        return e.onBackPressed();
    }

    public void onResume() {
        super.onResume();
    }

    public void onDestroy() {
        super.onDestroy();
        i.a().b(this);
    }

    protected final PagerSlidingTabStrip d() {
        return this.a;
    }

    public void b(int i) {
        this.f.removeCallbacks(this.k);
        i = d(i);
        if (i != 0) {
            i.onPageSelected();
        }
    }

    protected final void c(int i) {
        i = d(i);
        if (i != 0) {
            i.onPageOff();
        }
    }

    protected final BasePageFragment e() {
        if (this.b == null) {
            return null;
        }
        return d(this.b.getCurrentItem());
    }

    protected final BasePageFragment d(int i) {
        if (this.g == null) {
            return 0;
        }
        return (BasePageFragment) this.g.a.get(i);
    }

    public void e(int i) {
        if (this.h != null) {
            this.h.setTextColor(Color.parseColor("#5a6473"));
            this.h.invalidate();
        }
        i = this.a.a(i);
        TextView textView = (TextView) i.findViewById(R.id.tab_title);
        textView.setTextColor(Color.parseColor("#1aa3ff"));
        textView.invalidate();
        i.findViewById(R.id.main_tab_top_point).setVisibility(8);
        i.findViewById(R.id.main_tab_top_live).setVisibility(8);
        this.h = textView;
    }

    public void b(boolean z) {
        BasePageFragment e = e();
        if (e != null) {
            e.onFullScreenChange(z);
        }
    }

    public void a(View view) {
        this.a = (PagerSlidingTabStrip) view.findViewById(R.id.pager_sliding_tab);
        this.a.setCurrentMode(a());
        this.a.setTabWidth(b());
        LayoutInflater from = LayoutInflater.from(getActivity());
        String[] f = f();
        int length = f.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= length) {
                break;
            }
            View inflate = from.inflate(R.layout.tab_spec_view, null);
            TextView textView = (TextView) inflate.findViewById(R.id.tab_title);
            this.i.add(textView);
            textView.setText(f[i]);
            a(i, (ImageView) inflate.findViewById(R.id.main_tab_top_point));
            this.a.a(inflate);
            String b = o.a().b(i);
            if (!("choiceness".equals(b) || "follow".equals(b) || "fun_pic".equals(b) || "short_movie".equals(b))) {
                if (!"youliao".equals(b)) {
                    z = false;
                }
            }
            if (z) {
                a aVar = new a(this);
                if (!(inflate == null || b == null)) {
                    inflate.setTag(b);
                    this.a.b.put(inflate.getTag(), aVar);
                }
            }
            i++;
        }
        this.b = (CustomViewPager) view.findViewById(R.id.viewPager);
        this.b.setAdapter(this.g);
        this.a.setViewPager(this.b);
        this.a.setOnPageChangeListener(this.j);
        this.b.setCurrentItem(this.d);
        if (this.d == null) {
            this.f.postDelayed(this.k, 500);
        }
        new Handler().postDelayed(new b(this), 2000);
        this.c = true;
    }
}
