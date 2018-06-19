package com.xunlei.downloadprovider.download.taskdetails.newui;

import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.downloadprovider.download.center.widget.DownloadCenterBottomView;
import com.xunlei.downloadprovider.download.center.widget.DownloadCenterSelectFileTitleView;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.taskdetails.a.b;
import com.xunlei.downloadprovider.download.taskdetails.subtask.BTSubTaskItem;
import com.xunlei.downloadprovider.download.tasklist.task.s;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TaskDetailEditController */
public class aw {
    private static final String h = "aw";
    b a;
    a b;
    DownloadCenterSelectFileTitleView c;
    XLAlertDialog d;
    DownloadCenterBottomView e;
    s f;
    a g;

    /* compiled from: TaskDetailEditController */
    public interface a {
        void a(boolean z);
    }

    public final void a(boolean z) {
        int i = 8;
        this.e.setVisibility(z ? 0 : 8);
        DownloadCenterSelectFileTitleView downloadCenterSelectFileTitleView = this.c;
        if (z) {
            i = 0;
        }
        downloadCenterSelectFileTitleView.setVisibility(i);
    }

    final void a() {
        if (this.d != null) {
            this.d.dismiss();
        }
    }

    static /* synthetic */ void a(aw awVar, boolean z, List list) {
        int i;
        for (i = 0; i < list.size(); i++) {
            if (((BTSubTaskItem) list.get(i)).mLocalFileName != null) {
                File file = new File(((BTSubTaskItem) list.get(i)).mLocalFileName);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
        if (z) {
            n.a().b(new long[]{awVar.f.a()});
            if (awVar.g) {
                awVar = awVar.g;
                z = new ArrayList(0);
                awVar.a(true);
                return;
            }
        }
        z = awVar.a.b();
        list = new long[z.size()];
        for (i = 0; i < z.size(); i++) {
            list[i] = (long) ((BTSubTaskItem) z.get(i)).mBTSubIndex;
        }
        n.a();
        n.a(awVar.f.a(), list);
        awVar.b.b(false);
        if (awVar.g) {
            awVar.g.a(false);
        }
    }
}
