package com.xunlei.downloadprovider.download.engine.task.info;

import java.io.Serializable;

public class DownloadInfo implements Serializable {
    private static final long serialVersionUID = 0;
    public String mCID;
    public String mCookie;
    public String mCreateOrigin;
    public long mCustomFlags = 0;
    public String mDownloadPath;
    public String mDownloadUrl;
    private DownloadAdditionInfo mExtra;
    public String mFileName;
    public long mFileSize;
    public String mGCID;
    public String mRefUrl;
    public boolean mTaskInvisible = false;

    public DownloadAdditionInfo getExtra() {
        if (this.mExtra == null) {
            this.mExtra = new DownloadAdditionInfo();
        }
        return this.mExtra;
    }

    public DownloadAdditionInfo setExtra(DownloadAdditionInfo downloadAdditionInfo) {
        this.mExtra = downloadAdditionInfo;
        return this.mExtra;
    }

    public DownloadInfo(String str, String str2, String str3, String str4) {
        this.mFileName = str2;
        this.mDownloadUrl = str;
        this.mRefUrl = str3;
        this.mCreateOrigin = str4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DownloadInfo{mFileName='");
        stringBuilder.append(this.mFileName);
        stringBuilder.append('\'');
        stringBuilder.append(", mDownloadUrl='");
        stringBuilder.append(this.mDownloadUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", mRefUrl='");
        stringBuilder.append(this.mRefUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", mCID='");
        stringBuilder.append(this.mCID);
        stringBuilder.append('\'');
        stringBuilder.append(", mGCID='");
        stringBuilder.append(this.mGCID);
        stringBuilder.append('\'');
        stringBuilder.append(", mFileSize=");
        stringBuilder.append(this.mFileSize);
        stringBuilder.append(", mCreateOrigin='");
        stringBuilder.append(this.mCreateOrigin);
        stringBuilder.append('\'');
        stringBuilder.append(", mDownloadPath='");
        stringBuilder.append(this.mDownloadPath);
        stringBuilder.append('\'');
        stringBuilder.append(", mExtra=");
        stringBuilder.append(this.mExtra);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
