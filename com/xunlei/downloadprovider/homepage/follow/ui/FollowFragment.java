package com.xunlei.downloadprovider.homepage.follow.ui;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xunlei.common.commonview.UnifiedLoadingView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.frame.BaseFragment;
import com.xunlei.downloadprovider.homepage.follow.aa;
import com.xunlei.downloadprovider.homepage.follow.ab;
import com.xunlei.downloadprovider.homepage.follow.ad;
import com.xunlei.downloadprovider.homepage.follow.b;
import com.xunlei.downloadprovider.homepage.follow.b.a;
import com.xunlei.downloadprovider.homepage.follow.ui.view.ap;
import com.xunlei.downloadprovider.homepage.follow.z;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.payment.a.e$e;
import com.xunlei.downloadprovider.xlui.recyclerview.XRecyclerView;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;
import java.util.List;

public class FollowFragment extends BaseFragment {
    private XRecyclerView a;
    private h b;
    private ErrorBlankView c;
    private UnifiedLoadingView d;
    private b e;
    private LocalBroadcastManager f;
    private String g = "";
    private boolean h = true;
    private final ab i = new ab();
    private boolean j = false;
    private BroadcastReceiver k = new f(this);
    private aa l = new g(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f = LocalBroadcastManager.getInstance(BrothersApplication.getApplicationInstance());
        bundle = new IntentFilter();
        bundle.addAction("new_follow");
        bundle.addAction("cancel_follow");
        bundle.addAction("new_user_login_success");
        bundle.addAction("user_logout");
        this.f.registerReceiver(this.k, bundle);
        this.e = b.a();
        ad.c();
        ab.a().a(this.l);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(R.layout.follow_fragment, viewGroup, false);
        this.a = (XRecyclerView) layoutInflater.findViewById(R.id.lv_follow);
        this.b = new h(getContext(), this.i);
        this.a.setLayoutManager(new LinearLayoutManager(getContext()));
        this.a.setAdapter(this.b);
        this.a.setPullRefreshEnabled(false);
        this.a.setLoadingListener(new c(this));
        this.c = (ErrorBlankView) layoutInflater.findViewById(R.id.error_view);
        this.d = (UnifiedLoadingView) layoutInflater.findViewById(R.id.loading_view);
        viewGroup = com.xunlei.xllib.android.b.a(BrothersApplication.getApplicationInstance());
        this.c.setErrorType(2);
        this.c.setActionButtonListener(new b(this));
        if (viewGroup == null) {
            b();
        }
        a();
        return layoutInflater;
    }

    private void a(String str) {
        if (!this.j) {
            LoginHelper.a();
            if (l.c()) {
                if (TextUtils.isEmpty(str)) {
                    this.h = true;
                    this.i.c.clear();
                    this.i.d.clear();
                    this.a.setLoadingMoreEnabled(true);
                } else if (!this.h) {
                    return;
                }
                this.j = true;
                b bVar = this.e;
                e$e dVar = new d(this);
                if (TextUtils.isEmpty(str)) {
                    bVar.h.clear();
                    bVar.i.clear();
                }
                bVar.d.a(20, str, new z(bVar, dVar));
            }
        }
    }

    private void b() {
        this.c.setVisibility(0);
    }

    public void onDestroy() {
        this.f.unregisterReceiver(this.k);
        ab.a().b(this.l);
        super.onDetach();
    }

    private void a() {
        this.d.setVisibility(0);
        a("");
    }

    static /* synthetic */ void a(FollowFragment followFragment, List list) {
        if (list.size() > 0) {
            for (a aVar : list) {
                ab abVar = followFragment.i;
                abVar.a = 1;
                if ("rad".equals(aVar.c)) {
                    abVar.c.add(new ap(2, aVar));
                } else {
                    abVar.c.add(new ap(1, aVar));
                }
            }
        }
    }
}
