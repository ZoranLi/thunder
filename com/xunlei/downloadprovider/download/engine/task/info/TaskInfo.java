package com.xunlei.downloadprovider.download.engine.task.info;

import android.text.TextUtils;
import com.xunlei.download.DownloadManager.TaskType;
import com.xunlei.downloadprovider.download.engine.util.b;
import java.util.List;

public class TaskInfo extends TaskBasicInfo {
    private static final long serialVersionUID = 1;
    public long mAcceleratedSize;
    public long mAcceleratedSpeed;
    public String mAppName = "";
    public List<TaskRangeInfo> mCacheTaskRangeInfos;
    public boolean mCheckApkOperateWhenCreate = false;
    private boolean mConsumed = false;
    public String mCreateOrigin = "";
    public long mDownloadRemainTime = -1;
    public TaskExtraInfo mExtraInfo = null;
    public long mFreeTrialLMT = 0;
    public long mFreeTrialRemainTime = -1;
    public int mFreeTrialTimes;
    public boolean mHasShowRedEnvelopeBanner;
    public boolean mHasSpeed = false;
    public String mIconUrl = "";
    public boolean mIsEnteredHighSpeedTrial;
    public boolean mIsToastForTask;
    public String mLastRangeInfoStr = "";
    public transient int mRevision = 0;
    public final transient a mRunningInfo = new a();
    private int mSeenFlag = 0;
    public boolean mShouldAutoSpeedup = false;
    public String mSniffKeyword = "";
    public String mUrlEigenvalue = "";
    public long mVipAcceleratedSize;
    public long mVipAcceleratedSpeed;
    public String mWebsiteName = "";

    public String getResourceGcid() {
        if (this.mTaskType == TaskType.BT) {
            if (!TextUtils.isEmpty(this.mInfoHash) || this.mExtraInfo == null || TextUtils.isEmpty(this.mExtraInfo.mInfoHash)) {
                return this.mInfoHash;
            }
            return this.mExtraInfo.mInfoHash;
        } else if (this.mTaskType == TaskType.MAGNET) {
            String str = this.mInfoHash;
            if (!(!TextUtils.isEmpty(str) || this.mExtraInfo == null || TextUtils.isEmpty(this.mExtraInfo.mInfoHash))) {
                str = this.mExtraInfo.mInfoHash;
            }
            if (TextUtils.isEmpty(str)) {
                str = this.mGCID;
            }
            if (!b.f(str)) {
                if (this.mExtraInfo == null) {
                    syncExtraInfo();
                }
                str = b.c(getTaskDownloadUrl());
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.mTitle)) {
                    str = b.d(this.mTitle);
                }
                if (!(TextUtils.isEmpty(str) || this.mExtraInfo == null)) {
                    this.mExtraInfo.mInfoHash = str;
                }
            }
            return str;
        } else if (!TextUtils.isEmpty(this.mGCID) || this.mExtraInfo == null || TextUtils.isEmpty(this.mExtraInfo.mGCID)) {
            return this.mGCID;
        } else {
            return this.mExtraInfo.mGCID;
        }
    }

    public int getVodStatus() {
        return this.mRunningInfo.d;
    }

    public void setVodStatus(int i) {
        this.mRunningInfo.d = i;
    }

    public static void calculateTaskRunningData(TaskInfo taskInfo) {
        taskInfo.mAcceleratedSpeed = taskInfo.mP2spSpeed;
        taskInfo.mVipAcceleratedSpeed = 0;
        if (taskInfo.mVipChannelSpeed > 0) {
            taskInfo.mAcceleratedSpeed += taskInfo.mVipChannelSpeed;
            taskInfo.mVipAcceleratedSpeed += taskInfo.mVipChannelSpeed;
        }
        if (taskInfo.mDcdnSpeed > 0) {
            taskInfo.mAcceleratedSpeed += taskInfo.mDcdnSpeed;
            taskInfo.mVipAcceleratedSpeed += taskInfo.mDcdnSpeed;
        }
        taskInfo.mAcceleratedSize = taskInfo.mDownloadedSize - taskInfo.mOriginReceivedSize;
        taskInfo.mVipAcceleratedSize = taskInfo.mVipChannelReceivedSize + taskInfo.mDcdnReceivedSize;
        if (!taskInfo.mHasSpeed && taskInfo.mDownloadSpeed > 0) {
            taskInfo.mHasSpeed = true;
        }
    }

    public String getTaskDownloadUrl() {
        if (this.mTaskType == TaskType.BT) {
            return b.b(this.mInfoHash);
        }
        return this.mUrl;
    }

    public boolean isUnseen() {
        return this.mSeenFlag == 0;
    }

    public void markToSeen() {
        if (this.mSeenFlag == 0) {
            this.mSeenFlag = 1;
            this.mRevision++;
        }
    }

    public int getSeenFlag() {
        return this.mSeenFlag;
    }

    public boolean setSeenFlag(int i) {
        int i2 = this.mSeenFlag;
        this.mSeenFlag = i == 0 ? 0 : 1;
        return i2 != this.mSeenFlag;
    }

    public boolean isConsumed() {
        return this.mConsumed;
    }

    public void setConsumed(boolean z) {
        this.mConsumed = z;
    }

    public void syncExtraInfo() {
        if (this.mExtraInfo == null) {
            this.mExtraInfo = new TaskExtraInfo();
        }
        this.mExtraInfo.mTaskId = this.mTaskId;
        this.mExtraInfo.mUrl = this.mUrl;
        this.mExtraInfo.mRefUrl = this.mRefUrl;
        if (!TextUtils.isEmpty(this.mCID)) {
            this.mExtraInfo.mCID = this.mCID;
        }
        if (!TextUtils.isEmpty(this.mGCID)) {
            this.mExtraInfo.mGCID = this.mGCID;
        }
        if (!TextUtils.isEmpty(this.mInfoHash)) {
            this.mExtraInfo.mInfoHash = this.mInfoHash;
        }
        this.mExtraInfo.mCreateOrigin = this.mCreateOrigin;
        this.mExtraInfo.mSeen = this.mSeenFlag;
        this.mExtraInfo.mSniffKeyword = this.mSniffKeyword;
        this.mExtraInfo.mWebsiteName = this.mWebsiteName;
        this.mExtraInfo.mIconUrl = this.mIconUrl;
        this.mExtraInfo.mDisplayName = this.mDisplayName;
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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("TaskRunningInfo{mTaskId='");
        stringBuilder.append(this.mTaskId);
        stringBuilder.append('\'');
        stringBuilder.append("mTaskStatus='");
        stringBuilder.append(this.mTaskStatus);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
