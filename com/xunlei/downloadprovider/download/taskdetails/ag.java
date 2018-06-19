package com.xunlei.downloadprovider.download.taskdetails;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.download.player.a.m;
import com.xunlei.downloadprovider.download.taskdetails.a.c;
import com.xunlei.downloadprovider.download.taskdetails.items.a.b;
import com.xunlei.downloadprovider.download.taskdetails.items.h;
import com.xunlei.downloadprovider.download.taskdetails.items.i;
import com.xunlei.downloadprovider.download.taskdetails.items.p;
import com.xunlei.downloadprovider.download.taskdetails.items.q;
import com.xunlei.downloadprovider.download.taskdetails.items.x;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import java.util.Collection;
import java.util.List;

/* compiled from: TaskDetailAdapter */
public class ag extends Adapter<b> {
    private static final String m = "ag";
    protected a a;
    protected Context b;
    protected com.xunlei.downloadprovider.download.control.a c;
    com.xunlei.downloadprovider.ad.taskdetail.a d = null;
    protected m e = null;
    protected c<com.xunlei.downloadprovider.download.taskdetails.items.a.a> f = new c();
    public boolean g = false;
    public com.xunlei.downloadprovider.download.taskdetails.b.a h;
    public q i;
    public boolean j;
    public String k;
    protected boolean l = true;
    private p n;

    /* compiled from: TaskDetailAdapter */
    public interface a extends a {
        void a(DownloadTaskInfo downloadTaskInfo);

        void a(boolean z);

        void c();

        void d();
    }

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        a((b) viewHolder, i);
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return a(viewGroup, i);
    }

    public ag(Context context) {
        this.b = context;
        this.h = new com.xunlei.downloadprovider.download.taskdetails.b.a(context, this);
    }

    public final com.xunlei.downloadprovider.download.control.a a() {
        return this.c;
    }

    public final void a(boolean z) {
        this.l = z;
    }

    public final void a(com.xunlei.downloadprovider.download.control.a aVar) {
        this.c = aVar;
    }

    public final void a(m mVar) {
        this.e = mVar;
    }

    public final a b() {
        return this.a;
    }

    public final void a(a aVar) {
        this.a = aVar;
    }

    public b a(ViewGroup viewGroup, int i) {
        b bVar = null;
        if (1 == i) {
            this.n = new p(p.a(this.b));
            viewGroup = this.n;
            i = this.a;
            if (viewGroup.a != null) {
                viewGroup.a.setRefreshListener(i);
            }
            bVar = this.n;
        } else if (3 == i) {
            bVar = new i(i.a(this.b));
            bVar.a(this);
        } else if (4 == i) {
            bVar = new com.xunlei.downloadprovider.download.taskdetails.items.m(com.xunlei.downloadprovider.download.taskdetails.items.m.a(this.b, viewGroup));
        } else if (5 == i) {
            this.i = new q(q.a(this.b));
            bVar = this.i;
        } else if (i == 0) {
            bVar = new com.xunlei.downloadprovider.download.taskdetails.items.b(com.xunlei.downloadprovider.download.taskdetails.items.b.a(this.b, viewGroup));
            bVar.b = this.a;
        } else if (7 == i) {
            bVar = new h(h.a(this.b, viewGroup));
        } else {
            if (!(8 == i || 9 == i)) {
                if (10 != i) {
                    if (i >= 110) {
                        bVar = new x(this.h.a.a(viewGroup, i - 110));
                    }
                }
            }
            viewGroup = com.xunlei.downloadprovider.download.taskdetails.items.a.a(this.b, i, this.d);
            if (viewGroup != null) {
                bVar = new com.xunlei.downloadprovider.download.taskdetails.items.a(viewGroup);
                bVar.a = this.d;
            }
        }
        if (bVar != null) {
            bVar.g = this.c;
            bVar.a(this.e);
            bVar.a(this);
        }
        return bVar;
    }

    public b c() {
        return this.n;
    }

    public void a(b bVar, int i) {
        com.xunlei.downloadprovider.download.taskdetails.items.a.a aVar;
        if (bVar != null) {
            new StringBuilder("onBindViewHolder ").append(bVar.getClass().getSimpleName());
        }
        int a = this.f.a();
        if (i < a) {
            aVar = (com.xunlei.downloadprovider.download.taskdetails.items.a.a) this.f.a(i);
        } else {
            aVar = (com.xunlei.downloadprovider.download.taskdetails.items.a.a) this.h.b.get(i - a);
        }
        bVar.g = this.c;
        bVar.a(aVar);
        if ((bVar instanceof p) != 0) {
            p pVar = (p) bVar;
            boolean z = true;
            if (pVar.a != null) {
                z = pVar.a.getIsInCollapedState();
            }
            if (z != this.l) {
                new StringBuilder("onBindViewHolder, mIsTaskDetailCollaped : ").append(this.l);
                i = this.l;
                if (pVar.a != null) {
                    pVar.a.setNeedFold(i);
                    pVar.a.setCollaped(i);
                }
            }
        }
    }

    public int getItemViewType(int i) {
        return a(i).a;
    }

    public final int d() {
        return this.f.a();
    }

    public final void a(List<com.xunlei.downloadprovider.download.taskdetails.items.a.a> list, List<com.xunlei.downloadprovider.download.taskdetails.items.a.a> list2) {
        c cVar = this.f;
        cVar.a.clear();
        cVar.b.clear();
        cVar.c.clear();
        cVar.d.clear();
        this.f.a((Collection) list);
        this.f.d(list2);
        notifyDataSetChanged();
    }

    public final void b(List<com.xunlei.downloadprovider.download.taskdetails.items.a.a> list, List<com.xunlei.downloadprovider.download.taskdetails.items.a.a> list2) {
        this.f.a.clear();
        this.f.d.clear();
        this.f.a((Collection) list);
        this.f.d(list2);
        notifyDataSetChanged();
    }

    public final void e() {
        this.f.a.clear();
        this.f.d.clear();
        notifyDataSetChanged();
    }

    public final void a(com.xunlei.downloadprovider.download.taskdetails.items.a.a aVar) {
        if (this.f != null) {
            c cVar = this.f;
            if (aVar != null) {
                if (cVar.a.contains(aVar)) {
                    cVar.a.remove(aVar);
                } else if (cVar.b.contains(aVar)) {
                    cVar.b.remove(aVar);
                } else if (cVar.d.contains(aVar)) {
                    cVar.d.remove(aVar);
                }
            }
        }
        notifyDataSetChanged();
    }

    public void a(List<com.xunlei.downloadprovider.download.taskdetails.items.a.a> list) {
        this.f.b();
        this.f.b(list);
        this.f.c(list);
        this.f.e = false;
        notifyDataSetChanged();
    }

    public final void f() {
        if (this.f != null) {
            notifyItemRangeChanged(0, this.f.a());
        }
    }

    public final com.xunlei.downloadprovider.download.taskdetails.items.a.a a(int i) {
        int a = this.f.a();
        if (i < a) {
            return (com.xunlei.downloadprovider.download.taskdetails.items.a.a) this.f.a(i);
        }
        return (com.xunlei.downloadprovider.download.taskdetails.items.a.a) this.h.b.get(i - a);
    }

    public long getItemId(int i) {
        if (i >= this.f.a()) {
            return (long) i;
        }
        if (this.f.a(i) == null) {
            return (long) i;
        }
        com.xunlei.downloadprovider.download.taskdetails.items.a.a aVar = (com.xunlei.downloadprovider.download.taskdetails.items.a.a) this.f.a(i);
        long j = aVar.b;
        if (j != -1) {
            if (j <= 2147483647L) {
                return (((long) aVar.a) << 32) | (j & 2147483647L);
            }
        }
        return -1;
    }

    public int getItemCount() {
        if (this.g) {
            return this.f.a();
        }
        return this.f.a() + this.h.a();
    }
}
