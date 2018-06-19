package com.xunlei.downloadprovider.download.taskdetails.subtask;

import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.xunlei.common.businessutil.XLFileTypeUtil;
import com.xunlei.common.businessutil.XLFileTypeUtil.EFileCategoryType;
import com.xunlei.downloadprovider.download.engine.task.info.BTSubTaskInfo;
import com.xunlei.downloadprovider.h.e;
import com.xunlei.downloadprovider.personal.playrecord.v;
import java.io.Serializable;

public class BTSubTaskItem extends BTSubTaskInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public EFileCategoryType mFileCategoryType;
    private boolean mIsFileMissing = false;
    private boolean mSelected = false;
    public int mVideoDuration;
    public int mVideoPlayedTime;
    @Nullable
    private transient g mViewModel;

    public static EFileCategoryType getTaskFileCategoryType(BTSubTaskItem bTSubTaskItem) {
        if (bTSubTaskItem == null) {
            return null;
        }
        EFileCategoryType fileCategoryTypeByName;
        if (bTSubTaskItem.mFileCategoryType != null) {
            if (bTSubTaskItem.mFileCategoryType != EFileCategoryType.E_OTHER_CATEGORY) {
                bTSubTaskItem = bTSubTaskItem.mFileCategoryType;
                return bTSubTaskItem;
            }
        }
        if (TextUtils.isEmpty(bTSubTaskItem.mLocalFileName)) {
            fileCategoryTypeByName = XLFileTypeUtil.getFileCategoryTypeByName(bTSubTaskItem.mTitle);
        } else {
            fileCategoryTypeByName = XLFileTypeUtil.getFileCategoryTypeByName(bTSubTaskItem.mLocalFileName);
        }
        bTSubTaskItem.mFileCategoryType = fileCategoryTypeByName;
        bTSubTaskItem = fileCategoryTypeByName;
        return bTSubTaskItem;
    }

    public boolean isSelected() {
        return this.mSelected;
    }

    public void setSelected(boolean z) {
        this.mSelected = z;
    }

    public boolean isFileMissing() {
        return this.mIsFileMissing;
    }

    public g getViewModel() {
        return this.mViewModel;
    }

    public void setViewModel(@Nullable g gVar) {
        if (this.mViewModel != null) {
            this.mViewModel.c = null;
        }
        this.mViewModel = gVar;
        if (gVar != null) {
            gVar.c = this;
        }
    }

    public void refreshTaskUI() {
        if (this.mViewModel != null && this.mViewModel.b(this)) {
            g gVar = this.mViewModel;
            if (gVar.c != null) {
                if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
                    gVar.a();
                    return;
                }
                g.b.post(gVar.d);
            }
        }
    }

    public void checkFileMissing() {
        this.mIsFileMissing = false;
        if (this.mTaskStatus == 8 && !TextUtils.isEmpty(this.mLocalFileName) && !e.c(this.mLocalFileName)) {
            this.mIsFileMissing = true;
        }
    }

    public void checkFileCategory() {
        if (this.mFileCategoryType == null) {
            this.mFileCategoryType = getTaskFileCategoryType(this);
        }
    }

    public boolean isVideoFile() {
        return getTaskFileCategoryType(this) == EFileCategoryType.E_VIDEO_CATEGORY;
    }

    public boolean isApkFile() {
        return getTaskFileCategoryType(this) == EFileCategoryType.E_SOFTWARE_CATEGORY;
    }

    public void loadPlayRecord() {
        v.a().a(this.mLocalFileName, new a(this), null);
    }
}
