package com.xunlei.downloadprovider.personal.redenvelope.redenvelopedetail;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.download.engine.task.c;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;

/* compiled from: RedEnvelopesDetailActivity */
final class k implements c {
    final /* synthetic */ RedEnvelopesDetailActivity a;

    k(RedEnvelopesDetailActivity redEnvelopesDetailActivity) {
        this.a = redEnvelopesDetailActivity;
    }

    public final void a(TaskInfo taskInfo, int i, int i2) {
        if (taskInfo != null && i == -2) {
            RedEnvelopesDetailActivity.j(this.a);
        }
    }

    public final void b(TaskInfo taskInfo, int i, int i2) {
        if (this.a.s != null) {
            this.a.s.e = 2;
            RedEnvelopesDetailActivity.j(this.a);
            XLToast.showToast(this.a.getApplicationContext(), "任务创建成功");
        }
    }
}
