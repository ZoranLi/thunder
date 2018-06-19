package com.xunlei.downloadprovider.download.tasklist.list;

import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: TaskListAdapter */
public final class c implements Runnable {
    final /* synthetic */ a a;

    public c(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        Collection arrayList = new ArrayList();
        if (this.a.a.a != null) {
            int i = 0;
            while (i < this.a.a.a.size() - 1) {
                e eVar = (e) this.a.a.a.get(i);
                i++;
                e eVar2 = (e) this.a.a.a.get(i);
                if ((eVar.a == 101 || eVar.a == 100) && (eVar2.a == 101 || eVar2.a == 100)) {
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
