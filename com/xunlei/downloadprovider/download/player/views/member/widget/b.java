package com.xunlei.downloadprovider.download.player.views.member.widget;

import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.player.views.member.a;
import com.xunlei.downloadprovider.member.login.b.c;

/* compiled from: MemberActionLoadingView */
final class b extends c {
    final /* synthetic */ TaskInfo a;
    final /* synthetic */ MemberActionLoadingView b;

    b(MemberActionLoadingView memberActionLoadingView, TaskInfo taskInfo) {
        this.b = memberActionLoadingView;
        this.a = taskInfo;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        a.d(this.a);
        if (!a.a()) {
            this.b.a();
        }
    }
}
