package com.xunlei.downloadprovider.publiser.per;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.liked.r;
import com.xunlei.downloadprovider.personal.liked.u;
import com.xunlei.downloadprovider.personal.liked.w;
import com.xunlei.downloadprovider.personal.message.data.q;
import com.xunlei.downloadprovider.player.a.a;
import com.xunlei.downloadprovider.publiser.common.g;
import com.xunlei.downloadprovider.publiser.common.o;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PersonalItemAdapter */
public final class bo extends Adapter<bq> {
    public final List<bp> a;
    public int b = 0;
    String c;
    String d;
    String e;
    private final g f;
    private a g;
    private RecyclerView h;
    private boolean i;
    private int j;

    public final /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        bq bqVar = (bq) viewHolder;
        bp bpVar = (this.a == null || this.a.size() <= i) ? null : (bp) this.a.get(i);
        bqVar.a(bpVar);
        viewHolder = bpVar.a;
        if (!this.i) {
            if (this.b == 2) {
                q.a(false, (bp) this.a.get(i));
            } else if (this.b == 1 && (viewHolder == 2 || viewHolder == 6 || viewHolder == 9)) {
                com.xunlei.downloadprovider.homepage.recommend.a.a(false, (com.xunlei.downloadprovider.publiser.per.model.g) ((bp) this.a.get(i)).b, this.c, this.e, o.a(this.d));
            }
        }
    }

    public bo(g gVar, a aVar, RecyclerView recyclerView) {
        this.h = recyclerView;
        this.a = new ArrayList(1);
        this.f = gVar;
        this.g = aVar;
    }

    public final int getItemCount() {
        if (this.a == null) {
            return 0;
        }
        return this.a.size();
    }

    public final int getItemViewType(int i) {
        if (i >= this.a.size()) {
            return -1;
        }
        return ((bp) this.a.get(i)).a;
    }

    public final void a(List<bp> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                int size = this.a.size();
                this.a.addAll(list);
                notifyItemRangeInserted(size, list.size());
                b();
            }
        }
    }

    public final void a(int i, List<bp> list) {
        if (list != null) {
            this.a.addAll(i, list);
            notifyItemRangeInserted(i, list.size());
            b();
        }
    }

    public final void a(bp bpVar) {
        if (bpVar != null) {
            this.a.add(0, bpVar);
            notifyItemInserted(0);
            b();
        }
    }

    public final bp a(int i) {
        return (i < 0 || this.a == null || i >= this.a.size()) ? 0 : (bp) this.a.get(i);
    }

    public final void b(bp bpVar) {
        if (!(this.a == null || this.a.size() == 0)) {
            if (bpVar != null) {
                int size = this.a.size() - 1;
                while (size >= 0) {
                    if (this.a.get(size) == bpVar) {
                        break;
                    }
                    size--;
                }
                size = -1;
                if (size >= 0) {
                    this.a.remove(size);
                    notifyItemRemoved(size);
                    b();
                }
            }
        }
    }

    private void b() {
        if (this.b != 0) {
            com.xunlei.downloadprovider.homepage.recommend.a.b();
        }
    }

    public final void a() {
        if (this.b != 0) {
            b(false);
        }
    }

    private void a(boolean z) {
        if (this.i && !z) {
            b(true);
        }
        this.i = z;
    }

    public final void b(int i) {
        if (this.b != 0) {
            if (this.j == 2 && this.j != i) {
                b(true);
            }
            this.j = i;
            switch (i) {
                case 0:
                case 1:
                    a((boolean) 0);
                    return;
                case 2:
                    a(true);
                    break;
                default:
                    break;
            }
        }
    }

    private void b(boolean z) {
        if (this.h != null) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.h.getLayoutManager();
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            int itemCount = getItemCount();
            while (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
                if (findFirstVisibleItemPosition >= 0 && findFirstVisibleItemPosition < itemCount) {
                    bp bpVar = (bp) this.a.get(findFirstVisibleItemPosition);
                    if (this.b == 2) {
                        q.a(z, bpVar);
                    } else if (bpVar.b != null && (bpVar.b instanceof com.xunlei.downloadprovider.publiser.per.model.g)) {
                        com.xunlei.downloadprovider.homepage.recommend.a.a(z, (com.xunlei.downloadprovider.publiser.per.model.g) bpVar.b, this.c, this.e, o.a(this.d));
                    }
                }
                findFirstVisibleItemPosition++;
            }
        }
    }

    public final /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 100) {
            return com.xunlei.downloadprovider.publiser.c.a.a(viewGroup.getContext());
        }
        switch (i) {
            case 0:
                return new a(viewGroup, this.f);
            case 1:
                viewGroup = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.common_pull_up_refresh_item, null);
                viewGroup.setLayoutParams(new LayoutParams(-1, -2));
                return new w(viewGroup);
            case 2:
                return new bc(new bs(viewGroup.getContext(), this.g), this.f, this);
            case 3:
                return new u(viewGroup, this.f);
            case 4:
                return new r(viewGroup, this.f);
            case 5:
                return new f(viewGroup, this.f);
            case 6:
                return new bh(viewGroup.getContext(), this.f, this);
            case 7:
                return new m(viewGroup, this.f);
            case 8:
                return new af(viewGroup);
            case 9:
                return new ai(viewGroup.getContext());
            case 10:
                return new h(viewGroup, this.f, this.d);
            case 11:
                return new ad(viewGroup, this.d);
            default:
                throw new IllegalArgumentException("Invalid view holder type!!!");
        }
    }
}
