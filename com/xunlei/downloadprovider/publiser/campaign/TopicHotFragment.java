package com.xunlei.downloadprovider.publiser.campaign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.homepage.recommend.fans.BaseExposureRecyViewFragment;
import com.xunlei.downloadprovider.player.a.a;
import com.xunlei.downloadprovider.publiser.campaign.a.c;
import com.xunlei.downloadprovider.publiser.campaign.a.e;
import com.xunlei.downloadprovider.publiser.campaign.a.j;
import com.xunlei.downloadprovider.publiser.campaign.a.n;
import com.xunlei.downloadprovider.search.ui.a.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TopicHotFragment extends BaseExposureRecyViewFragment<n> implements c {
    private static final String l = "TopicHotFragment";
    m k;
    private int m;
    private String n;
    private String o;
    private n p;
    private e q;
    private Set<String> r = new HashSet();

    public final int f() {
        return 8;
    }

    protected final int g() {
        return 8;
    }

    public static TopicHotFragment a(int i, String str) {
        TopicHotFragment topicHotFragment = new TopicHotFragment();
        Bundle bundle = new Bundle(1);
        bundle.putInt("type", i);
        bundle.putString("campaign_new_tag", str);
        topicHotFragment.setArguments(bundle);
        return topicHotFragment;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.m = bundle.getInt("type");
            this.n = bundle.getString("campaign_new_tag");
        }
        TextUtils.isEmpty(this.n);
        this.p = new n();
        this.p.a = -1;
        this.q = new e();
        this.e = new a(getContext());
    }

    protected final void a() {
        super.a();
        b();
        if (this.m == 1) {
            XLThreadPool.execute(new j(this.q, this.n, new n(this)));
        } else {
            h();
        }
    }

    protected final void h() {
        super.h();
        StringBuilder stringBuilder = new StringBuilder("loadFirstData---------------------------------=mTag=");
        stringBuilder.append(this.n);
        stringBuilder.append(",pageSize=8,mCursor=");
        stringBuilder.append(this.o);
        this.q.a(this.m, this.o, this.n, true, this, this.k);
    }

    protected final void i() {
        super.i();
        StringBuilder stringBuilder = new StringBuilder("loadNextPageData---------------------------------=mTag=");
        stringBuilder.append(this.n);
        stringBuilder.append(",pageSize=8,mCursor=");
        stringBuilder.append(this.o);
        this.q.a(this.m, this.o, this.n, false, this, this.k);
    }

    protected final b<n> j() {
        return new g(this.m, this, 1, this.n, this.c, this.e, this.b);
    }

    protected final void d() {
        super.d();
        if (this.p != null) {
            a((Object) this.p);
        }
    }

    protected final void e() {
        if (this.p != null) {
            b((Object) this.p);
        }
    }

    public final void b(boolean z) {
        super.b(z);
        if (this.d) {
            this.d.a(false);
        }
    }

    public final void a(boolean z) {
        super.a(z);
        if (this.d) {
            this.d.a();
        }
    }

    public final void a(com.xunlei.downloadprovider.publiser.campaign.a.b bVar) {
        if (!this.i) {
            if (bVar != null) {
                this.o = bVar.c;
                c(bVar.b);
                if (!this.r.isEmpty()) {
                    Iterator it = bVar.d.iterator();
                    while (it.hasNext()) {
                        n nVar = (n) it.next();
                        if (this.r.contains(nVar.b.getGcid())) {
                            it.remove();
                            this.r.remove(nVar.b.getGcid());
                        }
                    }
                }
                a((List) bVar.d);
            }
        }
    }

    public final void k() {
        if (!this.i) {
            c();
        }
    }
}
