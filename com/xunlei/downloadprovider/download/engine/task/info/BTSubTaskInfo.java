package com.xunlei.downloadprovider.download.engine.task.info;

import java.io.Serializable;
import java.util.List;

public class BTSubTaskInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public int mBTSubIndex = -1;
    public String mCID = "";
    public List<TaskRangeInfo> mCacheTaskRangeInfos;
    public long mDownloadSpeed = 0;
    public long mDownloadedSize = 0;
    public long mFileSize = 0;
    public String mGCID = "";
    public String mLastRangeInfoStr = "";
    public String mLocalFileName = "";
    public int mOriginalStatusCode = 0;
    public long mParentTaskId = -1;
    public String mRangeInfoStr = "";
    public long mTaskId = -1;
    public int mTaskStatus = 0;
    public String mTitle = "";

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BTSubTaskInfo)) {
            return false;
        }
        return this.mTaskId == ((BTSubTaskInfo) obj).mTaskId;
    }

    public int hashCode() {
        return (int) (this.mTaskId ^ (this.mTaskId >>> 32));
    }
}
