package com.xunlei.downloadprovider.download.downloadvod;

import android.os.Bundle;
import java.io.Serializable;

public class DownloadVodInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public int mBtSubIndex = -1;
    public String mCID;
    public long mFileSize = 0;
    public String mGCID;
    public boolean mIsLocalPlay = false;
    public String mPlayUrl;
    public String mSourceUrl;
    public long mTaskId = -1;

    public static DownloadVodInfo createDownloadVodInfo(String str, long j, int i, String str2, String str3) {
        DownloadVodInfo downloadVodInfo = new DownloadVodInfo();
        downloadVodInfo.mPlayUrl = str;
        downloadVodInfo.mTaskId = j;
        downloadVodInfo.mGCID = str3;
        downloadVodInfo.mCID = str2;
        downloadVodInfo.mBtSubIndex = i;
        return downloadVodInfo;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DownloadVodInfo{mSourceUrl='");
        stringBuilder.append(this.mSourceUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", mPlayUrl='");
        stringBuilder.append(this.mPlayUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", mTaskId=");
        stringBuilder.append(this.mTaskId);
        stringBuilder.append(", mBtSubIndex=");
        stringBuilder.append(this.mBtSubIndex);
        stringBuilder.append(", mCID='");
        stringBuilder.append(this.mCID);
        stringBuilder.append('\'');
        stringBuilder.append(", mGCID='");
        stringBuilder.append(this.mGCID);
        stringBuilder.append('\'');
        stringBuilder.append(", mFileSize=");
        stringBuilder.append(this.mFileSize);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public Bundle toBundle() {
        return toBundle(new Bundle(9));
    }

    Bundle toBundle(Bundle bundle) {
        bundle.putString("DownloadVodInfo_SourceUrl", this.mSourceUrl);
        bundle.putString("DownloadVodInfo_PlayUrl", this.mPlayUrl);
        bundle.putString("DownloadVodInfo_CID", this.mCID);
        bundle.putString("DownloadVodInfo_GCID", this.mGCID);
        bundle.putLong("DownloadVodInfo_TaskId", this.mTaskId);
        bundle.putLong("DownloadVodInfo_BtSubIndex", (long) this.mBtSubIndex);
        bundle.putLong("DownloadVodInfo_FileSize", this.mFileSize);
        bundle.putBoolean("DownloadVodInfo_IsLocalPlay", this.mIsLocalPlay);
        return bundle;
    }
}
