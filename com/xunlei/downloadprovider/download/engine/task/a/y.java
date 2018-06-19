package com.xunlei.downloadprovider.download.engine.task.a;

import android.database.Observable;
import com.xunlei.downloadprovider.download.engine.task.z;
import java.util.List;

/* compiled from: TaskListObservable */
public final class y extends Observable<z> {
    y() {
    }

    public final /* synthetic */ void registerObserver(Object obj) {
        a((z) obj);
    }

    public final /* synthetic */ void unregisterObserver(Object obj) {
        b((z) obj);
    }

    public final synchronized void a(z zVar) {
        try {
            super.registerObserver(zVar);
        } catch (z zVar2) {
            zVar2.printStackTrace();
        }
    }

    public final synchronized void b(z zVar) {
        try {
            super.unregisterObserver(zVar);
        } catch (z zVar2) {
            zVar2.printStackTrace();
        }
    }

    final void a(List<z> list) {
        if (!this.mObservers.isEmpty()) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((z) this.mObservers.get(size)).c(list);
            }
        }
    }
}
