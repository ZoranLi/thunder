package com.xunlei.downloadprovider.download.player.views.member.widget;

import android.text.TextUtils;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.player.views.member.a;

/* compiled from: MemberActionLoadingView */
final class c implements Runnable {
    final /* synthetic */ MemberActionLoadingView a;

    c(MemberActionLoadingView memberActionLoadingView) {
        this.a = memberActionLoadingView;
    }

    public final void run() {
        TaskInfo a = this.a.getTaskInfo();
        if (a != null) {
            int i = 2;
            if (a.b(a)) {
                com.xunlei.downloadprovider.download.c.a.a().f(a.getTaskId());
                if (TextUtils.equals("免费试用会员加速，体验高速看片>", this.a.getText().toString())) {
                    i = 0;
                }
                com.xunlei.downloadprovider.player.a.a(1, i);
                return;
            }
            if (TextUtils.equals("免费试用会员加速，体验高速看片>", this.a.getText().toString())) {
                i = 0;
            }
            com.xunlei.downloadprovider.player.a.a(0, i);
        }
    }
}
