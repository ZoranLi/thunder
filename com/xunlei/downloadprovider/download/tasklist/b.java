package com.xunlei.downloadprovider.download.tasklist;

import com.xunlei.downloadprovider.download.privatespace.PrivateSpaceMgr;
import com.xunlei.downloadprovider.download.tasklist.list.a;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import com.xunlei.xllib.b.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: TaskListPageFragment */
final class b extends com.xunlei.downloadprovider.download.privatespace.PrivateSpaceMgr.b {
    final /* synthetic */ TaskListPageFragment a;

    b(TaskListPageFragment taskListPageFragment) {
        this.a = taskListPageFragment;
    }

    public final void a(long j) {
        int i;
        a f = this.a.d;
        int a = f.a(j);
        if (a != -1 && a >= 0 && a < f.getItemCount() && !PrivateSpaceMgr.a().f()) {
            e a2 = f.a(a);
            a2.b().setCustomFlags(300);
            i = 0;
            while (i < a) {
                e a3 = f.a(i);
                if (a3.b() != null) {
                    if (a3.b().getCustomFlags() == 300) {
                        if (a2.b().mCreateTime >= a3.b().mCreateTime) {
                            f.a(a, i);
                            break;
                        }
                        i++;
                    }
                }
                f.a(a, i);
                break;
            }
        }
        i = -1;
        if (i != -1) {
            this.a.c.getLayoutManager().scrollToPosition(i);
        }
    }

    public final void a(long j, boolean z) {
        int itemCount;
        a f = this.a.d;
        int a = f.a(j);
        if (a != -1 && a >= 0 && a < f.getItemCount() && !PrivateSpaceMgr.a().f()) {
            e a2 = f.a(a);
            a2.b().setCustomFlags(0);
            itemCount = f.getItemCount();
            if (!z) {
                itemCount--;
                while (itemCount > a) {
                    z = f.a(itemCount);
                    if (z.b() != null) {
                        if (z.b().getCustomFlags() == 300) {
                            f.a(a, itemCount);
                            break;
                        } else if (a2.b().mCreateTime <= z.b().mCreateTime) {
                            f.a(a, itemCount);
                            break;
                        }
                    }
                    itemCount--;
                }
            }
        }
        itemCount = -1;
        if (itemCount != -1) {
            this.a.c.getLayoutManager().scrollToPosition(itemCount);
        }
    }

    public final void a() {
        if (PrivateSpaceMgr.a().f() && PrivateSpaceMgr.a().a.size() > 0) {
            a f = this.a.d;
            Collection arrayList = new ArrayList();
            Iterator it = f.a.a.iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                if (eVar.b() != null && PrivateSpaceMgr.a().a(eVar.b())) {
                    arrayList.add(eVar);
                }
            }
            if (!d.a(arrayList)) {
                f.a.a.removeAll(arrayList);
                f.notifyDataSetChanged();
            }
        }
    }

    public final void b() {
        a f = this.a.d;
        int itemCount = f.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            e a = f.a(i);
            if (a.b() != null && a.b().getCustomFlags() == 300) {
                a.b().setCustomFlags(0);
            }
        }
        com.xunlei.downloadprovider.download.tasklist.task.b.a(f.a.a);
        f.notifyDataSetChanged();
    }
}
