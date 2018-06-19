package com.xunlei.downloadprovider.homepage.recommend.fans;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xunlei.common.commonview.UnifiedLoadingView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.search.ui.a.b;
import com.xunlei.downloadprovider.search.ui.a.f;
import com.xunlei.downloadprovider.search.ui.a.f.a;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;
import com.xunlei.xllib.b.d;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyViewFragment<T> extends Fragment implements a {
    private int a = 2;
    private int b = 0;
    protected RecyclerView c;
    protected b<T> d;
    protected com.xunlei.downloadprovider.player.a.a e;
    protected ErrorBlankView f;
    protected UnifiedLoadingView g;
    protected List<T> h = new ArrayList();
    protected boolean i;
    protected boolean j;
    private boolean k = false;
    private boolean l = true;
    private LinearLayoutManager m;

    public void e() {
    }

    public int f() {
        return 10;
    }

    public abstract b<T> j();

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        layoutInflater = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_recy_base_list, viewGroup, false);
        this.c = (RecyclerView) layoutInflater.findViewById(R.id.list);
        if (this.e != null) {
            this.e.a = this.c;
        }
        this.f = (ErrorBlankView) layoutInflater.findViewById(R.id.ev_error);
        this.g = (UnifiedLoadingView) layoutInflater.findViewById(R.id.lv_loading);
        this.c.setOnTouchListener(new d(this));
        this.c.addOnScrollListener(new e(this));
        a();
        this.c.addOnScrollListener(new f(this));
        return layoutInflater;
    }

    public void onResume() {
        super.onResume();
        this.i = false;
    }

    public void onPause() {
        super.onPause();
        this.i = true;
    }

    public void onDestroy() {
        super.onDestroy();
        k();
    }

    public void a() {
        this.d = j();
        this.c.setAdapter(this.d);
        this.m = new LinearLayoutManager(getContext());
        this.c.setLayoutManager(this.m);
    }

    protected final void b() {
        this.g.show();
        this.f.setVisibility(4);
    }

    private void k() {
        this.g.hide();
        this.f.setVisibility(4);
    }

    protected final void c() {
        k();
        e();
        if (this.h != null) {
            if (!this.h.isEmpty()) {
                e();
                this.b = 2;
                if (this.h.size() < g()) {
                    this.k = false;
                }
                return;
            }
        }
        this.f.setErrorType(2);
        this.f.setVisibility(0);
        this.f.a("刷新", new h(this));
        this.b = 1;
    }

    protected final void a(List<T> list) {
        k();
        this.b = 2;
        this.a = 2;
        if (this.l) {
            this.h.clear();
        }
        if ((list == null || list.isEmpty()) && this.h.isEmpty()) {
            this.f.setErrorType(0);
            this.f.setVisibility(0);
            this.f.a("刷新", new g(this));
            return;
        }
        this.h.addAll(list);
        f fVar = this.d;
        fVar.c();
        fVar.b.addAll(list);
        fVar.notifyDataSetChanged();
        this.d.notifyDataSetChanged();
        if (this.j == null) {
            this.k = false;
            e();
            return;
        }
        this.k = true;
        d();
    }

    public void d() {
        e();
    }

    public int g() {
        return f();
    }

    protected final void c(boolean z) {
        this.j = z;
    }

    private boolean l() {
        if (!(this.a == 0 || this.b == 0)) {
            if (this.k) {
                return true;
            }
        }
        return false;
    }

    public void h() {
        this.l = true;
    }

    public void i() {
        if (l()) {
            this.l = false;
            if (!this.h.isEmpty()) {
                this.a = 0;
            }
        }
    }

    protected final void a(T t) {
        if (this.d != null) {
            f fVar = this.d;
            fVar.c();
            fVar.b.add(t);
            fVar.notifyDataSetChanged();
        }
    }

    protected final void b(T t) {
        if (this.d != null) {
            f fVar = this.d;
            if (!d.a(fVar.b)) {
                fVar.b.remove(t);
                fVar.notifyDataSetChanged();
            }
        }
    }
}
