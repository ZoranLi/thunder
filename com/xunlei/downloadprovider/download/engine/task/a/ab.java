package com.xunlei.downloadprovider.download.engine.task.a;

import com.xunlei.downloadprovider.download.engine.task.z;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TaskStateObservable */
public final class ab {
    protected final ArrayList<Object> a = new ArrayList();

    final void a(z zVar) {
        if (!this.a.isEmpty()) {
            Iterator it = new ArrayList(this.a).iterator();
            while (it.hasNext()) {
                it.next();
                zVar.f();
            }
        }
    }
}
