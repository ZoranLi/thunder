package com.xunlei.downloadprovider.homepage.choiceness.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.frame.BasePageFragment;
import com.xunlei.downloadprovider.frame.f;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter$RefreshType;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.e;
import com.xunlei.downloadprovider.homepage.choiceness.a.h;
import com.xunlei.downloadprovider.homepage.choiceness.a.t;
import com.xunlei.downloadprovider.homepage.choiceness.g;
import com.xunlei.downloadprovider.homepage.choiceness.k;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.d;
import com.xunlei.downloadprovider.player.a.a;
import com.xunlei.downloadprovider.xlui.recyclerview.XRecyclerView;
import com.xunlei.downloadprovider.xlui.recyclerview.XRecyclerView.b;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;
import java.util.ArrayList;
import java.util.List;

public class HomeChoicenessFragment extends BasePageFragment implements f {
    private RefreshPromptView a;
    private ErrorBlankView b;
    private XRecyclerView c;
    private ImageView d;
    private LinearLayoutManager e;
    private i f;
    private a g;
    private com.xunlei.downloadprovider.homepage.choiceness.a.a h;
    private Handler i = new Handler();
    private com.xunlei.downloadprovider.homepage.a j;
    private ChoicenessReporter$RefreshType k = ChoicenessReporter$RefreshType.manul_pull;
    private boolean l;
    private k m;
    private g n;
    private LocalBroadcastManager o = LocalBroadcastManager.getInstance(BrothersApplication.getApplicationInstance());
    private com.xunlei.downloadprovider.homepage.choiceness.jointactivity.g p;
    private com.xunlei.downloadprovider.homepage.a.a q = new r(this);
    private com.xunlei.downloadprovider.e.b.a r = new s(this);
    private d s = new t(this);
    private BroadcastReceiver t = new u(this);
    private b u = new v(this);
    private OnScrollListener v = new k(this);
    private k.a w = new l(this);
    private y x = new m(this);

    protected String getTabId() {
        return "choiceness";
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.h = com.xunlei.downloadprovider.homepage.choiceness.a.a.a((Context) activity);
        this.j = new com.xunlei.downloadprovider.homepage.a(this.q);
        this.m = new k(activity);
        this.n = new g(activity);
        this.p = new com.xunlei.downloadprovider.homepage.choiceness.jointactivity.g(activity);
        this.m.i = this.p;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = new IntentFilter();
        bundle.addAction("following_id_list_loaded");
        bundle.addAction("user_logout");
        bundle.addAction("live_viewfinder_show");
        bundle.addAction("live_viewfinder_hide");
        this.o.registerReceiver(this.t, bundle);
        com.xunlei.downloadprovider.e.b.b.a();
        com.xunlei.downloadprovider.e.b.b.a(this.r);
    }

    public void onDestroy() {
        super.onDestroy();
        com.xunlei.downloadprovider.e.b.b.a();
        com.xunlei.downloadprovider.e.b.b.b(this.r);
        this.o.unregisterReceiver(this.t);
        LoginHelper.a().b(this.s);
    }

    public void onResume() {
        super.onResume();
        this.m.b();
        this.p.d();
    }

    public boolean onBackPressed() {
        this.x.a();
        this.x.b();
        return super.onBackPressed();
    }

    public void onUserVisible(boolean z) {
        super.onUserVisible(z);
        if (z) {
            if (com.xunlei.downloadprovider.d.d.a().b.s()) {
                t.a().a(0);
            } else {
                XLThreadPool.execute(new b(this.h, new q(this)));
            }
        }
        if (this.f) {
            this.f.a(this.l);
            this.l = false;
        }
        if (!this.c.a && !this.c.b) {
            this.j.a();
        }
    }

    public void onUserInvisible(boolean z) {
        super.onUserInvisible(z);
        this.j.b();
        if (this.f) {
            this.f.b();
        }
    }

    public void onExitApp() {
        super.onExitApp();
        this.j.b();
    }

    public void onMainTabClick(boolean z) {
        super.onMainTabClick(z);
        this.l = z;
        if (!z) {
            a(ChoicenessReporter$RefreshType.single_click_bottom_rec);
        }
    }

    protected View createView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(R.layout.home_choiceness_fragment1, viewGroup, false);
        this.a = (RefreshPromptView) layoutInflater.findViewById(R.id.refresh_prompt);
        this.a.setTranslationY((float) (-DipPixelUtil.dip2px(37.0f)));
        this.b = (ErrorBlankView) layoutInflater.findViewById(R.id.error_layout);
        this.b.setActionButtonListener(new j(this));
        this.b.setOnTouchListener(new n(this));
        this.d = (ImageView) layoutInflater.findViewById(R.id.live_player_image);
        this.c = (XRecyclerView) layoutInflater.findViewById(R.id.recyclerView);
        this.e = new LinearLayoutManager(getActivity());
        this.c.setLayoutManager(this.e);
        this.g = new a(getActivity());
        this.g.a = this.c;
        this.f = new i(getActivity(), this.c, this.g, this.x);
        this.c.setAdapter(this.f);
        this.f.a(this.h.e);
        this.c.setOnTouchListener(new o(this));
        this.c.setLoadingListener(this.u);
        this.c.addOnScrollListener(this.v);
        com.xunlei.downloadprovider.ad.home.a.f.a(getActivity().getApplicationContext()).d = this.f;
        h.a().c = this.f;
        this.m.b = this.c;
        this.m.g = this.w;
        this.n.b = this.m;
        this.n.a = this.c;
        this.n.a();
        LoginHelper.a().a(this.s);
        return layoutInflater;
    }

    public final void a() {
        a(ChoicenessReporter$RefreshType.single_click_top_tab);
    }

    private void a(boolean z, com.xunlei.downloadprovider.homepage.choiceness.a.a.k kVar) {
        Context activity = getActivity();
        boolean a = com.xunlei.xllib.android.b.a(BrothersApplication.getApplicationInstance());
        if (this.f.a()) {
            if (a) {
                this.b.setErrorType(0);
            } else {
                this.b.setErrorType(2);
            }
            this.b.setVisibility(0);
        } else {
            this.b.setVisibility(8);
        }
        if (!this.f.a() && isResumed()) {
            if (!a) {
                XLToast.showNoNetworkToast(getContext());
            } else if (kVar == null) {
                XLToast.showToast(activity, "网络异常");
            } else {
                int a2 = a(kVar.a);
                if (!z) {
                    if (a2 != null) {
                        this.a.a(a2);
                        return;
                    }
                }
                this.a.a();
            }
        }
    }

    private static int a(List list) {
        return list == null ? null : list.size();
    }

    public final void a(ChoicenessReporter$RefreshType choicenessReporter$RefreshType) {
        this.k = choicenessReporter$RefreshType;
        this.c.scrollToPosition(0);
        this.c.d();
    }

    private void a(com.xunlei.downloadprovider.homepage.choiceness.a.a.k kVar) {
        if (kVar != null) {
            if (kVar.g) {
                this.x.a(this.k, com.xunlei.downloadprovider.ad.common.f.a(kVar.f));
            } else {
                List arrayList = new ArrayList();
                if (kVar.a != null) {
                    arrayList.addAll(kVar.a);
                }
                this.x.a(this.k, arrayList);
            }
        }
    }

    static /* synthetic */ void a(HomeChoicenessFragment homeChoicenessFragment, List list, com.xunlei.downloadprovider.homepage.choiceness.a.a.k kVar) {
        if (list != null) {
            list.isEmpty();
        }
        homeChoicenessFragment.j.a = false;
        homeChoicenessFragment.a(kVar);
        homeChoicenessFragment.k = ChoicenessReporter$RefreshType.manul_pull;
        FragmentActivity activity = homeChoicenessFragment.getActivity();
        if (homeChoicenessFragment.f != null) {
            if (activity != null) {
                if (kVar != null && kVar.a()) {
                    homeChoicenessFragment.f.a(list);
                    list = h.a();
                    a(kVar.a);
                    if (h.b()) {
                        list.c();
                    }
                }
                homeChoicenessFragment.a(false, kVar);
            }
        }
    }

    static /* synthetic */ void b(HomeChoicenessFragment homeChoicenessFragment, List list, com.xunlei.downloadprovider.homepage.choiceness.a.a.k kVar) {
        homeChoicenessFragment.a(kVar);
        homeChoicenessFragment.k = ChoicenessReporter$RefreshType.manul_pull;
        FragmentActivity activity = homeChoicenessFragment.getActivity();
        if (homeChoicenessFragment.f != null) {
            if (activity != null) {
                if (kVar != null && kVar.a()) {
                    List list2 = homeChoicenessFragment.f.a;
                    if (list.size() >= list2.size()) {
                        int indexOf = list.indexOf((e) list2.get(list2.size() - 1));
                        if (indexOf == list2.size() - 1) {
                            i iVar = homeChoicenessFragment.f;
                            iVar.a.clear();
                            if (!com.xunlei.xllib.b.d.a(list)) {
                                iVar.a.addAll(list);
                            }
                            homeChoicenessFragment.f.notifyItemRangeInserted(indexOf, list.size() - list2.size());
                            list = h.a();
                            if (h.b()) {
                                list.c();
                            }
                        }
                    }
                    homeChoicenessFragment.f.a(list);
                    list = h.a();
                    if (h.b()) {
                        list.c();
                    }
                }
                homeChoicenessFragment.a(true, kVar);
            }
        }
    }
}
