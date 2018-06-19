package com.xunlei.downloadprovider.personal.lixianspace.business;

import android.os.Handler;
import android.os.HandlerThread;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo;
import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo.CollectState;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: LXSpaceTaskStateMgr */
public final class c {
    public Handler a;
    Set<Long> b;
    public long c;
    private HandlerThread d;

    /* compiled from: LXSpaceTaskStateMgr */
    private static class a {
        private static final c a = new c();
    }

    private c() {
        this.c = 1800000;
        this.b = Collections.synchronizedSet(new HashSet(16));
        Collection a = com.xunlei.downloadprovider.personal.lixianspace.a.a.a.a().a();
        if (!(a == null || a.isEmpty())) {
            this.b.addAll(a);
        }
        com.xunlei.downloadprovider.personal.lixianspace.b.c.a.a().a(new d(this));
        LoginHelper.a().a(new e(this));
    }

    final boolean a(LXTaskInfo lXTaskInfo) {
        if (lXTaskInfo != null && lXTaskInfo.e > 0 && lXTaskInfo.i == CollectState.downloading) {
            return this.b.add(Long.valueOf(lXTaskInfo.a));
        }
        return false;
    }

    private void c() {
        if (this.d == null) {
            this.d = new HandlerThread("lx_task_download");
            this.d.start();
            this.a = new f(this, this.d.getLooper());
        }
    }

    final void a() {
        if (com.xunlei.downloadprovider.personal.lixianspace.a.d()) {
            c();
            com.xunlei.downloadprovider.personal.lixianspace.a.a.a.a().a(this.b);
            if (!(this.a.hasMessages(1) || this.b.isEmpty())) {
                this.a.sendEmptyMessageDelayed(1, this.c);
            }
        }
    }

    public final void b() {
        if (com.xunlei.downloadprovider.personal.lixianspace.a.d()) {
            c();
            this.a.removeMessages(1);
            this.a.sendEmptyMessage(1);
        }
    }

    static /* synthetic */ void a(c cVar, LXTaskInfo lXTaskInfo) {
        if (com.xunlei.downloadprovider.personal.lixianspace.a.d() && cVar.a(lXTaskInfo) != null) {
            cVar.a();
        }
    }
}
