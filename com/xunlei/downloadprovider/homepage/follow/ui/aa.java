package com.xunlei.downloadprovider.homepage.follow.ui;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.homepage.follow.ad;
import com.xunlei.downloadprovider.homepage.follow.b;
import com.xunlei.downloadprovider.homepage.follow.b.d;
import com.xunlei.downloadprovider.homepage.follow.b.e;
import com.xunlei.downloadprovider.homepage.follow.ui.view.ViewHolder.From;
import com.xunlei.downloadprovider.homepage.follow.ui.view.ag;
import com.xunlei.downloadprovider.homepage.follow.ui.view.al;
import com.xunlei.downloadprovider.homepage.follow.ui.view.an;
import com.xunlei.downloadprovider.homepage.follow.ui.view.ap;
import com.xunlei.downloadprovider.homepage.follow.ui.view.i;
import com.xunlei.downloadprovider.homepage.follow.ui.view.j;
import com.xunlei.downloadprovider.homepage.follow.ui.view.o;
import com.xunlei.downloadprovider.homepage.follow.ui.view.q;
import com.xunlei.downloadprovider.homepage.follow.ui.view.s;
import com.xunlei.downloadprovider.player.a.a;
import com.xunlei.downloadprovider.player.xmp.PlayerTag;
import com.xunlei.downloadprovider.player.xmp.ak;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: FollowTabListAdapter */
public final class aa extends a {
    public boolean a = true;
    private Context b;
    private LayoutInflater c;
    private RecyclerView d;
    private List<ap> e;
    private final af f;
    private a g;

    public final /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        ((com.xunlei.downloadprovider.homepage.follow.ui.view.ViewHolder) viewHolder).a(b(i));
    }

    public aa(Context context, RecyclerView recyclerView, af afVar, a aVar) {
        this.b = context;
        this.c = LayoutInflater.from(context);
        this.d = recyclerView;
        this.e = new ArrayList();
        this.f = afVar;
        this.g = aVar;
    }

    public final int getItemCount() {
        return this.e.size();
    }

    public final int getItemViewType(int i) {
        super.getItemViewType(i);
        return ((ap) this.e.get(i)).a;
    }

    private ap b(int i) {
        return (ap) this.e.get(i);
    }

    public final void c() {
        e();
        super.notifyDataSetChanged();
    }

    public final void d() {
        e();
        super.notifyItemChanged(1);
    }

    public final void e() {
        af afVar = this.f;
        afVar.d.clear();
        new StringBuilder("getFollowTabViewDataList() state=").append(afVar.a);
        boolean z = false;
        switch (afVar.a) {
            case 1:
                afVar.b.a = null;
                afVar.c = null;
                afVar.g.clear();
                afVar.d.add(afVar.f);
                afVar.d.addAll(afVar.i);
                break;
            case 2:
                afVar.b.a = null;
                afVar.d.addAll(afVar.i);
                break;
            case 3:
                afVar.b.a = Collections.unmodifiableList(b.a().h);
                afVar.b.b = afVar.b();
                afVar.d.add(afVar.e);
                afVar.d.addAll(afVar.c());
                afVar.d.addAll(afVar.i);
                break;
            case 4:
                afVar.b.a = Collections.unmodifiableList(b.a().h);
                afVar.b.b = false;
                afVar.d.add(afVar.e);
                afVar.d.addAll(afVar.c());
                afVar.d.addAll(afVar.g);
                break;
            case 5:
                afVar.b.a = Collections.unmodifiableList(b.a().h);
                afVar.b.b = false;
                afVar.d.add(afVar.e);
                afVar.d.addAll(afVar.c());
                afVar.d.addAll(afVar.g);
                afVar.d.add(afVar.h);
                break;
            case 6:
                afVar.b.a = Collections.unmodifiableList(b.a().h);
                e eVar = afVar.b;
                if (afVar.b() && afVar.d()) {
                    z = true;
                }
                eVar.b = z;
                afVar.d.add(afVar.e);
                afVar.d.addAll(afVar.c());
                if (!afVar.g.isEmpty()) {
                    afVar.d.addAll(afVar.g);
                    break;
                } else {
                    afVar.d.addAll(afVar.i);
                    break;
                }
            default:
                break;
        }
        this.e = afVar.d;
    }

    protected final void a(int i, boolean z) {
        if (b(i).a == 5) {
            StringBuilder stringBuilder = new StringBuilder("tryReportItemExposure() position=");
            stringBuilder.append(i);
            stringBuilder.append(" shouldDistinct=");
            stringBuilder.append(z);
            ad.a(z, (d) b(i).b);
        }
    }

    public final void a(boolean z) {
        super.a(z);
        this.a = true;
        if (!z) {
            b(false);
        }
    }

    public final void b() {
        super.b();
        ad.b();
        ad.a();
        if (this.a) {
            ak.a().c(PlayerTag.FOLLOW_TAB);
        }
    }

    protected final void a() {
        b(true);
    }

    private void b(boolean z) {
        if (this.d != null) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.d.getLayoutManager();
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition() - 1;
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition() - 1;
            int itemCount = getItemCount();
            while (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
                if (findFirstVisibleItemPosition >= 0 && findFirstVisibleItemPosition < itemCount) {
                    a(findFirstVisibleItemPosition, z);
                }
                findFirstVisibleItemPosition++;
            }
        }
    }

    public final /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        switch (i) {
            case 1:
                return new o(this.c, viewGroup);
            case 2:
                return new q(this.c, viewGroup);
            case 3:
                return new com.xunlei.downloadprovider.homepage.follow.ui.view.e(this.c, viewGroup, From.LIVE);
            case 4:
                return new com.xunlei.downloadprovider.homepage.follow.ui.view.a(this.c, viewGroup, this);
            case 5:
                return new i(this.b, this.g, this);
            case 6:
                return new j(viewGroup);
            case 7:
                return new al(this.c, viewGroup);
            case 8:
                return new an(this.c, viewGroup);
            case 9:
                return new ag(viewGroup.getContext(), From.REC_FOLLOW);
            case 11:
                return new s(this.c, viewGroup);
            default:
                return null;
        }
    }
}
