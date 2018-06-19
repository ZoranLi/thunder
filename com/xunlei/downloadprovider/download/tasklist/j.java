package com.xunlei.downloadprovider.download.tasklist;

import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.view.View;
import com.xunlei.downloadprovider.ad.downloadlist.b.a;
import com.xunlei.downloadprovider.download.privatespace.PrivateSpaceMgr;
import com.xunlei.downloadprovider.download.tasklist.list.c;
import com.xunlei.downloadprovider.download.tasklist.list.e;
import java.util.Iterator;

/* compiled from: TaskListPageFragment */
final class j extends AdapterDataObserver {
    final /* synthetic */ TaskListPageFragment a;

    j(TaskListPageFragment taskListPageFragment) {
        this.a = taskListPageFragment;
    }

    public final void onChanged() {
        super.onChanged();
        if (this.a.isVisible()) {
            TaskListPageFragment.p(this.a);
            if (this.a.v != null) {
                if (this.a.d == null) {
                    this.a.c.setVisibility(8);
                    this.a.v.setVisibility(0);
                    this.a.v.setErrorType(0);
                    this.a.v.a(null, null);
                } else if (this.a.d.getItemCount() == 0 && this.a.f.size() == 0) {
                    this.a.v.setVisibility(0);
                    this.a.v.setErrorType(0);
                    this.a.v.a(null, null);
                    this.a.c.setVisibility(8);
                } else if (!this.a.d.a.c) {
                    a a;
                    if (!this.a.d.b()) {
                        a = a.a();
                        if (a.k[this.a.b]) {
                            this.a.d.e();
                        }
                        a = a.a();
                        a.k[this.a.b] = false;
                    } else if (this.a.d.b()) {
                        int i;
                        int i2;
                        com.xunlei.downloadprovider.download.tasklist.list.a f;
                        View view;
                        a = a.a();
                        a.k[this.a.b] = true;
                        e eVar = this.a.d.a;
                        if (eVar.a != null) {
                            if (eVar.a.size() != 0) {
                                Iterator it = eVar.a.iterator();
                                i = 0;
                                while (it.hasNext()) {
                                    com.xunlei.downloadprovider.download.tasklist.list.a.e eVar2 = (com.xunlei.downloadprovider.download.tasklist.list.a.e) it.next();
                                    if (eVar2.a == 0 || eVar2.a == 200) {
                                        i++;
                                    }
                                }
                                a = a.a();
                                i2 = a.m[this.a.b];
                                if (!(i2 == 0 || i2 == i || i == 0)) {
                                    f = this.a.d;
                                    view = f.g.getView();
                                    if (view != null) {
                                        view.post(new c(f));
                                    }
                                }
                                a = a.a();
                                a.m[this.a.b] = i;
                            }
                        }
                        i = 0;
                        a = a.a();
                        i2 = a.m[this.a.b];
                        f = this.a.d;
                        view = f.g.getView();
                        if (view != null) {
                            view.post(new c(f));
                        }
                        a = a.a();
                        a.m[this.a.b] = i;
                    }
                    a = a.a();
                    a.l[this.a.b] = PrivateSpaceMgr.a().f();
                    this.a.c.setVisibility(0);
                    this.a.v.setVisibility(4);
                }
            }
        }
    }
}
