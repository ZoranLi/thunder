package com.xunlei.downloadprovider.download.tasklist;

import com.xunlei.downloadprovider.download.tasklist.TaskListPageFragment.LOAD_TAG;
import com.xunlei.downloadprovider.download.tasklist.list.a;
import com.xunlei.downloadprovider.download.tasklist.task.b.c;
import java.util.Collection;
import java.util.List;

/* compiled from: TaskListPageFragment */
final class e extends c {
    int a = null;
    final /* synthetic */ TaskListPageFragment b;
    private long c = 0;

    e(TaskListPageFragment taskListPageFragment) {
        this.b = taskListPageFragment;
    }

    public final void a() {
        if (this.b.isAdded()) {
            if (this.b.isResumed()) {
                this.b.f.remove(LOAD_TAG.LOAD_TASK);
                if (this.b.d != null) {
                    this.b.d.notifyDataSetChanged();
                    new StringBuilder("notifyDownloadTaskLoaded - PageIndex = ").append(this.b.b);
                    this.b.d.h();
                }
            }
        }
    }

    public final void b() {
        if (this.b.getUserVisibleHint()) {
            if (this.b.isResumed()) {
                this.b.f.remove(LOAD_TAG.LOAD_TASK);
                long nanoTime = System.nanoTime();
                long j = (nanoTime - this.c) / 1000000;
                if (this.c != 0) {
                    if (j <= 3000) {
                        this.c = nanoTime;
                        this.a++;
                        if (this.a <= 1) {
                            this.b.m.postDelayed(new f(this), com.xunlei.download.proguard.c.x);
                        }
                        if (this.b.e != null) {
                            this.b.e.a(this.b.b);
                        }
                        if (this.b.n > 0) {
                            this.b.m.post(new g(this));
                        }
                        return;
                    }
                }
                this.c = nanoTime;
                this.a = 0;
                if (this.b.d != null) {
                    this.b.d.notifyDataSetChanged();
                    new StringBuilder("notifyDataSetChanged - PageIndex = ").append(this.b.b);
                }
                if (this.b.e != null) {
                    this.b.e.a(this.b.b);
                }
                if (this.b.n > 0) {
                    this.b.m.post(new g(this));
                }
                return;
            }
        }
        this.b.y = this.b.y + 1;
    }

    public final void a(List<com.xunlei.downloadprovider.download.tasklist.list.a.e> list) {
        new StringBuilder("DataSource - onItemInserted: ").append(list);
        if (this.b.isAdded()) {
            if (this.b.isResumed()) {
                if (!(this.b.d == null || list == null)) {
                    this.b.d.a((List) list);
                }
                return;
            }
        }
        this.b.y = this.b.y + 1;
        this.b.F = true;
    }

    public final void a(Collection<com.xunlei.downloadprovider.download.tasklist.list.a.e> collection) {
        new StringBuilder("DataSource - onItemRemoved: ").append(collection);
        if (this.b.isAdded()) {
            if (this.b.isResumed()) {
                if (!(this.b.d == null || collection == null)) {
                    this.b.F = true;
                    a f = this.b.d;
                    com.xunlei.downloadprovider.download.tasklist.list.e eVar = f.a;
                    eVar.a.removeAll(collection);
                    eVar.b.removeAll(collection);
                    f.notifyDataSetChanged();
                }
                return;
            }
        }
        this.b.y = this.b.y + 1;
        this.b.F = true;
    }
}
