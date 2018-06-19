package com.xunlei.downloadprovider.download.taskdetails.a;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: MultiPartList */
public final class c<E> {
    public final ArrayList<E> a = new ArrayList();
    public final ArrayList<E> b = new ArrayList();
    public final ArrayList<E> c = new ArrayList();
    public final ArrayList<E> d = new ArrayList();
    public boolean e = true;
    public boolean f = false;

    public final E a(int i) {
        int a = a();
        if (i >= 0) {
            if (i < a) {
                if (this.a.size() > 0 && i < this.a.size()) {
                    return this.a.get(i);
                }
                ArrayList arrayList;
                i -= this.a.size();
                if (!this.e) {
                    if (!this.f) {
                        arrayList = this.b;
                        if (arrayList.size() <= 0 && i < arrayList.size()) {
                            return arrayList.get(i);
                        }
                        return this.d.get(i - arrayList.size());
                    }
                }
                arrayList = this.c;
                if (arrayList.size() <= 0) {
                }
                return this.d.get(i - arrayList.size());
            }
        }
        return null;
    }

    public final void b() {
        this.b.clear();
        this.c.clear();
    }

    public final boolean a(Collection<E> collection) {
        return collection == null ? null : this.a.addAll(collection);
    }

    public final boolean b(Collection<E> collection) {
        return collection == null ? null : this.b.addAll(collection);
    }

    public final boolean c(Collection<E> collection) {
        return collection == null ? null : this.c.addAll(collection);
    }

    public final boolean d(Collection<E> collection) {
        return collection == null ? null : this.d.addAll(collection);
    }

    public final int a() {
        ArrayList arrayList;
        if (!this.e) {
            if (!this.f) {
                arrayList = this.b;
                return (this.a.size() + arrayList.size()) + this.d.size();
            }
        }
        arrayList = this.c;
        return (this.a.size() + arrayList.size()) + this.d.size();
    }
}
