package com.xunlei.downloadprovider.publiser.campaign;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.player.a.a;
import com.xunlei.downloadprovider.player.xmp.PlayerTag;
import com.xunlei.downloadprovider.player.xmp.ak;
import com.xunlei.downloadprovider.publiser.campaign.a.m;
import com.xunlei.downloadprovider.publiser.campaign.a.n;
import com.xunlei.downloadprovider.search.ui.a.b;
import com.xunlei.downloadprovider.search.ui.a.d;
import com.xunlei.downloadprovider.search.ui.a.f;

/* compiled from: TopicAdapter */
public final class g extends b<n> {
    private int d;
    private int e;
    private String f;
    private RecyclerView g;
    private a h;
    private boolean i = true;

    public g(int i, f.a aVar, int i2, String str, RecyclerView recyclerView, a aVar2, boolean z) {
        super(aVar, z);
        this.d = i;
        this.e = i2;
        this.f = str;
        this.g = recyclerView;
        this.h = aVar2;
    }

    protected final int a(int i) {
        super.a(i);
        n nVar = (n) c(i);
        if (nVar == null) {
            return -1;
        }
        return nVar.a;
    }

    protected final d a(ViewGroup viewGroup, int i) {
        if (i != -1) {
            return new s(this.d, this.e, this.f, new h(this, viewGroup.getContext(), this.h));
        }
        viewGroup = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.common_pull_up_refresh_item, null);
        viewGroup.setLayoutParams(new LayoutParams(-1, -2));
        return new com.xunlei.downloadprovider.search.ui.a.g(viewGroup);
    }

    protected final void a(int i, boolean z) {
        super.a(i, z);
        n nVar = (n) c(i);
        if (nVar != null && nVar.a == 0) {
            m.a(this.d, z, nVar, d());
        }
    }

    public final void a(boolean z) {
        super.a(z);
        this.i = true;
        if (!z) {
            b(false);
        }
    }

    public final void a() {
        super.a();
        if (this.i) {
            ak.a().c(PlayerTag.TOPIC_COLLECT);
        }
        m.a(this.d, d());
        m.a(this.d);
    }

    protected final void b() {
        b(true);
    }

    private void b(boolean z) {
        if (this.g != null) {
            int findFirstVisibleItemPosition = ((LinearLayoutManager) this.g.getLayoutManager()).findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = ((LinearLayoutManager) this.g.getLayoutManager()).findLastVisibleItemPosition();
            int itemCount = getItemCount();
            while (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
                if (findFirstVisibleItemPosition >= 0 && findFirstVisibleItemPosition < itemCount) {
                    m.a(this.d, z, (n) c(findFirstVisibleItemPosition), d());
                }
                findFirstVisibleItemPosition++;
            }
        }
    }

    private String d() {
        switch (this.e) {
            case 1:
                return "hot";
            case 2:
                return "new";
            default:
                return "new";
        }
    }
}
