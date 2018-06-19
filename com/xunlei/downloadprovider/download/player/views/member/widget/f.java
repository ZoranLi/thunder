package com.xunlei.downloadprovider.download.player.views.member.widget;

import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.player.views.member.a;

/* compiled from: MemberActionView */
final class f implements Runnable {
    final /* synthetic */ MemberActionView a;

    f(MemberActionView memberActionView) {
        this.a = memberActionView;
    }

    public final void run() {
        TaskInfo a = this.a.getTaskInfo();
        if (a != null) {
            if (a.b(a)) {
                com.xunlei.downloadprovider.download.c.a.a().f(a.getTaskId());
                com.xunlei.downloadprovider.player.a.a(1, 3);
                return;
            }
            com.xunlei.downloadprovider.player.a.a(0, 3);
        }
    }
}
