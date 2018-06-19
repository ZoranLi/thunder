package com.xunlei.downloadprovider.publiser.campaign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.xunlei.downloadprovider.homepage.recommend.fans.BaseExposureRecyViewFragment;
import com.xunlei.downloadprovider.player.a.a;
import com.xunlei.downloadprovider.publiser.campaign.a.c;
import com.xunlei.downloadprovider.publiser.campaign.a.e;
import com.xunlei.downloadprovider.publiser.campaign.a.n;
import com.xunlei.downloadprovider.search.ui.a.b;
import java.util.List;

public class TopicNewFragment extends BaseExposureRecyViewFragment<n> implements c {
    private static final String l = "TopicNewFragment";
    m k;
    private int m;
    private String n;
    private String o;
    private n p;
    private e q;

    protected final int f() {
        return 8;
    }

    protected final int g() {
        return 8;
    }

    public static TopicNewFragment a(int i, String str) {
        TopicNewFragment topicNewFragment = new TopicNewFragment();
        Bundle bundle = new Bundle(1);
        bundle.putInt("type", i);
        bundle.putString("campaign_new_tag", str);
        topicNewFragment.setArguments(bundle);
        return topicNewFragment;
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
        h();
    }

    protected final void h() {
        super.h();
        b();
        StringBuilder stringBuilder = new StringBuilder("loadFirstData mTag=");
        stringBuilder.append(this.n);
        stringBuilder.append(",pageSize=8,mCursor=");
        stringBuilder.append(this.o);
        this.q.b(this.m, this.o, this.n, true, this, this.k);
    }

    protected final void i() {
        super.i();
        StringBuilder stringBuilder = new StringBuilder("loadNextPageData mTag=");
        stringBuilder.append(this.n);
        stringBuilder.append(",pageSize=8,mCursor=");
        stringBuilder.append(this.o);
        this.q.b(this.m, this.o, this.n, false, this, this.k);
    }

    protected final b<n> j() {
        return new g(this.m, this, 2, this.n, this.c, this.e, this.b);
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
