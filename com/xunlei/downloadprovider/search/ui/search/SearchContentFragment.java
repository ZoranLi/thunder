package com.xunlei.downloadprovider.search.ui.search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.search.ui.widget.SearchHistoryListView;
import com.xunlei.downloadprovider.search.ui.widget.SearchHistoryListView.a;
import com.xunlei.downloadprovider.search.ui.widget.f;
import com.xunlei.downloadprovider.search.ui.widget.g;
import com.xunlei.downloadprovider.web.BrowserFrom;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;
import java.util.List;

public class SearchContentFragment extends Fragment {
    private SearchHistoryListView a;
    private ViewGroup b;
    private boolean c;
    private boolean d;
    private ErrorBlankView e;
    private View f;

    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        layoutInflater = layoutInflater.inflate(R.layout.search_content_fragment, null);
        this.a = (SearchHistoryListView) layoutInflater.findViewById(R.id.search_history_view);
        this.e = (ErrorBlankView) layoutInflater.findViewById(R.id.error_layout);
        this.e.findViewById(R.id.btn_action).setVisibility(8);
        this.e.setVisibility(8);
        this.e.setErrorType(0);
        this.e.getActionButton().setVisibility(8);
        viewGroup = LayoutInflater.from(getContext()).inflate(R.layout.search_hot_word_layout, this.a, false);
        this.a.addHeaderView(viewGroup);
        this.f = viewGroup.findViewById(R.id.hot_search_word_title);
        this.b = (ViewGroup) viewGroup.findViewById(R.id.hot_search_word_container);
        viewGroup = this.a;
        viewGroup.c = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.search_title_layout, viewGroup, false);
        viewGroup.addHeaderView(viewGroup.c);
        viewGroup.d = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.search_remove_history_layout, viewGroup, false);
        viewGroup.addFooterView(viewGroup.d);
        viewGroup.c.setVisibility(8);
        viewGroup.d.setVisibility(8);
        viewGroup.a = new b(viewGroup);
        viewGroup.findViewById(R.id.remove_history_btn).setOnClickListener(new f(viewGroup));
        return layoutInflater;
    }

    public void onResume() {
        super.onResume();
        a();
        List b = bq.a().b();
        if (b == null || b.size() <= 0 || b.size() > 15) {
            this.b.setVisibility(8);
            this.f.setVisibility(8);
            this.d |= 1;
            return;
        }
        for (int i = 0; i < b.size(); i++) {
            TextView textView = (TextView) this.b.getChildAt(i);
            textView.setVisibility(0);
            textView.setText((CharSequence) b.get(i));
            textView.setOnClickListener(new at(this, b, i));
        }
        this.b.setVisibility(0);
        this.d &= false;
    }

    public final void a() {
        if (this.a != null) {
            SearchContentFragment.class.getSimpleName();
            SearchHistoryListView searchHistoryListView = this.a;
            a asVar = new as(this);
            searchHistoryListView.setAdapter(searchHistoryListView.a);
            searchHistoryListView.b = asVar;
            XLThreadPool.execute(new g(searchHistoryListView, asVar));
        }
    }

    static /* synthetic */ void b(SearchContentFragment searchContentFragment) {
        SearchHistoryListView searchHistoryListView;
        int i;
        ViewGroup viewGroup;
        int i2 = 8;
        if (searchContentFragment.c) {
            if (searchContentFragment.d) {
                searchContentFragment.e.setVisibility(0);
                searchHistoryListView = searchContentFragment.a;
                if (searchContentFragment.c) {
                    if (!searchContentFragment.d) {
                        i = 8;
                        searchHistoryListView.setVisibility(i);
                        viewGroup = searchContentFragment.b;
                        if (searchContentFragment.d == null) {
                            i2 = 0;
                        }
                        viewGroup.setVisibility(i2);
                    }
                }
                i = 0;
                searchHistoryListView.setVisibility(i);
                viewGroup = searchContentFragment.b;
                if (searchContentFragment.d == null) {
                    i2 = 0;
                }
                viewGroup.setVisibility(i2);
            }
        }
        searchContentFragment.e.setVisibility(8);
        searchHistoryListView = searchContentFragment.a;
        if (searchContentFragment.c) {
            if (!searchContentFragment.d) {
                i = 8;
                searchHistoryListView.setVisibility(i);
                viewGroup = searchContentFragment.b;
                if (searchContentFragment.d == null) {
                    i2 = 0;
                }
                viewGroup.setVisibility(i2);
            }
        }
        i = 0;
        searchHistoryListView.setVisibility(i);
        viewGroup = searchContentFragment.b;
        if (searchContentFragment.d == null) {
            i2 = 0;
        }
        viewGroup.setVisibility(i2);
    }

    static /* synthetic */ void a(SearchContentFragment searchContentFragment, String str) {
        XLThreadPool.execute(new au(searchContentFragment, str));
        com.xunlei.downloadprovider.web.a.a();
        com.xunlei.downloadprovider.web.a.a(searchContentFragment.getContext(), 22, str, true, BrowserFrom.SEARCH_HOT_WORD);
    }
}
