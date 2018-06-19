package com.xunlei.downloadprovider.download.tasklist.list;

import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: TaskListAdapter */
final class b implements Runnable {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        Collection arrayList = new ArrayList();
        if (this.a.a.a != null) {
            Iterator it = this.a.a.a.iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                if (eVar.a == 101 || eVar.a == 100) {
                    arrayList.add(eVar);
                }
            }
            if (arrayList.size() != 0) {
                this.a.a.a.removeAll(arrayList);
                this.a.notifyDataSetChanged();
            }
        }
    }
}
