package com.xunlei.downloadprovider.download.taskdetails.newui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.ad.taskdetailnew.banner.TaskDetailNewBannerAdController;
import com.xunlei.downloadprovider.download.taskdetails.ag;
import com.xunlei.downloadprovider.download.taskdetails.items.a.b;
import com.xunlei.downloadprovider.download.taskdetails.newui.itemview.e;
import com.xunlei.downloadprovider.download.taskdetails.newui.itemview.g;
import com.xunlei.downloadprovider.download.taskdetails.newui.itemview.m;
import com.xunlei.downloadprovider.download.taskdetails.newui.itemview.n;
import com.xunlei.downloadprovider.download.taskdetails.newui.itemview.q;
import com.xunlei.downloadprovider.download.taskdetails.subtask.BTSubTaskItem;
import com.xunlei.downloadprovider.download.taskdetails.widget.h;
import java.util.Collections;
import java.util.List;

/* compiled from: DetailsAdapter */
public class a extends ag {
    private static final String u = "a";
    public c m;
    LinearLayoutManager n;
    int o = -1;
    @Nullable
    h p;
    boolean q = true;
    boolean r = false;
    int s = -1;
    TaskDetailNewBannerAdController t = null;
    private com.xunlei.downloadprovider.download.taskdetails.items.a.a v = new com.xunlei.downloadprovider.download.taskdetails.items.a.a(12, null, Boolean.valueOf(false), -1);
    private com.xunlei.downloadprovider.download.taskdetails.items.a.a w = new com.xunlei.downloadprovider.download.taskdetails.items.a.a(12, null, Boolean.valueOf(true), -1);
    private q x;

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        a((b) viewHolder, i);
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return a(viewGroup, i);
    }

    public a(Context context) {
        super(context);
    }

    public final b a(ViewGroup viewGroup, int i) {
        b gVar;
        if (11 == i) {
            gVar = new g(g.a(this.b, viewGroup));
            gVar.a = this.a;
        } else if (i == 12) {
            gVar = new e(e.a(this.b, viewGroup));
        } else if (14 == i) {
            this.x = new q(q.a(this.b));
            q qVar = this.x;
            com.xunlei.downloadprovider.download.taskdetails.ag.a aVar = this.a;
            if (qVar.a != null) {
                qVar.a.setRefreshListener(aVar);
            }
            gVar = this.x;
        } else {
            gVar = 15 == i ? new n(n.a(this.b, viewGroup)) : 16 == i ? new com.xunlei.downloadprovider.download.taskdetails.newui.itemview.b(com.xunlei.downloadprovider.download.taskdetails.newui.itemview.b.a(this.b, viewGroup), this.t) : 17 == i ? new m(m.a(this.b, viewGroup)) : null;
        }
        if (gVar == null) {
            gVar = super.a(viewGroup, i);
        }
        if (gVar != null) {
            gVar.g = this.c;
            gVar.a(this.e);
            gVar.a((ag) this);
        }
        return gVar;
    }

    public final void a(b bVar, int i) {
        if (bVar != null) {
            new StringBuilder("onBindViewHolder ").append(bVar.getClass().getSimpleName());
        }
        super.a(bVar, i);
        if ((bVar instanceof q) != 0) {
            q qVar = (q) bVar;
            boolean z = true;
            if (qVar.a != null) {
                z = qVar.a.getIsInCollapedState();
            }
            if (z != this.l) {
                new StringBuilder("onBindViewHolder, mIsTaskDetailCollaped : ").append(this.l);
                i = this.l;
                if (qVar.a != null) {
                    qVar.a.setNeedFold(i);
                    qVar.a.setCollaped(i);
                }
            }
        }
    }

    public final b c() {
        return this.x;
    }

    public final void g() {
        if (this.n != null) {
            this.n.scrollToPosition(this.f.a.size());
        }
    }

    public final void b(int i) {
        if (i >= 0) {
            if (this.n != null) {
                Object obj = null;
                List<com.xunlei.downloadprovider.download.taskdetails.items.a.a> list = this.f.c;
                if (!list.isEmpty()) {
                    for (com.xunlei.downloadprovider.download.taskdetails.items.a.a aVar : list) {
                        BTSubTaskItem bTSubTaskItem = (BTSubTaskItem) aVar.a(BTSubTaskItem.class);
                        if (bTSubTaskItem != null && bTSubTaskItem.mBTSubIndex == i) {
                            obj = aVar;
                            break;
                        }
                    }
                }
                if (obj != null) {
                    i = this.f.c.indexOf(obj);
                    if (i >= 0 && i >= 2) {
                        c(1);
                    }
                }
            }
        }
    }

    public final void c(boolean z) {
        this.f.e = z;
        this.q = z;
        if (this.p != null) {
            this.p.a(z);
        }
        notifyDataSetChanged();
    }

    public final void a(List<com.xunlei.downloadprovider.download.taskdetails.items.a.a> list) {
        new StringBuilder("replaceBtSubFileItems items.size() = ").append(list.size());
        this.f.b();
        this.f.c(list);
        boolean z = false;
        if (this.r) {
            if (list.size() > 2) {
                this.f.b(list.subList(0, 2));
                this.f.b(Collections.singletonList(this.v));
                this.f.e = this.q;
                this.f.c(Collections.singletonList(this.w));
                if (this.p != null) {
                    this.p.a(this.q);
                    h hVar = this.p;
                    if (list.size() > 8) {
                        z = true;
                    }
                    hVar.b(z);
                }
            } else {
                this.f.b(list);
                this.f.e = true;
                this.q = true;
                if (this.p != null) {
                    this.p.b(false);
                }
            }
            notifyDataSetChanged();
            h();
            return;
        }
        this.f.b(list);
        this.f.e = false;
        notifyDataSetChanged();
    }

    public final void b(boolean z) {
        boolean z2 = this.g;
        this.g = z;
        this.f.f = z;
        if (z2 != z) {
            if (z && this.n != null) {
                this.o = this.n.findFirstVisibleItemPosition();
            }
            notifyDataSetChanged();
            if (this.m != null) {
                this.m.a(z);
            }
        }
    }

    public final void h() {
        if (!this.g) {
            if (this.f.e) {
                if (this.n != null) {
                    int findLastVisibleItemPosition = this.n.findLastVisibleItemPosition();
                    if (findLastVisibleItemPosition != -1) {
                        int size = this.f.a.size() + 8;
                        if (findLastVisibleItemPosition + 1 >= this.f.a.size() + this.f.c.size() || findLastVisibleItemPosition < size) {
                            if (this.p != null) {
                                this.p.a(8);
                            }
                        } else if (this.p != null) {
                            this.p.a(0);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
        }
        if (this.p != null) {
            this.p.a(8);
        }
    }
}
