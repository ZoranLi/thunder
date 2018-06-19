package com.xunlei.downloadprovider.download.player.views.member.widget;

import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.player.views.member.a;
import com.xunlei.downloadprovider.member.login.b.c;

/* compiled from: MemberActionView */
final class e extends c {
    final /* synthetic */ TaskInfo a;
    final /* synthetic */ MemberActionView b;

    e(MemberActionView memberActionView, TaskInfo taskInfo) {
        this.b = memberActionView;
        this.a = taskInfo;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        a.d(this.a);
        if (!a.a()) {
            this.b.a();
        }
    }
}
