package com.xunlei.downloadprovider.download.engine.task.info;

import android.text.TextUtils;
import com.xunlei.download.DownloadManager.TaskType;
import java.io.Serializable;

public class TaskBasicInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public String mCID = "";
    public long mCreateTime = 0;
    private long mCustomFlags = 0;
    public long mDcdnReceivedSize = 0;
    public long mDcdnSpeed = 0;
    public String mDisplayName = null;
    public long mDownloadDurationTime = 0;
    public long mDownloadSpeed = 0;
    public long mDownloadedSize = 0;
    public String mErrorMsg = "";
    public long mFailureReason = 0;
    public long mFileSize = 0;
    public String mGCID = "";
    public boolean mHasVipChannelSpeedup = false;
    public String mInfoHash = "";
    public long mLastModifiedTime = 0;
    public String mLocalFileName = "";
    public long mOriginReceivedSize = 0;
    public long mOriginSpeed = 0;
    public int mOriginalStatusCode = 0;
    public long mP2spReceivedSize = 0;
    public long mP2spSpeed = 0;
    private String mRangeInfoStr = "";
    public String mRefUrl = "";
    public long mResLinkTotal = 0;
    public long mResLinkUsed = 0;
    protected long mTaskId = -1;
    private boolean mTaskInvisible = false;
    protected int mTaskStatus = 0;
    public TaskType mTaskType = TaskType.HTTP;
    public String mTitle = "";
    public String mUrl = "";
    public long mVipChannelReceivedSize = 0;
    public long mVipChannelSpeed = 0;
    public int mVipChannelStatus = 0;
    public int mVipChannelStatusCode = 0;

    public static void copyTaskBasicInfoCoreFields(TaskBasicInfo taskBasicInfo, TaskBasicInfo taskBasicInfo2) {
        taskBasicInfo2.mUrl = taskBasicInfo.mUrl;
        taskBasicInfo2.mTitle = taskBasicInfo.mTitle;
        taskBasicInfo2.mLocalFileName = taskBasicInfo.mLocalFileName;
        taskBasicInfo2.mFileSize = taskBasicInfo.mFileSize;
        taskBasicInfo2.mDownloadSpeed = taskBasicInfo.mDownloadSpeed;
        taskBasicInfo2.mOriginSpeed = taskBasicInfo.mOriginSpeed;
        taskBasicInfo2.mP2spSpeed = taskBasicInfo.mP2spSpeed;
        taskBasicInfo2.mVipChannelSpeed = taskBasicInfo.mVipChannelSpeed;
        taskBasicInfo2.mDownloadedSize = taskBasicInfo.mDownloadedSize;
        taskBasicInfo2.mOriginReceivedSize = taskBasicInfo.mOriginReceivedSize;
        taskBasicInfo2.mP2spReceivedSize = taskBasicInfo.mP2spReceivedSize;
        taskBasicInfo2.mVipChannelReceivedSize = taskBasicInfo.mVipChannelReceivedSize;
        taskBasicInfo2.mResLinkTotal = taskBasicInfo.mResLinkTotal;
        taskBasicInfo2.mResLinkUsed = taskBasicInfo.mResLinkUsed;
        taskBasicInfo2.mCreateTime = taskBasicInfo.mCreateTime;
        taskBasicInfo2.mLastModifiedTime = taskBasicInfo.mLastModifiedTime;
        taskBasicInfo2.mDownloadDurationTime = taskBasicInfo.mDownloadDurationTime;
        taskBasicInfo2.mCID = taskBasicInfo.mCID;
        taskBasicInfo2.mGCID = taskBasicInfo.mGCID;
        taskBasicInfo2.mInfoHash = taskBasicInfo.mInfoHash;
        taskBasicInfo2.mHasVipChannelSpeedup = taskBasicInfo.mHasVipChannelSpeedup;
        taskBasicInfo2.mVipChannelStatus = taskBasicInfo.mVipChannelStatus;
        taskBasicInfo2.mVipChannelStatusCode = taskBasicInfo.mVipChannelStatusCode;
        taskBasicInfo2.mTaskType = taskBasicInfo.mTaskType;
        taskBasicInfo2.mTaskId = taskBasicInfo.mTaskId;
        taskBasicInfo2.mTaskStatus = taskBasicInfo.mTaskStatus;
        taskBasicInfo2.mOriginalStatusCode = taskBasicInfo.mOriginalStatusCode;
        taskBasicInfo2.mFailureReason = taskBasicInfo.mFailureReason;
        taskBasicInfo2.mErrorMsg = taskBasicInfo.mErrorMsg;
        taskBasicInfo2.mDcdnSpeed = taskBasicInfo.mDcdnSpeed;
        taskBasicInfo2.mDcdnReceivedSize = taskBasicInfo.mDcdnReceivedSize;
        taskBasicInfo2.mTaskInvisible = taskBasicInfo.mTaskInvisible;
        taskBasicInfo2.mCustomFlags = taskBasicInfo.mCustomFlags;
        taskBasicInfo2.mRangeInfoStr = taskBasicInfo.mRangeInfoStr;
    }

    public static void syncTaskBasicInfo(TaskBasicInfo taskBasicInfo, TaskBasicInfo taskBasicInfo2) {
        copyTaskBasicInfoCoreFields(taskBasicInfo, taskBasicInfo2);
        if (!TextUtils.isEmpty(taskBasicInfo.mRefUrl)) {
            taskBasicInfo2.mRefUrl = taskBasicInfo.mRefUrl;
        }
        if (!TextUtils.isEmpty(taskBasicInfo.mDisplayName)) {
            taskBasicInfo2.mDisplayName = taskBasicInfo.mDisplayName;
        }
    }

    public void setRangeInfoStr(String str) {
        this.mRangeInfoStr = str;
    }

    public String getRangeInfoStr() {
        return this.mRangeInfoStr;
    }

    public long getCustomFlags() {
        return this.mCustomFlags;
    }

    public void setCustomFlags(long j) {
        this.mCustomFlags = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TaskBasicInfo)) {
            return false;
        }
        return this.mTaskId == ((TaskBasicInfo) obj).mTaskId;
    }

    public int hashCode() {
        return (int) (this.mTaskId ^ (this.mTaskId >>> 32));
    }

    public boolean isTaskInvisible() {
        return this.mTaskInvisible;
    }

    public void setTaskInvisible(boolean z) {
        this.mTaskInvisible = z;
    }

    public long getTaskId() {
        return this.mTaskId;
    }

    public void setTaskId(long j) {
        this.mTaskId = j;
    }

    public int getTaskStatus() {
        return this.mTaskStatus;
    }

    public void setTaskStatus(int i) {
        this.mTaskStatus = i;
    }
}
