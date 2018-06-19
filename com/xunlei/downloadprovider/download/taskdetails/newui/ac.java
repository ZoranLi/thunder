package com.xunlei.downloadprovider.download.taskdetails.newui;

import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.download.taskdetails.subtask.b.a;
import java.util.Collection;
import java.util.List;

/* compiled from: DownloadDetailsActivityFragment */
final class ac implements a {
    final /* synthetic */ DownloadDetailsActivityFragment a;

    ac(DownloadDetailsActivityFragment downloadDetailsActivityFragment) {
        this.a = downloadDetailsActivityFragment;
    }

    public final void a(List<com.xunlei.downloadprovider.download.taskdetails.items.a.a> list, boolean z) {
        DownloadDetailsActivityFragment.q;
        StringBuilder stringBuilder = new StringBuilder("onBTTaskListLoaded, sizeChange : ");
        stringBuilder.append(z);
        stringBuilder.append("items.size() = ");
        stringBuilder.append(list.size());
        this.a.d.a(list);
        b B = this.a.u;
        Collection collection = this.a.e.e;
        a aVar = B.b;
        aVar.l.clear();
        if (list != null) {
            aVar.l.addAll(list);
        }
        list = B.b;
        list.m.clear();
        if (collection != null) {
            list.m.addAll(collection);
        }
        if (this.a.u.e == null && this.a.p != null && this.a.p.b() >= null && this.a.C != null) {
            this.a.C = false;
            this.a.d.b(this.a.p.b());
        }
        this.a.u.e = true;
        this.a.b(true, true);
        if (z || this.a.G != null) {
            this.a.G = false;
            DownloadDetailsActivityFragment.q;
            XLThreadPool.execute(new ad(this));
        }
    }

    public final void a() {
        DownloadDetailsActivityFragment.q;
        if (this.a.g != null) {
            this.a.g.i();
        }
    }

    public final void b() {
        DownloadDetailsActivityFragment.q;
        this.a.d();
    }
}
