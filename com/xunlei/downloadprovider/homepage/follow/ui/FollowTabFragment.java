package com.xunlei.downloadprovider.homepage.follow.ui;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.SimpleItemAnimator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.frame.BaseFragment;
import com.xunlei.downloadprovider.frame.BasePageFragment;
import com.xunlei.downloadprovider.frame.f;
import com.xunlei.downloadprovider.homepage.follow.aa;
import com.xunlei.downloadprovider.homepage.follow.ab;
import com.xunlei.downloadprovider.homepage.follow.ad;
import com.xunlei.downloadprovider.homepage.follow.b;
import com.xunlei.downloadprovider.homepage.follow.c.ai;
import com.xunlei.downloadprovider.homepage.follow.c.e;
import com.xunlei.downloadprovider.homepage.follow.j;
import com.xunlei.downloadprovider.homepage.follow.k;
import com.xunlei.downloadprovider.homepage.follow.m;
import com.xunlei.downloadprovider.homepage.o;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.payment.a.e$d;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import com.xunlei.downloadprovider.player.a.a;
import com.xunlei.downloadprovider.xlui.recyclerview.XRecyclerView;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FollowTabFragment extends BasePageFragment implements f {
    private HashMap<String, Boolean> a = new HashMap();
    private View b;
    private XRecyclerView c;
    private LayoutManager d;
    private aa e;
    private a f;
    private ErrorBlankView g;
    private View h;
    private TextView i;
    private b j;
    private final af k = new af();
    private LocalBroadcastManager l;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private BroadcastReceiver q = new o(this);
    private com.xunlei.downloadprovider.homepage.a r = new com.xunlei.downloadprovider.homepage.a(new p(this));
    private aa s = new q(this);

    protected String getTabId() {
        return "follow";
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.l = LocalBroadcastManager.getInstance(BrothersApplication.getApplicationInstance());
        bundle = new IntentFilter();
        bundle.addAction("new_follow");
        bundle.addAction("cancel_follow");
        bundle.addAction("new_user_login_success");
        bundle.addAction("user_logout");
        this.l.registerReceiver(this.q, bundle);
        ab.a().a(this.s);
    }

    protected View createView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(R.layout.follow_tab_fragment, viewGroup, false);
        this.b = layoutInflater;
        this.c = (XRecyclerView) layoutInflater.findViewById(R.id.recycler_view);
        this.d = new LinearLayoutManager(this.mActivity);
        this.c.setLayoutManager(this.d);
        ((SimpleItemAnimator) this.c.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f = new a(getContext());
        this.f.a = this.c;
        this.e = new aa(getContext(), this.c, this.k, this.f);
        this.c.setAdapter(this.e);
        this.c.setLoadingListener(new s(this));
        this.c.setOnTouchListener(new t(this));
        this.c.addOnScrollListener(new u(this));
        this.g = (ErrorBlankView) layoutInflater.findViewById(R.id.error_view);
        this.g.setActionButtonListener(new v(this));
        this.g.setOnTouchListener(new w(this));
        this.h = layoutInflater.findViewById(R.id.following_success_loading_view);
        this.i = (TextView) layoutInflater.findViewById(R.id.tv_follow_success);
        this.j = b.a();
        return layoutInflater;
    }

    public void onResume() {
        super.onResume();
        Bundle c = c();
        if (c != null) {
            String string = c.getString("follow_tab_from");
            if (!TextUtils.isEmpty(string)) {
                int i = -1;
                int hashCode = string.hashCode();
                if (hashCode != 931605900) {
                    if (hashCode == 2053493335) {
                        if (string.equals("follow_tab_from_push")) {
                            i = 0;
                        }
                    }
                } else if (string.equals("follow_tab_guide_follow")) {
                    i = 1;
                }
                switch (i) {
                    case 0:
                        this.c.d();
                        break;
                    case 1:
                        int i2 = c.getInt("guide_follow_increase_follows");
                        this.c.d();
                        TextView textView = this.i;
                        StringBuilder stringBuilder = new StringBuilder("已成功关注");
                        stringBuilder.append(i2);
                        stringBuilder.append("位播主");
                        textView.setText(stringBuilder.toString());
                        this.h.setVisibility(0);
                        this.h.postDelayed(new i(this), 1000);
                        break;
                    default:
                        break;
                }
            }
            c.remove("follow_tab_from");
        }
    }

    private Bundle c() {
        Fragment parentFragment = getParentFragment();
        return parentFragment instanceof BaseFragment ? ((BaseFragment) parentFragment).getExtras() : null;
    }

    private void d() {
        this.j.b(new n(this));
    }

    public void onUserVisible(boolean z) {
        boolean z2;
        super.onUserVisible(z);
        int i = 1;
        if (z) {
            d();
            LoginHelper.a();
            if (l.c()) {
                b.a(new m(this.j, new x(this)));
            } else {
                a(1);
            }
        }
        if (this.e) {
            this.e.a(false);
        }
        if (this.c) {
            this.r.a();
        }
        z = o.a();
        int a = z.a("follow");
        if (a >= z.e.size()) {
            z2 = false;
        } else {
            z2 = ((Boolean) z.e.get(a)).booleanValue();
        }
        Bundle c = c();
        Object obj = "";
        if (c != null) {
            obj = c.getString("follow_tab_from");
        }
        int i2 = this.k.a;
        if (i2 != 3) {
            if (i2 != 6) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        i = 0;
                    }
                }
                i = 2;
            }
        }
        if ("follow_tab_from_push".equals(obj)) {
            LoginHelper.a();
            ad.a(z2, "push", l.c(), i);
        } else {
            String str = DispatchConstants.OTHER;
            LoginHelper.a();
            ad.a(z2, str, l.c(), i);
        }
        if (z2 && !this.r.a) {
            this.c.d();
        }
        z.a(a, false);
        if (this.p) {
            e();
            this.p = false;
        }
    }

    public void onUserInvisible(boolean z) {
        super.onUserInvisible(z);
        this.r.b();
        if (this.e) {
            this.e.b();
        }
        this.p = false;
    }

    public void onExitApp() {
        super.onExitApp();
        this.r.b();
    }

    public void onDestroy() {
        super.onDestroy();
        this.l.unregisterReceiver(this.q);
        ab.a().b(this.s);
    }

    public final void a() {
        LoginHelper.a();
        if (l.c()) {
            this.c.d();
            e();
        }
    }

    public void onMainTabClick(boolean z) {
        if (!z) {
            LoginHelper.a();
            if (l.c()) {
                this.c.d();
                e();
            }
        }
    }

    private void e() {
        this.d.scrollToPosition(0);
    }

    private void a(int i) {
        this.k.a = i;
        if (!(i == 1 || i == 2)) {
            if (i != 3) {
                if (i == 6) {
                    this.c.setLoadingMoreEnabled(true ^ this.k.d());
                    return;
                } else {
                    this.c.setLoadingMoreEnabled(true);
                    return;
                }
            }
        }
        this.k.e();
        this.j.c();
        this.c.setLoadingMoreEnabled(false);
    }

    private void f() {
        if (this.k.a()) {
            this.g.postDelayed(new r(this), 500);
        } else {
            g();
        }
    }

    private void g() {
        if (isVisible()) {
            if (com.xunlei.xllib.android.b.a(BrothersApplication.getApplicationInstance())) {
                XLToast.showToast(getContext(), "网络异常");
            } else {
                XLToast.showNoNetworkToast(getContext());
            }
        }
    }

    static /* synthetic */ void b(FollowTabFragment followTabFragment) {
        if (com.xunlei.xllib.android.b.a(BrothersApplication.getApplicationInstance())) {
            LoginHelper.a();
            boolean c = l.c();
            if (!followTabFragment.m || c) {
                if (!(followTabFragment.m || followTabFragment.n)) {
                    followTabFragment.d();
                }
                if (c) {
                    followTabFragment.j.a(new y(followTabFragment));
                }
                return;
            }
            followTabFragment.c.b();
            return;
        }
        followTabFragment.c.b();
        followTabFragment.f();
    }

    static /* synthetic */ void e(FollowTabFragment followTabFragment) {
        b bVar = followTabFragment.j;
        XLThreadPool.execute(new e(bVar.d, bVar.m, new k(bVar, new k(followTabFragment))));
    }

    static /* synthetic */ void n(FollowTabFragment followTabFragment) {
        if (followTabFragment.k.a()) {
            followTabFragment.g.setVisibility(0);
        }
    }

    static /* synthetic */ void o(FollowTabFragment followTabFragment) {
        List unmodifiableList = Collections.unmodifiableList(followTabFragment.j.h);
        if (unmodifiableList == null || unmodifiableList.size() < 4 || followTabFragment.o) {
            b bVar = followTabFragment.j;
            bVar.d.a(4, "", new com.xunlei.downloadprovider.homepage.follow.e(bVar, new l(followTabFragment)));
        }
    }

    static /* synthetic */ void q(FollowTabFragment followTabFragment) {
        b bVar = followTabFragment.j;
        c mVar = new m(followTabFragment);
        followTabFragment = bVar.d;
        e$d jVar = new j(bVar, mVar);
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/follow/live_list");
        stringBuilder.append("?ptime=0");
        new StringBuilder("getFollowingLiveList:url=>").append(stringBuilder);
        XLThreadPool.execute(new ai(followTabFragment, stringBuilder, jVar));
    }

    static /* synthetic */ void r(FollowTabFragment followTabFragment) {
        b bVar = followTabFragment.j;
        XLThreadPool.execute(new com.xunlei.downloadprovider.homepage.follow.c.k(bVar.d, bVar.l, new com.xunlei.downloadprovider.homepage.follow.l(bVar, new z(followTabFragment))));
    }

    static /* synthetic */ boolean u(FollowTabFragment followTabFragment) {
        return (!((Boolean) followTabFragment.a.get("latest_feeds")).booleanValue() || ((Boolean) followTabFragment.a.get("live_hosts")).booleanValue() == null) ? null : true;
    }
}
