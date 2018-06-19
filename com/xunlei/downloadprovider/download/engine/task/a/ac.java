package com.xunlei.downloadprovider.download.engine.task.a;

import com.xunlei.downloadprovider.download.engine.task.info.TaskCountsStatistics;
import com.xunlei.downloadprovider.download.engine.task.info.c;

/* compiled from: TaskStatistics */
final class ac {
    TaskCountsStatistics a = new TaskCountsStatistics();
    final a b = new a();

    /* compiled from: TaskStatistics */
    private static class a {
        TaskCountsStatistics a = new TaskCountsStatistics();
        TaskCountsStatistics b = new TaskCountsStatistics();
        TaskCountsStatistics c = new TaskCountsStatistics();
        c d = new c();
        c e = new c();

        a() {
        }
    }

    ac() {
    }

    ac(ac acVar) {
        a(acVar);
    }

    final void a(ac acVar) {
        if (this.a == null) {
            this.a = new TaskCountsStatistics(acVar.a);
        } else {
            this.a.copyFrom(acVar.a);
        }
        a aVar = this.b;
        acVar = acVar.b;
        aVar.a.copyFrom(acVar.a);
        aVar.b.copyFrom(acVar.b);
        aVar.d.a(acVar.d);
        aVar.e.a(acVar.e);
    }
}
