package com.xunlei.downloadprovider.download.engine.task.info;

import java.io.Serializable;

public class TaskExtraInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public String mCID = "";
    public String mCreateOrigin = "";
    public String mDisplayName = "";
    public String mGCID = "";
    public String mIconUrl = "";
    public String mInfoHash = "";
    public long mMaxDownloadSpeed = 0;
    public String mRefUrl = "";
    public int mSeen = 0;
    public String mSniffKeyword = "";
    public long mTaskId = -1;
    public String mUrl = "";
    public String mWebsiteName = "";

    public TaskExtraInfo deepCopyFrom(Object obj) {
        if (!(this == obj || obj == null)) {
            if (obj instanceof TaskExtraInfo) {
                TaskExtraInfo taskExtraInfo = (TaskExtraInfo) obj;
                this.mTaskId = taskExtraInfo.mTaskId;
                this.mUrl = taskExtraInfo.mUrl;
                this.mRefUrl = taskExtraInfo.mRefUrl;
                this.mCID = taskExtraInfo.mCID;
                this.mGCID = taskExtraInfo.mGCID;
                this.mInfoHash = taskExtraInfo.mInfoHash;
                this.mCreateOrigin = taskExtraInfo.mCreateOrigin;
                this.mSeen = taskExtraInfo.mSeen;
                this.mMaxDownloadSpeed = taskExtraInfo.mMaxDownloadSpeed;
                this.mSniffKeyword = taskExtraInfo.mSniffKeyword;
                this.mWebsiteName = taskExtraInfo.mWebsiteName;
                this.mIconUrl = taskExtraInfo.mIconUrl;
                this.mDisplayName = taskExtraInfo.mDisplayName;
                return this;
            }
        }
        return this;
    }
}
