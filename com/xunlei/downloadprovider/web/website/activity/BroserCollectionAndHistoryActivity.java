package com.xunlei.downloadprovider.web.website.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.frame.view.CustomViewPager;
import com.xunlei.downloadprovider.web.browser.aa;
import com.xunlei.downloadprovider.web.website.fragment.CollectionAndHistoryFragment;
import com.xunlei.downloadprovider.xlui.widget.PagerSlidingTabStrip;
import com.xunlei.xllib.android.XLIntent;
import java.util.ArrayList;
import java.util.List;

public class BroserCollectionAndHistoryActivity extends BaseActivity {
    private static String[] i = new String[]{"收藏", "历史"};
    private ImageView a;
    private CustomViewPager c;
    private PagerSlidingTabStrip d;
    private List<Fragment> e = new ArrayList();
    private List<TextView> f = new ArrayList(2);
    private CollectionAndHistoryFragment g;
    private CollectionAndHistoryFragment h;
    private FragmentPagerAdapter j = new b(this, getSupportFragmentManager());
    private OnPageChangeListener k = new c(this);

    public static void a(Context context) {
        context.startActivity(new XLIntent(context, BroserCollectionAndHistoryActivity.class));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_collection_and_history);
        this.a = (ImageView) findViewById(R.id.back);
        this.c = (CustomViewPager) findViewById(R.id.viewPager);
        this.d = (PagerSlidingTabStrip) findViewById(R.id.pager_sliding_tab);
        bundle = LayoutInflater.from(this);
        for (CharSequence text : i) {
            View inflate = bundle.inflate(R.layout.tab_spec_view, null);
            TextView textView = (TextView) inflate.findViewById(R.id.tab_title);
            this.f.add(textView);
            textView.setText(text);
            this.d.a(inflate);
        }
        this.g = CollectionAndHistoryFragment.a(1000);
        this.h = CollectionAndHistoryFragment.a(1001);
        this.e.add(this.g);
        this.e.add(this.h);
        this.c.setAdapter(this.j);
        this.d.setViewPager(this.c);
        this.d.setOnPageChangeListener(this.k);
        this.a.setOnClickListener(new a(this));
        aa.b();
    }
}
