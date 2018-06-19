package com.xunlei.downloadprovider.download.tasklist.list.download;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.download.center.widget.af.a;

/* compiled from: TaskDownloadCardViewHolder */
final class e implements a {
    final /* synthetic */ TaskDownloadCardViewHolder a;

    e(TaskDownloadCardViewHolder taskDownloadCardViewHolder) {
        this.a = taskDownloadCardViewHolder;
    }

    public final void a() {
        int a = this.a.mAdapter.a(this.a.mTaskInfo.getTaskId());
        if (a != -1 && a >= 0 && a < this.a.mAdapter.getItemCount()) {
            this.a.refreshPrivateSpaceUI();
            String a2 = com.xunlei.downloadprovider.download.report.a.a(this.a.mCardItem.b());
            String access$1700 = this.a.getTabid(this.a.mAdapter.a());
            StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_center_taskAlert_click");
            StatEvent addString = build.addString("clickid", "in_prispace").addString("status", a2);
            String str = "tabid";
            if (access$1700 == null) {
                access$1700 = "";
            }
            addString.addString(str, access$1700);
            ThunderReport.reportEvent(build);
        }
    }

    public final void b() {
        int a = this.a.mAdapter.a(this.a.mTaskInfo.getTaskId());
        if (a != -1 && a >= 0 && a < this.a.mAdapter.getItemCount()) {
            this.a.refreshPrivateSpaceUI();
            String a2 = com.xunlei.downloadprovider.download.report.a.a(this.a.mCardItem.b());
            String access$1700 = this.a.getTabid(this.a.mAdapter.a());
            StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_center_taskAlert_click");
            StatEvent addString = build.addString("clickid", "re_prispace").addString("status", a2);
            String str = "tabid";
            if (access$1700 == null) {
                access$1700 = "";
            }
            addString.addString(str, access$1700);
            ThunderReport.reportEvent(build);
        }
    }
}
