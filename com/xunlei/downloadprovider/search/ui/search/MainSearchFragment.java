package com.xunlei.downloadprovider.search.ui.search;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.web.website.fragment.CollectionAndHistoryFragment;
import com.xunlei.downloadprovider.xlui.widget.PagerSlidingTabStrip;
import java.util.ArrayList;
import java.util.List;

public class MainSearchFragment extends Fragment {
    SearchContentFragment a;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        bundle = layoutInflater.inflate(R.layout.custom_view_pager_layout, null);
        ViewPager viewPager = (ViewPager) bundle.findViewById(R.id.viewPager);
        viewPager.setPageMargin(DipPixelUtil.dip2px(8.0f));
        List arrayList = new ArrayList();
        CollectionAndHistoryFragment a = CollectionAndHistoryFragment.a(1003);
        this.a = new SearchContentFragment();
        arrayList.add(this.a);
        arrayList.add(a);
        viewPager.setAdapter(new e(getFragmentManager(), arrayList));
        PagerSlidingTabStrip pagerSlidingTabStrip = (PagerSlidingTabStrip) bundle.findViewById(R.id.pager_sliding_tab);
        View inflate = layoutInflater.inflate(R.layout.tab_spec_view, null);
        ((TextView) inflate.findViewById(R.id.tab_title)).setText("搜索");
        pagerSlidingTabStrip.a(inflate);
        View inflate2 = layoutInflater.inflate(R.layout.tab_spec_view, null);
        ((TextView) inflate2.findViewById(R.id.tab_title)).setText(getString(R.string.mian_search_collect_tab_title));
        pagerSlidingTabStrip.a(inflate2);
        pagerSlidingTabStrip.setViewPager(viewPager);
        return bundle;
    }
}
