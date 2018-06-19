package com.xunlei.downloadprovider.homepage;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.commonview.DownloadEntranceView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.downloadlist.c;
import com.xunlei.downloadprovider.d.b.h;
import com.xunlei.downloadprovider.d.b.h.a;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.download.b.b;
import com.xunlei.downloadprovider.download.center.widget.v;
import com.xunlei.downloadprovider.download.create.m;
import com.xunlei.downloadprovider.download.report.DLCenterEntry;
import com.xunlei.downloadprovider.frame.BasePageFragment;
import com.xunlei.downloadprovider.frame.BaseViewPagerFragment;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.frame.MainTabActivity$b;
import com.xunlei.downloadprovider.h.i;
import com.xunlei.downloadprovider.h.j;
import com.xunlei.downloadprovider.homepage.choiceness.ui.HomeChoicenessFragment;
import com.xunlei.downloadprovider.homepage.follow.ac;
import com.xunlei.downloadprovider.homepage.follow.ui.FollowTabFragment;
import com.xunlei.downloadprovider.homepage.recommend.SummaryMoviesListFragment;
import com.xunlei.downloadprovider.homepage.youliao.YouliaoVideoFragment;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.g;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.search.ui.widget.HomeTitleBar;
import com.xunlei.downloadprovider.xlui.widget.PagerSlidingTabStrip;
import com.xunlei.downloadprovider.xlui.widget.PagerSlidingTabStrip.Mode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class HomeFragment extends BaseViewPagerFragment {
    Handler f = new Handler();
    Runnable g;
    private HomeTitleBar h;
    private View i;
    private View j;
    private View k;
    private o l = o.a();
    private BroadcastReceiver m;
    private String n;
    private boolean o = false;
    private DownloadEntranceView p;
    private v q;
    private m r = new m();
    private g s;
    private LoginHelper t = LoginHelper.a();
    private String u;
    private MainTabActivity$b v;
    private Handler w = new Handler();

    protected final void c() {
    }

    public void onCreate(Bundle bundle) {
        List list;
        o oVar = this.l;
        oVar.a.clear();
        oVar.b.clear();
        oVar.c.clear();
        oVar.d.clear();
        oVar.e.clear();
        List list2 = oVar.a;
        h hVar = d.a().g;
        if (b.c()) {
            List<a> list3 = hVar.a;
            boolean z = false;
            for (a aVar : list3) {
                if ("download".equals(aVar.a)) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                if (list3.size() < 2) {
                    list3.add(h.a());
                } else {
                    list3.add(2, h.a());
                }
            }
        } else {
            list = hVar.a;
            if (!list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if ("download".equals(((a) it.next()).a)) {
                        it.remove();
                    }
                }
            }
        }
        if (hVar.a == null || hVar.a.isEmpty()) {
            list = hVar.a;
            Collection arrayList = new ArrayList();
            a aVar2 = new a();
            aVar2.a = "follow";
            aVar2.b = "关注";
            arrayList.add(aVar2);
            aVar2 = new a();
            aVar2.a = "choiceness";
            aVar2.b = "精选";
            arrayList.add(aVar2);
            if (b.c()) {
                arrayList.add(h.a());
            }
            aVar2 = new a();
            aVar2.a = "short_movie";
            aVar2.b = "短片";
            arrayList.add(aVar2);
            list.addAll(arrayList);
        }
        new StringBuilder("getTabList--tabList=").append(hVar.a);
        list2.addAll(hVar.a);
        oVar.b();
        super.onCreate(bundle);
        this.m = new k(this);
        bundle = new IntentFilter();
        bundle.addAction("com.xunlei.downloadprovider.app.action.FOLLOW_DATA_UPDATED");
        bundle.addAction("com.xunlei.downloadprovider.app.action.LIVE_DATA_UPDATED");
        bundle.addAction("action_enter_full_screen_mode");
        bundle.addAction("action_exit_full_screen_mode");
        bundle.addAction("action_move_up");
        bundle.addAction("action_move_down");
        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(this.m, bundle);
        ac.a().a.edit().remove("latest_p_time").apply();
        bundle = m.a();
        bundle.a = true;
        bundle.c();
        this.s = new e(this);
        this.t.a(this.s);
    }

    protected View createView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.i = LayoutInflater.from(getActivity()).inflate(R.layout.main_home_fragment, viewGroup, false);
        a(this.i);
        this.n = this.l.a(0);
        layoutInflater = this.l.a("choiceness");
        if (layoutInflater >= null) {
            a((int) layoutInflater);
            this.n = "choiceness";
        }
        this.i.setOnTouchListener(new f(this));
        return this.i;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.v = new g(this);
        MainTabActivity mainTabActivity = (MainTabActivity) getActivity();
        mainTabActivity.i.add(this.v);
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onDestroy() {
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.m);
        if (this.s != null) {
            this.t.b(this.s);
        }
        super.onDestroy();
    }

    protected final void a(View view) {
        super.a(view);
        this.j = view.findViewById(R.id.title_layout);
        HomeTitleBar homeTitleBar = (HomeTitleBar) view.findViewById(R.id.title_bar);
        homeTitleBar.setDlCenterEntry(DLCenterEntry.home);
        homeTitleBar.setOnTitleClickListener(new i(this));
        homeTitleBar.setSearchDownloadEntranceState(false);
        this.h = homeTitleBar;
        this.g = new j(this);
        this.p = (DownloadEntranceView) view.findViewById(R.id.tab_download_entrance);
        this.p.setOnClickListener(new h(this));
        this.k = view.findViewById(R.id.tab_space);
        this.b.setPageMargin(getResources().getDimensionPixelOffset(R.dimen.search_line_space_normal));
        this.b.setPageMarginDrawable(getResouceDrawable(R.drawable.viewpage_space_drawable));
        com.xunlei.downloadprovider.download.tasklist.list.feed.b.a.a().a(view.findViewById(R.id.iv_go_to_top));
        view.findViewById(R.id.status_bar_fix).setLayoutParams(new LayoutParams(-1, j.a(getActivity())));
        j.a(getActivity());
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.r.a(getActivity(), this.j, this.p, this.k, this.b, this.h);
    }

    protected final Mode a() {
        return Mode.SLOID_TABS;
    }

    protected final int b() {
        return DipPixelUtil.dip2px(60.0f);
    }

    protected final String[] f() {
        return this.l.g;
    }

    protected final Class<?>[] g() {
        return this.l.f;
    }

    public void onResume() {
        super.onResume();
        if (this.q == null) {
            this.q = new v(this.p);
        }
        this.q.a();
        boolean z = false;
        this.q.a(false);
        this.h.a();
        HomeTitleBar homeTitleBar = this.h;
        if (homeTitleBar.a != null) {
            homeTitleBar.a.a(false);
        }
        i.b(getContext(), "com.xunlei.downloadprovider.app.action.CHECK_FOLLOW_UPDATE");
        i.a(getContext(), "com.xunlei.downloadprovider.app.action.CHECK_FOLLOW_UPDATE");
        if (isAdded()) {
            com.xunlei.downloadprovider.d.i.a().a(System.currentTimeMillis(), "recommend");
            ((MainTabActivity) this.mActivity).a("thunder", 8);
        }
        Bundle extras = getExtras();
        if (extras != null) {
            String string = extras.getString("home_sub_tab_tag");
            if (!TextUtils.isEmpty(string)) {
                if (string.equals("download")) {
                    c.a().d = true;
                }
                int a = this.l.a(string);
                if (a >= 0) {
                    int i;
                    if (this.b == null) {
                        i = this.d;
                    } else {
                        i = this.b.getCurrentItem();
                    }
                    a(a);
                    this.n = string;
                    extras.remove("home_sub_tab_tag");
                    string = "home_sub_tab_has_switch_tab";
                    if (i != a) {
                        z = true;
                    }
                    extras.putBoolean(string, z);
                    BasePageFragment d = d(a);
                    if (d != null) {
                        d.onNewExtras(extras);
                    }
                }
            }
        }
        this.f.postDelayed(this.g, 300);
    }

    protected final void a(int i, View view) {
        com.xunlei.downloadprovider.d.i a = com.xunlei.downloadprovider.d.i.a();
        if (a.b()) {
            i = f(i);
            boolean e = a.e(i);
            int i2 = 0;
            if (!e || "follow".equals(i) == 0) {
                if (!e) {
                    i2 = 8;
                }
                view.setVisibility(i2);
                return;
            }
            c(false);
        }
    }

    private void c(boolean z) {
        if (z || !this.o) {
            PagerSlidingTabStrip d = d();
            if (d != null) {
                int length = this.l.f.length;
                for (int i = 0; i < length; i++) {
                    if ("follow".equals(f(i))) {
                        View a = d.a(i);
                        ImageView imageView = (ImageView) a.findViewById(R.id.main_tab_top_point);
                        ImageView imageView2 = (ImageView) a.findViewById(R.id.main_tab_top_live);
                        if (z) {
                            imageView2.setVisibility(0);
                            imageView.setVisibility(8);
                            this.o = true;
                        } else {
                            imageView2.setVisibility(8);
                            imageView.setVisibility(0);
                            this.o = false;
                        }
                        this.l.a(i, true);
                        ac.a().a(z ^ 1);
                        ac.a().b(z);
                        return;
                    }
                }
            }
        }
    }

    protected final void e(int i) {
        super.e(i);
        this.n = this.l.a(i);
        long currentTimeMillis = System.currentTimeMillis();
        i = f(i);
        com.xunlei.downloadprovider.d.i.a().a(currentTimeMillis, i);
        if ("follow".equals(i) != 0) {
            ac.a().a(false);
            ac.a().b(false);
            this.o = false;
        }
    }

    private String f(int i) {
        return this.l.a(i);
    }

    public final void a(com.xunlei.downloadprovider.d.i iVar) {
        super.a(iVar);
        this.w.post(new l(this));
    }

    protected final void b(int i) {
        super.b(i);
        i = this.l.b(i);
        LoginHelper.a();
        p.a(i, l.c());
        i = e();
        if (i instanceof HomeChoicenessFragment) {
            this.e = (HomeChoicenessFragment) i;
        }
        if (i instanceof FollowTabFragment) {
            this.e = (FollowTabFragment) i;
        }
        if (i instanceof SummaryMoviesListFragment) {
            this.e = (SummaryMoviesListFragment) i;
        }
        if (i instanceof YouliaoVideoFragment) {
            this.e = (YouliaoVideoFragment) i;
        }
    }

    protected final void b(boolean z) {
        super.b(z);
    }

    public final void h() {
        BasePageFragment e = e();
        if (e != null) {
            e.onExitApp();
        }
    }

    public void onPause() {
        if (this.q != null) {
            this.q.b();
        }
        HomeTitleBar homeTitleBar = this.h;
        if (homeTitleBar.a != null) {
            homeTitleBar.a.b();
        }
        getContext();
        i.a("com.xunlei.downloadprovider.app.action.CHECK_FOLLOW_UPDATE");
        super.onPause();
        this.f.removeCallbacks(this.g);
    }
}
