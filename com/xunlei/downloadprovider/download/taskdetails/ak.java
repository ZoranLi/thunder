package com.xunlei.downloadprovider.download.taskdetails;

import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.taskdetail.a$a;

/* compiled from: TaskDetailFragment */
final class ak implements a$a {
    final /* synthetic */ TaskDetailFragment a;

    ak(TaskDetailFragment taskDetailFragment) {
        this.a = taskDetailFragment;
    }

    public final void a() {
        boolean z;
        TaskDetailFragment taskDetailFragment = this.a;
        l lVar = taskDetailFragment.i.e;
        if (lVar != null) {
            switch (an.a[lVar.v.ordinal()]) {
                case 1:
                case 2:
                    z = true;
                    break;
                default:
                    break;
            }
        }
        z = false;
        if (taskDetailFragment.n != null) {
            taskDetailFragment.n.a(z, lVar, taskDetailFragment.i);
        }
        this.a.c();
        this.a.d();
    }
}
