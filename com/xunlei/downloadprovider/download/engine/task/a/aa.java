package com.xunlei.downloadprovider.download.engine.task.a;

import android.database.Observable;
import com.xunlei.downloadprovider.download.engine.task.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: TaskObservable */
public final class aa extends Observable<w> {
    public final void a(long j) {
        if (!this.mObservers.isEmpty()) {
            Iterator it = new ArrayList(this.mObservers).iterator();
            while (it.hasNext()) {
                ((w) it.next()).a(j);
            }
        }
    }

    public final void a(Collection<Long> collection) {
        if (!this.mObservers.isEmpty()) {
            Iterator it = new ArrayList(this.mObservers).iterator();
            while (it.hasNext()) {
                ((w) it.next()).a((Collection) collection);
            }
        }
    }

    public final void b(Collection<Long> collection) {
        if (!this.mObservers.isEmpty()) {
            Iterator it = new ArrayList(this.mObservers).iterator();
            while (it.hasNext()) {
                ((w) it.next()).b(collection);
            }
        }
    }
}
