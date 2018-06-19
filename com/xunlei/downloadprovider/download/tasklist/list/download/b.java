package com.xunlei.downloadprovider.download.tasklist.list.download;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.androidutil.ApkHelper;
import com.xunlei.common.businessutil.XLFileTypeUtil.EFileCategoryType;
import com.xunlei.downloadprovider.download.control.a;
import com.xunlei.downloadprovider.download.util.r;

/* compiled from: TaskDownloadCardViewHolder */
final class b implements OnClickListener {
    final /* synthetic */ TaskDownloadCardViewHolder a;

    b(TaskDownloadCardViewHolder taskDownloadCardViewHolder) {
        this.a = taskDownloadCardViewHolder;
    }

    public final void onClick(View view) {
        if (this.a.isEditMode() != null) {
            this.a.selectOrDeselectTaskCardItem();
            return;
        }
        this.a.setTaskToSeen();
        if (this.a.getDownloadCenterControl() != null) {
            if (this.a.mTaskInfo.getTaskStatus() == 8 && r.a(this.a.mTaskInfo) == EFileCategoryType.E_SOFTWARE_CATEGORY) {
                view = ApkHelper.getApkInfo(this.a.mContext, this.a.mTaskInfo.mLocalFileName);
                if (view != null) {
                    view = view.getPackageName();
                    if (!TextUtils.isEmpty(view)) {
                        this.a.onApkTaskOnClick(this.a.mTaskInfo, ApkHelper.isApkPackageFileInstalled(this.a.mContext, this.a.mTaskInfo.mLocalFileName), view);
                        return;
                    }
                }
            }
            a.a(this.a.getContext(), this.a.mTaskInfo, "dlcenter_total_bar");
        }
    }
}
