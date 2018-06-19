package com.xunlei.downloadprovider.download.tasklist;

import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.download.b.b;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import com.xunlei.downloadprovider.download.tasklist.list.feed.e.a;
import java.util.List;

/* compiled from: TaskListPageFragment */
final class c implements a<List<e>> {
    final /* synthetic */ TaskListPageFragment a;

    c(TaskListPageFragment taskListPageFragment) {
        this.a = taskListPageFragment;
    }

    public final /* synthetic */ void a(Object obj) {
        List list = (List) obj;
        if (this.a.c != null) {
            this.a.c.a();
        }
        if (!this.a.x) {
            this.a.B = false;
            if (!f.a(this.a.getActivity())) {
                if (b.c() || !d.a().d.l()) {
                    this.a.z = this.a.z + 1;
                } else {
                    com.xunlei.downloadprovider.download.tasklist.list.feed.d a = com.xunlei.downloadprovider.download.tasklist.list.feed.d.a();
                    int i = this.a.b;
                    a.a.put(Integer.valueOf(i), Integer.valueOf((a.a.get(Integer.valueOf(i)) != null ? ((Integer) a.a.get(Integer.valueOf(i))).intValue() : 1) + 1));
                    a.b();
                }
                TaskListPageFragment.a(this.a, list);
            }
        }
    }

    public final void a(int i, String str) {
        if (f.a(this.a.getActivity()) == 0) {
            this.a.B = false;
            if (this.a.c != 0) {
                this.a.c.a();
            }
        }
    }
}
