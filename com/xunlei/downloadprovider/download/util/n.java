package com.xunlei.downloadprovider.download.util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.xunlei.downloadprovider.cooperation.data.CooperationItem;
import com.xunlei.downloadprovider.cooperation.l;
import com.xunlei.downloadprovider.cooperation.ui.b;
import com.xunlei.downloadprovider.download.center.widget.at;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.plugin.q;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.a.c;
import com.xunlei.downloadprovidershare.a.f;
import com.xunlei.downloadprovidershare.b.d;
import com.xunlei.downloadprovidershare.k;

/* compiled from: TaskShareHelper */
public final class n {

    /* compiled from: TaskShareHelper */
    public static class a implements k {
        private String a;
        TaskInfo c;
        Activity d;
        at e;
        Bitmap f = null;

        public a(Activity activity, TaskInfo taskInfo, String str) {
            this.d = activity;
            this.c = taskInfo;
            this.a = str;
        }

        public void onShareTargetClicked(ShareOperationType shareOperationType, f fVar) {
            shareOperationType.getReportShareTo();
            if (shareOperationType == ShareOperationType.QR_SHARE) {
                String str = fVar.f;
                if (this.e != null) {
                    this.e.dismiss();
                }
                q.a().a(this.d, "com.xunlei.plugin.qrcode", new o(this, str));
            } else if (shareOperationType == ShareOperationType.COOPERATION) {
                b.a().a(this.d, (CooperationItem) ((c) fVar).b.b, this.c.mLocalFileName);
            } else if (shareOperationType == ShareOperationType.THUNDER_COMMAND) {
                new com.xunlei.downloadprovider.download.player.views.c(this.d, fVar, this.a).show();
                com.xunlei.downloadprovider.download.report.a.f(this.a, ((c) fVar).a);
            }
            if (this.c != null) {
                com.xunlei.downloadprovider.download.report.a.b(shareOperationType.getReportShareTo(), fVar.j, this.c.mGCID, this.c.mTitle, this.c.getTaskDownloadUrl());
            }
        }

        public void onShareComplete(int i, ShareOperationType shareOperationType, f fVar) {
            if (this.c != null) {
                com.xunlei.downloadprovider.download.report.a.a(shareOperationType.getReportShareTo(), com.xunlei.downloadprovider.f.a.a(i), fVar.j, this.c.mGCID, this.c.mTitle, this.c.getTaskDownloadUrl());
            }
        }
    }

    public static d a(Activity activity, String str, TaskInfo taskInfo, String str2, String str3, k kVar, String str4) {
        CooperationItem a = com.xunlei.downloadprovider.cooperation.c.a().a(7);
        f a2 = com.xunlei.downloadprovider.f.c.a(str, taskInfo, a, str2, str3);
        com.xunlei.downloadprovidershare.b.c a3 = com.xunlei.downloadprovidershare.b.a.a(a2, com.xunlei.downloadprovider.d.d.a().d.v());
        if (kVar != null) {
            com.xunlei.downloadprovider.f.a.a();
            activity = com.xunlei.downloadprovider.f.a.a(activity, a2, kVar, a3);
        } else {
            com.xunlei.downloadprovider.f.a.a();
            activity = com.xunlei.downloadprovider.f.a.a(activity, a2, new a(activity, taskInfo, str4), a3);
        }
        if (a != null && TextUtils.isEmpty(a.getAppName()) == null && TextUtils.isEmpty(a.getCopyWriting()) == null) {
            com.xunlei.downloadprovider.cooperation.a.a.a(l.c(a.getDisplayLocation()), a.getAppName(), a.isShowInstallTip());
        }
        return activity;
    }
}
