package com.xunlei.downloadprovider.web.browser;

import android.view.LayoutInflater;
import android.widget.Toast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.engine.task.c;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;

/* compiled from: BrowserActivity */
final class q implements c {
    final /* synthetic */ BrowserActivity a;

    q(BrowserActivity browserActivity) {
        this.a = browserActivity;
    }

    public final void a(TaskInfo taskInfo, int i, int i2) {
        i2 = BrowserActivity.a;
        new StringBuilder("handle ADD_TASK_FAILED , url = ").append(taskInfo.mUrl);
        if (i != -2) {
            taskInfo = this.a;
            i = new Toast(taskInfo.getApplicationContext());
            taskInfo = LayoutInflater.from(taskInfo).inflate(R.layout.download_fail_toast, null);
            i.setGravity(17, 0, 0);
            i.setView(taskInfo);
            i.setDuration(0);
            i.show();
            return;
        }
        com.xunlei.downloadprovider.download.c.a(this.a, i, taskInfo.getTaskId());
    }

    public final void b(TaskInfo taskInfo, int i, int i2) {
        i = BrowserActivity.a;
        new StringBuilder("taskId = ").append(taskInfo.getTaskId());
        BrowserActivity.f(this.a);
        taskInfo = this.a;
        i = new Toast(taskInfo.getApplicationContext());
        i.setView(LayoutInflater.from(taskInfo).inflate(R.layout.download_success_toast, null));
        i.setGravity(17, 0, 0);
        i.setDuration(0);
        i.show();
        BrowserActivity.g(this.a);
    }
}
