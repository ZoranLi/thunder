package com.xunlei.downloadprovider.download.tasklist.list;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TaskListItemArray */
public final class e {
    public ArrayList<com.xunlei.downloadprovider.download.tasklist.list.a.e> a = new ArrayList();
    public ArrayList<com.xunlei.downloadprovider.download.tasklist.list.a.e> b = new ArrayList();
    public boolean c;
    ArrayList<com.xunlei.downloadprovider.download.tasklist.list.a.e> d = new ArrayList();
    com.xunlei.downloadprovider.download.tasklist.list.a.e e = new com.xunlei.downloadprovider.download.tasklist.list.a.e(3);

    e() {
    }

    public final int a() {
        return this.a.size() + (this.c ? 0 : this.b.size());
    }

    public final com.xunlei.downloadprovider.download.tasklist.list.a.e a(int i) {
        if (i >= a()) {
            return 0;
        }
        if (i < this.a.size()) {
            return (com.xunlei.downloadprovider.download.tasklist.list.a.e) this.a.get(i);
        }
        return (com.xunlei.downloadprovider.download.tasklist.list.a.e) this.b.get(i - this.a.size());
    }

    public final int b() {
        int i = 0;
        if (this.a != null) {
            if (this.a.size() != 0) {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    if (((com.xunlei.downloadprovider.download.tasklist.list.a.e) it.next()).a == 0) {
                        i++;
                    }
                }
                return i;
            }
        }
        return 0;
    }
}
