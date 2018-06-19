package com.xunlei.downloadprovider.download.tasklist.task;

import com.xunlei.downloadprovider.download.engine.task.w;
import java.util.Collection;

/* compiled from: TaskListManager */
final class j implements w {
    final /* synthetic */ h a;

    j(h hVar) {
        this.a = hVar;
    }

    public final void a(long j) {
        if (this.a.j != null) {
            this.a.j.a(j);
        }
    }

    public final void a(Collection<Long> collection) {
        if (this.a.j != null) {
            this.a.j.a((Collection) collection);
        }
    }

    public final void b(Collection<Long> collection) {
        if (this.a.j != null) {
            this.a.j.b(collection);
        }
    }
}
