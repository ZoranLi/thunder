package com.xunlei.downloadprovider.homepage.recommend.fans;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.xunlei.common.commonview.UnifiedLoadingView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.search.ui.a.c;
import com.xunlei.downloadprovider.search.ui.a.e;
import com.xunlei.downloadprovider.search.ui.a.e.a;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;
import com.xunlei.xllib.b.d;
import java.util.List;

public abstract class BaseListFragment<T extends c> extends Fragment implements a {
    protected int a = 20;
    protected PullToRefreshListView b;
    protected e<T> c;
    protected ErrorBlankView d;
    protected UnifiedLoadingView e;
    boolean f = true;
    protected boolean g;
    private int h = 2;
    private int i = 0;
    private boolean j = true;
    private View k;

    protected abstract e<T> i();

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        layoutInflater = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_base_list, viewGroup, false);
        this.b = (PullToRefreshListView) layoutInflater.findViewById(R.id.list);
        this.d = (ErrorBlankView) layoutInflater.findViewById(R.id.ev_error);
        this.e = (UnifiedLoadingView) layoutInflater.findViewById(R.id.lv_loading);
        this.k = LayoutInflater.from(getContext()).inflate(R.layout.common_pull_up_refresh_item, null);
        b();
        this.b.setOnScrollListener(new a(this));
        this.b.setOnRefreshListener(new b(this));
        return layoutInflater;
    }

    public void onResume() {
        super.onResume();
        this.g = false;
    }

    public void onPause() {
        super.onPause();
        this.g = true;
    }

    public void onDestroy() {
        super.onDestroy();
        a();
    }

    protected void b() {
        this.c = i();
        this.b.setAdapter(this.c);
    }

    protected final void c() {
        this.e.show();
        this.d.setVisibility(4);
    }

    private void a() {
        this.e.hide();
        this.d.setVisibility(4);
    }

    protected final void d() {
        this.d.setErrorType(0);
        this.d.setVisibility(0);
        this.d.a(null, null);
    }

    protected final void e() {
        a();
        if (this.c.isEmpty()) {
            this.d.setErrorType(2);
            this.d.setVisibility(0);
            this.d.a("刷新", new c(this));
            this.i = 1;
            return;
        }
        this.i = 2;
        this.h = 2;
        j();
        if (this.c.getCount() < this.a) {
            this.f = false;
        }
    }

    protected final void a(List<T> list) {
        e eVar;
        a();
        this.i = 2;
        this.h = 2;
        j();
        if (this.j) {
            eVar = this.c;
            if (!d.a(eVar.b)) {
                eVar.b.clear();
                eVar.notifyDataSetChanged();
            }
        }
        if ((list == null || list.isEmpty()) && this.c.isEmpty()) {
            d();
        } else if (list.size() <= 0) {
            this.f = null;
        } else {
            eVar = this.c;
            eVar.a();
            eVar.b.addAll(list);
            eVar.notifyDataSetChanged();
            this.c.notifyDataSetChanged();
        }
    }

    private void j() {
        if (this.b != null && this.k != null) {
            ((ListView) this.b.getRefreshableView()).removeFooterView(this.k);
        }
    }

    private boolean k() {
        if (!(this.h == 0 || this.i == 0)) {
            if (this.f) {
                return true;
            }
        }
        return false;
    }

    protected void f() {
        this.j = true;
    }

    protected void g() {
        if (k()) {
            this.j = false;
            if (!this.c.isEmpty()) {
                this.h = 0;
                j();
                if (!(this.b == null || this.k == null)) {
                    ((ListView) this.b.getRefreshableView()).addFooterView(this.k);
                }
            }
        }
    }

    public final void h() {
        if (this.c != null) {
            this.c.notifyDataSetChanged();
        }
    }
}
