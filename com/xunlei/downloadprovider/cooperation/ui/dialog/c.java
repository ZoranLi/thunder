package com.xunlei.downloadprovider.cooperation.ui.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.common.androidutil.ApkHelper;
import com.xunlei.downloadprovider.cooperation.a.a;
import com.xunlei.downloadprovider.cooperation.data.CooperationItem;
import com.xunlei.downloadprovider.download.engine.task.n;
import java.io.File;

/* compiled from: CooperationDialogActivity */
final class c implements OnClickListener {
    final /* synthetic */ CooperationItem a;
    final /* synthetic */ CooperationDialogActivity b;

    c(CooperationDialogActivity cooperationDialogActivity, CooperationItem cooperationItem) {
        this.b = cooperationDialogActivity;
        this.a = cooperationItem;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
            this.b.b = null;
        }
        a.a(this.a.getDisplayLocationName(), this.a.getAppPackageName(), "1");
        dialogInterface = ApkHelper.isApkPackageInstalled(this.b.getApplication(), this.a.getAppPackageName());
        i = this.b;
        CooperationItem cooperationItem = this.a;
        if (cooperationItem != null) {
            if (dialogInterface != null) {
                ApkHelper.launchAppByPackageName(i, cooperationItem.getAppPackageName());
                return;
            }
            n.a();
            long e = n.e(cooperationItem.getAppDownloadUrl());
            if (e != -1) {
                n.a();
                dialogInterface = n.f(e);
                if (dialogInterface == null || dialogInterface.mLocalFileName == null || !new File(dialogInterface.mLocalFileName).exists() || dialogInterface.mDownloadedSize != dialogInterface.mFileSize) {
                    CooperationDialogActivity.a(cooperationItem);
                    return;
                } else {
                    ApkHelper.installApk(i, dialogInterface.mLocalFileName);
                    return;
                }
            }
            CooperationDialogActivity.a(cooperationItem);
        }
    }
}
